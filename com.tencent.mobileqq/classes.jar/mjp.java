import android.content.Context;
import com.tencent.av.app.VideoAppInterface;

public class mjp
  extends mjo
{
  protected mjp(Context paramContext, VideoAppInterface paramVideoAppInterface)
  {
    super(paramContext, paramVideoAppInterface);
  }
  
  public static int a(int paramInt)
  {
    return (paramInt << 16) / 1201 >> 6;
  }
  
  private void a(meu parammeu1, meu parammeu2, int paramInt)
  {
    int i = paramInt >> 1;
    int j = b(paramInt);
    parammeu1.a(0, 0, 0, 0);
    parammeu1.b(0, 0, i, j);
    parammeu1.d(-15197410);
    parammeu2.a(0, 0, 0, 0);
    parammeu2.b(i, 0, paramInt, j);
    parammeu2.d(-15197410);
  }
  
  public static int b(int paramInt)
  {
    return paramInt * 1201 >> 10;
  }
  
  public int a()
  {
    return 2;
  }
  
  public void a(lfe paramlfe, meu[] paramArrayOfmeu, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, int paramInt4) {}
  
  public void a(meu[] paramArrayOfmeu, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {}
  
  public void a(meu[] paramArrayOfmeu, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    boolean bool;
    if (!this.a.getCurrentAccountUin().equals(paramArrayOfmeu[1].a(0)))
    {
      bool = true;
      lbd.f("ScreenLayoutDoubleScreen", "layoutCommon: " + paramBoolean + "|" + bool);
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
        a(paramArrayOfmeu[1], paramArrayOfmeu[0], paramInt1);
        return;
        bool = false;
        break;
        paramBoolean = false;
        continue;
      }
      a(paramArrayOfmeu[0], paramArrayOfmeu[1], paramInt1);
      return;
    }
  }
  
  public boolean b()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mjp
 * JD-Core Version:    0.7.0.1
 */