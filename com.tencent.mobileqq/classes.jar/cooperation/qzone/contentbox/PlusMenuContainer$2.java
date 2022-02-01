package cooperation.qzone.contentbox;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;

class PlusMenuContainer$2
  implements View.OnClickListener
{
  PlusMenuContainer$2(PlusMenuContainer paramPlusMenuContainer) {}
  
  public void onClick(View paramView)
  {
    String str;
    if ((paramView.getTag() != null) && ((paramView.getTag() instanceof String)))
    {
      str = (String)paramView.getTag();
      Intent localIntent = new Intent();
      localIntent.putExtra("cmd", "Schema");
      localIntent.putExtra("schema", str);
      QZoneHelper.forwardToQzoneTransluentActivity((Activity)this.this$0.context, QZoneHelper.UserInfo.getInstance(), localIntent);
      if (!str.equals(PlusMenuContainer.defaultScheme[0])) {
        break label101;
      }
      LpReportInfo_pf00064.report(133, 2);
    }
    for (;;)
    {
      this.this$0.hide();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label101:
      if (str.equals(PlusMenuContainer.defaultScheme[1])) {
        LpReportInfo_pf00064.report(133, 3);
      } else if (str.equals(PlusMenuContainer.defaultScheme[2])) {
        LpReportInfo_pf00064.report(133, 4);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.contentbox.PlusMenuContainer.2
 * JD-Core Version:    0.7.0.1
 */