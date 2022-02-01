package com.tencent.mobileqq.nearby;

import com.tencent.mobileqq.nearby.ipc.NearbyProcObserver;
import java.util.List;

class NearbyIconDecoder$2
  extends NearbyProcObserver
{
  public void a(List<String> paramList1, List<String> paramList2)
  {
    if ((paramList1 != null) && (paramList2 != null) && (paramList1.size() != 0))
    {
      if (paramList1.size() != paramList2.size()) {
        return;
      }
      int i = 0;
      while (i < paramList1.size())
      {
        this.a.a((String)paramList1.get(i), (String)paramList2.get(i));
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyIconDecoder.2
 * JD-Core Version:    0.7.0.1
 */