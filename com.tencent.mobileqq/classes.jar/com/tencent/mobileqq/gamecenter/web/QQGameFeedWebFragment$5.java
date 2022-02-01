package com.tencent.mobileqq.gamecenter.web;

import android.text.TextUtils;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.OnGetPathListener;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.PathResult;
import com.tencent.qphone.base.util.QLog;

class QQGameFeedWebFragment$5
  implements IPreloadService.OnGetPathListener
{
  QQGameFeedWebFragment$5(QQGameFeedWebFragment paramQQGameFeedWebFragment) {}
  
  public void onResult(int paramInt, IPreloadService.PathResult paramPathResult)
  {
    if ((paramInt == 0) && (!TextUtils.isEmpty(paramPathResult.folderPath))) {
      QLog.d("GameWebPage", 1, "loading apng download succ!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.web.QQGameFeedWebFragment.5
 * JD-Core Version:    0.7.0.1
 */