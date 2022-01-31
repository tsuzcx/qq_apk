import android.text.TextUtils;
import com.tencent.av.business.manager.pendant.EffectPendantTips;

public class jgs
  implements Runnable
{
  public jgs(EffectPendantTips paramEffectPendantTips, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    try
    {
      if (this.jdField_a_of_type_Int != 0)
      {
        String str = this.jdField_a_of_type_ComTencentAvBusinessManagerPendantEffectPendantTips.a(EffectPendantTips.a(this.jdField_a_of_type_ComTencentAvBusinessManagerPendantEffectPendantTips), this.jdField_a_of_type_Int);
        if (!TextUtils.isEmpty(str)) {
          this.jdField_a_of_type_ComTencentAvBusinessManagerPendantEffectPendantTips.b(this.b, str);
        }
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jgs
 * JD-Core Version:    0.7.0.1
 */