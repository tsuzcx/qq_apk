package com.tencent.mobileqq.vas.troopnick;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.vas.VasResEngine.VasResController;

class TroopNickAdapter$2
  implements Runnable
{
  TroopNickAdapter$2(TroopNickAdapter paramTroopNickAdapter, String paramString, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (TroopNickAdapter.a(this.this$0) == null) {
      return;
    }
    synchronized (TroopNickAdapter.a(this.this$0))
    {
      String[] arrayOfString1 = this.this$0.a(this.jdField_a_of_type_JavaLangString);
      if ((arrayOfString1 == null) || (arrayOfString1.length == 0) || (TroopNickAdapter.a(this.this$0) == null)) {
        return;
      }
    }
    Message localMessage = TroopNickAdapter.a(this.this$0).a().obtainMessage();
    Bundle localBundle = new Bundle();
    localBundle.putInt("type", 1);
    localBundle.putStringArray("pngs", arrayOfString2);
    localBundle.putInt("interval", this.jdField_a_of_type_Int);
    localBundle.putInt("repeatTimes", this.b);
    localMessage.setData(localBundle);
    localMessage.what = 10001;
    TroopNickAdapter.a(this.this$0).a().sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.troopnick.TroopNickAdapter.2
 * JD-Core Version:    0.7.0.1
 */