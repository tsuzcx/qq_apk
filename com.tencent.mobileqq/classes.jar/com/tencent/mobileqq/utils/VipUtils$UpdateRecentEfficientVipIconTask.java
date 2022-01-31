package com.tencent.mobileqq.utils;

import QQService.EVIPSPEC;
import ajjn;
import alto;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import bdov;
import bdow;
import bdox;
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
  private WeakReference<ajjn> c;
  
  VipUtils$UpdateRecentEfficientVipIconTask(View paramView, Context paramContext, String paramString, ajjn paramajjn)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramView);
    this.b = new WeakReference(paramContext);
    this.c = new WeakReference(paramajjn);
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  private View a()
  {
    return (View)this.jdField_a_of_type_MqqUtilWeakReference.get();
  }
  
  static void a(Context paramContext, String paramString, ajjn paramajjn)
  {
    QQAppInterface localQQAppInterface = ((BaseActivity)paramContext).app;
    Object localObject = (alto)localQQAppInterface.getManager(51);
    boolean bool = ((alto)localObject).c;
    localObject = ((alto)localObject).e(paramString);
    int i;
    label111:
    int j;
    if ((localObject != null) && (bdow.a(((Friends)localObject).nameplateVipType)))
    {
      i = 1;
      if (i != 0)
      {
        if (bdow.b(((Friends)localObject).grayNameplateFlag)) {
          break label221;
        }
        String str = bdow.a(localQQAppInterface, ((Friends)localObject).uin, bdox.a(((Friends)localObject).nameplateVipType), false);
        VipUtils.a(paramajjn.a, paramContext, str, bdow.a(bdox.a(((Friends)localObject).nameplateVipType)));
      }
      j = VipUtils.a(localQQAppInterface, paramString);
      if (QLog.isColorLevel()) {
        QLog.d("VipUtils", 2, "bindView: vip=" + j);
      }
      if (j >> 8 != 3) {
        break label308;
      }
      paramString = bdow.a(localQQAppInterface, paramString, EVIPSPEC.E_SP_BIGCLUB);
      if ((j & 0xF) != 1) {
        break label252;
      }
      if (!bool) {
        break label233;
      }
      paramajjn.a.setTextColor(paramContext.getResources().getColor(2131167039));
      label200:
      if (i == 0) {
        VipUtils.a(paramajjn.a, paramContext, paramString, 2130846612);
      }
    }
    for (;;)
    {
      return;
      i = 0;
      break;
      label221:
      paramajjn.a.setCompoundDrawablesWithIntrinsicBounds(0, 0);
      break label111;
      label233:
      paramajjn.a.setTextColor(paramContext.getResources().getColor(2131166910));
      break label200;
      label252:
      if (bool) {
        paramajjn.a.setTextColor(paramContext.getResources().getColor(2131167039));
      }
      while (i == 0)
      {
        VipUtils.a(paramajjn.a, paramContext, paramString, 2130846610);
        return;
        paramajjn.a.setTextColor(paramContext.getResources().getColor(2131166910));
      }
      continue;
      label308:
      if (j >> 8 == 1)
      {
        if (bool) {
          paramajjn.a.setTextColor(paramContext.getResources().getColor(2131167039));
        }
        for (;;)
        {
          paramString = bdow.a(localQQAppInterface, paramString, EVIPSPEC.E_SP_QQVIP);
          if (i != 0) {
            break;
          }
          VipUtils.a(paramajjn.a, paramContext, paramString, 2130846611);
          return;
          paramajjn.a.setTextColor(paramContext.getResources().getColor(2131166910));
        }
      }
      if (j >> 8 != 2) {
        break label523;
      }
      paramString = bdow.a(localQQAppInterface, paramString, EVIPSPEC.E_SP_SUPERVIP);
      if ((j & 0xF) == 1)
      {
        if (bool) {
          paramajjn.a.setTextColor(paramContext.getResources().getColor(2131167039));
        }
        while (i == 0)
        {
          VipUtils.a(paramajjn.a, paramContext, paramString, 2130846612);
          return;
          paramajjn.a.setTextColor(paramContext.getResources().getColor(2131166910));
        }
      }
      else
      {
        if (bool) {
          paramajjn.a.setTextColor(paramContext.getResources().getColor(2131167039));
        }
        while (i == 0)
        {
          VipUtils.a(paramajjn.a, paramContext, paramString, 2130846610);
          return;
          paramajjn.a.setTextColor(paramContext.getResources().getColor(2131166910));
        }
      }
    }
    label523:
    paramajjn.a.setTextColor(paramContext.getResources().getColor(2131166910));
    paramajjn.a.setCompoundDrawablesWithIntrinsicBounds(0, 0);
  }
  
  public void run()
  {
    bdov.b(this);
    if (!this.jdField_a_of_type_Boolean) {
      if (QLog.isColorLevel()) {
        QLog.w("VipUtils", 1, "updateRecentEfficientVipIcon async - not Valid");
      }
    }
    do
    {
      return;
      Context localContext = (Context)this.b.get();
      ajjn localajjn = (ajjn)this.c.get();
      if ((localContext != null) && (localajjn != null)) {
        a(localContext, this.jdField_a_of_type_JavaLangString, localajjn);
      }
    } while (!QLog.isColorLevel());
    QLog.w("VipUtils", 1, "updateRecentEfficientVipIcon async - sucess : " + this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.VipUtils.UpdateRecentEfficientVipIconTask
 * JD-Core Version:    0.7.0.1
 */