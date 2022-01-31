import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.Button;
import com.tencent.biz.qqstory.takevideo.EditPicQzonePublishActivity;

public class obr
  implements DialogInterface.OnClickListener
{
  public obr(EditPicQzonePublishActivity paramEditPicQzonePublishActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    EditPicQzonePublishActivity.a(this.a, false);
    EditPicQzonePublishActivity.a(this.a).setSelected(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     obr
 * JD-Core Version:    0.7.0.1
 */