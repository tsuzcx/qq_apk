package com.tencent.mobileqq.selectmember;

import SecurityAccountServer.RespondQueryQQBindingStat;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.phonecontact.observer.ContactBindObserver;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.IndexView.OnIndexChangedListener;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.mobileqq.widget.PinnedDividerListView.OnLayoutListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import mqq.os.MqqHandler;

public class PhoneContactTabView
  extends TroopDiscussionBaseV
  implements View.OnClickListener, View.OnTouchListener, IndexView.OnIndexChangedListener, PinnedDividerListView.OnLayoutListener
{
  PinnedDividerListView a;
  List<PhoneContact> b;
  ContactFriendInnerFrame c;
  private IPhoneContactService i;
  private ContactBindObserver j;
  private PhoneContactTabView.ContactsListAdapter k;
  private IndexView l;
  private TextView m;
  private String n;
  private MqqHandler o = new PhoneContactTabView.2(this);
  
  public PhoneContactTabView(SelectMemberActivity paramSelectMemberActivity, ContactFriendInnerFrame paramContactFriendInnerFrame)
  {
    super(paramSelectMemberActivity);
    this.c = paramContactFriendInnerFrame;
  }
  
  private void g()
  {
    this.a.setVisibility(8);
    this.l.setVisibility(8);
  }
  
  private void h()
  {
    this.a = ((PinnedDividerListView)findViewById(2131430527));
    this.l = ((IndexView)findViewById(2131435678));
    this.l.setIndex(new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#" });
    this.l.setOnIndexChangedListener(this);
    this.a.setSelector(2131168376);
    this.a.setOnLayoutListener(this);
    this.m = ((TextView)findViewById(2131448820));
    this.m.setOnClickListener(new PhoneContactTabView.1(this));
  }
  
  private void i()
  {
    if (this.i == null) {
      this.i = ((IPhoneContactService)this.f.getRuntimeService(IPhoneContactService.class, ""));
    }
    if (this.j == null) {
      this.j = new PhoneContactTabView.3(this);
    }
    this.f.registObserver(this.j);
  }
  
  private void j() {}
  
  public void a(Bundle paramBundle)
  {
    setContentView(2131629255);
    this.i = ((IPhoneContactService)this.f.getRuntimeService(IPhoneContactService.class, ""));
    this.f.setHandler(PhoneContactTabView.class, this.o);
    h();
    this.k = new PhoneContactTabView.ContactsListAdapter(this, this.d, this.f, this.a, false);
    this.a.setAdapter(this.k);
    this.d.setupTitleBar(false, this.d.getString(2131916208), this.d.mTitleString);
    int i1 = this.i.getSelfBindState();
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("onStart state:");
      paramBundle.append(i1);
      QLog.i("ContactsInnerFrame", 2, paramBundle.toString());
    }
    if ((i1 != 0) && (i1 != 1) && (i1 != 5)) {
      if (i1 != 6)
      {
        if (i1 != 7)
        {
          if (i1 != 9)
          {
            i();
            return;
          }
          d();
        }
      }
      else
      {
        if (this.i.getSelfBindInfo().lastUsedFlag == 2L)
        {
          d();
          return;
        }
        g();
        return;
      }
    }
    g();
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (((this.a.getFirstVisiblePosition() > 0) || ((this.a.getFirstVisiblePosition() == 0) && (this.a.getChildCount() < this.k.getCount() + this.a.getHeaderViewsCount()))) && (!this.d.isSoftInputShowing()))
    {
      this.l.setVisibility(0);
      this.o.sendEmptyMessage(1);
      return;
    }
    this.l.setVisibility(4);
    this.o.sendEmptyMessage(2);
  }
  
  public void b()
  {
    super.b();
    this.o.removeMessages(3);
    this.f.removeHandler(PhoneContactTabView.class);
    PhoneContactTabView.ContactsListAdapter localContactsListAdapter = this.k;
    if (localContactsListAdapter != null) {
      localContactsListAdapter.d();
    }
    this.f.unRegistObserver(this.j);
  }
  
  public void c()
  {
    this.k.notifyDataSetChanged();
  }
  
  public void d()
  {
    this.b = this.i.getContactListForPhoneSelector();
    if (this.b == null)
    {
      this.o.removeMessages(3);
      this.o.sendEmptyMessageDelayed(3, 1000L);
    }
    else
    {
      if (this.k == null)
      {
        this.k = new PhoneContactTabView.ContactsListAdapter(this, this.d, this.f, this.a, false);
        this.a.setAdapter(this.k);
      }
      this.k.b();
    }
    this.a.setVisibility(0);
    this.l.setVisibility(0);
    this.m.setVisibility(8);
  }
  
  public String getGroupUin()
  {
    return "-1";
  }
  
  public void onClick(View paramView)
  {
    paramView.getId();
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onIndexChanged(String paramString)
  {
    if ("$".equals(paramString))
    {
      this.a.setSelection(0);
      return;
    }
    int i1 = this.k.b(paramString);
    if (i1 != -1)
    {
      paramString = this.a;
      paramString.setSelection(i1 + paramString.getHeaderViewsCount());
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    paramMotionEvent.getAction();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.PhoneContactTabView
 * JD-Core Version:    0.7.0.1
 */