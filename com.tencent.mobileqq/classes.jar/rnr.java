import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import tencent.im.oidb.cmd0x5bd.oidb_0x5bd.AdReport;

public class rnr
{
  public String a;
  
  public static rnr a(oidb_0x5bd.AdReport paramAdReport)
  {
    rnr localrnr = new rnr();
    localrnr.a = paramAdReport.bytes_report_url.get().toStringUtf8();
    return localrnr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rnr
 * JD-Core Version:    0.7.0.1
 */