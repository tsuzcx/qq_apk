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
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.cloudfile.QfileCloudFileTabView.IWeiYunImageEvent;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class QfileWeiYunImageExpandableListAdapter
  extends QfileBaseExpandableListAdapter
{
  public final int a = 1;
  public final int b = 2;
  private Context c;
  private LinkedHashMap<String, List<WeiYunFileInfo>> d = new LinkedHashMap();
  private BaseFileAssistantActivity i;
  private LayoutInflater j;
  private View.OnClickListener k;
  private View.OnClickListener l;
  private View.OnClickListener m;
  private View.OnLongClickListener n;
  private View.OnClickListener o;
  private QfileCloudFileTabView.IWeiYunImageEvent p;
  private int q = 50;
  private float r = 0.0F;
  private int s = 0;
  
  public QfileWeiYunImageExpandableListAdapter(QfileCloudFileTabView.IWeiYunImageEvent paramIWeiYunImageEvent, BaseFileAssistantActivity paramBaseFileAssistantActivity, Object paramObject, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, View.OnClickListener paramOnClickListener3, View.OnLongClickListener paramOnLongClickListener, View.OnClickListener paramOnClickListener4)
  {
    super(paramBaseFileAssistantActivity, paramObject);
    this.c = paramBaseFileAssistantActivity;
    this.i = paramBaseFileAssistantActivity;
    this.j = LayoutInflater.from(paramBaseFileAssistantActivity);
    this.d = ((LinkedHashMap)paramObject);
    this.k = paramOnClickListener1;
    this.l = paramOnClickListener2;
    this.m = paramOnClickListener3;
    this.n = paramOnLongClickListener;
    this.o = paramOnClickListener4;
    this.p = paramIWeiYunImageEvent;
    this.r = this.c.getResources().getDisplayMetrics().density;
    this.s = ((int)(this.r * 2.0F));
    this.q = b();
  }
  
  private View a(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = (LinearLayout)paramView;
    paramView = (View)localObject;
    if (localObject == null) {
      paramView = a(paramViewGroup);
    }
    paramView.removeAllViews();
    QfileWeiYunImageExpandableListAdapter.GridGroupHolder localGridGroupHolder = (QfileWeiYunImageExpandableListAdapter.GridGroupHolder)paramView.getTag();
    int i1 = 0;
    while (i1 < 4)
    {
      View localView = b(paramInt1, paramInt2 * 4 + i1, paramBoolean, localGridGroupHolder.a[i1], paramViewGroup);
      if (localView == null) {
        return paramView;
      }
      localGridGroupHolder.a[i1] = localView;
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
      localObject = localLayoutParams;
      if (localLayoutParams == null)
      {
        i2 = this.q;
        localObject = new LinearLayout.LayoutParams(i2, i2);
      }
      int i2 = this.q;
      ((LinearLayout.LayoutParams)localObject).width = i2;
      ((LinearLayout.LayoutParams)localObject).height = i2;
      if (i1 != 0) {
        ((LinearLayout.LayoutParams)localObject).leftMargin = this.s;
      }
      ((LinearLayout.LayoutParams)localObject).topMargin = this.s;
      localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramView.addView(localView);
      i1 += 1;
    }
    return paramView;
  }
  
  private LinearLayout a(ViewGroup paramViewGroup)
  {
    paramViewGroup = new LinearLayout(this.c);
    paramViewGroup.setOrientation(0);
    paramViewGroup.setClickable(false);
    paramViewGroup.setLongClickable(false);
    paramViewGroup.setTag(new QfileWeiYunImageExpandableListAdapter.GridGroupHolder(null));
    return paramViewGroup;
  }
  
  private int b()
  {
    DisplayMetrics localDisplayMetrics = this.c.getResources().getDisplayMetrics();
    return (int)(localDisplayMetrics.widthPixels - localDisplayMetrics.density * 6.0F) / 4;
  }
  
  private View b(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = getChild(paramInt1, paramInt2);
    Object localObject1;
    if (paramViewGroup != null) {
      localObject1 = (WeiYunFileInfo)paramViewGroup;
    } else {
      localObject1 = null;
    }
    if (localObject1 == null)
    {
      if (a(paramInt1, paramInt2) == 1) {
        return null;
      }
      if (this.p.c()) {
        return null;
      }
      if (QLog.isDevelopLevel())
      {
        paramView = new StringBuilder();
        paramView.append("groupPosition[");
        paramView.append(paramInt1);
        paramView.append("],position[");
        paramView.append(paramInt2);
        paramView.append("] add getMoreButton");
        QLog.d("@#@#@#", 4, paramView.toString());
      }
      paramView = new ImageHolder();
      paramViewGroup = this.j.inflate(2131627042, null);
      paramViewGroup.setClickable(true);
      paramView.d = ((TextView)paramViewGroup.findViewById(2131449882));
      paramView.e = ((ProgressBar)paramViewGroup.findViewById(2131444560));
      paramView.f = ((ImageView)paramViewGroup.findViewById(2131437616));
      paramView.j = true;
      paramView.h = paramInt1;
      paramView.g = paramInt2;
      paramViewGroup.setOnClickListener(this.p.a(paramView.d));
      paramViewGroup.setTag(paramView);
      if ((this.d.size() == 0) && (!this.p.a())) {
        paramViewGroup.setVisibility(8);
      } else {
        paramViewGroup.setVisibility(0);
      }
      if (this.p.b())
      {
        paramView.e.setVisibility(0);
        paramView.f.setVisibility(8);
        paramView.d.setText(2131889625);
        return paramViewGroup;
      }
      paramView.e.setVisibility(8);
      paramView.f.setVisibility(0);
      paramView.d.setText(2131889357);
      return paramViewGroup;
    }
    if (paramView == null) {
      paramViewGroup = paramView;
    }
    for (;;)
    {
      try
      {
        paramView = this.j.inflate(2131627052, null);
        paramViewGroup = paramView;
        ImageHolder localImageHolder = new ImageHolder();
        paramViewGroup = paramView;
        localImageHolder.a = ((AsyncImageView)paramView.findViewById(2131435357));
        paramViewGroup = paramView;
        localImageHolder.b = ((ImageView)paramView.findViewById(2131435382));
        paramViewGroup = paramView;
        localImageHolder.c = ((ImageView)paramView.findViewById(2131435377));
        paramViewGroup = paramView;
        localImageHolder.a.setOnClickListener(this.m);
        paramViewGroup = paramView;
        localImageHolder.b.setOnClickListener(this.l);
        paramViewGroup = paramView;
        localImageHolder.a.setTag(localImageHolder);
        paramViewGroup = paramView;
        localImageHolder.b.setTag(localImageHolder);
        paramViewGroup = paramView;
        localImageHolder.j = false;
        paramViewGroup = paramView;
        paramView.setTag(localImageHolder);
        continue;
        paramViewGroup = paramView;
        localImageHolder = (ImageHolder)paramView.getTag();
        paramViewGroup = paramView;
        if (localImageHolder.j)
        {
          paramViewGroup = paramView;
          paramView = this.j.inflate(2131627052, null);
          paramViewGroup = paramView;
          localImageHolder = new ImageHolder();
          paramViewGroup = paramView;
          localImageHolder.a = ((AsyncImageView)paramView.findViewById(2131435357));
          paramViewGroup = paramView;
          localImageHolder.b = ((ImageView)paramView.findViewById(2131435382));
          paramViewGroup = paramView;
          localImageHolder.c = ((ImageView)paramView.findViewById(2131435377));
          paramViewGroup = paramView;
          localImageHolder.a.setOnClickListener(this.m);
          paramViewGroup = paramView;
          localImageHolder.b.setOnClickListener(this.l);
          paramViewGroup = paramView;
          localImageHolder.a.setTag(localImageHolder);
          paramViewGroup = paramView;
          localImageHolder.b.setTag(localImageHolder);
          paramViewGroup = paramView;
          paramView.setTag(localImageHolder);
          paramViewGroup = paramView;
          localImageHolder.i = localObject1;
          paramViewGroup = paramView;
          localImageHolder.h = paramInt1;
          paramViewGroup = paramView;
          localImageHolder.g = paramInt2;
          paramViewGroup = paramView;
          localImageHolder.a.setAdjustViewBounds(false);
          paramViewGroup = paramView;
          localImageHolder.a.setScaleType(ImageView.ScaleType.CENTER_CROP);
          paramViewGroup = paramView;
          localImageHolder.a.setDefaultImage(2130849738);
          paramViewGroup = paramView;
          localImageHolder.a.setAsyncClipSize(this.q, this.q);
          paramViewGroup = paramView;
          localImageHolder.j = false;
          paramViewGroup = paramView;
          if (((WeiYunFileInfo)localObject1).l != null)
          {
            paramViewGroup = paramView;
            if (((WeiYunFileInfo)localObject1).l.length() > 0)
            {
              paramViewGroup = paramView;
              if (FileUtils.fileExistsAndNotEmpty(((WeiYunFileInfo)localObject1).l))
              {
                paramViewGroup = paramView;
                localImageHolder.a.setAsyncImage(((WeiYunFileInfo)localObject1).l);
              }
            }
          }
          paramViewGroup = paramView;
          Object localObject2 = new StringBuilder();
          paramViewGroup = paramView;
          ((StringBuilder)localObject2).append(this.i.getString(2131889359));
          paramViewGroup = paramView;
          ((StringBuilder)localObject2).append(((WeiYunFileInfo)localObject1).c);
          paramViewGroup = paramView;
          localObject2 = ((StringBuilder)localObject2).toString();
          paramViewGroup = paramView;
          if (this.i.D())
          {
            paramViewGroup = paramView;
            localImageHolder.b.setVisibility(0);
            paramViewGroup = paramView;
            if (FMDataCache.a((WeiYunFileInfo)localObject1))
            {
              paramViewGroup = paramView;
              localObject1 = new StringBuilder();
              paramViewGroup = paramView;
              ((StringBuilder)localObject1).append((String)localObject2);
              paramViewGroup = paramView;
              ((StringBuilder)localObject1).append(this.i.getString(2131889360));
              paramViewGroup = paramView;
              localObject1 = ((StringBuilder)localObject1).toString();
              paramViewGroup = paramView;
              localImageHolder.b.setImageResource(2130841341);
              paramViewGroup = paramView;
              paramView.setBackgroundColor(this.i.getResources().getColor(2131168464));
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
              paramViewGroup = paramView;
              paramView.setOnLongClickListener(this.n);
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
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
        QLog.e("#######", 1, paramView.toString());
        return paramViewGroup;
      }
    }
  }
  
  public int a()
  {
    return this.q + this.s;
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    if (paramInt1 + 1 < this.d.keySet().size()) {
      return 1;
    }
    List localList = (List)this.d.get(getGroup(paramInt1));
    if (((localList == null) && (paramInt2 == 0)) || ((localList != null) && (paramInt2 == localList.size()))) {
      return 2;
    }
    return 1;
  }
  
  public Object getChild(int paramInt1, int paramInt2)
  {
    Object localObject = this.d.keySet().iterator();
    int i1 = 0;
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if (i1 == paramInt1)
      {
        localObject = (List)this.d.get(str);
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
    return a(paramInt1, paramInt2, paramBoolean, paramView, paramViewGroup);
  }
  
  public int getChildrenCount(int paramInt)
  {
    Iterator localIterator = this.d.keySet().iterator();
    int i1 = 0;
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (i1 == paramInt)
      {
        paramInt = ((List)this.d.get(str)).size();
        if (paramInt < 4) {
          return 1;
        }
        return paramInt / 4 + 1;
      }
      i1 += 1;
    }
    if (!this.p.c()) {
      return 1;
    }
    return 0;
  }
  
  public Object getGroup(int paramInt)
  {
    Iterator localIterator = this.d.keySet().iterator();
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
    if (this.d.keySet().size() > 0) {
      return this.d.keySet().size();
    }
    if (!this.p.c()) {
      return 1;
    }
    return 0;
  }
  
  public long getGroupId(int paramInt)
  {
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.adapter.QfileWeiYunImageExpandableListAdapter
 * JD-Core Version:    0.7.0.1
 */