package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import com.tencent.mobileqq.apollo.store.ApolloResDownloader;
import com.tencent.mobileqq.apollo.store.ApolloResDownloader.OnApolloDownLoadListener;
import com.tencent.mobileqq.apollo.store.ApolloWebAvatarParam;

class ApolloJsPlugin$3
  implements ApolloResDownloader.OnApolloDownLoadListener
{
  ApolloJsPlugin$3(ApolloJsPlugin paramApolloJsPlugin, ApolloWebAvatarParam paramApolloWebAvatarParam, Activity paramActivity, int paramInt, String paramString) {}
  
  public void onDownLoadFinish(boolean paramBoolean, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    if (paramBoolean)
    {
      if ((this.val$param.dressIds == null) || (this.val$param.dressIds.length == 0)) {
        this.val$param.dressIds = ApolloResDownloader.a(this.val$param.roleId);
      }
      if (this.val$activity != null) {
        this.val$activity.runOnUiThread(new ApolloJsPlugin.3.1(this));
      }
      return;
    }
    this.this$0.callbackError(this.val$callbackId, "下载角色资源失败");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ApolloJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */