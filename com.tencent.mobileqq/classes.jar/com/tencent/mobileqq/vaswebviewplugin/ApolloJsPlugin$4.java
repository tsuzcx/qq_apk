package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import com.tencent.mobileqq.apollo.store.ApolloResDownloader;
import com.tencent.mobileqq.apollo.store.ApolloResDownloader.OnApolloDownLoadListener;
import com.tencent.mobileqq.apollo.store.ApolloWebAvatarParam;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

class ApolloJsPlugin$4
  implements ApolloResDownloader.OnApolloDownLoadListener
{
  ApolloJsPlugin$4(ApolloJsPlugin paramApolloJsPlugin, ApolloWebAvatarParam paramApolloWebAvatarParam, Activity paramActivity, AtomicInteger paramAtomicInteger, ArrayList paramArrayList, String paramString) {}
  
  public void onDownLoadFinish(boolean paramBoolean, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    if ((this.val$param.dressIds == null) || (this.val$param.dressIds.length == 0)) {
      this.val$param.dressIds = ApolloResDownloader.a(this.val$param.roleId);
    }
    paramString = new ArrayList();
    paramString.add(this.val$param);
    if (this.val$activity != null) {
      this.val$activity.runOnUiThread(new ApolloJsPlugin.4.1(this, paramString));
    }
    this.val$counter.getAndIncrement();
    if (this.val$counter.get() == this.val$avatarParams.size()) {
      this.this$0.callbackOk(this.val$callbackId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ApolloJsPlugin.4
 * JD-Core Version:    0.7.0.1
 */