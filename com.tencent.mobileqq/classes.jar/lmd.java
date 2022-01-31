import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.av.doodle.DoodleSurfaceView;

public class lmd
{
  public static boolean a;
  
  public static int a(int paramInt1, int paramInt2, float paramFloat)
  {
    return Math.round((paramInt2 - paramInt1) * paramFloat) + paramInt1;
  }
  
  public static int a(int[] paramArrayOfInt, float paramFloat)
  {
    if (paramFloat <= 0.0F) {
      return paramArrayOfInt[0];
    }
    if (paramFloat >= 1.0F) {
      return paramArrayOfInt[(paramArrayOfInt.length - 1)];
    }
    paramFloat = (paramArrayOfInt.length - 1) * paramFloat;
    int j = (int)paramFloat;
    paramFloat -= j;
    int i = paramArrayOfInt[j];
    j = paramArrayOfInt[(j + 1)];
    return Color.argb(a(Color.alpha(i), Color.alpha(j), paramFloat), a(Color.red(i), Color.red(j), paramFloat), a(Color.green(i), Color.green(j), paramFloat), a(Color.blue(i), Color.blue(j), paramFloat));
  }
  
  public static DoodleSurfaceView a(ViewGroup paramViewGroup)
  {
    Object localObject2 = (DoodleSurfaceView)paramViewGroup.findViewById(2131372242);
    Object localObject1 = localObject2;
    View localView;
    if (localObject2 == null)
    {
      localObject1 = new DoodleSurfaceView(paramViewGroup.getContext());
      localObject2 = new ViewGroup.LayoutParams(-1, -1);
      localView = paramViewGroup.findViewById(2131372534);
      if (localView == null) {
        break label67;
      }
    }
    label67:
    for (int i = paramViewGroup.indexOfChild(localView);; i = -1)
    {
      paramViewGroup.addView((View)localObject1, i, (ViewGroup.LayoutParams)localObject2);
      return localObject1;
    }
  }
  
  public static lly a(int paramInt)
  {
    Object localObject;
    switch (paramInt)
    {
    case 2: 
    default: 
      localObject = new lme();
    }
    for (;;)
    {
      ((lly)localObject).a = paramInt;
      return localObject;
      localObject = new lme();
      continue;
      localObject = new lmj(2130968654);
    }
  }
  
  public static void a(ViewGroup paramViewGroup)
  {
    View localView = paramViewGroup.findViewById(2131372242);
    if (localView != null) {
      paramViewGroup.removeView(localView);
    }
  }
  
  public static void a(String paramString)
  {
    axqy.b(null, "CliOper", "", "", paramString, paramString, 0, 0, "", "", "", "");
  }
  
  public static boolean a()
  {
    if (a) {
      return true;
    }
    if (!b()) {
      return false;
    }
    a = true;
    return a;
  }
  
  public static boolean b()
  {
    int i = llw.e();
    if (i < 4)
    {
      lcg.c("DoodleUtils", "isSupportOfDevice error cpucount = " + i);
      return false;
    }
    long l = llw.c();
    if (l < 1400000L)
    {
      lcg.c("DoodleUtils", "isSupportOfDevice error cpuFrequency = " + l);
      return false;
    }
    l = bbdh.d();
    if (l < 1073741824L)
    {
      lcg.c("DoodleUtils", "isSupportOfDevice error memory = " + l);
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lmd
 * JD-Core Version:    0.7.0.1
 */