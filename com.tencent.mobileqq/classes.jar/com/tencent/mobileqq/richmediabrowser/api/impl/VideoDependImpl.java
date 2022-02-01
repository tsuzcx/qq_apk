package com.tencent.mobileqq.richmediabrowser.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ForwardRecentTranslucentActivity;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.ScannerResult;
import com.tencent.mobileqq.qrscan.api.IScanUtilApi;
import com.tencent.mobileqq.richmediabrowser.api.IVideoDepend;
import com.tencent.mobileqq.richmediabrowser.utils.GalleryJumpUtils;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.util.Pair;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavReport;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import mqq.app.AppRuntime;

public class VideoDependImpl
  implements IVideoDepend
{
  public VideoPlayParam buildVideoPlayParam(MessageRecord paramMessageRecord, VideoPlayParam paramVideoPlayParam)
  {
    if (((paramMessageRecord instanceof MessageForShortVideo)) && (paramVideoPlayParam != null))
    {
      paramMessageRecord = (MessageForShortVideo)paramMessageRecord;
      paramVideoPlayParam.mVideoFileTimeMs = (paramMessageRecord.videoFileTime * 1000);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramMessageRecord.md5);
      localStringBuilder.append(paramMessageRecord.uniseq);
      paramVideoPlayParam.mFileID = localStringBuilder.toString();
      paramVideoPlayParam.mFileSize = paramMessageRecord.videoFileSize;
      return paramVideoPlayParam;
    }
    return null;
  }
  
  public void dealAddFavorite(Intent paramIntent, Activity paramActivity, AppRuntime paramAppRuntime, int paramInt1, int paramInt2, int paramInt3)
  {
    QfavBuilder.a(paramIntent).a(paramActivity, BaseApplicationImpl.getApplication().getRuntime().getAccount());
    QfavReport.a(paramAppRuntime, paramInt1, paramInt2, paramInt3);
    QfavReport.a(BaseApplicationImpl.getApplication().getRuntime(), 6, 5);
  }
  
  public void dealSendToFriend(Activity paramActivity, Intent paramIntent, String paramString1, String paramString2, int paramInt, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    if (paramIntent != null)
    {
      if (!TextUtils.isEmpty(paramString1))
      {
        paramIntent.putExtra("widgetinfo", paramString1);
        paramIntent.putExtra("key_camera_material_name", paramString2);
      }
      if (paramInt == 72)
      {
        paramIntent.putExtra("key_req", 1);
        paramIntent.putExtra("key_direct_show_uin_type", paramActionSheetItem.uinType);
        paramIntent.putExtra("key_direct_show_uin", paramActionSheetItem.uin);
        ForwardBaseOption.a(paramActivity, paramIntent, ForwardRecentTranslucentActivity.class, 19005, 100500, " biz_src_jc_video");
        return;
      }
      ForwardBaseOption.a(paramActivity, paramIntent, 100500, " biz_src_jc_video");
    }
  }
  
  public String getCameraMaterialName()
  {
    return "key_camera_material_name";
  }
  
  public String getCameraVideoParam()
  {
    return "widgetinfo";
  }
  
  public int getVideoIpType()
  {
    return 1005;
  }
  
  public Pair<Boolean, Boolean> hasCode(Bitmap paramBitmap)
  {
    paramBitmap = ((IScanUtilApi)QRoute.api(IScanUtilApi.class)).decodeQQCodeFromBmp(paramBitmap, 3);
    if (paramBitmap != null) {
      return new Pair(Boolean.valueOf(paramBitmap.h()), Boolean.valueOf(paramBitmap.g()));
    }
    return new Pair(Boolean.valueOf(false), Boolean.valueOf(false));
  }
  
  public void onQRDecodeSucceed(Context paramContext, String paramString1, int paramInt1, boolean paramBoolean, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, String paramString6, String paramString7)
  {
    Intent localIntent;
    if (paramInt2 == 1)
    {
      localIntent = new Intent();
      localIntent.putExtra("detectType", 1);
      localIntent.putExtra("fromPicQRDecode", true);
      GalleryJumpUtils.a(paramContext, paramString1, paramInt1, paramBoolean, paramString2, paramString3, paramString4, paramString5, 1, paramString6, paramString7, localIntent);
      return;
    }
    if (paramInt2 == 2)
    {
      localIntent = new Intent();
      localIntent.putExtra("detectType", 2);
      localIntent.putExtra("fromPicQRDecode", true);
      GalleryJumpUtils.a(paramContext, paramString1, paramInt1, paramBoolean, paramString2, paramString3, paramString4, paramString5, 2, paramString6, paramString7, localIntent);
    }
  }
  
  public void sendToQZone(Activity paramActivity, String paramString1, String paramString2)
  {
    QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.getInstance();
    localUserInfo.qzone_uin = paramString1;
    QZoneHelper.forwardToPublishMood(paramActivity, localUserInfo, paramString2, 10001);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.api.impl.VideoDependImpl
 * JD-Core Version:    0.7.0.1
 */