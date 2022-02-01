package com.tencent.mobileqq.troop.homework.entry.ui;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.troop.homework.recite.ui.SearchReciteArticleFragment;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.util.TroopReportor;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PublishHomeWorkFragment$21
  implements View.OnClickListener
{
  PublishHomeWorkFragment$21(PublishHomeWorkFragment paramPublishHomeWorkFragment) {}
  
  public void onClick(View paramView)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(4) >= 6) {
      QQToast.a(this.a.getActivity(), String.format(HardCodeUtil.a(2131708826), new Object[] { Integer.valueOf(6) }), 0).a();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ((InputMethodManager)this.a.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.a.jdField_a_of_type_AndroidViewViewGroup.getWindowToken(), 0);
      this.a.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.b();
      SearchReciteArticleFragment.a(this.a.getActivity(), this.a.b);
      TroopReportor.a("Grp_edu", "Grp_recite", "Assign_Clk", 0, 0, new String[] { this.a.b });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment.21
 * JD-Core Version:    0.7.0.1
 */