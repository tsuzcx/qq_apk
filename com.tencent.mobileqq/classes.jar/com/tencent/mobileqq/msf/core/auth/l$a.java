package com.tencent.mobileqq.msf.core.auth;

import android.content.Context;
import com.tencent.beacon.event.UserAction;
import oicq.wlogin_sdk.listener.QimeiListener;

public class l$a
  implements QimeiListener
{
  public static final String a = "WtQimeiListener";
  
  public String getQimei(Context paramContext)
  {
    return UserAction.getQIMEI();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.auth.l.a
 * JD-Core Version:    0.7.0.1
 */