import android.util.SparseArray;
import com.tencent.qphone.base.util.QLog;

public class opy
{
  public SparseArray<opx> a = new SparseArray();
  
  public opy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExposureSupplementUtil", 2, "create ExposureSupplementUtilManager");
    }
  }
  
  public opx a(int paramInt)
  {
    return (opx)this.a.get(paramInt);
  }
  
  public void a(int paramInt, opx paramopx)
  {
    this.a.put(paramInt, paramopx);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     opy
 * JD-Core Version:    0.7.0.1
 */