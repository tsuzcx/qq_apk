package com.tencent.mobileqq.colornote.smallscreen;

import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.qphone.base.util.QLog;
import java.io.InputStream;

class ColorNoteSmallScreenRelativeLayout$6
  implements Runnable
{
  ColorNoteSmallScreenRelativeLayout$6(ColorNoteSmallScreenRelativeLayout paramColorNoteSmallScreenRelativeLayout, String paramString1, Context paramContext, String paramString2, boolean paramBoolean) {}
  
  public void run()
  {
    try
    {
      InputStream localInputStream = this.this$0.getContext().getAssets().open(this.a);
      ColorNoteSmallScreenRelativeLayout.a(this.this$0, LottieComposition.Factory.fromInputStream(this.b, localInputStream, new ColorNoteSmallScreenRelativeLayout.6.1(this)));
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ColorNoteSmallScreenRelativeLayout", 2, "load lottie failed", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenRelativeLayout.6
 * JD-Core Version:    0.7.0.1
 */