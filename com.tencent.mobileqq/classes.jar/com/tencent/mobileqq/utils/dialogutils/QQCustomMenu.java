package com.tencent.mobileqq.utils.dialogutils;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class QQCustomMenu
{
  List<QQCustomMenuItem> a = new CopyOnWriteArrayList();
  String b;
  
  public QQCustomMenuItem a(int paramInt)
  {
    return (QQCustomMenuItem)this.a.get(paramInt);
  }
  
  public void a()
  {
    this.a.clear();
  }
  
  @Deprecated
  public void a(int paramInt, String paramString)
  {
    paramString = new QQCustomMenuItem(paramInt, paramString);
    this.a.add(paramString);
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    paramString = new QQCustomMenuItem(paramInt1, paramString);
    paramString.c = paramInt2;
    this.a.add(paramString);
  }
  
  public void a(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    paramString = new QQCustomMenuItem(paramInt1, paramString);
    paramString.c = paramInt2;
    this.a.add(paramInt3, paramString);
  }
  
  public void a(QQCustomMenuItem paramQQCustomMenuItem)
  {
    if (paramQQCustomMenuItem != null) {
      this.a.add(paramQQCustomMenuItem);
    }
  }
  
  public void a(String paramString)
  {
    this.b = paramString;
  }
  
  public int b()
  {
    return this.a.size();
  }
  
  public String c()
  {
    return this.b;
  }
  
  public QQCustomMenuItem[] d()
  {
    Object localObject = this.a;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = new QQCustomMenuItem[this.a.size()];
      this.a.toArray((Object[])localObject);
      return localObject;
    }
    return null;
  }
  
  public QQCustomMenu e()
  {
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    localQQCustomMenu.b = this.b;
    localQQCustomMenu.a.addAll(this.a);
    return localQQCustomMenu;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    Object localObject = this.a;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        QQCustomMenuItem localQQCustomMenuItem = (QQCustomMenuItem)((Iterator)localObject).next();
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append(" ");
        localStringBuilder2.append(localQQCustomMenuItem.a);
        localStringBuilder1.append(localStringBuilder2.toString());
      }
    }
    return localStringBuilder1.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.dialogutils.QQCustomMenu
 * JD-Core Version:    0.7.0.1
 */