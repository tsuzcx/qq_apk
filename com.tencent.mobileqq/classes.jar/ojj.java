import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.EditVideoFragment;
import com.tencent.biz.qqstory.takevideo.EditVideoPartManager;
import com.tencent.biz.qqstory.takevideo.doodle.ui.widget.ElasticImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;

public class ojj
  implements View.OnTouchListener
{
  private final int jdField_a_of_type_Int = AIOUtils.a(40.0F, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFragment.a());
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private boolean jdField_a_of_type_Boolean;
  private final int jdField_b_of_type_Int = 5;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private int d = -1;
  private int e = -1;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l;
  private int m;
  private int n;
  
  public ojj(EditVideoFragment paramEditVideoFragment, int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i1 = (int)paramMotionEvent.getRawX();
    int i2 = (int)paramMotionEvent.getRawY();
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      do
      {
        for (;;)
        {
          return true;
          if ((paramView.getTag() != null) && (((Boolean)paramView.getTag()).booleanValue()))
          {
            SLog.b("Q.qqstory.record.EditVideoFragment", "discard event. action down while doing reset animation.");
            return false;
          }
          if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFragment.c > System.currentTimeMillis()) {
            return false;
          }
          this.d = i1;
          this.e = i2;
          this.f = paramView.getLeft();
          this.g = (ScreenUtil.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFragment.a()) - paramView.getBottom());
          this.m = 0;
          this.n = 0;
          this.l = paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex());
          this.jdField_a_of_type_Boolean = false;
          this.jdField_c_of_type_Boolean = false;
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFragment.a(paramView);
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFragment.a(this.jdField_c_of_type_Int);
          continue;
          int i3 = paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex());
          if (i3 == this.l) {
            break;
          }
          this.d = i1;
          this.e = i2;
          this.m = (paramView.getLeft() - this.f);
          this.n = (ScreenUtil.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFragment.a()) - paramView.getBottom() - this.g);
          this.l = i3;
        }
        this.h = (i1 - this.d);
        this.i = (this.e - i2);
      } while ((Math.abs(this.h) <= 5) && (Math.abs(this.i) <= 5));
      this.jdField_a_of_type_Boolean = true;
      if (!this.jdField_c_of_type_Boolean)
      {
        this.jdField_c_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFragment.b(paramView);
      }
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFragment.a(this.jdField_c_of_type_Int, false);
      this.j = (this.f + this.m + this.h);
      this.k = (this.g + this.n + this.i);
      if (this.j < 0) {
        this.j = 0;
      }
      if (this.j + paramView.getWidth() > ScreenUtil.jdField_a_of_type_Int) {
        this.j = (ScreenUtil.jdField_a_of_type_Int - paramView.getWidth());
      }
      if (this.k < 0) {
        this.k = 0;
      }
      if (this.k + paramView.getHeight() > ScreenUtil.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFragment.a())) {
        this.k = (ScreenUtil.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFragment.a()) - paramView.getHeight());
      }
      paramMotionEvent = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
      paramMotionEvent.leftMargin = this.j;
      paramMotionEvent.bottomMargin = this.k;
      paramView.setLayoutParams(paramMotionEvent);
      paramView.invalidate();
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFragment.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFragment.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetElasticImageView.getGlobalVisibleRect(this.jdField_a_of_type_AndroidGraphicsRect);
      paramView = this.jdField_a_of_type_AndroidGraphicsRect;
      paramView.left -= this.jdField_a_of_type_Int;
      paramView = this.jdField_a_of_type_AndroidGraphicsRect;
      paramView.top -= this.jdField_a_of_type_Int;
      paramView = this.jdField_a_of_type_AndroidGraphicsRect;
      paramView.right += this.jdField_a_of_type_Int;
      paramView = this.jdField_a_of_type_AndroidGraphicsRect;
      paramView.bottom += this.jdField_a_of_type_Int;
      if (this.jdField_a_of_type_AndroidGraphicsRect.contains(i1, i2))
      {
        this.jdField_b_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFragment.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetElasticImageView.a(1.5F);
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFragment.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetElasticImageView.getDrawable().setColorFilter(Color.parseColor("#F31919"), PorterDuff.Mode.MULTIPLY);
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFragment.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(23);
        break;
        if (this.jdField_b_of_type_Boolean)
        {
          this.jdField_b_of_type_Boolean = false;
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFragment.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetElasticImageView.a(1.0F);
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFragment.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetElasticImageView.getDrawable().clearColorFilter();
        }
      }
    } while (!this.jdField_a_of_type_Boolean);
    paramView.clearAnimation();
    if ((this.jdField_a_of_type_AndroidGraphicsRect != null) && (this.jdField_a_of_type_AndroidGraphicsRect.contains(i1, i2)))
    {
      SLog.c("Q.qqstory.record.EditVideoFragment", "remove fragment.");
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFragment.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetElasticImageView.a(1.0F);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFragment.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetElasticImageView.getDrawable().clearColorFilter();
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFragment.a(this.jdField_c_of_type_Int, this.f, this.g);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFragment.b(this.jdField_c_of_type_Int);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFragment.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFragment.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(0);
      break;
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFragment.a(paramView, paramView.getLeft(), ScreenUtil.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFragment.a()) - paramView.getBottom(), this.f, this.g);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFragment.a(this.jdField_c_of_type_Int, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ojj
 * JD-Core Version:    0.7.0.1
 */