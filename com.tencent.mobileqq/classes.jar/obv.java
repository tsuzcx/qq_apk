import android.content.Context;
import android.content.IntentFilter;
import java.util.concurrent.atomic.AtomicBoolean;

public class obv
{
  private Context jdField_a_of_type_AndroidContentContext;
  private IntentFilter jdField_a_of_type_AndroidContentIntentFilter;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private obw jdField_a_of_type_Obw;
  private obx jdField_a_of_type_Obx;
  
  public obv(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidContentIntentFilter = new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS");
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Obw != null) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true))) {
      this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_Obw, this.jdField_a_of_type_AndroidContentIntentFilter);
    }
  }
  
  public void a(obx paramobx)
  {
    this.jdField_a_of_type_Obx = paramobx;
    this.jdField_a_of_type_Obw = new obw(this);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Obw != null) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(true, false))) {
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_Obw);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     obv
 * JD-Core Version:    0.7.0.1
 */