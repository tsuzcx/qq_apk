package com.tencent.mobileqq.qqlive.end;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider.Factory;
import com.tencent.mobileqq.mvvm.BaseViewModel;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.data.QQLiveEndPageInfo;
import com.tencent.mobileqq.qqlive.data.QQLiveEndRecommendInfo;
import java.util.ArrayList;

public class EndFragmentViewModel
  extends BaseViewModel<EndDataRepository>
{
  public static ViewModelProvider.Factory i = new EndFragmentViewModel.1();
  public final MutableLiveData<String> a = new MutableLiveData();
  public final MutableLiveData<String> b = new MutableLiveData();
  public final MutableLiveData<String> c = new MutableLiveData();
  public final MutableLiveData<Long> d = new MutableLiveData();
  public final MutableLiveData<Integer> e = new MutableLiveData();
  public final MutableLiveData<QQLiveEndRecommendInfo> f = new MutableLiveData();
  public final MutableLiveData<QQLiveEndRecommendInfo> g = new MutableLiveData();
  public final MutableLiveData<Boolean> h = new MutableLiveData();
  private IQQLiveSDK j;
  
  public EndFragmentViewModel(EndDataRepository paramEndDataRepository)
  {
    super(paramEndDataRepository);
  }
  
  public void a(IQQLiveSDK paramIQQLiveSDK)
  {
    this.j = paramIQQLiveSDK;
  }
  
  public void a(QQLiveEndPageInfo paramQQLiveEndPageInfo)
  {
    if (paramQQLiveEndPageInfo != null)
    {
      if (paramQQLiveEndPageInfo.uid == paramQQLiveEndPageInfo.anchorUid) {
        this.h.postValue(Boolean.valueOf(false));
      } else {
        this.h.postValue(Boolean.valueOf(true));
      }
      if (paramQQLiveEndPageInfo.headIcon != null) {
        this.a.postValue(paramQQLiveEndPageInfo.headIcon);
      }
      if (paramQQLiveEndPageInfo.nick != null) {
        this.b.postValue(paramQQLiveEndPageInfo.nick);
      }
      if (paramQQLiveEndPageInfo.popularity != null) {
        this.c.postValue(paramQQLiveEndPageInfo.popularity);
      }
      this.d.postValue(Long.valueOf(paramQQLiveEndPageInfo.time));
      this.e.postValue(Integer.valueOf(paramQQLiveEndPageInfo.follow));
      if ((paramQQLiveEndPageInfo.recommendInfos != null) && (paramQQLiveEndPageInfo.recommendInfos.size() > 0)) {
        if (paramQQLiveEndPageInfo.recommendInfos.size() == 1)
        {
          if (paramQQLiveEndPageInfo.recommendInfos.get(0) != null) {
            this.f.postValue(paramQQLiveEndPageInfo.recommendInfos.get(0));
          }
        }
        else if (paramQQLiveEndPageInfo.recommendInfos.get(1) != null) {
          this.g.postValue(paramQQLiveEndPageInfo.recommendInfos.get(1));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.end.EndFragmentViewModel
 * JD-Core Version:    0.7.0.1
 */