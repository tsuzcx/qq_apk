package com.tencent.mobileqq.guild.privatechannel;

import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.api.IQQGuildAvatarApi;
import com.tencent.mobileqq.guild.util.QQGuildAvatarLoader;
import com.tencent.mobileqq.guild.util.QQGuildAvatarLoader.OnAvatarLoadListener;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.GuildUserAvatar;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class GuildPrivateMemberListAdapter
  extends BaseAdapter
  implements QQGuildAvatarLoader.OnAvatarLoadListener
{
  public final GuildSelectMemberLayout a;
  public final int b;
  private final HashMap<String, Boolean> c = new HashMap();
  private final QQGuildAvatarLoader d;
  private List<GuildPrivateMemberListAdapter.UserInfoUIData> e = new ArrayList();
  private final HashMap<String, GuildPrivateMemberListAdapter.UserInfoUIData> f = new HashMap();
  
  public GuildPrivateMemberListAdapter(GuildSelectMemberLayout paramGuildSelectMemberLayout, QQGuildAvatarLoader paramQQGuildAvatarLoader, int paramInt)
  {
    this.d = paramQQGuildAvatarLoader;
    this.d.a(this);
    this.a = paramGuildSelectMemberLayout;
    this.b = paramInt;
  }
  
  private View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131625117, null);
    }
    return localView;
  }
  
  private void a(ImageView paramImageView, GuildUserAvatar paramGuildUserAvatar)
  {
    paramGuildUserAvatar = ((IGPSService)e().getRuntimeService(IGPSService.class, "")).getFullAvatarUrl(paramGuildUserAvatar, 0);
    int i = (int)(DeviceInfoUtil.a * 36.0F);
    paramImageView.setImageDrawable(((IQQGuildAvatarApi)e().getRuntimeService(IQQGuildAvatarApi.class, "")).getAvatarDrawable(paramGuildUserAvatar, i, i, null));
  }
  
  private boolean a(View paramView, String paramString, GuildUserAvatar paramGuildUserAvatar)
  {
    if ((paramView.getTag() instanceof GuildPrivateSearchItemHolder))
    {
      paramView = (GuildPrivateSearchItemHolder)paramView.getTag();
      if (((paramView.a.getTag() instanceof GuildPrivateSearchGridAdapter.GridUIData)) && (paramString.equals(((GuildPrivateSearchGridAdapter.GridUIData)paramView.a.getTag()).b)))
      {
        a(paramView.a, paramGuildUserAvatar);
        return true;
      }
    }
    return false;
  }
  
  private View b(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131625086, null);
    }
    paramView = a(paramInt);
    ((TextView)localView.findViewById(2131438059)).setText(paramView.mTitleName);
    return localView;
  }
  
  private boolean b(View paramView, String paramString, GuildUserAvatar paramGuildUserAvatar)
  {
    if ((paramView.getTag() instanceof GuildPrivateMemberListViewHolder))
    {
      paramView = (GuildPrivateMemberListViewHolder)paramView.getTag();
      if (((paramView.a.getTag() instanceof GuildPrivateMemberListAdapter.UserInfoUIData)) && (paramString.equals(((GuildPrivateMemberListAdapter.UserInfoUIData)paramView.a.getTag()).mTinyId)))
      {
        a(paramView.a, paramGuildUserAvatar);
        return true;
      }
    }
    return false;
  }
  
  private View c(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = new GuildPrivateMemberListViewHolder(this);
      paramViewGroup = paramView.a(paramViewGroup);
    }
    else
    {
      localObject = (GuildPrivateMemberListViewHolder)paramView.getTag();
      paramViewGroup = paramView;
      paramView = (View)localObject;
    }
    Object localObject = a(paramInt);
    if (localObject == null) {
      return paramViewGroup;
    }
    paramView.a(paramInt, (GuildPrivateMemberListAdapter.UserInfoUIData)localObject, this.c.containsKey(((GuildPrivateMemberListAdapter.UserInfoUIData)localObject).mTinyId));
    return paramViewGroup;
  }
  
  public GuildPrivateMemberListAdapter.UserInfoUIData a(int paramInt)
  {
    List localList = this.e;
    if ((localList != null) && (localList.size() > paramInt)) {
      return (GuildPrivateMemberListAdapter.UserInfoUIData)this.e.get(paramInt);
    }
    return null;
  }
  
  public HashMap<String, Boolean> a()
  {
    return this.c;
  }
  
  public void a(GuildPrivateMemberListAdapter.UserInfoUIData paramUserInfoUIData)
  {
    this.a.b(paramUserInfoUIData);
  }
  
  public void a(String paramString)
  {
    if (!this.f.containsKey(paramString)) {
      return;
    }
    GuildPrivateMemberListAdapter.UserInfoUIData localUserInfoUIData = (GuildPrivateMemberListAdapter.UserInfoUIData)this.f.get(paramString);
    this.e.remove(localUserInfoUIData);
    this.f.remove(paramString);
    notifyDataSetChanged();
  }
  
  public void a(String paramString, GuildUserAvatar paramGuildUserAvatar)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramGuildUserAvatar != null))
    {
      if (this.a == null) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("GuildPrivateMemberListAdapter", 2, new Object[] { "onLoadFinish tinyId:", paramString });
      }
      ThreadManagerV2.getUIHandlerV2().post(new GuildPrivateMemberListAdapter.1(this, paramString, paramGuildUserAvatar));
    }
  }
  
  public void a(List<GuildPrivateMemberListAdapter.UserInfoUIData> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      GuildPrivateMemberListAdapter.UserInfoUIData localUserInfoUIData = (GuildPrivateMemberListAdapter.UserInfoUIData)paramList.next();
      if (localUserInfoUIData != null) {
        if (localUserInfoUIData.mType == 0)
        {
          if (!TextUtils.isEmpty(localUserInfoUIData.mTinyId))
          {
            if (!this.f.containsKey(localUserInfoUIData.mTinyId))
            {
              this.e.add(localUserInfoUIData);
              this.f.put(localUserInfoUIData.mTinyId, localUserInfoUIData);
            }
          }
          else {
            this.e.add(localUserInfoUIData);
          }
        }
        else {
          this.e.add(localUserInfoUIData);
        }
      }
    }
    notifyDataSetChanged();
    this.d.b(this.e);
  }
  
  public void a(String[] paramArrayOfString, boolean paramBoolean)
  {
    Object localObject = new ArrayList();
    int j = 0;
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      String str = paramArrayOfString[i];
      if (paramBoolean)
      {
        if (!this.c.containsKey(str))
        {
          this.c.put(str, Boolean.valueOf(true));
          if (this.f.containsKey(str) == true) {
            ((ArrayList)localObject).add(this.f.get(str));
          }
        }
      }
      else if (this.c.containsKey(str) == true)
      {
        this.c.remove(str);
        if (this.f.containsKey(str))
        {
          ((ArrayList)localObject).add(this.f.get(str));
        }
        else
        {
          GuildPrivateMemberListAdapter.UserInfoUIData localUserInfoUIData = new GuildPrivateMemberListAdapter.UserInfoUIData(0);
          localUserInfoUIData.mTinyId = str;
          ((ArrayList)localObject).add(localUserInfoUIData);
        }
      }
      i += 1;
    }
    boolean bool = this.a.a((GuildPrivateMemberListAdapter.UserInfoUIData[])((ArrayList)localObject).toArray(new GuildPrivateMemberListAdapter.UserInfoUIData[((ArrayList)localObject).size()]), paramBoolean);
    if ((paramBoolean) && (!bool))
    {
      int k = paramArrayOfString.length;
      i = j;
      while (i < k)
      {
        localObject = paramArrayOfString[i];
        this.c.remove(localObject);
        i += 1;
      }
    }
    notifyDataSetChanged();
  }
  
  public boolean a(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (!paramCompoundButton.isShown()) {
      return true;
    }
    paramCompoundButton = (GuildPrivateMemberListAdapter.UserInfoUIData)paramCompoundButton.getTag();
    if (paramBoolean) {
      this.c.put(paramCompoundButton.mTinyId, Boolean.valueOf(true));
    } else {
      this.c.remove(paramCompoundButton.mTinyId);
    }
    if (QLog.isColorLevel()) {
      QLog.d("GuildPrivateMemberListAdapter", 2, new Object[] { "onCheckedChanged mSelectedPositionList:", this.c.toString() });
    }
    boolean bool = this.a.a(new GuildPrivateMemberListAdapter.UserInfoUIData[] { paramCompoundButton }, paramBoolean);
    if ((paramBoolean) && (!bool)) {
      this.c.remove(paramCompoundButton.mTinyId);
    }
    return bool;
  }
  
  public void b(GuildPrivateMemberListAdapter.UserInfoUIData paramUserInfoUIData)
  {
    this.a.a(paramUserInfoUIData);
  }
  
  public void b(List<GuildPrivateMemberListAdapter.UserInfoUIData> paramList)
  {
    this.e.clear();
    this.f.clear();
    if (paramList != null)
    {
      this.e.addAll(paramList);
      this.d.b(this.e);
    }
    notifyDataSetInvalidated();
  }
  
  public GuildPrivateMemberListAdapter.UserInfoUIData[] b()
  {
    Iterator localIterator = this.c.keySet().iterator();
    GuildPrivateMemberListAdapter.UserInfoUIData[] arrayOfUserInfoUIData = new GuildPrivateMemberListAdapter.UserInfoUIData[this.c.size()];
    int i = 0;
    while (localIterator.hasNext())
    {
      arrayOfUserInfoUIData[i] = ((GuildPrivateMemberListAdapter.UserInfoUIData)this.f.get(localIterator.next()));
      i += 1;
    }
    return arrayOfUserInfoUIData;
  }
  
  public void c()
  {
    this.d.a();
  }
  
  public QQGuildAvatarLoader d()
  {
    return this.d;
  }
  
  public AppInterface e()
  {
    GuildSelectMemberLayout localGuildSelectMemberLayout = this.a;
    if (localGuildSelectMemberLayout == null) {
      return null;
    }
    return localGuildSelectMemberLayout.getAppInterface();
  }
  
  public int getCount()
  {
    List localList = this.e;
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    GuildPrivateMemberListAdapter.UserInfoUIData localUserInfoUIData = a(paramInt);
    if (localUserInfoUIData != null) {
      return localUserInfoUIData.mType;
    }
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = getItemViewType(paramInt);
    View localView;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          localView = paramView;
        } else {
          localView = b(paramInt, paramView, paramViewGroup);
        }
      }
      else {
        localView = a(paramInt, paramView, paramViewGroup);
      }
    }
    else {
      localView = c(paramInt, paramView, paramViewGroup);
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
  
  public int getViewTypeCount()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.privatechannel.GuildPrivateMemberListAdapter
 * JD-Core Version:    0.7.0.1
 */