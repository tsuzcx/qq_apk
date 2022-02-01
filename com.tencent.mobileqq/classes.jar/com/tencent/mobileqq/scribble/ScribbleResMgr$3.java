package com.tencent.mobileqq.scribble;

import java.util.Comparator;

class ScribbleResMgr$3
  implements Comparator<ScribbleResMgr.ResInfo>
{
  ScribbleResMgr$3(ScribbleResMgr paramScribbleResMgr) {}
  
  public int a(ScribbleResMgr.ResInfo paramResInfo1, ScribbleResMgr.ResInfo paramResInfo2)
  {
    if ((paramResInfo1 != null) && (paramResInfo2 != null)) {
      return paramResInfo1.orderIndex - paramResInfo2.orderIndex;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.scribble.ScribbleResMgr.3
 * JD-Core Version:    0.7.0.1
 */