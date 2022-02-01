import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import tencent.im.oidb.cmd0x5bd.oidb_0x5bd.AdReport;

public class rbl
{
  public String a;
  
  public static rbl a(oidb_0x5bd.AdReport paramAdReport)
  {
    rbl localrbl = new rbl();
    localrbl.a = paramAdReport.bytes_report_url.get().toStringUtf8();
    return localrbl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rbl
 * JD-Core Version:    0.7.0.1
 */