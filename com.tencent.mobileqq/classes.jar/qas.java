import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.CustomMethodsRegister.CustomMethodInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class qas
  implements CustomMethodsRegister.CustomMethodInterface
{
  public Object invoke(String paramString, Object... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length >= 1))
    {
      paramVarArgs = paramVarArgs[0];
      QLog.d("RIJProteusMethod", 1, "MethodHyperLink invoke,s=" + paramString + " firstObject=" + paramVarArgs);
      if (String.valueOf(paramVarArgs).startsWith("more-")) {
        pfd.a().a(String.valueOf(paramVarArgs));
      }
    }
    else
    {
      return null;
    }
    ozs.d(BaseApplication.getContext(), String.valueOf(paramVarArgs));
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qas
 * JD-Core Version:    0.7.0.1
 */