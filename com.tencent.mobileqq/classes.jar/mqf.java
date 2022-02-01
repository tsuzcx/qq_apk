import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVActivity;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class mqf
{
  public long a;
  public VideoAppInterface a;
  public WeakReference<moy> b;
  public final String i = "AVRedBag_" + getClass().getSimpleName() + "_" + this.jdField_a_of_type_Long;
  
  mqf(moy parammoy)
  {
    this.jdField_a_of_type_Long = AudioHelper.b();
    this.b = new WeakReference(parammoy);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = parammoy.a();
  }
  
  public AVActivity a()
  {
    moy localmoy = (moy)this.b.get();
    if (localmoy != null) {
      return localmoy.a();
    }
    return null;
  }
  
  public moy a()
  {
    moy localmoy = (moy)this.b.get();
    if (localmoy == null) {
      QLog.d(this.i, 1, "getRedBagMgr[" + getClass().getName() + "] is null");
    }
    return localmoy;
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
 * Qualified Name:     mqf
 * JD-Core Version:    0.7.0.1
 */