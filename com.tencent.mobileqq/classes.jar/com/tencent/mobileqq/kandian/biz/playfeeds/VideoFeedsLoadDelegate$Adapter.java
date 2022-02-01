package com.tencent.mobileqq.kandian.biz.playfeeds;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.tencent.mobileqq.app.QBaseFragment;
import java.util.List;

public class VideoFeedsLoadDelegate$Adapter
  extends FragmentStatePagerAdapter
{
  private List<QBaseFragment> a;
  private String[] b;
  
  public VideoFeedsLoadDelegate$Adapter(FragmentManager paramFragmentManager, List<QBaseFragment> paramList, String[] paramArrayOfString)
  {
    super(paramFragmentManager);
    this.a = paramList;
    this.b = paramArrayOfString;
  }
  
  public QBaseFragment a(int paramInt)
  {
    return (QBaseFragment)this.a.get(paramInt);
  }
  
  public List<QBaseFragment> a()
  {
    return this.a;
  }
  
  public int getCount()
  {
    List localList = this.a;
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
  
  public int getItemPosition(Object paramObject)
  {
    if (this.a.indexOf(paramObject) < 0) {
      return -2;
    }
    return -1;
  }
  
  public CharSequence getPageTitle(int paramInt)
  {
    String[] arrayOfString = this.b;
    if ((arrayOfString != null) && (paramInt < arrayOfString.length)) {
      return arrayOfString[paramInt];
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsLoadDelegate.Adapter
 * JD-Core Version:    0.7.0.1
 */