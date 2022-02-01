package com.tencent.mobileqq.kandian.glue.viola.modules;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QBaseActivity;
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
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      String str2;
      try
      {
        Object localObject = (QQAppInterface)ReadInJoyUtils.a();
        String str1 = str3;
        if (localObject != null)
        {
          str1 = ((QQAppInterface)localObject).getAccount();
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("https://guanjia.qq.com/online_server/m_report.html?shareUrl=");
          ((StringBuilder)localObject).append(URLEncoder.encode(this.jdField_a_of_type_JavaLangString, "utf-8"));
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
      if (QBaseActivity.sTopActivity != null) {
        ReadInJoyUtils.a(QBaseActivity.sTopActivity, str2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.modules.SheetItemClickProcessor.JuBaoAction.1
 * JD-Core Version:    0.7.0.1
 */