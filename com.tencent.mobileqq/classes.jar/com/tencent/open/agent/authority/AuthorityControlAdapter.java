package com.tencent.open.agent.authority;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.open.agent.AuthorityControlAppDetailsFragment;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.open.model.AppInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AuthorityControlAdapter
  extends BaseAdapter
  implements View.OnClickListener
{
  private final IphoneTitleBarFragment a;
  private Activity b;
  private QQAppInterface c;
  @NonNull
  private List<AppInfo> d = new ArrayList();
  private List<Integer> e;
  private boolean f;
  
  public AuthorityControlAdapter(IphoneTitleBarFragment paramIphoneTitleBarFragment, QQAppInterface paramQQAppInterface)
  {
    this.a = paramIphoneTitleBarFragment;
    this.b = paramIphoneTitleBarFragment.getBaseActivity();
    this.c = paramQQAppInterface;
    this.e = new ArrayList();
  }
  
  private void a(int paramInt, View paramView, AuthorityControlAdapter.ViewHolder paramViewHolder)
  {
    paramViewHolder.b = paramInt;
    paramViewHolder.d.setOnClickListener(this);
    AppInfo localAppInfo = (AppInfo)this.d.get(paramInt);
    String str = localAppInfo.c();
    paramView = str;
    if (str == null) {
      paramView = "";
    }
    paramViewHolder.g.setText(paramView.trim());
    paramViewHolder.h.setText(localAppInfo.b());
    paramViewHolder.e.setChecked(false);
    a(paramViewHolder, localAppInfo);
  }
  
  private void a(View paramView)
  {
    AuthorityControlAdapter.ViewHolder localViewHolder = (AuthorityControlAdapter.ViewHolder)paramView.getTag();
    if (this.f)
    {
      paramView = (CheckBox)paramView.findViewById(2131439016);
      boolean bool = paramView.isChecked() ^ true;
      paramView.setChecked(bool);
      if (paramView.isChecked())
      {
        this.e.add(Integer.valueOf(localViewHolder.b));
      }
      else
      {
        int i = localViewHolder.b;
        this.e.remove(Integer.valueOf(i));
      }
      if (this.e.size() > 0) {
        this.a.rightViewText.setEnabled(true);
      } else {
        this.a.rightViewText.setEnabled(false);
      }
      paramView = (AppInfo)this.d.get(localViewHolder.b);
      if (paramView != null) {
        paramView.a(bool);
      }
      if (QLog.isColorLevel())
      {
        paramView = new StringBuilder();
        paramView.append("onLayoutAppItemClick: invoked.  mCheckedPositions: ");
        paramView.append(this.e);
        QLog.i("AuthorityControlAdapter", 2, paramView.toString());
      }
    }
    else
    {
      paramView = (AppInfo)this.d.get(localViewHolder.b);
      AuthorityControlAppDetailsFragment.a(this.b, paramView);
      AuthorityUtil.a(this.c, "0X800B92F", new String[] { "", "", paramView.c(), "" });
    }
  }
  
  private void a(AuthorityControlAdapter.ViewHolder paramViewHolder)
  {
    paramViewHolder.e.setVisibility(8);
    paramViewHolder.c.setVisibility(0);
  }
  
  private void a(AuthorityControlAdapter.ViewHolder paramViewHolder, View paramView)
  {
    paramViewHolder.d = paramView.findViewById(2131436876);
    paramViewHolder.e = ((CheckBox)paramView.findViewById(2131439016));
    paramViewHolder.c = ((ImageView)paramView.findViewById(2131435051));
    paramViewHolder.g = ((TextView)paramView.findViewById(2131428634));
    paramViewHolder.h = ((TextView)paramView.findViewById(2131428645));
    paramViewHolder.f = ((ImageView)paramView.findViewById(2131428623));
    paramViewHolder.a = paramView.findViewById(2131437979);
  }
  
  private void a(AuthorityControlAdapter.ViewHolder paramViewHolder, AppInfo paramAppInfo)
  {
    Object localObject1 = paramAppInfo.d();
    Object localObject2 = this.b.getResources().getDrawable(2130838758);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    if (ThemeUtil.isNowThemeIsNight(this.c, false, null)) {
      paramViewHolder.a.setVisibility(0);
    } else {
      paramViewHolder.a.setVisibility(8);
    }
    localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject2);
    localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject2);
    localObject2 = paramViewHolder.f.getLayoutParams();
    localURLDrawableOptions.mRequestHeight = ((ViewGroup.LayoutParams)localObject2).height;
    localURLDrawableOptions.mRequestWidth = ((ViewGroup.LayoutParams)localObject2).width;
    try
    {
      localObject1 = URLDrawable.getDrawable((String)localObject1, localURLDrawableOptions);
      ((URLDrawable)localObject1).setTag(URLDrawableDecodeHandler.b(((ViewGroup.LayoutParams)localObject2).width, ((ViewGroup.LayoutParams)localObject2).height, UIUtils.a(this.b, 6.0F)));
      ((URLDrawable)localObject1).setDecodeHandler(URLDrawableDecodeHandler.j);
      paramViewHolder.f.setImageDrawable((Drawable)localObject1);
      label148:
      paramViewHolder.e.setChecked(paramAppInfo.e());
      return;
    }
    catch (Throwable localThrowable)
    {
      break label148;
    }
  }
  
  private void b(AuthorityControlAdapter.ViewHolder paramViewHolder)
  {
    paramViewHolder.e.setVisibility(0);
    paramViewHolder.c.setVisibility(8);
  }
  
  public void a(@NonNull List<AppInfo> paramList)
  {
    this.d = paramList;
  }
  
  public boolean a()
  {
    return this.f;
  }
  
  @NonNull
  public List<AppInfo> b()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext())
    {
      int i = ((Integer)localIterator.next()).intValue();
      if ((i < this.d.size()) && (i >= 0)) {
        localArrayList.add((AppInfo)this.d.get(i));
      }
    }
    return localArrayList;
  }
  
  public void b(List<AppInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator1 = this.d.iterator();
    while (localIterator1.hasNext())
    {
      AppInfo localAppInfo1 = (AppInfo)localIterator1.next();
      int j = 1;
      Iterator localIterator2 = paramList.iterator();
      AppInfo localAppInfo2;
      do
      {
        i = j;
        if (!localIterator2.hasNext()) {
          break;
        }
        localAppInfo2 = (AppInfo)localIterator2.next();
      } while (localAppInfo1.a() != localAppInfo2.a());
      int i = 0;
      if (i != 0) {
        localArrayList.add(localAppInfo1);
      }
    }
    this.d.clear();
    this.d.addAll(localArrayList);
  }
  
  public void c()
  {
    this.e.clear();
    notifyDataSetChanged();
  }
  
  public void d()
  {
    this.f = true;
    this.e.clear();
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext()) {
      ((AppInfo)localIterator.next()).a(false);
    }
    notifyDataSetChanged();
  }
  
  public void e()
  {
    this.f = false;
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.d.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.d.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView == null)
    {
      paramView = new AuthorityControlAdapter.ViewHolder(null);
      localView = LayoutInflater.from(this.b).inflate(2131624263, null);
      a(paramView, localView);
      localView.setTag(paramView);
    }
    else
    {
      AuthorityControlAdapter.ViewHolder localViewHolder = (AuthorityControlAdapter.ViewHolder)paramView.getTag();
      localView = paramView;
      paramView = localViewHolder;
    }
    a(paramInt, localView, paramView);
    if (this.f) {
      b(paramView);
    } else {
      a(paramView);
    }
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131436876) {
      a(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.authority.AuthorityControlAdapter
 * JD-Core Version:    0.7.0.1
 */