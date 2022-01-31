package dov.com.tencent.mobileqq.shortvideo;

import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Environment;
import android.text.TextUtils;
import aoot;
import aoou;
import aoov;
import aoow;
import aooy;
import aooz;
import aopa;
import aopb;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.mobileqq.shortvideo.common.Observable;
import com.tencent.mobileqq.shortvideo.common.Observer;
import com.tencent.mobileqq.shortvideo.ptvfilter.material.MovieMaterial;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.QIMSegmentCaptureManager;
import dov.com.qq.im.capture.IQIMManager;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.adapter.QIMPtvTemplateAdapter;
import dov.com.qq.im.capture.data.QIMRedDotConfig;
import dov.com.qq.im.capture.data.QIMRedDotConfig.CategoryRedConfig;
import dov.com.qq.im.capture.data.QIMRedDotConfig.RedDotItemConfig;
import dov.com.qq.im.capture.data.TemplateGroupItem;
import dov.com.qq.im.capture.music.CaptureConfigUpdateObserver;
import dov.com.tencent.mobileqq.richmedia.capture.util.DanceGameReporter;
import dov.com.tencent.mobileqq.shortvideo.util.FaceDanceEntryUtil;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class QIMPtvTemplateManager
  extends IQIMManager
{
  public static int a;
  public static File a;
  public static final Long a;
  public static Object a;
  public static String a;
  public static AtomicBoolean a;
  public static File b;
  public static String b;
  public static String c;
  private Observable jdField_a_of_type_ComTencentMobileqqShortvideoCommonObservable;
  private MovieMaterial jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterMaterialMovieMaterial;
  public QIMRedDotConfig a;
  private TemplateGroupItem jdField_a_of_type_DovComQqImCaptureDataTemplateGroupItem;
  private PtvTemplateManager.IPtvTemplateDownloadListener jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$IPtvTemplateDownloadListener;
  ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  public List a;
  public boolean a;
  private TemplateGroupItem b;
  public Object b;
  public ArrayList b;
  public boolean b;
  private Object c;
  String d;
  String e;
  
  static
  {
    jdField_a_of_type_JavaLangLong = Long.valueOf(60000L);
    jdField_a_of_type_JavaLangString = "ptv_template_usable";
    jdField_b_of_type_JavaLangString = "ptv_debug";
    jdField_c_of_type_JavaLangString = "ptv_template_usable_doodle";
    jdField_a_of_type_JavaLangObject = new Object();
    try
    {
      bool = "mounted".equals(Environment.getExternalStorageState());
      if (bool)
      {
        File localFile1 = new File(AppConstants.aJ);
        jdField_a_of_type_JavaIoFile = new File(localFile1, "dov_ptv_template_dov");
        jdField_a_of_type_JavaLangString = jdField_a_of_type_JavaIoFile.getPath() + File.separator + jdField_a_of_type_JavaLangString + File.separator;
        jdField_b_of_type_JavaLangString = jdField_a_of_type_JavaIoFile.getPath() + File.separator + jdField_b_of_type_JavaLangString;
        jdField_b_of_type_JavaIoFile = new File(localFile1, "doodle_template");
        jdField_c_of_type_JavaLangString = jdField_b_of_type_JavaIoFile.getPath() + File.separator + jdField_c_of_type_JavaLangString + File.separator;
        jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
        jdField_a_of_type_Int = 10;
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        boolean bool = false;
        continue;
        File localFile2 = BaseApplicationImpl.getApplication().getCacheDir();
      }
    }
  }
  
  public QIMPtvTemplateManager()
  {
    this.jdField_b_of_type_JavaLangObject = new Object();
    this.jdField_c_of_type_JavaLangObject = new Object();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
    c();
  }
  
  private int a(List paramList, String paramString)
  {
    int j;
    if ((paramList == null) || (paramList.size() <= 0))
    {
      j = -1;
      return j;
    }
    int i = 0;
    for (;;)
    {
      if (i >= paramList.size()) {
        break label61;
      }
      j = i;
      if (((PtvTemplateManager.PtvTemplateInfo)paramList.get(i)).id.equals(paramString)) {
        break;
      }
      i += 1;
    }
    label61:
    return -1;
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
  
  private ArrayList a(ArrayList paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      TemplateGroupItem localTemplateGroupItem = b((TemplateGroupItem)paramArrayList.next());
      if ((localTemplateGroupItem != null) && (localTemplateGroupItem.jdField_a_of_type_JavaUtilList.size() > 0)) {
        localArrayList.add(localTemplateGroupItem);
      } else if (QLog.isColorLevel()) {
        QLog.d("QIMPtvTemplateManager", 2, "templateInfoList.size() == 0 all not support segment should hide tab!");
      }
    }
    return localArrayList;
  }
  
  public static List a(QIMPtvTemplateManager paramQIMPtvTemplateManager, String paramString, QIMRedDotConfig paramQIMRedDotConfig)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.i("QIMPtvTemplateManager", 2, "parseConfigRaw " + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        if (paramQIMPtvTemplateManager != null)
        {
          if (paramString.has("guide_video_url")) {
            paramQIMPtvTemplateManager.d = paramString.getString("guide_video_url");
          }
          if (paramString.has("guide_video_md5")) {
            paramQIMPtvTemplateManager.e = paramString.getString("guide_video_md5");
          }
        }
        if (paramQIMRedDotConfig != null)
        {
          int j = paramString.optInt("iconRedDotVersion");
          boolean bool = paramString.optBoolean("needRedDot");
          if (QLog.isColorLevel()) {
            QLog.d("QIMRedDotConfig_PTV", 2, "parseConfig|oldVer= " + paramQIMRedDotConfig.iconVersion + ",ver=" + j + ",showRed=" + bool);
          }
          if (paramQIMRedDotConfig.iconVersion != j)
          {
            paramQIMRedDotConfig.iconVersion = j;
            paramQIMRedDotConfig.showRedDot = bool;
            paramQIMRedDotConfig.hasShow = false;
            paramQIMRedDotConfig.firstShowTime = 0L;
          }
          j = paramString.optInt("defaultCategoryVersion");
          int k = paramString.optInt("defaultCategoryId", -1);
          if (QLog.isColorLevel()) {
            QLog.d("QIMRedDotConfig_PTV", 2, "parseConfig|oldVer= " + paramQIMRedDotConfig.defaultCategoryVer + ",ver=" + j + ",defaultCategoryId=" + k);
          }
          if (paramQIMRedDotConfig.defaultCategoryVer != j)
          {
            paramQIMRedDotConfig.defaultCategoryVer = j;
            paramQIMRedDotConfig.defaultCategoryId = k;
            paramQIMRedDotConfig.hasChoose = false;
          }
          j = paramString.optInt("defaultUseVersion");
          paramQIMPtvTemplateManager = paramString.optString("defaultUseId");
          if (QLog.isColorLevel()) {
            QLog.d("QIMRedDotConfig_PTV", 2, "parseConfig|oldVer= " + paramQIMRedDotConfig.defaultUseVer + ",ver=" + j + ",defaultUseId=" + paramQIMPtvTemplateManager);
          }
          if (paramQIMRedDotConfig.defaultUseVer != j)
          {
            paramQIMRedDotConfig.defaultUseVer = j;
            paramQIMRedDotConfig.defaultUseId = paramQIMPtvTemplateManager;
            paramQIMRedDotConfig.hasUse = false;
          }
          j = paramString.optInt("itemRedDotVersion");
          if (paramQIMRedDotConfig.redDotVersion != j)
          {
            paramQIMRedDotConfig.redDotVersion = j;
            paramQIMRedDotConfig.redDotItems.clear();
            if (paramString.has("itemNeedRedDot"))
            {
              paramQIMPtvTemplateManager = new StringBuilder();
              paramQIMPtvTemplateManager.append("parseConfig|redDotList:");
              JSONArray localJSONArray = paramString.getJSONArray("itemNeedRedDot");
              if (i < localJSONArray.length())
              {
                String str = localJSONArray.optString(i);
                if (TextUtils.isEmpty(str)) {
                  break label616;
                }
                QIMRedDotConfig.RedDotItemConfig localRedDotItemConfig = new QIMRedDotConfig.RedDotItemConfig();
                localRedDotItemConfig.filterId = str;
                paramQIMPtvTemplateManager.append(str).append(",");
                paramQIMRedDotConfig.redDotItems.put(str, localRedDotItemConfig);
                break label616;
              }
              if (QLog.isColorLevel()) {
                QLog.d("QIMRedDotConfig_PTV", 2, "parseConfig|redDotItem= " + paramQIMPtvTemplateManager.toString());
              }
            }
          }
        }
        if (!paramString.has("category")) {
          break;
        }
        paramQIMPtvTemplateManager = a(paramString.getJSONArray("category"), paramQIMRedDotConfig);
        return paramQIMPtvTemplateManager;
      }
      catch (JSONException paramQIMPtvTemplateManager) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      paramQIMPtvTemplateManager.printStackTrace();
      return null;
      label616:
      i += 1;
    }
  }
  
  static List a(JSONArray paramJSONArray, QIMRedDotConfig paramQIMRedDotConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QIMPtvTemplateManager", 2, "parse config: " + paramJSONArray);
    }
    if (paramJSONArray == null) {
      return null;
    }
    int j = paramJSONArray.length();
    if (j <= 0) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < j) {}
    for (;;)
    {
      TemplateGroupItem localTemplateGroupItem;
      Object localObject3;
      int k;
      Object localObject4;
      try
      {
        localTemplateGroupItem = new TemplateGroupItem();
        localObject3 = paramJSONArray.getJSONObject(i);
        if (((JSONObject)localObject3).has("content")) {
          localTemplateGroupItem.jdField_a_of_type_JavaUtilList = PtvTemplateManager.PtvTemplateInfo.convertFrom(((JSONObject)localObject3).getJSONArray("content"));
        }
        if (((JSONObject)localObject3).has("categoryName")) {
          localTemplateGroupItem.jdField_a_of_type_JavaLangString = ((JSONObject)localObject3).getString("categoryName");
        }
        localTemplateGroupItem.jdField_a_of_type_Boolean = "1".equals(((JSONObject)localObject3).optString("random_position"));
        if (!((JSONObject)localObject3).has("categoryId")) {
          break label401;
        }
        localTemplateGroupItem.jdField_a_of_type_Int = ((JSONObject)localObject3).getInt("categoryId");
        if (paramQIMRedDotConfig == null) {
          break label619;
        }
        k = ((JSONObject)localObject3).optInt("redDotVersion");
        bool = ((JSONObject)localObject3).optBoolean("needRedDot");
        localObject1 = (QIMRedDotConfig.CategoryRedConfig)paramQIMRedDotConfig.categories.get(Integer.valueOf(localTemplateGroupItem.jdField_a_of_type_Int));
        if (localObject1 != null)
        {
          if (((QIMRedDotConfig.CategoryRedConfig)localObject1).version == k) {
            break label616;
          }
          ((QIMRedDotConfig.CategoryRedConfig)localObject1).version = k;
          ((QIMRedDotConfig.CategoryRedConfig)localObject1).showRedDot = bool;
          ((QIMRedDotConfig.CategoryRedConfig)localObject1).hasShow = false;
          ((QIMRedDotConfig.CategoryRedConfig)localObject1).firstShowTime = 0L;
          if ((localTemplateGroupItem.jdField_a_of_type_JavaUtilList == null) || (localTemplateGroupItem.jdField_a_of_type_JavaUtilList.isEmpty())) {
            break label374;
          }
          localObject4 = localTemplateGroupItem.jdField_a_of_type_JavaUtilList.iterator();
          if (!((Iterator)localObject4).hasNext()) {
            break label374;
          }
          ((PtvTemplateManager.PtvTemplateInfo)((Iterator)localObject4).next()).categoryId = localTemplateGroupItem.jdField_a_of_type_Int;
          continue;
          return localArrayList;
        }
      }
      catch (JSONException paramJSONArray)
      {
        if (QLog.isColorLevel()) {
          paramJSONArray.printStackTrace();
        }
      }
      Object localObject1 = new QIMRedDotConfig.CategoryRedConfig();
      ((QIMRedDotConfig.CategoryRedConfig)localObject1).categoryId = localTemplateGroupItem.jdField_a_of_type_Int;
      ((QIMRedDotConfig.CategoryRedConfig)localObject1).version = k;
      ((QIMRedDotConfig.CategoryRedConfig)localObject1).showRedDot = bool;
      continue;
      label374:
      if ((paramQIMRedDotConfig != null) && (localObject1 != null)) {
        paramQIMRedDotConfig.categories.put(Integer.valueOf(((QIMRedDotConfig.CategoryRedConfig)localObject1).categoryId), localObject1);
      }
      label401:
      boolean bool = ((JSONObject)localObject3).has("commonRes");
      if (bool) {
        try
        {
          Object localObject5 = ((JSONObject)localObject3).getJSONObject("commonRes");
          localObject1 = ((JSONObject)localObject5).getString("dg_stage_name");
          localObject3 = ((JSONObject)localObject5).getString("dg_stage_resurl");
          localObject4 = ((JSONObject)localObject5).getString("dg_stage_resmd5");
          String str1 = ((JSONObject)localObject5).getString("dg_model_name");
          String str2 = ((JSONObject)localObject5).getString("dg_model_resurl");
          localObject5 = ((JSONObject)localObject5).getString("dg_model_resmd5");
          if (localTemplateGroupItem.jdField_a_of_type_JavaUtilList != null)
          {
            Iterator localIterator = localTemplateGroupItem.jdField_a_of_type_JavaUtilList.iterator();
            while (localIterator.hasNext())
            {
              PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)localIterator.next();
              if ((localPtvTemplateInfo.kind == 5) || (localPtvTemplateInfo.kind == 6))
              {
                localPtvTemplateInfo.dgStageName = ((String)localObject1);
                localPtvTemplateInfo.dgStageResurl = ((String)localObject3);
                localPtvTemplateInfo.dgStageResmd5 = ((String)localObject4);
                localPtvTemplateInfo.dgModelName = str1;
                localPtvTemplateInfo.dgModelResurl = str2;
                localPtvTemplateInfo.dgModelResmd5 = ((String)localObject5);
              }
            }
          }
          localArrayList.add(localTemplateGroupItem);
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
      i += 1;
      break;
      label616:
      continue;
      label619:
      Object localObject2 = null;
    }
  }
  
  private void a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, String arg2)
  {
    this.jdField_a_of_type_JavaUtilArrayList.remove(???);
    if (b(paramPtvTemplateInfo))
    {
      paramPtvTemplateInfo.usable = a(paramPtvTemplateInfo);
      synchronized (this.jdField_b_of_type_JavaLangObject)
      {
        PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo;
        do
        {
          Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
          Object localObject;
          while (!((Iterator)localObject).hasNext())
          {
            do
            {
              if (!localIterator.hasNext()) {
                break;
              }
              localObject = (TemplateGroupItem)localIterator.next();
            } while (((TemplateGroupItem)localObject).jdField_a_of_type_JavaUtilList == null);
            localObject = ((TemplateGroupItem)localObject).jdField_a_of_type_JavaUtilList.iterator();
          }
          localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)((Iterator)localObject).next();
        } while (!localPtvTemplateInfo.id.equals(paramPtvTemplateInfo.id));
        localPtvTemplateInfo.usable = a(localPtvTemplateInfo);
      }
      if (this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$IPtvTemplateDownloadListener != null) {
        this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$IPtvTemplateDownloadListener.a(paramPtvTemplateInfo, paramPtvTemplateInfo.usable);
      }
      if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0) {
        this.jdField_a_of_type_JavaUtilHashMap.clear();
      }
    }
  }
  
  private void a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, String paramString, long paramLong1, long paramLong2)
  {
    paramString = (aopb)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if (paramString != null)
    {
      paramString.jdField_a_of_type_Long = paramLong1;
      paramString.b = paramLong2;
      paramString.jdField_a_of_type_Boolean = true;
      paramLong2 = 0L;
      long l2 = 1L;
      paramLong1 = l2;
      long l1 = paramLong2;
      if (!paramPtvTemplateInfo.dgStageUsable)
      {
        paramString = (aopb)this.jdField_a_of_type_JavaUtilHashMap.get(paramPtvTemplateInfo.dgStageName);
        paramLong1 = l2;
        l1 = paramLong2;
        if (paramString != null)
        {
          if (!paramString.jdField_a_of_type_Boolean) {
            break label255;
          }
          l1 = 0L + paramString.jdField_a_of_type_Long;
          paramLong1 = paramString.b + 1L;
        }
      }
      paramLong2 = paramLong1;
      l2 = l1;
      if (!paramPtvTemplateInfo.dgModelUsable)
      {
        paramString = (aopb)this.jdField_a_of_type_JavaUtilHashMap.get(paramPtvTemplateInfo.dgModelName);
        paramLong2 = paramLong1;
        l2 = l1;
        if (paramString != null)
        {
          if (!paramString.jdField_a_of_type_Boolean) {
            break label268;
          }
          l2 = l1 + paramString.jdField_a_of_type_Long;
          paramLong2 = paramLong1 + paramString.b;
        }
      }
      label164:
      paramLong1 = paramLong2;
      l1 = l2;
      if (!paramPtvTemplateInfo.usable)
      {
        paramString = (aopb)this.jdField_a_of_type_JavaUtilHashMap.get(paramPtvTemplateInfo.name);
        paramLong1 = paramLong2;
        l1 = l2;
        if (paramString != null)
        {
          if (!paramString.jdField_a_of_type_Boolean) {
            break label282;
          }
          l1 = l2 + paramString.jdField_a_of_type_Long;
          paramLong1 = paramLong2 + paramString.b;
        }
      }
      for (;;)
      {
        if (this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$IPtvTemplateDownloadListener != null) {
          this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$IPtvTemplateDownloadListener.a(paramPtvTemplateInfo, (int)(l1 * 100L / paramLong1));
        }
        return;
        label255:
        paramLong1 = 1000L + 1L;
        l1 = paramLong2;
        break;
        label268:
        paramLong2 = paramLong1 + 1000L;
        l2 = l1;
        break label164;
        label282:
        paramLong1 = paramLong2 + 1000L;
        l1 = l2;
      }
    }
    QLog.d("QIMPtvTemplateManager", 1, "ProcessUpdate error occur! info:" + paramPtvTemplateInfo.toString());
  }
  
  static void a(String paramString1, String paramString2)
  {
    ThreadManager.getFileThreadHandler().post(new aoou(paramString2, paramString1));
  }
  
  public static boolean a()
  {
    boolean bool = new File(jdField_a_of_type_JavaIoFile, "ptv_template_new.cfg").exists();
    if (QLog.isColorLevel()) {
      QLog.i("QIMPtvTemplateManager", 2, "QIMPtvTemplateManager isStickerConfigFileExist" + bool);
    }
    return bool;
  }
  
  private TemplateGroupItem b(TemplateGroupItem paramTemplateGroupItem)
  {
    if (paramTemplateGroupItem == null) {
      return null;
    }
    Object localObject = (QIMSegmentCaptureManager)QIMManager.a().c(13);
    paramTemplateGroupItem = paramTemplateGroupItem.a();
    if ((localObject == null) || (!((QIMSegmentCaptureManager)localObject).a()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QIMPtvTemplateManager", 2, "[segmentCapture] update template, not in segment mode");
      }
      return paramTemplateGroupItem;
    }
    localObject = paramTemplateGroupItem.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)((Iterator)localObject).next();
      if (!localPtvTemplateInfo.multivideosupport)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QIMPtvTemplateManager", 2, "should hide template not support segment, categoryID=" + localPtvTemplateInfo.categoryId + ", templateID = " + localPtvTemplateInfo.id + ", templateName = " + localPtvTemplateInfo.name);
        }
        ((Iterator)localObject).remove();
      }
    }
    return paramTemplateGroupItem;
  }
  
  private ArrayList b()
  {
    ArrayList localArrayList1 = new ArrayList();
    localArrayList1.addAll(this.jdField_a_of_type_JavaUtilList);
    boolean bool1 = QmcfManager.a().a(2);
    boolean bool2 = FaceDanceEntryUtil.c();
    if ((!bool1) || (!bool2))
    {
      for (;;)
      {
        Iterator localIterator1;
        List localList;
        synchronized (this.jdField_b_of_type_JavaLangObject)
        {
          localIterator1 = localArrayList1.iterator();
          if (!localIterator1.hasNext()) {
            break;
          }
          localList = ((TemplateGroupItem)localIterator1.next()).jdField_a_of_type_JavaUtilList;
          Iterator localIterator2 = localList.iterator();
          if (localIterator2.hasNext())
          {
            PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)localIterator2.next();
            if (((bool1) || (localPtvTemplateInfo.kind != 5)) && ((bool2) || (localPtvTemplateInfo.kind != 6))) {
              continue;
            }
            if (QLog.isColorLevel()) {
              QLog.d("QIMPtvTemplateManager", 2, "should hide dg template! isQmcfEnableEntry=" + bool1 + " isFaceDanceEnableEntry=" + bool2 + " categoryID=" + localPtvTemplateInfo.categoryId);
            }
            localIterator2.remove();
          }
        }
        if (localList.size() == 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("QIMPtvTemplateManager", 2, "templateInfoList.size() == 0 should hide dg tab!");
          }
          localIterator1.remove();
        }
      }
      DanceGameReporter.a().a(bool1, bool2);
    }
    return localArrayList2;
  }
  
  private boolean b()
  {
    return (this.jdField_a_of_type_DovComQqImCaptureDataTemplateGroupItem != null) && (this.jdField_a_of_type_DovComQqImCaptureDataTemplateGroupItem.jdField_a_of_type_JavaUtilList.size() >= 100);
  }
  
  private boolean b(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo)
  {
    return (this.jdField_a_of_type_JavaUtilArrayList.size() == 0) || ((!this.jdField_a_of_type_JavaUtilArrayList.contains(paramPtvTemplateInfo.dgStageName)) && (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramPtvTemplateInfo.dgModelName)) && (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramPtvTemplateInfo.name)));
  }
  
  /* Error */
  private static boolean b(String paramString1, String paramString2, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 245	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +5 -> 9
    //   7: iconst_0
    //   8: ireturn
    //   9: new 73	java/io/File
    //   12: dup
    //   13: getstatic 88	dov/com/tencent/mobileqq/shortvideo/QIMPtvTemplateManager:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   16: aload_0
    //   17: invokespecial 86	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   20: astore_3
    //   21: aload_3
    //   22: invokevirtual 558	java/io/File:exists	()Z
    //   25: ifeq -18 -> 7
    //   28: aload_3
    //   29: invokevirtual 94	java/io/File:getPath	()Ljava/lang/String;
    //   32: invokestatic 634	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/lang/String;)Ljava/lang/String;
    //   35: astore_3
    //   36: aload_3
    //   37: invokestatic 245	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   40: ifne -33 -> 7
    //   43: aload_3
    //   44: aload_1
    //   45: invokevirtual 637	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   48: ifeq -41 -> 7
    //   51: new 90	java/lang/StringBuilder
    //   54: dup
    //   55: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   58: getstatic 42	dov/com/tencent/mobileqq/shortvideo/QIMPtvTemplateManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   61: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: aload_0
    //   65: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: getstatic 101	java/io/File:separator	Ljava/lang/String;
    //   71: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: astore_3
    //   78: new 73	java/io/File
    //   81: dup
    //   82: aload_3
    //   83: ldc_w 639
    //   86: invokespecial 640	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   89: astore_1
    //   90: new 73	java/io/File
    //   93: dup
    //   94: aload_3
    //   95: ldc_w 642
    //   98: invokespecial 640	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   101: astore_3
    //   102: aload_1
    //   103: invokevirtual 558	java/io/File:exists	()Z
    //   106: ifne +59 -> 165
    //   109: iload_2
    //   110: ifeq +10 -> 120
    //   113: aload_3
    //   114: invokevirtual 558	java/io/File:exists	()Z
    //   117: ifne +48 -> 165
    //   120: new 73	java/io/File
    //   123: dup
    //   124: getstatic 88	dov/com/tencent/mobileqq/shortvideo/QIMPtvTemplateManager:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   127: aload_0
    //   128: invokespecial 86	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   131: getstatic 42	dov/com/tencent/mobileqq/shortvideo/QIMPtvTemplateManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   134: invokestatic 646	com/tencent/biz/common/util/ZipUtils:a	(Ljava/io/File;Ljava/lang/String;)V
    //   137: iconst_1
    //   138: ireturn
    //   139: astore_0
    //   140: invokestatic 224	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   143: ifeq -136 -> 7
    //   146: aload_0
    //   147: invokevirtual 647	java/lang/UnsatisfiedLinkError:printStackTrace	()V
    //   150: iconst_0
    //   151: ireturn
    //   152: astore_0
    //   153: invokestatic 224	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   156: ifeq -149 -> 7
    //   159: aload_0
    //   160: invokevirtual 482	java/lang/Exception:printStackTrace	()V
    //   163: iconst_0
    //   164: ireturn
    //   165: iconst_1
    //   166: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	167	0	paramString1	String
    //   0	167	1	paramString2	String
    //   0	167	2	paramBoolean	boolean
    //   20	94	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   28	36	139	java/lang/UnsatisfiedLinkError
    //   120	137	152	java/lang/Exception
  }
  
  public int a()
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_DovComQqImCaptureDataQIMRedDotConfig != null) && (!this.jdField_a_of_type_DovComQqImCaptureDataQIMRedDotConfig.hasChoose))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QIMRedDotConfig_PTV", 2, "getDefaultCategoryId=" + this.jdField_a_of_type_DovComQqImCaptureDataQIMRedDotConfig.defaultCategoryId);
        }
        int i = this.jdField_a_of_type_DovComQqImCaptureDataQIMRedDotConfig.defaultCategoryId;
        return i;
      }
      return -1;
    }
  }
  
  public MovieMaterial a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterMaterialMovieMaterial;
  }
  
  public TemplateGroupItem a(TemplateGroupItem paramTemplateGroupItem)
  {
    int i = 0;
    ??? = BaseApplicationImpl.getApplication().getSharedPreferences("recent_template_setting", 0);
    Object localObject2 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    ??? = ((SharedPreferences)???).getString("recent_template_list" + (String)localObject2, null);
    if (QLog.isColorLevel()) {
      QLog.d("QIMPtvTemplateManager", 2, "getRecentTemplate list=" + (String)???);
    }
    if (??? == null) {
      return paramTemplateGroupItem;
    }
    localObject2 = ((String)???).split("\\$");
    for (;;)
    {
      Object localObject3;
      synchronized (this.jdField_c_of_type_JavaLangObject)
      {
        paramTemplateGroupItem.jdField_a_of_type_JavaUtilList.clear();
        if (i >= localObject2.length) {
          break label211;
        }
        localObject3 = localObject2[i].split("\\|");
        if ((localObject3 == null) || (localObject3.length != 2)) {
          break label215;
        }
        Integer.valueOf(localObject3[1]).intValue();
        localObject3 = a(localObject3[0]);
        if (localObject3 == null) {
          break label215;
        }
        if (paramTemplateGroupItem.jdField_a_of_type_JavaUtilList.size() >= 100) {
          return paramTemplateGroupItem;
        }
      }
      paramTemplateGroupItem.jdField_a_of_type_JavaUtilList.add(localObject3);
      break label215;
      label211:
      return paramTemplateGroupItem;
      label215:
      i += 1;
    }
  }
  
  public PtvTemplateManager.PtvTemplateInfo a()
  {
    PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo;
    do
    {
      Iterator localIterator = a().iterator();
      Object localObject;
      while (!((Iterator)localObject).hasNext())
      {
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localObject = (TemplateGroupItem)localIterator.next();
        } while ((localObject == null) || (((TemplateGroupItem)localObject).jdField_a_of_type_JavaUtilList == null) || (((TemplateGroupItem)localObject).jdField_a_of_type_Int != QIMPtvTemplateAdapter.jdField_b_of_type_Int));
        localObject = ((TemplateGroupItem)localObject).jdField_a_of_type_JavaUtilList.iterator();
      }
      localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)((Iterator)localObject).next();
    } while (!localPtvTemplateInfo.id.equals(QIMPtvTemplateAdapter.jdField_b_of_type_JavaLangString));
    if (QLog.isColorLevel()) {
      QLog.d("QIMRedDotConfig_PTV", 2, "selectPtvTemplateInfo= " + localPtvTemplateInfo);
    }
    return localPtvTemplateInfo;
    return null;
  }
  
  public PtvTemplateManager.PtvTemplateInfo a(String paramString)
  {
    PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo;
    do
    {
      Iterator localIterator1 = a().iterator();
      Iterator localIterator2;
      while (!localIterator2.hasNext())
      {
        if (!localIterator1.hasNext()) {
          break;
        }
        localIterator2 = ((TemplateGroupItem)localIterator1.next()).jdField_a_of_type_JavaUtilList.iterator();
      }
      localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)localIterator2.next();
    } while (!localPtvTemplateInfo.id.equals(paramString));
    if (QLog.isColorLevel()) {
      QLog.d("QIMPtvTemplateManager", 2, "QIMPtvTemplateManager existTemplateInfo id=" + paramString);
    }
    return localPtvTemplateInfo;
    return null;
  }
  
  public ArrayList a()
  {
    return b();
  }
  
  public ArrayList a(boolean paramBoolean)
  {
    ArrayList localArrayList = a(a());
    synchronized (this.jdField_c_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_DovComQqImCaptureDataTemplateGroupItem == null)
      {
        this.jdField_a_of_type_DovComQqImCaptureDataTemplateGroupItem = new TemplateGroupItem("最近");
        this.jdField_a_of_type_DovComQqImCaptureDataTemplateGroupItem.jdField_a_of_type_JavaUtilList = new ArrayList(100);
      }
      if (paramBoolean) {
        a(this.jdField_a_of_type_DovComQqImCaptureDataTemplateGroupItem);
      }
      jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      this.jdField_b_of_type_DovComQqImCaptureDataTemplateGroupItem = b(this.jdField_a_of_type_DovComQqImCaptureDataTemplateGroupItem);
      localArrayList.add(0, this.jdField_b_of_type_DovComQqImCaptureDataTemplateGroupItem);
      if (QLog.isColorLevel()) {
        QLog.d("QIMPtvTemplateManager", 2, "getRecentTemplateAndConfigTemplate needInitRecent: " + paramBoolean);
      }
      return localArrayList;
    }
  }
  
  public List a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramPtvTemplateInfo == null) || (TextUtils.isEmpty(paramPtvTemplateInfo.name))) {
      return localArrayList;
    }
    for (;;)
    {
      try
      {
        localObject = QIMManager.a();
        if ((localObject == null) || (!(localObject instanceof AppInterface))) {
          break label233;
        }
        localObject = ((AppInterface)localObject).getCurrentAccountUin();
        if (!StringUtil.c((String)localObject)) {
          return localArrayList;
        }
      }
      catch (Throwable paramPtvTemplateInfo)
      {
        return localArrayList;
      }
      Object localObject = new File(jdField_a_of_type_JavaLangString, paramPtvTemplateInfo.name + File.separator + "params.json");
      if (!((File)localObject).exists()) {}
      try
      {
        paramPtvTemplateInfo = new File(jdField_a_of_type_JavaIoFile, paramPtvTemplateInfo.name);
        if (paramPtvTemplateInfo.exists()) {
          ZipUtils.a(paramPtvTemplateInfo, jdField_a_of_type_JavaLangString);
        }
        label135:
        if (((File)localObject).exists())
        {
          paramPtvTemplateInfo = FileUtils.a((File)localObject);
          if (TextUtils.isEmpty(paramPtvTemplateInfo)) {}
        }
        try
        {
          paramPtvTemplateInfo = new JSONObject(paramPtvTemplateInfo);
          if (paramPtvTemplateInfo.has("shaderType")) {
            localArrayList.add(paramPtvTemplateInfo.get("shaderType"));
          }
          if (paramPtvTemplateInfo.has("doodleDefaultColor"))
          {
            paramPtvTemplateInfo = Integer.valueOf(paramPtvTemplateInfo.getInt("doodleDefaultColor"));
            if ((paramPtvTemplateInfo instanceof Integer)) {
              localArrayList.add(paramPtvTemplateInfo);
            }
          }
        }
        catch (Exception paramPtvTemplateInfo)
        {
          label223:
          break label223;
        }
        return localArrayList;
      }
      catch (Throwable paramPtvTemplateInfo)
      {
        break label135;
      }
      label233:
      localObject = "";
    }
  }
  
  public List a(File paramFile)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QIMPtvTemplateManager", 2, String.format("rebuildTemplateInfos, isUpdateedByServer[%s], cur_runnable[%s]", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean), Integer.valueOf(hashCode()) }));
    }
    if (this.jdField_a_of_type_Boolean) {}
    do
    {
      do
      {
        return null;
        paramFile = a(paramFile);
      } while (TextUtils.isEmpty(paramFile));
      paramFile = a(this, paramFile, null);
    } while ((paramFile == null) || (paramFile.isEmpty()));
    Iterator localIterator = paramFile.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (TemplateGroupItem)localIterator.next();
      if ((((TemplateGroupItem)localObject).jdField_a_of_type_JavaUtilList != null) && (((TemplateGroupItem)localObject).jdField_a_of_type_JavaUtilList.size() != 0))
      {
        localObject = ((TemplateGroupItem)localObject).jdField_a_of_type_JavaUtilList.iterator();
        label143:
        PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo;
        List localList;
        while (((Iterator)localObject).hasNext())
        {
          localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)((Iterator)localObject).next();
          if (localPtvTemplateInfo != null)
          {
            localPtvTemplateInfo.usable = a(localPtvTemplateInfo);
            localList = a(localPtvTemplateInfo);
            if (localList.size() <= 0) {
              break label261;
            }
            i = ((Integer)localList.get(0)).intValue();
            label217:
            localPtvTemplateInfo.type = i;
            if (localList.size() <= 1) {
              break label266;
            }
          }
        }
        label261:
        label266:
        for (int i = ((Integer)localList.get(1)).intValue();; i = 0)
        {
          localPtvTemplateInfo.color = i;
          break label143;
          break;
          i = 0;
          break label217;
        }
      }
    }
    return paramFile;
  }
  
  public void a() {}
  
  public void a(int paramInt)
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoCommonObservable != null) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoCommonObservable.a(paramInt);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    for (;;)
    {
      StringBuilder localStringBuilder;
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_DovComQqImCaptureDataQIMRedDotConfig == null) {
          return;
        }
        if ((this.jdField_a_of_type_DovComQqImCaptureDataQIMRedDotConfig.updateRedDotInfo(paramInt1, paramInt2, paramString)) && (QLog.isColorLevel()))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("updateRedDotInfo==> type=");
          if (paramInt1 == 2)
          {
            localStringBuilder.append(",categoryId=").append(paramInt2);
            QLog.d("QIMRedDotConfig_PTV", 2, localStringBuilder.toString());
          }
        }
        else
        {
          return;
        }
      }
      if (paramInt1 == 3) {
        localStringBuilder.append(",id=").append(paramString);
      } else if (paramInt1 == 4) {
        localStringBuilder.append(",defaultId=").append(this.jdField_a_of_type_DovComQqImCaptureDataQIMRedDotConfig.defaultUseId);
      } else if (paramInt1 == 5) {
        localStringBuilder.append(",defaultCategoryId=").append(this.jdField_a_of_type_DovComQqImCaptureDataQIMRedDotConfig.defaultCategoryId);
      }
    }
  }
  
  public void a(int paramInt, Object paramObject)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoCommonObservable != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoCommonObservable.a(paramInt, new Object[] { paramObject });
      if (QLog.isColorLevel()) {
        QLog.d("QIMPtvTemplateManager", 2, "notifyEventId eventId" + paramInt);
      }
    }
  }
  
  public void a(AppInterface paramAppInterface, PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, PtvTemplateManager.IPtvTemplateDownloadListener paramIPtvTemplateDownloadListener)
  {
    if (paramPtvTemplateInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QIMPtvTemplateManager", 2, "startDownloadTemplate is null");
      }
      return;
    }
    if ((paramPtvTemplateInfo.kind == 5) || (paramPtvTemplateInfo.kind == 6))
    {
      c(paramAppInterface, paramPtvTemplateInfo, paramIPtvTemplateDownloadListener);
      return;
    }
    b(paramAppInterface, paramPtvTemplateInfo, paramIPtvTemplateDownloadListener);
  }
  
  public void a(AppInterface paramAppInterface, PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (this.jdField_a_of_type_JavaUtilHashMap.get(paramString1) != null)) {}
    for (;;)
    {
      return;
      Object localObject = new aopb(this);
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString1, localObject);
      this.jdField_a_of_type_JavaUtilArrayList.add(paramString1);
      localObject = new HttpNetReq();
      ((HttpNetReq)localObject).jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = new aopa(this, paramString1, paramString2, paramString3);
      ((HttpNetReq)localObject).jdField_a_of_type_JavaLangString = paramString2;
      ((HttpNetReq)localObject).jdField_a_of_type_Int = 0;
      ((HttpNetReq)localObject).jdField_c_of_type_JavaLangString = new File(jdField_a_of_type_JavaIoFile, paramString1).getPath();
      ((HttpNetReq)localObject).a(paramPtvTemplateInfo);
      ((HttpNetReq)localObject).jdField_c_of_type_Int = NetworkUtil.a(NetworkCenter.a().a());
      ((HttpNetReq)localObject).jdField_c_of_type_Long = 60000L;
      try
      {
        paramAppInterface.getNetEngine(0).a((NetReq)localObject);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("QIMPtvTemplateManager", 2, "downloadDGTemplateItem url: " + paramString2);
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
  
  public void a(Observer paramObserver)
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoCommonObservable != null) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoCommonObservable.a(paramObserver);
      }
      return;
    }
    finally
    {
      paramObserver = finally;
      throw paramObserver;
    }
  }
  
  public void a(Observer paramObserver, int paramInt)
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoCommonObservable == null) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoCommonObservable = new Observable();
      }
      this.jdField_a_of_type_ComTencentMobileqqShortvideoCommonObservable.a(paramObserver, new int[] { paramInt });
      return;
    }
    finally {}
  }
  
  public void a(MovieMaterial paramMovieMaterial)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterMaterialMovieMaterial = paramMovieMaterial;
  }
  
  public void a(PtvTemplateManager.IPtvTemplateDownloadListener paramIPtvTemplateDownloadListener)
  {
    this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$IPtvTemplateDownloadListener = paramIPtvTemplateDownloadListener;
  }
  
  public void a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, int paramInt)
  {
    for (;;)
    {
      int i;
      synchronized (this.jdField_c_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_DovComQqImCaptureDataTemplateGroupItem == null)
        {
          this.jdField_a_of_type_DovComQqImCaptureDataTemplateGroupItem = new TemplateGroupItem("最近");
          this.jdField_a_of_type_DovComQqImCaptureDataTemplateGroupItem.jdField_a_of_type_JavaUtilList = new ArrayList(100);
          a(this.jdField_a_of_type_DovComQqImCaptureDataTemplateGroupItem);
        }
        if (this.jdField_b_of_type_DovComQqImCaptureDataTemplateGroupItem == null) {
          this.jdField_b_of_type_DovComQqImCaptureDataTemplateGroupItem = this.jdField_a_of_type_DovComQqImCaptureDataTemplateGroupItem.a();
        }
        i = a(this.jdField_a_of_type_DovComQqImCaptureDataTemplateGroupItem.jdField_a_of_type_JavaUtilList, paramPtvTemplateInfo.id);
        if (i == -1)
        {
          if (!b())
          {
            this.jdField_a_of_type_DovComQqImCaptureDataTemplateGroupItem.jdField_a_of_type_JavaUtilList.add(0, paramPtvTemplateInfo);
            this.jdField_b_of_type_DovComQqImCaptureDataTemplateGroupItem.jdField_a_of_type_JavaUtilList.add(0, paramPtvTemplateInfo);
            if (this.jdField_a_of_type_ComTencentMobileqqShortvideoCommonObservable != null) {
              this.jdField_a_of_type_ComTencentMobileqqShortvideoCommonObservable.a(paramInt, new Object[] { this.jdField_b_of_type_DovComQqImCaptureDataTemplateGroupItem });
            }
            if (QLog.isColorLevel()) {
              QLog.d("QIMPtvTemplateManager", 2, "setCurrentTemplateInfoToRecent not isRecentTemplateFull ");
            }
            if (QLog.isColorLevel()) {
              QLog.d("QIMPtvTemplateManager", 2, "setCurrentTemplateInfoToRecent index=" + i);
            }
            return;
          }
          PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)this.jdField_a_of_type_DovComQqImCaptureDataTemplateGroupItem.jdField_a_of_type_JavaUtilList.remove(99);
          this.jdField_a_of_type_DovComQqImCaptureDataTemplateGroupItem.jdField_a_of_type_JavaUtilList.add(0, paramPtvTemplateInfo);
          this.jdField_b_of_type_DovComQqImCaptureDataTemplateGroupItem.jdField_a_of_type_JavaUtilList.remove(localPtvTemplateInfo);
          this.jdField_b_of_type_DovComQqImCaptureDataTemplateGroupItem.jdField_a_of_type_JavaUtilList.add(0, paramPtvTemplateInfo);
          if (this.jdField_a_of_type_ComTencentMobileqqShortvideoCommonObservable == null) {
            continue;
          }
          this.jdField_a_of_type_ComTencentMobileqqShortvideoCommonObservable.a(paramInt, new Object[] { this.jdField_b_of_type_DovComQqImCaptureDataTemplateGroupItem });
        }
      }
      if (i != 0)
      {
        this.jdField_a_of_type_DovComQqImCaptureDataTemplateGroupItem.jdField_a_of_type_JavaUtilList.remove(i);
        this.jdField_a_of_type_DovComQqImCaptureDataTemplateGroupItem.jdField_a_of_type_JavaUtilList.add(0, paramPtvTemplateInfo);
      }
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    do
    {
      List localList;
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_DovComQqImCaptureDataQIMRedDotConfig == null)
        {
          this.jdField_a_of_type_DovComQqImCaptureDataQIMRedDotConfig = new QIMRedDotConfig(2);
          if (QLog.isColorLevel()) {
            QLog.d("QIMRedDotConfig_PTV", 2, "handleGetServerConfig RedDot is null");
          }
        }
        localList = a(null, paramString, this.jdField_a_of_type_DovComQqImCaptureDataQIMRedDotConfig);
        if (QLog.isColorLevel()) {
          QLog.d("QIMRedDotConfig_PTV", 2, "handleGetServerConfig" + this.jdField_a_of_type_DovComQqImCaptureDataQIMRedDotConfig);
        }
        if ((localList == null) || (localList.isEmpty())) {
          return;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("QIMRedDotConfig_PTV", 2, "handleGetServerConfig face");
      }
      a(paramString, "ptv_template_new.cfg");
      b(false);
      a(localList, paramInt);
      a().notifyObservers(CaptureConfigUpdateObserver.class, 3, true, null);
    } while (this.jdField_b_of_type_Boolean);
    a(this.jdField_a_of_type_JavaUtilList);
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    QIMPtvTemplateAdapter.jdField_b_of_type_JavaLangString = paramString1;
    QIMPtvTemplateAdapter.jdField_b_of_type_Int = paramInt;
    QIMPtvTemplateAdapter.jdField_a_of_type_JavaLangString = paramString2;
    paramString1 = new StringBuilder("QIMPtvTemplateManager setSelectedPtvTemplate id=").append(paramString1).append(" categoryId =").append(paramInt).append(" currentPath=").append(paramString2);
    if (QLog.isColorLevel()) {
      QLog.d("QIMPtvTemplateManager", 2, paramString1.toString());
    }
    a(113, null);
  }
  
  void a(List paramList)
  {
    ThreadManager.getSubThreadHandler().postDelayed(new aoov(this, paramList), jdField_a_of_type_JavaLangLong.longValue());
  }
  
  public void a(List paramList, int paramInt)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    ??? = paramList.iterator();
    if (((Iterator)???).hasNext())
    {
      Iterator localIterator = ((TemplateGroupItem)((Iterator)???).next()).jdField_a_of_type_JavaUtilList.iterator();
      label49:
      PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo;
      List localList;
      while (localIterator.hasNext())
      {
        localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)localIterator.next();
        if (localPtvTemplateInfo != null)
        {
          localPtvTemplateInfo.usable = a(localPtvTemplateInfo);
          localList = a(localPtvTemplateInfo);
          if (localList.size() <= 0) {
            break label167;
          }
          paramInt = ((Integer)localList.get(0)).intValue();
          label123:
          localPtvTemplateInfo.type = paramInt;
          if (localList.size() <= 1) {
            break label172;
          }
        }
      }
      label167:
      label172:
      for (paramInt = ((Integer)localList.get(1)).intValue();; paramInt = 0)
      {
        localPtvTemplateInfo.color = paramInt;
        break label49;
        break;
        paramInt = 0;
        break label123;
      }
    }
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
      this.jdField_a_of_type_Boolean = true;
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    ThreadManager.postImmediately(new aoot(this, paramBoolean), null, false);
  }
  
  public boolean a(int paramInt1, int paramInt2, String paramString)
  {
    for (;;)
    {
      StringBuilder localStringBuilder;
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_DovComQqImCaptureDataQIMRedDotConfig == null) {
          return false;
        }
        boolean bool = this.jdField_a_of_type_DovComQqImCaptureDataQIMRedDotConfig.needShowRedDot(paramInt1, paramInt2, paramString);
        if ((bool) && (QLog.isColorLevel()))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("ShowRedDot ==> type=");
          localStringBuilder.append(paramInt1);
          if (paramInt1 == 2)
          {
            localStringBuilder.append(",categoryId=").append(paramInt2);
            QLog.d("QIMRedDotConfig_PTV", 2, localStringBuilder.toString());
          }
        }
        else
        {
          return bool;
        }
      }
      if (paramInt1 == 3) {
        localStringBuilder.append(",id=").append(paramString);
      } else if (paramInt1 == 4) {
        localStringBuilder.append(",defaultId=").append(this.jdField_a_of_type_DovComQqImCaptureDataQIMRedDotConfig.defaultUseId);
      } else if (paramInt1 == 5) {
        localStringBuilder.append(",defaultCategoryId=").append(this.jdField_a_of_type_DovComQqImCaptureDataQIMRedDotConfig.defaultCategoryId);
      }
    }
  }
  
  public boolean a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo)
  {
    if (paramPtvTemplateInfo == null) {}
    do
    {
      boolean bool;
      do
      {
        return false;
        if (paramPtvTemplateInfo.kind != 5) {
          break;
        }
        paramPtvTemplateInfo.dgStageUsable = b(paramPtvTemplateInfo.dgStageName, paramPtvTemplateInfo.dgStageResmd5, false);
        paramPtvTemplateInfo.dgModelUsable = b(paramPtvTemplateInfo.dgModelName, paramPtvTemplateInfo.dgModelResmd5, false);
        bool = b(paramPtvTemplateInfo.name, paramPtvTemplateInfo.md5, false);
        if (QLog.isColorLevel()) {
          QLog.d("QIMPtvTemplateManager", 2, String.format("isDGTemplateUsage stage[%s], model[%s], total[%s], id[%s]", new Object[] { Boolean.valueOf(paramPtvTemplateInfo.dgStageUsable), Boolean.valueOf(paramPtvTemplateInfo.dgModelUsable), Boolean.valueOf(bool), paramPtvTemplateInfo.id }));
        }
      } while ((!paramPtvTemplateInfo.dgStageUsable) || (!paramPtvTemplateInfo.dgModelUsable));
      return bool;
      if (paramPtvTemplateInfo.kind != 6) {
        break;
      }
      paramPtvTemplateInfo.dgStageUsable = b(paramPtvTemplateInfo.dgStageName, paramPtvTemplateInfo.dgStageResmd5, false);
    } while (!paramPtvTemplateInfo.dgStageUsable);
    return b(paramPtvTemplateInfo.name, paramPtvTemplateInfo.md5, false);
    return b(paramPtvTemplateInfo.name, paramPtvTemplateInfo.md5, true);
  }
  
  public void b()
  {
    this.jdField_a_of_type_DovComQqImCaptureDataTemplateGroupItem = null;
    if (QLog.isColorLevel()) {
      QLog.d("QIMPtvTemplateManager", 2, "QIMPtvTemplateManager onDestroy");
    }
  }
  
  public void b(AppInterface paramAppInterface, PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, PtvTemplateManager.IPtvTemplateDownloadListener paramIPtvTemplateDownloadListener)
  {
    if ((paramPtvTemplateInfo == null) || (paramAppInterface == null)) {}
    for (;;)
    {
      return;
      HttpNetReq localHttpNetReq = new HttpNetReq();
      localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = new aooz(this, paramPtvTemplateInfo, paramIPtvTemplateDownloadListener);
      localHttpNetReq.jdField_a_of_type_JavaLangString = paramPtvTemplateInfo.resurl;
      localHttpNetReq.jdField_a_of_type_Int = 0;
      localHttpNetReq.jdField_c_of_type_JavaLangString = new File(jdField_a_of_type_JavaIoFile, paramPtvTemplateInfo.name).getPath();
      localHttpNetReq.jdField_c_of_type_Int = NetworkUtil.a(NetworkCenter.a().a());
      localHttpNetReq.jdField_c_of_type_Long = 60000L;
      try
      {
        paramAppInterface.getNetEngine(0).a(localHttpNetReq);
        localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener.a(localHttpNetReq, 1L, 100L);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("QIMPtvTemplateManager", 2, "startDownloadTemplate url: " + paramPtvTemplateInfo.resurl);
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
  
  public void b(List paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    do
    {
      do
      {
        return;
      } while (BaseApplicationImpl.sProcessId != 1);
      paramList = paramList.iterator();
    } while (!paramList.hasNext());
    List localList = ((TemplateGroupItem)paramList.next()).jdField_a_of_type_JavaUtilList;
    int i = 0;
    label52:
    PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo;
    if (i < localList.size())
    {
      localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)localList.get(i);
      if ((localPtvTemplateInfo != null) && (localPtvTemplateInfo.predownload) && (!TextUtils.isEmpty(localPtvTemplateInfo.resurl))) {
        break label105;
      }
    }
    for (;;)
    {
      i += 1;
      break label52;
      break;
      label105:
      ThreadManager.getFileThreadHandler().post(new aoow(this, localPtvTemplateInfo));
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if ((this.jdField_a_of_type_DovComQqImCaptureDataQIMRedDotConfig != null) && (this.jdField_a_of_type_DovComQqImCaptureDataQIMRedDotConfig.update))
      {
        this.jdField_a_of_type_DovComQqImCaptureDataQIMRedDotConfig.update = false;
        QIMRedDotConfig.saveRedDotConfig(this.jdField_a_of_type_DovComQqImCaptureDataQIMRedDotConfig, jdField_a_of_type_JavaIoFile.getAbsolutePath());
      }
      return;
    }
    QIMRedDotConfig.saveRedDotConfig(this.jdField_a_of_type_DovComQqImCaptureDataQIMRedDotConfig, jdField_a_of_type_JavaIoFile.getAbsolutePath());
  }
  
  @TargetApi(9)
  public void c()
  {
    File localFile = new File(jdField_a_of_type_JavaIoFile, "ptv_template_new.cfg");
    if (!localFile.exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d("QIMPtvTemplateManager", 2, "initLocalTemplateConfigInfo config file not exist.");
      }
      a(false);
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("QIMPtvTemplateManager", 4, String.format("rebuildTemplateInfos, runnable[%s]", new Object[] { Integer.valueOf(hashCode()) }));
    }
    ThreadManager.getFileThreadHandler().post(new aooy(this, localFile));
  }
  
  public void c(AppInterface paramAppInterface, PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, PtvTemplateManager.IPtvTemplateDownloadListener paramIPtvTemplateDownloadListener)
  {
    if ((paramPtvTemplateInfo == null) || (paramAppInterface == null)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("QIMPtvTemplateManager", 2, String.format("DGTemplateUsage stage[%s], model[%s], total[%s]", new Object[] { Boolean.valueOf(paramPtvTemplateInfo.dgStageUsable), Boolean.valueOf(paramPtvTemplateInfo.dgModelUsable), Boolean.valueOf(paramPtvTemplateInfo.usable) }));
      }
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$IPtvTemplateDownloadListener = paramIPtvTemplateDownloadListener;
      if (!paramPtvTemplateInfo.dgStageUsable) {
        a(paramAppInterface, paramPtvTemplateInfo, paramPtvTemplateInfo.dgStageName, paramPtvTemplateInfo.dgStageResurl, paramPtvTemplateInfo.dgStageResmd5);
      }
      if (!paramPtvTemplateInfo.dgModelUsable) {
        a(paramAppInterface, paramPtvTemplateInfo, paramPtvTemplateInfo.dgModelName, paramPtvTemplateInfo.dgModelResurl, paramPtvTemplateInfo.dgModelResmd5);
      }
    } while (paramPtvTemplateInfo.usable);
    a(paramAppInterface, paramPtvTemplateInfo, paramPtvTemplateInfo.name, paramPtvTemplateInfo.resurl, paramPtvTemplateInfo.md5);
    this.jdField_b_of_type_JavaUtilArrayList.add(paramPtvTemplateInfo);
  }
  
  public void d()
  {
    Iterator localIterator = a().iterator();
    while (localIterator.hasNext())
    {
      TemplateGroupItem localTemplateGroupItem = (TemplateGroupItem)localIterator.next();
      if (localTemplateGroupItem.jdField_a_of_type_Boolean) {
        Collections.shuffle(localTemplateGroupItem.jdField_a_of_type_JavaUtilList);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("QIMPtvTemplateManager", 2, "randomliseData");
    }
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_DovComQqImCaptureDataTemplateGroupItem == null) {}
    StringBuilder localStringBuilder;
    do
    {
      do
      {
        do
        {
          return;
        } while ((this.jdField_a_of_type_DovComQqImCaptureDataTemplateGroupItem.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_DovComQqImCaptureDataTemplateGroupItem.jdField_a_of_type_JavaUtilList.isEmpty()));
        localStringBuilder = new StringBuilder();
        localObject1 = this.jdField_a_of_type_DovComQqImCaptureDataTemplateGroupItem.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (PtvTemplateManager.PtvTemplateInfo)((Iterator)localObject1).next();
          if (!TextUtils.isEmpty(((PtvTemplateManager.PtvTemplateInfo)localObject2).id))
          {
            localStringBuilder.append(((PtvTemplateManager.PtvTemplateInfo)localObject2).id).append("|");
            localStringBuilder.append(((PtvTemplateManager.PtvTemplateInfo)localObject2).categoryId).append("$");
          }
        }
      } while (TextUtils.isEmpty(localStringBuilder.toString()));
      Object localObject1 = BaseApplicationImpl.getApplication().getSharedPreferences("recent_template_setting", 0);
      Object localObject2 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      ((SharedPreferences)localObject1).edit().putString("recent_template_list" + (String)localObject2, localStringBuilder.toString());
      ((SharedPreferences)localObject1).edit().commit();
    } while (!QLog.isColorLevel());
    QLog.d("QIMPtvTemplateManager", 2, "saveRecentTemplate list=" + localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.QIMPtvTemplateManager
 * JD-Core Version:    0.7.0.1
 */