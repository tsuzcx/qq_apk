import android.content.Context;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;

public class nak
{
  public static float a;
  public static int a;
  public static int b;
  public static int c;
  public static int d;
  public static int e;
  public static int f;
  public static int g;
  public static int h;
  public static int i;
  public static int j;
  public static int k;
  public static int l;
  public static int m;
  public static int n;
  public static int o;
  public static int p;
  public static int q;
  public static int r;
  public static int s;
  public static int t;
  public static int u;
  public static int v;
  
  static
  {
    jdField_a_of_type_Float = 1.0F;
  }
  
  public static void a(Context paramContext)
  {
    float f2 = 1.0F;
    int i2 = bgtn.a();
    int i1 = bgtn.b();
    int i3 = ImmersiveUtils.getStatusBarHeight(paramContext);
    float f1;
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      jdField_a_of_type_Int = i3 + bgtn.b(4.0F);
      u = (int)(i2 * 0.2D);
      i3 = i1 - (0 + i2 + bgtn.b(22.0F) + ((i2 - bgtn.b(72.0F)) / 4 + bgtn.b(32.0F)) * 2 + bgtn.b(46.0F));
      k = 0;
      b = 0;
      l = i2;
      m = i2;
      if (i3 >= -bgtn.b(6.0F)) {
        break label784;
      }
      k = 0;
      b = 0;
      f1 = 1.0F * (l + i3) / l;
      l = i3 + l;
      u = (int)(i2 * 0.2D);
      label157:
      c = l + bgtn.b(22.0F);
      f = i2 - bgtn.a(115.0F);
      f = Math.max(Math.min(bgtn.b(260.0F), f), bgtn.b(220.0F));
      f = Math.round(f * f1);
      h = Math.round(f * 666.0F / 520.0F);
      d = (i2 - f) / 2;
      e = bgtn.b(115.0F) * h / bgtn.b(333.0F);
      i = Math.max((f - bgtn.b(170.0F)) / 2, bgtn.b(24.0F));
      j = bgtn.b(f * 40 / bgtn.b(260.0F));
      jdField_a_of_type_Float = f1;
      g = f - i * 2;
      n = k + l + bgtn.b(15.0F);
      i3 = bgtn.b(9.0F);
      q = i3;
      p = i3;
      r = bgtn.b(8.0F);
      s = (i2 - q - p - r * 3) / 4;
      t = s + bgtn.b(18.0F);
      o = t * 2 + bgtn.b(20.0F);
      i3 = i1 - n - o - bgtn.b(46.0F);
      if (i3 <= bgtn.b(64.0F)) {
        break label838;
      }
      n += bgtn.b(24.0F);
    }
    for (;;)
    {
      paramContext = new StringBuilder();
      paramContext.append(" viewScreenWidth:").append(i2);
      paramContext.append(" viewScreenHeight:").append(i1);
      paramContext.append(" titleViewMarginTop:").append(jdField_a_of_type_Int);
      paramContext.append("\n gameListViewMarginTop:").append(b);
      paramContext.append("\n gameListViewHeight:").append(c);
      paramContext.append("\n gameListItemNameMarginTop:").append(e);
      paramContext.append("\n gameListItemWidth:").append(f);
      paramContext.append("\n gameListItemHeight:").append(h);
      paramContext.append("\n gameListItemPaddingH:").append(i);
      paramContext.append("\n gameListItemPaddingBottom:").append(j);
      paramContext.append("\n gameListItemScale:").append(jdField_a_of_type_Float);
      paramContext.append("\n stageViewMarginTop:").append(k);
      paramContext.append("\n stageViewHeight:").append(l);
      paramContext.append("\n stageViewWidth:").append(m);
      paramContext.append("\n seatViewMarginTop:").append(n);
      paramContext.append("\n seatViewHeight:").append(o);
      paramContext.append("\n seatViewPaddingLeft:").append(p);
      paramContext.append("\n seatViewPaddingRight:").append(q);
      paramContext.append("\n seatViewMemberItemGapH:").append(r);
      paramContext.append("\n seatViewPaddingRight:").append(q);
      paramContext.append("\n seatViewMemberItemWidth:").append(s);
      paramContext.append("\n seatViewMemberItemHeight:").append(t);
      QLog.i("GameRoomViewLayoutParamsDef", 2, "calculateViewsLocSize : " + paramContext.toString());
      return;
      i1 -= i3;
      v = i3;
      jdField_a_of_type_Int = bgtn.b(8.0F);
      break;
      label784:
      f1 = f2;
      if (i3 < jdField_a_of_type_Int + bgtn.b(48.0F)) {
        break label157;
      }
      i3 = jdField_a_of_type_Int + bgtn.b(48.0F);
      k = i3;
      b = i3;
      u = k + bgtn.b(20.0F);
      f1 = f2;
      break label157;
      label838:
      if (i3 > bgtn.b(48.0F)) {
        n += bgtn.b(16.0F);
      }
    }
  }
  
  public static void a(View paramView)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    v = arrayOfInt[1];
  }
  
  public static void a(View paramView, int[] paramArrayOfInt)
  {
    paramView.getLocationInWindow(paramArrayOfInt);
    if (v > 0) {
      paramArrayOfInt[1] -= v;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     nak
 * JD-Core Version:    0.7.0.1
 */