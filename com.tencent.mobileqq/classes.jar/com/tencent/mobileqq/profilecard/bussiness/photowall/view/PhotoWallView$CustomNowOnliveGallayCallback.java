package com.tencent.mobileqq.profilecard.bussiness.photowall.view;

import android.os.Handler;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.profilecard.bussiness.photowall.bean.NowShowVideoInfo;
import com.tencent.mobileqq.profilecard.bussiness.photowall.handler.NowOnliveGallayCallback;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import tencent.im.ilive.photo.NowLiveGallary.RspBody.PhotoInfo;

class PhotoWallView$CustomNowOnliveGallayCallback
  extends NowOnliveGallayCallback
{
  private WeakReference<PhotoWallView> mRef;
  
  public PhotoWallView$CustomNowOnliveGallayCallback(PhotoWallView paramPhotoWallView)
  {
    this.mRef = new WeakReference(paramPhotoWallView);
  }
  
  public void onGetNowOnliveGallay(int paramInt, List<NowLiveGallary.RspBody.PhotoInfo> paramList)
  {
    Object localObject1 = this.mRef;
    if (localObject1 != null) {
      localObject1 = (PhotoWallView)((WeakReference)localObject1).get();
    } else {
      localObject1 = null;
    }
    if (localObject1 == null) {
      return;
    }
    if (paramInt != 0)
    {
      if (QLog.isColorLevel())
      {
        paramList = new StringBuilder();
        paramList.append("onGetNowOnliveGallay errorCode:");
        paramList.append(paramInt);
        QLog.d("NowOnliveGallayCallback", 2, paramList.toString());
      }
      ((PhotoWallView)localObject1).mHandler.sendEmptyMessage(4);
      return;
    }
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onGetNowOnliveGallay size:");
      ((StringBuilder)localObject2).append(paramList.size());
      QLog.d("NowOnliveGallayCallback", 2, ((StringBuilder)localObject2).toString());
    }
    ((PhotoWallView)localObject1).mNowVideoList.clear();
    paramInt = 0;
    while (paramInt < paramList.size())
    {
      localObject2 = (NowLiveGallary.RspBody.PhotoInfo)paramList.get(paramInt);
      localObject2 = new NowShowVideoInfo(((NowLiveGallary.RspBody.PhotoInfo)localObject2).cover.get().toStringUtf8(), ((NowLiveGallary.RspBody.PhotoInfo)localObject2).video.get().toStringUtf8(), ((NowLiveGallary.RspBody.PhotoInfo)localObject2).timestamp.get());
      ((PhotoWallView)localObject1).mNowVideoList.add(localObject2);
      paramInt += 1;
    }
    if (((PhotoWallView)localObject1).mNowVideoList.size() > 0) {
      ReportController.b((AppRuntime)this.mApp.get(), "dc00899", "NOW", "", "qq_zlk", "replay_exp", 0, 0, ((PhotoWallView)localObject1).mUin, "", "", "");
    }
    ((PhotoWallView)localObject1).mHandler.sendEmptyMessage(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.photowall.view.PhotoWallView.CustomNowOnliveGallayCallback
 * JD-Core Version:    0.7.0.1
 */