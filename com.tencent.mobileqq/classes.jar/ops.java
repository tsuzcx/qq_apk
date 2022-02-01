import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils.TruncateAt;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoInfo;

public class ops
{
  public static TextView a(Context paramContext, VideoInfo paramVideoInfo, String paramString)
  {
    if ((paramVideoInfo == null) || (paramVideoInfo.a == null)) {
      return null;
    }
    int i = opr.a(paramVideoInfo.a);
    paramVideoInfo = new LinearLayout.LayoutParams(-2, -2);
    paramVideoInfo.rightMargin = afur.a(6.0F, paramContext.getResources());
    paramContext = new TextView(paramContext);
    paramContext.setIncludeFontPadding(false);
    if (i == 3)
    {
      paramContext.setBackgroundResource(2130849311);
      paramContext.setTextColor(Color.parseColor("#757575"));
      paramContext.setTextSize(11.0F);
    }
    for (;;)
    {
      paramContext.setMaxLines(1);
      paramContext.setEllipsize(TextUtils.TruncateAt.END);
      paramContext.setGravity(17);
      paramContext.setText(paramString);
      paramContext.setLayoutParams(paramVideoInfo);
      return paramContext;
      paramContext.setBackgroundResource(2130849309);
      paramContext.setTextSize(10.0F);
      paramContext.setTextColor(Color.parseColor("#737373"));
    }
  }
  
  public static void a(rxl paramrxl)
  {
    if ((paramrxl == null) || (paramrxl.c == null)) {}
    Context localContext;
    do
    {
      boolean bool1;
      do
      {
        return;
        boolean bool2 = false;
        bool1 = bool2;
        if (paramrxl.a != null)
        {
          bool1 = bool2;
          if (paramrxl.a.a != null) {
            bool1 = oqj.a(paramrxl.a.a);
          }
        }
      } while (!bool1);
      localContext = paramrxl.c.getContext();
    } while (localContext == null);
    Object localObject = (RelativeLayout.LayoutParams)paramrxl.e.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = afur.a(245.0F, localContext.getResources());
    ((RelativeLayout.LayoutParams)localObject).height = afur.a(48.0F, localContext.getResources());
    ((RelativeLayout.LayoutParams)localObject).bottomMargin = afur.a(65.0F, localContext.getResources());
    paramrxl.e.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = new GradientDrawable();
    ((GradientDrawable)localObject).setColor(Color.parseColor("#7F4D4D4D"));
    ((GradientDrawable)localObject).setCornerRadius(afur.a(6.0F, localContext.getResources()));
    paramrxl.e.setBackgroundDrawable((Drawable)localObject);
    localObject = new GradientDrawable();
    ((GradientDrawable)localObject).setColor(Color.parseColor("#12B7F5"));
    ((GradientDrawable)localObject).setCornerRadius(afur.a(19.0F, localContext.getResources()));
    paramrxl.k.setBackgroundDrawable((Drawable)localObject);
    localObject = (RelativeLayout.LayoutParams)paramrxl.f.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = afur.a(40.0F, localContext.getResources());
    ((RelativeLayout.LayoutParams)localObject).height = afur.a(40.0F, localContext.getResources());
    ((RelativeLayout.LayoutParams)localObject).leftMargin = afur.a(4.0F, localContext.getResources());
    paramrxl.f.setLayoutParams((ViewGroup.LayoutParams)localObject);
    paramrxl.p.setTextSize(14.0F);
    localObject = (RelativeLayout.LayoutParams)paramrxl.p.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).leftMargin = afur.a(10.0F, localContext.getResources());
    paramrxl.p.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (RelativeLayout.LayoutParams)paramrxl.q.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).rightMargin = afur.a(25.0F, localContext.getResources());
    paramrxl.q.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (LinearLayout.LayoutParams)paramrxl.d.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).leftMargin = afur.a(10.0F, localContext.getResources());
    paramrxl.d.setLayoutParams((ViewGroup.LayoutParams)localObject);
    paramrxl.q.setTextSize(14.0F);
    paramrxl.q.setTypeface(Typeface.DEFAULT);
    paramrxl.m.setTypeface(Typeface.DEFAULT);
    paramrxl.o.setTypeface(Typeface.DEFAULT);
    paramrxl.n.setTextColor(Color.parseColor("#FFFFFF"));
    paramrxl.n.setTextSize(11.0F);
    localObject = new GradientDrawable();
    ((GradientDrawable)localObject).setColor(Color.parseColor("#FF6522"));
    ((GradientDrawable)localObject).setCornerRadius(afur.a(3.0F, localContext.getResources()));
    paramrxl.n.setBackgroundDrawable((Drawable)localObject);
    localObject = (RelativeLayout.LayoutParams)paramrxl.b.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).bottomMargin = afur.a(50.0F, localContext.getResources());
    paramrxl.b.setLayoutParams((ViewGroup.LayoutParams)localObject);
    paramrxl.k.setTypeface(Typeface.DEFAULT_BOLD);
  }
  
  public static void b(rxl paramrxl)
  {
    if ((paramrxl == null) || (paramrxl.e == null)) {}
    Context localContext;
    do
    {
      boolean bool1;
      do
      {
        return;
        boolean bool2 = false;
        bool1 = bool2;
        if (paramrxl.a != null)
        {
          bool1 = bool2;
          if (paramrxl.a.a != null) {
            bool1 = oqj.a(paramrxl.a.a);
          }
        }
      } while (!bool1);
      localContext = paramrxl.e.getContext();
    } while (localContext == null);
    Object localObject = (RelativeLayout.LayoutParams)paramrxl.e.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).height = afur.a(31.0F, localContext.getResources());
    ((RelativeLayout.LayoutParams)localObject).bottomMargin = afur.a(10.0F, localContext.getResources());
    paramrxl.e.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = new GradientDrawable();
    ((GradientDrawable)localObject).setColor(Color.parseColor("#33FFFFFF"));
    ((GradientDrawable)localObject).setCornerRadius(afur.a(6.0F, localContext.getResources()));
    paramrxl.e.setBackgroundDrawable((Drawable)localObject);
    localObject = new GradientDrawable();
    ((GradientDrawable)localObject).setColor(Color.parseColor("#12B7F5"));
    ((GradientDrawable)localObject).setCornerRadius(afur.a(6.0F, localContext.getResources()));
    paramrxl.k.setBackgroundDrawable((Drawable)localObject);
    localObject = (RelativeLayout.LayoutParams)paramrxl.f.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = afur.a(31.0F, localContext.getResources());
    ((RelativeLayout.LayoutParams)localObject).height = afur.a(31.0F, localContext.getResources());
    ((RelativeLayout.LayoutParams)localObject).leftMargin = afur.a(0.0F, localContext.getResources());
    paramrxl.f.setLayoutParams((ViewGroup.LayoutParams)localObject);
    paramrxl.p.setTextSize(16.0F);
    paramrxl.q.setTextSize(14.0F);
    paramrxl.q.setTypeface(Typeface.DEFAULT);
    paramrxl.m.setTypeface(Typeface.DEFAULT_BOLD);
    localObject = (RelativeLayout.LayoutParams)paramrxl.b.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).bottomMargin = afur.a(0.0F, localContext.getResources());
    paramrxl.b.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ops
 * JD-Core Version:    0.7.0.1
 */