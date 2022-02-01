package com.tencent.thumbplayer.adapter;

import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import com.tencent.thumbplayer.adapter.player.TPUrlDataSource;
import com.tencent.thumbplayer.api.composition.ITPMediaAsset;
import java.util.HashMap;
import java.util.Map;

public class TPPlayerDataSource
{
  public static final int TYPE_CLIP_INFO = 2;
  public static final int TYPE_DATA_SOURCE = 3;
  public static final int TYPE_FD = 1;
  public static final int TYPE_URL = 0;
  private ParcelFileDescriptor mFileDescriptor;
  private Map<String, String> mHttpHeaders;
  private ITPMediaAsset mTPMediaAsset;
  private int mType;
  private String mUrl;
  private TPUrlDataSource tpUrlDataSource;
  
  protected TPPlayerDataSource()
  {
    this.mHttpHeaders = new HashMap();
  }
  
  protected TPPlayerDataSource(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    this.mUrl = null;
    this.mType = 1;
    this.mFileDescriptor = paramParcelFileDescriptor;
    this.mHttpHeaders = new HashMap(0);
  }
  
  protected TPPlayerDataSource(ITPMediaAsset paramITPMediaAsset)
  {
    this.mUrl = null;
    this.mType = 2;
    this.mFileDescriptor = null;
    this.mHttpHeaders = new HashMap(0);
    this.mTPMediaAsset = paramITPMediaAsset;
  }
  
  protected TPPlayerDataSource(String paramString)
  {
    this.mUrl = paramString;
    this.mType = 0;
    this.mFileDescriptor = null;
    this.mHttpHeaders = new HashMap(0);
  }
  
  protected TPPlayerDataSource(String paramString, Map<String, String> paramMap)
  {
    this.mUrl = paramString;
    this.mType = 0;
    this.mFileDescriptor = null;
    this.mHttpHeaders = new HashMap();
    this.mHttpHeaders.putAll(paramMap);
  }
  
  public ParcelFileDescriptor fileDescriptor()
  {
    return this.mFileDescriptor;
  }
  
  public TPUrlDataSource getTpUrlDataSource()
  {
    return this.tpUrlDataSource;
  }
  
  public int getType()
  {
    return this.mType;
  }
  
  public Map<String, String> httpHeaders()
  {
    return this.mHttpHeaders;
  }
  
  protected boolean isValid()
  {
    return (!TextUtils.isEmpty(this.mUrl)) || (this.mFileDescriptor != null) || (this.mTPMediaAsset != null) || (this.tpUrlDataSource != null);
  }
  
  public ITPMediaAsset mediaAsset()
  {
    return this.mTPMediaAsset;
  }
  
  protected void setFileDescriptor(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    this.mUrl = null;
    this.mType = 1;
    this.mHttpHeaders.clear();
    this.mFileDescriptor = paramParcelFileDescriptor;
  }
  
  protected void setHttpHeaders(Map<String, String> paramMap)
  {
    this.mHttpHeaders.clear();
    Map localMap = this.mHttpHeaders;
    Object localObject = paramMap;
    if (paramMap == null) {
      localObject = new HashMap(0);
    }
    localMap.putAll((Map)localObject);
  }
  
  protected void setMediaClipInfo(ITPMediaAsset paramITPMediaAsset)
  {
    this.mUrl = null;
    this.mType = 2;
    this.mHttpHeaders.clear();
    this.mFileDescriptor = null;
    this.mTPMediaAsset = paramITPMediaAsset;
  }
  
  public void setTpUrlDataSource(TPUrlDataSource paramTPUrlDataSource)
  {
    this.mUrl = null;
    this.mType = 3;
    this.mFileDescriptor = null;
    this.tpUrlDataSource = paramTPUrlDataSource;
  }
  
  protected void setUrl(String paramString)
  {
    this.mUrl = paramString;
    this.mType = 0;
    this.mFileDescriptor = null;
  }
  
  public String url()
  {
    return this.mUrl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.TPPlayerDataSource
 * JD-Core Version:    0.7.0.1
 */