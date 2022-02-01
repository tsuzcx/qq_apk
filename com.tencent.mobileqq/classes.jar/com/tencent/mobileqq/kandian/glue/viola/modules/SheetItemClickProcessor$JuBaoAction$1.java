package com.tencent.mobileqq.kandian.glue.viola.modules;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import java.net.URLEncoder;

class SheetItemClickProcessor$JuBaoAction$1
  implements Runnable
{
  SheetItemClickProcessor$JuBaoAction$1(SheetItemClickProcessor.JuBaoAction paramJuBaoAction, String paramString) {}
  
  public void run()
  {
    String str3 = "https://guanjia.qq.com/online_server/m_report.html?shareUrl=";
    if (!TextUtils.isEmpty(this.a))
    {
      String str2;
      try
      {
        Object localObject = (QQAppInterface)ReadInJoyUtils.b();
        String str1 = str3;
        if (localObject != null)
        {
          str1 = ((QQAppInterface)localObject).getAccount();
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("https://guanjia.qq.com/online_server/m_report.html?shareUrl=");
          ((StringBuilder)localObject).append(URLEncoder.encode(this.a, "utf-8"));
          ((StringBuilder)localObject).append("&qq=");
          ((StringBuilder)localObject).append(str1);
          ((StringBuilder)localObject).append("&_wv=7");
          str1 = ((StringBuilder)localObject).toString();
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        str2 = str3;
      }
      if (BridgeModuleHelper.e() != null) {
        ReadInJoyUtils.a(BridgeModuleHelper.e(), str2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.modules.SheetItemClickProcessor.JuBaoAction.1
 * JD-Core Version:    0.7.0.1
 */