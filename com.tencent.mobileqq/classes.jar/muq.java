import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class muq
  extends BroadcastReceiver
{
  muq(mup parammup) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    mus localmus;
    if (paramIntent.getAction().equals("tencent.video.q2v.getNearByProfile"))
    {
      paramContext = paramIntent.getStringExtra("uin");
      localmus = new mus(this.a);
      localmus.jdField_a_of_type_JavaLangString = paramContext;
      localmus.jdField_b_of_type_JavaLangString = paramIntent.getStringExtra("nickname");
      localmus.jdField_a_of_type_Int = paramIntent.getIntExtra("gender", -1);
      localmus.jdField_b_of_type_Int = paramIntent.getIntExtra("age", 0);
      localmus.jdField_a_of_type_Byte = paramIntent.getByteExtra("constellation", (byte)-1);
      paramIntent = lfb.a().c(this.a.jdField_a_of_type_JavaLangString);
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
        lfu locallfu = this.a.jdField_a_of_type_ComTencentAvVideoController.a(paramContext);
        if (locallfu != null)
        {
          this.a.jdField_a_of_type_ComTencentAvVideoController.a(paramContext, localmus.jdField_b_of_type_JavaLangString, false);
          locallfu.c = localmus.jdField_a_of_type_Int;
        }
        if (paramContext.equals(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getAccount()))
        {
          paramIntent.a.d = localmus.jdField_a_of_type_Int;
          paramIntent.a.f = localmus.jdField_b_of_type_JavaLangString;
        }
        if (paramContext.equals(paramIntent.d))
        {
          paramIntent.a.c = localmus.jdField_a_of_type_Int;
          paramIntent.a.jdField_b_of_type_JavaLangString = localmus.jdField_b_of_type_JavaLangString;
        }
      }
    } while ((this.a.jdField_a_of_type_Mur == null) || (!this.a.jdField_a_of_type_JavaUtilList.contains(paramContext)));
    if (QLog.isColorLevel()) {
      QLog.d("NearbyPeopleProfileHelper", 2, "onGetNearbyPeopleProfile uin :" + paramContext + ", nickname:" + localmus.jdField_b_of_type_JavaLangString + ", gender:" + localmus.jdField_a_of_type_Int);
    }
    this.a.jdField_a_of_type_Mur.a(paramContext, localmus);
    this.a.jdField_a_of_type_JavaUtilList.remove(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     muq
 * JD-Core Version:    0.7.0.1
 */