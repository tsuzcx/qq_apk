package com.tencent.mobileqq.kandian.biz.ugc;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.kandian.repo.handler.TagInfo;
import com.tencent.mobileqq.widget.QQToast;

class ReadInJoyVideoSearchTagFragment$5
  implements AdapterView.OnItemClickListener
{
  ReadInJoyVideoSearchTagFragment$5(ReadInJoyVideoSearchTagFragment paramReadInJoyVideoSearchTagFragment, boolean paramBoolean) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyVideoSearchTagFragment.getQBaseActivity(), 2131718055, 0).a();
    }
    else
    {
      paramView = new Intent();
      paramAdapterView = paramAdapterView.getItemAtPosition(paramInt);
      if ((paramAdapterView != null) && ((paramAdapterView instanceof TagInfo)))
      {
        paramView.putExtra("SEARCH_TAG_RESULT", (TagInfo)paramAdapterView);
        this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyVideoSearchTagFragment.getQBaseActivity().setResult(-1, paramView);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyVideoSearchTagFragment.getQBaseActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyVideoSearchTagFragment.5
 * JD-Core Version:    0.7.0.1
 */