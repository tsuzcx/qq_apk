import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class rmp
{
  private static rmp jdField_a_of_type_Rmp = new rmp();
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = -1L;
  private List<?> jdField_a_of_type_JavaUtilList;
  private rmo jdField_a_of_type_Rmo;
  private rmq jdField_a_of_type_Rmq;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = -100;
  private long jdField_b_of_type_Long = -1L;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = -100;
  private long jdField_c_of_type_Long = -1L;
  private boolean jdField_c_of_type_Boolean;
  private int d = -100;
  
  public static rmp a()
  {
    return jdField_a_of_type_Rmp;
  }
  
  private void b()
  {
    rmq localrmq = this.jdField_a_of_type_Rmq;
    if ((localrmq == null) || (localrmq.a())) {
      return;
    }
    localrmq.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    localrmq.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
    if (QLog.isColorLevel()) {
      QLog.d("VideoBehaviorsReporter", 2, "doReportVideoBehaviorsSeq(): " + localrmq.toString());
    }
    ozs.f(BaseApplication.getContext(), ozs.a(), true, localrmq.a());
    this.jdField_a_of_type_Rmq.a();
  }
  
  public void a()
  {
    b();
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Int = -100;
    this.jdField_c_of_type_Int = -100;
    this.d = -100;
    this.jdField_c_of_type_Long = -1L;
    this.jdField_a_of_type_JavaUtilList = null;
    this.jdField_a_of_type_Rmo = null;
    this.jdField_a_of_type_Rmq = null;
  }
  
  public void a(int paramInt)
  {
    if (!this.jdField_c_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(sel paramsel, List<?> paramList)
  {
    if (!this.jdField_c_of_type_Boolean) {}
    do
    {
      return;
      if (this.jdField_a_of_type_JavaUtilList == null)
      {
        this.jdField_a_of_type_JavaUtilList = paramList;
        if ((this.jdField_c_of_type_Long == -1L) && (this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
        {
          this.jdField_c_of_type_Long = ((BaseArticleInfo)this.jdField_a_of_type_JavaUtilList.get(0)).mRecommendSeq;
          if (QLog.isColorLevel()) {
            QLog.d("VideoBehaviorsReporter", 2, "bindVideoChannel(): 2,  mFirstVideoSeq = " + this.jdField_c_of_type_Long);
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("VideoBehaviorsReporter", 2, "bindVideoChannel(): 1, mFirstVideoSeq = " + this.jdField_c_of_type_Long);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public void b(boolean paramBoolean)
  {
    if (!this.jdField_c_of_type_Boolean) {}
    while (this.jdField_a_of_type_Boolean == paramBoolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void c(boolean paramBoolean)
  {
    if (!this.jdField_c_of_type_Boolean) {
      return;
    }
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rmp
 * JD-Core Version:    0.7.0.1
 */