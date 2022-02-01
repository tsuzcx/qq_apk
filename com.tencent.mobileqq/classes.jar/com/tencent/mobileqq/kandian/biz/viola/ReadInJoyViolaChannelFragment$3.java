package com.tencent.mobileqq.kandian.biz.viola;

import android.app.Activity;
import android.os.Handler;
import com.tencent.mobileqq.kandian.biz.common.RIJXTabFrameUtils;
import com.tencent.mobileqq.kandian.biz.viola.api.IViolaBaseView.ViolaViewListener;
import com.tencent.mobileqq.kandian.biz.viola.contract.ViolaFragmentCommonLogicContract;
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
    if (this.a.a() != null) {
      new Handler(this.a.a().getMainLooper()).postDelayed(new ReadInJoyViolaChannelFragment.3.1(this), 200L);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyViolaChannelFragment", 2, "initViola success!");
    }
    if ((this.a.a != null) && (this.a.a.b()) && (this.a.b()) && (RIJXTabFrameUtils.INSTANCE.isNowInKanDianTab())) {
      this.a.a.a(true);
    }
  }
  
  public void a(int paramInt)
  {
    ReadInJoyViolaChannelFragment.a(this.a);
    ReadInJoyViolaChannelFragment.a(this.a).b();
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
    if (ReadInJoyViolaChannelFragment.a(this.a) != null) {
      ReadInJoyViolaChannelFragment.a(this.a).a(paramInt);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.viola.ReadInJoyViolaChannelFragment.3
 * JD-Core Version:    0.7.0.1
 */