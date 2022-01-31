import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.qphone.base.util.QLog;

class lfr
  implements AsyncBack
{
  lfr(lfq paramlfq) {}
  
  public void loaded(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyNewFeedsActivity", 2, "load 2378 html web resource finish");
    }
  }
  
  public void progress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lfr
 * JD-Core Version:    0.7.0.1
 */