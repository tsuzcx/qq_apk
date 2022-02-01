package com.tencent.mobileqq.colornote.smallscreen;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.colornote.ColorNoteRecentView;
import com.tencent.mobileqq.colornote.api.IColorNoteDataService;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.data.ColorNoteUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

class ColorNoteSmallScreenService$1
  extends BroadcastReceiver
{
  ColorNoteSmallScreenService$1(ColorNoteSmallScreenService paramColorNoteSmallScreenService) {}
  
  private void a(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("param_from", -1);
    StringBuilder localStringBuilder;
    if (QLog.isDevelopLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("mReceiver from : ");
      localStringBuilder.append(i);
      QLog.w("ColorNoteSmallScreenService", 1, localStringBuilder.toString());
    }
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 5)
          {
            if (i != 6) {
              return;
            }
            boolean bool = paramIntent.getBooleanExtra("param_custom_night_mode", false);
            this.a.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.setCustomNightMode(bool);
            paramIntent = new StringBuilder();
            paramIntent.append("[onReceive->FromType_CustomNightMode]\n[setCustomNightMode]: ");
            paramIntent.append(bool);
            ColorNoteUtils.a("ColorNoteSmallScreenService", paramIntent.toString());
            return;
          }
          paramIntent = ColorNoteSmallScreenService.a(this.a);
          if ((!ColorNoteRecentView.a(ColorNoteSmallScreenService.b(this.a))) && (((paramIntent.size() == 1) && (ColorNoteUtils.b((ColorNote)paramIntent.get(0)))) || (paramIntent.size() == 0))) {
            this.a.f();
          }
        }
        else
        {
          paramIntent = ColorNoteSmallScreenService.a(this.a);
          if ((paramIntent != null) && (paramIntent.size() != 0))
          {
            this.a.jdField_a_of_type_Int = paramIntent.size();
            this.a.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.a(paramIntent);
            if (ColorNoteUtils.a(paramIntent)) {
              ColorNoteSmallScreenService.a(this.a).a();
            }
            if (QLog.isColorLevel())
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("[onReceive->FromType_UpdateData]\n[visibleColorNotes]: ");
              localStringBuilder.append(this.a.jdField_a_of_type_Int);
              localStringBuilder.append("\n");
              localStringBuilder.append(ColorNoteUtils.b(paramIntent));
              ColorNoteUtils.a("ColorNoteSmallScreenService", localStringBuilder.toString());
            }
          }
        }
      }
      else
      {
        ColorNoteSmallScreenService.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("param_shoule_show_smallscreen", true);
        if (QLog.isDevelopLevel())
        {
          paramIntent = new StringBuilder();
          paramIntent.append("mReceiver from : FromType_BusinessLimit mShouldShow = ");
          paramIntent.append(ColorNoteSmallScreenService.jdField_a_of_type_Boolean);
          QLog.w("ColorNoteSmallScreenService", 1, paramIntent.toString());
        }
      }
    }
    else {
      this.a.e = paramIntent.getBooleanExtra("param_not_in_colornote_list", true);
    }
  }
  
  private boolean a(String paramString, boolean paramBoolean)
  {
    int i;
    if ((paramString != null) && (paramString.contains("openSdk"))) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0)
    {
      paramString = this.a;
      paramString.d = true;
      paramString.f = false;
      return paramBoolean;
    }
    if (((IColorNoteDataService)ColorNoteSmallScreenService.a(this.a).getRuntimeService(IColorNoteDataService.class, "all")).getCurrentColorNoteCount() > 0)
    {
      this.a.f = true;
    }
    else
    {
      paramString = this.a;
      paramString.d = true;
      paramString.f = false;
    }
    return false;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str2 = paramIntent.getAction();
    boolean bool2 = true;
    paramContext = null;
    Object localObject;
    try
    {
      String str1 = paramIntent.getStringExtra("process_name");
      paramContext = str1;
      localObject = str1;
      if (QLog.isDevelopLevel())
      {
        paramContext = str1;
        localObject = new StringBuilder();
        paramContext = str1;
        ((StringBuilder)localObject).append("mReceiver action : ");
        paramContext = str1;
        ((StringBuilder)localObject).append(str2);
        paramContext = str1;
        ((StringBuilder)localObject).append(", process_name :");
        paramContext = str1;
        ((StringBuilder)localObject).append(str1);
        paramContext = str1;
        QLog.w("ColorNoteSmallScreenService", 1, ((StringBuilder)localObject).toString());
        localObject = str1;
      }
    }
    catch (Exception localException)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("action: ");
      ((StringBuilder)localObject).append(str2);
      QLog.e("ColorNoteSmallScreenService", 1, ((StringBuilder)localObject).toString(), localException);
      localObject = paramContext;
    }
    boolean bool1 = bool2;
    try
    {
      if (this.a.b != null)
      {
        this.a.a().removeCallbacks(this.a.b);
        if (str2.equals("action_update_cn_smallscreen_state"))
        {
          a(paramIntent);
          bool1 = bool2;
        }
        else if ("mqq.intent.action.QQ_BACKGROUND".equals(str2))
        {
          this.a.d = false;
          this.a.f = false;
          bool1 = bool2;
        }
        else
        {
          bool1 = bool2;
          if ("mqq.intent.action.QQ_FOREGROUND".equals(str2)) {
            bool1 = a((String)localObject, true);
          }
        }
      }
      if (bool1)
      {
        this.a.a().removeCallbacks(this.a.b);
        this.a.a().postDelayed(this.a.b, 200L);
        return;
      }
    }
    catch (Throwable paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ColorNoteSmallScreenService", 2, "mReceiver fail", paramContext);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenService.1
 * JD-Core Version:    0.7.0.1
 */