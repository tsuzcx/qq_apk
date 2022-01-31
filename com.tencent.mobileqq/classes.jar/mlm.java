import android.content.Context;
import com.tencent.av.app.VideoAppInterface;

public class mlm
  extends mll
{
  protected mlm(Context paramContext, VideoAppInterface paramVideoAppInterface)
  {
    super(paramContext, paramVideoAppInterface);
  }
  
  public static int a(int paramInt)
  {
    return (paramInt << 16) / 1201 >> 6;
  }
  
  private void a(mgp parammgp1, mgp parammgp2, int paramInt)
  {
    int i = paramInt >> 1;
    int j = b(paramInt);
    parammgp1.a(0, 0, 0, 0);
    parammgp1.b(0, 0, i, j);
    parammgp1.d(-15197410);
    parammgp2.a(0, 0, 0, 0);
    parammgp2.b(i, 0, paramInt, j);
    parammgp2.d(-15197410);
  }
  
  public static int b(int paramInt)
  {
    return paramInt * 1201 >> 10;
  }
  
  public int a()
  {
    return 2;
  }
  
  public void a(lid paramlid, mgp[] paramArrayOfmgp, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, int paramInt4) {}
  
  public void a(mgp[] paramArrayOfmgp, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {}
  
  public void a(mgp[] paramArrayOfmgp, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    boolean bool;
    if (!this.a.getCurrentAccountUin().equals(paramArrayOfmgp[1].a(0)))
    {
      bool = true;
      lek.c("ScreenLayoutDoubleScreen", "layoutCommon: " + paramBoolean + "|" + bool);
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
        a(paramArrayOfmgp[1], paramArrayOfmgp[0], paramInt1);
        return;
        bool = false;
        break;
        paramBoolean = false;
        continue;
      }
      a(paramArrayOfmgp[0], paramArrayOfmgp[1], paramInt1);
      return;
    }
  }
  
  public boolean a()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mlm
 * JD-Core Version:    0.7.0.1
 */