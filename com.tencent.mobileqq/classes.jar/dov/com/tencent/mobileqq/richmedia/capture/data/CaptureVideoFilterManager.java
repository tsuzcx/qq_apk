package dov.com.tencent.mobileqq.richmedia.capture.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import aoln;
import aolo;
import aolp;
import aolq;
import com.tencent.av.AVLog;
import com.tencent.av.AVNetEngine;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
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
  private static int c;
  public static final String c;
  public static String d;
  public static String e;
  private static final String f;
  private static final String g;
  private Handler jdField_a_of_type_AndroidOsHandler;
  public CaptureRedDotConfig a;
  private CaptureVideoFilterManager.CaptureVideoFilterRefreshListener jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureDataCaptureVideoFilterManager$CaptureVideoFilterRefreshListener;
  private CaptureVideoFilterManager.OnResourceDownloadListener jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureDataCaptureVideoFilterManager$OnResourceDownloadListener;
  public FilterCategoryItem a;
  HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private final CopyOnWriteArrayList jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  public boolean a;
  private final CopyOnWriteArrayList jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  
  static
  {
    jdField_a_of_type_JavaLangString = AppConstants.aJ + "dov_capture_qsvf" + File.separator;
    jdField_b_of_type_JavaLangString = jdField_a_of_type_JavaLangString + "capture_res" + File.separator;
    f = AppConstants.aJ + "qav" + File.separator + "beauty" + File.separator;
    g = f + "SKINCOLOR" + File.separator;
    jdField_c_of_type_JavaLangString = f;
    jdField_a_of_type_JavaLangObject = new Object();
    d = jdField_a_of_type_JavaLangString + "lowlight";
    e = d + File.separator + "LowLight.png";
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
  
  public static final CaptureVideoFilterManager a()
  {
    return aolo.a();
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
  
  public static void a(Context paramContext, int paramInt)
  {
    AVLog.c("CaptureVideoFilterManager", "setQQShortVideoFilterConfigVersion:" + paramInt);
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("capture_qq_video_filter_config_version", paramInt);
    paramContext.commit();
  }
  
  private boolean a()
  {
    String str = FileUtils.c("filter_template.cfg");
    boolean bool = a(str);
    if (QLog.isColorLevel()) {
      QLog.i("CaptureVideoFilterManager", 2, "initFromAsset" + str + " result:" + bool);
    }
    return bool;
  }
  
  private boolean a(Context paramContext)
  {
    paramContext = a(paramContext);
    boolean bool = a(paramContext);
    if (QLog.isColorLevel()) {
      QLog.i("CaptureVideoFilterManager", 2, "initFromCache" + paramContext + " result:" + bool);
    }
    return bool;
  }
  
  private boolean a(String paramString)
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
          if ((((FilterCategory)localObject3).a.size() <= 0) || ((((FilterCategory)localObject3).a.size() == 1) && (((FilterCategoryItem)((FilterCategory)localObject3).a.get(0)).a()))) {
            break label334;
          }
          ((ArrayList)localObject2).add(new FilterCategory(paramString.getJSONObject(i), null));
          break label334;
        }
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.addAll((Collection)localObject2);
        this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
        paramString = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
        if (paramString.hasNext())
        {
          localObject2 = ((FilterCategory)paramString.next()).a.iterator();
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
      if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureDataCaptureVideoFilterManager$CaptureVideoFilterRefreshListener != null) {
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureDataCaptureVideoFilterManager$CaptureVideoFilterRefreshListener.a();
      }
      return true;
      label334:
      i += 1;
    }
  }
  
  public FilterDesc a(String paramString)
  {
    return (FilterDesc)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
  }
  
  public FilterCategoryItem a()
  {
    return this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureDataFilterCategoryItem;
  }
  
  public List a()
  {
    return this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureDataCaptureVideoFilterManager$CaptureVideoFilterRefreshListener = null;
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    for (;;)
    {
      StringBuilder localStringBuilder;
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig == null) {
          return;
        }
        if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.updateRedDotInfo(paramInt1, paramInt2, paramString))
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
            this.jdField_a_of_type_AndroidOsHandler.post(new aoln(this));
          }
        }
        else {
          return;
        }
      }
      if (paramInt1 == 3) {
        localStringBuilder.append(",id=").append(paramString);
      } else if (paramInt1 == 4) {
        localStringBuilder.append(",defaultId=").append(this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.defaultUseId);
      } else if (paramInt1 == 5) {
        localStringBuilder.append(",defaultCategoryId=").append(this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.defaultCategoryId);
      }
    }
  }
  
  public void a(CaptureVideoFilterManager.CaptureVideoFilterRefreshListener paramCaptureVideoFilterRefreshListener)
  {
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureDataCaptureVideoFilterManager$CaptureVideoFilterRefreshListener = paramCaptureVideoFilterRefreshListener;
  }
  
  public void a(CaptureVideoFilterManager.OnResourceDownloadListener paramOnResourceDownloadListener)
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList == null) || (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() == 0)) {
      AVLog.c("CaptureVideoFilterManager", "preDownloadResource list is empty!");
    }
    do
    {
      return;
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureDataCaptureVideoFilterManager$OnResourceDownloadListener = paramOnResourceDownloadListener;
      AVLog.c("CaptureVideoFilterManager", "preDownloadResource list size: " + this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
      paramOnResourceDownloadListener = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (paramOnResourceDownloadListener.hasNext())
      {
        Object localObject1 = (FilterCategory)paramOnResourceDownloadListener.next();
        if (((FilterCategory)localObject1).a != null)
        {
          localObject1 = ((FilterCategory)localObject1).a.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            FilterDesc localFilterDesc = ((FilterCategoryItem)((Iterator)localObject1).next()).a();
            if (localFilterDesc != null)
            {
              AVLog.c("CaptureVideoFilterManager", "preDownloadResource predownload: " + localFilterDesc.d + ", iconurl: " + localFilterDesc.jdField_c_of_type_JavaLangString + ", resurl:" + localFilterDesc.jdField_a_of_type_JavaLangString);
              if (localFilterDesc.d == 1)
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
                    ((HttpNetReq)localObject3).jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = new aolq(this);
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
                    ((HttpNetReq)localObject2).jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = new aolp(this);
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
    } while ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 0) || (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureDataCaptureVideoFilterManager$OnResourceDownloadListener == null));
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureDataCaptureVideoFilterManager$OnResourceDownloadListener.a(false);
  }
  
  public void a(FilterCategoryItem paramFilterCategoryItem)
  {
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureDataFilterCategoryItem = paramFilterCategoryItem;
    if ((this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureDataFilterCategoryItem != null) && (!this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureDataFilterCategoryItem.a())) {
      a(3, this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureDataFilterCategoryItem.jdField_b_of_type_Int, this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureDataFilterCategoryItem.jdField_a_of_type_JavaLangString);
    }
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureDataFilterCategoryItem != null)
    {
      paramFilterCategoryItem = this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureDataFilterCategoryItem.a();
      if (paramFilterCategoryItem != null)
      {
        QQFilterRenderManager localQQFilterRenderManager = EffectsCameraCaptureView.a();
        if (localQQFilterRenderManager != null) {
          localQQFilterRenderManager.a(paramFilterCategoryItem);
        }
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if ((this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig != null) && (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.update))
      {
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.update = false;
        CaptureRedDotConfig.saveRedDotConfig(this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig, jdField_a_of_type_JavaLangString, "_Filter");
      }
      return;
    }
    CaptureRedDotConfig.saveRedDotConfig(this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig, jdField_a_of_type_JavaLangString, "_Filter");
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      com.tencent.av.video.effect.QavVideoEffect.DEBUG_MODE = true;
    }
    c();
    if (!a(BaseApplicationImpl.sApplication)) {
      a();
    }
    AVLog.c("CaptureVideoFilterManager", "init mFilterCategoryRaw size:" + this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
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
          this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig = localCaptureRedDotConfig;
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.capture.data.CaptureVideoFilterManager
 * JD-Core Version:    0.7.0.1
 */