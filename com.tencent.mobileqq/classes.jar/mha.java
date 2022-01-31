import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class mha
  extends BroadcastReceiver
{
  mha(mgz parammgz) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    mhc localmhc;
    if (paramIntent.getAction().equals("tencent.video.q2v.getNearByProfile"))
    {
      paramContext = paramIntent.getStringExtra("uin");
      localmhc = new mhc(this.a);
      localmhc.jdField_a_of_type_JavaLangString = paramContext;
      localmhc.jdField_b_of_type_JavaLangString = paramIntent.getStringExtra("nickname");
      localmhc.jdField_a_of_type_Int = paramIntent.getIntExtra("gender", -1);
      localmhc.jdField_b_of_type_Int = paramIntent.getIntExtra("age", 0);
      localmhc.jdField_a_of_type_Byte = paramIntent.getByteExtra("constellation", (byte)-1);
      paramIntent = ksn.a().b(this.a.jdField_a_of_type_JavaLangString);
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
        kth localkth = this.a.jdField_a_of_type_ComTencentAvVideoController.a(paramContext);
        if (localkth != null)
        {
          this.a.jdField_a_of_type_ComTencentAvVideoController.a(paramContext, localmhc.jdField_b_of_type_JavaLangString, false);
          localkth.jdField_b_of_type_Int = localmhc.jdField_a_of_type_Int;
        }
        if (paramContext.equals(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getAccount()))
        {
          paramIntent.a.d = localmhc.jdField_a_of_type_Int;
          paramIntent.a.f = localmhc.jdField_b_of_type_JavaLangString;
        }
        if (paramContext.equals(paramIntent.d))
        {
          paramIntent.a.c = localmhc.jdField_a_of_type_Int;
          paramIntent.a.jdField_b_of_type_JavaLangString = localmhc.jdField_b_of_type_JavaLangString;
        }
      }
    } while ((this.a.jdField_a_of_type_Mhb == null) || (!this.a.jdField_a_of_type_JavaUtilList.contains(paramContext)));
    if (QLog.isColorLevel()) {
      QLog.d("NearbyPeopleProfileHelper", 2, "onGetNearbyPeopleProfile uin :" + paramContext + ", nickname:" + localmhc.jdField_b_of_type_JavaLangString + ", gender:" + localmhc.jdField_a_of_type_Int);
    }
    this.a.jdField_a_of_type_Mhb.a(paramContext, localmhc);
    this.a.jdField_a_of_type_JavaUtilList.remove(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mha
 * JD-Core Version:    0.7.0.1
 */