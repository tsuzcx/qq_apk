import android.content.Context;
import com.tencent.avgame.app.AVGameAppInterface;

public class nda
  extends mdt
{
  private final boolean p;
  private boolean q;
  
  public nda(Context paramContext, AVGameAppInterface paramAVGameAppInterface, String paramString, long paramLong)
  {
    this(paramContext, paramAVGameAppInterface, paramString, paramLong, true);
  }
  
  public nda(Context paramContext, AVGameAppInterface paramAVGameAppInterface, String paramString, long paramLong, boolean paramBoolean)
  {
    super(paramContext, null, paramString, paramLong, paramBoolean);
    this.p = paramBoolean;
  }
  
  protected boolean a(int paramInt)
  {
    if (h() == 2) {
      return false;
    }
    return super.a(paramInt);
  }
  
  protected void b(lpx paramlpx)
  {
    if (this.p) {
      super.b(paramlpx);
    }
  }
  
  protected void d(lpx paramlpx)
  {
    this.q = true;
    super.d(paramlpx);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     nda
 * JD-Core Version:    0.7.0.1
 */