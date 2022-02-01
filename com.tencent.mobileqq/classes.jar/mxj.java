import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class mxj
  extends ansi
{
  mxj(mxi parammxi) {}
  
  protected void onGetRealNameStatusForAV(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WTogetherRealNameMainProcessHelper", 2, "onGetRealNameStatusForAV authed:=" + paramBoolean);
    }
    mxi.a(this.a, paramBoolean);
    mxi.a(this.a).removeObserver(mxi.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mxj
 * JD-Core Version:    0.7.0.1
 */