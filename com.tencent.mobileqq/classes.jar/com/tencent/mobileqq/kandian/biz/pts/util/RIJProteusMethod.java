package com.tencent.mobileqq.kandian.biz.pts.util;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.CustomMethodsRegister.CustomMethodInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

public class RIJProteusMethod
  implements CustomMethodsRegister.CustomMethodInterface
{
  private Map<String, CustomMethodsRegister.CustomMethodInterface> a = new HashMap();
  
  public RIJProteusMethod()
  {
    a();
  }
  
  private void a()
  {
    a("decodeEmotion", new RIJProteusMethod.MethodDecodeEmotion(null));
    a("HyperLinkClick", new RIJProteusMethod.MethodHyperLink(null));
  }
  
  public void a(String paramString, CustomMethodsRegister.CustomMethodInterface paramCustomMethodInterface)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramCustomMethodInterface == null) {
        return;
      }
      this.a.put(paramString, paramCustomMethodInterface);
    }
  }
  
  public Object invoke(String paramString, Object... paramVarArgs)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("invoke,s=");
    localStringBuilder.append(paramString);
    QLog.d("RIJProteusMethod", 1, localStringBuilder.toString());
    if (this.a.containsKey(paramString)) {
      return ((CustomMethodsRegister.CustomMethodInterface)this.a.get(paramString)).invoke(paramString, paramVarArgs);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.util.RIJProteusMethod
 * JD-Core Version:    0.7.0.1
 */