package com.tencent.thumbplayer.composition;

import com.tencent.thumbplayer.api.TPCommonEnum.TP_DRM_TYPE;
import com.tencent.thumbplayer.api.composition.ITPMediaDRMAsset;
import com.tencent.thumbplayer.utils.TPLogUtil;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TPMediaDRMAsset
  implements ITPMediaDRMAsset
{
  private static final String TAG = "TPMediaDRMAsset";
  private Map<String, String> mDrmPropertyMap;
  @TPCommonEnum.TP_DRM_TYPE
  private int mDrmType;
  private String mPlayUrl;
  
  public TPMediaDRMAsset(@TPCommonEnum.TP_DRM_TYPE int paramInt, String paramString)
  {
    this.mPlayUrl = paramString;
    this.mDrmType = paramInt;
    this.mDrmPropertyMap = new HashMap();
  }
  
  public Map<String, String> getDrmAllProperties()
  {
    return this.mDrmPropertyMap;
  }
  
  public String getDrmPlayUrl()
  {
    return this.mPlayUrl;
  }
  
  public String getDrmProperty(String paramString1, String paramString2)
  {
    Object localObject = this.mDrmPropertyMap;
    if (localObject != null)
    {
      if (((Map)localObject).isEmpty()) {
        return paramString2;
      }
      localObject = (String)this.mDrmPropertyMap.get(paramString1);
      paramString1 = (String)localObject;
      if (localObject == null) {
        paramString1 = paramString2;
      }
      return paramString1;
    }
    return paramString2;
  }
  
  @TPCommonEnum.TP_DRM_TYPE
  public int getDrmType()
  {
    return this.mDrmType;
  }
  
  public int getMediaType()
  {
    return 0;
  }
  
  public String getUrl()
  {
    try
    {
      String str = TPMediaCompositionXmlGenerator.buildXmlPathFromDrmAsset(this);
      return str;
    }
    catch (IOException localIOException)
    {
      TPLogUtil.e("TPMediaDRMAsset", localIOException);
    }
    return "";
  }
  
  public void setDrmPlayUrl(String paramString)
  {
    this.mPlayUrl = paramString;
  }
  
  public void setDrmProperty(String paramString1, String paramString2)
  {
    this.mDrmPropertyMap.put(paramString1, paramString2);
  }
  
  public void setDrmType(@TPCommonEnum.TP_DRM_TYPE int paramInt)
  {
    this.mDrmType = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.composition.TPMediaDRMAsset
 * JD-Core Version:    0.7.0.1
 */