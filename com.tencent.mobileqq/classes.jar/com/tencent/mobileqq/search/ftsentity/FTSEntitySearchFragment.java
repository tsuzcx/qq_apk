package com.tencent.mobileqq.search.ftsentity;

import android.os.Bundle;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.base.activity.BaseSearchActivity;
import com.tencent.mobileqq.search.base.adapter.BaseMvpAdapter;
import com.tencent.mobileqq.search.base.engine.ISearchEngine;
import com.tencent.mobileqq.search.base.fragment.BaseSearchFragment;
import com.tencent.mobileqq.search.base.model.SearchRespData;
import com.tencent.mobileqq.search.ftsmsg.FTSMessageSearchEngine;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class FTSEntitySearchFragment
  extends BaseSearchFragment
{
  public static FTSEntitySearchFragment b(String paramString)
  {
    FTSEntitySearchFragment localFTSEntitySearchFragment = new FTSEntitySearchFragment();
    Bundle localBundle = new Bundle(1);
    localBundle.putString("keyword", paramString);
    localFTSEntitySearchFragment.setArguments(localBundle);
    return localFTSEntitySearchFragment;
  }
  
  public void a(String paramString)
  {
    super.a(paramString, 1);
  }
  
  public void a(List paramList, int paramInt)
  {
    super.a(paramList, paramInt);
    if (!this.j)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(this.q);
      localObject = ((StringBuilder)localObject).toString();
      paramInt = 0;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      if (paramList != null) {
        paramInt = paramList.size();
      }
      localStringBuilder.append(paramInt);
      SearchUtils.a("talk", "exp_page", new String[] { localObject, localStringBuilder.toString() });
      this.j = true;
    }
  }
  
  public void a(List paramList, SearchRespData paramSearchRespData)
  {
    if (paramSearchRespData.a(this.q))
    {
      a(paramList, paramSearchRespData.b);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FTSEntitySearchFragment", 2, new Object[] { "onFinish not match keyword1:", paramSearchRespData.a, " keyword2:", this.q });
    }
  }
  
  protected BaseMvpAdapter b()
  {
    return new FTSEntitySearchFragment.1(this, this.l, this.n);
  }
  
  protected ISearchEngine c()
  {
    BaseSearchActivity localBaseSearchActivity = (BaseSearchActivity)getQBaseActivity();
    return FTSEntitySearchUtils.a((QQAppInterface)this.p, localBaseSearchActivity.j);
  }
  
  protected String d()
  {
    BaseSearchActivity localBaseSearchActivity = (BaseSearchActivity)getQBaseActivity();
    return FTSEntitySearchUtils.a(localBaseSearchActivity, localBaseSearchActivity.j);
  }
  
  protected String e()
  {
    return HardCodeUtil.a(2131899285);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (getArguments() != null) {
      this.q = getArguments().getString("keyword");
    }
  }
  
  public void onPause()
  {
    super.onPause();
    this.o.c();
  }
  
  public void onResume()
  {
    super.onResume();
    this.o.d();
  }
  
  public void onStart()
  {
    super.onStart();
    ((FTSMessageSearchEngine)this.o).f();
  }
  
  public void onStop()
  {
    super.onStop();
    ((FTSMessageSearchEngine)this.o).g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.ftsentity.FTSEntitySearchFragment
 * JD-Core Version:    0.7.0.1
 */