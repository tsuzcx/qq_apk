package com.tencent.mobileqq.profilecard.bussiness.achievement.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView.Adapter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.profilecard.bussiness.achievement.LifeAchivementHelper;
import com.tencent.mobileqq.profilecard.bussiness.achievement.bean.LifeAchivementData;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AlphaClickableTextView;
import java.util.ArrayList;
import java.util.List;

public class LifeAchivementAdapter
  extends RecyclerView.Adapter<LifeAchivementAdapter.ViewHolder>
{
  static final String TAG = "LifeAchivementAdapter";
  Context context;
  List<LifeAchivementData> dataList = new ArrayList();
  LifeAchivementAdapter.OnItemClickListener itemClickListener;
  
  public LifeAchivementAdapter(Context paramContext, List<LifeAchivementData> paramList, LifeAchivementAdapter.OnItemClickListener paramOnItemClickListener)
  {
    this.context = paramContext;
    if (paramList != null) {
      this.dataList = paramList;
    }
    this.itemClickListener = paramOnItemClickListener;
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("LifeAchivementAdapter itemClickListener = ");
      paramContext.append(this.itemClickListener);
      paramContext.append(",listener = ");
      paramContext.append(paramOnItemClickListener);
      QLog.i("LifeAchivementAdapter", 2, paramContext.toString());
    }
  }
  
  private void update(LifeAchivementAdapter.ViewHolder paramViewHolder, LifeAchivementData paramLifeAchivementData)
  {
    Object localObject;
    if (!TextUtils.isEmpty(paramLifeAchivementData.iconUrl))
    {
      localObject = URLDrawable.getDrawable(paramLifeAchivementData.iconUrl, null);
      if ((localObject != null) && (1 != ((URLDrawable)localObject).getStatus()))
      {
        ((URLDrawable)localObject).setAutoDownload(true);
        ((URLDrawable)localObject).startDownload(true);
      }
      paramViewHolder.imageview.setImageDrawable((Drawable)localObject);
    }
    if (paramLifeAchivementData.type == 2)
    {
      paramViewHolder.moreNum.setVisibility(0);
      localObject = paramViewHolder.moreNum;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("+");
      localStringBuilder.append(paramLifeAchivementData.moreNum);
      ((TextView)localObject).setText(localStringBuilder.toString());
      paramViewHolder.praiseCount.setVisibility(4);
    }
    else if (paramLifeAchivementData.type == 1)
    {
      paramViewHolder.moreNum.setVisibility(4);
      paramViewHolder.praiseCount.setVisibility(4);
    }
    else
    {
      paramViewHolder.moreNum.setVisibility(4);
      paramViewHolder.praiseCount.setVisibility(0);
      updatePraiseUI(paramViewHolder.praiseCount, paramLifeAchivementData.hasPraised, paramLifeAchivementData.praiseNum);
    }
    paramViewHolder.content.setText(paramLifeAchivementData.title);
  }
  
  private void updatePraiseUI(TextView paramTextView, boolean paramBoolean, int paramInt)
  {
    paramTextView.setText(LifeAchivementHelper.formatPraiseNum(paramInt));
    if (paramBoolean) {
      paramInt = 2130847452;
    } else {
      paramInt = 2130847451;
    }
    Drawable localDrawable = paramTextView.getResources().getDrawable(paramInt);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    paramTextView.setCompoundDrawables(localDrawable, null, null, null);
    paramTextView.setCompoundDrawablePadding(Utils.a(2.0F, paramTextView.getResources()));
  }
  
  public LifeAchivementData getDataByPosition(int paramInt)
  {
    List localList = this.dataList;
    if ((localList != null) && (paramInt < localList.size())) {
      return (LifeAchivementData)this.dataList.get(paramInt);
    }
    return null;
  }
  
  public int getItemCount()
  {
    List localList = this.dataList;
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
  
  public void onBindViewHolder(LifeAchivementAdapter.ViewHolder paramViewHolder, int paramInt)
  {
    update(paramViewHolder, (LifeAchivementData)this.dataList.get(paramInt));
    paramViewHolder.imageview.setOnClickListener(new LifeAchivementAdapter.1(this, paramInt));
    paramViewHolder.praiseCount.setOnClickListener(new LifeAchivementAdapter.2(this, paramInt));
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
  
  public LifeAchivementAdapter.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return new LifeAchivementAdapter.ViewHolder(LayoutInflater.from(this.context).inflate(2131627690, paramViewGroup, false));
  }
  
  public void updateDatas(List<LifeAchivementData> paramList, int paramInt, boolean paramBoolean)
  {
    if (paramList != null)
    {
      this.dataList.clear();
      if (paramInt > 10)
      {
        this.dataList.addAll(paramList.subList(0, 10));
        paramList = new LifeAchivementData();
        paramList.title = this.context.getResources().getString(2131896972);
        paramList.iconUrl = "https://downv6.qq.com/qq_relation/life_achivement/default_badge_v2.png";
        paramList.moreNum = (paramInt - 10);
        paramList.type = 2;
        this.dataList.add(paramList);
      }
      else
      {
        this.dataList.addAll(paramList);
      }
      if (paramBoolean)
      {
        paramList = new LifeAchivementData();
        paramList.title = this.context.getResources().getString(2131896966);
        paramList.iconUrl = "https://downv6.qq.com/qq_relation/life_achivement/add_badge_v2.png";
        paramList.type = 1;
        this.dataList.add(0, paramList);
      }
      notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.achievement.view.LifeAchivementAdapter
 * JD-Core Version:    0.7.0.1
 */