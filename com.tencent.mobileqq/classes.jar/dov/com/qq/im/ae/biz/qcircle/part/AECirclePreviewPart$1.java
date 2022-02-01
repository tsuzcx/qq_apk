package dov.com.qq.im.ae.biz.qcircle.part;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnItemTouchListener;
import android.view.MotionEvent;
import com.tencent.qphone.base.util.QLog;

class AECirclePreviewPart$1
  implements RecyclerView.OnItemTouchListener
{
  AECirclePreviewPart$1(AECirclePreviewPart paramAECirclePreviewPart) {}
  
  public boolean onInterceptTouchEvent(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0) {
      AECirclePreviewPart.a(this.a, paramMotionEvent.getY());
    }
    float f;
    do
    {
      do
      {
        return false;
      } while (paramMotionEvent.getAction() != 1);
      f = paramMotionEvent.getY();
      QLog.d("AECirclePreviewPart", 4, AECirclePreviewPart.a(this.a) + " " + f);
    } while (Math.abs(f - AECirclePreviewPart.a(this.a)) <= 600.0F);
    AECirclePreviewPart.a(this.a);
    return true;
  }
  
  public void onRequestDisallowInterceptTouchEvent(boolean paramBoolean) {}
  
  public void onTouchEvent(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.biz.qcircle.part.AECirclePreviewPart.1
 * JD-Core Version:    0.7.0.1
 */