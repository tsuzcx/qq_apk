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
  List<QzonePhotoView.PhotoInfo> a;
  int b;
  int c;
  
  QzonePhotoView$PhotoGridAdapter(QzonePhotoView paramQzonePhotoView) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    this.b = paramInt1;
    this.c = paramInt2;
  }
  
  public void a(List<QzonePhotoView.PhotoInfo> paramList)
  {
    this.a = paramList;
    int i = paramList.size();
    if (i < 16)
    {
      if (QzonePhotoView.e(this.d)) {
        this.a.add(new QzonePhotoView.PhotoInfo(paramList.size(), 101, null));
      }
    }
    else
    {
      paramList = this.a;
      i -= 1;
      paramList = (QzonePhotoView.PhotoInfo)paramList.get(i);
      paramList.f = 102;
      this.a.set(i, paramList);
    }
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
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1 = (QzonePhotoView.PhotoInfo)this.a.get(paramInt);
    QzonePhotoView.PhotoGridAdapter.ItemHolder localItemHolder;
    if (paramView == null)
    {
      localItemHolder = new QzonePhotoView.PhotoGridAdapter.ItemHolder(this);
      paramView = (RelativeLayout)LayoutInflater.from(this.d.getContext()).inflate(2131628455, null);
      int i = this.b;
      paramView.setLayoutParams(new AbsListView.LayoutParams(i, i));
      localItemHolder.a = ((URLImageView)paramView.findViewById(2131443119));
      localItemHolder.a.setTag(new DataTag(25, Integer.valueOf(paramInt)));
      String str2 = ProfileCardTemplateUtil.a(-1L);
      Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = this.c;
      i = this.b;
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = i;
      String str1 = ((QzonePhotoView.PhotoInfo)localObject1).a(i);
      if (((QzonePhotoView.PhotoInfo)localObject1).f == 100)
      {
        if (!TextUtils.isEmpty(str1))
        {
          localItemHolder.a.setImageDrawable(URLDrawable.getDrawable(str1, (URLDrawable.URLDrawableOptions)localObject2));
          localObject1 = localItemHolder.a;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(HardCodeUtil.a(2131909713));
          ((StringBuilder)localObject2).append(paramInt + 1);
          ((URLImageView)localObject1).setContentDescription(((StringBuilder)localObject2).toString());
        }
      }
      else if (((QzonePhotoView.PhotoInfo)localObject1).f == 101)
      {
        QzonePhotoView.f(this.d).updateViewAttr(localItemHolder.a, "src", QzonePhotoView.d(this.d).currentTemplate, "photoAddSrc");
        localItemHolder.a.setContentDescription(HardCodeUtil.a(2131909708));
      }
      else if (((QzonePhotoView.PhotoInfo)localObject1).f == 102)
      {
        if (!TextUtils.isEmpty(str2))
        {
          localObject1 = new File(str2, "qvip_profile_photo_more.png");
          localItemHolder.a.setImageDrawable(URLDrawable.getDrawable((File)localObject1, (URLDrawable.URLDrawableOptions)localObject2));
        }
        if (!TextUtils.isEmpty(str1)) {
          localItemHolder.a.setBackgroundDrawable(URLDrawable.getDrawable(str1, (URLDrawable.URLDrawableOptions)localObject2));
        }
        localItemHolder.a.setContentDescription(HardCodeUtil.a(2131909716));
      }
      localItemHolder.a.setOnClickListener(QzonePhotoView.g(this.d));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.QzonePhotoView.PhotoGridAdapter
 * JD-Core Version:    0.7.0.1
 */