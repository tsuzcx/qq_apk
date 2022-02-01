package com.tencent.mobileqq.filemanager.activity.localfile;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.adapter.ImageHolder;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QfileBaseLocalFileTabView$5
  implements View.OnClickListener
{
  QfileBaseLocalFileTabView$5(QfileBaseLocalFileTabView paramQfileBaseLocalFileTabView) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = paramView.getTag();
    boolean bool2 = localObject1 instanceof QfileLocalFileBaseExpandableListAdapter.LocalItemHolder;
    boolean bool1 = true;
    FileInfo localFileInfo = null;
    Object localObject2;
    if (bool2)
    {
      localObject1 = (QfileLocalFileBaseExpandableListAdapter.LocalItemHolder)paramView.getTag();
      localFileInfo = (FileInfo)((QfileLocalFileBaseExpandableListAdapter.LocalItemHolder)localObject1).j;
      localObject1 = ((QfileLocalFileBaseExpandableListAdapter.LocalItemHolder)localObject1).g;
    }
    else if ((localObject1 instanceof ImageHolder))
    {
      localObject2 = (ImageHolder)paramView.getTag();
      localFileInfo = (FileInfo)((ImageHolder)localObject2).i;
      localObject1 = ((ImageHolder)localObject2).a;
      if ((this.a.C.F()) || (this.a.C.G()))
      {
        SharedPreferences.Editor localEditor = this.a.C.getSharedPreferences("LAST_CHOOSE_", 0).edit();
        localEditor.putInt("GROUP", ((ImageHolder)localObject2).h);
        localEditor.putInt("CHILD", (((ImageHolder)localObject2).g + 1) / 4);
        localEditor.commit();
      }
    }
    else
    {
      localObject1 = null;
    }
    if ((paramView.getId() == 2131433103) && (QfileBaseLocalFileTabView.c(this.a))) {
      ReportController.b(QfileBaseLocalFileTabView.d(this.a), "dc00898", "", "", "0X800A665", "0X800A665", 0, 0, "", "", "", "");
    }
    if (localFileInfo != null)
    {
      localObject2 = this.a;
      if (paramView.getId() != 2131433103) {
        bool1 = false;
      }
      ((QfileBaseLocalFileTabView)localObject2).a(localFileInfo, (View)localObject1, bool1);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView.5
 * JD-Core Version:    0.7.0.1
 */