package com.tencent.open.agent;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.widget.PinnedDividerListView.DividerAdapter;
import com.tencent.open.agent.datamodel.Friend;
import com.tencent.open.agent.datamodel.FriendDataManager;
import com.tencent.open.agent.datamodel.ImageLoader;
import com.tencent.open.agent.datamodel.QZonePortraitData;
import com.tencent.open.base.LogUtility;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class DeviceFriendListOpenFrame$FriendListAdapter
  extends PinnedDividerListView.DividerAdapter
{
  protected LinkedHashMap<String, List<Friend>> a = new LinkedHashMap();
  protected String[] b = new String[0];
  protected int[] c = new int[0];
  
  public DeviceFriendListOpenFrame$FriendListAdapter(DeviceFriendListOpenFrame paramDeviceFriendListOpenFrame)
  {
    b();
  }
  
  public int a()
  {
    return 2131625258;
  }
  
  public int a(String paramString)
  {
    if (this.b != null)
    {
      int i = 0;
      for (;;)
      {
        String[] arrayOfString = this.b;
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
  
  public void a(View paramView, int paramInt)
  {
    int i = Arrays.binarySearch(this.c, paramInt);
    paramInt = i;
    if (i < 0) {
      paramInt = -(i + 1) - 1;
    }
    if (paramInt >= 0)
    {
      String[] arrayOfString = this.b;
      if (paramInt >= arrayOfString.length) {
        return;
      }
      ((TextView)paramView).setText(arrayOfString[paramInt]);
    }
  }
  
  public boolean a(int paramInt)
  {
    return Arrays.binarySearch(this.c, paramInt) >= 0;
  }
  
  protected void b()
  {
    this.a.clear();
    Object localObject1 = this.d.i.e();
    LogUtility.c(DeviceFriendListOpenFrame.a, "-->start constructHashStruct()");
    Iterator localIterator = ((List)localObject1).iterator();
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
      Friend localFriend = (Friend)localIterator.next();
      if ((localFriend.i != null) && (localFriend.i.length() != 0)) {
        localObject1 = localFriend.i.substring(0, 1);
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
      if (this.a.get(localObject2) == null) {
        this.a.put(localObject2, new ArrayList());
      }
      ((List)this.a.get(localObject2)).add(localFriend);
    }
    localObject1 = this.a;
    this.a = new LinkedHashMap();
    while (c1 <= 'Z')
    {
      if (((LinkedHashMap)localObject1).get(String.valueOf(c1)) != null) {
        this.a.put(String.valueOf(c1), ((LinkedHashMap)localObject1).get(String.valueOf(c1)));
      }
      c1 = (char)(c1 + '\001');
    }
    if (((LinkedHashMap)localObject1).get("#") != null) {
      this.a.put("#", ((LinkedHashMap)localObject1).get("#"));
    }
    ((LinkedHashMap)localObject1).clear();
    this.c = new int[this.a.keySet().size()];
    this.b = new String[this.c.length];
    localObject1 = this.a.keySet().iterator();
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
      localObject2[i] += localObject2[(i - 1)] + ((List)this.a.get(((Iterator)localObject1).next())).size() + 1;
      i += 1;
    }
    localObject1 = this.a.keySet().iterator();
    i = j;
    while (((Iterator)localObject1).hasNext())
    {
      this.b[i] = ((String)((Iterator)localObject1).next());
      i += 1;
    }
    LogUtility.c(DeviceFriendListOpenFrame.a, "-->end constructHashStruct()");
  }
  
  public void c()
  {
    b();
    super.notifyDataSetChanged();
  }
  
  public int getCount()
  {
    Object localObject = this.c;
    if (localObject.length == 0) {
      return 0;
    }
    int i = localObject[(localObject.length - 1)];
    localObject = this.a;
    String[] arrayOfString = this.b;
    return i + ((List)((LinkedHashMap)localObject).get(arrayOfString[(arrayOfString.length - 1)])).size() + 1;
  }
  
  public Object getItem(int paramInt)
  {
    int i = Arrays.binarySearch(this.c, paramInt);
    if (i >= 0) {
      return null;
    }
    i = -(i + 1) - 1;
    List localList = (List)this.a.get(this.b[i]);
    paramInt = paramInt - this.c[i] - 1;
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
    int i = Arrays.binarySearch(this.c, paramInt);
    View localView;
    Object localObject;
    if (paramView == null)
    {
      localView = this.d.m.inflate(2131629265, paramViewGroup, false);
      paramView = new DeviceFriendListOpenFrame.ViewHolder();
      paramView.e = ((RelativeLayout)localView.findViewById(2131444983));
      paramView.b = ((TextView)localView.findViewById(2131448537));
      paramView.a = ((CheckBox)localView.findViewById(2131430688));
      paramView.c = ((ImageView)localView.findViewById(2131435219));
      paramView.d = ((TextView)localView.findViewById(2131439121));
      localView.setTag(paramView);
    }
    else
    {
      localObject = (DeviceFriendListOpenFrame.ViewHolder)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
    }
    if (i < 0)
    {
      i = -(i + 1) - 1;
      localObject = (Friend)((List)this.a.get(this.b[i])).get(paramInt - this.c[i] - 1);
      if (this.d.i.b(((Friend)localObject).a)) {
        paramView.a.setChecked(true);
      } else {
        paramView.a.setChecked(false);
      }
      if ((this.d.j.z != null) && (this.d.j.z.contains(((Friend)localObject).a))) {
        paramView.a.setEnabled(false);
      } else {
        paramView.a.setEnabled(true);
      }
      if ((((Friend)localObject).d == null) || ("".equals(((Friend)localObject).d))) {
        ((Friend)localObject).d = QZonePortraitData.a(this.d.j.i(), ((Friend)localObject).a);
      }
      paramView.f = ((Friend)localObject).d;
      paramView.e.setVisibility(0);
      paramView.b.setVisibility(8);
      Bitmap localBitmap = ImageLoader.a().a(((Friend)localObject).d);
      if (localBitmap == null)
      {
        paramView.c.setImageResource(2130841060);
        ImageLoader.a().a(((Friend)localObject).d, this.d);
      }
      else
      {
        paramView.c.setImageBitmap(localBitmap);
      }
      if ((((Friend)localObject).c != null) && (!"".equals(((Friend)localObject).c))) {
        paramView.d.setText(((Friend)localObject).c);
      } else {
        paramView.d.setText(((Friend)localObject).b);
      }
    }
    else
    {
      paramView.e.setVisibility(8);
      paramView.b.setVisibility(0);
      paramView.b.setText(String.valueOf(this.b[i]));
    }
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.DeviceFriendListOpenFrame.FriendListAdapter
 * JD-Core Version:    0.7.0.1
 */