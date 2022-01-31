package com.tencent.mobileqq.vaswebviewplugin;

import com.tencent.mobileqq.apollo.store.ApolloViewController;
import com.tencent.mobileqq.apollo.store.ApolloWebAvatarParam;
import com.tencent.mobileqq.apollo.store.IApolloActivityJsCallBack;
import java.util.ArrayList;
import java.util.Vector;

class ApolloJsPlugin$4$1
  implements Runnable
{
  ApolloJsPlugin$4$1(ApolloJsPlugin.4 param4, ArrayList paramArrayList) {}
  
  public void run()
  {
    if (ApolloJsPlugin.access$200(this.this$1.this$0).contains(this.this$1.val$param.apolloId))
    {
      if (!(this.this$1.val$activity instanceof IApolloActivityJsCallBack)) {
        break label60;
      }
      ((IApolloActivityJsCallBack)this.this$1.val$activity).a(this.val$tempList);
    }
    label60:
    while (ApolloJsPlugin.access$300(this.this$1.this$0) == null) {
      return;
    }
    ApolloJsPlugin.access$300(this.this$1.this$0).a(this.val$tempList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ApolloJsPlugin.4.1
 * JD-Core Version:    0.7.0.1
 */