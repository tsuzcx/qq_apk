package com.tencent.mobileqq.guild.setting;

import android.os.Handler;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.api.IQQGuildAvatarApi;
import com.tencent.mobileqq.guild.util.QQGuildAvatarLoader;
import com.tencent.mobileqq.guild.util.QQGuildAvatarLoader.OnAvatarLoadListener;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.GuildUserAvatar;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.SwipListView.RightIconMenuListener;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.util.WeakReference;

public class QQGuildMemberListAdapter
  extends BaseAdapter
  implements CompoundButton.OnCheckedChangeListener, QQGuildAvatarLoader.OnAvatarLoadListener, SwipListView.RightIconMenuListener
{
  private final SparseArray<Boolean> a = new SparseArray();
  private final WeakReference<QQGuildMemberFragment> b;
  private final List<QQGuildMemberListAdapter.UserInfoItem> c = new ArrayList();
  private final QQGuildMemberListViewModel d;
  private final QQGuildAvatarLoader e;
  private final GuildMemberListModel f = new GuildMemberListModel();
  private boolean g = false;
  private final int h;
  
  public QQGuildMemberListAdapter(QQGuildMemberFragment paramQQGuildMemberFragment, QQGuildMemberListViewModel paramQQGuildMemberListViewModel, int paramInt)
  {
    this.d = paramQQGuildMemberListViewModel;
    this.h = paramInt;
    this.b = new WeakReference(paramQQGuildMemberFragment);
    this.e = new QQGuildAvatarLoader(paramQQGuildMemberFragment.l());
    this.e.a(this);
    this.d.a().observe(paramQQGuildMemberFragment.getViewLifecycleOwner(), new QQGuildMemberListAdapter.1(this));
    this.d.g().observe(paramQQGuildMemberFragment.getViewLifecycleOwner(), new QQGuildMemberListAdapter.2(this));
    this.d.h().observe(paramQQGuildMemberFragment.getViewLifecycleOwner(), new QQGuildMemberListAdapter.3(this));
    this.d.i().observe(paramQQGuildMemberFragment.getViewLifecycleOwner(), new QQGuildMemberListAdapter.4(this));
    this.d.j().observe(paramQQGuildMemberFragment.getViewLifecycleOwner(), new QQGuildMemberListAdapter.5(this));
    this.d.k().observe(paramQQGuildMemberFragment.getViewLifecycleOwner(), new QQGuildMemberListAdapter.6(this));
  }
  
  private View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131625086, null);
    }
    paramView = a(paramInt);
    ((TextView)localView.findViewById(2131438059)).setText(paramView.b);
    return localView;
  }
  
  private void a(int paramInt, QQGuildMemberListAdapter.UserInfoItem paramUserInfoItem)
  {
    if (paramInt == this.c.size())
    {
      this.c.add(paramUserInfoItem);
      return;
    }
    this.c.add(paramInt, paramUserInfoItem);
  }
  
  private void a(int paramInt, IGProUserInfo paramIGProUserInfo)
  {
    QQGuildMemberListAdapter.UserInfoItem localUserInfoItem = new QQGuildMemberListAdapter.UserInfoItem();
    localUserInfoItem.c = paramIGProUserInfo;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt == 2)
        {
          a(q(), localUserInfoItem);
          this.f.w();
          return;
        }
        throw new InvalidParameterException("QQGuildMemberListAdapteraddDataItem invalid titleType");
      }
      a(p(), localUserInfoItem);
      this.f.u();
      return;
    }
    if (QQGuildUtil.b(paramIGProUserInfo)) {
      a(n(), localUserInfoItem);
    } else {
      a(o(), localUserInfoItem);
    }
    this.f.s();
  }
  
  private void a(ImageView paramImageView, GuildUserAvatar paramGuildUserAvatar)
  {
    paramGuildUserAvatar = ((IGPSService)c().getRuntimeService(IGPSService.class, "")).getFullAvatarUrl(paramGuildUserAvatar, 0);
    int i = (int)(DeviceInfoUtil.a * 36.0F);
    paramImageView.setImageDrawable(((IQQGuildAvatarApi)c().getRuntimeService(IQQGuildAvatarApi.class, "")).getAvatarDrawable(paramGuildUserAvatar, i, i, null));
  }
  
  private void a(IGProUserInfo paramIGProUserInfo)
  {
    if (!this.f.d()) {
      c(2);
    }
    QQGuildMemberListAdapter.UserInfoItem localUserInfoItem = new QQGuildMemberListAdapter.UserInfoItem();
    localUserInfoItem.c = paramIGProUserInfo;
    int i = m();
    while (i < this.c.size())
    {
      if (((QQGuildMemberListAdapter.UserInfoItem)this.c.get(i)).a != 1)
      {
        IGProUserInfo localIGProUserInfo = ((QQGuildMemberListAdapter.UserInfoItem)this.c.get(i)).c;
        if (paramIGProUserInfo.e() > localIGProUserInfo.e())
        {
          a(i, localUserInfoItem);
          this.f.w();
          return;
        }
      }
      i += 1;
    }
    a(q(), localUserInfoItem);
    this.f.w();
  }
  
  private boolean a(View paramView, String paramString, GuildUserAvatar paramGuildUserAvatar)
  {
    if ((paramView.getTag() instanceof QQGuildMemberListItemViewHolder))
    {
      paramView = (QQGuildMemberListItemViewHolder)paramView.getTag();
      if (((paramView.b.getTag() instanceof QQGuildMemberListAdapter.UserInfoItem)) && (paramString.equals(((QQGuildMemberListAdapter.UserInfoItem)paramView.b.getTag()).c.a())))
      {
        a(paramView.b, paramGuildUserAvatar);
        return true;
      }
    }
    return false;
  }
  
  private View b(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = new QQGuildMemberListItemViewHolder(this);
      paramViewGroup = paramView.a(paramViewGroup);
    }
    else
    {
      localObject = (QQGuildMemberListItemViewHolder)paramView.getTag();
      paramViewGroup = paramView;
      paramView = (View)localObject;
    }
    paramView.a = paramViewGroup;
    Object localObject = a(paramInt);
    if (localObject != null)
    {
      if (((QQGuildMemberListAdapter.UserInfoItem)localObject).c == null) {
        return paramViewGroup;
      }
      paramView.a(paramInt, (QQGuildMemberListAdapter.UserInfoItem)localObject, ((Boolean)this.a.get(paramInt, Boolean.valueOf(false))).booleanValue(), this.h);
    }
    return paramViewGroup;
  }
  
  private void b(IGProUserInfo paramIGProUserInfo)
  {
    int i = 0;
    while (i < this.c.size())
    {
      QQGuildMemberListAdapter.UserInfoItem localUserInfoItem = (QQGuildMemberListAdapter.UserInfoItem)this.c.get(i);
      if ((localUserInfoItem.a != 1) && (paramIGProUserInfo.a().equals(localUserInfoItem.c.a())))
      {
        if (QQGuildUtil.e(paramIGProUserInfo))
        {
          this.f.v();
          if (this.f.o() == 0)
          {
            this.c.remove(this.f.j());
            this.f.h();
          }
        }
        else if (QQGuildUtil.c(paramIGProUserInfo))
        {
          this.f.t();
        }
        else if (QQGuildUtil.d(paramIGProUserInfo))
        {
          this.f.x();
          this.f.r();
          if (this.f.p() == 0)
          {
            this.c.remove(this.f.k());
            this.f.i();
          }
        }
        this.c.remove(localUserInfoItem);
        return;
      }
      i += 1;
    }
  }
  
  private void c(int paramInt)
  {
    QQGuildMemberListAdapter.UserInfoItem localUserInfoItem;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt == 2)
        {
          localUserInfoItem = this.f.g();
          paramInt = m();
        }
        else
        {
          throw new InvalidParameterException("QQGuildMemberListAdapteraddTitleItem invalid titleType");
        }
      }
      else
      {
        localUserInfoItem = this.f.f();
        paramInt = l();
      }
    }
    else
    {
      localUserInfoItem = this.f.e();
      paramInt = k();
    }
    localUserInfoItem.a = 1;
    a(paramInt, localUserInfoItem);
  }
  
  private void c(IGProUserInfo paramIGProUserInfo)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramIGProUserInfo.a());
    this.d.b(localArrayList);
  }
  
  private void c(List<IGProUserInfo> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      b((IGProUserInfo)paramList.next());
    }
  }
  
  private void d(List<IGProUserInfo> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      IGProUserInfo localIGProUserInfo = (IGProUserInfo)paramList.next();
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        QQGuildMemberListAdapter.UserInfoItem localUserInfoItem = (QQGuildMemberListAdapter.UserInfoItem)localIterator.next();
        if ((localUserInfoItem.a == 0) && (localIGProUserInfo.a().equals(localUserInfoItem.c.a()))) {
          localUserInfoItem.c = localIGProUserInfo;
        }
      }
    }
  }
  
  private void j()
  {
    this.f.l();
    this.f.m();
    this.f.a(this.d.n());
  }
  
  private int k()
  {
    if (this.g) {
      return -1;
    }
    return 0;
  }
  
  private int l()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:632)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private int m()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:632)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private int n()
  {
    return k() + 1;
  }
  
  private int o()
  {
    return k() + this.f.n() + 1;
  }
  
  private int p()
  {
    return l() + this.f.o() + 1;
  }
  
  private int q()
  {
    return m() + this.f.p() + 1;
  }
  
  public QQGuildMemberListAdapter.UserInfoItem a(int paramInt)
  {
    if (this.c.size() > paramInt) {
      return (QQGuildMemberListAdapter.UserInfoItem)this.c.get(paramInt);
    }
    return null;
  }
  
  public QQGuildAvatarLoader a()
  {
    return this.e;
  }
  
  public IGProUserInfo a(String paramString)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      QQGuildMemberListAdapter.UserInfoItem localUserInfoItem = (QQGuildMemberListAdapter.UserInfoItem)localIterator.next();
      if ((localUserInfoItem.a != 1) && (localUserInfoItem.c.a().equals(paramString))) {
        return localUserInfoItem.c;
      }
    }
    return null;
  }
  
  public void a(String paramString, GuildUserAvatar paramGuildUserAvatar)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramGuildUserAvatar != null))
    {
      if (this.b.get() == null) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQGuildMemberListAdapter", 2, new Object[] { "onLoadFinish tinyId:", paramString });
      }
      ThreadManagerV2.getUIHandlerV2().post(new QQGuildMemberListAdapter.7(this, paramString, paramGuildUserAvatar));
    }
  }
  
  public void a(List<IGProUserInfo> paramList)
  {
    if (this.h == 1)
    {
      this.c.clear();
      this.f.a();
    }
    b(paramList);
    j();
    this.a.clear();
    notifyDataSetChanged();
    this.e.a(this.c);
  }
  
  public void a(List<IGProUserInfo> paramList, boolean paramBoolean)
  {
    if (this.b.get() == null) {
      return;
    }
    ((QQGuildMemberFragment)this.b.get()).a(paramList, paramBoolean);
  }
  
  public QQGuildMemberListViewModel b()
  {
    return this.d;
  }
  
  public void b(int paramInt)
  {
    this.f.a(paramInt);
    j();
    notifyDataSetChanged();
  }
  
  public void b(List<IGProUserInfo> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      IGProUserInfo localIGProUserInfo = (IGProUserInfo)paramList.next();
      if (QQGuildUtil.e(localIGProUserInfo))
      {
        if ((!this.g) && (!this.f.c())) {
          c(1);
        }
        a(1, localIGProUserInfo);
      }
      else if (QQGuildUtil.c(localIGProUserInfo))
      {
        if ((!this.g) && (!this.f.b())) {
          c(0);
        }
        a(0, localIGProUserInfo);
      }
      else if (QQGuildUtil.d(localIGProUserInfo))
      {
        if ((!this.g) && (!this.f.d())) {
          c(2);
        }
        a(2, localIGProUserInfo);
      }
    }
  }
  
  public AppInterface c()
  {
    if (this.b.get() == null) {
      return null;
    }
    return ((QQGuildMemberFragment)this.b.get()).l();
  }
  
  public QBaseActivity d()
  {
    if (this.b.get() == null) {
      return null;
    }
    return ((QQGuildMemberFragment)this.b.get()).getQBaseActivity();
  }
  
  public SparseArray<Boolean> e()
  {
    return this.a;
  }
  
  public void f()
  {
    this.e.a();
  }
  
  public void g()
  {
    this.g = true;
  }
  
  public int getCount()
  {
    return this.c.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    QQGuildMemberListAdapter.UserInfoItem localUserInfoItem = a(paramInt);
    if (localUserInfoItem != null) {
      return localUserInfoItem.a;
    }
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = getItemViewType(paramInt);
    View localView;
    if (i != 0)
    {
      if (i != 1) {
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
  
  public void h()
  {
    ((QQGuildMemberFragment)this.b.get()).i();
  }
  
  @Nullable
  public QBaseFragment i()
  {
    return (QBaseFragment)this.b.get();
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramCompoundButton.isShown())
    {
      if (paramBoolean) {
        this.a.put(((Integer)paramCompoundButton.getTag()).intValue(), Boolean.valueOf(true));
      } else {
        this.a.remove(((Integer)paramCompoundButton.getTag()).intValue());
      }
      if (this.a.size() == 0)
      {
        ((QQGuildMemberFragment)this.b.get()).a("移除", -2147483648);
      }
      else
      {
        QQGuildMemberFragment localQQGuildMemberFragment = (QQGuildMemberFragment)this.b.get();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("移除(");
        localStringBuilder.append(this.a.size());
        localStringBuilder.append(")");
        localQQGuildMemberFragment.a(localStringBuilder.toString(), -16777216);
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQGuildMemberListAdapter", 2, new Object[] { "onCheckedChanged mSelectedPositionList:", this.a.toString() });
      }
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
  
  public void onRightIconMenuHide(View paramView) {}
  
  public void onRightIconMenuShow(View paramView)
  {
    View localView = paramView.findViewById(2131436072);
    if (localView != null) {
      VideoReport.reportEvent("clck", localView, null);
    }
    if ((paramView.getTag() instanceof QQGuildMemberListItemViewHolder))
    {
      paramView = (QQGuildMemberListItemViewHolder)paramView.getTag();
      HashMap localHashMap;
      if (paramView.e.isShown())
      {
        localHashMap = new HashMap();
        localHashMap.put("sgrp_member_op_result", Integer.valueOf(3));
        VideoReport.reportEvent("imp", paramView.e, localHashMap);
      }
      if (paramView.d.isShown())
      {
        localHashMap = new HashMap();
        int j = ((QQGuildMemberListAdapter.UserInfoItem)localView.getTag()).c.d();
        int i = 1;
        if (j == 1) {
          i = 2;
        }
        localHashMap.put("sgrp_member_op_result", Integer.valueOf(i));
        VideoReport.reportEvent("imp", paramView.d, localHashMap);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.setting.QQGuildMemberListAdapter
 * JD-Core Version:    0.7.0.1
 */