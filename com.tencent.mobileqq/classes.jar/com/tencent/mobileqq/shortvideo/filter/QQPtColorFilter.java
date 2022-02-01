package com.tencent.mobileqq.shortvideo.filter;

import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.av.video.effect.utils.CommonUtils;
import com.tencent.filter.ttpic.GPUImageLookupFilter;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.shortvideo.resource.AVFilterResource;
import com.tencent.mobileqq.shortvideo.resource.Resources;
import com.tencent.sveffects.SLog;
import com.tencent.sveffects.SdkContext;
import com.tencent.ttpic.baseutils.device.DeviceInstance;
import com.tencent.view.RendererUtils;
import java.io.File;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONObject;

public class QQPtColorFilter
  extends QQBaseFilter
{
  public static final String TAG = "QQPtColorFilter";
  private static HashSet blackList = new HashSet();
  private boolean bwork = false;
  private String currentFilterPath;
  private VideoFilterBase effectFilter;
  private boolean hasinit = false;
  private GPUImageLookupFilter internalFilter = new GPUImageLookupFilter();
  private boolean isLoadSoSuccess = false;
  private int lastHeight = 0;
  private int lastWidth = 0;
  private Frame mCacheFrame = new Frame();
  private int[] mPtColorTextureId = new int[1];
  private boolean needChange = false;
  private String newFilterPath = null;
  
  static
  {
    blackList.add("HUAWEI_ALP-AL00");
  }
  
  public QQPtColorFilter(QQFilterRenderManager paramQQFilterRenderManager)
  {
    super(999, paramQQFilterRenderManager);
    GPUImageLookupFilter.jarPath = null;
  }
  
  public static QQPtColorFilterInfo getColorFilterInfo(String paramString)
  {
    try
    {
      localObject = SdkContext.getInstance().getApplication();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(File.separator);
      localStringBuilder.append("params.json");
      paramString = CommonUtils.getInputStreamFromPath((Context)localObject, localStringBuilder.toString());
      if (paramString != null)
      {
        paramString = CommonUtils.convertStreamToString(paramString);
        if (paramString != null) {
          localObject = new JSONObject(paramString);
        }
      }
    }
    catch (Exception paramString)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getColorFilterInfo:");
      ((StringBuilder)localObject).append(paramString);
      SLog.e("QQPtColorFilterInfo", ((StringBuilder)localObject).toString());
      localObject = null;
    }
    if (localObject == null)
    {
      if (SLog.isEnable()) {
        SLog.e("QQPtColorFilterInfo", "filterConfig == null!");
      }
      return null;
    }
    try
    {
      boolean bool = ((JSONObject)localObject).has("filterId");
      j = -1;
      if (!bool) {
        break label279;
      }
      i = Integer.valueOf(((JSONObject)localObject).getString("filterId")).intValue();
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        int j;
        continue;
        int i = -1;
        continue;
        paramString = null;
        continue;
        localObject = null;
      }
    }
    if (((JSONObject)localObject).has("name"))
    {
      paramString = ((JSONObject)localObject).getString("name");
      if (((JSONObject)localObject).has("subId")) {
        j = Integer.valueOf(((JSONObject)localObject).getString("subId")).intValue();
      }
      if (!((JSONObject)localObject).has("resourceList")) {
        break label289;
      }
      localObject = ((JSONObject)localObject).getJSONArray("resourceList");
      if ((localObject == null) || (((JSONArray)localObject).length() <= 0)) {
        break label289;
      }
      localObject = ((JSONArray)localObject).get(0).toString();
      paramString = new QQPtColorFilterInfo(i, paramString, j, (String)localObject);
      return paramString;
      return null;
    }
  }
  
  private void init(int paramInt1, int paramInt2)
  {
    release();
    this.internalFilter.applyFilterChain(true, paramInt1, paramInt2);
    int[] arrayOfInt = this.mPtColorTextureId;
    GLES20.glGenTextures(arrayOfInt.length, arrayOfInt, 0);
    this.hasinit = true;
  }
  
  private void release()
  {
    if (!this.isLoadSoSuccess) {
      return;
    }
    Object localObject = this.internalFilter;
    if (localObject != null) {
      ((GPUImageLookupFilter)localObject).clearGLSL();
    }
    this.mCacheFrame.clear();
    localObject = this.mPtColorTextureId;
    GLES20.glDeleteTextures(localObject.length, (int[])localObject, 0);
    if (SLog.isEnable()) {
      SLog.d("QQPtColorFilter", "reslease internalFilter");
    }
    this.hasinit = false;
  }
  
  private void setNeedChangeFilter(String paramString, boolean paramBoolean)
  {
    try
    {
      this.newFilterPath = paramString;
      this.needChange = paramBoolean;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public boolean isFilterWork()
  {
    return this.bwork;
  }
  
  public void onDrawFrame()
  {
    if ((TextUtils.isEmpty(this.newFilterPath)) && (TextUtils.isEmpty(this.currentFilterPath)) && (this.effectFilter == null))
    {
      this.mOutputTextureID = this.mInputTextureID;
      return;
    }
    this.lastWidth = getQQFilterRenderManager().getFilterWidth();
    this.lastHeight = getQQFilterRenderManager().getFilterHeight();
    if (!this.isLoadSoSuccess) {
      this.isLoadSoSuccess = getQQFilterRenderManager().loadFilterSoSuccess();
    }
    if (!this.isLoadSoSuccess)
    {
      this.mOutputTextureID = this.mInputTextureID;
      return;
    }
    if (!this.hasinit)
    {
      init(this.lastWidth, this.lastHeight);
      this.mOutputTextureID = this.mInputTextureID;
      return;
    }
    Object localObject = this.effectFilter;
    if ((localObject != null) && (((VideoFilterBase)localObject).isValid()))
    {
      this.mOutputTextureID = this.effectFilter.RenderProcess(this.mInputTextureID, this.lastWidth, this.lastHeight).getTextureId();
      return;
    }
    localObject = this.newFilterPath;
    if (this.needChange)
    {
      setNeedChangeFilter(null, false);
      this.currentFilterPath = ((String)localObject);
      this.internalFilter.updateLut(this.currentFilterPath);
    }
    if (TextUtils.isEmpty(this.currentFilterPath))
    {
      this.mOutputTextureID = this.mInputTextureID;
      return;
    }
    this.internalFilter.RenderProcess(this.mInputTextureID, this.lastWidth, this.lastHeight, this.mPtColorTextureId[0], 0.0D, this.mCacheFrame);
    if (blackList.contains(DeviceInstance.getInstance().getDeviceName()))
    {
      localObject = RendererUtils.saveTexture(this.mCacheFrame);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Save bitmap to avoid black lines ");
      localStringBuilder.append(((Bitmap)localObject).getWidth());
      Log.e("QQPtColorFilter", localStringBuilder.toString());
      ((Bitmap)localObject).recycle();
    }
    this.mOutputTextureID = this.mPtColorTextureId[0];
  }
  
  public void onSurfaceChange(int paramInt1, int paramInt2)
  {
    if (!this.isLoadSoSuccess) {
      return;
    }
    int i = this.lastHeight;
    if ((i != paramInt1) || (i != paramInt2)) {
      init(paramInt1, paramInt2);
    }
  }
  
  public void onSurfaceDestroy()
  {
    if (this.hasinit)
    {
      release();
      VideoFilterBase localVideoFilterBase = this.effectFilter;
      if (localVideoFilterBase != null) {
        localVideoFilterBase.clearGLSLSelf();
      }
    }
  }
  
  public void setEffectFilter(VideoFilterBase paramVideoFilterBase)
  {
    VideoFilterBase localVideoFilterBase = this.effectFilter;
    if (localVideoFilterBase != null)
    {
      localVideoFilterBase.clearGLSLSelf();
      this.effectFilter = null;
    }
    this.effectFilter = paramVideoFilterBase;
  }
  
  public void setLutResPath(FilterDesc paramFilterDesc)
  {
    if (paramFilterDesc == null)
    {
      setNeedChangeFilter(null, true);
      this.bwork = false;
      return;
    }
    String str = SdkContext.getInstance().getResources().getAvFilterResource().getFilterResPath();
    if (paramFilterDesc != null)
    {
      if (!TextUtils.isEmpty(paramFilterDesc.resRootPath)) {
        str = paramFilterDesc.getResFold(paramFilterDesc.resRootPath);
      } else {
        str = paramFilterDesc.getResFold(str);
      }
    }
    else {
      str = "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append(paramFilterDesc.respicname);
    paramFilterDesc = localStringBuilder.toString();
    if (new File(paramFilterDesc).exists())
    {
      setNeedChangeFilter(paramFilterDesc, true);
      this.bwork = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.filter.QQPtColorFilter
 * JD-Core Version:    0.7.0.1
 */