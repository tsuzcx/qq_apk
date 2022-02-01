package com.tencent.mobileqq.sharehelper;

import android.content.Context;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import cooperation.qzone.QZoneShareData;
import cooperation.qzone.QZoneShareManager;
import java.util.ArrayList;

public class ShareActionSheetInject
  implements IShareActionInterface
{
  public void a(Context paramContext, QzoneLinkShareInfo paramQzoneLinkShareInfo)
  {
    QZoneShareData localQZoneShareData = new QZoneShareData();
    localQZoneShareData.mSummary = paramQzoneLinkShareInfo.b();
    localQZoneShareData.mDefaultForwardReason = paramQzoneLinkShareInfo.f();
    localQZoneShareData.mTitle = paramQzoneLinkShareInfo.a();
    localQZoneShareData.mImageUrls = paramQzoneLinkShareInfo.c();
    localQZoneShareData.targetUrl = paramQzoneLinkShareInfo.d();
    localQZoneShareData.from = paramQzoneLinkShareInfo.e();
    QZoneShareManager.shareToQzone(paramContext, paramQzoneLinkShareInfo.g(), localQZoneShareData, null, paramQzoneLinkShareInfo.h());
  }
  
  public void a(Context paramContext, ArrayList<String> paramArrayList, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putStringArrayList("images", paramArrayList);
    QZoneShareManager.publishToQzone((AppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramContext, localBundle, null, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.sharehelper.ShareActionSheetInject
 * JD-Core Version:    0.7.0.1
 */