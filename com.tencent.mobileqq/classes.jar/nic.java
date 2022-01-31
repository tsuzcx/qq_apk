import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.biz.qqstory.playmode.child.FeedsPlayModeBase;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.support.report.StoryReportor;

public class nic
  implements DialogInterface.OnCancelListener
{
  public nic(FeedsPlayModeBase paramFeedsPlayModeBase) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    StoryReportor.a("story_grp", "clk_one", this.a.a(), 0, new String[] { "6", PlayModeUtils.a(this.a.a, this.a.b), "", "" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nic
 * JD-Core Version:    0.7.0.1
 */