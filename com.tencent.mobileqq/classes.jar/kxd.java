import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

public class kxd
  extends kwt
  implements Observer
{
  private volatile HashMap<Integer, kxe> a;
  
  protected kxd(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  protected void a()
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this);
  }
  
  public void a(int paramInt, kxe paramkxe)
  {
    if (paramkxe == null) {}
    do
    {
      return;
      if (QLog.isDevelopLevel()) {
        QLog.w("EffectMutexManager", 1, "RegistMutexItem, key[" + paramInt + "]");
      }
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt))) {
        break;
      }
    } while (paramkxe == (kxe)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt)));
    this.jdField_a_of_type_JavaUtilHashMap.remove(Integer.valueOf(paramInt));
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), paramkxe);
  }
  
  protected boolean a(String paramString)
  {
    return false;
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    paramObservable = ((Object[])(Object[])paramObject)[0];
    if (!(paramObservable instanceof Integer)) {}
    for (;;)
    {
      return;
      int i = ((Integer)paramObservable).intValue();
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(i)))
      {
        if (QLog.isDevelopLevel()) {
          QLog.w("EffectMutexManager", 1, "update, msgType[" + i + "]");
        }
        paramObservable = (kxe)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(i));
        paramObject = this.jdField_a_of_type_JavaUtilHashMap.values().iterator();
        while (paramObject.hasNext())
        {
          kxe localkxe = (kxe)paramObject.next();
          if (localkxe != paramObservable) {
            localkxe.b();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     kxd
 * JD-Core Version:    0.7.0.1
 */