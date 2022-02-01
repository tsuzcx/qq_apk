package com.tencent.mobileqq.teamworkforgroup;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.TeamWorkUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GroupTeamWorkListActivity$2
  implements View.OnClickListener
{
  GroupTeamWorkListActivity$2(GroupTeamWorkListActivity paramGroupTeamWorkListActivity) {}
  
  public void onClick(View paramView)
  {
    GroupPadTemplateAdapter.GroupPadTemplateItemHolder localGroupPadTemplateItemHolder = (GroupPadTemplateAdapter.GroupPadTemplateItemHolder)paramView.getTag();
    if (localGroupPadTemplateItemHolder.jdField_a_of_type_Int == GroupPadTemplateAdapter.b)
    {
      TeamWorkUtils.a(this.a.app, "0X8009938");
      TeamWorkUtils.a(this.a.app, this.a, 2, "group_online_doc_more_temp", this.a.a, GroupTeamWorkListActivity.a(this.a), this.a.app.getLongAccountUin());
      ReportController.b(this.a.app, "dc00898", "", "", "0X8009C67", "0X8009C67", 0, 0, "", "", "" + GroupTeamWorkListActivity.a(this.a), "");
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      String str = QFileUtils.a(this.a.app, this.a.a, this.a.app.getLongAccountUin());
      if (!TextUtils.isEmpty(str))
      {
        QQToast.a(this.a, str, 0).a();
      }
      else
      {
        TeamWorkUtils.a(this.a.app, "0X8009937");
        TeamWorkUtils.a(this.a.app, this.a, "group_online_doc_temp", GroupTeamWorkListActivity.a(this.a), localGroupPadTemplateItemHolder.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupPadTemplateInfo);
        ReportController.b(this.a.app, "dc00898", "", "", "0X8009C66", "0X8009C66", 0, 0, "", "", "" + GroupTeamWorkListActivity.a(this.a), "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.teamworkforgroup.GroupTeamWorkListActivity.2
 * JD-Core Version:    0.7.0.1
 */