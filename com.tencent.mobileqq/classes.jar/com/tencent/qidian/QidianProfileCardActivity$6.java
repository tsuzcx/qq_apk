package com.tencent.qidian;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QidianProfileCardActivity$6
  implements View.OnClickListener
{
  QidianProfileCardActivity$6(QidianProfileCardActivity paramQidianProfileCardActivity) {}
  
  public void onClick(View paramView)
  {
    Object localObject = QidianProfileCardActivity.b(this.a);
    int i;
    if (QidianProfileCardActivity.a(this.a)) {
      i = 1;
    } else {
      i = 3;
    }
    ((TextView)localObject).setMaxLines(i);
    localObject = this.a;
    QidianProfileCardActivity.a((QidianProfileCardActivity)localObject, QidianProfileCardActivity.a((QidianProfileCardActivity)localObject) ^ true);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qidian.QidianProfileCardActivity.6
 * JD-Core Version:    0.7.0.1
 */