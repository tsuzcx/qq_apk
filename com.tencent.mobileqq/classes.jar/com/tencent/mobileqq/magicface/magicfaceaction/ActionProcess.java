package com.tencent.mobileqq.magicface.magicfaceaction;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ActionProcess
{
  public int a;
  public String a;
  public List a = new ArrayList();
  public int b = -1;
  public String b;
  public String c;
  
  public int a(int paramInt)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      RecordCondition localRecordCondition = (RecordCondition)localIterator.next();
      if ((localRecordCondition.a <= paramInt) && (localRecordCondition.b > paramInt)) {
        return localRecordCondition.c;
      }
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.magicfaceaction.ActionProcess
 * JD-Core Version:    0.7.0.1
 */