import com.tencent.pts.nativemodule.IPTSHandleJSException;

public class pwi
  implements IPTSHandleJSException
{
  private final String a = "PTSHandleJSException";
  
  public void handleJSException(int paramInt1, int paramInt2, String paramString)
  {
    pwx.a("0X800A7C6", "", "", "", new pwy().a("type", "1").a("line", "" + paramInt1).a("column", "" + paramInt2).a("msg", paramString).a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pwi
 * JD-Core Version:    0.7.0.1
 */