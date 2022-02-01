package com.tencent.mobileqq.kandian.biz.comment.emotion;

import android.view.View;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.emoticon.IEmotionPanelBuilder;
import com.tencent.mobileqq.emoticon.IEmotionTabCreateListener;
import com.tencent.mobileqq.emoticonview.BaseEmotionAdapter;
import com.tencent.mobileqq.kandian.biz.comment.emotion.adapter.RIJCommonEmotionAdapter;
import com.tencent.mobileqq.kandian.biz.comment.emotion.adapter.RIJCommonEmotionAdapterParams;
import java.util.List;

public class RIJEmotionPanelBuilder
  implements IEmotionPanelBuilder, IEmotionTabCreateListener
{
  private RIJCommonEmotionAdapter jdField_a_of_type_ComTencentMobileqqKandianBizCommentEmotionAdapterRIJCommonEmotionAdapter;
  private final RIJCommonEmotionAdapterParams jdField_a_of_type_ComTencentMobileqqKandianBizCommentEmotionAdapterRIJCommonEmotionAdapterParams;
  private final String jdField_a_of_type_JavaLangString;
  private List jdField_a_of_type_JavaUtilList;
  
  public RIJEmotionPanelBuilder(RIJCommonEmotionAdapterParams paramRIJCommonEmotionAdapterParams, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEmotionAdapterRIJCommonEmotionAdapterParams = paramRIJCommonEmotionAdapterParams;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(List paramList)
  {
    RIJCommonEmotionAdapter localRIJCommonEmotionAdapter = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEmotionAdapterRIJCommonEmotionAdapter;
    if (localRIJCommonEmotionAdapter != null)
    {
      localRIJCommonEmotionAdapter.setData(paramList);
      return;
    }
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public BaseEmotionAdapter buildComplete()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEmotionAdapterRIJCommonEmotionAdapter = new RIJCommonEmotionAdapter(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEmotionAdapterRIJCommonEmotionAdapterParams);
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList != null) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEmotionAdapterRIJCommonEmotionAdapter.setData(localList);
    }
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEmotionAdapterRIJCommonEmotionAdapter;
  }
  
  public void buildData() {}
  
  public void buildParams() {}
  
  public void buildView() {}
  
  public void onCreateTabView(View paramView, URLImageView paramURLImageView, ImageView paramImageView, int paramInt)
  {
    paramView = URLDrawable.URLDrawableOptions.obtain();
    paramView = URLDrawable.getDrawable(this.jdField_a_of_type_JavaLangString, paramView);
    paramView.startDownload();
    paramURLImageView.setImageDrawable(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.emotion.RIJEmotionPanelBuilder
 * JD-Core Version:    0.7.0.1
 */