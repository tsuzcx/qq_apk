package com.tencent.mobileqq.selectmember;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.adapter.CharDividedFacePreloadBaseAdapter;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.selectmember.util.CommonUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

class DiscussionMemberListInnerFrame$DiscussionMemberListAdapter
  extends CharDividedFacePreloadBaseAdapter
{
  private LinkedHashMap<String, List<DiscussionMemberInfo>> b = new LinkedHashMap();
  private int[] c = new int[0];
  private String[] d = new String[0];
  
  public DiscussionMemberListInnerFrame$DiscussionMemberListAdapter(DiscussionMemberListInnerFrame paramDiscussionMemberListInnerFrame)
  {
    super(paramDiscussionMemberListInnerFrame.f, paramDiscussionMemberListInnerFrame.h, paramDiscussionMemberListInnerFrame.a, true);
    e();
  }
  
  @SuppressLint({"DefaultLocale"})
  private void e()
  {
    this.b.clear();
    String str2 = this.a.h.getCurrentAccountUin();
    Iterator localIterator = this.a.b.iterator();
    Object localObject1 = null;
    char c2;
    int j;
    Object localObject3;
    for (;;)
    {
      boolean bool = localIterator.hasNext();
      c2 = 'A';
      j = 0;
      String str1 = "#";
      if (!bool) {
        break;
      }
      DiscussionMemberInfo localDiscussionMemberInfo = (DiscussionMemberInfo)localIterator.next();
      if ((localDiscussionMemberInfo != null) && ((localDiscussionMemberInfo == null) || (!CommonUtils.a(this.a.h, localDiscussionMemberInfo.memberUin)))) {
        if ((localDiscussionMemberInfo != null) && (this.a.f.mIsPutMySelfFirst) && (str2 != null) && (str2.equals(localDiscussionMemberInfo.memberUin)))
        {
          localObject1 = localDiscussionMemberInfo;
        }
        else
        {
          if ((localDiscussionMemberInfo.displayedNamePinyinFirst != null) && (localDiscussionMemberInfo.displayedNamePinyinFirst.length() != 0)) {
            localObject2 = localDiscussionMemberInfo.displayedNamePinyinFirst.substring(0, 1);
          } else {
            localObject2 = "#";
          }
          i = ((String)localObject2).charAt(0);
          if ((65 > i) || (i > 90))
          {
            localObject3 = str1;
            if (97 <= i)
            {
              localObject3 = str1;
              if (i > 122) {}
            }
          }
          else
          {
            localObject3 = ((String)localObject2).toUpperCase();
          }
          if (this.b.get(localObject3) == null) {
            this.b.put(localObject3, new ArrayList());
          }
          ((List)this.b.get(localObject3)).add(localDiscussionMemberInfo);
        }
      }
    }
    Object localObject2 = this.b;
    this.b = new LinkedHashMap();
    char c1 = c2;
    if (this.a.f.mIsPutMySelfFirst)
    {
      c1 = c2;
      if (localObject1 != null)
      {
        localObject3 = new ArrayList();
        ((ArrayList)localObject3).add(localObject1);
        this.b.put(HardCodeUtil.a(2131901473), localObject3);
      }
    }
    for (c1 = c2; c1 <= 'Z'; c1 = (char)(c1 + '\001')) {
      if (((LinkedHashMap)localObject2).get(String.valueOf(c1)) != null) {
        this.b.put(String.valueOf(c1), ((LinkedHashMap)localObject2).get(String.valueOf(c1)));
      }
    }
    if (((LinkedHashMap)localObject2).get("#") != null) {
      this.b.put("#", ((LinkedHashMap)localObject2).get("#"));
    }
    ((LinkedHashMap)localObject2).clear();
    this.c = new int[this.b.keySet().size()];
    this.d = new String[this.c.length];
    localObject1 = this.b.keySet().iterator();
    localObject2 = this.c;
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
    e();
    super.notifyDataSetChanged();
  }
  
  public int c()
  {
    Iterator localIterator = this.b.keySet().iterator();
    int i = 0;
    while (localIterator.hasNext()) {
      i += ((List)this.b.get(localIterator.next())).size();
    }
    return i;
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
    return (DiscussionMemberInfo)((List)this.b.get(this.d[i])).get(paramInt - this.c[i] - 1);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = Arrays.binarySearch(this.c, paramInt);
    View localView = paramView;
    if (paramView == null)
    {
      localView = this.a.i.inflate(2131629265, paramViewGroup, false);
      paramView = new DiscussionMemberListInnerFrame.ViewHolder(this.a, null);
      localView.setTag(paramView);
      paramView.g = ((RelativeLayout)localView.findViewById(2131444983));
      paramView.h = ((TextView)localView.findViewById(2131448537));
      paramView.a = ((CheckBox)localView.findViewById(2131430688));
      paramView.A = ((ImageView)localView.findViewById(2131435219));
      paramView.i = ((TextView)localView.findViewById(2131439121));
    }
    Object localObject = (DiscussionMemberListInnerFrame.ViewHolder)localView.getTag();
    if (i < 0)
    {
      i = -(i + 1) - 1;
      paramView = (DiscussionMemberInfo)((List)this.b.get(this.d[i])).get(paramInt - this.c[i] - 1);
      if (this.a.f.isResultListContainFriend(paramView.memberUin)) {
        ((DiscussionMemberListInnerFrame.ViewHolder)localObject).a.setChecked(true);
      } else {
        ((DiscussionMemberListInnerFrame.ViewHolder)localObject).a.setChecked(false);
      }
      ((DiscussionMemberListInnerFrame.ViewHolder)localObject).g.setVisibility(0);
      ((DiscussionMemberListInnerFrame.ViewHolder)localObject).h.setVisibility(8);
      ((DiscussionMemberListInnerFrame.ViewHolder)localObject).A.setImageBitmap(a(paramView.memberUin));
      ((DiscussionMemberListInnerFrame.ViewHolder)localObject).i.setText(CommonUtils.a(paramView, this.a.h));
      ((DiscussionMemberListInnerFrame.ViewHolder)localObject).y = paramView.memberUin;
      if ((this.a.f.mUinsSelectedDefault != null) && (this.a.f.mUinsSelectedDefault.contains(paramView.memberUin))) {
        ((DiscussionMemberListInnerFrame.ViewHolder)localObject).a.setEnabled(false);
      } else {
        ((DiscussionMemberListInnerFrame.ViewHolder)localObject).a.setEnabled(true);
      }
      if ((AppSetting.e) && (((DiscussionMemberListInnerFrame.ViewHolder)localObject).a.isEnabled())) {
        if (((DiscussionMemberListInnerFrame.ViewHolder)localObject).a.isChecked())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(CommonUtils.a(paramView, this.a.h));
          ((StringBuilder)localObject).append(HardCodeUtil.a(2131901479));
          localView.setContentDescription(((StringBuilder)localObject).toString());
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(CommonUtils.a(paramView, this.a.h));
          ((StringBuilder)localObject).append(HardCodeUtil.a(2131901462));
          localView.setContentDescription(((StringBuilder)localObject).toString());
        }
      }
      localView.setOnClickListener(this.a);
    }
    else
    {
      ((DiscussionMemberListInnerFrame.ViewHolder)localObject).g.setVisibility(8);
      ((DiscussionMemberListInnerFrame.ViewHolder)localObject).h.setVisibility(0);
      paramView = String.valueOf(this.d[i]);
      ((DiscussionMemberListInnerFrame.ViewHolder)localObject).h.setText(paramView);
      ((DiscussionMemberListInnerFrame.ViewHolder)localObject).h.setContentDescription(String.format(this.a.f.getString(2131888769), new Object[] { paramView.toLowerCase() }));
    }
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.DiscussionMemberListInnerFrame.DiscussionMemberListAdapter
 * JD-Core Version:    0.7.0.1
 */