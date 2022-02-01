package com.tencent.mobileqq.ocr.ui;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.ocr.OCRTextSearchInfo.SougouSearchInfo;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class SearchSougouResultItemBuilder
  extends SearchResultBaseBuilder
{
  public static final Paint a;
  private ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(Color.parseColor("#e7e7e7"));
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  
  static
  {
    jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup, SearchResultAdapter paramSearchResultAdapter, SearchResultAdapter.ListItem paramListItem)
  {
    Context localContext = paramViewGroup.getContext();
    OCRTextSearchInfo.SougouSearchInfo localSougouSearchInfo = (OCRTextSearchInfo.SougouSearchInfo)paramListItem.jdField_a_of_type_JavaLangObject;
    if (paramView != null)
    {
      paramSearchResultAdapter = (SearchResultAdapter.ListItem)paramView.getTag();
      if ((paramSearchResultAdapter.jdField_a_of_type_Int == paramListItem.jdField_a_of_type_Int) && (paramSearchResultAdapter.b == paramListItem.b))
      {
        paramSearchResultAdapter = (SearchSougouResultItemBuilder.ViewHolder)paramView.getTag(-1);
        paramInt = 0;
        break label75;
      }
    }
    paramSearchResultAdapter = null;
    paramInt = 1;
    label75:
    Object localObject;
    if (paramInt == 0)
    {
      localObject = paramSearchResultAdapter;
      if (paramSearchResultAdapter != null) {}
    }
    else
    {
      localObject = new SearchSougouResultItemBuilder.ViewHolder(this);
      paramView = (ViewGroup)LayoutInflater.from(localContext).inflate(2131561261, paramViewGroup, false);
      ((SearchSougouResultItemBuilder.ViewHolder)localObject).jdField_a_of_type_AndroidViewViewGroup = paramView;
      ((SearchSougouResultItemBuilder.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378784));
      ((SearchSougouResultItemBuilder.ViewHolder)localObject).b = ((TextView)paramView.findViewById(2131361820));
      ((SearchSougouResultItemBuilder.ViewHolder)localObject).c = ((TextView)paramView.findViewById(2131377723));
      ((SearchSougouResultItemBuilder.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368461));
      paramView.setTag(-1, localObject);
    }
    a((SearchSougouResultItemBuilder.ViewHolder)localObject, localSougouSearchInfo);
    paramView.setTag(paramListItem);
    return paramView;
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
  }
  
  void a(SearchSougouResultItemBuilder.ViewHolder paramViewHolder, OCRTextSearchInfo.SougouSearchInfo paramSougouSearchInfo)
  {
    Object localObject = new HighlightModel(paramSougouSearchInfo.titleKeyWords, null);
    if (!TextUtils.isEmpty(paramSougouSearchInfo.title))
    {
      localObject = ((HighlightModel)localObject).a(paramSougouSearchInfo.title, true);
      if (localObject != null) {
        paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      }
    }
    localObject = new HighlightModel(paramSougouSearchInfo.abstractStrKeyWords, null);
    if (!TextUtils.isEmpty(paramSougouSearchInfo.abstractStr))
    {
      localObject = ((HighlightModel)localObject).a(HighlightModel.a(paramSougouSearchInfo.abstractStr));
      paramViewHolder.b.setText((CharSequence)localObject);
    }
    try
    {
      if (TextUtils.isEmpty(paramSougouSearchInfo.summaryPic))
      {
        paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      else
      {
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = DisplayUtil.a(MobileQQ.sMobileQQ, 80.0F);
        ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = DisplayUtil.a(MobileQQ.sMobileQQ, 60.0F);
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
        localObject = URLDrawable.getDrawable(paramSougouSearchInfo.summaryPic, (URLDrawable.URLDrawableOptions)localObject);
        if ((localObject != null) && (((URLDrawable)localObject).getStatus() == 2))
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("updateNormalItem image fail,");
            ((StringBuilder)localObject).append(paramSougouSearchInfo);
            QLog.e("Q.ocr.SearchSougouResultItemBuilder", 2, ((StringBuilder)localObject).toString());
          }
          paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        }
        else
        {
          paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          if (localObject != null) {
            ((URLDrawable)localObject).setURLDrawableListener(new SearchSougouResultItemBuilder.UrlDownloadListener(this));
          }
          paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
        }
        paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setTag(paramSougouSearchInfo.summaryPic);
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.ocr.SearchSougouResultItemBuilder", 2, "updateNormalItem", localException);
      }
      localException.printStackTrace();
    }
    if (TextUtils.isEmpty(paramSougouSearchInfo.sourceFrom))
    {
      paramViewHolder.c.setVisibility(8);
      return;
    }
    paramViewHolder.c.setVisibility(0);
    paramViewHolder.c.setText(paramSougouSearchInfo.sourceFrom);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.ui.SearchSougouResultItemBuilder
 * JD-Core Version:    0.7.0.1
 */