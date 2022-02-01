package com.tencent.mobileqq.flashshow.list.blocks;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import androidx.fragment.app.Fragment;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.richframework.part.block.BlockMerger;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.mobileqq.flashshow.fragment.list.FSPublicListInnerFragment;
import com.tencent.mobileqq.flashshow.helper.FSPopupWindowHelper;
import com.tencent.mobileqq.flashshow.utils.FSThemeUtil;
import com.tencent.mobileqq.flashshow.widgets.FSBaseMultiViewBlock;
import com.tencent.mobileqq.flashshow.widgets.fault.FSListHintView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.idata.ILoadDataAsync;
import com.tencent.richframework.data.idata.ILoadDataByReq;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public abstract class FSBaseListBlock<E, T>
  extends FSBaseMultiViewBlock<E>
  implements ILoadDataAsync<E>, ILoadDataByReq<BaseRequest, E, T>
{
  private List<E> mAllListData;
  protected FSListHintView mHintView;
  protected Serializable mInitBean;
  protected boolean mIsFinish;
  protected String mLastAttachInfo;
  
  public FSBaseListBlock(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  private void handleLoadMoreData()
  {
    List localList = this.mAllListData;
    if ((localList != null) && (localList.size() > 0))
    {
      int i = this.mAllListData.size() - getDataList().size();
      if (i <= 0) {
        return;
      }
      if (i > getPageCount())
      {
        i = getPageCount();
        this.mIsFinish = false;
      }
      else
      {
        this.mIsFinish = true;
      }
      QLog.d(getLogTag(), 1, String.format(Locale.getDefault(), "MSG_LOAD_NEXT_PAGE totalCount: %s, loadCount: %s", new Object[] { Integer.valueOf(this.mAllListData.size()), Integer.valueOf(i) }));
      handleListData(this.mAllListData.subList(getDataList().size(), getDataList().size() + i), true, this.mIsFinish);
    }
  }
  
  private void handleRefreshData(List<E> paramList)
  {
    Object localObject = paramList;
    if (paramList == null) {
      localObject = new ArrayList();
    }
    this.mAllListData = ((List)localObject);
    int k = ((List)localObject).size();
    int j = Math.min(k, getPageCount());
    int i = j;
    if (getDataList().size() > j)
    {
      i = j;
      if (getDataList().size() <= k) {
        i = getDataList().size();
      }
    }
    boolean bool;
    if (i == k) {
      bool = true;
    } else {
      bool = false;
    }
    this.mIsFinish = bool;
    QLog.d(getLogTag(), 1, String.format(Locale.getDefault(), "MSG_REFRESH_LIST_GLOBAL totalCount: %s, loadCount: %s, curItemCount: %s", new Object[] { Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(getDataList().size()) }));
    handleListData(((List)localObject).subList(0, i), false, this.mIsFinish);
  }
  
  public int getContentLayoutId()
  {
    return 2131624812;
  }
  
  public abstract List<Part> getCustomParts();
  
  public String getDaTongPageId()
  {
    return "";
  }
  
  public abstract String getDropFrameMonitorTag();
  
  public abstract String getEmptyHint();
  
  public FSPublicListInnerFragment getHostFragment()
  {
    if ((getParentFragment() instanceof FSPublicListInnerFragment)) {
      return (FSPublicListInnerFragment)getParentFragment();
    }
    return null;
  }
  
  public int getItemCount()
  {
    return this.mDataList.size();
  }
  
  public abstract String getLogTag();
  
  public BaseRequest getRequestWithLoadInfo(LoadInfo paramLoadInfo, String paramString)
  {
    if ((!paramLoadInfo.c()) && (!paramLoadInfo.d()))
    {
      if (paramLoadInfo.e()) {
        return (BaseRequest)getRequest(paramString);
      }
    }
    else
    {
      paramString = (BaseRequest)getRequest(null);
      if (paramString != null)
      {
        paramString.setEnableCache(paramLoadInfo.c());
        return paramString;
      }
    }
    return null;
  }
  
  public int getStatusBarColor()
  {
    return FSThemeUtil.a();
  }
  
  public abstract String getTitle();
  
  public abstract View getTitleTabView(ViewGroup paramViewGroup);
  
  public void handleListData(List<E> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    preHandleListData(paramList, paramBoolean1, paramBoolean2);
    RFThreadManager.getUIHandler().post(new FSBaseListBlock.1(this, paramList, paramBoolean1, paramBoolean2));
  }
  
  protected void handleResponse(boolean paramBoolean1, boolean paramBoolean2, long paramLong, String paramString1, String paramString2, T paramT)
  {
    if ((paramBoolean1) && (paramLong == 0L) && (paramT != null))
    {
      paramString2 = getListDataFromRsp(paramT);
      this.mIsFinish = getIsFinishFromRsp(paramT);
      this.mLastAttachInfo = getAttachInfoFromRsp(paramT);
      if (paramString2 != null)
      {
        String str = getLogTag();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString1);
        localStringBuilder.append("rspData size:");
        localStringBuilder.append(paramString2.size());
        localStringBuilder.append(" | isFinish:");
        localStringBuilder.append(this.mIsFinish);
        localStringBuilder.append(" | attachInfo:");
        localStringBuilder.append(getAttachInfoFromRsp(paramT));
        QLog.d(str, 1, localStringBuilder.toString());
        handleListData(paramString2, paramBoolean2, this.mIsFinish);
        return;
      }
      QLog.e(getLogTag(), 1, "handleResponse but listData is null");
      return;
    }
    showErrorView(paramString2, paramLong);
    clearData();
    notifyDataSetChanged();
    notifyLoadingComplete(true, false);
  }
  
  public abstract void initTitleBar(View paramView);
  
  public void loadData(LoadInfo paramLoadInfo)
  {
    BaseRequest localBaseRequest = getRequestWithLoadInfo(paramLoadInfo, this.mLastAttachInfo);
    if ((localBaseRequest != null) && (getParentFragment() != null))
    {
      bool1 = paramLoadInfo.e();
      boolean bool2 = localBaseRequest.isEnableCache();
      paramLoadInfo = localBaseRequest.getCmdName();
      VSNetworkHelper.getInstance().sendRequest(getParentFragment().hashCode(), localBaseRequest, new FSBaseListBlock.2(this, paramLoadInfo, bool1, bool2));
      return;
    }
    boolean bool1 = paramLoadInfo.c();
    localBaseRequest = null;
    if ((!bool1) && (!paramLoadInfo.d()))
    {
      if (paramLoadInfo.e())
      {
        FSBaseListBlock.4 local4 = new FSBaseListBlock.4(this);
        paramLoadInfo = localBaseRequest;
        if (getDataList() != null)
        {
          paramLoadInfo = localBaseRequest;
          if (getDataList().size() > 0) {
            paramLoadInfo = getAttachInfoFromItemData(getDataList().get(getDataList().size() - 1));
          }
        }
        if (paramLoadInfo != null)
        {
          getListDataAsync(local4, paramLoadInfo);
          return;
        }
        handleLoadMoreData();
      }
    }
    else {
      getListDataAsync(new FSBaseListBlock.3(this), null);
    }
  }
  
  public void notifyLoadingComplete(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((getBlockContainer() != null) && (getBlockMerger() != null))
    {
      getLoadInfo().a(4);
      Object localObject = getBlockContainer();
      boolean bool2 = false;
      ((BlockContainer)localObject).setRefreshing(false);
      if (isLastPeerBlock())
      {
        int i;
        if (getItemCount() == 0) {
          i = 1;
        } else {
          i = 0;
        }
        localObject = getBlockMerger();
        boolean bool1 = bool2;
        if (paramBoolean2)
        {
          bool1 = bool2;
          if (i == 0) {
            bool1 = true;
          }
        }
        ((BlockMerger)localObject).a(paramBoolean1, bool1);
      }
    }
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    super.onActivityCreated(paramActivity, paramBundle);
    getActivity().getWindow().setSoftInputMode(32);
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    FSPopupWindowHelper.a().b();
  }
  
  public void onDoubleClickTitle()
  {
    if ((getBlockContainer() != null) && (getBlockContainer().getRecyclerView() != null)) {
      getBlockContainer().getRecyclerView().scrollToPosition(0);
    }
  }
  
  public void onInitBlock(Bundle paramBundle)
  {
    QLog.d(getLogTag(), 1, "onPrepareParams");
    if (this.mHintView == null)
    {
      this.mHintView = new FSListHintView(getContext());
      getBlockContainer().addView(this.mHintView, new ViewGroup.LayoutParams(-1, -1));
    }
  }
  
  public abstract void onTitleTabSelectedChanged(View paramView, boolean paramBoolean);
  
  protected void preHandleListData(List<E> paramList, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void setInitBean(Serializable paramSerializable)
  {
    this.mInitBean = paramSerializable;
  }
  
  public void setInitData(ArrayList<E> paramArrayList)
  {
    setDatas(paramArrayList);
  }
  
  protected void showEmptyView()
  {
    FSListHintView localFSListHintView = this.mHintView;
    if (localFSListHintView != null) {
      localFSListHintView.a(getEmptyHint());
    }
  }
  
  protected void showErrorView(String paramString, long paramLong)
  {
    FSListHintView localFSListHintView = this.mHintView;
    if (localFSListHintView != null) {
      localFSListHintView.b(paramString);
    }
  }
  
  public void showListView()
  {
    if ((getHostFragment() != null) && (getHostFragment().i() != null))
    {
      FSListHintView localFSListHintView = this.mHintView;
      if (localFSListHintView != null) {
        localFSListHintView.setVisibility(8);
      }
      getHostFragment().i().getRecyclerView().setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.list.blocks.FSBaseListBlock
 * JD-Core Version:    0.7.0.1
 */