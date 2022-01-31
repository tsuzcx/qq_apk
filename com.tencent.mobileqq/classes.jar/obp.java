import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.biz.qqstory.takevideo.EditPicQzonePublishActivity;
import com.tencent.mobileqq.activity.richmedia.QzoneSyncQQStoryTool;

public class obp
  implements View.OnClickListener
{
  public obp(EditPicQzonePublishActivity paramEditPicQzonePublishActivity, long paramLong) {}
  
  public void onClick(View paramView)
  {
    boolean bool = true;
    if (EditPicQzonePublishActivity.b(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditPicQzonePublishActivity))
    {
      EditPicQzonePublishActivity.b(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditPicQzonePublishActivity).setSelected(false);
      paramView = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditPicQzonePublishActivity;
      if (EditPicQzonePublishActivity.b(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditPicQzonePublishActivity)) {
        break label73;
      }
    }
    for (;;)
    {
      EditPicQzonePublishActivity.b(paramView, bool);
      QzoneSyncQQStoryTool.a(this.jdField_a_of_type_Long, EditPicQzonePublishActivity.b(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditPicQzonePublishActivity));
      return;
      EditPicQzonePublishActivity.b(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditPicQzonePublishActivity).setSelected(true);
      break;
      label73:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     obp
 * JD-Core Version:    0.7.0.1
 */