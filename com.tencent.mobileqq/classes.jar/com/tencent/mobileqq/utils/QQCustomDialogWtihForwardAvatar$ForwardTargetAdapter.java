package com.tencent.mobileqq.utils;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.guild.api.IQQGuildAvatarApi;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class QQCustomDialogWtihForwardAvatar$ForwardTargetAdapter
  extends BaseAdapter
{
  private Context b;
  private QQAppInterface c;
  private List<ResultRecord> d;
  private View.OnClickListener e;
  
  public QQCustomDialogWtihForwardAvatar$ForwardTargetAdapter(QQAppInterface paramQQAppInterface, Context paramContext, List<ResultRecord> paramList, View.OnClickListener paramOnClickListener)
  {
    this.c = paramContext;
    this.b = paramList;
    Object localObject;
    this.e = localObject;
    this.d = paramOnClickListener;
  }
  
  private void a(ImageView paramImageView, ResultRecord paramResultRecord)
  {
    if (AppConstants.DATALINE_PC_UIN.equals(paramResultRecord.uin))
    {
      paramImageView.setImageResource(2130845599);
      return;
    }
    if (AppConstants.DATALINE_IPAD_UIN.equals(paramResultRecord.uin))
    {
      paramImageView.setImageResource(2130845594);
      return;
    }
    if (AppConstants.DATALINE_PRINTER_UIN.equals(paramResultRecord.uin))
    {
      paramImageView.setImageResource(2130845602);
      return;
    }
    if (AppConstants.SMARTDEVICE_SEARCH_UIN.equals(paramResultRecord.uin))
    {
      paramImageView.setImageResource(2130839779);
      return;
    }
    int i = b(paramResultRecord.getUinType());
    if (i == 117)
    {
      paramImageView.setImageDrawable(((IQQGuildAvatarApi)this.c.getRuntimeService(IQQGuildAvatarApi.class, "")).getAvatarDrawable(paramResultRecord.guildAvatarUrl, 100, 100, null));
      return;
    }
    paramImageView.setImageDrawable(FaceDrawable.getFaceDrawable(this.c, i, paramResultRecord.uin));
  }
  
  private int b(int paramInt)
  {
    int i = 1;
    if (paramInt == 1) {
      return 4;
    }
    if (paramInt == 3000) {
      return 101;
    }
    if (paramInt == 1006) {
      return 11;
    }
    if (paramInt == 10014) {
      i = 117;
    }
    return i;
  }
  
  public ResultRecord a(int paramInt)
  {
    return (ResultRecord)this.d.get(paramInt);
  }
  
  public int getCount()
  {
    List localList = this.d;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    ImageView localImageView;
    if (paramView == null)
    {
      localImageView = new ImageView(this.b);
      localImageView.setLayoutParams(new AbsListView.LayoutParams(this.a.E, this.a.E));
    }
    else
    {
      localImageView = (ImageView)paramView;
    }
    a(localImageView, a(paramInt));
    localImageView.setTag(a(paramInt));
    localImageView.setOnClickListener(this.e);
    localImageView.setFocusable(false);
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return localImageView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomDialogWtihForwardAvatar.ForwardTargetAdapter
 * JD-Core Version:    0.7.0.1
 */