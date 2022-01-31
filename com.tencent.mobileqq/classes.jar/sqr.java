import android.view.View;
import android.view.animation.Animation;
import android.widget.TextView;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.widget.ProfileCardMoreInfoView;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.PullToZoomHeaderListView;
import com.tencent.widget.immersive.ImmersiveTitleBar2;

public class sqr
  implements AbsListView.OnScrollListener
{
  public sqr(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (this.a.jdField_b_of_type_Int != paramInt) {
      this.a.jdField_b_of_type_Int = paramInt;
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    paramAbsListView = this.a.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView.getChildAt(0);
    Object localObject;
    if ((paramAbsListView != null) && (paramInt1 == 0))
    {
      if ((this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.jdField_a_of_type_Int == 33) || (this.a.d == null)) {
        return;
      }
      paramInt1 = Math.abs(paramAbsListView.getTop());
      localObject = null;
      if ((paramInt1 <= this.a.jdField_a_of_type_Int) || (paramInt1 < this.a.c) || (this.a.d.getVisibility() != 8)) {
        break label180;
      }
      paramAbsListView = this.a.jdField_a_of_type_AndroidViewAnimationAlphaAnimation;
    }
    for (;;)
    {
      if ((paramAbsListView != null) && (paramAbsListView != this.a.d.getAnimation()))
      {
        paramAbsListView.reset();
        this.a.d.startAnimation(paramAbsListView);
        this.a.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.startAnimation(paramAbsListView);
      }
      this.a.jdField_a_of_type_Int = paramInt1;
      if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView == null) {
        break;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.b("map_key_extend_friend_info");
      return;
      label180:
      paramAbsListView = localObject;
      if (paramInt1 < this.a.jdField_a_of_type_Int)
      {
        paramAbsListView = localObject;
        if (paramInt1 <= this.a.c)
        {
          paramAbsListView = localObject;
          if (this.a.d.getVisibility() == 0) {
            paramAbsListView = this.a.jdField_b_of_type_AndroidViewAnimationAlphaAnimation;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sqr
 * JD-Core Version:    0.7.0.1
 */