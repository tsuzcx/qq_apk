import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class mta
  extends BroadcastReceiver
{
  mta(msz parammsz) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    mtc localmtc;
    if (paramIntent.getAction().equals("tencent.video.q2v.getNearByProfile"))
    {
      paramContext = paramIntent.getStringExtra("uin");
      localmtc = new mtc(this.a);
      localmtc.jdField_a_of_type_JavaLangString = paramContext;
      localmtc.jdField_b_of_type_JavaLangString = paramIntent.getStringExtra("nickname");
      localmtc.jdField_a_of_type_Int = paramIntent.getIntExtra("gender", -1);
      localmtc.jdField_b_of_type_Int = paramIntent.getIntExtra("age", 0);
      localmtc.jdField_a_of_type_Byte = paramIntent.getByteExtra("constellation", (byte)-1);
      paramIntent = lbz.a().c(this.a.jdField_a_of_type_JavaLangString);
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
        lcu locallcu = this.a.jdField_a_of_type_ComTencentAvVideoController.a(paramContext);
        if (locallcu != null)
        {
          this.a.jdField_a_of_type_ComTencentAvVideoController.a(paramContext, localmtc.jdField_b_of_type_JavaLangString, false);
          locallcu.c = localmtc.jdField_a_of_type_Int;
        }
        if (paramContext.equals(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getAccount()))
        {
          paramIntent.a.d = localmtc.jdField_a_of_type_Int;
          paramIntent.a.f = localmtc.jdField_b_of_type_JavaLangString;
        }
        if (paramContext.equals(paramIntent.d))
        {
          paramIntent.a.c = localmtc.jdField_a_of_type_Int;
          paramIntent.a.jdField_b_of_type_JavaLangString = localmtc.jdField_b_of_type_JavaLangString;
        }
      }
    } while ((this.a.jdField_a_of_type_Mtb == null) || (!this.a.jdField_a_of_type_JavaUtilList.contains(paramContext)));
    if (QLog.isColorLevel()) {
      QLog.d("NearbyPeopleProfileHelper", 2, "onGetNearbyPeopleProfile uin :" + paramContext + ", nickname:" + localmtc.jdField_b_of_type_JavaLangString + ", gender:" + localmtc.jdField_a_of_type_Int);
    }
    this.a.jdField_a_of_type_Mtb.a(paramContext, localmtc);
    this.a.jdField_a_of_type_JavaUtilList.remove(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mta
 * JD-Core Version:    0.7.0.1
 */