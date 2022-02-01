package com.tencent.mobileqq.filemanager.settings;

import android.app.Activity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import java.util.List;

class FMSettings$5
  implements Runnable
{
  FMSettings$5(FMSettings paramFMSettings, Activity paramActivity, List paramList, FMSettingInterface.MoveFileCallback paramMoveFileCallback) {}
  
  public void run()
  {
    View localView = RelativeLayout.inflate(this.jdField_a_of_type_AndroidAppActivity, 2131560938, null);
    TextView localTextView = (TextView)localView.findViewById(2131371908);
    localTextView.setText(this.this$0.jdField_a_of_type_JavaLangString);
    ((TextView)localView.findViewById(2131366958)).setText(this.this$0.b);
    ProgressBar localProgressBar = (ProgressBar)localView.findViewById(2131366931);
    localProgressBar.setVisibility(8);
    this.this$0.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 0, 2131559069, HardCodeUtil.a(2131704686), this.this$0.jdField_a_of_type_JavaLangString + '\n' + this.this$0.b, HardCodeUtil.a(2131704685), HardCodeUtil.a(2131704688), new FMSettings.5.1(this, localTextView, localProgressBar), new FMSettings.5.2(this)).addView(localView);
    FileManagerReporter.a("0X8005BE1");
    this.this$0.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.settings.FMSettings.5
 * JD-Core Version:    0.7.0.1
 */