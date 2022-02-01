package com.tencent.mobileqq.utils;

import QQService.EVIPSPEC;
import akle;
import amsw;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import bgam;
import bgan;
import bgao;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SingleLineTextView;
import mqq.util.WeakReference;

public class VipUtils$UpdateRecentEfficientVipIconTask
  implements Runnable
{
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<View> jdField_a_of_type_MqqUtilWeakReference;
  private boolean jdField_a_of_type_Boolean = true;
  private WeakReference<Context> b;
  private WeakReference<akle> c;
  
  VipUtils$UpdateRecentEfficientVipIconTask(View paramView, Context paramContext, String paramString, akle paramakle)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramView);
    this.b = new WeakReference(paramContext);
    this.c = new WeakReference(paramakle);
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  private View a()
  {
    return (View)this.jdField_a_of_type_MqqUtilWeakReference.get();
  }
  
  static void a(Context paramContext, String paramString, akle paramakle)
  {
    QQAppInterface localQQAppInterface = ((BaseActivity)paramContext).app;
    Object localObject = (amsw)localQQAppInterface.getManager(51);
    boolean bool = ((amsw)localObject).c;
    localObject = ((amsw)localObject).e(paramString);
    int i;
    label111:
    int j;
    if ((localObject != null) && (bgan.a(((Friends)localObject).nameplateVipType)))
    {
      i = 1;
      if (i != 0)
      {
        if (bgan.b(((Friends)localObject).grayNameplateFlag)) {
          break label221;
        }
        String str = bgan.a(localQQAppInterface, ((Friends)localObject).uin, bgao.a(((Friends)localObject).nameplateVipType), false);
        VipUtils.a(paramakle.a, paramContext, str, bgan.a(bgao.a(((Friends)localObject).nameplateVipType)));
      }
      j = VipUtils.a(localQQAppInterface, paramString);
      if (QLog.isColorLevel()) {
        QLog.d("VipUtils", 2, "bindView: vip=" + j);
      }
      if (j >> 8 != 3) {
        break label308;
      }
      paramString = bgan.a(localQQAppInterface, paramString, EVIPSPEC.E_SP_BIGCLUB);
      if ((j & 0xF) != 1) {
        break label252;
      }
      if (!bool) {
        break label233;
      }
      paramakle.a.setTextColor(paramContext.getResources().getColor(2131167156));
      label200:
      if (i == 0) {
        VipUtils.a(paramakle.a, paramContext, paramString, 2130846979);
      }
    }
    for (;;)
    {
      return;
      i = 0;
      break;
      label221:
      paramakle.a.setCompoundDrawablesWithIntrinsicBounds(0, 0);
      break label111;
      label233:
      paramakle.a.setTextColor(paramContext.getResources().getColor(2131167019));
      break label200;
      label252:
      if (bool) {
        paramakle.a.setTextColor(paramContext.getResources().getColor(2131167156));
      }
      while (i == 0)
      {
        VipUtils.a(paramakle.a, paramContext, paramString, 2130846977);
        return;
        paramakle.a.setTextColor(paramContext.getResources().getColor(2131167019));
      }
      continue;
      label308:
      if (j >> 8 == 1)
      {
        if (bool) {
          paramakle.a.setTextColor(paramContext.getResources().getColor(2131167156));
        }
        for (;;)
        {
          paramString = bgan.a(localQQAppInterface, paramString, EVIPSPEC.E_SP_QQVIP);
          if (i != 0) {
            break;
          }
          VipUtils.a(paramakle.a, paramContext, paramString, 2130846978);
          return;
          paramakle.a.setTextColor(paramContext.getResources().getColor(2131167019));
        }
      }
      if (j >> 8 != 2) {
        break label523;
      }
      paramString = bgan.a(localQQAppInterface, paramString, EVIPSPEC.E_SP_SUPERVIP);
      if ((j & 0xF) == 1)
      {
        if (bool) {
          paramakle.a.setTextColor(paramContext.getResources().getColor(2131167156));
        }
        while (i == 0)
        {
          VipUtils.a(paramakle.a, paramContext, paramString, 2130846979);
          return;
          paramakle.a.setTextColor(paramContext.getResources().getColor(2131167019));
        }
      }
      else
      {
        if (bool) {
          paramakle.a.setTextColor(paramContext.getResources().getColor(2131167156));
        }
        while (i == 0)
        {
          VipUtils.a(paramakle.a, paramContext, paramString, 2130846977);
          return;
          paramakle.a.setTextColor(paramContext.getResources().getColor(2131167019));
        }
      }
    }
    label523:
    paramakle.a.setTextColor(paramContext.getResources().getColor(2131167019));
    paramakle.a.setCompoundDrawablesWithIntrinsicBounds(0, 0);
  }
  
  public void run()
  {
    bgam.b(this);
    if (!this.jdField_a_of_type_Boolean) {
      if (QLog.isColorLevel()) {
        QLog.w("VipUtils", 1, "updateRecentEfficientVipIcon async - not Valid");
      }
    }
    do
    {
      return;
      Context localContext = (Context)this.b.get();
      akle localakle = (akle)this.c.get();
      if ((localContext != null) && (localakle != null)) {
        a(localContext, this.jdField_a_of_type_JavaLangString, localakle);
      }
    } while (!QLog.isColorLevel());
    QLog.w("VipUtils", 1, "updateRecentEfficientVipIcon async - sucess : " + this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.VipUtils.UpdateRecentEfficientVipIconTask
 * JD-Core Version:    0.7.0.1
 */