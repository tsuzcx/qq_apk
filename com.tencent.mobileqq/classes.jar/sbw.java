import android.graphics.Bitmap;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.richstatus.IIconListener;
import com.tencent.mobileqq.richstatus.RichStatus;

public class sbw
  implements IIconListener
{
  public sbw(ChatSettingActivity paramChatSettingActivity) {}
  
  public void a(int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    if ((this.a.f != null) && (this.a.a != null) && (this.a.a.actionId == paramInt1) && (paramBitmap != null) && (paramInt2 == 200)) {
      ChatSettingActivity.a(this.a, this.a.a, this.a.f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sbw
 * JD-Core Version:    0.7.0.1
 */