package com.tencent.mobileqq.profilecard.api.impl;

import android.content.Context;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;

public class ProfileCardApiImpl
  implements IProfileCardApi
{
  public void openProfileCard(Context paramContext, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramString = new ProfileActivity.AllInOne(paramString, paramInt1);
    paramString.h = paramInt2;
    paramString.i = paramInt3;
    paramString.l = paramInt4;
    ProfileActivity.b(paramContext, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.api.impl.ProfileCardApiImpl
 * JD-Core Version:    0.7.0.1
 */