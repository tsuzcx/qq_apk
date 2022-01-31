import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import tencent.im.oidb.cmd0x5bd.oidb_0x5bd.AdReport;

public class poe
{
  public String a;
  
  public static poe a(oidb_0x5bd.AdReport paramAdReport)
  {
    poe localpoe = new poe();
    localpoe.a = paramAdReport.bytes_report_url.get().toStringUtf8();
    return localpoe;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     poe
 * JD-Core Version:    0.7.0.1
 */