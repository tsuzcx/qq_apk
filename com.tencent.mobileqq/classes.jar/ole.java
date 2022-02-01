import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.NativeAd.view.NativeAdDownloadView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout.Params;

public class ole
{
  public static void a(Context paramContext, osm paramosm, ols paramols, TextView paramTextView, NativeAdDownloadView paramNativeAdDownloadView)
  {
    int n = Color.parseColor("#40A0FF");
    if (!TextUtils.isEmpty(paramols.jdField_a_of_type_JavaLangString)) {
      n = nya.a(paramols.jdField_a_of_type_JavaLangString, "#FFFFFF");
    }
    for (;;)
    {
      int i2 = (int)paramols.g;
      float f2 = paramols.jdField_a_of_type_Int;
      int i = 0;
      int j = 0;
      float f1 = f2;
      if (f2 < 10.0F) {
        f1 = 10.0F;
      }
      if (f1 > 16.0F) {}
      for (float f4 = 16.0F;; f4 = f1)
      {
        Object localObject = paramols.b;
        f2 = paramols.jdField_c_of_type_Float;
        String str = paramols.jdField_c_of_type_JavaLangString;
        float f3 = paramols.d;
        GradientDrawable localGradientDrawable = new GradientDrawable();
        if (!TextUtils.isEmpty(str)) {
          localGradientDrawable.setColor(nya.a(str, "#40A0FF"));
        }
        f1 = f2;
        if (f2 > 0.0F)
        {
          f1 = f2;
          if (f2 > 2.0F) {
            f1 = 2.0F;
          }
          localGradientDrawable.setStroke(afur.a(f1, paramContext.getResources()), nya.a((String)localObject, "#40A0FF"));
        }
        if (f3 < 0.0F) {
          f2 = 0.0F;
        }
        for (;;)
        {
          localGradientDrawable.setCornerRadius(afur.a(f2, paramContext.getResources()));
          pez.a(paramTextView, localGradientDrawable);
          f3 = paramols.e;
          float f5 = paramols.f;
          label228:
          label238:
          int k;
          int m;
          if (f3 < 0.0F)
          {
            f2 = 0.0F;
            if (f5 >= 0.0F) {
              break label562;
            }
            f3 = 0.0F;
            if (f2 > 0.0F)
            {
              j = afur.a(f2, paramContext.getResources());
              i = j;
            }
            if (f3 <= 0.0F) {
              break label655;
            }
            k = afur.a(f3, paramContext.getResources());
            m = k;
          }
          for (;;)
          {
            f2 = paramols.i;
            if (f2 == 3.0F)
            {
              localObject = (FrameLayout.LayoutParams)paramTextView.getLayoutParams();
              ((FrameLayout.LayoutParams)localObject).gravity = 21;
              paramTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
              localObject = (FrameLayout.LayoutParams)paramNativeAdDownloadView.getLayoutParams();
              ((FrameLayout.LayoutParams)localObject).gravity = 21;
              paramNativeAdDownloadView.setLayoutParams((ViewGroup.LayoutParams)localObject);
              label342:
              f2 = paramols.k;
              f3 = paramols.l;
              if ((f2 <= 0.0F) || (f3 <= 0.0F)) {
                break label640;
              }
              paramNativeAdDownloadView = (FrameLayout.LayoutParams)paramTextView.getLayoutParams();
              paramNativeAdDownloadView.height = afur.a(f3, paramContext.getResources());
              paramNativeAdDownloadView.width = afur.a(f2, paramContext.getResources());
              paramTextView.setLayoutParams(paramNativeAdDownloadView);
              paramTextView.setGravity(17);
              j = 0;
              i = 0;
              k = 0;
              m = 0;
            }
            for (;;)
            {
              f2 = paramols.j;
              if (f2 > 0.0F)
              {
                if (f1 <= 2.0F) {
                  break label637;
                }
                f1 = 2.0F;
              }
              label562:
              label637:
              for (;;)
              {
                paramNativeAdDownloadView = paramosm.getComLayoutParams();
                paramols = paramNativeAdDownloadView;
                if (paramNativeAdDownloadView == null) {
                  paramols = new Layout.Params();
                }
                paramols.mLayoutWidth = afur.a(f1 * 2.0F + f2, paramContext.getResources());
                paramosm.setComLayoutParams(paramols);
                paramTextView.setCompoundDrawablePadding(i2);
                paramTextView.setTextColor(n);
                paramTextView.setTextSize(f4);
                paramTextView.setPadding(j, k, i, m);
                return;
                if (f3 <= 20.0F) {
                  break label664;
                }
                f2 = 20.0F;
                break;
                f2 = f3;
                if (f3 <= 12.0F) {
                  break label228;
                }
                f2 = 12.0F;
                break label228;
                f3 = f5;
                if (f5 <= 12.0F) {
                  break label238;
                }
                f3 = 12.0F;
                break label238;
                if (f2 != 1.0F) {
                  break label342;
                }
                localObject = (FrameLayout.LayoutParams)paramTextView.getLayoutParams();
                ((FrameLayout.LayoutParams)localObject).gravity = 19;
                paramTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
                localObject = (FrameLayout.LayoutParams)paramNativeAdDownloadView.getLayoutParams();
                ((FrameLayout.LayoutParams)localObject).gravity = 19;
                paramNativeAdDownloadView.setLayoutParams((ViewGroup.LayoutParams)localObject);
                break label342;
              }
              label640:
              int i1 = j;
              j = i;
              i = i1;
            }
            label655:
            m = 0;
            k = 0;
          }
          label664:
          f2 = f3;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ole
 * JD-Core Version:    0.7.0.1
 */