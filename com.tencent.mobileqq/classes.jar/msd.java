import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class msd
  extends BroadcastReceiver
{
  msd(msc parammsc) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    msf localmsf;
    if (paramIntent.getAction().equals("tencent.video.q2v.getNearByProfile"))
    {
      paramContext = paramIntent.getStringExtra("uin");
      localmsf = new msf(this.a);
      localmsf.jdField_a_of_type_JavaLangString = paramContext;
      localmsf.jdField_b_of_type_JavaLangString = paramIntent.getStringExtra("nickname");
      localmsf.jdField_a_of_type_Int = paramIntent.getIntExtra("gender", -1);
      localmsf.jdField_b_of_type_Int = paramIntent.getIntExtra("age", 0);
      localmsf.jdField_a_of_type_Byte = paramIntent.getByteExtra("constellation", (byte)-1);
      paramIntent = lbu.a().c(this.a.jdField_a_of_type_JavaLangString);
      if (paramIntent != null) {
        break label98;
      }
    }
    label98:
    do
    {
      return;
      if (this.a.jdField_a_of_type_ComTencentAvVideoController != null)
      {
        lcp locallcp = this.a.jdField_a_of_type_ComTencentAvVideoController.a(paramContext);
        if (locallcp != null)
        {
          this.a.jdField_a_of_type_ComTencentAvVideoController.a(paramContext, localmsf.jdField_b_of_type_JavaLangString, false);
          locallcp.c = localmsf.jdField_a_of_type_Int;
        }
        if (paramContext.equals(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getAccount()))
        {
          paramIntent.a.d = localmsf.jdField_a_of_type_Int;
          paramIntent.a.f = localmsf.jdField_b_of_type_JavaLangString;
        }
        if (paramContext.equals(paramIntent.d))
        {
          paramIntent.a.c = localmsf.jdField_a_of_type_Int;
          paramIntent.a.jdField_b_of_type_JavaLangString = localmsf.jdField_b_of_type_JavaLangString;
        }
      }
    } while ((this.a.jdField_a_of_type_Mse == null) || (!this.a.jdField_a_of_type_JavaUtilList.contains(paramContext)));
    if (QLog.isColorLevel()) {
      QLog.d("NearbyPeopleProfileHelper", 2, "onGetNearbyPeopleProfile uin :" + paramContext + ", nickname:" + localmsf.jdField_b_of_type_JavaLangString + ", gender:" + localmsf.jdField_a_of_type_Int);
    }
    this.a.jdField_a_of_type_Mse.a(paramContext, localmsf);
    this.a.jdField_a_of_type_JavaUtilList.remove(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     msd
 * JD-Core Version:    0.7.0.1
 */