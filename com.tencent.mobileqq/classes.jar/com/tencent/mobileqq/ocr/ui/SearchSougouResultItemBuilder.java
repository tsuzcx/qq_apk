package com.tencent.mobileqq.ocr.ui;

import agdj;
import agdl;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.ocr.OCRTextSearchInfo.SougouSearchInfo;
import com.tencent.qphone.base.util.QLog;

public class SearchSougouResultItemBuilder
  extends SearchResultBaseBuilder
{
  public static final Paint a;
  private ColorDrawable a;
  public ViewGroup a;
  
  static
  {
    jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  }
  
  public SearchSougouResultItemBuilder()
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(Color.parseColor("#e7e7e7"));
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup, SearchResultAdapter paramSearchResultAdapter, SearchResultAdapter.ListItem paramListItem)
  {
    Context localContext = paramViewGroup.getContext();
    OCRTextSearchInfo.SougouSearchInfo localSougouSearchInfo = (OCRTextSearchInfo.SougouSearchInfo)paramListItem.jdField_a_of_type_JavaLangObject;
    paramInt = 1;
    if (paramView != null)
    {
      paramSearchResultAdapter = (SearchResultAdapter.ListItem)paramView.getTag();
      if ((paramSearchResultAdapter.jdField_a_of_type_Int == paramListItem.jdField_a_of_type_Int) && (paramSearchResultAdapter.b == paramListItem.b))
      {
        paramSearchResultAdapter = (agdl)paramView.getTag(-1);
        paramInt = 0;
      }
    }
    for (;;)
    {
      Object localObject;
      if (paramInt == 0)
      {
        localObject = paramSearchResultAdapter;
        if (paramSearchResultAdapter != null) {}
      }
      else
      {
        localObject = new agdl(this);
        paramView = (ViewGroup)LayoutInflater.from(localContext).inflate(2130970506, paramViewGroup, false);
        ((agdl)localObject).jdField_a_of_type_AndroidViewViewGroup = paramView;
        ((agdl)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363378));
        ((agdl)localObject).b = ((TextView)paramView.findViewById(2131370911));
        ((agdl)localObject).c = ((TextView)paramView.findViewById(2131370912));
        ((agdl)localObject).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131361846));
        paramView.setTag(-1, localObject);
      }
      a((agdl)localObject, localSougouSearchInfo);
      paramView.setTag(paramListItem);
      return paramView;
      paramSearchResultAdapter = null;
    }
  }
  
  void a(agdl paramagdl, OCRTextSearchInfo.SougouSearchInfo paramSougouSearchInfo)
  {
    Object localObject = new HighlightModel(paramSougouSearchInfo.titleKeyWords, null);
    if (!TextUtils.isEmpty(paramSougouSearchInfo.title))
    {
      localObject = ((HighlightModel)localObject).a(paramSougouSearchInfo.title, true);
      if (localObject != null) {
        paramagdl.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      }
    }
    localObject = new HighlightModel(paramSougouSearchInfo.abstractStrKeyWords, null);
    if (!TextUtils.isEmpty(paramSougouSearchInfo.abstractStr))
    {
      localObject = ((HighlightModel)localObject).a(HighlightModel.a(paramSougouSearchInfo.abstractStr));
      paramagdl.b.setText((CharSequence)localObject);
    }
    try
    {
      if (TextUtils.isEmpty(paramSougouSearchInfo.summaryPic)) {
        paramagdl.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      for (;;)
      {
        if (!TextUtils.isEmpty(paramSougouSearchInfo.sourceFrom)) {
          break label276;
        }
        paramagdl.c.setVisibility(8);
        return;
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
        localObject = URLDrawable.getDrawable(paramSougouSearchInfo.summaryPic, (URLDrawable.URLDrawableOptions)localObject);
        if ((localObject == null) || (((URLDrawable)localObject).getStatus() != 2)) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.e("Q.ocr.SearchSougouResultItemBuilder", 2, "updateNormalItem image fail," + paramSougouSearchInfo);
        }
        paramagdl.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        paramagdl.jdField_a_of_type_AndroidWidgetImageView.setTag(paramSougouSearchInfo.summaryPic);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.ocr.SearchSougouResultItemBuilder", 2, "updateNormalItem", localException);
        }
        localException.printStackTrace();
        continue;
        paramagdl.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        localException.setURLDrawableListener(new agdj(this));
        paramagdl.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localException);
      }
      label276:
      paramagdl.c.setVisibility(0);
      paramagdl.c.setText(paramSougouSearchInfo.sourceFrom);
    }
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.ui.SearchSougouResultItemBuilder
 * JD-Core Version:    0.7.0.1
 */