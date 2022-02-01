import android.content.Context;
import com.tencent.avgame.app.AVGameAppInterface;

public class nes
  extends mep
{
  private final boolean p;
  private boolean q;
  
  public nes(Context paramContext, AVGameAppInterface paramAVGameAppInterface, String paramString, long paramLong)
  {
    this(paramContext, paramAVGameAppInterface, paramString, paramLong, true);
  }
  
  public nes(Context paramContext, AVGameAppInterface paramAVGameAppInterface, String paramString, long paramLong, boolean paramBoolean)
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
  
  protected void b(lqt paramlqt)
  {
    if (this.p) {
      super.b(paramlqt);
    }
  }
  
  protected void d(lqt paramlqt)
  {
    this.q = true;
    super.d(paramlqt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     nes
 * JD-Core Version:    0.7.0.1
 */