import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import tencent.im.oidb.cmd0x5bd.oidb_0x5bd.AdReport;

public class pzz
{
  public String a;
  
  public static pzz a(oidb_0x5bd.AdReport paramAdReport)
  {
    pzz localpzz = new pzz();
    localpzz.a = paramAdReport.bytes_report_url.get().toStringUtf8();
    return localpzz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     pzz
 * JD-Core Version:    0.7.0.1
 */