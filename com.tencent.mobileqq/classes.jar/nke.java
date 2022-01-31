import android.os.Bundle;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.qqstory.network.handler.ReportEvilToXinanHandler;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import mqq.manager.TicketManager;

public class nke
  implements Runnable
{
  public nke(ReportEvilToXinanHandler paramReportEvilToXinanHandler, boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public void run()
  {
    String str4 = ReportEvilToXinanHandler.a(this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerReportEvilToXinanHandler);
    if (this.jdField_a_of_type_Boolean) {}
    for (String str1 = "1";; str1 = "0")
    {
      String str2 = this.jdField_a_of_type_JavaLangString;
      String str3 = this.b;
      str4 = MD5Utils.d("android" + "_" + "7.6.8" + "_" + "1111" + "_" + str4);
      SLog.a("ReportEvilToXinanHandler", "get cryptograph step1. scretKey = %s.", str4);
      str4 = MD5Utils.d(this.c + "_" + "" + "_" + str2 + "_" + "" + "_" + "" + "_" + str3 + "_" + "" + "_" + "" + "_" + str4);
      SLog.a("ReportEvilToXinanHandler", "get cryptograph step2. cryptograph = %s.", str4);
      Object localObject2 = (TicketManager)PlayModeUtils.a().getManager(2);
      Object localObject1 = PlayModeUtils.a().getCurrentAccountUin();
      String str5 = ((TicketManager)localObject2).getSkey((String)localObject1);
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("cookie", "uin=" + (String)localObject1 + ";skey=" + str5);
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("system", "android");
      ((Bundle)localObject1).putString("version", "7.6.8");
      ((Bundle)localObject1).putString("uintype", "1");
      ((Bundle)localObject1).putString("eviluin", this.c);
      ((Bundle)localObject1).putString("appname", "KQQ");
      ((Bundle)localObject1).putString("appid", "2400002");
      ((Bundle)localObject1).putString("subapp", "near_trace");
      ((Bundle)localObject1).putString("scene", "1111");
      ((Bundle)localObject1).putString("evil_type", this.d);
      ((Bundle)localObject1).putString("buddyflag", str1);
      ((Bundle)localObject1).putString("srv_para", "");
      ((Bundle)localObject1).putString("impeach_desc", "");
      ((Bundle)localObject1).putString("text_evidence", str2);
      ((Bundle)localObject1).putString("img_evidence", "");
      ((Bundle)localObject1).putString("url_evidence", "");
      ((Bundle)localObject1).putString("video_evidence", str3);
      ((Bundle)localObject1).putString("file_evidence", "");
      ((Bundle)localObject1).putString("audio_evidence", "");
      ((Bundle)localObject1).putString("user_input_param", "REPORT_IP=0&EVIL_IP=0");
      ((Bundle)localObject1).putString("cryptograph", str4);
      try
      {
        str1 = HttpUtil.a(BaseApplicationImpl.getContext(), "https://jubao.qq.com/uniform_impeach/impeach_submit", "POST", (Bundle)localObject1, (Bundle)localObject2);
        ReportEvilToXinanHandler.a(this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerReportEvilToXinanHandler, str1);
        return;
      }
      catch (IOException localIOException)
      {
        QLog.d("ReportEvilToXinanHandler", 1, localIOException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nke
 * JD-Core Version:    0.7.0.1
 */