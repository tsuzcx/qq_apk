package com.tencent.mobileqq.selectmember;

import SecurityAccountServer.RespondQueryQQBindingStat;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.phonecontact.observer.ContactBindObserver;
import com.tencent.mobileqq.search.business.contact.fragment.ContactSearchFragment;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.IndexView.OnIndexChangedListener;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.mobileqq.widget.PinnedDividerListView.OnLayoutListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import mqq.os.MqqHandler;

public class ContactsInnerFrame
  extends SelectMemberInnerFrame
  implements View.OnClickListener, IndexView.OnIndexChangedListener, PinnedDividerListView.OnLayoutListener
{
  PinnedDividerListView a;
  List<PhoneContact> b;
  private IPhoneContactService c;
  private ContactBindObserver d;
  private ContactsInnerFrame.ContactsListAdapter e;
  private IndexView j;
  private MqqHandler k = new ContactsInnerFrame.1(this);
  
  public ContactsInnerFrame(Context paramContext)
  {
    super(paramContext);
  }
  
  public ContactsInnerFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ContactsInnerFrame(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void g()
  {
    this.a = ((PinnedDividerListView)findViewById(2131430527));
    this.j = ((IndexView)findViewById(2131435678));
    this.j.setIndex(new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#" });
    this.j.setOnIndexChangedListener(this);
    this.a.setSelector(2131168376);
    this.a.setOnLayoutListener(this);
  }
  
  private void h()
  {
    this.b = this.c.getContactListForSelector();
    if (this.b == null)
    {
      this.k.removeMessages(3);
      this.k.sendEmptyMessageDelayed(3, 1000L);
      return;
    }
    if (this.e == null)
    {
      this.e = new ContactsInnerFrame.ContactsListAdapter(this, this.f, this.h, this.a, false);
      this.a.setAdapter(this.e);
    }
    this.e.b();
  }
  
  private void i()
  {
    if (this.c == null) {
      this.c = ((IPhoneContactService)this.h.getRuntimeService(IPhoneContactService.class, ""));
    }
    if (this.d == null) {
      this.d = new ContactsInnerFrame.2(this);
    }
    this.h.registObserver(this.d);
  }
  
  private void j() {}
  
  public void a()
  {
    super.a();
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    setContentView(2131629255);
    this.c = ((IPhoneContactService)this.h.getRuntimeService(IPhoneContactService.class, ""));
    this.h.setHandler(ContactsInnerFrame.class, this.k);
    g();
    this.e = new ContactsInnerFrame.ContactsListAdapter(this, this.f, this.h, this.a, false);
    this.a.setAdapter(this.e);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (((this.a.getFirstVisiblePosition() > 0) || ((this.a.getFirstVisiblePosition() == 0) && (this.a.getChildCount() < this.e.getCount() + this.a.getHeaderViewsCount()))) && (!this.f.isSoftInputShowing()))
    {
      this.j.setVisibility(0);
      this.k.sendEmptyMessage(1);
      return;
    }
    this.j.setVisibility(4);
    this.k.sendEmptyMessage(2);
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    this.f.setupTitleBar(true, this.f.getString(2131916220), this.f.getString(2131892489));
    int i = this.c.getSelfBindState();
    if (i != 0) {
      if ((i != 1) && (i != 5))
      {
        if (i != 6)
        {
          if ((i != 7) && (i != 9)) {
            i();
          }
        }
        else
        {
          if (this.c.getSelfBindInfo().lastUsedFlag == 2L)
          {
            h();
            return;
          }
          j();
        }
      }
      else
      {
        j();
        return;
      }
    }
    h();
  }
  
  public void d()
  {
    super.d();
    this.k.removeMessages(3);
    this.h.removeHandler(ContactsInnerFrame.class);
    ContactsInnerFrame.ContactsListAdapter localContactsListAdapter = this.e;
    if (localContactsListAdapter != null) {
      localContactsListAdapter.d();
    }
    this.h.unRegistObserver(this.d);
  }
  
  public void f()
  {
    this.e.notifyDataSetChanged();
  }
  
  public ContactSearchFragment getContactSearchFragment()
  {
    return ContactSearchFragment.a(-1, 768, null, this.f.mUinsToHide, this.f);
  }
  
  public String getGroupUin()
  {
    return "-1";
  }
  
  public void onClick(View paramView)
  {
    SelectActivityViewHolder localSelectActivityViewHolder = (SelectActivityViewHolder)paramView.getTag();
    if ((localSelectActivityViewHolder != null) && (localSelectActivityViewHolder.a != null) && (localSelectActivityViewHolder.b != null))
    {
      Object localObject = localSelectActivityViewHolder.b;
      if (localSelectActivityViewHolder.a.isEnabled())
      {
        boolean bool = localSelectActivityViewHolder.d;
        int i = 0;
        if (bool) {
          bool = this.f.onListViewItemClick(localSelectActivityViewHolder.y, ((PhoneContact)localObject).name, 5, "-1");
        } else if (localSelectActivityViewHolder.y.startsWith("+")) {
          bool = this.f.onListViewItemClick(localSelectActivityViewHolder.y, ((PhoneContact)localObject).name, 4, "-1");
        } else {
          bool = this.f.onListViewItemClick(localSelectActivityViewHolder.y, ((PhoneContact)localObject).name, 0, "-1");
        }
        localSelectActivityViewHolder.a.setChecked(bool);
        if (AppSetting.e) {
          if (localSelectActivityViewHolder.a.isChecked())
          {
            if (localSelectActivityViewHolder.d)
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append(localSelectActivityViewHolder.i.getText());
              ((StringBuilder)localObject).append(this.f.getString(2131916221));
              paramView.setContentDescription(((StringBuilder)localObject).toString());
            }
            else
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append(localSelectActivityViewHolder.i.getText().toString());
              ((StringBuilder)localObject).append(HardCodeUtil.a(2131900706));
              paramView.setContentDescription(((StringBuilder)localObject).toString());
            }
          }
          else
          {
            if (localSelectActivityViewHolder.d) {
              i = this.f.getCheckPhoneNumberResId(localSelectActivityViewHolder.y);
            }
            if ((localSelectActivityViewHolder.d) && (i != 0))
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append(localSelectActivityViewHolder.i.getText());
              ((StringBuilder)localObject).append(this.f.getString(i));
              paramView.setContentDescription(((StringBuilder)localObject).toString());
            }
            else
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append(localSelectActivityViewHolder.i.getText().toString());
              ((StringBuilder)localObject).append(HardCodeUtil.a(2131900700));
              paramView.setContentDescription(((StringBuilder)localObject).toString());
            }
          }
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onIndexChanged(String paramString)
  {
    if ("$".equals(paramString))
    {
      this.a.setSelection(0);
      return;
    }
    int i = this.e.b(paramString);
    if (i != -1)
    {
      paramString = this.a;
      paramString.setSelection(i + paramString.getHeaderViewsCount());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.ContactsInnerFrame
 * JD-Core Version:    0.7.0.1
 */