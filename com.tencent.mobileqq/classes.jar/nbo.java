import android.content.Context;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;

public class nbo
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
  public static int w;
  public static int x;
  public static int y;
  public static int z;
  
  static
  {
    jdField_a_of_type_Float = 1.0F;
  }
  
  public static void a(Context paramContext)
  {
    float f2 = 1.0F;
    int i2 = 0;
    int i3 = bhtq.a();
    int i1 = bhtq.b();
    int i4 = ImmersiveUtils.getStatusBarHeight(paramContext);
    float f1;
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      jdField_a_of_type_Int = i4 + bhtq.b(4.0F);
      y = (int)(i3 * 0.2D);
      i4 = i1 - (0 + i3 + bhtq.b(22.0F) + ((i3 - bhtq.b(72.0F)) / 4 + bhtq.b(32.0F)) * 2 + bhtq.b(46.0F));
      o = 0;
      p = i3;
      q = i3;
      l = 0;
      if (i4 >= -bhtq.b(6.0F)) {
        break label824;
      }
      o = 0;
      f1 = 1.0F * (p + i4) / p;
      p = i4 + p;
      y = (int)(i3 * 0.2D);
      label156:
      b = jdField_a_of_type_Int + bhtq.b(48.0F);
      c = p + bhtq.b(22.0F);
      if (i2 == 0) {
        c -= b;
      }
      d = i3 - bhtq.a(115.0F);
      d = Math.max(Math.min(bhtq.b(260.0F), d), bhtq.b(220.0F));
      d = Math.round(d * f1);
      f = Math.round(d * 666.0F / 520.0F);
      g = Math.max((d - bhtq.b(170.0F)) / 2, bhtq.b(24.0F));
      h = bhtq.b(d * 40 / bhtq.b(260.0F));
      jdField_a_of_type_Float = f1;
      e = d - g * 2;
      k = bhtq.a(16.0F);
      m = bhtq.a(40.0F);
      i = (i3 - k * 2 - bhtq.a(14.0F) * 2) / 3;
      j = (int)(i * 1.428572F);
      n = bhtq.a(16.0F);
      r = o + p + bhtq.b(15.0F);
      i2 = bhtq.b(9.0F);
      u = i2;
      t = i2;
      v = bhtq.b(8.0F);
      w = (i3 - u - t - v * 3) / 4;
      x = w + bhtq.b(18.0F);
      s = x * 2 + bhtq.b(20.0F);
      i2 = i1 - r - s - bhtq.b(46.0F);
      if (i2 <= bhtq.b(64.0F)) {
        break label872;
      }
      r += bhtq.b(24.0F);
    }
    for (;;)
    {
      paramContext = new StringBuilder();
      paramContext.append(" viewScreenWidth:").append(i3);
      paramContext.append(" viewScreenHeight:").append(i1);
      paramContext.append(" titleViewMarginTop:").append(jdField_a_of_type_Int);
      paramContext.append("\n gameListViewMarginTop:").append(b);
      paramContext.append("\n gameListGridHeight:").append(j);
      paramContext.append("\n gameListGridWidth:").append(i);
      paramContext.append("\n gameListGridRowMargin:").append(n);
      paramContext.append("\n gameListRootPaddingLR:").append(k);
      paramContext.append("\n gameListRootPaddingTop:").append(l);
      paramContext.append("\n gameListRootPaddingBottom:").append(m);
      paramContext.append("\n stageViewMarginTop:").append(o);
      paramContext.append("\n stageViewHeight:").append(p);
      paramContext.append("\n stageViewWidth:").append(q);
      paramContext.append("\n seatViewMarginTop:").append(r);
      paramContext.append("\n seatViewHeight:").append(s);
      paramContext.append("\n seatViewPaddingLeft:").append(t);
      paramContext.append("\n seatViewPaddingRight:").append(u);
      paramContext.append("\n seatViewMemberItemGapH:").append(v);
      paramContext.append("\n seatViewPaddingRight:").append(u);
      paramContext.append("\n seatViewMemberItemWidth:").append(w);
      paramContext.append("\n seatViewMemberItemHeight:").append(x);
      QLog.i("GameRoomViewLayoutParamsDef", 2, "calculateViewsLocSize : " + paramContext.toString());
      return;
      i1 -= i4;
      z = i4;
      jdField_a_of_type_Int = bhtq.b(8.0F);
      break;
      label824:
      f1 = f2;
      if (i4 < jdField_a_of_type_Int + bhtq.b(48.0F)) {
        break label156;
      }
      i2 = 1;
      o = jdField_a_of_type_Int + bhtq.b(48.0F);
      y = o + bhtq.b(20.0F);
      f1 = f2;
      break label156;
      label872:
      if (i2 > bhtq.b(48.0F)) {
        r += bhtq.b(16.0F);
      }
    }
  }
  
  public static void a(View paramView)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    z = arrayOfInt[1];
  }
  
  public static void a(View paramView, int[] paramArrayOfInt)
  {
    paramView.getLocationInWindow(paramArrayOfInt);
    if (z > 0) {
      paramArrayOfInt[1] -= z;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     nbo
 * JD-Core Version:    0.7.0.1
 */