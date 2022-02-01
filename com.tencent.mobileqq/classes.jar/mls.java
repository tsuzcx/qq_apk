import android.graphics.PointF;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.qphone.base.util.QLog;

public class mls
  implements lqr
{
  private int jdField_a_of_type_Int;
  private int b;
  private int c;
  private int d;
  private int e;
  
  private mls(VideoLayerUI paramVideoLayerUI) {}
  
  public void a(lqq paramlqq)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_JavaLangString, 2, "onMoveEnd");
    }
    if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_Mjj.a() == 2) {
      return;
    }
    PointF localPointF = paramlqq.a();
    int i = (int)localPointF.x;
    int j = (int)localPointF.y;
    if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.q == 0) {
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ArrayOfMep[0].a(i, j, true);
    }
    for (;;)
    {
      lir.a(false);
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(Integer.valueOf(6503), Boolean.valueOf(false));
      return;
      if ((this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.q == 1) && (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.h()))
      {
        this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.b(i, j);
        this.c = ((int)paramlqq.a());
        this.d = ((int)paramlqq.b());
        this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.t = this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(this.e, this.jdField_a_of_type_Int, this.b, this.c, this.d);
        this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.n(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.t);
      }
    }
  }
  
  public boolean a(lqq paramlqq)
  {
    if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_Mjj.a() == 2) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_JavaLangString, 2, "onMove");
    }
    paramlqq = paramlqq.a();
    int i = (int)paramlqq.x;
    int j = (int)paramlqq.y;
    if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.q == 0) {
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ArrayOfMep[0].a(i, j, false);
    }
    for (;;)
    {
      return true;
      if ((this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.q == 1) && (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.h()))
      {
        if ((Math.abs(i) > 5) || (Math.abs(j) > 5)) {
          VideoLayerUI.b(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI, true);
        }
        this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.b(i, j);
      }
    }
  }
  
  public boolean b(lqq paramlqq)
  {
    if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.q == 0)
    {
      paramlqq = paramlqq.a();
      int i = (int)paramlqq.x;
      int j = (int)paramlqq.y;
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ArrayOfMep[0].a(i, j, false);
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        QLog.w(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_JavaLangString, 1, "onMoveBegin, mTargetIndex[" + this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.q + "], startX[" + this.jdField_a_of_type_Int + "], startY[" + this.b + "], startPosition[" + this.e + "], mTopOffset[" + this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.n + "], mBottomOffset[" + this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.o + "], mRecordCtrlBottom[" + this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.i + "]");
        QLog.d(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_JavaLangString, 2, "onMoveBegin");
      }
      lir.a(true);
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(Integer.valueOf(6503), Boolean.valueOf(true));
      return true;
      if ((this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.q == 1) && (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.h()))
      {
        this.jdField_a_of_type_Int = ((int)paramlqq.a());
        this.b = ((int)paramlqq.b());
        this.e = this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.h();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mls
 * JD-Core Version:    0.7.0.1
 */