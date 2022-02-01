package com.tencent.mobileqq.kandian.glue.businesshandler.engine;

import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;

class KandianMergeManager$36
  extends AvatarObserver
{
  KandianMergeManager$36(KandianMergeManager paramKandianMergeManager) {}
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (TextUtils.equals(KandianMergeManager.m(this.a), paramString)) && (!TextUtils.equals(paramString, AppConstants.KANDIAN_MERGE_UIN))) {
      KandianMergeManager.c(this.a).getBusinessHandler(BusinessHandlerFactory.AVATAR_HANDLER).notifyUI(1, true, new Object[] { AppConstants.KANDIAN_MERGE_UIN });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager.36
 * JD-Core Version:    0.7.0.1
 */