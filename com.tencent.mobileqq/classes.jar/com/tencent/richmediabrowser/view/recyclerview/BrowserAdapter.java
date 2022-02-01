package com.tencent.richmediabrowser.view.recyclerview;

import android.content.Context;
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
  private Context mContext;
  public MainBrowserPresenter mainBrowserPresenter;
  int margin;
  int screenHeight;
  int screenWidth;
  
  public BrowserAdapter(Context paramContext)
  {
    this.mContext = paramContext;
    this.margin = ScreenUtils.dip2px(this.mContext, 0.0F);
    this.screenWidth = ScreenUtils.getScreenWidth(this.mContext);
    this.screenHeight = ScreenUtils.getScreenHeight(this.mContext);
  }
  
  private void setParams(View paramView, int paramInt)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    if ((paramInt != 0) && (paramInt != getItemCount() - 1))
    {
      paramInt = this.margin;
      localLayoutParams.leftMargin = paramInt;
      localLayoutParams.rightMargin = paramInt;
    }
    else
    {
      localLayoutParams.leftMargin = 0;
      localLayoutParams.rightMargin = 0;
    }
    localLayoutParams.width = this.screenWidth;
    localLayoutParams.height = this.screenHeight;
    paramView.setLayoutParams(localLayoutParams);
  }
  
  public RichMediaBrowserInfo getItem(int paramInt)
  {
    MainBrowserPresenter localMainBrowserPresenter = this.mainBrowserPresenter;
    if ((localMainBrowserPresenter != null) && (localMainBrowserPresenter.browserModel != null)) {
      return this.mainBrowserPresenter.browserModel.getItem(paramInt);
    }
    return null;
  }
  
  public int getItemCount()
  {
    MainBrowserPresenter localMainBrowserPresenter = this.mainBrowserPresenter;
    if ((localMainBrowserPresenter != null) && (localMainBrowserPresenter.browserModel != null)) {
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
    IBrowserLog localIBrowserLog = BrowserLogHelper.getInstance().getGalleryLog();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onBindViewHolder position = ");
    localStringBuilder.append(paramInt);
    localIBrowserLog.i("BrowserAdapter", 2, localStringBuilder.toString());
    if (paramBrowserViewHolder != null)
    {
      paramBrowserViewHolder = paramBrowserViewHolder.itemView;
      if ((paramBrowserViewHolder instanceof BrowserBaseView))
      {
        paramBrowserViewHolder = (BrowserBaseView)paramBrowserViewHolder;
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
    Object localObject = BrowserLogHelper.getInstance().getGalleryLog();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onCreateViewHolder  viewType = ");
    localStringBuilder.append(paramInt);
    ((IBrowserLog)localObject).i("BrowserAdapter", 2, localStringBuilder.toString());
    localObject = this.mainBrowserPresenter.buildItemView(paramInt);
    if ((localObject instanceof BrowserBaseView))
    {
      localObject = (BrowserBaseView)localObject;
      ((BrowserBaseView)localObject).getView(((BrowserBaseView)localObject).mBrowserItemView, paramViewGroup);
      paramViewGroup = (ViewGroup)localObject;
      if (((BrowserBaseView)localObject).mBrowserItemView != null) {
        return new BrowserAdapter.BrowserViewHolder(this, (BrowserBaseView)localObject, this.mainBrowserPresenter.getDecoratorPresenter(paramInt), this.mainBrowserPresenter.getPresenter(paramInt));
      }
    }
    else
    {
      BrowserLogHelper.getInstance().getGalleryLog().i("BrowserAdapter", 2, "onCreateViewHolder  baseView is null");
      paramViewGroup = new BrowserBaseView(this.mContext, new BrowserBasePresenter());
      paramViewGroup.mBrowserItemView = new RelativeLayout(this.mContext);
    }
    return new BrowserAdapter.BrowserViewHolder(this, paramViewGroup, this.mainBrowserPresenter.getDecoratorPresenter(paramInt), this.mainBrowserPresenter.getPresenter(paramInt));
  }
  
  public void onViewRecycled(BrowserAdapter.BrowserViewHolder paramBrowserViewHolder)
  {
    super.onViewRecycled(paramBrowserViewHolder);
    if ((paramBrowserViewHolder.itemView instanceof BrowserBaseView))
    {
      Object localObject = this.mainBrowserPresenter;
      if ((localObject != null) && (((MainBrowserPresenter)localObject).browserScene != null))
      {
        paramBrowserViewHolder = (BrowserBaseView)paramBrowserViewHolder.itemView;
        int i = this.mainBrowserPresenter.browserScene.getPosition(paramBrowserViewHolder.mBrowserItemView);
        localObject = BrowserLogHelper.getInstance().getGalleryLog();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onViewRecycled position = ");
        localStringBuilder.append(i);
        ((IBrowserLog)localObject).i("BrowserAdapter", 2, localStringBuilder.toString());
        paramBrowserViewHolder.onDestroyView(i, paramBrowserViewHolder.mBrowserItemView);
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.richmediabrowser.view.recyclerview.BrowserAdapter
 * JD-Core Version:    0.7.0.1
 */