package com.tencent.mobileqq.vas.adapter;

import android.os.Bundle;
import bbvh;
import bhoh;
import bhoj;
import bhok;
import bhpo;
import bhqf;
import com.tencent.mobileqq.app.SignatureManager;

public class SignatureAdapter$2
  implements Runnable
{
  public SignatureAdapter$2(bhqf parambhqf, int paramInt, bhoj parambhoj) {}
  
  public void run()
  {
    if (SignatureManager.b(String.valueOf(this.jdField_a_of_type_Int)))
    {
      bhqf.a(this.this$0, true);
      str = bhoh.a(Integer.toString(this.jdField_a_of_type_Int), "dynamic_aio");
      localObject1 = this.jdField_a_of_type_Bhoj.a[0];
      localObject2 = bhqf.a(this.this$0);
      int i;
      if (((bhok)localObject1).c != 0)
      {
        i = ((bhok)localObject1).c;
        if (!bhqf.a(this.this$0)) {
          break label96;
        }
      }
      label96:
      for (int j = -1;; j = ((bhok)localObject1).b)
      {
        ((bhpo)localObject2).a(str, i, j);
        return;
        i = 50;
        break;
      }
    }
    String str = this.jdField_a_of_type_Bhoj.a[0].a;
    Object localObject1 = bbvh.a(this.jdField_a_of_type_Int, str);
    Object localObject2 = bhoh.a(String.valueOf(this.jdField_a_of_type_Int), str);
    Bundle localBundle = new Bundle();
    localBundle.putInt("resType", 2);
    localBundle.putInt("dynamicType", 16);
    localBundle.putString("tplId", String.valueOf(this.jdField_a_of_type_Int));
    localBundle.putString("fileName", str);
    bhqf.a(this.this$0).a((String)localObject1, (String)localObject2, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adapter.SignatureAdapter.2
 * JD-Core Version:    0.7.0.1
 */