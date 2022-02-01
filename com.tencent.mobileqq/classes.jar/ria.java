import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import tencent.im.oidb.cmd0xbc9.oidb_cmd0xbc9.AdReport;

public class ria
{
  public String a;
  
  public static ria a(oidb_cmd0xbc9.AdReport paramAdReport)
  {
    ria localria = new ria();
    localria.a = paramAdReport.bytes_report_url.get().toStringUtf8();
    return localria;
  }
  
  public oidb_cmd0xbc9.AdReport a()
  {
    oidb_cmd0xbc9.AdReport localAdReport = new oidb_cmd0xbc9.AdReport();
    localAdReport.bytes_report_url.set(ByteStringMicro.copyFromUtf8(this.a));
    return localAdReport;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ria
 * JD-Core Version:    0.7.0.1
 */