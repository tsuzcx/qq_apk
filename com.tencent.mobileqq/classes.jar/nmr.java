import android.content.Context;
import com.tencent.avgame.app.AVGameAppInterface;

public class nmr
  extends meu
{
  private final boolean q;
  private boolean r;
  
  public nmr(Context paramContext, AVGameAppInterface paramAVGameAppInterface, String paramString, long paramLong)
  {
    this(paramContext, paramAVGameAppInterface, paramString, paramLong, true);
  }
  
  public nmr(Context paramContext, AVGameAppInterface paramAVGameAppInterface, String paramString, long paramLong, boolean paramBoolean)
  {
    super(paramContext, null, paramString, paramLong, paramBoolean);
    this.q = paramBoolean;
  }
  
  protected boolean a(int paramInt)
  {
    if (h() == 2) {
      return false;
    }
    return super.a(paramInt);
  }
  
  protected void b(lqo paramlqo)
  {
    if (this.q) {
      super.b(paramlqo);
    }
  }
  
  protected void d(lqo paramlqo)
  {
    this.r = true;
    super.d(paramlqo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nmr
 * JD-Core Version:    0.7.0.1
 */