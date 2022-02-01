package com.tencent.mobileqq.guild.audio.widget.audiofaceview;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil.ItemCallback;
import com.tencent.mobileqq.guild.audio.data.UserInfo;

class FaceAdapter$1
  extends DiffUtil.ItemCallback<UserInfo>
{
  FaceAdapter$1(FaceAdapter paramFaceAdapter) {}
  
  public boolean a(@NonNull UserInfo paramUserInfo1, @NonNull UserInfo paramUserInfo2)
  {
    return TextUtils.equals(paramUserInfo1.h, paramUserInfo2.h);
  }
  
  public boolean b(@NonNull UserInfo paramUserInfo1, @NonNull UserInfo paramUserInfo2)
  {
    return (paramUserInfo1.m == paramUserInfo2.m) && (paramUserInfo1.o == paramUserInfo2.o) && (TextUtils.equals(paramUserInfo1.j, paramUserInfo2.j)) && (TextUtils.equals(paramUserInfo1.i, paramUserInfo2.i)) && (TextUtils.equals(paramUserInfo1.h, paramUserInfo2.h)) && (paramUserInfo1.n == paramUserInfo2.n) && (paramUserInfo1.k == paramUserInfo2.k) && (paramUserInfo1.p == paramUserInfo2.p) && (paramUserInfo1.l == paramUserInfo2.l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.widget.audiofaceview.FaceAdapter.1
 * JD-Core Version:    0.7.0.1
 */