package com.tencent.mobileqq.vas.adapter;

import android.os.Bundle;
import awei;
import bbqc;
import bbqe;
import bbqf;
import bbrm;
import bbsb;
import com.tencent.mobileqq.app.SignatureManager;

public class SignatureAdapter$2
  implements Runnable
{
  public SignatureAdapter$2(bbsb parambbsb, int paramInt, bbqe parambbqe) {}
  
  public void run()
  {
    if (SignatureManager.b(String.valueOf(this.jdField_a_of_type_Int)))
    {
      bbsb.a(this.this$0, true);
      str = bbqc.a(Integer.toString(this.jdField_a_of_type_Int), "dynamic_aio");
      localObject1 = this.jdField_a_of_type_Bbqe.a[0];
      localObject2 = bbsb.a(this.this$0);
      int i;
      if (((bbqf)localObject1).c != 0)
      {
        i = ((bbqf)localObject1).c;
        if (!bbsb.a(this.this$0)) {
          break label96;
        }
      }
      label96:
      for (int j = -1;; j = ((bbqf)localObject1).b)
      {
        ((bbrm)localObject2).a(str, i, j);
        return;
        i = 50;
        break;
      }
    }
    String str = this.jdField_a_of_type_Bbqe.a[0].a;
    Object localObject1 = awei.a(this.jdField_a_of_type_Int, str);
    Object localObject2 = bbqc.a(String.valueOf(this.jdField_a_of_type_Int), str);
    Bundle localBundle = new Bundle();
    localBundle.putInt("resType", 2);
    localBundle.putInt("dynamicType", 16);
    localBundle.putString("tplId", String.valueOf(this.jdField_a_of_type_Int));
    localBundle.putString("fileName", str);
    bbsb.a(this.this$0).a((String)localObject1, (String)localObject2, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adapter.SignatureAdapter.2
 * JD-Core Version:    0.7.0.1
 */