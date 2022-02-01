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

class QQFMSettings$5
  implements Runnable
{
  QQFMSettings$5(QQFMSettings paramQQFMSettings, Activity paramActivity, List paramList, FMSettingInterface.MoveFileCallback paramMoveFileCallback) {}
  
  public void run()
  {
    View localView = RelativeLayout.inflate(this.jdField_a_of_type_AndroidAppActivity, 2131560813, null);
    TextView localTextView = (TextView)localView.findViewById(2131371529);
    localTextView.setText(this.this$0.jdField_a_of_type_JavaLangString);
    ((TextView)localView.findViewById(2131366820)).setText(this.this$0.b);
    ProgressBar localProgressBar = (ProgressBar)localView.findViewById(2131366793);
    localProgressBar.setVisibility(8);
    QQFMSettings localQQFMSettings = this.this$0;
    Activity localActivity = this.jdField_a_of_type_AndroidAppActivity;
    String str = HardCodeUtil.a(2131704765);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.this$0.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\n');
    localStringBuilder.append(this.this$0.b);
    localQQFMSettings.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(localActivity, 0, 2131558963, str, localStringBuilder.toString(), HardCodeUtil.a(2131692263), HardCodeUtil.a(2131704767), new QQFMSettings.5.1(this, localTextView, localProgressBar), new QQFMSettings.5.2(this)).addView(localView);
    FileManagerReporter.a("0X8005BE1");
    this.this$0.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.settings.QQFMSettings.5
 * JD-Core Version:    0.7.0.1
 */