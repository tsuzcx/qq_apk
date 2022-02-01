package com.tencent.mobileqq.proxy.api.impl;

import com.tencent.mobileqq.activity.recent.msg.RecentUserMsgFactory;
import com.tencent.mobileqq.proxy.api.IRecentUserMsgSerializeApi;
import com.tencent.qphone.base.util.QLog;

public class RecentUserMsgSerializeApiImpl
  implements IRecentUserMsgSerializeApi
{
  public Object recentUserMsgDeserialize(int paramInt, byte[] paramArrayOfByte)
  {
    if (RecentUserMsgFactory.a() == null)
    {
      QLog.e("RecentUserMsgSerializeApiImpl", 1, "RecentUserMsgFactory.instance() == null");
      return null;
    }
    return RecentUserMsgFactory.a().a(paramInt, paramArrayOfByte);
  }
  
  public byte[] recentUserMsgSerialize(int paramInt, Object paramObject)
  {
    return RecentUserMsgFactory.a().a(paramInt, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.proxy.api.impl.RecentUserMsgSerializeApiImpl
 * JD-Core Version:    0.7.0.1
 */