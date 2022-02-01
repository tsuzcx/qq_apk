package com.tencent.mobileqq.vas;

import android.graphics.Color;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.List;

public class VasPalette$OcTree
{
  VasPalette.OcNode a = VasPalette.OcNode.a();
  public List<VasPalette.OcNode> b = new ArrayList();
  public SparseArray<List<VasPalette.OcNode>> c = new SparseArray();
  
  public VasPalette.OcNode a(int paramInt)
  {
    VasPalette.OcNode localOcNode1 = this.a;
    int m = Color.red(paramInt);
    int n = Color.green(paramInt);
    int i1 = Color.blue(paramInt);
    paramInt = 128;
    byte b1 = 1;
    while (b1 <= 8)
    {
      boolean bool = false;
      if ((m & paramInt) == 0) {
        i = 0;
      } else {
        i = 1;
      }
      int j;
      if ((n & paramInt) == 0) {
        j = 0;
      } else {
        j = 1;
      }
      int k;
      if ((i1 & paramInt) == 0) {
        k = 0;
      } else {
        k = 1;
      }
      int i = i * 4 + j * 2 + k;
      if (localOcNode1.g == null) {
        localOcNode1.g = new SparseArray();
      }
      if (localOcNode1.g.get(i) == null)
      {
        VasPalette.OcNode localOcNode2 = VasPalette.OcNode.a(i, b1);
        localOcNode1.g.put(i, localOcNode2);
        if (b1 == 8) {
          bool = true;
        }
        localOcNode2.h = bool;
        if (localOcNode2.h)
        {
          this.b.add(localOcNode2);
        }
        else
        {
          if (this.c.get(b1) == null) {
            this.c.put(b1, new ArrayList());
          }
          ((List)this.c.get(b1)).add(localOcNode2);
        }
      }
      localOcNode1 = (VasPalette.OcNode)localOcNode1.g.get(i);
      if (localOcNode1.h)
      {
        localOcNode1.a += m;
        localOcNode1.b += n;
        localOcNode1.c += i1;
        localOcNode1.d += 1;
        return localOcNode1;
      }
      b1 = (byte)(b1 + 1);
      paramInt >>= 1;
    }
    return localOcNode1;
  }
  
  public void a()
  {
    int i = 7;
    while ((i > 0) && (((List)this.c.get(i)).isEmpty())) {
      i -= 1;
    }
    Object localObject = (List)this.c.get(i);
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      VasPalette.OcNode localOcNode = (VasPalette.OcNode)((List)localObject).get(((List)localObject).size() - 1);
      ((List)localObject).remove(localOcNode);
      i = 0;
      while (i < 8)
      {
        localObject = (VasPalette.OcNode)localOcNode.g.get(i);
        if (localObject != null)
        {
          localOcNode.a += ((VasPalette.OcNode)localObject).a;
          localOcNode.b += ((VasPalette.OcNode)localObject).b;
          localOcNode.c += ((VasPalette.OcNode)localObject).c;
          localOcNode.d += ((VasPalette.OcNode)localObject).d;
          this.b.remove(localObject);
        }
        i += 1;
      }
      localOcNode.g.clear();
      localOcNode.g = null;
      localOcNode.h = true;
      this.b.add(localOcNode);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.VasPalette.OcTree
 * JD-Core Version:    0.7.0.1
 */