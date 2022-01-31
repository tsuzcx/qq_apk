import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.network.handler.ReportEvilToXinanHandler;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public final class nlp
  implements ActionSheet.OnButtonClickListener
{
  public nlp(QQUserUIItem paramQQUserUIItem, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      paramView = "16384";
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.qq)) {
        new ReportEvilToXinanHandler().a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.qq, this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.isFriend(), paramView);
      }
      break;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      paramView = "2";
      break;
      paramView = "1";
      break;
      paramView = "4";
      break;
      SLog.d("Q.qqstory.player.PlayModeUtils", "report user error because evil uin is empty.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nlp
 * JD-Core Version:    0.7.0.1
 */