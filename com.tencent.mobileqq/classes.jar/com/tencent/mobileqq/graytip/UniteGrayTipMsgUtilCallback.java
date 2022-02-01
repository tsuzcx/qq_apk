package com.tencent.mobileqq.graytip;

import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;

public class UniteGrayTipMsgUtilCallback
  implements UniteGrayTipMsgUtil.Callback
{
  public void a()
  {
    Object localObject = BaseActivity.sTopActivity;
    if ((localObject != null) && ((localObject instanceof BaseActivity)))
    {
      localObject = ((BaseActivity)localObject).getChatFragment();
      if (localObject != null) {
        ((ChatFragment)localObject).k().j(131072);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.graytip.UniteGrayTipMsgUtilCallback
 * JD-Core Version:    0.7.0.1
 */