import android.graphics.Rect;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.widget.ImageView;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVActivity.AnimationTrigger;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.av.ui.VideoLayerUIBase;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class mmd
  implements lsd
{
  private float jdField_a_of_type_Float;
  private long jdField_a_of_type_Long;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private boolean jdField_b_of_type_Boolean;
  
  public mmd(VideoLayerUI paramVideoLayerUI) {}
  
  public boolean a(lsc paramlsc, MotionEvent paramMotionEvent)
  {
    boolean bool = b(paramlsc, paramMotionEvent);
    if (paramMotionEvent.getAction() == 1) {
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_Long = 0L;
    }
    return bool;
  }
  
  boolean b(lsc paramlsc, MotionEvent paramMotionEvent)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramlsc == null) || (paramMotionEvent == null) || (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) || (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvVideoController == null)) {
      bool1 = false;
    }
    label438:
    label459:
    label486:
    label1020:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return bool1;
                  bool1 = bool2;
                } while (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvVideoController.a().t == 1);
                if (paramMotionEvent.getAction() == 0)
                {
                  this.jdField_a_of_type_Float = 0.0F;
                  this.jdField_b_of_type_Float = 0.0F;
                  this.jdField_a_of_type_Long = System.currentTimeMillis();
                  this.jdField_a_of_type_Float = paramMotionEvent.getX();
                  this.jdField_b_of_type_Float = paramMotionEvent.getY();
                  if (QLog.isColorLevel()) {
                    QLog.e(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_JavaLangString, 2, "[childLock] touch onDown: " + this.jdField_a_of_type_Float + " x " + this.jdField_b_of_type_Float + " ==========");
                  }
                  if (!this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvVideoController.a().x) {
                    break label438;
                  }
                  this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvUiAVActivity$AnimationTrigger.a();
                }
                for (;;)
                {
                  this.jdField_a_of_type_Boolean = false;
                  this.jdField_b_of_type_Boolean = false;
                  if ((!this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvVideoController.a().x) && ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getPointerCount() > 1) || ((paramMotionEvent.getAction() == 2) && ((Math.abs(paramMotionEvent.getX() - this.jdField_a_of_type_Float) > 70.0F) || (Math.abs(paramMotionEvent.getY() - this.jdField_b_of_type_Float) > 70.0F)))))
                  {
                    this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvUiAVActivity$AnimationTrigger);
                    if ((this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvUiAVActivity$AnimationTrigger != null) && (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvUiAVActivity$AnimationTrigger.a()))
                    {
                      if (paramMotionEvent.getAction() == 1) {
                        this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvUiAVActivity$AnimationTrigger.c();
                      }
                      if (QLog.isColorLevel()) {
                        QLog.e(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_JavaLangString, 2, "[childLock] cancel animation");
                      }
                    }
                    if (QLog.isColorLevel()) {
                      QLog.e(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_JavaLangString, 2, "[childLock] touch end ==========");
                    }
                  }
                  if (!this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvVideoController.a().x) {
                    break label459;
                  }
                  bool1 = bool2;
                  if (paramMotionEvent.getAction() != 1) {
                    break;
                  }
                  bool1 = bool2;
                  if (System.currentTimeMillis() - this.jdField_a_of_type_Long >= 200L) {
                    break;
                  }
                  bool1 = bool2;
                  if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvUiAVActivity$AnimationTrigger == null) {
                    break;
                  }
                  this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvUiAVActivity$AnimationTrigger.b();
                  return true;
                  this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvUiAVActivity$AnimationTrigger.a(this.jdField_a_of_type_Float, this.jdField_b_of_type_Float);
                }
                this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.r = -1;
                meu[] arrayOfmeu = this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ArrayOfMeu;
                int k = arrayOfmeu.length;
                int i = 0;
                int j = 0;
                if (i < k)
                {
                  if (paramlsc == arrayOfmeu[i]) {
                    this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.r = j;
                  }
                }
                else if ((VideoLayerUI.b(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI)) && (VideoLayerUI.a(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI) != null) && (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvVideoController != null) && (VideoLayerUIBase.b(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvVideoController.a())) && (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvVideoController.a().c != null) && (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvVideoController.a().c.size() > 0))
                {
                  i = (int)paramMotionEvent.getX();
                  j = (int)paramMotionEvent.getY();
                  if ((paramMotionEvent.getAction() == 0) && (VideoLayerUI.a(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI).contains(i, j)))
                  {
                    this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_Long = paramMotionEvent.getEventTime();
                    this.jdField_a_of_type_Boolean = true;
                  }
                  if (this.jdField_a_of_type_Boolean == true)
                  {
                    if (!VideoLayerUI.a(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI).contains(i, j)) {
                      break label972;
                    }
                    VideoLayerUI.a(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI).onTouchEvent(paramMotionEvent);
                    switch (paramMotionEvent.getAction())
                    {
                    }
                  }
                }
                for (;;)
                {
                  if ((this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_AndroidWidgetImageView != null) && (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0)) {
                    this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.r = 0;
                  }
                  if ((this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_AndroidViewGestureDetector != null) && (!this.jdField_a_of_type_Boolean)) {
                    this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
                  }
                  if (!VideoLayerUIBase.a(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvVideoController.a())) {
                    break label1020;
                  }
                  paramlsc = lbz.a().a();
                  if (paramlsc != null)
                  {
                    bool1 = bool2;
                    if (paramlsc.A()) {
                      break;
                    }
                  }
                  bool1 = bool2;
                  if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.r != 1) {
                    break;
                  }
                  bool1 = bool2;
                  if (VideoLayerUI.a(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI) == null) {
                    break;
                  }
                  if ((!VideoLayerUI.a(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI).a()) && (paramMotionEvent.getAction() != 0))
                  {
                    paramlsc = MotionEvent.obtain(paramMotionEvent);
                    paramlsc.setAction(0);
                    VideoLayerUI.a(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI).a(paramlsc);
                    paramlsc.recycle();
                  }
                  VideoLayerUI.a(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI).a(paramMotionEvent);
                  this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_Long = paramMotionEvent.getEventTime();
                  return true;
                  j += 1;
                  i += 1;
                  break label486;
                  paramlsc = this.jdField_a_of_type_ComTencentAvUiVideoLayerUI;
                  if (!VideoLayerUI.a(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI).a()) {}
                  for (bool1 = true;; bool1 = false)
                  {
                    VideoLayerUI.c(paramlsc, bool1);
                    VideoLayerUI.a(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI).a();
                    break;
                  }
                  this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.b();
                  continue;
                  if (!this.jdField_b_of_type_Boolean)
                  {
                    paramlsc = MotionEvent.obtain(paramMotionEvent);
                    paramlsc.setAction(3);
                    VideoLayerUI.a(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI).onTouchEvent(paramlsc);
                    this.jdField_b_of_type_Boolean = true;
                    this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_Long = paramMotionEvent.getEventTime();
                  }
                }
                bool1 = bool2;
              } while (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.r != 0);
              if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.p == 0) {
                break;
              }
              bool1 = bool2;
            } while (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.o != 0);
            bool1 = bool2;
          } while (2 != this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ArrayOfMeu[0].h());
          bool1 = bool2;
        } while (VideoLayerUI.a(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI) == null);
        this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_Long = paramMotionEvent.getEventTime();
        VideoLayerUI.a(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI).onTouchEvent(paramMotionEvent);
        bool1 = bool2;
      } while (VideoLayerUI.a(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI).isInProgress());
      bool1 = bool2;
    } while (VideoLayerUI.a(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI) == null);
    label972:
    VideoLayerUI.a(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI).a(paramMotionEvent);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mmd
 * JD-Core Version:    0.7.0.1
 */