package com.tencent.mobileqq.kandian.biz.ugc.selectvideo;

import com.tencent.mobileqq.kandian.base.utils.AlbumUtils;
import com.tencent.mobileqq.kandian.biz.ugc.PageLoadManager.QueryProvider;
import com.tencent.qav.thread.ThreadManager;
import java.util.List;

class SelectVideoPresenter$5
  implements PageLoadManager.QueryProvider
{
  SelectVideoPresenter$5(SelectVideoPresenter paramSelectVideoPresenter) {}
  
  public List a(int paramInt1, int paramInt2)
  {
    return AlbumUtils.a(paramInt1, paramInt2);
  }
  
  public void a(List paramList, boolean paramBoolean)
  {
    SelectVideoPresenter.a(this.a).a(paramList, paramBoolean);
    ThreadManager.c(new SelectVideoPresenter.5.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.selectvideo.SelectVideoPresenter.5
 * JD-Core Version:    0.7.0.1
 */