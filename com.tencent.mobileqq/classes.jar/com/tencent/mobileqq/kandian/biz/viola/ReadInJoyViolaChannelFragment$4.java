package com.tencent.mobileqq.kandian.biz.viola;

import android.app.Activity;
import android.os.Handler;
import com.tencent.mobileqq.kandian.biz.viola.api.IViolaBaseView.ViolaViewListener;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.ChannelModeConfigHandler;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.qphone.base.util.QLog;

class ReadInJoyViolaChannelFragment$4
  implements IViolaBaseView.ViolaViewListener
{
  ReadInJoyViolaChannelFragment$4(ReadInJoyViolaChannelFragment paramReadInJoyViolaChannelFragment) {}
  
  public void a()
  {
    if (this.a.a() != null) {
      new Handler(this.a.a().getMainLooper()).postDelayed(new ReadInJoyViolaChannelFragment.4.2(this), 200L);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyViolaChannelFragment", 2, "reloadPage success!");
    }
  }
  
  public void a(int paramInt)
  {
    if (this.a.a() != null) {
      new Handler(this.a.a().getMainLooper()).postDelayed(new ReadInJoyViolaChannelFragment.4.1(this), 1000L);
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reloadPage error,error code=");
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
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reloadPage process,process code=");
      localStringBuilder.append(paramInt);
      QLog.d("ReadInJoyViolaChannelFragment", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.viola.ReadInJoyViolaChannelFragment.4
 * JD-Core Version:    0.7.0.1
 */