package com.tencent.mobileqq.mutualmark.oldlogic;

import amsw;
import awgw;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.HashSet;

public final class OldMutualMarkLogicHelper$3
  implements Runnable
{
  public OldMutualMarkLogicHelper$3(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    amsw localamsw = (amsw)this.a.getManager(51);
    if (localamsw != null)
    {
      HashSet localHashSet = awgw.a();
      if ((localHashSet != null) && (localHashSet.size() > 0))
      {
        localamsw.b(new ArrayList(localHashSet));
        localHashSet.clear();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mutualmark.oldlogic.OldMutualMarkLogicHelper.3
 * JD-Core Version:    0.7.0.1
 */