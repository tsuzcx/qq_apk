package com.tencent.mobileqq.guild.setting;

import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider.Factory;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.callback.IGetGProUserListPaginationCallback.Result;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.qqguildsdk.search.model.ISearchResultModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class QQGuildVisibleMemberListViewModel
  extends QQGuildMemberListViewModel
{
  public static ViewModelProvider.Factory v = new QQGuildVisibleMemberListViewModel.1();
  protected int w = 0;
  protected String[] x;
  protected boolean y;
  
  public QQGuildVisibleMemberListViewModel(QQGuildInfoRepository paramQQGuildInfoRepository)
  {
    super(paramQQGuildInfoRepository);
  }
  
  private List<IGProUserInfo> c(List<IGProUserInfo> paramList)
  {
    if (this.w == 0) {
      return paramList;
    }
    LinkedList localLinkedList = new LinkedList();
    Object localObject;
    if (this.w == 2)
    {
      localObject = this.x;
      if (localObject == null) {
        return localLinkedList;
      }
      localObject = Arrays.asList((Object[])localObject);
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        IGProUserInfo localIGProUserInfo = (IGProUserInfo)paramList.next();
        if (((List)localObject).contains(localIGProUserInfo.a())) {
          localLinkedList.add(localIGProUserInfo);
        }
      }
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject = (IGProUserInfo)paramList.next();
      if (QQGuildUtil.c((IGProUserInfo)localObject)) {
        localLinkedList.add(localObject);
      }
    }
    return localLinkedList;
  }
  
  public void a(AppInterface paramAppInterface, IGProGuildInfo paramIGProGuildInfo, int paramInt, String[] paramArrayOfString)
  {
    super.a(paramAppInterface, paramIGProGuildInfo, "");
    this.w = paramInt;
    this.x = paramArrayOfString;
    boolean bool;
    if (paramInt != 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.y = bool;
  }
  
  public void a(AppInterface paramAppInterface, IGProGuildInfo paramIGProGuildInfo, String paramString)
  {
    super.a(paramAppInterface, paramIGProGuildInfo, paramString);
    if (!TextUtils.isEmpty(this.e))
    {
      paramAppInterface = ((IGPSService)this.s.getRuntimeService(IGPSService.class, "")).getChannelInfo(paramString);
      if (paramAppInterface != null)
      {
        this.w = paramAppInterface.getVisibleType();
        int i = this.w;
        boolean bool = true;
        if (i != 1) {
          bool = false;
        }
        this.y = bool;
      }
    }
  }
  
  protected void a(IGetGProUserListPaginationCallback.Result paramResult)
  {
    if ((this.y) && (paramResult.a == 0) && (paramResult.c != null) && (paramResult.e != null))
    {
      this.t = paramResult.e;
      if (paramResult.d) {
        this.j.postValue(Boolean.valueOf(true));
      }
      this.g.postValue(c(paramResult.c));
      this.r = false;
      return;
    }
    super.a(paramResult);
  }
  
  protected void a(List<ISearchResultModel<IGProUserInfo>> paramList)
  {
    if ((this.y) && (paramList != null) && (paramList.size() > 0))
    {
      paramList = new ArrayList(((ISearchResultModel)paramList.get(0)).b());
      this.k.postValue(c(paramList));
      return;
    }
    super.a(paramList);
  }
  
  public void s()
  {
    if ((this.b != null) && (!TextUtils.isEmpty(this.e)) && (this.w == 2))
    {
      ((IGPSService)this.s.getRuntimeService(IGPSService.class, "")).getVisibleMemberList(this.b.getGuildID(), this.e, 100, true, new QQGuildVisibleMemberListViewModel.2(this));
      this.r = true;
      return;
    }
    super.s();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.setting.QQGuildVisibleMemberListViewModel
 * JD-Core Version:    0.7.0.1
 */