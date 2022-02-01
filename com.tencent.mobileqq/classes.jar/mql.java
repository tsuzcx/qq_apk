import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVActivity;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class mql
{
  public long a;
  public VideoAppInterface a;
  public WeakReference<mpe> b;
  public final String i = "AVRedBag_" + getClass().getSimpleName() + "_" + this.jdField_a_of_type_Long;
  
  mql(mpe parammpe)
  {
    this.jdField_a_of_type_Long = AudioHelper.b();
    this.b = new WeakReference(parammpe);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = parammpe.a();
  }
  
  public AVActivity a()
  {
    mpe localmpe = (mpe)this.b.get();
    if (localmpe != null) {
      return localmpe.a();
    }
    return null;
  }
  
  public mpe a()
  {
    mpe localmpe = (mpe)this.b.get();
    if (localmpe == null) {
      QLog.d(this.i, 1, "getRedBagMgr[" + getClass().getName() + "] is null");
    }
    return localmpe;
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
 * Qualified Name:     mql
 * JD-Core Version:    0.7.0.1
 */