import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVActivity;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class mfk
{
  public long a;
  public VideoAppInterface a;
  public WeakReference<med> b;
  public final String i = "AVRedBag_" + getClass().getSimpleName() + "_" + this.jdField_a_of_type_Long;
  
  mfk(med parammed)
  {
    this.jdField_a_of_type_Long = AudioHelper.b();
    this.b = new WeakReference(parammed);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = parammed.a();
  }
  
  public AVActivity a()
  {
    med localmed = (med)this.b.get();
    if (localmed != null) {
      return localmed.a();
    }
    return null;
  }
  
  public med a()
  {
    med localmed = (med)this.b.get();
    if (localmed == null) {
      QLog.d(this.i, 1, "getRedBagMgr[" + getClass().getName() + "] is null");
    }
    return localmed;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mfk
 * JD-Core Version:    0.7.0.1
 */