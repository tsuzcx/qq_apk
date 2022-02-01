package com.tencent.mobileqq.kandian.biz.detail.web;

import android.graphics.Point;
import android.graphics.Rect;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class ReadinjoyH5ElementManager
{
  public static String a = "ReadinjoyH5ElementManager";
  private List<ReadinjoyH5ElementManager.H5Element> b = new ArrayList();
  
  public boolean a()
  {
    return this.b.isEmpty();
  }
  
  public boolean a(Point paramPoint)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("pt.x = ");
      localStringBuilder.append(paramPoint.x);
      localStringBuilder.append("  pt.y=");
      localStringBuilder.append(paramPoint.y);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    int i = 0;
    while (i < this.b.size())
    {
      localObject = (ReadinjoyH5ElementManager.H5Element)this.b.get(i);
      if ((localObject != null) && (((ReadinjoyH5ElementManager.H5Element)localObject).a != null) && (((ReadinjoyH5ElementManager.H5Element)localObject).a.contains(paramPoint.x, paramPoint.y))) {
        return true;
      }
      i += 1;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.detail.web.ReadinjoyH5ElementManager
 * JD-Core Version:    0.7.0.1
 */