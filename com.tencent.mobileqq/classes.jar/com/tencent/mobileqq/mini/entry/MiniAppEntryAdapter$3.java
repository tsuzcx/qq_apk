package com.tencent.mobileqq.mini.entry;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class MiniAppEntryAdapter$3
  implements View.OnClickListener
{
  MiniAppEntryAdapter$3(MiniAppEntryAdapter paramMiniAppEntryAdapter) {}
  
  public void onClick(View paramView)
  {
    if ((paramView instanceof TextView))
    {
      localObject = ((TextView)paramView).getText();
      if (localObject != null)
      {
        localObject = ((CharSequence)localObject).toString();
        break label31;
      }
    }
    Object localObject = null;
    label31:
    int i = paramView.getId();
    if ((i >= 0) && (i < MiniAppEntryAdapter.access$400(this.this$0).size()))
    {
      paramView = (MiniAppInfo)MiniAppEntryAdapter.access$400(this.this$0).get(i);
      MiniAppEntryAdapter.access$500(this.this$0, (String)localObject, paramView);
    }
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("onClick. onMenuItemSelected, position = ");
      paramView.append(i);
      QLog.i("MiniAppEntryAdapter", 2, paramView.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppEntryAdapter.3
 * JD-Core Version:    0.7.0.1
 */