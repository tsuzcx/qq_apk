import android.content.DialogInterface;
import com.tencent.biz.qqstory.takevideo2.StoryPublishLauncher;
import com.tencent.mobileqq.utils.DialogUtil.DialogOnClickAdapter;

public class olf
  extends DialogUtil.DialogOnClickAdapter
{
  public olf(StoryPublishLauncher paramStoryPublishLauncher) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     olf
 * JD-Core Version:    0.7.0.1
 */