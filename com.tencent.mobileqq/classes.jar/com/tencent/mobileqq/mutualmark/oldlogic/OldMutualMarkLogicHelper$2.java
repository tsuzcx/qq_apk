package com.tencent.mobileqq.mutualmark.oldlogic;

import ajxl;
import asyj;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.HashSet;

public final class OldMutualMarkLogicHelper$2
  implements Runnable
{
  public OldMutualMarkLogicHelper$2(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    ajxl localajxl = (ajxl)this.a.getManager(51);
    if (localajxl != null)
    {
      HashSet localHashSet = asyj.a();
      if ((localHashSet != null) && (localHashSet.size() > 0))
      {
        localajxl.b(new ArrayList(localHashSet));
        localHashSet.clear();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.mutualmark.oldlogic.OldMutualMarkLogicHelper.2
 * JD-Core Version:    0.7.0.1
 */