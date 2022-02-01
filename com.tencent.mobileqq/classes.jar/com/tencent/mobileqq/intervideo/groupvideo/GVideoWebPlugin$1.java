package com.tencent.mobileqq.intervideo.groupvideo;

import android.text.TextUtils;
import com.tencent.mobileqq.widget.QQProgressDialog;

class GVideoWebPlugin$1
  implements IGroupVideoManager.CheckListener
{
  GVideoWebPlugin$1(GVideoWebPlugin paramGVideoWebPlugin, String paramString) {}
  
  public void a(boolean paramBoolean)
  {
    if ((paramBoolean) && (TextUtils.equals("download", this.a)))
    {
      GVideoWebPlugin.a(this.b).c(2131893371);
      GVideoWebPlugin.a(this.b).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.groupvideo.GVideoWebPlugin.1
 * JD-Core Version:    0.7.0.1
 */