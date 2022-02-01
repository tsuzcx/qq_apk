package com.tencent.mobileqq.vas.adapter;

import android.os.Bundle;
import bbce;
import bgyw;
import bgyy;
import bgyz;
import bhae;
import bhau;
import com.tencent.mobileqq.app.SignatureManager;

public class SignatureAdapter$2
  implements Runnable
{
  public SignatureAdapter$2(bhau parambhau, int paramInt, bgyy parambgyy) {}
  
  public void run()
  {
    if (SignatureManager.b(String.valueOf(this.jdField_a_of_type_Int)))
    {
      bhau.a(this.this$0, true);
      str = bgyw.a(Integer.toString(this.jdField_a_of_type_Int), "dynamic_aio");
      localObject1 = this.jdField_a_of_type_Bgyy.a[0];
      localObject2 = bhau.a(this.this$0);
      int i;
      if (((bgyz)localObject1).c != 0)
      {
        i = ((bgyz)localObject1).c;
        if (!bhau.a(this.this$0)) {
          break label96;
        }
      }
      label96:
      for (int j = -1;; j = ((bgyz)localObject1).b)
      {
        ((bhae)localObject2).a(str, i, j);
        return;
        i = 50;
        break;
      }
    }
    String str = this.jdField_a_of_type_Bgyy.a[0].a;
    Object localObject1 = bbce.a(this.jdField_a_of_type_Int, str);
    Object localObject2 = bgyw.a(String.valueOf(this.jdField_a_of_type_Int), str);
    Bundle localBundle = new Bundle();
    localBundle.putInt("resType", 2);
    localBundle.putInt("dynamicType", 16);
    localBundle.putString("tplId", String.valueOf(this.jdField_a_of_type_Int));
    localBundle.putString("fileName", str);
    bhau.a(this.this$0).a((String)localObject1, (String)localObject2, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adapter.SignatureAdapter.2
 * JD-Core Version:    0.7.0.1
 */