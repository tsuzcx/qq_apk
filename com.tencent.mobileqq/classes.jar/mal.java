import android.graphics.PointF;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.qphone.base.util.QLog;

public class mal
  implements lga
{
  private int jdField_a_of_type_Int;
  private int b;
  private int c;
  private int d;
  private int e;
  
  private mal(VideoLayerUI paramVideoLayerUI) {}
  
  public void a(lfz paramlfz)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_JavaLangString, 2, "onMoveEnd");
    }
    if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_Lyf.a() == 2) {
      return;
    }
    PointF localPointF = paramlfz.a();
    int i = (int)localPointF.x;
    int j = (int)localPointF.y;
    if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.q == 0) {
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ArrayOfLtl[0].a(i, j, true);
    }
    for (;;)
    {
      kyy.a(false);
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(Integer.valueOf(6503), Boolean.valueOf(false));
      return;
      if ((this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.q == 1) && (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.h()))
      {
        this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.c(i, j);
        this.c = ((int)paramlfz.a());
        this.d = ((int)paramlfz.b());
        this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.t = this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(this.e, this.jdField_a_of_type_Int, this.b, this.c, this.d);
        this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.n(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.t);
      }
    }
  }
  
  public boolean a(lfz paramlfz)
  {
    if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_Lyf.a() == 2) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_JavaLangString, 2, "onMove");
    }
    paramlfz = paramlfz.a();
    int i = (int)paramlfz.x;
    int j = (int)paramlfz.y;
    if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.q == 0) {
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ArrayOfLtl[0].a(i, j, false);
    }
    for (;;)
    {
      return true;
      if ((this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.q == 1) && (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.h()))
      {
        if ((Math.abs(i) > 5) || (Math.abs(j) > 5)) {
          VideoLayerUI.b(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI, true);
        }
        this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.c(i, j);
      }
    }
  }
  
  public boolean b(lfz paramlfz)
  {
    if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.q == 0)
    {
      paramlfz = paramlfz.a();
      int i = (int)paramlfz.x;
      int j = (int)paramlfz.y;
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ArrayOfLtl[0].a(i, j, false);
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        QLog.w(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_JavaLangString, 1, "onMoveBegin, mTargetIndex[" + this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.q + "], startX[" + this.jdField_a_of_type_Int + "], startY[" + this.b + "], startPosition[" + this.e + "], mTopOffset[" + this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.n + "], mBottomOffset[" + this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.o + "], mRecordCtrlBottom[" + this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.i + "]");
        QLog.d(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_JavaLangString, 2, "onMoveBegin");
      }
      kyy.a(true);
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(Integer.valueOf(6503), Boolean.valueOf(true));
      return true;
      if ((this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.q == 1) && (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.h()))
      {
        this.jdField_a_of_type_Int = ((int)paramlfz.a());
        this.b = ((int)paramlfz.b());
        this.e = this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.h();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mal
 * JD-Core Version:    0.7.0.1
 */