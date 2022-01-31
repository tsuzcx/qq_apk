package com.tencent.mobileqq.troop.homework.xmediaeditor.ui;

import android.app.Activity;
import android.text.TextUtils;
import babf;
import babx;
import bhxg;

public class AudioItem$1
  implements Runnable
{
  public AudioItem$1(babx parambabx, babf parambabf) {}
  
  public void run()
  {
    String str = bhxg.a(this.a.b);
    this.a.b(str);
    if (!TextUtils.isEmpty(str)) {
      ((Activity)babx.a(this.this$0)).runOnUiThread(new AudioItem.1.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.ui.AudioItem.1
 * JD-Core Version:    0.7.0.1
 */