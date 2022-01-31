package com.tencent.mobileqq.hiboom;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.XEditTextEx;

public class HiBoomPanelView$HiBoomViewHolder
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  public int a;
  public HiBoomTextView a;
  
  public HiBoomPanelView$HiBoomViewHolder(HiBoomPanelView paramHiBoomPanelView, View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView = ((HiBoomTextView)paramView.findViewById(2131375507));
    this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView.setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView.b()) {}
    String str;
    do
    {
      return;
      if (!this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView.a())
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomPanelView.getContext(), "字体正在下载，请稍后点击发送", 0).a();
        return;
      }
      paramView = (HiBoomManager)this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomPanelView.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(218);
      str = HiBoomManager.a(this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomPanelView.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString());
    } while (TextUtils.isEmpty(str));
    int i = this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomPanelView.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomPanelView$HiBoomAdapter.a(this.jdField_a_of_type_Int);
    paramView.a(this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomPanelView.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, str, i);
    this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomPanelView.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText("");
    this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomPanelView.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.ar();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.HiBoomPanelView.HiBoomViewHolder
 * JD-Core Version:    0.7.0.1
 */