import android.text.TextUtils;
import com.tencent.av.business.manager.pendant.EffectPendantTips;

public class jgp
  implements Runnable
{
  public jgp(EffectPendantTips paramEffectPendantTips, String paramString, int paramInt) {}
  
  public void run()
  {
    try
    {
      String str = this.jdField_a_of_type_JavaLangString;
      if (!TextUtils.isEmpty(str)) {
        this.jdField_a_of_type_ComTencentAvBusinessManagerPendantEffectPendantTips.b(this.jdField_a_of_type_Int, str);
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
 * Qualified Name:     jgp
 * JD-Core Version:    0.7.0.1
 */