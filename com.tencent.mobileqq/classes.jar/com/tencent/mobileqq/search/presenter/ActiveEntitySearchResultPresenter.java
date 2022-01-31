package com.tencent.mobileqq.search.presenter;

import ahyu;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.search.model.GroupBaseNetSearchModelItem;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.model.RelativeWord;
import com.tencent.mobileqq.search.util.SearchViewUtils;
import com.tencent.mobileqq.search.view.ISearchResultView;
import com.tencent.mobileqq.search.view.SearchResultFromNetView;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.widget.TroopLabelLayout;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class ActiveEntitySearchResultPresenter
  extends SearchResultPresenter
{
  int jdField_a_of_type_Int;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new ahyu(this);
  boolean jdField_a_of_type_Boolean = false;
  
  public ActiveEntitySearchResultPresenter(FaceDecoder paramFaceDecoder, int paramInt)
  {
    super(paramFaceDecoder);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private LinearLayout a(Context paramContext)
  {
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    localLinearLayout.setOrientation(0);
    int i = paramContext.getResources().getDisplayMetrics().widthPixels;
    float f = paramContext.getResources().getDimension(2131559153);
    i = (int)(i - f * 2.0F - AIOUtils.a(24.0F, paramContext.getResources()) - 1.0F) / 2;
    TextView localTextView1 = new TextView(paramContext);
    localTextView1.setTextSize(1, 16.0F);
    localTextView1.setTextColor(paramContext.getResources().getColor(2131494223));
    Object localObject = new LinearLayout.LayoutParams(i, -2);
    ((LinearLayout.LayoutParams)localObject).rightMargin = DisplayUtil.a(paramContext, 12.0F);
    localTextView1.setSingleLine(true);
    localTextView1.setEllipsize(TextUtils.TruncateAt.END);
    localTextView1.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = new TextView(paramContext);
    ((TextView)localObject).setLayoutParams(new LinearLayout.LayoutParams(1, -1));
    ((TextView)localObject).setBackgroundColor(paramContext.getResources().getColor(2131493805));
    ((TextView)localObject).setId(2131363953);
    TextView localTextView2 = new TextView(paramContext);
    localTextView2.setTextSize(1, 16.0F);
    localTextView2.setTextColor(paramContext.getResources().getColor(2131494223));
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(i, -2);
    localLayoutParams.leftMargin = DisplayUtil.a(paramContext, 12.0F);
    localTextView2.setLayoutParams(localLayoutParams);
    localTextView2.setSingleLine(true);
    localTextView2.setEllipsize(TextUtils.TruncateAt.END);
    localLinearLayout.addView(localTextView1);
    localLinearLayout.addView((View)localObject);
    localLinearLayout.addView(localTextView2);
    return localLinearLayout;
  }
  
  public static void a(ImageView paramImageView1, ImageView paramImageView2, int paramInt)
  {
    Drawable localDrawable;
    if (paramInt == 1)
    {
      localDrawable = paramImageView2.getResources().getDrawable(2130840387);
      paramImageView1.setColorFilter(-1610612736, PorterDuff.Mode.SRC_OVER);
      paramImageView2.setImageDrawable(localDrawable);
      paramImageView2.setScaleType(ImageView.ScaleType.CENTER);
      paramImageView2.setVisibility(0);
      return;
    }
    if (paramInt == 2)
    {
      localDrawable = paramImageView2.getResources().getDrawable(2130840402);
      paramImageView1.setColorFilter(-1610612736, PorterDuff.Mode.SRC_OVER);
      paramImageView2.setImageDrawable(localDrawable);
      paramImageView2.setScaleType(ImageView.ScaleType.CENTER);
      paramImageView2.setVisibility(0);
      return;
    }
    paramImageView1.setColorFilter(0);
    paramImageView2.setVisibility(8);
  }
  
  private void a(TextView paramTextView, int paramInt1, int paramInt2)
  {
    int i;
    switch (paramInt1)
    {
    default: 
      paramInt1 = 0;
      i = 0;
    }
    while ((i == 0) && (paramInt2 == 0))
    {
      paramTextView.setText("");
      paramTextView.setCompoundDrawables(null, null, null, null);
      paramTextView.setVisibility(4);
      return;
      i = 2130839267;
      paramInt1 = 2130842925;
      continue;
      i = 2130839262;
      paramInt1 = 2130842916;
    }
    paramTextView.setVisibility(0);
    paramTextView.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
    paramTextView.setBackgroundResource(paramInt1);
    paramTextView.setText(String.valueOf(paramInt2));
    paramTextView.setTextColor(BaseApplicationImpl.getContext().getResources().getColor(2131492969));
  }
  
  public static void a(TextView paramTextView1, TextView paramTextView2, CharSequence paramCharSequence, TextView paramTextView3)
  {
    Paint localPaint = new Paint();
    if ((paramTextView1 == null) || (paramTextView2 == null) || (paramCharSequence == null)) {
      return;
    }
    int i = paramTextView1.getContext().getResources().getDisplayMetrics().widthPixels;
    float f1;
    if (paramTextView3 != null)
    {
      localPaint.setTextSize(paramTextView3.getTextSize());
      f1 = localPaint.measureText(paramTextView3.getText(), 0, paramTextView3.getText().length()) + AIOUtils.a(4.0F, paramTextView1.getContext().getResources());
      paramTextView3.getLayoutParams().width = ((int)f1);
      paramTextView3.setLayoutParams(paramTextView3.getLayoutParams());
      paramTextView3.setPadding(AIOUtils.a(2.0F, paramTextView1.getContext().getResources()), 0, AIOUtils.a(2.0F, paramTextView1.getContext().getResources()), 0);
    }
    for (;;)
    {
      float f2 = i - AIOUtils.a(89.0F, paramTextView1.getContext().getResources());
      if (f1 != 0.0F) {}
      for (f1 = f2 - (f1 + AIOUtils.a(6.0F, paramTextView1.getContext().getResources()));; f1 = f2)
      {
        localPaint.setTextSize(paramTextView1.getTextSize());
        if (localPaint.measureText(paramCharSequence, 0, paramCharSequence.length()) > f1)
        {
          paramTextView1.setMaxLines(2);
          paramTextView2.setMaxLines(1);
          return;
        }
        paramTextView1.setMaxLines(1);
        paramTextView2.setMaxLines(2);
        return;
      }
      f1 = 0.0F;
    }
  }
  
  private void a(TextView paramTextView, String paramString)
  {
    if ((paramString != null) && ((paramString.startsWith("http://")) || (paramString.startsWith("https://"))))
    {
      paramString = URLDrawable.getDrawable(paramString);
      if ((paramString.getStatus() != 1) && (paramString.getStatus() != 0)) {
        paramString.restartDownload();
      }
      Resources localResources = paramTextView.getContext().getResources();
      paramString.setBounds(0, 0, AIOUtils.a(14.0F, localResources), AIOUtils.a(14.0F, localResources));
      paramTextView.setCompoundDrawablePadding(AIOUtils.a(4.0F, localResources));
      paramTextView.setCompoundDrawables(null, null, paramString, null);
      return;
    }
    paramTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
  }
  
  private void a(SearchResultFromNetView paramSearchResultFromNetView, GroupBaseNetSearchModelItem paramGroupBaseNetSearchModelItem)
  {
    List localList = paramGroupBaseNetSearchModelItem.jdField_c_of_type_JavaUtilList;
    paramSearchResultFromNetView.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    paramSearchResultFromNetView.jdField_a_of_type_AndroidWidgetTextView.setText(paramGroupBaseNetSearchModelItem.jdField_c_of_type_JavaLangString);
    int j = localList.size();
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    localLayoutParams.topMargin = DisplayUtil.a(paramSearchResultFromNetView.jdField_a_of_type_AndroidWidgetLinearLayout.getContext(), 9.0F);
    localLayoutParams.bottomMargin = DisplayUtil.a(paramSearchResultFromNetView.jdField_a_of_type_AndroidWidgetLinearLayout.getContext(), 9.0F);
    boolean bool = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
    int k = Color.parseColor("#4B76A6");
    int i = 0;
    RelativeWord localRelativeWord2;
    if (i < j)
    {
      localRelativeWord2 = (RelativeWord)localList.get(i);
      if (i + 1 >= j) {
        break label624;
      }
    }
    label303:
    label624:
    for (RelativeWord localRelativeWord1 = (RelativeWord)localList.get(i + 1);; localRelativeWord1 = null)
    {
      LinearLayout localLinearLayout = a(paramSearchResultFromNetView.a().getContext());
      TextView localTextView1 = (TextView)localLinearLayout.getChildAt(0);
      TextView localTextView2 = (TextView)localLinearLayout.getChildAt(1);
      TextView localTextView3 = (TextView)localLinearLayout.getChildAt(2);
      localTextView1.setText(localRelativeWord2.a);
      localTextView1.setTextColor(k);
      localTextView1.setTag(localRelativeWord2.b);
      localTextView1.setTag(2131372046, localRelativeWord2.a);
      localTextView1.setTag(2131362363, localRelativeWord2.b);
      if (localRelativeWord1 != null)
      {
        localTextView3.setText(localRelativeWord1.a);
        localTextView3.setTextColor(k);
        localTextView3.setTag(localRelativeWord1.b);
        localTextView3.setTag(2131372046, localRelativeWord1.a);
        localTextView3.setTag(2131362363, localRelativeWord1.b);
        localTextView1.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        localTextView3.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        localTextView1.setTag(2131362079, paramGroupBaseNetSearchModelItem);
        localTextView3.setTag(2131362079, paramGroupBaseNetSearchModelItem);
        paramSearchResultFromNetView.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localLinearLayout, localLayoutParams);
        if (!bool) {
          break label389;
        }
        localTextView2.setBackgroundColor(paramSearchResultFromNetView.a().getResources().getColor(2131492950));
      }
      for (;;)
      {
        i += 2;
        break;
        localTextView3.setVisibility(4);
        break label303;
        localTextView2.setBackgroundColor(paramSearchResultFromNetView.a().getResources().getColor(2131492949));
      }
      if (bool)
      {
        paramSearchResultFromNetView.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#44608A"));
        paramSearchResultFromNetView.jdField_b_of_type_AndroidViewView.setBackgroundColor(Color.parseColor("#040E1C"));
        paramSearchResultFromNetView.jdField_a_of_type_AndroidViewView.setBackgroundColor(BaseApplicationImpl.getApplication().getResources().getColor(2131492950));
        if ((paramGroupBaseNetSearchModelItem.jdField_d_of_type_Boolean) || (paramGroupBaseNetSearchModelItem.jdField_c_of_type_Boolean))
        {
          paramSearchResultFromNetView.c.setVisibility(8);
          paramSearchResultFromNetView.jdField_a_of_type_AndroidViewView.setVisibility(0);
          return;
        }
        paramSearchResultFromNetView.c.setVisibility(0);
        paramSearchResultFromNetView.jdField_a_of_type_AndroidViewView.setVisibility(8);
        paramSearchResultFromNetView.c.setBackgroundColor(Color.parseColor("#040E1C"));
        return;
      }
      paramSearchResultFromNetView.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#808080"));
      paramSearchResultFromNetView.jdField_b_of_type_AndroidViewView.setBackgroundColor(Color.parseColor("#ECECEC"));
      paramSearchResultFromNetView.jdField_a_of_type_AndroidViewView.setBackgroundColor(BaseApplicationImpl.getApplication().getResources().getColor(2131492949));
      if (!paramGroupBaseNetSearchModelItem.jdField_d_of_type_Boolean)
      {
        paramSearchResultFromNetView.c.setVisibility(0);
        paramSearchResultFromNetView.jdField_a_of_type_AndroidViewView.setVisibility(8);
        paramSearchResultFromNetView.c.setBackgroundColor(Color.parseColor("#F7F7F8"));
        return;
      }
      paramSearchResultFromNetView.c.setVisibility(8);
      paramSearchResultFromNetView.jdField_a_of_type_AndroidViewView.setVisibility(0);
      return;
    }
  }
  
  public void a(View paramView, CharSequence paramCharSequence, boolean paramBoolean)
  {
    a(paramView, paramCharSequence, paramBoolean, false);
  }
  
  public void a(View paramView, CharSequence paramCharSequence, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i;
    if (paramView != null)
    {
      if (TextUtils.isEmpty(paramCharSequence)) {
        break label32;
      }
      i = 1;
      if ((i == 0) || (paramView.getVisibility() == 0)) {
        break label38;
      }
      paramView.setVisibility(0);
    }
    label32:
    label38:
    do
    {
      do
      {
        return;
        i = 0;
        break;
      } while (i != 0);
      if ((paramBoolean1) && (!paramBoolean2) && (paramView.getVisibility() != 4))
      {
        paramView.setVisibility(4);
        return;
      }
    } while (paramView.getVisibility() == 8);
    paramView.setVisibility(8);
  }
  
  public void a(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView)
  {
    if (!(paramISearchResultModel instanceof GroupBaseNetSearchModelItem))
    {
      QLog.e("Q.uniteSearch.ActiveEntitySearchResultPresenter", 2, "Model is not GroupBaseNetSearchModelItem type. m = " + paramISearchResultModel);
      throw new RuntimeException("Model is not GroupBaseNetSearchModelItem type. m = " + paramISearchResultModel);
    }
    paramISearchResultModel = (GroupBaseNetSearchModelItem)paramISearchResultModel;
    this.jdField_a_of_type_Int = paramISearchResultModel.b();
    TextView localTextView1 = paramISearchResultView.e();
    TextView localTextView2 = paramISearchResultView.f();
    TextView localTextView3 = paramISearchResultView.g();
    Resources localResources = paramISearchResultView.a().getContext().getResources();
    if ((localTextView3 != null) && (paramISearchResultModel.jdField_c_of_type_Int != -1)) {
      localTextView3.setTextColor(localResources.getColor(paramISearchResultModel.jdField_c_of_type_Int));
    }
    if ((paramISearchResultView instanceof SearchResultFromNetView))
    {
      SearchResultFromNetView localSearchResultFromNetView = (SearchResultFromNetView)paramISearchResultView;
      if (localSearchResultFromNetView.b() != null) {
        localSearchResultFromNetView.b().setVisibility(8);
      }
      if (localTextView1 != null) {
        a(localTextView1, paramISearchResultModel.h);
      }
      if (localTextView2 != null) {
        a(localTextView2, paramISearchResultModel.i);
      }
      switch (this.jdField_a_of_type_Int)
      {
      default: 
        if (localTextView3 != null) {
          localTextView3.setMaxLines(1);
        }
        break;
      }
      for (;;)
      {
        super.a(paramISearchResultModel, paramISearchResultView);
        a(paramISearchResultView.e(), paramISearchResultModel.a(), true, false);
        a(paramISearchResultView.f(), paramISearchResultModel.b(), false);
        a(paramISearchResultView.g(), paramISearchResultModel.c(), false);
        a(paramISearchResultView.h(), paramISearchResultModel.d(), false);
        return;
        if (localSearchResultFromNetView.a() != null)
        {
          a(localSearchResultFromNetView.a(), paramISearchResultModel.jdField_d_of_type_Int, paramISearchResultModel.e);
          continue;
          if (localSearchResultFromNetView.a() != null)
          {
            localSearchResultFromNetView.a().setVisibility(0);
            localSearchResultFromNetView.a().setLabelType(1);
            localSearchResultFromNetView.a().a(paramISearchResultModel.a);
          }
          if (localSearchResultFromNetView.jdField_a_of_type_AndroidWidgetImageView != null)
          {
            if ((paramISearchResultModel.jdField_b_of_type_Long & 0x800) == 0L) {
              break label467;
            }
            localSearchResultFromNetView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          }
          while (localSearchResultFromNetView.jdField_b_of_type_AndroidWidgetImageView != null)
          {
            if ((paramISearchResultModel.jdField_b_of_type_Long & 1L) == 0L) {
              break label480;
            }
            localSearchResultFromNetView.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
            break;
            label467:
            localSearchResultFromNetView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          }
          label480:
          localSearchResultFromNetView.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          continue;
          if (localTextView1 != null)
          {
            localTextView1.setCompoundDrawablePadding(AIOUtils.a(4.0F, localResources));
            localTextView1.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130839697, 0);
            continue;
            a(localTextView1, localTextView3, paramISearchResultModel.a(), null);
            continue;
            a(localSearchResultFromNetView, paramISearchResultModel);
          }
        }
      }
    }
    QLog.e("Q.uniteSearch.ActiveEntitySearchResultPresenter", 2, "View is not SearchResultFromNetView. View = " + paramISearchResultView);
    throw new RuntimeException("View is not SearchResultFromNetView. View = " + paramISearchResultView);
  }
  
  public boolean a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return true;
    }
    return false;
  }
  
  public void b(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView)
  {
    Object localObject = paramISearchResultView.a();
    if (localObject == null) {
      return;
    }
    for (;;)
    {
      GroupBaseNetSearchModelItem localGroupBaseNetSearchModelItem;
      ViewGroup.LayoutParams localLayoutParams;
      try
      {
        if ((!(paramISearchResultModel instanceof GroupBaseNetSearchModelItem)) || (!(paramISearchResultView instanceof SearchResultFromNetView))) {
          break label425;
        }
        localGroupBaseNetSearchModelItem = (GroupBaseNetSearchModelItem)paramISearchResultModel;
        SearchResultFromNetView localSearchResultFromNetView = (SearchResultFromNetView)paramISearchResultView;
        localLayoutParams = ((ImageView)localObject).getLayoutParams();
        if (this.jdField_a_of_type_Boolean)
        {
          localLayoutParams.height = AIOUtils.a(30.0F, ((ImageView)localObject).getContext().getResources());
          ((ImageView)localObject).setLayoutParams(localLayoutParams);
          if (localSearchResultFromNetView.c() != null) {
            localSearchResultFromNetView.c().setLayoutParams(localLayoutParams);
          }
          if ((localGroupBaseNetSearchModelItem.b() == 1001) || (localGroupBaseNetSearchModelItem.b() == 1002)) {
            break label416;
          }
          int i = paramISearchResultView.a().getResources().getDimensionPixelSize(2131559209);
          paramISearchResultModel = URLDrawable.URLDrawableOptions.obtain();
          paramISearchResultModel.mRequestWidth = i;
          paramISearchResultModel.mRequestHeight = i;
          if (localGroupBaseNetSearchModelItem.jdField_b_of_type_Boolean) {
            paramISearchResultModel.mMemoryCacheKeySuffix = "isAvatar";
          }
          if (this.jdField_a_of_type_Boolean)
          {
            localObject = new GradientDrawable();
            ((GradientDrawable)localObject).setColor(Color.parseColor("#ECEAE8"));
            ((GradientDrawable)localObject).setShape(1);
            paramISearchResultModel.mLoadingDrawable = ((Drawable)localObject);
            paramISearchResultModel.mFailedDrawable = ((Drawable)localObject);
          }
          paramISearchResultModel = URLDrawable.getDrawable(localGroupBaseNetSearchModelItem.c(), paramISearchResultModel);
          if (localGroupBaseNetSearchModelItem.jdField_b_of_type_Boolean) {
            paramISearchResultModel.setDecodeHandler(URLDrawableDecodeHandler.a);
          }
          if ((paramISearchResultModel.getStatus() != 1) && (paramISearchResultModel.getStatus() != 0)) {
            paramISearchResultModel.restartDownload();
          }
          paramISearchResultView.a().setImageDrawable(paramISearchResultModel);
          if ((paramISearchResultView.a() == null) || (localSearchResultFromNetView.c() == null)) {
            break;
          }
          a(paramISearchResultView.a(), localSearchResultFromNetView.c(), localGroupBaseNetSearchModelItem.jdField_b_of_type_Int);
          return;
        }
      }
      catch (Exception paramISearchResultModel)
      {
        QLog.e("Q.uniteSearch.ActiveEntitySearchResultPresenter", 1, "get face drawable error:" + paramISearchResultModel.toString());
        return;
      }
      if ((localGroupBaseNetSearchModelItem.b() == 8192) || (localGroupBaseNetSearchModelItem.b() == 16) || (localGroupBaseNetSearchModelItem.b() == 8))
      {
        localLayoutParams.height = AIOUtils.a(70.0F, ((ImageView)localObject).getContext().getResources());
      }
      else if (localGroupBaseNetSearchModelItem.b() != 1024)
      {
        localLayoutParams.height = ((ImageView)localObject).getResources().getDimensionPixelSize(2131559134);
        continue;
        label416:
        super.b(paramISearchResultModel, paramISearchResultView);
      }
    }
    label425:
    super.b(paramISearchResultModel, paramISearchResultView);
  }
  
  public void c(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView)
  {
    if (((paramISearchResultModel instanceof GroupBaseNetSearchModelItem)) && (!this.jdField_a_of_type_Boolean) && (a(((GroupBaseNetSearchModelItem)paramISearchResultModel).b()))) {
      SearchViewUtils.a(paramISearchResultModel.c(), paramISearchResultModel.d(), paramISearchResultView.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.presenter.ActiveEntitySearchResultPresenter
 * JD-Core Version:    0.7.0.1
 */