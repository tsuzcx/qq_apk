import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.ad.utils.AdVideoButtonUIUtils.1;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class opr
{
  public static int a(VideoAdInfo paramVideoAdInfo)
  {
    if (paramVideoAdInfo == null) {}
    do
    {
      return 1;
      if (oqi.c(paramVideoAdInfo)) {
        return 2;
      }
    } while (!oqi.a());
    return 3;
  }
  
  public static void a(Context paramContext, rxl paramrxl)
  {
    VideoInfo localVideoInfo;
    if ((paramrxl != null) && (paramrxl.jdField_a_of_type_Sar != null) && (paramrxl.jdField_a_of_type_Sar.a != null))
    {
      localVideoInfo = paramrxl.jdField_a_of_type_Sar.a;
      if (!oqj.a(localVideoInfo)) {
        break label87;
      }
      paramrxl.q.setText(oqj.a(paramContext, localVideoInfo, 1));
      paramrxl.k.setText(oqj.a(paramContext, localVideoInfo, 2));
    }
    for (;;)
    {
      paramrxl.q.setTag(paramrxl);
      paramrxl.d.setTag(paramrxl);
      paramrxl.k.setTag(paramrxl);
      return;
      label87:
      paramrxl.d.setText(oqj.a(paramContext, localVideoInfo, paramContext.getResources()));
      paramrxl.k.setText(oqj.a(paramContext, localVideoInfo, paramContext.getResources()));
    }
  }
  
  public static void a(View paramView)
  {
    if ((paramView != null) && (paramView.getVisibility() != 0)) {
      paramView.setVisibility(0);
    }
  }
  
  private static void a(View paramView, ViewGroup.LayoutParams paramLayoutParams, int paramInt)
  {
    paramLayoutParams.width = paramInt;
    paramView.setLayoutParams(paramLayoutParams);
  }
  
  private static void a(View paramView, RelativeLayout.LayoutParams paramLayoutParams, Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    if ((paramView == null) || (paramContext == null) || (paramLayoutParams == null)) {
      return;
    }
    paramLayoutParams.leftMargin = afur.a(paramInt1, paramContext.getResources());
    paramLayoutParams.rightMargin = afur.a(paramInt2, paramContext.getResources());
    paramLayoutParams.topMargin = afur.a(paramInt3, paramContext.getResources());
    paramLayoutParams.bottomMargin = afur.a(paramInt4, paramContext.getResources());
    paramLayoutParams.height = afur.a(paramInt6, paramContext.getResources());
    if (paramInt5 > 0) {
      paramLayoutParams.width = afur.a(paramInt5, paramContext.getResources());
    }
    paramView.setLayoutParams(paramLayoutParams);
  }
  
  public static void a(ImageView paramImageView)
  {
    if (paramImageView == null) {
      return;
    }
    paramImageView.setAlpha(0.5F);
  }
  
  public static void a(TextView paramTextView, String paramString)
  {
    if ((paramTextView != null) && (!TextUtils.isEmpty(paramString))) {
      paramTextView.setText(paramString);
    }
  }
  
  public static void a(rxl paramrxl)
  {
    if (paramrxl == null) {
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramrxl.d.getLayoutParams();
    localLayoutParams.addRule(9, 0);
    localLayoutParams.addRule(13);
    paramrxl.d.setLayoutParams(localLayoutParams);
  }
  
  private static void a(rxl paramrxl, int paramInt)
  {
    a(false, paramrxl, paramInt);
    b(false, paramrxl, paramInt);
    if (paramrxl.jdField_b_of_type_AndroidWidgetImageView != null)
    {
      if (paramInt == 3) {
        paramrxl.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
    else {
      return;
    }
    if (paramInt == 2)
    {
      paramrxl.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
    paramrxl.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  public static void a(rxl paramrxl, String paramString)
  {
    if ((paramrxl == null) || (paramrxl.r == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    paramrxl.r.setText(paramString);
    a(paramrxl.r);
    ThreadManager.getUIHandler().postDelayed(new AdVideoButtonUIUtils.1(paramrxl), 1000L);
  }
  
  public static void a(boolean paramBoolean, rxl paramrxl)
  {
    if ((paramrxl == null) || (paramrxl.jdField_a_of_type_Sar == null) || (paramrxl.jdField_a_of_type_Sar.a == null) || (paramrxl.jdField_a_of_type_Sar.a.a == null)) {
      return;
    }
    int i = a(paramrxl.jdField_a_of_type_Sar.a.a);
    if (!paramBoolean)
    {
      a(paramrxl, i);
      return;
    }
    b(paramrxl, i);
  }
  
  private static void a(boolean paramBoolean, rxl paramrxl, int paramInt)
  {
    float f2 = 19.0F;
    if ((paramrxl == null) || (paramrxl.jdField_c_of_type_AndroidWidgetRelativeLayout == null)) {}
    Context localContext;
    do
    {
      return;
      localContext = paramrxl.jdField_c_of_type_AndroidWidgetRelativeLayout.getContext();
    } while (localContext == null);
    GradientDrawable localGradientDrawable1 = new GradientDrawable();
    GradientDrawable localGradientDrawable2 = new GradientDrawable();
    Object localObject1;
    Object localObject2;
    label64:
    label77:
    Object localObject3;
    float f1;
    if (paramBoolean)
    {
      localObject1 = "#FF12B7F6";
      if (!paramBoolean) {
        break label208;
      }
      localObject2 = "#FF12B7F6";
      if (paramInt != 3) {
        break label222;
      }
      if (!paramBoolean) {
        break label215;
      }
      localObject1 = "#FF12B7F5";
      localObject3 = "#FF12B7F5";
      f1 = 19.0F;
      localObject2 = localObject1;
      localObject1 = localObject3;
    }
    for (;;)
    {
      localGradientDrawable1.setColor(Color.parseColor((String)localObject2));
      localGradientDrawable1.setCornerRadius(afur.a(f2, localContext.getResources()));
      paramrxl.jdField_c_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(localGradientDrawable1);
      localGradientDrawable2.setColor(Color.parseColor((String)localObject1));
      localGradientDrawable2.setCornerRadius(afur.a(f1, localContext.getResources()));
      paramrxl.k.setBackgroundDrawable(localGradientDrawable2);
      if (paramInt == 3)
      {
        paramrxl.jdField_a_of_type_AndroidWidgetProgressBar.setProgressDrawable(localContext.getResources().getDrawable(2130842670));
        paramrxl.jdField_b_of_type_AndroidWidgetProgressBar.setProgressDrawable(localContext.getResources().getDrawable(2130842670));
        return;
        localObject1 = "#1AFFFFFF";
        break;
        label208:
        localObject2 = "#1AFFFFFF";
        break label64;
        label215:
        localObject1 = "#7F7A8690";
        break label77;
        label222:
        if (paramInt != 2) {
          break label335;
        }
        if (paramBoolean) {}
        for (localObject1 = "#FF12B7F6";; localObject1 = "#1AFFFFFF")
        {
          localObject2 = localObject1;
          f1 = 6.0F;
          f2 = 6.0F;
          localObject1 = "#FF12B7F5";
          break;
        }
      }
      if (paramInt == 2)
      {
        paramrxl.jdField_a_of_type_AndroidWidgetProgressBar.setProgressDrawable(localContext.getResources().getDrawable(2130842669));
        paramrxl.jdField_b_of_type_AndroidWidgetProgressBar.setProgressDrawable(localContext.getResources().getDrawable(2130842669));
        return;
      }
      paramrxl.jdField_a_of_type_AndroidWidgetProgressBar.setProgressDrawable(localContext.getResources().getDrawable(2130842668));
      paramrxl.jdField_b_of_type_AndroidWidgetProgressBar.setProgressDrawable(localContext.getResources().getDrawable(2130842669));
      return;
      label335:
      f2 = 0.0F;
      f1 = 6.0F;
      localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
    }
  }
  
  public static boolean a()
  {
    return Aladdin.getConfig(343).getIntegerFromString("tiktok_big_style", 0) == 1;
  }
  
  public static void b(View paramView)
  {
    if ((paramView != null) && (paramView.getVisibility() != 8)) {
      paramView.setVisibility(8);
    }
  }
  
  private static void b(rxl paramrxl)
  {
    if ((paramrxl == null) || (paramrxl.jdField_c_of_type_AndroidWidgetRelativeLayout == null)) {}
    Context localContext;
    do
    {
      return;
      localContext = paramrxl.jdField_c_of_type_AndroidWidgetRelativeLayout.getContext();
    } while ((localContext == null) || (paramrxl.jdField_a_of_type_Sar == null) || (paramrxl.jdField_a_of_type_Sar.a == null));
    Object localObject = paramrxl.jdField_a_of_type_Sar.a;
    int i = localContext.getResources().getDisplayMetrics().widthPixels - afur.a(77.0F, localContext.getResources());
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramrxl.n.getLayoutParams();
    a(paramrxl.n, localLayoutParams, i);
    localLayoutParams = (RelativeLayout.LayoutParams)paramrxl.jdField_e_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    a(paramrxl.jdField_e_of_type_AndroidWidgetRelativeLayout, localLayoutParams, i);
    localLayoutParams = (RelativeLayout.LayoutParams)paramrxl.jdField_c_of_type_AndroidWidgetTextView.getLayoutParams();
    if (oqj.a((VideoInfo)localObject))
    {
      localLayoutParams.bottomMargin = afur.a(124.0F, localContext.getResources());
      a(paramrxl.jdField_c_of_type_AndroidWidgetTextView, localLayoutParams, i);
      paramrxl.jdField_c_of_type_AndroidWidgetTextView.setLineSpacing(afur.a(4.0F, localContext.getResources()), 1.0F);
      localObject = (RelativeLayout.LayoutParams)paramrxl.m.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = afur.a(65.0F, localContext.getResources());
      if (!a()) {
        break label520;
      }
    }
    label520:
    for (((RelativeLayout.LayoutParams)localObject).rightMargin = afur.a(62.0F, localContext.getResources());; ((RelativeLayout.LayoutParams)localObject).rightMargin = afur.a(120.0F, localContext.getResources()))
    {
      paramrxl.m.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (RelativeLayout.LayoutParams)paramrxl.jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = afur.a(65.0F, localContext.getResources());
      paramrxl.jdField_b_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (LinearLayout.LayoutParams)paramrxl.jdField_e_of_type_AndroidWidgetImageView.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).width = afur.a(60.0F, localContext.getResources());
      ((LinearLayout.LayoutParams)localObject).height = afur.a(60.0F, localContext.getResources());
      ((LinearLayout.LayoutParams)localObject).leftMargin = afur.a(10.0F, localContext.getResources());
      ((LinearLayout.LayoutParams)localObject).topMargin = afur.a(12.0F, localContext.getResources());
      paramrxl.jdField_e_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (LinearLayout.LayoutParams)paramrxl.jdField_c_of_type_AndroidWidgetLinearLayout.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).leftMargin = afur.a(10.0F, localContext.getResources());
      paramrxl.jdField_c_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramrxl.j.setTypeface(Typeface.DEFAULT);
      paramrxl.j.setTextSize(12.0F);
      localObject = (LinearLayout.LayoutParams)paramrxl.k.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).height = afur.a(38.0F, localContext.getResources());
      paramrxl.k.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (LinearLayout.LayoutParams)paramrxl.p.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).height = afur.a(38.0F, localContext.getResources());
      paramrxl.p.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (RelativeLayout.LayoutParams)paramrxl.jdField_b_of_type_AndroidWidgetSeekBar.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = afur.a(50.0F, localContext.getResources());
      ((RelativeLayout.LayoutParams)localObject).leftMargin = 0;
      ((RelativeLayout.LayoutParams)localObject).rightMargin = 0;
      paramrxl.jdField_b_of_type_AndroidWidgetSeekBar.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
      localLayoutParams.bottomMargin = afur.a(114.0F, localContext.getResources());
      break;
    }
  }
  
  private static void b(rxl paramrxl, int paramInt)
  {
    a(true, paramrxl, paramInt);
    b(true, paramrxl, paramInt);
    if (paramInt == 3)
    {
      b(paramrxl.jdField_b_of_type_AndroidWidgetImageView);
      return;
    }
    if (paramInt == 2)
    {
      b(paramrxl.jdField_b_of_type_AndroidWidgetImageView);
      return;
    }
    a(paramrxl.jdField_b_of_type_AndroidWidgetImageView);
  }
  
  private static void b(boolean paramBoolean, rxl paramrxl, int paramInt)
  {
    if ((paramrxl.jdField_c_of_type_AndroidWidgetRelativeLayout == null) || (paramrxl.d == null)) {}
    Object localObject;
    do
    {
      return;
      localObject = paramrxl.jdField_c_of_type_AndroidWidgetRelativeLayout.getContext();
    } while (localObject == null);
    int i = 0;
    int j = 0;
    int k = 0;
    int m = 0;
    int i3 = -1;
    int n = 42;
    int i1;
    int i2;
    if (paramInt == 3)
    {
      i = 16;
      j = 15;
      k = 13;
      m = 65;
      i3 = 205;
      n = 40;
      i1 = 9;
      i2 = 13;
    }
    for (;;)
    {
      oqh.a("AdVideoButtonUIUtils", "leftMargin = " + i + " rightMargin = " + j + " topMargin = " + k + " bottomMargin = " + m + " height = " + n);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramrxl.jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      a(paramrxl.jdField_b_of_type_AndroidWidgetRelativeLayout, localLayoutParams, (Context)localObject, i, j, k, m, i3, n);
      localObject = (RelativeLayout.LayoutParams)paramrxl.d.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).addRule(i1, 0);
      ((RelativeLayout.LayoutParams)localObject).addRule(i2);
      paramrxl.d.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if (paramInt == 3)
      {
        b(paramrxl);
        ops.a(paramrxl);
        a(paramrxl.s);
        a(paramrxl.o);
        return;
        if (paramInt == 2)
        {
          int i5 = 15;
          int i4 = 15;
          k = 8;
          m = 5;
          n = 31;
          if (paramBoolean)
          {
            i = 13;
            label283:
            if (!paramBoolean) {
              break label314;
            }
          }
          label314:
          for (j = 9;; j = 13)
          {
            i1 = j;
            i2 = i;
            i = i5;
            j = i4;
            break;
            i = 9;
            break label283;
          }
        }
      }
      else
      {
        c(paramrxl, paramInt);
        ops.b(paramrxl);
        b(paramrxl.s);
        b(paramrxl.o);
        return;
      }
      i1 = 13;
      i2 = 9;
    }
  }
  
  public static boolean b()
  {
    return Aladdin.getConfig(343).getIntegerFromString("gray_btn", 0) == 1;
  }
  
  public static void c(View paramView)
  {
    if ((paramView != null) && (paramView.getVisibility() != 4)) {
      paramView.setVisibility(4);
    }
  }
  
  private static void c(rxl paramrxl, int paramInt)
  {
    if ((paramrxl == null) || (paramrxl.jdField_c_of_type_AndroidWidgetRelativeLayout == null)) {}
    Context localContext;
    do
    {
      return;
      localContext = paramrxl.jdField_c_of_type_AndroidWidgetRelativeLayout.getContext();
    } while ((localContext == null) || (paramrxl.jdField_a_of_type_Sar == null) || (paramrxl.jdField_a_of_type_Sar.a == null));
    Object localObject = paramrxl.jdField_a_of_type_Sar.a;
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramrxl.jdField_c_of_type_AndroidWidgetTextView.getLayoutParams();
    if (oqj.a((VideoInfo)localObject))
    {
      localLayoutParams.bottomMargin = afur.a(51.0F, localContext.getResources());
      paramrxl.jdField_c_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
      localObject = (RelativeLayout.LayoutParams)paramrxl.jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      if (paramInt != 2) {
        break label333;
      }
    }
    label333:
    for (((RelativeLayout.LayoutParams)localObject).bottomMargin = afur.a(5.0F, localContext.getResources());; ((RelativeLayout.LayoutParams)localObject).bottomMargin = afur.a(0.0F, localContext.getResources()))
    {
      paramrxl.jdField_b_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (LinearLayout.LayoutParams)paramrxl.jdField_e_of_type_AndroidWidgetImageView.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).width = afur.a(75.0F, localContext.getResources());
      ((LinearLayout.LayoutParams)localObject).height = afur.a(75.0F, localContext.getResources());
      paramrxl.jdField_e_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramrxl.j.setTypeface(Typeface.DEFAULT);
      localObject = (LinearLayout.LayoutParams)paramrxl.k.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).height = afur.a(31.0F, localContext.getResources());
      paramrxl.k.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (LinearLayout.LayoutParams)paramrxl.p.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).height = afur.a(31.0F, localContext.getResources());
      paramrxl.p.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (RelativeLayout.LayoutParams)paramrxl.jdField_b_of_type_AndroidWidgetSeekBar.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = afur.a(41.5F, localContext.getResources());
      ((RelativeLayout.LayoutParams)localObject).leftMargin = afur.a(15.0F, localContext.getResources());
      ((RelativeLayout.LayoutParams)localObject).rightMargin = afur.a(15.0F, localContext.getResources());
      paramrxl.jdField_b_of_type_AndroidWidgetSeekBar.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
      localLayoutParams.bottomMargin = afur.a(55.0F, localContext.getResources());
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     opr
 * JD-Core Version:    0.7.0.1
 */