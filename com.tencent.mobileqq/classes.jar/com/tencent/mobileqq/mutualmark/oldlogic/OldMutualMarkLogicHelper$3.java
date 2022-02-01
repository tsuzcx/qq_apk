package com.tencent.mobileqq.mutualmark.oldlogic;

import anvk;
import axmy;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import java.util.ArrayList;
import java.util.HashSet;

public final class OldMutualMarkLogicHelper$3
  implements Runnable
{
  public OldMutualMarkLogicHelper$3(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    anvk localanvk = (anvk)this.a.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (localanvk != null)
    {
      HashSet localHashSet = axmy.a();
      if ((localHashSet != null) && (localHashSet.size() > 0))
      {
        localanvk.b(new ArrayList(localHashSet));
        localHashSet.clear();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mutualmark.oldlogic.OldMutualMarkLogicHelper.3
 * JD-Core Version:    0.7.0.1
 */