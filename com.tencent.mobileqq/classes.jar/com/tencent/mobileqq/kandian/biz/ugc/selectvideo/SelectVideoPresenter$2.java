package com.tencent.mobileqq.kandian.biz.ugc.selectvideo;

import com.tencent.mobileqq.kandian.base.utils.AlbumUtils.LocalMediaInfo;

class SelectVideoPresenter$2
  implements ConditionChecker.ConditionCallback<AlbumUtils.LocalMediaInfo>
{
  SelectVideoPresenter$2(SelectVideoPresenter paramSelectVideoPresenter) {}
  
  public boolean a(AlbumUtils.LocalMediaInfo paramLocalMediaInfo)
  {
    return paramLocalMediaInfo.j >= 5000L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.selectvideo.SelectVideoPresenter.2
 * JD-Core Version:    0.7.0.1
 */