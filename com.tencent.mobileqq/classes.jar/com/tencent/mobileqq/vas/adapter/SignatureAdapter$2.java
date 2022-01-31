package com.tencent.mobileqq.vas.adapter;

import android.os.Bundle;
import avep;
import baog;
import baoi;
import baoj;
import bapp;
import baqe;
import com.tencent.mobileqq.app.SignatureManager;

public class SignatureAdapter$2
  implements Runnable
{
  public SignatureAdapter$2(baqe parambaqe, int paramInt, baoi parambaoi) {}
  
  public void run()
  {
    if (SignatureManager.b(String.valueOf(this.jdField_a_of_type_Int)))
    {
      baqe.a(this.this$0, true);
      str = baog.a(Integer.toString(this.jdField_a_of_type_Int), "dynamic_aio");
      localObject1 = this.jdField_a_of_type_Baoi.a[0];
      localObject2 = baqe.a(this.this$0);
      int i;
      if (((baoj)localObject1).c != 0)
      {
        i = ((baoj)localObject1).c;
        if (!baqe.a(this.this$0)) {
          break label96;
        }
      }
      label96:
      for (int j = -1;; j = ((baoj)localObject1).b)
      {
        ((bapp)localObject2).a(str, i, j);
        return;
        i = 50;
        break;
      }
    }
    String str = this.jdField_a_of_type_Baoi.a[0].a;
    Object localObject1 = avep.a(this.jdField_a_of_type_Int, str);
    Object localObject2 = baog.a(String.valueOf(this.jdField_a_of_type_Int), str);
    Bundle localBundle = new Bundle();
    localBundle.putInt("resType", 2);
    localBundle.putInt("dynamicType", 16);
    localBundle.putString("tplId", String.valueOf(this.jdField_a_of_type_Int));
    localBundle.putString("fileName", str);
    baqe.a(this.this$0).a((String)localObject1, (String)localObject2, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adapter.SignatureAdapter.2
 * JD-Core Version:    0.7.0.1
 */