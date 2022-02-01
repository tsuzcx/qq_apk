package com.tencent.mobileqq.gallery.picocr;

import com.tencent.mobileqq.app.BusinessObserver;

public class PicOcrObserver
  implements BusinessObserver
{
  public void a() {}
  
  public void a(PicOcrRspResult paramPicOcrRspResult) {}
  
  protected void a(boolean paramBoolean, PicOcrRspResult paramPicOcrRspResult) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    a(paramBoolean, (PicOcrRspResult)paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gallery.picocr.PicOcrObserver
 * JD-Core Version:    0.7.0.1
 */