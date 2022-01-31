package com.tencent.mobileqq.search.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.search.model.SearchResultModelForEntrance;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.widget.SquareImageView;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import pb.unite.search.DynamicSearch.SubItem;
import pb.unite.search.DynamicSearch.SubItemMedia;
import pb.unite.search.DynamicSearch.SubItemText;

public class SearchResultEntranceView
  extends SearchResultView
{
  public View a;
  public LinearLayout a;
  public TextView a;
  private View b;
  public TextView b;
  private View c;
  public TextView c;
  public TextView d;
  public TextView e;
  private View f;
  
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
    int i = 0;
    CharSequence localCharSequence1 = SearchUtils.a(a(paramSearchResultModelForEntrance.jdField_a_of_type_PbUniteSearchDynamicSearch$SubItem.title.get()));
    CharSequence localCharSequence2 = SearchUtils.a(a(paramSearchResultModelForEntrance.jdField_a_of_type_PbUniteSearchDynamicSearch$SubItem.summary.get()));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(localCharSequence1);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(localCharSequence2);
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null))
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundColor(Color.parseColor("#040E1C"));
      return;
    }
    try
    {
      int j = Color.parseColor(paramSearchResultModelForEntrance.jdField_a_of_type_PbUniteSearchDynamicSearch$SubItem.backgroud_color.toString());
      i = j;
    }
    catch (Exception paramSearchResultModelForEntrance)
    {
      label101:
      break label101;
    }
    if (i != 0)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundColor(i);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundColor(Color.parseColor("#F1F1F1"));
  }
  
  private void c(SearchResultModelForEntrance paramSearchResultModelForEntrance)
  {
    e(paramSearchResultModelForEntrance);
    LinearLayout localLinearLayout;
    if ((paramSearchResultModelForEntrance.jdField_a_of_type_PbUniteSearchDynamicSearch$SubItem != null) && ((this.jdField_f_of_type_AndroidViewView instanceof LinearLayout)))
    {
      localLinearLayout = (LinearLayout)this.jdField_f_of_type_AndroidViewView;
      int m = localLinearLayout.getChildCount();
      int n = paramSearchResultModelForEntrance.jdField_a_of_type_PbUniteSearchDynamicSearch$SubItem.media_list.size();
      int i = 0;
      if (i < m)
      {
        SquareImageView localSquareImageView = (SquareImageView)localLinearLayout.getChildAt(i);
        Object localObject;
        if (i < n)
        {
          localObject = (DynamicSearch.SubItemMedia)paramSearchResultModelForEntrance.jdField_a_of_type_PbUniteSearchDynamicSearch$SubItem.media_list.get(i);
          if (((DynamicSearch.SubItemMedia)localObject).type.get() == 1) {}
        }
        for (;;)
        {
          i += 1;
          break;
          localObject = ((DynamicSearch.SubItemMedia)localObject).coverUrl.get().toStringUtf8();
          if ((i == 4) && (paramSearchResultModelForEntrance.jdField_a_of_type_PbUniteSearchDynamicSearch$SubItem.media_total_count.get() > 5))
          {
            int k = paramSearchResultModelForEntrance.jdField_a_of_type_PbUniteSearchDynamicSearch$SubItem.media_total_count.get() - 5;
            int j = k;
            if (k > 999) {
              j = 999;
            }
            localSquareImageView.setFilterText("+" + j);
          }
          localObject = URLDrawable.getDrawable((String)localObject, null);
          localSquareImageView.setImageDrawable((Drawable)localObject);
          if ((((URLDrawable)localObject).getStatus() != 1) && (((URLDrawable)localObject).getStatus() != 0)) {
            ((URLDrawable)localObject).restartDownload();
          }
          localSquareImageView.setVisibility(0);
          continue;
          localSquareImageView.setVisibility(4);
        }
      }
      if (n == 0) {
        localLinearLayout.setVisibility(8);
      }
    }
    else
    {
      return;
    }
    localLinearLayout.setVisibility(0);
  }
  
  private void d(SearchResultModelForEntrance paramSearchResultModelForEntrance)
  {
    e(paramSearchResultModelForEntrance);
    LinearLayout localLinearLayout;
    if ((paramSearchResultModelForEntrance.jdField_a_of_type_PbUniteSearchDynamicSearch$SubItem != null) && ((this.jdField_f_of_type_AndroidViewView instanceof LinearLayout)))
    {
      localLinearLayout = (LinearLayout)this.jdField_f_of_type_AndroidViewView;
      int j = localLinearLayout.getChildCount();
      int k = paramSearchResultModelForEntrance.jdField_a_of_type_PbUniteSearchDynamicSearch$SubItem.media_list.size();
      int i = 0;
      if (i < j)
      {
        View localView = localLinearLayout.getChildAt(i);
        Object localObject1;
        Object localObject2;
        if (i < k)
        {
          localObject1 = (DynamicSearch.SubItemMedia)paramSearchResultModelForEntrance.jdField_a_of_type_PbUniteSearchDynamicSearch$SubItem.media_list.get(i);
          int m = ((DynamicSearch.SubItemMedia)localObject1).type.get();
          localObject2 = ((DynamicSearch.SubItemMedia)localObject1).coverUrl.get().toStringUtf8();
          if ((m == 2) && (!TextUtils.isEmpty((CharSequence)localObject2))) {}
        }
        for (;;)
        {
          i += 1;
          break;
          if (QLog.isColorLevel()) {
            QLog.d("SearchResultEntranceView", 2, "bindVideoListView use new view.");
          }
          SquareImageView localSquareImageView = (SquareImageView)localView.findViewById(2131361846);
          TextView localTextView = (TextView)localView.findViewById(2131365664);
          localSquareImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
          localSquareImageView.setImageScale(1.777778F, DisplayUtil.a(this.jdField_d_of_type_AndroidViewView.getContext(), 5.0F));
          localObject2 = URLDrawable.getDrawable((String)localObject2, null);
          localSquareImageView.setImageDrawable((Drawable)localObject2);
          if ((((URLDrawable)localObject2).getStatus() != 1) && (((URLDrawable)localObject2).getStatus() != 0)) {
            ((URLDrawable)localObject2).restartDownload();
          }
          localObject1 = ((DynamicSearch.SubItemMedia)localObject1).description.get().toStringUtf8().trim();
          localTextView.setText((CharSequence)localObject1);
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            localTextView.setVisibility(8);
          }
          for (;;)
          {
            localView.setVisibility(0);
            break;
            localTextView.setVisibility(0);
          }
          localView.setVisibility(4);
        }
      }
      if (k == 0) {
        localLinearLayout.setVisibility(8);
      }
    }
    else
    {
      return;
    }
    localLinearLayout.setVisibility(0);
  }
  
  private void e(SearchResultModelForEntrance paramSearchResultModelForEntrance)
  {
    if (paramSearchResultModelForEntrance.jdField_a_of_type_PbUniteSearchDynamicSearch$SubItem != null)
    {
      boolean bool = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
      Object localObject1;
      Object localObject2;
      Object localObject3;
      if (e() != null)
      {
        new ForegroundColorSpan(2131494223);
        localObject1 = new SpannableStringBuilder("");
        localObject2 = paramSearchResultModelForEntrance.jdField_a_of_type_PbUniteSearchDynamicSearch$SubItem.title.get().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Object localObject4 = (DynamicSearch.SubItemText)((Iterator)localObject2).next();
          localObject3 = ((DynamicSearch.SubItemText)localObject4).text.get().toStringUtf8().trim();
          localObject4 = ((DynamicSearch.SubItemText)localObject4).color.get().toStringUtf8();
          ((SpannableStringBuilder)localObject1).append((CharSequence)localObject3);
          if ((!TextUtils.isEmpty((CharSequence)localObject4)) && (!bool)) {
            ((SpannableStringBuilder)localObject1).setSpan(new ForegroundColorSpan(Color.parseColor((String)localObject4)), ((SpannableStringBuilder)localObject1).length() - ((String)localObject3).length(), ((SpannableStringBuilder)localObject1).length(), 34);
          }
        }
        e().setMaxLines(1);
        e().setIncludeFontPadding(false);
        e().setText((CharSequence)localObject1);
      }
      if (b() != null)
      {
        localObject1 = b();
        if (paramSearchResultModelForEntrance.jdField_a_of_type_PbUniteSearchDynamicSearch$SubItem.show_arrow.get() != 1) {
          break label447;
        }
      }
      label447:
      for (int i = 0;; i = 8)
      {
        ((ImageView)localObject1).setVisibility(i);
        if (!(this.jdField_c_of_type_AndroidViewView instanceof LinearLayout)) {
          break label555;
        }
        localObject1 = (LinearLayout)this.jdField_c_of_type_AndroidViewView;
        ((LinearLayout)localObject1).removeAllViews();
        paramSearchResultModelForEntrance = paramSearchResultModelForEntrance.jdField_a_of_type_PbUniteSearchDynamicSearch$SubItem.summary.get().iterator();
        while (paramSearchResultModelForEntrance.hasNext())
        {
          localObject3 = ((DynamicSearch.SubItemText)paramSearchResultModelForEntrance.next()).text.get().toStringUtf8();
          if (!TextUtils.isEmpty((CharSequence)localObject3))
          {
            localObject2 = new TextView(this.jdField_d_of_type_AndroidViewView.getContext());
            ((TextView)localObject2).setText((CharSequence)localObject3);
            ((TextView)localObject2).setMaxLines(1);
            ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
            ((TextView)localObject2).setTextSize(0, a().getResources().getDimension(2131559424));
            ((TextView)localObject2).setTextColor(a().getResources().getColor(2131494271));
            ((TextView)localObject2).setIncludeFontPadding(false);
            localObject3 = new LinearLayout.LayoutParams(-1, -2);
            if (((LinearLayout)localObject1).getChildCount() > 0) {
              ((LinearLayout.LayoutParams)localObject3).topMargin = DisplayUtil.a(this.jdField_d_of_type_AndroidViewView.getContext(), 5.0F);
            }
            ((TextView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
            ((LinearLayout)localObject1).addView((View)localObject2);
          }
        }
      }
      paramSearchResultModelForEntrance = (ViewGroup.MarginLayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
      paramSearchResultModelForEntrance.topMargin = DisplayUtil.a(this.jdField_d_of_type_AndroidViewView.getContext(), -1.0F);
      paramSearchResultModelForEntrance.bottomMargin = DisplayUtil.a(this.jdField_d_of_type_AndroidViewView.getContext(), 10.0F);
      if (((LinearLayout)localObject1).getChildCount() == 0)
      {
        paramSearchResultModelForEntrance.topMargin = DisplayUtil.a(this.jdField_d_of_type_AndroidViewView.getContext(), 4.0F);
        paramSearchResultModelForEntrance.bottomMargin = DisplayUtil.a(this.jdField_d_of_type_AndroidViewView.getContext(), 4.0F);
        ((LinearLayout)localObject1).setVisibility(8);
      }
      for (;;)
      {
        this.jdField_b_of_type_AndroidViewView.setLayoutParams(paramSearchResultModelForEntrance);
        label555:
        return;
        ((LinearLayout)localObject1).setVisibility(0);
      }
    }
    f(paramSearchResultModelForEntrance);
  }
  
  private void f(SearchResultModelForEntrance paramSearchResultModelForEntrance)
  {
    if (e() != null) {
      e().setText(paramSearchResultModelForEntrance.a());
    }
    if (f() != null) {
      f().setText(paramSearchResultModelForEntrance.b());
    }
    if ((this.e != null) && (!TextUtils.isEmpty(paramSearchResultModelForEntrance.f)))
    {
      this.e.setText(paramSearchResultModelForEntrance.f);
      f().setMaxWidth(a(this.jdField_d_of_type_AndroidViewView.getContext(), new View[] { e(), this.e, this.jdField_f_of_type_AndroidWidgetImageView }) - AIOUtils.a(75.0F, f().getResources()));
    }
    Object localObject;
    if (a() != null)
    {
      if (paramSearchResultModelForEntrance.jdField_b_of_type_Int != 0)
      {
        a().setImageResource(paramSearchResultModelForEntrance.jdField_b_of_type_Int);
        a().setVisibility(0);
      }
    }
    else if (this.jdField_a_of_type_AndroidViewView != null)
    {
      localObject = a().getTag(2131362080);
      if (!(localObject instanceof Integer)) {
        break label394;
      }
    }
    label384:
    label394:
    for (int i = ((Integer)localObject).intValue();; i = -1)
    {
      if (i > 0) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
      for (;;)
      {
        if ((g() != null) && (!TextUtils.isEmpty(paramSearchResultModelForEntrance.c())))
        {
          g().setText(paramSearchResultModelForEntrance.c());
          g().setVisibility(0);
        }
        if (b() != null)
        {
          if (!paramSearchResultModelForEntrance.a()) {
            break label384;
          }
          b().setVisibility(0);
        }
        return;
        if (!TextUtils.isEmpty(paramSearchResultModelForEntrance.c))
        {
          i = a().getResources().getDimensionPixelSize(2131559209);
          localObject = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = i;
          ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = i;
          ((URLDrawable.URLDrawableOptions)localObject).mMemoryCacheKeySuffix = "isAvatar";
          localObject = URLDrawable.getDrawable(paramSearchResultModelForEntrance.c, (URLDrawable.URLDrawableOptions)localObject);
          ((URLDrawable)localObject).setDecodeHandler(URLDrawableDecodeHandler.a);
          if ((((URLDrawable)localObject).getStatus() != 1) && (((URLDrawable)localObject).getStatus() != 0)) {
            ((URLDrawable)localObject).restartDownload();
          }
          a().setImageDrawable((Drawable)localObject);
          a().setVisibility(0);
          break;
        }
        a().setVisibility(8);
        break;
        if (i == 0) {
          this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        }
      }
      b().setVisibility(8);
      return;
    }
  }
  
  public JSONArray a(List paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      JSONArray localJSONArray = new JSONArray();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        DynamicSearch.SubItemText localSubItemText = (DynamicSearch.SubItemText)paramList.next();
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("word", localSubItemText.text.get().toStringUtf8());
          localJSONObject.put("color", localSubItemText.color.get().toStringUtf8());
          localJSONArray.put(localJSONObject);
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
        }
      }
      if (localJSONArray.length() > 0) {
        return localJSONArray;
      }
    }
    return null;
  }
  
  protected void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidViewView = this.jdField_d_of_type_AndroidViewView.findViewById(2131363953);
    switch (this.jdField_b_of_type_Int)
    {
    case 2130969376: 
    case 2130969377: 
    case 2130969378: 
    case 2130969379: 
    case 2130969382: 
    default: 
      return;
    case 2130969380: 
      this.jdField_b_of_type_AndroidViewView = this.jdField_d_of_type_AndroidViewView.findViewById(2131366356);
      this.jdField_c_of_type_AndroidViewView = this.jdField_d_of_type_AndroidViewView.findViewById(2131366339);
      return;
    case 2130969384: 
    case 2130969385: 
      this.jdField_b_of_type_AndroidViewView = this.jdField_d_of_type_AndroidViewView.findViewById(2131366356);
      this.jdField_f_of_type_AndroidViewView = this.jdField_d_of_type_AndroidViewView.findViewById(2131366355);
      return;
    case 2130969383: 
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_d_of_type_AndroidViewView.findViewById(2131366353));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_d_of_type_AndroidViewView.findViewById(2131366354));
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_d_of_type_AndroidViewView.findViewById(2131366352));
      return;
    case 2130969381: 
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_d_of_type_AndroidViewView.findViewById(2131363921));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_d_of_type_AndroidViewView.findViewById(2131363926));
      e().setMaxWidth(a(this.jdField_d_of_type_AndroidViewView.getContext(), new View[] { this.jdField_c_of_type_AndroidWidgetTextView, this.jdField_d_of_type_AndroidWidgetTextView, this.jdField_f_of_type_AndroidWidgetImageView }));
      return;
    }
    this.e = ((TextView)this.jdField_d_of_type_AndroidViewView.findViewById(2131366334));
  }
  
  public void a(SearchResultModelForEntrance paramSearchResultModelForEntrance)
  {
    b();
    switch (paramSearchResultModelForEntrance.jdField_a_of_type_Int)
    {
    case 0: 
    default: 
      f(paramSearchResultModelForEntrance);
      return;
    case -4: 
    case -3: 
    case -2: 
    case -1: 
      f(paramSearchResultModelForEntrance);
      return;
    case 1: 
      e(paramSearchResultModelForEntrance);
      return;
    case 2: 
      d(paramSearchResultModelForEntrance);
      return;
    case 3: 
      c(paramSearchResultModelForEntrance);
      return;
    }
    b(paramSearchResultModelForEntrance);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.view.SearchResultEntranceView
 * JD-Core Version:    0.7.0.1
 */