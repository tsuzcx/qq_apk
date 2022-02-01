package com.tencent.mobileqq.text;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.emoticon.QQEmojiUtil;
import com.tencent.qphone.base.util.BaseApplication;

final class TextUtils$1
  implements Runnable
{
  TextUtils$1(int paramInt, TextUtils.LoadSysEmojiCallback paramLoadSysEmojiCallback) {}
  
  public void run()
  {
    Drawable localDrawable = QQEmojiUtil.loadEmojiFromDisk(BaseApplication.getContext().getResources(), this.val$index);
    if ((localDrawable != null) && (this.val$callback != null)) {
      this.val$callback.callbackWhenSysEmojiLoaded(localDrawable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.text.TextUtils.1
 * JD-Core Version:    0.7.0.1
 */