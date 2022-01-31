import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import tencent.im.oidb.cmd0xbc9.oidb_cmd0xbc9.AdReport;

public class qne
{
  public String a;
  
  public static qne a(oidb_cmd0xbc9.AdReport paramAdReport)
  {
    qne localqne = new qne();
    localqne.a = paramAdReport.bytes_report_url.get().toStringUtf8();
    return localqne;
  }
  
  public oidb_cmd0xbc9.AdReport a()
  {
    oidb_cmd0xbc9.AdReport localAdReport = new oidb_cmd0xbc9.AdReport();
    localAdReport.bytes_report_url.set(ByteStringMicro.copyFromUtf8(this.a));
    return localAdReport;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qne
 * JD-Core Version:    0.7.0.1
 */