import android.util.SparseBooleanArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.biz.qqstory.support.report.VideoEditReport;
import com.tencent.biz.qqstory.takevideo.doodle.layer.LineLayer;
import com.tencent.biz.qqstory.takevideo.doodle.layer.base.BaseLayer.OnLayerTouchListener;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout.DoodleBtnOperationHelper;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleOpController;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.PureOperator;
import com.tencent.biz.qqstory.takevideo.view.widget.colorbar.HorizontalSelectColorLayout;
import com.tencent.biz.qqstory.takevideo.view.widget.colorbar.stroke.HorizontalStroke;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;

public class ojt
  implements BaseLayer.OnLayerTouchListener
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  int b;
  
  private ojt(DoodleLayout paramDoodleLayout) {}
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    DoodleLayout.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout, System.currentTimeMillis() + 500L);
    if (paramBoolean3) {
      DoodleLayout.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout, DoodleLayout.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout) + 500L);
    }
    Object localObject = new AlphaAnimation(1.0F, 0.0F);
    ((AlphaAnimation)localObject).setDuration(500L);
    ((AlphaAnimation)localObject).setFillAfter(true);
    ((AlphaAnimation)localObject).setAnimationListener(new oju(this));
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setDuration(500L);
    if (paramBoolean3) {
      localAlphaAnimation.setStartOffset(500L);
    }
    localAlphaAnimation.setFillAfter(true);
    localAlphaAnimation.setAnimationListener(new ojv(this));
    if (paramBoolean2) {
      localObject = localAlphaAnimation;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.startAnimation((Animation)localObject);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setAnimationEndTime(DoodleLayout.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout));
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$DoodleBtnOperationHelper != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$DoodleBtnOperationHelper.b((Animation)localObject);
      }
      return;
    }
  }
  
  public boolean a(LineLayer paramLineLayer, MotionEvent paramMotionEvent)
  {
    HorizontalStroke localHorizontalStroke = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.a();
    if (localHorizontalStroke != null) {}
    int i;
    int j;
    switch (localHorizontalStroke.jdField_a_of_type_Int)
    {
    default: 
      i = Math.round(paramMotionEvent.getY());
      j = Math.round(paramMotionEvent.getX());
      switch (paramMotionEvent.getAction())
      {
      }
      break;
    }
    label516:
    do
    {
      do
      {
        do
        {
          return false;
          i = localHorizontalStroke.jdField_b_of_type_Int;
          if (i != PureOperator.jdField_a_of_type_Int) {
            this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_b_of_type_AndroidUtilSparseBooleanArray.put(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_Int, true);
          }
          for (;;)
          {
            localObject = (PureOperator)paramLineLayer.a(101);
            if (localObject != null) {
              ((PureOperator)localObject).a(i);
            }
            if (paramLineLayer.b()) {
              break;
            }
            paramLineLayer.e();
            break;
            this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_b_of_type_AndroidUtilSparseBooleanArray.put(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_Int, false);
          }
          if (paramLineLayer.c()) {
            break;
          }
          paramLineLayer.d();
          break;
          Object localObject = null;
          if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.getContext() instanceof QQStoryBaseActivity)) {
            localObject = ((QQStoryBaseActivity)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.getContext()).a;
          }
          paramLineLayer.a((AppInterface)localObject, 2, localHorizontalStroke.jdField_b_of_type_Int);
          break;
          this.jdField_a_of_type_Int = Math.round(paramMotionEvent.getX());
          this.jdField_b_of_type_Int = Math.round(paramMotionEvent.getY());
          this.jdField_a_of_type_Long = System.currentTimeMillis();
          return false;
        } while (((Math.abs(j - this.jdField_a_of_type_Int) < 3) && (Math.abs(i - this.jdField_b_of_type_Int) < 3)) || (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_b_of_type_Int == 6) || (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_b_of_type_Int == 5));
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.c(5);
        if (DoodleLayout.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout) > System.currentTimeMillis()) {
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a(5, Boolean.valueOf(false));
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a(new View[] { this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout });
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("Personality", 2, "LineLayer draw move hide");
          return false;
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a(5, Boolean.valueOf(true));
          a(true, false, true);
        }
        if (paramLineLayer.a.a() > 0) {
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setUndoViewEnable(true);
        }
        if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_b_of_type_Int != 5) {
          break label516;
        }
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.d(2);
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.c(2);
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.b(new View[] { this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout });
        a(true, true, true);
      } while (!QLog.isColorLevel());
      QLog.d("Personality", 2, "LineLayer draw up show");
      return false;
    } while ((Math.abs(j - this.jdField_a_of_type_Int) >= 3) || (Math.abs(i - this.jdField_b_of_type_Int) >= 3));
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_b_of_type_Int == 6)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a(2, Boolean.valueOf(false));
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.c(2);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.b(new View[] { this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout });
      if (paramLineLayer.a.a() > 0) {}
      for (bool = true;; bool = false)
      {
        a(bool, true, false);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Personality", 2, "LineLayer tap up show");
        return false;
      }
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.c(6);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.d(6);
    VideoEditReport.b("0X80080E5", VideoEditReport.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a(new View[] { this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout });
    if (paramLineLayer.a.a() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      a(bool, false, true);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Personality", 2, "LineLayer tap up hide");
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ojt
 * JD-Core Version:    0.7.0.1
 */