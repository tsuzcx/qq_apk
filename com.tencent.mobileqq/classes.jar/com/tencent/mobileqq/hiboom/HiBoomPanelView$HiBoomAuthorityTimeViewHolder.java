package com.tencent.mobileqq.hiboom;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.VasH5PayUtil;
import java.util.concurrent.atomic.AtomicBoolean;

public class HiBoomPanelView$HiBoomAuthorityTimeViewHolder
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  public TextView a;
  public TextView b;
  
  public HiBoomPanelView$HiBoomAuthorityTimeViewHolder(HiBoomPanelView paramHiBoomPanelView, View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131375505));
    this.b = ((TextView)paramView.findViewById(2131375506));
    this.b.setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    VasH5PayUtil.a(this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomPanelView.getContext(), "mvip.g.a.zt_high", "CJCLUBT", 3, false, true);
    ((HiBoomManager)this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomPanelView.a.a.getManager(218)).b.set(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.HiBoomPanelView.HiBoomAuthorityTimeViewHolder
 * JD-Core Version:    0.7.0.1
 */