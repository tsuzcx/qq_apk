package com.tencent.mobileqq.kandian.biz.tab;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.util.StateSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.kandian.biz.feeds.channelcover.ChannelCoverView;
import com.tencent.mobileqq.kandian.biz.framework.api.impl.ReadInJoyActivityHelper;
import com.tencent.mobileqq.kandian.glue.viola.ViolaAccessHelper;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ChannelCoverInfo;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReadInJoyNavigationAdapter
  extends BaseAdapter
  implements View.OnClickListener
{
  public final int a = -9387998;
  public int b = -13879999;
  public int c = -723466;
  private Context d;
  private List<ChannelCoverInfo> e;
  private ReadInJoyNavigationAdapter.ChannelButtonListener f;
  
  public ReadInJoyNavigationAdapter(Context paramContext)
  {
    this.d = paramContext;
    this.e = new ArrayList();
  }
  
  private void a(View paramView, int paramInt)
  {
    GradientDrawable localGradientDrawable1 = new GradientDrawable();
    localGradientDrawable1.setShape(0);
    localGradientDrawable1.setCornerRadius(ViewUtils.dip2px(17.0F));
    localGradientDrawable1.setColor(-723466);
    localGradientDrawable1.setStroke(1, paramInt);
    GradientDrawable localGradientDrawable2 = new GradientDrawable();
    localGradientDrawable2.setShape(0);
    localGradientDrawable2.setCornerRadius(ViewUtils.dip2px(17.0F));
    localGradientDrawable2.setColor(-2697514);
    localGradientDrawable2.setStroke(1, paramInt);
    StateListDrawable localStateListDrawable = new StateListDrawable();
    localStateListDrawable.addState(new int[] { 16842919 }, localGradientDrawable2);
    localStateListDrawable.addState(StateSet.WILD_CARD, localGradientDrawable1);
    paramView.setBackgroundDrawable(localStateListDrawable);
  }
  
  private List<ChannelCoverInfo> b(List<ChannelCoverInfo> paramList)
  {
    Object localObject = paramList;
    if (paramList != null)
    {
      localObject = paramList;
      if (paramList.size() > 28) {
        localObject = paramList.subList(0, 28);
      }
    }
    return localObject;
  }
  
  public void a(ReadInJoyNavigationAdapter.ChannelButtonListener paramChannelButtonListener)
  {
    this.f = paramChannelButtonListener;
  }
  
  public void a(List<ChannelCoverInfo> paramList)
  {
    this.e.clear();
    this.e.addAll(b(paramList));
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyNavigationAdapter", 2, new Object[] { "mChannels size: ", Integer.valueOf(this.e.size()) });
    }
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    List localList = this.e;
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return this.e.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = new ReadInJoyNavigationAdapter.ViewHolder(this, null);
      paramViewGroup = LayoutInflater.from(this.d).inflate(2131626289, paramViewGroup, false);
      paramView.a = paramViewGroup.findViewById(2131431280);
      paramView.b = ((TextView)paramViewGroup.findViewById(2131446778));
      paramViewGroup.setTag(paramView);
    }
    else
    {
      localObject = (ReadInJoyNavigationAdapter.ViewHolder)paramView.getTag();
      paramViewGroup = paramView;
      paramView = (View)localObject;
    }
    Object localObject = (ChannelCoverInfo)this.e.get(paramInt);
    if (localObject != null)
    {
      paramView.b.setText(((ChannelCoverInfo)localObject).mChannelCoverName);
      int j = 14;
      int i = 5;
      paramInt = 12;
      if (DeviceInfoUtil.H() < 1080L)
      {
        i = 4;
        paramInt = 11;
      }
      if (paramView.b.length() >= i) {
        j = paramInt;
      }
      float f1 = FontSettingManager.getFontLevel() / 16.0F;
      paramView.b.setTextSize(j / f1);
      paramView.b.setTextColor(((ChannelCoverInfo)localObject).mFontColor);
      a(paramView.a, this.c);
      if (TextUtils.isEmpty(((ChannelCoverInfo)localObject).mIconUrl))
      {
        paramView.a.setPadding(ViewUtils.dip2px(8.0F), 0, ViewUtils.dip2px(8.0F), 0);
        paramView.b.setCompoundDrawables(null, null, null, null);
        paramView.b.setGravity(17);
      }
      if (!((ChannelCoverInfo)localObject).isReport)
      {
        ((ChannelCoverInfo)localObject).isReport = true;
        ChannelCoverView.a("0X8007F01", (ChannelCoverInfo)localObject, ChannelCoverView.b);
      }
      paramView.a.setTag(localObject);
      paramView.a.setOnClickListener(this);
    }
    return paramViewGroup;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() != 2131431280) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyNavigationAdapter", 2, "click container");
    }
    ChannelCoverInfo localChannelCoverInfo = (ChannelCoverInfo)paramView.getTag();
    if (localChannelCoverInfo != null)
    {
      Object localObject;
      if (TextUtils.isEmpty(localChannelCoverInfo.mChannelJumpUrl))
      {
        localObject = new HashMap();
        ((HashMap)localObject).put("param_key_ariticle_id", Long.valueOf(localChannelCoverInfo.mArticleId));
        ((HashMap)localObject).put("param_key_channel_cover_style", Integer.valueOf(localChannelCoverInfo.mChannelCoverStyle));
        ReadInJoyActivityHelper.INSTANCE.launchChannelActivity(this.d, localChannelCoverInfo.mChannelCoverId, localChannelCoverInfo.mChannelCoverName, localChannelCoverInfo.mChannelType, 4, (Map)localObject);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("launchChannelActivity info.mArticleId:");
          ((StringBuilder)localObject).append(localChannelCoverInfo.mArticleId);
          ((StringBuilder)localObject).append(" info.mChannelCoverStyle: ");
          ((StringBuilder)localObject).append(localChannelCoverInfo.mChannelCoverStyle);
          ((StringBuilder)localObject).append(" info.mChannelCoverId:");
          ((StringBuilder)localObject).append(localChannelCoverInfo.mChannelCoverId);
          ((StringBuilder)localObject).append(" info.mChannelCoverName:");
          ((StringBuilder)localObject).append(localChannelCoverInfo.mChannelCoverName);
          ((StringBuilder)localObject).append(" info.mChannelType: ");
          ((StringBuilder)localObject).append(localChannelCoverInfo.mChannelType);
          QLog.d("ReadInJoyNavigationAdapter", 2, ((StringBuilder)localObject).toString());
        }
      }
      else
      {
        if (ViolaAccessHelper.e(localChannelCoverInfo.mChannelJumpUrl))
        {
          ViolaAccessHelper.a(this.d, "", localChannelCoverInfo.mChannelJumpUrl, null);
        }
        else
        {
          localObject = new Intent(this.d, QQBrowserActivity.class);
          ((Intent)localObject).putExtra("url", localChannelCoverInfo.mChannelJumpUrl);
          this.d.startActivity((Intent)localObject);
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("info.mChannelJumpUrl:");
          ((StringBuilder)localObject).append(localChannelCoverInfo.mChannelJumpUrl);
          QLog.d("ReadInJoyNavigationAdapter", 2, ((StringBuilder)localObject).toString());
        }
      }
      ChannelCoverView.a("0X8007F02", localChannelCoverInfo, ChannelCoverView.b);
    }
    if ((this.f != null) && ((paramView.getTag() instanceof ChannelCoverInfo))) {
      this.f.a((ChannelCoverInfo)paramView.getTag());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.tab.ReadInJoyNavigationAdapter
 * JD-Core Version:    0.7.0.1
 */