package com.tencent.mobileqq.kandian.base.view;

import android.support.v4.util.LruCache;
import com.tencent.mobileqq.dinifly.LottieComposition;
import java.io.File;

class ReadInJoyLottieDrawable$3
  implements Runnable
{
  ReadInJoyLottieDrawable$3(ReadInJoyLottieDrawable paramReadInJoyLottieDrawable, File paramFile, File[] paramArrayOfFile) {}
  
  public void run()
  {
    LottieComposition localLottieComposition = (LottieComposition)ReadInJoyLottieDrawable.a().get(this.jdField_a_of_type_JavaIoFile.getAbsolutePath());
    if (localLottieComposition != null)
    {
      ReadInJoyLottieDrawable.3.1 local1 = new ReadInJoyLottieDrawable.3.1(this);
      this.this$0.setImageAssetDelegate(local1);
      this.this$0.setComposition(localLottieComposition);
      this.this$0.loop(true);
      if (ReadInJoyLottieDrawable.a(this.this$0)) {
        this.this$0.playAnimation();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.ReadInJoyLottieDrawable.3
 * JD-Core Version:    0.7.0.1
 */