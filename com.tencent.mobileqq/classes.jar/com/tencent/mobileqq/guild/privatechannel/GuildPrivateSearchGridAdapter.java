package com.tencent.mobileqq.guild.privatechannel;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.EditText;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.util.QQGuildAvatarLoader;
import com.tencent.mobileqq.guild.util.QQGuildAvatarLoader.OnAvatarLoadListener;
import com.tencent.mobileqq.qqguildsdk.data.GuildUserAvatar;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public class GuildPrivateSearchGridAdapter
  extends BaseAdapter
  implements QQGuildAvatarLoader.OnAvatarLoadListener
{
  public final GuildSelectMemberLayout a;
  public final int b;
  public EditText c;
  private final GuildPrivateSearchGridAdapter.GridUIData d;
  private final GuildSelectMemberLayout.SearchTextWatcher e;
  private final GuildSelectMemberLayout.SearchKeyListener f;
  private final QQGuildAvatarLoader g;
  private TouchCrossLinearLayout h;
  private ArrayList<GuildPrivateSearchGridAdapter.GridUIData> i = new ArrayList();
  private LinkedHashMap<String, GuildPrivateSearchGridAdapter.GridUIData> j = new LinkedHashMap();
  
  public GuildPrivateSearchGridAdapter(GuildSelectMemberLayout paramGuildSelectMemberLayout, QQGuildAvatarLoader paramQQGuildAvatarLoader, int paramInt, GuildSelectMemberLayout.SearchTextWatcher paramSearchTextWatcher, GuildSelectMemberLayout.SearchKeyListener paramSearchKeyListener)
  {
    this.a = paramGuildSelectMemberLayout;
    this.g = paramQQGuildAvatarLoader;
    this.b = paramInt;
    this.d = new GuildPrivateSearchGridAdapter.GridUIData(1);
    this.e = paramSearchTextWatcher;
    this.f = paramSearchKeyListener;
    this.g.a(this);
  }
  
  private View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131625116, null);
      paramViewGroup = (EditText)paramView.findViewById(2131432634);
      this.h = ((TouchCrossLinearLayout)paramView.findViewById(2131434709));
      this.e.a(paramViewGroup);
      paramViewGroup.addTextChangedListener(this.e);
      paramViewGroup.setOnKeyListener(this.f);
      this.c = paramViewGroup;
      localView = paramView;
      if (this.b == 1)
      {
        this.c.setBackgroundColor(15790838);
        localView = paramView;
      }
    }
    int k = this.a.k.getNumColumns();
    int m = ViewUtils.getScreenWidth();
    int n = ViewUtils.dpToPx(10.0F);
    int i1 = ViewUtils.dpToPx(20.0F);
    int i2 = ViewUtils.dpToPx(85.0F);
    this.h.setLayoutParams(new ViewGroup.LayoutParams(m - n - (i1 + paramInt % k * i2), -2));
    return localView;
  }
  
  private View b(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = new GuildPrivateSearchItemHolder(this);
      View localView = paramView.a(paramViewGroup);
      paramViewGroup = paramView;
      paramView = localView;
    }
    else
    {
      paramViewGroup = (GuildPrivateSearchItemHolder)paramView.getTag();
    }
    paramViewGroup.a(a(paramInt));
    return paramView;
  }
  
  public GuildPrivateSearchGridAdapter.GridUIData a(int paramInt)
  {
    ArrayList localArrayList = this.i;
    if (localArrayList != null)
    {
      if (paramInt < localArrayList.size()) {
        return (GuildPrivateSearchGridAdapter.GridUIData)this.i.get(paramInt);
      }
      return this.d;
    }
    return null;
  }
  
  public ArrayList<GuildPrivateSearchGridAdapter.GridUIData> a()
  {
    return this.i;
  }
  
  public void a(String paramString, GuildUserAvatar paramGuildUserAvatar) {}
  
  public void a(List<GuildPrivateSearchGridAdapter.GridUIData> paramList)
  {
    this.i.addAll(paramList);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      GuildPrivateSearchGridAdapter.GridUIData localGridUIData = (GuildPrivateSearchGridAdapter.GridUIData)paramList.next();
      if ((this.j.containsKey(localGridUIData.b)) && (QLog.isColorLevel()))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("same tinyID:");
        localStringBuilder.append(localGridUIData.b);
        QLog.e("GuildPrivateSearchGridAdapter", 2, localStringBuilder.toString());
      }
      this.j.put(localGridUIData.b, localGridUIData);
    }
    paramList = this.c;
    if (paramList != null)
    {
      paramList.setText("");
      this.a.k.postDelayed(new GuildPrivateSearchGridAdapter.1(this), 200L);
    }
    notifyDataSetChanged();
  }
  
  public void a(String[] paramArrayOfString)
  {
    int m = paramArrayOfString.length;
    int k = 0;
    while (k < m)
    {
      String str = paramArrayOfString[k];
      if (this.j.containsKey(str))
      {
        this.i.remove(this.j.get(str));
        this.j.remove(str);
      }
      k += 1;
    }
    notifyDataSetChanged();
  }
  
  public QQGuildAvatarLoader b()
  {
    return this.g;
  }
  
  public AppInterface c()
  {
    GuildSelectMemberLayout localGuildSelectMemberLayout = this.a;
    if (localGuildSelectMemberLayout == null) {
      return null;
    }
    return localGuildSelectMemberLayout.getAppInterface();
  }
  
  public int getCount()
  {
    ArrayList localArrayList = this.i;
    if (localArrayList != null) {
      return localArrayList.size() + 1;
    }
    return 0;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt < this.i.size()) {
      return 0;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int k = getItemViewType(paramInt);
    View localView;
    if (k != 0)
    {
      if (k != 1) {
        localView = paramView;
      } else {
        localView = a(paramInt, paramView, paramViewGroup);
      }
    }
    else {
      localView = b(paramInt, paramView, paramViewGroup);
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.privatechannel.GuildPrivateSearchGridAdapter
 * JD-Core Version:    0.7.0.1
 */