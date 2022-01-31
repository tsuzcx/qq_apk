package com.tencent.mobileqq.vaswebviewplugin;

import ajhu;
import ajic;
import android.app.Activity;
import com.tencent.mobileqq.apollo.store.ApolloWebAvatarParam;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

class ApolloJsPlugin$5
  implements ajic
{
  ApolloJsPlugin$5(ApolloJsPlugin paramApolloJsPlugin, ApolloWebAvatarParam paramApolloWebAvatarParam, Activity paramActivity, AtomicInteger paramAtomicInteger, ArrayList paramArrayList, String paramString) {}
  
  public void onDownLoadFinish(boolean paramBoolean, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    if ((this.val$param.dressIds == null) || (this.val$param.dressIds.length == 0)) {
      this.val$param.dressIds = ajhu.a(this.val$param.roleId);
    }
    paramString = new ArrayList();
    paramString.add(this.val$param);
    if (this.val$activity != null) {
      this.val$activity.runOnUiThread(new ApolloJsPlugin.5.1(this, paramString));
    }
    this.val$counter.getAndIncrement();
    if (this.val$counter.get() == this.val$avatarParams.size()) {
      this.this$0.callbackOk(this.val$callbackId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ApolloJsPlugin.5
 * JD-Core Version:    0.7.0.1
 */