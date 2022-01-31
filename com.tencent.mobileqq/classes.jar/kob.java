import com.tencent.biz.common.util.FileChooserHelper;
import com.tencent.widget.ActionSheet.OnDismissListener;

public class kob
  implements ActionSheet.OnDismissListener
{
  public kob(FileChooserHelper paramFileChooserHelper) {}
  
  public void onDismiss()
  {
    FileChooserHelper.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kob
 * JD-Core Version:    0.7.0.1
 */