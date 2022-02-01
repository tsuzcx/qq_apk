package com.tencent.mobileqq.selectmember;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
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

class PhoneContactTabView$ContactsListAdapter
  extends CharDividedFacePreloadBaseAdapter
{
  View.OnClickListener a = new PhoneContactTabView.ContactsListAdapter.1(this);
  private LinkedHashMap<String, List<PhoneContact>> c = new LinkedHashMap();
  private int[] d = new int[0];
  private String[] e = new String[0];
  
  public PhoneContactTabView$ContactsListAdapter(PhoneContactTabView paramPhoneContactTabView, Context paramContext, AppInterface paramAppInterface, XListView paramXListView, boolean paramBoolean)
  {
    super(paramContext, paramAppInterface, paramXListView, paramBoolean);
  }
  
  @SuppressLint({"DefaultLocale"})
  private void c()
  {
    this.c.clear();
    if (this.b.b == null) {
      return;
    }
    Iterator localIterator = this.b.b.iterator();
    char c2;
    int j;
    for (;;)
    {
      boolean bool = localIterator.hasNext();
      c2 = 'A';
      String str = "#";
      j = 0;
      if (!bool) {
        break;
      }
      PhoneContact localPhoneContact = (PhoneContact)localIterator.next();
      if (TextUtils.isEmpty(localPhoneContact.pinyinFirst)) {
        localObject1 = "#";
      } else {
        localObject1 = localPhoneContact.pinyinFirst.substring(0, 1);
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
      if (this.c.get(localObject2) == null) {
        this.c.put(localObject2, new ArrayList());
      }
      ((List)this.c.get(localObject2)).add(localPhoneContact);
    }
    Object localObject1 = this.c;
    this.c = new LinkedHashMap();
    Object localObject2 = (List)((LinkedHashMap)localObject1).get("@");
    char c1 = c2;
    if (localObject2 != null) {
      this.c.put(PhoneContactTabView.d(this.b), localObject2);
    }
    for (c1 = c2; c1 <= 'Z'; c1 = (char)(c1 + '\001')) {
      if (((LinkedHashMap)localObject1).get(String.valueOf(c1)) != null) {
        this.c.put(String.valueOf(c1), ((LinkedHashMap)localObject1).get(String.valueOf(c1)));
      }
    }
    if (((LinkedHashMap)localObject1).get("#") != null) {
      this.c.put("#", ((LinkedHashMap)localObject1).get("#"));
    }
    ((LinkedHashMap)localObject1).clear();
    this.d = new int[this.c.keySet().size()];
    this.e = new String[this.d.length];
    localObject1 = this.c.keySet().iterator();
    localObject2 = this.d;
    if (localObject2.length == 0) {
      return;
    }
    localObject2[0] = 0;
    int i = 1;
    for (;;)
    {
      localObject2 = this.d;
      if (i >= localObject2.length) {
        break;
      }
      localObject2[i] += localObject2[(i - 1)] + ((List)this.c.get(((Iterator)localObject1).next())).size() + 1;
      i += 1;
    }
    localObject1 = this.c.keySet().iterator();
    i = j;
    while (((Iterator)localObject1).hasNext())
    {
      this.e[i] = ((String)((Iterator)localObject1).next());
      i += 1;
    }
  }
  
  public int a()
  {
    if (this.e.length > 0) {
      return 2131625258;
    }
    return 0;
  }
  
  public void a(View paramView, int paramInt)
  {
    Arrays.binarySearch(this.d, paramInt);
  }
  
  public boolean a(int paramInt)
  {
    return Arrays.binarySearch(this.d, paramInt) >= 0;
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
    if (this.e != null)
    {
      int i = 0;
      for (;;)
      {
        String[] arrayOfString = this.e;
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
        return this.d[i];
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
    Object localObject = this.d;
    if (localObject.length == 0) {
      return 0;
    }
    int i = localObject[(localObject.length - 1)];
    localObject = this.c;
    String[] arrayOfString = this.e;
    return i + ((List)((LinkedHashMap)localObject).get(arrayOfString[(arrayOfString.length - 1)])).size() + 1;
  }
  
  public Object getItem(int paramInt)
  {
    int i = Arrays.binarySearch(this.d, paramInt);
    if (i >= 0) {
      return null;
    }
    i = -(i + 1) - 1;
    return (PhoneContact)((List)this.c.get(this.e[i])).get(paramInt - this.d[i] - 1);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = Arrays.binarySearch(this.d, paramInt);
    View localView = paramView;
    if (paramView == null) {
      localView = SelectActivityViewHolder.a(paramViewGroup, this.b.h, 2131624560);
    }
    paramView = (SelectActivityViewHolder)localView.getTag();
    Object localObject;
    if (i < 0)
    {
      i = -(i + 1) - 1;
      localObject = (PhoneContact)((List)this.c.get(this.e[i])).get(paramInt - this.d[i] - 1);
      SelectActivityViewHolder.a(this, paramView, (PhoneContact)localObject);
      paramView.i.setText(((PhoneContact)localObject).name);
      paramView.e.setText(((PhoneContact)localObject).mobileNo);
      paramView.e.setVisibility(0);
      if (this.b.d.isResultListContainFriend(paramView.y)) {
        paramView.a.setChecked(true);
      } else {
        paramView.a.setChecked(false);
      }
      paramView.a.setEnabled(true);
      if ((AppSetting.e) && (paramView.a.isEnabled()))
      {
        StringBuilder localStringBuilder;
        if (paramView.a.isChecked())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(((PhoneContact)localObject).name);
          localStringBuilder.append(HardCodeUtil.a(2131905806));
          localView.setContentDescription(localStringBuilder.toString());
        }
        else
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(((PhoneContact)localObject).name);
          localStringBuilder.append(HardCodeUtil.a(2131905804));
          localView.setContentDescription(localStringBuilder.toString());
        }
      }
      paramView.b = ((PhoneContact)localObject);
      paramView.f.setVisibility(8);
      paramView.f.setOnClickListener(this.a);
      localView.setOnClickListener(this.a);
    }
    else
    {
      paramView.g.setVisibility(8);
      paramView.h.setVisibility(0);
      localObject = String.valueOf(this.e[i]);
      paramView.h.setText((CharSequence)localObject);
      paramView.h.setContentDescription(String.format(this.b.d.getString(2131888769), new Object[] { ((String)localObject).toLowerCase() }));
    }
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.PhoneContactTabView.ContactsListAdapter
 * JD-Core Version:    0.7.0.1
 */