import com.tencent.pts.nativemodule.IPTSHandleJSException;

public class qzk
  implements IPTSHandleJSException
{
  public void handleJSException(int paramInt1, int paramInt2, String paramString)
  {
    rag.a("0X800A7C6", "", "", "", new rah().a("type", "1").a("line", "" + paramInt1).a("column", "" + paramInt2).a("msg", paramString).a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qzk
 * JD-Core Version:    0.7.0.1
 */