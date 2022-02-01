package com.tencent.mobileqq.qcall;

import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.phonecontact.util.PhoneContactHelper;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;

class QCallDetailActivity$7
  implements AdapterView.OnItemClickListener
{
  QCallDetailActivity$7(QCallDetailActivity paramQCallDetailActivity) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = PhoneContactHelper.a(((TextView)paramView.findViewById(2131374196)).getText().toString());
    paramView = this.a;
    paramView.a(paramView.getActivity(), paramAdapterView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.qcall.QCallDetailActivity.7
 * JD-Core Version:    0.7.0.1
 */