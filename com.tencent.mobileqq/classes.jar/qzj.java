import android.view.View;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.widget.presseffect.PressEffectImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;

class qzj
  implements bkhe
{
  int jdField_a_of_type_Int = 0;
  View jdField_a_of_type_AndroidViewView = null;
  int jdField_b_of_type_Int = 0;
  View jdField_b_of_type_AndroidViewView = null;
  
  qzj(qzi paramqzi, AbsListView paramAbsListView, ChatMessage paramChatMessage) {}
  
  private void a()
  {
    int i;
    int j;
    label84:
    PressEffectImageView localPressEffectImageView;
    if ((this.jdField_a_of_type_ComTencentWidgetAbsListView.getChildAt(0) != null) && ("RIJRedPacketStruttingMsgItemBuilder".equals(this.jdField_a_of_type_ComTencentWidgetAbsListView.getChildAt(0).getTag(2131369971))))
    {
      i = 1;
      if ((this.jdField_a_of_type_ComTencentWidgetAbsListView.getChildAt(this.jdField_a_of_type_ComTencentWidgetAbsListView.getChildCount() - 1) == null) || (!"RIJRedPacketStruttingMsgItemBuilder".equals(this.jdField_a_of_type_ComTencentWidgetAbsListView.getChildAt(this.jdField_a_of_type_ComTencentWidgetAbsListView.getChildCount() - 1).getTag(2131369971)))) {
        break label260;
      }
      j = 1;
      if (((this.jdField_a_of_type_AndroidViewView != null) && ((this.jdField_a_of_type_AndroidViewView == this.jdField_a_of_type_ComTencentWidgetAbsListView.getChildAt(0)) || (this.jdField_a_of_type_ComTencentWidgetAbsListView.getChildAt(0) == null) || (this.jdField_a_of_type_ComTencentWidgetAbsListView.getChildAt(0).getTop() >= this.jdField_a_of_type_Int))) || (i == 0)) {
        break label265;
      }
      QLog.d("RIJRedPacketStruttingMsgItemBuilder", 1, "qqqqqqqqqqqqqqqqqqqqqqqqqqq 1");
      localPressEffectImageView = (PressEffectImageView)this.jdField_a_of_type_ComTencentWidgetAbsListView.getChildAt(0).findViewById(2131375974);
      qzi.a(this.jdField_a_of_type_Qzi, localPressEffectImageView);
      qzi.a(this.jdField_a_of_type_Qzi, (MessageForStructing)this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentWidgetAbsListView.getChildAt(0);
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentWidgetAbsListView.getChildAt(this.jdField_a_of_type_ComTencentWidgetAbsListView.getChildCount() - 1);
      if (this.jdField_a_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidViewView.getTop();
      }
      if (this.jdField_b_of_type_AndroidViewView != null) {
        this.jdField_b_of_type_Int = this.jdField_b_of_type_AndroidViewView.getTop();
      }
      return;
      i = 0;
      break;
      label260:
      j = 0;
      break label84;
      label265:
      if (((this.jdField_b_of_type_AndroidViewView == null) || ((this.jdField_b_of_type_AndroidViewView != this.jdField_a_of_type_ComTencentWidgetAbsListView.getChildAt(this.jdField_a_of_type_ComTencentWidgetAbsListView.getChildCount() - 1)) && (this.jdField_a_of_type_ComTencentWidgetAbsListView.getChildAt(this.jdField_a_of_type_ComTencentWidgetAbsListView.getChildCount() - 1) != null) && (this.jdField_a_of_type_ComTencentWidgetAbsListView.getChildAt(this.jdField_a_of_type_ComTencentWidgetAbsListView.getChildCount() - 1).getTop() > this.jdField_b_of_type_Int))) && (j != 0))
      {
        QLog.d("RIJRedPacketStruttingMsgItemBuilder", 1, "qqqqqqqqqqqqqqqqqqqqqqqqqqq 2");
        localPressEffectImageView = (PressEffectImageView)this.jdField_a_of_type_ComTencentWidgetAbsListView.getChildAt(this.jdField_a_of_type_ComTencentWidgetAbsListView.getChildCount() - 1).findViewById(2131375974);
        qzi.a(this.jdField_a_of_type_Qzi, localPressEffectImageView);
        qzi.a(this.jdField_a_of_type_Qzi, (MessageForStructing)this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
      }
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    a();
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qzj
 * JD-Core Version:    0.7.0.1
 */