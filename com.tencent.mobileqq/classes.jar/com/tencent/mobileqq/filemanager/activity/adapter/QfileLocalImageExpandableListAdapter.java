package com.tencent.mobileqq.filemanager.activity.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class QfileLocalImageExpandableListAdapter
  extends QfileBaseExpandableListAdapter
{
  protected Context a;
  protected BaseFileAssistantActivity b;
  protected LayoutInflater c;
  protected int d = 50;
  private LinkedHashMap<String, List<FileInfo>> i = new LinkedHashMap();
  private View.OnClickListener j;
  private View.OnClickListener k;
  private View.OnClickListener l;
  private View.OnLongClickListener m;
  private View.OnClickListener n;
  private float o = 0.0F;
  private int p = 0;
  
  public QfileLocalImageExpandableListAdapter(BaseFileAssistantActivity paramBaseFileAssistantActivity, Object paramObject, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, View.OnClickListener paramOnClickListener3, View.OnLongClickListener paramOnLongClickListener, View.OnClickListener paramOnClickListener4)
  {
    super(paramBaseFileAssistantActivity, paramObject);
    this.a = paramBaseFileAssistantActivity;
    this.b = paramBaseFileAssistantActivity;
    this.c = LayoutInflater.from(paramBaseFileAssistantActivity);
    this.i = ((LinkedHashMap)paramObject);
    this.j = paramOnClickListener1;
    this.l = paramOnClickListener3;
    this.k = paramOnClickListener2;
    this.m = paramOnLongClickListener;
    this.n = paramOnClickListener4;
    this.o = this.a.getResources().getDisplayMetrics().density;
    this.p = ((int)(this.o * 2.0F));
    this.d = c(a());
  }
  
  private LinearLayout a(ViewGroup paramViewGroup)
  {
    paramViewGroup = new LinearLayout(this.a);
    paramViewGroup.setOrientation(0);
    paramViewGroup.setClickable(false);
    paramViewGroup.setLongClickable(false);
    paramViewGroup.setTag(new QfileLocalImageExpandableListAdapter.GridGroupHolder(null));
    return paramViewGroup;
  }
  
  private View b(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = (LinearLayout)paramView;
    paramView = (View)localObject;
    if (localObject == null) {
      paramView = a(paramViewGroup);
    }
    paramView.removeAllViews();
    QfileLocalImageExpandableListAdapter.GridGroupHolder localGridGroupHolder = (QfileLocalImageExpandableListAdapter.GridGroupHolder)paramView.getTag();
    int i1 = 0;
    while (i1 < 4)
    {
      View localView = a(paramInt1, paramInt2 * 4 + i1, paramBoolean, localGridGroupHolder.a[i1], paramViewGroup);
      if (localView == null) {
        return paramView;
      }
      localGridGroupHolder.a[i1] = localView;
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
      localObject = localLayoutParams;
      if (localLayoutParams == null)
      {
        i2 = this.d;
        localObject = new LinearLayout.LayoutParams(i2, i2);
      }
      int i2 = this.d;
      ((LinearLayout.LayoutParams)localObject).width = i2;
      ((LinearLayout.LayoutParams)localObject).height = i2;
      if (i1 != 0) {
        ((LinearLayout.LayoutParams)localObject).leftMargin = this.p;
      }
      ((LinearLayout.LayoutParams)localObject).topMargin = this.p;
      localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramView.addView(localView);
      i1 += 1;
    }
    return paramView;
  }
  
  private int c(int paramInt)
  {
    DisplayMetrics localDisplayMetrics = this.a.getResources().getDisplayMetrics();
    return (int)(localDisplayMetrics.widthPixels - localDisplayMetrics.density * ((paramInt - 1) * 2)) / paramInt;
  }
  
  protected int a()
  {
    return 4;
  }
  
  protected View a(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = getChild(paramInt1, paramInt2);
    Object localObject1;
    if (paramViewGroup != null) {
      localObject1 = (FileInfo)paramViewGroup;
    } else {
      localObject1 = null;
    }
    if (localObject1 == null) {
      return null;
    }
    if (paramView == null) {
      paramViewGroup = paramView;
    }
    try
    {
      paramView = this.c.inflate(2131627052, null);
      paramViewGroup = paramView;
      ImageHolder localImageHolder = new ImageHolder();
      paramViewGroup = paramView;
      localImageHolder.a = ((AsyncImageView)paramView.findViewById(2131435357));
      paramViewGroup = paramView;
      localImageHolder.b = ((ImageView)paramView.findViewById(2131435382));
      paramViewGroup = paramView;
      localImageHolder.c = ((ImageView)paramView.findViewById(2131435377));
      paramViewGroup = paramView;
      localImageHolder.b.setOnClickListener(this.k);
      paramViewGroup = paramView;
      localImageHolder.a.setTag(localImageHolder);
      paramViewGroup = paramView;
      localImageHolder.b.setTag(localImageHolder);
      paramViewGroup = paramView;
      localImageHolder.a.setOnClickListener(this.l);
      paramViewGroup = paramView;
      paramView.setTag(localImageHolder);
      break label212;
      paramViewGroup = paramView;
      localImageHolder = (ImageHolder)paramView.getTag();
      label212:
      paramViewGroup = paramView;
      ((FileInfo)localObject1).a((String)getGroup(paramInt1));
      paramViewGroup = paramView;
      localImageHolder.i = localObject1;
      paramViewGroup = paramView;
      localImageHolder.g = paramInt2;
      paramViewGroup = paramView;
      localImageHolder.h = paramInt1;
      paramViewGroup = paramView;
      localImageHolder.a.setAdjustViewBounds(false);
      paramViewGroup = paramView;
      localImageHolder.a.setScaleType(ImageView.ScaleType.CENTER_CROP);
      paramViewGroup = paramView;
      localImageHolder.a.setDefaultImage(2130849738);
      paramViewGroup = paramView;
      localImageHolder.a.setAsyncClipSize(this.d, this.d);
      paramViewGroup = paramView;
      if (((FileInfo)localObject1).d() != null)
      {
        paramViewGroup = paramView;
        if (((FileInfo)localObject1).d().length() > 0)
        {
          paramViewGroup = paramView;
          if (FileUtils.fileExistsAndNotEmpty(((FileInfo)localObject1).d()))
          {
            paramViewGroup = paramView;
            localImageHolder.a.setAsyncImage(((FileInfo)localObject1).d());
          }
        }
      }
      paramViewGroup = paramView;
      Object localObject2 = new StringBuilder();
      paramViewGroup = paramView;
      ((StringBuilder)localObject2).append(this.b.getString(2131889359));
      paramViewGroup = paramView;
      ((StringBuilder)localObject2).append(((FileInfo)localObject1).e());
      paramViewGroup = paramView;
      localObject2 = ((StringBuilder)localObject2).toString();
      paramViewGroup = paramView;
      if (this.b.D())
      {
        paramViewGroup = paramView;
        localImageHolder.b.setVisibility(0);
        paramViewGroup = paramView;
        if (FMDataCache.a((FileInfo)localObject1))
        {
          paramViewGroup = paramView;
          localObject1 = new StringBuilder();
          paramViewGroup = paramView;
          ((StringBuilder)localObject1).append((String)localObject2);
          paramViewGroup = paramView;
          ((StringBuilder)localObject1).append(this.b.getString(2131889360));
          paramViewGroup = paramView;
          localObject1 = ((StringBuilder)localObject1).toString();
          paramViewGroup = paramView;
          localImageHolder.b.setImageResource(2130841341);
          paramViewGroup = paramView;
          paramView.setBackgroundColor(this.b.getResources().getColor(2131168464));
          paramViewGroup = paramView;
          paramView.setOnLongClickListener(null);
        }
        else
        {
          paramViewGroup = paramView;
          localObject1 = new StringBuilder();
          paramViewGroup = paramView;
          ((StringBuilder)localObject1).append((String)localObject2);
          paramViewGroup = paramView;
          ((StringBuilder)localObject1).append(HardCodeUtil.a(2131889361));
          paramViewGroup = paramView;
          localObject1 = ((StringBuilder)localObject1).toString();
          paramViewGroup = paramView;
          localImageHolder.c.setVisibility(4);
          paramViewGroup = paramView;
          localImageHolder.b.setImageResource(2130847332);
        }
      }
      else
      {
        paramViewGroup = paramView;
        localImageHolder.b.setVisibility(8);
        paramViewGroup = paramView;
        localImageHolder.c.setVisibility(8);
        localObject1 = localObject2;
      }
      paramViewGroup = paramView;
      localImageHolder.b.setContentDescription((CharSequence)localObject1);
      paramViewGroup = paramView;
      localImageHolder.a.setContentDescription((CharSequence)localObject1);
      return paramView;
    }
    catch (Exception paramView)
    {
      paramView.printStackTrace();
      QLog.e("#######", 1, paramView.toString());
    }
    return paramViewGroup;
  }
  
  public int b()
  {
    return this.d + this.p;
  }
  
  public Object getChild(int paramInt1, int paramInt2)
  {
    Object localObject = this.i.keySet().iterator();
    int i1 = 0;
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if (i1 == paramInt1)
      {
        localObject = (List)this.i.get(str);
        if (paramInt2 >= ((List)localObject).size()) {
          return null;
        }
        return ((List)localObject).get(paramInt2);
      }
      i1 += 1;
    }
    return null;
  }
  
  public long getChildId(int paramInt1, int paramInt2)
  {
    return paramInt2;
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    return b(paramInt1, paramInt2, paramBoolean, paramView, paramViewGroup);
  }
  
  public int getChildrenCount(int paramInt)
  {
    Iterator localIterator = this.i.keySet().iterator();
    int i1 = 0;
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (i1 == paramInt) {
        return ((List)this.i.get(str)).size() / 4 + 1;
      }
      i1 += 1;
    }
    return 0;
  }
  
  public Object getGroup(int paramInt)
  {
    Iterator localIterator = this.i.keySet().iterator();
    int i1 = 0;
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (i1 == paramInt) {
        return str;
      }
      i1 += 1;
    }
    return null;
  }
  
  public int getGroupCount()
  {
    return this.i.keySet().size();
  }
  
  public long getGroupId(int paramInt)
  {
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.adapter.QfileLocalImageExpandableListAdapter
 * JD-Core Version:    0.7.0.1
 */