package dov.com.tencent.mobileqq.activity.richmedia;

import android.view.View;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import com.tencent.biz.qqstory.app.QQStoryContext;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.QZoneClickReport.ReportInfo;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoPartManager;
import java.util.ArrayList;
import java.util.List;

public class QzEditVideoPartManager
  extends EditVideoPartManager
{
  public int a;
  public View a;
  private EditVideoQzComment a;
  public String a;
  public ArrayList a;
  public String b;
  public String c = "";
  public int d = -1;
  public String d;
  public int e = -1;
  public boolean f = true;
  public boolean g;
  public boolean h = true;
  public boolean i;
  public boolean j = true;
  
  public QzEditVideoPartManager()
  {
    this.jdField_a_of_type_Int = 1;
  }
  
  static void b(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    QZoneClickReport.ReportInfo localReportInfo = new QZoneClickReport.ReportInfo();
    localReportInfo.c = paramString1;
    localReportInfo.d = paramString2;
    localReportInfo.e = paramString3;
    QZoneClickReport.report(QQStoryContext.a().a(), localReportInfo, paramBoolean);
  }
  
  public void a(Animation paramAnimation)
  {
    if (this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaEditVideoQzComment == null) {
      return;
    }
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaEditVideoQzComment.a.setAnimation(paramAnimation);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    b(paramString1, paramString2, paramString3, paramBoolean);
  }
  
  protected void a(List paramList)
  {
    EditVideoQzComment localEditVideoQzComment = new EditVideoQzComment(this);
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaEditVideoQzComment = localEditVideoQzComment;
    paramList.add(localEditVideoQzComment);
  }
  
  public void b(Animation paramAnimation)
  {
    if (this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaEditVideoQzComment == null) {
      return;
    }
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaEditVideoQzComment.a.startAnimation(paramAnimation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.QzEditVideoPartManager
 * JD-Core Version:    0.7.0.1
 */