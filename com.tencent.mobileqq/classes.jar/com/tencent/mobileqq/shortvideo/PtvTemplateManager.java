package com.tencent.mobileqq.shortvideo;

import android.os.Build.VERSION;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.aelight.camera.api.ICameraCompatible;
import com.tencent.aelight.camera.constants.CameraCompatibleConstants;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask;
import com.tencent.mobileqq.transfile.predownload.IPreDownloadController;
import com.tencent.mobileqq.transfile.predownload.RunnableTask;
import com.tencent.mobileqq.util.JSONUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.util.VideoSDKMaterialParser;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONArray;
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
  public static String h;
  private static boolean h;
  public static String i;
  public PtvTemplateManager.IPtvTemplateUpdateListener a;
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
  public boolean g;
  
  static
  {
    jdField_a_of_type_JavaLangLong = Long.valueOf(60000L);
    jdField_a_of_type_JavaLangString = "ptv_template_usable";
    jdField_b_of_type_JavaLangString = "ptv_debug";
    jdField_c_of_type_JavaLangString = "ptv_template_usable_doodle";
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_g_of_type_JavaLangString = "5";
    jdField_h_of_type_JavaLangString = "200";
    i = "20";
    int j = 0;
    jdField_a_of_type_Boolean = false;
    jdField_h_of_type_Boolean = false;
    try
    {
      boolean bool = "mounted".equals(Environment.getExternalStorageState());
      j = bool;
    }
    catch (Exception localException)
    {
      label70:
      Object localObject;
      StringBuilder localStringBuilder;
      break label70;
    }
    if (j != 0) {
      localObject = new File(AppConstants.SDCARD_PATH);
    } else {
      localObject = BaseApplicationImpl.getApplication().getCacheDir();
    }
    jdField_a_of_type_JavaIoFile = new File((File)localObject, "ptv_template");
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(jdField_a_of_type_JavaIoFile.getPath());
    localStringBuilder.append(File.separator);
    localStringBuilder.append(jdField_a_of_type_JavaLangString);
    localStringBuilder.append(File.separator);
    jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(jdField_a_of_type_JavaIoFile.getPath());
    localStringBuilder.append(File.separator);
    localStringBuilder.append(jdField_b_of_type_JavaLangString);
    jdField_b_of_type_JavaLangString = localStringBuilder.toString();
    jdField_b_of_type_JavaIoFile = new File((File)localObject, "doodle_template");
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(jdField_b_of_type_JavaIoFile.getPath());
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append(jdField_c_of_type_JavaLangString);
    ((StringBuilder)localObject).append(File.separator);
    jdField_c_of_type_JavaLangString = ((StringBuilder)localObject).toString();
    jdField_h_of_type_Boolean = ((ICameraCompatible)QRoute.api(ICameraCompatible.class)).isFoundProductFeatureRom(CameraCompatibleConstants.E);
  }
  
  private PtvTemplateManager(AppInterface paramAppInterface)
  {
    this.jdField_d_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_g_of_type_Boolean = false;
  }
  
  static PtvTemplateManager.PtvTemplateInfo a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      paramString = (PtvTemplateManager.PtvTemplateInfo)JSONUtils.a(localJSONObject, PtvTemplateManager.PtvTemplateInfo.class);
      localObject = paramString;
      try
      {
        if (!localJSONObject.has("doodleinfo")) {
          break label77;
        }
        localObject = localJSONObject.getJSONArray("doodleinfo");
      }
      catch (JSONException localJSONException1) {}
      localObject = paramString;
    }
    catch (JSONException localJSONException2)
    {
      paramString = null;
    }
    if (QLog.isColorLevel())
    {
      localJSONException2.printStackTrace();
      localObject = paramString;
    }
    label77:
    PtvTemplateManager.DoodleInfo localDoodleInfo = null;
    paramString = (String)localObject;
    Object localObject = localDoodleInfo;
    if (localObject != null)
    {
      if (paramString == null) {
        return null;
      }
      try
      {
        int k = ((JSONArray)localObject).length();
        if (k <= 0) {
          return null;
        }
        paramString.doodleInfos = new ArrayList(k);
        int j = 0;
        while (j < k)
        {
          localDoodleInfo = (PtvTemplateManager.DoodleInfo)JSONUtils.a(((JSONArray)localObject).getJSONObject(j), PtvTemplateManager.DoodleInfo.class);
          if (localDoodleInfo != null) {
            paramString.doodleInfos.add(localDoodleInfo);
          }
          j += 1;
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("parseDoodleConfig|templateInfo= ");
          ((StringBuilder)localObject).append(paramString);
          QLog.d("Doodle_Strokes_PtvTemplateManager", 2, ((StringBuilder)localObject).toString());
        }
        return paramString;
      }
      catch (JSONException paramString)
      {
        if (QLog.isDevelopLevel()) {
          paramString.printStackTrace();
        }
      }
    }
    return null;
  }
  
  public static PtvTemplateManager a(AppInterface paramAppInterface)
  {
    ??? = jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager;
    if (??? != null) {
      return ???;
    }
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager != null)
      {
        paramAppInterface = jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager;
        return paramAppInterface;
      }
      jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager = new PtvTemplateManager(paramAppInterface);
      paramAppInterface = jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager;
      return paramAppInterface;
    }
  }
  
  public static String a(File paramFile)
  {
    paramFile = FileUtils.fileToBytes(paramFile);
    if (paramFile != null)
    {
      if (paramFile.length <= 0) {
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
    }
    return null;
  }
  
  static List<PtvTemplateManager.PtvTemplateInfo> a(PtvTemplateManager paramPtvTemplateManager, String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("parse config: ");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("PtvTemplateManager", 2, ((StringBuilder)localObject).toString());
    }
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      localObject = new JSONObject(paramString);
      if (((JSONObject)localObject).has("content")) {
        paramString = ((JSONObject)localObject).getJSONArray("content");
      } else {
        paramString = null;
      }
      if (paramPtvTemplateManager != null) {}
      try
      {
        if (((JSONObject)localObject).has("guide_video_url")) {
          paramPtvTemplateManager.jdField_d_of_type_JavaLangString = ((JSONObject)localObject).getString("guide_video_url");
        }
        if (((JSONObject)localObject).has("guide_video_md5")) {
          paramPtvTemplateManager.jdField_e_of_type_JavaLangString = ((JSONObject)localObject).getString("guide_video_md5");
        }
        if (((JSONObject)localObject).has("version")) {
          paramPtvTemplateManager.jdField_f_of_type_JavaLangString = ((JSONObject)localObject).getString("version");
        }
        if (((JSONObject)localObject).has("gestureGapFrame")) {
          jdField_g_of_type_JavaLangString = ((JSONObject)localObject).getString("gestureGapFrame");
        }
        if (((JSONObject)localObject).has("gestureGapTime")) {
          jdField_h_of_type_JavaLangString = ((JSONObject)localObject).getString("gestureGapTime");
        }
        if (((JSONObject)localObject).has("gesturethreadcoldtime")) {
          i = ((JSONObject)localObject).getString("gesturethreadcoldtime");
        }
        paramPtvTemplateManager = paramString;
        if (!((JSONObject)localObject).has("gestureShouldUpload")) {
          break label255;
        }
        jdField_a_of_type_Boolean = ((JSONObject)localObject).getBoolean("gestureShouldUpload");
        paramPtvTemplateManager = paramString;
      }
      catch (JSONException localJSONException1) {}
      paramPtvTemplateManager = paramString;
    }
    catch (JSONException localJSONException2)
    {
      paramString = null;
    }
    if (QLog.isColorLevel())
    {
      localJSONException2.printStackTrace();
      paramPtvTemplateManager = paramString;
    }
    label255:
    if (paramPtvTemplateManager == null) {
      return null;
    }
    paramPtvTemplateManager = PtvTemplateManager.PtvTemplateInfo.convertFrom(paramPtvTemplateManager);
    if (paramPtvTemplateManager != null)
    {
      if (paramPtvTemplateManager.isEmpty()) {
        return null;
      }
      return paramPtvTemplateManager;
    }
    return null;
  }
  
  public static void a()
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager != null) {
        jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager = null;
      }
      return;
    }
  }
  
  static void a(String paramString1, String paramString2)
  {
    ThreadManager.getFileThreadHandler().post(new PtvTemplateManager.1(paramString2, paramString1));
  }
  
  public static boolean a()
  {
    return new File(jdField_a_of_type_JavaIoFile, "ptv_template_new.cfg").exists();
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
    PtvTemplateManager.IPtvTemplateUpdateListener localIPtvTemplateUpdateListener = this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$IPtvTemplateUpdateListener;
    if (localIPtvTemplateUpdateListener != null) {
      localIPtvTemplateUpdateListener.a();
    }
  }
  
  public static boolean d()
  {
    return new File(jdField_a_of_type_JavaIoFile, "ptv_template_bless.cfg").exists();
  }
  
  public QQAppInterface a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  public ArrayList<PtvTemplateManager.PtvTemplateInfo> a()
  {
    return this.jdField_c_of_type_JavaUtilArrayList;
  }
  
  public List<VideoMaterial> a()
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
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(jdField_c_of_type_JavaLangString);
            localStringBuilder.append(((PtvTemplateManager.DoodleInfo)localObject3).doodleName);
            localObject3 = VideoSDKMaterialParser.parseVideoMaterialForEdit(localStringBuilder.toString(), "params");
            this.jdField_d_of_type_JavaUtilArrayList.add(localObject3);
            if (QLog.isDevelopLevel()) {
              QLog.d("Doodle_Strokes_PtvTemplateManager", 4, new Object[] { "getDoodleMaterials add DoodleMaterial:", ((VideoMaterial)localObject3).getId() });
            }
          }
        }
      }
    }
    return this.jdField_d_of_type_JavaUtilArrayList;
  }
  
  List<PtvTemplateManager.PtvTemplateInfo> a(AppInterface paramAppInterface, File paramFile, HashMap<String, PtvTemplateManager.PtvTemplateInfo> paramHashMap)
  {
    if (QLog.isColorLevel())
    {
      boolean bool;
      if (paramAppInterface != null) {
        bool = true;
      } else {
        bool = false;
      }
      QLog.i("PtvTemplateManager", 2, String.format("rebuildTemplateInfos, app[%s], isUpdateedByServer[%s], cur_runnable[%s]", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(this.jdField_b_of_type_Boolean), Integer.valueOf(hashCode()) }));
    }
    if (this.jdField_b_of_type_Boolean) {
      return null;
    }
    paramAppInterface = a(paramFile);
    if (TextUtils.isEmpty(paramAppInterface)) {
      return null;
    }
    paramAppInterface = a(this, paramAppInterface);
    if (paramAppInterface != null)
    {
      if (paramAppInterface.isEmpty()) {
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
    return null;
  }
  
  void a(QQAppInterface paramQQAppInterface, ArrayList<PtvTemplateManager.PtvTemplateInfo> paramArrayList)
  {
    ThreadManager.getSubThreadHandler().postDelayed(new PtvTemplateManager.3(this, paramArrayList), jdField_a_of_type_JavaLangLong.longValue());
  }
  
  public void a(Runnable paramRunnable)
  {
    PtvTemplateManager.5 local5 = new PtvTemplateManager.5(this, paramRunnable);
    if (QLog.isDevelopLevel())
    {
      boolean bool;
      if (paramRunnable != null) {
        bool = true;
      } else {
        bool = false;
      }
      QLog.d("PtvTemplateManager", 2, String.format("双人挂件加载, onInitFinishSink[%s], runnable[%s]", new Object[] { Boolean.valueOf(bool), Integer.valueOf(local5.hashCode()) }));
    }
    ThreadManager.postImmediately(local5, null, false);
  }
  
  public void a(String arg1, QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = a(???);
    if (paramQQAppInterface == null) {
      return;
    }
    ThreadManager.getFileThreadHandler().post(new PtvTemplateManager.12(this, ???));
    synchronized (this.jdField_d_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo = paramQQAppInterface;
      ThreadManager.getFileThreadHandler().post(new PtvTemplateManager.13(this));
      b();
      return;
    }
  }
  
  public void a(String paramString, QQAppInterface paramQQAppInterface, int paramInt)
  {
    List localList = a(null, paramString);
    if (localList != null)
    {
      if (localList.isEmpty()) {
        return;
      }
      ArrayList localArrayList;
      String str;
      if (paramInt == 1)
      {
        localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
        str = "ptv_template_new.cfg";
      }
      else
      {
        localArrayList = this.jdField_b_of_type_JavaUtilArrayList;
        str = "ptv_template_web.cfg";
      }
      a(paramString, str);
      a(localList, paramInt);
      if (this.jdField_d_of_type_Boolean) {
        return;
      }
      ThreadManager.getFileThreadHandler().post(new PtvTemplateManager.2(this, localList));
      a(paramQQAppInterface, localArrayList);
    }
  }
  
  void a(ArrayList<PtvTemplateManager.PtvTemplateInfo> paramArrayList)
  {
    if (paramArrayList != null)
    {
      if (paramArrayList.isEmpty()) {
        return;
      }
      int j = 0;
      while (j < paramArrayList.size())
      {
        PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)paramArrayList.get(j);
        if ((localPtvTemplateInfo != null) && (localPtvTemplateInfo.predownload) && (!TextUtils.isEmpty(localPtvTemplateInfo.resurl))) {
          ThreadManager.getFileThreadHandler().post(new PtvTemplateManager.4(this, localPtvTemplateInfo));
        }
        j += 1;
      }
    }
  }
  
  void a(List<PtvTemplateManager.PtvTemplateInfo> paramList) {}
  
  public void a(List<PtvTemplateManager.PtvTemplateInfo> paramList, int paramInt)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
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
  }
  
  public boolean a(PtvTemplateManager.DoodleInfo paramDoodleInfo, boolean paramBoolean)
  {
    if (paramDoodleInfo != null)
    {
      if (TextUtils.isEmpty(paramDoodleInfo.doodleName)) {
        return false;
      }
      Object localObject = new File(jdField_b_of_type_JavaIoFile, paramDoodleInfo.doodleName);
      if (!((File)localObject).exists())
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("isDoodleTemplateUsable|file is not exist -> ");
          ((StringBuilder)localObject).append(paramDoodleInfo.doodleName);
          QLog.d("Doodle_Strokes_PtvTemplateManager", 2, ((StringBuilder)localObject).toString());
        }
        return false;
      }
      try
      {
        localObject = FileUtils.calcMd5(((File)localObject).getPath());
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equalsIgnoreCase(paramDoodleInfo.doodleMd5)))
        {
          if (paramBoolean)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(jdField_c_of_type_JavaLangString);
            ((StringBuilder)localObject).append(paramDoodleInfo.doodleName);
            ((StringBuilder)localObject).append(File.separator);
            if (!new File(((StringBuilder)localObject).toString(), "params.json").exists())
            {
              if (QLog.isColorLevel())
              {
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append("isDoodleTemplateUsable|paramFile is not exist->>");
                ((StringBuilder)localObject).append(paramDoodleInfo.doodleName);
                QLog.d("Doodle_Strokes_PtvTemplateManager", 2, ((StringBuilder)localObject).toString());
              }
              try
              {
                ZipUtils.unZipFile(new File(jdField_b_of_type_JavaIoFile, paramDoodleInfo.doodleName), jdField_c_of_type_JavaLangString);
                if (QLog.isColorLevel())
                {
                  localObject = new StringBuilder();
                  ((StringBuilder)localObject).append("isDoodleTemplateUsable|unZipFile->>");
                  ((StringBuilder)localObject).append(paramDoodleInfo.doodleName);
                  QLog.d("Doodle_Strokes_PtvTemplateManager", 2, ((StringBuilder)localObject).toString());
                }
                return true;
              }
              catch (IOException paramDoodleInfo)
              {
                if (QLog.isColorLevel()) {
                  paramDoodleInfo.printStackTrace();
                }
                return false;
              }
            }
          }
          return true;
        }
        return false;
      }
      catch (UnsatisfiedLinkError paramDoodleInfo)
      {
        if (QLog.isColorLevel()) {
          paramDoodleInfo.printStackTrace();
        }
      }
    }
    return false;
  }
  
  public boolean a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo)
  {
    if (paramPtvTemplateInfo != null)
    {
      if (TextUtils.isEmpty(paramPtvTemplateInfo.name)) {
        return false;
      }
      Object localObject1 = new File(jdField_a_of_type_JavaIoFile, paramPtvTemplateInfo.name);
      if (!((File)localObject1).exists()) {
        return false;
      }
      try
      {
        localObject1 = FileUtils.calcMd5(((File)localObject1).getPath());
        if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (((String)localObject1).equalsIgnoreCase(paramPtvTemplateInfo.md5)))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(jdField_a_of_type_JavaLangString);
          ((StringBuilder)localObject1).append(paramPtvTemplateInfo.name);
          ((StringBuilder)localObject1).append(File.separator);
          Object localObject2 = ((StringBuilder)localObject1).toString();
          localObject1 = new File((String)localObject2, "params.json");
          localObject2 = new File((String)localObject2, "params.dat");
          if ((!((File)localObject1).exists()) && (!((File)localObject2).exists())) {
            try
            {
              ZipUtils.unZipFile(new File(jdField_a_of_type_JavaIoFile, paramPtvTemplateInfo.name), jdField_a_of_type_JavaLangString);
              return true;
            }
            catch (Exception paramPtvTemplateInfo)
            {
              if (QLog.isColorLevel()) {
                paramPtvTemplateInfo.printStackTrace();
              }
              return false;
            }
          }
          return true;
        }
        return false;
      }
      catch (UnsatisfiedLinkError paramPtvTemplateInfo)
      {
        if (QLog.isColorLevel()) {
          paramPtvTemplateInfo.printStackTrace();
        }
      }
    }
    return false;
  }
  
  void b()
  {
    QQAppInterface localQQAppInterface = a();
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo;
    if ((localObject1 != null) && (!((PtvTemplateManager.PtvTemplateInfo)localObject1).doodleInfos.isEmpty()) && (localQQAppInterface != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Doodle_Strokes_PtvTemplateManager", 2, "preDownloadDoodleTemplate!");
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.doodleInfos.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        PtvTemplateManager.DoodleInfo localDoodleInfo = (PtvTemplateManager.DoodleInfo)((Iterator)localObject1).next();
        if ((localDoodleInfo != null) && (!TextUtils.isEmpty(localDoodleInfo.doodleUrl)) && (!localDoodleInfo.doodleUsable))
        {
          Object localObject2 = new PtvTemplateManager.14(this, localDoodleInfo);
          IPreDownloadController localIPreDownloadController = (IPreDownloadController)localQQAppInterface.getRuntimeService(IPreDownloadController.class);
          if (localIPreDownloadController.isEnable())
          {
            localObject2 = new RunnableTask(localQQAppInterface, "qq_doodle_res", (Runnable)localObject2, 4000L);
            localIPreDownloadController.requestPreDownload(10020, null, localDoodleInfo.doodleName, 0, localDoodleInfo.doodleUrl, new File(jdField_b_of_type_JavaIoFile, localDoodleInfo.doodleName).getPath(), 2, 0, true, (AbsPreDownloadTask)localObject2);
          }
          else
          {
            ThreadManager.post((Runnable)localObject2, 8, null, true);
          }
        }
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Doodle_Strokes_PtvTemplateManager", 2, "Exception!");
    }
  }
  
  public void b(String arg1, QQAppInterface paramQQAppInterface)
  {
    List localList = a(null, ???);
    if (localList != null)
    {
      if (localList.isEmpty()) {
        return;
      }
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
        this.jdField_f_of_type_Boolean = true;
        if (this.jdField_g_of_type_Boolean) {
          return;
        }
        ThreadManager.getFileThreadHandler().post(new PtvTemplateManager.16(this, localList));
        a(paramQQAppInterface, this.jdField_e_of_type_JavaUtilArrayList);
        return;
      }
    }
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.PtvTemplateManager
 * JD-Core Version:    0.7.0.1
 */