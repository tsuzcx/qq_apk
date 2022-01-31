import android.content.Context;
import com.tencent.av.app.VideoAppInterface;

public class lyg
  extends lyf
{
  protected lyg(Context paramContext, VideoAppInterface paramVideoAppInterface)
  {
    super(paramContext, paramVideoAppInterface);
  }
  
  public static int a(int paramInt)
  {
    return (paramInt << 16) / 1201 >> 6;
  }
  
  private void a(ltl paramltl1, ltl paramltl2, int paramInt)
  {
    int i = paramInt >> 1;
    int j = b(paramInt);
    paramltl1.a(0, 0, 0, 0);
    paramltl1.b(0, 0, i, j);
    paramltl1.d(-15197410);
    paramltl2.a(0, 0, 0, 0);
    paramltl2.b(i, 0, paramInt, j);
    paramltl2.d(-15197410);
  }
  
  public static int b(int paramInt)
  {
    return paramInt * 1201 >> 10;
  }
  
  public int a()
  {
    return 2;
  }
  
  public void a(kvq paramkvq, ltl[] paramArrayOfltl, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, int paramInt4) {}
  
  public void a(ltl[] paramArrayOfltl, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {}
  
  public void a(ltl[] paramArrayOfltl, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    boolean bool;
    if (!this.a.getCurrentAccountUin().equals(paramArrayOfltl[1].a(0)))
    {
      bool = true;
      krx.c("ScreenLayoutDoubleScreen", "layoutCommon: " + paramBoolean + "|" + bool);
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
        a(paramArrayOfltl[1], paramArrayOfltl[0], paramInt1);
        return;
        bool = false;
        break;
        paramBoolean = false;
        continue;
      }
      a(paramArrayOfltl[0], paramArrayOfltl[1], paramInt1);
      return;
    }
  }
  
  public boolean a()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lyg
 * JD-Core Version:    0.7.0.1
 */