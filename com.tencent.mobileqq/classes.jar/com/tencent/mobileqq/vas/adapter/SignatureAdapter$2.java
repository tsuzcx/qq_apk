package com.tencent.mobileqq.vas.adapter;

import android.os.Bundle;
import aydw;
import bdtt;
import bdtv;
import bdtw;
import bdvd;
import bdvs;
import com.tencent.mobileqq.app.SignatureManager;

public class SignatureAdapter$2
  implements Runnable
{
  public SignatureAdapter$2(bdvs parambdvs, int paramInt, bdtv parambdtv) {}
  
  public void run()
  {
    if (SignatureManager.b(String.valueOf(this.jdField_a_of_type_Int)))
    {
      bdvs.a(this.this$0, true);
      str = bdtt.a(Integer.toString(this.jdField_a_of_type_Int), "dynamic_aio");
      localObject1 = this.jdField_a_of_type_Bdtv.a[0];
      localObject2 = bdvs.a(this.this$0);
      int i;
      if (((bdtw)localObject1).c != 0)
      {
        i = ((bdtw)localObject1).c;
        if (!bdvs.a(this.this$0)) {
          break label96;
        }
      }
      label96:
      for (int j = -1;; j = ((bdtw)localObject1).b)
      {
        ((bdvd)localObject2).a(str, i, j);
        return;
        i = 50;
        break;
      }
    }
    String str = this.jdField_a_of_type_Bdtv.a[0].a;
    Object localObject1 = aydw.a(this.jdField_a_of_type_Int, str);
    Object localObject2 = bdtt.a(String.valueOf(this.jdField_a_of_type_Int), str);
    Bundle localBundle = new Bundle();
    localBundle.putInt("resType", 2);
    localBundle.putInt("dynamicType", 16);
    localBundle.putString("tplId", String.valueOf(this.jdField_a_of_type_Int));
    localBundle.putString("fileName", str);
    bdvs.a(this.this$0).a((String)localObject1, (String)localObject2, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adapter.SignatureAdapter.2
 * JD-Core Version:    0.7.0.1
 */