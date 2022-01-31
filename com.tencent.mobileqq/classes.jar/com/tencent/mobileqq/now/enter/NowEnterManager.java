package com.tencent.mobileqq.now.enter;

import agek;
import agel;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.Utils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.splashlogo.ConfigServlet;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class NowEnterManager
  implements INetEngine.INetEngineListener, Manager
{
  int jdField_a_of_type_Int = -1;
  private long jdField_a_of_type_Long = NetConnInfoCenter.getServerTime();
  public QQAppInterface a;
  private INetEngine jdField_a_of_type_ComTencentMobileqqTransfileINetEngine;
  public WeakReference a;
  private List jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
  protected Set a;
  private int b;
  
  public NowEnterManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilSet = Collections.synchronizedSet(new HashSet());
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public static Bitmap a(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = a(paramQQAppInterface, paramString);
    if (QLog.isColorLevel()) {
      QLog.i("now_enter.pendant", 2, "[getBitmap] url=" + paramString + ", path=" + paramQQAppInterface);
    }
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = Utils.Crc64String(paramString);
      String str = "now_enter_pendant_" + paramString;
      paramString = (Bitmap)BaseApplicationImpl.sImageCache.get(str);
      if (paramString != null)
      {
        paramQQAppInterface = paramString;
        if (QLog.isColorLevel())
        {
          QLog.i("now_enter.pendant", 2, "[getBitmap] hit cache=" + str);
          paramQQAppInterface = paramString;
        }
      }
      do
      {
        return paramQQAppInterface;
        if (!new File(paramQQAppInterface).exists()) {
          return null;
        }
        paramString = a(paramQQAppInterface, 1);
        if (QLog.isColorLevel()) {
          QLog.i("now_enter.pendant", 2, "[getBitmap] hit local file, decodeLocal result=" + paramString + ", key=" + str);
        }
        paramQQAppInterface = paramString;
      } while (paramString == null);
      BaseApplicationImpl.sImageCache.put(str, paramString);
      return paramString;
    }
    return null;
  }
  
  public static Bitmap a(String paramString, int paramInt)
  {
    localObject1 = null;
    Object localObject2 = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject2).inPreferredConfig = Bitmap.Config.ARGB_8888;
    ((BitmapFactory.Options)localObject2).inSampleSize = paramInt;
    try
    {
      localObject2 = BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject2);
      localObject1 = localObject2;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        QLog.e("now_enter.pendant", 1, "[decodeBitmap] outOfMemoryError, inSampleSize:" + paramInt);
        if (paramInt == 1) {
          localObject1 = a(paramString, 2);
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("now_enter.pendant", 1, "[decodeBitmap]", localException);
      }
    }
    if (localObject1 == null) {
      QLog.e("now_enter.pendant", 1, new Object[] { "[decodeBitmap] error:", paramString });
    }
    return localObject1;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    paramQQAppInterface = paramQQAppInterface.getApplication().getFilesDir() + File.separator + "now_enter" + File.separator;
    paramString = Utils.Crc64String(paramString);
    return paramQQAppInterface + paramString;
  }
  
  public int a()
  {
    if (this.b != 0) {
      return this.b;
    }
    this.b = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("now_enter_config" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 4).getInt("version" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 0);
    return this.b;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("now_enter_config" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 4).getString("activeJumpUrl" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), "");
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((NowEnterManager.WebProcessBindCallback)localIterator.next()).a();
    }
  }
  
  public void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NowEnterManager", 2, new Object[] { "[setNextValidPulldownMsgTime] interval=", Long.valueOf(paramLong) });
    }
    long l = paramLong;
    if (paramLong > 300L)
    {
      QLog.d("NowEnterManager", 1, new Object[] { "[setNextValidPulldownMsgTime] interval exceed 300s: ", Long.valueOf(paramLong) });
      l = 300L;
    }
    if (l > 0L) {
      this.jdField_a_of_type_Long = (NetConnInfoCenter.getServerTime() + l);
    }
  }
  
  /* Error */
  public void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_2
    //   3: invokestatic 88	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: istore_3
    //   7: iload_3
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: aload_1
    //   16: aload_2
    //   17: invokevirtual 270	com/tencent/mobileqq/now/enter/NowEnterManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)Z
    //   20: istore_3
    //   21: invokestatic 61	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   24: ifeq +39 -> 63
    //   27: ldc 63
    //   29: iconst_2
    //   30: new 65	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   37: ldc_w 272
    //   40: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: iload_3
    //   44: invokevirtual 275	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   47: ldc_w 277
    //   50: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: aload_2
    //   54: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: invokestatic 82	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   63: iload_3
    //   64: ifeq -53 -> 11
    //   67: aload_2
    //   68: invokestatic 94	com/tencent/image/Utils:Crc64String	(Ljava/lang/String;)Ljava/lang/String;
    //   71: astore 4
    //   73: aload_0
    //   74: getfield 38	com/tencent/mobileqq/now/enter/NowEnterManager:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   77: aload 4
    //   79: invokeinterface 283 2 0
    //   84: pop
    //   85: aload_0
    //   86: getfield 285	com/tencent/mobileqq/now/enter/NowEnterManager:jdField_a_of_type_ComTencentMobileqqTransfileINetEngine	Lcom/tencent/mobileqq/transfile/INetEngine;
    //   89: ifnonnull +12 -> 101
    //   92: aload_0
    //   93: aload_1
    //   94: iconst_0
    //   95: invokevirtual 289	com/tencent/mobileqq/app/QQAppInterface:getNetEngine	(I)Lcom/tencent/mobileqq/transfile/INetEngine;
    //   98: putfield 285	com/tencent/mobileqq/now/enter/NowEnterManager:jdField_a_of_type_ComTencentMobileqqTransfileINetEngine	Lcom/tencent/mobileqq/transfile/INetEngine;
    //   101: new 291	com/tencent/mobileqq/transfile/HttpNetReq
    //   104: dup
    //   105: invokespecial 292	com/tencent/mobileqq/transfile/HttpNetReq:<init>	()V
    //   108: astore 4
    //   110: aload 4
    //   112: aload_0
    //   113: putfield 295	com/tencent/mobileqq/transfile/HttpNetReq:jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener	Lcom/tencent/mobileqq/transfile/INetEngine$INetEngineListener;
    //   116: aload 4
    //   118: aload_2
    //   119: putfield 297	com/tencent/mobileqq/transfile/HttpNetReq:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   122: aload 4
    //   124: iconst_0
    //   125: putfield 298	com/tencent/mobileqq/transfile/HttpNetReq:jdField_a_of_type_Int	I
    //   128: aload 4
    //   130: aload_1
    //   131: aload_2
    //   132: invokestatic 55	com/tencent/mobileqq/now/enter/NowEnterManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)Ljava/lang/String;
    //   135: putfield 300	com/tencent/mobileqq/transfile/HttpNetReq:c	Ljava/lang/String;
    //   138: aload 4
    //   140: iconst_2
    //   141: putfield 302	com/tencent/mobileqq/transfile/HttpNetReq:e	I
    //   144: aload_0
    //   145: getfield 285	com/tencent/mobileqq/now/enter/NowEnterManager:jdField_a_of_type_ComTencentMobileqqTransfileINetEngine	Lcom/tencent/mobileqq/transfile/INetEngine;
    //   148: aload 4
    //   150: invokeinterface 307 2 0
    //   155: goto -144 -> 11
    //   158: astore_1
    //   159: aload_0
    //   160: monitorexit
    //   161: aload_1
    //   162: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	163	0	this	NowEnterManager
    //   0	163	1	paramQQAppInterface	QQAppInterface
    //   0	163	2	paramString	String
    //   6	58	3	bool	boolean
    //   71	78	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	158	finally
    //   14	63	158	finally
    //   67	101	158	finally
    //   101	155	158	finally
  }
  
  public void a(ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    int j = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getInt("now_enter_config_version" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 0);
    if (QLog.isColorLevel()) {
      QLog.i("NowEnterManager", 2, "handleNowEnterManagerConfig: ,version: " + paramConfig.version.get() + "| localVersion: " + j);
    }
    if (i != j)
    {
      paramConfig = ConfigServlet.a(paramConfig);
      localEditor = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("now_enter_config" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 4).edit();
      if ((paramConfig != null) && (paramConfig.size() > 0))
      {
        str1 = (String)paramConfig.get(0);
        paramConfig = str1;
        if (str1 == null) {
          paramConfig = "";
        }
        if (QLog.isColorLevel()) {
          QLog.d("NowEnterManager", 2, new Object[] { "handleNowEnterManagerConfig json content: ", "" + paramConfig });
        }
      }
    }
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        SharedPreferences.Editor localEditor;
        try
        {
          localObject = new JSONObject(paramConfig);
          paramConfig = ((JSONObject)localObject).optString("topViewImageUrl");
          bool = ((JSONObject)localObject).optBoolean("preloadImage");
          str1 = ((JSONObject)localObject).optString("floatViewImageUrl");
          if (((JSONObject)localObject).has("nativeAutoEnterRoom")) {
            localEditor.putBoolean("nativeAutoEnterRoom" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), ((JSONObject)localObject).optBoolean("nativeAutoEnterRoom"));
          }
          if (((JSONObject)localObject).has("autoEnterForNotWifi")) {
            localEditor.putBoolean("autoEnterForNotWifi" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), ((JSONObject)localObject).optBoolean("autoEnterForNotWifi"));
          }
          localEditor.putString("topViewJumpUrl" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), ((JSONObject)localObject).optString("topViewJumpUrl"));
          localEditor.putString("floatViewJumpUrl" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), ((JSONObject)localObject).optString("floatViewJumpUrl"));
          localEditor.putString("topViewImageUrl" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), paramConfig);
          localEditor.putString("floatViewImageUrl" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), str1);
          localEditor.putString("activeJumpUrl" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), ((JSONObject)localObject).optString("activeJumpUrl"));
          localEditor.putBoolean("isActiveEnable" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), ((JSONObject)localObject).optBoolean("isActiveEnable"));
          localEditor.putBoolean("isNowEnterSettingShow" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), ((JSONObject)localObject).optBoolean("isNowEnterSettingShow"));
          localEditor.putBoolean("preloadImage" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), bool);
          str2 = ((JSONObject)localObject).optString("activeStartTime");
          str3 = ((JSONObject)localObject).optString("activeEndTime");
          localEditor.putInt("version" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), ((JSONObject)localObject).optInt("version"));
          localObject = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
        }
        catch (JSONException paramConfig)
        {
          String str1;
          Object localObject;
          boolean bool;
          String str2;
          String str3;
          long l1;
          long l2;
          localEditor.clear();
          continue;
        }
        try
        {
          l1 = ((SimpleDateFormat)localObject).parse(str2).getTime();
          l2 = ((SimpleDateFormat)localObject).parse(str3).getTime();
          localEditor.putLong("activeStartTime" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), l1 / 1000L);
          localEditor.putLong("activeEndTime" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), l2 / 1000L);
          localEditor.commit();
          if (bool) {
            ThreadManager.post(new agek(this, paramConfig, str1), 5, null, false);
          }
          localEditor.commit();
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit().putInt("now_enter_config_version" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), i).commit();
          this.b = 0;
          paramConfig = (NowHongbaoPushManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(265);
          if (paramConfig != null) {
            paramConfig.b();
          }
          return;
        }
        catch (ParseException localParseException)
        {
          QLog.e("NowEnterManager", 1, localParseException, new Object[0]);
          continue;
        }
        localEditor.clear();
      }
    }
    QLog.i("NowEnterManager", 2, "handleNowEnterManagerConfig:localVersion == version = " + i);
  }
  
  public void a(NowEnterManager.DownloadListener paramDownloadListener)
  {
    if (paramDownloadListener != null)
    {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramDownloadListener);
      return;
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
  }
  
  public void a(NowEnterManager.WebProcessBindCallback paramWebProcessBindCallback)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramWebProcessBindCallback);
  }
  
  public void a(NetReq paramNetReq, long paramLong1, long paramLong2) {}
  
  public void a(NetResp paramNetResp)
  {
    try
    {
      if (paramNetResp.jdField_a_of_type_Int == 0) {}
      for (boolean bool = true;; bool = false)
      {
        HttpNetReq localHttpNetReq = (HttpNetReq)paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq;
        QLog.d("now_enter.pendant", 1, "[onResp]: isSucc=" + bool + ", resp.mResult=" + paramNetResp.jdField_a_of_type_Int + ", url=" + localHttpNetReq.jdField_a_of_type_JavaLangString);
        paramNetResp = Utils.Crc64String(localHttpNetReq.jdField_a_of_type_JavaLangString);
        if (this.jdField_a_of_type_JavaUtilSet.contains(paramNetResp)) {
          this.jdField_a_of_type_JavaUtilSet.remove(paramNetResp);
        }
        ThreadManager.getUIHandler().post(new agel(this, bool, localHttpNetReq));
        if (!bool)
        {
          paramNetResp = new File(localHttpNetReq.c);
          if ((paramNetResp != null) && (paramNetResp.exists())) {
            paramNetResp.delete();
          }
        }
        return;
      }
      return;
    }
    catch (Exception paramNetResp)
    {
      QLog.w("now_enter.pendant", 1, "onResp:" + paramNetResp.toString());
    }
  }
  
  public void a(boolean paramBoolean)
  {
    int i = 1;
    ReportTask localReportTask = new ReportTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_AIO").c("year_icon").d("settings_button");
    if (paramBoolean) {}
    for (;;)
    {
      localReportTask.a(new String[] { String.valueOf(i) }).a();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("now_enter_config" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 4).edit().putBoolean("nowPullShow" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), paramBoolean).commit();
      return;
      i = 2;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("now_enter_config" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 4).getBoolean("nativeAutoEnterRoom" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), false);
  }
  
  protected boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      QLog.e("now_enter.pendant", 1, "[isNeedDownload] url is empty.");
    }
    do
    {
      do
      {
        return false;
        String str = Utils.Crc64String(paramString);
        if (!this.jdField_a_of_type_JavaUtilSet.contains(str)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("now_enter.pendant", 2, "isNeedDownload=false, downloading...");
      return false;
    } while (new File(a(paramQQAppInterface, paramString)).exists());
    return true;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("now_enter_config" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 4).getString("topViewImageUrl" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), "");
  }
  
  public void b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((NowEnterManager.WebProcessBindCallback)localIterator.next()).b();
    }
  }
  
  public void b(NowEnterManager.WebProcessBindCallback paramWebProcessBindCallback)
  {
    this.jdField_a_of_type_JavaUtilList.remove(paramWebProcessBindCallback);
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("now_enter_config" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 4).getBoolean("autoEnterForNotWifi" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), false);
  }
  
  public String c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("now_enter_config" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 4).getString("floatViewImageUrl" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), "");
  }
  
  public boolean c()
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("now_enter_config" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 4).getBoolean("nowPullShow" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), true);
    if (QLog.isColorLevel()) {
      QLog.i("NowEnterManager", 2, "isNowPullShow -- isShowSetting = " + bool);
    }
    return bool;
  }
  
  public String d()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("now_enter_config" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 4).getString("floatViewJumpUrl" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), "");
  }
  
  public boolean d()
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("now_enter_config" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 4).getBoolean("now_local_enter_switch_config" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), false);
    if (QLog.isColorLevel()) {
      QLog.i("NowEnterManager", 2, "isLocalConfigSwitchShow -- isShowSetting = " + bool);
    }
    return bool;
  }
  
  public boolean e()
  {
    return NetConnInfoCenter.getServerTime() >= this.jdField_a_of_type_Long;
  }
  
  public void onDestroy()
  {
    this.b = 0;
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    this.jdField_a_of_type_JavaUtilList.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.now.enter.NowEnterManager
 * JD-Core Version:    0.7.0.1
 */