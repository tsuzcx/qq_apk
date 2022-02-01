package com.tencent.mobileqq.flashshow.personal.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.tencent.mobileqq.flashshow.fragment.FSPersonalFeedFragment;
import java.util.ArrayList;
import java.util.List;

public class FSPersonalFeedVpAdapter
  extends FragmentStateAdapter
{
  private List<FSPersonalFeedFragment> a = new ArrayList();
  
  public FSPersonalFeedVpAdapter(@NonNull Fragment paramFragment)
  {
    super(paramFragment);
  }
  
  public void a(List<FSPersonalFeedFragment> paramList)
  {
    this.a = paramList;
    notifyDataSetChanged();
  }
  
  @NonNull
  public Fragment createFragment(int paramInt)
  {
    return (Fragment)this.a.get(paramInt);
  }
  
  public int getItemCount()
  {
    return this.a.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.personal.adapter.FSPersonalFeedVpAdapter
 * JD-Core Version:    0.7.0.1
 */