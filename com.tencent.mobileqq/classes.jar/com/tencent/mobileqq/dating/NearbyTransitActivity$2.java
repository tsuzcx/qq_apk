package com.tencent.mobileqq.dating;

import android.content.res.Resources;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.app.HotChatObserver;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearby.api.IHotChatUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import mqq.os.MqqHandler;
import tencent.im.oidb.hotchat.Common.WifiPOIInfo;

class NearbyTransitActivity$2
  extends HotChatObserver
{
  NearbyTransitActivity$2(NearbyTransitActivity paramNearbyTransitActivity) {}
  
  protected void a(String paramString1, String paramString2, boolean paramBoolean, String paramString3, String paramString4, Boolean paramBoolean1)
  {
    DatingUtil.a("NearbyTransitActivity", new Object[] { "onJoinHotChat", Boolean.valueOf(NearbyTransitActivity.d(this.a)), Boolean.valueOf(paramBoolean), paramString1 });
    NearbyTransitActivity.a("onJoinHotChat", 1);
    if (NearbyTransitActivity.d(this.a)) {
      return;
    }
    NearbyTransitActivity.e(this.a).removeMessages(2);
    NearbyTransitActivity.e(this.a).removeMessages(5);
    if (this.a.b != null) {
      this.a.b.b();
    }
    paramBoolean1 = Message.obtain();
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString1)))
    {
      paramBoolean1.what = 3;
      paramBoolean1.obj = new Object[] { paramString1, paramString2, paramString4 };
    }
    else
    {
      paramString1 = paramString3;
      if (TextUtils.isEmpty(paramString3)) {
        paramString1 = NearbyTransitActivity.a;
      }
      paramBoolean1.what = 1;
      paramBoolean1.arg1 = 11;
      paramBoolean1.obj = paramString1;
    }
    NearbyTransitActivity.e(this.a).sendMessage(paramBoolean1);
  }
  
  public void a(boolean paramBoolean, HotChatInfo paramHotChatInfo, Common.WifiPOIInfo paramWifiPOIInfo, int paramInt, String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString))
    {
      str = paramString;
      if (paramHotChatInfo != null) {
        str = paramHotChatInfo.name;
      }
    }
    if ((NearbyTransitActivity.b(this.a) == 1) && (!Utils.a(str, NearbyTransitActivity.c(this.a)))) {
      return;
    }
    NearbyTransitActivity.a("onQuickJoinHotChat", 1);
    DatingUtil.a("NearbyTransitActivity", new Object[] { "onQuickJoinHotChat", Boolean.valueOf(NearbyTransitActivity.d(this.a)), Boolean.valueOf(paramBoolean), Integer.valueOf(NearbyTransitActivity.b(this.a)), Integer.valueOf(paramInt), str, paramHotChatInfo, paramWifiPOIInfo });
    if (NearbyTransitActivity.d(this.a)) {
      return;
    }
    NearbyTransitActivity.e(this.a).removeMessages(2);
    NearbyTransitActivity.e(this.a).removeMessages(5);
    if (this.a.b != null) {
      this.a.b.b();
    }
    paramWifiPOIInfo = Message.obtain();
    if (paramBoolean)
    {
      if ((paramHotChatInfo != null) && ((paramInt == 1) || (paramInt == 2)))
      {
        paramWifiPOIInfo.what = 3;
        paramWifiPOIInfo.obj = new Object[] { paramHotChatInfo.troopUin, paramHotChatInfo.troopCode, paramHotChatInfo.name };
      }
      else
      {
        paramWifiPOIInfo.what = 1;
        paramWifiPOIInfo.arg1 = 5;
        paramWifiPOIInfo.obj = NearbyTransitActivity.a;
      }
    }
    else
    {
      paramWifiPOIInfo.what = 1;
      paramWifiPOIInfo.arg1 = (paramInt + 100);
      paramWifiPOIInfo.obj = ((IHotChatUtil)QRoute.api(IHotChatUtil.class)).getJoinHotChatFailTip(paramInt);
    }
    if ((NearbyTransitActivity.f(this.a) == 1) && (paramWifiPOIInfo.what == 3) && (paramHotChatInfo.mFissionRoomNum > 0))
    {
      NearbyUtils.a("NearbyTransitActivity", new Object[] { "onQuickJoinHotChat allocate room success,is to showing entering tip " });
      paramString = Message.obtain();
      paramString.what = 5;
      paramString.obj = String.format(this.a.getResources().getString(2131890723), new Object[] { Integer.valueOf(paramHotChatInfo.mFissionRoomNum) });
      NearbyTransitActivity.e(this.a).sendMessage(paramString);
      NearbyTransitActivity.e(this.a).sendMessageDelayed(paramWifiPOIInfo, 600L);
      return;
    }
    NearbyTransitActivity.e(this.a).sendMessage(paramWifiPOIInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dating.NearbyTransitActivity.2
 * JD-Core Version:    0.7.0.1
 */