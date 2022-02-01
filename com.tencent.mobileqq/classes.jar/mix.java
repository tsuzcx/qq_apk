import android.content.Context;
import com.tencent.av.app.VideoAppInterface;

public class mix
  extends mis
{
  protected mix(Context paramContext, VideoAppInterface paramVideoAppInterface)
  {
    super(paramContext, paramVideoAppInterface);
  }
  
  private void a(mdy parammdy1, mdy parammdy2, int paramInt)
  {
    int i = paramInt >> 1;
    int j = mit.b(paramInt);
    parammdy1.a(0, 0, 0, 0);
    parammdy1.b(i, 0, paramInt, j);
    parammdy1.d(-15197410);
    parammdy2.a(0, 0, 0, 0);
    parammdy2.b(0, 0, i, j);
    parammdy2.d(-15197410);
  }
  
  public int a()
  {
    return 2;
  }
  
  public void a(mdy[] paramArrayOfmdy, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {}
  
  public void a(mdy[] paramArrayOfmdy, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    boolean bool;
    if (!this.a.getCurrentAccountUin().equals(paramArrayOfmdy[1].a(0)))
    {
      bool = true;
      lba.f("ScreenLayoutSmallUIDouble", "layoutCommon: " + paramBoolean + "|" + bool);
      if (!bool) {
        break label112;
      }
      if (paramBoolean) {
        break label94;
      }
      paramBoolean = true;
    }
    label94:
    label112:
    for (;;)
    {
      if (paramBoolean)
      {
        a(paramArrayOfmdy[0], paramArrayOfmdy[1], paramInt1);
        return;
        bool = false;
        break;
        paramBoolean = false;
        continue;
      }
      a(paramArrayOfmdy[1], paramArrayOfmdy[0], paramInt1);
      return;
    }
  }
  
  public boolean a()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mix
 * JD-Core Version:    0.7.0.1
 */