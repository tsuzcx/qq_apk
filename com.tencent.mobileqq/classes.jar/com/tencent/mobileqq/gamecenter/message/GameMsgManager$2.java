package com.tencent.mobileqq.gamecenter.message;

import amjk;
import android.content.SharedPreferences;
import android.text.TextUtils;
import aojk;
import aojl;
import asil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;

public class GameMsgManager$2
  implements Runnable
{
  public GameMsgManager$2(asil paramasil) {}
  
  public void run()
  {
    QLog.i(asil.c(), 1, "init task starts.");
    Object localObject1 = aojl.a();
    if (localObject1 != null)
    {
      if (asil.a(this.this$0) == null) {
        asil.a(this.this$0, new aojk());
      }
      asil.a(this.this$0).jdField_a_of_type_Int = ((aojk)localObject1).jdField_a_of_type_Int;
      if (!TextUtils.isEmpty(((aojk)localObject1).jdField_a_of_type_JavaLangString)) {
        asil.a(this.this$0).jdField_a_of_type_JavaLangString = ((aojk)localObject1).jdField_a_of_type_JavaLangString;
      }
      if (!TextUtils.isEmpty(((aojk)localObject1).b)) {
        asil.a(this.this$0).b = ((aojk)localObject1).b;
      }
      QLog.i(asil.c(), 1, "graySwitch:" + asil.a(this.this$0).jdField_a_of_type_Int);
    }
    asil.a(this.this$0);
    asil.b(this.this$0);
    asil.c(this.this$0);
    asil.a(this.this$0).addObserver(asil.a(this.this$0));
    this.this$0.a();
    localObject1 = BaseApplicationImpl.getApplication().getSharedPreferences("game_center_sp", 0);
    Object localObject2 = "sp_enter_pub" + asil.a(this.this$0).getCurrentAccountUin();
    asil.a(this.this$0, ((SharedPreferences)localObject1).getInt((String)localObject2, 0));
    asil.a(this.this$0).a().addObserver(this.this$0);
    asil.a(true);
    if (asil.a(this.this$0) > 0)
    {
      localObject1 = asil.a(this.this$0).a().a();
      localObject2 = ((amjk)localObject1).a("2747277822", 1008);
      if ((localObject2 != null) && (this.this$0.b())) {
        ((amjk)localObject1).a((RecentUser)localObject2);
      }
    }
    this.this$0.c();
    QLog.i(asil.c(), 1, "init task ends. unreadCnt = " + asil.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.message.GameMsgManager.2
 * JD-Core Version:    0.7.0.1
 */