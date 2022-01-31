package com.tencent.mobileqq.vashealth;

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
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import apvb;
import aukm;
import aukn;
import auko;
import bbbr;
import bbts;
import bbty;
import bbtz;
import bbua;
import bbuc;
import bbue;
import bbwg;
import bbwi;
import bbwl;
import bcdb;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pluginsdk.PluginInterface;
import com.tencent.mobileqq.pluginsdk.PluginInterfaceHelper;
import com.tencent.mobileqq.pluginsdk.PluginInterfaceHelper.OnPluginInterfaceLoadedListener;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PathTraceManager
  implements Manager
{
  public static int a;
  public static MediaPlayer a;
  public static int b;
  private static int jdField_f_of_type_Int;
  private static int i = 50;
  private static int j = 100;
  private static int k = 30;
  public long a;
  Sensor jdField_a_of_type_AndroidHardwareSensor;
  SensorEventListener jdField_a_of_type_AndroidHardwareSensorEventListener;
  SensorManager jdField_a_of_type_AndroidHardwareSensorManager;
  public Handler a;
  aukn jdField_a_of_type_Aukn;
  private bbue jdField_a_of_type_Bbue;
  bbwi jdField_a_of_type_Bbwi;
  bbwl jdField_a_of_type_Bbwl;
  BrowserAppInterface jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface;
  private PluginInterface jdField_a_of_type_ComTencentMobileqqPluginsdkPluginInterface;
  private PluginInterfaceHelper.OnPluginInterfaceLoadedListener jdField_a_of_type_ComTencentMobileqqPluginsdkPluginInterfaceHelper$OnPluginInterfaceLoadedListener;
  private TracePathData jdField_a_of_type_ComTencentMobileqqVashealthTracePathData;
  private TracePointsData jdField_a_of_type_ComTencentMobileqqVashealthTracePointsData;
  private String jdField_a_of_type_JavaLangString;
  public WeakReference<bbts> a;
  public ArrayList<TracePointsData> a;
  private List<TracePointsData> jdField_a_of_type_JavaUtilList = new ArrayList(4);
  public boolean a;
  public long b;
  public boolean b;
  private int jdField_c_of_type_Int;
  boolean jdField_c_of_type_Boolean = true;
  private int d;
  public boolean d;
  private int e;
  public boolean e;
  private boolean jdField_f_of_type_Boolean = true;
  private int g;
  private int h;
  
  static
  {
    jdField_a_of_type_Int = -1;
    jdField_b_of_type_Int = -2;
  }
  
  public PathTraceManager(BrowserAppInterface paramBrowserAppInterface)
  {
    this.jdField_e_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidOsHandler = new bbuc(this, Looper.getMainLooper());
    this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface = paramBrowserAppInterface;
    this.jdField_a_of_type_Aukn = this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface.getEntityManagerFactory().createEntityManager();
    this.jdField_c_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentMobileqqPluginsdkPluginInterfaceHelper$OnPluginInterfaceLoadedListener = new bbty(this);
    PluginInterfaceHelper.getPluginInterface(this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqPluginsdkPluginInterfaceHelper$OnPluginInterfaceLoadedListener);
    this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData = b();
    paramBrowserAppInterface = new StringBuilder(this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface.getApp().getFilesDir().getPath());
    paramBrowserAppInterface.append("/QQSportVoice/");
    this.jdField_a_of_type_JavaLangString = paramBrowserAppInterface.toString();
    a(null);
    this.jdField_a_of_type_AndroidHardwareSensorManager = ((SensorManager)this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface.getApp().getApplicationContext().getSystemService("sensor"));
    this.jdField_a_of_type_AndroidHardwareSensor = this.jdField_a_of_type_AndroidHardwareSensorManager.getDefaultSensor(19);
    this.jdField_a_of_type_AndroidHardwareSensorEventListener = new bbtz(this);
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("path:");
      if (this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData == null) {
        break label249;
      }
    }
    label249:
    for (paramBrowserAppInterface = this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData;; paramBrowserAppInterface = "null")
    {
      QLog.i("PathTraceManager", 2, paramBrowserAppInterface);
      return;
    }
  }
  
  private JSONObject a(TracePointsData paramTracePointsData)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("retCode", 1);
      localJSONObject.put("data", paramTracePointsData.toJson().toString());
      localJSONObject.put("isBeforeRunning", "true");
      if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
      {
        paramTracePointsData = (bbts)this.jdField_a_of_type_JavaLangRefWeakReference.get();
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
  public static void a(ArrayList<Uri> paramArrayList)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 6
    //   6: aconst_null
    //   7: astore_3
    //   8: aload 5
    //   10: astore 4
    //   12: aload 6
    //   14: astore_2
    //   15: getstatic 269	com/tencent/mobileqq/vashealth/PathTraceManager:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   18: ifnull +66 -> 84
    //   21: aload 5
    //   23: astore 4
    //   25: aload 6
    //   27: astore_2
    //   28: getstatic 269	com/tencent/mobileqq/vashealth/PathTraceManager:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   31: invokevirtual 274	android/media/MediaPlayer:isPlaying	()Z
    //   34: istore_1
    //   35: iload_1
    //   36: ifeq +22 -> 58
    //   39: iconst_0
    //   40: ifeq +11 -> 51
    //   43: new 276	java/lang/NullPointerException
    //   46: dup
    //   47: invokespecial 277	java/lang/NullPointerException:<init>	()V
    //   50: athrow
    //   51: return
    //   52: astore_0
    //   53: aload_0
    //   54: invokevirtual 280	java/io/IOException:printStackTrace	()V
    //   57: return
    //   58: aload 5
    //   60: astore 4
    //   62: aload 6
    //   64: astore_2
    //   65: getstatic 269	com/tencent/mobileqq/vashealth/PathTraceManager:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   68: ifnull +16 -> 84
    //   71: aload 5
    //   73: astore 4
    //   75: aload 6
    //   77: astore_2
    //   78: getstatic 269	com/tencent/mobileqq/vashealth/PathTraceManager:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   81: invokevirtual 283	android/media/MediaPlayer:release	()V
    //   84: aload 5
    //   86: astore 4
    //   88: aload 6
    //   90: astore_2
    //   91: iconst_0
    //   92: putstatic 206	com/tencent/mobileqq/vashealth/PathTraceManager:jdField_f_of_type_Int	I
    //   95: aload 5
    //   97: astore 4
    //   99: aload 6
    //   101: astore_2
    //   102: aload_0
    //   103: getstatic 206	com/tencent/mobileqq/vashealth/PathTraceManager:jdField_f_of_type_Int	I
    //   106: invokevirtual 286	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   109: checkcast 288	android/net/Uri
    //   112: astore 7
    //   114: aload 5
    //   116: astore 4
    //   118: aload 6
    //   120: astore_2
    //   121: aload 7
    //   123: invokevirtual 291	android/net/Uri:getScheme	()Ljava/lang/String;
    //   126: ldc_w 293
    //   129: invokevirtual 299	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   132: ifeq +63 -> 195
    //   135: aload 5
    //   137: astore 4
    //   139: aload 6
    //   141: astore_2
    //   142: new 271	android/media/MediaPlayer
    //   145: dup
    //   146: invokespecial 300	android/media/MediaPlayer:<init>	()V
    //   149: putstatic 269	com/tencent/mobileqq/vashealth/PathTraceManager:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   152: aload 5
    //   154: astore 4
    //   156: aload 6
    //   158: astore_2
    //   159: new 302	java/io/FileInputStream
    //   162: dup
    //   163: new 137	java/io/File
    //   166: dup
    //   167: aload 7
    //   169: invokevirtual 303	android/net/Uri:getPath	()Ljava/lang/String;
    //   172: invokespecial 304	java/io/File:<init>	(Ljava/lang/String;)V
    //   175: invokespecial 307	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   178: astore_3
    //   179: getstatic 269	com/tencent/mobileqq/vashealth/PathTraceManager:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   182: aload_3
    //   183: invokevirtual 311	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   186: invokevirtual 315	android/media/MediaPlayer:setDataSource	(Ljava/io/FileDescriptor;)V
    //   189: getstatic 269	com/tencent/mobileqq/vashealth/PathTraceManager:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   192: invokevirtual 318	android/media/MediaPlayer:prepare	()V
    //   195: aload_3
    //   196: astore 4
    //   198: aload_3
    //   199: astore_2
    //   200: getstatic 269	com/tencent/mobileqq/vashealth/PathTraceManager:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   203: astore 5
    //   205: aload 5
    //   207: ifnonnull +18 -> 225
    //   210: aload_3
    //   211: ifnull -160 -> 51
    //   214: aload_3
    //   215: invokevirtual 321	java/io/FileInputStream:close	()V
    //   218: return
    //   219: astore_0
    //   220: aload_0
    //   221: invokevirtual 280	java/io/IOException:printStackTrace	()V
    //   224: return
    //   225: aload_3
    //   226: astore 4
    //   228: aload_3
    //   229: astore_2
    //   230: getstatic 269	com/tencent/mobileqq/vashealth/PathTraceManager:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   233: new 323	bbub
    //   236: dup
    //   237: aload_0
    //   238: invokespecial 325	bbub:<init>	(Ljava/util/ArrayList;)V
    //   241: invokevirtual 329	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   244: aload_3
    //   245: astore 4
    //   247: aload_3
    //   248: astore_2
    //   249: getstatic 269	com/tencent/mobileqq/vashealth/PathTraceManager:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   252: invokevirtual 332	android/media/MediaPlayer:start	()V
    //   255: aload_3
    //   256: astore 4
    //   258: aload_3
    //   259: astore_2
    //   260: getstatic 269	com/tencent/mobileqq/vashealth/PathTraceManager:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   263: iconst_0
    //   264: invokevirtual 336	android/media/MediaPlayer:setLooping	(Z)V
    //   267: aload_3
    //   268: ifnull -217 -> 51
    //   271: aload_3
    //   272: invokevirtual 321	java/io/FileInputStream:close	()V
    //   275: return
    //   276: astore_0
    //   277: aload_0
    //   278: invokevirtual 280	java/io/IOException:printStackTrace	()V
    //   281: return
    //   282: astore_0
    //   283: aload 4
    //   285: astore_2
    //   286: aload_0
    //   287: invokevirtual 337	java/lang/Exception:printStackTrace	()V
    //   290: aload 4
    //   292: ifnull -241 -> 51
    //   295: aload 4
    //   297: invokevirtual 321	java/io/FileInputStream:close	()V
    //   300: return
    //   301: astore_0
    //   302: aload_0
    //   303: invokevirtual 280	java/io/IOException:printStackTrace	()V
    //   306: return
    //   307: astore_0
    //   308: aload_2
    //   309: ifnull +7 -> 316
    //   312: aload_2
    //   313: invokevirtual 321	java/io/FileInputStream:close	()V
    //   316: aload_0
    //   317: athrow
    //   318: astore_2
    //   319: aload_2
    //   320: invokevirtual 280	java/io/IOException:printStackTrace	()V
    //   323: goto -7 -> 316
    //   326: astore_0
    //   327: aload_3
    //   328: astore_2
    //   329: goto -21 -> 308
    //   332: astore_0
    //   333: aload_3
    //   334: astore 4
    //   336: goto -53 -> 283
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	339	0	paramArrayList	ArrayList<Uri>
    //   34	2	1	bool	boolean
    //   14	299	2	localObject1	Object
    //   318	2	2	localIOException	java.io.IOException
    //   328	1	2	localFileInputStream1	java.io.FileInputStream
    //   7	327	3	localFileInputStream2	java.io.FileInputStream
    //   10	325	4	localObject2	Object
    //   1	205	5	localMediaPlayer	MediaPlayer
    //   4	153	6	localObject3	Object
    //   112	56	7	localUri	Uri
    // Exception table:
    //   from	to	target	type
    //   43	51	52	java/io/IOException
    //   214	218	219	java/io/IOException
    //   271	275	276	java/io/IOException
    //   15	21	282	java/lang/Exception
    //   28	35	282	java/lang/Exception
    //   65	71	282	java/lang/Exception
    //   78	84	282	java/lang/Exception
    //   91	95	282	java/lang/Exception
    //   102	114	282	java/lang/Exception
    //   121	135	282	java/lang/Exception
    //   142	152	282	java/lang/Exception
    //   159	179	282	java/lang/Exception
    //   200	205	282	java/lang/Exception
    //   230	244	282	java/lang/Exception
    //   249	255	282	java/lang/Exception
    //   260	267	282	java/lang/Exception
    //   295	300	301	java/io/IOException
    //   15	21	307	finally
    //   28	35	307	finally
    //   65	71	307	finally
    //   78	84	307	finally
    //   91	95	307	finally
    //   102	114	307	finally
    //   121	135	307	finally
    //   142	152	307	finally
    //   159	179	307	finally
    //   200	205	307	finally
    //   230	244	307	finally
    //   249	255	307	finally
    //   260	267	307	finally
    //   286	290	307	finally
    //   312	316	318	java/io/IOException
    //   179	195	326	finally
    //   179	195	332	java/lang/Exception
  }
  
  private void a(ArrayList<String> paramArrayList, double paramDouble)
  {
    paramDouble /= Float.valueOf(1000.0F).floatValue();
    if (c(paramDouble) != null)
    {
      paramArrayList.add(c(paramDouble));
      paramArrayList.add("100");
    }
    if (d(paramDouble) != null)
    {
      paramArrayList.add(d(paramDouble));
      paramArrayList.add("10");
    }
    if (e(paramDouble) != null) {
      paramArrayList.add(e(paramDouble));
    }
    paramArrayList.add("d");
    if (f(paramDouble) != null) {
      paramArrayList.add(f(paramDouble));
    }
    if (g(paramDouble) != null) {
      paramArrayList.add(g(paramDouble));
    }
    paramArrayList.add("km");
  }
  
  /* Error */
  public static byte[] a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 378	java/io/ByteArrayOutputStream
    //   6: dup
    //   7: aload_0
    //   8: arraylength
    //   9: invokespecial 379	java/io/ByteArrayOutputStream:<init>	(I)V
    //   12: astore_2
    //   13: aload_2
    //   14: astore_1
    //   15: new 381	java/util/zip/GZIPOutputStream
    //   18: dup
    //   19: aload_2
    //   20: invokespecial 384	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   23: astore_3
    //   24: aload_2
    //   25: astore_1
    //   26: aload_3
    //   27: aload_0
    //   28: invokevirtual 388	java/util/zip/GZIPOutputStream:write	([B)V
    //   31: aload_2
    //   32: astore_1
    //   33: aload_3
    //   34: invokevirtual 391	java/util/zip/GZIPOutputStream:finish	()V
    //   37: aload_2
    //   38: astore_1
    //   39: aload_3
    //   40: invokevirtual 394	java/util/zip/GZIPOutputStream:flush	()V
    //   43: aload_2
    //   44: astore_1
    //   45: aload_3
    //   46: invokevirtual 395	java/util/zip/GZIPOutputStream:close	()V
    //   49: aload 4
    //   51: astore_1
    //   52: aload_2
    //   53: ifnull +8 -> 61
    //   56: aload_2
    //   57: invokevirtual 399	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   60: astore_1
    //   61: aload_1
    //   62: areturn
    //   63: astore_3
    //   64: aconst_null
    //   65: astore_0
    //   66: aload_0
    //   67: astore_1
    //   68: ldc 195
    //   70: iconst_1
    //   71: aload_3
    //   72: iconst_0
    //   73: anewarray 4	java/lang/Object
    //   76: invokestatic 402	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   79: aload 4
    //   81: astore_1
    //   82: aload_0
    //   83: ifnull -22 -> 61
    //   86: aload_0
    //   87: invokevirtual 399	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   90: areturn
    //   91: astore_0
    //   92: aconst_null
    //   93: astore_0
    //   94: aload 4
    //   96: astore_1
    //   97: aload_0
    //   98: ifnull -37 -> 61
    //   101: aload_0
    //   102: invokevirtual 399	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   105: areturn
    //   106: astore_0
    //   107: aload_1
    //   108: astore_0
    //   109: goto -15 -> 94
    //   112: astore_3
    //   113: aload_2
    //   114: astore_0
    //   115: goto -49 -> 66
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	118	0	paramArrayOfByte	byte[]
    //   14	94	1	localObject1	Object
    //   12	102	2	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   23	23	3	localGZIPOutputStream	java.util.zip.GZIPOutputStream
    //   63	9	3	localThrowable1	java.lang.Throwable
    //   112	1	3	localThrowable2	java.lang.Throwable
    //   1	94	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   3	13	63	java/lang/Throwable
    //   3	13	91	finally
    //   15	24	106	finally
    //   26	31	106	finally
    //   33	37	106	finally
    //   39	43	106	finally
    //   45	49	106	finally
    //   68	79	106	finally
    //   15	24	112	java/lang/Throwable
    //   26	31	112	java/lang/Throwable
    //   33	37	112	java/lang/Throwable
    //   39	43	112	java/lang/Throwable
    //   45	49	112	java/lang/Throwable
  }
  
  private void b(List<TracePointsData> paramList)
  {
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      localJSONObject1.put("retCode", 0);
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("distance", this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData.distance);
      localJSONObject2.put("totalTime", this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData.totalTime);
      localJSONObject2.put("totalSteps", this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData.totalSteps);
      JSONArray localJSONArray = new JSONArray();
      if (paramList != null)
      {
        int m = 0;
        while (m < paramList.size())
        {
          localJSONArray.put(((TracePointsData)paramList.get(m)).toJson());
          m += 1;
        }
      }
      localJSONObject2.put("tracePath", localJSONArray);
      localJSONObject1.put("data", localJSONObject2.toString());
      if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
      {
        paramList = (bbts)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (paramList != null) {
          paramList.dispatchJsEvent("PathTraceSend", localJSONObject1, new JSONObject());
        }
      }
      return;
    }
    catch (Exception paramList)
    {
      QLog.d("PathTraceManager", 1, "draw Err");
    }
  }
  
  public int a()
  {
    int m = 0;
    if (this.jdField_c_of_type_Int <= 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData = b();
      if (this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData != null) {
        m = 2;
      }
      return m;
    }
    return this.jdField_c_of_type_Int;
  }
  
  public TracePathData a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData;
  }
  
  public TracePathData a(long paramLong)
  {
    TracePathData localTracePathData = null;
    Object localObject = "SELECT * FROM TracePathData WHERE startTime = " + paramLong;
    localObject = this.jdField_a_of_type_Aukn.a(TracePathData.class, (String)localObject, null);
    if (localObject != null) {
      localTracePathData = (TracePathData)((List)localObject).get(0);
    }
    return localTracePathData;
  }
  
  String a(double paramDouble)
  {
    if (paramDouble >= 10000.0D) {
      return String.valueOf((int)(paramDouble % 100000.0D / 10000.0D));
    }
    return null;
  }
  
  String a(long paramLong)
  {
    if (paramLong >= 3600L) {
      return String.valueOf((int)(paramLong / 3600L));
    }
    return null;
  }
  
  public List<TracePointsData> a(long paramLong)
  {
    long l = System.currentTimeMillis();
    Object localObject = "SELECT * FROM TracePointsData WHERE startTime = " + paramLong;
    localObject = this.jdField_a_of_type_Aukn.a(TracePointsData.class, (String)localObject, null);
    StringBuilder localStringBuilder = new StringBuilder().append("getAllTracePointByStartTime  size: ");
    if (localObject != null) {}
    for (int m = ((List)localObject).size();; m = 0)
    {
      QLog.i("PathTraceManager", 1, m + ", cost: " + (System.currentTimeMillis() - l));
      return localObject;
    }
  }
  
  public JSONObject a()
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    Object localObject = this.jdField_a_of_type_Aukn.a(TracePathData.class);
    try
    {
      localJSONObject1.put("retCode", 1);
      if ((localObject == null) || (((List)localObject).size() <= 0)) {
        break label200;
      }
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
      localJSONObject1.put("data", localJSONException);
    }
    catch (JSONException localJSONException)
    {
      QLog.d("PathTraceManager", 1, "PathTraceQuery Err");
      return localJSONObject1;
    }
    return localJSONObject1;
    label200:
    localJSONObject1.put("retCode", 1);
    localJSONObject1.put("data", localJSONException);
    return localJSONObject1;
  }
  
  public JSONObject a(String paramString)
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    if (paramString != null) {}
    for (;;)
    {
      try
      {
        paramString = a(Long.parseLong(new JSONObject(paramString).getString("startTime")));
        if (paramString != null)
        {
          long l = paramString.startTime;
          localJSONObject1.put("startTime", paramString.startTime);
          localJSONObject1.put("endTime", paramString.endTime);
          localJSONObject1.put("totalTime", paramString.totalTime);
          localJSONObject1.put("distance", paramString.distance);
          localJSONObject1.put("type", paramString.type);
          localJSONObject1.put("totalSteps", paramString.totalSteps);
          localJSONObject1.put("stepsGoal", paramString.stepsGoal);
          paramString = a(Long.parseLong(String.valueOf(l)));
          if ((paramString == null) || (paramString.size() <= 0)) {
            break;
          }
          paramString = paramString.iterator();
          if (!paramString.hasNext()) {
            break;
          }
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
          continue;
        }
        return localJSONObject1;
      }
      catch (Exception paramString)
      {
        QLog.d("PathTraceManager", 1, "queryPathData Err");
      }
      paramString = b();
    }
    localJSONObject1.put("data", localJSONArray);
    return localJSONObject1;
  }
  
  @TargetApi(19)
  public void a()
  {
    if ((Build.VERSION.SDK_INT >= 19) && (this.jdField_a_of_type_AndroidHardwareSensor != null)) {
      try
      {
        this.jdField_a_of_type_AndroidHardwareSensorManager.registerListener(this.jdField_a_of_type_AndroidHardwareSensorEventListener, this.jdField_a_of_type_AndroidHardwareSensor, 3, 0);
        this.jdField_a_of_type_AndroidHardwareSensorManager.flush(this.jdField_a_of_type_AndroidHardwareSensorEventListener);
        return;
      }
      catch (Exception localException)
      {
        QLog.d("PathTraceManager", 1, "detector API err");
        return;
      }
    }
    QLog.d("PathTraceManager", 1, "Step Unsupported");
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Bbue == null) {
      this.jdField_a_of_type_Bbue = new bbue(this, this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface);
    }
    this.jdField_c_of_type_Int = paramInt;
    SosoInterface.a(this.jdField_a_of_type_Bbue);
    if ((this.jdField_c_of_type_Int == 1) && (this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
    {
      localObject = (bbts)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if ((localObject != null) && (((bbts)localObject).mRuntime != null)) {
        if (((bbts)localObject).mRuntime.a() == null) {
          break label149;
        }
      }
    }
    label149:
    for (Object localObject = ((bbts)localObject).mRuntime.a().h;; localObject = null)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        a(this.jdField_c_of_type_Int, (String)localObject);
      }
      QLog.i("PathTraceManager", 1, "startMode: " + this.jdField_c_of_type_Int);
      return;
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    Object localObject;
    if (!TextUtils.isEmpty(paramString))
    {
      if (Uri.parse(paramString).getQuery() == null) {
        break label169;
      }
      localObject = paramString;
      if (Uri.parse(paramString).getQueryParameter("ADTAG") == null) {
        localObject = paramString + "&ADTAG=aio.run.click&from=bar";
      }
      if (((String)localObject).contains("runningState")) {
        break label236;
      }
      if (Uri.parse((String)localObject).getQuery() == null) {
        break label208;
      }
      paramString = (String)localObject + "&runningState=" + paramInt;
    }
    for (;;)
    {
      localObject = new Bundle();
      ((Bundle)localObject).putInt("CommondType", 1);
      ((Bundle)localObject).putLong("runningState", paramInt);
      ((Bundle)localObject).putString("cookieUrl", paramString);
      a((Bundle)localObject);
      if (QLog.isColorLevel()) {
        QLog.i("PathTraceManager", 2, "showSportBar url：" + paramString);
      }
      return;
      label169:
      localObject = paramString;
      if (Uri.parse(paramString).getQueryParameter("ADTAG") != null) {
        break;
      }
      localObject = paramString + "?ADTAG=aio.run.click&from=bar";
      break;
      label208:
      paramString = (String)localObject + "?runningState=" + paramInt;
      continue;
      label236:
      paramString = Uri.parse((String)localObject).getQueryParameter("runningState");
      paramString = ((String)localObject).replace("runningState=" + paramString, "runningState=" + paramInt);
    }
  }
  
  public void a(long paramLong, String paramString)
  {
    ThreadManager.executeOnNetWorkThread(new PathTraceManager.DataUploadTask(this, paramLong, paramString));
  }
  
  public void a(Bundle paramBundle)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPluginsdkPluginInterface != null)
    {
      long l = System.currentTimeMillis();
      paramBundle.setClassLoader(getClass().getClassLoader());
      this.jdField_a_of_type_ComTencentMobileqqPluginsdkPluginInterface.transfer("running_plugin_cmd", paramBundle);
      QLog.i("PathTraceManager", 1, "postInvokeRemoteCmd cost: " + (System.currentTimeMillis() - l));
      return;
    }
    QLog.e("PathTraceManager", 1, "postInvokeRemoteCmd Err");
  }
  
  public void a(bbts parambbts)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambbts);
  }
  
  protected void a(TracePathData paramTracePathData, boolean paramBoolean, TracePointsData paramTracePointsData)
  {
    ArrayList localArrayList = new ArrayList();
    double d1 = paramTracePathData.distance;
    if (paramBoolean) {
      localArrayList.add("end");
    }
    long l1;
    SharedPreferences localSharedPreferences;
    Object localObject;
    SharedPreferences.Editor localEditor;
    if (!paramBoolean)
    {
      d1 = Math.floor(d1 / 1000.0D);
      localArrayList.add("yyd");
      if (c(d1) != null)
      {
        localArrayList.add(c(d1));
        localArrayList.add("100");
      }
      if ((d(d1) != null) && (Integer.parseInt(d(d1)) != 0))
      {
        localArrayList.add(d(d1));
        localArrayList.add("10");
      }
      if (e(d1) != null) {
        localArrayList.add(e(d1));
      }
      localArrayList.add("km");
      l1 = paramTracePathData.totalTime;
      localArrayList.add("ys");
      a(localArrayList, l1);
      if (!paramBoolean)
      {
        localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface.getCurrentAccountUin(), 0);
        localObject = BaseApplicationImpl.getApplication().getSharedPreferences(String.valueOf(paramTracePathData.startTime), 0);
        localEditor = localSharedPreferences.edit();
        localObject = ((SharedPreferences)localObject).edit();
        if ((int)(paramTracePathData.distance / 1000.0D) != 1) {
          break label597;
        }
        localArrayList.add("zjps");
        a(localArrayList, l1);
        localEditor.putLong(String.valueOf(paramTracePathData.startTime), paramTracePathData.totalTime);
        if (paramTracePointsData == null) {
          break label559;
        }
        ((SharedPreferences.Editor)localObject).putString("1", String.valueOf(l1) + "," + String.valueOf(paramTracePointsData.latitude) + "," + String.valueOf(paramTracePointsData.longitude));
        label347:
        ((SharedPreferences.Editor)localObject).putLong(String.valueOf(jdField_a_of_type_Int), paramTracePathData.totalTime).putFloat(String.valueOf(jdField_b_of_type_Int), (float)paramTracePathData.distance);
        label381:
        localEditor.commit();
        ((SharedPreferences.Editor)localObject).commit();
      }
      localArrayList.add("pjps");
      if ((paramBoolean) || ((int)(paramTracePathData.distance / Float.valueOf(1000.0F).floatValue()) != 1)) {
        break label792;
      }
    }
    label792:
    for (d1 = l1;; d1 = l1 / (paramTracePathData.distance / Float.valueOf(1000.0F).floatValue()))
    {
      a(localArrayList, d1);
      if (!paramBoolean)
      {
        localArrayList.add("jxjy");
        b(localArrayList);
      }
      if (paramBoolean)
      {
        localArrayList.add("jsy");
        b(localArrayList);
      }
      int m = 0;
      while (m < localArrayList.size())
      {
        QLog.d("PathTraceManager", 1, "psvoice:" + (String)localArrayList.get(m));
        m += 1;
      }
      localArrayList.add("yyd");
      a(localArrayList, d1);
      break;
      label559:
      ((SharedPreferences.Editor)localObject).putString("1", String.valueOf(l1) + ",0,0");
      break label347;
      label597:
      long l2 = localSharedPreferences.getLong(String.valueOf(paramTracePathData.startTime), 0L);
      if (l2 == 0L) {
        break label381;
      }
      long l3 = paramTracePathData.totalTime;
      localArrayList.add("zjps");
      a(localArrayList, paramTracePathData.totalTime - l2);
      if (paramTracePointsData != null) {
        ((SharedPreferences.Editor)localObject).putString(String.valueOf((int)(paramTracePathData.distance / 1000.0D)), String.valueOf(paramTracePathData.totalTime - l2) + "," + String.valueOf(paramTracePointsData.latitude) + "," + String.valueOf(paramTracePointsData.longitude));
      }
      ((SharedPreferences.Editor)localObject).putLong(String.valueOf(jdField_a_of_type_Int), paramTracePathData.totalTime).putFloat(String.valueOf(jdField_b_of_type_Int), Float.valueOf(String.valueOf(paramTracePathData.distance)).floatValue());
      localEditor.putLong(String.valueOf(paramTracePathData.startTime), paramTracePathData.totalTime);
      break label381;
    }
  }
  
  public void a(TracePathData paramTracePathData, boolean paramBoolean1, boolean paramBoolean2)
  {
    ArrayList localArrayList = new ArrayList();
    int m = paramTracePathData.totalSteps;
    if (paramBoolean1) {
      localArrayList.add("end");
    }
    if (!paramBoolean1)
    {
      localArrayList.add("yyd");
      if (paramBoolean2)
      {
        b(localArrayList, paramTracePathData.stepsGoal);
        localArrayList.add("ys");
        a(localArrayList, paramTracePathData.totalTime);
        if (paramTracePathData.stepsGoal == 0)
        {
          localArrayList.add("jxjy");
          b(localArrayList);
        }
      }
      else
      {
        if ((a(m) != null) && (Integer.parseInt(a(m)) != 0))
        {
          if (m % 100000 / 10000 == 2)
          {
            localArrayList.add("2_liang");
            label144:
            localArrayList.add("10000");
          }
        }
        else if ((b(m) != null) && (Integer.parseInt(b(m)) != 0))
        {
          if ((m >= 10000) || (m % 10000 / 1000 != 2)) {
            break label244;
          }
          localArrayList.add("2_liang");
        }
        for (;;)
        {
          localArrayList.add("1000");
          localArrayList.add("step");
          break;
          localArrayList.add(a(m));
          break label144;
          label244:
          localArrayList.add(b(m));
        }
      }
      if (paramTracePathData.totalSteps < paramTracePathData.stepsGoal)
      {
        localArrayList.add("hy");
        b(localArrayList, paramTracePathData.stepsGoal - paramTracePathData.totalSteps / 1000 * 1000);
        localArrayList.add("goal_0");
        localArrayList.add("jxjy");
        b(localArrayList);
        return;
      }
      if (paramBoolean2)
      {
        localArrayList.add("goal_1");
        b(localArrayList);
        return;
      }
      localArrayList.add("jxjy");
      b(localArrayList);
      return;
    }
    localArrayList.add("bcyd");
    b(localArrayList, paramTracePathData.totalSteps);
    localArrayList.add("empty_0_5s");
    a(localArrayList, paramTracePathData.distance);
    localArrayList.add("ys");
    a(localArrayList, paramTracePathData.totalTime);
    if (paramTracePathData.totalSteps < 10000) {
      localArrayList.add("jsy");
    }
    for (;;)
    {
      b(localArrayList);
      return;
      localArrayList.add("guli_1");
    }
  }
  
  public void a(TracePointsData paramTracePointsData)
  {
    if (this.jdField_c_of_type_Int <= 0)
    {
      a(paramTracePointsData);
      QLog.i("PathTraceManager", 1, "drawPoint: " + paramTracePointsData.toString());
      return;
    }
    if (this.jdField_c_of_type_Int == 1)
    {
      if (this.jdField_e_of_type_Boolean)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqVashealthTracePointsData != null)
        {
          paramTracePointsData.latitude = (this.jdField_a_of_type_ComTencentMobileqqVashealthTracePointsData.latitude + (float)(0.0003D * Math.random()));
          paramTracePointsData.longitude = (this.jdField_a_of_type_ComTencentMobileqqVashealthTracePointsData.longitude + (float)(0.0003D * Math.random()));
        }
        paramTracePointsData.speed = 3.0F;
        paramTracePointsData.altitude = 8.800000000000001D;
        paramTracePointsData.accuracy = 41;
      }
      Object localObject1;
      int m;
      label179:
      Object localObject2;
      TracePathData localTracePathData;
      if (this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData == null)
      {
        QLog.e("PathTraceManager", 1, "dowhile Err");
        localObject1 = new StringBuilder("drawPathTrace: ").append(paramTracePointsData.toString());
        if (this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData != null) {
          break label807;
        }
        QLog.e("PathTraceManager", 1, "DoWhile Err");
        m = 0;
        localObject2 = new ArrayList(2);
        if (this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData != null)
        {
          localTracePathData = new TracePathData();
          localTracePathData.startTime = this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData.startTime;
          localTracePathData.type = this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData.type;
          localTracePathData.distance = this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData.distance;
          localTracePathData.endTime = this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData.endTime;
          localTracePathData.totalTime = this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData.totalTime;
          localTracePathData.isStop = this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData.isStop;
          localTracePathData.totalSteps = this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData.totalSteps;
          localTracePathData.stepsGoal = this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData.stepsGoal;
          ((List)localObject2).add(localTracePathData);
          ((StringBuilder)localObject1).append(",totalTime: ").append(this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData.totalTime).append(",total distance: ").append(this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData.distance);
        }
        if (m == 0) {
          break label1712;
        }
        ((List)localObject2).add(paramTracePointsData);
      }
      for (;;)
      {
        ThreadManager.getSubThreadHandler().post(new PathTraceManager.6(this, (List)localObject2));
        if ((this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData != null) && (Build.VERSION.SDK_INT >= 25))
        {
          paramTracePointsData = new Intent();
          paramTracePointsData.setAction(PathTraceService.jdField_a_of_type_JavaLangString);
          paramTracePointsData.putExtra(PathTraceService.b, this.jdField_c_of_type_Int);
          paramTracePointsData.putExtra(PathTraceService.c, this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData.totalTime);
          paramTracePointsData.putExtra(PathTraceService.d, this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData.distance);
          this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface.getApp().getApplicationContext().sendBroadcast(paramTracePointsData);
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData != null) && (this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData.totalTime > 21600L)) {
          paramTracePointsData = new JSONObject();
        }
        try
        {
          paramTracePointsData.put("retCode", -6);
          if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
          {
            localObject2 = (bbts)this.jdField_a_of_type_JavaLangRefWeakReference.get();
            if (localObject2 != null)
            {
              ((bbts)localObject2).dispatchJsEvent("PathTraceEnd", paramTracePointsData, new JSONObject());
              QLog.i("PathTraceManager", 1, "LONG END");
            }
          }
        }
        catch (Exception paramTracePointsData)
        {
          for (;;)
          {
            int n;
            float f1;
            float f2;
            QLog.i("PathTraceManager", 1, "TooLong Err");
          }
        }
        a(21600L);
        QLog.i("PathTraceManager", 1, ((StringBuilder)localObject1).toString());
        return;
        if ((Build.VERSION.SDK_INT < 19) || (this.jdField_a_of_type_AndroidHardwareSensor == null))
        {
          m = (int)(this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData.distance / 0.65D);
          localObject1 = new float[1];
          if (this.jdField_a_of_type_ComTencentMobileqqVashealthTracePointsData != null) {
            Location.distanceBetween(paramTracePointsData.latitude, paramTracePointsData.longitude, this.jdField_a_of_type_ComTencentMobileqqVashealthTracePointsData.latitude, this.jdField_a_of_type_ComTencentMobileqqVashealthTracePointsData.longitude, (float[])localObject1);
          }
          n = (int)((this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData.distance + localObject1[0]) / 0.65D);
          if (this.jdField_e_of_type_Boolean) {}
          for (paramTracePointsData.steps += (int)(20.0D * Math.random());; paramTracePointsData.steps = n)
          {
            if (this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData.type != 1) {
              break label747;
            }
            if ((m >= this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData.stepsGoal) || (this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData.totalSteps < this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData.stepsGoal)) {
              break label749;
            }
            a(this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData, false, true);
            break;
          }
          label747:
          break;
          label749:
          if (Math.floor(this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData.totalSteps / 1000) - Math.floor(m / 1000) <= 0.0D) {
            break;
          }
          a(this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData, false, false);
          break;
        }
        paramTracePointsData.steps = this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData.totalSteps;
        break;
        label807:
        paramTracePointsData.startTime = this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData.startTime;
        this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData.endTime = NetConnInfoCenter.getServerTime();
        if ((this.jdField_a_of_type_ComTencentMobileqqVashealthTracePointsData == null) && (this.jdField_a_of_type_Long != 0L))
        {
          this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData.totalTime = (this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData.totalTime + NetConnInfoCenter.getServerTime() - this.jdField_a_of_type_Long);
          this.jdField_a_of_type_Long = NetConnInfoCenter.getServerTime();
          this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData.isStop = 2;
          localObject2 = new float[1];
          if (this.jdField_a_of_type_ComTencentMobileqqVashealthTracePointsData != null)
          {
            Location.distanceBetween(paramTracePointsData.latitude, paramTracePointsData.longitude, this.jdField_a_of_type_ComTencentMobileqqVashealthTracePointsData.latitude, this.jdField_a_of_type_ComTencentMobileqqVashealthTracePointsData.longitude, (float[])localObject2);
            ((StringBuilder)localObject1).append(",interval: ").append(localObject2[0]);
            if ((localObject2[0] <= k) || (localObject2[0] >= j)) {
              break label1324;
            }
            if (paramTracePointsData.accuracy < j) {
              break label1279;
            }
            f1 = 0.2F;
            label980:
            paramTracePointsData.latitude = (paramTracePointsData.latitude * f1 + this.jdField_a_of_type_ComTencentMobileqqVashealthTracePointsData.latitude * (1.0F - f1));
            paramTracePointsData.longitude = (paramTracePointsData.longitude * f1 + this.jdField_a_of_type_ComTencentMobileqqVashealthTracePointsData.longitude * (1.0F - f1));
            Location.distanceBetween(paramTracePointsData.latitude, paramTracePointsData.longitude, this.jdField_a_of_type_ComTencentMobileqqVashealthTracePointsData.latitude, this.jdField_a_of_type_ComTencentMobileqqVashealthTracePointsData.longitude, (float[])localObject2);
            ((StringBuilder)localObject1).append(",Mis distance:" + localObject2[0] + ",coefficient:" + f1);
          }
        }
        label1324:
        for (this.jdField_a_of_type_Boolean = false;; this.jdField_a_of_type_Boolean = true)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqVashealthTracePointsData != null) {
            this.jdField_a_of_type_ComTencentMobileqqVashealthTracePointsData.time = paramTracePointsData.time;
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData.distance >= 10.0D) || (this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() < 5)) {
            break label1545;
          }
          f2 = 0.0F;
          f1 = 0.0F;
          m = 0;
          while (m < this.jdField_a_of_type_JavaUtilArrayList.size())
          {
            f2 += ((TracePointsData)this.jdField_a_of_type_JavaUtilArrayList.get(m)).latitude;
            f1 += ((TracePointsData)this.jdField_a_of_type_JavaUtilArrayList.get(m)).longitude;
            m += 1;
          }
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData;
          long l2 = ((TracePathData)localObject2).totalTime;
          if (this.jdField_a_of_type_ComTencentMobileqqVashealthTracePointsData == null) {}
          for (long l1 = 2L;; l1 = paramTracePointsData.time - this.jdField_a_of_type_ComTencentMobileqqVashealthTracePointsData.time)
          {
            ((TracePathData)localObject2).totalTime = (l1 + l2);
            break;
          }
          label1279:
          if (paramTracePointsData.accuracy <= k)
          {
            f1 = 1.0F;
            break label980;
          }
          f1 = Float.valueOf(j - paramTracePointsData.accuracy).floatValue() / (j - k);
          break label980;
        }
        paramTracePointsData.latitude = (f2 / this.jdField_a_of_type_JavaUtilArrayList.size());
        paramTracePointsData.longitude = (f1 / this.jdField_a_of_type_JavaUtilArrayList.size());
        QLog.d("PathTraceManager", 1, "mOriginnalPoints HAPPEND:" + this.jdField_a_of_type_JavaUtilArrayList.toString());
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        label1545:
        do
        {
          double d1 = this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData.distance;
          localTracePathData = this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData;
          localTracePathData.distance += localObject2[0];
          if ((this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData.type == 0) && (Math.floor(this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData.distance / 1000.0D) - Math.floor(Double.valueOf(d1).doubleValue() / 1000.0D) > 0.0D)) {
            a(this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData, false, paramTracePointsData);
          }
          m = 1;
          this.jdField_a_of_type_ComTencentMobileqqVashealthTracePointsData = paramTracePointsData;
          this.jdField_f_of_type_Boolean = true;
          this.jdField_a_of_type_Boolean = true;
          this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData.totalSteps = paramTracePointsData.steps;
          this.jdField_a_of_type_JavaUtilList.clear();
          this.jdField_a_of_type_JavaUtilList.add(paramTracePointsData);
          b(this.jdField_a_of_type_JavaUtilList);
          break;
          if (paramTracePointsData.accuracy > i)
          {
            ((StringBuilder)localObject1).append(",accuracy too low: ").append(paramTracePointsData.accuracy);
            m = 0;
            break;
          }
          if ((this.jdField_b_of_type_Boolean) || ((paramTracePointsData.speed < 0.005D) && (this.jdField_a_of_type_Boolean)))
          {
            ((StringBuilder)localObject1).append(",speed too low: ").append(paramTracePointsData.speed);
            m = 0;
            break;
          }
          if ((localObject2[0] > j) && (this.jdField_f_of_type_Boolean))
          {
            ((StringBuilder)localObject1).append(",distance too long: ").append(localObject2[0]);
            this.jdField_f_of_type_Boolean = false;
            m = 0;
            break;
          }
        } while ((localObject2[0] >= 0.5D) || (this.jdField_a_of_type_ComTencentMobileqqVashealthTracePointsData == null));
        ((StringBuilder)localObject1).append(",distance too low: ").append(localObject2[0]);
        m = 0;
        break label179;
        label1712:
        if ((this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData != null) && (this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData.distance < 10.0D) && (this.jdField_a_of_type_JavaUtilArrayList != null)) {
          this.jdField_a_of_type_JavaUtilArrayList.add(paramTracePointsData);
        }
        paramTracePointsData = new JSONObject();
        try
        {
          paramTracePointsData.put("retCode", 1);
          if (this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData != null) {
            b(null);
          }
        }
        catch (Exception paramTracePointsData)
        {
          QLog.i("PathTraceManager", 1, "no singnal step");
        }
      }
    }
    b(-1);
    PathTraceService.c();
    QLog.e("PathTraceManager", 1, "WorkMode Err :" + this.jdField_c_of_type_Int);
  }
  
  public void a(String paramString)
  {
    String str = this.jdField_a_of_type_JavaLangString + "audio715.zip";
    Object localObject;
    if (!apvb.a(str))
    {
      localObject = new File(this.jdField_a_of_type_JavaLangString, "audio715.zip");
      this.jdField_c_of_type_Boolean = false;
    }
    for (;;)
    {
      if (this.jdField_c_of_type_Boolean) {}
      do
      {
        return;
        localObject = new bbwg("http://imgcache.qq.com/ac/vasapp/webviewlib/2513/run_sd/audio715.zip", (File)localObject);
        ((bbwg)localObject).r = false;
        ((bbwg)localObject).q = true;
        if (this.jdField_a_of_type_Bbwi == null)
        {
          this.jdField_a_of_type_Bbwi = ((bbwi)this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface.getManager(47));
          this.jdField_a_of_type_Bbwl = this.jdField_a_of_type_Bbwi.a(1);
        }
        if (this.jdField_a_of_type_Bbwl != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("PathTraceManager", 2, "loaderInterface Null");
      return;
      this.jdField_a_of_type_Bbwl.a((bbwg)localObject, new bbua(this, str, paramString), null);
      return;
      localObject = null;
    }
  }
  
  void a(ArrayList<String> paramArrayList, long paramLong)
  {
    long l;
    if (a(paramLong) != null)
    {
      l = paramLong / 3600L;
      if (c(l) != null)
      {
        paramArrayList.add(c(l));
        paramArrayList.add("100");
      }
      if (d(l) != null)
      {
        paramArrayList.add(d(l));
        paramArrayList.add("10");
      }
      if (e(l) != null) {
        paramArrayList.add(e(l));
      }
      paramArrayList.add("hour");
    }
    if (b(paramLong) != null)
    {
      l = paramLong % 3600L / 60L;
      if (c(l) != null)
      {
        paramArrayList.add(c(l));
        paramArrayList.add("100");
      }
      if (d(l) != null)
      {
        paramArrayList.add(d(l));
        paramArrayList.add("10");
      }
      if (e(l) != null) {
        paramArrayList.add(e(l));
      }
      paramArrayList.add("min");
    }
    if (c(paramLong) != null)
    {
      paramLong %= 60L;
      if (c(paramLong) != null)
      {
        paramArrayList.add(c(paramLong));
        paramArrayList.add("100");
      }
      if (paramLong < 10L) {
        break label321;
      }
      if (d(paramLong) != null)
      {
        paramArrayList.add(d(paramLong));
        paramArrayList.add("10");
      }
      if (e(paramLong) != null) {
        paramArrayList.add(e(paramLong));
      }
      paramArrayList.add("sec");
    }
    label321:
    do
    {
      return;
      if (paramLong > 0L)
      {
        paramArrayList.add("0");
        if (e(paramLong) != null) {
          paramArrayList.add(e(paramLong));
        }
        paramArrayList.add("sec");
        return;
      }
    } while (paramLong != 0L);
    paramArrayList.add("0");
    paramArrayList.add("sec");
  }
  
  /* Error */
  public void a(List<aukm> paramList)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +12 -> 13
    //   4: aload_1
    //   5: invokeinterface 434 1 0
    //   10: ifne +4 -> 14
    //   13: return
    //   14: aload_1
    //   15: invokeinterface 434 1 0
    //   20: iconst_1
    //   21: if_icmpne +19 -> 40
    //   24: aload_0
    //   25: aload_1
    //   26: iconst_0
    //   27: invokeinterface 435 2 0
    //   32: checkcast 1074	aukm
    //   35: invokevirtual 1077	com/tencent/mobileqq/vashealth/PathTraceManager:a	(Laukm;)Z
    //   38: pop
    //   39: return
    //   40: aload_0
    //   41: getfield 103	com/tencent/mobileqq/vashealth/PathTraceManager:jdField_a_of_type_Aukn	Laukn;
    //   44: invokevirtual 1080	aukn:a	()Laukp;
    //   47: astore_2
    //   48: aload_2
    //   49: invokevirtual 1084	aukp:a	()V
    //   52: aload_1
    //   53: invokeinterface 492 1 0
    //   58: astore_1
    //   59: aload_1
    //   60: invokeinterface 497 1 0
    //   65: ifeq +61 -> 126
    //   68: aload_0
    //   69: aload_1
    //   70: invokeinterface 500 1 0
    //   75: checkcast 1074	aukm
    //   78: invokevirtual 1077	com/tencent/mobileqq/vashealth/PathTraceManager:a	(Laukm;)Z
    //   81: pop
    //   82: goto -23 -> 59
    //   85: astore_1
    //   86: invokestatic 190	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   89: ifeq +32 -> 121
    //   92: ldc 195
    //   94: iconst_2
    //   95: new 129	java/lang/StringBuilder
    //   98: dup
    //   99: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   102: ldc_w 1086
    //   105: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: aload_1
    //   109: invokevirtual 1089	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   112: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: invokestatic 444	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   121: aload_2
    //   122: invokevirtual 1091	aukp:b	()V
    //   125: return
    //   126: aload_2
    //   127: invokevirtual 1092	aukp:c	()V
    //   130: aload_2
    //   131: invokevirtual 1091	aukp:b	()V
    //   134: return
    //   135: astore_1
    //   136: aload_2
    //   137: invokevirtual 1091	aukp:b	()V
    //   140: aload_1
    //   141: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	142	0	this	PathTraceManager
    //   0	142	1	paramList	List<aukm>
    //   47	90	2	localaukp	aukp
    // Exception table:
    //   from	to	target	type
    //   52	59	85	java/lang/Exception
    //   59	82	85	java/lang/Exception
    //   126	130	85	java/lang/Exception
    //   52	59	135	finally
    //   59	82	135	finally
    //   86	121	135	finally
    //   126	130	135	finally
  }
  
  public void a(JSONObject paramJSONObject)
  {
    QLog.i("PathTraceManager", 1, "startPathTrace");
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("start");
    b(localArrayList);
    this.g = paramJSONObject.optInt("type");
    i = paramJSONObject.optInt("accuracy");
    this.h = paramJSONObject.optInt("stepGoal");
    if (i == 0) {
      i = 50;
    }
    try
    {
      paramJSONObject = new TracePathData();
      paramJSONObject.startTime = NetConnInfoCenter.getServerTime();
      paramJSONObject.endTime = NetConnInfoCenter.getServerTime();
      paramJSONObject.type = this.g;
      paramJSONObject.stepsGoal = this.h;
      this.jdField_a_of_type_Long = paramJSONObject.startTime;
      this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData = paramJSONObject;
      boolean bool = a(this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData);
      QLog.i("PathTraceManager", 1, "createTime: " + this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData.startTime + ", ret: " + bool);
      a(1);
      PathTraceService.b();
      this.jdField_d_of_type_Int = 0;
      a();
      return;
    }
    catch (Exception paramJSONObject)
    {
      for (;;)
      {
        QLog.e("PathTraceManager", 1, paramJSONObject.getMessage());
      }
    }
  }
  
  public boolean a()
  {
    return this.jdField_c_of_type_Int == 1;
  }
  
  public boolean a(long paramLong)
  {
    b(-1);
    PathTraceService.c();
    c(this.jdField_c_of_type_Int);
    if (this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData == null) {
      this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData = b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData != null) {
      BaseApplicationImpl.getApplication().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface.getCurrentAccountUin(), 0).edit().remove(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData.startTime)).commit();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData == null)
    {
      QLog.e("PathTraceManager", 1, "pathTraceEnd Err");
      return false;
    }
    JSONObject localJSONObject = new JSONObject();
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {}
    Object localObject;
    for (bbts localbbts = (bbts)this.jdField_a_of_type_JavaLangRefWeakReference.get();; localObject = null)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData.totalTime < 60L) || (this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData.distance < 100.0D))
      {
        try
        {
          localJSONObject.put("retCode", -5);
          if (localbbts != null) {
            localbbts.dispatchJsEvent("PathTraceEnd", localJSONObject, new JSONObject());
          }
          a(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData.startTime));
        }
        catch (JSONException localJSONException1)
        {
          for (;;)
          {
            localJSONException1.printStackTrace();
          }
        }
        return false;
      }
      this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData.totalTime = paramLong;
      this.jdField_b_of_type_Long = paramLong;
      if (this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData.type == 0) {
        a(this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData, true, null);
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData.isStop = 1;
        this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData.endTime = NetConnInfoCenter.getServerTime();
        a(this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData);
        try
        {
          localJSONObject.put("retCode", 1);
          if (localJSONException1 != null) {
            localJSONException1.dispatchJsEvent("PathTraceEnd", localJSONObject, new JSONObject());
          }
        }
        catch (JSONException localJSONException2)
        {
          for (;;)
          {
            localJSONException2.printStackTrace();
          }
        }
        b();
        return true;
        if (this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData.type == 1) {
          a(this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData, true, false);
        }
      }
    }
  }
  
  public boolean a(aukm paramaukm)
  {
    if ((this.jdField_a_of_type_Aukn != null) && (this.jdField_a_of_type_Aukn.a()))
    {
      if (paramaukm.getStatus() == 1000)
      {
        this.jdField_a_of_type_Aukn.b(paramaukm);
        return paramaukm.getStatus() == 1001;
      }
      if ((paramaukm.getStatus() == 1001) || (paramaukm.getStatus() == 1002)) {
        return this.jdField_a_of_type_Aukn.a(paramaukm);
      }
    }
    QLog.e("PathTraceManager", 1, "updateEntity Err");
    return false;
  }
  
  public boolean a(Long paramLong)
  {
    Object localObject = "DELETE FROM TracePathData WHERE startTime = " + paramLong;
    this.jdField_a_of_type_Aukn.b((String)localObject);
    paramLong = "DELETE FROM TracePointsData WHERE time IN (SELECT time FROM TracePointsData WHERE startTime =" + paramLong + ")";
    bool = this.jdField_a_of_type_Aukn.b(paramLong);
    try
    {
      localObject = new JSONObject();
      if (bool) {
        ((JSONObject)localObject).put("retCode", 1);
      }
      for (;;)
      {
        paramLong = null;
        if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
          paramLong = (bbts)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        }
        if (paramLong == null) {
          break;
        }
        paramLong.dispatchJsEvent("PathTraceDelete", (JSONObject)localObject, new JSONObject());
        return bool;
        ((JSONObject)localObject).put("retCode", -8);
      }
      return bool;
    }
    catch (JSONException paramLong)
    {
      QLog.d("PathTraceManager", 1, "PathTraceDelete Err");
    }
  }
  
  public int b()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public TracePathData b()
  {
    TracePathData localTracePathData = null;
    List localList = this.jdField_a_of_type_Aukn.a(TracePathData.class, "SELECT * FROM TracePathData WHERE isStop <> 1 order by startTime desc limit 1 ", null);
    if (localList != null) {
      localTracePathData = (TracePathData)localList.get(0);
    }
    return localTracePathData;
  }
  
  String b(double paramDouble)
  {
    if (paramDouble >= 1000.0D) {
      return String.valueOf((int)(paramDouble % 10000.0D / 1000.0D));
    }
    return null;
  }
  
  String b(long paramLong)
  {
    if (paramLong >= 60L) {
      return String.valueOf((int)(paramLong % 3600L / 60L));
    }
    return null;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_AndroidHardwareSensorManager != null) && (this.jdField_a_of_type_AndroidHardwareSensorEventListener != null)) {
      this.jdField_a_of_type_AndroidHardwareSensorManager.unregisterListener(this.jdField_a_of_type_AndroidHardwareSensorEventListener);
    }
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_Bbue != null)
    {
      SosoInterface.b(this.jdField_a_of_type_Bbue);
      this.jdField_c_of_type_Int = paramInt;
      if ((this.jdField_c_of_type_Int == 2) && (this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
      {
        localObject = (bbts)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if ((localObject != null) && (((bbts)localObject).mRuntime != null)) {
          if (((bbts)localObject).mRuntime.a() == null) {
            break label133;
          }
        }
      }
    }
    label133:
    for (Object localObject = ((bbts)localObject).mRuntime.a().h;; localObject = null)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        a(this.jdField_c_of_type_Int, (String)localObject);
      }
      QLog.i("PathTraceManager", 1, "stopMode:" + this.jdField_c_of_type_Int);
      return;
    }
  }
  
  public void b(ArrayList<String> paramArrayList)
  {
    QLog.d("PathTraceManager", 1, "internalSavePath:" + this.jdField_a_of_type_JavaLangString);
    if (!this.jdField_d_of_type_Boolean)
    {
      int m = 0;
      int n = 1;
      if (m < paramArrayList.size())
      {
        if (!apvb.a(this.jdField_a_of_type_JavaLangString + (String)paramArrayList.get(m) + ".mp3"))
        {
          if (paramArrayList.size() != 1) {
            break label117;
          }
          a((String)paramArrayList.get(0));
        }
        for (;;)
        {
          n = 0;
          m += 1;
          break;
          label117:
          a(null);
        }
      }
      if (n != 0)
      {
        if (paramArrayList.size() == 1) {
          bbbr.a(Uri.fromFile(new File(this.jdField_a_of_type_JavaLangString + (String)paramArrayList.get(0) + ".mp3")), false, true);
        }
      }
      else {
        return;
      }
      ArrayList localArrayList = new ArrayList();
      m = 0;
      while (m < paramArrayList.size())
      {
        localArrayList.add(Uri.fromFile(new File(this.jdField_a_of_type_JavaLangString + (String)paramArrayList.get(m) + ".mp3")));
        m += 1;
      }
      ThreadManager.post(new PathTraceManager.5(this, localArrayList), 5, null, false);
      return;
    }
    QLog.d("PathTraceManager", 1, "play mute");
  }
  
  void b(ArrayList<String> paramArrayList, long paramLong)
  {
    label90:
    int m;
    if (a(paramLong) != null)
    {
      if ((int)(paramLong % 100000L / 10000L) == 2)
      {
        paramArrayList.add("2_liang");
        paramArrayList.add("10000");
      }
    }
    else
    {
      if ((b(paramLong) == null) || (Integer.parseInt(b(paramLong)) == 0)) {
        break label253;
      }
      if ((paramLong >= 10000L) || ((int)(paramLong % 10000L / 1000L) != 2)) {
        break label239;
      }
      paramArrayList.add("2_liang");
      paramArrayList.add("1000");
      m = 0;
    }
    for (;;)
    {
      label101:
      int n;
      if ((c(paramLong) != null) && (Integer.parseInt(c(paramLong)) != 0))
      {
        paramArrayList.add(c(paramLong));
        paramArrayList.add("100");
        n = 0;
        label144:
        if ((d(paramLong) == null) || (Integer.parseInt(d(paramLong)) == 0)) {
          break label453;
        }
        paramArrayList.add(d(paramLong));
        paramArrayList.add("10");
      }
      for (;;)
      {
        if ((e(paramLong) != null) && (Integer.parseInt(e(paramLong)) != 0)) {
          paramArrayList.add(e(paramLong));
        }
        paramArrayList.add("step");
        return;
        paramArrayList.add(a(paramLong));
        break;
        label239:
        paramArrayList.add(b(paramLong));
        break label90;
        label253:
        if ((b(paramLong) == null) || (Integer.parseInt(b(paramLong)) != 0) || (((c(paramLong) == null) || (Integer.parseInt(c(paramLong)) == 0)) && ((d(paramLong) == null) || (Integer.parseInt(d(paramLong)) == 0)) && ((e(paramLong) == null) || (Integer.parseInt(e(paramLong)) == 0)))) {
          break label511;
        }
        paramArrayList.add("0");
        m = 1;
        break label101;
        n = m;
        if (c(paramLong) == null) {
          break label144;
        }
        n = m;
        if (Integer.parseInt(c(paramLong)) != 0) {
          break label144;
        }
        n = m;
        if (m != 0) {
          break label144;
        }
        if ((d(paramLong) == null) || (Integer.parseInt(d(paramLong)) == 0))
        {
          n = m;
          if (e(paramLong) == null) {
            break label144;
          }
          n = m;
          if (Integer.parseInt(e(paramLong)) == 0) {
            break label144;
          }
        }
        paramArrayList.add("0");
        n = 1;
        break label144;
        label453:
        if ((d(paramLong) != null) && (Integer.parseInt(d(paramLong)) == 0) && (n == 0) && (e(paramLong) != null) && (Integer.parseInt(e(paramLong)) != 0)) {
          paramArrayList.add("0");
        }
      }
      label511:
      m = 0;
    }
  }
  
  String c(double paramDouble)
  {
    if (paramDouble >= 100.0D) {
      return String.valueOf((int)(paramDouble % 1000.0D / 100.0D));
    }
    return null;
  }
  
  String c(long paramLong)
  {
    if (paramLong >= 0L) {
      return String.valueOf((int)(paramLong % 60L));
    }
    return null;
  }
  
  public void c()
  {
    boolean bool = false;
    Object localObject = new ArrayList();
    ((ArrayList)localObject).add("pause");
    b((ArrayList)localObject);
    if (this.jdField_a_of_type_ComTencentMobileqqVashealthTracePointsData != null) {
      BaseApplicationImpl.getApplication().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface.getCurrentAccountUin(), 0).edit().putFloat("search_lbs_logitude", this.jdField_a_of_type_ComTencentMobileqqVashealthTracePointsData.longitude).putFloat("search_lbs_latitude", this.jdField_a_of_type_ComTencentMobileqqVashealthTracePointsData.latitude).putLong("search_lbs_timestamp", System.currentTimeMillis()).commit();
    }
    this.jdField_a_of_type_ComTencentMobileqqVashealthTracePointsData = null;
    b(2);
    PathTraceService.c();
    if (this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData != null)
    {
      if (this.jdField_a_of_type_Long != 0L) {
        this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData.totalTime = (this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData.totalTime + NetConnInfoCenter.getServerTime() - this.jdField_a_of_type_Long);
      }
      this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData.isStop = 3;
      a(this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData);
    }
    localObject = new StringBuilder().append("pathTracePause:");
    if (this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData == null) {
      bool = true;
    }
    QLog.i("PathTraceManager", 1, bool);
  }
  
  public void c(int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("CommondType", 2);
    localBundle.putLong("runningState", paramInt);
    if (this.jdField_a_of_type_ComTencentMobileqqPluginsdkPluginInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqPluginsdkPluginInterface.transfer("running_plugin_cmd", localBundle);
    }
    a(localBundle);
    QLog.i("PathTraceManager", 1, "removeSportBar");
  }
  
  String d(double paramDouble)
  {
    if (paramDouble >= 10.0D) {
      return String.valueOf((int)(paramDouble % 100.0D / 10.0D));
    }
    return null;
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData == null) {
      this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData = b();
    }
    this.jdField_a_of_type_Long = NetConnInfoCenter.getServerTime();
    a();
    if (this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData != null)
    {
      a(1);
      PathTraceService.b();
    }
    for (;;)
    {
      this.jdField_d_of_type_Int = 0;
      return;
      QLog.e("PathTraceManager", 1, "pathTraceResume Err");
    }
  }
  
  String e(double paramDouble)
  {
    if ((d(paramDouble) != null) && ((int)(paramDouble % 10.0D) == 0)) {
      return null;
    }
    return String.valueOf((int)(paramDouble % 10.0D));
  }
  
  String f(double paramDouble)
  {
    return String.valueOf((int)(paramDouble * 10.0D % 10.0D));
  }
  
  String g(double paramDouble)
  {
    if ((int)(paramDouble * 100.0D % 10.0D) != 0) {
      return String.valueOf((int)(paramDouble * 100.0D % 10.0D));
    }
    return null;
  }
  
  public void onDestroy()
  {
    b(-1);
    PathTraceService.c();
    c(a());
    bbbr.a();
    QLog.i("PathTraceManager", 1, "onDestroy");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.PathTraceManager
 * JD-Core Version:    0.7.0.1
 */