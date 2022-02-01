package com.tencent.mobileqq.kandian.biz.comment.helper;

import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import okhttp3.Call;
import okhttp3.FormBody.Builder;
import okhttp3.OkHttpClient;
import okhttp3.Request.Builder;

public class RIJCommentAegisHelper
{
  private static OkHttpClient a;
  
  private static OkHttpClient a()
  {
    if (a == null) {
      a = new OkHttpClient();
    }
    return a;
  }
  
  public static void a(String paramString1, String paramString2)
  {
    a(paramString1, paramString2, "4");
  }
  
  private static void a(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString1 != null) && (paramString2 != null))
    {
      if (!b()) {
        return;
      }
      paramString1 = new FormBody.Builder().addEncoded("msg[0]", paramString1).addEncoded("level[0]", paramString3).addEncoded("count", "1").addEncoded("id", "cTTfdMjcgujYUviLww");
      paramString3 = new StringBuilder();
      paramString3.append(BaseApplicationImpl.getApplication().getRuntime().getAccount());
      paramString3.append("");
      paramString1 = paramString1.addEncoded("uin", paramString3.toString());
      paramString3 = new StringBuilder();
      paramString3.append(System.currentTimeMillis());
      paramString3.append("");
      paramString1 = paramString1.addEncoded("sessionId", paramString3.toString()).addEncoded("version", "8.8.17").addEncoded("from", paramString2).addEncoded("platform", "Android").addEncoded("ext1", "isDebug:false").build();
      paramString1 = new Request.Builder().url("https://aegis.qq.com/collect").post(paramString1).build();
      a().newCall(paramString1).enqueue(new RIJCommentAegisHelper.1());
    }
  }
  
  private static boolean b()
  {
    boolean bool;
    if (Aladdin.getConfig(488).getIntegerFromString("comment_aegis_switch", 0) == 1) {
      bool = true;
    } else {
      bool = false;
    }
    QLog.d("RIJCommentAegisHelper", 1, new Object[] { "isCommentAegisSwitchOn: ", Boolean.valueOf(bool) });
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.helper.RIJCommentAegisHelper
 * JD-Core Version:    0.7.0.1
 */