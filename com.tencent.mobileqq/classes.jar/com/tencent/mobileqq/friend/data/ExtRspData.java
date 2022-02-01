package com.tencent.mobileqq.friend.data;

import com.tencent.qphone.base.util.QLog;
import friendlist.FriendListSubSrvRspCode;
import friendlist.GetFriendListResp;

public class ExtRspData
{
  public int a;
  public long a;
  public int b = 0;
  public int c = 0;
  
  public ExtRspData(GetFriendListResp paramGetFriendListResp)
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Long = paramGetFriendListResp.serverTime;
    this.jdField_a_of_type_Int = paramGetFriendListResp.wGetExtSnsRspCode;
    if (paramGetFriendListResp.stSubSrvRspCode != null)
    {
      this.b = paramGetFriendListResp.stSubSrvRspCode.wGetMutualMarkRspCode;
      this.c = paramGetFriendListResp.stSubSrvRspCode.wGetIntimateInfoRspCode;
    }
    if (QLog.isColorLevel())
    {
      paramGetFriendListResp = new StringBuilder();
      paramGetFriendListResp.append("wGetExtSnsRspCode: ");
      paramGetFriendListResp.append(this.jdField_a_of_type_Int);
      paramGetFriendListResp.append(", wGetMutualMarkRspCode: ");
      paramGetFriendListResp.append(this.b);
      paramGetFriendListResp.append(", wGetIntimateInfoRspCode: ");
      paramGetFriendListResp.append(this.c);
      QLog.d("ExtRspCode", 2, paramGetFriendListResp.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.friend.data.ExtRspData
 * JD-Core Version:    0.7.0.1
 */