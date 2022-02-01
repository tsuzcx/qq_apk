package com.tencent.mobileqq.flashshow.fragment;

import com.tencent.biz.richframework.part.block.MultiViewBlock.OnLoadDataDelegate;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.mobileqq.flashshow.personal.adapter.FSPersonalInfoBlock;
import com.tencent.mobileqq.flashshow.personal.viewmodel.FSPersonalViewModel;

class FSPersonalHomeFragment$4
  implements MultiViewBlock.OnLoadDataDelegate<FSPersonalInfoBlock>
{
  FSPersonalHomeFragment$4(FSPersonalHomeFragment paramFSPersonalHomeFragment) {}
  
  public void a(LoadInfo paramLoadInfo, FSPersonalInfoBlock paramFSPersonalInfoBlock)
  {
    if ((paramLoadInfo.d()) && (FSPersonalHomeFragment.c(this.a) != null)) {
      FSPersonalHomeFragment.c(this.a).a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.fragment.FSPersonalHomeFragment.4
 * JD-Core Version:    0.7.0.1
 */