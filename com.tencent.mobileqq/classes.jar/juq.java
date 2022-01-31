import com.tencent.av.business.manager.pendant.EffectPendantTools;
import com.tencent.av.ui.EffectToolbar;
import com.tencent.qphone.base.util.QLog;

public class juq
  implements Runnable
{
  public juq(EffectToolbar paramEffectToolbar, String paramString) {}
  
  public void run()
  {
    if (EffectToolbar.access$200(this.jdField_a_of_type_ComTencentAvUiEffectToolbar) != null)
    {
      QLog.w("EffectToolbar", 1, "postSetCurrentItemById, id[" + this.jdField_a_of_type_JavaLangString + "]");
      EffectToolbar.access$200(this.jdField_a_of_type_ComTencentAvUiEffectToolbar).b(this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     juq
 * JD-Core Version:    0.7.0.1
 */