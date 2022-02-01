package com.tencent.mobileqq.utils;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class QQCustomDialogWtihForwardAvatar$ForwardTargetAdapter
  extends BaseAdapter
{
  private QQAppInterface mApp;
  private View.OnClickListener mClickListener;
  private Context mContext;
  private List<ResultRecord> mForwardTargets;
  
  public QQCustomDialogWtihForwardAvatar$ForwardTargetAdapter(QQAppInterface paramQQAppInterface, Context paramContext, List<ResultRecord> paramList, View.OnClickListener paramOnClickListener)
  {
    this.mApp = paramContext;
    this.mContext = paramList;
    Object localObject;
    this.mClickListener = localObject;
    this.mForwardTargets = paramOnClickListener;
  }
  
  private int getAvatarTypeByUinType(int paramInt)
  {
    if (paramInt == 4) {}
    do
    {
      return 11;
      if (paramInt == 1) {
        return 4;
      }
      if (paramInt == 3000) {
        return 101;
      }
    } while (paramInt == 1006);
    return 1;
  }
  
  private void setBitmap(ImageView paramImageView, ResultRecord paramResultRecord)
  {
    if (AppConstants.DATALINE_PC_UIN.equals(paramResultRecord.uin))
    {
      paramImageView.setImageResource(2130844186);
      return;
    }
    if (AppConstants.DATALINE_IPAD_UIN.equals(paramResultRecord.uin))
    {
      paramImageView.setImageResource(2130844184);
      return;
    }
    if (AppConstants.DATALINE_PRINTER_UIN.equals(paramResultRecord.uin))
    {
      paramImageView.setImageResource(2130844189);
      return;
    }
    if (AppConstants.SMARTDEVICE_SEARCH_UIN.equals(paramResultRecord.uin))
    {
      paramImageView.setImageResource(2130839629);
      return;
    }
    int i = getAvatarTypeByUinType(paramResultRecord.getUinType());
    paramImageView.setImageDrawable(FaceDrawable.getFaceDrawable(this.mApp, i, paramResultRecord.uin));
  }
  
  public int getCount()
  {
    if (this.mForwardTargets == null) {
      return 0;
    }
    return this.mForwardTargets.size();
  }
  
  public ResultRecord getItem(int paramInt)
  {
    return (ResultRecord)this.mForwardTargets.get(paramInt);
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
      localImageView = new ImageView(this.mContext);
      localImageView.setLayoutParams(new AbsListView.LayoutParams(this.this$0.mImgvHeadWidth, this.this$0.mImgvHeadWidth));
    }
    for (;;)
    {
      setBitmap(localImageView, getItem(paramInt));
      localImageView.setTag(getItem(paramInt));
      localImageView.setOnClickListener(this.mClickListener);
      localImageView.setFocusable(false);
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localImageView;
      localImageView = (ImageView)paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomDialogWtihForwardAvatar.ForwardTargetAdapter
 * JD-Core Version:    0.7.0.1
 */