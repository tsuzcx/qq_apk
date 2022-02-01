package com.tencent.open.appstore.js;

import com.tencent.open.base.LogUtility;
import com.tencent.smtt.sdk.ValueCallback;

class YybTreasureCardJsPlugin$1$1
  implements ValueCallback<String>
{
  YybTreasureCardJsPlugin$1$1(YybTreasureCardJsPlugin.1 param1) {}
  
  public void a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[jsCallBack]:");
    localStringBuilder.append(paramString);
    LogUtility.b("TreasureCardJsPlugin", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.appstore.js.YybTreasureCardJsPlugin.1.1
 * JD-Core Version:    0.7.0.1
 */