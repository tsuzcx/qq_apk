package com.tencent.mobileqq.mini.manager;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.mobileqq.mini.util.StorageUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo;

public class MiniLoadingAdManager$CachedAdInfo
{
  private long aid;
  private long creativeId;
  public String filePath;
  private Downloader.DownloadListener listener = new MiniLoadingAdManager.CachedAdInfo.1(this);
  private String saveKey;
  public String url;
  
  public MiniLoadingAdManager$CachedAdInfo(GdtAd paramGdtAd, String paramString1, String paramString2)
  {
    if ((paramGdtAd != null) && (paramGdtAd.info != null) && (paramGdtAd.info.display_info != null))
    {
      if ((paramGdtAd.info.display_info.basic_info != null) && (paramGdtAd.info.display_info.basic_info.img != null) && (!TextUtils.isEmpty(paramGdtAd.info.display_info.basic_info.img.get()))) {
        this.url = paramGdtAd.info.display_info.basic_info.img.get();
      }
      if ((paramGdtAd.info.report_info != null) && (paramGdtAd.info.report_info.trace_info != null))
      {
        this.aid = paramGdtAd.info.report_info.trace_info.aid.get();
        this.creativeId = paramGdtAd.info.report_info.trace_info.creative_id.get();
      }
      if (!TextUtils.isEmpty(this.url)) {
        this.filePath = MiniAppFileManager.getLoadingAdCacheFilePath(this.url, paramString1);
      }
    }
    this.saveKey = ("mini_loading_ad_preload_adjson_key_" + paramString1 + "_" + paramString2);
  }
  
  private void updatePreloadAdCache()
  {
    QLog.d("MiniLoadingAdManager", 1, "updatePreloadAdCache 更新缓存广告列表");
    Object localObject1 = StorageUtil.getPreference().getString(this.saveKey, new JSONObject().toString());
    try
    {
      JSONObject localJSONObject = new JSONObject((String)localObject1);
      Object localObject2 = localJSONObject.optJSONArray("adArray");
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new JSONArray();
      }
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("aid", this.aid);
      ((JSONObject)localObject2).put("creativeId", this.creativeId);
      ((JSONObject)localObject2).put("url", this.url);
      ((JSONObject)localObject2).put("filePath", this.filePath);
      ((JSONArray)localObject1).put(localObject2);
      localJSONObject.put("adArray", localObject1);
      StorageUtil.getPreference().edit().putString(this.saveKey, localJSONObject.toString()).apply();
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  public boolean isValid()
  {
    File localFile = new File(this.filePath);
    if (localFile.exists()) {
      updatePreloadAdCache();
    }
    return (!TextUtils.isEmpty(this.url)) && (!TextUtils.isEmpty(this.filePath)) && (this.aid != 0L) && (this.creativeId != 0L) && (!localFile.exists());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.manager.MiniLoadingAdManager.CachedAdInfo
 * JD-Core Version:    0.7.0.1
 */