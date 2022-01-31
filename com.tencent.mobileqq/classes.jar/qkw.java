import android.os.SystemClock;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class qkw
{
  private static qkw jdField_a_of_type_Qkw = new qkw();
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = -1L;
  private List<?> jdField_a_of_type_JavaUtilList;
  private qkv jdField_a_of_type_Qkv;
  private qkx jdField_a_of_type_Qkx;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = -100;
  private long jdField_b_of_type_Long = -1L;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = -100;
  private long jdField_c_of_type_Long = -1L;
  private boolean jdField_c_of_type_Boolean;
  private int d = -100;
  
  private int a(long paramLong, List<?> paramList)
  {
    int i;
    if (paramList != null)
    {
      i = 0;
      if (i < paramList.size()) {
        if (paramLong != Long.valueOf(((BaseArticleInfo)paramList.get(i)).mRecommendSeq).longValue()) {}
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("VideoBehaviorsReporter", 2, "findPositionInList(): seq = " + paramLong + ", posi=" + i);
      }
      return i;
      i += 1;
      break;
      i = -1;
    }
  }
  
  public static qkw a()
  {
    return jdField_a_of_type_Qkw;
  }
  
  private void b()
  {
    qkv localqkv2 = this.jdField_a_of_type_Qkv;
    qkv localqkv1 = localqkv2;
    if (localqkv2 == null)
    {
      localqkv1 = new qkv(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Qkv = localqkv1;
    }
    localqkv1.jdField_b_of_type_Int = (this.jdField_b_of_type_Int - this.jdField_c_of_type_Int);
    localqkv1.jdField_c_of_type_Int = (this.jdField_c_of_type_Int - this.d);
    localqkv1.jdField_a_of_type_Long = (this.jdField_a_of_type_Long - this.jdField_b_of_type_Long);
    localqkv1.jdField_b_of_type_Boolean = this.jdField_a_of_type_Boolean;
    localqkv1.jdField_a_of_type_Boolean = this.jdField_b_of_type_Boolean;
    this.jdField_b_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d("VideoBehaviorsReporter", 2, "doReportVideoBehaviors(): " + localqkv1.toString());
    }
    onk.f(BaseApplication.getContext(), onk.a(), true, localqkv1.a());
    this.jdField_a_of_type_Qkv = null;
  }
  
  private void c()
  {
    qkx localqkx = this.jdField_a_of_type_Qkx;
    if ((localqkx == null) || (localqkx.a())) {
      return;
    }
    localqkx.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    localqkx.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
    if (QLog.isColorLevel()) {
      QLog.d("VideoBehaviorsReporter", 2, "doReportVideoBehaviorsSeq(): " + localqkx.toString());
    }
    onk.g(BaseApplication.getContext(), onk.a(), true, localqkx.a());
    this.jdField_a_of_type_Qkx.a();
  }
  
  public void a()
  {
    c();
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Int = -100;
    this.jdField_c_of_type_Int = -100;
    this.d = -100;
    this.jdField_c_of_type_Long = -1L;
    this.jdField_a_of_type_JavaUtilList = null;
    this.jdField_a_of_type_Qkv = null;
    this.jdField_a_of_type_Qkx = null;
  }
  
  public void a(int paramInt)
  {
    if (!this.jdField_c_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(rap paramrap, List<?> paramList)
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
  
  public void b(int paramInt)
  {
    if (!this.jdField_c_of_type_Boolean) {
      return;
    }
    long l1 = System.currentTimeMillis();
    label33:
    int i;
    if (this.jdField_b_of_type_Int == -100)
    {
      this.jdField_b_of_type_Int = paramInt;
      this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
      if ((this.jdField_b_of_type_Long != -1L) && (this.jdField_a_of_type_Long - this.jdField_b_of_type_Long <= 500L)) {
        break label311;
      }
      if (this.d != -100) {
        b();
      }
      if (this.jdField_a_of_type_Qkx == null) {
        this.jdField_a_of_type_Qkx = new qkx(this.jdField_a_of_type_Int);
      }
      if (this.jdField_a_of_type_Int != 0) {
        break label313;
      }
      if (this.jdField_c_of_type_Long == -1L) {
        break label326;
      }
      i = a(this.jdField_c_of_type_Long, this.jdField_a_of_type_JavaUtilList);
      if (i == -1) {
        break label326;
      }
      i = paramInt - i;
    }
    for (;;)
    {
      if (i != -1000) {
        this.jdField_a_of_type_Qkx.a(paramInt);
      }
      long l2 = System.currentTimeMillis();
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("VideoBehaviorsReporter", 2, "onVideoPlay(): posi = " + paramInt + ", mCurIndex=" + this.jdField_b_of_type_Int + ", mLastIndex =" + this.jdField_c_of_type_Int + ", mBeforeLastIndex=" + this.d + ", seqIndexDiff = " + i + ", cost= " + (l2 - l1) + " ms");
      return;
      this.jdField_b_of_type_Long = this.jdField_a_of_type_Long;
      this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
      if (this.jdField_c_of_type_Int == -100)
      {
        this.jdField_c_of_type_Int = this.jdField_b_of_type_Int;
        this.jdField_b_of_type_Int = paramInt;
        break label33;
      }
      this.d = this.jdField_c_of_type_Int;
      this.jdField_c_of_type_Int = this.jdField_b_of_type_Int;
      this.jdField_b_of_type_Int = paramInt;
      break label33;
      label311:
      break;
      label313:
      if (this.jdField_a_of_type_Int == 2) {
        i = paramInt;
      } else {
        label326:
        i = -1000;
      }
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qkw
 * JD-Core Version:    0.7.0.1
 */