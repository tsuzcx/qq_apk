package com.tencent.mobileqq.utils;

import com.tencent.biz.qqstory.network.request.StoryShareTranslateTokenRequest.StoryShareTranslateTokenResponse;
import com.tencent.biz.qqstory.newshare.util.StoryShareEncryptHelper;
import com.tencent.biz.qqstory.newshare.util.StoryShareEncryptHelper.DecryptCallback;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;

class JumpActionLegacy$5
  implements StoryShareEncryptHelper.DecryptCallback
{
  JumpActionLegacy$5(JumpActionLegacy paramJumpActionLegacy) {}
  
  public void a(StoryShareTranslateTokenRequest.StoryShareTranslateTokenResponse paramStoryShareTranslateTokenResponse, QQProgressDialog paramQQProgressDialog)
  {
    if ((paramQQProgressDialog != null) && (paramQQProgressDialog.isShowing())) {
      paramQQProgressDialog.dismiss();
    }
    StoryShareEncryptHelper.a(this.a.f);
    if ((paramStoryShareTranslateTokenResponse != null) && (paramStoryShareTranslateTokenResponse.c == 0))
    {
      StoryShareEncryptHelper.a(paramStoryShareTranslateTokenResponse.a, this.a.f);
      JumpActionLegacy.d(this.a);
      return;
    }
    if (!NetworkUtil.isNetworkAvailable(BaseApplicationImpl.getContext()))
    {
      QQToast.makeText(BaseApplicationImpl.getApplication(), 1, 2131892105, 1).show();
      return;
    }
    paramStoryShareTranslateTokenResponse = this.a;
    paramStoryShareTranslateTokenResponse.e = "open";
    JumpActionLegacy.d(paramStoryShareTranslateTokenResponse);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.JumpActionLegacy.5
 * JD-Core Version:    0.7.0.1
 */