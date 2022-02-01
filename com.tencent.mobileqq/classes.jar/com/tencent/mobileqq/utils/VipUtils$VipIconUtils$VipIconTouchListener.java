package com.tencent.mobileqq.utils;

import QQService.EVIPSPEC;
import android.content.Intent;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.vas.quickupdate.VipIconCallback;
import com.tencent.mobileqq.vas.quickupdate.VipIconCallback.VipIconClickConfig;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import mqq.util.WeakReference;

public class VipUtils$VipIconUtils$VipIconTouchListener
  implements View.OnTouchListener
{
  private int jdField_a_of_type_Int = 0;
  private final String jdField_a_of_type_JavaLangString;
  private final WeakReference<QQAppInterface> jdField_a_of_type_MqqUtilWeakReference;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 0;
  private final String jdField_b_of_type_JavaLangString;
  private int c = 0;
  
  private VipUtils$VipIconUtils$VipIconTouchListener(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramQQAppInterface);
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    Friends localFriends = ((FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(paramString1);
    int i;
    if (localFriends != null)
    {
      if (!VipUtils.VipIconUtils.a(localFriends.nameplateVipType)) {
        break label194;
      }
      paramQQAppInterface = VipUtils.VipIconUtils.NamePlateVipTpye.a(localFriends.nameplateVipType);
      if (!VipUtils.VipIconUtils.b(localFriends.grayNameplateFlag)) {
        break label144;
      }
      i = 1;
      this.c = i;
      this.jdField_a_of_type_Int = paramQQAppInterface.jdField_a_of_type_Int;
      if ((paramQQAppInterface != VipUtils.VipIconUtils.NamePlateVipTpye.f) && (paramQQAppInterface != VipUtils.VipIconUtils.NamePlateVipTpye.g)) {
        break label150;
      }
      this.jdField_b_of_type_Int = localFriends.bigClubTemplateId;
      this.jdField_a_of_type_Boolean = true;
    }
    label144:
    label150:
    label194:
    do
    {
      do
      {
        return;
        i = 0;
        break;
        if ((paramQQAppInterface == VipUtils.VipIconUtils.NamePlateVipTpye.d) || (paramQQAppInterface == VipUtils.VipIconUtils.NamePlateVipTpye.e))
        {
          this.jdField_b_of_type_Int = localFriends.superVipTemplateId;
          return;
        }
      } while ((paramQQAppInterface != VipUtils.VipIconUtils.NamePlateVipTpye.b) && (paramQQAppInterface != VipUtils.VipIconUtils.NamePlateVipTpye.c));
      this.jdField_b_of_type_Int = 0;
      return;
      i = VipUtils.a(paramQQAppInterface, paramString1);
      paramString2 = null;
      if (i >> 8 == 3) {
        paramString2 = EVIPSPEC.E_SP_BIGCLUB;
      }
      while (paramString2 == EVIPSPEC.E_SP_BIGCLUB)
      {
        this.jdField_a_of_type_Int = VipUtils.a(paramQQAppInterface, paramString1, EVIPSPEC.E_SP_BIGCLUB);
        this.jdField_a_of_type_Int = (this.jdField_a_of_type_Int >> 8 | (this.jdField_a_of_type_Int & 0xF) << 8);
        this.jdField_b_of_type_Int = localFriends.bigClubTemplateId;
        this.jdField_a_of_type_Boolean = true;
        return;
        if (i >> 8 == 1) {
          paramString2 = EVIPSPEC.E_SP_QQVIP;
        } else if (i >> 8 == 2) {
          paramString2 = EVIPSPEC.E_SP_SUPERVIP;
        }
      }
      if (paramString2 == EVIPSPEC.E_SP_SUPERVIP)
      {
        this.jdField_a_of_type_Int = VipUtils.a(paramQQAppInterface, paramString1, EVIPSPEC.E_SP_SUPERVIP);
        this.jdField_a_of_type_Int = (this.jdField_a_of_type_Int >> 8 | (this.jdField_a_of_type_Int & 0xF) << 8);
        this.jdField_b_of_type_Int = localFriends.superVipTemplateId;
        return;
      }
    } while (paramString2 != EVIPSPEC.E_SP_QQVIP);
    this.jdField_a_of_type_Int = VipUtils.a(paramQQAppInterface, paramString1, EVIPSPEC.E_SP_QQVIP);
    this.jdField_a_of_type_Int = (this.jdField_a_of_type_Int >> 8 | (this.jdField_a_of_type_Int & 0xF) << 8);
    this.jdField_b_of_type_Int = 0;
  }
  
  public static VipIconTouchListener a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    return new VipIconTouchListener(paramQQAppInterface, paramString1, paramString2);
  }
  
  public void a()
  {
    String str = this.jdField_b_of_type_JavaLangString;
    int i = this.jdField_b_of_type_Int;
    if (this.c != 0) {}
    for (boolean bool = true;; bool = false)
    {
      VipUtils.VipIconUtils.a(str, i, bool);
      return;
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    Object localObject = (QQAppInterface)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if (localObject == null) {}
    do
    {
      return true;
      if (!VipIconCallback.sInstance.isFileExists("namePlate_UrlConfig")) {
        VipIconCallback.sInstance.download("namePlate_UrlConfig", null, false);
      }
    } while ((paramMotionEvent != null) && (paramMotionEvent.getAction() != 1));
    paramMotionEvent = VipIconCallback.sInstance.findConfig(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.c);
    String str = this.jdField_b_of_type_JavaLangString;
    int i = this.jdField_b_of_type_Int;
    boolean bool;
    if (this.c != 0)
    {
      bool = true;
      VipUtils.VipIconUtils.b(str, i, bool);
      str = ((QQAppInterface)localObject).getCurrentAccountUin();
      bool = this.jdField_a_of_type_JavaLangString.equals(str);
      if ((paramMotionEvent == null) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {
        break label345;
      }
      if (!"VIA_SETTINGME".equals(this.jdField_b_of_type_JavaLangString)) {
        break label246;
      }
      paramMotionEvent = paramMotionEvent.d;
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramMotionEvent))
      {
        localObject = paramMotionEvent;
        if (!bool) {
          localObject = paramMotionEvent.replace("{uin}", this.jdField_a_of_type_JavaLangString);
        }
        paramMotionEvent = new Intent(paramView.getContext(), QQBrowserActivity.class);
        paramMotionEvent.putExtra("portraitOnly", true);
        paramMotionEvent.putExtra("uin", str);
        paramMotionEvent.putExtra("hide_operation_bar", true);
        paramMotionEvent.putExtra("hide_more_button", true);
        VasWebviewUtil.openQQBrowserWithoutAD(paramView.getContext(), (String)localObject, 256L, paramMotionEvent, false, -1);
        return true;
        bool = false;
        break;
        label246:
        if ("VIA_PROFILECARD".equals(this.jdField_b_of_type_JavaLangString))
        {
          if (bool)
          {
            paramMotionEvent = paramMotionEvent.e;
            continue;
          }
          paramMotionEvent = paramMotionEvent.g;
          continue;
        }
        if ("VIA_AIO_TITLE".equals(this.jdField_b_of_type_JavaLangString))
        {
          if (bool)
          {
            paramMotionEvent = paramMotionEvent.f;
            continue;
          }
          paramMotionEvent = paramMotionEvent.h;
          continue;
        }
        if (!"VIA_AIO_CHATSETTINGS".equals(this.jdField_b_of_type_JavaLangString)) {
          break label718;
        }
        if (bool)
        {
          paramMotionEvent = paramMotionEvent.i;
          continue;
        }
        paramMotionEvent = paramMotionEvent.j;
        continue;
      }
      label345:
      if ("VIA_SETTINGME".equals(this.jdField_b_of_type_JavaLangString))
      {
        if (this.jdField_a_of_type_Boolean)
        {
          VipUtils.a((QQAppInterface)localObject, paramView.getContext(), this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, "cty");
          return true;
        }
        VipUtils.b((QQAppInterface)localObject, paramView.getContext(), "cty");
        return true;
      }
      if ("VIA_PROFILECARD".equals(this.jdField_b_of_type_JavaLangString))
      {
        if (this.jdField_a_of_type_Boolean)
        {
          paramMotionEvent = paramView.getContext();
          i = this.jdField_a_of_type_Int;
          str = this.jdField_a_of_type_JavaLangString;
          if (bool) {}
          for (paramView = "zlk";; paramView = "zlkkr")
          {
            VipUtils.a((QQAppInterface)localObject, paramMotionEvent, i, str, paramView);
            return true;
          }
        }
        paramMotionEvent = paramView.getContext();
        if (bool) {}
        for (paramView = "zlk";; paramView = "zlkkr")
        {
          VipUtils.b((QQAppInterface)localObject, paramMotionEvent, paramView);
          return true;
        }
      }
      if ("VIA_AIO_TITLE".equals(this.jdField_b_of_type_JavaLangString))
      {
        if (this.jdField_a_of_type_Boolean)
        {
          paramMotionEvent = paramView.getContext();
          i = this.jdField_a_of_type_Int;
          str = this.jdField_a_of_type_JavaLangString;
          if (bool) {}
          for (paramView = "ctoc";; paramView = "ctockr")
          {
            VipUtils.a((QQAppInterface)localObject, paramMotionEvent, i, str, paramView);
            return true;
          }
        }
        paramMotionEvent = paramView.getContext();
        if (bool) {}
        for (paramView = "ctoc";; paramView = "ctockr")
        {
          VipUtils.b((QQAppInterface)localObject, paramMotionEvent, paramView);
          return true;
        }
      }
      if ("VIA_AIO_CHATSETTINGS".equals(this.jdField_b_of_type_JavaLangString))
      {
        if (this.jdField_a_of_type_Boolean)
        {
          paramMotionEvent = paramView.getContext();
          i = this.jdField_a_of_type_Int;
          str = this.jdField_a_of_type_JavaLangString;
          if (bool) {}
          for (paramView = "ctocset";; paramView = "ctocsetkr")
          {
            VipUtils.a((QQAppInterface)localObject, paramMotionEvent, i, str, paramView);
            return true;
          }
        }
        paramMotionEvent = paramView.getContext();
        if (bool) {}
        for (paramView = "ctocset";; paramView = "ctocsetkr")
        {
          VipUtils.b((QQAppInterface)localObject, paramMotionEvent, paramView);
          return true;
        }
      }
      if (this.jdField_a_of_type_Boolean)
      {
        VipUtils.a((QQAppInterface)localObject, paramView.getContext(), this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, "unknow");
        return true;
      }
      VipUtils.b((QQAppInterface)localObject, paramView.getContext(), "unknow");
      return true;
      label718:
      paramMotionEvent = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.VipUtils.VipIconUtils.VipIconTouchListener
 * JD-Core Version:    0.7.0.1
 */