package com.tencent.mobileqq.magicface.magicfaceaction;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ActionProcess
{
  public String a;
  public String b;
  public String c;
  public int d;
  public int e = -1;
  public List<RecordCondition> f = new ArrayList();
  
  public int a(int paramInt)
  {
    Iterator localIterator = this.f.iterator();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.magicfaceaction.ActionProcess
 * JD-Core Version:    0.7.0.1
 */