import com.tencent.biz.pubaccount.readinjoy.view.pullrefresh.ReadInJoySkinAnimManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class mpx
  implements Runnable
{
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  
  public mpx(ReadInJoySkinAnimManager paramReadInJoySkinAnimManager, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramReadInJoySkinAnimManager);
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void run()
  {
    ReadInJoySkinAnimManager localReadInJoySkinAnimManager = (ReadInJoySkinAnimManager)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localReadInJoySkinAnimManager != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoySkinAnimManager", 1, "InitResourceRunnable folder = " + ReadInJoySkinAnimManager.b(localReadInJoySkinAnimManager));
      }
      ReadInJoySkinAnimManager.a(localReadInJoySkinAnimManager, this.jdField_a_of_type_Boolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mpx
 * JD-Core Version:    0.7.0.1
 */