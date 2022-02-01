package com.tencent.mobileqq.friend.data;

import com.tencent.qphone.base.util.QLog;
import friendlist.FriendListSubSrvRspCode;
import friendlist.GetFriendListResp;

public class ExtRspData
{
  public long a = 0L;
  public int b = 0;
  public int c = 0;
  public int d = 0;
  
  public ExtRspData(GetFriendListResp paramGetFriendListResp)
  {
    this.a = paramGetFriendListResp.serverTime;
    this.b = paramGetFriendListResp.wGetExtSnsRspCode;
    if (paramGetFriendListResp.stSubSrvRspCode != null)
    {
      this.c = paramGetFriendListResp.stSubSrvRspCode.wGetMutualMarkRspCode;
      this.d = paramGetFriendListResp.stSubSrvRspCode.wGetIntimateInfoRspCode;
    }
    if (QLog.isColorLevel())
    {
      paramGetFriendListResp = new StringBuilder();
      paramGetFriendListResp.append("wGetExtSnsRspCode: ");
      paramGetFriendListResp.append(this.b);
      paramGetFriendListResp.append(", wGetMutualMarkRspCode: ");
      paramGetFriendListResp.append(this.c);
      paramGetFriendListResp.append(", wGetIntimateInfoRspCode: ");
      paramGetFriendListResp.append(this.d);
      QLog.d("ExtRspCode", 2, paramGetFriendListResp.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.friend.data.ExtRspData
 * JD-Core Version:    0.7.0.1
 */