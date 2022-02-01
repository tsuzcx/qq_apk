package com.tencent.mobileqq.vas.adapter;

import android.os.Bundle;
import android.os.Handler;
import bhoh;
import bhpo;
import bhqf;
import bhyq;
import java.io.File;

public class SignatureAdapter$3
  implements Runnable
{
  public SignatureAdapter$3(bhqf parambhqf, Bundle paramBundle) {}
  
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
          bhqf.a(this.this$0).a().sendEmptyMessage(10003);
        }
      }
      return;
      localObject = bhoh.a(str1, "dynamic_aio");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adapter.SignatureAdapter.3
 * JD-Core Version:    0.7.0.1
 */