import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import tencent.im.oidb.cmd0x5bd.oidb_0x5bd.AdReport;

public class qun
{
  public String a;
  
  public static qun a(oidb_0x5bd.AdReport paramAdReport)
  {
    qun localqun = new qun();
    localqun.a = paramAdReport.bytes_report_url.get().toStringUtf8();
    return localqun;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qun
 * JD-Core Version:    0.7.0.1
 */