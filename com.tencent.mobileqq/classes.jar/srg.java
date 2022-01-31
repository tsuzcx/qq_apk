import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.FriendProfileCardActivity.ColorScreenLoader;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;
import com.tencent.mobileqq.vas.VasMonitorHandler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;

public class srg
  implements OnCompositionLoadedListener
{
  public srg(FriendProfileCardActivity.ColorScreenLoader paramColorScreenLoader) {}
  
  public void onCompositionLoaded(LottieComposition paramLottieComposition)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ColorScreenManager", 2, "onCompositionLoaded: composition= " + paramLottieComposition);
    }
    if (paramLottieComposition == null)
    {
      VasMonitorHandler.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "individual_v2_colorscreen_parse_fail", "0", "", Integer.toString(this.a.jdField_a_of_type_Int), null, null, 0.0F, 0.0F);
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqDiniflyLottieComposition = paramLottieComposition;
    this.a.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.b.postDelayed(this.a, 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     srg
 * JD-Core Version:    0.7.0.1
 */