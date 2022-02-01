package dov.com.tencent.mobileqq.activity.richmedia;

import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.util.QZLog;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoPart;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class QzoneEditPictureAndVideoReportModel
{
  private int jdField_a_of_type_Int;
  private final Class<? extends EditVideoPart> jdField_a_of_type_JavaLangClass;
  private Set<Integer> jdField_a_of_type_JavaUtilSet = new HashSet();
  private final int b;
  private final int c;
  
  private QzoneEditPictureAndVideoReportModel(int paramInt1, int paramInt2, int paramInt3, Class<? extends EditVideoPart> paramClass)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.jdField_a_of_type_JavaLangClass = paramClass;
  }
  
  static QzoneEditPictureAndVideoReportModel a(int paramInt1, int paramInt2, int paramInt3, Class<? extends EditVideoPart> paramClass)
  {
    return new QzoneEditPictureAndVideoReportModel(paramInt1, paramInt2, paramInt3, paramClass);
  }
  
  Class<? extends EditVideoPart> a()
  {
    return this.jdField_a_of_type_JavaLangClass;
  }
  
  void a()
  {
    if (this.jdField_a_of_type_JavaUtilSet.size() > 0)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
      while (localIterator.hasNext())
      {
        Integer localInteger = (Integer)localIterator.next();
        LpReportInfo_pf00064.allReport(this.jdField_a_of_type_Int, this.b, localInteger.intValue());
        QZLog.d("QzoneEditPictureAndVide", 2, new Object[] { "performReport ", toString() + " with " + localInteger });
      }
    }
    LpReportInfo_pf00064.allReport(this.jdField_a_of_type_Int, this.b, this.c);
    QZLog.d("QzoneEditPictureAndVide", 2, "performReport " + toString());
  }
  
  void a(Set<Integer> paramSet)
  {
    this.jdField_a_of_type_JavaUtilSet.addAll(paramSet);
  }
  
  public String toString()
  {
    return "QzoneEditPictureReportModel{actionType=" + this.jdField_a_of_type_Int + ", subActionType=" + this.b + ", reserve=" + this.c + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.QzoneEditPictureAndVideoReportModel
 * JD-Core Version:    0.7.0.1
 */