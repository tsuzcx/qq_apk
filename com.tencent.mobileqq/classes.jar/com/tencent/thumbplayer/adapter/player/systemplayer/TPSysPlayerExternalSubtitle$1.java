package com.tencent.thumbplayer.adapter.player.systemplayer;

import com.tencent.thumbplayer.core.subtitle.ITPSubtitleParserCallback;
import com.tencent.thumbplayer.utils.TPLogUtil;

class TPSysPlayerExternalSubtitle$1
  implements ITPSubtitleParserCallback
{
  TPSysPlayerExternalSubtitle$1(TPSysPlayerExternalSubtitle paramTPSysPlayerExternalSubtitle) {}
  
  public void onLoadResult(int paramInt)
  {
    TPLogUtil.i("TPSysPlayerExternalSubtitle", "onLoadResult, index:" + paramInt);
  }
  
  public void onSelectResult(int paramInt, long paramLong)
  {
    TPLogUtil.i("TPSysPlayerExternalSubtitle", "onSelectResult, index:" + paramInt + ", long:" + paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.player.systemplayer.TPSysPlayerExternalSubtitle.1
 * JD-Core Version:    0.7.0.1
 */