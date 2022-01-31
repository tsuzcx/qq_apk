import android.os.Bundle;
import android.view.View;
import com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class nwp
  implements ActionSheet.OnButtonClickListener
{
  public nwp(QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (UIUtils.b()) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentWidgetActionSheet.d();
    } while (!"查看群资料卡".equals(this.jdField_a_of_type_ComTencentWidgetActionSheet.a(paramInt)));
    paramView = TroopInfoActivity.a(this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardQQStoryShareGroupProfileActivity.c, 0);
    paramView.putInt("extra_last_open_from", this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardQQStoryShareGroupProfileActivity.a);
    ChatSettingForTroop.a(this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardQQStoryShareGroupProfileActivity, paramView, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nwp
 * JD-Core Version:    0.7.0.1
 */