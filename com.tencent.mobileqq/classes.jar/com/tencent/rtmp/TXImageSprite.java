package com.tencent.rtmp;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.rtmp.a.b;
import java.util.List;

public class TXImageSprite
  implements com.tencent.rtmp.a.a
{
  private Context mContext;
  private com.tencent.rtmp.a.a mImageSprite;
  
  public TXImageSprite(Context paramContext)
  {
    this.mContext = paramContext.getApplicationContext();
    TXCDRApi.initCrashReport(paramContext);
  }
  
  public Bitmap getThumbnail(float paramFloat)
  {
    com.tencent.rtmp.a.a locala = this.mImageSprite;
    if (locala != null) {
      return locala.getThumbnail(paramFloat);
    }
    return null;
  }
  
  public void release()
  {
    com.tencent.rtmp.a.a locala = this.mImageSprite;
    if (locala != null)
    {
      locala.release();
      this.mImageSprite = null;
    }
  }
  
  public void setVTTUrlAndImageUrls(String paramString, List<String> paramList)
  {
    if (this.mImageSprite != null) {
      release();
    }
    if ((paramString != null) && (paramList != null) && (paramList.size() != 0))
    {
      TXCDRApi.txReportDAU(this.mContext, com.tencent.liteav.basic.datareport.a.bD);
      this.mImageSprite = new b();
      this.mImageSprite.setVTTUrlAndImageUrls(paramString, paramList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rtmp.TXImageSprite
 * JD-Core Version:    0.7.0.1
 */