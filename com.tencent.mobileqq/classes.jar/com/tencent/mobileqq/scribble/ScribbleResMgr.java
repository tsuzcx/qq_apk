package com.tencent.mobileqq.scribble;

import alof;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import aozj;
import atgx;
import aygo;
import aygp;
import aygs;
import aygt;
import bbaa;
import bbab;
import bdne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
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
  private final ArrayList<aygs> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private Lock jdField_a_of_type_JavaUtilConcurrentLocksLock = new ReentrantLock();
  public boolean a;
  private final Handler jdField_b_of_type_AndroidOsHandler = new aygo(this, Looper.getMainLooper());
  private ArrayList<ScribbleResMgr.ResInfo> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_b_of_type_Boolean;
  private ArrayList<ScribbleResMgr.ResInfo> jdField_c_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  private boolean e;
  private String f = "";
  private String g = "";
  private String h = "";
  private String i = "";
  
  static
  {
    jdField_a_of_type_JavaLangString = alof.cm + "Config/";
    jdField_b_of_type_JavaLangString = alof.cm + "Config/paint/";
    jdField_c_of_type_JavaLangString = alof.cm + "Config/gif/";
    jdField_d_of_type_JavaLangString = alof.cm + "Config/line_icon/";
    jdField_e_of_type_JavaLangString = alof.cm + "Config/gif_icon/";
    jdField_a_of_type_JavaLangLong = Long.valueOf(30000L);
  }
  
  public ScribbleResMgr()
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
    this.jdField_e_of_type_Boolean = true;
  }
  
  public static ScribbleResMgr a()
  {
    if (jdField_a_of_type_ComTencentMobileqqScribbleScribbleResMgr != null) {
      return jdField_a_of_type_ComTencentMobileqqScribbleScribbleResMgr;
    }
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_ComTencentMobileqqScribbleScribbleResMgr != null)
      {
        ScribbleResMgr localScribbleResMgr1 = jdField_a_of_type_ComTencentMobileqqScribbleScribbleResMgr;
        return localScribbleResMgr1;
      }
    }
    jdField_a_of_type_ComTencentMobileqqScribbleScribbleResMgr = new ScribbleResMgr();
    ScribbleResMgr localScribbleResMgr2 = jdField_a_of_type_ComTencentMobileqqScribbleScribbleResMgr;
    return localScribbleResMgr2;
  }
  
  private String a()
  {
    return alof.cm + "paint_icon";
  }
  
  public static String a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 1) {
      return jdField_d_of_type_JavaLangString + "line_icon_" + String.valueOf(paramInt2) + ".png";
    }
    if (paramInt1 == 2) {
      return jdField_e_of_type_JavaLangString + "gif_icon_" + String.valueOf(paramInt2) + ".png";
    }
    return null;
  }
  
  private ArrayList<ScribbleResMgr.ResInfo> a()
  {
    ArrayList localArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    try
    {
      if ((this.jdField_c_of_type_JavaUtilArrayList != null) && (this.jdField_c_of_type_JavaUtilArrayList.size() > 0))
      {
        Iterator localIterator = this.jdField_c_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          ScribbleResMgr.ResInfo localResInfo = (ScribbleResMgr.ResInfo)localIterator.next();
          if (localResInfo != null) {
            localArrayList.add(localResInfo.cpy(localResInfo));
          }
        }
      }
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
    return localArrayList1;
  }
  
  public static ArrayList<ScribbleResMgr.ResInfo> a(JSONArray paramJSONArray, int paramInt)
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
        ScribbleResMgr.ResInfo localResInfo = (ScribbleResMgr.ResInfo)atgx.a(paramJSONArray.getJSONObject(j), ScribbleResMgr.ResInfo.class);
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
  private void a(int paramInt1, int paramInt2, View paramView, aygt paramaygt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 107	com/tencent/mobileqq/scribble/ScribbleResMgr:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   6: invokevirtual 165	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   9: astore 5
    //   11: aload 5
    //   13: invokeinterface 171 1 0
    //   18: ifeq +41 -> 59
    //   21: aload 5
    //   23: invokeinterface 175 1 0
    //   28: checkcast 237	aygs
    //   31: astore 6
    //   33: aload 6
    //   35: invokevirtual 240	aygs:a	()Landroid/view/View;
    //   38: aload_3
    //   39: if_acmpne -28 -> 11
    //   42: aload 6
    //   44: new 242	java/lang/ref/WeakReference
    //   47: dup
    //   48: aload 4
    //   50: invokespecial 245	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   53: putfield 248	aygs:b	Ljava/lang/ref/WeakReference;
    //   56: aload_0
    //   57: monitorexit
    //   58: return
    //   59: aload_0
    //   60: getfield 107	com/tencent/mobileqq/scribble/ScribbleResMgr:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   63: new 237	aygs
    //   66: dup
    //   67: aload_0
    //   68: iload_1
    //   69: iload_2
    //   70: aload_3
    //   71: aload 4
    //   73: invokespecial 251	aygs:<init>	(Lcom/tencent/mobileqq/scribble/ScribbleResMgr;IILandroid/view/View;Laygt;)V
    //   76: invokevirtual 185	java/util/ArrayList:add	(Ljava/lang/Object;)Z
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
    //   0	88	4	paramaygt	aygt
    //   9	13	5	localIterator	Iterator
    //   31	12	6	localaygs	aygs
    // Exception table:
    //   from	to	target	type
    //   2	11	83	finally
    //   11	56	83	finally
    //   59	80	83	finally
  }
  
  private void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramInt1 == 3) {
      this.jdField_c_of_type_Boolean = paramBoolean;
    }
    if (paramInt1 == 4) {
      this.jdField_b_of_type_Boolean = paramBoolean;
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
  
  public static void a(Context paramContext, String paramString)
  {
    QLog.d("ScribbleResMgr", 2, "setScribbleRedShowed false");
    bdne.a(paramContext, Boolean.valueOf(false), paramString);
  }
  
  private void a(QQAppInterface paramQQAppInterface)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      long l1 = System.currentTimeMillis();
      QLog.i("ScribbleResMgr", 2, "init=======================timenow:" + l1);
      String str = bdne.o(paramQQAppInterface.getApp().getApplicationContext());
      paramQQAppInterface = bdne.n(paramQQAppInterface.getApp().getApplicationContext());
      if (!TextUtils.isEmpty(str)) {
        a(str);
      }
      if (!TextUtils.isEmpty(paramQQAppInterface)) {
        b(paramQQAppInterface);
      }
      this.jdField_a_of_type_Boolean = true;
      long l2 = System.currentTimeMillis();
      QLog.i("ScribbleResMgr", 2, "init=======================timenow:" + l2);
      QLog.i("ScribbleResMgr", 2, "init==========================timedec:" + (l2 - l1));
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2)
  {
    int n = 0;
    a(paramQQAppInterface);
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
            break label140;
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
          break label167;
        }
        j = 1;
      }
      k = j;
      if (paramInt1 == 2)
      {
        if (!this.jdField_b_of_type_JavaUtilArrayList.isEmpty()) {
          break label277;
        }
        k = 1;
      }
      if ((k != 0) && (!this.jdField_d_of_type_Boolean))
      {
        this.jdField_d_of_type_Boolean = true;
        aozj.g(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin());
      }
      return;
      if (!this.jdField_c_of_type_Boolean) {
        a(paramQQAppInterface, paramInt1, 50L);
      }
      j = 0;
      break;
      label140:
      k = j;
      if (!this.jdField_b_of_type_Boolean)
      {
        a(paramQQAppInterface, paramInt1, 50L);
        k = j;
      }
    }
    label167:
    Object localObject = a();
    ScribbleResMgr.ResInfo localResInfo;
    int m;
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      localObject = ((ArrayList)localObject).iterator();
      for (;;)
      {
        if ((localObject != null) && (((Iterator)localObject).hasNext()))
        {
          localResInfo = (ScribbleResMgr.ResInfo)((Iterator)localObject).next();
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
    }
    for (;;)
    {
      j = k;
      if (m != 0) {
        break;
      }
      j = 1;
      break;
      label277:
      localObject = b();
      paramInt1 = n;
      long l;
      if (localObject != null)
      {
        paramInt1 = n;
        if (((ArrayList)localObject).size() > 0)
        {
          localObject = ((ArrayList)localObject).iterator();
          do
          {
            paramInt1 = n;
            if (localObject == null) {
              break;
            }
            paramInt1 = n;
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            localResInfo = (ScribbleResMgr.ResInfo)((Iterator)localObject).next();
          } while ((localResInfo == null) || (localResInfo.sourceId != paramInt2));
          if (localResInfo.downloading) {
            break label464;
          }
          localResInfo.downloading = true;
          l = Thread.currentThread().getId();
          QLog.i("ScribbleResMgr", 2, "RESOURCE_TYPE_GIF threadId: " + l + " inf.resType:  " + localResInfo.resType + " resID: " + localResInfo.sourceId + " downloading is false set true");
          a(paramQQAppInterface, localResInfo, 0L, false);
        }
      }
      for (paramInt1 = 1;; paramInt1 = 1)
      {
        k = j;
        if (paramInt1 != 0) {
          break;
        }
        k = 1;
        break;
        label464:
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
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new ScribbleResMgr.5(this, paramInt, paramQQAppInterface), paramLong);
  }
  
  private void a(QQAppInterface paramQQAppInterface, ScribbleResMgr.ResInfo paramResInfo, long paramLong, boolean paramBoolean)
  {
    if (paramResInfo == null) {
      return;
    }
    ScribbleResMgr.4 local4 = new ScribbleResMgr.4(this, paramResInfo);
    bbaa localbbaa;
    String str;
    if (paramBoolean)
    {
      localbbaa = (bbaa)paramQQAppInterface.getManager(193);
      if (localbbaa.a())
      {
        str = null;
        if (paramResInfo.resType == 1) {
          str = b(paramResInfo.resType, paramResInfo.sourceId);
        }
        if (paramResInfo.resType != 2) {
          break label337;
        }
        str = d(paramResInfo.sourceId);
      }
    }
    label337:
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ScribbleResMgr", 2, "download res, predownload enable:" + paramResInfo.sourceId + " " + paramResInfo.resType + " outpath:" + str + " url:" + paramResInfo.sourceUrl);
      }
      paramQQAppInterface = new bbab(paramQQAppInterface, "doodle_msg_res", local4, 4000L);
      localbbaa.a(10068, "prd", String.valueOf(paramResInfo.sourceId), 0, paramResInfo.sourceUrl, str, 2, 0, true, paramQQAppInterface);
      return;
      paramQQAppInterface = (bbaa)paramQQAppInterface.getManager(193);
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
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(local4, paramLong);
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
  
  private void a(ArrayList<ScribbleResMgr.ResInfo> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() < 2)) {
      return;
    }
    Collections.sort(paramArrayList, new aygp(this));
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    boolean bool = bdne.p(paramContext, paramString);
    QLog.d("ScribbleResMgr", 2, "getNeedScribbleRedShow" + bool);
    return bool;
  }
  
  private boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    Object localObject2 = null;
    String str = bdne.m(paramQQAppInterface.getApp().getBaseContext());
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        if (localJSONObject.has("version"))
        {
          localObject1 = localJSONObject.getString("version");
          boolean bool;
          Object localObject3;
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
            localObject2 = localJSONObject.getJSONArray("content");
          }
          bool = true;
          localObject2 = a((JSONArray)localObject2, 1);
          c((ArrayList)localObject2);
          if (((str != null) && (str.equalsIgnoreCase((String)localObject1))) || (!bool)) {
            continue;
          }
          QLog.i("ScribbleResMgr", 2, "RESOURCE_CONFIG_TASK_ID_PAINT newVersion = " + (String)localObject1);
          bdne.w(paramQQAppInterface.getApp().getBaseContext(), (String)localObject1);
          bdne.y(paramQQAppInterface.getApp().getBaseContext(), paramString);
          a(paramQQAppInterface, 3, jdField_a_of_type_JavaLangLong.longValue());
          if (((ArrayList)localObject2).isEmpty()) {
            break label389;
          }
          paramString = ((ArrayList)localObject2).iterator();
          if (!paramString.hasNext()) {
            break label389;
          }
          localObject1 = (ScribbleResMgr.ResInfo)paramString.next();
          if (((ScribbleResMgr.ResInfo)localObject1).downloading) {
            continue;
          }
          if ((((ScribbleResMgr.ResInfo)localObject1).predownload != 1) && (!this.jdField_d_of_type_Boolean)) {
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
        localObject3 = null;
        continue;
        QLog.e("ScribbleResMgr", 2, "mArrPaintInfo index :" + ((ScribbleResMgr.ResInfo)localObject1).sourceId + " is downloading ");
        continue;
        QLog.i("ScribbleResMgr", 2, "RESOURCE_CONFIG_TASK_ID_PAINT newVersion = " + (String)localObject1 + " oldVersion=  " + str);
      }
      label389:
      Object localObject1 = null;
    }
  }
  
  private boolean a(String paramString)
  {
    localObject = null;
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      if (localJSONObject.has("iconUrl")) {
        this.f = localJSONObject.getString("iconUrl");
      }
      if (localJSONObject.has("iconMd5")) {
        this.g = localJSONObject.getString("iconMd5");
      }
      paramString = localObject;
      if (localJSONObject.has("content")) {
        paramString = localJSONObject.getJSONArray("content");
      }
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        QLog.e("ScribbleResMgr", 2, "parsePaintConfigInfo JSON EXCEPT");
        paramString = localObject;
      }
    }
    c(a(paramString, 1));
    return true;
  }
  
  /* Error */
  public static boolean a(String paramString1, Context paramContext, String paramString2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 10
    //   3: iconst_0
    //   4: istore 11
    //   6: new 524	org/json/JSONObject
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 525	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   14: astore 12
    //   16: aload 12
    //   18: ldc_w 578
    //   21: invokevirtual 530	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   24: ifeq +625 -> 649
    //   27: aload 12
    //   29: ldc_w 578
    //   32: invokevirtual 534	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   35: invokestatic 583	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   38: invokevirtual 586	java/lang/Integer:intValue	()I
    //   41: istore 6
    //   43: iload 6
    //   45: iconst_1
    //   46: if_icmpne +365 -> 411
    //   49: iconst_1
    //   50: istore 7
    //   52: aload 12
    //   54: ldc_w 588
    //   57: invokevirtual 530	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   60: ifeq +584 -> 644
    //   63: aload 12
    //   65: ldc_w 588
    //   68: invokevirtual 534	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   71: invokestatic 593	java/lang/Float:valueOf	(Ljava/lang/String;)Ljava/lang/Float;
    //   74: invokevirtual 597	java/lang/Float:floatValue	()F
    //   77: fstore_3
    //   78: aload 12
    //   80: ldc_w 599
    //   83: invokevirtual 530	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   86: ifeq +552 -> 638
    //   89: aload 12
    //   91: ldc_w 599
    //   94: invokevirtual 534	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   97: invokestatic 583	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   100: invokevirtual 586	java/lang/Integer:intValue	()I
    //   103: istore 6
    //   105: iload 6
    //   107: iconst_1
    //   108: if_icmpne +309 -> 417
    //   111: iconst_1
    //   112: istore 8
    //   114: aload 12
    //   116: ldc_w 601
    //   119: invokevirtual 530	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   122: ifeq +510 -> 632
    //   125: aload 12
    //   127: ldc_w 601
    //   130: invokevirtual 534	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   133: invokestatic 593	java/lang/Float:valueOf	(Ljava/lang/String;)Ljava/lang/Float;
    //   136: invokevirtual 597	java/lang/Float:floatValue	()F
    //   139: fstore 4
    //   141: iload 11
    //   143: istore 9
    //   145: aload 12
    //   147: ldc_w 603
    //   150: invokevirtual 530	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   153: ifeq +32 -> 185
    //   156: aload 12
    //   158: ldc_w 603
    //   161: invokevirtual 534	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   164: invokestatic 583	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   167: invokevirtual 586	java/lang/Integer:intValue	()I
    //   170: istore 6
    //   172: iload 11
    //   174: istore 9
    //   176: iload 6
    //   178: iconst_1
    //   179: if_icmpne +6 -> 185
    //   182: iconst_1
    //   183: istore 9
    //   185: iconst_1
    //   186: istore 11
    //   188: iload 7
    //   190: istore 10
    //   192: iload 8
    //   194: istore 7
    //   196: fload_3
    //   197: fstore 5
    //   199: fload 4
    //   201: fstore_3
    //   202: aload_1
    //   203: iload 10
    //   205: aload_2
    //   206: invokestatic 606	bdne:b	(Landroid/content/Context;ZLjava/lang/String;)V
    //   209: iload 7
    //   211: ifeq +257 -> 468
    //   214: aload_1
    //   215: aload_2
    //   216: invokestatic 609	bdne:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/Float;
    //   219: invokevirtual 597	java/lang/Float:floatValue	()F
    //   222: fstore 4
    //   224: fload 5
    //   226: fload 4
    //   228: fcmpl
    //   229: ifle +61 -> 290
    //   232: aload_1
    //   233: iload 7
    //   235: invokestatic 272	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   238: aload_2
    //   239: invokestatic 277	bdne:a	(Landroid/content/Context;Ljava/lang/Boolean;Ljava/lang/String;)V
    //   242: aload_1
    //   243: fload 5
    //   245: invokestatic 612	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   248: aload_2
    //   249: invokestatic 615	bdne:a	(Landroid/content/Context;Ljava/lang/Float;Ljava/lang/String;)V
    //   252: ldc 225
    //   254: iconst_2
    //   255: new 27	java/lang/StringBuilder
    //   258: dup
    //   259: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   262: ldc_w 617
    //   265: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: fload 4
    //   270: invokevirtual 620	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   273: ldc_w 622
    //   276: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: fload 5
    //   281: invokevirtual 620	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   284: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   287: invokestatic 293	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   290: iload 9
    //   292: ifeq +216 -> 508
    //   295: aload_1
    //   296: aload_2
    //   297: invokestatic 624	bdne:b	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/Float;
    //   300: invokevirtual 597	java/lang/Float:floatValue	()F
    //   303: fstore 4
    //   305: fload_3
    //   306: fload 4
    //   308: fcmpl
    //   309: ifle +56 -> 365
    //   312: aload_1
    //   313: fload_3
    //   314: invokestatic 612	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   317: aload_2
    //   318: invokestatic 626	bdne:b	(Landroid/content/Context;Ljava/lang/Float;Ljava/lang/String;)V
    //   321: aload_1
    //   322: iload 9
    //   324: aload_2
    //   325: invokestatic 628	bdne:c	(Landroid/content/Context;ZLjava/lang/String;)V
    //   328: ldc 225
    //   330: iconst_2
    //   331: new 27	java/lang/StringBuilder
    //   334: dup
    //   335: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   338: ldc_w 630
    //   341: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: fload 4
    //   346: invokevirtual 620	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   349: ldc_w 632
    //   352: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: fload_3
    //   356: invokevirtual 620	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   359: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   362: invokestatic 293	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   365: invokestatic 401	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   368: ifeq +40 -> 408
    //   371: ldc 225
    //   373: iconst_2
    //   374: new 27	java/lang/StringBuilder
    //   377: dup
    //   378: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   381: ldc_w 634
    //   384: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   387: iload 10
    //   389: invokevirtual 515	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   392: ldc_w 636
    //   395: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: aload_0
    //   399: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   405: invokestatic 293	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   408: iload 11
    //   410: ireturn
    //   411: iconst_0
    //   412: istore 7
    //   414: goto -362 -> 52
    //   417: iconst_0
    //   418: istore 8
    //   420: goto -306 -> 114
    //   423: astore 12
    //   425: fconst_0
    //   426: fstore 4
    //   428: iconst_0
    //   429: istore 7
    //   431: iconst_0
    //   432: istore 8
    //   434: fconst_0
    //   435: fstore_3
    //   436: aload 12
    //   438: invokevirtual 223	org/json/JSONException:printStackTrace	()V
    //   441: ldc 225
    //   443: iconst_2
    //   444: ldc_w 638
    //   447: invokestatic 233	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   450: iconst_0
    //   451: istore 11
    //   453: fload 4
    //   455: fstore 5
    //   457: iload 10
    //   459: istore 9
    //   461: iload 8
    //   463: istore 10
    //   465: goto -263 -> 202
    //   468: ldc 225
    //   470: iconst_2
    //   471: new 27	java/lang/StringBuilder
    //   474: dup
    //   475: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   478: ldc_w 640
    //   481: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   484: iload 7
    //   486: invokevirtual 515	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   489: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   492: invokestatic 293	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   495: aload_1
    //   496: iload 7
    //   498: invokestatic 272	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   501: aload_2
    //   502: invokestatic 277	bdne:a	(Landroid/content/Context;Ljava/lang/Boolean;Ljava/lang/String;)V
    //   505: goto -215 -> 290
    //   508: ldc 225
    //   510: iconst_2
    //   511: new 27	java/lang/StringBuilder
    //   514: dup
    //   515: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   518: ldc_w 642
    //   521: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   524: iload 9
    //   526: invokevirtual 515	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   529: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   532: invokestatic 293	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   535: aload_1
    //   536: iload 9
    //   538: aload_2
    //   539: invokestatic 628	bdne:c	(Landroid/content/Context;ZLjava/lang/String;)V
    //   542: goto -177 -> 365
    //   545: astore 12
    //   547: fconst_0
    //   548: fstore 4
    //   550: iconst_0
    //   551: istore 9
    //   553: iload 7
    //   555: istore 8
    //   557: fconst_0
    //   558: fstore_3
    //   559: iload 9
    //   561: istore 7
    //   563: goto -127 -> 436
    //   566: astore 12
    //   568: fload_3
    //   569: fstore 4
    //   571: iload 7
    //   573: istore 8
    //   575: iconst_0
    //   576: istore 7
    //   578: fconst_0
    //   579: fstore_3
    //   580: goto -144 -> 436
    //   583: astore 12
    //   585: fload_3
    //   586: fstore 4
    //   588: iload 7
    //   590: istore 9
    //   592: fconst_0
    //   593: fstore_3
    //   594: iload 8
    //   596: istore 7
    //   598: iload 9
    //   600: istore 8
    //   602: goto -166 -> 436
    //   605: astore 12
    //   607: fload_3
    //   608: fstore 5
    //   610: iload 7
    //   612: istore 9
    //   614: fload 4
    //   616: fstore_3
    //   617: fload 5
    //   619: fstore 4
    //   621: iload 8
    //   623: istore 7
    //   625: iload 9
    //   627: istore 8
    //   629: goto -193 -> 436
    //   632: fconst_0
    //   633: fstore 4
    //   635: goto -494 -> 141
    //   638: iconst_0
    //   639: istore 8
    //   641: goto -527 -> 114
    //   644: fconst_0
    //   645: fstore_3
    //   646: goto -568 -> 78
    //   649: iconst_0
    //   650: istore 7
    //   652: goto -600 -> 52
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	655	0	paramString1	String
    //   0	655	1	paramContext	Context
    //   0	655	2	paramString2	String
    //   77	569	3	f1	float
    //   139	495	4	f2	float
    //   197	421	5	f3	float
    //   41	139	6	j	int
    //   50	601	7	bool1	boolean
    //   112	528	8	bool2	boolean
    //   143	483	9	bool3	boolean
    //   1	463	10	bool4	boolean
    //   4	448	11	bool5	boolean
    //   14	143	12	localJSONObject	JSONObject
    //   423	14	12	localJSONException1	JSONException
    //   545	1	12	localJSONException2	JSONException
    //   566	1	12	localJSONException3	JSONException
    //   583	1	12	localJSONException4	JSONException
    //   605	1	12	localJSONException5	JSONException
    // Exception table:
    //   from	to	target	type
    //   6	43	423	org/json/JSONException
    //   52	78	545	org/json/JSONException
    //   78	105	566	org/json/JSONException
    //   114	141	583	org/json/JSONException
    //   145	172	605	org/json/JSONException
  }
  
  private String b()
  {
    return alof.cm + "gif_icon";
  }
  
  public static String b(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 1) {
      return jdField_b_of_type_JavaLangString + "line_orig_" + String.valueOf(paramInt2) + ".png";
    }
    if (paramInt1 == 2) {
      return e(paramInt2);
    }
    return null;
  }
  
  private ArrayList<ScribbleResMgr.ResInfo> b()
  {
    ArrayList localArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    try
    {
      if ((this.jdField_b_of_type_JavaUtilArrayList != null) && (this.jdField_b_of_type_JavaUtilArrayList.size() > 0))
      {
        Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          ScribbleResMgr.ResInfo localResInfo = (ScribbleResMgr.ResInfo)localIterator.next();
          if (localResInfo != null) {
            localArrayList.add(localResInfo.cpy(localResInfo));
          }
        }
      }
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
    return localArrayList1;
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
  
  public static void b(Context paramContext, String paramString)
  {
    bdne.c(paramContext, false, paramString);
    QLog.d("ScribbleResMgr", 2, "setScribblePlusRedShowed false");
  }
  
  private void b(ArrayList<ScribbleResMgr.ResInfo> paramArrayList)
  {
    if ((paramArrayList != null) && (!paramArrayList.isEmpty())) {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    }
    try
    {
      this.jdField_b_of_type_JavaUtilArrayList.clear();
      this.jdField_b_of_type_JavaUtilArrayList.addAll(paramArrayList);
      a(this.jdField_b_of_type_JavaUtilArrayList);
      return;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
  }
  
  public static boolean b(Context paramContext, String paramString)
  {
    boolean bool1 = c(paramContext, paramString);
    boolean bool2 = bdne.q(paramContext, paramString);
    QLog.d("ScribbleResMgr", 2, "getNeedScribblePlusRedShow" + bool2);
    return (bool2) && (bool1);
  }
  
  private boolean b(QQAppInterface paramQQAppInterface, String paramString)
  {
    Object localObject2 = null;
    String str = bdne.l(paramQQAppInterface.getApp().getBaseContext());
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        if (localJSONObject.has("version"))
        {
          localObject1 = localJSONObject.getString("version");
          boolean bool;
          Object localObject3;
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
            localObject2 = localJSONObject.getJSONArray("content");
          }
          bool = true;
          localObject2 = a((JSONArray)localObject2, 2);
          b((ArrayList)localObject2);
          if (((str != null) && (str.equalsIgnoreCase((String)localObject1))) || (!bool)) {
            continue;
          }
          QLog.i("ScribbleResMgr", 2, "RESOURCE_CONFIG_TASK_ID_GIF newVersion = " + (String)localObject1);
          bdne.v(paramQQAppInterface.getApp().getBaseContext(), (String)localObject1);
          bdne.x(paramQQAppInterface.getApp().getBaseContext(), paramString);
          a(paramQQAppInterface, 4, jdField_a_of_type_JavaLangLong.longValue());
          if (((ArrayList)localObject2).isEmpty()) {
            break label393;
          }
          paramString = ((ArrayList)localObject2).iterator();
          if ((paramString == null) || (!paramString.hasNext())) {
            break label393;
          }
          localObject1 = (ScribbleResMgr.ResInfo)paramString.next();
          if (((ScribbleResMgr.ResInfo)localObject1).downloading) {
            continue;
          }
          if ((((ScribbleResMgr.ResInfo)localObject1).predownload != 1) && (!this.jdField_d_of_type_Boolean)) {
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
        localObject3 = null;
        continue;
        QLog.e("ScribbleResMgr", 2, "mArrGifInfo index :" + ((ScribbleResMgr.ResInfo)localObject1).sourceId + " is downloading ");
        continue;
        QLog.i("ScribbleResMgr", 2, "RESOURCE_CONFIG_TASK_ID_GIF newVersion = " + (String)localObject1 + " oldVersion=  " + str);
      }
      label393:
      Object localObject1 = null;
    }
  }
  
  private boolean b(String paramString)
  {
    localObject = null;
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      if (localJSONObject.has("iconUrl")) {
        this.h = localJSONObject.getString("iconUrl");
      }
      if (localJSONObject.has("iconMd5")) {
        this.i = localJSONObject.getString("iconMd5");
      }
      paramString = localObject;
      if (localJSONObject.has("content")) {
        paramString = localJSONObject.getJSONArray("content");
      }
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        QLog.e("ScribbleResMgr", 2, "RESOURCE_CONFIG_TASK_ID_Gif JSON EXCEPT");
        paramString = localObject;
      }
    }
    b(a(paramString, 2));
    return true;
  }
  
  private static String c(int paramInt)
  {
    return jdField_c_of_type_JavaLangString + "gif_zip_tmp" + String.valueOf(paramInt) + "/";
  }
  
  private void c()
  {
    Message localMessage = new Message();
    localMessage.what = 3;
    localMessage.obj = null;
    localMessage.arg1 = 0;
    this.jdField_b_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, 0L);
  }
  
  private void c(ArrayList<ScribbleResMgr.ResInfo> paramArrayList)
  {
    if ((paramArrayList != null) && (!paramArrayList.isEmpty())) {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    }
    try
    {
      this.jdField_c_of_type_JavaUtilArrayList.clear();
      this.jdField_c_of_type_JavaUtilArrayList.addAll(paramArrayList);
      a(this.jdField_c_of_type_JavaUtilArrayList);
      return;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
  }
  
  public static boolean c(Context paramContext, String paramString)
  {
    boolean bool = bdne.o(paramContext, paramString);
    QLog.d("ScribbleResMgr", 2, "canShowEnter" + bool);
    return bool;
  }
  
  private static String d(int paramInt)
  {
    return c(paramInt) + "gif_zip_tmp" + String.valueOf(paramInt);
  }
  
  private static String e(int paramInt)
  {
    return c(paramInt) + "gif_orig_" + String.valueOf(paramInt) + ".gif";
  }
  
  public ArrayList<Integer> a(QQAppInterface paramQQAppInterface)
  {
    a(paramQQAppInterface);
    paramQQAppInterface = new ArrayList();
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    try
    {
      if ((this.jdField_c_of_type_JavaUtilArrayList != null) && (this.jdField_c_of_type_JavaUtilArrayList.size() > 0))
      {
        Iterator localIterator = this.jdField_c_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          ScribbleResMgr.ResInfo localResInfo = (ScribbleResMgr.ResInfo)localIterator.next();
          if ((localResInfo.resType == 1) && (localResInfo.isShow == 1) && ((localResInfo.showInApp & 0x2) > 0)) {
            paramQQAppInterface.add(Integer.valueOf(localResInfo.sourceId));
          }
        }
      }
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
    return paramQQAppInterface;
  }
  
  public void a()
  {
    this.jdField_d_of_type_Boolean = false;
    QLog.d("ScribbleResMgr", 2, "setGetConfigFinished");
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, View paramView, aygt paramaygt)
  {
    a(paramInt1, paramInt2, paramView, paramaygt);
    paramQQAppInterface = new ScribbleResMgr.2(this, paramQQAppInterface, paramInt1, paramInt2);
    this.jdField_a_of_type_AndroidOsHandler.post(paramQQAppInterface);
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
  
  public ArrayList<Integer> b(QQAppInterface paramQQAppInterface)
  {
    a(paramQQAppInterface);
    paramQQAppInterface = new ArrayList();
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    try
    {
      if ((this.jdField_b_of_type_JavaUtilArrayList != null) && (this.jdField_b_of_type_JavaUtilArrayList.size() > 0))
      {
        Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          ScribbleResMgr.ResInfo localResInfo = (ScribbleResMgr.ResInfo)localIterator.next();
          if ((localResInfo.resType == 2) && (localResInfo.isShow == 1) && ((localResInfo.showInApp & 0x2) > 0)) {
            paramQQAppInterface.add(Integer.valueOf(localResInfo.sourceId));
          }
        }
      }
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
    return paramQQAppInterface;
  }
  
  public void b()
  {
    c();
    a();
    QLog.e("ScribbleResMgr", 2, "onGetConfigFailed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.scribble.ScribbleResMgr
 * JD-Core Version:    0.7.0.1
 */