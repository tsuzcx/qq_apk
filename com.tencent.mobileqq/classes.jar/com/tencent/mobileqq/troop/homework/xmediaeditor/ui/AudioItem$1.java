package com.tencent.mobileqq.troop.homework.xmediaeditor.ui;

import android.app.Activity;
import android.text.TextUtils;
import bfuq;
import bfvi;
import bmjd;

public class AudioItem$1
  implements Runnable
{
  public AudioItem$1(bfvi parambfvi, bfuq parambfuq) {}
  
  public void run()
  {
    String str = bmjd.a(this.a.b);
    this.a.b(str);
    if (!TextUtils.isEmpty(str)) {
      ((Activity)bfvi.a(this.this$0)).runOnUiThread(new AudioItem.1.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.ui.AudioItem.1
 * JD-Core Version:    0.7.0.1
 */