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
  public TextView b;
  public TextView c;
  public TextView d;
  
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
  
  private void a(SearchResultModelForEntrance paramSearchResultModelForEntrance, SearchResultEntranceView paramSearchResultEntranceView)
  {
    if (paramSearchResultModelForEntrance.z() != 8) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    TextView localTextView1 = paramSearchResultEntranceView.b();
    TextView localTextView2 = paramSearchResultEntranceView.b;
    if (localTextView2 != null) {
      localStringBuilder.append(localTextView2.getText());
    }
    if (localTextView1 != null) {
      localStringBuilder.append(localTextView1.getText());
    }
    paramSearchResultEntranceView = paramSearchResultEntranceView.c;
    if (paramSearchResultEntranceView != null) {
      localStringBuilder.append(paramSearchResultEntranceView.getText());
    }
    paramSearchResultModelForEntrance.b(localStringBuilder.toString());
  }
  
  private void b(SearchResultModelForEntrance paramSearchResultModelForEntrance)
  {
    if (b() != null) {
      b().setText(paramSearchResultModelForEntrance.d());
    }
    if (c() != null) {
      c().setText(paramSearchResultModelForEntrance.e());
    }
    if ((this.d != null) && (!TextUtils.isEmpty(paramSearchResultModelForEntrance.h)))
    {
      this.d.setText(paramSearchResultModelForEntrance.h);
      c().setMaxWidth(a(this.e.getContext(), new View[] { b(), this.d, this.k }) - SearchUtils.a(75.0F, c().getResources()));
    }
    ColorDrawable localColorDrawable = new ColorDrawable(Color.parseColor("#e7e7e7"));
    int i;
    Object localObject;
    if (g() != null) {
      if (paramSearchResultModelForEntrance.d != 0)
      {
        g().setImageResource(paramSearchResultModelForEntrance.d);
        g().setVisibility(0);
      }
      else if (!TextUtils.isEmpty(paramSearchResultModelForEntrance.e))
      {
        i = h().getResources().getDimensionPixelSize(2131298168);
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = i;
        ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = i;
        ((URLDrawable.URLDrawableOptions)localObject).mMemoryCacheKeySuffix = "isAvatar";
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localColorDrawable;
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localColorDrawable;
        localObject = URLDrawable.getDrawable(paramSearchResultModelForEntrance.e, (URLDrawable.URLDrawableOptions)localObject);
        ((URLDrawable)localObject).setDecodeHandler(((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).getDecodeHandler());
        if ((((URLDrawable)localObject).getStatus() != 1) && (((URLDrawable)localObject).getStatus() != 0)) {
          ((URLDrawable)localObject).restartDownload();
        }
        g().setImageDrawable((Drawable)localObject);
        g().setVisibility(0);
      }
      else
      {
        g().setVisibility(8);
      }
    }
    if (this.a != null)
    {
      i = -1;
      localObject = h().getTag(2131449868);
      if ((localObject instanceof Integer)) {
        i = ((Integer)localObject).intValue();
      }
      if (i > 0) {
        this.a.setVisibility(0);
      } else if (i == 0) {
        this.a.setVisibility(8);
      }
    }
    if ((d() != null) && (!TextUtils.isEmpty(paramSearchResultModelForEntrance.a())))
    {
      d().setText(paramSearchResultModelForEntrance.a());
      d().setVisibility(0);
    }
    if (f() != null)
    {
      if (paramSearchResultModelForEntrance.h()) {
        f().setVisibility(0);
      } else {
        f().setVisibility(8);
      }
      if (!TextUtils.isEmpty(paramSearchResultModelForEntrance.j))
      {
        i = h().getResources().getDimensionPixelSize(2131299105);
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = i;
        ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = i;
        ((URLDrawable.URLDrawableOptions)localObject).mMemoryCacheKeySuffix = "rightIcon";
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localColorDrawable;
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localColorDrawable;
        paramSearchResultModelForEntrance = URLDrawable.getDrawable(paramSearchResultModelForEntrance.j, (URLDrawable.URLDrawableOptions)localObject);
        if ((paramSearchResultModelForEntrance.getStatus() != 1) && (paramSearchResultModelForEntrance.getStatus() != 0)) {
          paramSearchResultModelForEntrance.restartDownload();
        }
        f().setImageDrawable(paramSearchResultModelForEntrance);
        f().setVisibility(0);
        return;
      }
      f().setVisibility(8);
    }
  }
  
  protected void a()
  {
    super.a();
    this.a = this.e.findViewById(2131432033);
    if (this.m == 2131625843)
    {
      this.b = ((TextView)this.e.findViewById(2131447063));
      this.c = ((TextView)this.e.findViewById(2131447065));
      b().setMaxWidth(a(this.e.getContext(), new View[] { this.b, this.c, this.k }));
      b().setTextColor(SearchUtils.a());
      ThemeUtil.isNowThemeIsNight(MobileQQ.sMobileQQ.peekAppRuntime(), false, null);
      return;
    }
    if (this.m == 2131625836) {
      this.d = ((TextView)this.e.findViewById(2131438891));
    }
  }
  
  public void a(SearchResultModelForEntrance paramSearchResultModelForEntrance)
  {
    i();
    int i = paramSearchResultModelForEntrance.c;
    if ((i == -4) || (i == -3) || (i == -1)) {
      b(paramSearchResultModelForEntrance);
    }
    a(paramSearchResultModelForEntrance, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.base.view.SearchResultEntranceView
 * JD-Core Version:    0.7.0.1
 */