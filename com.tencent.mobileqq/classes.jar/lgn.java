import android.util.SparseArray;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.EffectMutexManager.1;
import com.tencent.qphone.base.util.QLog;

public class lgn
  extends lgd
{
  private volatile SparseArray<lgo> a;
  
  protected lgn(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  }
  
  protected void a() {}
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.w("EffectMutexManager", 1, "notifyMutex, fromMuteKey[" + paramInt + "], data[" + paramString + "]");
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.runOnUiThread(new EffectMutexManager.1(this, paramInt, paramString));
  }
  
  public void a(int paramInt, lgo paramlgo)
  {
    if (paramlgo == null) {
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.w("EffectMutexManager", 1, "registerMutexItem, key[" + paramInt + "]");
    }
    this.jdField_a_of_type_AndroidUtilSparseArray.remove(paramInt);
    this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, paramlgo);
  }
  
  protected boolean a(String paramString)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lgn
 * JD-Core Version:    0.7.0.1
 */