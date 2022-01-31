import com.tencent.biz.common.util.FileChooserHelper;
import com.tencent.widget.ActionSheet.OnDismissListener;

public class kmj
  implements ActionSheet.OnDismissListener
{
  public kmj(FileChooserHelper paramFileChooserHelper) {}
  
  public void onDismiss()
  {
    FileChooserHelper.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kmj
 * JD-Core Version:    0.7.0.1
 */