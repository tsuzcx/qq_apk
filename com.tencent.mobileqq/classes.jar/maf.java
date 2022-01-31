import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.biz.pubaccount.readinjoy.video.TopicShareHelper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoShareListener;

public class maf
  implements DialogInterface.OnDismissListener
{
  public maf(TopicShareHelper paramTopicShareHelper) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (TopicShareHelper.a(this.a) != null) {
      TopicShareHelper.a(this.a).a(TopicShareHelper.a(this.a), TopicShareHelper.b(this.a), false, false);
    }
    TopicShareHelper.a(this.a, true);
    TopicShareHelper.b(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     maf
 * JD-Core Version:    0.7.0.1
 */