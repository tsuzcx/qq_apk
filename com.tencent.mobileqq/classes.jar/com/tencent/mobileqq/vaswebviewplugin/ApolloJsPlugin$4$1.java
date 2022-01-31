package com.tencent.mobileqq.vaswebviewplugin;

import aleh;
import aleo;
import com.tencent.mobileqq.apollo.store.ApolloWebAvatarParam;
import com.tencent.qphone.base.util.QLog;
import java.util.Vector;

class ApolloJsPlugin$4$1
  implements Runnable
{
  ApolloJsPlugin$4$1(ApolloJsPlugin.4 param4) {}
  
  public void run()
  {
    if (ApolloJsPlugin.access$200(this.this$1.this$0).contains(this.this$1.val$param.apolloId))
    {
      String str = "";
      if (this.this$1.val$from == 1) {
        if (ApolloJsPlugin.access$300(this.this$1.this$0) != null) {
          str = ApolloJsPlugin.access$300(this.this$1.this$0).a(1, true, this.this$1.val$param);
        }
      }
      for (;;)
      {
        this.this$1.this$0.callJs(this.this$1.val$callbackId + "&&" + this.this$1.val$callbackId + "(" + str + ");");
        return;
        str = "{\"result\":1, \"msg\": \"终端初始化错误\" }";
        continue;
        if (this.this$1.val$from == 0) {
          if ((this.this$1.val$activity instanceof aleo)) {
            str = ((aleo)this.this$1.val$activity).a(ApolloJsPlugin.access$400(this.this$1.this$0), this.this$1.val$param);
          } else {
            str = "{\"result\":1, \"msg\": \"非商城页面\" }";
          }
        }
      }
    }
    QLog.e("ApolloJsPlugin", 1, new Object[] { "[IPC_APOLLO_CHECK_AVATAR_RES] onDownLoadFinish, initAvatar abort, apolloId is detroyed, id=", this.this$1.val$param.apolloId });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ApolloJsPlugin.4.1
 * JD-Core Version:    0.7.0.1
 */