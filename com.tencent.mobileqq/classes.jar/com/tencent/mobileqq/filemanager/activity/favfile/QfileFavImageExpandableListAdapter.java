package com.tencent.mobileqq.filemanager.activity.favfile;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
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
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.adapter.ImageHolder;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter;
import com.tencent.mobileqq.filemanager.api.IQQFileEngine;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FavFileInfo;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class QfileFavImageExpandableListAdapter
  extends QfileBaseExpandableListAdapter
{
  private Context a;
  private LinkedHashMap<String, List<FavFileInfo>> b;
  private BaseFileAssistantActivity c;
  private LayoutInflater d;
  private View.OnClickListener i;
  private View.OnClickListener j;
  private View.OnLongClickListener k;
  private QfileFavImageExpandableListAdapter.IAdapterCallBack l;
  private int m;
  private int n;
  private boolean o = false;
  
  QfileFavImageExpandableListAdapter(QfileFavImageExpandableListAdapter.IAdapterCallBack paramIAdapterCallBack, BaseFileAssistantActivity paramBaseFileAssistantActivity, Object paramObject, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, View.OnLongClickListener paramOnLongClickListener)
  {
    super(paramBaseFileAssistantActivity, paramObject);
    this.a = paramBaseFileAssistantActivity;
    this.c = paramBaseFileAssistantActivity;
    this.d = LayoutInflater.from(paramBaseFileAssistantActivity);
    this.b = ((LinkedHashMap)paramObject);
    this.i = paramOnClickListener1;
    this.j = paramOnClickListener2;
    this.k = paramOnLongClickListener;
    this.l = paramIAdapterCallBack;
    this.n = ((int)(this.a.getResources().getDisplayMetrics().density * 2.0F));
    this.m = c();
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    if (paramInt1 + 1 < this.b.keySet().size()) {
      return 1;
    }
    List localList = (List)this.b.get(getGroup(paramInt1));
    if (((localList == null) && (paramInt2 == 0)) || ((localList != null) && (paramInt2 == localList.size()))) {
      return 2;
    }
    return 1;
  }
  
  @SuppressLint({"InflateParams"})
  private View a(int paramInt1, int paramInt2, View paramView)
  {
    Object localObject1 = getChild(paramInt1, paramInt2);
    Object localObject2;
    if (localObject1 != null) {
      localObject2 = (FavFileInfo)localObject1;
    } else {
      localObject2 = null;
    }
    this.o = false;
    if (localObject2 == null)
    {
      if (a(paramInt1, paramInt2) == 1) {
        return null;
      }
      if (this.l.b()) {
        return null;
      }
      paramView = new ImageHolder();
      localObject1 = this.d.inflate(2131627042, null);
      ((View)localObject1).setClickable(true);
      paramView.d = ((TextView)((View)localObject1).findViewById(2131449882));
      paramView.e = ((ProgressBar)((View)localObject1).findViewById(2131444560));
      paramView.f = ((ImageView)((View)localObject1).findViewById(2131437616));
      paramView.j = true;
      paramView.h = paramInt1;
      paramView.g = paramInt2;
      ((View)localObject1).setOnClickListener(this.l.a(paramView.d));
      ((View)localObject1).setTag(paramView);
      if (this.b.size() == 0)
      {
        ((View)localObject1).setVisibility(8);
      }
      else
      {
        ((View)localObject1).setVisibility(0);
        this.o = true;
      }
      if (this.l.a())
      {
        paramView.e.setVisibility(0);
        paramView.f.setVisibility(8);
        paramView.d.setText(2131889625);
        return localObject1;
      }
      paramView.e.setVisibility(8);
      paramView.f.setVisibility(0);
      paramView.d.setText(2131889357);
      return localObject1;
    }
    if (paramView == null) {
      localObject1 = paramView;
    }
    for (;;)
    {
      try
      {
        paramView = this.d.inflate(2131627052, null);
        localObject1 = paramView;
        ImageHolder localImageHolder = new ImageHolder();
        localObject1 = paramView;
        localImageHolder.a = ((AsyncImageView)paramView.findViewById(2131435357));
        localObject1 = paramView;
        localImageHolder.b = ((ImageView)paramView.findViewById(2131435382));
        localObject1 = paramView;
        localImageHolder.c = ((ImageView)paramView.findViewById(2131435377));
        localObject1 = paramView;
        localImageHolder.a.setOnClickListener(this.j);
        localObject1 = paramView;
        localImageHolder.b.setOnClickListener(this.i);
        localObject1 = paramView;
        localImageHolder.a.setTag(localImageHolder);
        localObject1 = paramView;
        localImageHolder.b.setTag(localImageHolder);
        localObject1 = paramView;
        localImageHolder.j = false;
        localObject1 = paramView;
        paramView.setTag(localImageHolder);
        continue;
        localObject1 = paramView;
        localImageHolder = (ImageHolder)paramView.getTag();
        localObject1 = paramView;
        if (localImageHolder.j)
        {
          localObject1 = paramView;
          paramView = this.d.inflate(2131627052, null);
          localObject1 = paramView;
          localImageHolder = new ImageHolder();
          localObject1 = paramView;
          localImageHolder.a = ((AsyncImageView)paramView.findViewById(2131435357));
          localObject1 = paramView;
          localImageHolder.b = ((ImageView)paramView.findViewById(2131435382));
          localObject1 = paramView;
          localImageHolder.c = ((ImageView)paramView.findViewById(2131435377));
          localObject1 = paramView;
          localImageHolder.a.setOnClickListener(this.j);
          localObject1 = paramView;
          localImageHolder.b.setOnClickListener(this.i);
          localObject1 = paramView;
          localImageHolder.a.setTag(localImageHolder);
          localObject1 = paramView;
          localImageHolder.b.setTag(localImageHolder);
          localObject1 = paramView;
          paramView.setTag(localImageHolder);
          localObject1 = paramView;
          localImageHolder.i = localObject2;
          localObject1 = paramView;
          localImageHolder.h = paramInt1;
          localObject1 = paramView;
          localImageHolder.g = paramInt2;
          localObject1 = paramView;
          localImageHolder.a.setAdjustViewBounds(false);
          localObject1 = paramView;
          localImageHolder.a.setScaleType(ImageView.ScaleType.CENTER_CROP);
          localObject1 = paramView;
          localImageHolder.a.setDefaultImage(2130849738);
          localObject1 = paramView;
          localImageHolder.a.setAsyncClipSize(this.m, this.m);
          localObject1 = paramView;
          localImageHolder.j = false;
          localObject1 = paramView;
          a((FavFileInfo)localObject2, localImageHolder.a);
          localObject1 = paramView;
          Object localObject3 = new StringBuilder();
          localObject1 = paramView;
          ((StringBuilder)localObject3).append(this.c.getString(2131889359));
          localObject1 = paramView;
          ((StringBuilder)localObject3).append(((FavFileInfo)localObject2).d);
          localObject1 = paramView;
          localObject3 = ((StringBuilder)localObject3).toString();
          localObject1 = paramView;
          if (this.c.D())
          {
            localObject1 = paramView;
            localImageHolder.b.setVisibility(0);
            localObject1 = paramView;
            localImageHolder.b.setClickable(true);
            localObject1 = paramView;
            if (this.l.a((FavFileInfo)localObject2))
            {
              localObject1 = paramView;
              localObject2 = new StringBuilder();
              localObject1 = paramView;
              ((StringBuilder)localObject2).append((String)localObject3);
              localObject1 = paramView;
              ((StringBuilder)localObject2).append(this.c.getString(2131889358));
              localObject1 = paramView;
              localObject2 = ((StringBuilder)localObject2).toString();
              localObject1 = paramView;
              localImageHolder.c.setVisibility(4);
              localObject1 = paramView;
              localImageHolder.b.setImageResource(2130847334);
              localObject1 = paramView;
              localImageHolder.b.setClickable(false);
            }
            else
            {
              localObject1 = paramView;
              if (FMDataCache.c((FavFileInfo)localObject2))
              {
                localObject1 = paramView;
                localObject2 = new StringBuilder();
                localObject1 = paramView;
                ((StringBuilder)localObject2).append((String)localObject3);
                localObject1 = paramView;
                ((StringBuilder)localObject2).append(this.c.getString(2131889360));
                localObject1 = paramView;
                localObject2 = ((StringBuilder)localObject2).toString();
                localObject1 = paramView;
                localImageHolder.b.setImageResource(2130841341);
                localObject1 = paramView;
                paramView.setBackgroundColor(this.c.getResources().getColor(2131168464));
                localObject1 = paramView;
                paramView.setOnLongClickListener(null);
              }
              else
              {
                localObject1 = paramView;
                localObject2 = new StringBuilder();
                localObject1 = paramView;
                ((StringBuilder)localObject2).append((String)localObject3);
                localObject1 = paramView;
                ((StringBuilder)localObject2).append(HardCodeUtil.a(2131889361));
                localObject1 = paramView;
                localObject2 = ((StringBuilder)localObject2).toString();
                localObject1 = paramView;
                localImageHolder.c.setVisibility(4);
                localObject1 = paramView;
                localImageHolder.b.setImageResource(2130847332);
                localObject1 = paramView;
                paramView.setOnLongClickListener(this.k);
              }
            }
          }
          else
          {
            localObject1 = paramView;
            localImageHolder.b.setVisibility(8);
            localObject1 = paramView;
            localImageHolder.c.setVisibility(8);
            localObject2 = localObject3;
          }
          localObject1 = paramView;
          localImageHolder.b.setContentDescription((CharSequence)localObject2);
          localObject1 = paramView;
          localImageHolder.a.setContentDescription((CharSequence)localObject2);
          return paramView;
        }
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
        QLog.e("#######", 1, paramView.toString());
        return localObject1;
      }
    }
  }
  
  private void a(FavFileInfo paramFavFileInfo, AsyncImageView paramAsyncImageView)
  {
    if ((!TextUtils.isEmpty(paramFavFileInfo.h)) && (FileUtils.fileExistsAndNotEmpty(paramFavFileInfo.h)))
    {
      paramAsyncImageView.setAsyncImage(paramFavFileInfo.h);
      return;
    }
    int i1 = 0;
    String str;
    if ((!TextUtils.isEmpty(paramFavFileInfo.n)) && (FileUtils.fileExistsAndNotEmpty(paramFavFileInfo.n)))
    {
      str = paramFavFileInfo.n;
    }
    else if ((!TextUtils.isEmpty(paramFavFileInfo.m)) && (FileUtils.fileExistsAndNotEmpty(paramFavFileInfo.m)))
    {
      str = paramFavFileInfo.m;
    }
    else if ((!TextUtils.isEmpty(paramFavFileInfo.l)) && (FileUtils.fileExistsAndNotEmpty(paramFavFileInfo.l)))
    {
      str = paramFavFileInfo.l;
    }
    else if ((!TextUtils.isEmpty(paramFavFileInfo.k)) && (FileUtils.fileExistsAndNotEmpty(paramFavFileInfo.k)))
    {
      str = paramFavFileInfo.k;
    }
    else
    {
      if ((!TextUtils.isEmpty(paramFavFileInfo.j)) && (FileUtils.fileExistsAndNotEmpty(paramFavFileInfo.j))) {
        str = paramFavFileInfo.j;
      } else if ((!TextUtils.isEmpty(paramFavFileInfo.i)) && (FileUtils.fileExistsAndNotEmpty(paramFavFileInfo.i))) {
        str = paramFavFileInfo.i;
      } else {
        str = "";
      }
      i1 = 1;
    }
    if (!TextUtils.isEmpty(str))
    {
      paramAsyncImageView.setAsyncImage(str);
      if (i1 == 0) {
        return;
      }
    }
    long l1 = System.currentTimeMillis();
    if (l1 - paramFavFileInfo.a(2) > 30000L)
    {
      ((IQQFileEngine)this.c.p.getRuntimeService(IQQFileEngine.class)).favProxydownloadThumb(paramFavFileInfo, 2);
      paramFavFileInfo.a(2, l1);
    }
  }
  
  private View b(int paramInt1, int paramInt2, View paramView)
  {
    Object localObject = (LinearLayout)paramView;
    paramView = (View)localObject;
    if (localObject == null) {
      paramView = d();
    }
    paramView.removeAllViews();
    QfileFavImageExpandableListAdapter.GridGroupHolder localGridGroupHolder = (QfileFavImageExpandableListAdapter.GridGroupHolder)paramView.getTag();
    int i1 = 0;
    while (i1 < 4)
    {
      View localView = a(paramInt1, paramInt2 * 4 + i1, localGridGroupHolder.a[i1]);
      if (localView == null) {
        return paramView;
      }
      localGridGroupHolder.a[i1] = localView;
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
      localObject = localLayoutParams;
      if (localLayoutParams == null)
      {
        i2 = this.m;
        localObject = new LinearLayout.LayoutParams(i2, i2);
      }
      int i2 = this.m;
      ((LinearLayout.LayoutParams)localObject).width = i2;
      ((LinearLayout.LayoutParams)localObject).height = i2;
      if (i1 != 0) {
        ((LinearLayout.LayoutParams)localObject).leftMargin = this.n;
      }
      ((LinearLayout.LayoutParams)localObject).topMargin = this.n;
      localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramView.addView(localView);
      i1 += 1;
    }
    return paramView;
  }
  
  private int c()
  {
    DisplayMetrics localDisplayMetrics = this.a.getResources().getDisplayMetrics();
    return (int)(localDisplayMetrics.widthPixels - localDisplayMetrics.density * 6.0F) / 4;
  }
  
  private LinearLayout d()
  {
    LinearLayout localLinearLayout = new LinearLayout(this.a);
    localLinearLayout.setOrientation(0);
    localLinearLayout.setClickable(false);
    localLinearLayout.setLongClickable(false);
    localLinearLayout.setTag(new QfileFavImageExpandableListAdapter.GridGroupHolder(null));
    return localLinearLayout;
  }
  
  int a()
  {
    return this.m + this.n;
  }
  
  boolean b()
  {
    return this.o;
  }
  
  public Object getChild(int paramInt1, int paramInt2)
  {
    Object localObject = this.b.keySet().iterator();
    int i1 = 0;
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if (i1 == paramInt1)
      {
        localObject = (List)this.b.get(str);
        if (localObject == null) {
          return null;
        }
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
    return b(paramInt1, paramInt2, paramView);
  }
  
  public int getChildrenCount(int paramInt)
  {
    Iterator localIterator = this.b.keySet().iterator();
    int i1 = 0;
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (i1 == paramInt)
      {
        paramInt = ((List)this.b.get(str)).size();
        if (paramInt < 4) {
          return 1;
        }
        return paramInt / 4 + 1;
      }
      i1 += 1;
    }
    if (!this.l.b()) {
      return 1;
    }
    return 0;
  }
  
  public Object getGroup(int paramInt)
  {
    Iterator localIterator = this.b.keySet().iterator();
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
    if (this.b.keySet().size() > 0) {
      return this.b.keySet().size();
    }
    return 0;
  }
  
  public long getGroupId(int paramInt)
  {
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.favfile.QfileFavImageExpandableListAdapter
 * JD-Core Version:    0.7.0.1
 */