import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class msu
  extends BroadcastReceiver
{
  msu(mst parammst) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    msw localmsw;
    if (paramIntent.getAction().equals("tencent.video.q2v.getNearByProfile"))
    {
      paramContext = paramIntent.getStringExtra("uin");
      localmsw = new msw(this.a);
      localmsw.jdField_a_of_type_JavaLangString = paramContext;
      localmsw.jdField_b_of_type_JavaLangString = paramIntent.getStringExtra("nickname");
      localmsw.jdField_a_of_type_Int = paramIntent.getIntExtra("gender", -1);
      localmsw.jdField_b_of_type_Int = paramIntent.getIntExtra("age", 0);
      localmsw.jdField_a_of_type_Byte = paramIntent.getByteExtra("constellation", (byte)-1);
      paramIntent = lcb.a().c(this.a.jdField_a_of_type_JavaLangString);
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
        lcv locallcv = this.a.jdField_a_of_type_ComTencentAvVideoController.a(paramContext);
        if (locallcv != null)
        {
          this.a.jdField_a_of_type_ComTencentAvVideoController.a(paramContext, localmsw.jdField_b_of_type_JavaLangString, false);
          locallcv.c = localmsw.jdField_a_of_type_Int;
        }
        if (paramContext.equals(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getAccount()))
        {
          paramIntent.a.d = localmsw.jdField_a_of_type_Int;
          paramIntent.a.f = localmsw.jdField_b_of_type_JavaLangString;
        }
        if (paramContext.equals(paramIntent.d))
        {
          paramIntent.a.c = localmsw.jdField_a_of_type_Int;
          paramIntent.a.jdField_b_of_type_JavaLangString = localmsw.jdField_b_of_type_JavaLangString;
        }
      }
    } while ((this.a.jdField_a_of_type_Msv == null) || (!this.a.jdField_a_of_type_JavaUtilList.contains(paramContext)));
    if (QLog.isColorLevel()) {
      QLog.d("NearbyPeopleProfileHelper", 2, "onGetNearbyPeopleProfile uin :" + paramContext + ", nickname:" + localmsw.jdField_b_of_type_JavaLangString + ", gender:" + localmsw.jdField_a_of_type_Int);
    }
    this.a.jdField_a_of_type_Msv.a(paramContext, localmsw);
    this.a.jdField_a_of_type_JavaUtilList.remove(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     msu
 * JD-Core Version:    0.7.0.1
 */