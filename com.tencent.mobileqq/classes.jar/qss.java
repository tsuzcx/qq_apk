import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.CustomMethodsRegister.CustomMethodInterface;
import com.tencent.mobileqq.text.QQText;

class qss
  implements CustomMethodsRegister.CustomMethodInterface
{
  public Object invoke(String paramString, Object... paramVarArgs)
  {
    String str = "";
    paramString = str;
    if (paramVarArgs != null)
    {
      paramString = str;
      if (paramVarArgs.length >= 1) {
        paramString = bcsc.b(String.valueOf(paramVarArgs[0]));
      }
    }
    return new QQText(paramString, 3, 16);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qss
 * JD-Core Version:    0.7.0.1
 */