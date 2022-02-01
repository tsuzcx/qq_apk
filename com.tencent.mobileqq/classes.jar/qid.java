import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.CustomMethodsRegister.CustomMethodInterface;
import java.util.HashMap;
import java.util.Map;

public class qid
  implements CustomMethodsRegister.CustomMethodInterface
{
  private Map<String, CustomMethodsRegister.CustomMethodInterface> a = new HashMap();
  
  public qid()
  {
    a();
  }
  
  private void a()
  {
    this.a.put("decodeEmotion", new qif(null));
    this.a.put("HyperLinkClick", new qig(null));
  }
  
  public Object invoke(String paramString, Object... paramVarArgs)
  {
    if (this.a.containsKey(paramString)) {
      return ((CustomMethodsRegister.CustomMethodInterface)this.a.get(paramString)).invoke(paramString, paramVarArgs);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qid
 * JD-Core Version:    0.7.0.1
 */