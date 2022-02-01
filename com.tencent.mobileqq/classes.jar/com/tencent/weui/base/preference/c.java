package com.tencent.weui.base.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mm.ui.f;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class c
  extends BaseAdapter
  implements IPreferenceScreen
{
  private final d a;
  private final LinkedList<String> b = new LinkedList();
  private final HashMap<String, Preference> c = new HashMap();
  private final HashSet<String> d = new HashSet();
  private final LinkedList<String> e = new LinkedList();
  private final HashMap<String, Integer> f = new HashMap();
  private final HashMap<String, String> g = new HashMap();
  private final SharedPreferences h;
  private final Context i;
  private int[] j = new int[0];
  private boolean k = false;
  private boolean l = false;
  private Preference.OnPreferenceChangeListener m;
  
  public c(Context paramContext, SharedPreferences paramSharedPreferences)
  {
    this.a = new d(paramContext);
    this.i = paramContext;
    this.h = paramSharedPreferences;
  }
  
  private static String a(Preference paramPreference)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramPreference.getClass().getName());
    localStringBuilder.append("L");
    localStringBuilder.append(paramPreference.getLayoutResource());
    localStringBuilder.append("W");
    localStringBuilder.append(paramPreference.getWidgetLayoutResource());
    return localStringBuilder.toString();
  }
  
  private void a()
  {
    HashSet localHashSet = new HashSet();
    int n = 0;
    while (n < this.e.size())
    {
      Preference localPreference = (Preference)this.c.get(this.e.get(n));
      if (n != 0) {
        localPreference = (Preference)this.c.get(this.e.get(n - 1));
      }
      n += 1;
    }
    this.e.removeAll(localHashSet);
  }
  
  private void a(Preference paramPreference, int paramInt)
  {
    Object localObject1 = b(paramPreference);
    this.c.put(localObject1, paramPreference);
    Object localObject2 = this.b;
    int n = paramInt;
    if (paramInt == -1) {
      n = ((LinkedList)localObject2).size();
    }
    ((LinkedList)localObject2).add(n, localObject1);
    if ((!this.f.containsKey(a(paramPreference))) && (!this.l)) {
      this.f.put(a(paramPreference), Integer.valueOf(this.f.size()));
    }
    if (paramPreference.getDependency() != null)
    {
      localObject1 = this.g;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramPreference.getDependency());
      ((StringBuilder)localObject2).append("|");
      ((StringBuilder)localObject2).append(paramPreference.getKey());
      ((HashMap)localObject1).put(((StringBuilder)localObject2).toString(), paramPreference.getKey());
    }
  }
  
  private static void a(Preference paramPreference, SharedPreferences paramSharedPreferences)
  {
    if ((paramPreference instanceof CheckBoxPreference))
    {
      CheckBoxPreference localCheckBoxPreference = (CheckBoxPreference)paramPreference;
      if (localCheckBoxPreference.isPersistent()) {
        localCheckBoxPreference.setChecked(paramSharedPreferences.getBoolean(paramPreference.getKey(), localCheckBoxPreference.isChecked()));
      }
    }
  }
  
  private static boolean a(int paramInt)
  {
    return (paramInt == 2131625448) || (paramInt == 2131625458) || (paramInt == 2131625459);
  }
  
  private static String b(Preference paramPreference)
  {
    if ((paramPreference.getKey() != null) && (paramPreference.getKey().length() > 0)) {
      return paramPreference.getKey();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("_anonymous_pref@");
    localStringBuilder.append(paramPreference.hashCode());
    return localStringBuilder.toString();
  }
  
  private void b()
  {
    this.e.clear();
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (!this.d.contains(str)) {
        if (this.c.get(str) == null)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("not found pref by key ");
          localStringBuilder.append(str);
          f.e("MicroMsg.WeUIPreferenceAdapter", localStringBuilder.toString(), new Object[0]);
        }
        else
        {
          this.e.add(str);
        }
      }
    }
    if ((!this.e.isEmpty()) && (a(((Preference)this.c.get(this.e.get(0))).getLayoutResource()))) {
      a(new b(this.i), 0);
    }
  }
  
  public void a(Preference.OnPreferenceChangeListener paramOnPreferenceChangeListener)
  {
    this.m = paramOnPreferenceChangeListener;
    notifyDataSetChanged();
  }
  
  public void addPreference(Preference paramPreference)
  {
    addPreference(paramPreference, -1);
  }
  
  public void addPreference(Preference paramPreference, int paramInt)
  {
    a(paramPreference, paramInt);
    if (!this.k) {
      notifyDataSetChanged();
    }
  }
  
  public void addPreference(Preference paramPreference, boolean paramBoolean)
  {
    a(paramPreference, -1);
    if ((paramBoolean) && (!this.k)) {
      notifyDataSetChanged();
    }
  }
  
  public void addPreferencesFromResource(int paramInt)
  {
    this.k = true;
    this.a.a(paramInt, this);
    this.k = false;
    notifyDataSetChanged();
  }
  
  public Preference findPreference(String paramString)
  {
    return (Preference)this.c.get(paramString);
  }
  
  public int getCount()
  {
    return this.e.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.c.get(this.e.get(paramInt));
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt > this.e.size()) {
      return -1;
    }
    Object localObject = (Preference)this.c.get(this.e.get(paramInt));
    localObject = (Integer)this.f.get(a((Preference)localObject));
    if (localObject == null) {
      return -1;
    }
    return ((Integer)localObject).intValue();
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramInt <= this.e.size())
    {
      Object localObject = (Preference)this.c.get(this.e.get(paramInt));
      if ((localObject instanceof CheckBoxPreference)) {
        ((Preference)localObject).setOnPreferenceChangeListener(this.m);
      }
      if (!this.f.containsKey(a((Preference)localObject))) {
        paramView = null;
      }
      paramView = ((Preference)localObject).getView(paramView, paramViewGroup);
      int i10 = this.j[paramInt];
      localObject = paramView.findViewById(2131431322);
      if (localObject == null)
      {
        f.b("MicroMsg.WeUIPreferenceAdapter", "find content view error", new Object[0]);
      }
      else
      {
        View localView = paramView.findViewById(16908312);
        if ((i10 & 0x4) == 0)
        {
          int i2 = ((View)localObject).getPaddingLeft();
          int i3 = ((View)localObject).getPaddingRight();
          int i4 = ((View)localObject).getPaddingTop();
          int i5 = ((View)localObject).getPaddingBottom();
          int i1 = 2130851782;
          int i6 = paramView.getPaddingLeft();
          int i7 = paramView.getPaddingRight();
          int i8 = paramView.getPaddingTop();
          int i9 = paramView.getPaddingBottom();
          int n;
          if ((i10 & 0x8) != 0)
          {
            int i11 = this.e.size();
            i1 = 2130842134;
            n = i1;
            if (paramInt != i11 - 1) {
              if ((paramInt == this.e.size() - 2) && ((getItem(this.e.size() - 1) instanceof a))) {
                n = i1;
              } else if ((i10 & 0x2) != 0) {
                n = i1;
              } else {
                n = 2130841353;
              }
            }
            i1 = 2131168464;
          }
          else
          {
            if ((i10 & 0x10) != 0) {}
            while ((i10 & 0x2) == 0)
            {
              n = 2130841353;
              break;
            }
            n = 0;
          }
          ((View)localObject).setBackgroundResource(n);
          ((View)localObject).setPadding(i2, i4, i3, i5);
          if (localView != null) {
            localView.setBackgroundResource(n);
          }
          paramView.setBackgroundResource(i1);
          paramView.setPadding(i6, i8, i7, i9);
        }
      }
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
  
  public int getViewTypeCount()
  {
    if (!this.l) {
      this.l = true;
    }
    return Math.max(1, this.f.size());
  }
  
  public void hidePreference(String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (!this.d.contains(paramString)) {
        this.d.add(paramString);
      }
    }
    else if (!this.d.remove(paramString)) {
      return;
    }
    notifyDataSetChanged();
  }
  
  public int indexOf(String paramString)
  {
    return this.b.indexOf(paramString);
  }
  
  public int indexOfShow(String paramString)
  {
    LinkedList localLinkedList = this.e;
    if (localLinkedList == null) {
      return -1;
    }
    return localLinkedList.indexOf(paramString);
  }
  
  public void notifyDataSetChanged()
  {
    b();
    a();
    this.j = new int[this.e.size()];
    Object localObject = this.j;
    if (localObject.length <= 0) {
      return;
    }
    int i1 = localObject.length;
    int n = 0;
    if (i1 == 1)
    {
      n = ((Preference)this.c.get(this.e.get(0))).getLayoutResource();
      localObject = (Preference)this.c.get(this.e.get(0));
      if (a(n))
      {
        if ((localObject instanceof CheckBoxPreference))
        {
          localObject = this.j;
          localObject[0] |= 0x8;
        }
        else
        {
          this.j[0] = 3;
        }
      }
      else {
        this.j[0] = 4;
      }
      a((Preference)this.c.get(this.e.get(0)), this.h);
      super.notifyDataSetChanged();
      return;
    }
    while (n < this.e.size())
    {
      a((Preference)this.c.get(this.e.get(n)), this.h);
      localObject = (Preference)this.c.get(this.e.get(n));
      i1 = ((Preference)localObject).getLayoutResource();
      if (a(i1))
      {
        if ((localObject instanceof CheckBoxPreference))
        {
          localObject = this.j;
          localObject[n] |= 0x8;
        }
        else if (n == 0)
        {
          localObject = this.j;
          localObject[n] |= 0x1;
        }
        else
        {
          if (n == this.e.size() - 1)
          {
            localObject = this.j;
            localObject[n] |= 0x2;
          }
          i1 = ((Preference)this.c.get(this.e.get(n - 1))).getLayoutResource();
          if ((i1 != 2131625448) || (i1 == 2131625458) || (i1 == 2131625459))
          {
            localObject = this.j;
            localObject[n] |= 0x1;
          }
        }
      }
      else
      {
        LinkedList localLinkedList;
        int i2;
        if (i1 == 2131625452)
        {
          if (n == 0)
          {
            localObject = this.j;
            localObject[n] |= 0x4;
          }
          else
          {
            localObject = this.j;
            localObject[n] |= 0x10;
            localObject = this.c;
            localLinkedList = this.e;
            i1 = n - 1;
            i2 = ((Preference)((HashMap)localObject).get(localLinkedList.get(i1))).getLayoutResource();
            if ((i2 == 2131625448) || (i2 == 2131625458) || (i2 == 2131625459))
            {
              localObject = this.j;
              localObject[i1] |= 0x2;
            }
          }
        }
        else
        {
          localObject = this.j;
          localObject[n] |= 0x4;
          if (n != 0)
          {
            localObject = this.c;
            localLinkedList = this.e;
            i1 = n - 1;
            i2 = ((Preference)((HashMap)localObject).get(localLinkedList.get(i1))).getLayoutResource();
            if ((a(i2)) || (i2 == 2131625452))
            {
              localObject = this.j;
              localObject[i1] |= 0x2;
            }
          }
        }
      }
      n += 1;
    }
    super.notifyDataSetChanged();
  }
  
  public void removeAll()
  {
    this.e.clear();
    this.c.clear();
    this.b.clear();
    this.d.clear();
    notifyDataSetChanged();
  }
  
  public boolean removePreference(Preference paramPreference)
  {
    if (paramPreference == null) {
      return false;
    }
    String str = b(paramPreference);
    this.b.remove(str);
    this.c.remove(str);
    this.d.remove(paramPreference.getKey());
    notifyDataSetChanged();
    return true;
  }
  
  public boolean removePreference(String paramString)
  {
    return removePreference(findPreference(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.weui.base.preference.c
 * JD-Core Version:    0.7.0.1
 */