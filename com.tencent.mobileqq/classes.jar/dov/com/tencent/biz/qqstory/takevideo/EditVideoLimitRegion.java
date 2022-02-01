package dov.com.tencent.biz.qqstory.takevideo;

import android.os.Message;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.widget.StoryGuideLineView;
import dov.com.tencent.mobileqq.activity.richmedia.QzEditVideoPartManager;

public class EditVideoLimitRegion
  extends EditVideoPart
{
  private StoryGuideLineView a;
  
  public EditVideoLimitRegion(@NonNull EditVideoPartManager paramEditVideoPartManager)
  {
    super(paramEditVideoPartManager);
  }
  
  public static void a(StoryGuideLineView paramStoryGuideLineView)
  {
    ThreadManager.excute(new EditVideoLimitRegion.1(paramStoryGuideLineView), 16, null, true);
  }
  
  private boolean b()
  {
    try
    {
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetStoryGuideLineView != null) {
        return true;
      }
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a().c();
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetStoryGuideLineView = ((StoryGuideLineView)a(2131372781));
      a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetStoryGuideLineView);
      return true;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.publish.edit.StoryDoodle", 2, "makeSureInitLayout error : " + localException.getMessage());
      }
    }
    return false;
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    if (!b()) {
      return;
    }
    if (paramBoolean4) {
      if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager instanceof QzEditVideoPartManager))
      {
        StoryGuideLineView localStoryGuideLineView = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetStoryGuideLineView;
        if (!((QzEditVideoPartManager)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager).q)
        {
          paramBoolean3 = true;
          localStoryGuideLineView.a(paramBoolean3);
          label50:
          if (!paramBoolean2) {
            break label99;
          }
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetStoryGuideLineView.b();
        }
      }
    }
    for (;;)
    {
      if (!paramBoolean1) {
        break label109;
      }
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetStoryGuideLineView.d();
      return;
      paramBoolean3 = false;
      break;
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetStoryGuideLineView.a(true);
      break label50;
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetStoryGuideLineView.a();
      break label50;
      label99:
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetStoryGuideLineView.c();
    }
    label109:
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetStoryGuideLineView.e();
  }
  
  protected boolean a(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return super.a(paramMessage);
      if ((paramMessage.obj != null) && ((paramMessage.obj instanceof EditVideoLimitRegion.LimitMessage)))
      {
        EditVideoLimitRegion.LimitMessage localLimitMessage = (EditVideoLimitRegion.LimitMessage)paramMessage.obj;
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.publish.edit.StoryDoodle", 2, "showLimitView : left : " + localLimitMessage.d + " right : " + localLimitMessage.c + " top : " + localLimitMessage.a + " bottom : " + localLimitMessage.b);
        }
        if (localLimitMessage.e) {
          a(localLimitMessage.d, localLimitMessage.c, localLimitMessage.a, localLimitMessage.b);
        } else {
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetStoryGuideLineView.f();
        }
      }
    }
  }
  
  public void f()
  {
    super.f();
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoLimitRegion
 * JD-Core Version:    0.7.0.1
 */