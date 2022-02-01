package cooperation.troop_homework.jsp;

import android.view.View;
import com.tencent.mobileqq.webview.swift.WebViewUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class TroopHWJsPlugin$2
  implements ActionSheet.OnButtonClickListener
{
  TroopHWJsPlugin$2(TroopHWJsPlugin paramTroopHWJsPlugin, int paramInt, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt == 1) {
        this.c.a(this.a);
      }
    }
    else {
      TroopHWJsPlugin.a(this.c, (WebViewUtil.a("homework") << 8) + 2);
    }
    this.b.superDismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.troop_homework.jsp.TroopHWJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */