package com.tencent.mobileqq.qqlive.prepare;

import androidx.lifecycle.Observer;
import com.tencent.mobileqq.qqlive.data.CoverInfo;

final class QQLiveGamePrepareViewBinderHelper$2
  implements Observer<CoverInfo>
{
  QQLiveGamePrepareViewBinderHelper$2(IQQLivePrepareView paramIQQLivePrepareView) {}
  
  public void a(CoverInfo paramCoverInfo)
  {
    if (paramCoverInfo != null) {
      paramCoverInfo = paramCoverInfo.roomLogo16v9;
    } else {
      paramCoverInfo = "";
    }
    this.a.a(paramCoverInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.prepare.QQLiveGamePrepareViewBinderHelper.2
 * JD-Core Version:    0.7.0.1
 */