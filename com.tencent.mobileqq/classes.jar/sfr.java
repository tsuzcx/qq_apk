import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.theme.diy.ThemeBackground;
import com.tencent.mobileqq.vas.VasApngUtil;
import mqq.os.MqqHandler;

public class sfr
  implements Runnable
{
  public sfr(Conversation paramConversation) {}
  
  public void run()
  {
    this.a.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1051);
    ThemeBackground localThemeBackground = new ThemeBackground();
    if (ThemeUtil.isNowThemeIsDIY())
    {
      localThemeBackground.pageIndex = 100;
      ThemeBackground.getThemeBackground(this.a.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getContext(), "theme_bg_message_path_png", this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), localThemeBackground);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_MqqOsMqqHandler.sendMessage(this.a.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(1051, localThemeBackground));
      return;
      if (ThemeUtil.isNowThemeIsAnimate())
      {
        localThemeBackground.path = ThemeUtil.getAnimatePathByTag(2);
        Drawable localDrawable = this.a.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getContext().getResources().getDrawable(2130845679);
        localThemeBackground.img = VasApngUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localThemeBackground.path, "-conversation-", localDrawable, VasApngUtil.a, "-conversation-", null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sfr
 * JD-Core Version:    0.7.0.1
 */