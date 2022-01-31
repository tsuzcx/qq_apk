import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.biz.qqstory.takevideo.EditPicQzonePublishActivity;

public class odg
  implements View.OnClickListener
{
  public odg(EditPicQzonePublishActivity paramEditPicQzonePublishActivity) {}
  
  public void onClick(View paramView)
  {
    if (!EditPicQzonePublishActivity.a(this.a))
    {
      EditPicQzonePublishActivity.a(this.a);
      return;
    }
    EditPicQzonePublishActivity.a(this.a, false);
    EditPicQzonePublishActivity.a(this.a).setSelected(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     odg
 * JD-Core Version:    0.7.0.1
 */