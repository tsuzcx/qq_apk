package com.tencent.mobileqq.profilecard.bussiness.troop.fansinfo;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.utils.FansTroopUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class IdolAdapter
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  private static final String TAG = "idolAdapter";
  private Context mContext;
  private IdolAdapter.IdolAdapterCallBack mIdolAdapterCb;
  private List<TroopFansInfo.IdolItem> mIdolItems = new ArrayList();
  private boolean mIsNight = false;
  private String troopUin;
  
  public IdolAdapter(Context paramContext, String paramString, IdolAdapter.IdolAdapterCallBack paramIdolAdapterCallBack)
  {
    this.mContext = paramContext;
    this.troopUin = paramString;
    this.mIdolAdapterCb = paramIdolAdapterCallBack;
    this.mIsNight = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
  }
  
  protected void clickItem(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < getItemCount()))
    {
      TroopFansInfo.IdolItem localIdolItem = (TroopFansInfo.IdolItem)this.mIdolItems.get(paramInt);
      FansTroopUtils.a(this.mContext, localIdolItem.idolid, this.troopUin);
      ReportController.b(null, "dc00898", "", "", "0X800B598", "0X800B598", 0, 0, "", "", "", "");
      if (this.mIdolAdapterCb != null) {
        this.mIdolAdapterCb.gotoWeb();
      }
    }
  }
  
  public int getItemCount()
  {
    return this.mIdolItems.size();
  }
  
  public List<TroopFansInfo.IdolItem> getList()
  {
    return this.mIdolItems;
  }
  
  protected String getQScoreText(long paramLong)
  {
    if (paramLong < 10000L) {
      return String.valueOf(paramLong);
    }
    if (paramLong < 1000000L)
    {
      String str2 = String.format("%.2f", new Object[] { Double.valueOf((float)paramLong / 10000.0F - 0.005D) });
      String str1 = str2;
      if (str2.length() > 2)
      {
        str1 = str2;
        if (str2.substring(str2.length() - 2).equals("00")) {
          str1 = str2.substring(0, str2.length() - 3);
        }
      }
      return str1 + this.mContext.getString(2131699376);
    }
    return String.valueOf(paramLong / 10000L) + this.mContext.getString(2131699376);
  }
  
  protected String getRankText(long paramLong)
  {
    if (paramLong <= 0L) {
      return this.mContext.getString(2131699456);
    }
    return String.format(this.mContext.getString(2131699372), new Object[] { String.valueOf(paramLong) });
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    IdolAdapter.MyViewHolder localMyViewHolder = (IdolAdapter.MyViewHolder)paramViewHolder;
    TroopFansInfo.IdolItem localIdolItem = (TroopFansInfo.IdolItem)this.mIdolItems.get(paramInt);
    if (localIdolItem != null)
    {
      URLDrawable localURLDrawable = URLDrawable.getDrawable(localIdolItem.pic, null);
      if ((localURLDrawable != null) && (1 != localURLDrawable.getStatus())) {
        localURLDrawable.restartDownload();
      }
      localMyViewHolder.ivHead.setImageDrawable(localURLDrawable);
      if (this.mIdolAdapterCb != null) {
        this.mIdolAdapterCb.onUpdateItemTheme(localMyViewHolder.tvQscoretitle);
      }
      localMyViewHolder.tvQscore.setText(getQScoreText(localIdolItem.qScore));
      localMyViewHolder.tvRank.setText(getRankText(localIdolItem.rank));
      localMyViewHolder.tvRank.setContentDescription(getRankText(localIdolItem.rank));
      localMyViewHolder.tvName.setText(localIdolItem.name);
      localMyViewHolder.tvName.setContentDescription(localIdolItem.name);
      localMyViewHolder.itemView.setOnClickListener(new IdolAdapter.1(this, paramInt));
      if (!this.mIsNight) {
        break label212;
      }
      localMyViewHolder.itemView.setBackgroundDrawable(this.mContext.getResources().getDrawable(2130841749));
    }
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
      return;
      label212:
      localMyViewHolder.itemView.setBackgroundDrawable(this.mContext.getResources().getDrawable(2130841748));
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return new IdolAdapter.MyViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559701, paramViewGroup, false));
  }
  
  public void setList(List<TroopFansInfo.IdolItem> paramList)
  {
    if (paramList != null)
    {
      this.mIdolItems.clear();
      this.mIdolItems.addAll(paramList);
      notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.troop.fansinfo.IdolAdapter
 * JD-Core Version:    0.7.0.1
 */