package com.tencent.mobileqq.scribble;

import java.util.Comparator;

class ScribbleResMgr$3
  implements Comparator<ResInfo>
{
  ScribbleResMgr$3(ScribbleResMgr paramScribbleResMgr) {}
  
  public int a(ResInfo paramResInfo1, ResInfo paramResInfo2)
  {
    if ((paramResInfo1 != null) && (paramResInfo2 != null)) {
      return paramResInfo1.j - paramResInfo2.j;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.scribble.ScribbleResMgr.3
 * JD-Core Version:    0.7.0.1
 */