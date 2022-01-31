import android.text.TextUtils;
import com.tencent.av.business.manager.pendant.EffectPendantTips;

public class jga
  implements Runnable
{
  public jga(EffectPendantTips paramEffectPendantTips, String paramString, int paramInt) {}
  
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
 * Qualified Name:     jga
 * JD-Core Version:    0.7.0.1
 */