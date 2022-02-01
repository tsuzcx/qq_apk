package com.tencent.mobileqq.guild.privatechannel;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.util.QQGuildAvatarLoader;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.InputMethodUtil;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.SwipListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GuildSelectMemberLayout
  extends LinearLayout
  implements Handler.Callback, View.OnClickListener
{
  private AppInterface a;
  private QQProgressDialog b;
  private final WeakReferenceHandler c = new WeakReferenceHandler(Looper.getMainLooper(), this);
  protected Context d;
  public SwipListView e;
  protected int f;
  public GuildPrivateMemberListAdapter g;
  protected View h;
  public EditText i;
  protected View j;
  public GuildPrivateSearchGridView k;
  protected GuildPrivateSearchGridAdapter l;
  public View m;
  private GuildSelectMemberLayout.ISelectMemberCallback n;
  private View o;
  private QQGuildAvatarLoader p;
  private boolean q;
  private int r = 0;
  private final View.OnTouchListener s = new GuildSelectMemberLayout.1(this);
  private final AbsListView.OnScrollListener t = new GuildSelectMemberLayout.2(this);
  
  public GuildSelectMemberLayout(Context paramContext)
  {
    super(paramContext);
    this.d = paramContext;
    d();
  }
  
  public GuildSelectMemberLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.d = paramContext;
    d();
  }
  
  public GuildSelectMemberLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.d = paramContext;
    d();
  }
  
  private void a(boolean paramBoolean)
  {
    this.k.setVisibility(8);
    this.h.setVisibility(0);
    if (paramBoolean == true)
    {
      h();
      this.i.requestFocus();
    }
  }
  
  private void a(GuildPrivateMemberListAdapter.UserInfoUIData[] paramArrayOfUserInfoUIData)
  {
    String[] arrayOfString = new String[paramArrayOfUserInfoUIData.length];
    int i1 = 0;
    while (i1 < paramArrayOfUserInfoUIData.length)
    {
      arrayOfString[i1] = paramArrayOfUserInfoUIData[i1].mTinyId;
      i1 += 1;
    }
    this.l.a(arrayOfString);
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.i == null) {
      return;
    }
    this.o.setVisibility(8);
    if (paramBoolean == true)
    {
      this.i.setHint(null);
      this.i.setText("");
      this.e.setVisibility(0);
      this.h.findViewById(2131448724).setVisibility(0);
      if (this.i.isFocused())
      {
        InputMethodUtil.b(this.i);
        this.i.clearFocus();
      }
    }
    GuildSelectMemberLayout.ISelectMemberCallback localISelectMemberCallback = this.n;
    if (localISelectMemberCallback != null) {
      localISelectMemberCallback.a();
    }
  }
  
  private void b(GuildPrivateMemberListAdapter.UserInfoUIData[] paramArrayOfUserInfoUIData)
  {
    ArrayList localArrayList = new ArrayList();
    int i2 = paramArrayOfUserInfoUIData.length;
    int i1 = 0;
    while (i1 < i2)
    {
      GuildPrivateMemberListAdapter.UserInfoUIData localUserInfoUIData = paramArrayOfUserInfoUIData[i1];
      GuildPrivateSearchGridAdapter.GridUIData localGridUIData = new GuildPrivateSearchGridAdapter.GridUIData(0);
      localGridUIData.c = localUserInfoUIData.mName;
      localGridUIData.b = localUserInfoUIData.mTinyId;
      localArrayList.add(localGridUIData);
      i1 += 1;
    }
    this.l.a(localArrayList);
  }
  
  private void d()
  {
    this.j = LayoutInflater.from(this.d).inflate(2131625119, this);
    this.m = this.j.findViewById(2131434710);
    this.e = ((SwipListView)this.j.findViewById(2131438055));
    View localView = LayoutInflater.from(this.d).inflate(2131625031, null);
    this.e.setOverScrollFooter(localView);
    this.b = new QQProgressDialog(this.d);
    e();
  }
  
  private void e()
  {
    this.h = this.j.findViewById(2131445390);
    this.h.setVisibility(0);
    this.i = ((EditText)this.h.findViewById(2131432634));
    this.i.clearFocus();
    GuildSelectMemberLayout.SearchTextWatcher localSearchTextWatcher = new GuildSelectMemberLayout.SearchTextWatcher(this, false);
    localSearchTextWatcher.a(this.i);
    this.i.addTextChangedListener(localSearchTextWatcher);
    this.o = this.h.findViewById(2131435215);
    this.i.setOnTouchListener(this.s);
    this.o.setOnClickListener(this);
    this.j.setFocusableInTouchMode(true);
  }
  
  private void f()
  {
    this.k = ((GuildPrivateSearchGridView)this.j.findViewById(2131445425));
    if (this.r == 1) {
      this.k.setBackground(getResources().getDrawable(2130840977));
    }
    this.l = new GuildPrivateSearchGridAdapter(this, this.p, this.r, new GuildSelectMemberLayout.SearchTextWatcher(this, true), new GuildSelectMemberLayout.SearchKeyListener(this));
    this.k.setAdapter(this.l);
    int i1 = (ViewUtils.getScreenWidth() - ViewUtils.dpToPx(20.0F)) / ViewUtils.dpToPx(83.0F);
    this.k.setNumColumns(i1);
    this.k.setMaxHeight(ViewUtils.dpToPx(120.0F));
    a(false);
  }
  
  private void g()
  {
    if (this.k.getVisibility() == 0) {
      return;
    }
    this.k.setVisibility(0);
    this.h.setVisibility(8);
    this.o.setVisibility(8);
    this.i.setHint(null);
    if (this.l.c != null) {
      this.l.c.setText(this.i.getText());
    }
    this.i.setText("");
  }
  
  private void h()
  {
    if (this.i.hasFocus()) {
      return;
    }
    this.h.findViewById(2131448724).setVisibility(8);
    this.i.setHint(getResources().getString(2131890513));
    if (TextUtils.isEmpty(this.i.getText()))
    {
      this.o.setVisibility(8);
      return;
    }
    this.o.setVisibility(0);
  }
  
  public void a()
  {
    this.c.sendEmptyMessageDelayed(15, 500L);
  }
  
  public void a(GuildPrivateMemberListAdapter.UserInfoUIData paramUserInfoUIData)
  {
    GuildSelectMemberLayout.ISelectMemberCallback localISelectMemberCallback = this.n;
    if (localISelectMemberCallback != null) {
      localISelectMemberCallback.b(paramUserInfoUIData);
    }
  }
  
  public void a(String paramString)
  {
    this.g.a(paramString);
  }
  
  public void a(List<GuildPrivateMemberListAdapter.UserInfoUIData> paramList)
  {
    this.g.a(paramList);
  }
  
  public boolean a(GuildPrivateMemberListAdapter.UserInfoUIData[] paramArrayOfUserInfoUIData, boolean paramBoolean)
  {
    GuildSelectMemberLayout.ISelectMemberCallback localISelectMemberCallback = this.n;
    boolean bool1;
    if (localISelectMemberCallback != null)
    {
      boolean bool2 = localISelectMemberCallback.a(paramArrayOfUserInfoUIData, paramBoolean);
      bool1 = bool2;
      if (bool2 == true) {
        if (paramBoolean)
        {
          b(paramArrayOfUserInfoUIData);
          bool1 = bool2;
        }
        else
        {
          a(paramArrayOfUserInfoUIData);
          bool1 = bool2;
        }
      }
    }
    else
    {
      bool1 = true;
    }
    if ((bool1 == true) && (this.q == true))
    {
      if (this.g.a().size() > 0)
      {
        g();
        return bool1;
      }
      a(true);
    }
    return bool1;
  }
  
  public void b()
  {
    this.c.removeMessages(15);
    QQProgressDialog localQQProgressDialog = this.b;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      this.b.dismiss();
    }
  }
  
  public void b(GuildPrivateMemberListAdapter.UserInfoUIData paramUserInfoUIData)
  {
    GuildSelectMemberLayout.ISelectMemberCallback localISelectMemberCallback = this.n;
    if (localISelectMemberCallback != null) {
      localISelectMemberCallback.a(paramUserInfoUIData);
    }
  }
  
  public void c()
  {
    GuildPrivateMemberListAdapter localGuildPrivateMemberListAdapter = this.g;
    if (localGuildPrivateMemberListAdapter != null) {
      localGuildPrivateMemberListAdapter.c();
    }
    b();
  }
  
  public AppInterface getAppInterface()
  {
    return this.a;
  }
  
  public HashMap<String, Boolean> getSelectedPositionList()
  {
    return this.g.a();
  }
  
  public GuildPrivateMemberListAdapter.UserInfoUIData[] getSelectedUIDataList()
  {
    return this.g.b();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 15) {
      this.b.show();
    }
    return false;
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.o) {
      b(true);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setInitData(AppInterface paramAppInterface, int paramInt)
  {
    setInitData(paramAppInterface, paramInt, true, 0);
  }
  
  public void setInitData(AppInterface paramAppInterface, int paramInt, boolean paramBoolean)
  {
    setInitData(paramAppInterface, paramInt, paramBoolean, 0);
  }
  
  public void setInitData(AppInterface paramAppInterface, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    this.f = paramInt1;
    this.q = paramBoolean;
    this.r = paramInt2;
    this.a = paramAppInterface;
    this.p = new QQGuildAvatarLoader(getAppInterface());
    this.g = new GuildPrivateMemberListAdapter(this, this.p, this.f);
    this.e.setAdapter(this.g);
    this.e.setDragEnable(true);
    this.e.setOnScrollListener(this.t);
    f();
    if (this.r == 1)
    {
      this.i.setBackgroundColor(15790838);
      this.j.findViewById(2131434693).setMinimumHeight(ViewUtils.dip2px(50.0F));
      paramInt1 = ViewUtils.dip2px(12.0F);
      paramAppInterface = (FrameLayout.LayoutParams)this.k.getLayoutParams();
      paramAppInterface.gravity = 80;
      paramAppInterface.setMargins(paramAppInterface.leftMargin, paramAppInterface.topMargin, paramAppInterface.rightMargin, paramInt1);
      this.k.setLayoutParams(paramAppInterface);
      paramInt2 = ViewUtils.dip2px(6.0F);
      this.k.setPadding(paramInt2, paramInt2, paramInt2, paramInt2);
      this.h.setBackground(getResources().getDrawable(2130840977));
      paramInt2 = ViewUtils.dip2px(16.0F);
      paramAppInterface = (FrameLayout.LayoutParams)this.h.getLayoutParams();
      paramAppInterface.gravity = 80;
      paramAppInterface.setMargins(paramInt2, paramAppInterface.topMargin, paramInt2, paramInt1);
      this.h.setLayoutParams(paramAppInterface);
    }
  }
  
  public void setSelectData(List<GuildPrivateMemberListAdapter.UserInfoUIData> paramList)
  {
    this.g.b(paramList);
  }
  
  public void setSelectItems(String[] paramArrayOfString)
  {
    this.g.a(paramArrayOfString, true);
  }
  
  public void setSelectMemberCallback(GuildSelectMemberLayout.ISelectMemberCallback paramISelectMemberCallback)
  {
    this.n = paramISelectMemberCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.privatechannel.GuildSelectMemberLayout
 * JD-Core Version:    0.7.0.1
 */