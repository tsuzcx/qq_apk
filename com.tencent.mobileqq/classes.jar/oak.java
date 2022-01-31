import android.util.SparseArray;
import com.tencent.qphone.base.util.QLog;

public class oak
{
  public SparseArray<oaj> a = new SparseArray();
  
  public oak()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExposureSupplementUtil", 2, "create ExposureSupplementUtilManager");
    }
  }
  
  public oaj a(int paramInt)
  {
    return (oaj)this.a.get(paramInt);
  }
  
  public void a(int paramInt, oaj paramoaj)
  {
    this.a.put(paramInt, paramoaj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oak
 * JD-Core Version:    0.7.0.1
 */