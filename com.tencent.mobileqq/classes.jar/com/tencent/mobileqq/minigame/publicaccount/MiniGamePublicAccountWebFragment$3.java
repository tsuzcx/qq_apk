package com.tencent.mobileqq.minigame.publicaccount;

import android.text.TextUtils;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.OnGetPathListener;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.PathResult;
import com.tencent.qphone.base.util.QLog;

class MiniGamePublicAccountWebFragment$3
  implements IPreloadService.OnGetPathListener
{
  MiniGamePublicAccountWebFragment$3(MiniGamePublicAccountWebFragment paramMiniGamePublicAccountWebFragment) {}
  
  public void onResult(int paramInt, IPreloadService.PathResult paramPathResult)
  {
    if ((paramInt == 0) && (!TextUtils.isEmpty(paramPathResult.folderPath))) {
      QLog.d("MiniGamePublicAccountWebFragment", 1, "loading apng download succ!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.publicaccount.MiniGamePublicAccountWebFragment.3
 * JD-Core Version:    0.7.0.1
 */