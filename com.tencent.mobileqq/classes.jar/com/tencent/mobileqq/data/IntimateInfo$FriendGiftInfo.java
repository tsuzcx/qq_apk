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
    Object localObject = new oidb_0xd6c.RspBody();
    for (;;)
    {
      try
      {
        oidb_0xd6c.RspBody localRspBody = (oidb_0xd6c.RspBody)((oidb_0xd6c.RspBody)localObject).mergeFrom(paramCommonBody.rspBodyContent);
        if (localRspBody.str_gift_url.has())
        {
          paramCommonBody = localRspBody.str_gift_url.get();
          localFriendGiftInfo.str_gift_url = paramCommonBody;
          boolean bool = localRspBody.str_custom_url.has();
          localObject = "";
          if (!bool) {
            break label167;
          }
          paramCommonBody = localRspBody.str_custom_url.get();
          localFriendGiftInfo.str_custom_url = paramCommonBody;
          paramCommonBody = (IntimateInfo.CommonBody)localObject;
          if (localRspBody.str_desc.has()) {
            paramCommonBody = localRspBody.str_desc.get();
          }
          localFriendGiftInfo.str_desc = paramCommonBody;
          if (!localRspBody.str_send_times.has()) {
            break label173;
          }
          i = localRspBody.str_send_times.get();
          localFriendGiftInfo.str_send_times = i;
          return localFriendGiftInfo;
        }
      }
      catch (Exception paramCommonBody)
      {
        return null;
      }
      paramCommonBody = null;
      continue;
      label167:
      paramCommonBody = "";
      continue;
      label173:
      int i = 0;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FriendGiftInfo{str_gift_url=");
    localStringBuilder.append(this.str_gift_url);
    localStringBuilder.append("str_send_times=");
    localStringBuilder.append(this.str_send_times);
    localStringBuilder.append("str_desc=");
    localStringBuilder.append(this.str_desc);
    localStringBuilder.append("str_custom_url=");
    localStringBuilder.append(this.str_custom_url);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.IntimateInfo.FriendGiftInfo
 * JD-Core Version:    0.7.0.1
 */