package com.tencent.mobileqq.vaswebviewplugin;

import amod;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.os.MqqHandler;

class ApolloJsPlugin$5
  implements amod
{
  ApolloJsPlugin$5(ApolloJsPlugin paramApolloJsPlugin, String paramString, int paramInt) {}
  
  public void onGetApolloDressInfo(HashMap<Integer, String> paramHashMap, String paramString, int paramInt)
  {
    QLog.d("ApolloJsPlugin", 1, "[handleCmShowLoad3DFaceDress] onGetApolloDressInfo: " + paramHashMap + ", errMsg: " + paramString);
    if (paramHashMap == null)
    {
      QLog.e("ApolloJsPlugin", 1, "[handleCmShowLoad3DFaceDress] onGetApolloDressInfo apolloDressInfo is null! ");
      this.this$0.callbackError(this.val$callbackId, "apolloDressInfo is null");
      return;
    }
    paramHashMap = (String)paramHashMap.get(Integer.valueOf(this.val$dressId));
    if (TextUtils.isEmpty(paramHashMap))
    {
      QLog.e("ApolloJsPlugin", 1, "[handleCmShowLoad3DFaceDress] dressPath is empty!");
      return;
    }
    ThreadManager.getFileThreadHandler().post(new ApolloJsPlugin.5.1(this, paramHashMap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ApolloJsPlugin.5
 * JD-Core Version:    0.7.0.1
 */