import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;

public class ncp
{
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
  
  public static void a(Context paramContext)
  {
    int i2 = 0;
    int i3 = ViewUtils.getScreenWidth();
    int i1 = ViewUtils.getScreenHeight();
    int i4 = ImmersiveUtils.getStatusBarHeight(paramContext);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      a = i4 + ViewUtils.dpToPx(4.0F);
      u = (int)(i3 * 0.2D);
      i4 = i1 - (0 + i3 + ViewUtils.dpToPx(22.0F) + ((i3 - ViewUtils.dpToPx(72.0F)) / 4 + ViewUtils.dpToPx(32.0F)) * 2 + ViewUtils.dpToPx(46.0F));
      k = 0;
      l = i3;
      m = i3;
      d = i3;
      h = 0;
      if (i4 >= -ViewUtils.dpToPx(6.0F)) {
        break label652;
      }
      k = 0;
      l = i4 + l;
      u = (int)(i3 * 0.2D);
    }
    for (;;)
    {
      b = a + paramContext.getResources().getDimensionPixelSize(2131296619);
      c = l;
      if (i2 == 0) {
        c -= b;
      }
      c += b + ViewUtils.dip2px(14.0F);
      g = ViewUtils.dip2px(16.0F);
      i = ViewUtils.dip2px(40.0F);
      e = (i3 - g * 2 - ViewUtils.dip2px(14.0F) * 2) / 3;
      f = (int)(e * 1.428572F);
      j = ViewUtils.dip2px(16.0F);
      n = k + l + ViewUtils.dpToPx(16.0F);
      i2 = ViewUtils.dpToPx(10.0F);
      q = i2;
      p = i2;
      r = ViewUtils.dpToPx(0.0F);
      s = (i3 - q - p - r * 3) / 4;
      t = s + ViewUtils.dpToPx(18.0F);
      o = t * 2 + ViewUtils.dpToPx(20.0F);
      paramContext = new StringBuilder();
      paramContext.append(" viewScreenWidth:").append(i3);
      paramContext.append(" viewScreenHeight:").append(i1);
      paramContext.append(" titleViewMarginTop:").append(a);
      paramContext.append("\n gameListViewChoseTextMarginTop:").append(b);
      paramContext.append("\n gameListGridHeight:").append(f);
      paramContext.append("\n gameListGridWidth:").append(e);
      paramContext.append("\n gameListGridRowMargin:").append(j);
      paramContext.append("\n gameListRootPaddingLR:").append(g);
      paramContext.append("\n gameListRootPaddingTop:").append(h);
      paramContext.append("\n gameListRootPaddingBottom:").append(i);
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
      i1 -= i4;
      v = i4;
      a = ViewUtils.dpToPx(8.0F);
      break;
      label652:
      if (i4 >= a + ViewUtils.dpToPx(48.0F))
      {
        i2 = 1;
        k = a + ViewUtils.dpToPx(48.0F);
        u = k + ViewUtils.dpToPx(20.0F);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ncp
 * JD-Core Version:    0.7.0.1
 */