package com.tencent.mobileqq.filemanager.data.search;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.base.adapter.BaseMvpAdapter;
import com.tencent.mobileqq.search.base.engine.ISearchEngine;
import com.tencent.mobileqq.search.base.fragment.BaseSearchFragment;
import com.tencent.mobileqq.search.business.group.model.GroupSearchModelFileEntity;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.util.List;

public class FileSearchFragment
  extends BaseSearchFragment<ISearchResultModel>
{
  public List<ISearchResultModel> f;
  public String g;
  protected boolean h = true;
  int i = -1;
  
  protected BaseMvpAdapter b()
  {
    return new FileSearchFragment.FileSearchAdapter(this, this.l, this.n, this.f, this.g, (QQAppInterface)this.p);
  }
  
  public void b(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  protected ISearchEngine c()
  {
    return new FileManagerSearchEngine((QQAppInterface)this.p, this.i);
  }
  
  protected String d()
  {
    return GroupSearchModelFileEntity.b;
  }
  
  protected String e()
  {
    return HardCodeUtil.a(2131899282);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramViewGroup = (TextView)this.k.findViewById(2131434940);
    if (!this.h) {
      paramViewGroup.setVisibility(8);
    } else {
      paramViewGroup.setVisibility(0);
    }
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.FileSearchFragment
 * JD-Core Version:    0.7.0.1
 */