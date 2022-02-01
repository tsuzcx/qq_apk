package dov.com.qq.im.ae.biz.qcircle.part;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

class AECirclePhotoListPart$PhotoPagerAdapter
  extends PagerAdapter
{
  private Fragment jdField_a_of_type_AndroidAppFragment = null;
  private FragmentManager jdField_a_of_type_AndroidAppFragmentManager;
  private FragmentTransaction jdField_a_of_type_AndroidAppFragmentTransaction = null;
  
  public AECirclePhotoListPart$PhotoPagerAdapter(AECirclePhotoListPart paramAECirclePhotoListPart, Fragment paramFragment)
  {
    if (Build.VERSION.SDK_INT >= 17)
    {
      this.jdField_a_of_type_AndroidAppFragmentManager = paramFragment.getChildFragmentManager();
      return;
    }
    this.jdField_a_of_type_AndroidAppFragmentManager = paramFragment.getFragmentManager();
  }
  
  private String a(int paramInt, long paramLong)
  {
    return "android:switcher:" + paramInt + ":" + paramLong;
  }
  
  public long a(int paramInt)
  {
    return paramInt;
  }
  
  public Fragment a(int paramInt)
  {
    return (Fragment)AECirclePhotoListPart.a(this.jdField_a_of_type_DovComQqImAeBizQcirclePartAECirclePhotoListPart).get(paramInt);
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    if (this.jdField_a_of_type_AndroidAppFragmentTransaction == null) {
      this.jdField_a_of_type_AndroidAppFragmentTransaction = this.jdField_a_of_type_AndroidAppFragmentManager.beginTransaction();
    }
    this.jdField_a_of_type_AndroidAppFragmentTransaction.detach((Fragment)paramObject);
  }
  
  public void finishUpdate(ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_AndroidAppFragmentTransaction != null)
    {
      this.jdField_a_of_type_AndroidAppFragmentTransaction.commitAllowingStateLoss();
      this.jdField_a_of_type_AndroidAppFragmentTransaction = null;
      this.jdField_a_of_type_AndroidAppFragmentManager.executePendingTransactions();
    }
  }
  
  public int getCount()
  {
    return AECirclePhotoListPart.a(this.jdField_a_of_type_DovComQqImAeBizQcirclePartAECirclePhotoListPart).size();
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidAppFragmentTransaction == null) {
      this.jdField_a_of_type_AndroidAppFragmentTransaction = this.jdField_a_of_type_AndroidAppFragmentManager.beginTransaction();
    }
    long l = a(paramInt);
    Object localObject = a(paramViewGroup.getId(), l);
    localObject = this.jdField_a_of_type_AndroidAppFragmentManager.findFragmentByTag((String)localObject);
    if (localObject != null) {
      this.jdField_a_of_type_AndroidAppFragmentTransaction.attach((Fragment)localObject);
    }
    for (paramViewGroup = (ViewGroup)localObject;; paramViewGroup = (ViewGroup)localObject)
    {
      if (paramViewGroup != this.jdField_a_of_type_AndroidAppFragment)
      {
        paramViewGroup.setMenuVisibility(false);
        paramViewGroup.setUserVisibleHint(false);
      }
      return paramViewGroup;
      localObject = a(paramInt);
      this.jdField_a_of_type_AndroidAppFragmentTransaction.add(paramViewGroup.getId(), (Fragment)localObject, a(paramViewGroup.getId(), l));
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return ((Fragment)paramObject).getView() == paramView;
  }
  
  public void restoreState(Parcelable paramParcelable, ClassLoader paramClassLoader) {}
  
  public Parcelable saveState()
  {
    return null;
  }
  
  public void setPrimaryItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup = (Fragment)paramObject;
    if (paramViewGroup != this.jdField_a_of_type_AndroidAppFragment)
    {
      if (this.jdField_a_of_type_AndroidAppFragment != null)
      {
        this.jdField_a_of_type_AndroidAppFragment.setMenuVisibility(false);
        this.jdField_a_of_type_AndroidAppFragment.setUserVisibleHint(false);
      }
      if (paramViewGroup != null)
      {
        paramViewGroup.setMenuVisibility(true);
        paramViewGroup.setUserVisibleHint(true);
      }
      this.jdField_a_of_type_AndroidAppFragment = paramViewGroup;
    }
  }
  
  public void startUpdate(ViewGroup paramViewGroup) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.biz.qcircle.part.AECirclePhotoListPart.PhotoPagerAdapter
 * JD-Core Version:    0.7.0.1
 */