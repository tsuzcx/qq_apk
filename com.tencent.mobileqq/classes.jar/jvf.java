import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.QavPanel;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class jvf
  implements Runnable
{
  final int jdField_a_of_type_Int;
  final String jdField_a_of_type_JavaLangString;
  WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  final int jdField_b_of_type_Int;
  final String jdField_b_of_type_JavaLangString;
  WeakReference jdField_b_of_type_JavaLangRefWeakReference;
  
  public jvf(String paramString1, VideoAppInterface paramVideoAppInterface, QavPanel paramQavPanel, String paramString2, int paramInt1, int paramInt2)
  {
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQavPanel);
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramVideoAppInterface);
  }
  
  public void run()
  {
    boolean bool2 = false;
    QavPanel localQavPanel = (QavPanel)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    VideoAppInterface localVideoAppInterface = (VideoAppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get();
    String str = this.jdField_b_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder().append("ShowEffectOperateRunnable, mQavPanel[");
    if (localQavPanel != null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      localStringBuilder = localStringBuilder.append(bool1).append("], mApp[");
      bool1 = bool2;
      if (localVideoAppInterface != null) {
        bool1 = true;
      }
      QLog.w(str, 1, bool1 + "]");
      if ((localQavPanel != null) && (localVideoAppInterface != null)) {
        localQavPanel.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     jvf
 * JD-Core Version:    0.7.0.1
 */