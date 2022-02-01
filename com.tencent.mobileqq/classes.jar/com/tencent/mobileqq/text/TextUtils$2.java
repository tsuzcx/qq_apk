package com.tencent.mobileqq.text;

import android.graphics.drawable.Drawable;
import com.tencent.qphone.base.util.BaseApplication;

final class TextUtils$2
  implements Runnable
{
  TextUtils$2(int paramInt, TextUtils.LoadSysEmojiCallback paramLoadSysEmojiCallback) {}
  
  public void run()
  {
    Drawable localDrawable = TextUtils.getResourceDrawableThroughImageCache(BaseApplication.getContext().getResources(), this.val$resId);
    if (localDrawable != null)
    {
      TextUtils.LoadSysEmojiCallback localLoadSysEmojiCallback = this.val$callback;
      if (localLoadSysEmojiCallback != null) {
        localLoadSysEmojiCallback.callbackWhenSysEmojiLoaded(localDrawable);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.text.TextUtils.2
 * JD-Core Version:    0.7.0.1
 */