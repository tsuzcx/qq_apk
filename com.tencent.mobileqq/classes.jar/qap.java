import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.CustomMethodsRegister.CustomMethodInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

public class qap
  implements CustomMethodsRegister.CustomMethodInterface
{
  private Map<String, CustomMethodsRegister.CustomMethodInterface> a = new HashMap();
  
  public qap()
  {
    a();
  }
  
  private void a()
  {
    a("decodeEmotion", new qar(null));
    a("HyperLinkClick", new qas(null));
  }
  
  public void a(String paramString, CustomMethodsRegister.CustomMethodInterface paramCustomMethodInterface)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramCustomMethodInterface == null)) {
      return;
    }
    this.a.put(paramString, paramCustomMethodInterface);
  }
  
  public Object invoke(String paramString, Object... paramVarArgs)
  {
    QLog.d("RIJProteusMethod", 1, "invoke,s=" + paramString);
    if (this.a.containsKey(paramString)) {
      return ((CustomMethodsRegister.CustomMethodInterface)this.a.get(paramString)).invoke(paramString, paramVarArgs);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qap
 * JD-Core Version:    0.7.0.1
 */