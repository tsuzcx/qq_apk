package dov.com.tencent.mobileqq.activity.richmedia;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.util.LiuHaiUtils;
import cooperation.qzone.util.QZLog;
import dov.com.tencent.biz.qqstory.takevideo.EditPicPartManager;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoPart;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoUi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QzoneEditPicturePartManager
  extends EditPicPartManager
{
  public View a;
  private final QzoneEditPictureActivity jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzoneEditPictureActivity;
  private QzoneEditPicturePartComment jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzoneEditPicturePartComment;
  private QzoneEditPicturePartSave jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzoneEditPicturePartSave;
  private QzoneEditPicturePartScheduleDelete jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzoneEditPicturePartScheduleDelete;
  public String a;
  public ArrayList<String> a;
  public String b;
  public int c;
  public String c;
  public int d = -1;
  public String d;
  public int e;
  public String e;
  public boolean e;
  public int f = -1;
  public boolean f;
  public boolean g = true;
  public boolean h;
  public boolean i = true;
  private boolean j;
  private boolean k;
  
  public QzoneEditPicturePartManager(QzoneEditPictureActivity paramQzoneEditPictureActivity, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilArrayList = null;
    this.jdField_c_of_type_Int = 1;
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_e_of_type_Boolean = true;
    this.jdField_e_of_type_Int = -1;
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzoneEditPictureActivity = paramQzoneEditPictureActivity;
    this.k = paramBoolean;
  }
  
  private void A()
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzoneEditPictureActivity.findViewById(2131373156);
    Object localObject = (LinearLayout)LayoutInflater.from(this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzoneEditPictureActivity).inflate(2131562415, null);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.setMargins(0, LiuHaiUtils.jdField_a_of_type_Int, 0, 0);
    localLayoutParams.addRule(11);
    localRelativeLayout.addView((View)localObject, localLayoutParams);
    ((LinearLayout)localObject).findViewById(2131375846).setVisibility(0);
    ((LinearLayout)localObject).findViewById(2131375844).setVisibility(0);
    ((LinearLayout)localObject).findViewById(2131375847).setVisibility(8);
    localObject = (RelativeLayout)this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzoneEditPictureActivity.getLayoutInflater().inflate(2131562413, localRelativeLayout, false);
    localLayoutParams = new RelativeLayout.LayoutParams(-1, AIOUtils.a(50.0F, a().a().getResources()));
    ((RelativeLayout)localObject).setVisibility(0);
    localLayoutParams.addRule(12);
    if (LiuHaiUtils.jdField_e_of_type_Int > 0) {}
    for (int m = LiuHaiUtils.jdField_e_of_type_Int;; m = AIOUtils.a(60.0F, this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzoneEditPictureActivity.getResources()))
    {
      localLayoutParams.bottomMargin = m;
      View localView = new View(this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzoneEditPictureActivity);
      localView.setBackgroundColor(Color.argb(128, 0, 0, 0));
      localView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
      localView.setVisibility(8);
      localRelativeLayout.addView((View)localObject, localLayoutParams);
      localRelativeLayout.addView(localView);
      this.jdField_a_of_type_AndroidViewView = localView;
      return;
    }
  }
  
  private QzoneEditPicturePartReport a()
  {
    Iterator localIterator = a().iterator();
    while (localIterator.hasNext())
    {
      EditVideoPart localEditVideoPart = (EditVideoPart)localIterator.next();
      if ((localEditVideoPart instanceof QzoneEditPicturePartReport)) {
        return (QzoneEditPicturePartReport)localEditVideoPart;
      }
    }
    return null;
  }
  
  public void a(Context paramContext)
  {
    super.a(paramContext);
    c(3005);
  }
  
  public void a(@NonNull EditVideoParams paramEditVideoParams)
  {
    int m = (paramEditVideoParams.jdField_c_of_type_Int | 0x2000) & 0xFFFFEFFF;
    if (f())
    {
      super.a(new EditVideoParams(paramEditVideoParams.jdField_a_of_type_Int, m & 0xFFFFFDFF, paramEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource, paramEditVideoParams.jdField_a_of_type_AndroidOsBundle));
      a(this.jdField_a_of_type_JavaUtilList);
      return;
    }
    super.a(new EditVideoParams(paramEditVideoParams.jdField_a_of_type_Int, m, paramEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource, paramEditVideoParams.jdField_a_of_type_AndroidOsBundle));
  }
  
  public void a(List<EditVideoPart> paramList)
  {
    super.a(paramList);
    if (f())
    {
      Object localObject = new QzoneEditPicturePartComment(this);
      this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzoneEditPicturePartComment = ((QzoneEditPicturePartComment)localObject);
      paramList.add(localObject);
      localObject = new QzoneEditPicturePartScheduleDelete(this);
      this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzoneEditPicturePartScheduleDelete = ((QzoneEditPicturePartScheduleDelete)localObject);
      paramList.add(localObject);
      localObject = new QzoneEditPicturePartSave(this);
      this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzoneEditPicturePartSave = ((QzoneEditPicturePartSave)localObject);
      paramList.add(localObject);
    }
    try
    {
      paramList.add(new QzoneEditVideoPartReport(this));
      return;
    }
    catch (Exception paramList)
    {
      QZLog.e("QzEditVideoPartManager", 2, new Object[] { "addExtraParts", " add report part error" });
    }
  }
  
  public void c(int paramInt)
  {
    QzoneEditPicturePartReport localQzoneEditPicturePartReport = a();
    if (localQzoneEditPicturePartReport != null) {
      localQzoneEditPicturePartReport.a(paramInt, null);
    }
  }
  
  public void e()
  {
    super.e();
    c(3006);
  }
  
  public void e(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }
  
  public boolean f()
  {
    return this.k;
  }
  
  public boolean g()
  {
    return this.j;
  }
  
  public void h()
  {
    if (f()) {
      A();
    }
    super.h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.QzoneEditPicturePartManager
 * JD-Core Version:    0.7.0.1
 */