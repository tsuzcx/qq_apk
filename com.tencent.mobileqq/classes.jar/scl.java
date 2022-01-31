import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.immersive.ImmersiveTitleBar2;

public class scl
  implements AbsListView.OnScrollListener
{
  protected int a;
  
  public scl(ChatSettingForTroop paramChatSettingForTroop) {}
  
  private int a(AbsListView paramAbsListView)
  {
    int i = 0;
    View localView = paramAbsListView.getChildAt(0);
    if (localView == null) {
      return 0;
    }
    int j = paramAbsListView.getFirstVisiblePosition();
    int k = localView.getTop();
    if (j >= 1) {
      i = paramAbsListView.getHeight();
    }
    k = -k;
    return i + (localView.getHeight() * j + k);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt) {}
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt1 = a(paramAbsListView);
    Object localObject = null;
    if ((paramInt1 > this.jdField_a_of_type_Int) && (paramInt1 >= this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.n) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0))
    {
      paramAbsListView = this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_AndroidViewAnimationAlphaAnimation;
      if ((paramAbsListView != null) && (paramAbsListView != this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_AndroidWidgetRelativeLayout.getAnimation()))
      {
        paramAbsListView.reset();
        this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_AndroidWidgetRelativeLayout.startAnimation(paramAbsListView);
        this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.startAnimation(paramAbsListView);
        if (paramAbsListView != this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_AndroidViewAnimationAlphaAnimation) {
          break label186;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839147);
        this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130846264);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = paramInt1;
      return;
      paramAbsListView = localObject;
      if (paramInt1 >= this.jdField_a_of_type_Int) {
        break;
      }
      paramAbsListView = localObject;
      if (paramInt1 > this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.n) {
        break;
      }
      paramAbsListView = localObject;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0) {
        break;
      }
      paramAbsListView = this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_b_of_type_AndroidViewAnimationAlphaAnimation;
      break;
      label186:
      if (paramAbsListView == this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_b_of_type_AndroidViewAnimationAlphaAnimation) {
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) && (!this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead))
        {
          if ("1103".equals(ThemeUtil.getCurrentThemeId()))
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130841301);
            this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841302);
          }
          else
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130841454);
            this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841439);
          }
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130841301);
          this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841302);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     scl
 * JD-Core Version:    0.7.0.1
 */