package com.tencent.mobileqq.extendfriend.limitchat.limitchatstatehandler;

import android.text.TextUtils;
import asne;
import assa;
import aweo;
import bbdh;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class MatchingStateHandler$1
  implements Runnable
{
  public MatchingStateHandler$1(assa paramassa) {}
  
  public void run()
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    aweo.b((QQAppInterface)localObject, this.this$0.a.jdField_b_of_type_JavaLangString);
    aweo.a((QQAppInterface)localObject, this.this$0.a, this.this$0.a.a, 2);
    String str1 = this.this$0.a.jdField_b_of_type_JavaLangString;
    int i = this.this$0.a.jdField_b_of_type_Int;
    String str2 = this.this$0.a.f;
    if (!TextUtils.isEmpty(this.this$0.a.c)) {}
    for (boolean bool = true;; bool = false)
    {
      aweo.a((QQAppInterface)localObject, str1, i, str2, bool, -1, false, 3);
      if (this.this$0.a.jdField_b_of_type_Int >= 2)
      {
        localObject = (bbdh)((QQAppInterface)localObject).getManager(QQManagerFactory.ICE_BREAKING_MNG);
        ((bbdh)localObject).b(this.this$0.a.jdField_b_of_type_JavaLangString);
        ((bbdh)localObject).d();
      }
      ThreadManager.getUIHandler().post(new MatchingStateHandler.1.1(this));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.limitchat.limitchatstatehandler.MatchingStateHandler.1
 * JD-Core Version:    0.7.0.1
 */