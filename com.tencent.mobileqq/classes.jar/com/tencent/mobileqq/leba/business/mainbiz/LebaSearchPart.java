package com.tencent.mobileqq.leba.business.mainbiz;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.leba.business.BaseLebaMainBiz;
import com.tencent.mobileqq.search.util.SearchConfigUtils;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class LebaSearchPart
  extends BaseLebaMainBiz
{
  private EditText b;
  private Button c;
  private RelativeLayout d;
  private View e;
  
  public void a(View paramView)
  {
    QQAppInterface localQQAppInterface = x();
    QBaseActivity localQBaseActivity = d();
    if ((localQQAppInterface != null) && (localQBaseActivity != null))
    {
      this.d = ((RelativeLayout)paramView.findViewById(2131437053));
      this.e = paramView.findViewById(2131437056);
      this.b = ((EditText)this.d.findViewById(2131432634));
      this.b.setCursorVisible(false);
      AccessibilityUtil.a(this.b, localQBaseActivity.getString(2131888115));
      this.c = ((Button)this.d.findViewById(2131429816));
      this.c.setVisibility(8);
      w();
      this.b.setOnFocusChangeListener(new LebaSearchPart.MyFocusChangeListener(localQQAppInterface, localQBaseActivity));
      if (AppSetting.e) {
        AccessibilityUtil.b(paramView);
      }
      return;
    }
    QLog.i("LebaQCirclePartImpl", 1, "initLebaQQCircleView app == null || activity == null");
  }
  
  public void a(boolean paramBoolean)
  {
    w();
  }
  
  public void p()
  {
    w();
  }
  
  public void v()
  {
    w();
  }
  
  public void w()
  {
    if (this.d != null)
    {
      boolean bool = SearchConfigUtils.a();
      Object localObject = this.d;
      int j = 0;
      int i;
      if (bool) {
        i = 0;
      } else {
        i = 8;
      }
      ((RelativeLayout)localObject).setVisibility(i);
      localObject = this.e;
      if (localObject != null)
      {
        if (!bool) {
          i = j;
        } else {
          i = 8;
        }
        ((View)localObject).setVisibility(i);
      }
    }
  }
  
  public QQAppInterface x()
  {
    AppRuntime localAppRuntime = b();
    if (localAppRuntime != null) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.business.mainbiz.LebaSearchPart
 * JD-Core Version:    0.7.0.1
 */