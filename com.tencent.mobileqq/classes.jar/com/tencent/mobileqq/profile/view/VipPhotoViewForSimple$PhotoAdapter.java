package com.tencent.mobileqq.profile.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.ProfileCardTemplate;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import java.net.URL;
import java.util.List;

public class VipPhotoViewForSimple$PhotoAdapter
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext = null;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater = null;
  List<QzonePhotoView.PhotoInfo> jdField_a_of_type_JavaUtilList;
  
  public VipPhotoViewForSimple$PhotoAdapter(VipPhotoViewForSimple paramVipPhotoViewForSimple, Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
  }
  
  public void a(List<QzonePhotoView.PhotoInfo> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    int i = paramList.size();
    if (i < 16) {
      if (VipPhotoViewForSimple.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewVipPhotoViewForSimple)) {
        this.jdField_a_of_type_JavaUtilList.add(new QzonePhotoView.PhotoInfo(paramList.size(), 101, null));
      }
    }
    for (;;)
    {
      notifyDataSetChanged();
      return;
      paramList = (QzonePhotoView.PhotoInfo)this.jdField_a_of_type_JavaUtilList.get(i - 1);
      paramList.d = 102;
      this.jdField_a_of_type_JavaUtilList.set(i - 1, paramList);
    }
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return this.jdField_a_of_type_JavaUtilList.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt);
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
    Object localObject = null;
    QzonePhotoView.PhotoInfo localPhotoInfo = (QzonePhotoView.PhotoInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    VipPhotoViewForSimple.PhotoAdapter.ViewHolder localViewHolder;
    View localView;
    if (paramView == null)
    {
      localViewHolder = new VipPhotoViewForSimple.PhotoAdapter.ViewHolder(this);
      localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131562192, null);
      localView.setLayoutParams(new AbsListView.LayoutParams(this.jdField_a_of_type_ComTencentMobileqqProfileViewVipPhotoViewForSimple.c, this.jdField_a_of_type_ComTencentMobileqqProfileViewVipPhotoViewForSimple.d));
      localViewHolder.a = ((URLImageView)localView.findViewById(2131375416));
      localView.setTag(localViewHolder);
      localViewHolder.a.setTag(new DataTag(25, Integer.valueOf(paramInt)));
      localViewHolder.a.setOnClickListener(VipPhotoViewForSimple.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewVipPhotoViewForSimple));
      paramView = (RelativeLayout.LayoutParams)localViewHolder.a.getLayoutParams();
      if (localPhotoInfo != null)
      {
        if ((localPhotoInfo.d != 100) && (localPhotoInfo.d != 102)) {
          break label345;
        }
        if (Build.VERSION.SDK_INT < 16) {
          break label308;
        }
        localView.setBackground(null);
        label179:
        localViewHolder.a.setScaleType(ImageView.ScaleType.CENTER_CROP);
      }
    }
    label405:
    for (;;)
    {
      try
      {
        paramView = localPhotoInfo.a();
        if (paramView == null) {
          break label405;
        }
        paramView = new URL("qzone_cover", "original", paramView);
      }
      catch (Exception localException)
      {
        label308:
        paramView = localObject;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("Q.qzonecover.", 2, localException.toString());
        paramView = localObject;
        continue;
      }
      if (paramView != null) {
        localViewHolder.a.setImageDrawable(URLDrawable.getDrawable(paramView, this.jdField_a_of_type_ComTencentMobileqqProfileViewVipPhotoViewForSimple.c, this.jdField_a_of_type_ComTencentMobileqqProfileViewVipPhotoViewForSimple.d));
      }
      localViewHolder.a.setContentDescription(HardCodeUtil.a(2131716592) + (paramInt + 1));
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localViewHolder = (VipPhotoViewForSimple.PhotoAdapter.ViewHolder)paramView.getTag();
      localView = paramView;
      break;
      localView.setBackgroundDrawable(null);
      break label179;
      label345:
      if (localException.d == 101)
      {
        localViewHolder.a.setScaleType(ImageView.ScaleType.CENTER);
        ProfileCardTemplate.a(localViewHolder.a, "src", VipPhotoViewForSimple.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewVipPhotoViewForSimple).a, "simpleGridAddSrc");
        localViewHolder.a.setContentDescription(HardCodeUtil.a(2131716593));
        continue;
        paramView = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.VipPhotoViewForSimple.PhotoAdapter
 * JD-Core Version:    0.7.0.1
 */