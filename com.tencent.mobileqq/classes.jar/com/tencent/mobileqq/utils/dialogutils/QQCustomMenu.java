package com.tencent.mobileqq.utils.dialogutils;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class QQCustomMenu
{
  String jdField_a_of_type_JavaLangString;
  List<QQCustomMenuItem> jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public QQCustomMenu a()
  {
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    localQQCustomMenu.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    localQQCustomMenu.jdField_a_of_type_JavaUtilList.addAll(this.jdField_a_of_type_JavaUtilList);
    return localQQCustomMenu;
  }
  
  public QQCustomMenuItem a(int paramInt)
  {
    return (QQCustomMenuItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  @Deprecated
  public void a(int paramInt, String paramString)
  {
    paramString = new QQCustomMenuItem(paramInt, paramString);
    this.jdField_a_of_type_JavaUtilList.add(paramString);
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    paramString = new QQCustomMenuItem(paramInt1, paramString);
    paramString.b = paramInt2;
    this.jdField_a_of_type_JavaUtilList.add(paramString);
  }
  
  public void a(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    paramString = new QQCustomMenuItem(paramInt1, paramString);
    paramString.b = paramInt2;
    this.jdField_a_of_type_JavaUtilList.add(paramInt3, paramString);
  }
  
  public void a(QQCustomMenuItem paramQQCustomMenuItem)
  {
    if (paramQQCustomMenuItem != null) {
      this.jdField_a_of_type_JavaUtilList.add(paramQQCustomMenuItem);
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public QQCustomMenuItem[] a()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = new QQCustomMenuItem[this.jdField_a_of_type_JavaUtilList.size()];
      this.jdField_a_of_type_JavaUtilList.toArray((Object[])localObject);
      return localObject;
    }
    return null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        QQCustomMenuItem localQQCustomMenuItem = (QQCustomMenuItem)((Iterator)localObject).next();
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append(" ");
        localStringBuilder2.append(localQQCustomMenuItem.jdField_a_of_type_JavaLangString);
        localStringBuilder1.append(localStringBuilder2.toString());
      }
    }
    return localStringBuilder1.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.dialogutils.QQCustomMenu
 * JD-Core Version:    0.7.0.1
 */