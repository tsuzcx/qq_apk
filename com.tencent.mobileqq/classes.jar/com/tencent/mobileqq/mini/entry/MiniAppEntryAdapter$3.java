package com.tencent.mobileqq.mini.entry;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class MiniAppEntryAdapter$3
  implements View.OnClickListener
{
  MiniAppEntryAdapter$3(MiniAppEntryAdapter paramMiniAppEntryAdapter) {}
  
  public void onClick(View paramView)
  {
    MiniAppInfo localMiniAppInfo = null;
    Object localObject = localMiniAppInfo;
    if ((paramView instanceof TextView))
    {
      CharSequence localCharSequence = ((TextView)paramView).getText();
      localObject = localMiniAppInfo;
      if (localCharSequence != null) {
        localObject = localCharSequence.toString();
      }
    }
    int i = paramView.getId();
    if ((i >= 0) && (i < MiniAppEntryAdapter.access$400(this.this$0).size()))
    {
      localMiniAppInfo = (MiniAppInfo)MiniAppEntryAdapter.access$400(this.this$0).get(i);
      MiniAppEntryAdapter.access$500(this.this$0, (String)localObject, localMiniAppInfo);
    }
    if (QLog.isColorLevel()) {
      QLog.i("MiniAppEntryAdapter", 2, "onClick. onMenuItemSelected, position = " + i);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppEntryAdapter.3
 * JD-Core Version:    0.7.0.1
 */