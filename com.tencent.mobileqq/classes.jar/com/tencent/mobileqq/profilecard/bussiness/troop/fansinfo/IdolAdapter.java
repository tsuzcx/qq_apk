package com.tencent.mobileqq.profilecard.bussiness.troop.fansinfo;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
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
import com.tencent.mobileqq.troop.fans.data.TroopFansInfo.IdolItem;
import com.tencent.mobileqq.troop.utils.FansTroopUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
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
      Object localObject = (TroopFansInfo.IdolItem)this.mIdolItems.get(paramInt);
      FansTroopUtils.a(this.mContext, ((TroopFansInfo.IdolItem)localObject).jdField_a_of_type_Int, this.troopUin);
      ReportController.b(null, "dc00898", "", "", "0X800B598", "0X800B598", 0, 0, "", "", "", "");
      localObject = this.mIdolAdapterCb;
      if (localObject != null) {
        ((IdolAdapter.IdolAdapterCallBack)localObject).gotoWeb();
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
      double d = (float)paramLong / 10000.0F;
      Double.isNaN(d);
      Object localObject2 = String.format("%.2f", new Object[] { Double.valueOf(d - 0.005D) });
      localObject1 = localObject2;
      if (((String)localObject2).length() > 2)
      {
        localObject1 = localObject2;
        if (((String)localObject2).substring(((String)localObject2).length() - 2).equals("00")) {
          localObject1 = ((String)localObject2).substring(0, ((String)localObject2).length() - 3);
        }
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(this.mContext.getString(2131699481));
      return ((StringBuilder)localObject2).toString();
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(String.valueOf(paramLong / 10000L));
    ((StringBuilder)localObject1).append(this.mContext.getString(2131699481));
    return ((StringBuilder)localObject1).toString();
  }
  
  protected String getRankText(long paramLong)
  {
    if (paramLong <= 0L) {
      return this.mContext.getString(2131699561);
    }
    return String.format(this.mContext.getString(2131699477), new Object[] { String.valueOf(paramLong) });
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    IdolAdapter.MyViewHolder localMyViewHolder = (IdolAdapter.MyViewHolder)paramViewHolder;
    TroopFansInfo.IdolItem localIdolItem = (TroopFansInfo.IdolItem)this.mIdolItems.get(paramInt);
    if (localIdolItem != null)
    {
      Object localObject = URLDrawable.getDrawable(localIdolItem.c, null);
      if ((localObject != null) && (1 != ((URLDrawable)localObject).getStatus())) {
        ((URLDrawable)localObject).restartDownload();
      }
      localMyViewHolder.ivHead.setImageDrawable((Drawable)localObject);
      localObject = this.mIdolAdapterCb;
      if (localObject != null) {
        ((IdolAdapter.IdolAdapterCallBack)localObject).onUpdateItemTheme(localMyViewHolder.tvQscoretitle);
      }
      localMyViewHolder.tvQscore.setText(getQScoreText(localIdolItem.b));
      localMyViewHolder.tvRank.setText(getRankText(localIdolItem.jdField_a_of_type_Long));
      localMyViewHolder.tvRank.setContentDescription(getRankText(localIdolItem.jdField_a_of_type_Long));
      localMyViewHolder.tvName.setText(localIdolItem.jdField_a_of_type_JavaLangString);
      localMyViewHolder.tvName.setContentDescription(localIdolItem.jdField_a_of_type_JavaLangString);
      localMyViewHolder.itemView.setOnClickListener(new IdolAdapter.1(this, paramInt));
      if (this.mIsNight) {
        localMyViewHolder.itemView.setBackgroundDrawable(this.mContext.getResources().getDrawable(2130841635));
      } else {
        localMyViewHolder.itemView.setBackgroundDrawable(this.mContext.getResources().getDrawable(2130841634));
      }
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return new IdolAdapter.MyViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559577, paramViewGroup, false));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.troop.fansinfo.IdolAdapter
 * JD-Core Version:    0.7.0.1
 */