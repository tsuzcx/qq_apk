package com.tencent.mobileqq.utils;

import QQService.EVIPSPEC;
import albw;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import anmw;
import bgtu;
import bgtv;
import bgtw;
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
  private WeakReference<albw> c;
  
  VipUtils$UpdateRecentEfficientVipIconTask(View paramView, Context paramContext, String paramString, albw paramalbw)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramView);
    this.b = new WeakReference(paramContext);
    this.c = new WeakReference(paramalbw);
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  private View a()
  {
    return (View)this.jdField_a_of_type_MqqUtilWeakReference.get();
  }
  
  static void a(Context paramContext, String paramString, albw paramalbw)
  {
    QQAppInterface localQQAppInterface = ((BaseActivity)paramContext).app;
    Object localObject = (anmw)localQQAppInterface.getManager(51);
    boolean bool = ((anmw)localObject).c;
    localObject = ((anmw)localObject).e(paramString);
    int i;
    label111:
    int j;
    if ((localObject != null) && (bgtv.a(((Friends)localObject).nameplateVipType)))
    {
      i = 1;
      if (i != 0)
      {
        if (bgtv.b(((Friends)localObject).grayNameplateFlag)) {
          break label221;
        }
        String str = bgtv.a(localQQAppInterface, ((Friends)localObject).uin, bgtw.a(((Friends)localObject).nameplateVipType), false);
        VipUtils.a(paramalbw.a, paramContext, str, bgtv.a(bgtw.a(((Friends)localObject).nameplateVipType)));
      }
      j = VipUtils.a(localQQAppInterface, paramString);
      if (QLog.isColorLevel()) {
        QLog.d("VipUtils", 2, "bindView: vip=" + j);
      }
      if (j >> 8 != 3) {
        break label308;
      }
      paramString = bgtv.a(localQQAppInterface, paramString, EVIPSPEC.E_SP_BIGCLUB);
      if ((j & 0xF) != 1) {
        break label252;
      }
      if (!bool) {
        break label233;
      }
      paramalbw.a.setTextColor(paramContext.getResources().getColor(2131167123));
      label200:
      if (i == 0) {
        VipUtils.a(paramalbw.a, paramContext, paramString, 2130847054);
      }
    }
    for (;;)
    {
      return;
      i = 0;
      break;
      label221:
      paramalbw.a.setCompoundDrawablesWithIntrinsicBounds(0, 0);
      break label111;
      label233:
      paramalbw.a.setTextColor(paramContext.getResources().getColor(2131166993));
      break label200;
      label252:
      if (bool) {
        paramalbw.a.setTextColor(paramContext.getResources().getColor(2131167123));
      }
      while (i == 0)
      {
        VipUtils.a(paramalbw.a, paramContext, paramString, 2130847052);
        return;
        paramalbw.a.setTextColor(paramContext.getResources().getColor(2131166993));
      }
      continue;
      label308:
      if (j >> 8 == 1)
      {
        if (bool) {
          paramalbw.a.setTextColor(paramContext.getResources().getColor(2131167123));
        }
        for (;;)
        {
          paramString = bgtv.a(localQQAppInterface, paramString, EVIPSPEC.E_SP_QQVIP);
          if (i != 0) {
            break;
          }
          VipUtils.a(paramalbw.a, paramContext, paramString, 2130847053);
          return;
          paramalbw.a.setTextColor(paramContext.getResources().getColor(2131166993));
        }
      }
      if (j >> 8 != 2) {
        break label523;
      }
      paramString = bgtv.a(localQQAppInterface, paramString, EVIPSPEC.E_SP_SUPERVIP);
      if ((j & 0xF) == 1)
      {
        if (bool) {
          paramalbw.a.setTextColor(paramContext.getResources().getColor(2131167123));
        }
        while (i == 0)
        {
          VipUtils.a(paramalbw.a, paramContext, paramString, 2130847054);
          return;
          paramalbw.a.setTextColor(paramContext.getResources().getColor(2131166993));
        }
      }
      else
      {
        if (bool) {
          paramalbw.a.setTextColor(paramContext.getResources().getColor(2131167123));
        }
        while (i == 0)
        {
          VipUtils.a(paramalbw.a, paramContext, paramString, 2130847052);
          return;
          paramalbw.a.setTextColor(paramContext.getResources().getColor(2131166993));
        }
      }
    }
    label523:
    paramalbw.a.setTextColor(paramContext.getResources().getColor(2131166993));
    paramalbw.a.setCompoundDrawablesWithIntrinsicBounds(0, 0);
  }
  
  public void run()
  {
    bgtu.b(this);
    if (!this.jdField_a_of_type_Boolean) {
      if (QLog.isColorLevel()) {
        QLog.w("VipUtils", 1, "updateRecentEfficientVipIcon async - not Valid");
      }
    }
    do
    {
      return;
      Context localContext = (Context)this.b.get();
      albw localalbw = (albw)this.c.get();
      if ((localContext != null) && (localalbw != null)) {
        a(localContext, this.jdField_a_of_type_JavaLangString, localalbw);
      }
    } while (!QLog.isColorLevel());
    QLog.w("VipUtils", 1, "updateRecentEfficientVipIcon async - sucess : " + this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.VipUtils.UpdateRecentEfficientVipIconTask
 * JD-Core Version:    0.7.0.1
 */