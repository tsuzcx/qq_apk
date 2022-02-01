package com.tencent.mobileqq.kandian.biz.video.api.impl;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.open.downloadnew.DownloadManager;

final class VideoFeedsWeiShiUtils$2
  implements DialogInterface.OnClickListener
{
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    DownloadManager.b().a(VideoFeedsWeiShiUtils.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.api.impl.VideoFeedsWeiShiUtils.2
 * JD-Core Version:    0.7.0.1
 */