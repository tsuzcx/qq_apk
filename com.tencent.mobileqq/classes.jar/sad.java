import UserGrowth.stReportItem;
import UserGrowth.stWeishiReportReq;
import UserGrowth.stWeishiReportRsp;
import java.util.ArrayList;

public class sad
  extends ryw<stWeishiReportRsp>
{
  public sad(ArrayList<stReportItem> paramArrayList)
  {
    super("WeishiReport");
    this.a = new stWeishiReportReq(paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     sad
 * JD-Core Version:    0.7.0.1
 */