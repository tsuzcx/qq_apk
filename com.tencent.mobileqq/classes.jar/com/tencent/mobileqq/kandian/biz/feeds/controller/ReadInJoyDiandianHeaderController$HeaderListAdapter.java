package com.tencent.mobileqq.kandian.biz.feeds.controller;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.push.RIJKanDianFolderStatus;
import com.tencent.mobileqq.kandian.repo.comment.entity.DiandianTopConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadInJoyDiandianHeaderController$HeaderListAdapter
  extends BaseAdapter
{
  private int jdField_a_of_type_Int;
  private List<DiandianTopConfig> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  ReadInJoyDiandianHeaderController$HeaderListAdapter(List<DiandianTopConfig> paramList, int paramInt)
  {
    this.jdField_a_of_type_Int = i;
    int j = i * 2;
    int i = j;
    while ((i < paramInt.size()) && (i < j + 2))
    {
      this.jdField_a_of_type_JavaUtilList.add(paramInt.get(i));
      i += 1;
    }
  }
  
  public Object a(int paramInt, DiandianTopConfig paramDiandianTopConfig)
  {
    return this.jdField_a_of_type_JavaUtilList.set(paramInt, paramDiandianTopConfig);
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
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
    Object localObject2 = (DiandianTopConfig)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (paramView == null)
    {
      paramView = new ReadInJoyDiandianHeaderController.ViewHolder(null);
      localObject1 = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560178, null);
      paramView.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)((View)localObject1).findViewById(2131369337));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131379618));
      paramView.b = ((TextView)((View)localObject1).findViewById(2131379620));
      paramView.c = ((TextView)((View)localObject1).findViewById(2131379619));
      paramView.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyDiandianHeaderController$OnItemViewClickListener = new ReadInJoyDiandianHeaderController.OnItemViewClickListener(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyDiandianHeaderController, null);
      ((View)localObject1).setTag(paramView);
      ((View)localObject1).setOnClickListener(paramView.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyDiandianHeaderController$OnItemViewClickListener);
      paramViewGroup = paramView;
      paramView = (View)localObject1;
    }
    else
    {
      paramViewGroup = (ReadInJoyDiandianHeaderController.ViewHolder)paramView.getTag();
    }
    paramViewGroup.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyDiandianHeaderController$OnItemViewClickListener.jdField_a_of_type_Int = (this.jdField_a_of_type_Int * 2 + paramInt);
    Object localObject1 = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyDiandianHeaderController.a;
    ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyDiandianHeaderController.a;
    ((URLDrawable.URLDrawableOptions)localObject1).mPlayGifImage = true;
    localObject1 = URLDrawable.getDrawable(((DiandianTopConfig)localObject2).picUrl, (URLDrawable.URLDrawableOptions)localObject1);
    ((URLDrawable)localObject1).setTag(URLDrawableDecodeHandler.a(DisplayUtil.a(paramView.getContext(), 42.0F), DisplayUtil.a(paramView.getContext(), 42.0F)));
    paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject1);
    if ((((URLDrawable)localObject1).getStatus() != 1) && (((URLDrawable)localObject1).getStatus() != 0)) {
      ((URLDrawable)localObject1).restartDownload();
    }
    if (((DiandianTopConfig)localObject2).type == 3) {
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    } else {
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    paramViewGroup.b.setText(((DiandianTopConfig)localObject2).title);
    if (!TextUtils.isEmpty(((DiandianTopConfig)localObject2).subTitleColor)) {
      try
      {
        paramViewGroup.c.setTextColor(Color.parseColor(((DiandianTopConfig)localObject2).subTitleColor));
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("getView parserColor error color = ");
          localStringBuilder.append(((DiandianTopConfig)localObject2).subTitleColor);
          localStringBuilder.append(" e=");
          localStringBuilder.append(localException.toString());
          QLog.e("ReadInJoyDiandianHeaderController", 2, localStringBuilder.toString());
        }
        paramViewGroup.c.setTextColor(Color.parseColor("#9D9D9D"));
      }
    } else {
      paramViewGroup.c.setTextColor(Color.parseColor("#9D9D9D"));
    }
    paramViewGroup.c.setText(((DiandianTopConfig)localObject2).subTitle);
    if (!ReadInJoyDiandianHeaderController.b(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyDiandianHeaderController)) {
      try
      {
        paramViewGroup = new JSONObject();
        paramViewGroup.put("folder_status", RIJKanDianFolderStatus.reportFolderStatus);
        IPublicAccountReportUtils localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(ReadInJoyDiandianHeaderController.b(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyDiandianHeaderController).size());
        ((StringBuilder)localObject2).append("");
        localIPublicAccountReportUtils.publicAccountReportClickEvent(null, "", "0X80092FB", "0X80092FB", 0, 0, ((StringBuilder)localObject2).toString(), "", "", paramViewGroup.toString(), false);
        ReadInJoyDiandianHeaderController.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyDiandianHeaderController, true);
        return paramView;
      }
      catch (JSONException paramViewGroup)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ReadInJoyDiandianHeaderController", 2, paramViewGroup.toString());
        }
      }
    }
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.controller.ReadInJoyDiandianHeaderController.HeaderListAdapter
 * JD-Core Version:    0.7.0.1
 */