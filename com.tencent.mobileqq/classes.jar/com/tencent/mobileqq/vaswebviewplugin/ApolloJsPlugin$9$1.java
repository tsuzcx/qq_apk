package com.tencent.mobileqq.vaswebviewplugin;

import anfk;
import anfr;
import com.tencent.mobileqq.apollo.store.ApolloWebAvatarParam;
import java.util.ArrayList;
import java.util.Vector;

class ApolloJsPlugin$9$1
  implements Runnable
{
  ApolloJsPlugin$9$1(ApolloJsPlugin.9 param9, ArrayList paramArrayList) {}
  
  public void run()
  {
    if (ApolloJsPlugin.access$500(this.this$1.this$0).contains(this.this$1.val$param.apolloId))
    {
      if (!(this.this$1.val$activity instanceof anfr)) {
        break label60;
      }
      ((anfr)this.this$1.val$activity).a(this.val$tempList);
    }
    label60:
    while (ApolloJsPlugin.access$600(this.this$1.this$0) == null) {
      return;
    }
    ApolloJsPlugin.access$600(this.this$1.this$0).a(this.val$tempList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ApolloJsPlugin.9.1
 * JD-Core Version:    0.7.0.1
 */