package com.tencent.mobileqq.utils;

import android.content.Intent;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.quickupdate.VipIconCallback;
import com.tencent.mobileqq.vas.quickupdate.VipIconCallback.VipIconClickConfig;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import mqq.util.WeakReference;

public class VipUtils$VipIconUtils$VipIconTouchListener
  implements View.OnTouchListener
{
  private int jdField_a_of_type_Int;
  private final String jdField_a_of_type_JavaLangString;
  private final WeakReference<QQAppInterface> jdField_a_of_type_MqqUtilWeakReference;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private final String jdField_b_of_type_JavaLangString;
  private int c;
  
  private VipUtils$VipIconUtils$VipIconTouchListener(QQAppInterface paramQQAppInterface, String paramString1, String paramString2) {}
  
  public static VipIconTouchListener a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    return new VipIconTouchListener(paramQQAppInterface, paramString1, paramString2);
  }
  
  public void a()
  {
    String str = this.jdField_b_of_type_JavaLangString;
    int i = this.jdField_b_of_type_Int;
    boolean bool;
    if (this.c != 0) {
      bool = true;
    } else {
      bool = false;
    }
    VipUtils.VipIconUtils.a(str, i, bool);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if (localQQAppInterface == null) {
      return true;
    }
    boolean bool2 = VipIconCallback.sInstance.isFileExists("namePlate_UrlConfig");
    boolean bool1 = false;
    Object localObject = null;
    if (!bool2) {
      VipIconCallback.sInstance.download("namePlate_UrlConfig", null, false);
    }
    if ((paramMotionEvent != null) && (paramMotionEvent.getAction() != 1)) {
      return true;
    }
    VipIconCallback.VipIconClickConfig localVipIconClickConfig = VipIconCallback.sInstance.findConfig(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.c);
    paramMotionEvent = this.jdField_b_of_type_JavaLangString;
    int i = this.jdField_b_of_type_Int;
    if (this.c != 0) {
      bool1 = true;
    }
    VipUtils.VipIconUtils.b(paramMotionEvent, i, bool1);
    String str = localQQAppInterface.getCurrentAccountUin();
    bool1 = this.jdField_a_of_type_JavaLangString.equals(str);
    if ((localVipIconClickConfig != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      if ("VIA_SETTINGME".equals(this.jdField_b_of_type_JavaLangString))
      {
        paramMotionEvent = localVipIconClickConfig.d;
      }
      else
      {
        if ("VIA_PROFILECARD".equals(this.jdField_b_of_type_JavaLangString)) {
          if (bool1) {
            paramMotionEvent = localVipIconClickConfig.e;
          } else {
            paramMotionEvent = localVipIconClickConfig.g;
          }
        }
        for (;;)
        {
          break;
          if ("VIA_AIO_TITLE".equals(this.jdField_b_of_type_JavaLangString))
          {
            if (bool1) {
              paramMotionEvent = localVipIconClickConfig.f;
            } else {
              paramMotionEvent = localVipIconClickConfig.h;
            }
          }
          else
          {
            paramMotionEvent = (MotionEvent)localObject;
            if (!"VIA_AIO_CHATSETTINGS".equals(this.jdField_b_of_type_JavaLangString)) {
              break;
            }
            if (bool1) {
              paramMotionEvent = localVipIconClickConfig.i;
            } else {
              paramMotionEvent = localVipIconClickConfig.j;
            }
          }
        }
      }
      if (!TextUtils.isEmpty(paramMotionEvent))
      {
        localObject = paramMotionEvent;
        if (!bool1) {
          localObject = paramMotionEvent.replace("{uin}", this.jdField_a_of_type_JavaLangString);
        }
        paramMotionEvent = new Intent(paramView.getContext(), QQBrowserActivity.class);
        paramMotionEvent.putExtra("portraitOnly", true);
        paramMotionEvent.putExtra("uin", str);
        paramMotionEvent.putExtra("hide_operation_bar", true);
        paramMotionEvent.putExtra("hide_more_button", true);
        VasWebviewUtil.b(paramView.getContext(), (String)localObject, 256L, paramMotionEvent, false, -1);
        return true;
      }
    }
    if ("VIA_SETTINGME".equals(this.jdField_b_of_type_JavaLangString))
    {
      if (this.jdField_a_of_type_Boolean)
      {
        VipUtils.a(localQQAppInterface, paramView.getContext(), this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, "cty");
        return true;
      }
      VipUtils.b(localQQAppInterface, paramView.getContext(), "cty");
      return true;
    }
    if ("VIA_PROFILECARD".equals(this.jdField_b_of_type_JavaLangString))
    {
      bool2 = this.jdField_a_of_type_Boolean;
      paramMotionEvent = "zlk";
      if (bool2)
      {
        paramView = paramView.getContext();
        i = this.jdField_a_of_type_Int;
        localObject = this.jdField_a_of_type_JavaLangString;
        if (!bool1) {
          paramMotionEvent = "zlkkr";
        }
        VipUtils.a(localQQAppInterface, paramView, i, (String)localObject, paramMotionEvent);
        return true;
      }
      paramView = paramView.getContext();
      if (!bool1) {
        paramMotionEvent = "zlkkr";
      }
      VipUtils.b(localQQAppInterface, paramView, paramMotionEvent);
      return true;
    }
    if ("VIA_AIO_TITLE".equals(this.jdField_b_of_type_JavaLangString))
    {
      bool2 = this.jdField_a_of_type_Boolean;
      paramMotionEvent = "ctoc";
      if (bool2)
      {
        paramView = paramView.getContext();
        i = this.jdField_a_of_type_Int;
        localObject = this.jdField_a_of_type_JavaLangString;
        if (!bool1) {
          paramMotionEvent = "ctockr";
        }
        VipUtils.a(localQQAppInterface, paramView, i, (String)localObject, paramMotionEvent);
        return true;
      }
      paramView = paramView.getContext();
      if (!bool1) {
        paramMotionEvent = "ctockr";
      }
      VipUtils.b(localQQAppInterface, paramView, paramMotionEvent);
      return true;
    }
    if ("VIA_AIO_CHATSETTINGS".equals(this.jdField_b_of_type_JavaLangString))
    {
      bool2 = this.jdField_a_of_type_Boolean;
      paramMotionEvent = "ctocsetkr";
      if (bool2)
      {
        paramView = paramView.getContext();
        i = this.jdField_a_of_type_Int;
        localObject = this.jdField_a_of_type_JavaLangString;
        if (bool1) {
          paramMotionEvent = "ctocset";
        }
        VipUtils.a(localQQAppInterface, paramView, i, (String)localObject, paramMotionEvent);
        return true;
      }
      paramView = paramView.getContext();
      if (bool1) {
        paramMotionEvent = "ctocset";
      }
      VipUtils.b(localQQAppInterface, paramView, paramMotionEvent);
      return true;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      VipUtils.a(localQQAppInterface, paramView.getContext(), this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, "unknow");
      return true;
    }
    VipUtils.b(localQQAppInterface, paramView.getContext(), "unknow");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.VipUtils.VipIconUtils.VipIconTouchListener
 * JD-Core Version:    0.7.0.1
 */