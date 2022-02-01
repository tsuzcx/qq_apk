package com.tencent.mobileqq.shortvideo;

import android.content.Context;
import com.tencent.mobileqq.widget.QQToast;

final class ShortVideoResourceManager$10
  implements Runnable
{
  ShortVideoResourceManager$10(String paramString) {}
  
  public void run()
  {
    Context localContext = VideoEnvironment.getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(this.a);
    QQToast.makeText(localContext, localStringBuilder.toString(), 1).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.10
 * JD-Core Version:    0.7.0.1
 */