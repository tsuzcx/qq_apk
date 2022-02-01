package dov.com.tencent.mobileqq.activity.richmedia;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideShowPhotoListManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.open.base.ToastUtil;
import com.tencent.util.LiuHaiUtils;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.widget.QzoneGuideBubbleHelper;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoPart;

public class QzoneRightButton
  extends EditVideoPart
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private View jdField_a_of_type_AndroidViewView;
  private QzEditVideoPartManager jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzEditVideoPartManager;
  private boolean jdField_a_of_type_Boolean = false;
  private View b;
  private View c;
  
  public QzoneRightButton(@NonNull QzEditVideoPartManager paramQzEditVideoPartManager, Activity paramActivity)
  {
    super(paramQzEditVideoPartManager);
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzEditVideoPartManager = paramQzEditVideoPartManager;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    if (SlideShowPhotoListManager.a().b() == 22) {
      bool = true;
    }
    this.jdField_a_of_type_Boolean = bool;
  }
  
  private void a(String paramString)
  {
    String str = a().getString(2131717867);
    QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.getInstance();
    QZoneHelper.forwardOpenQzoneVip2(this.jdField_a_of_type_AndroidAppActivity, localUserInfo, paramString, QQStoryContext.a().a(), "", 1010, str, false);
  }
  
  private void c()
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)a(2131366183);
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(a()).inflate(2131562415, localRelativeLayout, false);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.setMargins(0, LiuHaiUtils.a, 0, 0);
    localLayoutParams.addRule(11);
    localLayoutParams.addRule(10);
    this.b = this.jdField_a_of_type_AndroidViewView.findViewById(2131375847);
    this.c = this.jdField_a_of_type_AndroidViewView.findViewById(2131375846);
    if (this.jdField_a_of_type_Boolean)
    {
      this.b.setVisibility(8);
      this.c.setVisibility(8);
    }
    for (;;)
    {
      localRelativeLayout.addView(this.jdField_a_of_type_AndroidViewView, localLayoutParams);
      return;
      this.b.setOnClickListener(new QzoneRightButton.1(this));
      this.c.setOnClickListener(new QzoneRightButton.2(this));
    }
  }
  
  private void d()
  {
    DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 230).setMessage(2131718001).setPositiveButton(2131717515, new QzoneRightButton.4(this)).setNegativeButton(2131719344, new QzoneRightButton.3(this)).show();
  }
  
  private void i()
  {
    DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 230).setMessage(2131718002).setPositiveButton(2131717515, new QzoneRightButton.6(this)).setNegativeButton(2131691144, new QzoneRightButton.5(this)).show();
  }
  
  public void a()
  {
    super.a();
    c();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1010) && (paramInt2 == -1))
    {
      ToastUtil.a().a(2131717737);
      this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzEditVideoPartManager.e = true;
    }
  }
  
  public void a(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_AndroidViewView == null);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      return;
    } while (this.jdField_a_of_type_AndroidViewView == null);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void g()
  {
    super.g();
    QzoneGuideBubbleHelper.getInstance().dismissGuideBubble();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.QzoneRightButton
 * JD-Core Version:    0.7.0.1
 */