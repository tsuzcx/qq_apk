import android.content.Context;
import android.view.Window;
import com.tencent.av.ui.VideoInviteActivity;
import com.tencent.widget.ActionSheet;

public class kbh
  extends ActionSheet
{
  public kbh(VideoInviteActivity paramVideoInviteActivity, Context paramContext)
  {
    super(paramContext);
    super.getWindow().addFlags(524288);
    super.getWindow().addFlags(128);
    super.getWindow().addFlags(1024);
    super.getWindow().addFlags(2097152);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kbh
 * JD-Core Version:    0.7.0.1
 */