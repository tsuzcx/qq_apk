package com.tencent.mobileqq.utils;

import QQService.EVIPSPEC;
import ahnr;
import ajxn;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import bble;
import bblf;
import bblg;
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
  private WeakReference<ahnr> c;
  
  VipUtils$UpdateRecentEfficientVipIconTask(View paramView, Context paramContext, String paramString, ahnr paramahnr)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramView);
    this.b = new WeakReference(paramContext);
    this.c = new WeakReference(paramahnr);
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  private View a()
  {
    return (View)this.jdField_a_of_type_MqqUtilWeakReference.get();
  }
  
  static void a(Context paramContext, String paramString, ahnr paramahnr)
  {
    QQAppInterface localQQAppInterface = ((BaseActivity)paramContext).app;
    Object localObject = (ajxn)localQQAppInterface.getManager(51);
    boolean bool = ((ajxn)localObject).c;
    localObject = ((ajxn)localObject).e(paramString);
    int i;
    label111:
    int j;
    if ((localObject != null) && (bblf.a(((Friends)localObject).nameplateVipType)))
    {
      i = 1;
      if (i != 0)
      {
        if (bblf.b(((Friends)localObject).grayNameplateFlag)) {
          break label221;
        }
        String str = bblf.a(localQQAppInterface, ((Friends)localObject).uin, bblg.a(((Friends)localObject).nameplateVipType), false);
        VipUtils.a(paramahnr.a, paramContext, str, bblf.a(bblg.a(((Friends)localObject).nameplateVipType)));
      }
      j = VipUtils.a(localQQAppInterface, paramString);
      if (QLog.isColorLevel()) {
        QLog.d("VipUtils", 2, "bindView: vip=" + j);
      }
      if (j >> 8 != 3) {
        break label308;
      }
      paramString = bblf.a(localQQAppInterface, paramString, EVIPSPEC.E_SP_BIGCLUB);
      if ((j & 0xF) != 1) {
        break label252;
      }
      if (!bool) {
        break label233;
      }
      paramahnr.a.setTextColor(paramContext.getResources().getColor(2131166986));
      label200:
      if (i == 0) {
        VipUtils.a(paramahnr.a, paramContext, paramString, 2130846154);
      }
    }
    for (;;)
    {
      return;
      i = 0;
      break;
      label221:
      paramahnr.a.setCompoundDrawablesWithIntrinsicBounds(0, 0);
      break label111;
      label233:
      paramahnr.a.setTextColor(paramContext.getResources().getColor(2131166861));
      break label200;
      label252:
      if (bool) {
        paramahnr.a.setTextColor(paramContext.getResources().getColor(2131166986));
      }
      while (i == 0)
      {
        VipUtils.a(paramahnr.a, paramContext, paramString, 2130846152);
        return;
        paramahnr.a.setTextColor(paramContext.getResources().getColor(2131166861));
      }
      continue;
      label308:
      if (j >> 8 == 1)
      {
        if (bool) {
          paramahnr.a.setTextColor(paramContext.getResources().getColor(2131166986));
        }
        for (;;)
        {
          paramString = bblf.a(localQQAppInterface, paramString, EVIPSPEC.E_SP_QQVIP);
          if (i != 0) {
            break;
          }
          VipUtils.a(paramahnr.a, paramContext, paramString, 2130846153);
          return;
          paramahnr.a.setTextColor(paramContext.getResources().getColor(2131166861));
        }
      }
      if (j >> 8 != 2) {
        break label523;
      }
      paramString = bblf.a(localQQAppInterface, paramString, EVIPSPEC.E_SP_SUPERVIP);
      if ((j & 0xF) == 1)
      {
        if (bool) {
          paramahnr.a.setTextColor(paramContext.getResources().getColor(2131166986));
        }
        while (i == 0)
        {
          VipUtils.a(paramahnr.a, paramContext, paramString, 2130846154);
          return;
          paramahnr.a.setTextColor(paramContext.getResources().getColor(2131166861));
        }
      }
      else
      {
        if (bool) {
          paramahnr.a.setTextColor(paramContext.getResources().getColor(2131166986));
        }
        while (i == 0)
        {
          VipUtils.a(paramahnr.a, paramContext, paramString, 2130846152);
          return;
          paramahnr.a.setTextColor(paramContext.getResources().getColor(2131166861));
        }
      }
    }
    label523:
    paramahnr.a.setTextColor(paramContext.getResources().getColor(2131166861));
    paramahnr.a.setCompoundDrawablesWithIntrinsicBounds(0, 0);
  }
  
  public void run()
  {
    bble.b(this);
    if (!this.jdField_a_of_type_Boolean) {
      if (QLog.isColorLevel()) {
        QLog.w("VipUtils", 1, "updateRecentEfficientVipIcon async - not Valid");
      }
    }
    do
    {
      return;
      Context localContext = (Context)this.b.get();
      ahnr localahnr = (ahnr)this.c.get();
      if ((localContext != null) && (localahnr != null)) {
        a(localContext, this.jdField_a_of_type_JavaLangString, localahnr);
      }
    } while (!QLog.isColorLevel());
    QLog.w("VipUtils", 1, "updateRecentEfficientVipIcon async - sucess : " + this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.utils.VipUtils.UpdateRecentEfficientVipIconTask
 * JD-Core Version:    0.7.0.1
 */