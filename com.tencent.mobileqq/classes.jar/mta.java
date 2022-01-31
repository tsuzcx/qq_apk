import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVActivity;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class mta
{
  public long a;
  public VideoAppInterface a;
  public WeakReference<mrt> b;
  public final String i = "AVRedBag_" + getClass().getSimpleName() + "_" + this.jdField_a_of_type_Long;
  
  mta(mrt parammrt)
  {
    this.jdField_a_of_type_Long = AudioHelper.b();
    this.b = new WeakReference(parammrt);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = parammrt.a();
  }
  
  public AVActivity a()
  {
    mrt localmrt = (mrt)this.b.get();
    if (localmrt != null) {
      return localmrt.a();
    }
    return null;
  }
  
  public mrt a()
  {
    mrt localmrt = (mrt)this.b.get();
    if (localmrt == null) {
      QLog.d(this.i, 1, "getRedBagMgr[" + getClass().getName() + "] is null");
    }
    return localmrt;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mta
 * JD-Core Version:    0.7.0.1
 */