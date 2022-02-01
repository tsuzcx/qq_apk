package com.tencent.mobileqq.webview.swift.component;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.gamecenter.activities.GameCenterActivity;
import com.tencent.mobileqq.statistics.DcReportUtil;
import java.net.URLEncoder;

class SwiftBrowserStatistics$3
  implements Runnable
{
  SwiftBrowserStatistics$3(SwiftBrowserStatistics paramSwiftBrowserStatistics, String paramString1, int paramInt1, String paramString2, int paramInt2) {}
  
  public void run()
  {
    String str3 = "";
    try
    {
      localObject = Uri.parse(this.jdField_a_of_type_JavaLangString);
      str1 = str3;
      if (localObject != null)
      {
        str1 = ((Uri)localObject).getHost();
        if (TextUtils.isEmpty(str1)) {
          return;
        }
        if ((!this.this$0.q) && (!AuthorizeConfig.a().d("white_list_authorize_config", str1))) {
          return;
        }
        str1 = URLEncoder.encode(this.jdField_a_of_type_JavaLangString);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject;
        String str1;
        localException.printStackTrace();
        String str2 = str3;
        continue;
        str3 = "0";
      }
    }
    if (!TextUtils.isEmpty(str1))
    {
      localObject = new StringBuilder();
      if (this.this$0.a.jdField_a_of_type_Int == 13)
      {
        str3 = "1";
        ((StringBuilder)localObject).append(str3).append("|");
        ((StringBuilder)localObject).append(String.valueOf(-this.jdField_a_of_type_Int)).append("|");
        ((StringBuilder)localObject).append(str1).append("|");
        ((StringBuilder)localObject).append(str1).append("|");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
        DcReportUtil.a(null, "dc00757", ((StringBuilder)localObject).toString(), true);
        GameCenterActivity.a(this.jdField_b_of_type_JavaLangString, this.jdField_b_of_type_Int);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics.3
 * JD-Core Version:    0.7.0.1
 */