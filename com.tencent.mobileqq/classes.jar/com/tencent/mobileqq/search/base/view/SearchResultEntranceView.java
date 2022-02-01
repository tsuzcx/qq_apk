package com.tencent.mobileqq.search.base.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.ISearchPieceFetcher;
import com.tencent.mobileqq.search.base.model.SearchResultModelForEntrance;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import mqq.app.MobileQQ;

public class SearchResultEntranceView
  extends SearchResultView
{
  public View a;
  public TextView a;
  public TextView b;
  public TextView c;
  
  public SearchResultEntranceView(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
  }
  
  public static int a(Context paramContext, View... paramVarArgs)
  {
    int j = paramContext.getResources().getDisplayMetrics().widthPixels;
    int k = paramVarArgs.length;
    int i = 0;
    while (i < k)
    {
      paramContext = paramVarArgs[i];
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramContext.getLayoutParams();
      paramContext.measure(0, 0);
      j = j - paramContext.getMeasuredWidth() - localLayoutParams.leftMargin - localLayoutParams.rightMargin;
      i += 1;
    }
    return j;
  }
  
  private void b(SearchResultModelForEntrance paramSearchResultModelForEntrance)
  {
    if (a() != null) {
      a().setText(paramSearchResultModelForEntrance.b());
    }
    if (b() != null) {
      b().setText(paramSearchResultModelForEntrance.c());
    }
    if ((this.c != null) && (!TextUtils.isEmpty(paramSearchResultModelForEntrance.f)))
    {
      this.c.setText(paramSearchResultModelForEntrance.f);
      b().setMaxWidth(a(this.jdField_b_of_type_AndroidViewView.getContext(), new View[] { a(), this.c, this.jdField_b_of_type_AndroidWidgetImageView }) - SearchUtils.a(75.0F, b().getResources()));
    }
    ColorDrawable localColorDrawable = new ColorDrawable(Color.parseColor("#e7e7e7"));
    int i;
    Object localObject;
    if (b() != null) {
      if (paramSearchResultModelForEntrance.b != 0)
      {
        b().setImageResource(paramSearchResultModelForEntrance.b);
        b().setVisibility(0);
      }
      else if (!TextUtils.isEmpty(paramSearchResultModelForEntrance.c))
      {
        i = a().getResources().getDimensionPixelSize(2131297515);
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = i;
        ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = i;
        ((URLDrawable.URLDrawableOptions)localObject).mMemoryCacheKeySuffix = "isAvatar";
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localColorDrawable;
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localColorDrawable;
        localObject = URLDrawable.getDrawable(paramSearchResultModelForEntrance.c, (URLDrawable.URLDrawableOptions)localObject);
        ((URLDrawable)localObject).setDecodeHandler(((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).getDecodeHandler());
        if ((((URLDrawable)localObject).getStatus() != 1) && (((URLDrawable)localObject).getStatus() != 0)) {
          ((URLDrawable)localObject).restartDownload();
        }
        b().setImageDrawable((Drawable)localObject);
        b().setVisibility(0);
      }
      else
      {
        b().setVisibility(8);
      }
    }
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      i = -1;
      localObject = a().getTag(2131380885);
      if ((localObject instanceof Integer)) {
        i = ((Integer)localObject).intValue();
      }
      if (i > 0) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      } else if (i == 0) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      }
    }
    if ((c() != null) && (!TextUtils.isEmpty(paramSearchResultModelForEntrance.a())))
    {
      c().setText(paramSearchResultModelForEntrance.a());
      c().setVisibility(0);
    }
    if (a() != null)
    {
      if (paramSearchResultModelForEntrance.a()) {
        a().setVisibility(0);
      } else {
        a().setVisibility(8);
      }
      if (!TextUtils.isEmpty(paramSearchResultModelForEntrance.h))
      {
        i = a().getResources().getDimensionPixelSize(2131298391);
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = i;
        ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = i;
        ((URLDrawable.URLDrawableOptions)localObject).mMemoryCacheKeySuffix = "rightIcon";
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localColorDrawable;
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localColorDrawable;
        paramSearchResultModelForEntrance = URLDrawable.getDrawable(paramSearchResultModelForEntrance.h, (URLDrawable.URLDrawableOptions)localObject);
        if ((paramSearchResultModelForEntrance.getStatus() != 1) && (paramSearchResultModelForEntrance.getStatus() != 0)) {
          paramSearchResultModelForEntrance.restartDownload();
        }
        a().setImageDrawable(paramSearchResultModelForEntrance);
        a().setVisibility(0);
        return;
      }
      a().setVisibility(8);
    }
  }
  
  protected void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131365776);
    if (this.jdField_a_of_type_Int == 2131559800)
    {
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131378461));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131378463));
      a().setMaxWidth(a(this.jdField_b_of_type_AndroidViewView.getContext(), new View[] { this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_b_of_type_AndroidWidgetTextView, this.jdField_b_of_type_AndroidWidgetImageView }));
      a().setTextColor(SearchUtils.a());
      ThemeUtil.isNowThemeIsNight(MobileQQ.sMobileQQ.peekAppRuntime(), false, null);
      return;
    }
    if (this.jdField_a_of_type_Int == 2131559793) {
      this.c = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131371514));
    }
  }
  
  public void a(SearchResultModelForEntrance paramSearchResultModelForEntrance)
  {
    b();
    int i = paramSearchResultModelForEntrance.jdField_a_of_type_Int;
    if ((i != -4) && (i != -3) && (i != -1)) {
      return;
    }
    b(paramSearchResultModelForEntrance);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.base.view.SearchResultEntranceView
 * JD-Core Version:    0.7.0.1
 */