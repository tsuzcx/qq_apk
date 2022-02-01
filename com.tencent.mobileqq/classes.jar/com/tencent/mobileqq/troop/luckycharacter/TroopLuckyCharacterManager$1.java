package com.tencent.mobileqq.troop.luckycharacter;

import android.content.SharedPreferences;
import aoep;
import aqxe;
import bfya;
import bfyc;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

public class TroopLuckyCharacterManager$1
  implements Runnable
{
  public TroopLuckyCharacterManager$1(bfyc parambfyc) {}
  
  public void run()
  {
    bfyc.a(this.this$0, (bfya)aqxe.a().a(696));
    String str = bfyc.a(this.this$0).getCurrentAccountUin();
    boolean bool = BaseApplication.getContext().getSharedPreferences(str, 0).getBoolean(str + "self_troop_lucky_character_switch", true);
    this.this$0.a(bool);
    ((aoep)bfyc.a(this.this$0).getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).notifyUI(80, true, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.luckycharacter.TroopLuckyCharacterManager.1
 * JD-Core Version:    0.7.0.1
 */