import android.graphics.PointF;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.qphone.base.util.QLog;

public class mkz
  implements lqm
{
  private int jdField_a_of_type_Int;
  private int b;
  private int c;
  private int d;
  private int e;
  
  private mkz(VideoLayerUI paramVideoLayerUI) {}
  
  public void a(lql paramlql)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_JavaLangString, 2, "onMoveEnd");
    }
    if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_Mit.a() == 2) {
      return;
    }
    PointF localPointF = paramlql.a();
    int i = (int)localPointF.x;
    int j = (int)localPointF.y;
    if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.q == 0) {
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ArrayOfMdz[0].a(i, j, true);
    }
    for (;;)
    {
      ljj.a(false);
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(Integer.valueOf(6503), Boolean.valueOf(false));
      return;
      if ((this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.q == 1) && (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.h()))
      {
        this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.c(i, j);
        this.c = ((int)paramlql.a());
        this.d = ((int)paramlql.b());
        this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.t = this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(this.e, this.jdField_a_of_type_Int, this.b, this.c, this.d);
        this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.n(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.t);
      }
    }
  }
  
  public boolean a(lql paramlql)
  {
    if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_Mit.a() == 2) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_JavaLangString, 2, "onMove");
    }
    paramlql = paramlql.a();
    int i = (int)paramlql.x;
    int j = (int)paramlql.y;
    if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.q == 0) {
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ArrayOfMdz[0].a(i, j, false);
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
  
  public boolean b(lql paramlql)
  {
    if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.q == 0)
    {
      paramlql = paramlql.a();
      int i = (int)paramlql.x;
      int j = (int)paramlql.y;
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ArrayOfMdz[0].a(i, j, false);
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        QLog.w(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_JavaLangString, 1, "onMoveBegin, mTargetIndex[" + this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.q + "], startX[" + this.jdField_a_of_type_Int + "], startY[" + this.b + "], startPosition[" + this.e + "], mTopOffset[" + this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.n + "], mBottomOffset[" + this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.o + "], mRecordCtrlBottom[" + this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.i + "]");
        QLog.d(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_JavaLangString, 2, "onMoveBegin");
      }
      ljj.a(true);
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(Integer.valueOf(6503), Boolean.valueOf(true));
      return true;
      if ((this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.q == 1) && (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.h()))
      {
        this.jdField_a_of_type_Int = ((int)paramlql.a());
        this.b = ((int)paramlql.b());
        this.e = this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.h();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mkz
 * JD-Core Version:    0.7.0.1
 */