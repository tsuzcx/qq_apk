package com.tencent.qqmini.miniapp.util;

import android.app.Activity;
import android.view.View;
import com.tencent.qqmini.sdk.widget.actionsheet.ActionSheet;
import com.tencent.qqmini.sdk.widget.actionsheet.ActionSheet.OnButtonClickListener;

class FileChooserHelper$5
  implements ActionSheet.OnButtonClickListener
{
  FileChooserHelper$5(FileChooserHelper paramFileChooserHelper, Activity paramActivity, String paramString, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt == 1) {
        FileChooserHelper.access$200(this.this$0, this.val$caller, this.val$accept);
      }
    }
    else {
      FileChooserHelper.access$400(this.this$0, this.val$caller);
    }
    this.val$actionSheet.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.util.FileChooserHelper.5
 * JD-Core Version:    0.7.0.1
 */