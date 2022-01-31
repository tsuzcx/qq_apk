import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import tencent.im.oidb.cmd0xbc9.oidb_cmd0xbc9.AdReport;

public class qdl
{
  public String a;
  
  public static qdl a(oidb_cmd0xbc9.AdReport paramAdReport)
  {
    qdl localqdl = new qdl();
    localqdl.a = paramAdReport.bytes_report_url.get().toStringUtf8();
    return localqdl;
  }
  
  public oidb_cmd0xbc9.AdReport a()
  {
    oidb_cmd0xbc9.AdReport localAdReport = new oidb_cmd0xbc9.AdReport();
    localAdReport.bytes_report_url.set(ByteStringMicro.copyFromUtf8(this.a));
    return localAdReport;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qdl
 * JD-Core Version:    0.7.0.1
 */