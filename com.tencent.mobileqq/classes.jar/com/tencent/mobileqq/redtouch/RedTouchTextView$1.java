package com.tencent.mobileqq.redtouch;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.tencent.mobileqq.activity.qqsettingme.api.IRedTouchTextViewApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class RedTouchTextView$1
  implements Runnable
{
  RedTouchTextView$1(RedTouchTextView paramRedTouchTextView, String paramString, int paramInt) {}
  
  public void run()
  {
    try
    {
      Object localObject1 = this.this$0.getContext().getFilesDir();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.a.hashCode());
      ((StringBuilder)localObject2).append("");
      localObject1 = new File((File)localObject1, ((StringBuilder)localObject2).toString());
      if (((File)localObject1).exists())
      {
        localObject2 = this.this$0.a((File)localObject1);
        localObject1 = localObject2;
        if (this.b == 1) {
          localObject1 = ((IRedTouchTextViewApi)QRoute.api(IRedTouchTextViewApi.class)).getRoundedCornerBitmap((Bitmap)localObject2, ((Bitmap)localObject2).getWidth(), ((Bitmap)localObject2).getWidth(), ((Bitmap)localObject2).getHeight());
        }
        this.this$0.b = new BitmapDrawable((Bitmap)localObject1);
        this.this$0.a();
        return;
      }
      if (!RedTouchTextView.a(this.this$0))
      {
        RedTouchTextView.a(this.this$0, true);
        if (HttpDownloadUtil.download(null, this.a, (File)localObject1))
        {
          localObject2 = this.this$0.a((File)localObject1);
          localObject1 = localObject2;
          if (this.b == 1) {
            localObject1 = ((IRedTouchTextViewApi)QRoute.api(IRedTouchTextViewApi.class)).getRoundedCornerBitmap((Bitmap)localObject2, ((Bitmap)localObject2).getWidth(), ((Bitmap)localObject2).getWidth(), ((Bitmap)localObject2).getHeight());
          }
          this.this$0.b = new BitmapDrawable((Bitmap)localObject1);
          this.this$0.a();
        }
        RedTouchTextView.a(this.this$0, false);
        return;
      }
    }
    catch (Exception localException)
    {
      RedTouchTextView.a(this.this$0, false);
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("currentIrregularDrawable exception");
      ((StringBuilder)localObject2).append(localException);
      QLog.e("RedTouchTextView", 2, ((StringBuilder)localObject2).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.redtouch.RedTouchTextView.1
 * JD-Core Version:    0.7.0.1
 */