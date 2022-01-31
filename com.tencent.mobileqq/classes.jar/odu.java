import android.util.SparseArray;
import com.tencent.qphone.base.util.QLog;

public class odu
{
  public SparseArray<odt> a = new SparseArray();
  
  public odu()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExposureSupplementUtil", 2, "create ExposureSupplementUtilManager");
    }
  }
  
  public odt a(int paramInt)
  {
    return (odt)this.a.get(paramInt);
  }
  
  public void a(int paramInt, odt paramodt)
  {
    this.a.put(paramInt, paramodt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     odu
 * JD-Core Version:    0.7.0.1
 */