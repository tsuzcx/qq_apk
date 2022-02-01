package com.tencent.mobileqq.guild.audio;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.guild.audio.data.LocalUserInfo;
import com.tencent.mobileqq.guild.audio.data.NotifyUIData;
import com.tencent.mobileqq.guild.audio.data.UserInfoList;

public class AudioRoomObserver
  implements BusinessObserver
{
  public void a(String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2, String paramString4) {}
  
  public void a(String paramString1, String paramString2, String paramString3) {}
  
  public void a(String paramString1, String paramString2, String paramString3, LocalUserInfo paramLocalUserInfo, UserInfoList paramUserInfoList) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    paramObject = (NotifyUIData)paramObject;
    String str1 = (String)paramObject.a(1);
    String str2 = (String)paramObject.a(2);
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          return;
        }
        a(str1, str2, ((Integer)paramObject.a(6)).intValue(), (String)paramObject.a(7), ((Integer)paramObject.a(8)).intValue(), (String)paramObject.a(9));
        return;
      }
      a(str1, str2, (String)paramObject.a(5));
      return;
    }
    a((String)paramObject.a(10), str1, str2, (LocalUserInfo)paramObject.a(3), (UserInfoList)paramObject.a(4));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.AudioRoomObserver
 * JD-Core Version:    0.7.0.1
 */