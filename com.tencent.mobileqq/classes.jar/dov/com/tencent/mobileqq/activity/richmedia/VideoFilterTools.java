package dov.com.tencent.mobileqq.activity.richmedia;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import aopn;
import com.tencent.av.utils.UITools;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.QQFilterRenderManagerHolder;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.data.CaptureComboManager;
import dov.com.qq.im.capture.data.ComboSet;
import dov.com.qq.im.capture.data.FilterCategory;
import dov.com.qq.im.capture.data.QIMFilterCategoryItem;
import dov.com.qq.im.capture.data.QIMRedDotConfig;
import dov.com.qq.im.capture.data.TransitionCategoryItem;
import dov.com.qq.im.capture.util.QIMFileUtils;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoPartManager;
import dov.com.tencent.mobileqq.richmedia.capture.data.CaptureVideoFilterManager;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class VideoFilterTools
{
  static int jdField_a_of_type_Int;
  private static VideoFilterTools jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterTools;
  public static Object a;
  public static final String a;
  public static HashMap a;
  public static String b;
  public static String c;
  private static int jdField_d_of_type_Int;
  private static final String jdField_d_of_type_JavaLangString;
  private static int e;
  private static int f = -1;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  aopn jdField_a_of_type_Aopn = new aopn(this);
  public FilterDesc a;
  public QIMRedDotConfig a;
  private TransitionCategoryItem jdField_a_of_type_DovComQqImCaptureDataTransitionCategoryItem;
  private EditVideoPartManager jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private int[] jdField_a_of_type_ArrayOfInt = { -1 };
  public ComboSet[] a;
  public QIMFilterCategoryItem[] a;
  private int b;
  public QIMFilterCategoryItem[] b;
  private int c;
  
  static
  {
    jdField_a_of_type_JavaLangString = CaptureVideoFilterManager.jdField_a_of_type_JavaLangString + "artfilter" + File.separator;
    jdField_d_of_type_JavaLangString = AppConstants.aK + "dov_capture_qsvf" + File.separator;
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_a_of_type_Int = 1300000;
    jdField_b_of_type_JavaLangString = CaptureVideoFilterManager.jdField_a_of_type_JavaLangString + "lowlight";
    jdField_c_of_type_JavaLangString = jdField_b_of_type_JavaLangString + File.separator + "LowLight.png";
    jdField_d_of_type_Int = 2;
    jdField_e_of_type_Int = 1;
  }
  
  private VideoFilterTools()
  {
    this.jdField_b_of_type_Int = -1;
    this.jdField_c_of_type_Int = -1;
    this.jdField_a_of_type_ArrayOfDovComQqImCaptureDataQIMFilterCategoryItem = new QIMFilterCategoryItem[5];
    this.jdField_a_of_type_ArrayOfDovComQqImCaptureDataComboSet = new ComboSet[5];
    this.jdField_b_of_type_ArrayOfDovComQqImCaptureDataQIMFilterCategoryItem = new QIMFilterCategoryItem[5];
  }
  
  public static int a(Context paramContext)
  {
    int i = 0;
    int j = PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("dov_video_filter_config_version", 0);
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
  
  public static VideoFilterTools.DataSet a(CopyOnWriteArrayList paramCopyOnWriteArrayList, boolean paramBoolean1, boolean paramBoolean2)
  {
    VideoFilterTools.DataSet localDataSet = new VideoFilterTools.DataSet();
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
      localFilterCategory = new FilterCategory(((FilterCategory)localObject1).jdField_a_of_type_Int, ((FilterCategory)localObject1).jdField_a_of_type_JavaLangString, ((FilterCategory)localObject1).jdField_a_of_type_Boolean, ((FilterCategory)localObject1).jdField_b_of_type_Boolean, ((FilterCategory)localObject1).jdField_b_of_type_Int);
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
          paramCopyOnWriteArrayList = (CopyOnWriteArrayList)localObject1;
          if (!localQIMFilterCategoryItem.b()) {}
        }
        else
        {
          localFilterCategory.jdField_a_of_type_JavaUtilList.add(localQIMFilterCategoryItem);
          localArrayList1.add(localQIMFilterCategoryItem);
          paramCopyOnWriteArrayList = (CopyOnWriteArrayList)localObject1;
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
      localFilterCategory = new FilterCategory(((FilterCategory)localObject2).jdField_a_of_type_Int, ((FilterCategory)localObject2).jdField_a_of_type_JavaLangString, ((FilterCategory)localObject2).jdField_a_of_type_Boolean, ((FilterCategory)localObject2).jdField_b_of_type_Boolean, ((FilterCategory)localObject2).jdField_b_of_type_Int);
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
          if (QLog.isColorLevel()) {
            QLog.d("VideoFilterTools", 2, " buildDataSet needPredownload " + localQIMFilterCategoryItem.jdField_b_of_type_JavaLangString + localQIMFilterCategoryItem.f());
          }
          localObject1 = localObject2;
          if (!localQIMFilterCategoryItem.f())
          {
            localFilterCategory.jdField_a_of_type_JavaUtilList.add(localQIMFilterCategoryItem);
            localArrayList1.add(localQIMFilterCategoryItem);
            localArrayList2.add(localQIMFilterCategoryItem);
            localObject1 = localObject2;
          }
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
  
  static ArrayList a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      UITools.a("VideoFilterTools", "parseConfig|content is empty.");
    }
    for (;;)
    {
      try
      {
        Object localObject = FilterDesc.a(new JSONObject(paramString).getJSONArray("filters"));
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
  
  public static ArrayList a(CopyOnWriteArrayList paramCopyOnWriteArrayList, int paramInt, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    int i;
    if ((QmcfManager.a().a(1)) && (paramBoolean))
    {
      i = 1;
      paramCopyOnWriteArrayList = paramCopyOnWriteArrayList.iterator();
    }
    label518:
    label524:
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
          localFilterCategory = new FilterCategory(((FilterCategory)localObject).jdField_a_of_type_Int, ((FilterCategory)localObject).jdField_a_of_type_JavaLangString, ((FilterCategory)localObject).jdField_a_of_type_Boolean, ((FilterCategory)localObject).jdField_b_of_type_Boolean, ((FilterCategory)localObject).jdField_b_of_type_Int);
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
          break label524;
        }
        localArrayList.add(localFilterCategory);
        break;
        if ((paramInt != 2) || (((FilterCategory)localObject).jdField_a_of_type_Boolean)) {
          break;
        }
        localFilterCategory = new FilterCategory(((FilterCategory)localObject).jdField_a_of_type_Int, ((FilterCategory)localObject).jdField_a_of_type_JavaLangString, ((FilterCategory)localObject).jdField_a_of_type_Boolean, ((FilterCategory)localObject).jdField_b_of_type_Boolean, ((FilterCategory)localObject).jdField_b_of_type_Int);
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
            break label518;
          }
          localArrayList.add(localFilterCategory);
          break;
          if (QLog.isColorLevel())
          {
            paramCopyOnWriteArrayList = new StringBuilder(20);
            paramCopyOnWriteArrayList.append("getFilterCategory categoryType:").append(paramInt).append(" filter:");
            if (localArrayList != null) {
              break label501;
            }
            paramCopyOnWriteArrayList.append("null ");
          }
          for (;;)
          {
            QLog.d("VideoFilterTools", 2, paramCopyOnWriteArrayList.toString());
            return localArrayList;
            label501:
            paramCopyOnWriteArrayList.append(localArrayList.size());
          }
        }
        break;
      }
    }
  }
  
  public static JSONArray a(List paramList)
  {
    localJSONArray = new JSONArray();
    try
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        FilterDesc localFilterDesc = (FilterDesc)paramList.next();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("filterid", localFilterDesc.jdField_b_of_type_Int + "");
        localJSONObject.put("type", localFilterDesc.jdField_a_of_type_Int + "");
        localJSONObject.put("name", localFilterDesc.jdField_e_of_type_JavaLangString);
        localJSONObject.put("respicname", localFilterDesc.g);
        localJSONObject.put("version", localFilterDesc.jdField_e_of_type_Int);
        localJSONObject.put("md5", localFilterDesc.jdField_b_of_type_JavaLangString);
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
  
  private static void a(Context paramContext)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("dov_video_filter_config_first_launch", 1);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    UITools.a("VideoFilterTools", "setQQShortVideoFilterConfigVersion:" + paramInt);
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("dov_video_filter_config_version", paramInt);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    if (paramString == null)
    {
      UITools.a("VideoFilterTools", "updateQQShortVideoFilterConfig error ");
      return;
    }
    a(paramContext, paramString, a(paramContext));
    FileUtils.a(CaptureVideoFilterManager.jdField_a_of_type_JavaLangString, "filter_config_new.xml", paramString);
    a(paramContext, paramInt);
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
              if ((localFilterDesc.jdField_e_of_type_JavaLangString != null) && (localFilterDesc.jdField_e_of_type_JavaLangString.equals(paramString2.jdField_e_of_type_JavaLangString)))
              {
                UITools.a("VideoFilterTools", "compareContent res:" + localFilterDesc.jdField_e_of_type_JavaLangString + "|" + localFilterDesc.jdField_b_of_type_JavaLangString + "|" + paramString2.jdField_b_of_type_JavaLangString);
                if ((!TextUtils.isEmpty(localFilterDesc.jdField_b_of_type_JavaLangString)) && (!localFilterDesc.jdField_b_of_type_JavaLangString.equals(paramString2.jdField_b_of_type_JavaLangString)))
                {
                  UITools.a("VideoFilterTools", "compareContentDelete res:" + paramString2.b(CaptureVideoFilterManager.jdField_b_of_type_JavaLangString));
                  FileUtils.a(paramString2.b(CaptureVideoFilterManager.jdField_b_of_type_JavaLangString));
                }
                UITools.a("VideoFilterTools", "compareContent iconMD5:" + localFilterDesc.jdField_e_of_type_JavaLangString + "|" + localFilterDesc.jdField_d_of_type_JavaLangString + "|" + paramString2.jdField_d_of_type_JavaLangString);
                if ((!TextUtils.isEmpty(localFilterDesc.jdField_d_of_type_JavaLangString)) && (!localFilterDesc.jdField_d_of_type_JavaLangString.equals(paramString2.jdField_d_of_type_JavaLangString)))
                {
                  UITools.a("VideoFilterTools", "compareContentDelete iconMD5:" + paramString2.a(CaptureVideoFilterManager.jdField_b_of_type_JavaLangString));
                  FileUtils.d(paramString2.a(CaptureVideoFilterManager.jdField_b_of_type_JavaLangString));
                }
              }
            }
          }
        }
      }
    }
  }
  
  private static void b(Context paramContext)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("dov_video_filter_first_change_path", 1);
    paramContext.commit();
  }
  
  private static boolean c(Context paramContext)
  {
    boolean bool = false;
    int i = PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("dov_video_filter_config_first_launch", 0);
    UITools.a("VideoFilterTools", "getIsFirstLauncher:" + i);
    if (i == 0) {
      bool = true;
    }
    return bool;
  }
  
  private static boolean d(Context paramContext)
  {
    boolean bool = false;
    int i = PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("dov_video_filter_first_change_path", 0);
    UITools.a("VideoFilterTools", "getIsfisrtChangePath:" + i);
    if (i == 0) {
      bool = true;
    }
    return bool;
  }
  
  public int a()
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_DovComQqImCaptureDataQIMRedDotConfig != null) && (!this.jdField_a_of_type_DovComQqImCaptureDataQIMRedDotConfig.hasChoose))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QIMRedDotConfig_Filter", 2, "getDefaultCategoryId=" + this.jdField_a_of_type_DovComQqImCaptureDataQIMRedDotConfig.defaultCategoryId);
        }
        int i = this.jdField_a_of_type_DovComQqImCaptureDataQIMRedDotConfig.defaultCategoryId;
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
  
  public void a()
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager = null;
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
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
        if (this.jdField_a_of_type_DovComQqImCaptureDataQIMRedDotConfig == null) {
          return;
        }
        if ((this.jdField_a_of_type_DovComQqImCaptureDataQIMRedDotConfig.updateRedDotInfo(paramInt1, paramInt2, paramString)) && (QLog.isColorLevel()))
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
        localStringBuilder.append(",defaultId=").append(this.jdField_a_of_type_DovComQqImCaptureDataQIMRedDotConfig.defaultUseId);
      } else if (paramInt1 == 5) {
        localStringBuilder.append(",defaultCategoryId=").append(this.jdField_a_of_type_DovComQqImCaptureDataQIMRedDotConfig.defaultCategoryId);
      } else if (paramInt1 == 7) {
        localStringBuilder.append(",comboDefaultCategoryId=").append(this.jdField_a_of_type_DovComQqImCaptureDataQIMRedDotConfig.comboDefaultCategoryId);
      }
    }
  }
  
  public void a(Context paramContext, VideoFilterTools.OnResourceDownloadListener paramOnResourceDownloadListener)
  {
    if (c(BaseApplicationImpl.getContext()))
    {
      a(BaseApplicationImpl.getContext());
      if (new File(CaptureVideoFilterManager.jdField_b_of_type_JavaLangString).exists()) {
        FileUtils.a(CaptureVideoFilterManager.jdField_b_of_type_JavaLangString);
      }
    }
    if (d(BaseApplicationImpl.getContext()))
    {
      b(BaseApplicationImpl.getContext());
      if (new File(jdField_d_of_type_JavaLangString).exists()) {
        FileUtils.a(jdField_d_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      try
      {
        paramContext = (CaptureComboManager)QIMManager.a(5);
        if (paramContext.a != null)
        {
          UITools.a("VideoFilterTools", "already inited");
          if (paramOnResourceDownloadListener != null) {
            paramOnResourceDownloadListener.j(false);
          }
          return;
        }
        UITools.a("VideoFilterTools", "initCaptureComboManager");
        if (paramOnResourceDownloadListener != null) {
          this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramOnResourceDownloadListener);
        }
        if (!a(BaseApplicationImpl.sApplication)) {
          a();
        }
        paramContext = paramContext.a;
        if (paramContext != null)
        {
          paramContext = paramContext.a;
          if (paramOnResourceDownloadListener != null) {
            paramOnResourceDownloadListener.j(false);
          }
          UITools.a("VideoFilterTools", "filter list size:" + paramContext.size());
          return;
        }
      }
      finally {}
      paramContext = new CopyOnWriteArrayList();
    }
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
        List localList = ((QQFilterRenderManager)localObject).a();
        if ((localList != null) && (localList.size() > 0))
        {
          paramPublishVideoEntry.putExtra("hasAVFilter", Boolean.valueOf(true));
          paramPublishVideoEntry.putExtra("jsonAVFilterData", a(localList));
          localObject = ((QQFilterRenderManager)localObject).a();
          if (localObject != null) {
            paramPublishVideoEntry.putExtra("jsonMusicData", ((MusicItemInfo)localObject).a());
          }
        }
      }
    }
  }
  
  public void a(FilterDesc paramFilterDesc)
  {
    if (paramFilterDesc != null) {
      UITools.a("VideoFilterTools", "setCurrentId id: " + paramFilterDesc.jdField_b_of_type_Int);
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
      if (this.jdField_a_of_type_ArrayOfDovComQqImCaptureDataQIMFilterCategoryItem[2] != null) {}
      this.jdField_a_of_type_ArrayOfDovComQqImCaptureDataComboSet[2] = paramComboSet;
      if (this.jdField_a_of_type_ArrayOfDovComQqImCaptureDataComboSet[1] != null) {}
      this.jdField_a_of_type_ArrayOfDovComQqImCaptureDataComboSet[1] = paramComboSet;
    }
    while (paramInt == -1)
    {
      return;
      if ((paramInt == 2) || (paramInt == 1) || (paramInt == 3) || (paramInt != 4)) {}
    }
    this.jdField_a_of_type_ArrayOfDovComQqImCaptureDataComboSet[paramInt] = paramComboSet;
  }
  
  public void a(QIMFilterCategoryItem paramQIMFilterCategoryItem, Activity paramActivity, int paramInt)
  {
    CaptureComboManager localCaptureComboManager = (CaptureComboManager)QIMManager.a(5);
    if (paramInt == 0)
    {
      if (this.jdField_a_of_type_ArrayOfDovComQqImCaptureDataQIMFilterCategoryItem[2] != null) {}
      this.jdField_a_of_type_ArrayOfDovComQqImCaptureDataQIMFilterCategoryItem[2] = paramQIMFilterCategoryItem;
      if (this.jdField_a_of_type_ArrayOfDovComQqImCaptureDataQIMFilterCategoryItem[1] != null) {}
      this.jdField_a_of_type_ArrayOfDovComQqImCaptureDataQIMFilterCategoryItem[1] = paramQIMFilterCategoryItem;
    }
    while (paramInt == -1)
    {
      return;
      if ((paramInt == 2) || (paramInt == 1) || (paramInt == 3) || (paramInt != 4)) {}
    }
    QIMFilterCategoryItem localQIMFilterCategoryItem = this.jdField_a_of_type_ArrayOfDovComQqImCaptureDataQIMFilterCategoryItem[paramInt];
    paramActivity = paramQIMFilterCategoryItem;
    if (localQIMFilterCategoryItem != null)
    {
      localCaptureComboManager.a(localQIMFilterCategoryItem);
      if (paramQIMFilterCategoryItem != null) {
        break label189;
      }
      paramActivity = paramQIMFilterCategoryItem;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QCombo", 2, "setSelectedCombo last:" + localQIMFilterCategoryItem + " new:" + paramActivity + ", " + paramInt);
      }
      this.jdField_a_of_type_ArrayOfDovComQqImCaptureDataQIMFilterCategoryItem[paramInt] = paramActivity;
      if ((paramActivity == null) || (paramActivity.c())) {
        break;
      }
      a(3, paramActivity.jdField_a_of_type_Int, paramActivity.jdField_a_of_type_JavaLangString);
      return;
      label189:
      paramActivity = paramQIMFilterCategoryItem;
      if (TextUtils.equals(localQIMFilterCategoryItem.jdField_a_of_type_JavaLangString, paramQIMFilterCategoryItem.jdField_a_of_type_JavaLangString)) {
        paramActivity = localQIMFilterCategoryItem;
      }
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
  
  void a(CopyOnWriteArrayList paramCopyOnWriteArrayList)
  {
    if ((paramCopyOnWriteArrayList == null) || (paramCopyOnWriteArrayList.size() == 0)) {
      UITools.a("VideoFilterTools", "preDownloadResource list is empty!");
    }
    ArrayList localArrayList;
    do
    {
      return;
      UITools.a("VideoFilterTools", " preDownloadResource Categorylist size: " + paramCopyOnWriteArrayList.size());
      localArrayList = new ArrayList();
      paramCopyOnWriteArrayList = paramCopyOnWriteArrayList.iterator();
      while (paramCopyOnWriteArrayList.hasNext())
      {
        Object localObject = (FilterCategory)paramCopyOnWriteArrayList.next();
        if (!((FilterCategory)localObject).jdField_a_of_type_Boolean)
        {
          localObject = ((FilterCategory)localObject).jdField_a_of_type_JavaUtilList.iterator();
          while (((Iterator)localObject).hasNext())
          {
            Iterator localIterator = ((QIMFilterCategoryItem)((Iterator)localObject).next()).jdField_a_of_type_JavaUtilArrayList.iterator();
            while (localIterator.hasNext())
            {
              FilterDesc localFilterDesc = a((String)localIterator.next());
              if ((localFilterDesc != null) && (localFilterDesc.jdField_d_of_type_Int == 1) && (!TextUtils.isEmpty(localFilterDesc.jdField_a_of_type_JavaLangString)) && (VideoFilterListDownloader.a(localFilterDesc)))
              {
                localArrayList.add(localFilterDesc);
                UITools.a("VideoFilterTools", "VideoFilterListDownloader needDownLoad: " + localFilterDesc.jdField_e_of_type_JavaLangString);
              }
            }
          }
        }
      }
    } while (localArrayList.size() <= 0);
    VideoFilterListDownloader.a().a(localArrayList, this.jdField_a_of_type_Aopn);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if ((this.jdField_a_of_type_DovComQqImCaptureDataQIMRedDotConfig != null) && (this.jdField_a_of_type_DovComQqImCaptureDataQIMRedDotConfig.update))
      {
        this.jdField_a_of_type_DovComQqImCaptureDataQIMRedDotConfig.update = false;
        QIMRedDotConfig.saveRedDotConfig(this.jdField_a_of_type_DovComQqImCaptureDataQIMRedDotConfig, CaptureVideoFilterManager.jdField_a_of_type_JavaLangString);
      }
      return;
    }
    QIMRedDotConfig.saveRedDotConfig(this.jdField_a_of_type_DovComQqImCaptureDataQIMRedDotConfig, CaptureVideoFilterManager.jdField_a_of_type_JavaLangString);
  }
  
  public boolean a()
  {
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
  
  public boolean a(int paramInt1, int paramInt2, String paramString)
  {
    for (;;)
    {
      StringBuilder localStringBuilder;
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_DovComQqImCaptureDataQIMRedDotConfig == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("QIMRedDotConfig_Filter", 2, "needShowRedDot|mQIMRedDotConfig is null");
          }
          return false;
        }
        boolean bool = this.jdField_a_of_type_DovComQqImCaptureDataQIMRedDotConfig.needShowRedDot(paramInt1, paramInt2, paramString);
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
        localStringBuilder.append(",defaultId=").append(this.jdField_a_of_type_DovComQqImCaptureDataQIMRedDotConfig.defaultUseId);
      } else if (paramInt1 == 5) {
        localStringBuilder.append(",defaultCategoryId=").append(this.jdField_a_of_type_DovComQqImCaptureDataQIMRedDotConfig.defaultCategoryId);
      } else if (paramInt1 == 7) {
        localStringBuilder.append(",comboDefaultCategoryId=").append(this.jdField_a_of_type_DovComQqImCaptureDataQIMRedDotConfig.comboDefaultCategoryId);
      }
    }
  }
  
  public boolean a(Context paramContext)
  {
    bool2 = false;
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
  
  public boolean a(String paramString)
  {
    boolean bool1 = false;
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(paramString)) {
          break label70;
        }
        paramString = new VideoFilterTools.ComboFilterData(paramString, true);
        ((CaptureComboManager)QIMManager.a(5)).a(paramString);
        boolean bool2 = paramString.a.isEmpty();
        if (bool2) {
          continue;
        }
        bool1 = true;
      }
      catch (Exception paramString)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("VideoFilterTools", 2, "initFromCache", paramString);
        return false;
      }
      return bool1;
      bool1 = false;
      continue;
      label70:
      bool1 = false;
    }
  }
  
  public int b()
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_DovComQqImCaptureDataQIMRedDotConfig != null) && (!this.jdField_a_of_type_DovComQqImCaptureDataQIMRedDotConfig.comboHasChoose))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QIMRedDotConfig_Filter", 2, "getDefaultComboCategoryId=" + this.jdField_a_of_type_DovComQqImCaptureDataQIMRedDotConfig.comboDefaultCategoryId);
        }
        int i = this.jdField_a_of_type_DovComQqImCaptureDataQIMRedDotConfig.comboDefaultCategoryId;
        return i;
      }
      return -1;
    }
  }
  
  public QIMFilterCategoryItem b(int paramInt)
  {
    return this.jdField_b_of_type_ArrayOfDovComQqImCaptureDataQIMFilterCategoryItem[paramInt];
  }
  
  public void b(QIMFilterCategoryItem paramQIMFilterCategoryItem, Activity paramActivity, int paramInt)
  {
    a();
    if (QLog.isColorLevel()) {
      QLog.d("QCombo", 2, " setSelectedFilter " + paramQIMFilterCategoryItem + " scene " + paramInt);
    }
    paramActivity = (CaptureComboManager)QIMManager.a(5);
    if (paramInt == 0)
    {
      if (this.jdField_b_of_type_ArrayOfDovComQqImCaptureDataQIMFilterCategoryItem[2] != null) {}
      this.jdField_b_of_type_ArrayOfDovComQqImCaptureDataQIMFilterCategoryItem[2] = paramQIMFilterCategoryItem;
      if (this.jdField_b_of_type_ArrayOfDovComQqImCaptureDataQIMFilterCategoryItem[1] == null) {}
    }
    do
    {
      this.jdField_b_of_type_ArrayOfDovComQqImCaptureDataQIMFilterCategoryItem[1] = paramQIMFilterCategoryItem;
      while (paramInt == -1)
      {
        return;
        if ((paramInt == 2) || (paramInt == 1) || (paramInt == 3) || (paramInt != 4)) {}
      }
      paramActivity = this.jdField_b_of_type_ArrayOfDovComQqImCaptureDataQIMFilterCategoryItem[paramInt];
      if ((paramActivity == null) || (QLog.isColorLevel())) {
        QLog.i("QCombo", 2, "setSelectedFilter last:" + paramActivity + " new:" + paramQIMFilterCategoryItem);
      }
      this.jdField_b_of_type_ArrayOfDovComQqImCaptureDataQIMFilterCategoryItem[paramInt] = paramQIMFilterCategoryItem;
    } while ((paramQIMFilterCategoryItem == null) || (paramQIMFilterCategoryItem.c()));
    a(3, paramQIMFilterCategoryItem.jdField_a_of_type_Int, paramQIMFilterCategoryItem.jdField_a_of_type_JavaLangString);
  }
  
  public boolean b(Context paramContext)
  {
    boolean bool2 = a(a(paramContext));
    QLog.i("VideoFilterTools", 2, "ReloadContext FromCache " + bool2);
    boolean bool1 = bool2;
    if (!bool2)
    {
      bool1 = a(QIMFileUtils.a("filter_template.cfg"));
      QLog.i("VideoFilterTools", 2, "ReloadContext  FromAssets" + bool1);
    }
    return bool1;
  }
  
  public int c()
  {
    return this.jdField_c_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.VideoFilterTools
 * JD-Core Version:    0.7.0.1
 */