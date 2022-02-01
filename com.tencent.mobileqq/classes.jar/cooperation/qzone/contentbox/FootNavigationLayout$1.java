package cooperation.qzone.contentbox;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.contentbox.model.BottomItem;
import cooperation.qzone.report.lp.LpReportInfo_dc02880;
import cooperation.qzone.report.lp.LpReportManager;

class FootNavigationLayout$1
  implements View.OnClickListener
{
  FootNavigationLayout$1(FootNavigationLayout paramFootNavigationLayout, BottomItem paramBottomItem, int paramInt) {}
  
  public void onClick(View paramView)
  {
    Object localObject = JumpParser.a(((BaseActivity)this.this$0.getContext()).app, this.this$0.getContext(), this.val$bottomItem.url);
    if (localObject != null) {
      ((JumpAction)localObject).a();
    }
    for (;;)
    {
      localObject = new LpReportInfo_dc02880(7, FootNavigationLayout.access$000()[this.val$index]);
      LpReportManager.getInstance().reportToDC02880((LpReportInfo_dc02880)localObject, false, true);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localObject = new Intent(this.this$0.getContext(), QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", this.val$bottomItem.url);
      QZoneHelper.addSource((Intent)localObject);
      this.this$0.getContext().startActivity((Intent)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.contentbox.FootNavigationLayout.1
 * JD-Core Version:    0.7.0.1
 */