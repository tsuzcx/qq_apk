import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import tencent.im.oidb.cmd0xbc9.oidb_cmd0xbc9.AdReport;

public class qdi
{
  public String a;
  
  public static qdi a(oidb_cmd0xbc9.AdReport paramAdReport)
  {
    qdi localqdi = new qdi();
    localqdi.a = paramAdReport.bytes_report_url.get().toStringUtf8();
    return localqdi;
  }
  
  public oidb_cmd0xbc9.AdReport a()
  {
    oidb_cmd0xbc9.AdReport localAdReport = new oidb_cmd0xbc9.AdReport();
    localAdReport.bytes_report_url.set(ByteStringMicro.copyFromUtf8(this.a));
    return localAdReport;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qdi
 * JD-Core Version:    0.7.0.1
 */