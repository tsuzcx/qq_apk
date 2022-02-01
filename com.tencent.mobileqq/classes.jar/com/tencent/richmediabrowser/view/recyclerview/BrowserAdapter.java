package com.tencent.richmediabrowser.view.recyclerview;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import com.tencent.richmediabrowser.model.MainBrowserModel;
import com.tencent.richmediabrowser.model.RichMediaBaseData;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.presenter.BrowserBasePresenter;
import com.tencent.richmediabrowser.presenter.MainBrowserPresenter;
import com.tencent.richmediabrowser.utils.ScreenUtils;
import com.tencent.richmediabrowser.view.BrowserBaseView;
import com.tencent.richmediabrowser.view.MainBrowserScene;

public class BrowserAdapter
  extends RecyclerView.Adapter<BrowserAdapter.BrowserViewHolder>
{
  private static final String TAG = "BrowserAdapter";
  private boolean isFirstCome = true;
  private Activity mActivity;
  public MainBrowserPresenter mainBrowserPresenter;
  int margin;
  int screenHeight;
  int screenWidth;
  
  public BrowserAdapter(Activity paramActivity)
  {
    this.mActivity = paramActivity;
    this.margin = ScreenUtils.dip2px(this.mActivity, 0.0F);
    this.screenWidth = ScreenUtils.getScreenWidth(this.mActivity);
    this.screenHeight = ScreenUtils.getScreenHeight(this.mActivity);
  }
  
  private void setParams(View paramView, int paramInt)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    if ((paramInt == 0) || (paramInt == getItemCount() - 1)) {
      localLayoutParams.leftMargin = 0;
    }
    for (localLayoutParams.rightMargin = 0;; localLayoutParams.rightMargin = this.margin)
    {
      localLayoutParams.width = this.screenWidth;
      localLayoutParams.height = this.screenHeight;
      paramView.setLayoutParams(localLayoutParams);
      return;
      localLayoutParams.leftMargin = this.margin;
    }
  }
  
  public RichMediaBrowserInfo getItem(int paramInt)
  {
    if ((this.mainBrowserPresenter != null) && (this.mainBrowserPresenter.browserModel != null)) {
      return this.mainBrowserPresenter.browserModel.getItem(paramInt);
    }
    return null;
  }
  
  public int getItemCount()
  {
    if ((this.mainBrowserPresenter != null) && (this.mainBrowserPresenter.browserModel != null)) {
      return this.mainBrowserPresenter.browserModel.getCount();
    }
    return 0;
  }
  
  public int getItemViewType(int paramInt)
  {
    RichMediaBrowserInfo localRichMediaBrowserInfo = getItem(paramInt);
    if ((localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData != null)) {
      return localRichMediaBrowserInfo.baseData.getType();
    }
    return super.getItemViewType(paramInt);
  }
  
  public void onBindViewHolder(BrowserAdapter.BrowserViewHolder paramBrowserViewHolder, int paramInt)
  {
    BrowserLogHelper.getInstance().getGalleryLog().i("BrowserAdapter", 2, "onBindViewHolder position = " + paramInt);
    if (paramBrowserViewHolder != null)
    {
      paramBrowserViewHolder = paramBrowserViewHolder.itemView;
      if (paramBrowserViewHolder != null)
      {
        paramBrowserViewHolder.bindView(paramInt);
        if (this.isFirstCome)
        {
          this.isFirstCome = false;
          this.mainBrowserPresenter.onItemSelect(paramInt);
          paramBrowserViewHolder.onItemSelected(paramInt);
        }
      }
    }
  }
  
  public BrowserAdapter.BrowserViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    BrowserLogHelper.getInstance().getGalleryLog().i("BrowserAdapter", 2, "onCreateViewHolder  viewType = " + paramInt);
    BrowserBaseView localBrowserBaseView = this.mainBrowserPresenter.buildItemView(paramInt);
    if (localBrowserBaseView != null)
    {
      localBrowserBaseView.getView(localBrowserBaseView.mBrowserItemView, paramViewGroup);
      paramViewGroup = localBrowserBaseView;
      if (localBrowserBaseView.mBrowserItemView != null) {
        return new BrowserAdapter.BrowserViewHolder(this, localBrowserBaseView);
      }
    }
    else
    {
      BrowserLogHelper.getInstance().getGalleryLog().i("BrowserAdapter", 2, "onCreateViewHolder  baseView is null");
      paramViewGroup = new BrowserBaseView(this.mActivity, new BrowserBasePresenter());
      paramViewGroup.mBrowserItemView = new RelativeLayout(this.mActivity);
    }
    return new BrowserAdapter.BrowserViewHolder(this, paramViewGroup);
  }
  
  public void onViewRecycled(BrowserAdapter.BrowserViewHolder paramBrowserViewHolder)
  {
    super.onViewRecycled(paramBrowserViewHolder);
    if ((paramBrowserViewHolder.itemView != null) && (this.mainBrowserPresenter != null) && (this.mainBrowserPresenter.browserScene != null))
    {
      int i = this.mainBrowserPresenter.browserScene.getPosition(paramBrowserViewHolder.itemView.mBrowserItemView);
      BrowserLogHelper.getInstance().getGalleryLog().i("BrowserAdapter", 2, "onViewRecycled position = " + i);
      paramBrowserViewHolder.itemView.onDestroyView(i, paramBrowserViewHolder.itemView.mBrowserItemView);
    }
  }
  
  public void reset()
  {
    this.isFirstCome = true;
  }
  
  public void setPresenter(MainBrowserPresenter paramMainBrowserPresenter)
  {
    this.mainBrowserPresenter = paramMainBrowserPresenter;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.richmediabrowser.view.recyclerview.BrowserAdapter
 * JD-Core Version:    0.7.0.1
 */