package com.tencent.mobileqq.utils;

import QQService.EVIPSPEC;
import ajey;
import aloz;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import bdkm;
import bdkn;
import bdko;
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
  private WeakReference<ajey> c;
  
  VipUtils$UpdateRecentEfficientVipIconTask(View paramView, Context paramContext, String paramString, ajey paramajey)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramView);
    this.b = new WeakReference(paramContext);
    this.c = new WeakReference(paramajey);
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  private View a()
  {
    return (View)this.jdField_a_of_type_MqqUtilWeakReference.get();
  }
  
  static void a(Context paramContext, String paramString, ajey paramajey)
  {
    QQAppInterface localQQAppInterface = ((BaseActivity)paramContext).app;
    Object localObject = (aloz)localQQAppInterface.getManager(51);
    boolean bool = ((aloz)localObject).c;
    localObject = ((aloz)localObject).e(paramString);
    int i;
    label111:
    int j;
    if ((localObject != null) && (bdkn.a(((Friends)localObject).nameplateVipType)))
    {
      i = 1;
      if (i != 0)
      {
        if (bdkn.b(((Friends)localObject).grayNameplateFlag)) {
          break label221;
        }
        String str = bdkn.a(localQQAppInterface, ((Friends)localObject).uin, bdko.a(((Friends)localObject).nameplateVipType), false);
        VipUtils.a(paramajey.a, paramContext, str, bdkn.a(bdko.a(((Friends)localObject).nameplateVipType)));
      }
      j = VipUtils.a(localQQAppInterface, paramString);
      if (QLog.isColorLevel()) {
        QLog.d("VipUtils", 2, "bindView: vip=" + j);
      }
      if (j >> 8 != 3) {
        break label308;
      }
      paramString = bdkn.a(localQQAppInterface, paramString, EVIPSPEC.E_SP_BIGCLUB);
      if ((j & 0xF) != 1) {
        break label252;
      }
      if (!bool) {
        break label233;
      }
      paramajey.a.setTextColor(paramContext.getResources().getColor(2131167037));
      label200:
      if (i == 0) {
        VipUtils.a(paramajey.a, paramContext, paramString, 2130846539);
      }
    }
    for (;;)
    {
      return;
      i = 0;
      break;
      label221:
      paramajey.a.setCompoundDrawablesWithIntrinsicBounds(0, 0);
      break label111;
      label233:
      paramajey.a.setTextColor(paramContext.getResources().getColor(2131166908));
      break label200;
      label252:
      if (bool) {
        paramajey.a.setTextColor(paramContext.getResources().getColor(2131167037));
      }
      while (i == 0)
      {
        VipUtils.a(paramajey.a, paramContext, paramString, 2130846537);
        return;
        paramajey.a.setTextColor(paramContext.getResources().getColor(2131166908));
      }
      continue;
      label308:
      if (j >> 8 == 1)
      {
        if (bool) {
          paramajey.a.setTextColor(paramContext.getResources().getColor(2131167037));
        }
        for (;;)
        {
          paramString = bdkn.a(localQQAppInterface, paramString, EVIPSPEC.E_SP_QQVIP);
          if (i != 0) {
            break;
          }
          VipUtils.a(paramajey.a, paramContext, paramString, 2130846538);
          return;
          paramajey.a.setTextColor(paramContext.getResources().getColor(2131166908));
        }
      }
      if (j >> 8 != 2) {
        break label523;
      }
      paramString = bdkn.a(localQQAppInterface, paramString, EVIPSPEC.E_SP_SUPERVIP);
      if ((j & 0xF) == 1)
      {
        if (bool) {
          paramajey.a.setTextColor(paramContext.getResources().getColor(2131167037));
        }
        while (i == 0)
        {
          VipUtils.a(paramajey.a, paramContext, paramString, 2130846539);
          return;
          paramajey.a.setTextColor(paramContext.getResources().getColor(2131166908));
        }
      }
      else
      {
        if (bool) {
          paramajey.a.setTextColor(paramContext.getResources().getColor(2131167037));
        }
        while (i == 0)
        {
          VipUtils.a(paramajey.a, paramContext, paramString, 2130846537);
          return;
          paramajey.a.setTextColor(paramContext.getResources().getColor(2131166908));
        }
      }
    }
    label523:
    paramajey.a.setTextColor(paramContext.getResources().getColor(2131166908));
    paramajey.a.setCompoundDrawablesWithIntrinsicBounds(0, 0);
  }
  
  public void run()
  {
    bdkm.b(this);
    if (!this.jdField_a_of_type_Boolean) {
      if (QLog.isColorLevel()) {
        QLog.w("VipUtils", 1, "updateRecentEfficientVipIcon async - not Valid");
      }
    }
    do
    {
      return;
      Context localContext = (Context)this.b.get();
      ajey localajey = (ajey)this.c.get();
      if ((localContext != null) && (localajey != null)) {
        a(localContext, this.jdField_a_of_type_JavaLangString, localajey);
      }
    } while (!QLog.isColorLevel());
    QLog.w("VipUtils", 1, "updateRecentEfficientVipIcon async - sucess : " + this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.VipUtils.UpdateRecentEfficientVipIconTask
 * JD-Core Version:    0.7.0.1
 */