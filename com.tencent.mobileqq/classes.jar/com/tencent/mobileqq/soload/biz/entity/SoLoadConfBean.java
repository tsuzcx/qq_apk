package com.tencent.mobileqq.soload.biz.entity;

import com.tencent.mobileqq.config.QConfItem;

public class SoLoadConfBean
{
  public QConfItem[] confFiles = new QConfItem[0];
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("SoLoadConfBean:");
    QConfItem[] arrayOfQConfItem = this.confFiles;
    if (arrayOfQConfItem != null)
    {
      int j = arrayOfQConfItem.length;
      int i = 0;
      while (i < j)
      {
        QConfItem localQConfItem = arrayOfQConfItem[i];
        if (localQConfItem != null)
        {
          localStringBuilder.append("confItem ");
          localStringBuilder.append(localQConfItem.jdField_a_of_type_Int);
          localStringBuilder.append(":");
          localStringBuilder.append(localQConfItem.jdField_a_of_type_JavaLangString);
          localStringBuilder.append("\n");
        }
        i += 1;
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.soload.biz.entity.SoLoadConfBean
 * JD-Core Version:    0.7.0.1
 */