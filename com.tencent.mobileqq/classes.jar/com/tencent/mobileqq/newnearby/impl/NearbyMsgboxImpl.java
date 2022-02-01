package com.tencent.mobileqq.newnearby.impl;

import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.ProtoUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.recent.RecentDefaultItemBuilder.RecentItemDefaultHolder;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.dating.BaseMsgBoxActivity;
import com.tencent.mobileqq.dating.MsgBoxListActivity;
import com.tencent.mobileqq.newnearby.INearbyMsgbox;
import com.tencent.mobileqq.newnearby.INearbyReportHelper;
import com.tencent.mobileqq.newnearby.util.NearbyStatusBarHelper;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.observer.RedpointObserver;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.TabLayoutCompat;
import com.tencent.mobileqq.widget.TabLayoutCompat.Tab;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.nowsummarycard.NowSummaryCard.MiniCard;
import com.tencent.nowsummarycard.NowSummaryCard.NearbyMiniCardReq;
import com.tencent.nowsummarycard.NowSummaryCard.NearbyMiniCardRsp;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.ArrayList;
import java.util.List;

public class NearbyMsgboxImpl
  implements INearbyMsgbox
{
  private static final String TAG = "NearbyMsgbox";
  private static boolean isNewVersion;
  
  private void checkNightMode(MsgBoxListActivity paramMsgBoxListActivity)
  {
    if (!ThemeUtil.isNowThemeIsNight(null, false, null)) {
      return;
    }
    paramMsgBoxListActivity = paramMsgBoxListActivity.getWindow().getDecorView();
    if (Build.VERSION.SDK_INT >= 23) {
      paramMsgBoxListActivity.setForeground(new ColorDrawable(1996488704));
    }
  }
  
  private void setMsgBoxItem(View paramView, RecentDefaultItemBuilder.RecentItemDefaultHolder paramRecentItemDefaultHolder, NowSummaryCard.NearbyMiniCardRsp paramNearbyMiniCardRsp)
  {
    if (paramRecentItemDefaultHolder == null) {
      return;
    }
    if (paramNearbyMiniCardRsp.mini_card != null)
    {
      if (paramNearbyMiniCardRsp.mini_card.isEmpty()) {
        return;
      }
      paramNearbyMiniCardRsp = (NowSummaryCard.MiniCard)paramNearbyMiniCardRsp.mini_card.get(0);
      if (paramNearbyMiniCardRsp == null) {
        return;
      }
      Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (paramRecentItemDefaultHolder.j != null) {
        if (paramNearbyMiniCardRsp.is_online.get()) {
          paramRecentItemDefaultHolder.j.setVisibility(0);
        } else {
          paramRecentItemDefaultHolder.j.setVisibility(8);
        }
      }
      int i;
      if (paramRecentItemDefaultHolder.k != null)
      {
        if (paramNearbyMiniCardRsp.is_greet.get())
        {
          paramRecentItemDefaultHolder.k.setVisibility(0);
          ((INearbyReportHelper)QRoute.api(INearbyReportHelper.class)).reportMsgListItemExp((AppInterface)localObject, "1", String.valueOf(paramNearbyMiniCardRsp.target_id.get()));
          i = 1;
        }
        else
        {
          paramRecentItemDefaultHolder.k.setVisibility(8);
        }
      }
      else {
        i = 0;
      }
      int j = i;
      if (paramRecentItemDefaultHolder.l != null) {
        if (paramNearbyMiniCardRsp.is_match.get())
        {
          ((INearbyReportHelper)QRoute.api(INearbyReportHelper.class)).reportMsgListItemExp((AppInterface)localObject, "2", String.valueOf(paramNearbyMiniCardRsp.target_id.get()));
          paramRecentItemDefaultHolder.l.setVisibility(0);
          j = i + 1;
        }
        else
        {
          paramRecentItemDefaultHolder.l.setVisibility(8);
          j = i;
        }
      }
      if ((!paramNearbyMiniCardRsp.is_greet.get()) && (!paramNearbyMiniCardRsp.is_match.get())) {
        ((INearbyReportHelper)QRoute.api(INearbyReportHelper.class)).reportMsgListItemExp((AppInterface)localObject, "0", String.valueOf(paramNearbyMiniCardRsp.target_id.get()));
      }
      if (paramNearbyMiniCardRsp.nick.get() == null) {
        return;
      }
      localObject = paramNearbyMiniCardRsp.nick.get();
      if ((j == 1) && (((String)localObject).length() > 6))
      {
        paramNearbyMiniCardRsp = new StringBuilder();
        paramNearbyMiniCardRsp.append(((String)localObject).substring(0, 6));
        paramNearbyMiniCardRsp.append("...");
        paramNearbyMiniCardRsp = paramNearbyMiniCardRsp.toString();
      }
      else
      {
        paramNearbyMiniCardRsp = (NowSummaryCard.NearbyMiniCardRsp)localObject;
        if (j == 2)
        {
          paramNearbyMiniCardRsp = (NowSummaryCard.NearbyMiniCardRsp)localObject;
          if (((String)localObject).length() > 3)
          {
            paramNearbyMiniCardRsp = new StringBuilder();
            paramNearbyMiniCardRsp.append(((String)localObject).substring(0, 3));
            paramNearbyMiniCardRsp.append("...");
            paramNearbyMiniCardRsp = paramNearbyMiniCardRsp.toString();
          }
        }
      }
      if (paramRecentItemDefaultHolder.e != null) {
        paramRecentItemDefaultHolder.e.setText(paramNearbyMiniCardRsp);
      }
      if (ThemeUtil.isNowThemeIsNight(null, false, null))
      {
        if (paramRecentItemDefaultHolder.e != null) {
          paramRecentItemDefaultHolder.e.setTextColor(-16777216);
        }
        paramView = (RelativeLayout)paramView.findViewById(2131444600);
        if ((Build.VERSION.SDK_INT >= 16) && (paramView != null))
        {
          paramView.setBackground(null);
          paramView.setBackgroundColor(-1);
        }
      }
    }
  }
  
  public void initQQNearbyTabs(QBaseActivity paramQBaseActivity, TabLayoutCompat paramTabLayoutCompat, RedpointObserver paramRedpointObserver, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if ((paramQBaseActivity instanceof BaseMsgBoxActivity))
    {
      paramQBaseActivity = (BaseMsgBoxActivity)paramQBaseActivity;
      paramTabLayoutCompat.b(paramInt1).f();
      paramTabLayoutCompat.a(new NearbyMsgboxImpl.1(this, paramInt1, paramBoolean, paramInt2, paramQBaseActivity));
      paramTabLayoutCompat.setVisibility(0);
      paramQBaseActivity.app.addObserver(paramRedpointObserver);
      ((INearbyReportHelper)QRoute.api(INearbyReportHelper.class)).reportMsgListExp(paramQBaseActivity.app);
    }
  }
  
  public void initStatusBar(QBaseActivity paramQBaseActivity)
  {
    if ((paramQBaseActivity instanceof BaseMsgBoxActivity))
    {
      NearbyStatusBarHelper.c((BaseMsgBoxActivity)paramQBaseActivity);
      if (paramQBaseActivity.mSystemBarComp == null) {
        paramQBaseActivity.mSystemBarComp = new SystemBarCompact(paramQBaseActivity, true, -1);
      }
      paramQBaseActivity.mSystemBarComp.setStatusDrawable(paramQBaseActivity.getResources().getDrawable(1946288130));
    }
  }
  
  public void initTitleBar(QBaseActivity paramQBaseActivity)
  {
    if ((paramQBaseActivity instanceof MsgBoxListActivity))
    {
      paramQBaseActivity = (MsgBoxListActivity)paramQBaseActivity;
      Object localObject = paramQBaseActivity.centerView;
      ViewGroup.LayoutParams localLayoutParams = ((TextView)localObject).getLayoutParams();
      localLayoutParams.width = 150;
      localLayoutParams.height = 90;
      ((TextView)localObject).setLayoutParams(localLayoutParams);
      ((TextView)localObject).setBackgroundResource(1946550273);
      paramQBaseActivity.setRightButton(1946615840, new NearbyMsgboxImpl.2(this, paramQBaseActivity));
      paramQBaseActivity.rightViewText.setBackgroundDrawable(null);
      paramQBaseActivity.rightViewText.setBackgroundColor(paramQBaseActivity.getResources().getColor(1946288129));
      localObject = paramQBaseActivity.getTitleBarView();
      if ((localObject instanceof NavBarCommon))
      {
        localObject = (NavBarCommon)localObject;
        ((NavBarCommon)localObject).changeBg(true);
        ((NavBarCommon)localObject).getLeftBackIcon().setText("");
      }
      checkNightMode(paramQBaseActivity);
    }
  }
  
  public boolean isNewNearby()
  {
    return isNewVersion;
  }
  
  public void setNearbyVersion(boolean paramBoolean)
  {
    isNewVersion = paramBoolean;
  }
  
  public void updateMsgBoxItemView(View paramView, Object paramObject, long paramLong)
  {
    if (!isNewVersion) {
      return;
    }
    Object localObject = QBaseActivity.sTopActivity;
    if ((localObject instanceof MsgBoxListActivity))
    {
      localObject = (MsgBoxListActivity)localObject;
      if ((paramObject instanceof RecentDefaultItemBuilder.RecentItemDefaultHolder))
      {
        paramObject = (RecentDefaultItemBuilder.RecentItemDefaultHolder)paramObject;
        NowSummaryCard.NearbyMiniCardReq localNearbyMiniCardReq = new NowSummaryCard.NearbyMiniCardReq();
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(Long.valueOf(paramLong));
        localNearbyMiniCardReq.target_id.set(localArrayList);
        localNearbyMiniCardReq.id_type.set(0);
        ProtoUtils.a(((MsgBoxListActivity)localObject).app, new NearbyMsgboxImpl.3(this, paramView, paramObject), localNearbyMiniCardReq.toByteArray(), "NowSummaryCard.NearbyMiniCardReq");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.newnearby.impl.NearbyMsgboxImpl
 * JD-Core Version:    0.7.0.1
 */