package com.tencent.mobileqq.business.sougou;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;

class HightlightHotWordText$1
  implements ActionSheet.OnButtonClickListener
{
  HightlightHotWordText$1(HightlightHotWordText paramHightlightHotWordText, Context paramContext, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt == 0)
    {
      paramView = new StringBuilder();
      paramView.append(this.c.b);
      paramView.append(this.c.a);
      paramView = paramView.toString();
      if (TextUtils.isEmpty(paramView)) {
        return;
      }
      if ((!paramView.startsWith("http://")) && (!paramView.startsWith("https://"))) {
        return;
      }
      Intent localIntent = new Intent(this.a, QQBrowserActivity.class);
      localIntent.putExtra("url", paramView);
      this.a.startActivity(localIntent);
      if ((this.c.c != null) && (this.c.c.get() != null)) {
        ReportController.b((AppRuntime)this.c.c.get(), "P_CliOper", "aio_search", "", "aio_hotword", "search_hotword", 0, 0, "", "", this.c.a, "");
      }
    }
    this.b.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.business.sougou.HightlightHotWordText.1
 * JD-Core Version:    0.7.0.1
 */