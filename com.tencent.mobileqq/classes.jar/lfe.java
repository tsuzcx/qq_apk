import android.content.IntentFilter;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class lfe
{
  public static String a;
  VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  lff jdField_a_of_type_Lff;
  boolean jdField_a_of_type_Boolean = false;
  
  static
  {
    jdField_a_of_type_JavaLangString = "GAudioMsgReceiver";
  }
  
  public lfe(VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_Lff = new lff(paramVideoAppInterface);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().unregisterReceiver(this.jdField_a_of_type_Lff);
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "regist QQGAudioMsg Receiver");
    }
    IntentFilter localIntentFilter = new IntentFilter("tencent.video.q2v.MultiVideo");
    localIntentFilter.addAction("tencent.video.q2v.AddDiscussMember");
    localIntentFilter.addAction("tencent.video.q2v.SwitchToMultiAudo");
    localIntentFilter.addAction("tencent.video.q2v.GroupSystemMsg");
    localIntentFilter.addAction("tencent.video.q2v.SelectMember");
    localIntentFilter.addAction("tencent.video.q2v.ACTION_SELECT_MEMBER_ACTIVITY_IS_RESUME_CHANGED");
    localIntentFilter.addAction("tencent.video.q2v.GvideoGift");
    localIntentFilter.addAction("tencent.video.q2v.GvideoLevelUpgrade");
    localIntentFilter.addAction("tencent.video.q2v.GvideoMemUntInvite");
    localIntentFilter.addAction("tencent.video.q2v.close_invite_msg_box_by_invite_id");
    localIntentFilter.addAction("tencent.video.q2v.randomMultiOwnerOnlinePush");
    localIntentFilter.addAction("tencent.video.q2v.random1V1OnlinePush");
    localIntentFilter.addAction("tencent.video.q2v.avreportOnlinePush");
    localIntentFilter.addAction("tencent.video.q2v.AudioTransPush");
    localIntentFilter.addAction("tencent.video.q2v.AudioEngineReady");
    localIntentFilter.addAction("tencent.video.q2v.GroupInfoChanged");
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().registerReceiver(this.jdField_a_of_type_Lff, localIntentFilter) != null) {
      this.jdField_a_of_type_Boolean = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lfe
 * JD-Core Version:    0.7.0.1
 */