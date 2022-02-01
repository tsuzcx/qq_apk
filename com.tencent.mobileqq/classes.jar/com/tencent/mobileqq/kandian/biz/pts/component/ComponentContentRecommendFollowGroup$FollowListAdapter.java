package com.tencent.mobileqq.kandian.biz.pts.component;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.repo.feeds.GroupRecommendAccount;
import com.tencent.mobileqq.kandian.repo.feeds.RecommendFollowInfos;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.follow.RecommendFollowInfo;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.utils.ImageUtil;
import java.util.HashMap;
import java.util.List;

class ComponentContentRecommendFollowGroup$FollowListAdapter
  extends BaseAdapter
{
  private List<GroupRecommendAccount> jdField_a_of_type_JavaUtilList;
  
  private ComponentContentRecommendFollowGroup$FollowListAdapter(ComponentContentRecommendFollowGroup paramComponentContentRecommendFollowGroup) {}
  
  public void a(List<GroupRecommendAccount> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int j = 0;
    int i;
    Object localObject1;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560264, paramViewGroup, false);
      paramViewGroup = new ComponentContentRecommendFollowGroup.ViewHolder(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentRecommendFollowGroup, null);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367877));
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367080));
      paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131367072));
      paramViewGroup.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131367849));
      paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetRelativeLayout = new RelativeLayout[3];
      paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetImageView = new ImageView[3];
      paramViewGroup.jdField_b_of_type_ArrayOfAndroidWidgetImageView = new ImageView[3];
      paramViewGroup.c = new ImageView[3];
      paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetTextView = new TextView[3];
      i = 0;
      while (i < paramViewGroup.jdField_b_of_type_AndroidWidgetLinearLayout.getChildCount())
      {
        localObject1 = (RelativeLayout)paramViewGroup.jdField_b_of_type_AndroidWidgetLinearLayout.getChildAt(i);
        paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetRelativeLayout[i] = ((RelativeLayout)((RelativeLayout)localObject1).findViewById(2131368067));
        paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetImageView[i] = ((ImageView)((RelativeLayout)localObject1).findViewById(2131368058));
        paramViewGroup.jdField_b_of_type_ArrayOfAndroidWidgetImageView[i] = ((ImageView)((RelativeLayout)localObject1).findViewById(2131380362));
        paramViewGroup.c[i] = ((ImageView)((RelativeLayout)localObject1).findViewById(2131377820));
        paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetTextView[i] = ((TextView)((RelativeLayout)localObject1).findViewById(2131371884));
        paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetRelativeLayout[i].setOnClickListener(paramViewGroup);
        paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetTextView[i].setOnClickListener(paramViewGroup);
        i += 1;
      }
      paramView.setTag(paramViewGroup);
      paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(paramViewGroup);
    }
    else
    {
      paramViewGroup = (ComponentContentRecommendFollowGroup.ViewHolder)paramView.getTag();
    }
    paramViewGroup.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsGroupRecommendAccount = ((GroupRecommendAccount)this.jdField_a_of_type_JavaUtilList.get(paramInt));
    paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(paramViewGroup.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsGroupRecommendAccount.jdField_a_of_type_JavaLangString);
    paramInt = 0;
    while (paramInt < paramViewGroup.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsGroupRecommendAccount.jdField_a_of_type_JavaUtilList.size())
    {
      localObject1 = (RecommendFollowInfo)paramViewGroup.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsGroupRecommendAccount.jdField_a_of_type_JavaUtilList.get(paramInt);
      paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetTextView[paramInt].setText(((RecommendFollowInfo)localObject1).nickName);
      paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetTextView[paramInt].setTag(localObject1);
      paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetRelativeLayout[paramInt].setTag(localObject1);
      if (!TextUtils.isEmpty(((RecommendFollowInfo)localObject1).headUrl))
      {
        localObject2 = URLDrawable.URLDrawableOptions.obtain();
        Drawable localDrawable = ImageUtil.e();
        ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = localDrawable;
        ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = localDrawable;
        localObject2 = URLDrawable.getDrawable(((RecommendFollowInfo)localObject1).headUrl, (URLDrawable.URLDrawableOptions)localObject2);
        ((URLDrawable)localObject2).setDecodeHandler(URLDrawableDecodeHandler.a);
        ((URLDrawable)localObject2).setFadeInImage(true);
        paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetImageView[paramInt].setImageDrawable((Drawable)localObject2);
      }
      else
      {
        paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetImageView[paramInt].setImageDrawable(ImageUtil.e());
      }
      Object localObject2 = paramViewGroup.jdField_b_of_type_ArrayOfAndroidWidgetImageView[paramInt];
      boolean bool = ((RecommendFollowInfo)localObject1).isVip;
      int k = 8;
      if (bool) {
        i = 0;
      } else {
        i = 8;
      }
      ((ImageView)localObject2).setVisibility(i);
      localObject2 = paramViewGroup.c[paramInt];
      i = k;
      if (((RecommendFollowInfo)localObject1).isStar) {
        i = 0;
      }
      ((ImageView)localObject2).setVisibility(i);
      ComponentContentRecommendFollowGroup.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentRecommendFollowGroup).mRecommendFollowInfos.a.put(Long.valueOf(((RecommendFollowInfo)localObject1).uin), localObject1);
      paramInt += 1;
    }
    paramInt = 0;
    while (paramInt < paramViewGroup.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsGroupRecommendAccount.jdField_a_of_type_JavaUtilList.size())
    {
      if (!((RecommendFollowInfo)paramViewGroup.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsGroupRecommendAccount.jdField_a_of_type_JavaUtilList.get(paramInt)).isFollowed)
      {
        paramInt = j;
        break label646;
      }
      paramInt += 1;
    }
    paramInt = 1;
    label646:
    if (paramInt != 0)
    {
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131702441));
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-8947849);
      paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130849733);
      return paramView;
    }
    paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131702476));
    paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
    paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130849689);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentRecommendFollowGroup.FollowListAdapter
 * JD-Core Version:    0.7.0.1
 */