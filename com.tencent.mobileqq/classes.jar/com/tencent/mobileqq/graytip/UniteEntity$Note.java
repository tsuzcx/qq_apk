package com.tencent.mobileqq.graytip;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class UniteEntity$Note
{
  int a;
  HashMap<Integer, Object> b;
  Note c;
  ArrayList<Note> d;
  
  public UniteEntity$Note(int paramInt)
  {
    this.a = paramInt;
    this.b = new HashMap();
    this.d = new ArrayList();
  }
  
  private String a(int paramInt)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    int i = 0;
    while (i < paramInt)
    {
      localStringBuilder2.append("\t");
      i += 1;
    }
    localStringBuilder1.append(localStringBuilder2);
    localStringBuilder1.append(UniteEntity.a(this.a));
    localStringBuilder1.append(":[\n");
    localStringBuilder1.append(localStringBuilder2);
    localStringBuilder1.append("\tfields");
    localStringBuilder1.append(":[\n");
    Iterator localIterator = this.b.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Integer)localIterator.next();
      String str = UniteEntity.b(((Integer)localObject).intValue());
      localObject = this.b.get(localObject);
      localStringBuilder1.append(localStringBuilder2);
      localStringBuilder1.append("\t\t");
      localStringBuilder1.append(str);
      localStringBuilder1.append(":");
      localStringBuilder1.append(localObject);
      localStringBuilder1.append("\n");
    }
    localStringBuilder1.append(localStringBuilder2);
    localStringBuilder1.append("\t]");
    localStringBuilder1.append("\n");
    localIterator = this.d.iterator();
    while (localIterator.hasNext()) {
      localStringBuilder1.append(((Note)localIterator.next()).a(paramInt + 1));
    }
    localStringBuilder1.append(localStringBuilder2);
    localStringBuilder1.append("]");
    localStringBuilder1.append("\n");
    return localStringBuilder1.toString();
  }
  
  public HashMap<Integer, Object> a()
  {
    return this.b;
  }
  
  public void a(int paramInt, Object paramObject)
  {
    this.b.put(Integer.valueOf(paramInt), paramObject);
  }
  
  public void a(Note paramNote)
  {
    this.d.add(paramNote);
  }
  
  public Note b()
  {
    return this.c;
  }
  
  public Note b(Note paramNote)
  {
    this.c = paramNote;
    this.c.a(this);
    return this;
  }
  
  public boolean c()
  {
    return this.a == 2;
  }
  
  public int d()
  {
    return this.a;
  }
  
  public ArrayList<Note> e()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.graytip.UniteEntity.Note
 * JD-Core Version:    0.7.0.1
 */