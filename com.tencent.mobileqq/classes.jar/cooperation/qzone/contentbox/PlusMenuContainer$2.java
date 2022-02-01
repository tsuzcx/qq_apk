package cooperation.qzone.contentbox;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;

class PlusMenuContainer$2
  implements View.OnClickListener
{
  PlusMenuContainer$2(PlusMenuContainer paramPlusMenuContainer) {}
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() != null) && ((paramView.getTag() instanceof String)))
    {
      paramView = (String)paramView.getTag();
      Intent localIntent = new Intent();
      localIntent.putExtra("cmd", "Schema");
      localIntent.putExtra("schema", paramView);
      QZoneHelper.forwardToQzoneTransluentActivity((Activity)this.this$0.context, QZoneHelper.UserInfo.getInstance(), localIntent);
      if (paramView.equals(PlusMenuContainer.defaultScheme[0])) {
        LpReportInfo_pf00064.report(133, 2);
      } else if (paramView.equals(PlusMenuContainer.defaultScheme[1])) {
        LpReportInfo_pf00064.report(133, 3);
      } else if (paramView.equals(PlusMenuContainer.defaultScheme[2])) {
        LpReportInfo_pf00064.report(133, 4);
      }
    }
    this.this$0.hide();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.contentbox.PlusMenuContainer.2
 * JD-Core Version:    0.7.0.1
 */