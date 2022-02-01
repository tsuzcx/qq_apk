package com.tencent.mobileqq.vas.adapter;

import android.os.Bundle;
import com.tencent.mobileqq.app.SignatureManager;
import com.tencent.mobileqq.richstatus.SignatureManagerForTool;
import com.tencent.mobileqq.vas.SignatureTemplateConfig;
import com.tencent.mobileqq.vas.SignatureTemplateInfo;
import com.tencent.mobileqq.vas.SignatureTemplateInfo.DynamicItem;
import com.tencent.mobileqq.vas.VasResEngine.VasResController;

class SignatureAdapter$2
  implements Runnable
{
  SignatureAdapter$2(SignatureAdapter paramSignatureAdapter, int paramInt, SignatureTemplateInfo paramSignatureTemplateInfo) {}
  
  public void run()
  {
    if (SignatureManager.b(String.valueOf(this.jdField_a_of_type_Int)))
    {
      SignatureAdapter.a(this.this$0, true);
      str = SignatureTemplateConfig.a(Integer.toString(this.jdField_a_of_type_Int), "dynamic_aio");
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo.a[0];
      localObject2 = SignatureAdapter.a(this.this$0);
      int i;
      if (((SignatureTemplateInfo.DynamicItem)localObject1).c != 0) {
        i = ((SignatureTemplateInfo.DynamicItem)localObject1).c;
      } else {
        i = 50;
      }
      int j;
      if (SignatureAdapter.a(this.this$0)) {
        j = -1;
      } else {
        j = ((SignatureTemplateInfo.DynamicItem)localObject1).b;
      }
      ((VasResController)localObject2).a(str, i, j);
      return;
    }
    String str = this.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo.a[0].a;
    Object localObject1 = SignatureManagerForTool.a(this.jdField_a_of_type_Int, str);
    Object localObject2 = SignatureTemplateConfig.a(String.valueOf(this.jdField_a_of_type_Int), str);
    Bundle localBundle = new Bundle();
    localBundle.putInt("resType", 2);
    localBundle.putInt("dynamicType", 16);
    localBundle.putString("tplId", String.valueOf(this.jdField_a_of_type_Int));
    localBundle.putString("fileName", str);
    SignatureAdapter.a(this.this$0).a((String)localObject1, (String)localObject2, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adapter.SignatureAdapter.2
 * JD-Core Version:    0.7.0.1
 */