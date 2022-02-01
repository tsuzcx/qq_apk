package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.mini.util.StorageUtil;
import com.tencent.mobileqq.mini.webview.JsRuntime;

class StoragePlugin$8
  implements StoragePlugin.StorageTask
{
  StoragePlugin$8(StoragePlugin paramStoragePlugin, String paramString1, String paramString2, JsRuntime paramJsRuntime, String paramString3, int paramInt) {}
  
  public String run()
  {
    if (!TextUtils.isEmpty(this.val$key_real))
    {
      StorageUtil.getPreference().edit().putString(this.val$key_real, this.val$data).apply();
      return StoragePlugin.access$000(this.this$0, this.val$webview, this.val$event, null, this.val$callbackId);
    }
    return StoragePlugin.access$100(this.this$0, this.val$webview, this.val$event, null, "key is null", this.val$callbackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.StoragePlugin.8
 * JD-Core Version:    0.7.0.1
 */