package com.tencent.mobileqq.widget;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Message;
import com.tencent.mobileqq.utils.CommonImageCacheHelper;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.Util;
import java.util.ArrayList;

public class GifAnimationDrawable$Decoder
  implements Runnable
{
  private final GifAnimationDrawable.Frame a;
  
  public GifAnimationDrawable$Decoder(GifAnimationDrawable paramGifAnimationDrawable, GifAnimationDrawable.Frame paramFrame)
  {
    this.a = paramFrame;
  }
  
  @TargetApi(12)
  private BitmapDrawable a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(GifAnimationDrawable.a(this.this$0), 2, "decodeBitmap() called with: path = [" + paramString + "]");
    }
    return new BitmapDrawable(Util.a(paramString, 320, 320, true));
  }
  
  public void run()
  {
    if (!this.this$0.isRunning()) {}
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d(GifAnimationDrawable.a(this.this$0), 2, "Decoder index:" + this.a.jdField_a_of_type_Int);
      }
      Object localObject = "android.resource://main_tab_animation_" + (String)GifAnimationDrawable.a(this.this$0).get(this.a.jdField_a_of_type_Int);
      Bitmap localBitmap = CommonImageCacheHelper.a((String)localObject);
      if (localBitmap != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(GifAnimationDrawable.a(this.this$0), 2, "Decoder hit cache :" + this.a.jdField_a_of_type_Int);
        }
        this.a.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = new BitmapDrawable(localBitmap);
      }
      while (this.this$0.isRunning())
      {
        localObject = GifAnimationDrawable.a(this.this$0).obtainMessage(0, this.a);
        GifAnimationDrawable.a(this.this$0).sendMessageAtTime((Message)localObject, this.a.jdField_a_of_type_Long);
        return;
        long l1 = System.currentTimeMillis();
        this.a.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = a((String)GifAnimationDrawable.a(this.this$0).get(this.a.jdField_a_of_type_Int));
        long l2 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d(GifAnimationDrawable.a(this.this$0), 2, "Decoder decodeBitmap index:" + this.a.jdField_a_of_type_Int + " cost:" + (l2 - l1) + " delay:" + GifAnimationDrawable.a(this.this$0));
        }
        CommonImageCacheHelper.a((String)localObject, this.a.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable.getBitmap());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.widget.GifAnimationDrawable.Decoder
 * JD-Core Version:    0.7.0.1
 */