package com.tencent.shadow.core.runtime;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Fragment;
import android.app.FragmentManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class PluginFragmentManager
{
  FragmentManager mBase;
  
  PluginFragmentManager(FragmentManager paramFragmentManager)
  {
    this.mBase = paramFragmentManager;
  }
  
  @SuppressLint({"CommitTransaction"})
  public PluginFragmentTransaction beginTransaction()
  {
    return new PluginFragmentTransaction(this, this.mBase.beginTransaction());
  }
  
  public boolean executePendingTransactions()
  {
    return this.mBase.executePendingTransactions();
  }
  
  public ShadowFragment findFragmentByTag(String paramString)
  {
    paramString = this.mBase.findFragmentByTag(paramString);
    if ((paramString instanceof IContainerFragment)) {
      return ((IContainerFragment)paramString).getPluginFragment();
    }
    return null;
  }
  
  @TargetApi(26)
  public List<ShadowFragment> getFragments()
  {
    Object localObject = this.mBase.getFragments();
    ArrayList localArrayList = new ArrayList();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Fragment localFragment = (Fragment)((Iterator)localObject).next();
        if ((localFragment instanceof IContainerFragment)) {
          localArrayList.add(((IContainerFragment)localFragment).getPluginFragment());
        }
      }
    }
    if (localArrayList.size() > 0) {
      return localArrayList;
    }
    return Collections.EMPTY_LIST;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.shadow.core.runtime.PluginFragmentManager
 * JD-Core Version:    0.7.0.1
 */