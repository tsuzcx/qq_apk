package com.tencent.mobileqq.qqexpand.feed;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.api.data.SimpleMiniAppConfig;
import com.tencent.mobileqq.mini.api.data.SimpleMiniAppConfig.SimpleMiniAppInfo;
import com.tencent.mobileqq.qqexpand.bean.feed.MiniAppRecommInfo.MiniApp;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.widget.ThemeImageView;
import com.tencent.widget.ThemeImageWrapper;
import java.lang.ref.WeakReference;

class MiniAppRecommViewHolder$MicroAppViewHolder
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  int jdField_a_of_type_Int;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  MiniAppRecommInfo.MiniApp jdField_a_of_type_ComTencentMobileqqQqexpandBeanFeedMiniAppRecommInfo$MiniApp;
  private final WeakReference<Activity> jdField_a_of_type_JavaLangRefWeakReference;
  
  public MiniAppRecommViewHolder$MicroAppViewHolder(Activity paramActivity, View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131371377));
    paramActivity = this.jdField_a_of_type_AndroidWidgetImageView;
    if ((paramActivity instanceof ThemeImageView)) {
      ((ThemeImageView)paramActivity).setMaskShape(ThemeImageWrapper.MODE_OTHER);
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371380));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(MiniAppRecommInfo.MiniApp paramMiniApp)
  {
    if (paramMiniApp == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqQqexpandBeanFeedMiniAppRecommInfo$MiniApp = paramMiniApp;
    Drawable localDrawable = ((IMiniAppService)QRoute.api(IMiniAppService.class)).getIcon(this.jdField_a_of_type_AndroidWidgetImageView.getContext(), paramMiniApp.c, true, 2130841201, 48);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localDrawable);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramMiniApp.b);
  }
  
  public void onClick(View paramView)
  {
    paramView = this.jdField_a_of_type_ComTencentMobileqqQqexpandBeanFeedMiniAppRecommInfo$MiniApp;
    if ((paramView != null) && (paramView.jdField_a_of_type_NS_MINI_INTERFACEINTERFACE$StApiAppInfo != null))
    {
      paramView = new SimpleMiniAppConfig(SimpleMiniAppConfig.SimpleMiniAppInfo.from(this.jdField_a_of_type_ComTencentMobileqqQqexpandBeanFeedMiniAppRecommInfo$MiniApp.jdField_a_of_type_NS_MINI_INTERFACEINTERFACE$StApiAppInfo));
      paramView.launchParam.scene = 2065;
      ((IMiniAppService)QRoute.api(IMiniAppService.class)).startApp((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get(), paramView, null);
      MiniAppRecommViewHolder.a(102, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqQqexpandBeanFeedMiniAppRecommInfo$MiniApp.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.feed.MiniAppRecommViewHolder.MicroAppViewHolder
 * JD-Core Version:    0.7.0.1
 */