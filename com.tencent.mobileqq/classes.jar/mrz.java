import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class mrz
  extends BroadcastReceiver
{
  mrz(mry parammry) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    msb localmsb;
    if (paramIntent.getAction().equals("tencent.video.q2v.getNearByProfile"))
    {
      paramContext = paramIntent.getStringExtra("uin");
      localmsb = new msb(this.a);
      localmsb.jdField_a_of_type_JavaLangString = paramContext;
      localmsb.jdField_b_of_type_JavaLangString = paramIntent.getStringExtra("nickname");
      localmsb.jdField_a_of_type_Int = paramIntent.getIntExtra("gender", -1);
      localmsb.jdField_b_of_type_Int = paramIntent.getIntExtra("age", 0);
      localmsb.jdField_a_of_type_Byte = paramIntent.getByteExtra("constellation", (byte)-1);
      paramIntent = ldc.a().b(this.a.jdField_a_of_type_JavaLangString);
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
        ldw localldw = this.a.jdField_a_of_type_ComTencentAvVideoController.a(paramContext);
        if (localldw != null)
        {
          this.a.jdField_a_of_type_ComTencentAvVideoController.a(paramContext, localmsb.jdField_b_of_type_JavaLangString, false);
          localldw.jdField_b_of_type_Int = localmsb.jdField_a_of_type_Int;
        }
        if (paramContext.equals(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getAccount()))
        {
          paramIntent.a.d = localmsb.jdField_a_of_type_Int;
          paramIntent.a.f = localmsb.jdField_b_of_type_JavaLangString;
        }
        if (paramContext.equals(paramIntent.d))
        {
          paramIntent.a.c = localmsb.jdField_a_of_type_Int;
          paramIntent.a.jdField_b_of_type_JavaLangString = localmsb.jdField_b_of_type_JavaLangString;
        }
      }
    } while ((this.a.jdField_a_of_type_Msa == null) || (!this.a.jdField_a_of_type_JavaUtilList.contains(paramContext)));
    if (QLog.isColorLevel()) {
      QLog.d("NearbyPeopleProfileHelper", 2, "onGetNearbyPeopleProfile uin :" + paramContext + ", nickname:" + localmsb.jdField_b_of_type_JavaLangString + ", gender:" + localmsb.jdField_a_of_type_Int);
    }
    this.a.jdField_a_of_type_Msa.a(paramContext, localmsb);
    this.a.jdField_a_of_type_JavaUtilList.remove(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mrz
 * JD-Core Version:    0.7.0.1
 */