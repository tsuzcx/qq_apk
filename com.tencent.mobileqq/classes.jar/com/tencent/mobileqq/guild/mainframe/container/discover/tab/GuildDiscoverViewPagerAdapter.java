package com.tencent.mobileqq.guild.mainframe.container.discover.tab;

import android.util.SparseArray;
import androidx.fragment.app.FragmentManager;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.mainframe.container.discover.QQGuildDiscoverFragment;
import com.tencent.mobileqq.guild.mainframe.container.discover.subfragment.QQGuildDiscoverBaseSubTabFragment;
import com.tencent.mobileqq.guild.mainframe.container.discover.subfragment.QQGuildDiscoverBaseSubTabFragment.FragmentLifeListener;
import com.tencent.mobileqq.guild.mainframe.container.discover.subfragment.QQGuildDiscoverBaseSubTabFragment.RefreshDataListener;
import com.tencent.mobileqq.guild.mainframe.container.discover.view.HeadViewScrollListener;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class GuildDiscoverViewPagerAdapter
  extends CustomFragmentStatePagerAdapter
  implements QQGuildDiscoverBaseSubTabFragment.FragmentLifeListener
{
  protected SparseArray<QQGuildDiscoverBaseSubTabFragment> a = new SparseArray();
  protected QQGuildDiscoverBaseSubTabFragment.RefreshDataListener b;
  protected AppInterface c;
  protected QBaseActivity d;
  protected ArrayList<QQGuildDisSubTabInfo> e = new ArrayList();
  protected ArrayList<HeadViewScrollListener> f = new ArrayList();
  protected int g = -1;
  protected int h = -1;
  private boolean i = false;
  private QQGuildDiscoverFragment j;
  
  public GuildDiscoverViewPagerAdapter(FragmentManager paramFragmentManager, AppInterface paramAppInterface, QBaseActivity paramQBaseActivity, ArrayList<QQGuildDisSubTabInfo> paramArrayList, QQGuildDiscoverFragment paramQQGuildDiscoverFragment)
  {
    super(paramFragmentManager);
    this.c = paramAppInterface;
    this.d = paramQBaseActivity;
    this.e.clear();
    this.e.addAll(paramArrayList);
    this.j = paramQQGuildDiscoverFragment;
  }
  
  public QQGuildDiscoverBaseSubTabFragment a(int paramInt, boolean paramBoolean)
  {
    QQGuildDisSubTabInfo localQQGuildDisSubTabInfo = d(paramInt);
    Object localObject2;
    Object localObject1;
    if (localQQGuildDisSubTabInfo != null)
    {
      localObject2 = f(localQQGuildDisSubTabInfo.c);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = localObject2;
        if (paramBoolean)
        {
          localObject1 = SubTabFragmentFactory.a(localQQGuildDisSubTabInfo.a, localQQGuildDisSubTabInfo.c, this.j);
          ((QQGuildDiscoverBaseSubTabFragment)localObject1).a(this.d);
          ((QQGuildDiscoverBaseSubTabFragment)localObject1).a(this.c);
          ((QQGuildDiscoverBaseSubTabFragment)localObject1).a(this);
          ((QQGuildDiscoverBaseSubTabFragment)localObject1).a(this.b);
          ((QQGuildDiscoverBaseSubTabFragment)localObject1).b(paramInt);
          if ((localObject1 instanceof HeadViewScrollListener)) {
            this.f.add((HeadViewScrollListener)localObject1);
          }
          this.a.put(localQQGuildDisSubTabInfo.c, localObject1);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("getFragment ..... create ");
          ((StringBuilder)localObject2).append(paramInt);
          ((StringBuilder)localObject2).append("  ");
          ((StringBuilder)localObject2).append(localQQGuildDisSubTabInfo.c);
          QLog.d("Contacts.ContactsViewPagerAdapter", 2, ((StringBuilder)localObject2).toString());
        }
      }
    }
    else
    {
      localObject1 = null;
    }
    if (localObject1 != null)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getFragment ..... pos:");
      ((StringBuilder)localObject2).append(paramInt);
      ((StringBuilder)localObject2).append("  id:");
      ((StringBuilder)localObject2).append(((QQGuildDiscoverBaseSubTabFragment)localObject1).f());
      ((StringBuilder)localObject2).append("  isDetached: ");
      ((StringBuilder)localObject2).append(((QQGuildDiscoverBaseSubTabFragment)localObject1).isDetached());
      ((StringBuilder)localObject2).append(" contactsViewPager:");
      ((StringBuilder)localObject2).append(this.d.findViewById(2131434523));
      ((StringBuilder)localObject2).append("  isAdd: ");
      ((StringBuilder)localObject2).append(((QQGuildDiscoverBaseSubTabFragment)localObject1).isAdded());
      ((StringBuilder)localObject2).append(" ");
      ((StringBuilder)localObject2).append(localObject1);
      QLog.d("Contacts.ContactsViewPagerAdapter", 2, ((StringBuilder)localObject2).toString());
    }
    if ((localObject1 != null) && ((localObject1 instanceof HeadViewScrollListener)))
    {
      paramInt = this.h;
      if (paramInt > 0) {
        ((HeadViewScrollListener)localObject1).a(this.g, paramInt);
      }
    }
    return localObject1;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("remove fragment cache :");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("Contacts.ContactsViewPagerAdapter", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = f(paramInt);
    if (localObject != null)
    {
      ((QQGuildDiscoverBaseSubTabFragment)localObject).a();
      this.a.delete(paramInt);
      this.f.remove(localObject);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("headViewScrollChanged currentY:");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("  maxY:");
      localStringBuilder.append(paramInt2);
      QLog.i("Contacts.ContactsViewPagerAdapter", 2, localStringBuilder.toString());
    }
    int k = 0;
    while (k < this.f.size())
    {
      ((HeadViewScrollListener)this.f.get(k)).a(paramInt1, paramInt2);
      k += 1;
    }
    this.g = paramInt1;
    this.h = paramInt2;
  }
  
  public void a(QQGuildDiscoverBaseSubTabFragment.RefreshDataListener paramRefreshDataListener)
  {
    this.b = paramRefreshDataListener;
  }
  
  public void a(ArrayList<QQGuildDisSubTabInfo> paramArrayList)
  {
    this.e.clear();
    this.e.addAll(paramArrayList);
    a();
    if (QLog.isColorLevel())
    {
      paramArrayList = new StringBuilder();
      paramArrayList.append("tabDatasUpdated. size:");
      paramArrayList.append(this.e.size());
      QLog.i("Contacts.ContactsViewPagerAdapter", 2, paramArrayList.toString());
    }
    notifyDataSetChanged();
  }
  
  public void b()
  {
    int k = 0;
    while (k < this.e.size())
    {
      Object localObject = d(k);
      if (localObject != null)
      {
        localObject = f(((QQGuildDisSubTabInfo)localObject).c);
        if (localObject != null) {
          ((QQGuildDiscoverBaseSubTabFragment)localObject).e();
        }
      }
      k += 1;
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onPageSelected. curPos:");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(" prePos:");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.d("Contacts.ContactsViewPagerAdapter", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = a(paramInt1, false);
    if (localObject != null) {
      ((QQGuildDiscoverBaseSubTabFragment)localObject).c(true);
    }
    localObject = a(paramInt2, false);
    if (localObject != null) {
      ((QQGuildDiscoverBaseSubTabFragment)localObject).c(false);
    }
  }
  
  public void b(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doOnResume:");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" tabChange:");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("Contacts.ContactsViewPagerAdapter", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = a(paramInt, false);
    if (localObject != null) {
      ((QQGuildDiscoverBaseSubTabFragment)localObject).a(false);
    }
  }
  
  public QQGuildDiscoverBaseSubTabFragment c(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getItem:");
      localStringBuilder.append(paramInt);
      QLog.d("Contacts.ContactsViewPagerAdapter", 2, localStringBuilder.toString());
    }
    return a(paramInt, true);
  }
  
  public void c()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doOnDestroy  mFragmentsCache.size() = ");
      ((StringBuilder)localObject).append(this.a.size());
      QLog.d("Contacts.ContactsViewPagerAdapter", 2, ((StringBuilder)localObject).toString());
    }
    int k = 0;
    while (k < this.a.size())
    {
      localObject = (QQGuildDiscoverBaseSubTabFragment)this.a.valueAt(k);
      if (localObject != null) {
        ((QQGuildDiscoverBaseSubTabFragment)localObject).a();
      }
      k += 1;
    }
    this.a.clear();
    this.f.clear();
  }
  
  protected QQGuildDisSubTabInfo d(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.e.size())) {
      return (QQGuildDisSubTabInfo)this.e.get(paramInt);
    }
    return null;
  }
  
  protected int e(int paramInt)
  {
    int k = 0;
    while (k < this.e.size())
    {
      if (((QQGuildDisSubTabInfo)this.e.get(k)).c == paramInt) {
        return k;
      }
      k += 1;
    }
    return -1;
  }
  
  protected QQGuildDiscoverBaseSubTabFragment f(int paramInt)
  {
    return (QQGuildDiscoverBaseSubTabFragment)this.a.get(paramInt, null);
  }
  
  public void g(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("refresh:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("Contacts.ContactsViewPagerAdapter", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = a(paramInt, false);
    if (localObject != null) {
      ((QQGuildDiscoverBaseSubTabFragment)localObject).b();
    }
  }
  
  public int getCount()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getCount. size:");
      localStringBuilder.append(this.e.size());
      QLog.i("Contacts.ContactsViewPagerAdapter", 2, localStringBuilder.toString());
    }
    return this.e.size();
  }
  
  public int getItemPosition(Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getItemPosition ");
    localStringBuilder.append(paramObject);
    QLog.d("Contacts.ContactsViewPagerAdapter", 2, localStringBuilder.toString());
    paramObject = (QQGuildDiscoverBaseSubTabFragment)paramObject;
    if (paramObject != null)
    {
      int k = e(paramObject.f());
      if (k >= 0)
      {
        if (paramObject.g() == k)
        {
          QLog.d("Contacts.ContactsViewPagerAdapter", 2, "getItemPosition POSITION_UNCHANGED");
          return -1;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getItemPosition newPos");
        localStringBuilder.append(k);
        localStringBuilder.append(" oldPos:");
        localStringBuilder.append(paramObject.g());
        QLog.d("Contacts.ContactsViewPagerAdapter", 2, localStringBuilder.toString());
        paramObject.b(k);
        return k;
      }
    }
    QLog.d("Contacts.ContactsViewPagerAdapter", 2, "getItemPosition POSITION_NONE");
    return -2;
  }
  
  public void h(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doOnPause:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("Contacts.ContactsViewPagerAdapter", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = a(paramInt, false);
    if (localObject != null) {
      ((QQGuildDiscoverBaseSubTabFragment)localObject).b(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.container.discover.tab.GuildDiscoverViewPagerAdapter
 * JD-Core Version:    0.7.0.1
 */