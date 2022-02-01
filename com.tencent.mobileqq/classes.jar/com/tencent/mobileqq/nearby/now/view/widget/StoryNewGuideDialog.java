package com.tencent.mobileqq.nearby.now.view.widget;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.qqstory.view.AnimationPoint;
import com.tencent.mobileqq.nearby.now.IResourceUtil;
import com.tencent.mobileqq.qroute.QRoute;

public class StoryNewGuideDialog
  extends Dialog
{
  protected TextView a;
  protected AnimationPoint a;
  
  public StoryNewGuideDialog(Context paramContext)
  {
    super(paramContext, ((IResourceUtil)QRoute.api(IResourceUtil.class)).getAddDescribeDialogStyleNoFull());
    paramContext = LayoutInflater.from(paramContext).inflate(((IResourceUtil)QRoute.api(IResourceUtil.class)).getQQStoryNewGuideDialog(), null);
    paramContext.setOnTouchListener(new StoryNewGuideDialog.1(this));
    super.setContentView(paramContext);
    this.jdField_a_of_type_ComTencentBizQqstoryViewAnimationPoint = ((AnimationPoint)super.findViewById(((IResourceUtil)QRoute.api(IResourceUtil.class)).getAnimationPoint()));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(((IResourceUtil)QRoute.api(IResourceUtil.class)).getGuideTv()));
    this.jdField_a_of_type_ComTencentBizQqstoryViewAnimationPoint.setDuration(-1L);
    this.jdField_a_of_type_ComTencentBizQqstoryViewAnimationPoint.setOnAnimationListener(new StoryNewGuideDialog.2(this));
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  public void dismiss()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewAnimationPoint.b();
    super.dismiss();
  }
  
  public void show()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewAnimationPoint.a();
    super.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.widget.StoryNewGuideDialog
 * JD-Core Version:    0.7.0.1
 */