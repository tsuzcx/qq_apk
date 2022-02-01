package com.tencent.richmediabrowser.presenter.pic;

import android.text.TextUtils;
import com.tencent.richmediabrowser.api.BrowserParamsBuilder;
import com.tencent.richmediabrowser.api.depend.IBrowserProvider;
import com.tencent.richmediabrowser.core.IBaseViewBuilder;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import com.tencent.richmediabrowser.model.RichMediaBaseData;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.model.pic.PictureData;
import com.tencent.richmediabrowser.presenter.BrowserBasePresenter;
import com.tencent.richmediabrowser.presenter.MainBrowserPresenter;
import com.tencent.richmediabrowser.view.pic.PictureView;

public class PicturePresenter
  extends BrowserBasePresenter
{
  private static final String TAG = "PicturePresenter";
  public PictureView pictureView;
  
  public PictureData getCurrentPictureData()
  {
    RichMediaBrowserInfo localRichMediaBrowserInfo = getSelectedItem();
    if ((localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData != null) && (localRichMediaBrowserInfo.baseData.getType() == 1)) {
      return (PictureData)localRichMediaBrowserInfo.baseData;
    }
    return null;
  }
  
  public void notifyProgress(String paramString, int paramInt)
  {
    RichMediaBrowserInfo localRichMediaBrowserInfo = getItem(paramString);
    if ((localRichMediaBrowserInfo != null) && ((localRichMediaBrowserInfo.baseData instanceof PictureData)))
    {
      PictureData localPictureData = (PictureData)localRichMediaBrowserInfo.baseData;
      localPictureData.status = 1;
      localPictureData.progress = paramInt;
      localRichMediaBrowserInfo.baseData = localPictureData;
      updateItem(localRichMediaBrowserInfo);
    }
    localRichMediaBrowserInfo = getSelectedItem();
    if ((this.pictureView != null) && (localRichMediaBrowserInfo.baseData != null) && (!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty(localRichMediaBrowserInfo.baseData.id)) && (paramString.equals(localRichMediaBrowserInfo.baseData.id))) {
      this.pictureView.updateUI();
    }
  }
  
  public void notifyResult(String paramString, int paramInt)
  {
    Object localObject1 = BrowserLogHelper.getInstance().getGalleryLog();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("notifyResult id = ");
    ((StringBuilder)localObject2).append(paramString);
    ((StringBuilder)localObject2).append(" ,result = ");
    ((StringBuilder)localObject2).append(paramInt);
    ((IBrowserLog)localObject1).d("PicturePresenter", 4, ((StringBuilder)localObject2).toString());
    localObject1 = getItem(paramString);
    if ((localObject1 != null) && ((((RichMediaBrowserInfo)localObject1).baseData instanceof PictureData)))
    {
      localObject2 = (PictureData)((RichMediaBrowserInfo)localObject1).baseData;
      boolean bool = false;
      ((PictureData)localObject2).status = 0;
      ((PictureData)localObject2).progress = 0;
      if (paramInt == 0) {
        bool = true;
      }
      ((PictureData)localObject2).isDownloadSuccess = bool;
      ((PictureData)localObject2).errorCode = paramInt;
      ((RichMediaBrowserInfo)localObject1).baseData = ((RichMediaBaseData)localObject2);
      updateItem((RichMediaBrowserInfo)localObject1);
    }
    localObject1 = getSelectedItem();
    if ((this.pictureView != null) && (((RichMediaBrowserInfo)localObject1).baseData != null) && (!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty(((RichMediaBrowserInfo)localObject1).baseData.id)) && (paramString.equals(((RichMediaBrowserInfo)localObject1).baseData.id))) {
      this.pictureView.updateUI();
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Object localObject = getCurrentPictureData();
    if ((localObject != null) && (((PictureData)localObject).status == 1) && (!TextUtils.isEmpty(((PictureData)localObject).url)) && (this.mainBrowserPresenter.getParamsBuilder().a() != null)) {
      this.mainBrowserPresenter.getParamsBuilder().a().b(((PictureData)localObject).url);
    }
    localObject = this.pictureView;
    if (localObject != null) {
      ((PictureView)localObject).onDestroy();
    }
  }
  
  public void setBrowserView(IBaseViewBuilder paramIBaseViewBuilder)
  {
    super.setBrowserView(paramIBaseViewBuilder);
    if ((paramIBaseViewBuilder instanceof PictureView)) {
      this.pictureView = ((PictureView)paramIBaseViewBuilder);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.richmediabrowser.presenter.pic.PicturePresenter
 * JD-Core Version:    0.7.0.1
 */