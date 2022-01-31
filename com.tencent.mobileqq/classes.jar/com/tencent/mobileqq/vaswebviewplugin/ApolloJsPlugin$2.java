package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;

class ApolloJsPlugin$2
  implements Runnable
{
  ApolloJsPlugin$2(ApolloJsPlugin paramApolloJsPlugin, Activity paramActivity) {}
  
  public void run()
  {
    if ((this.val$activity != null) && (!this.val$activity.isFinishing())) {
      this.val$activity.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ApolloJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */