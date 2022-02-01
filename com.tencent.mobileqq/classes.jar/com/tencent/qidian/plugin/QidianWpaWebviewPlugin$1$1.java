package com.tencent.qidian.plugin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class QidianWpaWebviewPlugin$1$1
  implements ActionSheet.OnButtonClickListener
{
  QidianWpaWebviewPlugin$1$1(QidianWpaWebviewPlugin.1 param1, Intent paramIntent, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      paramView = this.jdField_a_of_type_AndroidContentIntent.getExtras();
      if ((paramView.containsKey("request_type")) && (paramView.containsKey("uin")) && (paramView.containsKey("sigt")) && (paramView.containsKey("nickname"))) {
        QidianWpaWebviewPlugin.a(this.jdField_a_of_type_ComTencentQidianPluginQidianWpaWebviewPlugin$1.a, paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qidian.plugin.QidianWpaWebviewPlugin.1.1
 * JD-Core Version:    0.7.0.1
 */