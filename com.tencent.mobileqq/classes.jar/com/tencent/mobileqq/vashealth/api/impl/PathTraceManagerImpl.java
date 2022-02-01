package com.tencent.mobileqq.vashealth.api.impl;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Location;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.pluginsdk.PluginInterface;
import com.tencent.mobileqq.pluginsdk.PluginInterfaceHelper;
import com.tencent.mobileqq.pluginsdk.PluginInterfaceHelper.OnPluginInterfaceLoadedListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.download.api.IDownloaderFactory;
import com.tencent.mobileqq.vashealth.PathTraceService;
import com.tencent.mobileqq.vashealth.TracePathData;
import com.tencent.mobileqq.vashealth.TracePointsData;
import com.tencent.mobileqq.vashealth.api.IPathTraceManager;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.swift.WebViewProvider;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PathTraceManagerImpl
  implements IPathTraceManager
{
  public static final String BASE_URL = "https://imgcache.qq.com/ac/vasapp/webviewlib/2513/run_sd/audio715.zip";
  public static int LAST_DISTANCE = -2;
  public static int LAST_TIME = -1;
  public static final int MSG_TYPE_CALL_JS = 1;
  public static final int SUCCESS = 1;
  public static final String TAG = "PathTraceManager";
  public static final int TIME_TOO_LONG = -6;
  private static int mVoiceIndex = 0;
  public static MediaPlayer mediaPalyer;
  private static int sAccuracy = 50;
  private static int sIntervalDistance = 30;
  private static int sIntervalDistanceMax = 100;
  boolean debug = false;
  private String internalSavePath = null;
  AppRuntime mApp;
  DownloaderInterface mDownloaderInterface;
  EntityManager mEntityManager;
  public boolean mIgnoreSpeed = false;
  public long mIntervalTime;
  public boolean mIsMute = false;
  private TracePointsData mLastPoint;
  private int mLastSteps;
  public ArrayList<TracePointsData> mOriginnalPoints = new ArrayList();
  private TracePathData mPathTrace;
  private PathTraceManagerImpl.PathTraceLocation mPathTraceLocation;
  WeakReference<WebViewPlugin> mPathTracePlug;
  private PluginInterface mPluginInterface = null;
  private PluginInterfaceHelper.OnPluginInterfaceLoadedListener mPluginInterfaceLoadedListener;
  public boolean mSpeedRule = false;
  private int mStepGoal;
  SensorManager mStepManager;
  Sensor mStepSensor;
  SensorEventListener mSteplistener;
  private int mSteps;
  private boolean mToolong = true;
  private int mType;
  Handler mUIHandler = new PathTraceManagerImpl.9(this, Looper.getMainLooper());
  public long mUploadTime;
  boolean mVoiceAllFiles = true;
  private int mWorkingMode;
  private List<TracePointsData> tempPointList = new ArrayList(4);
  
  private void drawPathTrace(List<TracePointsData> paramList)
  {
    JSONObject localJSONObject1 = new JSONObject();
    int i = 0;
    try
    {
      localJSONObject1.put("retCode", 0);
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("distance", this.mPathTrace.distance);
      localJSONObject2.put("totalTime", this.mPathTrace.totalTime);
      localJSONObject2.put("totalSteps", this.mPathTrace.totalSteps);
      JSONArray localJSONArray = new JSONArray();
      if (paramList != null) {
        while (i < paramList.size())
        {
          localJSONArray.put(((TracePointsData)paramList.get(i)).toJson());
          i += 1;
        }
      }
      localJSONObject2.put("tracePath", localJSONArray);
      localJSONObject1.put("data", localJSONObject2.toString());
      if (this.mPathTracePlug == null) {
        break label188;
      }
      paramList = (WebViewPlugin)this.mPathTracePlug.get();
      if (paramList == null) {
        break label188;
      }
      paramList.dispatchJsEvent("PathTraceSend", localJSONObject1, new JSONObject());
      return;
    }
    catch (Exception paramList)
    {
      label180:
      label188:
      break label180;
    }
    QLog.d("PathTraceManager", 1, "draw Err");
  }
  
  private JSONObject drawPoint(TracePointsData paramTracePointsData)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramTracePointsData == null) {
      return localJSONObject;
    }
    try
    {
      localJSONObject.put("retCode", 1);
      localJSONObject.put("data", paramTracePointsData.toJson().toString());
      localJSONObject.put("isBeforeRunning", "true");
      if (this.mPathTracePlug != null)
      {
        paramTracePointsData = (WebViewPlugin)this.mPathTracePlug.get();
        if (paramTracePointsData != null) {
          paramTracePointsData.dispatchJsEvent("PathTraceSend", localJSONObject, new JSONObject());
        }
      }
      return localJSONObject;
    }
    catch (Exception paramTracePointsData) {}
    return localJSONObject;
  }
  
  /* Error */
  public static byte[] gzip(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 269	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: aload_0
    //   5: arraylength
    //   6: invokespecial 270	java/io/ByteArrayOutputStream:<init>	(I)V
    //   9: astore_2
    //   10: aload_2
    //   11: astore_1
    //   12: new 272	java/util/zip/GZIPOutputStream
    //   15: dup
    //   16: aload_2
    //   17: invokespecial 275	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   20: astore_3
    //   21: aload_2
    //   22: astore_1
    //   23: aload_3
    //   24: aload_0
    //   25: invokevirtual 279	java/util/zip/GZIPOutputStream:write	([B)V
    //   28: aload_2
    //   29: astore_1
    //   30: aload_3
    //   31: invokevirtual 282	java/util/zip/GZIPOutputStream:finish	()V
    //   34: aload_2
    //   35: astore_1
    //   36: aload_3
    //   37: invokevirtual 285	java/util/zip/GZIPOutputStream:flush	()V
    //   40: aload_2
    //   41: astore_1
    //   42: aload_3
    //   43: invokevirtual 288	java/util/zip/GZIPOutputStream:close	()V
    //   46: aload_2
    //   47: invokevirtual 292	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   50: areturn
    //   51: astore_1
    //   52: aload_2
    //   53: astore_0
    //   54: aload_1
    //   55: astore_2
    //   56: goto +11 -> 67
    //   59: aconst_null
    //   60: astore_1
    //   61: goto +30 -> 91
    //   64: astore_2
    //   65: aconst_null
    //   66: astore_0
    //   67: aload_0
    //   68: astore_1
    //   69: ldc 21
    //   71: iconst_1
    //   72: aload_2
    //   73: iconst_0
    //   74: anewarray 4	java/lang/Object
    //   77: invokestatic 296	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   80: aload_0
    //   81: ifnull +8 -> 89
    //   84: aload_0
    //   85: invokevirtual 292	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   88: areturn
    //   89: aconst_null
    //   90: areturn
    //   91: aload_1
    //   92: ifnull +8 -> 100
    //   95: aload_1
    //   96: invokevirtual 292	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   99: areturn
    //   100: aconst_null
    //   101: areturn
    //   102: astore_0
    //   103: goto -44 -> 59
    //   106: astore_0
    //   107: goto -16 -> 91
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	110	0	paramArrayOfByte	byte[]
    //   11	31	1	localObject1	Object
    //   51	4	1	localThrowable1	Throwable
    //   60	36	1	arrayOfByte	byte[]
    //   9	47	2	localObject2	Object
    //   64	9	2	localThrowable2	Throwable
    //   20	23	3	localGZIPOutputStream	java.util.zip.GZIPOutputStream
    // Exception table:
    //   from	to	target	type
    //   12	21	51	java/lang/Throwable
    //   23	28	51	java/lang/Throwable
    //   30	34	51	java/lang/Throwable
    //   36	40	51	java/lang/Throwable
    //   42	46	51	java/lang/Throwable
    //   0	10	64	java/lang/Throwable
    //   0	10	102	finally
    //   12	21	106	finally
    //   23	28	106	finally
    //   30	34	106	finally
    //   36	40	106	finally
    //   42	46	106	finally
    //   69	80	106	finally
  }
  
  private void handleLocation(TracePointsData paramTracePointsData)
  {
    int i = this.mWorkingMode;
    Object localObject1;
    if (i <= 0)
    {
      drawPoint(paramTracePointsData);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("drawPoint: ");
      ((StringBuilder)localObject1).append(paramTracePointsData.toString());
      QLog.i("PathTraceManager", 1, ((StringBuilder)localObject1).toString());
      return;
    }
    Object localObject2;
    if (i == 1)
    {
      if (this.debug)
      {
        localObject1 = this.mLastPoint;
        if (localObject1 != null)
        {
          paramTracePointsData.latitude = (((TracePointsData)localObject1).latitude + (float)(Math.random() * 0.0003D));
          paramTracePointsData.longitude = (this.mLastPoint.longitude + (float)(Math.random() * 0.0003D));
        }
        paramTracePointsData.speed = 3.0F;
        paramTracePointsData.altitude = 8.800000000000001D;
        paramTracePointsData.accuracy = 41;
      }
      localObject1 = this.mPathTrace;
      i = 0;
      double d1;
      double d2;
      if (localObject1 == null)
      {
        QLog.e("PathTraceManager", 1, "dowhile Err");
      }
      else if ((Build.VERSION.SDK_INT >= 19) && (this.mStepSensor != null))
      {
        paramTracePointsData.steps = this.mPathTrace.totalSteps;
      }
      else
      {
        int j = (int)(this.mPathTrace.distance / 0.65D);
        localObject1 = new float[1];
        if (this.mLastPoint != null) {
          Location.distanceBetween(paramTracePointsData.latitude, paramTracePointsData.longitude, this.mLastPoint.latitude, this.mLastPoint.longitude, (float[])localObject1);
        }
        d1 = this.mPathTrace.distance;
        d2 = localObject1[0];
        Double.isNaN(d2);
        int k = (int)((d1 + d2) / 0.65D);
        if (this.debug) {
          paramTracePointsData.steps += (int)(Math.random() * 20.0D);
        } else {
          paramTracePointsData.steps = k;
        }
        if (this.mPathTrace.type == 1) {
          if ((j < this.mPathTrace.stepsGoal) && (this.mPathTrace.totalSteps >= this.mPathTrace.stepsGoal)) {
            stepVoiceBroadCast(this.mPathTrace, false, true);
          } else if (Math.floor(this.mPathTrace.totalSteps / 1000) - Math.floor(j / 1000) > 0.0D) {
            stepVoiceBroadCast(this.mPathTrace, false, false);
          }
        }
      }
      localObject1 = new StringBuilder("drawPathTrace: ");
      ((StringBuilder)localObject1).append(paramTracePointsData.toString());
      localObject2 = this.mPathTrace;
      Object localObject3;
      if (localObject2 == null)
      {
        QLog.e("PathTraceManager", 1, "DoWhile Err");
      }
      else
      {
        paramTracePointsData.startTime = ((TracePathData)localObject2).startTime;
        this.mPathTrace.endTime = NetConnInfoCenter.getServerTime();
        if ((this.mLastPoint == null) && (this.mIntervalTime != 0L))
        {
          localObject2 = this.mPathTrace;
          ((TracePathData)localObject2).totalTime = (((TracePathData)localObject2).totalTime + NetConnInfoCenter.getServerTime() - this.mIntervalTime);
        }
        else
        {
          localObject2 = this.mPathTrace;
          long l2 = ((TracePathData)localObject2).totalTime;
          long l1;
          if (this.mLastPoint == null) {
            l1 = 2L;
          } else {
            l1 = paramTracePointsData.time - this.mLastPoint.time;
          }
          ((TracePathData)localObject2).totalTime = (l2 + l1);
        }
        this.mIntervalTime = NetConnInfoCenter.getServerTime();
        this.mPathTrace.isStop = 2;
        localObject2 = new float[1];
        float f1;
        float f2;
        if (this.mLastPoint != null)
        {
          Location.distanceBetween(paramTracePointsData.latitude, paramTracePointsData.longitude, this.mLastPoint.latitude, this.mLastPoint.longitude, (float[])localObject2);
          ((StringBuilder)localObject1).append(",interval: ");
          ((StringBuilder)localObject1).append(localObject2[0]);
          if ((localObject2[0] > sIntervalDistance) && (localObject2[0] < sIntervalDistanceMax))
          {
            if (paramTracePointsData.accuracy >= sIntervalDistanceMax) {
              f1 = 0.2F;
            } else if (paramTracePointsData.accuracy <= sIntervalDistance) {
              f1 = 1.0F;
            } else {
              f1 = Float.valueOf(sIntervalDistanceMax - paramTracePointsData.accuracy).floatValue() / (sIntervalDistanceMax - sIntervalDistance);
            }
            f2 = paramTracePointsData.latitude;
            float f3 = this.mLastPoint.latitude;
            float f4 = 1.0F - f1;
            paramTracePointsData.latitude = (f2 * f1 + f3 * f4);
            paramTracePointsData.longitude = (paramTracePointsData.longitude * f1 + this.mLastPoint.longitude * f4);
            Location.distanceBetween(paramTracePointsData.latitude, paramTracePointsData.longitude, this.mLastPoint.latitude, this.mLastPoint.longitude, (float[])localObject2);
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append(",Mis distance:");
            ((StringBuilder)localObject3).append(localObject2[0]);
            ((StringBuilder)localObject3).append(",coefficient:");
            ((StringBuilder)localObject3).append(f1);
            ((StringBuilder)localObject1).append(((StringBuilder)localObject3).toString());
            this.mSpeedRule = false;
          }
          else
          {
            this.mSpeedRule = true;
          }
        }
        localObject3 = this.mLastPoint;
        if (localObject3 != null) {
          ((TracePointsData)localObject3).time = paramTracePointsData.time;
        }
        if (this.mPathTrace.distance < 10.0D)
        {
          localObject3 = this.mOriginnalPoints;
          if ((localObject3 != null) && (((ArrayList)localObject3).size() >= 5))
          {
            i = 0;
            f2 = 0.0F;
            f1 = 0.0F;
            while (i < this.mOriginnalPoints.size())
            {
              f2 += ((TracePointsData)this.mOriginnalPoints.get(i)).latitude;
              f1 += ((TracePointsData)this.mOriginnalPoints.get(i)).longitude;
              i += 1;
            }
            paramTracePointsData.latitude = (f2 / this.mOriginnalPoints.size());
            paramTracePointsData.longitude = (f1 / this.mOriginnalPoints.size());
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("mOriginnalPoints HAPPEND:");
            ((StringBuilder)localObject3).append(this.mOriginnalPoints.toString());
            QLog.d("PathTraceManager", 1, ((StringBuilder)localObject3).toString());
            this.mOriginnalPoints.clear();
            break label1246;
          }
        }
        if (paramTracePointsData.accuracy > sAccuracy)
        {
          ((StringBuilder)localObject1).append(",accuracy too low: ");
          ((StringBuilder)localObject1).append(paramTracePointsData.accuracy);
        }
        else if ((!this.mIgnoreSpeed) && ((paramTracePointsData.speed >= 0.005D) || (!this.mSpeedRule)))
        {
          if ((localObject2[0] > sIntervalDistanceMax) && (this.mToolong))
          {
            ((StringBuilder)localObject1).append(",distance too long: ");
            ((StringBuilder)localObject1).append(localObject2[0]);
            this.mToolong = false;
          }
          else if ((localObject2[0] < 0.5D) && (this.mLastPoint != null))
          {
            ((StringBuilder)localObject1).append(",distance too low: ");
            ((StringBuilder)localObject1).append(localObject2[0]);
          }
          else
          {
            label1246:
            d1 = this.mPathTrace.distance;
            localObject3 = this.mPathTrace;
            d2 = ((TracePathData)localObject3).distance;
            double d3 = localObject2[0];
            Double.isNaN(d3);
            ((TracePathData)localObject3).distance = (d2 + d3);
            if ((this.mPathTrace.type == 0) && (Math.floor(this.mPathTrace.distance / 1000.0D) - Math.floor(Double.valueOf(d1).doubleValue() / 1000.0D) > 0.0D)) {
              runVoiceBroadCast(this.mPathTrace, false, paramTracePointsData);
            }
            this.mLastPoint = paramTracePointsData;
            this.mToolong = true;
            this.mSpeedRule = true;
            this.mPathTrace.totalSteps = paramTracePointsData.steps;
            this.tempPointList.clear();
            this.tempPointList.add(paramTracePointsData);
            drawPathTrace(this.tempPointList);
            i = 1;
          }
        }
        else
        {
          ((StringBuilder)localObject1).append(",speed too low: ");
          ((StringBuilder)localObject1).append(paramTracePointsData.speed);
        }
      }
      localObject2 = new ArrayList(2);
      if (this.mPathTrace != null)
      {
        localObject3 = new TracePathData();
        ((TracePathData)localObject3).startTime = this.mPathTrace.startTime;
        ((TracePathData)localObject3).type = this.mPathTrace.type;
        ((TracePathData)localObject3).distance = this.mPathTrace.distance;
        ((TracePathData)localObject3).endTime = this.mPathTrace.endTime;
        ((TracePathData)localObject3).totalTime = this.mPathTrace.totalTime;
        ((TracePathData)localObject3).isStop = this.mPathTrace.isStop;
        ((TracePathData)localObject3).totalSteps = this.mPathTrace.totalSteps;
        ((TracePathData)localObject3).stepsGoal = this.mPathTrace.stepsGoal;
        ((List)localObject2).add(localObject3);
        ((StringBuilder)localObject1).append(",totalTime: ");
        ((StringBuilder)localObject1).append(this.mPathTrace.totalTime);
        ((StringBuilder)localObject1).append(",total distance: ");
        ((StringBuilder)localObject1).append(this.mPathTrace.distance);
      }
      if (i != 0)
      {
        ((List)localObject2).add(paramTracePointsData);
      }
      else
      {
        localObject3 = this.mPathTrace;
        if ((localObject3 != null) && (((TracePathData)localObject3).distance < 10.0D))
        {
          localObject3 = this.mOriginnalPoints;
          if (localObject3 != null) {
            ((ArrayList)localObject3).add(paramTracePointsData);
          }
        }
        paramTracePointsData = new JSONObject();
      }
    }
    try
    {
      paramTracePointsData.put("retCode", 1);
      if (this.mPathTrace == null) {
        break label1697;
      }
      drawPathTrace(null);
    }
    catch (Exception paramTracePointsData)
    {
      label1688:
      label1697:
      break label1688;
    }
    QLog.i("PathTraceManager", 1, "no singnal step");
    ThreadManager.getSubThreadHandler().post(new PathTraceManagerImpl.6(this, (List)localObject2));
    if ((this.mPathTrace != null) && (Build.VERSION.SDK_INT >= 25))
    {
      paramTracePointsData = new Intent();
      paramTracePointsData.setAction(PathTraceService.b);
      paramTracePointsData.putExtra(PathTraceService.c, this.mWorkingMode);
      paramTracePointsData.putExtra(PathTraceService.d, this.mPathTrace.totalTime);
      paramTracePointsData.putExtra(PathTraceService.e, this.mPathTrace.distance);
      this.mApp.getApp().getApplicationContext().sendBroadcast(paramTracePointsData);
    }
    paramTracePointsData = this.mPathTrace;
    if ((paramTracePointsData != null) && (paramTracePointsData.totalTime > 21600L)) {
      paramTracePointsData = new JSONObject();
    }
    try
    {
      paramTracePointsData.put("retCode", -6);
      if (this.mPathTracePlug == null) {
        break label1899;
      }
      localObject2 = (WebViewPlugin)this.mPathTracePlug.get();
      if (localObject2 == null) {
        break label1899;
      }
      ((WebViewPlugin)localObject2).dispatchJsEvent("PathTraceEnd", paramTracePointsData, new JSONObject());
      QLog.i("PathTraceManager", 1, "LONG END");
    }
    catch (Exception paramTracePointsData)
    {
      label1890:
      label1899:
      break label1890;
    }
    QLog.i("PathTraceManager", 1, "TooLong Err");
    pathTraceEnd(21600L);
    QLog.i("PathTraceManager", 1, ((StringBuilder)localObject1).toString());
    return;
    stopLocation(-1);
    stopPathTraceService();
    paramTracePointsData = new StringBuilder();
    paramTracePointsData.append("WorkMode Err :");
    paramTracePointsData.append(this.mWorkingMode);
    QLog.e("PathTraceManager", 1, paramTracePointsData.toString());
  }
  
  private void kmToVoice(ArrayList<String> paramArrayList, double paramDouble)
  {
    double d = Float.valueOf(1000.0F).floatValue();
    Double.isNaN(d);
    paramDouble /= d;
    if (getDecades(paramDouble) != null)
    {
      paramArrayList.add(getDecades(paramDouble));
      paramArrayList.add("100");
    }
    if (getTens(paramDouble) != null)
    {
      paramArrayList.add(getTens(paramDouble));
      paramArrayList.add("10");
    }
    if (getOnes(paramDouble) != null) {
      paramArrayList.add(getOnes(paramDouble));
    }
    paramArrayList.add("d");
    if (getZeroOnes(paramDouble) != null) {
      paramArrayList.add(getZeroOnes(paramDouble));
    }
    if (getZeroTwos(paramDouble) != null) {
      paramArrayList.add(getZeroTwos(paramDouble));
    }
    paramArrayList.add("km");
  }
  
  /* Error */
  public static void pathTraceConsectivePlay(ArrayList<Uri> paramArrayList)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore_2
    //   8: aload 4
    //   10: astore_1
    //   11: aload 5
    //   13: astore_3
    //   14: getstatic 615	com/tencent/mobileqq/vashealth/api/impl/PathTraceManagerImpl:mediaPalyer	Landroid/media/MediaPlayer;
    //   17: ifnull +43 -> 60
    //   20: aload 4
    //   22: astore_1
    //   23: aload 5
    //   25: astore_3
    //   26: getstatic 615	com/tencent/mobileqq/vashealth/api/impl/PathTraceManagerImpl:mediaPalyer	Landroid/media/MediaPlayer;
    //   29: invokevirtual 621	android/media/MediaPlayer:isPlaying	()Z
    //   32: ifeq +4 -> 36
    //   35: return
    //   36: aload 4
    //   38: astore_1
    //   39: aload 5
    //   41: astore_3
    //   42: getstatic 615	com/tencent/mobileqq/vashealth/api/impl/PathTraceManagerImpl:mediaPalyer	Landroid/media/MediaPlayer;
    //   45: ifnull +15 -> 60
    //   48: aload 4
    //   50: astore_1
    //   51: aload 5
    //   53: astore_3
    //   54: getstatic 615	com/tencent/mobileqq/vashealth/api/impl/PathTraceManagerImpl:mediaPalyer	Landroid/media/MediaPlayer;
    //   57: invokevirtual 624	android/media/MediaPlayer:release	()V
    //   60: aload 4
    //   62: astore_1
    //   63: aload 5
    //   65: astore_3
    //   66: iconst_0
    //   67: putstatic 160	com/tencent/mobileqq/vashealth/api/impl/PathTraceManagerImpl:mVoiceIndex	I
    //   70: aload 4
    //   72: astore_1
    //   73: aload 5
    //   75: astore_3
    //   76: aload_0
    //   77: getstatic 160	com/tencent/mobileqq/vashealth/api/impl/PathTraceManagerImpl:mVoiceIndex	I
    //   80: invokevirtual 443	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   83: checkcast 626	android/net/Uri
    //   86: astore 6
    //   88: aload 4
    //   90: astore_1
    //   91: aload 5
    //   93: astore_3
    //   94: aload 6
    //   96: invokevirtual 629	android/net/Uri:getScheme	()Ljava/lang/String;
    //   99: ldc_w 631
    //   102: invokevirtual 636	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   105: ifeq +76 -> 181
    //   108: aload 4
    //   110: astore_1
    //   111: aload 5
    //   113: astore_3
    //   114: new 638	com/tencent/qqlive/module/videoreport/dtreport/audio/playback/ReportMediaPlayer
    //   117: dup
    //   118: invokespecial 639	com/tencent/qqlive/module/videoreport/dtreport/audio/playback/ReportMediaPlayer:<init>	()V
    //   121: putstatic 615	com/tencent/mobileqq/vashealth/api/impl/PathTraceManagerImpl:mediaPalyer	Landroid/media/MediaPlayer;
    //   124: aload 4
    //   126: astore_1
    //   127: aload 5
    //   129: astore_3
    //   130: new 641	java/io/FileInputStream
    //   133: dup
    //   134: new 643	java/io/File
    //   137: dup
    //   138: aload 6
    //   140: invokevirtual 646	android/net/Uri:getPath	()Ljava/lang/String;
    //   143: invokespecial 647	java/io/File:<init>	(Ljava/lang/String;)V
    //   146: invokespecial 650	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   149: astore_2
    //   150: getstatic 615	com/tencent/mobileqq/vashealth/api/impl/PathTraceManagerImpl:mediaPalyer	Landroid/media/MediaPlayer;
    //   153: aload_2
    //   154: invokevirtual 654	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   157: invokevirtual 658	android/media/MediaPlayer:setDataSource	(Ljava/io/FileDescriptor;)V
    //   160: getstatic 615	com/tencent/mobileqq/vashealth/api/impl/PathTraceManagerImpl:mediaPalyer	Landroid/media/MediaPlayer;
    //   163: invokevirtual 661	android/media/MediaPlayer:prepare	()V
    //   166: goto +15 -> 181
    //   169: astore_0
    //   170: aload_2
    //   171: astore_1
    //   172: goto +112 -> 284
    //   175: astore_0
    //   176: aload_2
    //   177: astore_3
    //   178: goto +85 -> 263
    //   181: aload_2
    //   182: astore_1
    //   183: aload_2
    //   184: astore_3
    //   185: getstatic 615	com/tencent/mobileqq/vashealth/api/impl/PathTraceManagerImpl:mediaPalyer	Landroid/media/MediaPlayer;
    //   188: astore 4
    //   190: aload 4
    //   192: ifnonnull +18 -> 210
    //   195: aload_2
    //   196: ifnull +13 -> 209
    //   199: aload_2
    //   200: invokevirtual 662	java/io/FileInputStream:close	()V
    //   203: return
    //   204: astore_0
    //   205: aload_0
    //   206: invokevirtual 665	java/io/IOException:printStackTrace	()V
    //   209: return
    //   210: aload_2
    //   211: astore_1
    //   212: aload_2
    //   213: astore_3
    //   214: getstatic 615	com/tencent/mobileqq/vashealth/api/impl/PathTraceManagerImpl:mediaPalyer	Landroid/media/MediaPlayer;
    //   217: new 667	com/tencent/mobileqq/vashealth/api/impl/PathTraceManagerImpl$4
    //   220: dup
    //   221: aload_0
    //   222: invokespecial 669	com/tencent/mobileqq/vashealth/api/impl/PathTraceManagerImpl$4:<init>	(Ljava/util/ArrayList;)V
    //   225: invokevirtual 673	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   228: aload_2
    //   229: astore_1
    //   230: aload_2
    //   231: astore_3
    //   232: getstatic 615	com/tencent/mobileqq/vashealth/api/impl/PathTraceManagerImpl:mediaPalyer	Landroid/media/MediaPlayer;
    //   235: invokevirtual 676	android/media/MediaPlayer:start	()V
    //   238: aload_2
    //   239: astore_1
    //   240: aload_2
    //   241: astore_3
    //   242: getstatic 615	com/tencent/mobileqq/vashealth/api/impl/PathTraceManagerImpl:mediaPalyer	Landroid/media/MediaPlayer;
    //   245: iconst_0
    //   246: invokevirtual 680	android/media/MediaPlayer:setLooping	(Z)V
    //   249: aload_2
    //   250: ifnull +33 -> 283
    //   253: aload_2
    //   254: invokevirtual 662	java/io/FileInputStream:close	()V
    //   257: return
    //   258: astore_0
    //   259: goto +25 -> 284
    //   262: astore_0
    //   263: aload_3
    //   264: astore_1
    //   265: aload_0
    //   266: invokevirtual 681	java/lang/Exception:printStackTrace	()V
    //   269: aload_3
    //   270: ifnull +13 -> 283
    //   273: aload_3
    //   274: invokevirtual 662	java/io/FileInputStream:close	()V
    //   277: return
    //   278: astore_0
    //   279: aload_0
    //   280: invokevirtual 665	java/io/IOException:printStackTrace	()V
    //   283: return
    //   284: aload_1
    //   285: ifnull +15 -> 300
    //   288: aload_1
    //   289: invokevirtual 662	java/io/FileInputStream:close	()V
    //   292: goto +8 -> 300
    //   295: astore_1
    //   296: aload_1
    //   297: invokevirtual 665	java/io/IOException:printStackTrace	()V
    //   300: aload_0
    //   301: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	302	0	paramArrayList	ArrayList<Uri>
    //   10	279	1	localObject1	Object
    //   295	2	1	localIOException	java.io.IOException
    //   7	247	2	localFileInputStream	java.io.FileInputStream
    //   13	261	3	localObject2	Object
    //   1	190	4	localMediaPlayer	MediaPlayer
    //   4	124	5	localObject3	Object
    //   86	53	6	localUri	Uri
    // Exception table:
    //   from	to	target	type
    //   150	166	169	finally
    //   150	166	175	java/lang/Exception
    //   199	203	204	java/io/IOException
    //   14	20	258	finally
    //   26	35	258	finally
    //   42	48	258	finally
    //   54	60	258	finally
    //   66	70	258	finally
    //   76	88	258	finally
    //   94	108	258	finally
    //   114	124	258	finally
    //   130	150	258	finally
    //   185	190	258	finally
    //   214	228	258	finally
    //   232	238	258	finally
    //   242	249	258	finally
    //   265	269	258	finally
    //   14	20	262	java/lang/Exception
    //   26	35	262	java/lang/Exception
    //   42	48	262	java/lang/Exception
    //   54	60	262	java/lang/Exception
    //   66	70	262	java/lang/Exception
    //   76	88	262	java/lang/Exception
    //   94	108	262	java/lang/Exception
    //   114	124	262	java/lang/Exception
    //   130	150	262	java/lang/Exception
    //   185	190	262	java/lang/Exception
    //   214	228	262	java/lang/Exception
    //   232	238	262	java/lang/Exception
    //   242	249	262	java/lang/Exception
    //   253	257	278	java/io/IOException
    //   273	277	278	java/io/IOException
    //   288	292	295	java/io/IOException
  }
  
  /* Error */
  public void bulkUpdateEntitys(List<Entity> paramList)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +148 -> 149
    //   4: aload_1
    //   5: invokeinterface 208 1 0
    //   10: ifne +4 -> 14
    //   13: return
    //   14: aload_1
    //   15: invokeinterface 208 1 0
    //   20: iconst_1
    //   21: if_icmpne +19 -> 40
    //   24: aload_0
    //   25: aload_1
    //   26: iconst_0
    //   27: invokeinterface 212 2 0
    //   32: checkcast 685	com/tencent/mobileqq/persistence/Entity
    //   35: invokevirtual 689	com/tencent/mobileqq/vashealth/api/impl/PathTraceManagerImpl:updateEntity	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   38: pop
    //   39: return
    //   40: aload_0
    //   41: getfield 691	com/tencent/mobileqq/vashealth/api/impl/PathTraceManagerImpl:mEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   44: invokevirtual 697	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   47: astore_2
    //   48: aload_2
    //   49: invokevirtual 702	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   52: aload_1
    //   53: invokeinterface 706 1 0
    //   58: astore_1
    //   59: aload_1
    //   60: invokeinterface 711 1 0
    //   65: ifeq +20 -> 85
    //   68: aload_0
    //   69: aload_1
    //   70: invokeinterface 714 1 0
    //   75: checkcast 685	com/tencent/mobileqq/persistence/Entity
    //   78: invokevirtual 689	com/tencent/mobileqq/vashealth/api/impl/PathTraceManagerImpl:updateEntity	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   81: pop
    //   82: goto -23 -> 59
    //   85: aload_2
    //   86: invokevirtual 717	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   89: goto +49 -> 138
    //   92: astore_1
    //   93: goto +50 -> 143
    //   96: astore_1
    //   97: invokestatic 720	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   100: ifeq +38 -> 138
    //   103: new 300	java/lang/StringBuilder
    //   106: dup
    //   107: invokespecial 301	java/lang/StringBuilder:<init>	()V
    //   110: astore_3
    //   111: aload_3
    //   112: ldc_w 722
    //   115: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: pop
    //   119: aload_3
    //   120: aload_1
    //   121: invokevirtual 725	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   124: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: pop
    //   128: ldc 21
    //   130: iconst_2
    //   131: aload_3
    //   132: invokevirtual 309	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   135: invokestatic 255	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   138: aload_2
    //   139: invokevirtual 728	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   142: return
    //   143: aload_2
    //   144: invokevirtual 728	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   147: aload_1
    //   148: athrow
    //   149: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	150	0	this	PathTraceManagerImpl
    //   0	150	1	paramList	List<Entity>
    //   47	97	2	localEntityTransaction	com.tencent.mobileqq.persistence.EntityTransaction
    //   110	22	3	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   52	59	92	finally
    //   59	82	92	finally
    //   85	89	92	finally
    //   97	138	92	finally
    //   52	59	96	java/lang/Exception
    //   59	82	96	java/lang/Exception
    //   85	89	96	java/lang/Exception
  }
  
  public void downloadVoice(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.internalSavePath);
    ((StringBuilder)localObject).append("audio715.zip");
    String str = ((StringBuilder)localObject).toString();
    if (!FileUtils.fileExists(str))
    {
      localObject = new File(this.internalSavePath, "audio715.zip");
      this.mVoiceAllFiles = false;
    }
    else
    {
      localObject = null;
    }
    if (this.mVoiceAllFiles) {
      return;
    }
    localObject = new DownloadTask("https://imgcache.qq.com/ac/vasapp/webviewlib/2513/run_sd/audio715.zip", (File)localObject);
    ((DownloadTask)localObject).Q = false;
    ((DownloadTask)localObject).P = true;
    if (this.mDownloaderInterface == null) {
      this.mDownloaderInterface = ((IDownloaderFactory)QRoute.api(IDownloaderFactory.class)).getDownloader(1);
    }
    DownloaderInterface localDownloaderInterface = this.mDownloaderInterface;
    if (localDownloaderInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PathTraceManager", 2, "loaderInterface Null");
      }
      return;
    }
    localDownloaderInterface.startDownload((DownloadTask)localObject, new PathTraceManagerImpl.3(this, str, paramString), null);
  }
  
  public List<TracePointsData> getAllTracePointByStartTime(long paramLong)
  {
    long l = System.currentTimeMillis();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("SELECT * FROM TracePointsData WHERE startTime = ");
    ((StringBuilder)localObject).append(paramLong);
    localObject = ((StringBuilder)localObject).toString();
    localObject = this.mEntityManager.rawQuery(TracePointsData.class, (String)localObject, null);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getAllTracePointByStartTime  size: ");
    int i;
    if (localObject != null) {
      i = ((List)localObject).size();
    } else {
      i = 0;
    }
    localStringBuilder.append(i);
    localStringBuilder.append(", cost: ");
    localStringBuilder.append(System.currentTimeMillis() - l);
    QLog.i("PathTraceManager", 1, localStringBuilder.toString());
    return localObject;
  }
  
  String getDecades(double paramDouble)
  {
    if (paramDouble >= 100.0D) {
      return String.valueOf((int)(paramDouble % 1000.0D / 100.0D));
    }
    return null;
  }
  
  public int getEngineWorkingMode()
  {
    return this.mWorkingMode;
  }
  
  String getHours(long paramLong)
  {
    if (paramLong >= 3600L) {
      return String.valueOf((int)(paramLong / 3600L));
    }
    return null;
  }
  
  String getKilos(double paramDouble)
  {
    if (paramDouble >= 1000.0D) {
      return String.valueOf((int)(paramDouble % 10000.0D / 1000.0D));
    }
    return null;
  }
  
  public TracePathData getLastUnCompletedTrace()
  {
    Object localObject = this.mEntityManager;
    TracePathData localTracePathData = null;
    localObject = ((EntityManager)localObject).rawQuery(TracePathData.class, "SELECT * FROM TracePathData WHERE isStop <> 1 order by startTime desc limit 1 ", null);
    if (localObject != null) {
      localTracePathData = (TracePathData)((List)localObject).get(0);
    }
    return localTracePathData;
  }
  
  String getMinutes(long paramLong)
  {
    if (paramLong >= 60L) {
      return String.valueOf((int)(paramLong % 3600L / 60L));
    }
    return null;
  }
  
  String getOnes(double paramDouble)
  {
    if ((getTens(paramDouble) != null) && ((int)(paramDouble % 10.0D) == 0)) {
      return null;
    }
    return String.valueOf((int)(paramDouble % 10.0D));
  }
  
  public TracePathData getPathTrace()
  {
    return this.mPathTrace;
  }
  
  public TracePathData getPathTraceByTime(long paramLong)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("SELECT * FROM TracePathData WHERE startTime = ");
    ((StringBuilder)localObject1).append(paramLong);
    Object localObject2 = ((StringBuilder)localObject1).toString();
    EntityManager localEntityManager = this.mEntityManager;
    localObject1 = null;
    localObject2 = localEntityManager.rawQuery(TracePathData.class, (String)localObject2, null);
    if (localObject2 != null) {
      localObject1 = (TracePathData)((List)localObject2).get(0);
    }
    return localObject1;
  }
  
  public int getRunningStatus()
  {
    int j = this.mWorkingMode;
    int i = j;
    if (j <= 0)
    {
      this.mPathTrace = getLastUnCompletedTrace();
      if (this.mPathTrace != null) {
        return 2;
      }
      i = 0;
    }
    return i;
  }
  
  String getSeconds(long paramLong)
  {
    if (paramLong >= 0L) {
      return String.valueOf((int)(paramLong % 60L));
    }
    return null;
  }
  
  String getTenThousands(double paramDouble)
  {
    if (paramDouble >= 10000.0D) {
      return String.valueOf((int)(paramDouble % 100000.0D / 10000.0D));
    }
    return null;
  }
  
  String getTens(double paramDouble)
  {
    if (paramDouble >= 10.0D) {
      return String.valueOf((int)(paramDouble % 100.0D / 10.0D));
    }
    return null;
  }
  
  String getZeroOnes(double paramDouble)
  {
    return String.valueOf((int)(paramDouble * 10.0D % 10.0D));
  }
  
  String getZeroTwos(double paramDouble)
  {
    int i = (int)(paramDouble * 100.0D % 10.0D);
    if (i != 0) {
      return String.valueOf(i);
    }
    return null;
  }
  
  public boolean isRunning()
  {
    return this.mWorkingMode == 1;
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.mApp = paramAppRuntime;
    this.mEntityManager = this.mApp.getEntityManagerFactory().createEntityManager();
    this.mWorkingMode = -1;
    this.mPluginInterfaceLoadedListener = new PathTraceManagerImpl.1(this);
    PluginInterfaceHelper.getPluginInterface(this.mApp.getApp(), this.mPluginInterfaceLoadedListener);
    this.mPathTrace = getLastUnCompletedTrace();
    paramAppRuntime = new StringBuilder(this.mApp.getApp().getFilesDir().getPath());
    paramAppRuntime.append("/QQSportVoice/");
    this.internalSavePath = paramAppRuntime.toString();
    downloadVoice(null);
    this.mStepManager = ((SensorManager)this.mApp.getApp().getApplicationContext().getSystemService("sensor"));
    this.mStepSensor = this.mStepManager.getDefaultSensor(19);
    this.mSteplistener = new PathTraceManagerImpl.2(this);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("path:");
      paramAppRuntime = this.mPathTrace;
      if (paramAppRuntime == null) {
        paramAppRuntime = "null";
      }
      localStringBuilder.append(paramAppRuntime);
      QLog.i("PathTraceManager", 2, localStringBuilder.toString());
    }
  }
  
  public void onDestroy()
  {
    stopLocation(-1);
    stopPathTraceService();
    removeSportBar();
    AudioUtil.b();
    QLog.i("PathTraceManager", 1, "onDestroy");
  }
  
  public boolean pathTraceDelete(Long paramLong)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("DELETE FROM TracePathData WHERE startTime = ");
    ((StringBuilder)localObject).append(paramLong);
    localObject = ((StringBuilder)localObject).toString();
    this.mEntityManager.execSQL((String)localObject);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("DELETE FROM TracePointsData WHERE time IN (SELECT time FROM TracePointsData WHERE startTime =");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append(")");
    paramLong = ((StringBuilder)localObject).toString();
    boolean bool = this.mEntityManager.execSQL(paramLong);
    try
    {
      localObject = new JSONObject();
      if (bool) {
        ((JSONObject)localObject).put("retCode", 1);
      } else {
        ((JSONObject)localObject).put("retCode", -8);
      }
      paramLong = null;
      if (this.mPathTracePlug != null) {
        paramLong = (WebViewPlugin)this.mPathTracePlug.get();
      }
      if (paramLong == null) {
        break label162;
      }
      paramLong.dispatchJsEvent("PathTraceDelete", (JSONObject)localObject, new JSONObject());
      return bool;
    }
    catch (JSONException paramLong)
    {
      label153:
      break label153;
    }
    QLog.d("PathTraceManager", 1, "PathTraceDelete Err");
    label162:
    return bool;
  }
  
  public boolean pathTraceEnd(long paramLong)
  {
    stopLocation(-1);
    stopPathTraceService();
    removeSportBar();
    if (this.mPathTrace == null) {
      this.mPathTrace = getLastUnCompletedTrace();
    }
    if (this.mPathTrace != null) {
      this.mApp.getApplication().getSharedPreferences(this.mApp.getCurrentAccountUin(), 0).edit().remove(String.valueOf(this.mPathTrace.startTime)).commit();
    }
    if (this.mPathTrace == null)
    {
      QLog.e("PathTraceManager", 1, "pathTraceEnd Err");
      return false;
    }
    JSONObject localJSONObject = new JSONObject();
    Object localObject = this.mPathTracePlug;
    if (localObject != null) {
      localObject = (WebViewPlugin)((WeakReference)localObject).get();
    } else {
      localObject = null;
    }
    if ((this.mPathTrace.totalTime >= 60L) && (this.mPathTrace.distance >= 100.0D))
    {
      TracePathData localTracePathData = this.mPathTrace;
      localTracePathData.totalTime = paramLong;
      this.mUploadTime = paramLong;
      if (localTracePathData.type == 0) {
        runVoiceBroadCast(this.mPathTrace, true, null);
      } else if (this.mPathTrace.type == 1) {
        stepVoiceBroadCast(this.mPathTrace, true, false);
      }
      localTracePathData = this.mPathTrace;
      localTracePathData.isStop = 1;
      localTracePathData.endTime = NetConnInfoCenter.getServerTime();
      updateEntity(this.mPathTrace);
      try
      {
        localJSONObject.put("retCode", 1);
        if (localObject != null) {
          ((WebViewPlugin)localObject).dispatchJsEvent("PathTraceEnd", localJSONObject, new JSONObject());
        }
      }
      catch (JSONException localJSONException1)
      {
        localJSONException1.printStackTrace();
      }
      stepDetectEnd();
      return true;
    }
    try
    {
      localJSONObject.put("retCode", -5);
      if (localJSONException1 != null) {
        localJSONException1.dispatchJsEvent("PathTraceEnd", localJSONObject, new JSONObject());
      }
      pathTraceDelete(Long.valueOf(this.mPathTrace.startTime));
      return false;
    }
    catch (JSONException localJSONException2)
    {
      localJSONException2.printStackTrace();
    }
    return false;
  }
  
  public void pathTracePause()
  {
    Object localObject = new ArrayList();
    ((ArrayList)localObject).add("pause");
    pathTraceVoicePlay((ArrayList)localObject);
    localObject = this.mLastPoint;
    boolean bool = false;
    if (localObject != null) {
      this.mApp.getApplication().getSharedPreferences(this.mApp.getCurrentAccountUin(), 0).edit().putFloat("search_lbs_logitude", this.mLastPoint.longitude).putFloat("search_lbs_latitude", this.mLastPoint.latitude).putLong("search_lbs_timestamp", System.currentTimeMillis()).apply();
    }
    this.mLastPoint = null;
    stopLocation(2);
    stopPathTraceService();
    localObject = this.mPathTrace;
    if (localObject != null)
    {
      if (this.mIntervalTime != 0L) {
        ((TracePathData)localObject).totalTime = (((TracePathData)localObject).totalTime + NetConnInfoCenter.getServerTime() - this.mIntervalTime);
      }
      localObject = this.mPathTrace;
      ((TracePathData)localObject).isStop = 3;
      updateEntity((Entity)localObject);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("pathTracePause:");
    if (this.mPathTrace == null) {
      bool = true;
    }
    ((StringBuilder)localObject).append(bool);
    QLog.i("PathTraceManager", 1, ((StringBuilder)localObject).toString());
  }
  
  public JSONObject pathTraceQuery()
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    Object localObject = this.mEntityManager.query(TracePathData.class);
    try
    {
      localJSONObject1.put("retCode", 1);
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          TracePathData localTracePathData = (TracePathData)((Iterator)localObject).next();
          JSONObject localJSONObject2 = new JSONObject();
          localJSONObject2.put("startTime", localTracePathData.startTime);
          localJSONObject2.put("endTime", localTracePathData.endTime);
          localJSONObject2.put("totalTime", localTracePathData.totalTime);
          localJSONObject2.put("totalSteps", localTracePathData.totalSteps);
          localJSONObject2.put("distance", localTracePathData.distance);
          localJSONObject2.put("type", localTracePathData.type);
          localJSONArray.put(localJSONObject2);
        }
        localJSONObject1.put("data", localJSONArray);
        return localJSONObject1;
      }
      localJSONObject1.put("retCode", 1);
      localJSONObject1.put("data", localJSONArray);
      return localJSONObject1;
    }
    catch (JSONException localJSONException)
    {
      label202:
      break label202;
    }
    QLog.d("PathTraceManager", 1, "PathTraceQuery Err");
    return localJSONObject1;
  }
  
  public void pathTraceResume()
  {
    if (this.mPathTrace == null) {
      this.mPathTrace = getLastUnCompletedTrace();
    }
    this.mIntervalTime = NetConnInfoCenter.getServerTime();
    stepDetectStart();
    if (this.mPathTrace != null)
    {
      startLocation(1);
      startPathTraceService();
    }
    else
    {
      QLog.e("PathTraceManager", 1, "pathTraceResume Err");
    }
    this.mLastSteps = 0;
  }
  
  public void pathTraceUpload(long paramLong, String paramString)
  {
    ThreadManager.executeOnNetWorkThread(new PathTraceManagerImpl.DataUploadTask(this, paramLong, paramString));
  }
  
  public void pathTraceVoicePlay(ArrayList<String> paramArrayList)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("internalSavePath:");
    ((StringBuilder)localObject).append(this.internalSavePath);
    QLog.d("PathTraceManager", 1, ((StringBuilder)localObject).toString());
    if (!this.mIsMute)
    {
      int i = 0;
      int j = 1;
      while (i < paramArrayList.size())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.internalSavePath);
        ((StringBuilder)localObject).append((String)paramArrayList.get(i));
        ((StringBuilder)localObject).append(".mp3");
        if (!FileUtils.fileExists(((StringBuilder)localObject).toString()))
        {
          if (paramArrayList.size() == 1) {
            downloadVoice((String)paramArrayList.get(0));
          } else {
            downloadVoice(null);
          }
          j = 0;
        }
        i += 1;
      }
      if (j != 0)
      {
        if (paramArrayList.size() == 1)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(this.internalSavePath);
          ((StringBuilder)localObject).append((String)paramArrayList.get(0));
          ((StringBuilder)localObject).append(".mp3");
          AudioUtil.a(Uri.fromFile(new File(((StringBuilder)localObject).toString())), false, true);
          return;
        }
        localObject = new ArrayList();
        i = 0;
        while (i < paramArrayList.size())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(this.internalSavePath);
          localStringBuilder.append((String)paramArrayList.get(i));
          localStringBuilder.append(".mp3");
          ((ArrayList)localObject).add(Uri.fromFile(new File(localStringBuilder.toString())));
          i += 1;
        }
        ThreadManager.post(new PathTraceManagerImpl.5(this, (ArrayList)localObject), 5, null, false);
      }
    }
    else
    {
      QLog.d("PathTraceManager", 1, "play mute");
    }
  }
  
  public JSONObject queryPathData(String paramString)
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    if (paramString != null) {}
    try
    {
      paramString = getPathTraceByTime(Long.parseLong(new JSONObject(paramString).getString("startTime")));
      break label52;
      paramString = getLastUnCompletedTrace();
      label52:
      if (paramString == null) {
        break label344;
      }
      long l = paramString.startTime;
      localJSONObject1.put("startTime", paramString.startTime);
      localJSONObject1.put("endTime", paramString.endTime);
      localJSONObject1.put("totalTime", paramString.totalTime);
      localJSONObject1.put("distance", paramString.distance);
      localJSONObject1.put("type", paramString.type);
      localJSONObject1.put("totalSteps", paramString.totalSteps);
      localJSONObject1.put("stepsGoal", paramString.stepsGoal);
      paramString = getAllTracePointByStartTime(Long.parseLong(String.valueOf(l)));
      if ((paramString != null) && (paramString.size() > 0))
      {
        paramString = paramString.iterator();
        while (paramString.hasNext())
        {
          TracePointsData localTracePointsData = (TracePointsData)paramString.next();
          JSONObject localJSONObject2 = new JSONObject();
          localJSONObject2.put("time", localTracePointsData.time);
          localJSONObject2.put("longitude", localTracePointsData.longitude);
          localJSONObject2.put("latitude", localTracePointsData.latitude);
          localJSONObject2.put("altitude", localTracePointsData.altitude);
          localJSONObject2.put("speed", localTracePointsData.speed);
          localJSONObject2.put("accuracy", localTracePointsData.accuracy);
          localJSONObject2.put("steps", localTracePointsData.steps);
          localJSONArray.put(localJSONObject2);
        }
      }
      localJSONObject1.put("data", localJSONArray);
      return localJSONObject1;
    }
    catch (Exception paramString)
    {
      label335:
      break label335;
    }
    QLog.d("PathTraceManager", 1, "queryPathData Err");
    label344:
    return localJSONObject1;
  }
  
  public void registerWebViewPlug(WebViewPlugin paramWebViewPlugin)
  {
    this.mPathTracePlug = new WeakReference(paramWebViewPlugin);
  }
  
  public void removeSportBar()
  {
    ThreadManagerV2.executeOnSubThread(new PathTraceManagerImpl.8(this));
    QLog.i("PathTraceManager", 1, "removeSportBar");
  }
  
  protected void runVoiceBroadCast(TracePathData paramTracePathData, boolean paramBoolean, TracePointsData paramTracePointsData)
  {
    ArrayList localArrayList = new ArrayList();
    double d1 = paramTracePathData.distance;
    if (paramBoolean) {
      localArrayList.add("end");
    }
    if (!paramBoolean)
    {
      d1 = Math.floor(d1 / 1000.0D);
      localArrayList.add("yyd");
      if (getDecades(d1) != null)
      {
        localArrayList.add(getDecades(d1));
        localArrayList.add("100");
      }
      if ((getTens(d1) != null) && (Integer.parseInt(getTens(d1)) != 0))
      {
        localArrayList.add(getTens(d1));
        localArrayList.add("10");
      }
      if (getOnes(d1) != null) {
        localArrayList.add(getOnes(d1));
      }
      localArrayList.add("km");
    }
    else
    {
      localArrayList.add("yyd");
      kmToVoice(localArrayList, d1);
    }
    long l1 = paramTracePathData.totalTime;
    localArrayList.add("ys");
    timeToVoice(localArrayList, l1);
    if (!paramBoolean)
    {
      Object localObject2 = this.mApp.getApplication().getSharedPreferences(this.mApp.getCurrentAccountUin(), 0);
      Object localObject1 = this.mApp.getApplication().getSharedPreferences(String.valueOf(paramTracePathData.startTime), 0);
      SharedPreferences.Editor localEditor = ((SharedPreferences)localObject2).edit();
      localObject1 = ((SharedPreferences)localObject1).edit();
      if ((int)(paramTracePathData.distance / 1000.0D) == 1)
      {
        localArrayList.add("zjps");
        timeToVoice(localArrayList, l1);
        localEditor.putLong(String.valueOf(paramTracePathData.startTime), paramTracePathData.totalTime);
        if (paramTracePointsData != null)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(String.valueOf(l1));
          ((StringBuilder)localObject2).append(",");
          ((StringBuilder)localObject2).append(String.valueOf(paramTracePointsData.latitude));
          ((StringBuilder)localObject2).append(",");
          ((StringBuilder)localObject2).append(String.valueOf(paramTracePointsData.longitude));
          ((SharedPreferences.Editor)localObject1).putString("1", ((StringBuilder)localObject2).toString());
        }
        else
        {
          paramTracePointsData = new StringBuilder();
          paramTracePointsData.append(String.valueOf(l1));
          paramTracePointsData.append(",0,0");
          ((SharedPreferences.Editor)localObject1).putString("1", paramTracePointsData.toString());
        }
        ((SharedPreferences.Editor)localObject1).putLong(String.valueOf(LAST_TIME), paramTracePathData.totalTime).putFloat(String.valueOf(LAST_DISTANCE), (float)paramTracePathData.distance);
      }
      else
      {
        long l2 = ((SharedPreferences)localObject2).getLong(String.valueOf(paramTracePathData.startTime), 0L);
        if (l2 != 0L)
        {
          long l3 = paramTracePathData.totalTime;
          localArrayList.add("zjps");
          timeToVoice(localArrayList, paramTracePathData.totalTime - l2);
          if (paramTracePointsData != null)
          {
            i = (int)(paramTracePathData.distance / 1000.0D);
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(String.valueOf(paramTracePathData.totalTime - l2));
            ((StringBuilder)localObject2).append(",");
            ((StringBuilder)localObject2).append(String.valueOf(paramTracePointsData.latitude));
            ((StringBuilder)localObject2).append(",");
            ((StringBuilder)localObject2).append(String.valueOf(paramTracePointsData.longitude));
            ((SharedPreferences.Editor)localObject1).putString(String.valueOf(i), ((StringBuilder)localObject2).toString());
          }
          ((SharedPreferences.Editor)localObject1).putLong(String.valueOf(LAST_TIME), paramTracePathData.totalTime).putFloat(String.valueOf(LAST_DISTANCE), Float.valueOf(String.valueOf(paramTracePathData.distance)).floatValue());
          localEditor.putLong(String.valueOf(paramTracePathData.startTime), paramTracePathData.totalTime);
        }
      }
      localEditor.commit();
      ((SharedPreferences.Editor)localObject1).commit();
    }
    localArrayList.add("pjps");
    if (!paramBoolean)
    {
      d1 = paramTracePathData.distance;
      d2 = Float.valueOf(1000.0F).floatValue();
      Double.isNaN(d2);
      if ((int)(d1 / d2) == 1)
      {
        d1 = l1;
        break label810;
      }
    }
    d1 = l1;
    double d2 = paramTracePathData.distance;
    double d3 = Float.valueOf(1000.0F).floatValue();
    Double.isNaN(d3);
    d2 /= d3;
    Double.isNaN(d1);
    d1 /= d2;
    label810:
    timeToVoice(localArrayList, d1);
    if (!paramBoolean)
    {
      localArrayList.add("jxjy");
      pathTraceVoicePlay(localArrayList);
    }
    if (paramBoolean)
    {
      localArrayList.add("jsy");
      pathTraceVoicePlay(localArrayList);
    }
    int i = 0;
    while (i < localArrayList.size())
    {
      paramTracePathData = new StringBuilder();
      paramTracePathData.append("psvoice:");
      paramTracePathData.append((String)localArrayList.get(i));
      QLog.d("PathTraceManager", 1, paramTracePathData.toString());
      i += 1;
    }
  }
  
  public void setIgnoreSpeed(boolean paramBoolean)
  {
    this.mIgnoreSpeed = paramBoolean;
  }
  
  public void setIsMute(boolean paramBoolean)
  {
    this.mIsMute = paramBoolean;
  }
  
  public void showSportBar(int paramInt, String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject;
      if (Uri.parse(paramString).getQuery() != null)
      {
        localObject = paramString;
        if (Uri.parse(paramString).getQueryParameter("ADTAG") == null)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramString);
          ((StringBuilder)localObject).append("&ADTAG=aio.run.click&from=bar");
          localObject = ((StringBuilder)localObject).toString();
        }
      }
      else
      {
        localObject = paramString;
        if (Uri.parse(paramString).getQueryParameter("ADTAG") == null)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramString);
          ((StringBuilder)localObject).append("?ADTAG=aio.run.click&from=bar");
          localObject = ((StringBuilder)localObject).toString();
        }
      }
      if (!((String)localObject).contains("runningState"))
      {
        if (Uri.parse((String)localObject).getQuery() != null)
        {
          paramString = new StringBuilder();
          paramString.append((String)localObject);
          paramString.append("&runningState=");
          paramString.append(paramInt);
          paramString = paramString.toString();
        }
        else
        {
          paramString = new StringBuilder();
          paramString.append((String)localObject);
          paramString.append("?runningState=");
          paramString.append(paramInt);
          paramString = paramString.toString();
        }
      }
      else
      {
        paramString = Uri.parse((String)localObject).getQueryParameter("runningState");
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("runningState=");
        localStringBuilder.append(paramString);
        paramString = localStringBuilder.toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("runningState=");
        localStringBuilder.append(paramInt);
        paramString = ((String)localObject).replace(paramString, localStringBuilder.toString());
      }
      ThreadManagerV2.executeOnSubThread(new PathTraceManagerImpl.7(this, paramInt, paramString));
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("showSportBar url：");
        ((StringBuilder)localObject).append(paramString);
        QLog.i("PathTraceManager", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public void startLocation(int paramInt)
  {
    if (this.mPathTraceLocation == null) {
      this.mPathTraceLocation = new PathTraceManagerImpl.PathTraceLocation(this, (AppInterface)this.mApp);
    }
    this.mWorkingMode = paramInt;
    ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).startLocation(this.mPathTraceLocation);
    if (this.mWorkingMode == 1)
    {
      localObject = this.mPathTracePlug;
      if ((localObject != null) && (((WeakReference)localObject).get() != null))
      {
        localObject = (WebViewPlugin)this.mPathTracePlug.get();
        if ((localObject != null) && (((WebViewPlugin)localObject).mRuntime != null))
        {
          if (((WebViewPlugin)localObject).mRuntime.f() != null) {
            localObject = ((WebViewPlugin)localObject).mRuntime.f().getCurrentUrl();
          } else {
            localObject = null;
          }
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            showSportBar(this.mWorkingMode, (String)localObject);
          }
        }
      }
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("startMode: ");
    ((StringBuilder)localObject).append(this.mWorkingMode);
    QLog.i("PathTraceManager", 1, ((StringBuilder)localObject).toString());
  }
  
  public void startPathTrace(JSONObject paramJSONObject)
  {
    QLog.i("PathTraceManager", 1, "startPathTrace");
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("start");
    pathTraceVoicePlay(localArrayList);
    this.mType = paramJSONObject.optInt("type");
    sAccuracy = paramJSONObject.optInt("accuracy");
    this.mStepGoal = paramJSONObject.optInt("stepGoal");
    if (sAccuracy == 0) {
      sAccuracy = 50;
    }
    try
    {
      paramJSONObject = new TracePathData();
      paramJSONObject.startTime = NetConnInfoCenter.getServerTime();
      paramJSONObject.endTime = NetConnInfoCenter.getServerTime();
      paramJSONObject.type = this.mType;
      paramJSONObject.stepsGoal = this.mStepGoal;
      this.mIntervalTime = paramJSONObject.startTime;
      this.mPathTrace = paramJSONObject;
      boolean bool = updateEntity(this.mPathTrace);
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("createTime: ");
      paramJSONObject.append(this.mPathTrace.startTime);
      paramJSONObject.append(", ret: ");
      paramJSONObject.append(bool);
      QLog.i("PathTraceManager", 1, paramJSONObject.toString());
    }
    catch (Exception paramJSONObject)
    {
      QLog.e("PathTraceManager", 1, paramJSONObject.getMessage());
    }
    startLocation(1);
    startPathTraceService();
    this.mLastSteps = 0;
    stepDetectStart();
  }
  
  public void startPathTraceService()
  {
    Context localContext = this.mApp.getApplicationContext();
    Intent localIntent = new Intent(localContext, PathTraceService.class);
    try
    {
      localContext.startService(localIntent);
      return;
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PathTraceManager", 2, "", localThrowable);
      }
    }
  }
  
  public void stepDetectEnd()
  {
    SensorManager localSensorManager = this.mStepManager;
    if (localSensorManager != null)
    {
      SensorEventListener localSensorEventListener = this.mSteplistener;
      if (localSensorEventListener != null) {
        localSensorManager.unregisterListener(localSensorEventListener);
      }
    }
  }
  
  @TargetApi(19)
  public void stepDetectStart()
  {
    Sensor localSensor;
    if (Build.VERSION.SDK_INT >= 19)
    {
      localSensor = this.mStepSensor;
      if (localSensor == null) {}
    }
    try
    {
      this.mStepManager.registerListener(this.mSteplistener, localSensor, 3, 0);
      this.mStepManager.flush(this.mSteplistener);
      return;
    }
    catch (Exception localException)
    {
      label45:
      break label45;
    }
    QLog.d("PathTraceManager", 1, "detector API err");
    return;
    QLog.d("PathTraceManager", 1, "Step Unsupported");
  }
  
  void stepToVoice(ArrayList<String> paramArrayList, long paramLong)
  {
    double d = paramLong;
    if (getTenThousands(d) != null)
    {
      if ((int)(paramLong % 100000L / 10000L) == 2) {
        paramArrayList.add("2_liang");
      } else {
        paramArrayList.add(getTenThousands(d));
      }
      paramArrayList.add("10000");
    }
    if ((getKilos(d) != null) && (Integer.parseInt(getKilos(d)) != 0))
    {
      if ((paramLong < 10000L) && ((int)(paramLong % 10000L / 1000L) == 2)) {
        paramArrayList.add("2_liang");
      } else {
        paramArrayList.add(getKilos(d));
      }
      paramArrayList.add("1000");
    }
    else if ((getKilos(d) != null) && (Integer.parseInt(getKilos(d)) == 0) && (((getDecades(d) != null) && (Integer.parseInt(getDecades(d)) != 0)) || ((getTens(d) != null) && (Integer.parseInt(getTens(d)) != 0)) || ((getOnes(d) != null) && (Integer.parseInt(getOnes(d)) != 0))))
    {
      paramArrayList.add("0");
      i = 1;
      break label234;
    }
    int i = 0;
    label234:
    int j;
    if ((getDecades(d) != null) && (Integer.parseInt(getDecades(d)) != 0))
    {
      paramArrayList.add(getDecades(d));
      paramArrayList.add("100");
      j = 0;
    }
    else
    {
      j = i;
      if (getDecades(d) != null)
      {
        j = i;
        if (Integer.parseInt(getDecades(d)) == 0)
        {
          j = i;
          if (i == 0) {
            if ((getTens(d) == null) || (Integer.parseInt(getTens(d)) == 0))
            {
              j = i;
              if (getOnes(d) != null)
              {
                j = i;
                if (Integer.parseInt(getOnes(d)) == 0) {}
              }
            }
            else
            {
              paramArrayList.add("0");
              j = 1;
            }
          }
        }
      }
    }
    if ((getTens(d) != null) && (Integer.parseInt(getTens(d)) != 0))
    {
      paramArrayList.add(getTens(d));
      paramArrayList.add("10");
    }
    else if ((getTens(d) != null) && (Integer.parseInt(getTens(d)) == 0) && (j == 0) && (getOnes(d) != null) && (Integer.parseInt(getOnes(d)) != 0))
    {
      paramArrayList.add("0");
    }
    if ((getOnes(d) != null) && (Integer.parseInt(getOnes(d)) != 0)) {
      paramArrayList.add(getOnes(d));
    }
    paramArrayList.add("step");
  }
  
  protected void stepVoiceBroadCast(TracePathData paramTracePathData, boolean paramBoolean1, boolean paramBoolean2)
  {
    ArrayList localArrayList = new ArrayList();
    int i = paramTracePathData.totalSteps;
    if (paramBoolean1) {
      localArrayList.add("end");
    }
    if (!paramBoolean1)
    {
      localArrayList.add("yyd");
      if (paramBoolean2)
      {
        stepToVoice(localArrayList, paramTracePathData.stepsGoal);
      }
      else
      {
        double d = i;
        if ((getTenThousands(d) != null) && (Integer.parseInt(getTenThousands(d)) != 0))
        {
          if (i % 100000 / 10000 == 2) {
            localArrayList.add("2_liang");
          } else {
            localArrayList.add(getTenThousands(d));
          }
          localArrayList.add("10000");
        }
        if ((getKilos(d) != null) && (Integer.parseInt(getKilos(d)) != 0))
        {
          if ((i < 10000) && (i % 10000 / 1000 == 2)) {
            localArrayList.add("2_liang");
          } else {
            localArrayList.add(getKilos(d));
          }
          localArrayList.add("1000");
        }
        localArrayList.add("step");
      }
      localArrayList.add("ys");
      timeToVoice(localArrayList, paramTracePathData.totalTime);
      if (paramTracePathData.stepsGoal == 0)
      {
        localArrayList.add("jxjy");
        pathTraceVoicePlay(localArrayList);
        return;
      }
      if (paramTracePathData.totalSteps < paramTracePathData.stepsGoal)
      {
        localArrayList.add("hy");
        stepToVoice(localArrayList, paramTracePathData.stepsGoal - paramTracePathData.totalSteps / 1000 * 1000);
        localArrayList.add("goal_0");
        localArrayList.add("jxjy");
        pathTraceVoicePlay(localArrayList);
        return;
      }
      if (paramBoolean2)
      {
        localArrayList.add("goal_1");
        pathTraceVoicePlay(localArrayList);
        return;
      }
      localArrayList.add("jxjy");
      pathTraceVoicePlay(localArrayList);
      return;
    }
    localArrayList.add("bcyd");
    stepToVoice(localArrayList, paramTracePathData.totalSteps);
    localArrayList.add("empty_0_5s");
    kmToVoice(localArrayList, paramTracePathData.distance);
    localArrayList.add("ys");
    timeToVoice(localArrayList, paramTracePathData.totalTime);
    if (paramTracePathData.totalSteps < 10000) {
      localArrayList.add("jsy");
    } else {
      localArrayList.add("guli_1");
    }
    pathTraceVoicePlay(localArrayList);
  }
  
  public void stopLocation(int paramInt)
  {
    if (this.mPathTraceLocation != null)
    {
      ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).removeOnLocationListener(this.mPathTraceLocation);
      this.mWorkingMode = paramInt;
      if (this.mWorkingMode == 2)
      {
        localObject = this.mPathTracePlug;
        if ((localObject != null) && (((WeakReference)localObject).get() != null))
        {
          localObject = (WebViewPlugin)this.mPathTracePlug.get();
          if ((localObject != null) && (((WebViewPlugin)localObject).mRuntime != null))
          {
            if (((WebViewPlugin)localObject).mRuntime.f() != null) {
              localObject = ((WebViewPlugin)localObject).mRuntime.f().getCurrentUrl();
            } else {
              localObject = null;
            }
            if (!TextUtils.isEmpty((CharSequence)localObject)) {
              showSportBar(this.mWorkingMode, (String)localObject);
            }
          }
        }
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("stopMode:");
      ((StringBuilder)localObject).append(this.mWorkingMode);
      QLog.i("PathTraceManager", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  public void stopPathTraceService()
  {
    Intent localIntent = new Intent(this.mApp.getApplicationContext(), PathTraceService.class);
    try
    {
      this.mApp.getApplicationContext().stopService(localIntent);
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PathTraceManager", 2, "", localThrowable);
      }
    }
    QLog.i("PathTraceManager", 1, "stopPathTraceService");
  }
  
  void timeToVoice(ArrayList<String> paramArrayList, long paramLong)
  {
    double d;
    if (getHours(paramLong) != null)
    {
      d = paramLong / 3600L;
      if (getDecades(d) != null)
      {
        paramArrayList.add(getDecades(d));
        paramArrayList.add("100");
      }
      if (getTens(d) != null)
      {
        paramArrayList.add(getTens(d));
        paramArrayList.add("10");
      }
      if (getOnes(d) != null) {
        paramArrayList.add(getOnes(d));
      }
      paramArrayList.add("hour");
    }
    if (getMinutes(paramLong) != null)
    {
      d = paramLong % 3600L / 60L;
      if (getDecades(d) != null)
      {
        paramArrayList.add(getDecades(d));
        paramArrayList.add("100");
      }
      if (getTens(d) != null)
      {
        paramArrayList.add(getTens(d));
        paramArrayList.add("10");
      }
      if (getOnes(d) != null) {
        paramArrayList.add(getOnes(d));
      }
      paramArrayList.add("min");
    }
    if (getSeconds(paramLong) != null)
    {
      paramLong %= 60L;
      d = paramLong;
      if (getDecades(d) != null)
      {
        paramArrayList.add(getDecades(d));
        paramArrayList.add("100");
      }
      if (paramLong >= 10L)
      {
        if (getTens(d) != null)
        {
          paramArrayList.add(getTens(d));
          paramArrayList.add("10");
        }
        if (getOnes(d) != null) {
          paramArrayList.add(getOnes(d));
        }
        paramArrayList.add("sec");
        return;
      }
      if (paramLong > 0L)
      {
        paramArrayList.add("0");
        if (getOnes(d) != null) {
          paramArrayList.add(getOnes(d));
        }
        paramArrayList.add("sec");
        return;
      }
      if (paramLong == 0L)
      {
        paramArrayList.add("0");
        paramArrayList.add("sec");
      }
    }
  }
  
  public boolean updateEntity(Entity paramEntity)
  {
    EntityManager localEntityManager = this.mEntityManager;
    boolean bool = false;
    if ((localEntityManager != null) && (localEntityManager.isOpen()))
    {
      if (paramEntity.getStatus() == 1000)
      {
        this.mEntityManager.persistOrReplace(paramEntity);
        if (paramEntity.getStatus() == 1001) {
          bool = true;
        }
        return bool;
      }
      if ((paramEntity.getStatus() == 1001) || (paramEntity.getStatus() == 1002)) {
        return this.mEntityManager.update(paramEntity);
      }
    }
    QLog.e("PathTraceManager", 1, "updateEntity Err");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.api.impl.PathTraceManagerImpl
 * JD-Core Version:    0.7.0.1
 */