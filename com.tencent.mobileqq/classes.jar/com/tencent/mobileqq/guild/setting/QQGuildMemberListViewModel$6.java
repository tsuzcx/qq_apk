package com.tencent.mobileqq.guild.setting;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.qqguildsdk.callback.ISearchSink;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.qqguildsdk.search.model.ISearchResultModel;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.List;

class QQGuildMemberListViewModel$6
  implements ISearchSink<IGProUserInfo>
{
  QQGuildMemberListViewModel$6(QQGuildMemberListViewModel paramQQGuildMemberListViewModel) {}
  
  public void onSearchResult(int paramInt, String paramString, List<ISearchResultModel<IGProUserInfo>> paramList, boolean paramBoolean)
  {
    if (paramInt != 0)
    {
      QQToast.makeText(BaseApplication.getContext(), 1, paramString, 1).show();
      this.a.k.setValue(new ArrayList());
      return;
    }
    this.a.a(paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.setting.QQGuildMemberListViewModel.6
 * JD-Core Version:    0.7.0.1
 */