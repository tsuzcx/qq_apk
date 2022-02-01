package com.tencent.mobileqq.mini.entry;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.mini.sdk.MiniAppException;
import com.tencent.qphone.base.util.QLog;

class MiniAppEntryAdapter$1
  implements View.OnClickListener
{
  MiniAppEntryAdapter$1(MiniAppEntryAdapter paramMiniAppEntryAdapter) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if (!(localObject instanceof Integer))
    {
      if (QLog.isColorLevel())
      {
        paramView = new StringBuilder();
        paramView.append("onClick. obj = ");
        paramView.append(localObject);
        QLog.i("MiniAppEntryAdapter", 2, paramView.toString());
      }
      return;
    }
    paramView = ((MiniAppEntryAdapter.MicroAppViewHolder)((RecyclerView)paramView.getParent()).getChildViewHolder(paramView)).miniAppInfo;
    int j = MiniAppEntryAdapter.access$000(this.this$0);
    int i = 1001;
    if (j != 0) {
      if (MiniAppEntryAdapter.access$000(this.this$0) == 1) {
        i = 2006;
      } else if (MiniAppEntryAdapter.access$000(this.this$0) == 2) {
        i = 2007;
      }
    }
    try
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("--- click appid:");
      ((StringBuilder)localObject).append(paramView.appId);
      QLog.i("MiniAppEntryAdapter", 1, ((StringBuilder)localObject).toString());
      MiniAppController.launchMiniAppByAppInfo(MiniAppEntryAdapter.access$100(this.this$0), paramView, i);
      j = MiniAppEntryAdapter.access$200(this.this$0, paramView.appId);
      paramView = new MiniAppConfig(paramView);
      localObject = new LaunchParam();
      ((LaunchParam)localObject).scene = i;
      paramView.launchParam = ((LaunchParam)localObject);
      MiniProgramLpReportDC04239.reportAsync(paramView, "page_view", "click_scene", null, String.valueOf(j));
      return;
    }
    catch (MiniAppException paramView)
    {
      paramView.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppEntryAdapter.1
 * JD-Core Version:    0.7.0.1
 */