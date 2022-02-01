package com.tencent.mobileqq.qqgamepub.fragment;

import android.text.TextUtils;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.OnGetPathListener;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.PathResult;
import com.tencent.qphone.base.util.QLog;

class QQGameFeedWebFragment$2
  implements IPreloadService.OnGetPathListener
{
  QQGameFeedWebFragment$2(QQGameFeedWebFragment paramQQGameFeedWebFragment) {}
  
  public void onResult(int paramInt, IPreloadService.PathResult paramPathResult)
  {
    if ((paramInt == 0) && (!TextUtils.isEmpty(paramPathResult.folderPath))) {
      QLog.d("QQGamePub_GameWebPage", 1, "loading apng download succ!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.fragment.QQGameFeedWebFragment.2
 * JD-Core Version:    0.7.0.1
 */