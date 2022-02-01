package com.tencent.qidian;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.qidian.data.CompanyShowCaseInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.List;

public class PhotoWallViewForQiDianProfile$PhotoAdapter
  extends BaseAdapter
{
  List<CompanyShowCaseInfo> a;
  private Context c = null;
  private LayoutInflater d = null;
  
  public PhotoWallViewForQiDianProfile$PhotoAdapter(PhotoWallViewForQiDianProfile paramPhotoWallViewForQiDianProfile, Context paramContext)
  {
    this.c = paramContext;
    this.d = LayoutInflater.from(this.c);
  }
  
  public void a(List<CompanyShowCaseInfo> paramList)
  {
    this.a = paramList;
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    List localList = this.a;
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    List localList = this.a;
    if (localList != null) {
      return localList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  @TargetApi(16)
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    try
    {
      localObject = ((CompanyShowCaseInfo)this.a.get(paramInt)).c;
      try
      {
        String str = ((CompanyShowCaseInfo)this.a.get(paramInt)).a;
      }
      catch (Exception localException1) {}
      if (!QLog.isColorLevel()) {
        break label63;
      }
    }
    catch (Exception localException2)
    {
      localObject = null;
    }
    QLog.d("PhotoWallViewForQiDianProfile", 2, "getView url error!");
    label63:
    localException2.printStackTrace();
    CharSequence localCharSequence = null;
    PhotoWallViewForQiDianProfile.PhotoAdapter.ViewHolder localViewHolder;
    if (paramView == null)
    {
      localViewHolder = new PhotoWallViewForQiDianProfile.PhotoAdapter.ViewHolder(this);
      paramView = this.d.inflate(2131625587, null);
      paramView.setLayoutParams(new AbsListView.LayoutParams(this.b.d, this.b.e));
      localViewHolder.a = ((URLImageView)paramView.findViewById(2131440218));
      localViewHolder.b = ((TextView)paramView.findViewById(2131437988));
      localViewHolder.b.setMaxLines(2);
      localViewHolder.b.setTextColor(-1);
      localViewHolder.b.setTextSize(2, 14.0F);
      localViewHolder.b.setMaxLines(2);
      Resources localResources = this.c.getResources();
      localViewHolder.b.setLineSpacing(AIOUtils.b(2.5F, localResources), 1.0F);
      localViewHolder.b.setGravity(80);
      localViewHolder.b.setEllipsize(TextUtils.TruncateAt.END);
      localViewHolder.b.setBackgroundResource(2130842619);
      int i = AIOUtils.b(11.0F, localResources);
      int j = AIOUtils.b(14.0F, localResources);
      localViewHolder.b.setPadding(j, 0, j, i);
      paramView.setTag(localViewHolder);
    }
    else
    {
      localViewHolder = (PhotoWallViewForQiDianProfile.PhotoAdapter.ViewHolder)paramView.getTag();
    }
    localViewHolder.a.setTag(new DataTag(25, Integer.valueOf(paramInt)));
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      localViewHolder.a.setImageResource(2130852666);
    }
    else
    {
      localObject = URLDrawable.getDrawable((String)localObject);
      localViewHolder.a.setImageDrawable((Drawable)localObject);
    }
    if (!TextUtils.isEmpty(localCharSequence))
    {
      localViewHolder.b.setVisibility(0);
      localViewHolder.b.setText(localCharSequence);
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qidian.PhotoWallViewForQiDianProfile.PhotoAdapter
 * JD-Core Version:    0.7.0.1
 */