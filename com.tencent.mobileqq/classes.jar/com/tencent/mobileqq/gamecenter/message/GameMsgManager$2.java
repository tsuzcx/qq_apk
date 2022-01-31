package com.tencent.mobileqq.gamecenter.message;

import amnz;
import android.content.SharedPreferences;
import android.text.TextUtils;
import aont;
import aonu;
import asmu;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;

public class GameMsgManager$2
  implements Runnable
{
  public GameMsgManager$2(asmu paramasmu) {}
  
  public void run()
  {
    QLog.i(asmu.c(), 1, "init task starts.");
    Object localObject1 = aonu.a();
    if (localObject1 != null)
    {
      if (asmu.a(this.this$0) == null) {
        asmu.a(this.this$0, new aont());
      }
      asmu.a(this.this$0).jdField_a_of_type_Int = ((aont)localObject1).jdField_a_of_type_Int;
      if (!TextUtils.isEmpty(((aont)localObject1).jdField_a_of_type_JavaLangString)) {
        asmu.a(this.this$0).jdField_a_of_type_JavaLangString = ((aont)localObject1).jdField_a_of_type_JavaLangString;
      }
      if (!TextUtils.isEmpty(((aont)localObject1).b)) {
        asmu.a(this.this$0).b = ((aont)localObject1).b;
      }
      QLog.i(asmu.c(), 1, "graySwitch:" + asmu.a(this.this$0).jdField_a_of_type_Int);
    }
    asmu.a(this.this$0);
    asmu.b(this.this$0);
    asmu.c(this.this$0);
    asmu.a(this.this$0).addObserver(asmu.a(this.this$0));
    this.this$0.a();
    localObject1 = BaseApplicationImpl.getApplication().getSharedPreferences("game_center_sp", 0);
    Object localObject2 = "sp_enter_pub" + asmu.a(this.this$0).getCurrentAccountUin();
    asmu.a(this.this$0, ((SharedPreferences)localObject1).getInt((String)localObject2, 0));
    asmu.a(this.this$0).a().addObserver(this.this$0);
    asmu.a(true);
    if (asmu.a(this.this$0) > 0)
    {
      localObject1 = asmu.a(this.this$0).a().a();
      localObject2 = ((amnz)localObject1).a("2747277822", 1008);
      if ((localObject2 != null) && (this.this$0.b())) {
        ((amnz)localObject1).a((RecentUser)localObject2);
      }
    }
    this.this$0.c();
    QLog.i(asmu.c(), 1, "init task ends. unreadCnt = " + asmu.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.message.GameMsgManager.2
 * JD-Core Version:    0.7.0.1
 */