package com.tencent.thumbplayer.composition;

import com.tencent.thumbplayer.api.composition.ITPMediaRTCAsset;
import com.tencent.thumbplayer.utils.TPLogUtil;
import java.io.IOException;

public class TPMediaRtcAsset
  implements ITPMediaRTCAsset
{
  private static final String TAG = "TPMediaWebrtcAsset";
  private String mServeryUrl;
  private String mStreamUrl;
  
  public TPMediaRtcAsset(String paramString1, String paramString2)
  {
    this.mStreamUrl = paramString1;
    this.mServeryUrl = paramString2;
  }
  
  public int getMediaType()
  {
    return 0;
  }
  
  public String getRtcServerUrl()
  {
    return this.mServeryUrl;
  }
  
  public String getRtcStreamUrl()
  {
    return this.mStreamUrl;
  }
  
  public String getUrl()
  {
    try
    {
      String str = TPMediaCompositionXmlGenerator.buildXmlPathFromRtcAsset(this);
      return str;
    }
    catch (IOException localIOException)
    {
      TPLogUtil.e("TPMediaWebrtcAsset", localIOException);
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.composition.TPMediaRtcAsset
 * JD-Core Version:    0.7.0.1
 */