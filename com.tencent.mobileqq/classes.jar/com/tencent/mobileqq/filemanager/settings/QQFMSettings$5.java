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
    View localView = RelativeLayout.inflate(this.a, 2131627071, null);
    TextView localTextView = (TextView)localView.findViewById(2131438908);
    localTextView.setText(this.this$0.g);
    ((TextView)localView.findViewById(2131433142)).setText(this.this$0.h);
    ProgressBar localProgressBar = (ProgressBar)localView.findViewById(2131433115);
    localProgressBar.setVisibility(8);
    QQFMSettings localQQFMSettings = this.this$0;
    Activity localActivity = this.a;
    String str = HardCodeUtil.a(2131902667);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.this$0.g);
    localStringBuilder.append('\n');
    localStringBuilder.append(this.this$0.h);
    localQQFMSettings.a = DialogUtil.a(localActivity, 0, 2131624596, str, localStringBuilder.toString(), HardCodeUtil.a(2131889250), HardCodeUtil.a(2131902669), new QQFMSettings.5.1(this, localTextView, localProgressBar), new QQFMSettings.5.2(this)).addView(localView);
    FileManagerReporter.a("0X8005BE1");
    this.this$0.a.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.settings.QQFMSettings.5
 * JD-Core Version:    0.7.0.1
 */