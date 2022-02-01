package com.tencent.mobileqq.flashshow.fragment.list;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.widget.MultiTabViewPager;
import com.tencent.mobileqq.flashshow.fragment.FSBaseFragment;
import com.tencent.mobileqq.flashshow.list.blocks.FSBaseListBlock;
import com.tencent.mobileqq.flashshow.part.FSPublicListCommonPart;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FSPublicListFragment
  extends FSBaseFragment
{
  protected FSPublicListCommonPart b;
  protected ArrayList<FSBaseListBlock> c;
  protected ArrayList<String> d;
  protected List<BasePartFragment> e;
  protected MultiTabViewPager f;
  protected FSPublicListFragment.MultiFragmentsAdapter g;
  
  private void h()
  {
    this.f = ((MultiTabViewPager)this.D.findViewById(2131450004));
    this.g = new FSPublicListFragment.MultiFragmentsAdapter(this, getChildFragmentManager(), null);
    List localList = this.e;
    if ((localList != null) && (localList.size() > 1)) {
      this.f.setOffscreenPageLimit(this.e.size() - 1);
    }
    this.f.setAdapter(this.g);
  }
  
  public BasePartFragment a(String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = (BasePartFragment)Class.forName(paramString).getConstructor(new Class[0]).newInstance(new Object[0]);
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initAdapterError");
      localStringBuilder.append(paramString.getMessage());
      QLog.e("PublicListFragment", 1, localStringBuilder.toString());
    }
    return null;
  }
  
  public FSBaseListBlock a(Intent paramIntent, String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = (FSBaseListBlock)Class.forName(paramString).getConstructor(new Class[] { Bundle.class }).newInstance(new Object[] { getActivity().getIntent().getExtras() });
        try
        {
          if (paramIntent.hasExtra("public_list_init_data")) {
            paramString.setDatas((ArrayList)paramIntent.getSerializableExtra("public_list_init_data"));
          }
          String str = paramString;
          if (!paramIntent.hasExtra("key_bundle_common_init_bean")) {
            return ???;
          }
          paramString.setInitBean(paramIntent.getSerializableExtra("key_bundle_common_init_bean"));
          return paramString;
        }
        catch (Exception localException1)
        {
          paramIntent = paramString;
        }
      }
      else
      {
        return null;
      }
    }
    catch (Exception localException2)
    {
      paramIntent = null;
      paramString = new StringBuilder();
      paramString.append("initAdapterError");
      paramString.append(localException2.getMessage());
      QLog.e("PublicListFragment", 1, paramString.toString());
      Intent localIntent = paramIntent;
      return localIntent;
    }
  }
  
  protected void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    h();
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
  }
  
  public String b()
  {
    return "PublicListFragment";
  }
  
  protected int c()
  {
    return 2131624813;
  }
  
  protected List<Part> d()
  {
    ArrayList localArrayList = new ArrayList();
    this.b = new FSPublicListCommonPart(this.c);
    localArrayList.add(this.b);
    return localArrayList;
  }
  
  public String e()
  {
    return "";
  }
  
  protected void g()
  {
    Intent localIntent = getActivity().getIntent();
    if ((localIntent != null) && (localIntent.hasExtra("public_list_block_class_array"))) {
      try
      {
        this.c = new ArrayList();
        this.e = new ArrayList();
        this.d = localIntent.getStringArrayListExtra("public_list_block_class_array");
        Object localObject1 = this.d.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (String)((Iterator)localObject1).next();
          FSBaseListBlock localFSBaseListBlock = a(localIntent, (String)localObject2);
          if (localFSBaseListBlock != null)
          {
            FSPublicListInnerFragment localFSPublicListInnerFragment = new FSPublicListInnerFragment();
            localFSPublicListInnerFragment.a(localFSBaseListBlock);
            this.c.add(localFSBaseListBlock);
            this.e.add(localFSPublicListInnerFragment);
          }
          localObject2 = a((String)localObject2);
          if (localObject2 != null) {
            this.e.add(localObject2);
          }
        }
        QLog.e("PublicListFragment", 1, "intent can't be null");
      }
      catch (Exception localException)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("initIntentData error");
        ((StringBuilder)localObject1).append(localException.getMessage());
        QLog.e("PublicListFragment", 1, ((StringBuilder)localObject1).toString());
        getActivity().finish();
        return;
      }
    } else {
      getActivity().finish();
    }
  }
  
  public int j()
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      FSBaseListBlock localFSBaseListBlock = (FSBaseListBlock)localIterator.next();
      if (localFSBaseListBlock.getStatusBarColor() != 0) {
        return localFSBaseListBlock.getStatusBarColor();
      }
    }
    return 0;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Object localObject = this.c;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((FSBaseListBlock)((Iterator)localObject).next()).onActivityResult(paramInt1, paramInt2, paramIntent);
      }
    }
  }
  
  public void onAttach(Context paramContext)
  {
    super.onAttach(paramContext);
    g();
  }
  
  public boolean onBackEvent()
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      if (((FSBaseListBlock)localIterator.next()).onBackEvent()) {
        return true;
      }
    }
    return super.onBackEvent();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.fragment.list.FSPublicListFragment
 * JD-Core Version:    0.7.0.1
 */