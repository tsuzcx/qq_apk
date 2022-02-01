package com.tencent.timi.game.utils;

import android.content.Context;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/utils/NetUtils;", "", "()V", "checkNetIsAvailable", "", "netUnavailableHintResId", "", "netUnavailableHint", "", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class NetUtils
{
  public static final NetUtils a = new NetUtils();
  
  public final boolean a()
  {
    return (AppNetConnInfo.isMobileConn()) || (AppNetConnInfo.isWifiConn());
  }
  
  public final boolean a(int paramInt)
  {
    if ((!AppNetConnInfo.isMobileConn()) && (!AppNetConnInfo.isWifiConn()))
    {
      if (paramInt != 0) {
        QQToast.makeText((Context)BaseApplication.context, paramInt, 0).show();
      }
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.utils.NetUtils
 * JD-Core Version:    0.7.0.1
 */