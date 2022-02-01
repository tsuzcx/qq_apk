package dov.com.tencent.mobileqq.shortvideo;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.richmedia.PathUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraCompatibleList;
import com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask;
import com.tencent.mobileqq.transfile.predownload.PreDownloadController;
import com.tencent.mobileqq.transfile.predownload.RunnableTask;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.os.MqqHandler;

public class PtvTemplateManager
{
  private static PtvTemplateManager jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager;
  private static File jdField_a_of_type_JavaIoFile = new File(new File(PathUtils.d), "dov_doodle_template");
  private static Object jdField_a_of_type_JavaLangObject;
  private static String jdField_a_of_type_JavaLangString = jdField_a_of_type_JavaIoFile.getPath() + File.separator + jdField_a_of_type_JavaLangString + File.separator;
  private static boolean jdField_a_of_type_Boolean = CameraCompatibleList.b(CameraCompatibleList.E);
  private static Object b;
  private PtvTemplateManager.PtvTemplateInfo jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo;
  
  static
  {
    jdField_a_of_type_JavaLangObject = new Object();
    b = new Object();
  }
  
  /* Error */
  static PtvTemplateManager.PtvTemplateInfo a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 83	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: new 85	org/json/JSONObject
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 86	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   17: astore_0
    //   18: aload_0
    //   19: ldc 88
    //   21: invokestatic 93	com/tencent/mobileqq/util/JSONUtils:a	(Lorg/json/JSONObject;Ljava/lang/Class;)Ljava/lang/Object;
    //   24: checkcast 88	dov/com/tencent/mobileqq/shortvideo/PtvTemplateManager$PtvTemplateInfo
    //   27: astore_3
    //   28: aload_0
    //   29: ldc 95
    //   31: invokevirtual 98	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   34: ifeq +165 -> 199
    //   37: aload_0
    //   38: ldc 95
    //   40: invokevirtual 102	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
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
    //   61: invokevirtual 108	org/json/JSONArray:length	()I
    //   64: istore_2
    //   65: iload_2
    //   66: ifle -59 -> 7
    //   69: aload_0
    //   70: new 110	java/util/ArrayList
    //   73: dup
    //   74: iload_2
    //   75: invokespecial 113	java/util/ArrayList:<init>	(I)V
    //   78: putfield 117	dov/com/tencent/mobileqq/shortvideo/PtvTemplateManager$PtvTemplateInfo:doodleInfos	Ljava/util/ArrayList;
    //   81: iconst_0
    //   82: istore_1
    //   83: iload_1
    //   84: iload_2
    //   85: if_icmpge +71 -> 156
    //   88: aload_3
    //   89: iload_1
    //   90: invokevirtual 121	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   93: ldc 123
    //   95: invokestatic 93	com/tencent/mobileqq/util/JSONUtils:a	(Lorg/json/JSONObject;Ljava/lang/Class;)Ljava/lang/Object;
    //   98: checkcast 123	dov/com/tencent/mobileqq/shortvideo/PtvTemplateManager$DoodleInfo
    //   101: astore 4
    //   103: aload 4
    //   105: ifnull +13 -> 118
    //   108: aload_0
    //   109: getfield 117	dov/com/tencent/mobileqq/shortvideo/PtvTemplateManager$PtvTemplateInfo:doodleInfos	Ljava/util/ArrayList;
    //   112: aload 4
    //   114: invokevirtual 127	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   117: pop
    //   118: iload_1
    //   119: iconst_1
    //   120: iadd
    //   121: istore_1
    //   122: goto -39 -> 83
    //   125: astore_3
    //   126: aconst_null
    //   127: astore_0
    //   128: invokestatic 133	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   131: ifeq +7 -> 138
    //   134: aload_3
    //   135: invokevirtual 136	org/json/JSONException:printStackTrace	()V
    //   138: aconst_null
    //   139: astore_3
    //   140: goto -88 -> 52
    //   143: astore_0
    //   144: invokestatic 139	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   147: ifeq -140 -> 7
    //   150: aload_0
    //   151: invokevirtual 136	org/json/JSONException:printStackTrace	()V
    //   154: aconst_null
    //   155: areturn
    //   156: invokestatic 133	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   159: ifeq +28 -> 187
    //   162: ldc 141
    //   164: iconst_2
    //   165: new 44	java/lang/StringBuilder
    //   168: dup
    //   169: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   172: ldc 143
    //   174: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: aload_0
    //   178: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   181: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   184: invokestatic 149	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   82	40	1	i	int
    //   64	22	2	j	int
    //   27	62	3	localObject1	Object
    //   125	10	3	localJSONException1	org.json.JSONException
    //   139	57	3	localObject2	Object
    //   45	68	4	localObject3	Object
    //   189	5	4	localJSONException2	org.json.JSONException
    // Exception table:
    //   from	to	target	type
    //   9	28	125	org/json/JSONException
    //   60	65	143	org/json/JSONException
    //   69	81	143	org/json/JSONException
    //   88	103	143	org/json/JSONException
    //   108	118	143	org/json/JSONException
    //   28	44	189	org/json/JSONException
  }
  
  public static PtvTemplateManager a(AppInterface arg0)
  {
    if (jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager == null) {
        jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager = new PtvTemplateManager();
      }
      return jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager;
    }
  }
  
  public static String a(File paramFile)
  {
    paramFile = FileUtils.a(paramFile);
    if ((paramFile == null) || (paramFile.length <= 0)) {
      return null;
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
  
  private void a(QQAppInterface paramQQAppInterface)
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
          Object localObject = new PtvTemplateManager.4(this, localDoodleInfo, paramQQAppInterface);
          PreDownloadController localPreDownloadController = (PreDownloadController)paramQQAppInterface.getManager(QQManagerFactory.PRE_DOWNLOAD_CONTROLLER_2);
          if (localPreDownloadController.isEnable())
          {
            localObject = new RunnableTask(paramQQAppInterface, "qq_doodle_res", (Runnable)localObject, 4000L);
            localPreDownloadController.requestPreDownload(10020, null, localDoodleInfo.doodleName, 0, localDoodleInfo.doodleUrl, new File(jdField_a_of_type_JavaIoFile, localDoodleInfo.doodleName).getPath(), 2, 0, true, (AbsPreDownloadTask)localObject);
          }
          else
          {
            ThreadManager.post((Runnable)localObject, 8, null, true);
          }
        }
      }
    }
  }
  
  public static boolean a()
  {
    return new File(jdField_a_of_type_JavaIoFile, "dov_doodle_template_new.cfg").exists();
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
          return jdField_a_of_type_JavaLangString + localDoodleInfo.doodleName;
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
    int j;
    int i;
    for (;;)
    {
      synchronized (b)
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
      if (!new File(jdField_a_of_type_JavaIoFile, localDoodleInfo.doodleName).exists())
      {
        if (QLog.isColorLevel()) {
          QLog.d("DOV_Doodle_Strokes_PtvTemplateManager", 2, "getDoodleInfos|file is not exist ");
        }
        localDoodleInfo.doodleUsable = false;
      }
      else
      {
        localFile = new File(jdField_a_of_type_JavaLangString + localDoodleInfo.doodleName + File.separator, "params.json");
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
            break label357;
          }
          localObject2 = ((File)localObject2).listFiles();
          if ((localObject2 == null) || (localObject2.length <= 0)) {
            break label357;
          }
          j = localObject2.length;
          i = 0;
        }
      }
    }
    for (;;)
    {
      if (i < j)
      {
        if (!localObject2[i].getName().endsWith("png")) {}
      }
      else {
        label357:
        for (i = 1;; i = 0)
        {
          if (i == 0)
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
      i += 1;
    }
  }
  
  public void a(AppInterface paramAppInterface, PtvTemplateManager.DoodleInfoLoadObserver paramDoodleInfoLoadObserver)
  {
    File localFile = new File(jdField_a_of_type_JavaIoFile, "dov_doodle_template_new.cfg");
    if (!localFile.exists()) {
      if (QLog.isColorLevel()) {
        QLog.d("DOV_Doodle_Strokes_PtvTemplateManager", 2, "initLocalDoodleInfo config file not exist.");
      }
    }
    do
    {
      return;
      ThreadManager.excute(new PtvTemplateManager.1(this, localFile, paramDoodleInfoLoadObserver, paramAppInterface), 64, null, false);
    } while (!QLog.isDevelopLevel());
    QLog.d("DOV_Doodle_Strokes_PtvTemplateManager", 4, "initLocalDoodleInfo async");
  }
  
  public void a(String arg1, QQAppInterface paramQQAppInterface)
  {
    PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = a(???);
    if (localPtvTemplateInfo == null) {
      return;
    }
    ThreadManager.getFileThreadHandler().post(new PtvTemplateManager.2(this, ???));
    synchronized (b)
    {
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo = localPtvTemplateInfo;
      ThreadManager.getFileThreadHandler().post(new PtvTemplateManager.3(this));
      a(paramQQAppInterface);
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getContext().getSharedPreferences("key_sp_doodle_resource", 4).edit();
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      localEditor.putBoolean("key_doodle_resource_download_fail", paramBoolean).apply();
      return;
    }
  }
  
  public boolean a(PtvTemplateManager.DoodleInfo paramDoodleInfo, boolean paramBoolean)
  {
    if ((paramDoodleInfo == null) || (TextUtils.isEmpty(paramDoodleInfo.doodleName))) {}
    do
    {
      for (;;)
      {
        return false;
        Object localObject = new File(jdField_a_of_type_JavaIoFile, paramDoodleInfo.doodleName);
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
            localObject = FileUtils.c(((File)localObject).getPath());
            if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equalsIgnoreCase(paramDoodleInfo.doodleMd5)))
            {
              if ((!paramBoolean) || (new File(jdField_a_of_type_JavaLangString + paramDoodleInfo.doodleName + File.separator, "params.json").exists())) {
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
              ZipUtils.unZipFile(new File(jdField_a_of_type_JavaIoFile, paramDoodleInfo.doodleName), jdField_a_of_type_JavaLangString);
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
  
  public boolean b()
  {
    return BaseApplicationImpl.getContext().getSharedPreferences("key_sp_doodle_resource", 4).getBoolean("key_doodle_resource_download_fail", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager
 * JD-Core Version:    0.7.0.1
 */