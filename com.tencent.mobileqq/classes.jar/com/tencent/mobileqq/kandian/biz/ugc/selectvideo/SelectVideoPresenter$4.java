package com.tencent.mobileqq.kandian.biz.ugc.selectvideo;

import com.tencent.mobileqq.kandian.base.utils.AlbumUtils.LocalMediaInfo;
import com.tencent.mobileqq.kandian.base.video.compress.VideoCompressConfig;

class SelectVideoPresenter$4
  implements ConditionChecker.ConditionCallback<AlbumUtils.LocalMediaInfo>
{
  SelectVideoPresenter$4(SelectVideoPresenter paramSelectVideoPresenter) {}
  
  public boolean a(AlbumUtils.LocalMediaInfo paramLocalMediaInfo)
  {
    return paramLocalMediaInfo.f <= VideoCompressConfig.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.selectvideo.SelectVideoPresenter.4
 * JD-Core Version:    0.7.0.1
 */