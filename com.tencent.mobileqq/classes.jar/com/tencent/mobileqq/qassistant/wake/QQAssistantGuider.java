package com.tencent.mobileqq.qassistant.wake;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qassistant.view.VoicePanelSlideContainer;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingPermission;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import mqq.app.AppActivity;
import mqq.app.MobileQQ;

public class QQAssistantGuider
  extends ReportDialog
{
  static boolean jdField_a_of_type_Boolean = false;
  public static volatile boolean b = false;
  int jdField_a_of_type_Int = 2;
  protected Context a;
  VoicePanelSlideContainer jdField_a_of_type_ComTencentMobileqqQassistantViewVoicePanelSlideContainer;
  AppActivity jdField_a_of_type_MqqAppAppActivity;
  boolean c = false;
  
  public QQAssistantGuider(@NonNull AppActivity paramAppActivity)
  {
    super(paramAppActivity, 2131755376);
    this.jdField_a_of_type_AndroidContentContext = paramAppActivity;
    setCanceledOnTouchOutside(true);
    this.jdField_a_of_type_MqqAppAppActivity = paramAppActivity;
    WakeManager.a().b("QQAssistantGuider()");
    if (QQAssistantGuiderUtil.a()) {
      jdField_a_of_type_Boolean = true;
    }
    this.c = true;
  }
  
  public static void a()
  {
    b = false;
    jdField_a_of_type_Boolean = false;
    QQAssistantGuiderUtil.a(true);
  }
  
  public void dismiss()
  {
    b = false;
    int i = this.jdField_a_of_type_Int;
    if (i > 0) {
      ReportController.b(null, "dc00898", "", "", "0X800B44B", "0X800B44B", i, 0, "", "", "", "");
    }
    if (this.c) {
      WakeManager.a().a("QQAssistantGuider dismiss");
    }
    super.dismiss();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560978, null);
    setContentView(paramBundle);
    Object localObject = paramBundle.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).width = paramBundle.getResources().getDisplayMetrics().widthPixels;
    paramBundle.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = getWindow();
    ((Window)localObject).setWindowAnimations(2131755930);
    ((Window)localObject).setGravity(80);
    this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoicePanelSlideContainer = ((VoicePanelSlideContainer)paramBundle.findViewById(2131377654));
    this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoicePanelSlideContainer.setPanelSlideListener(new QQAssistantGuider.1(this));
    ((ImageView)paramBundle.findViewById(2131362936)).setOnClickListener(new QQAssistantGuider.2(this));
    boolean bool1;
    if ((Build.VERSION.SDK_INT >= 23) && (MobileQQ.sMobileQQ.checkSelfPermission("android.permission.RECORD_AUDIO") != 0)) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    boolean bool2 = ((IQQFloatingPermission)QRoute.api(IQQFloatingPermission.class)).checkPermission(MobileQQ.sMobileQQ);
    localObject = (TextView)paramBundle.findViewById(2131377678);
    Button localButton = (Button)paramBundle.findViewById(2131363730);
    ((Button)paramBundle.findViewById(2131363729)).setOnClickListener(new QQAssistantGuider.3(this));
    if ((bool1) && (bool2))
    {
      ((TextView)localObject).setVisibility(8);
      localButton.setOnClickListener(new QQAssistantGuider.4(this));
      return;
    }
    localButton.setOnClickListener(new QQAssistantGuider.5(this, bool1, bool2));
  }
  
  public void show()
  {
    b = true;
    QQAssistantGuiderUtil.a(false);
    super.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.wake.QQAssistantGuider
 * JD-Core Version:    0.7.0.1
 */