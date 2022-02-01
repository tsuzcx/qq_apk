import android.content.Context;
import com.tencent.avgame.app.AVGameAppInterface;

public class nfz
  extends mdy
{
  private final boolean p;
  private boolean q;
  
  public nfz(Context paramContext, AVGameAppInterface paramAVGameAppInterface, String paramString, long paramLong)
  {
    this(paramContext, paramAVGameAppInterface, paramString, paramLong, true);
  }
  
  public nfz(Context paramContext, AVGameAppInterface paramAVGameAppInterface, String paramString, long paramLong, boolean paramBoolean)
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
  
  protected void b(lqb paramlqb)
  {
    if (this.p) {
      super.b(paramlqb);
    }
  }
  
  protected void d(lqb paramlqb)
  {
    this.q = true;
    super.d(paramlqb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nfz
 * JD-Core Version:    0.7.0.1
 */