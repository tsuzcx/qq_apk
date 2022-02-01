package com.tencent.mobileqq.extendfriend.limitchat.limitchatstatehandler;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.extendfriend.ExtendFriendManager;
import com.tencent.mobileqq.extendfriend.bean.MatchInfo;
import com.tencent.mobileqq.limitchat.LimitChatUtil;
import com.tencent.mobileqq.relationx.icebreaking.IceBreakingMng;
import mqq.os.MqqHandler;

class MatchingStateHandler$1
  implements Runnable
{
  MatchingStateHandler$1(MatchingStateHandler paramMatchingStateHandler) {}
  
  public void run()
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    String str1;
    int i;
    String str2;
    if ((localObject != null) && (!((ExtendFriendManager)((QQAppInterface)localObject).getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).f()))
    {
      LimitChatUtil.b((QQAppInterface)localObject, this.this$0.a.jdField_b_of_type_JavaLangString);
      LimitChatUtil.a((QQAppInterface)localObject, this.this$0.a, this.this$0.a.a, 2);
      str1 = this.this$0.a.jdField_b_of_type_JavaLangString;
      i = this.this$0.a.jdField_b_of_type_Int;
      str2 = this.this$0.a.f;
      if (TextUtils.isEmpty(this.this$0.a.c)) {
        break label192;
      }
    }
    label192:
    for (boolean bool = true;; bool = false)
    {
      LimitChatUtil.a((QQAppInterface)localObject, str1, i, str2, bool, -1, false, 3);
      if (this.this$0.a.jdField_b_of_type_Int >= 2)
      {
        localObject = (IceBreakingMng)((QQAppInterface)localObject).getManager(QQManagerFactory.ICE_BREAKING_MNG);
        ((IceBreakingMng)localObject).b(this.this$0.a.jdField_b_of_type_JavaLangString);
        ((IceBreakingMng)localObject).d();
      }
      ThreadManager.getUIHandler().post(new MatchingStateHandler.1.1(this));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.limitchat.limitchatstatehandler.MatchingStateHandler.1
 * JD-Core Version:    0.7.0.1
 */