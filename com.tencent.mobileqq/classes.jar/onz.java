import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.biz.qqstory.playvideo.CustomViewPager;
import com.tencent.biz.qqstory.utils.BetterGestureDetector;
import com.tencent.biz.qqstory.videoplayer.StoryVideoPlayer;
import com.tencent.biz.qqstory.videoplayer.StoryVideoPlayer.GestureListener;
import com.tencent.mobileqq.util.DisplayUtil;

public class onz
  extends GestureDetector.SimpleOnGestureListener
{
  private onz(StoryVideoPlayer paramStoryVideoPlayer) {}
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if (this.a.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer$GestureListener != null) {
      this.a.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer$GestureListener.j();
    }
    return true;
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoCustomViewPager.jdField_a_of_type_Boolean = true;
    return true;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (this.a.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer$GestureListener == null) {
      return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    }
    float f2;
    if ((paramMotionEvent2 != null) && (paramMotionEvent1 != null))
    {
      float f1 = paramMotionEvent2.getY() - paramMotionEvent1.getY();
      f2 = paramMotionEvent2.getX() - paramMotionEvent1.getX();
      if (Math.abs(f1) <= Math.abs(f2)) {
        break label143;
      }
      if (Math.abs(Math.asin(Math.abs(f2) / Math.sqrt(f2 * f2 + f1 * f1))) < 0.5235987755982988D)
      {
        if (f1 >= 0.0F) {
          break label128;
        }
        this.a.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer$GestureListener.m();
      }
    }
    for (;;)
    {
      return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
      label128:
      this.a.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer$GestureListener.p();
      continue;
      label143:
      if (f2 > 0.0F) {
        this.a.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer$GestureListener.n();
      } else {
        this.a.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer$GestureListener.o();
      }
    }
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    if (this.a.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer$GestureListener != null) {
      this.a.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer$GestureListener.k();
    }
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if ((this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoCustomViewPager.jdField_a_of_type_ComTencentBizQqstoryUtilsBetterGestureDetector.a()) && (Math.abs(paramMotionEvent2.getX() - paramMotionEvent1.getX()) > DisplayUtil.a(this.a.getContext(), 10.0F))) {
      this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoCustomViewPager.jdField_a_of_type_Boolean = true;
    }
    return super.onScroll(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    if (this.a.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer$GestureListener != null) {
      this.a.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer$GestureListener.i();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     onz
 * JD-Core Version:    0.7.0.1
 */