import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.Button;
import com.tencent.biz.qqstory.takevideo.EditPicQzonePublishActivity;

public class odi
  implements DialogInterface.OnClickListener
{
  public odi(EditPicQzonePublishActivity paramEditPicQzonePublishActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    EditPicQzonePublishActivity.a(this.a, true);
    EditPicQzonePublishActivity.a(this.a).setSelected(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     odi
 * JD-Core Version:    0.7.0.1
 */