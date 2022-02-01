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
  private final WeakReference<QQAppInterface> a;
  private final String b;
  private final String c;
  private int d;
  private int e;
  private int f;
  private boolean g;
  
  private VipUtils$VipIconUtils$VipIconTouchListener(QQAppInterface paramQQAppInterface, String paramString1, String paramString2) {}
  
  public static VipIconTouchListener a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    return new VipIconTouchListener(paramQQAppInterface, paramString1, paramString2);
  }
  
  public void a()
  {
    String str = this.c;
    int i = this.e;
    boolean bool;
    if (this.f != 0) {
      bool = true;
    } else {
      bool = false;
    }
    VipUtils.VipIconUtils.a(str, i, bool);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.get();
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
    VipIconCallback.VipIconClickConfig localVipIconClickConfig = VipIconCallback.sInstance.findConfig(this.d, this.e, this.f);
    paramMotionEvent = this.c;
    int i = this.e;
    if (this.f != 0) {
      bool1 = true;
    }
    VipUtils.VipIconUtils.b(paramMotionEvent, i, bool1);
    String str = localQQAppInterface.getCurrentAccountUin();
    bool1 = this.b.equals(str);
    if ((localVipIconClickConfig != null) && (!TextUtils.isEmpty(this.b)))
    {
      if ("VIA_SETTINGME".equals(this.c))
      {
        paramMotionEvent = localVipIconClickConfig.d;
      }
      else
      {
        if ("VIA_PROFILECARD".equals(this.c)) {
          if (bool1) {
            paramMotionEvent = localVipIconClickConfig.e;
          } else {
            paramMotionEvent = localVipIconClickConfig.g;
          }
        }
        for (;;)
        {
          break;
          if ("VIA_AIO_TITLE".equals(this.c))
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
            if (!"VIA_AIO_CHATSETTINGS".equals(this.c)) {
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
          localObject = paramMotionEvent.replace("{uin}", this.b);
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
    if ("VIA_SETTINGME".equals(this.c))
    {
      if (this.g)
      {
        VipUtils.a(localQQAppInterface, paramView.getContext(), this.d, this.b, "cty");
        return true;
      }
      VipUtils.b(localQQAppInterface, paramView.getContext(), "cty");
      return true;
    }
    if ("VIA_PROFILECARD".equals(this.c))
    {
      bool2 = this.g;
      paramMotionEvent = "zlk";
      if (bool2)
      {
        paramView = paramView.getContext();
        i = this.d;
        localObject = this.b;
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
    if ("VIA_AIO_TITLE".equals(this.c))
    {
      bool2 = this.g;
      paramMotionEvent = "ctoc";
      if (bool2)
      {
        paramView = paramView.getContext();
        i = this.d;
        localObject = this.b;
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
    if ("VIA_AIO_CHATSETTINGS".equals(this.c))
    {
      bool2 = this.g;
      paramMotionEvent = "ctocsetkr";
      if (bool2)
      {
        paramView = paramView.getContext();
        i = this.d;
        localObject = this.b;
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
    if (this.g)
    {
      VipUtils.a(localQQAppInterface, paramView.getContext(), this.d, this.b, "unknow");
      return true;
    }
    VipUtils.b(localQQAppInterface, paramView.getContext(), "unknow");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.VipUtils.VipIconUtils.VipIconTouchListener
 * JD-Core Version:    0.7.0.1
 */