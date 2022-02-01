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
    if (SignatureManager.d(String.valueOf(this.a)))
    {
      SignatureAdapter.a(this.this$0, true);
      str = SignatureTemplateConfig.a(Integer.toString(this.a), "dynamic_aio");
      localObject1 = this.b.v[0];
      localObject2 = SignatureAdapter.c(this.this$0);
      int i;
      if (((SignatureTemplateInfo.DynamicItem)localObject1).h != 0) {
        i = ((SignatureTemplateInfo.DynamicItem)localObject1).h;
      } else {
        i = 50;
      }
      int j;
      if (SignatureAdapter.e(this.this$0)) {
        j = -1;
      } else {
        j = ((SignatureTemplateInfo.DynamicItem)localObject1).g;
      }
      ((VasResController)localObject2).a(str, i, j);
      return;
    }
    String str = this.b.v[0].b;
    Object localObject1 = SignatureManagerForTool.a(this.a, str);
    Object localObject2 = SignatureTemplateConfig.a(String.valueOf(this.a), str);
    Bundle localBundle = new Bundle();
    localBundle.putInt("resType", 2);
    localBundle.putInt("dynamicType", 16);
    localBundle.putString("tplId", String.valueOf(this.a));
    localBundle.putString("fileName", str);
    SignatureAdapter.c(this.this$0).a((String)localObject1, (String)localObject2, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adapter.SignatureAdapter.2
 * JD-Core Version:    0.7.0.1
 */