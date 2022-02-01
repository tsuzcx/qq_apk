import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import tencent.im.oidb.cmd0x5bd.oidb_0x5bd.AdReport;

public class rdu
{
  public String a;
  
  public static rdu a(oidb_0x5bd.AdReport paramAdReport)
  {
    rdu localrdu = new rdu();
    localrdu.a = paramAdReport.bytes_report_url.get().toStringUtf8();
    return localrdu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rdu
 * JD-Core Version:    0.7.0.1
 */