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
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.template.ITemplateUtils;
import com.tencent.mobileqq.util.ProfileCardTemplateUtil;
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
    if (i < 16)
    {
      if (QzonePhotoView.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewQzonePhotoView)) {
        this.jdField_a_of_type_JavaUtilList.add(new QzonePhotoView.PhotoInfo(paramList.size(), 101, null));
      }
    }
    else
    {
      paramList = this.jdField_a_of_type_JavaUtilList;
      i -= 1;
      paramList = (QzonePhotoView.PhotoInfo)paramList.get(i);
      paramList.d = 102;
      this.jdField_a_of_type_JavaUtilList.set(i, paramList);
    }
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
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1 = (QzonePhotoView.PhotoInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    QzonePhotoView.PhotoGridAdapter.ItemHolder localItemHolder;
    if (paramView == null)
    {
      localItemHolder = new QzonePhotoView.PhotoGridAdapter.ItemHolder(this);
      paramView = (RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqProfileViewQzonePhotoView.getContext()).inflate(2131562029, null);
      int i = this.jdField_a_of_type_Int;
      paramView.setLayoutParams(new AbsListView.LayoutParams(i, i));
      localItemHolder.a = ((URLImageView)paramView.findViewById(2131374934));
      localItemHolder.a.setTag(new DataTag(25, Integer.valueOf(paramInt)));
      String str2 = ProfileCardTemplateUtil.a(-1L);
      Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = this.b;
      i = this.jdField_a_of_type_Int;
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = i;
      String str1 = ((QzonePhotoView.PhotoInfo)localObject1).a(i);
      if (((QzonePhotoView.PhotoInfo)localObject1).d == 100)
      {
        if (!TextUtils.isEmpty(str1))
        {
          localItemHolder.a.setImageDrawable(URLDrawable.getDrawable(str1, (URLDrawable.URLDrawableOptions)localObject2));
          localObject1 = localItemHolder.a;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(HardCodeUtil.a(2131712091));
          ((StringBuilder)localObject2).append(paramInt + 1);
          ((URLImageView)localObject1).setContentDescription(((StringBuilder)localObject2).toString());
        }
      }
      else if (((QzonePhotoView.PhotoInfo)localObject1).d == 101)
      {
        QzonePhotoView.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewQzonePhotoView).updateViewAttr(localItemHolder.a, "src", QzonePhotoView.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewQzonePhotoView).currentTemplate, "photoAddSrc");
        localItemHolder.a.setContentDescription(HardCodeUtil.a(2131712085));
      }
      else if (((QzonePhotoView.PhotoInfo)localObject1).d == 102)
      {
        if (!TextUtils.isEmpty(str2))
        {
          localObject1 = new File(str2, "qvip_profile_photo_more.png");
          localItemHolder.a.setImageDrawable(URLDrawable.getDrawable((File)localObject1, (URLDrawable.URLDrawableOptions)localObject2));
        }
        if (!TextUtils.isEmpty(str1)) {
          localItemHolder.a.setBackgroundDrawable(URLDrawable.getDrawable(str1, (URLDrawable.URLDrawableOptions)localObject2));
        }
        localItemHolder.a.setContentDescription(HardCodeUtil.a(2131712094));
      }
      localItemHolder.a.setOnClickListener(QzonePhotoView.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewQzonePhotoView));
      paramView.setTag(localItemHolder);
    }
    else
    {
      localItemHolder = (QzonePhotoView.PhotoGridAdapter.ItemHolder)paramView.getTag();
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.QzonePhotoView.PhotoGridAdapter
 * JD-Core Version:    0.7.0.1
 */