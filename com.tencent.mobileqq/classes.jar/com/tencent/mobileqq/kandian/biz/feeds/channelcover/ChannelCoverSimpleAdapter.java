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
import com.tencent.mobileqq.kandian.biz.framework.api.impl.ReadInJoyActivityHelper;
import com.tencent.mobileqq.kandian.biz.video.view.ReadInJoyVideoTopicTextView;
import com.tencent.mobileqq.kandian.glue.report.GalleryReportedUtils;
import com.tencent.mobileqq.kandian.glue.viola.ViolaAccessHelper;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ChannelCoverInfo;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ChannelCoverSimpleAdapter
  extends BaseAdapter
  implements View.OnClickListener
{
  private Context a;
  private ArrayList<ChannelCoverInfo> b = new ArrayList();
  private int c;
  
  public ChannelCoverSimpleAdapter(Context paramContext, ArrayList<ChannelCoverInfo> paramArrayList, int paramInt)
  {
    this.a = paramContext;
    this.c = paramInt;
    if (paramArrayList != null)
    {
      this.b.clear();
      paramContext = new ChannelCoverInfo();
      this.b.add(paramContext);
      this.b.addAll(paramArrayList);
      paramContext = new ChannelCoverInfo();
      this.b.add(paramContext);
    }
  }
  
  public ChannelCoverInfo a(int paramInt)
  {
    ArrayList localArrayList = this.b;
    if ((localArrayList != null) && (paramInt < localArrayList.size())) {
      return (ChannelCoverInfo)this.b.get(paramInt);
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
      this.b.clear();
      localObject = new ChannelCoverInfo();
      this.b.add(localObject);
      this.b.addAll(paramArrayList);
      paramArrayList = new ChannelCoverInfo();
      this.b.add(paramArrayList);
    }
  }
  
  public int getCount()
  {
    if (this.b != null)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getCount()");
        localStringBuilder.append(this.b.size());
        QLog.d("READINJOYChannelCoverSimpleAdapter", 2, localStringBuilder.toString());
      }
      return this.b.size();
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
      ArrayList localArrayList = this.b;
      if ((localArrayList == null) || (paramInt != localArrayList.size() - 1)) {
        return 1;
      }
    }
    return 0;
  }
  
  @TargetApi(16)
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1 = this.a.getResources();
    if (getItemViewType(paramInt) == 0)
    {
      paramViewGroup = paramView;
      if (paramView == null)
      {
        paramViewGroup = new View(this.a);
        paramViewGroup.setLayoutParams(new ViewGroup.LayoutParams(AIOUtils.b(2.0F, (Resources)localObject1), AIOUtils.b(30.0F, (Resources)localObject1)));
      }
      return paramViewGroup;
    }
    if (paramView == null)
    {
      paramView = new ChannelCoverSimpleAdapter.SimpleViewHolder(this);
      paramViewGroup = new ReadInJoyVideoTopicTextView(this.a);
      paramViewGroup.setId(2131444260);
      paramViewGroup.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
      paramView.a = paramViewGroup;
      paramViewGroup.setTag(paramView);
    }
    else
    {
      localObject1 = (ChannelCoverSimpleAdapter.SimpleViewHolder)paramView.getTag();
      paramViewGroup = paramView;
      paramView = (View)localObject1;
    }
    localObject1 = (ChannelCoverInfo)this.b.get(paramInt);
    if (localObject1 != null)
    {
      if (((ChannelCoverInfo)localObject1).mColumnType == 1) {
        paramView.a.setTopicText(((ChannelCoverInfo)localObject1).mChannelCoverName);
      } else {
        paramView.a.setSubChannelText(((ChannelCoverInfo)localObject1).mChannelCoverName);
      }
      if (this.c == 56) {
        paramView.a.setTextColor(7566195);
      } else {
        paramView.a.setTextColor(((ChannelCoverInfo)localObject1).mFontColor);
      }
      Object localObject2;
      if (!TextUtils.isEmpty(((ChannelCoverInfo)localObject1).mIconUrl))
      {
        paramInt = ViewUtils.dip2px(21.0F);
        localObject2 = this.a.getResources().getDrawable(2130841253);
        localObject2 = URLDrawable.getDrawable(((ChannelCoverInfo)localObject1).mIconUrl, paramInt, paramInt, (Drawable)localObject2, (Drawable)localObject2);
        if (localObject2 != null)
        {
          if (((URLDrawable)localObject2).getStatus() == 2) {
            ((URLDrawable)localObject2).restartDownload();
          }
          ((URLDrawable)localObject2).setBounds(0, 0, paramInt, paramInt);
        }
        paramView.a.setCompoundDrawables((Drawable)localObject2, null, null, null);
      }
      else
      {
        paramView.a.setCompoundDrawables(null, null, null, null);
      }
      if (!((ChannelCoverInfo)localObject1).isReport)
      {
        ((ChannelCoverInfo)localObject1).isReport = true;
        paramInt = this.c;
        if (paramInt == 56)
        {
          localObject2 = this.a;
          if (((localObject2 instanceof Activity)) && (((Activity)localObject2).getIntent() != null)) {
            paramInt = ((Activity)this.a).getIntent().getIntExtra("channel_from", -1);
          } else {
            paramInt = 0;
          }
          ChannelCoverView.a("0X8007BE5", "1", "", "", (ChannelCoverInfo)localObject1, paramInt);
        }
        else if (RIJFeedsType.a(paramInt))
        {
          GalleryReportedUtils.a(this.a, "0X8009A70", this.c, ((ChannelCoverInfo)localObject1).mChannelCoverId);
        }
        ChannelCoverView.a("0X8007F01", (ChannelCoverInfo)localObject1, ChannelCoverView.b);
      }
      paramView.a.setOnClickListener(this);
      paramView.b = ((ChannelCoverInfo)localObject1);
    }
    return paramViewGroup;
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() != 2131444260) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("READINJOYChannelCoverSimpleAdapter", 2, "click readinjoy_feeds_video_label_textview");
    }
    paramView = ((ChannelCoverSimpleAdapter.SimpleViewHolder)paramView.getTag()).b;
    if (paramView != null)
    {
      Object localObject;
      if (TextUtils.isEmpty(paramView.mChannelJumpUrl))
      {
        localObject = new HashMap();
        ((HashMap)localObject).put("param_key_ariticle_id", Long.valueOf(paramView.mArticleId));
        ((HashMap)localObject).put("param_key_channel_cover_style", Integer.valueOf(paramView.mChannelCoverStyle));
        ((HashMap)localObject).put("param_key_channel_column_type", Integer.valueOf(paramView.mColumnType));
        if (this.c == 56) {
          ReadInJoyActivityHelper.INSTANCE.launchVideoSubChannelActivity(this.a, paramView.mChannelCoverId, paramView.mChannelCoverName, paramView.mChannelType, 4, (Map)localObject);
        } else {
          ReadInJoyActivityHelper.INSTANCE.launchChannelActivity(this.a, paramView.mChannelCoverId, paramView.mChannelCoverName, paramView.mChannelType, 4, (Map)localObject);
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
        if (this.c == 56) {
          ThreadManager.executeOnSubThread(new ChannelCoverSimpleAdapter.1(this, paramView));
        }
      }
      else
      {
        if (ViolaAccessHelper.e(paramView.mChannelJumpUrl))
        {
          ViolaAccessHelper.a(this.a, "", ViolaAccessHelper.f(paramView.mChannelJumpUrl), null);
        }
        else
        {
          localObject = new Intent(this.a, QQBrowserActivity.class);
          ((Intent)localObject).putExtra("url", paramView.mChannelJumpUrl);
          this.a.startActivity((Intent)localObject);
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("info.mChannelJumpUrl:");
          ((StringBuilder)localObject).append(paramView.mChannelJumpUrl);
          QLog.d("READINJOYChannelCoverSimpleAdapter", 2, ((StringBuilder)localObject).toString());
        }
      }
      if (RIJFeedsType.a(this.c)) {
        GalleryReportedUtils.a(this.a, "0X8009A71", this.c, paramView.mChannelCoverId);
      }
      ChannelCoverView.a("0X8007F02", paramView, ChannelCoverView.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.channelcover.ChannelCoverSimpleAdapter
 * JD-Core Version:    0.7.0.1
 */