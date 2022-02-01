package com.tencent.mobileqq.utils;

import QQService.EVIPSPEC;
import algw;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import anvk;
import bhje;
import bhjf;
import bhjg;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
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
  private WeakReference<algw> c;
  
  VipUtils$UpdateRecentEfficientVipIconTask(View paramView, Context paramContext, String paramString, algw paramalgw)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramView);
    this.b = new WeakReference(paramContext);
    this.c = new WeakReference(paramalgw);
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  private View a()
  {
    return (View)this.jdField_a_of_type_MqqUtilWeakReference.get();
  }
  
  static void a(Context paramContext, String paramString, algw paramalgw)
  {
    QQAppInterface localQQAppInterface = ((BaseActivity)paramContext).app;
    Object localObject = (anvk)localQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    boolean bool = ((anvk)localObject).c;
    localObject = ((anvk)localObject).e(paramString);
    int i;
    label112:
    int j;
    if ((localObject != null) && (bhjf.a(((Friends)localObject).nameplateVipType)))
    {
      i = 1;
      if (i != 0)
      {
        if (bhjf.b(((Friends)localObject).grayNameplateFlag)) {
          break label222;
        }
        String str = bhjf.a(localQQAppInterface, ((Friends)localObject).uin, bhjg.a(((Friends)localObject).nameplateVipType), false);
        VipUtils.a(paramalgw.a, paramContext, str, bhjf.a(bhjg.a(((Friends)localObject).nameplateVipType)));
      }
      j = VipUtils.a(localQQAppInterface, paramString);
      if (QLog.isColorLevel()) {
        QLog.d("VipUtils", 2, "bindView: vip=" + j);
      }
      if (j >> 8 != 3) {
        break label309;
      }
      paramString = bhjf.a(localQQAppInterface, paramString, EVIPSPEC.E_SP_BIGCLUB);
      if ((j & 0xF) != 1) {
        break label253;
      }
      if (!bool) {
        break label234;
      }
      paramalgw.a.setTextColor(paramContext.getResources().getColor(2131167170));
      label201:
      if (i == 0) {
        VipUtils.a(paramalgw.a, paramContext, paramString, 2130847076);
      }
    }
    for (;;)
    {
      return;
      i = 0;
      break;
      label222:
      paramalgw.a.setCompoundDrawablesWithIntrinsicBounds(0, 0);
      break label112;
      label234:
      paramalgw.a.setTextColor(paramContext.getResources().getColor(2131167033));
      break label201;
      label253:
      if (bool) {
        paramalgw.a.setTextColor(paramContext.getResources().getColor(2131167170));
      }
      while (i == 0)
      {
        VipUtils.a(paramalgw.a, paramContext, paramString, 2130847074);
        return;
        paramalgw.a.setTextColor(paramContext.getResources().getColor(2131167033));
      }
      continue;
      label309:
      if (j >> 8 == 1)
      {
        if (bool) {
          paramalgw.a.setTextColor(paramContext.getResources().getColor(2131167170));
        }
        for (;;)
        {
          paramString = bhjf.a(localQQAppInterface, paramString, EVIPSPEC.E_SP_QQVIP);
          if (i != 0) {
            break;
          }
          VipUtils.a(paramalgw.a, paramContext, paramString, 2130847075);
          return;
          paramalgw.a.setTextColor(paramContext.getResources().getColor(2131167033));
        }
      }
      if (j >> 8 != 2) {
        break label524;
      }
      paramString = bhjf.a(localQQAppInterface, paramString, EVIPSPEC.E_SP_SUPERVIP);
      if ((j & 0xF) == 1)
      {
        if (bool) {
          paramalgw.a.setTextColor(paramContext.getResources().getColor(2131167170));
        }
        while (i == 0)
        {
          VipUtils.a(paramalgw.a, paramContext, paramString, 2130847076);
          return;
          paramalgw.a.setTextColor(paramContext.getResources().getColor(2131167033));
        }
      }
      else
      {
        if (bool) {
          paramalgw.a.setTextColor(paramContext.getResources().getColor(2131167170));
        }
        while (i == 0)
        {
          VipUtils.a(paramalgw.a, paramContext, paramString, 2130847074);
          return;
          paramalgw.a.setTextColor(paramContext.getResources().getColor(2131167033));
        }
      }
    }
    label524:
    paramalgw.a.setTextColor(paramContext.getResources().getColor(2131167033));
    paramalgw.a.setCompoundDrawablesWithIntrinsicBounds(0, 0);
  }
  
  public void run()
  {
    bhje.b(this);
    if (!this.jdField_a_of_type_Boolean) {
      if (QLog.isColorLevel()) {
        QLog.w("VipUtils", 1, "updateRecentEfficientVipIcon async - not Valid");
      }
    }
    do
    {
      return;
      Context localContext = (Context)this.b.get();
      algw localalgw = (algw)this.c.get();
      if ((localContext != null) && (localalgw != null)) {
        a(localContext, this.jdField_a_of_type_JavaLangString, localalgw);
      }
    } while (!QLog.isColorLevel());
    QLog.w("VipUtils", 1, "updateRecentEfficientVipIcon async - sucess : " + this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.VipUtils.UpdateRecentEfficientVipIconTask
 * JD-Core Version:    0.7.0.1
 */