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
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.template.ITemplateUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import java.net.URL;
import java.util.List;

public class VipPhotoViewForSimple$PhotoAdapter
  extends BaseAdapter
{
  List<QzonePhotoView.PhotoInfo> a;
  private Context c = null;
  private LayoutInflater d = null;
  
  public VipPhotoViewForSimple$PhotoAdapter(VipPhotoViewForSimple paramVipPhotoViewForSimple, Context paramContext)
  {
    this.c = paramContext;
    this.d = LayoutInflater.from(this.c);
  }
  
  public void a(List<QzonePhotoView.PhotoInfo> paramList)
  {
    this.a = paramList;
    int i = paramList.size();
    if (i < 16)
    {
      if (VipPhotoViewForSimple.d(this.b)) {
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
  
  @TargetApi(16)
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject2 = (QzonePhotoView.PhotoInfo)this.a.get(paramInt);
    Object localObject3 = null;
    Object localObject1;
    if (paramView == null)
    {
      localObject1 = new VipPhotoViewForSimple.PhotoAdapter.ViewHolder(this);
      paramView = this.d.inflate(2131628455, null);
      paramView.setLayoutParams(new AbsListView.LayoutParams(this.b.g, this.b.h));
      ((VipPhotoViewForSimple.PhotoAdapter.ViewHolder)localObject1).a = ((URLImageView)paramView.findViewById(2131443119));
      paramView.setTag(localObject1);
    }
    else
    {
      localObject1 = (VipPhotoViewForSimple.PhotoAdapter.ViewHolder)paramView.getTag();
    }
    ((VipPhotoViewForSimple.PhotoAdapter.ViewHolder)localObject1).a.setTag(new DataTag(25, Integer.valueOf(paramInt)));
    ((VipPhotoViewForSimple.PhotoAdapter.ViewHolder)localObject1).a.setOnClickListener(VipPhotoViewForSimple.e(this.b));
    Object localObject4 = (RelativeLayout.LayoutParams)((VipPhotoViewForSimple.PhotoAdapter.ViewHolder)localObject1).a.getLayoutParams();
    if (localObject2 != null) {
      if ((((QzonePhotoView.PhotoInfo)localObject2).f != 100) && (((QzonePhotoView.PhotoInfo)localObject2).f != 102))
      {
        if (((QzonePhotoView.PhotoInfo)localObject2).f == 101)
        {
          ((VipPhotoViewForSimple.PhotoAdapter.ViewHolder)localObject1).a.setScaleType(ImageView.ScaleType.CENTER);
          VipPhotoViewForSimple.f(this.b).updateViewAttr(((VipPhotoViewForSimple.PhotoAdapter.ViewHolder)localObject1).a, "src", VipPhotoViewForSimple.c(this.b).currentTemplate, "simpleGridAddSrc");
          ((VipPhotoViewForSimple.PhotoAdapter.ViewHolder)localObject1).a.setContentDescription(HardCodeUtil.a(2131913690));
        }
      }
      else
      {
        if (Build.VERSION.SDK_INT >= 16) {
          paramView.setBackground(null);
        } else {
          paramView.setBackgroundDrawable(null);
        }
        ((VipPhotoViewForSimple.PhotoAdapter.ViewHolder)localObject1).a.setScaleType(ImageView.ScaleType.CENTER_CROP);
        try
        {
          localObject4 = ((QzonePhotoView.PhotoInfo)localObject2).a();
          localObject2 = localObject3;
          if (localObject4 != null) {
            localObject2 = new URL("qzone_cover", "original", (String)localObject4);
          }
        }
        catch (Exception localException)
        {
          localObject2 = localObject3;
          if (QLog.isColorLevel())
          {
            QLog.i("Q.qzonecover.", 2, localException.toString());
            localObject2 = localObject3;
          }
        }
        if (localObject2 != null) {
          ((VipPhotoViewForSimple.PhotoAdapter.ViewHolder)localObject1).a.setImageDrawable(URLDrawable.getDrawable((URL)localObject2, this.b.g, this.b.h));
        }
        localObject1 = ((VipPhotoViewForSimple.PhotoAdapter.ViewHolder)localObject1).a;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(HardCodeUtil.a(2131913689));
        ((StringBuilder)localObject2).append(paramInt + 1);
        ((URLImageView)localObject1).setContentDescription(((StringBuilder)localObject2).toString());
      }
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.VipPhotoViewForSimple.PhotoAdapter
 * JD-Core Version:    0.7.0.1
 */