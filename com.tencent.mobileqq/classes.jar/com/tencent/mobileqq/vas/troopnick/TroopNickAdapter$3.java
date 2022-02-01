package com.tencent.mobileqq.vas.troopnick;

import android.os.Bundle;
import android.os.Handler;
import bhoh;
import bhpo;
import bhsx;
import bhyq;
import java.io.File;

public class TroopNickAdapter$3
  implements Runnable
{
  public TroopNickAdapter$3(bhsx parambhsx, Bundle paramBundle) {}
  
  public void run()
  {
    int i = this.a.getInt("dynamicType");
    String str1 = this.a.getString("tplId");
    String str2 = this.a.getString("fileName");
    Object localObject = null;
    switch (i)
    {
    }
    for (;;)
    {
      if (localObject != null)
      {
        localObject = new File((String)localObject);
        if (bhyq.a(new File(bhoh.a(str1, str2)), (File)localObject, true)) {
          bhsx.a(this.this$0).a().sendEmptyMessage(10003);
        }
      }
      return;
      localObject = bhoh.a(str1, "dynamic_aio");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.troopnick.TroopNickAdapter.3
 * JD-Core Version:    0.7.0.1
 */