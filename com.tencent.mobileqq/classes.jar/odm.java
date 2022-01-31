import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.qqstory.takevideo.EditVideoLabel;
import com.tencent.biz.qqstory.takevideo.EditVideoPartManager;
import com.tencent.biz.qqstory.takevideo.label.QQStoryAddVideoLabelViewPart;

public class odm
  implements View.OnClickListener
{
  public odm(EditVideoLabel paramEditVideoLabel) {}
  
  public void onClick(View paramView)
  {
    if (!TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoLabelQQStoryAddVideoLabelViewPart.jdField_a_of_type_JavaLangString))
    {
      this.a.jdField_a_of_type_JavaLangString = this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoLabelQQStoryAddVideoLabelViewPart.jdField_a_of_type_JavaLangString;
      paramView = this.a.jdField_a_of_type_AndroidWidgetTextView.getText().toString();
      if ((paramView.equals("##")) || (TextUtils.isEmpty(paramView)) || (!paramView.equals("# " + this.a.jdField_a_of_type_JavaLangString)))
      {
        EditVideoPartManager localEditVideoPartManager = this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager;
        if (this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a())
        {
          paramView = "2";
          localEditVideoPartManager.a("use_custom_tag", 0, 0, new String[] { paramView });
        }
      }
      else
      {
        this.a.jdField_a_of_type_AndroidWidgetTextView.setText("# " + this.a.jdField_a_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(0);
      return;
      paramView = "1";
      break;
      this.a.jdField_a_of_type_JavaLangString = "";
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText("");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     odm
 * JD-Core Version:    0.7.0.1
 */