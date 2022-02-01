package com.tencent.mobileqq.onlinestatus.view;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.onlinestatus.BaseOnlineStatusDisplayInfo;
import com.tencent.mobileqq.onlinestatus.BaseOnlineStatusDisplayInfo.UpdateUIListener;
import com.tencent.mobileqq.onlinestatus.OnlineStatusExtInfoServlet;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionChecker.OnlineStatusPermissionItem;
import com.tencent.mobileqq.onlinestatus.OnlineStatusUtil;
import com.tencent.mobileqq.onlinestatus.ReportHelperKt;
import com.tencent.mobileqq.onlinestatus.constellation.ConstellationLauncher;
import com.tencent.mobileqq.onlinestatus.constellation.ExtensionBizInfoHelper;
import com.tencent.mobileqq.onlinestatus.constellation.StatusExtInfoObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.IProfileCardUtil;
import kotlin.Pair;
import mqq.app.AppRuntime;

public class OnlineStatusConstellationDisplayInfo
  extends BaseOnlineStatusDisplayInfo
{
  StatusExtInfoObserver k = new OnlineStatusConstellationDisplayInfo.1(this);
  private String l = "";
  private String m = "";
  
  public OnlineStatusConstellationDisplayInfo(long paramLong, BaseOnlineStatusDisplayInfo.UpdateUIListener paramUpdateUIListener, AppInterface paramAppInterface, QBaseActivity paramQBaseActivity)
  {
    super(paramLong, paramUpdateUIListener, paramAppInterface, paramQBaseActivity);
    paramAppInterface.registObserver(this.k);
    this.l = OnlineStatusUtil.b(((IProfileCardUtil)QRoute.api(IProfileCardUtil.class)).initCard(paramAppInterface, paramAppInterface.getCurrentAccountUin()).constellation);
  }
  
  protected void a()
  {
    this.a = this.h.getString(2131896427);
    this.d = false;
    this.e = this.h.getString(2131896414);
    if (!TextUtils.isEmpty(this.m))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.l);
      localStringBuilder.append(" | ");
      localStringBuilder.append(this.m);
      this.b = localStringBuilder.toString();
      return;
    }
    this.b = this.l;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    this.l = ((String)ConstellationViewKt.a(this.i, paramIntent, this.l).getSecond());
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      OnlineStatusExtInfoServlet.a(this.i, this.l);
    }
  }
  
  public void a(boolean paramBoolean, OnlineStatusPermissionChecker.OnlineStatusPermissionItem paramOnlineStatusPermissionItem)
  {
    ExtensionBizInfoHelper.a.a(this.i, 1040);
  }
  
  public void b()
  {
    Friends localFriends = ((IFriendDataService)this.i.getRuntimeService(IFriendDataService.class, "")).getFriend(this.i.getCurrentUin(), true, true, true);
    ConstellationLauncher.c.a(this.h, localFriends.constellationJumpUrl, 4015);
    ReportHelperKt.a("0X800AF4D");
  }
  
  public void d()
  {
    ConstellationLauncher.c.a(this.h, "VAL_FROM_STATUS_SETTING");
    ReportHelperKt.a("0X800AF97");
  }
  
  public void f()
  {
    super.f();
    this.i.unRegistObserver(this.k);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.view.OnlineStatusConstellationDisplayInfo
 * JD-Core Version:    0.7.0.1
 */