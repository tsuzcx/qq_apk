import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import tencent.im.oidb.cmd0x5bd.oidb_0x5bd.AdReport;

public class pzw
{
  public String a;
  
  public static pzw a(oidb_0x5bd.AdReport paramAdReport)
  {
    pzw localpzw = new pzw();
    localpzw.a = paramAdReport.bytes_report_url.get().toStringUtf8();
    return localpzw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     pzw
 * JD-Core Version:    0.7.0.1
 */