package com.tencent.mobileqq.filemanager.activity;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;

class TroopFileZipPreviewActivity$1
  implements View.OnClickListener
{
  TroopFileZipPreviewActivity$1(TroopFileZipPreviewActivity paramTroopFileZipPreviewActivity, FileManagerEntity paramFileManagerEntity) {}
  
  public void onClick(View paramView)
  {
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("isNeedFinish", true);
    this.b.setResult(-1, (Intent)localObject);
    TroopFileZipPreviewActivity.a(this.b);
    localObject = this.b.app;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(this.a.TroopUin);
    ReportController.b((AppRuntime)localObject, "dc00899", "Grp_files", null, "oper", "pre_arc_close", 0, 0, localStringBuilder.toString(), "", "", "1");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.TroopFileZipPreviewActivity.1
 * JD-Core Version:    0.7.0.1
 */