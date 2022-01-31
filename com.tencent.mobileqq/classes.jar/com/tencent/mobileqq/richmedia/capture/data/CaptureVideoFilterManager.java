package com.tencent.mobileqq.richmedia.capture.data;

import ahhn;
import ahho;
import ahhp;
import ahhq;
import ahhr;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.av.AVLog;
import com.tencent.av.AVNetEngine;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CaptureVideoFilterManager
{
  private static int jdField_a_of_type_Int;
  public static Object a;
  public static final String a;
  private static int jdField_b_of_type_Int;
  public static final String b;
  private static boolean jdField_b_of_type_Boolean;
  private static int c;
  public static final String c;
  public static String d;
  public static String e;
  private static final String f;
  private static final String g;
  private Handler jdField_a_of_type_AndroidOsHandler;
  public CaptureRedDotConfig a;
  private CaptureVideoFilterManager.CaptureVideoFilterRefreshListener jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureVideoFilterManager$CaptureVideoFilterRefreshListener;
  private CaptureVideoFilterManager.OnResourceDownloadListener jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureVideoFilterManager$OnResourceDownloadListener;
  public FilterCategoryItem a;
  HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private final CopyOnWriteArrayList jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  public boolean a;
  private final CopyOnWriteArrayList jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  
  static
  {
    jdField_a_of_type_JavaLangString = AppConstants.aJ + "capture_qsvf" + File.separator;
    jdField_b_of_type_JavaLangString = jdField_a_of_type_JavaLangString + "capture_res" + File.separator;
    f = AppConstants.aJ + "qav" + File.separator + "beauty" + File.separator;
    g = f + "SKINCOLOR" + File.separator;
    jdField_c_of_type_JavaLangString = f;
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_d_of_type_JavaLangString = jdField_a_of_type_JavaLangString + "lowlight";
    e = jdField_d_of_type_JavaLangString + File.separator + "LowLight.png";
    jdField_a_of_type_Int = 2;
    jdField_b_of_type_Int = 1;
    jdField_c_of_type_Int = -1;
  }
  
  private CaptureVideoFilterManager()
  {
    GraphicRenderMgr.loadSo();
    String str = DeviceInfoUtil.i() + " " + DeviceInfoUtil.e();
    QLog.i("CaptureVideoFilterManager", 2, "DeviceInfo " + str);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
  }
  
  public static int a(Context paramContext)
  {
    int i = 0;
    int j = PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("capture_qq_video_filter_config_version", 0);
    if ((j > 0) && (!new File(jdField_a_of_type_JavaLangString + "filter_config.xml").exists())) {
      AVLog.c("CaptureVideoFilterManager", "getQQShortVideoFilterConfigVersion config file don't exist!");
    }
    for (;;)
    {
      AVLog.c("CaptureVideoFilterManager", "getQQShortVideoFilterConfigVersion:" + i);
      return i;
      i = j;
    }
  }
  
  private static CaptureVideoFilterManager.SkinColorFilterDesc a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      AVLog.c("CaptureVideoFilterManager", "parseConfig|content is empty.");
      return null;
    }
    for (;;)
    {
      try
      {
        localJSONObject = new JSONObject(paramString).getJSONObject("skinColorFilter");
      }
      catch (JSONException localJSONException3)
      {
        JSONObject localJSONObject;
        int i;
        String str1;
        String str2;
        localSkinColorFilterDesc = null;
        continue;
      }
      try
      {
        i = Integer.valueOf(localJSONObject.getString("filterid")).intValue();
        str1 = localJSONObject.getString("resurl");
        str2 = localJSONObject.getString("md5");
        localSkinColorFilterDesc = new CaptureVideoFilterManager.SkinColorFilterDesc(i, str1, str2);
        try
        {
          AVLog.c("CaptureVideoFilterManager", "parseConfig:" + i + "|" + str1 + "|" + str2);
          return localSkinColorFilterDesc;
        }
        catch (JSONException localJSONException1) {}
      }
      catch (JSONException localJSONException4)
      {
        localSkinColorFilterDesc = null;
        continue;
      }
      try
      {
        localJSONException1.printStackTrace();
        AVLog.c("CaptureVideoFilterManager", "parseConfig failed. info = " + localJSONObject);
        return localSkinColorFilterDesc;
      }
      catch (JSONException localJSONException2)
      {
        localJSONException2.printStackTrace();
        AVLog.c("CaptureVideoFilterManager", "parseConfig|parse failed.context = " + paramString);
        return localSkinColorFilterDesc;
      }
    }
  }
  
  public static final CaptureVideoFilterManager a()
  {
    return ahho.a();
  }
  
  public static String a(Context paramContext)
  {
    try
    {
      File localFile = new File(jdField_a_of_type_JavaLangString + "filter_config.xml");
      AVLog.c("CaptureVideoFilterManager", "getQQShortVideoFilterConfig:" + jdField_a_of_type_JavaLangString + "filter_config.xml" + "|" + localFile.exists());
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
  
  public static void a(Context paramContext)
  {
    try
    {
      if (b(paramContext))
      {
        c(paramContext);
        if (new File(g).exists()) {
          FileUtils.a(g);
        }
      }
      paramContext = a(b(paramContext));
      if ((paramContext != null) && (!TextUtils.isEmpty(paramContext.jdField_a_of_type_JavaLangString)))
      {
        Object localObject = new File(g + "params.json");
        AVLog.c("CaptureVideoFilterManager", "preDownloadResource :" + ((File)localObject).exists());
        if (!((File)localObject).exists())
        {
          localObject = new HttpNetReq();
          ((HttpNetReq)localObject).jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = new ahhq();
          ((HttpNetReq)localObject).jdField_a_of_type_JavaLangString = paramContext.jdField_a_of_type_JavaLangString;
          ((HttpNetReq)localObject).jdField_a_of_type_Int = 0;
          ((HttpNetReq)localObject).jdField_c_of_type_JavaLangString = (f + "skin_color.zip");
          ((HttpNetReq)localObject).a(paramContext);
          AVNetEngine.a().a((NetReq)localObject);
        }
      }
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    AVLog.c("CaptureVideoFilterManager", "setQQShortVideoFilterConfigVersion:" + paramInt);
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("capture_qq_video_filter_config_version", paramInt);
    paramContext.commit();
  }
  
  static void a(Context paramContext, String paramString1, String paramString2)
  {
    Iterator localIterator = null;
    long l1 = System.currentTimeMillis();
    if ((paramString1 != null) && (!paramString1.equals("")))
    {
      paramContext = new ArrayList();
      a(paramString1, paramContext);
    }
    for (;;)
    {
      if ((paramString2 != null) && (!paramString2.equals("")))
      {
        paramString1 = new ArrayList();
        a(paramString2, paramString1);
        if ((paramContext != null) && (paramContext.size() != 0)) {
          break label151;
        }
        AVLog.c("CaptureVideoFilterManager", "compareContent newList.size=0");
        FileUtils.a(jdField_b_of_type_JavaLangString);
      }
      for (;;)
      {
        long l2 = System.currentTimeMillis();
        AVLog.c("CaptureVideoFilterManager", "compareContent :" + (l2 - l1));
        return;
        paramString1 = localIterator;
        if (!new File(jdField_b_of_type_JavaLangString).exists()) {
          break;
        }
        FileUtils.a(jdField_b_of_type_JavaLangString);
        paramString1 = localIterator;
        break;
        label151:
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
              if ((localFilterDesc.e != null) && (localFilterDesc.e.equals(paramString2.e)))
              {
                AVLog.c("CaptureVideoFilterManager", "compareContent res:" + localFilterDesc.e + "|" + localFilterDesc.jdField_b_of_type_JavaLangString + "|" + paramString2.jdField_b_of_type_JavaLangString);
                if ((localFilterDesc.jdField_b_of_type_JavaLangString != null) && (!localFilterDesc.jdField_b_of_type_JavaLangString.equals(paramString2.jdField_b_of_type_JavaLangString))) {
                  FileUtils.a(paramString2.b(jdField_b_of_type_JavaLangString));
                }
                AVLog.c("CaptureVideoFilterManager", "compareContent iconMD5:" + localFilterDesc.e + "|" + localFilterDesc.jdField_d_of_type_JavaLangString + "|" + paramString2.jdField_d_of_type_JavaLangString);
                if ((localFilterDesc.jdField_d_of_type_JavaLangString != null) && (!localFilterDesc.jdField_d_of_type_JavaLangString.equals(paramString2.jdField_d_of_type_JavaLangString))) {
                  FileUtils.d(paramString2.a(jdField_b_of_type_JavaLangString));
                }
              }
            }
          }
        }
      }
      paramContext = null;
    }
  }
  
  static void a(String paramString, List paramList)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramList == null))
    {
      AVLog.c("CaptureVideoFilterManager", "parseConfig|content is empty.");
      return;
    }
    paramList.clear();
    try
    {
      paramList.addAll(FilterDesc.a(new JSONObject(paramString).getJSONArray("filters")));
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private boolean a()
  {
    String str = FileUtils.c("filter_template.cfg");
    boolean bool = b(str);
    if (QLog.isColorLevel()) {
      QLog.i("CaptureVideoFilterManager", 2, "initFromAsset" + str + " result:" + bool);
    }
    return bool;
  }
  
  public static boolean a(int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    int i = DeviceInfoUtil.a();
    if (i < paramInt2)
    {
      AVLog.c("CaptureVideoFilterManager", "isSupportOfDevice error OSversion: " + i);
      return false;
    }
    paramInt2 = VcSystemInfo.e();
    if (paramInt2 < paramInt1)
    {
      AVLog.c("CaptureVideoFilterManager", "isSupportOfDevice error cpucount: " + paramInt2);
      return false;
    }
    long l = VcSystemInfo.c();
    if (l < paramLong1)
    {
      AVLog.c("CaptureVideoFilterManager", "isSupportOfDevice error cpuFrequency: " + l);
      return false;
    }
    paramLong1 = DeviceInfoUtil.e();
    if (paramLong1 < paramLong2)
    {
      AVLog.c("CaptureVideoFilterManager", "isSupportOfDevice error memory: " + paramLong1);
      return false;
    }
    return true;
  }
  
  public static boolean a(Context paramContext)
  {
    if (jdField_b_of_type_Boolean) {
      return true;
    }
    if (!a(4, 1350000L, 1073741824L, 17))
    {
      if (QLog.isColorLevel()) {
        QLog.d("CaptureVideoFilterManager", 2, "filter device note support");
      }
      return false;
    }
    jdField_b_of_type_Boolean = true;
    return jdField_b_of_type_Boolean;
  }
  
  public static String b(Context paramContext)
  {
    try
    {
      File localFile = new File(f + "beauty_config.json");
      AVLog.c("CaptureVideoFilterManager", "getVideoEffectBeautyConfig:" + f + "beauty_config.json" + "|" + localFile.exists());
      if (localFile.exists()) {
        return FileUtils.b(localFile);
      }
      b(paramContext, 0);
      return null;
    }
    catch (IOException paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public static void b(Context paramContext, int paramInt)
  {
    AVLog.c("CaptureVideoFilterManager", "setVideoEffectBeautyConfigVersion:" + paramInt);
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("qav_effect_beauty_config_version", paramInt);
    paramContext.commit();
  }
  
  private static boolean b(Context paramContext)
  {
    boolean bool = false;
    int i = PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("qq_video_filter_config_first_launch", 0);
    AVLog.c("CaptureVideoFilterManager", "getIsFirstLauncher:" + i);
    if (i == 0) {
      bool = true;
    }
    return bool;
  }
  
  private boolean b(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    for (;;)
    {
      int i;
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        Object localObject3;
        try
        {
          paramString = new JSONObject(paramString);
          localObject2 = FilterDesc.a(paramString.getJSONArray("filters")).iterator();
          if (((Iterator)localObject2).hasNext())
          {
            localObject3 = (FilterDesc)((Iterator)localObject2).next();
            this.jdField_a_of_type_JavaUtilHashMap.put(((FilterDesc)localObject3).e, localObject3);
            continue;
          }
          paramString = paramString.getJSONArray("categorys");
        }
        catch (JSONException paramString)
        {
          paramString.printStackTrace();
          return false;
        }
        Object localObject2 = new ArrayList(paramString.length());
        i = 0;
        if (i < paramString.length())
        {
          localObject3 = new FilterCategory(paramString.getJSONObject(i), null);
          if ((((FilterCategory)localObject3).jdField_a_of_type_JavaUtilList.size() <= 0) || ((((FilterCategory)localObject3).jdField_a_of_type_JavaUtilList.size() == 1) && (((FilterCategoryItem)((FilterCategory)localObject3).jdField_a_of_type_JavaUtilList.get(0)).a()))) {
            break label335;
          }
          ((ArrayList)localObject2).add(new FilterCategory(paramString.getJSONObject(i), null));
          break label335;
        }
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.addAll((Collection)localObject2);
        this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
        paramString = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
        if (paramString.hasNext())
        {
          localObject2 = ((FilterCategory)paramString.next()).jdField_a_of_type_JavaUtilList.iterator();
          if (!((Iterator)localObject2).hasNext()) {
            continue;
          }
          localObject3 = (FilterCategoryItem)((Iterator)localObject2).next();
          if (((FilterCategoryItem)localObject3).jdField_a_of_type_Boolean) {
            continue;
          }
          localObject3 = ((FilterCategoryItem)localObject3).a();
          this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(localObject3);
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureVideoFilterManager$CaptureVideoFilterRefreshListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureVideoFilterManager$CaptureVideoFilterRefreshListener.a();
      }
      return true;
      label335:
      i += 1;
    }
  }
  
  private static void c(Context paramContext)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("qq_video_filter_config_first_launch", 1);
    paramContext.commit();
  }
  
  private boolean c(Context paramContext)
  {
    paramContext = a(paramContext);
    boolean bool = b(paramContext);
    if (QLog.isColorLevel()) {
      QLog.i("CaptureVideoFilterManager", 2, "initFromCache" + paramContext + " result:" + bool);
    }
    return bool;
  }
  
  public int a()
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig != null) && (!this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.hasChoose))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QIMRedDotConfig_PTV", 2, "getDefaultCategoryId=" + this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.defaultCategoryId);
        }
        int i = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.defaultCategoryId;
        return i;
      }
      return -1;
    }
  }
  
  public FilterCategory a(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      FilterCategory localFilterCategory = (FilterCategory)localIterator.next();
      if (localFilterCategory.jdField_a_of_type_Int == paramInt) {
        return localFilterCategory;
      }
    }
    return null;
  }
  
  public FilterCategoryItem a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterCategoryItem;
  }
  
  public FilterDesc a(String paramString)
  {
    return (FilterDesc)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
  }
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureVideoFilterManager$CaptureVideoFilterRefreshListener = null;
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    for (;;)
    {
      StringBuilder localStringBuilder;
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig == null) {
          return;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.updateRedDotInfo(paramInt1, paramInt2, paramString))
        {
          if (QLog.isColorLevel())
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
            this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(null);
            this.jdField_a_of_type_AndroidOsHandler.post(new ahhn(this));
          }
        }
        else {
          return;
        }
      }
      if (paramInt1 == 3) {
        localStringBuilder.append(",id=").append(paramString);
      } else if (paramInt1 == 4) {
        localStringBuilder.append(",defaultId=").append(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.defaultUseId);
      } else if (paramInt1 == 5) {
        localStringBuilder.append(",defaultCategoryId=").append(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.defaultCategoryId);
      }
    }
  }
  
  public void a(Context paramContext, String paramString, int paramInt)
  {
    if (paramString == null)
    {
      AVLog.c("CaptureVideoFilterManager", "updateQQShortVideoFilterConfig error ");
      return;
    }
    int i = a(paramContext);
    String str = "";
    if (i != 0) {
      str = a(paramContext);
    }
    a(paramContext, paramString, str);
    FileUtils.a(jdField_a_of_type_JavaLangString, "filter_config.xml", paramString);
    a(paramContext, paramInt);
    c();
    a(paramString);
    AVLog.c("CaptureVideoFilterManager", "updateQQShortVideoFilterConfig sendBroadcast");
    paramContext.sendBroadcast(new Intent("action_brocassreceiver_for_filter"));
  }
  
  public void a(CaptureVideoFilterManager.CaptureVideoFilterRefreshListener paramCaptureVideoFilterRefreshListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureVideoFilterManager$CaptureVideoFilterRefreshListener = paramCaptureVideoFilterRefreshListener;
  }
  
  public void a(CaptureVideoFilterManager.OnResourceDownloadListener paramOnResourceDownloadListener)
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList == null) || (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() == 0)) {
      AVLog.c("CaptureVideoFilterManager", "preDownloadResource list is empty!");
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureVideoFilterManager$OnResourceDownloadListener = paramOnResourceDownloadListener;
      AVLog.c("CaptureVideoFilterManager", "preDownloadResource list size: " + this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
      paramOnResourceDownloadListener = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (paramOnResourceDownloadListener.hasNext())
      {
        Object localObject1 = (FilterCategory)paramOnResourceDownloadListener.next();
        if (((FilterCategory)localObject1).jdField_a_of_type_JavaUtilList != null)
        {
          localObject1 = ((FilterCategory)localObject1).jdField_a_of_type_JavaUtilList.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            FilterDesc localFilterDesc = ((FilterCategoryItem)((Iterator)localObject1).next()).a();
            if (localFilterDesc != null)
            {
              AVLog.c("CaptureVideoFilterManager", "preDownloadResource predownload: " + localFilterDesc.jdField_d_of_type_Int + ", iconurl: " + localFilterDesc.jdField_c_of_type_JavaLangString + ", resurl:" + localFilterDesc.jdField_a_of_type_JavaLangString);
              if (localFilterDesc.jdField_d_of_type_Int == 1)
              {
                Object localObject3;
                if (!TextUtils.isEmpty(localFilterDesc.jdField_c_of_type_JavaLangString))
                {
                  localObject2 = localFilterDesc.a(jdField_b_of_type_JavaLangString);
                  localObject3 = new File((String)localObject2);
                  AVLog.c("CaptureVideoFilterManager", "preDownloadResource icon " + (String)localObject2 + " exist: " + ((File)localObject3).exists());
                  if (!((File)localObject3).exists())
                  {
                    localObject3 = new HttpNetReq();
                    ((HttpNetReq)localObject3).jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = new ahhr(this);
                    ((HttpNetReq)localObject3).jdField_a_of_type_JavaLangString = localFilterDesc.jdField_c_of_type_JavaLangString;
                    ((HttpNetReq)localObject3).jdField_a_of_type_Int = 0;
                    ((HttpNetReq)localObject3).jdField_c_of_type_JavaLangString = ((String)localObject2);
                    ((HttpNetReq)localObject3).a(localFilterDesc);
                    AVNetEngine.a().a((NetReq)localObject3);
                    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
                  }
                }
                Object localObject2 = localFilterDesc.b(jdField_b_of_type_JavaLangString);
                if ((!TextUtils.isEmpty(localFilterDesc.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty((CharSequence)localObject2)))
                {
                  localObject3 = new File((String)localObject2 + "params.json");
                  AVLog.c("CaptureVideoFilterManager", "preDownloadResource file " + (String)localObject2 + "params.json" + " exist: " + ((File)localObject3).exists());
                  if (!((File)localObject3).exists())
                  {
                    localObject2 = new HttpNetReq();
                    ((HttpNetReq)localObject2).jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = new ahhp(this);
                    ((HttpNetReq)localObject2).jdField_a_of_type_JavaLangString = localFilterDesc.jdField_a_of_type_JavaLangString;
                    ((HttpNetReq)localObject2).jdField_a_of_type_Int = 0;
                    ((HttpNetReq)localObject2).jdField_c_of_type_JavaLangString = (jdField_b_of_type_JavaLangString + localFilterDesc.e + ".zip");
                    ((HttpNetReq)localObject2).a(localFilterDesc);
                    AVNetEngine.a().a((NetReq)localObject2);
                    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
                  }
                }
              }
            }
          }
        }
      }
    } while ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 0) || (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureVideoFilterManager$OnResourceDownloadListener == null));
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureVideoFilterManager$OnResourceDownloadListener.a(false);
  }
  
  public void a(FilterCategoryItem paramFilterCategoryItem)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterCategoryItem = paramFilterCategoryItem;
    if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterCategoryItem != null) && (!this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterCategoryItem.a())) {
      a(3, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterCategoryItem.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterCategoryItem.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig != null) && (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.update))
      {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.update = false;
        CaptureRedDotConfig.saveRedDotConfig(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig, jdField_a_of_type_JavaLangString, "_Filter");
      }
      return;
    }
    CaptureRedDotConfig.saveRedDotConfig(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig, jdField_a_of_type_JavaLangString, "_Filter");
  }
  
  public boolean a(int paramInt1, int paramInt2, String paramString)
  {
    for (;;)
    {
      StringBuilder localStringBuilder;
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("QIMRedDotConfig_Filter", 2, "needShowRedDot|mCaptureRedDotConfig is null");
          }
          return false;
        }
        boolean bool = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.needShowRedDot(paramInt1, paramInt2, paramString);
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
        localStringBuilder.append(",defaultId=").append(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.defaultUseId);
      } else if (paramInt1 == 5) {
        localStringBuilder.append(",defaultCategoryId=").append(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.defaultCategoryId);
      }
    }
  }
  
  public boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    for (;;)
    {
      int i;
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig = new CaptureRedDotConfig(1);
          if (QLog.isColorLevel()) {
            QLog.d("QIMRedDotConfig_Filter", 2, "updateFromServer config is null");
          }
        }
        try
        {
          Object localObject2 = new JSONObject(paramString);
          paramString = ((JSONObject)localObject2).getJSONArray("categorys");
          i = ((JSONObject)localObject2).optInt("iconRedDotVersion");
          boolean bool = ((JSONObject)localObject2).optBoolean("needRedDot");
          if (QLog.isColorLevel()) {
            QLog.d("QIMRedDotConfig_Filter", 2, "updateFromServer oldVer=" + this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.iconVersion + ",ver=" + i + ",showRed " + bool);
          }
          int j = ((JSONObject)localObject2).optInt("redDotShowTime", CaptureRedDotConfig.SHOW_TIME_DEFAULT);
          this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.showTime = j;
          if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.iconVersion != i)
          {
            this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.iconVersion = i;
            this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.showRedDot = bool;
            this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.hasShow = false;
            this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.firstShowTime = 0L;
          }
          i = ((JSONObject)localObject2).optInt("defaultCategoryVersion");
          j = ((JSONObject)localObject2).optInt("defaultCategoryId", -1);
          if (QLog.isColorLevel()) {
            QLog.d("QIMRedDotConfig_Filter", 2, "updateFromServer oldVer=" + this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.defaultCategoryVer + ",ver=" + i + ",defaultCategoryId " + j);
          }
          if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.defaultCategoryVer != i)
          {
            this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.defaultCategoryVer = i;
            this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.defaultCategoryId = j;
            this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.hasChoose = false;
          }
          i = ((JSONObject)localObject2).optInt("defaultUseVersion");
          Object localObject3 = ((JSONObject)localObject2).optString("defaultUseId");
          if (QLog.isColorLevel()) {
            QLog.d("QIMRedDotConfig_Filter", 2, "updateFromServer oldVer=" + this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.defaultUseVer + ",ver=" + i + ",defaultUseId " + (String)localObject3);
          }
          if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.defaultUseVer != i)
          {
            this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.defaultUseVer = i;
            this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.defaultUseId = ((String)localObject3);
            this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.hasUse = false;
          }
          i = ((JSONObject)localObject2).optInt("itemRedDotVersion");
          if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.redDotVersion != i)
          {
            this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.redDotVersion = i;
            this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.redDotItems.clear();
            if (((JSONObject)localObject2).has("itemNeedRedDot"))
            {
              localObject2 = ((JSONObject)localObject2).getJSONArray("itemNeedRedDot");
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("updateFromServer redDotList: ");
              i = 0;
              if (i < ((JSONArray)localObject2).length())
              {
                String str = ((JSONArray)localObject2).optString(i);
                if (TextUtils.isEmpty(str)) {
                  break label708;
                }
                CaptureRedDotConfig.RedDotItemConfig localRedDotItemConfig = new CaptureRedDotConfig.RedDotItemConfig();
                localRedDotItemConfig.filterId = str;
                ((StringBuilder)localObject3).append(str).append(",");
                this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.redDotItems.put(str, localRedDotItemConfig);
                break label708;
              }
              if (QLog.isColorLevel()) {
                QLog.d("QIMRedDotConfig_Filter", 2, ((StringBuilder)localObject3).toString());
              }
            }
          }
          localObject2 = new ArrayList(paramString.length());
          i = 0;
          if (i < paramString.length())
          {
            ((ArrayList)localObject2).add(new FilterCategory(paramString.getJSONObject(i), this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig));
            i += 1;
            continue;
          }
          this.jdField_a_of_type_Boolean = true;
          a(false);
          return true;
        }
        catch (JSONException paramString)
        {
          if (QLog.isColorLevel()) {
            QLog.e("QIMRedDotConfig", 2, QLog.getStackTraceString(paramString));
          }
          return false;
        }
      }
      label708:
      i += 1;
    }
  }
  
  public List b()
  {
    return this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      com.tencent.av.video.effect.QavVideoEffect.DEBUG_MODE = true;
    }
    c();
    if (!c(BaseApplicationImpl.sApplication)) {
      a();
    }
    AVLog.c("CaptureVideoFilterManager", "init mFilterCategoryRaw size:" + this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
  }
  
  public void b(Context paramContext)
  {
    if (new File(f + "beauty_config.json").exists())
    {
      if (!new File(g + "params.json").exists())
      {
        AVLog.c("CaptureVideoFilterManager", "!JasonFile.exists()");
        a(paramContext);
      }
      return;
    }
    AVLog.c("CaptureVideoFilterManager", "BEAUTY_CONFIG  is not exsit");
  }
  
  public void c()
  {
    CaptureRedDotConfig localCaptureRedDotConfig = CaptureRedDotConfig.getRedDotConfigFromFile(jdField_a_of_type_JavaLangString, "_Filter");
    if (localCaptureRedDotConfig != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QIMRedDotConfig_Filter", 2, "CaptureVideoFilterManger init UpdateByServer= " + this.jdField_a_of_type_Boolean);
      }
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        if (!this.jdField_a_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig = localCaptureRedDotConfig;
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.data.CaptureVideoFilterManager
 * JD-Core Version:    0.7.0.1
 */