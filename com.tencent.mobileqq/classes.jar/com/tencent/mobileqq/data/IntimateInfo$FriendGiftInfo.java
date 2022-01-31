package com.tencent.mobileqq.data;

import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import java.util.List;
import tencent.im.oidb.oidb_0xd6c.oidb_0xd6c.RspBody;

public class IntimateInfo$FriendGiftInfo
{
  public String str_custom_url;
  public String str_desc;
  public List<String> str_gift_url;
  public int str_send_times;
  
  public static FriendGiftInfo copyFrom(IntimateInfo.CommonBody paramCommonBody)
  {
    if (paramCommonBody == null) {
      return null;
    }
    FriendGiftInfo localFriendGiftInfo = new FriendGiftInfo();
    oidb_0xd6c.RspBody localRspBody = new oidb_0xd6c.RspBody();
    for (;;)
    {
      try
      {
        localRspBody = (oidb_0xd6c.RspBody)localRspBody.mergeFrom(paramCommonBody.rspBodyContent);
        if (localRspBody.str_gift_url.has())
        {
          paramCommonBody = localRspBody.str_gift_url.get();
          localFriendGiftInfo.str_gift_url = paramCommonBody;
          if (!localRspBody.str_custom_url.has()) {
            break label147;
          }
          paramCommonBody = localRspBody.str_custom_url.get();
          localFriendGiftInfo.str_custom_url = paramCommonBody;
          if (localRspBody.str_desc.has())
          {
            paramCommonBody = localRspBody.str_desc.get();
            localFriendGiftInfo.str_desc = paramCommonBody;
            if (localRspBody.str_send_times.has())
            {
              i = localRspBody.str_send_times.get();
              localFriendGiftInfo.str_send_times = i;
              return localFriendGiftInfo;
            }
          }
          else
          {
            paramCommonBody = "";
            continue;
          }
          int i = 0;
          continue;
        }
        paramCommonBody = null;
      }
      catch (Exception paramCommonBody)
      {
        return null;
      }
      continue;
      label147:
      paramCommonBody = "";
    }
  }
  
  public String toString()
  {
    return "FriendGiftInfo{str_gift_url=" + this.str_gift_url + "str_send_times=" + this.str_send_times + "str_desc=" + this.str_desc + "str_custom_url=" + this.str_custom_url + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.IntimateInfo.FriendGiftInfo
 * JD-Core Version:    0.7.0.1
 */