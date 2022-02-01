import android.os.Handler;
import com.tencent.qphone.base.util.QLog;

class osc
  extends rux
{
  osc(osb paramosb) {}
  
  public void a(sfb paramsfb)
  {
    super.a(paramsfb);
    QLog.d("KandianAdPandent", 2, "onCompletion");
    osb.a(this.a).sendEmptyMessage(2);
  }
  
  public void a(sfb paramsfb, Object paramObject)
  {
    QLog.d("KandianAdPandent", 2, "onVideoPrepared");
    osb.a(this.a).d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     osc
 * JD-Core Version:    0.7.0.1
 */