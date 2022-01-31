import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import tencent.im.oidb.cmd0x5bd.oidb_0x5bd.AdReport;

public class qjr
{
  public String a;
  
  public static qjr a(oidb_0x5bd.AdReport paramAdReport)
  {
    qjr localqjr = new qjr();
    localqjr.a = paramAdReport.bytes_report_url.get().toStringUtf8();
    return localqjr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qjr
 * JD-Core Version:    0.7.0.1
 */