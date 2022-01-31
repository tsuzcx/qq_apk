package com.tencent.richmediabrowser.view;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.image.RegionDrawableData;
import com.tencent.richmediabrowser.listener.IGalleryScaleListener;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import com.tencent.richmediabrowser.model.MainBrowserModel;
import com.tencent.richmediabrowser.model.RichMediaBaseData;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.presenter.BrowserBasePresenter;
import com.tencent.richmediabrowser.presenter.MainBrowserPresenter;
import com.tencent.richmediabrowser.view.page.ProGallery.OnProGalleryListener;

public class BrowserAdapter
  extends BrowserBaseAdapter
  implements IGalleryScaleListener, ProGallery.OnProGalleryListener
{
  static final String TAG = "BrowserAdapter";
  public Context mContext;
  public MainBrowserPresenter mainBrowserPresenter;
  
  public BrowserAdapter(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private boolean isContainsContentView(RelativeLayout paramRelativeLayout)
  {
    if ((paramRelativeLayout == null) || (this.mainBrowserPresenter == null)) {}
    for (;;)
    {
      return false;
      RelativeLayout localRelativeLayout = this.mainBrowserPresenter.browserScene.getContentView();
      int i = localRelativeLayout.getChildCount() - 1;
      while (i >= 0)
      {
        if (paramRelativeLayout == localRelativeLayout.getChildAt(i)) {
          return true;
        }
        i -= 1;
      }
    }
  }
  
  public int getCount()
  {
    if ((this.mainBrowserPresenter != null) && (this.mainBrowserPresenter.browserModel != null)) {
      return this.mainBrowserPresenter.browserModel.getCount();
    }
    return super.getCount();
  }
  
  public BrowserBaseView getCurrentView()
  {
    if (this.mainBrowserPresenter != null)
    {
      BrowserBasePresenter localBrowserBasePresenter = getPresenter(this.mainBrowserPresenter.getCurrentPosition());
      if (localBrowserBasePresenter != null) {
        return localBrowserBasePresenter.browserBaseView;
      }
    }
    return null;
  }
  
  public RichMediaBrowserInfo getItem(int paramInt)
  {
    if ((this.mainBrowserPresenter == null) || (this.mainBrowserPresenter.browserModel == null)) {
      return null;
    }
    return this.mainBrowserPresenter.browserModel.getItem(paramInt);
  }
  
  public int getItemViewType(int paramInt)
  {
    RichMediaBrowserInfo localRichMediaBrowserInfo = getItem(paramInt);
    if ((localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData != null)) {
      return localRichMediaBrowserInfo.baseData.getType();
    }
    return super.getItemViewType(paramInt);
  }
  
  public BrowserBasePresenter getPresenter(int paramInt)
  {
    paramInt = getItemViewType(paramInt);
    if (this.mainBrowserPresenter != null) {
      return this.mainBrowserPresenter.getPresenter(paramInt);
    }
    return null;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = getItem(paramInt);
    GalleryUrlImageView localGalleryUrlImageView = new GalleryUrlImageView(this.mContext);
    if ((localObject == null) || (((RichMediaBrowserInfo)localObject).baseData == null) || (this.mainBrowserPresenter == null))
    {
      BrowserLogHelper.getInstance().getGalleryLog().e("BrowserAdapter", 2, " getView(): position=" + paramInt + " data is null");
      return localGalleryUrlImageView;
    }
    int i = ((RichMediaBrowserInfo)localObject).baseData.getType();
    if (this.mainBrowserPresenter.getPresenter(i) == null) {
      this.mainBrowserPresenter.buildMVP(i);
    }
    localObject = this.mainBrowserPresenter.getPresenter(i);
    if (localObject != null)
    {
      localObject = ((BrowserBasePresenter)localObject).browserBaseView;
      if (localObject != null)
      {
        paramView = ((BrowserBaseView)localObject).getView(paramInt, paramView, paramViewGroup);
        if ((paramView != null) && ((paramView.getTag() instanceof IBrowserViewHolder))) {
          ((BrowserBaseView)localObject).setViewHolder((IBrowserViewHolder)paramView.getTag());
        }
        return paramView;
      }
      BrowserLogHelper.getInstance().getGalleryLog().e("BrowserAdapter", 2, "getView() browserBaseView is null");
      return localGalleryUrlImageView;
    }
    BrowserLogHelper.getInstance().getGalleryLog().e("BrowserAdapter", 2, "getView() presenter is null");
    return localGalleryUrlImageView;
  }
  
  public View onCreateView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("BrowserAdapter", 4, "onCreateView position =" + paramInt);
    paramView = getItem(paramInt);
    if (paramView != null)
    {
      paramViewGroup = getPresenter(paramInt);
      if ((paramViewGroup != null) && (paramViewGroup.browserBaseView != null)) {
        paramViewGroup.browserBaseView.onCreateView(paramInt, paramView);
      }
    }
    return null;
  }
  
  public void onDestroyView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("BrowserAdapter", 4, "onDestroyView position =" + paramInt);
    BrowserBasePresenter localBrowserBasePresenter = getPresenter(paramInt);
    if ((localBrowserBasePresenter != null) && (localBrowserBasePresenter.browserBaseView != null)) {
      localBrowserBasePresenter.browserBaseView.onDestroyView(paramInt, paramView, paramViewGroup);
    }
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if (this.mainBrowserPresenter != null) {
      this.mainBrowserPresenter.onDoubleTap(paramMotionEvent);
    }
    return true;
  }
  
  public void onItemSelected(int paramInt)
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("BrowserAdapter", 4, "onItemSelected position =" + paramInt);
    int i = getItemViewType(this.mainBrowserPresenter.getCurrentPosition());
    paramInt = getItemViewType(paramInt);
    if (i != paramInt)
    {
      localBrowserBasePresenter = this.mainBrowserPresenter.getPresenter(i);
      if ((localBrowserBasePresenter != null) && (localBrowserBasePresenter.browserBaseView != null) && (isContainsContentView(localBrowserBasePresenter.browserBaseView.contentView))) {
        this.mainBrowserPresenter.browserScene.getContentView().removeView(localBrowserBasePresenter.browserBaseView.contentView);
      }
    }
    BrowserBasePresenter localBrowserBasePresenter = this.mainBrowserPresenter.getPresenter(paramInt);
    if ((localBrowserBasePresenter != null) && (localBrowserBasePresenter.browserBaseView != null) && (!isContainsContentView(localBrowserBasePresenter.browserBaseView.contentView)))
    {
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      if (localBrowserBasePresenter.browserBaseView.contentView != null) {
        this.mainBrowserPresenter.browserScene.getContentView().addView(localBrowserBasePresenter.browserBaseView.contentView, localLayoutParams);
      }
    }
  }
  
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    if (this.mainBrowserPresenter != null) {
      this.mainBrowserPresenter.onScale(paramScaleGestureDetector);
    }
    return true;
  }
  
  public void onShowAreaChanged(int paramInt, View paramView, RegionDrawableData paramRegionDrawableData)
  {
    BrowserBasePresenter localBrowserBasePresenter = getPresenter(paramInt);
    if ((localBrowserBasePresenter != null) && (localBrowserBasePresenter.browserBaseView != null)) {
      localBrowserBasePresenter.browserBaseView.onShowAreaChanged(paramInt, paramView, paramRegionDrawableData);
    }
  }
  
  public void onSlot(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    BrowserLogHelper.getInstance().getGalleryLog().i("BrowserAdapter", 2, "onSlot(): position = " + paramInt);
    System.gc();
  }
  
  public void onViewDetached(int paramInt, View paramView, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    BrowserLogHelper.getInstance().getGalleryLog().i("BrowserAdapter", 2, "onViewDetached position = " + paramInt);
    paramViewGroup = getPresenter(paramInt);
    if ((paramViewGroup != null) && (paramViewGroup.browserBaseView != null))
    {
      RichMediaBrowserInfo localRichMediaBrowserInfo = getItem(paramInt);
      paramViewGroup.browserBaseView.onViewDetached(paramInt, paramView, localRichMediaBrowserInfo);
    }
  }
  
  public void onscaleBegin(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    BrowserBasePresenter localBrowserBasePresenter = getPresenter(paramInt);
    if ((localBrowserBasePresenter != null) && (localBrowserBasePresenter.browserBaseView != null)) {
      localBrowserBasePresenter.browserBaseView.onscaleBegin(paramInt, paramView, paramViewGroup);
    }
    this.mainBrowserPresenter.onscaleBegin(paramInt, paramView, paramViewGroup);
  }
  
  public void setPresenter(MainBrowserPresenter paramMainBrowserPresenter)
  {
    super.setPresenter(paramMainBrowserPresenter);
    this.mainBrowserPresenter = paramMainBrowserPresenter;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.richmediabrowser.view.BrowserAdapter
 * JD-Core Version:    0.7.0.1
 */