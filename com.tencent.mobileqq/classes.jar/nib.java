import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playmode.child.FeedsPlayModeBase;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class nib
  implements ActionSheet.OnButtonClickListener
{
  public nib(FeedsPlayModeBase paramFeedsPlayModeBase, Boolean[] paramArrayOfBoolean, StoryVideoItem paramStoryVideoItem) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildFeedsPlayModeBase.a.dismiss();
    if (paramView != null)
    {
      String str = this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildFeedsPlayModeBase.a.a(paramInt);
      if (!TextUtils.isEmpty(str)) {
        this.jdField_a_of_type_ArrayOfJavaLangBoolean[0] = Boolean.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildFeedsPlayModeBase.a(paramView, str, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nib
 * JD-Core Version:    0.7.0.1
 */