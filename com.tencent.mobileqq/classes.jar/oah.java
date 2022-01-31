import android.util.SparseArray;
import com.tencent.qphone.base.util.QLog;

public class oah
{
  public SparseArray<oag> a = new SparseArray();
  
  public oah()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExposureSupplementUtil", 2, "create ExposureSupplementUtilManager");
    }
  }
  
  public oag a(int paramInt)
  {
    return (oag)this.a.get(paramInt);
  }
  
  public void a(int paramInt, oag paramoag)
  {
    this.a.put(paramInt, paramoag);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oah
 * JD-Core Version:    0.7.0.1
 */