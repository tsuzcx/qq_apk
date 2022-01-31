import android.util.SparseArray;
import com.tencent.qphone.base.util.QLog;

public class noz
{
  public SparseArray<noy> a = new SparseArray();
  
  public noz()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExposureSupplementUtil", 2, "create ExposureSupplementUtilManager");
    }
  }
  
  public noy a(int paramInt)
  {
    return (noy)this.a.get(paramInt);
  }
  
  public void a(int paramInt, noy paramnoy)
  {
    this.a.put(paramInt, paramnoy);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     noz
 * JD-Core Version:    0.7.0.1
 */