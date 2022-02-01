import android.graphics.PointF;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.qphone.base.util.QLog;

public class mly
  implements lqm
{
  private int jdField_a_of_type_Int;
  private int b;
  private int c;
  private int d;
  private int e;
  
  private mly(VideoLayerUI paramVideoLayerUI) {}
  
  public void a(lql paramlql)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_JavaLangString, 2, "onMoveEnd");
    }
    if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_Mjo.a() == 2) {
      return;
    }
    PointF localPointF = paramlql.a();
    int i = (int)localPointF.x;
    int j = (int)localPointF.y;
    if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.r == 0) {
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ArrayOfMeu[0].a(i, j, true);
    }
    for (;;)
    {
      lix.a(false);
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(Integer.valueOf(6503), Boolean.valueOf(false));
      return;
      if ((this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.r == 1) && (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.h()))
      {
        this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.d(i, j);
        this.c = ((int)paramlql.a());
        this.d = ((int)paramlql.b());
        this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.u = this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(this.e, this.jdField_a_of_type_Int, this.b, this.c, this.d);
        this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.o(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.u);
      }
    }
  }
  
  public boolean a(lql paramlql)
  {
    if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_Mjo.a() == 2) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_JavaLangString, 2, "onMove");
    }
    paramlql = paramlql.a();
    int i = (int)paramlql.x;
    int j = (int)paramlql.y;
    if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.r == 0) {
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ArrayOfMeu[0].a(i, j, false);
    }
    for (;;)
    {
      return true;
      if ((this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.r == 1) && (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.h()))
      {
        if ((Math.abs(i) > 5) || (Math.abs(j) > 5)) {
          VideoLayerUI.b(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI, true);
        }
        this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.d(i, j);
      }
    }
  }
  
  public boolean b(lql paramlql)
  {
    if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.r == 0)
    {
      paramlql = paramlql.a();
      int i = (int)paramlql.x;
      int j = (int)paramlql.y;
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ArrayOfMeu[0].a(i, j, false);
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        QLog.w(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_JavaLangString, 1, "onMoveBegin, mTargetIndex[" + this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.r + "], startX[" + this.jdField_a_of_type_Int + "], startY[" + this.b + "], startPosition[" + this.e + "], mTopOffset[" + this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.o + "], mBottomOffset[" + this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.p + "], mRecordCtrlBottom[" + this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.i + "]");
        QLog.d(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_JavaLangString, 2, "onMoveBegin");
      }
      lix.a(true);
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(Integer.valueOf(6503), Boolean.valueOf(true));
      return true;
      if ((this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.r == 1) && (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.h()))
      {
        this.jdField_a_of_type_Int = ((int)paramlql.a());
        this.b = ((int)paramlql.b());
        this.e = this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.i();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mly
 * JD-Core Version:    0.7.0.1
 */