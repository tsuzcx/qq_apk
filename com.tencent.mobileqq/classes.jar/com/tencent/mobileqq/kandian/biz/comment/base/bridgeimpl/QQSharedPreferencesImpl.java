package com.tencent.mobileqq.kandian.biz.comment.base.bridgeimpl;

import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.tkd.comment.publisher.qq.bridge.QQSharedPreferenceBridge;

public class QQSharedPreferencesImpl
  implements QQSharedPreferenceBridge
{
  public <T> T getValue(String paramString, T paramT)
  {
    return RIJSPUtils.a(paramString, paramT);
  }
  
  public <T> void setValue(String paramString, T paramT)
  {
    RIJSPUtils.a(paramString, paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.base.bridgeimpl.QQSharedPreferencesImpl
 * JD-Core Version:    0.7.0.1
 */