import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiService;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;

class owq
  extends DownloadListener
{
  owq(owi paramowi, Bundle paramBundle) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    this.jdField_a_of_type_AndroidOsBundle.putBoolean("down", true);
    this.jdField_a_of_type_Owi.a.a(87, this.jdField_a_of_type_AndroidOsBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     owq
 * JD-Core Version:    0.7.0.1
 */