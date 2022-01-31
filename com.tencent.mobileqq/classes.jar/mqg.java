import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVActivity;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class mqg
{
  public long a;
  public VideoAppInterface a;
  public WeakReference<moz> b;
  public final String i = "AVRedBag_" + getClass().getSimpleName() + "_" + this.jdField_a_of_type_Long;
  
  mqg(moz parammoz)
  {
    this.jdField_a_of_type_Long = AudioHelper.b();
    this.b = new WeakReference(parammoz);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = parammoz.a();
  }
  
  public AVActivity a()
  {
    moz localmoz = (moz)this.b.get();
    if (localmoz != null) {
      return localmoz.a();
    }
    return null;
  }
  
  public moz a()
  {
    moz localmoz = (moz)this.b.get();
    if (localmoz == null) {
      QLog.d(this.i, 1, "getRedBagMgr[" + getClass().getName() + "] is null");
    }
    return localmoz;
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
 * Qualified Name:     mqg
 * JD-Core Version:    0.7.0.1
 */