package com.tencent.mobileqq.vas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class VasPalette$OcTreeQuantizer
{
  private static final Comparator<VasPalette.OcNode> b = new VasPalette.OcTreeQuantizer.1();
  private List<VasPalette.OcNode> a;
  
  public List<VasPalette.OcNode> a()
  {
    List localList = this.a;
    if (localList == null) {
      return null;
    }
    return Collections.unmodifiableList(localList);
  }
  
  public void a(int[] paramArrayOfInt, int paramInt)
  {
    Object localObject = new VasPalette.OcTree();
    int i = 0;
    while (i < paramArrayOfInt.length)
    {
      ((VasPalette.OcTree)localObject).a(paramArrayOfInt[i]);
      while (((VasPalette.OcTree)localObject).b.size() > paramInt) {
        ((VasPalette.OcTree)localObject).a();
      }
      i += 1;
    }
    this.a = new ArrayList();
    paramArrayOfInt = ((VasPalette.OcTree)localObject).b.iterator();
    while (paramArrayOfInt.hasNext())
    {
      localObject = (VasPalette.OcNode)paramArrayOfInt.next();
      ((VasPalette.OcNode)localObject).a = ((int)((float)((VasPalette.OcNode)localObject).a / ((VasPalette.OcNode)localObject).d));
      ((VasPalette.OcNode)localObject).b = ((int)((float)((VasPalette.OcNode)localObject).b / ((VasPalette.OcNode)localObject).d));
      ((VasPalette.OcNode)localObject).c = ((int)((float)((VasPalette.OcNode)localObject).c / ((VasPalette.OcNode)localObject).d));
      this.a.add(localObject);
    }
    Collections.sort(this.a, b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.VasPalette.OcTreeQuantizer
 * JD-Core Version:    0.7.0.1
 */