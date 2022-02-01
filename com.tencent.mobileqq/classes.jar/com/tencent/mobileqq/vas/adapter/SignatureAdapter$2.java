package com.tencent.mobileqq.vas.adapter;

import android.os.Bundle;
import bbux;
import bhzb;
import bhzd;
import bhze;
import biak;
import biba;
import com.tencent.mobileqq.app.SignatureManager;

public class SignatureAdapter$2
  implements Runnable
{
  public SignatureAdapter$2(biba parambiba, int paramInt, bhzd parambhzd) {}
  
  public void run()
  {
    if (SignatureManager.b(String.valueOf(this.jdField_a_of_type_Int)))
    {
      biba.a(this.this$0, true);
      str = bhzb.a(Integer.toString(this.jdField_a_of_type_Int), "dynamic_aio");
      localObject1 = this.jdField_a_of_type_Bhzd.a[0];
      localObject2 = biba.a(this.this$0);
      int i;
      if (((bhze)localObject1).c != 0)
      {
        i = ((bhze)localObject1).c;
        if (!biba.a(this.this$0)) {
          break label96;
        }
      }
      label96:
      for (int j = -1;; j = ((bhze)localObject1).b)
      {
        ((biak)localObject2).a(str, i, j);
        return;
        i = 50;
        break;
      }
    }
    String str = this.jdField_a_of_type_Bhzd.a[0].a;
    Object localObject1 = bbux.a(this.jdField_a_of_type_Int, str);
    Object localObject2 = bhzb.a(String.valueOf(this.jdField_a_of_type_Int), str);
    Bundle localBundle = new Bundle();
    localBundle.putInt("resType", 2);
    localBundle.putInt("dynamicType", 16);
    localBundle.putString("tplId", String.valueOf(this.jdField_a_of_type_Int));
    localBundle.putString("fileName", str);
    biba.a(this.this$0).a((String)localObject1, (String)localObject2, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adapter.SignatureAdapter.2
 * JD-Core Version:    0.7.0.1
 */