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
  private final FragmentManager jdField_a_of_type_AndroidxFragmentAppFragmentManager;
  private FragmentTransaction jdField_a_of_type_AndroidxFragmentAppFragmentTransaction = null;
  private QBaseFragment jdField_a_of_type_ComTencentMobileqqAppQBaseFragment = null;
  CallHotwordChange jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkCallHotwordChange;
  private ArrayList<Fragment.SavedState> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private List<TabChannelCoverInfo> jdField_a_of_type_JavaUtilList;
  private ArrayList<QBaseFragment> b = new ArrayList();
  
  public ReadInJoyChannelViewPager$CustomFragmentPagerAdapter(FragmentManager paramFragmentManager)
  {
    this.jdField_a_of_type_AndroidxFragmentAppFragmentManager = paramFragmentManager;
    b();
  }
  
  private void a(QBaseFragment paramQBaseFragment)
  {
    if ((paramQBaseFragment instanceof ReadInJoyBaseFragment))
    {
      ReadInJoySrtUtils.a().a();
      paramQBaseFragment = (ReadInJoyBaseFragment)paramQBaseFragment;
      ReadInJoySrtUtils.a().a(String.valueOf(paramQBaseFragment.b()));
    }
  }
  
  private QBaseFragment b(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < getCount()))
    {
      TabChannelCoverInfo localTabChannelCoverInfo = (TabChannelCoverInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      QBaseFragment localQBaseFragment = ReadInJoyFragmentFactory.a().a(localTabChannelCoverInfo);
      if ((localQBaseFragment instanceof ReadInJoyBaseFragment))
      {
        ReadInJoyBaseFragment localReadInJoyBaseFragment = (ReadInJoyBaseFragment)localQBaseFragment;
        localReadInJoyBaseFragment.b(paramInt);
        localReadInJoyBaseFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkCallHotwordChange, localTabChannelCoverInfo.mChannelCoverId);
      }
      return localQBaseFragment;
    }
    return null;
  }
  
  private void b()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public QBaseFragment a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQBaseFragment;
  }
  
  public QBaseFragment a(int paramInt)
  {
    if (this.b.size() > paramInt) {
      return (QBaseFragment)this.b.get(paramInt);
    }
    return null;
  }
  
  public void a()
  {
    try
    {
      this.jdField_a_of_type_JavaUtilList.clear();
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
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkCallHotwordChange = paramCallHotwordChange;
  }
  
  public void a(List<TabChannelCoverInfo> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
    notifyDataSetChanged();
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramObject = (QBaseFragment)paramObject;
    if (this.jdField_a_of_type_AndroidxFragmentAppFragmentTransaction == null) {
      this.jdField_a_of_type_AndroidxFragmentAppFragmentTransaction = this.jdField_a_of_type_AndroidxFragmentAppFragmentManager.beginTransaction();
    }
    QLog.d("PagerAdapter", 2, new Object[] { "destroyItem position = ", Integer.valueOf(paramInt), ", f = ", paramObject });
    while (this.jdField_a_of_type_JavaUtilArrayList.size() <= paramInt) {
      this.jdField_a_of_type_JavaUtilArrayList.add(null);
    }
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if (paramObject.isAdded()) {
      paramViewGroup = this.jdField_a_of_type_AndroidxFragmentAppFragmentManager.saveFragmentInstanceState(paramObject);
    } else {
      paramViewGroup = null;
    }
    localArrayList.set(paramInt, paramViewGroup);
    this.b.set(paramInt, null);
    this.jdField_a_of_type_AndroidxFragmentAppFragmentTransaction.remove(paramObject);
  }
  
  public void finishUpdate(ViewGroup paramViewGroup)
  {
    paramViewGroup = this.jdField_a_of_type_AndroidxFragmentAppFragmentTransaction;
    if (paramViewGroup != null)
    {
      paramViewGroup.commitAllowingStateLoss();
      this.jdField_a_of_type_AndroidxFragmentAppFragmentTransaction = null;
    }
  }
  
  public int getCount()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
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
      while (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        if (((TabChannelCoverInfo)this.jdField_a_of_type_JavaUtilList.get(i)).mChannelCoverId == paramObject.b())
        {
          int j = paramObject.d();
          QLog.d("PagerAdapter", 2, new Object[] { "getItemPosition, channelID = ", Integer.valueOf(paramObject.b()), ", channelName = ", ((TabChannelCoverInfo)this.jdField_a_of_type_JavaUtilList.get(i)).mChannelCoverName, ", oldPos = ", Integer.valueOf(j), ", newPos = ", Integer.valueOf(i) });
          if (j == i) {
            return -1;
          }
        }
        i += 1;
      }
      QLog.d("PagerAdapter", 2, new Object[] { "getItemPosition, channelID = ", Integer.valueOf(paramObject.b()), ",  POSITION_NONE" });
    }
    return -2;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    if (this.b.size() > paramInt)
    {
      localQBaseFragment = (QBaseFragment)this.b.get(paramInt);
      if (localQBaseFragment != null) {
        return localQBaseFragment;
      }
    }
    if (this.jdField_a_of_type_AndroidxFragmentAppFragmentTransaction == null) {
      this.jdField_a_of_type_AndroidxFragmentAppFragmentTransaction = this.jdField_a_of_type_AndroidxFragmentAppFragmentManager.beginTransaction();
    }
    QBaseFragment localQBaseFragment = b(paramInt);
    QLog.d("PagerAdapter", 2, new Object[] { "instantiateItem position = ", Integer.valueOf(paramInt), ", f = ", localQBaseFragment });
    while (this.b.size() <= paramInt) {
      this.b.add(null);
    }
    if (localQBaseFragment != null)
    {
      localQBaseFragment.setMenuVisibility(false);
      localQBaseFragment.setUserVisibleHint(false);
      this.b.set(paramInt, localQBaseFragment);
      this.jdField_a_of_type_AndroidxFragmentAppFragmentTransaction.add(paramViewGroup.getId(), localQBaseFragment);
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
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.b.clear();
      int i;
      if (paramClassLoader != null)
      {
        i = 0;
        while (i < paramClassLoader.length)
        {
          this.jdField_a_of_type_JavaUtilArrayList.add((Fragment.SavedState)paramClassLoader[i]);
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
          Object localObject = (QBaseFragment)this.jdField_a_of_type_AndroidxFragmentAppFragmentManager.getFragment(paramParcelable, str);
          if (localObject != null)
          {
            while (this.b.size() <= i) {
              this.b.add(null);
            }
            ((QBaseFragment)localObject).setMenuVisibility(false);
            this.b.set(i, localObject);
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
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
    {
      localObject2 = new Bundle();
      localObject1 = new Fragment.SavedState[this.jdField_a_of_type_JavaUtilArrayList.size()];
      this.jdField_a_of_type_JavaUtilArrayList.toArray((Object[])localObject1);
      ((Bundle)localObject2).putParcelableArray("states", (Parcelable[])localObject1);
    }
    else
    {
      localObject2 = null;
    }
    int i = 0;
    while (i < this.b.size())
    {
      QBaseFragment localQBaseFragment = (QBaseFragment)this.b.get(i);
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
          this.jdField_a_of_type_AndroidxFragmentAppFragmentManager.putFragment((Bundle)localObject1, (String)localObject2, localQBaseFragment);
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
      paramObject = this.jdField_a_of_type_ComTencentMobileqqAppQBaseFragment;
      if (paramViewGroup != paramObject)
      {
        if (paramObject != null)
        {
          paramObject.setMenuVisibility(false);
          this.jdField_a_of_type_ComTencentMobileqqAppQBaseFragment.setUserVisibleHint(false);
        }
        if (paramViewGroup != null)
        {
          paramViewGroup.setMenuVisibility(true);
          paramViewGroup.setUserVisibleHint(true);
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQBaseFragment = paramViewGroup;
        a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseFragment);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.tab.ReadInJoyChannelViewPager.CustomFragmentPagerAdapter
 * JD-Core Version:    0.7.0.1
 */