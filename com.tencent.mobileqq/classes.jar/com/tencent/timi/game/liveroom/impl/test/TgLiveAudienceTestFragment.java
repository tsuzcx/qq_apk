package com.tencent.timi.game.liveroom.impl.test;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qqlive.api.room.ITPPlayerVideoView;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.timi.game.component.qqlive.api.ITgLiveRoomService;
import com.tencent.timi.game.router.ServiceCenter;

public class TgLiveAudienceTestFragment
  extends QPublicBaseFragment
{
  private void a(View paramView)
  {
    paramView.findViewById(2131447294).setOnClickListener(new TgLiveAudienceTestFragment.1(this));
    paramView = (FrameLayout)paramView.findViewById(2131447293);
    ITPPlayerVideoView localITPPlayerVideoView = ((ITgLiveRoomService)ServiceCenter.a(ITgLiveRoomService.class)).b();
    if ((localITPPlayerVideoView != null) && (localITPPlayerVideoView.getCurrentDisplayView() != null)) {
      paramView.addView(localITPPlayerVideoView.getCurrentDisplayView(), new FrameLayout.LayoutParams(-1, -1));
    }
  }
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131629501, paramViewGroup, false);
    a(paramLayoutInflater);
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.test.TgLiveAudienceTestFragment
 * JD-Core Version:    0.7.0.1
 */