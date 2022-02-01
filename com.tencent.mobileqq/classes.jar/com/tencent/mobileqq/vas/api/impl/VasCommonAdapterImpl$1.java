package com.tencent.mobileqq.vas.api.impl;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.vas.VasH5PayUtil;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import java.net.URLEncoder;
import tencent.hiboom.hiboomauth.hiboom_auth.TTipsInfo;

class VasCommonAdapterImpl$1
  implements DialogInterface.OnClickListener
{
  VasCommonAdapterImpl$1(VasCommonAdapterImpl paramVasCommonAdapterImpl, int paramInt1, String paramString, Context paramContext, hiboom_auth.TTipsInfo paramTTipsInfo, int paramInt2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramInt = this.jdField_a_of_type_Int;
    if (paramInt != 1)
    {
      if (paramInt == 2)
      {
        String str1 = this.jdField_a_of_type_TencentHiboomHiboomauthHiboom_auth$TTipsInfo.str_vip_type.get();
        String str2 = this.jdField_a_of_type_TencentHiboomHiboomauthHiboom_auth$TTipsInfo.str_month.get();
        String str3 = this.jdField_a_of_type_TencentHiboomHiboomauthHiboom_auth$TTipsInfo.str_aid.get();
        boolean bool1;
        if (str1.startsWith("!"))
        {
          str1 = str1.substring(1, str1.length());
          bool1 = true;
        }
        else
        {
          bool1 = false;
        }
        boolean bool2;
        if (str2.startsWith("!"))
        {
          str2 = str2.substring(1, str2.length());
          bool2 = true;
        }
        else
        {
          bool2 = false;
        }
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("jsbridge://font/paySuccess?p={\"id\":");
        ((StringBuilder)localObject).append(this.b);
        ((StringBuilder)localObject).append("}");
        localObject = URLEncoder.encode(((StringBuilder)localObject).toString());
        VasH5PayUtil.a(this.jdField_a_of_type_AndroidContentContext, str3, str1, Integer.parseInt(str2), bool2, bool1, null, (String)localObject, false, false);
      }
    }
    else if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      VasWebviewUtil.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, -1L, null, false, -1);
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.api.impl.VasCommonAdapterImpl.1
 * JD-Core Version:    0.7.0.1
 */