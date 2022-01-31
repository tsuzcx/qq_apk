import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.pts.nativemodule.IPTSLoadFeeds;
import com.tencent.qphone.base.util.QLog;

public class pwj
  implements IPTSLoadFeeds
{
  private final String jdField_a_of_type_JavaLangString = "PTSLoadFeedsModule";
  private pvj jdField_a_of_type_Pvj = new pwk(this);
  
  public pwj()
  {
    pvi.a().a(this.jdField_a_of_type_Pvj);
  }
  
  public void loadFeeds(long paramLong1, long paramLong2, int paramInt, long paramLong3)
  {
    oxd localoxd = (oxd)((QQAppInterface)ors.a()).getManager(163);
    QLog.i("PTSLoadFeedsModule", 1, "[loadFeeds], channelID = " + paramLong1 + ", limitCount = " + paramInt);
    if (localoxd != null) {
      localoxd.a().a((int)paramLong1, paramInt, 9223372036854775807L, true, paramLong3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pwj
 * JD-Core Version:    0.7.0.1
 */