import com.tencent.pts.nativemodule.IPTSHandleJSException;

public class ppr
  implements IPTSHandleJSException
{
  private final String a = "PTSHandleJSException";
  
  public void handleJSException(int paramInt1, int paramInt2, String paramString)
  {
    pqe.a("0X800A7C6", "", "", "", new pqf().a("type", "1").a("line", "" + paramInt1).a("column", "" + paramInt2).a("msg", paramString).a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ppr
 * JD-Core Version:    0.7.0.1
 */