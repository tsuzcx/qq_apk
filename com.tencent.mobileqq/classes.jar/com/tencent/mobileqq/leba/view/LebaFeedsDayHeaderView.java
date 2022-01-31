package com.tencent.mobileqq.leba.view;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.widget.TextView;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.leba.LebaFeedsAdapter.ListItem;
import com.tencent.mobileqq.leba.LebaUtils;

public class LebaFeedsDayHeaderView
  extends LebaFeedsViewBase
{
  protected TextView a;
  protected TextView b;
  
  public LebaFeedsDayHeaderView(Context paramContext)
  {
    super(paramContext);
    LayoutInflater.from(paramContext).inflate(2130969489, this, true);
    this.a = ((TextView)super.findViewById(2131366702));
    this.b = ((TextView)super.findViewById(2131366703));
    e();
  }
  
  public void a(LebaFeedsAdapter.ListItem paramListItem)
  {
    if (paramListItem == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("LebaFeedsDayHeaderView", 0, " fillData title=" + paramListItem.a + ", time=" + paramListItem.jdField_b_of_type_Int);
    }
    this.b.setText(paramListItem.a);
    this.a.setText(paramListItem.jdField_b_of_type_JavaLangString);
  }
  
  public void e()
  {
    if (this.a != null) {
      this.a.setTextColor(getResources().getColor(LebaUtils.c(3)));
    }
    if (this.b != null) {
      this.b.setTextColor(getResources().getColor(LebaUtils.c(4)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.leba.view.LebaFeedsDayHeaderView
 * JD-Core Version:    0.7.0.1
 */