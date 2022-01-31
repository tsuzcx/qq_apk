package com.tencent.mobileqq.scribble;

import ahcb;
import ahcc;
import ahcd;
import ahcf;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.splashlogo.ConfigServlet;
import com.tencent.mobileqq.transfile.predownload.PreDownloadController;
import com.tencent.mobileqq.transfile.predownload.RunnableTask;
import com.tencent.mobileqq.util.JSONUtils;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ScribbleResMgr
{
  static ScribbleResMgr jdField_a_of_type_ComTencentMobileqqScribbleScribbleResMgr;
  public static final Long a;
  static Object jdField_a_of_type_JavaLangObject = new Object();
  public static final String a;
  public static final String b;
  public static final String c;
  public static final String d;
  public static final String e;
  protected Handler a;
  private final ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private final Handler jdField_b_of_type_AndroidOsHandler = new ahcb(this, Looper.getMainLooper());
  private ArrayList jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_b_of_type_Boolean;
  private ArrayList jdField_c_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  private String f = "";
  private String g = "";
  private String h = "";
  private String i = "";
  
  static
  {
    jdField_a_of_type_JavaLangString = AppConstants.bM + "Config/";
    jdField_b_of_type_JavaLangString = AppConstants.bM + "Config/paint/";
    jdField_c_of_type_JavaLangString = AppConstants.bM + "Config/gif/";
    jdField_d_of_type_JavaLangString = AppConstants.bM + "Config/line_icon/";
    e = AppConstants.bM + "Config/gif_icon/";
    jdField_a_of_type_JavaLangLong = Long.valueOf(30000L);
  }
  
  private ScribbleResMgr(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
    a(paramQQAppInterface);
  }
  
  public static ScribbleResMgr a(QQAppInterface paramQQAppInterface)
  {
    if (jdField_a_of_type_ComTencentMobileqqScribbleScribbleResMgr != null) {
      return jdField_a_of_type_ComTencentMobileqqScribbleScribbleResMgr;
    }
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_ComTencentMobileqqScribbleScribbleResMgr != null)
      {
        paramQQAppInterface = jdField_a_of_type_ComTencentMobileqqScribbleScribbleResMgr;
        return paramQQAppInterface;
      }
    }
    jdField_a_of_type_ComTencentMobileqqScribbleScribbleResMgr = new ScribbleResMgr(paramQQAppInterface);
    paramQQAppInterface = jdField_a_of_type_ComTencentMobileqqScribbleScribbleResMgr;
    return paramQQAppInterface;
  }
  
  private String a()
  {
    return AppConstants.bM + "paint_icon";
  }
  
  private String a(int paramInt)
  {
    return jdField_c_of_type_JavaLangString + "gif_zip_tmp" + String.valueOf(paramInt) + "/";
  }
  
  public static ArrayList a(JSONArray paramJSONArray, int paramInt)
  {
    if (paramJSONArray == null) {
      return null;
    }
    try
    {
      int k = paramJSONArray.length();
      if (k <= 0) {
        return null;
      }
      ArrayList localArrayList = new ArrayList(k);
      int j = 0;
      while (j < k)
      {
        ScribbleResMgr.ResInfo localResInfo = (ScribbleResMgr.ResInfo)JSONUtils.a(paramJSONArray.getJSONObject(j), ScribbleResMgr.ResInfo.class);
        if (localResInfo != null)
        {
          localResInfo.resType = paramInt;
          localArrayList.add(localResInfo);
        }
        j += 1;
      }
      return localArrayList;
    }
    catch (JSONException paramJSONArray)
    {
      if (QLog.isDevelopLevel())
      {
        paramJSONArray.printStackTrace();
        QLog.e("ScribbleResMgr", 2, "convertFromErr: " + paramJSONArray);
      }
    }
    return null;
  }
  
  /* Error */
  private void a(int paramInt1, int paramInt2, View paramView, ScribbleResMgr.ResCallback paramResCallback)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 105	com/tencent/mobileqq/scribble/ScribbleResMgr:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   6: invokevirtual 199	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   9: astore 5
    //   11: aload 5
    //   13: invokeinterface 204 1 0
    //   18: ifeq +41 -> 59
    //   21: aload 5
    //   23: invokeinterface 208 1 0
    //   28: checkcast 210	ahch
    //   31: astore 6
    //   33: aload 6
    //   35: invokevirtual 213	ahch:a	()Landroid/view/View;
    //   38: aload_3
    //   39: if_acmpne -28 -> 11
    //   42: aload 6
    //   44: new 215	java/lang/ref/WeakReference
    //   47: dup
    //   48: aload 4
    //   50: invokespecial 218	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   53: putfield 221	ahch:b	Ljava/lang/ref/WeakReference;
    //   56: aload_0
    //   57: monitorexit
    //   58: return
    //   59: aload_0
    //   60: getfield 105	com/tencent/mobileqq/scribble/ScribbleResMgr:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   63: new 210	ahch
    //   66: dup
    //   67: aload_0
    //   68: iload_1
    //   69: iload_2
    //   70: aload_3
    //   71: aload 4
    //   73: invokespecial 224	ahch:<init>	(Lcom/tencent/mobileqq/scribble/ScribbleResMgr;IILandroid/view/View;Lcom/tencent/mobileqq/scribble/ScribbleResMgr$ResCallback;)V
    //   76: invokevirtual 175	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   79: pop
    //   80: goto -24 -> 56
    //   83: astore_3
    //   84: aload_0
    //   85: monitorexit
    //   86: aload_3
    //   87: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	this	ScribbleResMgr
    //   0	88	1	paramInt1	int
    //   0	88	2	paramInt2	int
    //   0	88	3	paramView	View
    //   0	88	4	paramResCallback	ScribbleResMgr.ResCallback
    //   9	13	5	localIterator	Iterator
    //   31	12	6	localahch	ahch
    // Exception table:
    //   from	to	target	type
    //   2	11	83	finally
    //   11	56	83	finally
    //   59	80	83	finally
  }
  
  private void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramInt1 == 3) {
      this.jdField_b_of_type_Boolean = paramBoolean;
    }
    if (paramInt1 == 4) {
      this.jdField_a_of_type_Boolean = paramBoolean;
    }
    Iterator localIterator;
    ScribbleResMgr.ResInfo localResInfo;
    if (paramInt1 == 2)
    {
      localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        localResInfo = (ScribbleResMgr.ResInfo)localIterator.next();
        if ((localResInfo != null) && (localResInfo.sourceId == paramInt2)) {
          localResInfo.downloading = paramBoolean;
        }
      }
    }
    if (paramInt1 == 1)
    {
      localIterator = this.jdField_c_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        localResInfo = (ScribbleResMgr.ResInfo)localIterator.next();
        if ((localResInfo != null) && (localResInfo.sourceId == paramInt2)) {
          localResInfo.downloading = paramBoolean;
        }
      }
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface)
  {
    String str1 = SharedPreUtils.r(paramQQAppInterface.getApp().getApplicationContext());
    String str2 = SharedPreUtils.q(paramQQAppInterface.getApp().getApplicationContext());
    String str3 = SharedPreUtils.t(paramQQAppInterface.getApp().getApplicationContext());
    if (QLog.isColorLevel()) {
      QLog.i("ScribbleResMgr", 2, "init mIsShow:" + this.jdField_d_of_type_Boolean);
    }
    if (!TextUtils.isEmpty(str1)) {
      a(paramQQAppInterface, str1);
    }
    if (!TextUtils.isEmpty(str2)) {
      b(paramQQAppInterface, str2);
    }
    if (!TextUtils.isEmpty(str3)) {
      a(str3, paramQQAppInterface);
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2)
  {
    int n = 0;
    int j;
    int k;
    if (paramInt1 == 3) {
      if (TextUtils.isEmpty(this.f))
      {
        j = 1;
        k = j;
        if (paramInt1 == 4)
        {
          if (!TextUtils.isEmpty(this.h)) {
            break label135;
          }
          k = 1;
        }
      }
    }
    for (;;)
    {
      j = k;
      if (paramInt1 == 1)
      {
        if (!this.jdField_c_of_type_JavaUtilArrayList.isEmpty()) {
          break label162;
        }
        j = 1;
      }
      k = j;
      if (paramInt1 == 2)
      {
        if (!this.jdField_b_of_type_JavaUtilArrayList.isEmpty()) {
          break label250;
        }
        k = 1;
      }
      if ((k != 0) && (!this.jdField_c_of_type_Boolean))
      {
        this.jdField_c_of_type_Boolean = true;
        ConfigServlet.g(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin());
      }
      return;
      if (!this.jdField_b_of_type_Boolean) {
        a(paramQQAppInterface, paramInt1, 50L);
      }
      j = 0;
      break;
      label135:
      k = j;
      if (!this.jdField_a_of_type_Boolean)
      {
        a(paramQQAppInterface, paramInt1, 50L);
        k = j;
      }
    }
    label162:
    Iterator localIterator = this.jdField_c_of_type_JavaUtilArrayList.iterator();
    ScribbleResMgr.ResInfo localResInfo;
    int m;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localResInfo = (ScribbleResMgr.ResInfo)localIterator.next();
        if ((localResInfo != null) && (localResInfo.sourceId == paramInt2)) {
          if (!localResInfo.downloading)
          {
            localResInfo.downloading = true;
            a(paramQQAppInterface, localResInfo, 50L, false);
            m = 1;
          }
        }
      }
    }
    for (;;)
    {
      j = k;
      if (m != 0) {
        break;
      }
      j = 1;
      break;
      label250:
      localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
      do
      {
        paramInt1 = n;
        if (!localIterator.hasNext()) {
          break;
        }
        localResInfo = (ScribbleResMgr.ResInfo)localIterator.next();
      } while ((localResInfo == null) || (localResInfo.sourceId != paramInt2));
      long l;
      if (!localResInfo.downloading)
      {
        localResInfo.downloading = true;
        l = Thread.currentThread().getId();
        QLog.i("ScribbleResMgr", 2, "RESOURCE_TYPE_GIF threadId: " + l + " inf.resType:  " + localResInfo.resType + " resID: " + localResInfo.sourceId + " downloading is false set true");
        a(paramQQAppInterface, localResInfo, 0L, false);
      }
      for (paramInt1 = 1;; paramInt1 = 1)
      {
        k = j;
        if (paramInt1 != 0) {
          break;
        }
        k = 1;
        break;
        l = Thread.currentThread().getId();
        QLog.i("ScribbleResMgr", 2, "RESOURCE_TYPE_GIF threadId: " + l + " inf.resType:  " + localResInfo.resType + " resID: " + localResInfo.sourceId + "is downloading  ");
      }
      m = 1;
      continue;
      m = 0;
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, int paramInt, long paramLong)
  {
    if (!Environment.getExternalStorageState().equalsIgnoreCase("mounted"))
    {
      QLog.e("ScribbleResMgrdownloading", 2, "SD card mounted err");
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new ahcf(this, paramInt, paramQQAppInterface), paramLong);
  }
  
  private void a(QQAppInterface paramQQAppInterface, ScribbleResMgr.ResInfo paramResInfo, long paramLong, boolean paramBoolean)
  {
    if (paramResInfo == null) {
      return;
    }
    ahcd localahcd = new ahcd(this, paramResInfo);
    PreDownloadController localPreDownloadController;
    String str;
    if (paramBoolean)
    {
      localPreDownloadController = (PreDownloadController)paramQQAppInterface.getManager(192);
      if (localPreDownloadController.a())
      {
        str = null;
        if (paramResInfo.resType == 1) {
          str = b(paramResInfo.resType, paramResInfo.sourceId);
        }
        if (paramResInfo.resType != 2) {
          break label339;
        }
        str = b(paramResInfo.sourceId);
      }
    }
    label339:
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ScribbleResMgr", 2, "download res, predownload enable:" + paramResInfo.sourceId + " " + paramResInfo.resType + " outpath:" + str + " url:" + paramResInfo.sourceUrl);
      }
      paramQQAppInterface = new RunnableTask(paramQQAppInterface, "doodle_msg_res", localahcd, 4000L);
      localPreDownloadController.a(10068, "prd", String.valueOf(paramResInfo.sourceId), 0, paramResInfo.sourceUrl, str, 2, 0, true, paramQQAppInterface);
      return;
      paramQQAppInterface = (PreDownloadController)paramQQAppInterface.getManager(192);
      if (paramQQAppInterface.a())
      {
        paramQQAppInterface.a(paramResInfo.sourceUrl);
        if (QLog.isColorLevel()) {
          QLog.d("ScribbleResMgr", 2, "download res, cancel predownload reqeust Url:" + paramResInfo.sourceUrl);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("ScribbleResMgr", 2, "download res, normal download:" + paramResInfo.sourceId + " " + paramResInfo.resType + " Url:" + paramResInfo.sourceUrl);
      }
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(localahcd, paramLong);
      return;
    }
  }
  
  private void a(ScribbleResMgr.ResInfo paramResInfo, int paramInt)
  {
    Message localMessage = new Message();
    localMessage.what = paramInt;
    localMessage.obj = paramResInfo;
    localMessage.arg1 = paramResInfo.resType;
    this.jdField_b_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, 0L);
    b(paramResInfo.resType, paramResInfo.sourceId, false);
  }
  
  private void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      try
      {
        paramString = paramString.substring(0, paramString.lastIndexOf(File.separator));
        if (!TextUtils.isEmpty(paramString))
        {
          paramString = new File(paramString);
          if (!paramString.exists())
          {
            paramString.mkdirs();
            return;
          }
        }
      }
      catch (Exception paramString)
      {
        QLog.d("ScribbleResMgrdownloading", 2, "makedir execption: " + paramString);
      }
    }
  }
  
  private void a(ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() < 2)) {
      return;
    }
    Collections.sort(paramArrayList, new ahcc(this));
  }
  
  private boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    JSONArray localJSONArray = null;
    String str = SharedPreUtils.p(paramQQAppInterface.getApp().getBaseContext());
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        if (localJSONObject.has("version"))
        {
          localObject1 = localJSONObject.getString("version");
          boolean bool;
          Object localObject2;
          return bool;
        }
      }
      catch (JSONException localJSONException1)
      {
        try
        {
          if (localJSONObject.has("iconUrl")) {
            this.f = localJSONObject.getString("iconUrl");
          }
          if (localJSONObject.has("iconMd5")) {
            this.g = localJSONObject.getString("iconMd5");
          }
          if (localJSONObject.has("content")) {
            localJSONArray = localJSONObject.getJSONArray("content");
          }
          bool = true;
          a(localJSONArray);
          if (((str != null) && (str.equalsIgnoreCase((String)localObject1))) || (!bool)) {
            continue;
          }
          QLog.i("ScribbleResMgr", 2, "RESOURCE_CONFIG_TASK_ID_PAINT newVersion = " + (String)localObject1);
          SharedPreUtils.A(paramQQAppInterface.getApp().getBaseContext(), (String)localObject1);
          SharedPreUtils.C(paramQQAppInterface.getApp().getBaseContext(), paramString);
          a(paramQQAppInterface, 3, jdField_a_of_type_JavaLangLong.longValue());
          if (this.jdField_c_of_type_JavaUtilArrayList.isEmpty()) {
            break label386;
          }
          paramString = this.jdField_c_of_type_JavaUtilArrayList.iterator();
          if (!paramString.hasNext()) {
            break label386;
          }
          localObject1 = (ScribbleResMgr.ResInfo)paramString.next();
          if (((ScribbleResMgr.ResInfo)localObject1).downloading) {
            continue;
          }
          if ((((ScribbleResMgr.ResInfo)localObject1).predownload != 1) && (!this.jdField_c_of_type_Boolean)) {
            continue;
          }
          a(paramQQAppInterface, (ScribbleResMgr.ResInfo)localObject1, jdField_a_of_type_JavaLangLong.longValue(), true);
          continue;
          localJSONException1 = localJSONException1;
          localObject1 = null;
        }
        catch (JSONException localJSONException2)
        {
          continue;
        }
        localJSONException1.printStackTrace();
        QLog.e("ScribbleResMgr", 2, "RESOURCE_CONFIG_TASK_ID_PAINT JSON EXCEPT");
        bool = false;
        localObject2 = null;
        continue;
        QLog.e("ScribbleResMgr", 2, "mArrPaintInfo index :" + ((ScribbleResMgr.ResInfo)localObject1).sourceId + " is downloading ");
        continue;
        QLog.i("ScribbleResMgr", 2, "RESOURCE_CONFIG_TASK_ID_PAINT newVersion = " + (String)localObject1 + " oldVersion=  " + str);
      }
      label386:
      Object localObject1 = null;
    }
  }
  
  private boolean a(JSONArray paramJSONArray)
  {
    paramJSONArray = a(paramJSONArray, 1);
    if ((paramJSONArray == null) || (paramJSONArray.isEmpty())) {
      return false;
    }
    this.jdField_c_of_type_JavaUtilArrayList.clear();
    this.jdField_c_of_type_JavaUtilArrayList.addAll(paramJSONArray);
    a(this.jdField_b_of_type_JavaUtilArrayList);
    return true;
  }
  
  private String b()
  {
    return AppConstants.bM + "gif_icon";
  }
  
  private String b(int paramInt)
  {
    return a(paramInt) + "gif_zip_tmp" + String.valueOf(paramInt);
  }
  
  private void b(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Message localMessage = new Message();
    if (paramBoolean) {}
    for (int j = 1001;; j = 1002)
    {
      localMessage.what = j;
      localMessage.arg1 = paramInt1;
      localMessage.arg2 = paramInt2;
      this.jdField_b_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, 0L);
      return;
    }
  }
  
  private boolean b(QQAppInterface paramQQAppInterface, String paramString)
  {
    JSONArray localJSONArray = null;
    String str = SharedPreUtils.o(paramQQAppInterface.getApp().getBaseContext());
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        if (localJSONObject.has("version"))
        {
          localObject1 = localJSONObject.getString("version");
          boolean bool;
          Object localObject2;
          return bool;
        }
      }
      catch (JSONException localJSONException1)
      {
        try
        {
          if (localJSONObject.has("iconUrl")) {
            this.h = localJSONObject.getString("iconUrl");
          }
          if (localJSONObject.has("iconMd5")) {
            this.i = localJSONObject.getString("iconMd5");
          }
          if (localJSONObject.has("content")) {
            localJSONArray = localJSONObject.getJSONArray("content");
          }
          bool = true;
          b(localJSONArray);
          if (((str != null) && (str.equalsIgnoreCase((String)localObject1))) || (!bool)) {
            continue;
          }
          QLog.i("ScribbleResMgr", 2, "RESOURCE_CONFIG_TASK_ID_GIF newVersion = " + (String)localObject1);
          SharedPreUtils.z(paramQQAppInterface.getApp().getBaseContext(), (String)localObject1);
          SharedPreUtils.B(paramQQAppInterface.getApp().getBaseContext(), paramString);
          a(paramQQAppInterface, 4, jdField_a_of_type_JavaLangLong.longValue());
          if (this.jdField_b_of_type_JavaUtilArrayList.isEmpty()) {
            break label386;
          }
          paramString = this.jdField_b_of_type_JavaUtilArrayList.iterator();
          if (!paramString.hasNext()) {
            break label386;
          }
          localObject1 = (ScribbleResMgr.ResInfo)paramString.next();
          if (((ScribbleResMgr.ResInfo)localObject1).downloading) {
            continue;
          }
          if ((((ScribbleResMgr.ResInfo)localObject1).predownload != 1) && (!this.jdField_c_of_type_Boolean)) {
            continue;
          }
          a(paramQQAppInterface, (ScribbleResMgr.ResInfo)localObject1, jdField_a_of_type_JavaLangLong.longValue(), true);
          continue;
          localJSONException1 = localJSONException1;
          localObject1 = null;
        }
        catch (JSONException localJSONException2)
        {
          continue;
        }
        localJSONException1.printStackTrace();
        QLog.e("ScribbleResMgr", 2, "RESOURCE_CONFIG_TASK_ID_Gif JSON EXCEPT");
        bool = false;
        localObject2 = null;
        continue;
        QLog.e("ScribbleResMgr", 2, "mArrGifInfo index :" + ((ScribbleResMgr.ResInfo)localObject1).sourceId + " is downloading ");
        continue;
        QLog.i("ScribbleResMgr", 2, "RESOURCE_CONFIG_TASK_ID_GIF newVersion = " + (String)localObject1 + " oldVersion=  " + str);
      }
      label386:
      Object localObject1 = null;
    }
  }
  
  private boolean b(JSONArray paramJSONArray)
  {
    paramJSONArray = a(paramJSONArray, 2);
    if ((paramJSONArray == null) || (paramJSONArray.isEmpty())) {
      return false;
    }
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    this.jdField_b_of_type_JavaUtilArrayList.addAll(paramJSONArray);
    a(this.jdField_b_of_type_JavaUtilArrayList);
    return true;
  }
  
  private String c(int paramInt)
  {
    return a(paramInt) + "gif_orig_" + String.valueOf(paramInt) + ".gif";
  }
  
  private void c()
  {
    Message localMessage = new Message();
    localMessage.what = 3;
    localMessage.obj = null;
    localMessage.arg1 = 0;
    this.jdField_b_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, 0L);
  }
  
  public String a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 1) {
      return jdField_d_of_type_JavaLangString + "line_icon_" + String.valueOf(paramInt2) + ".png";
    }
    if (paramInt1 == 2) {
      return e + "gif_icon_" + String.valueOf(paramInt2) + ".png";
    }
    return null;
  }
  
  public ArrayList a()
  {
    return this.jdField_c_of_type_JavaUtilArrayList;
  }
  
  public void a()
  {
    this.jdField_c_of_type_Boolean = false;
    QLog.d("ScribbleResMgr", 2, "setGetConfigFinished");
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, View paramView, ScribbleResMgr.ResCallback paramResCallback)
  {
    a(paramInt1, paramInt2, paramView, paramResCallback);
    a(paramQQAppInterface, paramInt1, paramInt2);
  }
  
  public boolean a()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public boolean a(String paramString, QQAppInterface paramQQAppInterface)
  {
    bool3 = false;
    boolean bool4 = true;
    String str2 = SharedPreUtils.s(paramQQAppInterface.getApp().getBaseContext());
    localObject2 = null;
    String str1 = null;
    localObject1 = localObject2;
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      localObject1 = localObject2;
      if (localJSONObject.has("version"))
      {
        localObject1 = localObject2;
        str1 = localJSONObject.getString("version");
      }
      bool1 = bool3;
      bool2 = bool4;
      localObject2 = str1;
      localObject1 = str1;
      if (localJSONObject.has("isShow"))
      {
        localObject1 = str1;
        bool1 = "1".equals(localJSONObject.getString("isShow"));
        localObject2 = str1;
        bool2 = bool4;
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
        QLog.e("ScribbleResMgr", 2, "RESOURCE_CONFIG_TASK_ID_Gif JSON EXCEPT");
        boolean bool2 = false;
        boolean bool1 = bool3;
        localObject2 = localObject1;
      }
    }
    if ((str2 == null) || (!str2.equalsIgnoreCase(localObject2)))
    {
      SharedPreUtils.D(paramQQAppInterface.getApp().getBaseContext(), localObject2);
      SharedPreUtils.E(paramQQAppInterface.getApp().getBaseContext(), paramString);
    }
    this.jdField_d_of_type_Boolean = bool1;
    if (QLog.isColorLevel()) {
      QLog.i("ScribbleResMgr", 2, "handleGetSwitchConfig isShow:" + bool1 + " config:" + paramString);
    }
    return bool2;
  }
  
  public boolean a(String paramString, QQAppInterface paramQQAppInterface, int paramInt)
  {
    boolean bool = true;
    if (paramInt == 2598) {
      bool = a(paramQQAppInterface, paramString);
    }
    if (paramInt == 2599) {
      bool = b(paramQQAppInterface, paramString);
    }
    if (!bool) {
      c();
    }
    return bool;
  }
  
  public String b(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 1) {
      return jdField_b_of_type_JavaLangString + "line_orig_" + String.valueOf(paramInt2) + ".png";
    }
    if (paramInt1 == 2) {
      return c(paramInt2);
    }
    return null;
  }
  
  public ArrayList b()
  {
    return this.jdField_b_of_type_JavaUtilArrayList;
  }
  
  public void b()
  {
    c();
    a();
    QLog.e("ScribbleResMgr", 2, "onGetConfigFailed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.scribble.ScribbleResMgr
 * JD-Core Version:    0.7.0.1
 */