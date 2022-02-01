package com.tencent.mobileqq.extendfriend.limitchat.limitchatstatehandler;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.extendfriend.bean.MatchInfo;
import com.tencent.mobileqq.limitchat.LimitChatUtil;
import com.tencent.mobileqq.relationx.icebreaking.IceBreakingMng;

class BaseStateHandler$2
  implements Runnable
{
  BaseStateHandler$2(BaseStateHandler paramBaseStateHandler, MatchInfo paramMatchInfo) {}
  
  public void run()
  {
    boolean bool = true;
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    LimitChatUtil.b((QQAppInterface)localObject, this.a.jdField_b_of_type_JavaLangString);
    LimitChatUtil.a((QQAppInterface)localObject, this.a, this.a.a, 1);
    String str1 = this.a.jdField_b_of_type_JavaLangString;
    int i = this.a.jdField_b_of_type_Int;
    String str2 = this.a.f;
    if (!TextUtils.isEmpty(this.a.c)) {}
    for (;;)
    {
      LimitChatUtil.a((QQAppInterface)localObject, str1, i, str2, bool, -1, false, 3);
      if (this.a.jdField_b_of_type_Int >= 2)
      {
        localObject = (IceBreakingMng)((QQAppInterface)localObject).getManager(QQManagerFactory.ICE_BREAKING_MNG);
        ((IceBreakingMng)localObject).b(this.a.jdField_b_of_type_JavaLangString);
        ((IceBreakingMng)localObject).d();
      }
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.limitchat.limitchatstatehandler.BaseStateHandler.2
 * JD-Core Version:    0.7.0.1
 */