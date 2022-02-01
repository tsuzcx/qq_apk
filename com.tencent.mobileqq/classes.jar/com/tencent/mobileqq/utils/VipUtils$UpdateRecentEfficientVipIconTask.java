package com.tencent.mobileqq.utils;

import QQService.EVIPSPEC;
import alnm;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import anyw;
import bhtx;
import bhty;
import bhtz;
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
  private WeakReference<alnm> c;
  
  VipUtils$UpdateRecentEfficientVipIconTask(View paramView, Context paramContext, String paramString, alnm paramalnm)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramView);
    this.b = new WeakReference(paramContext);
    this.c = new WeakReference(paramalnm);
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  private View a()
  {
    return (View)this.jdField_a_of_type_MqqUtilWeakReference.get();
  }
  
  static void a(Context paramContext, String paramString, alnm paramalnm)
  {
    QQAppInterface localQQAppInterface = ((BaseActivity)paramContext).app;
    Object localObject = (anyw)localQQAppInterface.getManager(51);
    boolean bool = ((anyw)localObject).c;
    localObject = ((anyw)localObject).e(paramString);
    int i;
    label111:
    int j;
    if ((localObject != null) && (bhty.a(((Friends)localObject).nameplateVipType)))
    {
      i = 1;
      if (i != 0)
      {
        if (bhty.b(((Friends)localObject).grayNameplateFlag)) {
          break label221;
        }
        String str = bhty.a(localQQAppInterface, ((Friends)localObject).uin, bhtz.a(((Friends)localObject).nameplateVipType), false);
        VipUtils.a(paramalnm.a, paramContext, str, bhty.a(bhtz.a(((Friends)localObject).nameplateVipType)));
      }
      j = VipUtils.a(localQQAppInterface, paramString);
      if (QLog.isColorLevel()) {
        QLog.d("VipUtils", 2, "bindView: vip=" + j);
      }
      if (j >> 8 != 3) {
        break label308;
      }
      paramString = bhty.a(localQQAppInterface, paramString, EVIPSPEC.E_SP_BIGCLUB);
      if ((j & 0xF) != 1) {
        break label252;
      }
      if (!bool) {
        break label233;
      }
      paramalnm.a.setTextColor(paramContext.getResources().getColor(2131167133));
      label200:
      if (i == 0) {
        VipUtils.a(paramalnm.a, paramContext, paramString, 2130847071);
      }
    }
    for (;;)
    {
      return;
      i = 0;
      break;
      label221:
      paramalnm.a.setCompoundDrawablesWithIntrinsicBounds(0, 0);
      break label111;
      label233:
      paramalnm.a.setTextColor(paramContext.getResources().getColor(2131166997));
      break label200;
      label252:
      if (bool) {
        paramalnm.a.setTextColor(paramContext.getResources().getColor(2131167133));
      }
      while (i == 0)
      {
        VipUtils.a(paramalnm.a, paramContext, paramString, 2130847069);
        return;
        paramalnm.a.setTextColor(paramContext.getResources().getColor(2131166997));
      }
      continue;
      label308:
      if (j >> 8 == 1)
      {
        if (bool) {
          paramalnm.a.setTextColor(paramContext.getResources().getColor(2131167133));
        }
        for (;;)
        {
          paramString = bhty.a(localQQAppInterface, paramString, EVIPSPEC.E_SP_QQVIP);
          if (i != 0) {
            break;
          }
          VipUtils.a(paramalnm.a, paramContext, paramString, 2130847070);
          return;
          paramalnm.a.setTextColor(paramContext.getResources().getColor(2131166997));
        }
      }
      if (j >> 8 != 2) {
        break label523;
      }
      paramString = bhty.a(localQQAppInterface, paramString, EVIPSPEC.E_SP_SUPERVIP);
      if ((j & 0xF) == 1)
      {
        if (bool) {
          paramalnm.a.setTextColor(paramContext.getResources().getColor(2131167133));
        }
        while (i == 0)
        {
          VipUtils.a(paramalnm.a, paramContext, paramString, 2130847071);
          return;
          paramalnm.a.setTextColor(paramContext.getResources().getColor(2131166997));
        }
      }
      else
      {
        if (bool) {
          paramalnm.a.setTextColor(paramContext.getResources().getColor(2131167133));
        }
        while (i == 0)
        {
          VipUtils.a(paramalnm.a, paramContext, paramString, 2130847069);
          return;
          paramalnm.a.setTextColor(paramContext.getResources().getColor(2131166997));
        }
      }
    }
    label523:
    paramalnm.a.setTextColor(paramContext.getResources().getColor(2131166997));
    paramalnm.a.setCompoundDrawablesWithIntrinsicBounds(0, 0);
  }
  
  public void run()
  {
    bhtx.b(this);
    if (!this.jdField_a_of_type_Boolean) {
      if (QLog.isColorLevel()) {
        QLog.w("VipUtils", 1, "updateRecentEfficientVipIcon async - not Valid");
      }
    }
    do
    {
      return;
      Context localContext = (Context)this.b.get();
      alnm localalnm = (alnm)this.c.get();
      if ((localContext != null) && (localalnm != null)) {
        a(localContext, this.jdField_a_of_type_JavaLangString, localalnm);
      }
    } while (!QLog.isColorLevel());
    QLog.w("VipUtils", 1, "updateRecentEfficientVipIcon async - sucess : " + this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.VipUtils.UpdateRecentEfficientVipIconTask
 * JD-Core Version:    0.7.0.1
 */