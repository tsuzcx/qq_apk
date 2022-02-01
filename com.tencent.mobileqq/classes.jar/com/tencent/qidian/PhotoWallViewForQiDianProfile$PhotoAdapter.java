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
  private Context jdField_a_of_type_AndroidContentContext = null;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater = null;
  List<CompanyShowCaseInfo> jdField_a_of_type_JavaUtilList;
  
  public PhotoWallViewForQiDianProfile$PhotoAdapter(PhotoWallViewForQiDianProfile paramPhotoWallViewForQiDianProfile, Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
  }
  
  public void a(List<CompanyShowCaseInfo> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
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
      localObject = ((CompanyShowCaseInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt)).c;
      try
      {
        String str = ((CompanyShowCaseInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt)).a;
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
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559563, null);
      paramView.setLayoutParams(new AbsListView.LayoutParams(this.jdField_a_of_type_ComTencentQidianPhotoWallViewForQiDianProfile.a, this.jdField_a_of_type_ComTencentQidianPhotoWallViewForQiDianProfile.b));
      localViewHolder.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131372672));
      localViewHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370710));
      localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(2);
      localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
      localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setTextSize(2, 14.0F);
      localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(2);
      Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
      localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setLineSpacing(AIOUtils.b(2.5F, localResources), 1.0F);
      localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setGravity(80);
      localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
      localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130841704);
      int i = AIOUtils.b(11.0F, localResources);
      int j = AIOUtils.b(14.0F, localResources);
      localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setPadding(j, 0, j, i);
      paramView.setTag(localViewHolder);
    }
    else
    {
      localViewHolder = (PhotoWallViewForQiDianProfile.PhotoAdapter.ViewHolder)paramView.getTag();
    }
    localViewHolder.jdField_a_of_type_ComTencentImageURLImageView.setTag(new DataTag(25, Integer.valueOf(paramInt)));
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      localViewHolder.jdField_a_of_type_ComTencentImageURLImageView.setImageResource(2130850831);
    }
    else
    {
      localObject = URLDrawable.getDrawable((String)localObject);
      localViewHolder.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
    }
    if (!TextUtils.isEmpty(localCharSequence))
    {
      localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(localCharSequence);
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qidian.PhotoWallViewForQiDianProfile.PhotoAdapter
 * JD-Core Version:    0.7.0.1
 */