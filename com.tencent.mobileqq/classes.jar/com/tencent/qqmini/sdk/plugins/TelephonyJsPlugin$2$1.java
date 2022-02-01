package com.tencent.qqmini.sdk.plugins;

import android.view.View;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.widget.actionsheet.ActionSheet;
import com.tencent.qqmini.sdk.widget.actionsheet.ActionSheet.OnButtonClickListener;

class TelephonyJsPlugin$2$1
  implements ActionSheet.OnButtonClickListener
{
  TelephonyJsPlugin$2$1(TelephonyJsPlugin.2 param2, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    for (;;)
    {
      try
      {
        paramView = this.this$1.this$0;
        localObject = this.this$1.val$req.event;
        String str = this.this$1.val$req.jsonParams;
        if (paramInt == 0)
        {
          bool = true;
          TelephonyJsPlugin.access$200(paramView, (String)localObject, str, bool);
          this.val$actionSheet.dismiss();
          return;
        }
      }
      catch (Exception paramView)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.this$1.val$req.event);
        ((StringBuilder)localObject).append(" error.");
        QMLog.e("TelephonyJsPlugin", ((StringBuilder)localObject).toString(), paramView);
        return;
      }
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.TelephonyJsPlugin.2.1
 * JD-Core Version:    0.7.0.1
 */