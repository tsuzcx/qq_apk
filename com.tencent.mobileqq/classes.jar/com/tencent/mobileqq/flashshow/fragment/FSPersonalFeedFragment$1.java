package com.tencent.mobileqq.flashshow.fragment;

import com.tencent.biz.richframework.part.block.MultiViewBlock.OnLoadDataDelegate;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.mobileqq.flashshow.personal.adapter.FSPersonalFeedAdapter;
import com.tencent.mobileqq.flashshow.personal.viewmodel.FSPersonalViewModel;

class FSPersonalFeedFragment$1
  implements MultiViewBlock.OnLoadDataDelegate<FSPersonalFeedAdapter>
{
  FSPersonalFeedFragment$1(FSPersonalFeedFragment paramFSPersonalFeedFragment) {}
  
  public void a(LoadInfo paramLoadInfo, FSPersonalFeedAdapter paramFSPersonalFeedAdapter)
  {
    if (paramLoadInfo.e()) {
      FSPersonalFeedFragment.b(this.a).a(FSPersonalFeedFragment.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.fragment.FSPersonalFeedFragment.1
 * JD-Core Version:    0.7.0.1
 */