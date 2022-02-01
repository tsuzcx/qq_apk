package com.tencent.mobileqq.guild.chatpie.quickAt;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.BaseMsgProxy;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.chatpie.GuildChatContext;
import com.tencent.mobileqq.guild.chatpie.quickAt.search.SearchSession;
import com.tencent.mobileqq.guild.chatpie.quickAt.search.SearchSession.SearchResultListener;
import com.tencent.mobileqq.guild.message.BaseGuildMessageManager;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.troop.quickat.ui.GuildAtDialog;
import com.tencent.mobileqq.troop.quickat.ui.SoftPanelStatus;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GuildAtManager
  implements PopupWindow.OnDismissListener, GuildAtPanelListener, SearchSession.SearchResultListener
{
  private QBaseActivity a;
  private GuildChatContext b;
  private QQAppInterface c;
  private BaseSessionInfo d;
  private GuildAtDialog e;
  private View f = null;
  private GuildAtListViewWrapper g;
  private String h;
  private boolean i = false;
  private boolean j = false;
  private final SearchSession k;
  private final GuildAtAllCountCache l;
  
  public GuildAtManager(GuildChatContext paramGuildChatContext)
  {
    this.b = paramGuildChatContext;
    this.c = paramGuildChatContext.a();
    this.a = paramGuildChatContext.b();
    this.d = paramGuildChatContext.O();
    this.k = new SearchSession(this.c, this);
    this.l = new GuildAtAllCountCache(paramGuildChatContext);
  }
  
  private void c(String paramString)
  {
    Object localObject1 = paramString.trim();
    paramString = this.b.T();
    String str = this.b.S();
    IGPSService localIGPSService = (IGPSService)this.c.getRuntimeService(IGPSService.class, "");
    int m;
    if (localIGPSService.getChannelInfo(paramString).getVisibleType() != 0) {
      m = 1;
    } else {
      m = 0;
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      if (m != 0)
      {
        this.k.a(str, paramString, (String)localObject1);
        return;
      }
      this.k.a(str, (String)localObject1);
      return;
    }
    Object localObject2 = this.c.getMessageFacade().s().a(10014).b(paramString, 10014, 0, true);
    localObject1 = new ArrayList();
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((List)localObject1).add(((MessageRecord)((Iterator)localObject2).next()).senderuin);
    }
    ((List)localObject1).add(localIGPSService.getSelfTinyId());
    if (m != 0) {
      this.k.a(str, paramString, (List)localObject1);
    } else {
      this.k.a(str, (List)localObject1);
    }
    this.k.a(str);
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.i("GuildAtManager", 2, "initPanel");
    }
    Object localObject = this.b.d(2131435808);
    this.e = GuildAtDialog.a(this.a, -1, -1);
    this.e.setTouchInterceptor(new GuildAtManager.1(this, (View)localObject));
    this.e.setOnDismissListener(this);
    localObject = (XListView)this.e.getContentView().findViewById(2131448034);
    this.g = new GuildAtListViewWrapper(this.c, BaseApplicationImpl.context, this.b, (XListView)localObject, this.l);
    this.g.d.a(this);
    this.e.a(this.g.d.c);
    g();
  }
  
  private void g()
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      if (!((GuildChatContext)localObject).X()) {
        return;
      }
      localObject = this.e.getContentView();
      ((View)localObject).findViewById(2131428827).setBackgroundResource(2130840899);
      Resources localResources = ((View)localObject).getContext().getResources();
      int m = localResources.getColor(2131166222);
      ((View)localObject).findViewById(2131448034).setBackgroundColor(m);
      ((TextView)((View)localObject).findViewById(2131428826)).setTextColor(localResources.getColor(2131166220));
      ((View)localObject).findViewById(2131428031).setBackground(null);
      ((TextView)((View)localObject).findViewById(2131437659)).setTextColor(localResources.getColor(2131166221));
      ((ProgressBar)((View)localObject).findViewById(2131427930)).setIndeterminateDrawable(localResources.getDrawable(2130840887));
    }
  }
  
  private void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuildAtManager", 2, "initMultiSelectMode: invoked. ");
    }
    this.g.d.c.b = false;
    TextView localTextView = (TextView)this.e.getContentView().findViewById(2131428826);
    if (localTextView != null) {
      localTextView.setText(2131892030);
    }
  }
  
  public void a()
  {
    SoftPanelStatus.a(this.a);
    this.e.showAtLocation(this.f, 0, 0, 0);
  }
  
  public void a(View paramView, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("GuildAtManager", 2, "showPanel");
    }
    if (this.e == null) {
      f();
    }
    this.h = paramString;
    this.f = paramView;
    this.i = true;
    this.l.a();
    if ((TextUtils.isEmpty(paramString)) && (TextUtils.isEmpty(this.h))) {
      h();
    }
    a();
    this.e.a(0, 2131886468);
    c(paramString);
  }
  
  public void a(String paramString)
  {
    if (this.g != null)
    {
      GuildAtDialog localGuildAtDialog = this.e;
      if ((localGuildAtDialog != null) && (localGuildAtDialog.isShowing())) {
        this.g.d.b(paramString);
      }
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (!this.i) {
      return;
    }
    a();
    this.e.a(8, 2131886469);
    this.g.d.a(paramString1, new ArrayList());
  }
  
  public void a(String paramString, List<IGProUserInfo> paramList)
  {
    if (!this.i) {
      return;
    }
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      this.e.a(8, 2131886468);
      a();
      this.g.d.a(paramString, paramList);
      if (this.j)
      {
        if (QLog.isColorLevel()) {
          QLog.d("GuildAtManager", 2, "From Multi");
        }
        return;
      }
      this.g.a.setAdapter(this.g.a.getAdapter());
      this.g.a.setSelection(0);
      return;
    }
    b();
  }
  
  public void b(String paramString)
  {
    this.j = true;
    c(paramString);
  }
  
  public boolean b()
  {
    GuildAtDialog localGuildAtDialog = this.e;
    if ((localGuildAtDialog != null) && (localGuildAtDialog.isShowing()))
    {
      this.e.dismiss();
      return true;
    }
    return false;
  }
  
  public void c()
  {
    b();
    this.e = null;
    this.k.a();
    this.l.c();
    GuildAtListViewWrapper localGuildAtListViewWrapper = this.g;
    if ((localGuildAtListViewWrapper != null) && (localGuildAtListViewWrapper.d != null)) {
      this.g.d.d();
    }
  }
  
  public boolean d()
  {
    GuildAtListViewWrapper localGuildAtListViewWrapper = this.g;
    if (localGuildAtListViewWrapper != null) {
      return localGuildAtListViewWrapper.d.f;
    }
    return false;
  }
  
  public boolean e()
  {
    return this.i;
  }
  
  public void onDismiss()
  {
    if (QLog.isColorLevel()) {
      QLog.i("GuildAtManager", 2, "onDismiss");
    }
    this.j = false;
    this.i = false;
    this.h = null;
    this.l.b();
    Object localObject = this.g;
    if (localObject != null) {
      ((GuildAtListViewWrapper)localObject).d.c();
    }
    int m = SoftPanelStatus.b(this.a);
    localObject = (InputMethodManager)this.a.getSystemService("input_method");
    View localView = this.a.findViewById(2131435808);
    if ((m == 2) && (localObject != null) && (localView != null)) {
      ((InputMethodManager)localObject).showSoftInput(localView, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.quickAt.GuildAtManager
 * JD-Core Version:    0.7.0.1
 */