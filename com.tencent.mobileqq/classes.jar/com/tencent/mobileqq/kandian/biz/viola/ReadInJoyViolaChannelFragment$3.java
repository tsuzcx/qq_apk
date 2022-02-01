package com.tencent.mobileqq.kandian.biz.viola;

import android.app.Activity;
import android.os.Handler;
import com.tencent.mobileqq.kandian.biz.viola.api.IViolaBaseView.ViolaViewListener;
import com.tencent.mobileqq.kandian.biz.viola.contract.ViolaFragmentCommonLogicContract;
import com.tencent.mobileqq.kandian.biz.xtab.api.impl.RIJXTabFrameUtils;
import com.tencent.mobileqq.kandian.glue.viola.delegate.ViolaUiDelegate;
import com.tencent.mobileqq.kandian.glue.viola.view.ViolaBaseView;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.ChannelModeConfigHandler;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.qphone.base.util.QLog;

class ReadInJoyViolaChannelFragment$3
  implements IViolaBaseView.ViolaViewListener
{
  ReadInJoyViolaChannelFragment$3(ReadInJoyViolaChannelFragment paramReadInJoyViolaChannelFragment) {}
  
  public void a()
  {
    if (this.a.v() != null) {
      new Handler(this.a.v().getMainLooper()).postDelayed(new ReadInJoyViolaChannelFragment.3.1(this), 200L);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyViolaChannelFragment", 2, "initViola success!");
    }
    if ((this.a.m != null) && (this.a.m.b()) && (this.a.e()) && (RIJXTabFrameUtils.INSTANCE.isNowInKanDianTab())) {
      this.a.m.a(true);
    }
  }
  
  public void a(int paramInt)
  {
    ReadInJoyViolaChannelFragment.b(this.a);
    ReadInJoyViolaChannelFragment.a(this.a).f();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initViola error,error code=");
      localStringBuilder.append(paramInt);
      QLog.e("ReadInJoyViolaChannelFragment", 2, localStringBuilder.toString());
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean) {}
  
  public void a(String paramString, int paramInt)
  {
    if ((1 == paramInt) && (ChannelModeConfigHandler.a())) {
      ReadInJoyLogicEngineEventDispatcher.a().k();
    }
    if (ReadInJoyViolaChannelFragment.d(this.a) != null) {
      ReadInJoyViolaChannelFragment.d(this.a).a(paramInt);
    }
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initViola process,process code=");
      localStringBuilder.append(paramInt);
      QLog.d("ReadInJoyViolaChannelFragment", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.viola.ReadInJoyViolaChannelFragment.3
 * JD-Core Version:    0.7.0.1
 */