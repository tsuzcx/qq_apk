package com.tencent.mobileqq.kandian.biz.feeds.channelcover;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyActivityHelper;
import com.tencent.mobileqq.kandian.biz.video.view.ReadInJoyVideoTopicTextView;
import com.tencent.mobileqq.kandian.glue.report.GalleryReportedUtils;
import com.tencent.mobileqq.kandian.glue.viola.ViolaAccessHelper;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ChannelCoverInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ChannelCoverSimpleAdapter
  extends BaseAdapter
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private ArrayList<ChannelCoverInfo> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public ChannelCoverSimpleAdapter(Context paramContext, ArrayList<ChannelCoverInfo> paramArrayList, int paramInt)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
    if (paramArrayList != null)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      paramContext = new ChannelCoverInfo();
      this.jdField_a_of_type_JavaUtilArrayList.add(paramContext);
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
      paramContext = new ChannelCoverInfo();
      this.jdField_a_of_type_JavaUtilArrayList.add(paramContext);
    }
  }
  
  public ChannelCoverInfo a(int paramInt)
  {
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if ((localArrayList != null) && (paramInt < localArrayList.size())) {
      return (ChannelCoverInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    }
    return null;
  }
  
  public void a(ArrayList<ChannelCoverInfo> paramArrayList)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setData size");
      ((StringBuilder)localObject).append(paramArrayList.size());
      QLog.d("READINJOYChannelCoverSimpleAdapter", 2, ((StringBuilder)localObject).toString());
    }
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      localObject = new ChannelCoverInfo();
      this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
      paramArrayList = new ChannelCoverInfo();
      this.jdField_a_of_type_JavaUtilArrayList.add(paramArrayList);
    }
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getCount()");
        localStringBuilder.append(this.jdField_a_of_type_JavaUtilArrayList.size());
        QLog.d("READINJOYChannelCoverSimpleAdapter", 2, localStringBuilder.toString());
      }
      return this.jdField_a_of_type_JavaUtilArrayList.size();
    }
    return 0;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt != 0)
    {
      ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
      if ((localArrayList == null) || (paramInt != localArrayList.size() - 1)) {
        return 1;
      }
    }
    return 0;
  }
  
  @TargetApi(16)
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources();
    if (getItemViewType(paramInt) == 0)
    {
      paramViewGroup = paramView;
      if (paramView == null)
      {
        paramViewGroup = new View(this.jdField_a_of_type_AndroidContentContext);
        paramViewGroup.setLayoutParams(new ViewGroup.LayoutParams(AIOUtils.b(2.0F, (Resources)localObject1), AIOUtils.b(30.0F, (Resources)localObject1)));
      }
      return paramViewGroup;
    }
    if (paramView == null)
    {
      paramView = new ChannelCoverSimpleAdapter.SimpleViewHolder(this);
      paramViewGroup = new ReadInJoyVideoTopicTextView(this.jdField_a_of_type_AndroidContentContext);
      paramViewGroup.setId(2131376060);
      paramViewGroup.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
      paramView.jdField_a_of_type_ComTencentMobileqqKandianBizVideoViewReadInJoyVideoTopicTextView = paramViewGroup;
      paramViewGroup.setTag(paramView);
    }
    else
    {
      localObject1 = (ChannelCoverSimpleAdapter.SimpleViewHolder)paramView.getTag();
      paramViewGroup = paramView;
      paramView = (View)localObject1;
    }
    localObject1 = (ChannelCoverInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    if (localObject1 != null)
    {
      if (((ChannelCoverInfo)localObject1).mColumnType == 1) {
        paramView.jdField_a_of_type_ComTencentMobileqqKandianBizVideoViewReadInJoyVideoTopicTextView.setTopicText(((ChannelCoverInfo)localObject1).mChannelCoverName);
      } else {
        paramView.jdField_a_of_type_ComTencentMobileqqKandianBizVideoViewReadInJoyVideoTopicTextView.setSubChannelText(((ChannelCoverInfo)localObject1).mChannelCoverName);
      }
      if (this.jdField_a_of_type_Int == 56) {
        paramView.jdField_a_of_type_ComTencentMobileqqKandianBizVideoViewReadInJoyVideoTopicTextView.setTextColor(7566195);
      } else {
        paramView.jdField_a_of_type_ComTencentMobileqqKandianBizVideoViewReadInJoyVideoTopicTextView.setTextColor(((ChannelCoverInfo)localObject1).mFontColor);
      }
      Object localObject2;
      if (!TextUtils.isEmpty(((ChannelCoverInfo)localObject1).mIconUrl))
      {
        paramInt = ViewUtils.a(21.0F);
        localObject2 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840491);
        localObject2 = URLDrawable.getDrawable(((ChannelCoverInfo)localObject1).mIconUrl, paramInt, paramInt, (Drawable)localObject2, (Drawable)localObject2);
        if (localObject2 != null)
        {
          if (((URLDrawable)localObject2).getStatus() == 2) {
            ((URLDrawable)localObject2).restartDownload();
          }
          ((URLDrawable)localObject2).setBounds(0, 0, paramInt, paramInt);
        }
        paramView.jdField_a_of_type_ComTencentMobileqqKandianBizVideoViewReadInJoyVideoTopicTextView.setCompoundDrawables((Drawable)localObject2, null, null, null);
      }
      else
      {
        paramView.jdField_a_of_type_ComTencentMobileqqKandianBizVideoViewReadInJoyVideoTopicTextView.setCompoundDrawables(null, null, null, null);
      }
      if (!((ChannelCoverInfo)localObject1).isReport)
      {
        ((ChannelCoverInfo)localObject1).isReport = true;
        paramInt = this.jdField_a_of_type_Int;
        if (paramInt == 56)
        {
          localObject2 = this.jdField_a_of_type_AndroidContentContext;
          if (((localObject2 instanceof Activity)) && (((Activity)localObject2).getIntent() != null)) {
            paramInt = ((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent().getIntExtra("channel_from", -1);
          } else {
            paramInt = 0;
          }
          ChannelCoverView.a("0X8007BE5", "1", "", "", (ChannelCoverInfo)localObject1, paramInt);
        }
        else if (RIJFeedsType.a(paramInt))
        {
          GalleryReportedUtils.a(this.jdField_a_of_type_AndroidContentContext, "0X8009A70", this.jdField_a_of_type_Int, ((ChannelCoverInfo)localObject1).mChannelCoverId);
        }
        ChannelCoverView.a("0X8007F01", (ChannelCoverInfo)localObject1, ChannelCoverView.b);
      }
      paramView.jdField_a_of_type_ComTencentMobileqqKandianBizVideoViewReadInJoyVideoTopicTextView.setOnClickListener(this);
      paramView.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityChannelCoverInfo = ((ChannelCoverInfo)localObject1);
    }
    return paramViewGroup;
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() != 2131376060) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("READINJOYChannelCoverSimpleAdapter", 2, "click readinjoy_feeds_video_label_textview");
    }
    paramView = ((ChannelCoverSimpleAdapter.SimpleViewHolder)paramView.getTag()).jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityChannelCoverInfo;
    if (paramView != null)
    {
      Object localObject;
      if (TextUtils.isEmpty(paramView.mChannelJumpUrl))
      {
        localObject = new HashMap();
        ((HashMap)localObject).put("param_key_ariticle_id", Long.valueOf(paramView.mArticleId));
        ((HashMap)localObject).put("param_key_channel_cover_style", Integer.valueOf(paramView.mChannelCoverStyle));
        ((HashMap)localObject).put("param_key_channel_column_type", Integer.valueOf(paramView.mColumnType));
        if (this.jdField_a_of_type_Int == 56) {
          ((IReadInJoyActivityHelper)QRoute.api(IReadInJoyActivityHelper.class)).launchVideoSubChannelActivity(this.jdField_a_of_type_AndroidContentContext, paramView.mChannelCoverId, paramView.mChannelCoverName, paramView.mChannelType, 4, (Map)localObject);
        } else {
          ((IReadInJoyActivityHelper)QRoute.api(IReadInJoyActivityHelper.class)).launchChannelActivity(this.jdField_a_of_type_AndroidContentContext, paramView.mChannelCoverId, paramView.mChannelCoverName, paramView.mChannelType, 4, (Map)localObject);
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("launchChannelActivity info.mArticleId:");
          ((StringBuilder)localObject).append(paramView.mArticleId);
          ((StringBuilder)localObject).append(" info.mChannelCoverStyle: ");
          ((StringBuilder)localObject).append(paramView.mChannelCoverStyle);
          ((StringBuilder)localObject).append(" info.mChannelCoverId:");
          ((StringBuilder)localObject).append(paramView.mChannelCoverId);
          ((StringBuilder)localObject).append(" info.mChannelCoverName:");
          ((StringBuilder)localObject).append(paramView.mChannelCoverName);
          ((StringBuilder)localObject).append(" info.mChannelType: ");
          ((StringBuilder)localObject).append(paramView.mChannelType);
          QLog.d("READINJOYChannelCoverSimpleAdapter", 2, ((StringBuilder)localObject).toString());
        }
        if (this.jdField_a_of_type_Int == 56) {
          ThreadManager.executeOnSubThread(new ChannelCoverSimpleAdapter.1(this, paramView));
        }
      }
      else
      {
        if (ViolaAccessHelper.c(paramView.mChannelJumpUrl))
        {
          ViolaAccessHelper.a(this.jdField_a_of_type_AndroidContentContext, "", ViolaAccessHelper.c(paramView.mChannelJumpUrl), null);
        }
        else
        {
          localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
          ((Intent)localObject).putExtra("url", paramView.mChannelJumpUrl);
          this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("info.mChannelJumpUrl:");
          ((StringBuilder)localObject).append(paramView.mChannelJumpUrl);
          QLog.d("READINJOYChannelCoverSimpleAdapter", 2, ((StringBuilder)localObject).toString());
        }
      }
      if (RIJFeedsType.a(this.jdField_a_of_type_Int)) {
        GalleryReportedUtils.a(this.jdField_a_of_type_AndroidContentContext, "0X8009A71", this.jdField_a_of_type_Int, paramView.mChannelCoverId);
      }
      ChannelCoverView.a("0X8007F02", paramView, ChannelCoverView.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.channelcover.ChannelCoverSimpleAdapter
 * JD-Core Version:    0.7.0.1
 */