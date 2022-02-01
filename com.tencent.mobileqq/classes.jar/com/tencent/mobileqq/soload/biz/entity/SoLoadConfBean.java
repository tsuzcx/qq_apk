package com.tencent.mobileqq.soload.biz.entity;

import com.tencent.mobileqq.config.QConfItem;

public class SoLoadConfBean
{
  public QConfItem[] a = new QConfItem[0];
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("SoLoadConfBean:");
    if (this.a != null)
    {
      QConfItem[] arrayOfQConfItem = this.a;
      int j = arrayOfQConfItem.length;
      int i = 0;
      while (i < j)
      {
        QConfItem localQConfItem = arrayOfQConfItem[i];
        if (localQConfItem != null) {
          localStringBuilder.append("confItem ").append(localQConfItem.jdField_a_of_type_Int).append(":").append(localQConfItem.jdField_a_of_type_JavaLangString).append("\n");
        }
        i += 1;
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.soload.biz.entity.SoLoadConfBean
 * JD-Core Version:    0.7.0.1
 */