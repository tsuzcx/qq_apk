package dov.com.tencent.mobileqq.activity.richmedia;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.av.opengl.filter.qqavimage.QQAVImageFilterConstants;
import com.tencent.av.utils.UITools;
import com.tencent.av.video.effect.lowlight.LowLightTools;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.richmedia.PathUtils;
import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.shortvideo.filter.FilterBusinessOperation;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.mobileqq.shortvideo.qmcf.QmcfDevicesStrategy;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.QQFilterRenderManagerHolder;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.data.CaptureComboManager;
import dov.com.qq.im.capture.data.ComboSet;
import dov.com.qq.im.capture.data.FilterCategory;
import dov.com.qq.im.capture.data.FilterSet;
import dov.com.qq.im.capture.data.QIMFilterCategoryItem;
import dov.com.qq.im.capture.data.QIMRedDotConfig;
import dov.com.qq.im.capture.data.QIMRedDotConfig.RedDotItemConfig;
import dov.com.qq.im.capture.data.TransitionCategoryItem;
import dov.com.qq.im.capture.util.QIMFileUtils;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoPartManager;
import dov.com.tencent.mobileqq.richmedia.capture.data.CaptureVideoFilterManager;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArrayList<Ldov.com.qq.im.capture.data.FilterCategory;>;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class VideoFilterTools
{
  public static int a;
  public static QIMRedDotConfig a;
  private static VideoFilterTools jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterTools;
  public static Object a;
  public static final String a;
  public static HashMap<String, FilterDesc> a;
  public static String b;
  private static boolean jdField_b_of_type_Boolean;
  public static String c;
  private static boolean jdField_c_of_type_Boolean;
  private static int jdField_d_of_type_Int = 2;
  private static final String jdField_d_of_type_JavaLangString;
  private static boolean jdField_d_of_type_Boolean;
  private static int e = 1;
  private static int f = -1;
  private static int g = 0;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  public FilterDesc a;
  private TransitionCategoryItem jdField_a_of_type_DovComQqImCaptureDataTransitionCategoryItem;
  private EditVideoPartManager jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager;
  private boolean jdField_a_of_type_Boolean = true;
  private int[] jdField_a_of_type_ArrayOfInt = { -1 };
  public ComboSet[] a;
  public QIMFilterCategoryItem[] a;
  private int jdField_b_of_type_Int = -1;
  public QIMFilterCategoryItem[] b;
  private int jdField_c_of_type_Int = -1;
  public QIMFilterCategoryItem[] c;
  
  static
  {
    jdField_a_of_type_JavaLangString = CaptureVideoFilterManager.jdField_a_of_type_JavaLangString + "artfilter" + File.separator;
    jdField_d_of_type_JavaLangString = PathUtils.jdField_d_of_type_JavaLangString + "dov_capture_qsvf" + File.separator;
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_b_of_type_Boolean = false;
    jdField_c_of_type_Boolean = false;
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_d_of_type_Boolean = false;
    jdField_b_of_type_JavaLangString = CaptureVideoFilterManager.jdField_a_of_type_JavaLangString + "lowlight";
    jdField_c_of_type_JavaLangString = jdField_b_of_type_JavaLangString + File.separator + "LowLight.png";
    jdField_a_of_type_Int = 0;
  }
  
  private VideoFilterTools()
  {
    this.jdField_a_of_type_ArrayOfDovComQqImCaptureDataQIMFilterCategoryItem = new QIMFilterCategoryItem[5];
    this.jdField_a_of_type_ArrayOfDovComQqImCaptureDataComboSet = new ComboSet[5];
    this.jdField_b_of_type_ArrayOfDovComQqImCaptureDataQIMFilterCategoryItem = new QIMFilterCategoryItem[5];
    this.jdField_c_of_type_ArrayOfDovComQqImCaptureDataQIMFilterCategoryItem = new QIMFilterCategoryItem[5];
  }
  
  public static int a(Context paramContext)
  {
    int i = 0;
    int j = BaseApplicationImpl.getApplication().getSharedPreferences("short_video_filter_config_sp", 4).getInt("dov_video_filter_config_version_775", 0);
    if ((j > 0) && (!new File(CaptureVideoFilterManager.jdField_a_of_type_JavaLangString + "filter_config_new.xml").exists())) {
      UITools.a("VideoFilterTools", "getQQShortVideoFilterConfigVersion config file don't exist!");
    }
    for (;;)
    {
      UITools.a("VideoFilterTools", "getQQShortVideoFilterConfigVersion:" + i);
      return i;
      i = j;
    }
  }
  
  public static VideoFilterTools.DataSet a(CopyOnWriteArrayList<FilterCategory> paramCopyOnWriteArrayList, boolean paramBoolean1, boolean paramBoolean2)
  {
    VideoFilterTools.DataSet localDataSet = new VideoFilterTools.DataSet();
    paramBoolean1 = d();
    Object localObject1 = a(paramCopyOnWriteArrayList, 1, paramBoolean1);
    Object localObject3 = a(paramCopyOnWriteArrayList, 2, paramBoolean1);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    paramCopyOnWriteArrayList = null;
    Object localObject2 = null;
    ArrayList localArrayList3 = new ArrayList();
    Object localObject4 = ((ArrayList)localObject1).iterator();
    FilterCategory localFilterCategory;
    Iterator localIterator;
    QIMFilterCategoryItem localQIMFilterCategoryItem;
    while (((Iterator)localObject4).hasNext())
    {
      localObject1 = (FilterCategory)((Iterator)localObject4).next();
      localFilterCategory = new FilterCategory(((FilterCategory)localObject1).jdField_a_of_type_Int, ((FilterCategory)localObject1).jdField_a_of_type_JavaLangString, ((FilterCategory)localObject1).jdField_a_of_type_Boolean, ((FilterCategory)localObject1).jdField_b_of_type_Boolean, ((FilterCategory)localObject1).jdField_b_of_type_Int, ((FilterCategory)localObject1).jdField_c_of_type_Int);
      localIterator = ((FilterCategory)localObject1).jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        localQIMFilterCategoryItem = (QIMFilterCategoryItem)localIterator.next();
        localObject1 = paramCopyOnWriteArrayList;
        if (localQIMFilterCategoryItem.c())
        {
          localObject1 = paramCopyOnWriteArrayList;
          if (paramCopyOnWriteArrayList == null) {
            localObject1 = localQIMFilterCategoryItem;
          }
        }
        localQIMFilterCategoryItem = localQIMFilterCategoryItem.a();
        if (paramBoolean2)
        {
          paramCopyOnWriteArrayList = (CopyOnWriteArrayList<FilterCategory>)localObject1;
          if (!localQIMFilterCategoryItem.b()) {}
        }
        else
        {
          localFilterCategory.jdField_a_of_type_JavaUtilList.add(localQIMFilterCategoryItem);
          localArrayList1.add(localQIMFilterCategoryItem);
          paramCopyOnWriteArrayList = (CopyOnWriteArrayList<FilterCategory>)localObject1;
        }
      }
      localArrayList3.add(localFilterCategory);
    }
    localObject4 = new ArrayList();
    localObject3 = ((ArrayList)localObject3).iterator();
    localObject1 = localObject2;
    while (((Iterator)localObject3).hasNext())
    {
      localObject2 = (FilterCategory)((Iterator)localObject3).next();
      localFilterCategory = new FilterCategory(((FilterCategory)localObject2).jdField_a_of_type_Int, ((FilterCategory)localObject2).jdField_a_of_type_JavaLangString, ((FilterCategory)localObject2).jdField_a_of_type_Boolean, ((FilterCategory)localObject2).jdField_b_of_type_Boolean, ((FilterCategory)localObject2).jdField_b_of_type_Int, ((FilterCategory)localObject2).jdField_c_of_type_Int);
      localIterator = ((FilterCategory)localObject2).jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        localQIMFilterCategoryItem = (QIMFilterCategoryItem)localIterator.next();
        localObject2 = localObject1;
        if (localQIMFilterCategoryItem.c())
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = localQIMFilterCategoryItem;
          }
        }
        localQIMFilterCategoryItem = localQIMFilterCategoryItem.a();
        if (paramBoolean2)
        {
          localObject1 = localObject2;
          if (!localQIMFilterCategoryItem.b()) {}
        }
        else
        {
          localFilterCategory.jdField_a_of_type_JavaUtilList.add(localQIMFilterCategoryItem);
          localArrayList1.add(localQIMFilterCategoryItem);
          localArrayList2.add(localQIMFilterCategoryItem);
          localObject1 = localObject2;
        }
      }
      ((ArrayList)localObject4).add(localFilterCategory);
    }
    localDataSet.jdField_a_of_type_JavaUtilArrayList = localArrayList3;
    localDataSet.jdField_b_of_type_JavaUtilArrayList = ((ArrayList)localObject4);
    localDataSet.d = localArrayList1;
    localDataSet.c = localArrayList2;
    localDataSet.jdField_a_of_type_DovComQqImCaptureDataQIMFilterCategoryItem = paramCopyOnWriteArrayList;
    localDataSet.jdField_b_of_type_DovComQqImCaptureDataQIMFilterCategoryItem = ((QIMFilterCategoryItem)localObject1);
    return localDataSet;
  }
  
  public static VideoFilterTools a()
  {
    if (jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterTools == null) {
      jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterTools = new VideoFilterTools();
    }
    return jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterTools;
  }
  
  public static String a(Context paramContext)
  {
    try
    {
      File localFile = new File(CaptureVideoFilterManager.jdField_a_of_type_JavaLangString + "filter_config_new.xml");
      UITools.a("VideoFilterTools", "getQQShortVideoFilterConfig:" + CaptureVideoFilterManager.jdField_a_of_type_JavaLangString + "filter_config_new.xml" + "|" + localFile.exists());
      if (localFile.exists()) {
        return FileUtils.b(localFile);
      }
      a(paramContext, 0);
      return null;
    }
    catch (IOException paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public static String a(String paramString)
  {
    if ((paramString == null) || (paramString.equals(""))) {}
    int i;
    int j;
    do
    {
      return paramString;
      i = paramString.lastIndexOf(".");
      j = paramString.lastIndexOf(File.separator);
      if (j != -1) {
        break;
      }
    } while (i == -1);
    return paramString.substring(0, i);
    if (i == -1) {
      return paramString.substring(j + 1);
    }
    if (j < i) {}
    for (paramString = paramString.substring(j + 1, i);; paramString = paramString.substring(j + 1)) {
      return paramString;
    }
  }
  
  static ArrayList<FilterDesc> a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      UITools.a("VideoFilterTools", "parseConfig|content is empty.");
    }
    for (;;)
    {
      try
      {
        Object localObject = FilterDesc.parse(new JSONObject(paramString).getJSONArray("filters"));
        paramString = (String)localObject;
        localObject = paramString;
        if (paramString == null) {
          localObject = new ArrayList();
        }
        return localObject;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        UITools.a("VideoFilterTools", "parseConfig|parse failed.context = " + paramString);
      }
      paramString = null;
    }
  }
  
  public static ArrayList<FilterCategory> a(CopyOnWriteArrayList<FilterCategory> paramCopyOnWriteArrayList, int paramInt, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    int i;
    if ((d()) && (paramBoolean))
    {
      i = 1;
      paramCopyOnWriteArrayList = paramCopyOnWriteArrayList.iterator();
    }
    label524:
    label530:
    for (;;)
    {
      Object localObject;
      FilterCategory localFilterCategory;
      QIMFilterCategoryItem localQIMFilterCategoryItem;
      if (paramCopyOnWriteArrayList.hasNext())
      {
        localObject = (FilterCategory)paramCopyOnWriteArrayList.next();
        if ((paramInt == 1) && (((FilterCategory)localObject).jdField_a_of_type_Boolean))
        {
          localFilterCategory = new FilterCategory(((FilterCategory)localObject).jdField_a_of_type_Int, ((FilterCategory)localObject).jdField_a_of_type_JavaLangString, ((FilterCategory)localObject).jdField_a_of_type_Boolean, ((FilterCategory)localObject).jdField_b_of_type_Boolean, ((FilterCategory)localObject).jdField_b_of_type_Int, ((FilterCategory)localObject).jdField_c_of_type_Int);
          localFilterCategory.jdField_a_of_type_Boolean = true;
          localObject = ((FilterCategory)localObject).jdField_a_of_type_JavaUtilList.iterator();
          for (;;)
          {
            if (((Iterator)localObject).hasNext())
            {
              localQIMFilterCategoryItem = (QIMFilterCategoryItem)((Iterator)localObject).next();
              if (((i != 0) || (!QIMFilterCategoryItem.a(localQIMFilterCategoryItem))) && (!QIMFilterCategoryItem.b(localQIMFilterCategoryItem)))
              {
                localFilterCategory.jdField_a_of_type_JavaUtilList.add(localQIMFilterCategoryItem);
                continue;
                i = 0;
                break;
              }
            }
          }
          if (localFilterCategory.jdField_a_of_type_JavaUtilList.size() <= 0) {
            continue;
          }
          localObject = localFilterCategory.jdField_a_of_type_JavaUtilList.iterator();
          do
          {
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
          } while (((QIMFilterCategoryItem)((Iterator)localObject).next()).c());
        }
      }
      for (int j = 0;; j = 1)
      {
        if (j != 0) {
          break label530;
        }
        localArrayList.add(localFilterCategory);
        break;
        if ((paramInt != 2) || (((FilterCategory)localObject).jdField_a_of_type_Boolean)) {
          break;
        }
        localFilterCategory = new FilterCategory(((FilterCategory)localObject).jdField_a_of_type_Int, ((FilterCategory)localObject).jdField_a_of_type_JavaLangString, ((FilterCategory)localObject).jdField_a_of_type_Boolean, ((FilterCategory)localObject).jdField_b_of_type_Boolean, ((FilterCategory)localObject).jdField_b_of_type_Int, ((FilterCategory)localObject).jdField_c_of_type_Int);
        localFilterCategory.jdField_a_of_type_Boolean = false;
        localObject = ((FilterCategory)localObject).jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          localQIMFilterCategoryItem = (QIMFilterCategoryItem)((Iterator)localObject).next();
          if (((i != 0) || (!QIMFilterCategoryItem.a(localQIMFilterCategoryItem))) && (!QIMFilterCategoryItem.b(localQIMFilterCategoryItem))) {
            localFilterCategory.jdField_a_of_type_JavaUtilList.add(localQIMFilterCategoryItem);
          }
        }
        if (localFilterCategory.jdField_a_of_type_JavaUtilList.size() <= 0) {
          break;
        }
        localObject = localFilterCategory.jdField_a_of_type_JavaUtilList.iterator();
        do
        {
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
        } while (((QIMFilterCategoryItem)((Iterator)localObject).next()).c());
        for (j = 0;; j = 1)
        {
          if (j != 0) {
            break label524;
          }
          localArrayList.add(localFilterCategory);
          break;
          if (QLog.isColorLevel())
          {
            paramCopyOnWriteArrayList = new StringBuilder(20);
            paramCopyOnWriteArrayList.append("getFilterCategory categoryType:").append(paramInt).append(" filter:");
            if (localArrayList != null) {
              break label507;
            }
            paramCopyOnWriteArrayList.append("null ");
          }
          for (;;)
          {
            QLog.d("VideoFilterTools", 2, paramCopyOnWriteArrayList.toString());
            return localArrayList;
            label507:
            paramCopyOnWriteArrayList.append(localArrayList.size());
          }
        }
        break;
      }
    }
  }
  
  public static JSONArray a(List<FilterDesc> paramList)
  {
    localJSONArray = new JSONArray();
    try
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        FilterDesc localFilterDesc = (FilterDesc)paramList.next();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("filterid", localFilterDesc.id + "");
        localJSONObject.put("type", localFilterDesc.type + "");
        localJSONObject.put("name", localFilterDesc.name);
        localJSONObject.put("respicname", localFilterDesc.respicname);
        localJSONObject.put("version", localFilterDesc.version);
        localJSONObject.put("md5", localFilterDesc.resMD5);
        localJSONObject.put("resurl", localFilterDesc.resurl);
        localJSONArray.put(localJSONObject);
      }
      return localJSONArray;
    }
    catch (Exception paramList)
    {
      QLog.w("VideoFilterTools", 2, "convertFilterDesc" + paramList.toString());
      QLog.w("VideoFilterTools", 2, "convertFilterDesc json" + localJSONArray.toString());
    }
  }
  
  public static void a()
  {
    if (jdField_a_of_type_DovComQqImCaptureDataQIMRedDotConfig == null)
    {
      QIMRedDotConfig localQIMRedDotConfig = QIMRedDotConfig.getRedDotConfigFromFile(CaptureVideoFilterManager.jdField_a_of_type_JavaLangString);
      if (localQIMRedDotConfig != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QIMRedDotConfig_Filter", 2, "VideoFilterTools reddot config init");
        }
        synchronized (jdField_a_of_type_JavaLangObject)
        {
          jdField_a_of_type_DovComQqImCaptureDataQIMRedDotConfig = localQIMRedDotConfig;
          return;
        }
      }
    }
  }
  
  private static void a(Context paramContext)
  {
    paramContext = BaseApplicationImpl.getApplication().getSharedPreferences("short_video_filter_config_sp", 4).edit();
    paramContext.putInt("dov_video_filter_first_change_path", 1);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    UITools.a("VideoFilterTools", "setQQShortVideoFilterConfigVersion:" + paramInt);
    paramContext = BaseApplicationImpl.getApplication().getSharedPreferences("short_video_filter_config_sp", 4).edit();
    paramContext.putInt("dov_video_filter_config_version_775", paramInt);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, String paramString)
  {
    if (paramString == null) {
      UITools.a("VideoFilterTools", "updateQQShortVideoFilterConfig error ");
    }
    do
    {
      return;
      if (b(BaseApplicationImpl.getContext()))
      {
        a(BaseApplicationImpl.getContext());
        if (new File(jdField_d_of_type_JavaLangString).exists()) {
          FileUtils.a(jdField_d_of_type_JavaLangString);
        }
      }
      a(paramContext, paramString, a(paramContext));
    } while (!a(paramString));
    FileUtils.a(CaptureVideoFilterManager.jdField_a_of_type_JavaLangString, "filter_config_new.xml", paramString);
  }
  
  static void a(Context paramContext, String paramString1, String paramString2)
  {
    Iterator localIterator = null;
    long l1 = System.currentTimeMillis();
    if ((paramString1 != null) && (!paramString1.equals(""))) {}
    for (paramContext = a(paramString1);; paramContext = null)
    {
      paramString1 = localIterator;
      if (paramString2 != null)
      {
        paramString1 = localIterator;
        if (!paramString2.equals("")) {
          paramString1 = a(paramString2);
        }
      }
      if (paramContext == null) {
        FileUtils.a(CaptureVideoFilterManager.jdField_b_of_type_JavaLangString);
      }
      for (;;)
      {
        long l2 = System.currentTimeMillis();
        UITools.a("VideoFilterTools", "compareContent :" + (l2 - l1));
        return;
        if (paramString1 != null)
        {
          paramString1 = paramString1.iterator();
          while (paramString1.hasNext())
          {
            paramString2 = (FilterDesc)paramString1.next();
            localIterator = paramContext.iterator();
            while (localIterator.hasNext())
            {
              FilterDesc localFilterDesc = (FilterDesc)localIterator.next();
              if ((localFilterDesc.name != null) && (localFilterDesc.name.equals(paramString2.name)))
              {
                UITools.a("VideoFilterTools", "compareContent res:" + localFilterDesc.name + "|" + localFilterDesc.resMD5 + "|" + paramString2.resMD5);
                if ((!TextUtils.isEmpty(localFilterDesc.resMD5)) && (!localFilterDesc.resMD5.equals(paramString2.resMD5)))
                {
                  UITools.a("VideoFilterTools", "compareContentDelete res:" + paramString2.getResFold(CaptureVideoFilterManager.jdField_b_of_type_JavaLangString));
                  FileUtils.a(paramString2.getResFold(CaptureVideoFilterManager.jdField_b_of_type_JavaLangString));
                }
                UITools.a("VideoFilterTools", "compareContent iconMD5:" + localFilterDesc.name + "|" + localFilterDesc.iconMD5 + "|" + paramString2.iconMD5);
                if ((!TextUtils.isEmpty(localFilterDesc.iconMD5)) && (!localFilterDesc.iconMD5.equals(paramString2.iconMD5)))
                {
                  UITools.a("VideoFilterTools", "compareContentDelete iconMD5:" + paramString2.getIconFile(CaptureVideoFilterManager.jdField_b_of_type_JavaLangString));
                  FileUtils.e(paramString2.getIconFile(CaptureVideoFilterManager.jdField_b_of_type_JavaLangString));
                }
              }
            }
          }
        }
      }
    }
  }
  
  public static void a(List<QIMFilterCategoryItem> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      label13:
      return;
    } else {
      paramList = paramList.iterator();
    }
    for (;;)
    {
      if (!paramList.hasNext()) {
        break label13;
      }
      Object localObject1 = (QIMFilterCategoryItem)paramList.next();
      if (((QIMFilterCategoryItem)localObject1).jdField_a_of_type_JavaUtilArrayList == null) {
        break;
      }
      localObject1 = ((QIMFilterCategoryItem)localObject1).jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (String)((Iterator)localObject1).next();
        localObject2 = a().a((String)localObject2);
        if ((localObject2 != null) && (QQAVImageFilterConstants.isMusicSpecialFilter(((FilterDesc)localObject2).id))) {
          paramList.remove();
        }
      }
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if ((jdField_a_of_type_DovComQqImCaptureDataQIMRedDotConfig != null) && (jdField_a_of_type_DovComQqImCaptureDataQIMRedDotConfig.update))
      {
        jdField_a_of_type_DovComQqImCaptureDataQIMRedDotConfig.update = false;
        QIMRedDotConfig.saveRedDotConfig(jdField_a_of_type_DovComQqImCaptureDataQIMRedDotConfig, CaptureVideoFilterManager.jdField_a_of_type_JavaLangString);
      }
      return;
    }
    QIMRedDotConfig.saveRedDotConfig(jdField_a_of_type_DovComQqImCaptureDataQIMRedDotConfig, CaptureVideoFilterManager.jdField_a_of_type_JavaLangString);
  }
  
  public static boolean a(int paramInt1, int paramInt2, String paramString)
  {
    for (;;)
    {
      StringBuilder localStringBuilder;
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        if (jdField_a_of_type_DovComQqImCaptureDataQIMRedDotConfig == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("QIMRedDotConfig_Filter", 2, "needShowRedDot|mQIMRedDotConfig is null");
          }
          return false;
        }
        boolean bool = jdField_a_of_type_DovComQqImCaptureDataQIMRedDotConfig.needShowRedDot(paramInt1, paramInt2, paramString);
        if ((bool) && (QLog.isColorLevel()))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("ShowRedDot==> type=");
          localStringBuilder.append(paramInt1);
          if (paramInt1 == 2)
          {
            localStringBuilder.append(",categoryId=").append(paramInt2);
            QLog.d("QIMRedDotConfig_Filter", 2, localStringBuilder.toString());
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
        localStringBuilder.append(",defaultId=").append(jdField_a_of_type_DovComQqImCaptureDataQIMRedDotConfig.defaultUseId);
      } else if (paramInt1 == 5) {
        localStringBuilder.append(",defaultCategoryId=").append(jdField_a_of_type_DovComQqImCaptureDataQIMRedDotConfig.defaultCategoryId);
      } else if (paramInt1 == 7) {
        localStringBuilder.append(",comboDefaultCategoryId=").append(jdField_a_of_type_DovComQqImCaptureDataQIMRedDotConfig.comboDefaultCategoryId);
      }
    }
  }
  
  public static boolean a(String paramString)
  {
    label821:
    for (;;)
    {
      try
      {
        int i;
        synchronized (jdField_a_of_type_JavaLangObject)
        {
          paramString = new JSONObject(paramString);
          if (jdField_a_of_type_DovComQqImCaptureDataQIMRedDotConfig == null)
          {
            jdField_a_of_type_DovComQqImCaptureDataQIMRedDotConfig = new QIMRedDotConfig(1);
            if (QLog.isColorLevel()) {
              QLog.d("QIMRedDotConfig_Filter", 2, "updateFromServer config is null");
            }
          }
          i = paramString.optInt("iconRedDotVersion");
          boolean bool = paramString.optBoolean("needRedDot");
          if (QLog.isColorLevel()) {
            QLog.d("QIMRedDotConfig_Filter", 2, "updateFromServer oldVer=" + jdField_a_of_type_DovComQqImCaptureDataQIMRedDotConfig.iconVersion + ",ver=" + i + ",showRed " + bool);
          }
          if (jdField_a_of_type_DovComQqImCaptureDataQIMRedDotConfig.iconVersion != i)
          {
            jdField_a_of_type_DovComQqImCaptureDataQIMRedDotConfig.iconVersion = i;
            jdField_a_of_type_DovComQqImCaptureDataQIMRedDotConfig.showRedDot = bool;
            jdField_a_of_type_DovComQqImCaptureDataQIMRedDotConfig.hasShow = false;
            jdField_a_of_type_DovComQqImCaptureDataQIMRedDotConfig.firstShowTime = 0L;
          }
          i = paramString.optInt("combo_iconRedDotVersion");
          bool = paramString.optBoolean("combo_needRedDot");
          if (QLog.isColorLevel()) {
            QLog.d("QIMRedDotConfig_Filter", 2, "updateFromServer combo oldVer=" + jdField_a_of_type_DovComQqImCaptureDataQIMRedDotConfig.comboIconVersion + ",ver=" + i + ",showRed " + bool);
          }
          if (jdField_a_of_type_DovComQqImCaptureDataQIMRedDotConfig.comboIconVersion != i)
          {
            jdField_a_of_type_DovComQqImCaptureDataQIMRedDotConfig.comboIconVersion = i;
            jdField_a_of_type_DovComQqImCaptureDataQIMRedDotConfig.comboShowRedDot = bool;
            jdField_a_of_type_DovComQqImCaptureDataQIMRedDotConfig.comboHasShow = false;
            jdField_a_of_type_DovComQqImCaptureDataQIMRedDotConfig.comboFirstShowTime = 0L;
          }
          i = paramString.optInt("combo_defaultCategoryVersion");
          int j = paramString.optInt("combo_defaultCategoryId", -1);
          if (QLog.isColorLevel()) {
            QLog.d("QIMRedDotConfig_Filter", 2, "updateFromServer oldVer=" + jdField_a_of_type_DovComQqImCaptureDataQIMRedDotConfig.comboDefaultCategoryVer + ",ver=" + i + ",comboDefaultCategoryId " + j);
          }
          if (jdField_a_of_type_DovComQqImCaptureDataQIMRedDotConfig.comboDefaultCategoryVer != i)
          {
            jdField_a_of_type_DovComQqImCaptureDataQIMRedDotConfig.comboDefaultCategoryVer = i;
            jdField_a_of_type_DovComQqImCaptureDataQIMRedDotConfig.comboDefaultCategoryId = j;
            jdField_a_of_type_DovComQqImCaptureDataQIMRedDotConfig.comboHasChoose = false;
          }
          i = paramString.optInt("defaultCategoryVersion");
          j = paramString.optInt("defaultCategoryId", -1);
          if (QLog.isColorLevel()) {
            QLog.d("QIMRedDotConfig_Filter", 2, "updateFromServer oldVer=" + jdField_a_of_type_DovComQqImCaptureDataQIMRedDotConfig.defaultCategoryVer + ",ver=" + i + ",defaultCategoryId " + j);
          }
          if (jdField_a_of_type_DovComQqImCaptureDataQIMRedDotConfig.defaultCategoryVer != i)
          {
            jdField_a_of_type_DovComQqImCaptureDataQIMRedDotConfig.defaultCategoryVer = i;
            jdField_a_of_type_DovComQqImCaptureDataQIMRedDotConfig.defaultCategoryId = j;
            jdField_a_of_type_DovComQqImCaptureDataQIMRedDotConfig.hasChoose = false;
          }
          i = paramString.optInt("defaultUseVersion");
          Object localObject2 = paramString.optString("defaultUseId");
          if (QLog.isColorLevel()) {
            QLog.d("QIMRedDotConfig_Filter", 2, "updateFromServer oldVer=" + jdField_a_of_type_DovComQqImCaptureDataQIMRedDotConfig.defaultUseVer + ",ver=" + i + ",defaultUseId " + (String)localObject2);
          }
          if (jdField_a_of_type_DovComQqImCaptureDataQIMRedDotConfig.defaultUseVer != i)
          {
            jdField_a_of_type_DovComQqImCaptureDataQIMRedDotConfig.defaultUseVer = i;
            jdField_a_of_type_DovComQqImCaptureDataQIMRedDotConfig.defaultUseId = ((String)localObject2);
            jdField_a_of_type_DovComQqImCaptureDataQIMRedDotConfig.hasUse = false;
          }
          i = paramString.optInt("itemRedDotVersion");
          if (jdField_a_of_type_DovComQqImCaptureDataQIMRedDotConfig.redDotVersion != i)
          {
            jdField_a_of_type_DovComQqImCaptureDataQIMRedDotConfig.redDotVersion = i;
            jdField_a_of_type_DovComQqImCaptureDataQIMRedDotConfig.redDotItems.clear();
            if (paramString.has("itemNeedRedDot"))
            {
              paramString = paramString.getJSONArray("itemNeedRedDot");
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("updateFromServer redDotList: ");
              i = 0;
              if (i < paramString.length())
              {
                String str = paramString.optString(i);
                if (TextUtils.isEmpty(str)) {
                  break label821;
                }
                QIMRedDotConfig.RedDotItemConfig localRedDotItemConfig = new QIMRedDotConfig.RedDotItemConfig();
                localRedDotItemConfig.filterId = str;
                ((StringBuilder)localObject2).append(str).append(",");
                jdField_a_of_type_DovComQqImCaptureDataQIMRedDotConfig.redDotItems.put(str, localRedDotItemConfig);
                break label821;
              }
              if (QLog.isColorLevel()) {
                QLog.d("QIMRedDotConfig_Filter", 2, ((StringBuilder)localObject2).toString());
              }
            }
          }
          a(false);
          if (QLog.isColorLevel()) {
            QLog.d("QCombo", 2, "updateComboConfig accept");
          }
          return true;
        }
        i += 1;
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QIMRedDotConfig_Filter", 2, "updateRedDotConfigFromServer null", paramString);
        }
        if (QLog.isColorLevel()) {
          QLog.d("QCombo", 2, "updateRedDotConfigFromServer fail");
        }
        return false;
      }
    }
  }
  
  public static boolean b()
  {
    if (jdField_c_of_type_Boolean) {
      return jdField_b_of_type_Boolean;
    }
    jdField_c_of_type_Boolean = true;
    jdField_b_of_type_Boolean = false;
    String str = Build.MODEL;
    if ((str.equals("ZTE BA610C")) || (str.equals("ZTE BA610T")) || (str.equals("vivo Y51A")) || (str.equals("vivo Y51")) || (str.equals("vivo Y37")) || (str.equals("OPPO A37t")) || (str.equals("OPPO A37m")) || (str.equals("SLA-TL10")) || (str.equals("SM-A5000")) || (str.equals("SM-A8000")) || (str.equals("HUAWEI GRA-TL00")) || (str.equals("OPPO A33m")) || (str.equals("OPPO A33")) || (str.equals("vivo X6A")) || (str.equals("CUN-AL00")) || (str.equals("Redmi 3")) || (str.equals("CAM-TL00")) || (str.equals("vivo Y35A")) || (str.equals("KIW-AL10")) || (str.equals("vivo Y31A")) || (str.equals("OPPO A53m")) || (str.equals("OPPO A53")) || (str.equals("OPPO R7sm")) || (str.equals("M6 Note")) || (str.equals("HUAWEI TIT-AL00")) || (str.equals("CUN-TL00")) || (str.equals("HUAWEI TIT-TL00")) || (str.equals("m2")))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFilterTools", 2, "in TransitionBlackModel:" + str);
      }
      jdField_b_of_type_Boolean = true;
    }
    return jdField_b_of_type_Boolean;
  }
  
  private static boolean b(Context paramContext)
  {
    boolean bool = false;
    int i = BaseApplicationImpl.getApplication().getSharedPreferences("short_video_filter_config_sp", 4).getInt("dov_video_filter_first_change_path", 0);
    UITools.a("VideoFilterTools", "getIsfisrtChangePath:" + i);
    if (i == 0) {
      bool = true;
    }
    return bool;
  }
  
  private void c()
  {
    File localFile = new File(jdField_c_of_type_JavaLangString);
    if (localFile.exists()) {
      localFile.delete();
    }
    for (;;)
    {
      Object localObject = LowLightTools.getLowLightImage(3.0F, 0.88F, 0.96F, 1.22F, false);
      try
      {
        FileOutputStream localFileOutputStream = new FileOutputStream(localFile);
        ((Bitmap)localObject).compress(Bitmap.CompressFormat.PNG, 100, localFileOutputStream);
        localFileOutputStream.flush();
        localFileOutputStream.close();
        if (!localFile.exists())
        {
          jdField_a_of_type_Int = f;
          return;
          localObject = localFile.getParentFile();
          if (((File)localObject).exists()) {
            continue;
          }
          ((File)localObject).mkdirs();
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.w("VideoFilterTools", 2, "LowLightTools saveBitmap:" + localException);
        }
        jdField_a_of_type_Int = jdField_d_of_type_Int;
      }
    }
  }
  
  public static boolean d()
  {
    boolean bool1 = QmcfManager.getInstance().hasQmcfEntrance(1);
    boolean bool2 = bool1;
    int i;
    if (bool1)
    {
      i = QmcfDevicesStrategy.a();
      if (i <= 0) {
        break label78;
      }
    }
    label78:
    for (bool1 = true;; bool1 = false)
    {
      bool2 = bool1;
      if (!bool1)
      {
        QmcfManager.getInstance().setQmcfMobileNotSupport(QmcfDevicesStrategy.jdField_a_of_type_JavaLangString);
        QLog.d("VideoFilterTools", 1, String.format("isArtFilterSupport supportFrameType[%d], gpuinfo[%s], model[%s]", new Object[] { Integer.valueOf(i), QmcfDevicesStrategy.jdField_a_of_type_JavaLangString, Build.MODEL }));
        bool2 = bool1;
      }
      return bool2;
    }
  }
  
  public int a()
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if ((jdField_a_of_type_DovComQqImCaptureDataQIMRedDotConfig != null) && (!jdField_a_of_type_DovComQqImCaptureDataQIMRedDotConfig.hasChoose))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QIMRedDotConfig_Filter", 2, "getDefaultCategoryId=" + jdField_a_of_type_DovComQqImCaptureDataQIMRedDotConfig.defaultCategoryId);
        }
        int i = jdField_a_of_type_DovComQqImCaptureDataQIMRedDotConfig.defaultCategoryId;
        return i;
      }
      return -1;
    }
  }
  
  public Bitmap a()
  {
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap == null) || (this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()))
    {
      Bitmap localBitmap = null;
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager != null) {
        localBitmap = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a();
      }
      if (localBitmap != null) {
        this.jdField_a_of_type_AndroidGraphicsBitmap = localBitmap.copy(localBitmap.getConfig(), true);
      }
    }
    return this.jdField_a_of_type_AndroidGraphicsBitmap;
  }
  
  public FilterDesc a(String paramString)
  {
    return (FilterDesc)jdField_a_of_type_JavaUtilHashMap.get(paramString);
  }
  
  public QIMFilterCategoryItem a(int paramInt)
  {
    return this.jdField_a_of_type_ArrayOfDovComQqImCaptureDataQIMFilterCategoryItem[paramInt];
  }
  
  public TransitionCategoryItem a()
  {
    return this.jdField_a_of_type_DovComQqImCaptureDataTransitionCategoryItem;
  }
  
  public EditVideoPartManager a()
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager == null) {}
    return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QCombo", 2, "setFrontCaptureScene " + paramInt);
    }
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    for (;;)
    {
      StringBuilder localStringBuilder;
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        if (jdField_a_of_type_DovComQqImCaptureDataQIMRedDotConfig == null) {
          return;
        }
        if ((jdField_a_of_type_DovComQqImCaptureDataQIMRedDotConfig.updateRedDotInfo(paramInt1, paramInt2, paramString)) && (QLog.isColorLevel()))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("updateRedDotInfo==> type=");
          localStringBuilder.append(paramInt1);
          if (paramInt1 == 2)
          {
            localStringBuilder.append(",categoryId=").append(paramInt2);
            QLog.d("QIMRedDotConfig_Filter", 2, localStringBuilder.toString());
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
        localStringBuilder.append(",defaultId=").append(jdField_a_of_type_DovComQqImCaptureDataQIMRedDotConfig.defaultUseId);
      } else if (paramInt1 == 5) {
        localStringBuilder.append(",defaultCategoryId=").append(jdField_a_of_type_DovComQqImCaptureDataQIMRedDotConfig.defaultCategoryId);
      } else if (paramInt1 == 7) {
        localStringBuilder.append(",comboDefaultCategoryId=").append(jdField_a_of_type_DovComQqImCaptureDataQIMRedDotConfig.comboDefaultCategoryId);
      }
    }
  }
  
  /* Error */
  public void a(Context paramContext, VideoFilterTools.OnResourceDownloadListener paramOnResourceDownloadListener, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iconst_5
    //   3: invokestatic 857	dov/com/qq/im/capture/QIMManager:a	(I)Ldov/com/qq/im/capture/IQIMManager;
    //   6: checkcast 859	dov/com/qq/im/capture/data/CaptureComboManager
    //   9: astore 4
    //   11: aload 4
    //   13: getfield 862	dov/com/qq/im/capture/data/CaptureComboManager:a	Ldov/com/tencent/mobileqq/activity/richmedia/VideoFilterTools$ComboFilterData;
    //   16: astore_1
    //   17: aload_1
    //   18: ifnull +43 -> 61
    //   21: ldc 145
    //   23: ldc_w 864
    //   26: invokestatic 152	com/tencent/av/utils/UITools:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   29: aload_1
    //   30: ifnull +63 -> 93
    //   33: aload_1
    //   34: getfield 869	dov/com/tencent/mobileqq/activity/richmedia/VideoFilterTools$ComboFilterData:a	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   37: astore_1
    //   38: aload_2
    //   39: ifnull +10 -> 49
    //   42: aload_2
    //   43: iconst_0
    //   44: invokeinterface 873 2 0
    //   49: iload_3
    //   50: ifeq +8 -> 58
    //   53: aload_0
    //   54: aload_1
    //   55: invokevirtual 876	dov/com/tencent/mobileqq/activity/richmedia/VideoFilterTools:a	(Ljava/util/concurrent/CopyOnWriteArrayList;)V
    //   58: aload_0
    //   59: monitorexit
    //   60: return
    //   61: ldc 145
    //   63: ldc_w 878
    //   66: invokestatic 152	com/tencent/av/utils/UITools:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   69: aload_0
    //   70: getstatic 882	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   73: invokevirtual 884	dov/com/tencent/mobileqq/activity/richmedia/VideoFilterTools:a	(Landroid/content/Context;)Z
    //   76: ifne +8 -> 84
    //   79: aload_0
    //   80: invokevirtual 886	dov/com/tencent/mobileqq/activity/richmedia/VideoFilterTools:a	()Z
    //   83: pop
    //   84: aload 4
    //   86: getfield 862	dov/com/qq/im/capture/data/CaptureComboManager:a	Ldov/com/tencent/mobileqq/activity/richmedia/VideoFilterTools$ComboFilterData;
    //   89: astore_1
    //   90: goto -61 -> 29
    //   93: new 305	java/util/concurrent/CopyOnWriteArrayList
    //   96: dup
    //   97: invokespecial 887	java/util/concurrent/CopyOnWriteArrayList:<init>	()V
    //   100: astore_1
    //   101: goto -63 -> 38
    //   104: astore_1
    //   105: aload_0
    //   106: monitorexit
    //   107: aload_1
    //   108: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	109	0	this	VideoFilterTools
    //   0	109	1	paramContext	Context
    //   0	109	2	paramOnResourceDownloadListener	VideoFilterTools.OnResourceDownloadListener
    //   0	109	3	paramBoolean	boolean
    //   9	76	4	localCaptureComboManager	CaptureComboManager
    // Exception table:
    //   from	to	target	type
    //   2	17	104	finally
    //   21	29	104	finally
    //   33	38	104	finally
    //   42	49	104	finally
    //   53	58	104	finally
    //   58	60	104	finally
    //   61	84	104	finally
    //   84	90	104	finally
    //   93	101	104	finally
    //   105	107	104	finally
  }
  
  public void a(Bitmap paramBitmap)
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
    try
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap.copy(paramBitmap.getConfig(), true);
      return;
    }
    catch (Exception paramBitmap)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("VideoFilterTools", 2, new Object[] { "setRawBitmap exception!", paramBitmap.toString() });
      return;
    }
    catch (Error paramBitmap)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("VideoFilterTools", 2, new Object[] { "setRawBitmap error!", paramBitmap.toString() });
    }
  }
  
  public void a(PublishVideoEntry paramPublishVideoEntry)
  {
    QLog.w("VideoFilterTools", 2, "saveRenderManagerData begin");
    if (paramPublishVideoEntry != null)
    {
      Object localObject = QQFilterRenderManagerHolder.a(QQFilterRenderManagerHolder.jdField_c_of_type_Int);
      if (localObject != null)
      {
        List localList = ((QQFilterRenderManager)localObject).getBusinessOperation().getCurrentAVFilterIdList();
        if ((localList != null) && (localList.size() > 0))
        {
          paramPublishVideoEntry.putExtra("hasAVFilter", Boolean.valueOf(true));
          paramPublishVideoEntry.putExtra("jsonAVFilterData", a(localList));
          localObject = ((QQFilterRenderManager)localObject).getBusinessOperation().getMusicItemInfo();
          if (localObject != null) {
            paramPublishVideoEntry.putExtra("jsonMusicData", ((MusicItemInfo)localObject).convertToJSON());
          }
        }
      }
    }
  }
  
  public void a(FilterDesc paramFilterDesc)
  {
    if (paramFilterDesc != null) {
      UITools.a("VideoFilterTools", "setCurrentId id: " + paramFilterDesc.id);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc = paramFilterDesc;
      return;
      UITools.a("VideoFilterTools", "setCurrentId null");
    }
  }
  
  public void a(ComboSet paramComboSet, Activity paramActivity, int paramInt)
  {
    if (paramInt == 0)
    {
      this.jdField_a_of_type_ArrayOfDovComQqImCaptureDataComboSet[2] = paramComboSet;
      this.jdField_a_of_type_ArrayOfDovComQqImCaptureDataComboSet[1] = paramComboSet;
    }
    while (paramInt != -1)
    {
      this.jdField_a_of_type_ArrayOfDovComQqImCaptureDataComboSet[paramInt] = paramComboSet;
      return;
    }
  }
  
  public void a(QIMFilterCategoryItem paramQIMFilterCategoryItem, int paramInt)
  {
    this.jdField_c_of_type_ArrayOfDovComQqImCaptureDataQIMFilterCategoryItem[paramInt] = paramQIMFilterCategoryItem;
  }
  
  public void a(QIMFilterCategoryItem paramQIMFilterCategoryItem, Activity paramActivity, int paramInt)
  {
    if (paramInt == 0)
    {
      this.jdField_a_of_type_ArrayOfDovComQqImCaptureDataQIMFilterCategoryItem[2] = paramQIMFilterCategoryItem;
      this.jdField_a_of_type_ArrayOfDovComQqImCaptureDataQIMFilterCategoryItem[1] = paramQIMFilterCategoryItem;
    }
    while (paramInt != -1)
    {
      QIMFilterCategoryItem localQIMFilterCategoryItem = this.jdField_a_of_type_ArrayOfDovComQqImCaptureDataQIMFilterCategoryItem[paramInt];
      paramActivity = paramQIMFilterCategoryItem;
      if (localQIMFilterCategoryItem != null)
      {
        paramActivity = paramQIMFilterCategoryItem;
        if (paramQIMFilterCategoryItem != null)
        {
          paramActivity = paramQIMFilterCategoryItem;
          if (TextUtils.equals(localQIMFilterCategoryItem.jdField_a_of_type_JavaLangString, paramQIMFilterCategoryItem.jdField_a_of_type_JavaLangString)) {
            paramActivity = localQIMFilterCategoryItem;
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("QCombo", 2, "setSelectedCombo last:" + localQIMFilterCategoryItem + " new:" + paramActivity + ", " + paramInt);
      }
      this.jdField_a_of_type_ArrayOfDovComQqImCaptureDataQIMFilterCategoryItem[paramInt] = paramActivity;
      if ((paramActivity != null) && (!paramActivity.c())) {
        a(3, paramActivity.jdField_a_of_type_Int, paramActivity.jdField_a_of_type_JavaLangString);
      }
      return;
    }
  }
  
  public void a(TransitionCategoryItem paramTransitionCategoryItem)
  {
    this.jdField_a_of_type_DovComQqImCaptureDataTransitionCategoryItem = paramTransitionCategoryItem;
  }
  
  public void a(EditVideoPartManager paramEditVideoPartManager)
  {
    if (paramEditVideoPartManager == null) {}
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager = paramEditVideoPartManager;
  }
  
  void a(CopyOnWriteArrayList<FilterCategory> paramCopyOnWriteArrayList)
  {
    label19:
    CaptureComboManager localCaptureComboManager;
    if ((paramCopyOnWriteArrayList == null) || (paramCopyOnWriteArrayList.size() == 0))
    {
      UITools.a("VideoFilterTools", "preDownloadResource list is empty!");
      return;
    }
    else
    {
      UITools.a("VideoFilterTools", " preDownloadResource Categorylist size: " + paramCopyOnWriteArrayList.size());
      localCaptureComboManager = (CaptureComboManager)QIMManager.a(5);
      paramCopyOnWriteArrayList = paramCopyOnWriteArrayList.iterator();
    }
    for (;;)
    {
      if (!paramCopyOnWriteArrayList.hasNext()) {
        break label19;
      }
      Object localObject = (FilterCategory)paramCopyOnWriteArrayList.next();
      if (((FilterCategory)localObject).jdField_a_of_type_Boolean) {
        break;
      }
      localObject = ((FilterCategory)localObject).jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        FilterSet localFilterSet = localCaptureComboManager.a((QIMFilterCategoryItem)((Iterator)localObject).next());
        if ((localFilterSet.a()) && (localFilterSet.a() == 2)) {
          localFilterSet.b();
        }
      }
    }
  }
  
  public boolean a()
  {
    a();
    Object localObject = QIMFileUtils.a("filter_template.cfg");
    try
    {
      localObject = new VideoFilterTools.ComboFilterData((String)localObject);
      ((CaptureComboManager)QIMManager.a(5)).a((VideoFilterTools.ComboFilterData)localObject);
      bool1 = true;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        boolean bool2 = false;
        boolean bool1 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.i("VideoFilterTools", 2, "initFromAsset " + false, localException);
          bool1 = bool2;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("VideoFilterTools", 2, "initFromAsset " + bool1);
    }
    return bool1;
  }
  
  public boolean a(Context paramContext)
  {
    bool2 = false;
    a();
    paramContext = a(paramContext);
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(paramContext)) {
          continue;
        }
        paramContext = new VideoFilterTools.ComboFilterData(paramContext);
        ((CaptureComboManager)QIMManager.a(5)).a(paramContext);
        bool1 = paramContext.a.isEmpty();
        if (bool1) {
          continue;
        }
        bool1 = true;
      }
      catch (Exception paramContext)
      {
        boolean bool1 = bool2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("VideoFilterTools", 2, "initFromCache", paramContext);
        bool1 = bool2;
        continue;
        bool1 = false;
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.i("VideoFilterTools", 2, "initFromCache " + bool1);
      }
      return bool1;
      bool1 = false;
    }
  }
  
  public int b()
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if ((jdField_a_of_type_DovComQqImCaptureDataQIMRedDotConfig != null) && (!jdField_a_of_type_DovComQqImCaptureDataQIMRedDotConfig.comboHasChoose))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QIMRedDotConfig_Filter", 2, "getDefaultComboCategoryId=" + jdField_a_of_type_DovComQqImCaptureDataQIMRedDotConfig.comboDefaultCategoryId);
        }
        int i = jdField_a_of_type_DovComQqImCaptureDataQIMRedDotConfig.comboDefaultCategoryId;
        return i;
      }
      return -1;
    }
  }
  
  public QIMFilterCategoryItem b(int paramInt)
  {
    return this.jdField_b_of_type_ArrayOfDovComQqImCaptureDataQIMFilterCategoryItem[paramInt];
  }
  
  public void b()
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager = null;
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
  }
  
  public void b(QIMFilterCategoryItem paramQIMFilterCategoryItem, Activity paramActivity, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QCombo", 2, "setSelectedFilter " + paramQIMFilterCategoryItem + " scene " + paramInt);
    }
    if (paramInt == -1) {}
    do
    {
      return;
      paramActivity = this.jdField_b_of_type_ArrayOfDovComQqImCaptureDataQIMFilterCategoryItem[paramInt];
      this.jdField_b_of_type_ArrayOfDovComQqImCaptureDataQIMFilterCategoryItem[paramInt] = paramQIMFilterCategoryItem;
      if (QLog.isColorLevel()) {
        QLog.i("QCombo", 2, "setSelectedFilter last:" + paramActivity);
      }
    } while ((paramQIMFilterCategoryItem == null) || (paramQIMFilterCategoryItem.c()));
    a(3, paramQIMFilterCategoryItem.jdField_a_of_type_Int, paramQIMFilterCategoryItem.jdField_a_of_type_JavaLangString);
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public int c()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public QIMFilterCategoryItem c(int paramInt)
  {
    return this.jdField_c_of_type_ArrayOfDovComQqImCaptureDataQIMFilterCategoryItem[paramInt];
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.VideoFilterTools
 * JD-Core Version:    0.7.0.1
 */