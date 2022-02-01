package com.tencent.mobileqq.kandian.biz.tab;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment.SavedState;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.kandian.biz.common.fragment.ReadInJoyBaseFragment;
import com.tencent.mobileqq.kandian.biz.framework.CallHotwordChange;
import com.tencent.mobileqq.kandian.glue.router.ReadInJoyFragmentFactory;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoySrtUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TabChannelCoverInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReadInJoyChannelViewPager$CustomFragmentPagerAdapter
  extends PagerAdapter
{
  CallHotwordChange a;
  private final FragmentManager b;
  private FragmentTransaction c = null;
  private ArrayList<Fragment.SavedState> d = new ArrayList();
  private ArrayList<QBaseFragment> e = new ArrayList();
  private QBaseFragment f = null;
  private List<TabChannelCoverInfo> g;
  
  public ReadInJoyChannelViewPager$CustomFragmentPagerAdapter(FragmentManager paramFragmentManager)
  {
    this.b = paramFragmentManager;
    e();
  }
  
  private void a(QBaseFragment paramQBaseFragment)
  {
    if ((paramQBaseFragment instanceof ReadInJoyBaseFragment))
    {
      ReadInJoySrtUtils.a().d();
      paramQBaseFragment = (ReadInJoyBaseFragment)paramQBaseFragment;
      ReadInJoySrtUtils.a().a(String.valueOf(paramQBaseFragment.d()));
    }
  }
  
  private QBaseFragment b(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < getCount()))
    {
      TabChannelCoverInfo localTabChannelCoverInfo = (TabChannelCoverInfo)this.g.get(paramInt);
      QBaseFragment localQBaseFragment = ReadInJoyFragmentFactory.a().a(localTabChannelCoverInfo);
      if ((localQBaseFragment instanceof ReadInJoyBaseFragment))
      {
        ReadInJoyBaseFragment localReadInJoyBaseFragment = (ReadInJoyBaseFragment)localQBaseFragment;
        localReadInJoyBaseFragment.b(paramInt);
        localReadInJoyBaseFragment.a(this.a, localTabChannelCoverInfo.mChannelCoverId);
      }
      return localQBaseFragment;
    }
    return null;
  }
  
  private void e()
  {
    this.g = new ArrayList();
  }
  
  public QBaseFragment a(int paramInt)
  {
    if (this.e.size() > paramInt) {
      return (QBaseFragment)this.e.get(paramInt);
    }
    return null;
  }
  
  public void a()
  {
    try
    {
      this.g.clear();
      notifyDataSetChanged();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      QLog.d("PagerAdapter", 1, "clearData exception.");
    }
  }
  
  public void a(CallHotwordChange paramCallHotwordChange)
  {
    this.a = paramCallHotwordChange;
  }
  
  public void a(List<TabChannelCoverInfo> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      this.g.clear();
      this.g.addAll(paramList);
    }
    notifyDataSetChanged();
  }
  
  public void b()
  {
    int i = 0;
    while (i < this.e.size())
    {
      QBaseFragment localQBaseFragment = (QBaseFragment)this.e.get(i);
      if ((localQBaseFragment instanceof ReadInJoyBaseFragment)) {
        ((ReadInJoyBaseFragment)localQBaseFragment).i();
      }
      i += 1;
    }
  }
  
  public void c()
  {
    int i = 0;
    while (i < this.e.size())
    {
      QBaseFragment localQBaseFragment = (QBaseFragment)this.e.get(i);
      if ((localQBaseFragment instanceof ReadInJoyBaseFragment)) {
        ((ReadInJoyBaseFragment)localQBaseFragment).j();
      }
      i += 1;
    }
  }
  
  public QBaseFragment d()
  {
    return this.f;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramObject = (QBaseFragment)paramObject;
    if (this.c == null) {
      this.c = this.b.beginTransaction();
    }
    QLog.d("PagerAdapter", 2, new Object[] { "destroyItem position = ", Integer.valueOf(paramInt), ", f = ", paramObject });
    while (this.d.size() <= paramInt) {
      this.d.add(null);
    }
    ArrayList localArrayList = this.d;
    if (paramObject.isAdded()) {
      paramViewGroup = this.b.saveFragmentInstanceState(paramObject);
    } else {
      paramViewGroup = null;
    }
    localArrayList.set(paramInt, paramViewGroup);
    this.e.set(paramInt, null);
    this.c.remove(paramObject);
  }
  
  public void finishUpdate(ViewGroup paramViewGroup)
  {
    paramViewGroup = this.c;
    if (paramViewGroup != null)
    {
      paramViewGroup.commitAllowingStateLoss();
      this.c = null;
    }
  }
  
  public int getCount()
  {
    List localList = this.g;
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
  
  public int getItemPosition(Object paramObject)
  {
    if ((paramObject instanceof ReadInJoyBaseFragment))
    {
      paramObject = (ReadInJoyBaseFragment)paramObject;
      int i = 0;
      while (i < this.g.size())
      {
        if (((TabChannelCoverInfo)this.g.get(i)).mChannelCoverId == paramObject.d())
        {
          int j = paramObject.s();
          QLog.d("PagerAdapter", 2, new Object[] { "getItemPosition, channelID = ", Integer.valueOf(paramObject.d()), ", channelName = ", ((TabChannelCoverInfo)this.g.get(i)).mChannelCoverName, ", oldPos = ", Integer.valueOf(j), ", newPos = ", Integer.valueOf(i) });
          if (j == i) {
            return -1;
          }
        }
        i += 1;
      }
      QLog.d("PagerAdapter", 2, new Object[] { "getItemPosition, channelID = ", Integer.valueOf(paramObject.d()), ",  POSITION_NONE" });
    }
    return -2;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    if (this.e.size() > paramInt)
    {
      localQBaseFragment = (QBaseFragment)this.e.get(paramInt);
      if (localQBaseFragment != null) {
        return localQBaseFragment;
      }
    }
    if (this.c == null) {
      this.c = this.b.beginTransaction();
    }
    QBaseFragment localQBaseFragment = b(paramInt);
    QLog.d("PagerAdapter", 2, new Object[] { "instantiateItem position = ", Integer.valueOf(paramInt), ", f = ", localQBaseFragment });
    while (this.e.size() <= paramInt) {
      this.e.add(null);
    }
    if (localQBaseFragment != null)
    {
      localQBaseFragment.setMenuVisibility(false);
      localQBaseFragment.setUserVisibleHint(false);
      this.e.set(paramInt, localQBaseFragment);
      this.c.add(paramViewGroup.getId(), localQBaseFragment);
    }
    return localQBaseFragment;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return ((QBaseFragment)paramObject).getView() == paramView;
  }
  
  public void restoreState(Parcelable paramParcelable, ClassLoader paramClassLoader)
  {
    if (paramParcelable != null)
    {
      paramParcelable = (Bundle)paramParcelable;
      paramParcelable.setClassLoader(paramClassLoader);
      paramClassLoader = paramParcelable.getParcelableArray("states");
      this.d.clear();
      this.e.clear();
      int i;
      if (paramClassLoader != null)
      {
        i = 0;
        while (i < paramClassLoader.length)
        {
          this.d.add((Fragment.SavedState)paramClassLoader[i]);
          i += 1;
        }
      }
      paramClassLoader = paramParcelable.keySet().iterator();
      while (paramClassLoader.hasNext())
      {
        String str = (String)paramClassLoader.next();
        if (str.startsWith("f"))
        {
          i = Integer.parseInt(str.substring(1));
          Object localObject = (QBaseFragment)this.b.getFragment(paramParcelable, str);
          if (localObject != null)
          {
            while (this.e.size() <= i) {
              this.e.add(null);
            }
            ((QBaseFragment)localObject).setMenuVisibility(false);
            this.e.set(i, localObject);
          }
          else
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("Bad fragment at key ");
            ((StringBuilder)localObject).append(str);
            Log.w("PagerAdapter", ((StringBuilder)localObject).toString());
          }
        }
      }
    }
  }
  
  public Parcelable saveState()
  {
    Object localObject2;
    Object localObject1;
    if (this.d.size() > 0)
    {
      localObject2 = new Bundle();
      localObject1 = new Fragment.SavedState[this.d.size()];
      this.d.toArray((Object[])localObject1);
      ((Bundle)localObject2).putParcelableArray("states", (Parcelable[])localObject1);
    }
    else
    {
      localObject2 = null;
    }
    int i = 0;
    while (i < this.e.size())
    {
      QBaseFragment localQBaseFragment = (QBaseFragment)this.e.get(i);
      localObject1 = localObject2;
      if (localQBaseFragment != null)
      {
        localObject1 = localObject2;
        if (localQBaseFragment.isAdded())
        {
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = new Bundle();
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("f");
          ((StringBuilder)localObject2).append(i);
          localObject2 = ((StringBuilder)localObject2).toString();
          this.b.putFragment((Bundle)localObject1, (String)localObject2, localQBaseFragment);
        }
      }
      i += 1;
      localObject2 = localObject1;
    }
    return localObject2;
  }
  
  public void setPrimaryItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup = (QBaseFragment)paramObject;
    if (paramViewGroup != null)
    {
      if (!paramViewGroup.isAdded()) {
        return;
      }
      paramObject = this.f;
      if (paramViewGroup != paramObject)
      {
        if (paramObject != null)
        {
          paramObject.setMenuVisibility(false);
          this.f.setUserVisibleHint(false);
        }
        if (paramViewGroup != null)
        {
          paramViewGroup.setMenuVisibility(true);
          paramViewGroup.setUserVisibleHint(true);
        }
        this.f = paramViewGroup;
        a(this.f);
      }
    }
  }
  
  public void startUpdate(ViewGroup paramViewGroup)
  {
    if (paramViewGroup.getId() != -1) {
      return;
    }
    paramViewGroup = new StringBuilder();
    paramViewGroup.append("ViewPager with adapter ");
    paramViewGroup.append(this);
    paramViewGroup.append(" requires a view id");
    throw new IllegalStateException(paramViewGroup.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.tab.ReadInJoyChannelViewPager.CustomFragmentPagerAdapter
 * JD-Core Version:    0.7.0.1
 */