package com.tencent.qqmini.sdk.core.plugins;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import bgok;

class StorageJsPlugin$7
  implements StorageJsPlugin.StorageTask
{
  StorageJsPlugin$7(StorageJsPlugin paramStorageJsPlugin, String paramString1, String paramString2, bgok parambgok) {}
  
  public String run()
  {
    if (!TextUtils.isEmpty(this.val$key_real))
    {
      StorageJsPlugin.access$100(this.this$0).edit().putString(this.val$key_real, this.val$data).apply();
      return this.val$req.a();
    }
    return this.val$req.a("key is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.StorageJsPlugin.7
 * JD-Core Version:    0.7.0.1
 */