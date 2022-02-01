package com.tencent.open.agent;

import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.api.handler.ITroopTokenHandler;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import java.util.Set;

public class JoinTroopPreVerificationFragment
  extends TroopAbilityPreVerificationFragment
{
  private TroopObserver p = new JoinTroopPreVerificationFragment.1(this);
  
  protected void a()
  {
    super.a();
    this.a.addObserver(this.p);
  }
  
  protected void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ((ITroopTokenHandler)this.a.getBusinessHandler(BusinessHandlerFactory.TROOP_TOKEN_HANDLER)).b(Integer.valueOf(this.h).intValue(), Integer.valueOf(this.l).intValue());
      return;
    }
    d();
    a(HardCodeUtil.a(2131903836));
    this.b.finish();
  }
  
  protected boolean a(Set<Integer> paramSet)
  {
    if ((paramSet != null) && (!paramSet.isEmpty())) {
      return paramSet.contains(Integer.valueOf(15));
    }
    return false;
  }
  
  protected void b()
  {
    super.b();
    this.a.removeObserver(this.p);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.JoinTroopPreVerificationFragment
 * JD-Core Version:    0.7.0.1
 */