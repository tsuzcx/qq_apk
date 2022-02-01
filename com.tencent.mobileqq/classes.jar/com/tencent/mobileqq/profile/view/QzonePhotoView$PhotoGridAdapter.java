package com.tencent.mobileqq.profile.view;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.ProfileCardTemplate;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.util.List;

class QzonePhotoView$PhotoGridAdapter
  extends BaseAdapter
{
  int jdField_a_of_type_Int;
  List<QzonePhotoView.PhotoInfo> jdField_a_of_type_JavaUtilList;
  int b;
  
  QzonePhotoView$PhotoGridAdapter(QzonePhotoView paramQzonePhotoView) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public void a(List<QzonePhotoView.PhotoInfo> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    int i = paramList.size();
    if (i < 16) {
      if (QzonePhotoView.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewQzonePhotoView)) {
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
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = (QzonePhotoView.PhotoInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    QzonePhotoView.PhotoGridAdapter.ItemHolder localItemHolder;
    String str2;
    URLDrawable.URLDrawableOptions localURLDrawableOptions;
    String str1;
    if (paramView == null)
    {
      localItemHolder = new QzonePhotoView.PhotoGridAdapter.ItemHolder(this);
      paramView = (RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqProfileViewQzonePhotoView.getContext()).inflate(2131562192, null);
      paramView.setLayoutParams(new AbsListView.LayoutParams(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int));
      localItemHolder.a = ((URLImageView)paramView.findViewById(2131375416));
      localItemHolder.a.setTag(new DataTag(25, Integer.valueOf(paramInt)));
      str2 = ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewQzonePhotoView.a, -1L);
      localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestHeight = this.b;
      localURLDrawableOptions.mRequestWidth = this.jdField_a_of_type_Int;
      str1 = ((QzonePhotoView.PhotoInfo)localObject).a(this.jdField_a_of_type_Int);
      if (((QzonePhotoView.PhotoInfo)localObject).d == 100)
      {
        if (!TextUtils.isEmpty(str1))
        {
          localItemHolder.a.setImageDrawable(URLDrawable.getDrawable(str1, localURLDrawableOptions));
          localItemHolder.a.setContentDescription(HardCodeUtil.a(2131712116) + (paramInt + 1));
        }
        localItemHolder.a.setOnClickListener(QzonePhotoView.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewQzonePhotoView));
        paramView.setTag(localItemHolder);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      if (((QzonePhotoView.PhotoInfo)localObject).d == 101)
      {
        ProfileCardTemplate.a(localItemHolder.a, "src", QzonePhotoView.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewQzonePhotoView).a, "photoAddSrc");
        localItemHolder.a.setContentDescription(HardCodeUtil.a(2131712110));
        break;
      }
      if (((QzonePhotoView.PhotoInfo)localObject).d != 102) {
        break;
      }
      if (!TextUtils.isEmpty(str2))
      {
        localObject = new File(str2, "qvip_profile_photo_more.png");
        localItemHolder.a.setImageDrawable(URLDrawable.getDrawable((File)localObject, localURLDrawableOptions));
      }
      if (!TextUtils.isEmpty(str1)) {
        localItemHolder.a.setBackgroundDrawable(URLDrawable.getDrawable(str1, localURLDrawableOptions));
      }
      localItemHolder.a.setContentDescription(HardCodeUtil.a(2131712119));
      break;
      localObject = (QzonePhotoView.PhotoGridAdapter.ItemHolder)paramView.getTag();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.QzonePhotoView.PhotoGridAdapter
 * JD-Core Version:    0.7.0.1
 */