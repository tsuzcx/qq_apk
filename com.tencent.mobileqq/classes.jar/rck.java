import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.Doraemon.monitor.DoraemonAPIReporterMain;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.oidb_0xb6f.Identity;
import tencent.im.oidb.oidb_0xb6f.ReportFreqRspBody;
import tencent.im.oidb.oidb_0xb6f.RspBody;

public class rck
  extends ProtoUtils.TroopProtocolObserver
{
  public rck(DoraemonAPIReporterMain paramDoraemonAPIReporterMain, int paramInt1, String paramString1, String paramString2, int paramInt2) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("DoraemonOpenAPI.report", 2, "onResult " + this.jdField_a_of_type_Int + "|" + this.jdField_a_of_type_JavaLangString + "|" + this.b + "|" + this.c + ", code=" + paramInt);
    }
    if ((paramInt != 0) || (paramArrayOfByte == null)) {
      if (QLog.isColorLevel()) {
        QLog.i("DoraemonOpenAPI.report", 2, "req error");
      }
    }
    do
    {
      for (;;)
      {
        return;
        paramBundle = new oidb_0xb6f.RspBody();
        try
        {
          paramBundle.mergeFrom(paramArrayOfByte);
          if (paramBundle.report_freq_rsp.has()) {
            break label158;
          }
          if (QLog.isColorLevel())
          {
            QLog.i("DoraemonOpenAPI.report", 2, "rsp invalid");
            return;
          }
        }
        catch (InvalidProtocolBufferMicroException paramArrayOfByte) {}
      }
    } while (!QLog.isColorLevel());
    QLog.i("DoraemonOpenAPI.report", 2, "parse rsp error", paramArrayOfByte);
    return;
    label158:
    DoraemonAPIReporterMain.a(this.jdField_a_of_type_ComTencentMobileqqDoraemonMonitorDoraemonAPIReporterMain, paramBundle.report_freq_rsp.identity.appType.get(), String.valueOf(paramBundle.report_freq_rsp.identity.appid.get()), paramBundle.report_freq_rsp.identity.apiName.get(), paramBundle.report_freq_rsp.remain_minute_times.get(), paramBundle.report_freq_rsp.remain_day_times.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     rck
 * JD-Core Version:    0.7.0.1
 */