import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.pts.nativemodule.IPTSLoadFeeds;
import com.tencent.qphone.base.util.QLog;

public class qzl
  implements IPTSLoadFeeds
{
  private qxz a = new qzm(this);
  
  public qzl()
  {
    qxy.a().a(this.a);
  }
  
  public void loadFeeds(long paramLong1, long paramLong2, int paramInt, long paramLong3)
  {
    pvp localpvp = (pvp)((QQAppInterface)pkh.a()).getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
    QLog.i("PTSLoadFeedsModule", 1, "[loadFeeds], channelID = " + paramLong1 + ", limitCount = " + paramInt);
    if (localpvp != null) {
      localpvp.a().a((int)paramLong1, paramInt, 9223372036854775807L, true, paramLong3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qzl
 * JD-Core Version:    0.7.0.1
 */