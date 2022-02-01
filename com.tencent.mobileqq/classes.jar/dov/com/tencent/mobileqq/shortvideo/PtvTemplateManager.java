package dov.com.tencent.mobileqq.shortvideo;

import alwf;
import android.os.Build.VERSION;
import android.text.TextUtils;
import bdax;
import bezs;
import bezv;
import bezw;
import bhmi;
import brhj;
import brhl;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.ptvfilter.material.QQTemplateParser;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import nof;
import org.json.JSONException;
import org.json.JSONObject;

public class PtvTemplateManager
{
  static PtvTemplateManager jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager;
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
  public brhl a;
  public PtvTemplateManager.PtvTemplateInfo a;
  ArrayList<PtvTemplateManager.PtvTemplateInfo> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  Object jdField_b_of_type_JavaLangObject = new Object();
  ArrayList<PtvTemplateManager.PtvTemplateInfo> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  public boolean b;
  Object jdField_c_of_type_JavaLangObject = new Object();
  ArrayList<PtvTemplateManager.PtvTemplateInfo> jdField_c_of_type_JavaUtilArrayList = new ArrayList();
  public boolean c;
  Object jdField_d_of_type_JavaLangObject = new Object();
  String jdField_d_of_type_JavaLangString;
  public ArrayList<VideoMaterial> d;
  public boolean d;
  String jdField_e_of_type_JavaLangString;
  ArrayList<PtvTemplateManager.PtvTemplateInfo> jdField_e_of_type_JavaUtilArrayList = new ArrayList();
  public boolean e;
  String f;
  public boolean f;
  
  static
  {
    jdField_a_of_type_JavaLangLong = Long.valueOf(60000L);
    jdField_a_of_type_JavaLangString = "ptv_template_usable";
    jdField_b_of_type_JavaLangString = "ptv_debug";
    jdField_c_of_type_JavaLangString = "dov_ptv_template_usable_doodle";
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_g_of_type_JavaLangString = "5";
    h = "200";
    i = "20";
    File localFile = new File(alwf.jdField_d_of_type_JavaLangString);
    jdField_a_of_type_JavaIoFile = new File(localFile, "dov_ptv_template");
    jdField_a_of_type_JavaLangString = jdField_a_of_type_JavaIoFile.getPath() + File.separator + jdField_a_of_type_JavaLangString + File.separator;
    jdField_b_of_type_JavaLangString = jdField_a_of_type_JavaIoFile.getPath() + File.separator + jdField_b_of_type_JavaLangString;
    jdField_b_of_type_JavaIoFile = new File(localFile, "dov_doodle_template");
    jdField_c_of_type_JavaLangString = jdField_b_of_type_JavaIoFile.getPath() + File.separator + jdField_c_of_type_JavaLangString + File.separator;
    jdField_g_of_type_Boolean = bdax.b(bdax.E);
  }
  
  private PtvTemplateManager(AppInterface paramAppInterface)
  {
    this.jdField_d_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  /* Error */
  static PtvTemplateManager.PtvTemplateInfo a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 142	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: new 144	org/json/JSONObject
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 145	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   17: astore_0
    //   18: aload_0
    //   19: ldc 147
    //   21: invokestatic 152	bhhq:a	(Lorg/json/JSONObject;Ljava/lang/Class;)Ljava/lang/Object;
    //   24: checkcast 147	dov/com/tencent/mobileqq/shortvideo/PtvTemplateManager$PtvTemplateInfo
    //   27: astore_3
    //   28: aload_0
    //   29: ldc 154
    //   31: invokevirtual 157	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   34: ifeq +165 -> 199
    //   37: aload_0
    //   38: ldc 154
    //   40: invokevirtual 161	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
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
    //   61: invokevirtual 167	org/json/JSONArray:length	()I
    //   64: istore_2
    //   65: iload_2
    //   66: ifle -59 -> 7
    //   69: aload_0
    //   70: new 116	java/util/ArrayList
    //   73: dup
    //   74: iload_2
    //   75: invokespecial 170	java/util/ArrayList:<init>	(I)V
    //   78: putfield 173	dov/com/tencent/mobileqq/shortvideo/PtvTemplateManager$PtvTemplateInfo:doodleInfos	Ljava/util/ArrayList;
    //   81: iconst_0
    //   82: istore_1
    //   83: iload_1
    //   84: iload_2
    //   85: if_icmpge +71 -> 156
    //   88: aload_3
    //   89: iload_1
    //   90: invokevirtual 177	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   93: ldc 179
    //   95: invokestatic 152	bhhq:a	(Lorg/json/JSONObject;Ljava/lang/Class;)Ljava/lang/Object;
    //   98: checkcast 179	dov/com/tencent/mobileqq/shortvideo/PtvTemplateManager$DoodleInfo
    //   101: astore 4
    //   103: aload 4
    //   105: ifnull +13 -> 118
    //   108: aload_0
    //   109: getfield 173	dov/com/tencent/mobileqq/shortvideo/PtvTemplateManager$PtvTemplateInfo:doodleInfos	Ljava/util/ArrayList;
    //   112: aload 4
    //   114: invokevirtual 183	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   117: pop
    //   118: iload_1
    //   119: iconst_1
    //   120: iadd
    //   121: istore_1
    //   122: goto -39 -> 83
    //   125: astore_3
    //   126: aconst_null
    //   127: astore_0
    //   128: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   131: ifeq +7 -> 138
    //   134: aload_3
    //   135: invokevirtual 192	org/json/JSONException:printStackTrace	()V
    //   138: aconst_null
    //   139: astore_3
    //   140: goto -88 -> 52
    //   143: astore_0
    //   144: invokestatic 195	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   147: ifeq -140 -> 7
    //   150: aload_0
    //   151: invokevirtual 192	org/json/JSONException:printStackTrace	()V
    //   154: aconst_null
    //   155: areturn
    //   156: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   159: ifeq +28 -> 187
    //   162: ldc 197
    //   164: iconst_2
    //   165: new 83	java/lang/StringBuilder
    //   168: dup
    //   169: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   172: ldc 199
    //   174: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: aload_0
    //   178: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   181: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   184: invokestatic 205	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   82	40	1	j	int
    //   64	22	2	k	int
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
    if (jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager != null) {
      return jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager;
    }
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager != null)
      {
        paramAppInterface = jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager;
        return paramAppInterface;
      }
    }
    jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager = new PtvTemplateManager(paramAppInterface);
    paramAppInterface = jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager;
    return paramAppInterface;
  }
  
  public static String a(File paramFile)
  {
    paramFile = bhmi.a(paramFile);
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
  
  static List<PtvTemplateManager.PtvTemplateInfo> a(PtvTemplateManager paramPtvTemplateManager, String paramString)
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
              paramPtvTemplateManager.f = localJSONObject.getString("version");
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
  
  private void a()
  {
    if (this.jdField_a_of_type_Brhl != null) {
      this.jdField_a_of_type_Brhl.a();
    }
  }
  
  public static boolean a()
  {
    return new File(jdField_b_of_type_JavaIoFile, "dov_doodle_template_new.cfg").exists();
  }
  
  public String a(int paramInt)
  {
    if ((this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo != null) && (this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.doodleInfos != null) && (!this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.doodleInfos.isEmpty()))
    {
      Iterator localIterator = this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.doodleInfos.iterator();
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
  
  public ArrayList<PtvTemplateManager.DoodleInfo> a()
  {
    ArrayList localArrayList = new ArrayList();
    PtvTemplateManager.DoodleInfo localDoodleInfo;
    File localFile;
    Object localObject2;
    int k;
    int j;
    for (;;)
    {
      synchronized (this.jdField_d_of_type_JavaLangObject)
      {
        if ((this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo == null) || (this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.doodleInfos.isEmpty())) {
          return null;
        }
        Iterator localIterator = this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.doodleInfos.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localDoodleInfo = (PtvTemplateManager.DoodleInfo)localIterator.next();
        if ((localDoodleInfo == null) || (TextUtils.isEmpty(localDoodleInfo.doodleName)))
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("DOV_Doodle_Strokes_PtvTemplateManager", 2, "info is null or info name is null " + localDoodleInfo);
        }
      }
      if (!new File(jdField_b_of_type_JavaIoFile, localDoodleInfo.doodleName).exists())
      {
        if (QLog.isColorLevel()) {
          QLog.d("DOV_Doodle_Strokes_PtvTemplateManager", 2, "getDoodleInfos|file is not exist ");
        }
        localDoodleInfo.doodleUsable = false;
      }
      else
      {
        localFile = new File(jdField_c_of_type_JavaLangString + localDoodleInfo.doodleName + File.separator, "params.json");
        if (!localFile.exists())
        {
          if (QLog.isColorLevel()) {
            QLog.d("DOV_Doodle_Strokes_PtvTemplateManager", 2, "getDoodleInfos|paramFile is not exist ");
          }
          localDoodleInfo.doodleUsable = false;
        }
        else
        {
          localObject2 = localFile.getParentFile();
          if (!((File)localObject2).isDirectory()) {
            break label358;
          }
          localObject2 = ((File)localObject2).listFiles();
          if ((localObject2 == null) || (localObject2.length <= 0)) {
            break label358;
          }
          k = localObject2.length;
          j = 0;
        }
      }
    }
    for (;;)
    {
      if (j < k)
      {
        if (!localObject2[j].getName().endsWith("png")) {}
      }
      else {
        label358:
        for (j = 1;; j = 0)
        {
          if (j == 0)
          {
            if (QLog.isColorLevel()) {
              QLog.d("DOV_Doodle_Strokes_PtvTemplateManager", 2, "getDoodleInfos|image is not exist ");
            }
            localFile.delete();
            break;
          }
          localArrayList1.add(localDoodleInfo);
          break;
          return localArrayList1;
        }
      }
      j += 1;
    }
  }
  
  public List<VideoMaterial> a()
  {
    if ((this.jdField_d_of_type_JavaUtilArrayList.isEmpty()) && (this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo != null)) {
      synchronized (this.jdField_d_of_type_JavaLangObject)
      {
        Iterator localIterator = this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.doodleInfos.iterator();
        while (localIterator.hasNext())
        {
          Object localObject3 = (PtvTemplateManager.DoodleInfo)localIterator.next();
          if (((PtvTemplateManager.DoodleInfo)localObject3).doodleUsable)
          {
            localObject3 = jdField_c_of_type_JavaLangString + ((PtvTemplateManager.DoodleInfo)localObject3).doodleName;
            VideoMaterial localVideoMaterial = QQTemplateParser.parseVideoMaterial((String)localObject3, "params");
            if (localVideoMaterial != null)
            {
              localVideoMaterial.setDataPath((String)localObject3);
              this.jdField_d_of_type_JavaUtilArrayList.add(localVideoMaterial);
              if (QLog.isDevelopLevel()) {
                QLog.d("DOV_Doodle_Strokes_PtvTemplateManager", 4, new Object[] { "getDoodleMaterials add DoodleMaterial:", localVideoMaterial.getId() });
              }
            }
          }
        }
      }
    }
    return this.jdField_d_of_type_JavaUtilArrayList;
  }
  
  List<PtvTemplateManager.PtvTemplateInfo> a(AppInterface paramAppInterface, File paramFile, HashMap<String, PtvTemplateManager.PtvTemplateInfo> paramHashMap)
  {
    if (QLog.isColorLevel()) {
      if (paramAppInterface == null) {
        break label66;
      }
    }
    label66:
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
  
  public void a(AppInterface paramAppInterface, brhj parambrhj, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo != null) && (!this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.doodleInfos.isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("DOV_Doodle_Strokes_PtvTemplateManager", 2, "initDoodleInfo has inited.");
      }
      if (paramBoolean) {
        ThreadManager.postImmediately(new PtvTemplateManager.9(this), null, false);
      }
    }
    File localFile;
    do
    {
      return;
      localFile = new File(jdField_b_of_type_JavaIoFile, "dov_doodle_template_new.cfg");
      if (localFile.exists()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("DOV_Doodle_Strokes_PtvTemplateManager", 2, "initLocalDoodleInfo config file not exist.");
    return;
    parambrhj = new PtvTemplateManager.10(this, localFile, paramBoolean, parambrhj, paramAppInterface);
    if (QLog.isDevelopLevel()) {
      QLog.d("DOV_Doodle_Strokes_PtvTemplateManager", 4, String.format("initLocalDoodleInfo async, runnable[%s]", new Object[] { Integer.valueOf(parambrhj.hashCode()) }));
    }
    if ((paramAppInterface instanceof QQAppInterface))
    {
      ThreadManager.getFileThreadHandler().postDelayed(parambrhj, 0L);
      return;
    }
    ThreadManager.postImmediately(parambrhj, null, false);
  }
  
  void a(AppInterface paramAppInterface, ArrayList<PtvTemplateManager.PtvTemplateInfo> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {
      return;
    }
    int j = 0;
    label14:
    PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo;
    if (j < paramArrayList.size())
    {
      localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)paramArrayList.get(j);
      if ((localPtvTemplateInfo != null) && (localPtvTemplateInfo.predownload) && (!TextUtils.isEmpty(localPtvTemplateInfo.resurl))) {
        break label63;
      }
    }
    for (;;)
    {
      j += 1;
      break label14;
      break;
      label63:
      ThreadManager.getFileThreadHandler().post(new PtvTemplateManager.5(this, localPtvTemplateInfo, paramAppInterface));
    }
  }
  
  void a(QQAppInterface paramQQAppInterface)
  {
    if ((this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo == null) || (this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.doodleInfos.isEmpty()) || (paramQQAppInterface == null)) {}
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("DOV_Doodle_Strokes_PtvTemplateManager", 2, "preDownloadDoodleTemplate|app= " + paramQQAppInterface);
      }
      Iterator localIterator = this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.doodleInfos.iterator();
      while (localIterator.hasNext())
      {
        PtvTemplateManager.DoodleInfo localDoodleInfo = (PtvTemplateManager.DoodleInfo)localIterator.next();
        if ((localDoodleInfo != null) && (!TextUtils.isEmpty(localDoodleInfo.doodleUrl)) && (!localDoodleInfo.doodleUsable))
        {
          Object localObject = new PtvTemplateManager.13(this, localDoodleInfo, paramQQAppInterface);
          bezv localbezv = (bezv)paramQQAppInterface.getManager(193);
          if (localbezv.a())
          {
            localObject = new bezw(paramQQAppInterface, "qq_doodle_res", (Runnable)localObject, 4000L);
            localbezv.a(10020, null, localDoodleInfo.doodleName, 0, localDoodleInfo.doodleUrl, new File(jdField_b_of_type_JavaIoFile, localDoodleInfo.doodleName).getPath(), 2, 0, true, (bezs)localObject);
          }
          else
          {
            ThreadManager.post((Runnable)localObject, 8, null, true);
          }
        }
      }
    }
  }
  
  public void a(String arg1, QQAppInterface paramQQAppInterface)
  {
    PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = a(???);
    if (localPtvTemplateInfo == null) {
      return;
    }
    ThreadManager.getFileThreadHandler().post(new PtvTemplateManager.11(this, ???));
    synchronized (this.jdField_d_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo = localPtvTemplateInfo;
      ThreadManager.getFileThreadHandler().post(new PtvTemplateManager.12(this));
      a(paramQQAppInterface);
      return;
    }
  }
  
  void a(List<PtvTemplateManager.PtvTemplateInfo> paramList) {}
  
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
            QLog.d("DOV_Doodle_Strokes_PtvTemplateManager", 2, "isDoodleTemplateUsable|file is not exist -> " + paramDoodleInfo.doodleName);
            return false;
          }
        }
        else {
          try
          {
            localObject = bhmi.c(((File)localObject).getPath());
            if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equalsIgnoreCase(paramDoodleInfo.doodleMd5)))
            {
              if ((!paramBoolean) || (new File(jdField_c_of_type_JavaLangString + paramDoodleInfo.doodleName + File.separator, "params.json").exists())) {
                break label268;
              }
              if (QLog.isColorLevel()) {
                QLog.d("DOV_Doodle_Strokes_PtvTemplateManager", 2, "isDoodleTemplateUsable|paramFile is not exist->>" + paramDoodleInfo.doodleName);
              }
              if (!QLog.isColorLevel()) {}
            }
          }
          catch (UnsatisfiedLinkError paramDoodleInfo)
          {
            try
            {
              nof.a(new File(jdField_b_of_type_JavaIoFile, paramDoodleInfo.doodleName), jdField_c_of_type_JavaLangString);
              if (QLog.isColorLevel()) {
                QLog.d("DOV_Doodle_Strokes_PtvTemplateManager", 2, "isDoodleTemplateUsable|unZipFile->>" + paramDoodleInfo.doodleName);
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
    //   5: getfield 569	dov/com/tencent/mobileqq/shortvideo/PtvTemplateManager$PtvTemplateInfo:name	Ljava/lang/String;
    //   8: invokestatic 142	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11: ifeq +5 -> 16
    //   14: iconst_0
    //   15: ireturn
    //   16: new 67	java/io/File
    //   19: dup
    //   20: getstatic 81	dov/com/tencent/mobileqq/shortvideo/PtvTemplateManager:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   23: aload_1
    //   24: getfield 569	dov/com/tencent/mobileqq/shortvideo/PtvTemplateManager$PtvTemplateInfo:name	Ljava/lang/String;
    //   27: invokespecial 79	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   30: astore_2
    //   31: aload_2
    //   32: invokevirtual 295	java/io/File:exists	()Z
    //   35: ifeq -21 -> 14
    //   38: aload_2
    //   39: invokevirtual 88	java/io/File:getPath	()Ljava/lang/String;
    //   42: invokestatic 548	bhmi:c	(Ljava/lang/String;)Ljava/lang/String;
    //   45: astore_2
    //   46: aload_2
    //   47: invokestatic 142	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   50: ifne -36 -> 14
    //   53: aload_2
    //   54: aload_1
    //   55: getfield 572	dov/com/tencent/mobileqq/shortvideo/PtvTemplateManager$PtvTemplateInfo:md5	Ljava/lang/String;
    //   58: invokevirtual 554	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   61: ifeq -47 -> 14
    //   64: new 83	java/lang/StringBuilder
    //   67: dup
    //   68: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   71: getstatic 40	dov/com/tencent/mobileqq/shortvideo/PtvTemplateManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   74: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: aload_1
    //   78: getfield 569	dov/com/tencent/mobileqq/shortvideo/PtvTemplateManager$PtvTemplateInfo:name	Ljava/lang/String;
    //   81: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: getstatic 95	java/io/File:separator	Ljava/lang/String;
    //   87: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   93: astore_3
    //   94: new 67	java/io/File
    //   97: dup
    //   98: aload_3
    //   99: ldc_w 338
    //   102: invokespecial 341	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   105: astore_2
    //   106: new 67	java/io/File
    //   109: dup
    //   110: aload_3
    //   111: ldc_w 574
    //   114: invokespecial 341	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   117: astore_3
    //   118: aload_2
    //   119: invokevirtual 295	java/io/File:exists	()Z
    //   122: ifne +58 -> 180
    //   125: aload_3
    //   126: invokevirtual 295	java/io/File:exists	()Z
    //   129: ifne +51 -> 180
    //   132: new 67	java/io/File
    //   135: dup
    //   136: getstatic 81	dov/com/tencent/mobileqq/shortvideo/PtvTemplateManager:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   139: aload_1
    //   140: getfield 569	dov/com/tencent/mobileqq/shortvideo/PtvTemplateManager$PtvTemplateInfo:name	Ljava/lang/String;
    //   143: invokespecial 79	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   146: getstatic 40	dov/com/tencent/mobileqq/shortvideo/PtvTemplateManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   149: invokestatic 560	nof:a	(Ljava/io/File;Ljava/lang/String;)V
    //   152: iconst_1
    //   153: ireturn
    //   154: astore_1
    //   155: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   158: ifeq -144 -> 14
    //   161: aload_1
    //   162: invokevirtual 563	java/lang/UnsatisfiedLinkError:printStackTrace	()V
    //   165: iconst_0
    //   166: ireturn
    //   167: astore_1
    //   168: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   171: ifeq -157 -> 14
    //   174: aload_1
    //   175: invokevirtual 575	java/lang/Exception:printStackTrace	()V
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager
 * JD-Core Version:    0.7.0.1
 */