import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.utils.ImageUtil;
import java.util.List;

public class scu
  implements Runnable
{
  public scu(ChatSettingForTroop paramChatSettingForTroop, long paramLong) {}
  
  public void run()
  {
    int j = this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.b.size();
    int i = 0;
    ImageView localImageView;
    Object localObject;
    if (i < j)
    {
      localImageView = (ImageView)this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.b.get(i);
      localObject = (String)localImageView.getTag();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {}
    }
    for (;;)
    {
      i += 1;
      break;
      try
      {
        long l = Long.valueOf((String)localObject).longValue();
        if (l == this.jdField_a_of_type_Long)
        {
          localObject = ImageUtil.a();
          localObject = FaceDrawable.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.app, 1, Long.toString(this.jdField_a_of_type_Long), 3, (Drawable)localObject, (Drawable)localObject, 4);
          this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.runOnUiThread(new scv(this, localImageView, (FaceDrawable)localObject));
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     scu
 * JD-Core Version:    0.7.0.1
 */