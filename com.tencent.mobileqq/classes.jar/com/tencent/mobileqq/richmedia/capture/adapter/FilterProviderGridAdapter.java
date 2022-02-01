package com.tencent.mobileqq.richmedia.capture.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.aelight.camera.qqstory.api.ICaptureVideoFilterManager;
import com.tencent.aelight.camera.struct.editor.FilterCategoryItem;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.capture.view.CaptureCommonLoadingView;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class FilterProviderGridAdapter
  extends BaseAdapter
{
  public String a = "FilterProviderGridAdapter";
  List<FilterCategoryItem> b = new CopyOnWriteArrayList();
  int c;
  int d;
  boolean e = true;
  private Context f;
  
  public FilterProviderGridAdapter(Context paramContext, boolean paramBoolean)
  {
    this.f = paramContext;
    this.e = paramBoolean;
  }
  
  public void a(List<FilterCategoryItem> paramList)
  {
    this.b.clear();
    Object localObject;
    if (this.e)
    {
      this.b.addAll(paramList);
    }
    else
    {
      localObject = paramList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        FilterCategoryItem localFilterCategoryItem = (FilterCategoryItem)((Iterator)localObject).next();
        if (!localFilterCategoryItem.i) {
          this.b.add(localFilterCategoryItem);
        }
      }
    }
    notifyDataSetChanged();
    if ((paramList != null) && (QLog.isColorLevel()))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("FilterProviderGridAdapter setData size = ");
      ((StringBuilder)localObject).append(paramList.size());
      QLog.d("CapturePtvTemplateManager", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public int getCount()
  {
    return this.b.size();
  }
  
  public Object getItem(int paramInt)
  {
    if (paramInt > this.b.size()) {
      return null;
    }
    return this.b.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if ((this.c <= 0) && (paramViewGroup != null))
    {
      this.c = paramViewGroup.getMeasuredWidth();
      this.d = ((int)((this.c - FilterProviderPagerAdapter.b * 3 - paramViewGroup.getPaddingLeft() - paramViewGroup.getPaddingRight()) / 4 + 0.5F));
    }
    if (paramView == null) {
      paramView = LayoutInflater.from(this.f).inflate(2131627347, paramViewGroup, false);
    }
    TextView localTextView = (TextView)paramView.findViewById(2131433168);
    ImageView localImageView3 = (ImageView)paramView.findViewById(2131435657);
    ImageView localImageView1 = (ImageView)paramView.findViewById(2131435219);
    ImageView localImageView2 = (ImageView)paramView.findViewById(2131431428);
    URLImageView localURLImageView = (URLImageView)paramView.findViewById(2131427868);
    CaptureCommonLoadingView localCaptureCommonLoadingView = (CaptureCommonLoadingView)paramView.findViewById(2131433172);
    FilterCategoryItem localFilterCategoryItem = (FilterCategoryItem)this.b.get(paramInt);
    Object localObject = ((ICaptureVideoFilterManager)QRoute.api(ICaptureVideoFilterManager.class)).getSelectFilterCategoryItem();
    boolean bool1;
    if (localObject != null) {
      bool1 = TextUtils.equals(((FilterCategoryItem)localObject).a, localFilterCategoryItem.a);
    } else {
      bool1 = false;
    }
    boolean bool2 = bool1;
    if (!bool1) {
      if (((localObject == null) || (((FilterCategoryItem)localObject).b())) && (localFilterCategoryItem.b())) {
        bool2 = true;
      } else {
        bool2 = false;
      }
    }
    paramView.setTag(localFilterCategoryItem);
    AbsListView.LayoutParams localLayoutParams = (AbsListView.LayoutParams)paramView.getLayoutParams();
    localObject = localLayoutParams;
    if (localLayoutParams == null)
    {
      localObject = new AbsListView.LayoutParams(-1, -1);
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    ((AbsListView.LayoutParams)localObject).height = this.d;
    if (localFilterCategoryItem.b())
    {
      localImageView1.setImageDrawable(this.f.getResources().getDrawable(2130847600));
      if (bool2) {
        localImageView3.setVisibility(0);
      } else {
        localImageView3.setVisibility(8);
      }
      localImageView2.setVisibility(8);
      localTextView.setText(HardCodeUtil.a(2131902609));
      localImageView1.setContentDescription(HardCodeUtil.a(2131902612));
      localTextView.setContentDescription(HardCodeUtil.a(2131902613));
    }
    else
    {
      if (bool2)
      {
        localImageView3.setVisibility(0);
        localTextView.setShadowLayer(0.0F, 0.0F, 0.0F, this.f.getResources().getColor(2131167939));
      }
      else
      {
        localImageView3.setVisibility(8);
        localTextView.setShadowLayer(3.0F, 0.0F, 0.0F, this.f.getResources().getColor(2131167939));
      }
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.f.getResources().getDrawable(2130847596);
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.f.getResources().getDrawable(2130847596);
      localCaptureCommonLoadingView.setMax(10000);
      localCaptureCommonLoadingView.setVisibility(8);
      localObject = URLDrawable.getDrawable(localFilterCategoryItem.d, URLDrawable.URLDrawableOptions.obtain());
      ((URLDrawable)localObject).startDownload();
      localImageView1.setImageDrawable((Drawable)localObject);
      localTextView.setText(localFilterCategoryItem.b);
      localImageView1.setContentDescription(localFilterCategoryItem.b);
      localTextView.setContentDescription(localFilterCategoryItem.b);
      if (localFilterCategoryItem.i)
      {
        localImageView2.setVisibility(8);
        if (StringUtil.isEmpty(localFilterCategoryItem.n)) {
          localURLImageView.setVisibility(8);
        } else {
          try
          {
            localURLImageView.setVisibility(0);
            localURLImageView.setImageDrawable(URLDrawable.getDrawable(localFilterCategoryItem.n));
            localObject = localURLImageView.getLayoutParams();
            ((ViewGroup.LayoutParams)localObject).height = 42;
            ((ViewGroup.LayoutParams)localObject).width = 42;
            localURLImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
          }
          catch (Exception localException)
          {
            QLog.e("PtvTemplateItemView", 1, "PtvTemplateItemView bindData mBadgeImg.setImageDrawable(URLDrawable.getDrawable(info.badgeurl)) catch an Exception.", localException);
            localURLImageView.setVisibility(8);
          }
        }
        ReportController.b(null, "dc00898", "", "", "0X800859E", "0X800859E", 2, 0, "", "", localFilterCategoryItem.a, "");
      }
      else
      {
        bool1 = ((ICaptureVideoFilterManager)QRoute.api(ICaptureVideoFilterManager.class)).needShowRedDot(3, localFilterCategoryItem.f, localFilterCategoryItem.a);
        if (bool1)
        {
          localImageView2.setVisibility(0);
          if (bool1) {
            localImageView2.setImageResource(2130847602);
          }
        }
        else
        {
          localImageView2.setVisibility(8);
        }
      }
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.adapter.FilterProviderGridAdapter
 * JD-Core Version:    0.7.0.1
 */