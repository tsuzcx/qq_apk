package com.tencent.mobileqq.vas;

import android.content.Context;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import bhbe;
import com.tencent.mobileqq.vas.avatar.VasAvatar;
import com.tencent.qqconnect.wtlogin.Login;

public class AvatarItemView
  extends ImageView
{
  public AvatarItemView(Context paramContext)
  {
    super(paramContext);
    paramContext = new VasAvatar(paramContext);
    paramContext.setLoader(null, new bhbe(Login.a, -1, "small", 0L));
    paramContext.setScaleType(ImageView.ScaleType.CENTER_CROP);
    paramContext.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.AvatarItemView
 * JD-Core Version:    0.7.0.1
 */