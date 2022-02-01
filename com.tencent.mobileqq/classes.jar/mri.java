import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVActivity;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class mri
{
  public long a;
  public VideoAppInterface a;
  public WeakReference<mqb> b;
  public final String i = "AVRedBag_" + getClass().getSimpleName() + "_" + this.jdField_a_of_type_Long;
  
  mri(mqb parammqb)
  {
    this.jdField_a_of_type_Long = AudioHelper.b();
    this.b = new WeakReference(parammqb);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = parammqb.a();
  }
  
  public AVActivity a()
  {
    mqb localmqb = (mqb)this.b.get();
    if (localmqb != null) {
      return localmqb.a();
    }
    return null;
  }
  
  public mqb a()
  {
    mqb localmqb = (mqb)this.b.get();
    if (localmqb == null) {
      QLog.d(this.i, 1, "getRedBagMgr[" + getClass().getName() + "] is null");
    }
    return localmqb;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mri
 * JD-Core Version:    0.7.0.1
 */