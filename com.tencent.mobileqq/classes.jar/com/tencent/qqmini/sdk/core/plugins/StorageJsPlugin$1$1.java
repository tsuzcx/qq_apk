package com.tencent.qqmini.sdk.core.plugins;

import bdei;
import bdfz;

class StorageJsPlugin$1$1
  implements bdei
{
  StorageJsPlugin$1$1(StorageJsPlugin.1 param1) {}
  
  public void onFailed(String paramString1, String paramString2)
  {
    this.this$1.val$req.a(paramString2);
  }
  
  public void onSuccess(String paramString1, String paramString2)
  {
    this.this$1.val$req.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.StorageJsPlugin.1.1
 * JD-Core Version:    0.7.0.1
 */