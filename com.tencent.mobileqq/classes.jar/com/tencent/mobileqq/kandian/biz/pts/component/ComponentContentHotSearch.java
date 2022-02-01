package com.tencent.mobileqq.kandian.biz.pts.component;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.kandian.biz.config.IReadInJoySearchJumpUrlConfBean;
import com.tencent.mobileqq.kandian.biz.config.api.IReadInJoySearchJumpUrlConfProcessor;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.repo.feeds.HotWordInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.mobileqq.widget.MeasureGridView;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class ComponentContentHotSearch
  extends RelativeLayout
  implements ComponentInheritView
{
  public static final String a = "ComponentContentHotSearch";
  public static String b;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private ReadInJoyBaseAdapter jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter;
  private ComponentContentHotSearch.HotWordsAdapter jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentHotSearch$HotWordsAdapter;
  private ComponentNotIntrest jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentNotIntrest;
  private AbsBaseArticleInfo jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
  private IReadInJoyModel jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel;
  private MeasureGridView jdField_a_of_type_ComTencentMobileqqWidgetMeasureGridView;
  
  public ComponentContentHotSearch(Context paramContext, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter = paramReadInJoyBaseAdapter;
    a(paramContext);
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131560127, this, true);
  }
  
  public void a(Context paramContext)
  {
    a(a(paramContext));
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131368297));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131378828));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentNotIntrest = ((ComponentNotIntrest)paramView.findViewById(2131371954));
    this.jdField_a_of_type_ComTencentMobileqqWidgetMeasureGridView = ((MeasureGridView)paramView.findViewById(2131368296));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentHotSearch$HotWordsAdapter = new ComponentContentHotSearch.HotWordsAdapter(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetMeasureGridView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentHotSearch$HotWordsAdapter);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new ComponentContentHotSearch.1(this));
  }
  
  public void a(FeedItemCell.CellListener paramCellListener)
  {
    ComponentNotIntrest localComponentNotIntrest = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentNotIntrest;
    if (localComponentNotIntrest != null) {
      localComponentNotIntrest.a(paramCellListener);
    }
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof IReadInJoyModel))
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel = ((IReadInJoyModel)paramObject);
      this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.a();
      paramObject = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
      if (paramObject == null) {
        return;
      }
      paramObject = paramObject.hotWordInfo;
      if ((paramObject != null) && (paramObject.a != null) && (paramObject.a.size() > 0))
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentHotSearch$HotWordsAdapter.a(paramObject.a);
        paramObject = ((IReadInJoySearchJumpUrlConfProcessor)QRoute.api(IReadInJoySearchJumpUrlConfProcessor.class)).getConfig();
        if ((paramObject != null) && (!TextUtils.isEmpty(paramObject.b()))) {
          paramObject = paramObject.b();
        } else {
          paramObject = "https://pub.idqqimg.com/pc/misc/files/20180903/eddc885537fc4606a66c93a06854511b.png";
        }
        Drawable localDrawable = URLDrawableHelperConstants.a;
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mFailedDrawable = localDrawable;
        localURLDrawableOptions.mLoadingDrawable = localDrawable;
        localURLDrawableOptions.mRequestWidth = this.jdField_a_of_type_ComTencentImageURLImageView.getWidth();
        localURLDrawableOptions.mRequestHeight = this.jdField_a_of_type_ComTencentImageURLImageView.getHeight();
        paramObject = URLDrawable.getDrawable(paramObject, localURLDrawableOptions);
        this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramObject);
        if ((paramObject.getStatus() != 1) && (paramObject.getStatus() != 0)) {
          paramObject.restartDownload();
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "bindData hotWordInfo is null or hotWordItems is null ");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentHotSearch
 * JD-Core Version:    0.7.0.1
 */