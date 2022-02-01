package com.tencent.mobileqq.nearby.redtouch.impl;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.redtouch.IUtil;
import com.tencent.mobileqq.nearby.redtouch.Util;

public class UtilImpl
  implements IUtil
{
  public boolean checkLikeRankListRedPointConfig(Object paramObject)
  {
    return Util.b((QQAppInterface)paramObject);
  }
  
  public boolean checkMedalRedPointConfig(Object paramObject)
  {
    return Util.a((QQAppInterface)paramObject);
  }
  
  public void onLikeRankListConfigChanged(Object paramObject, boolean paramBoolean)
  {
    Util.b((QQAppInterface)paramObject, paramBoolean);
  }
  
  public void onMedalConfigChanged(Object paramObject, boolean paramBoolean)
  {
    Util.a((QQAppInterface)paramObject, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.redtouch.impl.UtilImpl
 * JD-Core Version:    0.7.0.1
 */