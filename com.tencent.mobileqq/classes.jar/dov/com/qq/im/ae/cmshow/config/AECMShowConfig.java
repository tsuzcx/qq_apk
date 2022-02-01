package dov.com.qq.im.ae.cmshow.config;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import dov.com.qq.im.aeeditor.data.AEEditorDownloadResBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class AECMShowConfig
  implements Serializable
{
  public static final HashMap<String, AEEditorDownloadResBean> DEFAULT_RES_INFO_MAP;
  public static final ArrayList<String> ESSENTIAL_RESOURCE_ID_LIST = new ArrayList();
  public static final String RES_ID_CM_JOY_BASE = "video_limishow_base";
  public static final String RES_ID_CM_JOY_PLACEHOLDER = "video_3DFaceFila_kapu_placeholder";
  public List<AECMShowConfig.CmShowResBean> preDownloadResources = new LinkedList();
  @SerializedName("ptaRequestConfig")
  public AECMShowConfig.RequestConfig requestConfig = new AECMShowConfig.RequestConfig();
  
  static
  {
    DEFAULT_RES_INFO_MAP = new HashMap();
    ESSENTIAL_RESOURCE_ID_LIST.add("video_limishow_base");
    ESSENTIAL_RESOURCE_ID_LIST.add("video_3DFaceFila_kapu_placeholder");
    AEEditorDownloadResBean localAEEditorDownloadResBean = new AEEditorDownloadResBean();
    localAEEditorDownloadResBean.setId("video_limishow_base");
    localAEEditorDownloadResBean.setUrl("https://downv6.qq.com/shadow_qqcamera/AECMJoy/Android/video_limishow_base_2021010501.zip");
    localAEEditorDownloadResBean.setMd5("321c99223d7d1d4c1c62b932f6ffb187");
    localAEEditorDownloadResBean.setPreDownload(0);
    DEFAULT_RES_INFO_MAP.put("video_limishow_base", localAEEditorDownloadResBean);
    localAEEditorDownloadResBean = new AEEditorDownloadResBean();
    localAEEditorDownloadResBean.setId("video_3DFaceFila_kapu_placeholder");
    localAEEditorDownloadResBean.setUrl("https://downv6.qq.com/shadow_qqcamera/AECMJoy/Android/video_3DFaceFila_kapu_placeholder_2021010201.zip");
    localAEEditorDownloadResBean.setMd5("5b402ac04dd4b2a649533ec35a9c1054");
    localAEEditorDownloadResBean.setPreDownload(0);
    DEFAULT_RES_INFO_MAP.put("video_3DFaceFila_kapu_placeholder", localAEEditorDownloadResBean);
  }
  
  @Nullable
  public static HashMap<String, AEEditorDownloadResBean> convert2DownloadBeanMap(@Nullable AECMShowConfig paramAECMShowConfig)
  {
    if ((paramAECMShowConfig == null) || (CollectionUtils.isEmpty(paramAECMShowConfig.preDownloadResources))) {
      return null;
    }
    HashMap localHashMap = new HashMap();
    paramAECMShowConfig = paramAECMShowConfig.preDownloadResources.iterator();
    while (paramAECMShowConfig.hasNext())
    {
      AECMShowConfig.CmShowResBean localCmShowResBean = (AECMShowConfig.CmShowResBean)paramAECMShowConfig.next();
      if ((localCmShowResBean != null) && (!TextUtils.isEmpty(localCmShowResBean.id)))
      {
        AEEditorDownloadResBean localAEEditorDownloadResBean = new AEEditorDownloadResBean();
        localAEEditorDownloadResBean.setId(localCmShowResBean.id);
        localAEEditorDownloadResBean.setUrl(localCmShowResBean.androidUrl);
        localAEEditorDownloadResBean.setMd5(localCmShowResBean.androidMd5);
        localAEEditorDownloadResBean.setPreDownload(0);
        localHashMap.put(localCmShowResBean.id, localAEEditorDownloadResBean);
      }
    }
    if (localHashMap.size() < 2) {
      return null;
    }
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.cmshow.config.AECMShowConfig
 * JD-Core Version:    0.7.0.1
 */