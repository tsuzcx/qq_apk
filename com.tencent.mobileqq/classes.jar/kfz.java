import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.SessionMgr;
import com.tencent.av.VideoController;
import com.tencent.av.VideoController.GAudioFriends;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.NearbyPeopleProfileHelper;
import com.tencent.av.utils.NearbyPeopleProfileHelper.INearbyPeopleProfileCallBack;
import com.tencent.av.utils.NearbyPeopleProfileHelper.NearbyProfileData;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class kfz
  extends BroadcastReceiver
{
  public kfz(NearbyPeopleProfileHelper paramNearbyPeopleProfileHelper) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    NearbyPeopleProfileHelper.NearbyProfileData localNearbyProfileData;
    if (paramIntent.getAction().equals("tencent.video.q2v.getNearByProfile"))
    {
      paramContext = paramIntent.getStringExtra("uin");
      localNearbyProfileData = new NearbyPeopleProfileHelper.NearbyProfileData(this.a);
      localNearbyProfileData.jdField_a_of_type_JavaLangString = paramContext;
      localNearbyProfileData.jdField_b_of_type_JavaLangString = paramIntent.getStringExtra("nickname");
      localNearbyProfileData.jdField_a_of_type_Int = paramIntent.getIntExtra("gender", -1);
      localNearbyProfileData.jdField_b_of_type_Int = paramIntent.getIntExtra("age", 0);
      localNearbyProfileData.jdField_a_of_type_Byte = paramIntent.getByteExtra("constellation", (byte)-1);
      paramIntent = SessionMgr.a().a(this.a.jdField_a_of_type_JavaLangString);
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
        VideoController.GAudioFriends localGAudioFriends = this.a.jdField_a_of_type_ComTencentAvVideoController.a(paramContext);
        if (localGAudioFriends != null)
        {
          this.a.jdField_a_of_type_ComTencentAvVideoController.a(paramContext, localNearbyProfileData.jdField_b_of_type_JavaLangString, false);
          localGAudioFriends.jdField_b_of_type_Int = localNearbyProfileData.jdField_a_of_type_Int;
        }
        if (paramContext.equals(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getAccount()))
        {
          paramIntent.a.d = localNearbyProfileData.jdField_a_of_type_Int;
          paramIntent.a.f = localNearbyProfileData.jdField_b_of_type_JavaLangString;
        }
        if (paramContext.equals(paramIntent.c))
        {
          paramIntent.a.c = localNearbyProfileData.jdField_a_of_type_Int;
          paramIntent.a.jdField_b_of_type_JavaLangString = localNearbyProfileData.jdField_b_of_type_JavaLangString;
        }
      }
    } while ((this.a.jdField_a_of_type_ComTencentAvUtilsNearbyPeopleProfileHelper$INearbyPeopleProfileCallBack == null) || (!this.a.jdField_a_of_type_JavaUtilList.contains(paramContext)));
    if (QLog.isColorLevel()) {
      QLog.d("NearbyPeopleProfileHelper", 2, "onGetNearbyPeopleProfile uin :" + paramContext + ", nickname:" + localNearbyProfileData.jdField_b_of_type_JavaLangString + ", gender:" + localNearbyProfileData.jdField_a_of_type_Int);
    }
    this.a.jdField_a_of_type_ComTencentAvUtilsNearbyPeopleProfileHelper$INearbyPeopleProfileCallBack.a(paramContext, localNearbyProfileData);
    this.a.jdField_a_of_type_JavaUtilList.remove(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kfz
 * JD-Core Version:    0.7.0.1
 */