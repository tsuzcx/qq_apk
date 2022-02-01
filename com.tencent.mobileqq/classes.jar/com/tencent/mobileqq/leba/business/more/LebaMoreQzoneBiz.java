package com.tencent.mobileqq.leba.business.more;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.leba.business.ILabaMoreVipBiz;
import com.tencent.mobileqq.leba.entity.LebaMoreViewItem;
import com.tencent.mobileqq.leba.entity.LebaPluginInfo;
import com.tencent.mobileqq.leba.entity.LebaViewItem;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpActionLegacy;
import java.util.List;
import mqq.app.MobileQQ;

public class LebaMoreQzoneBiz
  extends ILabaMoreVipBiz
{
  public void a(int paramInt, boolean paramBoolean, List<LebaMoreViewItem> paramList1, List<LebaMoreViewItem> paramList2)
  {
    if (paramBoolean) {
      return;
    }
    paramList2 = new LebaMoreViewItem();
    paramList2.a = 2;
    paramList2.e = true;
    paramList2.d = true;
    paramList2.f = 1;
    paramList2.c = new LebaViewItem();
    paramList2.c.b = new LebaPluginInfo();
    if (paramInt == 2) {
      paramInt = 2130846953;
    } else {
      paramInt = 2130846946;
    }
    paramList2.g = paramInt;
    paramList2.h = HardCodeUtil.a(2131914763);
    paramList2.i = false;
    paramList1.add(paramList2);
  }
  
  public boolean a(LebaMoreViewItem paramLebaMoreViewItem)
  {
    if ((paramLebaMoreViewItem.e) && (paramLebaMoreViewItem.f == 1))
    {
      new JumpActionLegacy((QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null), a()).bY_();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.business.more.LebaMoreQzoneBiz
 * JD-Core Version:    0.7.0.1
 */