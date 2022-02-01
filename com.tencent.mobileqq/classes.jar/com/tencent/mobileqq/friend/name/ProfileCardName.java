package com.tencent.mobileqq.friend.name;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.profilecard.api.IProfileDataService;

public class ProfileCardName
  implements IFriendName
{
  public String a(String paramString, Friends paramFriends, AppInterface paramAppInterface)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramAppInterface != null))
    {
      paramString = ((IProfileDataService)paramAppInterface.getRuntimeService(IProfileDataService.class, "all")).getProfileCard(paramString, false);
      if ((paramString != null) && (!TextUtils.isEmpty(paramString.strNick))) {
        return paramString.strNick;
      }
      return null;
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.friend.name.ProfileCardName
 * JD-Core Version:    0.7.0.1
 */