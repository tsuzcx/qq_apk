package com.tencent.mobileqq.nearby.now.view.viewmodel.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.nearby.now.NowSmallVideoObserver;

class PlayOperationViewModelImpl$16
  extends NowSmallVideoObserver
{
  PlayOperationViewModelImpl$16(PlayOperationViewModelImpl paramPlayOperationViewModelImpl) {}
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(PlayOperationViewModelImpl.access$1000(this.a));
      localStringBuilder.append("");
      if (paramString.equals(localStringBuilder.toString())) {
        this.a.setFollow(paramBoolean);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.viewmodel.impl.PlayOperationViewModelImpl.16
 * JD-Core Version:    0.7.0.1
 */