package com.tencent.mobileqq.nearby.now;

import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.nearby.now.view.CommentsView;
import com.tencent.mobileqq.nearby.now.view.CustomViewPager;
import com.tencent.mobileqq.nearby.now.view.IShortVideoCommentsView;
import com.tencent.mobileqq.nearby.now.view.StuffContainerView;
import com.tencent.mobileqq.nearby.now.view.StuffContainerView.OnCloseListener;
import com.tencent.mobileqq.nearby.now.view.VideoPlayerPagerAdapter;
import com.tencent.qphone.base.util.QLog;

class SmallVideoFragment$1
  implements StuffContainerView.OnCloseListener
{
  SmallVideoFragment$1(SmallVideoFragment paramSmallVideoFragment) {}
  
  public void a(int paramInt)
  {
    if (this.a.a.getCurrentVideoData() != null) {
      localObject = this.a.a.getCurrentVideoData().c;
    } else {
      localObject = "0";
    }
    long l;
    if (this.a.a.getCurrentVideoData() != null) {
      l = this.a.a.getCurrentVideoData().i;
    } else {
      l = 0L;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onClickClose report module=short_video, action=view_click, obj1=6, res2=");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(", anchor=");
      localStringBuilder.append(l);
      QLog.i("Native_ShortVideo_Report", 2, localStringBuilder.toString());
    }
    Object localObject = (VideoPlayerPagerAdapter)this.a.d.getAdapter();
    if ((((VideoPlayerPagerAdapter)localObject).d(this.a.d.getCurrentItem()) instanceof IShortVideoCommentsView)) {
      ((CommentsView)((VideoPlayerPagerAdapter)localObject).d(this.a.d.getCurrentItem())).hideInputKeyboard();
    }
    this.a.h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.SmallVideoFragment.1
 * JD-Core Version:    0.7.0.1
 */