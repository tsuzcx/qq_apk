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
  public static final Paint b = new Paint();
  ViewGroup a;
  private ColorDrawable c = new ColorDrawable(Color.parseColor("#e7e7e7"));
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup, SearchResultAdapter paramSearchResultAdapter, SearchResultAdapter.ListItem paramListItem)
  {
    Context localContext = paramViewGroup.getContext();
    OCRTextSearchInfo.SougouSearchInfo localSougouSearchInfo = (OCRTextSearchInfo.SougouSearchInfo)paramListItem.b;
    if (paramView != null)
    {
      paramSearchResultAdapter = (SearchResultAdapter.ListItem)paramView.getTag();
      if ((paramSearchResultAdapter.a == paramListItem.a) && (paramSearchResultAdapter.f == paramListItem.f))
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
      paramView = (ViewGroup)LayoutInflater.from(localContext).inflate(2131627617, paramViewGroup, false);
      ((SearchSougouResultItemBuilder.ViewHolder)localObject).a = paramView;
      ((SearchSougouResultItemBuilder.ViewHolder)localObject).b = ((TextView)paramView.findViewById(2131447463));
      ((SearchSougouResultItemBuilder.ViewHolder)localObject).c = ((TextView)paramView.findViewById(2131427372));
      ((SearchSougouResultItemBuilder.ViewHolder)localObject).d = ((TextView)paramView.findViewById(2131446179));
      ((SearchSougouResultItemBuilder.ViewHolder)localObject).e = ((ImageView)paramView.findViewById(2131435357));
      paramView.setTag(-1, localObject);
    }
    a((SearchSougouResultItemBuilder.ViewHolder)localObject, localSougouSearchInfo);
    paramView.setTag(paramListItem);
    return paramView;
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    this.a = paramViewGroup;
  }
  
  void a(SearchSougouResultItemBuilder.ViewHolder paramViewHolder, OCRTextSearchInfo.SougouSearchInfo paramSougouSearchInfo)
  {
    Object localObject = new HighlightModel(paramSougouSearchInfo.titleKeyWords, null);
    if (!TextUtils.isEmpty(paramSougouSearchInfo.title))
    {
      localObject = ((HighlightModel)localObject).a(paramSougouSearchInfo.title, true);
      if (localObject != null) {
        paramViewHolder.b.setText((CharSequence)localObject);
      }
    }
    localObject = new HighlightModel(paramSougouSearchInfo.abstractStrKeyWords, null);
    if (!TextUtils.isEmpty(paramSougouSearchInfo.abstractStr))
    {
      localObject = ((HighlightModel)localObject).a(HighlightModel.b(paramSougouSearchInfo.abstractStr));
      paramViewHolder.c.setText((CharSequence)localObject);
    }
    try
    {
      if (TextUtils.isEmpty(paramSougouSearchInfo.summaryPic))
      {
        paramViewHolder.e.setVisibility(8);
      }
      else
      {
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = DisplayUtil.a(MobileQQ.sMobileQQ, 80.0F);
        ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = DisplayUtil.a(MobileQQ.sMobileQQ, 60.0F);
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.c;
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.c;
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
          paramViewHolder.e.setVisibility(8);
        }
        else
        {
          paramViewHolder.e.setVisibility(0);
          if (localObject != null) {
            ((URLDrawable)localObject).setURLDrawableListener(new SearchSougouResultItemBuilder.UrlDownloadListener(this));
          }
          paramViewHolder.e.setImageDrawable((Drawable)localObject);
        }
        paramViewHolder.e.setTag(paramSougouSearchInfo.summaryPic);
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
      paramViewHolder.d.setVisibility(8);
      return;
    }
    paramViewHolder.d.setVisibility(0);
    paramViewHolder.d.setText(paramSougouSearchInfo.sourceFrom);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.ui.SearchSougouResultItemBuilder
 * JD-Core Version:    0.7.0.1
 */