package com.tencent.xweb.internal;

import java.util.Iterator;
import java.util.List;
import org.xwalk.core.XWalkEnvironment;

class j$a
{
  String a;
  List<i> b;
  
  public boolean a(double paramDouble)
  {
    Object localObject = this.b;
    boolean bool2 = false;
    if (localObject == null) {
      return false;
    }
    localObject = ((List)localObject).iterator();
    i locali;
    do
    {
      bool1 = bool2;
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      locali = (i)((Iterator)localObject).next();
    } while ((locali.a > paramDouble) || (locali.b < paramDouble));
    boolean bool1 = bool2;
    if (XWalkEnvironment.getTodayGrayValue() < locali.a(paramDouble) * 10000.0D) {
      bool1 = true;
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xweb.internal.j.a
 * JD-Core Version:    0.7.0.1
 */