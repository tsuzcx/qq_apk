package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import aniv;
import anje;
import anzj;
import com.tencent.mobileqq.apollo.store.ApolloWebAvatarParam;

class ApolloJsPlugin$4
  implements anje
{
  ApolloJsPlugin$4(ApolloJsPlugin paramApolloJsPlugin, ApolloWebAvatarParam paramApolloWebAvatarParam, Activity paramActivity, int paramInt, String paramString) {}
  
  public void onDownLoadFinish(boolean paramBoolean, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    if (paramBoolean)
    {
      if ((this.val$param.dressIds == null) || (this.val$param.dressIds.length == 0)) {
        this.val$param.dressIds = aniv.a(this.val$param.roleId);
      }
      if (this.val$activity != null) {
        this.val$activity.runOnUiThread(new ApolloJsPlugin.4.1(this));
      }
      return;
    }
    this.this$0.callbackError(this.val$callbackId, anzj.a(2131699360));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ApolloJsPlugin.4
 * JD-Core Version:    0.7.0.1
 */