package com.tencent.mobileqq.webview.swift.component;

import android.net.Uri;
import android.text.TextUtils;
import azlj;
import beep;
import beer;
import java.net.URLEncoder;
import myl;

public class SwiftBrowserStatistics$3
  implements Runnable
{
  public SwiftBrowserStatistics$3(beep parambeep, String paramString, int paramInt) {}
  
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
        if ((!this.this$0.q) && (!myl.a().m(str1))) {
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
        azlj.a(null, "dc00757", ((StringBuilder)localObject).toString(), true);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics.3
 * JD-Core Version:    0.7.0.1
 */