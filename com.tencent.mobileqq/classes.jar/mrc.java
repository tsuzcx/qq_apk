import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVActivity;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class mrc
{
  public long a;
  public VideoAppInterface a;
  public WeakReference<mpv> b;
  public final String i = "AVRedBag_" + getClass().getSimpleName() + "_" + this.jdField_a_of_type_Long;
  
  mrc(mpv parammpv)
  {
    this.jdField_a_of_type_Long = AudioHelper.b();
    this.b = new WeakReference(parammpv);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = parammpv.a();
  }
  
  public AVActivity a()
  {
    mpv localmpv = (mpv)this.b.get();
    if (localmpv != null) {
      return localmpv.a();
    }
    return null;
  }
  
  public mpv a()
  {
    mpv localmpv = (mpv)this.b.get();
    if (localmpv == null) {
      QLog.d(this.i, 1, "getRedBagMgr[" + getClass().getName() + "] is null");
    }
    return localmpv;
  }
  
  protected void finalize()
  {
    QLog.d(this.i, 1, "finalize, " + toString());
    super.finalize();
  }
  
  public String toString()
  {
    return super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mrc
 * JD-Core Version:    0.7.0.1
 */