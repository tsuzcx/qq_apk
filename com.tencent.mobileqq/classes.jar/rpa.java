import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.emoticonview.EmotionKeywordHorizonListView.HorizonListViewTouchListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.XEditTextEx;
import mqq.os.MqqHandler;

public class rpa
  implements EmotionKeywordHorizonListView.HorizonListViewTouchListener
{
  public rpa(BaseChatPie paramBaseChatPie) {}
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    default: 
      return;
    case 0: 
      this.a.jdField_a_of_type_MqqOsMqqHandler.removeMessages(67);
      ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "slide", 0, 0, "", "", "", this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString());
      return;
    }
    this.a.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(67, 5000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rpa
 * JD-Core Version:    0.7.0.1
 */