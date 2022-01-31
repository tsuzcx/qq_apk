import android.graphics.PointF;
import com.tencent.av.business.manager.zimu.ARZimuTask;
import com.tencent.av.opengl.gesturedetectors.MoveGestureDetector;
import com.tencent.av.opengl.gesturedetectors.MoveGestureDetector.OnMoveGestureListener;
import com.tencent.av.ui.GLVideoView;
import com.tencent.av.ui.ScreenLayout;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.qphone.base.util.QLog;

public class kef
  implements MoveGestureDetector.OnMoveGestureListener
{
  private int jdField_a_of_type_Int;
  private int b;
  private int c;
  private int d;
  private int e;
  
  private kef(VideoLayerUI paramVideoLayerUI) {}
  
  public void a(MoveGestureDetector paramMoveGestureDetector)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_JavaLangString, 2, "onMoveEnd");
    }
    if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvUiScreenLayout.a() == 2) {
      return;
    }
    PointF localPointF = paramMoveGestureDetector.a();
    int i = (int)localPointF.x;
    int j = (int)localPointF.y;
    if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.e == 0) {
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].a(i, j, true);
    }
    for (;;)
    {
      ARZimuTask.a(false);
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(Integer.valueOf(6503), Boolean.valueOf(false));
      return;
      if ((this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.e == 1) && ((this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.c == 0) || (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.b == 0) || (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.b == this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_Int)))
      {
        this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.b(i, j);
        this.c = ((int)paramMoveGestureDetector.a());
        this.d = ((int)paramMoveGestureDetector.b());
        this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.h = this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(this.e, this.jdField_a_of_type_Int, this.b, this.c, this.d);
        if (VideoLayerUI.a(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI))
        {
          if (this.e == 4) {
            this.e = 3;
          }
          if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.h == 4) {
            this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.h = this.e;
          }
        }
        this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.l(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.h);
      }
    }
  }
  
  public boolean a(MoveGestureDetector paramMoveGestureDetector)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_JavaLangString, 2, "onMoveBegin");
    }
    if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.e == 0)
    {
      paramMoveGestureDetector = paramMoveGestureDetector.a();
      int i = (int)paramMoveGestureDetector.x;
      int j = (int)paramMoveGestureDetector.y;
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].a(i, j, false);
    }
    for (;;)
    {
      ARZimuTask.a(true);
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(Integer.valueOf(6503), Boolean.valueOf(true));
      return true;
      if ((this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.e == 1) && ((this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.c == 0) || (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.b == 0)))
      {
        this.jdField_a_of_type_Int = ((int)paramMoveGestureDetector.a());
        this.b = ((int)paramMoveGestureDetector.b());
        this.e = this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.c();
      }
    }
  }
  
  public boolean b(MoveGestureDetector paramMoveGestureDetector)
  {
    if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvUiScreenLayout.a() == 2) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_JavaLangString, 2, "onMove");
    }
    paramMoveGestureDetector = paramMoveGestureDetector.a();
    int i = (int)paramMoveGestureDetector.x;
    int j = (int)paramMoveGestureDetector.y;
    if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.e == 0) {
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].a(i, j, false);
    }
    for (;;)
    {
      return true;
      if ((this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.e == 1) && ((this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.c == 0) || (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.b == 0) || (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.b == this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_Int)))
      {
        if ((Math.abs(i) > 5) || (Math.abs(j) > 5)) {
          VideoLayerUI.a(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI, true);
        }
        this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.b(i, j);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     kef
 * JD-Core Version:    0.7.0.1
 */