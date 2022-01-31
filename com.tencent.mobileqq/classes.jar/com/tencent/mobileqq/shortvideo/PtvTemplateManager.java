package com.tencent.mobileqq.shortvideo;

import ahyl;
import ahym;
import ahyn;
import ahyo;
import ahyp;
import ahyq;
import ahyr;
import ahyt;
import ahyu;
import ahyv;
import ahyw;
import ahyx;
import ahyy;
import ahza;
import ahzb;
import ahzc;
import ahzd;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraCompatibleList;
import com.tencent.mobileqq.shortvideo.ptvfilter.material.QQVideoMaterial;
import com.tencent.mobileqq.shortvideo.ptvfilter.material.TemplateParser;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask;
import com.tencent.mobileqq.transfile.predownload.PreDownloadController;
import com.tencent.mobileqq.transfile.predownload.RunnableTask;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class PtvTemplateManager
{
  static PtvTemplateManager jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager;
  public static File a;
  public static final Long a;
  static Object jdField_a_of_type_JavaLangObject;
  public static String a;
  public static boolean a;
  public static File b;
  public static String b;
  public static String c;
  public static String g;
  private static boolean g;
  public static String h;
  public static String i;
  protected static final String j;
  public PtvTemplateManager.IPtvTemplateUpdateListener a;
  public PtvTemplateManager.PtvTemplateInfo a;
  public ArrayList a;
  public Object b;
  public ArrayList b;
  public boolean b;
  public Object c;
  public ArrayList c;
  public boolean c;
  public Object d;
  String d;
  public ArrayList d;
  public boolean d;
  String e;
  public ArrayList e;
  public boolean e;
  public String f;
  public boolean f;
  
  static
  {
    jdField_a_of_type_JavaLangLong = Long.valueOf(60000L);
    jdField_a_of_type_JavaLangString = "ptv_template_usable";
    jdField_b_of_type_JavaLangString = "ptv_debug";
    jdField_c_of_type_JavaLangString = "ptv_template_usable_doodle";
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_g_of_type_JavaLangString = "5";
    h = "200";
    i = "20";
    j = AppConstants.aJ + "qav" + File.separator;
    int k = 0;
    try
    {
      boolean bool = "mounted".equals(Environment.getExternalStorageState());
      k = bool;
    }
    catch (Exception localException)
    {
      label92:
      File localFile;
      break label92;
    }
    if (k != 0) {}
    for (localFile = new File(AppConstants.aJ);; localFile = BaseApplicationImpl.getApplication().getCacheDir())
    {
      jdField_a_of_type_JavaIoFile = new File(localFile, "ptv_template");
      jdField_a_of_type_JavaLangString = jdField_a_of_type_JavaIoFile.getPath() + File.separator + jdField_a_of_type_JavaLangString + File.separator;
      jdField_b_of_type_JavaLangString = jdField_a_of_type_JavaIoFile.getPath() + File.separator + jdField_b_of_type_JavaLangString;
      jdField_b_of_type_JavaIoFile = new File(localFile, "doodle_template");
      jdField_c_of_type_JavaLangString = jdField_b_of_type_JavaIoFile.getPath() + File.separator + jdField_c_of_type_JavaLangString + File.separator;
      jdField_g_of_type_Boolean = CameraCompatibleList.b(CameraCompatibleList.E);
      return;
    }
  }
  
  private PtvTemplateManager(AppInterface paramAppInterface)
  {
    this.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_d_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaLangObject = new Object();
    this.jdField_c_of_type_JavaLangObject = new Object();
    this.jdField_d_of_type_JavaLangObject = new Object();
    this.jdField_e_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    a(paramAppInterface);
    b(paramAppInterface);
    a(paramAppInterface, null, false);
    c(paramAppInterface);
  }
  
  /* Error */
  public static PtvTemplateManager.PtvTemplateInfo a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 180	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: new 182	org/json/JSONObject
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 183	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   17: astore_0
    //   18: aload_0
    //   19: ldc 185
    //   21: invokestatic 190	com/tencent/mobileqq/util/JSONUtils:a	(Lorg/json/JSONObject;Ljava/lang/Class;)Ljava/lang/Object;
    //   24: checkcast 185	com/tencent/mobileqq/shortvideo/PtvTemplateManager$PtvTemplateInfo
    //   27: astore_3
    //   28: aload_0
    //   29: ldc 192
    //   31: invokevirtual 195	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   34: ifeq +165 -> 199
    //   37: aload_0
    //   38: ldc 192
    //   40: invokevirtual 199	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   43: astore_0
    //   44: aload_3
    //   45: astore 4
    //   47: aload_0
    //   48: astore_3
    //   49: aload 4
    //   51: astore_0
    //   52: aload_3
    //   53: ifnull -46 -> 7
    //   56: aload_0
    //   57: ifnull -50 -> 7
    //   60: aload_3
    //   61: invokevirtual 205	org/json/JSONArray:length	()I
    //   64: istore_2
    //   65: iload_2
    //   66: ifle -59 -> 7
    //   69: aload_0
    //   70: new 145	java/util/ArrayList
    //   73: dup
    //   74: iload_2
    //   75: invokespecial 208	java/util/ArrayList:<init>	(I)V
    //   78: putfield 211	com/tencent/mobileqq/shortvideo/PtvTemplateManager$PtvTemplateInfo:doodleInfos	Ljava/util/ArrayList;
    //   81: iconst_0
    //   82: istore_1
    //   83: iload_1
    //   84: iload_2
    //   85: if_icmpge +71 -> 156
    //   88: aload_3
    //   89: iload_1
    //   90: invokevirtual 215	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   93: ldc 217
    //   95: invokestatic 190	com/tencent/mobileqq/util/JSONUtils:a	(Lorg/json/JSONObject;Ljava/lang/Class;)Ljava/lang/Object;
    //   98: checkcast 217	com/tencent/mobileqq/shortvideo/PtvTemplateManager$DoodleInfo
    //   101: astore 4
    //   103: aload 4
    //   105: ifnull +13 -> 118
    //   108: aload_0
    //   109: getfield 211	com/tencent/mobileqq/shortvideo/PtvTemplateManager$PtvTemplateInfo:doodleInfos	Ljava/util/ArrayList;
    //   112: aload 4
    //   114: invokevirtual 220	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   117: pop
    //   118: iload_1
    //   119: iconst_1
    //   120: iadd
    //   121: istore_1
    //   122: goto -39 -> 83
    //   125: astore_3
    //   126: aconst_null
    //   127: astore_0
    //   128: invokestatic 226	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   131: ifeq +7 -> 138
    //   134: aload_3
    //   135: invokevirtual 229	org/json/JSONException:printStackTrace	()V
    //   138: aconst_null
    //   139: astore_3
    //   140: goto -88 -> 52
    //   143: astore_0
    //   144: invokestatic 232	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   147: ifeq -140 -> 7
    //   150: aload_0
    //   151: invokevirtual 229	org/json/JSONException:printStackTrace	()V
    //   154: aconst_null
    //   155: areturn
    //   156: invokestatic 226	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   159: ifeq +28 -> 187
    //   162: ldc 234
    //   164: iconst_2
    //   165: new 68	java/lang/StringBuilder
    //   168: dup
    //   169: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   172: ldc 236
    //   174: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: aload_0
    //   178: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   181: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   184: invokestatic 242	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   187: aload_0
    //   188: areturn
    //   189: astore 4
    //   191: aload_3
    //   192: astore_0
    //   193: aload 4
    //   195: astore_3
    //   196: goto -68 -> 128
    //   199: aconst_null
    //   200: astore_0
    //   201: goto -157 -> 44
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	204	0	paramString	String
    //   82	40	1	k	int
    //   64	22	2	m	int
    //   27	62	3	localObject1	Object
    //   125	10	3	localJSONException1	JSONException
    //   139	57	3	localObject2	Object
    //   45	68	4	localObject3	Object
    //   189	5	4	localJSONException2	JSONException
    // Exception table:
    //   from	to	target	type
    //   9	28	125	org/json/JSONException
    //   60	65	143	org/json/JSONException
    //   69	81	143	org/json/JSONException
    //   88	103	143	org/json/JSONException
    //   108	118	143	org/json/JSONException
    //   28	44	189	org/json/JSONException
  }
  
  public static PtvTemplateManager a(AppInterface paramAppInterface)
  {
    if (jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager != null) {
      return jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager;
    }
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager != null)
      {
        paramAppInterface = jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager;
        return paramAppInterface;
      }
    }
    jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager = new PtvTemplateManager(paramAppInterface);
    paramAppInterface = jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager;
    return paramAppInterface;
  }
  
  protected static String a(int paramInt)
  {
    return j + String.valueOf(paramInt) + File.separator;
  }
  
  public static String a(File paramFile)
  {
    paramFile = FileUtils.a(paramFile);
    if ((paramFile == null) || (paramFile.length <= 0)) {
      return null;
    }
    if (Build.VERSION.SDK_INT <= 8) {
      return new String(paramFile);
    }
    try
    {
      paramFile = new String(paramFile, "UTF-8");
      return paramFile;
    }
    catch (UnsupportedEncodingException paramFile)
    {
      if (QLog.isDevelopLevel()) {
        paramFile.printStackTrace();
      }
    }
    return null;
  }
  
  public static List a(PtvTemplateManager paramPtvTemplateManager, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PtvTemplateManager", 2, "parse config: " + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return null;
      try
      {
        localJSONObject = new JSONObject(paramString);
        if (localJSONObject.has("content"))
        {
          paramString = localJSONObject.getJSONArray("content");
          if (paramPtvTemplateManager == null) {}
        }
      }
      catch (JSONException localJSONException1)
      {
        for (;;)
        {
          try
          {
            JSONObject localJSONObject;
            if (localJSONObject.has("guide_video_url")) {
              paramPtvTemplateManager.jdField_d_of_type_JavaLangString = localJSONObject.getString("guide_video_url");
            }
            if (localJSONObject.has("guide_video_md5")) {
              paramPtvTemplateManager.jdField_e_of_type_JavaLangString = localJSONObject.getString("guide_video_md5");
            }
            if (localJSONObject.has("version")) {
              paramPtvTemplateManager.jdField_f_of_type_JavaLangString = localJSONObject.getString("version");
            }
            if (localJSONObject.has("gestureGapFrame")) {
              jdField_g_of_type_JavaLangString = localJSONObject.getString("gestureGapFrame");
            }
            if (localJSONObject.has("gestureGapTime")) {
              h = localJSONObject.getString("gestureGapTime");
            }
            if (localJSONObject.has("gesturethreadcoldtime")) {
              i = localJSONObject.getString("gesturethreadcoldtime");
            }
            paramPtvTemplateManager = paramString;
            if (localJSONObject.has("gestureShouldUpload"))
            {
              jdField_a_of_type_Boolean = localJSONObject.getBoolean("gestureShouldUpload");
              paramPtvTemplateManager = paramString;
            }
            if (paramPtvTemplateManager == null) {
              break;
            }
            paramPtvTemplateManager = PtvTemplateManager.PtvTemplateInfo.convertFrom(paramPtvTemplateManager);
            if ((paramPtvTemplateManager == null) || (paramPtvTemplateManager.isEmpty())) {
              break;
            }
            return paramPtvTemplateManager;
          }
          catch (JSONException localJSONException2)
          {
            continue;
          }
          localJSONException1 = localJSONException1;
          paramString = null;
          paramPtvTemplateManager = paramString;
          if (QLog.isColorLevel())
          {
            localJSONException1.printStackTrace();
            paramPtvTemplateManager = paramString;
            continue;
            paramString = null;
          }
        }
      }
    }
  }
  
  static void a(String paramString1, String paramString2)
  {
    ThreadManager.getFileThreadHandler().post(new ahyv(paramString2, paramString1));
  }
  
  public static boolean a()
  {
    return new File(jdField_a_of_type_JavaIoFile, "ptv_template_new.cfg").exists();
  }
  
  public static void b()
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager != null) {
        jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager = null;
      }
      return;
    }
  }
  
  public static boolean b()
  {
    return new File(jdField_a_of_type_JavaIoFile, "ptv_template_web.cfg").exists();
  }
  
  public static boolean c()
  {
    return new File(jdField_b_of_type_JavaIoFile, "doodle_template_new.cfg").exists();
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$IPtvTemplateUpdateListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$IPtvTemplateUpdateListener.i();
    }
  }
  
  public static boolean d()
  {
    return new File(jdField_a_of_type_JavaIoFile, "ptv_template_bless.cfg").exists();
  }
  
  public ArrayList a()
  {
    return this.jdField_c_of_type_JavaUtilArrayList;
  }
  
  public ArrayList a(PtvTemplateManager.DoodleInfo paramDoodleInfo)
  {
    if ((paramDoodleInfo == null) || (!paramDoodleInfo.doodleUsable)) {
      if (QLog.isColorLevel()) {
        QLog.d("Doodle_Strokes_PtvTemplateManager", 2, "getDoodleIcons|doodle Usable" + paramDoodleInfo);
      }
    }
    label321:
    do
    {
      do
      {
        do
        {
          ArrayList localArrayList;
          Object localObject;
          do
          {
            return null;
            localArrayList = new ArrayList();
            localObject = jdField_c_of_type_JavaLangString + paramDoodleInfo.doodleName + File.separator;
            if (new File((String)localObject, "params.json").exists()) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.d("Doodle_Strokes_PtvTemplateManager", 2, "getDoodleIcons|paramFile is not exist:" + paramDoodleInfo.doodleName);
          return null;
          Bitmap localBitmap = BitmapManager.a((String)localObject + "ball.png");
          if (localBitmap != null)
          {
            localArrayList.add(localBitmap);
            localBitmap = BitmapManager.a((String)localObject + "bubble.png");
            if (localBitmap == null) {
              break;
            }
            localArrayList.add(localBitmap);
            localObject = BitmapManager.a((String)localObject + "preview.png");
            if (localObject == null) {
              break label321;
            }
            localArrayList.add(localObject);
            return localArrayList;
          }
        } while (!QLog.isColorLevel());
        QLog.d("Doodle_Strokes_PtvTemplateManager", 2, "getDoodleIcons|ball is not exist:" + paramDoodleInfo.doodleName);
        return null;
      } while (!QLog.isColorLevel());
      QLog.d("Doodle_Strokes_PtvTemplateManager", 2, "getDoodleIcons|bubble is not exist:" + paramDoodleInfo.doodleName);
      return null;
    } while (!QLog.isColorLevel());
    QLog.d("Doodle_Strokes_PtvTemplateManager", 2, "getDoodleIcons|preview is not exist:" + paramDoodleInfo.doodleName);
    return null;
  }
  
  public ArrayList a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramBoolean2) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.doodleInfos != null) && (!this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.doodleInfos.isEmpty()))
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.usable = true;
      localArrayList.add(0, this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo);
    }
    Object localObject2;
    if (paramInt == 1) {
      localObject2 = this.jdField_a_of_type_JavaUtilArrayList;
    }
    for (Object localObject1 = this.jdField_b_of_type_JavaLangObject; paramBoolean1; localObject1 = this.jdField_c_of_type_JavaLangObject)
    {
      localArrayList.addAll((Collection)localObject2);
      return localArrayList;
      localObject2 = this.jdField_b_of_type_JavaUtilArrayList;
    }
    try
    {
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)((Iterator)localObject2).next();
        if (localPtvTemplateInfo != null)
        {
          if ((localPtvTemplateInfo.usable) && (!new File(jdField_a_of_type_JavaIoFile, localPtvTemplateInfo.name).exists())) {
            localPtvTemplateInfo.usable = false;
          }
          if ((!localPtvTemplateInfo.predownload) || (localPtvTemplateInfo.usable)) {
            localArrayList.add(localPtvTemplateInfo);
          }
        }
      }
    }
    finally {}
    return localArrayList;
  }
  
  public List a()
  {
    if ((this.jdField_d_of_type_JavaUtilArrayList.isEmpty()) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo != null)) {
      synchronized (this.jdField_d_of_type_JavaLangObject)
      {
        Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.doodleInfos.iterator();
        while (localIterator.hasNext())
        {
          Object localObject3 = (PtvTemplateManager.DoodleInfo)localIterator.next();
          if (((PtvTemplateManager.DoodleInfo)localObject3).doodleUsable)
          {
            localObject3 = jdField_c_of_type_JavaLangString + ((PtvTemplateManager.DoodleInfo)localObject3).doodleName;
            QQVideoMaterial localQQVideoMaterial = TemplateParser.a((String)localObject3, "params");
            if (localQQVideoMaterial != null)
            {
              localQQVideoMaterial.setDataPath((String)localObject3);
              this.jdField_d_of_type_JavaUtilArrayList.add(localQQVideoMaterial);
              if (QLog.isDevelopLevel()) {
                QLog.d("Doodle_Strokes_PtvTemplateManager", 4, new Object[] { "getDoodleMaterials add DoodleMaterial:", localQQVideoMaterial.getId() });
              }
            }
          }
        }
      }
    }
    return this.jdField_d_of_type_JavaUtilArrayList;
  }
  
  public List a(AppInterface paramAppInterface, File paramFile, HashMap paramHashMap)
  {
    if (QLog.isColorLevel()) {
      if (paramAppInterface == null) {
        break label67;
      }
    }
    label67:
    for (boolean bool = true;; bool = false)
    {
      QLog.i("PtvTemplateManager", 2, String.format("rebuildTemplateInfos, app[%s], isUpdateedByServer[%s], cur_runnable[%s]", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(this.jdField_b_of_type_Boolean), Integer.valueOf(hashCode()) }));
      if (!this.jdField_b_of_type_Boolean) {
        break;
      }
      return null;
    }
    paramAppInterface = a(paramFile);
    if (TextUtils.isEmpty(paramAppInterface)) {
      return null;
    }
    paramAppInterface = a(this, paramAppInterface);
    if ((paramAppInterface == null) || (paramAppInterface.isEmpty())) {
      return null;
    }
    paramFile = paramAppInterface.iterator();
    while (paramFile.hasNext())
    {
      PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)paramFile.next();
      if (localPtvTemplateInfo != null)
      {
        localPtvTemplateInfo.usable = a(localPtvTemplateInfo);
        if (paramHashMap != null) {
          paramHashMap.put(localPtvTemplateInfo.id, localPtvTemplateInfo);
        }
      }
    }
    return paramAppInterface;
  }
  
  public void a()
  {
    a(false);
  }
  
  @TargetApi(9)
  public void a(AppInterface paramAppInterface)
  {
    Object localObject = new File(jdField_a_of_type_JavaIoFile, "ptv_template_new.cfg");
    if (!((File)localObject).exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d("PtvTemplateManager", 2, "initLocalTemplateConfigInfo config file not exist.");
      }
      return;
    }
    localObject = new ahzb(this, paramAppInterface, (File)localObject);
    if (QLog.isDevelopLevel()) {
      QLog.d("PtvTemplateManager", 4, String.format("initLocalTemplateConfigInfo async, runnable[%s]", new Object[] { Integer.valueOf(localObject.hashCode()) }));
    }
    if ((paramAppInterface instanceof QQAppInterface))
    {
      ThreadManager.getFileThreadHandler().postDelayed((Runnable)localObject, jdField_a_of_type_JavaLangLong.longValue());
      return;
    }
    ThreadManager.postImmediately((Runnable)localObject, null, false);
  }
  
  public void a(AppInterface paramAppInterface, PtvTemplateManager.DoodleInfoLoadObserver paramDoodleInfoLoadObserver, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo != null) && (!this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.doodleInfos.isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Doodle_Strokes_PtvTemplateManager", 2, "initDoodleInfo has inited.");
      }
      if (paramBoolean) {
        ThreadManager.postImmediately(new ahyn(this), null, false);
      }
    }
    File localFile;
    do
    {
      return;
      localFile = new File(jdField_b_of_type_JavaIoFile, "doodle_template_new.cfg");
      if (localFile.exists()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Doodle_Strokes_PtvTemplateManager", 2, "initLocalDoodleInfo config file not exist.");
    return;
    paramDoodleInfoLoadObserver = new ahyo(this, localFile, paramBoolean, paramDoodleInfoLoadObserver, paramAppInterface);
    if (QLog.isDevelopLevel()) {
      QLog.d("Doodle_Strokes_PtvTemplateManager", 4, String.format("initLocalDoodleInfo async, runnable[%s]", new Object[] { Integer.valueOf(paramDoodleInfoLoadObserver.hashCode()) }));
    }
    if ((paramAppInterface instanceof QQAppInterface))
    {
      ThreadManager.getFileThreadHandler().postDelayed(paramDoodleInfoLoadObserver, jdField_a_of_type_JavaLangLong.longValue());
      return;
    }
    ThreadManager.postImmediately(paramDoodleInfoLoadObserver, null, false);
  }
  
  public void a(AppInterface paramAppInterface, PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, PtvTemplateManager.IPtvTemplateDownloadListener paramIPtvTemplateDownloadListener)
  {
    if (paramPtvTemplateInfo == null) {}
    for (;;)
    {
      return;
      paramPtvTemplateInfo.startDownloadTime = System.currentTimeMillis();
      HttpNetReq localHttpNetReq = new HttpNetReq();
      localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = new ahzd(this, paramPtvTemplateInfo, paramIPtvTemplateDownloadListener);
      localHttpNetReq.jdField_a_of_type_JavaLangString = paramPtvTemplateInfo.resurl;
      localHttpNetReq.jdField_a_of_type_Int = 0;
      localHttpNetReq.jdField_c_of_type_JavaLangString = new File(jdField_a_of_type_JavaIoFile, paramPtvTemplateInfo.name).getPath();
      localHttpNetReq.jdField_c_of_type_Int = NetworkUtil.a(NetworkCenter.a().a());
      try
      {
        paramAppInterface.getNetEngine(0).a(localHttpNetReq);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("PtvTemplateManager", 2, "startDownloadTemplate url: " + paramPtvTemplateInfo.resurl);
        return;
      }
      catch (Exception paramAppInterface)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            paramAppInterface.printStackTrace();
          }
        }
      }
    }
  }
  
  void a(AppInterface paramAppInterface, ArrayList paramArrayList)
  {
    ThreadManager.getSubThreadHandler().postDelayed(new ahyx(this, paramAppInterface, paramArrayList), jdField_a_of_type_JavaLangLong.longValue());
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.doodleInfos.isEmpty()) || (paramQQAppInterface == null)) {}
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Doodle_Strokes_PtvTemplateManager", 2, "preDownloadDoodleTemplate|app= " + paramQQAppInterface);
      }
      Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.doodleInfos.iterator();
      while (localIterator.hasNext())
      {
        PtvTemplateManager.DoodleInfo localDoodleInfo = (PtvTemplateManager.DoodleInfo)localIterator.next();
        if ((localDoodleInfo != null) && (!TextUtils.isEmpty(localDoodleInfo.doodleUrl)) && (!localDoodleInfo.doodleUsable))
        {
          Object localObject = new ahyr(this, localDoodleInfo, paramQQAppInterface);
          PreDownloadController localPreDownloadController = (PreDownloadController)paramQQAppInterface.getManager(192);
          if (localPreDownloadController.a())
          {
            localObject = new RunnableTask(paramQQAppInterface, "qq_doodle_res", (Runnable)localObject, 4000L);
            localPreDownloadController.a(10020, null, localDoodleInfo.doodleName, 0, localDoodleInfo.doodleUrl, new File(jdField_b_of_type_JavaIoFile, localDoodleInfo.doodleName).getPath(), 2, 0, true, (AbsPreDownloadTask)localObject);
          }
          else
          {
            ThreadManager.post((Runnable)localObject, 8, null, true);
          }
        }
      }
    }
  }
  
  public void a(PtvTemplateManager.IPtvTemplateUpdateListener paramIPtvTemplateUpdateListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$IPtvTemplateUpdateListener = paramIPtvTemplateUpdateListener;
  }
  
  public void a(Runnable paramRunnable)
  {
    Object localObject = new File(a(106) + "config.xml");
    if (!((File)localObject).exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d("PtvTemplateManager", 2, "双人挂件加载 config file not exist.");
      }
      return;
    }
    localObject = new ahza(this, (File)localObject, paramRunnable);
    if (QLog.isDevelopLevel()) {
      if (paramRunnable == null) {
        break label120;
      }
    }
    label120:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("PtvTemplateManager", 2, String.format("双人挂件加载, onInitFinishSink[%s], runnable[%s]", new Object[] { Boolean.valueOf(bool), Integer.valueOf(localObject.hashCode()) }));
      ThreadManager.postImmediately((Runnable)localObject, null, false);
      return;
    }
  }
  
  public void a(String arg1, AppInterface paramAppInterface)
  {
    List localList = a(null, ???);
    if ((localList == null) || (localList.isEmpty())) {}
    for (;;)
    {
      return;
      a(???, "ptv_template_bless.cfg");
      ??? = localList.iterator();
      while (???.hasNext())
      {
        PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)???.next();
        if (localPtvTemplateInfo != null)
        {
          localPtvTemplateInfo.usable = a(localPtvTemplateInfo);
          localPtvTemplateInfo.businessID = 1;
        }
      }
      synchronized (this.jdField_e_of_type_JavaUtilArrayList)
      {
        this.jdField_e_of_type_JavaUtilArrayList.clear();
        this.jdField_e_of_type_JavaUtilArrayList.addAll(localList);
        this.jdField_e_of_type_Boolean = true;
        if (this.jdField_f_of_type_Boolean) {
          continue;
        }
        ThreadManager.getFileThreadHandler().post(new ahyu(this, localList));
        a(paramAppInterface, this.jdField_e_of_type_JavaUtilArrayList);
        return;
      }
    }
  }
  
  public void a(String paramString, AppInterface paramAppInterface, int paramInt)
  {
    List localList = a(null, paramString);
    if ((localList == null) || (localList.isEmpty())) {
      return;
    }
    String str;
    if (paramInt == 1) {
      str = "ptv_template_new.cfg";
    }
    for (ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;; localArrayList = this.jdField_b_of_type_JavaUtilArrayList)
    {
      a(paramString, str);
      a(localList, paramInt);
      if (this.jdField_d_of_type_Boolean) {
        break;
      }
      ThreadManager.getFileThreadHandler().post(new ahyw(this, localList));
      a(paramAppInterface, localArrayList);
      return;
      str = "ptv_template_web.cfg";
    }
  }
  
  public void a(String arg1, QQAppInterface paramQQAppInterface)
  {
    PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = a(???);
    if (localPtvTemplateInfo == null) {
      return;
    }
    ThreadManager.getFileThreadHandler().post(new ahyp(this, ???));
    synchronized (this.jdField_d_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo = localPtvTemplateInfo;
      ThreadManager.getFileThreadHandler().post(new ahyq(this));
      a(paramQQAppInterface);
      return;
    }
  }
  
  public void a(List paramList) {}
  
  public void a(List paramList, int paramInt)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    ??? = paramList.iterator();
    while (((Iterator)???).hasNext())
    {
      PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)((Iterator)???).next();
      if (localPtvTemplateInfo != null) {
        localPtvTemplateInfo.usable = a(localPtvTemplateInfo);
      }
    }
    if (paramInt == 1) {
      synchronized (this.jdField_b_of_type_JavaLangObject)
      {
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
        this.jdField_b_of_type_Boolean = true;
        return;
      }
    }
    synchronized (this.jdField_c_of_type_JavaLangObject)
    {
      this.jdField_b_of_type_JavaUtilArrayList.clear();
      this.jdField_b_of_type_JavaUtilArrayList.addAll(paramList);
      this.jdField_c_of_type_Boolean = true;
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    ThreadManager.postImmediately(new ahyl(this, paramBoolean), null, false);
  }
  
  public boolean a(PtvTemplateManager.DoodleInfo paramDoodleInfo, boolean paramBoolean)
  {
    if ((paramDoodleInfo == null) || (TextUtils.isEmpty(paramDoodleInfo.doodleName))) {}
    do
    {
      for (;;)
      {
        return false;
        Object localObject = new File(jdField_b_of_type_JavaIoFile, paramDoodleInfo.doodleName);
        if (!((File)localObject).exists())
        {
          if (QLog.isColorLevel())
          {
            QLog.d("Doodle_Strokes_PtvTemplateManager", 2, "isDoodleTemplateUsable|file is not exist -> " + paramDoodleInfo.doodleName);
            return false;
          }
        }
        else {
          try
          {
            localObject = FileUtils.b(((File)localObject).getPath());
            if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equalsIgnoreCase(paramDoodleInfo.doodleMd5)))
            {
              if ((!paramBoolean) || (new File(jdField_c_of_type_JavaLangString + paramDoodleInfo.doodleName + File.separator, "params.json").exists())) {
                break label268;
              }
              if (QLog.isColorLevel()) {
                QLog.d("Doodle_Strokes_PtvTemplateManager", 2, "isDoodleTemplateUsable|paramFile is not exist->>" + paramDoodleInfo.doodleName);
              }
              if (!QLog.isColorLevel()) {}
            }
          }
          catch (UnsatisfiedLinkError paramDoodleInfo)
          {
            try
            {
              ZipUtils.a(new File(jdField_b_of_type_JavaIoFile, paramDoodleInfo.doodleName), jdField_c_of_type_JavaLangString);
              if (QLog.isColorLevel()) {
                QLog.d("Doodle_Strokes_PtvTemplateManager", 2, "isDoodleTemplateUsable|unZipFile->>" + paramDoodleInfo.doodleName);
              }
              return true;
            }
            catch (IOException paramDoodleInfo) {}
            paramDoodleInfo = paramDoodleInfo;
          }
        }
      }
      paramDoodleInfo.printStackTrace();
      return false;
    } while (!QLog.isColorLevel());
    paramDoodleInfo.printStackTrace();
    return false;
    label268:
    return true;
  }
  
  /* Error */
  public boolean a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +13 -> 14
    //   4: aload_1
    //   5: getfield 418	com/tencent/mobileqq/shortvideo/PtvTemplateManager$PtvTemplateInfo:name	Ljava/lang/String;
    //   8: invokestatic 180	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11: ifeq +5 -> 16
    //   14: iconst_0
    //   15: ireturn
    //   16: new 82	java/io/File
    //   19: dup
    //   20: getstatic 114	com/tencent/mobileqq/shortvideo/PtvTemplateManager:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   23: aload_1
    //   24: getfield 418	com/tencent/mobileqq/shortvideo/PtvTemplateManager$PtvTemplateInfo:name	Ljava/lang/String;
    //   27: invokespecial 112	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   30: astore_2
    //   31: aload_2
    //   32: invokevirtual 344	java/io/File:exists	()Z
    //   35: ifeq -21 -> 14
    //   38: aload_2
    //   39: invokevirtual 117	java/io/File:getPath	()Ljava/lang/String;
    //   42: invokestatic 699	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/lang/String;)Ljava/lang/String;
    //   45: astore_2
    //   46: aload_2
    //   47: invokestatic 180	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   50: ifne -36 -> 14
    //   53: aload_2
    //   54: aload_1
    //   55: getfield 718	com/tencent/mobileqq/shortvideo/PtvTemplateManager$PtvTemplateInfo:md5	Ljava/lang/String;
    //   58: invokevirtual 705	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   61: ifeq -47 -> 14
    //   64: new 68	java/lang/StringBuilder
    //   67: dup
    //   68: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   71: getstatic 41	com/tencent/mobileqq/shortvideo/PtvTemplateManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   74: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: aload_1
    //   78: getfield 418	com/tencent/mobileqq/shortvideo/PtvTemplateManager$PtvTemplateInfo:name	Ljava/lang/String;
    //   81: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: getstatic 85	java/io/File:separator	Ljava/lang/String;
    //   87: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   93: astore_3
    //   94: new 82	java/io/File
    //   97: dup
    //   98: aload_3
    //   99: ldc_w 368
    //   102: invokespecial 369	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   105: astore_2
    //   106: new 82	java/io/File
    //   109: dup
    //   110: aload_3
    //   111: ldc_w 720
    //   114: invokespecial 369	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   117: astore_3
    //   118: aload_2
    //   119: invokevirtual 344	java/io/File:exists	()Z
    //   122: ifne +58 -> 180
    //   125: aload_3
    //   126: invokevirtual 344	java/io/File:exists	()Z
    //   129: ifne +51 -> 180
    //   132: new 82	java/io/File
    //   135: dup
    //   136: getstatic 114	com/tencent/mobileqq/shortvideo/PtvTemplateManager:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   139: aload_1
    //   140: getfield 418	com/tencent/mobileqq/shortvideo/PtvTemplateManager$PtvTemplateInfo:name	Ljava/lang/String;
    //   143: invokespecial 112	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   146: getstatic 41	com/tencent/mobileqq/shortvideo/PtvTemplateManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   149: invokestatic 711	com/tencent/biz/common/util/ZipUtils:a	(Ljava/io/File;Ljava/lang/String;)V
    //   152: iconst_1
    //   153: ireturn
    //   154: astore_1
    //   155: invokestatic 226	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   158: ifeq -144 -> 14
    //   161: aload_1
    //   162: invokevirtual 714	java/lang/UnsatisfiedLinkError:printStackTrace	()V
    //   165: iconst_0
    //   166: ireturn
    //   167: astore_1
    //   168: invokestatic 226	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   171: ifeq -157 -> 14
    //   174: aload_1
    //   175: invokevirtual 582	java/lang/Exception:printStackTrace	()V
    //   178: iconst_0
    //   179: ireturn
    //   180: iconst_1
    //   181: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	182	0	this	PtvTemplateManager
    //   0	182	1	paramPtvTemplateInfo	PtvTemplateManager.PtvTemplateInfo
    //   30	89	2	localObject1	Object
    //   93	33	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   38	46	154	java/lang/UnsatisfiedLinkError
    //   132	152	167	java/lang/Exception
  }
  
  public String b(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.doodleInfos != null) && (!this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.doodleInfos.isEmpty()))
    {
      Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.doodleInfos.iterator();
      while (localIterator.hasNext())
      {
        PtvTemplateManager.DoodleInfo localDoodleInfo = (PtvTemplateManager.DoodleInfo)localIterator.next();
        if (Integer.valueOf(localDoodleInfo.doodleId).intValue() == paramInt) {
          return jdField_c_of_type_JavaLangString + localDoodleInfo.doodleName;
        }
      }
    }
    return "";
  }
  
  public ArrayList b()
  {
    ArrayList localArrayList1 = new ArrayList();
    for (;;)
    {
      PtvTemplateManager.DoodleInfo localDoodleInfo;
      synchronized (this.jdField_d_of_type_JavaLangObject)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.doodleInfos.isEmpty())) {
          return null;
        }
        Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.doodleInfos.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localDoodleInfo = (PtvTemplateManager.DoodleInfo)localIterator.next();
        if ((localDoodleInfo == null) || (TextUtils.isEmpty(localDoodleInfo.doodleName)))
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("Doodle_Strokes_PtvTemplateManager", 2, "info is null or info name is null " + localDoodleInfo);
        }
      }
      if (!new File(jdField_b_of_type_JavaIoFile, localDoodleInfo.doodleName).exists())
      {
        if (QLog.isColorLevel()) {
          QLog.d("Doodle_Strokes_PtvTemplateManager", 2, "getDoodleInfos|file is not exist ");
        }
        localDoodleInfo.doodleUsable = false;
      }
      else if (!new File(jdField_c_of_type_JavaLangString + localDoodleInfo.doodleName + File.separator, "params.json").exists())
      {
        if (QLog.isColorLevel()) {
          QLog.d("Doodle_Strokes_PtvTemplateManager", 2, "getDoodleInfos|paramFile is not exist ");
        }
        localDoodleInfo.doodleUsable = false;
      }
      else
      {
        localArrayList2.add(localDoodleInfo);
      }
    }
    return localArrayList2;
  }
  
  @TargetApi(9)
  public void b(AppInterface paramAppInterface)
  {
    Object localObject = new File(jdField_a_of_type_JavaIoFile, "ptv_template_web.cfg");
    if (!((File)localObject).exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d("PtvTemplateManager", 2, "initLocalWebTemplateConfigInfo config file not exist.");
      }
      return;
    }
    localObject = new ahzc(this, paramAppInterface, (File)localObject);
    if (QLog.isDevelopLevel()) {
      QLog.d("PtvTemplateManager", 4, String.format("initLocalTemplateConfigInfo async, runnable[%s]", new Object[] { Integer.valueOf(localObject.hashCode()) }));
    }
    if ((paramAppInterface instanceof QQAppInterface))
    {
      ThreadManager.getFileThreadHandler().postDelayed((Runnable)localObject, jdField_a_of_type_JavaLangLong.longValue());
      return;
    }
    ThreadManager.postImmediately((Runnable)localObject, null, false);
  }
  
  public void b(AppInterface paramAppInterface, PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, PtvTemplateManager.IPtvTemplateDownloadListener paramIPtvTemplateDownloadListener)
  {
    if (paramPtvTemplateInfo == null) {}
    for (;;)
    {
      return;
      HttpNetReq localHttpNetReq = new HttpNetReq();
      localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = new ahym(this, paramPtvTemplateInfo, paramIPtvTemplateDownloadListener);
      localHttpNetReq.jdField_a_of_type_JavaLangString = paramPtvTemplateInfo.resurl;
      localHttpNetReq.jdField_a_of_type_Int = 0;
      localHttpNetReq.jdField_c_of_type_JavaLangString = new File(jdField_a_of_type_JavaIoFile, paramPtvTemplateInfo.name).getPath();
      localHttpNetReq.jdField_c_of_type_Int = NetworkUtil.a(NetworkCenter.a().a());
      try
      {
        paramAppInterface.getNetEngine(0).a(localHttpNetReq);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("PtvTemplateManager", 2, "startDownloadTemplate url: " + paramPtvTemplateInfo.resurl);
        return;
      }
      catch (Exception paramAppInterface)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            paramAppInterface.printStackTrace();
          }
        }
      }
    }
  }
  
  public void b(AppInterface paramAppInterface, ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {
      return;
    }
    int k = 0;
    label14:
    PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo;
    if (k < paramArrayList.size())
    {
      localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)paramArrayList.get(k);
      if ((localPtvTemplateInfo != null) && (localPtvTemplateInfo.predownload) && (!TextUtils.isEmpty(localPtvTemplateInfo.resurl))) {
        break label63;
      }
    }
    for (;;)
    {
      k += 1;
      break label14;
      break;
      label63:
      ThreadManager.getFileThreadHandler().post(new ahyy(this, localPtvTemplateInfo, paramAppInterface));
    }
  }
  
  public ArrayList c()
  {
    return this.jdField_e_of_type_JavaUtilArrayList;
  }
  
  public void c()
  {
    synchronized (this.jdField_d_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo = null;
      this.jdField_d_of_type_JavaUtilArrayList.clear();
      File localFile = new File(jdField_b_of_type_JavaIoFile, "doodle_template_new.cfg");
      if (localFile.exists()) {
        localFile.delete();
      }
      return;
    }
  }
  
  @TargetApi(9)
  public void c(AppInterface paramAppInterface)
  {
    Object localObject = new File(jdField_a_of_type_JavaIoFile, "ptv_template_bless.cfg");
    if (!((File)localObject).exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d("PtvTemplateManager", 2, "initBlessSpecialPendantConfigInfo config file not exist.");
      }
      a(true);
      return;
    }
    localObject = new ahyt(this, paramAppInterface, (File)localObject);
    if (QLog.isDevelopLevel()) {
      QLog.d("PtvTemplateManager", 4, String.format("initBlessTemplateConfigInfo async, runnable[%s]", new Object[] { Integer.valueOf(localObject.hashCode()) }));
    }
    if ((paramAppInterface instanceof QQAppInterface))
    {
      ThreadManager.getFileThreadHandler().postDelayed((Runnable)localObject, jdField_a_of_type_JavaLangLong.longValue());
      return;
    }
    ThreadManager.postImmediately((Runnable)localObject, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.PtvTemplateManager
 * JD-Core Version:    0.7.0.1
 */