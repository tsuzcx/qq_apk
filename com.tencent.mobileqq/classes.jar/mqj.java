import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVActivity;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class mqj
{
  public long a;
  public VideoAppInterface a;
  public WeakReference<mpc> b;
  public final String i = "AVRedBag_" + getClass().getSimpleName() + "_" + this.jdField_a_of_type_Long;
  
  mqj(mpc parammpc)
  {
    this.jdField_a_of_type_Long = AudioHelper.b();
    this.b = new WeakReference(parammpc);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = parammpc.a();
  }
  
  public AVActivity a()
  {
    mpc localmpc = (mpc)this.b.get();
    if (localmpc != null) {
      return localmpc.a();
    }
    return null;
  }
  
  public mpc a()
  {
    mpc localmpc = (mpc)this.b.get();
    if (localmpc == null) {
      QLog.d(this.i, 1, "getRedBagMgr[" + getClass().getName() + "] is null");
    }
    return localmpc;
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
 * Qualified Name:     mqj
 * JD-Core Version:    0.7.0.1
 */