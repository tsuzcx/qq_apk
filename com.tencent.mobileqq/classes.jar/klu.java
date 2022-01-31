import com.tencent.biz.common.util.FileChooserHelper;
import com.tencent.widget.ActionSheet.OnDismissListener;

public class klu
  implements ActionSheet.OnDismissListener
{
  public klu(FileChooserHelper paramFileChooserHelper) {}
  
  public void onDismiss()
  {
    FileChooserHelper.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     klu
 * JD-Core Version:    0.7.0.1
 */