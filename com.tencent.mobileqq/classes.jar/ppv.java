import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.pts.nativemodule.IPTSLoadFeeds;
import com.tencent.qphone.base.util.QLog;

public class ppv
  implements IPTSLoadFeeds
{
  private final String jdField_a_of_type_JavaLangString = "PTSLoadFeedsModule";
  private ppe jdField_a_of_type_Ppe = new ppw(this);
  
  public ppv()
  {
    ppd.a().a(this.jdField_a_of_type_Ppe);
  }
  
  public void loadFeeds(long paramLong1, long paramLong2, int paramInt, long paramLong3)
  {
    oso localoso = (oso)((QQAppInterface)onk.a()).getManager(163);
    QLog.i("PTSLoadFeedsModule", 1, "[loadFeeds], channelID = " + paramLong1 + ", limitCount = " + paramInt);
    if (localoso != null) {
      localoso.a().a((int)paramLong1, paramInt, 9223372036854775807L, true, paramLong3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ppv
 * JD-Core Version:    0.7.0.1
 */