package com.tencent.mobileqq.text;

import android.graphics.drawable.Drawable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;

final class TextUtils$1
  implements Runnable
{
  TextUtils$1(int paramInt, TextUtils.LoadSysEmojiCallback paramLoadSysEmojiCallback) {}
  
  public void run()
  {
    Drawable localDrawable = TextUtils.loadEmojiFromDisk(BaseApplicationImpl.getContext().getResources(), this.val$index);
    if ((localDrawable != null) && (this.val$callback != null)) {
      this.val$callback.callbackWhenSysEmojiLoaded(localDrawable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.text.TextUtils.1
 * JD-Core Version:    0.7.0.1
 */