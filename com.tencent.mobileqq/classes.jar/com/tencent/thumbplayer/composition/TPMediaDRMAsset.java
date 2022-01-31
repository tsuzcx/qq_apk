package com.tencent.thumbplayer.composition;

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
  private int mDrmType;
  private String mPlayUrl;
  
  public TPMediaDRMAsset(int paramInt, String paramString)
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
    if ((this.mDrmPropertyMap == null) || (this.mDrmPropertyMap.isEmpty())) {}
    do
    {
      return paramString2;
      paramString1 = (String)this.mDrmPropertyMap.get(paramString1);
    } while (paramString1 == null);
    return paramString1;
  }
  
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
  
  public void setDrmType(int paramInt)
  {
    this.mDrmType = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.composition.TPMediaDRMAsset
 * JD-Core Version:    0.7.0.1
 */