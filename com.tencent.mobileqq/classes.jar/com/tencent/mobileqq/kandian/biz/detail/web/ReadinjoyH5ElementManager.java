package com.tencent.mobileqq.kandian.biz.detail.web;

import android.graphics.Point;
import android.graphics.Rect;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class ReadinjoyH5ElementManager
{
  public static String a = "ReadinjoyH5ElementManager";
  private List<ReadinjoyH5ElementManager.H5Element> a;
  
  public ReadinjoyH5ElementManager()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaUtilList.isEmpty();
  }
  
  public boolean a(Point paramPoint)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("pt.x = ");
      localStringBuilder.append(paramPoint.x);
      localStringBuilder.append("  pt.y=");
      localStringBuilder.append(paramPoint.y);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      localObject = (ReadinjoyH5ElementManager.H5Element)this.jdField_a_of_type_JavaUtilList.get(i);
      if ((localObject != null) && (((ReadinjoyH5ElementManager.H5Element)localObject).a != null) && (((ReadinjoyH5ElementManager.H5Element)localObject).a.contains(paramPoint.x, paramPoint.y))) {
        return true;
      }
      i += 1;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.detail.web.ReadinjoyH5ElementManager
 * JD-Core Version:    0.7.0.1
 */