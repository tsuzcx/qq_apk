package cooperation.ilive.lite.report;

import com.tencent.biz.common.util.HttpUtil;
import com.tencent.livesdk.livesdkplayer.AVCatonReport4Player;
import com.tencent.qphone.base.util.QLog;
import cooperation.ilive.lite.IliveLiteMonitorUtil;
import java.util.HashMap;

public class IliveAVCatonReport
  extends AVCatonReport4Player
{
  private HashMap<String, String> a = new HashMap();
  private String b;
  private boolean c = false;
  
  public void a()
  {
    this.a.put("netstring", String.valueOf(HttpUtil.getNetWorkType()));
    IliveLiteMonitorUtil.a("live_avcaton");
    IliveLiteMonitorUtil.a("live_avcaton", this.a);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("avCatonReport: ");
      localStringBuilder.append(this.a);
      QLog.i("IliveAVCatonReport", 2, localStringBuilder.toString());
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    this.a.put("firstframeduration", String.valueOf(paramLong1));
    this.a.put("playduration", String.valueOf(paramLong2));
    if (this.c) {
      IliveLiteDataReport.a().h(paramLong1);
    }
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    this.a.put("gap0_5", String.valueOf(paramLong1));
    this.a.put("gap5_10", String.valueOf(paramLong2));
    this.a.put("gap10_100", String.valueOf(paramLong3));
    this.a.put("framecount", String.valueOf(paramLong4));
  }
  
  public void a(String paramString)
  {
    this.b = paramString;
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    this.a.put("url", paramString1);
    this.a.put("resolution", paramString2);
    this.a.put("roomid", this.b);
    this.a.put("sdktyp", paramString4);
    this.a.put("sdkversion", paramString5);
    this.a.put("openid", paramString6);
  }
  
  public void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.lite.report.IliveAVCatonReport
 * JD-Core Version:    0.7.0.1
 */