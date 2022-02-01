import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class mrw
  extends BroadcastReceiver
{
  mrw(mrv parammrv) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    mry localmry;
    if (paramIntent.getAction().equals("tencent.video.q2v.getNearByProfile"))
    {
      paramContext = paramIntent.getStringExtra("uin");
      localmry = new mry(this.a);
      localmry.jdField_a_of_type_JavaLangString = paramContext;
      localmry.jdField_b_of_type_JavaLangString = paramIntent.getStringExtra("nickname");
      localmry.jdField_a_of_type_Int = paramIntent.getIntExtra("gender", -1);
      localmry.jdField_b_of_type_Int = paramIntent.getIntExtra("age", 0);
      localmry.jdField_a_of_type_Byte = paramIntent.getByteExtra("constellation", (byte)-1);
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
        lco locallco = this.a.jdField_a_of_type_ComTencentAvVideoController.a(paramContext);
        if (locallco != null)
        {
          this.a.jdField_a_of_type_ComTencentAvVideoController.a(paramContext, localmry.jdField_b_of_type_JavaLangString, false);
          locallco.c = localmry.jdField_a_of_type_Int;
        }
        if (paramContext.equals(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getAccount()))
        {
          paramIntent.a.d = localmry.jdField_a_of_type_Int;
          paramIntent.a.f = localmry.jdField_b_of_type_JavaLangString;
        }
        if (paramContext.equals(paramIntent.d))
        {
          paramIntent.a.c = localmry.jdField_a_of_type_Int;
          paramIntent.a.jdField_b_of_type_JavaLangString = localmry.jdField_b_of_type_JavaLangString;
        }
      }
    } while ((this.a.jdField_a_of_type_Mrx == null) || (!this.a.jdField_a_of_type_JavaUtilList.contains(paramContext)));
    if (QLog.isColorLevel()) {
      QLog.d("NearbyPeopleProfileHelper", 2, "onGetNearbyPeopleProfile uin :" + paramContext + ", nickname:" + localmry.jdField_b_of_type_JavaLangString + ", gender:" + localmry.jdField_a_of_type_Int);
    }
    this.a.jdField_a_of_type_Mrx.a(paramContext, localmry);
    this.a.jdField_a_of_type_JavaUtilList.remove(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mrw
 * JD-Core Version:    0.7.0.1
 */