package com.tencent.mobileqq.selectmember;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.adapter.CharDividedFacePreloadBaseAdapter;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.Friends;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

class FriendListInnerFrame$FriendListAdapter
  extends CharDividedFacePreloadBaseAdapter
{
  private LinkedHashMap<String, List<Friends>> b = new LinkedHashMap();
  private String[] c = new String[0];
  private int[] d = new int[0];
  
  public FriendListInnerFrame$FriendListAdapter(FriendListInnerFrame paramFriendListInnerFrame)
  {
    super(paramFriendListInnerFrame.f, paramFriendListInnerFrame.h, paramFriendListInnerFrame.b, true);
    c();
  }
  
  @SuppressLint({"DefaultLocale"})
  private void c()
  {
    this.b.clear();
    Iterator localIterator = this.a.a.iterator();
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
      Friends localFriends = (Friends)localIterator.next();
      if ((localFriends.mCompareSpell != null) && (localFriends.mCompareSpell.length() != 0)) {
        localObject1 = localFriends.mCompareSpell.substring(0, 1);
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
      ((List)this.b.get(localObject2)).add(localFriends);
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
    this.d = new int[this.b.keySet().size()];
    this.c = new String[this.d.length];
    localObject1 = this.b.keySet().iterator();
    Object localObject2 = this.d;
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
      localObject2[i] += localObject2[(i - 1)] + ((List)this.b.get(((Iterator)localObject1).next())).size() + 1;
      i += 1;
    }
    localObject1 = this.b.keySet().iterator();
    i = j;
    while (((Iterator)localObject1).hasNext())
    {
      this.c[i] = ((String)((Iterator)localObject1).next());
      i += 1;
    }
  }
  
  public int a()
  {
    return 2131625258;
  }
  
  public void a(View paramView, int paramInt)
  {
    int i = Arrays.binarySearch(this.d, paramInt);
    paramInt = i;
    if (i < 0) {
      paramInt = -(i + 1) - 1;
    }
    ((TextView)paramView).setText(this.c[paramInt]);
  }
  
  public boolean a(int paramInt)
  {
    return Arrays.binarySearch(this.d, paramInt) >= 0;
  }
  
  public int b(String paramString)
  {
    if (this.c != null)
    {
      int i = 0;
      for (;;)
      {
        String[] arrayOfString = this.c;
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
    localObject = this.b;
    String[] arrayOfString = this.c;
    return i + ((List)((LinkedHashMap)localObject).get(arrayOfString[(arrayOfString.length - 1)])).size() + 1;
  }
  
  public Object getItem(int paramInt)
  {
    int i = Arrays.binarySearch(this.d, paramInt);
    if (i >= 0) {
      return null;
    }
    i = -(i + 1) - 1;
    List localList = (List)this.b.get(this.c[i]);
    paramInt = paramInt - this.d[i] - 1;
    if ((paramInt >= 0) && (paramInt < localList.size())) {
      return localList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = Arrays.binarySearch(this.d, paramInt);
    View localView = paramView;
    if (paramView == null)
    {
      localView = this.a.i.inflate(2131629265, paramViewGroup, false);
      paramView = new FriendListInnerFrame.ViewHolder(this.a, null);
      localView.setTag(paramView);
      paramView.g = ((RelativeLayout)localView.findViewById(2131444983));
      paramView.h = ((TextView)localView.findViewById(2131448537));
      paramView.a = ((CheckBox)localView.findViewById(2131430688));
      paramView.A = ((ImageView)localView.findViewById(2131435219));
      paramView.i = ((TextView)localView.findViewById(2131439121));
    }
    Object localObject = (FriendListInnerFrame.ViewHolder)localView.getTag();
    if (i < 0)
    {
      i = -(i + 1) - 1;
      paramView = (Friends)((List)this.b.get(this.c[i])).get(paramInt - this.d[i] - 1);
      if (this.a.f.isResultListContainFriend(paramView.uin)) {
        ((FriendListInnerFrame.ViewHolder)localObject).a.setChecked(true);
      } else {
        ((FriendListInnerFrame.ViewHolder)localObject).a.setChecked(false);
      }
      ((FriendListInnerFrame.ViewHolder)localObject).g.setVisibility(0);
      ((FriendListInnerFrame.ViewHolder)localObject).h.setVisibility(8);
      ((FriendListInnerFrame.ViewHolder)localObject).A.setImageBitmap(a(paramView.uin));
      ((FriendListInnerFrame.ViewHolder)localObject).i.setText(paramView.getFriendNick());
      ((FriendListInnerFrame.ViewHolder)localObject).y = paramView.uin;
      if ((this.a.f.mUinsSelectedDefault != null) && (this.a.f.mUinsSelectedDefault.contains(paramView.uin))) {
        ((FriendListInnerFrame.ViewHolder)localObject).a.setEnabled(false);
      } else {
        ((FriendListInnerFrame.ViewHolder)localObject).a.setEnabled(true);
      }
      if ((AppSetting.e) && (((FriendListInnerFrame.ViewHolder)localObject).a.isEnabled())) {
        if (((FriendListInnerFrame.ViewHolder)localObject).a.isChecked())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramView.getFriendNick());
          ((StringBuilder)localObject).append(HardCodeUtil.a(2131902864));
          localView.setContentDescription(((StringBuilder)localObject).toString());
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramView.getFriendNick());
          ((StringBuilder)localObject).append(HardCodeUtil.a(2131902867));
          localView.setContentDescription(((StringBuilder)localObject).toString());
        }
      }
      localView.setOnClickListener(this.a);
    }
    else
    {
      ((FriendListInnerFrame.ViewHolder)localObject).g.setVisibility(8);
      ((FriendListInnerFrame.ViewHolder)localObject).h.setVisibility(0);
      paramView = String.valueOf(this.c[i]);
      ((FriendListInnerFrame.ViewHolder)localObject).h.setText(paramView);
      ((FriendListInnerFrame.ViewHolder)localObject).h.setContentDescription(String.format(this.a.f.getString(2131888769), new Object[] { paramView.toLowerCase() }));
    }
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.FriendListInnerFrame.FriendListAdapter
 * JD-Core Version:    0.7.0.1
 */