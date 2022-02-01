package com.tencent.mobileqq.widget.participle;

import android.graphics.RectF;
import com.tencent.mobileqq.text.QQText;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class ParticipleView$ParticipleEntity
{
  private float jdField_a_of_type_Float = 0.0F;
  private long jdField_a_of_type_Long;
  QQText jdField_a_of_type_ComTencentMobileqqTextQQText;
  private List<RectF> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private List<QQText> b = new ArrayList();
  
  private ParticipleView$ParticipleEntity(QQText paramQQText)
  {
    this.jdField_a_of_type_ComTencentMobileqqTextQQText = paramQQText;
  }
  
  private void a(RectF paramRectF, QQText paramQQText)
  {
    if (this.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        if (paramRectF.equals((RectF)localIterator.next()))
        {
          i = 1;
          break label57;
        }
      }
    }
    int i = 0;
    label57:
    if (i == 0)
    {
      this.jdField_a_of_type_JavaUtilList.add(paramRectF);
      this.b.add(paramQQText);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.participle.ParticipleView.ParticipleEntity
 * JD-Core Version:    0.7.0.1
 */