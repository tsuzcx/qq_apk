package com.tencent.qqmini.sdk.runtime.plugin;

import bgok;
import bhke;

class MediaJsPlugin$5$1
  implements bhke
{
  MediaJsPlugin$5$1(MediaJsPlugin.5 param5) {}
  
  public void onStartPreview(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.this$1.val$req.a(this.this$1.val$result);
      return;
    }
    this.this$1.val$req.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.plugin.MediaJsPlugin.5.1
 * JD-Core Version:    0.7.0.1
 */