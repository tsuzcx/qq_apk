import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.mobileqq.medalwall.MedalWallMng;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class sqt
  implements Runnable
{
  public sqt(FriendProfileCardActivity paramFriendProfileCardActivity, DiniFlyAnimationView paramDiniFlyAnimationView) {}
  
  public void run()
  {
    JSONObject localJSONObject = MedalWallMng.a();
    if (localJSONObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("MedalWallMng", 2, "lottie json is null!");
      }
      return;
    }
    LottieComposition.Factory.fromJson(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.getResources(), localJSONObject, new squ(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sqt
 * JD-Core Version:    0.7.0.1
 */