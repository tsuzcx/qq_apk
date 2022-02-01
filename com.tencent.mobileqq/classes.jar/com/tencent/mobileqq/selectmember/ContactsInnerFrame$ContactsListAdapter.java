package com.tencent.mobileqq.selectmember;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.adapter.CharDividedFacePreloadBaseAdapter;
import com.tencent.mobileqq.adapter.FacePreloadHolder.ViewHolder;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

class ContactsInnerFrame$ContactsListAdapter
  extends CharDividedFacePreloadBaseAdapter
{
  private LinkedHashMap<String, List<PhoneContact>> b = new LinkedHashMap();
  private int[] c = new int[0];
  private String[] d = new String[0];
  
  public ContactsInnerFrame$ContactsListAdapter(ContactsInnerFrame paramContactsInnerFrame, Context paramContext, AppInterface paramAppInterface, XListView paramXListView, boolean paramBoolean)
  {
    super(paramContext, paramAppInterface, paramXListView, paramBoolean);
  }
  
  @SuppressLint({"DefaultLocale"})
  private void c()
  {
    this.b.clear();
    if (this.a.b == null) {
      return;
    }
    Iterator localIterator = this.a.b.iterator();
    char c1;
    int j;
    for (;;)
    {
      boolean bool = localIterator.hasNext();
      c1 = 'A';
      j = 0;
      String str = "#";
      if (!bool) {
        break;
      }
      PhoneContact localPhoneContact = (PhoneContact)localIterator.next();
      if ((localPhoneContact.pinyinFirst != null) && (localPhoneContact.pinyinFirst.length() != 0)) {
        localObject1 = localPhoneContact.pinyinFirst.substring(0, 1);
      } else {
        localObject1 = "#";
      }
      i = ((String)localObject1).charAt(0);
      if ((65 > i) || (i > 90))
      {
        localObject2 = str;
        if (97 <= i)
        {
          localObject2 = str;
          if (i > 122) {}
        }
      }
      else
      {
        localObject2 = ((String)localObject1).toUpperCase();
      }
      if (this.b.get(localObject2) == null) {
        this.b.put(localObject2, new ArrayList());
      }
      ((List)this.b.get(localObject2)).add(localPhoneContact);
    }
    Object localObject1 = this.b;
    this.b = new LinkedHashMap();
    while (c1 <= 'Z')
    {
      if (((LinkedHashMap)localObject1).get(String.valueOf(c1)) != null) {
        this.b.put(String.valueOf(c1), ((LinkedHashMap)localObject1).get(String.valueOf(c1)));
      }
      c1 = (char)(c1 + '\001');
    }
    if (((LinkedHashMap)localObject1).get("#") != null) {
      this.b.put("#", ((LinkedHashMap)localObject1).get("#"));
    }
    ((LinkedHashMap)localObject1).clear();
    this.c = new int[this.b.keySet().size()];
    this.d = new String[this.c.length];
    localObject1 = this.b.keySet().iterator();
    Object localObject2 = this.c;
    if (localObject2.length == 0) {
      return;
    }
    localObject2[0] = 0;
    int i = 1;
    for (;;)
    {
      localObject2 = this.c;
      if (i >= localObject2.length) {
        break;
      }
      localObject2[i] += localObject2[(i - 1)] + ((List)this.b.get(((Iterator)localObject1).next())).size() + 1;
      i += 1;
    }
    localObject1 = this.b.keySet().iterator();
    i = j;
    while (((Iterator)localObject1).hasNext())
    {
      this.d[i] = ((String)((Iterator)localObject1).next());
      i += 1;
    }
  }
  
  public int a()
  {
    if (this.d.length > 0) {
      return 2131625258;
    }
    return 0;
  }
  
  public void a(View paramView, int paramInt)
  {
    Arrays.binarySearch(this.c, paramInt);
  }
  
  public boolean a(int paramInt)
  {
    return Arrays.binarySearch(this.c, paramInt) >= 0;
  }
  
  protected boolean a(FacePreloadHolder.ViewHolder paramViewHolder)
  {
    boolean bool2 = super.a(paramViewHolder);
    boolean bool1 = bool2;
    if ((paramViewHolder instanceof SelectActivityViewHolder))
    {
      paramViewHolder = (SelectActivityViewHolder)paramViewHolder;
      if ((bool2) && (!paramViewHolder.d)) {
        return true;
      }
      bool1 = false;
    }
    return bool1;
  }
  
  public int b(String paramString)
  {
    if (this.d != null)
    {
      int i = 0;
      for (;;)
      {
        String[] arrayOfString = this.d;
        if (i >= arrayOfString.length) {
          break;
        }
        if (arrayOfString[i].equals(paramString)) {
          break label42;
        }
        i += 1;
      }
      i = -1;
      label42:
      if (i >= 0) {
        return this.c[i];
      }
    }
    return -1;
  }
  
  public void b()
  {
    c();
    super.notifyDataSetChanged();
  }
  
  public int getCount()
  {
    Object localObject = this.c;
    if (localObject.length == 0) {
      return 0;
    }
    int i = localObject[(localObject.length - 1)];
    localObject = this.b;
    String[] arrayOfString = this.d;
    return i + ((List)((LinkedHashMap)localObject).get(arrayOfString[(arrayOfString.length - 1)])).size() + 1;
  }
  
  public Object getItem(int paramInt)
  {
    int i = Arrays.binarySearch(this.c, paramInt);
    if (i >= 0) {
      return null;
    }
    i = -(i + 1) - 1;
    return (PhoneContact)((List)this.b.get(this.d[i])).get(paramInt - this.c[i] - 1);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = Arrays.binarySearch(this.c, paramInt);
    View localView = paramView;
    if (paramView == null) {
      localView = SelectActivityViewHolder.a(paramViewGroup, this.a.i, 2131629265);
    }
    SelectActivityViewHolder localSelectActivityViewHolder = (SelectActivityViewHolder)localView.getTag();
    if (i < 0)
    {
      i = -(i + 1) - 1;
      List localList = (List)this.b.get(this.d[i]);
      i = paramInt - this.c[i] - 1;
      PhoneContact localPhoneContact2 = (PhoneContact)localList.get(i);
      SelectActivityViewHolder.a(this, localSelectActivityViewHolder, localPhoneContact2);
      int j = i - 1;
      PhoneContact localPhoneContact1 = null;
      if (j < 0) {
        paramView = null;
      } else {
        paramView = (PhoneContact)localList.get(j);
      }
      i += 1;
      if (i <= localList.size() - 1) {
        localPhoneContact1 = (PhoneContact)localList.get(i);
      }
      if (((paramView != null) && (paramView.contactID == localPhoneContact2.contactID)) || ((localPhoneContact1 != null) && (localPhoneContact1.contactID == localPhoneContact2.contactID)))
      {
        localSelectActivityViewHolder.e.setVisibility(0);
        localSelectActivityViewHolder.e.setText(localPhoneContact2.mobileNo);
      }
      else
      {
        localSelectActivityViewHolder.e.setVisibility(8);
      }
      localSelectActivityViewHolder.i.setText(localPhoneContact2.name);
      if (this.a.f.isResultListContainFriend(localSelectActivityViewHolder.y)) {
        localSelectActivityViewHolder.a.setChecked(true);
      } else {
        localSelectActivityViewHolder.a.setChecked(false);
      }
      if ((this.a.f.mUinsSelectedDefault != null) && (this.a.f.mUinsSelectedDefault.contains(localPhoneContact2.uin))) {
        localSelectActivityViewHolder.a.setEnabled(false);
      } else {
        localSelectActivityViewHolder.a.setEnabled(true);
      }
      if ((AppSetting.e) && (localSelectActivityViewHolder.a.isEnabled())) {
        if (localSelectActivityViewHolder.a.isChecked())
        {
          paramView = new StringBuilder();
          paramView.append(localPhoneContact2.name);
          paramView.append(HardCodeUtil.a(2131900719));
          localView.setContentDescription(paramView.toString());
        }
        else
        {
          paramView = new StringBuilder();
          paramView.append(localPhoneContact2.name);
          paramView.append(HardCodeUtil.a(2131900690));
          localView.setContentDescription(paramView.toString());
        }
      }
      localSelectActivityViewHolder.b = localPhoneContact2;
      localView.setOnClickListener(this.a);
    }
    else
    {
      localSelectActivityViewHolder.g.setVisibility(8);
      localSelectActivityViewHolder.h.setVisibility(0);
      paramView = String.valueOf(this.d[i]);
      localSelectActivityViewHolder.h.setText(paramView);
      localSelectActivityViewHolder.h.setContentDescription(String.format(this.a.f.getString(2131888769), new Object[] { paramView.toLowerCase() }));
    }
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.ContactsInnerFrame.ContactsListAdapter
 * JD-Core Version:    0.7.0.1
 */