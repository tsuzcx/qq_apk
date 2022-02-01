package com.tencent.mobileqq.qqexpand.widget.voice;

import android.graphics.drawable.Drawable;
import com.tencent.image.ApngDrawable;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

class ExpandVoiceView$1
  implements Runnable
{
  ExpandVoiceView$1(ExpandVoiceView paramExpandVoiceView) {}
  
  public void run()
  {
    if (ExpandVoiceView.a(this.this$0) != null)
    {
      Object localObject1 = new File(ExpandVoiceView.getVoiceWavePath());
      boolean bool3 = ((File)localObject1).exists();
      boolean bool2 = true;
      boolean bool1 = true;
      if ((bool3) && (((File)localObject1).isFile()))
      {
        try
        {
          localObject1 = new ApngImage(((File)localObject1).getAbsoluteFile(), true);
          ExpandVoiceView.a(this.this$0, new ApngDrawable((ApngImage)localObject1));
        }
        catch (Throwable localThrowable1)
        {
          QLog.e("ExtendFriendVoiceView", 1, "unknow error!", localThrowable1);
          localThrowable1.printStackTrace();
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
        {
          QLog.e("ExtendFriendVoiceView", 1, "link error: nativeStartDecode, ", localUnsatisfiedLinkError);
        }
        catch (RuntimeException localRuntimeException)
        {
          QLog.e("ExtendFriendVoiceView", 1, "Apng decode RuntimeException! ", localRuntimeException);
        }
        catch (IOException localIOException)
        {
          QLog.e("ExtendFriendVoiceView", 1, "IOException! ", localIOException);
          localIOException.printStackTrace();
        }
        bool1 = false;
        if (!ExpandVoiceView.a(this.this$0, bool1)) {}
      }
      else
      {
        Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject2).mUseApngImage = true;
        localObject2 = URLDrawable.getDrawable("https://down.qq.com/extendfriend/voicewave.png", (URLDrawable.URLDrawableOptions)localObject2);
        if (!(((Drawable)localObject2).getCurrent() instanceof ApngDrawable)) {
          break label282;
        }
        try
        {
          ExpandVoiceView.a(this.this$0, (ApngDrawable)((Drawable)localObject2).getCurrent());
          bool1 = bool2;
        }
        catch (Throwable localThrowable2)
        {
          QLog.e("ExtendFriendVoiceView", 1, localThrowable2, new Object[0]);
          bool1 = false;
        }
        if (ExpandVoiceView.a(this.this$0, bool1)) {
          return;
        }
      }
      ExpandVoiceView.b(this.this$0).getImage().setSupportGlobalPasued(false);
      ExpandVoiceView.b(this.this$0).pause();
      ExpandVoiceView.a(this.this$0).setImageDrawable(ExpandVoiceView.b(this.this$0));
      return;
      label282:
      ExpandVoiceView.a(this.this$0).setImageDrawable(localThrowable2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.widget.voice.ExpandVoiceView.1
 * JD-Core Version:    0.7.0.1
 */