import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.pts.nativemodule.IPTSLoadFeeds;
import com.tencent.qphone.base.util.QLog;

public class qhf
  implements IPTSLoadFeeds
{
  private qfy a = new qhg(this);
  
  public qhf()
  {
    qfx.a().a(this.a);
  }
  
  public void loadFeeds(long paramLong1, long paramLong2, int paramInt, long paramLong3)
  {
    pfg localpfg = (pfg)((QQAppInterface)ozs.a()).getManager(163);
    QLog.i("PTSLoadFeedsModule", 1, "[loadFeeds], channelID = " + paramLong1 + ", limitCount = " + paramInt);
    if (localpfg != null) {
      localpfg.a().a((int)paramLong1, paramInt, 9223372036854775807L, true, paramLong3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qhf
 * JD-Core Version:    0.7.0.1
 */