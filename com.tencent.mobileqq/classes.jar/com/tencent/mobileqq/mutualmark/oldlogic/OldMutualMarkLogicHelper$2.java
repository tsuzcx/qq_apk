package com.tencent.mobileqq.mutualmark.oldlogic;

import ajjj;
import ascd;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.HashSet;

public final class OldMutualMarkLogicHelper$2
  implements Runnable
{
  public OldMutualMarkLogicHelper$2(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    ajjj localajjj = (ajjj)this.a.getManager(51);
    if (localajjj != null)
    {
      HashSet localHashSet = ascd.a();
      if ((localHashSet != null) && (localHashSet.size() > 0))
      {
        localajjj.b(new ArrayList(localHashSet));
        localHashSet.clear();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.mutualmark.oldlogic.OldMutualMarkLogicHelper.2
 * JD-Core Version:    0.7.0.1
 */