package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import bglp;
import com.tencent.qphone.base.util.QLog;
import mqq.app.QQPermissionCallback;

class ApolloJsPlugin$2
  implements QQPermissionCallback
{
  ApolloJsPlugin$2(ApolloJsPlugin paramApolloJsPlugin, Activity paramActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bglp.a(this.val$activity, paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.d("ApolloJsPlugin", 1, "[startRecord] grant");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ApolloJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */