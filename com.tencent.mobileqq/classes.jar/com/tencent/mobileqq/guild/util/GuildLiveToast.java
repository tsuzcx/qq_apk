package com.tencent.mobileqq.guild.util;

import androidx.annotation.StringRes;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

public class GuildLiveToast
{
  public static void a(@StringRes int paramInt)
  {
    a(HardCodeUtil.a(paramInt));
  }
  
  public static void a(String paramString)
  {
    QQToast.makeText(BaseApplication.getContext(), paramString, 0).show();
  }
  
  public static void b(@StringRes int paramInt)
  {
    b(HardCodeUtil.a(paramInt));
  }
  
  public static void b(String paramString)
  {
    QQToast.makeText(BaseApplication.getContext(), 1, paramString, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.util.GuildLiveToast
 * JD-Core Version:    0.7.0.1
 */