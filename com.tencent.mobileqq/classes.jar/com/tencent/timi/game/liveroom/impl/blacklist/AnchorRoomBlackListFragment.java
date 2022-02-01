package com.tencent.timi.game.liveroom.impl.blacklist;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.QPublicFragmentActivityForTool;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.supervision.IQQLiveModuleKickOut;
import com.tencent.mobileqq.qqlive.callback.supervision.KickOutUserCallback;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataRoomInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataUserInfo;
import com.tencent.mobileqq.qqlive.data.user.LimitUserInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.timi.game.component.qqlive.api.ITgLiveRoomService;
import com.tencent.timi.game.datareport.api.ILiveReportService;
import com.tencent.timi.game.liveroom.impl.more.AnchorMoreSettingUtil;
import com.tencent.timi.game.liveroom.impl.more.AnchorRoomSettingFragment;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.ui.widget.CustomToastView;
import com.tencent.timi.game.utils.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class AnchorRoomBlackListFragment
  extends QPublicBaseFragment
  implements View.OnClickListener
{
  private View a;
  private View b;
  private RecyclerView c;
  private View d;
  private long e;
  private IQQLiveModuleKickOut f;
  private boolean g = false;
  private boolean h = false;
  private int i = 0;
  private List<LimitUserInfo> j = new ArrayList();
  private AnchorBlackListAdapter k;
  
  private void a()
  {
    if (this.h)
    {
      Logger.c("AnchorRoomBlackListFragment", "loadPageData - mIsPageEnd");
      return;
    }
    if (this.g)
    {
      Logger.c("AnchorRoomBlackListFragment", "loadPageData - mIsRequesting");
      return;
    }
    int m = this.j.size();
    this.g = true;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("loadPageData - start, startIndex = ");
    localStringBuilder.append(m);
    Logger.a("AnchorRoomBlackListFragment", localStringBuilder.toString());
    this.f.queryKickOutHistory(this.e, m, 100, new AnchorRoomBlackListFragment.3(this, m));
  }
  
  private void a(long paramLong, KickOutUserCallback paramKickOutUserCallback)
  {
    Object localObject = ((ITgLiveRoomService)ServiceCenter.a(ITgLiveRoomService.class)).d(this.e);
    if (localObject != null)
    {
      long l1 = ((QQLiveAnchorRoomInfo)localObject).userDta.getAnchorUid();
      long l2 = ((QQLiveAnchorRoomInfo)localObject).roomData.getRoomId();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("removeUserFromBlack - ");
      ((StringBuilder)localObject).append(l1);
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(l2);
      ((StringBuilder)localObject).append(", user_");
      ((StringBuilder)localObject).append(paramLong);
      Logger.a("AnchorRoomBlackListFragment", ((StringBuilder)localObject).toString());
      this.f.cancelKickOutUser(l1, l2, paramLong, new AnchorRoomBlackListFragment.4(this, paramKickOutUserCallback, paramLong));
      return;
    }
    CustomToastView.a("数据异常，请退出重试");
    if (paramKickOutUserCallback != null) {
      paramKickOutUserCallback.onFailed(-10000, "数据异常");
    }
  }
  
  public static void a(Context paramContext, long paramLong)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("roomId", paramLong);
    QPublicFragmentActivity.Launcher.a(paramContext, localIntent, QPublicFragmentActivityForTool.class, AnchorRoomBlackListFragment.class);
  }
  
  private void a(View paramView)
  {
    this.e = getActivity().getIntent().getLongExtra("roomId", 0L);
    paramView.findViewById(2131428339).setOnClickListener(this);
    this.a = paramView.findViewById(2131428350);
    this.b = paramView.findViewById(2131428321);
    this.c = ((RecyclerView)paramView.findViewById(2131428322));
    this.d = paramView.findViewById(2131428316);
    AnchorRoomSettingFragment.a(this.a, getActivity());
    ConcurrentHashMap localConcurrentHashMap = AnchorMoreSettingUtil.a(this.e);
    ((ILiveReportService)ServiceCenter.a(ILiveReportService.class)).a(this, paramView, "pg_qqlive_room_blacklist", localConcurrentHashMap);
  }
  
  private void a(List<LimitUserInfo> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        LimitUserInfo localLimitUserInfo1 = (LimitUserInfo)paramList.next();
        int n = 0;
        Iterator localIterator = this.j.iterator();
        LimitUserInfo localLimitUserInfo2;
        do
        {
          m = n;
          if (!localIterator.hasNext()) {
            break;
          }
          localLimitUserInfo2 = (LimitUserInfo)localIterator.next();
        } while (localLimitUserInfo1.uid != localLimitUserInfo2.uid);
        int m = 1;
        if (m == 0) {
          localArrayList.add(localLimitUserInfo1);
        }
      }
      this.j.addAll(localArrayList);
      this.k.fillList(this.j);
    }
  }
  
  private void b()
  {
    this.d.setVisibility(0);
    this.b.setVisibility(4);
  }
  
  private void c()
  {
    getActivity().finish();
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public void onActivityCreated(@Nullable Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    if (((ITgLiveRoomService)ServiceCenter.a(ITgLiveRoomService.class)).c(this.e) == null)
    {
      CustomToastView.a("数据异常，请退出重试");
      b();
      return;
    }
    paramBundle = new LinearLayoutManager(getActivity(), 1, false);
    this.c.setLayoutManager(paramBundle);
    this.c.addOnScrollListener(new AnchorRoomBlackListFragment.1(this));
    this.k = new AnchorBlackListAdapter(getActivity(), this.j);
    this.k.a(new AnchorRoomBlackListFragment.2(this));
    this.c.setAdapter(this.k);
    this.f = ((ITgLiveRoomService)ServiceCenter.a(ITgLiveRoomService.class)).d().getKickOutModule();
    a();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131428339) {
      c();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131629402, paramViewGroup, false);
    a(paramLayoutInflater);
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.blacklist.AnchorRoomBlackListFragment
 * JD-Core Version:    0.7.0.1
 */