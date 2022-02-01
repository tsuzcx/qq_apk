package com.tencent.timi.game.liveroom.impl;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.timi.game.api.live.LiveRoomExtraInfo;
import org.jetbrains.annotations.NotNull;

public class TimiAudienceFragment
  extends QPublicBaseFragment
{
  private TimiAudienceView a;
  private long b;
  
  public void onCreate(@androidx.annotation.Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getArguments();
    if (paramBundle != null) {
      this.b = paramBundle.getLong("roomId", 0L);
    }
  }
  
  @androidx.annotation.Nullable
  @org.jetbrains.annotations.Nullable
  public View onCreateView(@NonNull @NotNull LayoutInflater paramLayoutInflater, @androidx.annotation.Nullable @org.jetbrains.annotations.Nullable ViewGroup paramViewGroup, @androidx.annotation.Nullable @org.jetbrains.annotations.Nullable Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131629438, paramViewGroup, false);
    this.a = ((TimiAudienceView)paramLayoutInflater);
    this.a.setAutoPlay(true);
    this.a.setLiveViewListener(new TimiAudienceFragment.1(this));
    this.a.a(this.b, "");
    this.a.a(getContext(), this.b, new LiveRoomExtraInfo());
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    this.a.a(this.b, true, true);
  }
  
  public void onStart()
  {
    super.onStart();
    this.a.c();
  }
  
  public void onStop()
  {
    super.onStop();
    this.a.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.TimiAudienceFragment
 * JD-Core Version:    0.7.0.1
 */