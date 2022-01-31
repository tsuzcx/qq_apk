package com.tencent.mobileqq.utils;

import QQService.EVIPSPEC;
import ahnp;
import ajxl;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import bbls;
import bblt;
import bblu;
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
  private WeakReference<ahnp> c;
  
  VipUtils$UpdateRecentEfficientVipIconTask(View paramView, Context paramContext, String paramString, ahnp paramahnp)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramView);
    this.b = new WeakReference(paramContext);
    this.c = new WeakReference(paramahnp);
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  private View a()
  {
    return (View)this.jdField_a_of_type_MqqUtilWeakReference.get();
  }
  
  static void a(Context paramContext, String paramString, ahnp paramahnp)
  {
    QQAppInterface localQQAppInterface = ((BaseActivity)paramContext).app;
    Object localObject = (ajxl)localQQAppInterface.getManager(51);
    boolean bool = ((ajxl)localObject).c;
    localObject = ((ajxl)localObject).e(paramString);
    int i;
    label111:
    int j;
    if ((localObject != null) && (bblt.a(((Friends)localObject).nameplateVipType)))
    {
      i = 1;
      if (i != 0)
      {
        if (bblt.b(((Friends)localObject).grayNameplateFlag)) {
          break label221;
        }
        String str = bblt.a(localQQAppInterface, ((Friends)localObject).uin, bblu.a(((Friends)localObject).nameplateVipType), false);
        VipUtils.a(paramahnp.a, paramContext, str, bblt.a(bblu.a(((Friends)localObject).nameplateVipType)));
      }
      j = VipUtils.a(localQQAppInterface, paramString);
      if (QLog.isColorLevel()) {
        QLog.d("VipUtils", 2, "bindView: vip=" + j);
      }
      if (j >> 8 != 3) {
        break label308;
      }
      paramString = bblt.a(localQQAppInterface, paramString, EVIPSPEC.E_SP_BIGCLUB);
      if ((j & 0xF) != 1) {
        break label252;
      }
      if (!bool) {
        break label233;
      }
      paramahnp.a.setTextColor(paramContext.getResources().getColor(2131166986));
      label200:
      if (i == 0) {
        VipUtils.a(paramahnp.a, paramContext, paramString, 2130846160);
      }
    }
    for (;;)
    {
      return;
      i = 0;
      break;
      label221:
      paramahnp.a.setCompoundDrawablesWithIntrinsicBounds(0, 0);
      break label111;
      label233:
      paramahnp.a.setTextColor(paramContext.getResources().getColor(2131166861));
      break label200;
      label252:
      if (bool) {
        paramahnp.a.setTextColor(paramContext.getResources().getColor(2131166986));
      }
      while (i == 0)
      {
        VipUtils.a(paramahnp.a, paramContext, paramString, 2130846158);
        return;
        paramahnp.a.setTextColor(paramContext.getResources().getColor(2131166861));
      }
      continue;
      label308:
      if (j >> 8 == 1)
      {
        if (bool) {
          paramahnp.a.setTextColor(paramContext.getResources().getColor(2131166986));
        }
        for (;;)
        {
          paramString = bblt.a(localQQAppInterface, paramString, EVIPSPEC.E_SP_QQVIP);
          if (i != 0) {
            break;
          }
          VipUtils.a(paramahnp.a, paramContext, paramString, 2130846159);
          return;
          paramahnp.a.setTextColor(paramContext.getResources().getColor(2131166861));
        }
      }
      if (j >> 8 != 2) {
        break label523;
      }
      paramString = bblt.a(localQQAppInterface, paramString, EVIPSPEC.E_SP_SUPERVIP);
      if ((j & 0xF) == 1)
      {
        if (bool) {
          paramahnp.a.setTextColor(paramContext.getResources().getColor(2131166986));
        }
        while (i == 0)
        {
          VipUtils.a(paramahnp.a, paramContext, paramString, 2130846160);
          return;
          paramahnp.a.setTextColor(paramContext.getResources().getColor(2131166861));
        }
      }
      else
      {
        if (bool) {
          paramahnp.a.setTextColor(paramContext.getResources().getColor(2131166986));
        }
        while (i == 0)
        {
          VipUtils.a(paramahnp.a, paramContext, paramString, 2130846158);
          return;
          paramahnp.a.setTextColor(paramContext.getResources().getColor(2131166861));
        }
      }
    }
    label523:
    paramahnp.a.setTextColor(paramContext.getResources().getColor(2131166861));
    paramahnp.a.setCompoundDrawablesWithIntrinsicBounds(0, 0);
  }
  
  public void run()
  {
    bbls.b(this);
    if (!this.jdField_a_of_type_Boolean) {
      if (QLog.isColorLevel()) {
        QLog.w("VipUtils", 1, "updateRecentEfficientVipIcon async - not Valid");
      }
    }
    do
    {
      return;
      Context localContext = (Context)this.b.get();
      ahnp localahnp = (ahnp)this.c.get();
      if ((localContext != null) && (localahnp != null)) {
        a(localContext, this.jdField_a_of_type_JavaLangString, localahnp);
      }
    } while (!QLog.isColorLevel());
    QLog.w("VipUtils", 1, "updateRecentEfficientVipIcon async - sucess : " + this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.utils.VipUtils.UpdateRecentEfficientVipIconTask
 * JD-Core Version:    0.7.0.1
 */