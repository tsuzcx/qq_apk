package com.tencent.mobileqq.kandian.biz.ugc.selectvideo;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.base.utils.AlbumUtils.LocalMediaInfo;

class SelectVideoPresenter$1
  implements ConditionChecker.ConditionCallback<AlbumUtils.LocalMediaInfo>
{
  SelectVideoPresenter$1(SelectVideoPresenter paramSelectVideoPresenter) {}
  
  public boolean a(AlbumUtils.LocalMediaInfo paramLocalMediaInfo)
  {
    return TextUtils.equals("video/mp4", paramLocalMediaInfo.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.selectvideo.SelectVideoPresenter.1
 * JD-Core Version:    0.7.0.1
 */