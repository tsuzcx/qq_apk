package com.tencent.timi.game.liveroom.impl;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorRoom;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataRoomInfo;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.timi.game.component.qqlive.api.ITgLiveRoomService;
import com.tencent.timi.game.datareport.api.ILiveReportService;
import com.tencent.timi.game.liveroom.impl.report.TGReportUtil;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.utils.Logger;

public class TimiAnchorFragment
  extends QPublicBaseFragment
{
  private TimiAnchorView a;
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean onBackEvent()
  {
    if (this.a.a()) {
      return true;
    }
    return super.onBackEvent();
  }
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131629436, paramViewGroup, false);
    this.a = ((TimiAnchorView)paramLayoutInflater);
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    this.a.b();
    super.onDestroyView();
  }
  
  public void onViewCreated(@NonNull View paramView, @Nullable Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    Logger.a("TGLiveAnchorFloatingView", "TimiAnchorFragment onViewCreated");
    ((ILiveReportService)ServiceCenter.a(ILiveReportService.class)).a(this, paramView, "pg_qqlive_anchorlive", TGReportUtil.a.a());
    paramView = ((ITgLiveRoomService)ServiceCenter.a(ITgLiveRoomService.class)).c(0L);
    this.a.setArgument(getArguments());
    if ((paramView != null) && (paramView.getAnchorRoomInfo() != null) && (paramView.getAnchorRoomInfo().roomData != null)) {
      this.a.a(paramView.getAnchorRoomInfo().roomData.id, paramView.getAnchorRoomInfo().uid);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.TimiAnchorFragment
 * JD-Core Version:    0.7.0.1
 */