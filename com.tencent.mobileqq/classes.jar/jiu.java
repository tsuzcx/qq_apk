import android.os.Handler;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.av.SessionMgr;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.SessionInfo.Anychat_Info;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.guild.GameHeroesUi;
import com.tencent.av.guild.GuildMultiActivity;
import com.tencent.av.utils.AvAddFriendHelper;
import com.tencent.av.utils.UITools;

public class jiu
  implements Runnable
{
  public jiu(GuildMultiActivity paramGuildMultiActivity) {}
  
  public void run()
  {
    if (this.a.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      Object localObject = UITools.a(this.a.jdField_a_of_type_ComTencentAvVideoController.a());
      if (this.a.jdField_a_of_type_AndroidWidgetTextView != null)
      {
        this.a.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(UITools.a((String)localObject));
        this.a.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        if (this.a.c)
        {
          this.a.c = false;
          this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.a.jdField_d_of_type_JavaLangRunnable, 2500L);
        }
        localObject = SessionMgr.a().a(this.a.e);
        if ((localObject != null) && (((SessionInfo)localObject).a.b == 5)) {
          this.a.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        }
      }
      if (!TextUtils.isEmpty(this.a.jdField_d_of_type_JavaLangString))
      {
        long l = this.a.a(this.a.jdField_d_of_type_JavaLangString);
        int i = this.a.jdField_a_of_type_ComTencentAvUtilsAvAddFriendHelper.a(this.a.jdField_d_of_type_JavaLangString);
        this.a.jdField_a_of_type_ComTencentAvGuildGameHeroesUi.a(i, l);
      }
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this, 1000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jiu
 * JD-Core Version:    0.7.0.1
 */