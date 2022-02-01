package com.tencent.mobileqq.richmediabrowser.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.tencent.aelight.camera.qqstory.api.IAELaunchEditPic;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.mobileqq.MsgRevokeListener;
import com.tencent.mobileqq.activity.ForwardRecentTranslucentActivity;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryMsgRevokeMgr;
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.haoliyou.orion.ZhuoXusManager;
import com.tencent.mobileqq.mini.api.IMiniAppFileMaterialService;
import com.tencent.mobileqq.pic.PicShareToWX;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.ScannerResult;
import com.tencent.mobileqq.qrscan.api.IQRScanReportApi;
import com.tencent.mobileqq.qrscan.api.IScanUtilApi;
import com.tencent.mobileqq.richmedia.capture.util.CaptureUtil;
import com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData;
import com.tencent.mobileqq.richmediabrowser.IAIOBrowserProvider;
import com.tencent.mobileqq.richmediabrowser.IProvider;
import com.tencent.mobileqq.richmediabrowser.ParamsManager;
import com.tencent.mobileqq.richmediabrowser.api.IBrowserDepend;
import com.tencent.mobileqq.richmediabrowser.model.AIOPictureData;
import com.tencent.mobileqq.richmediabrowser.utils.AIOGalleryUtils;
import com.tencent.mobileqq.richmediabrowser.utils.DataUtils;
import com.tencent.mobileqq.richmediabrowser.utils.ForwardUtils;
import com.tencent.mobileqq.richmediabrowser.utils.GalleryJumpUtils;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.RichMediaShareActionSheetUtil;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.richmediabrowser.api.depend.IBrowserProvider;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavReport;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneClickReport;
import java.io.File;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class BrowserDependImpl
  implements IBrowserDepend
{
  private static final String TAG = "BrowserDependImpl";
  
  private boolean addOpenWithMiniAppMenuItemIfNeeded(@NonNull ArrayList<ShareActionSheetBuilder.ActionSheetItem> paramArrayList)
  {
    if (((IMiniAppFileMaterialService)QRoute.api(IMiniAppFileMaterialService.class)).isMimeTypeSupported("image/*"))
    {
      RichMediaShareActionSheetUtil.a(166, 64, paramArrayList);
      return true;
    }
    return false;
  }
  
  private boolean isNeedUpdateMsg(MessageForShortVideo paramMessageForShortVideo, int paramInt1, int paramInt2, int paramInt3)
  {
    return ((paramMessageForShortVideo.videoFileStatus == 1002) || (paramMessageForShortVideo.videoFileStatus == 2002)) && (paramMessageForShortVideo.videoFileStatus == paramInt1) && (paramInt2 - paramInt3 < 10);
  }
  
  public void addMsgRevokerListener(MsgRevokeListener paramMsgRevokeListener)
  {
    AIOGalleryMsgRevokeMgr.a().a(paramMsgRevokeListener);
  }
  
  public void buildMessageRevokeUI(Activity paramActivity, RelativeLayout paramRelativeLayout)
  {
    AIOGalleryMsgRevokeMgr.a(paramActivity, paramRelativeLayout);
  }
  
  public String checkQQCode(Uri paramUri, ArrayList<ShareActionSheetBuilder.ActionSheetItem> paramArrayList1, ArrayList<ShareActionSheetBuilder.ActionSheetItem> paramArrayList2, Activity paramActivity, String paramString, ShareActionSheet paramShareActionSheet)
  {
    Object localObject = (IScanUtilApi)QRoute.api(IScanUtilApi.class);
    int k = 0;
    localObject = ((IScanUtilApi)localObject).decodeQQCodeFromFile(paramUri, paramActivity, 3, false);
    if (localObject != null)
    {
      ThreadManager.getUIHandler().post(new BrowserDependImpl.3(this, paramActivity, (ScannerResult)localObject, paramArrayList2, paramString, paramArrayList1, paramShareActionSheet));
      if (((ScannerResult)localObject).a != null) {
        i = ((ScannerResult)localObject).a.size();
      } else {
        i = 0;
      }
      int j;
      if (((ScannerResult)localObject).b != null) {
        j = ((ScannerResult)localObject).b.size();
      } else {
        j = 0;
      }
      paramArrayList1 = BrowserLogHelper.getInstance().getGalleryLog();
      paramArrayList2 = new StringBuilder();
      paramArrayList2.append("qrSize = ");
      paramArrayList2.append(i);
      paramArrayList2.append(", miniSize = ");
      paramArrayList2.append(j);
      paramArrayList1.d("BrowserDependImpl", 4, paramArrayList2.toString());
    }
    else
    {
      ThreadManager.getUIHandler().post(new BrowserDependImpl.4(this, paramArrayList1, paramShareActionSheet));
      BrowserLogHelper.getInstance().getGalleryLog().d("BrowserDependImpl", 4, "checkQQCode scannerResult is null");
    }
    int i = k;
    if (localObject != null) {
      i = ((ScannerResult)localObject).e();
    }
    if (i > 0) {
      return paramUri.getPath();
    }
    ((IQRScanReportApi)QRoute.api(IQRScanReportApi.class)).onAIOScanRecogTypeReport(i);
    return "";
  }
  
  public Parcelable convertAIORichMediaData(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof AIOBrowserBaseData)) {
      return DataUtils.a((AIOBrowserBaseData)paramParcelable);
    }
    return null;
  }
  
  public void dealAddFavorite(Activity paramActivity, Intent paramIntent, String paramString1, String paramString2)
  {
    if (paramIntent == null) {
      QfavBuilder.b(paramString1).a(paramActivity, paramString2);
    } else {
      new QfavBuilder(paramIntent).a(paramActivity, paramString2);
    }
    QfavReport.a(null, 40, 3);
  }
  
  public void dealAddToEmotion(Parcelable paramParcelable, Activity paramActivity)
  {
    if ((paramParcelable instanceof AIOPictureData))
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("pic_md5", ((AIOPictureData)paramParcelable).u);
      paramParcelable = new BrowserDependImpl.1(this, paramActivity);
      QIPCClientHelper.getInstance().callServer("EmoticonIPCModule", "action_group_emo_big_pic_add_fav", localBundle, paramParcelable);
    }
  }
  
  public void dealPicForwardToGroupAlbum(AIOPictureData paramAIOPictureData, Context paramContext, IProvider paramIProvider)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(ParamsManager.a().k());
    localStringBuilder.append("__qzone_pic_permission__");
    localStringBuilder.append(ParamsManager.a().e());
    if (LocalMultiProcConfig.getInt4Uin(localStringBuilder.toString(), -1, Long.valueOf(ParamsManager.a().k()).longValue()) == 0)
    {
      paramAIOPictureData = new QQCustomDialog(paramContext, 2131953338);
      paramAIOPictureData.setContentView(2131624611);
      paramAIOPictureData.setTitle(paramContext.getString(2131917608));
      paramAIOPictureData.setMessage(paramContext.getString(2131917606));
      paramAIOPictureData.setNegativeButton(paramContext.getString(2131917607), new BrowserDependImpl.2(this, paramContext));
      paramAIOPictureData.setCanceledOnTouchOutside(false);
      paramAIOPictureData.setCancelable(false);
      paramAIOPictureData.show();
      QZoneClickReport.startReportImediately(ParamsManager.a().k(), "40", "1");
      return;
    }
    if (paramIProvider != null) {
      paramIProvider.a("Pic_Forward_Grpalbum", 0);
    }
    AIOGalleryUtils.a((Activity)paramContext, ParamsManager.a().k(), ParamsManager.a().e(), ParamsManager.a().f(), paramAIOPictureData.j, paramAIOPictureData.r, paramAIOPictureData.s, -1);
  }
  
  public void dealSendToWeiYun(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof AIOPictureData))
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("pic_md5", ((AIOPictureData)paramParcelable).u);
      QIPCClientHelper.getInstance().callServer("EmoticonIPCModule", "action_group_emo_big_pic_upload_wy", localBundle, null);
    }
  }
  
  public void forwardPicToFriend(File paramFile, boolean paramBoolean, Parcelable paramParcelable, Bundle paramBundle, Activity paramActivity, int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2)
  {
    paramFile = getForwardPicToFriendIntent(paramFile, paramBoolean, paramParcelable, paramBundle, paramActivity);
    if (paramFile != null)
    {
      if (paramInt1 == 72)
      {
        paramFile.putExtra("key_req", 1);
        paramFile.putExtra("key_direct_show_uin_type", paramInt2);
        paramFile.putExtra("key_direct_show_uin", paramString1);
        ForwardBaseOption.a(paramActivity, paramFile, ForwardRecentTranslucentActivity.class, 19005, paramInt3, paramString2);
        return;
      }
      ForwardBaseOption.a(paramActivity, paramFile, 19005, paramInt3, paramString2);
    }
  }
  
  public void forwardToFriend(Activity paramActivity, Intent paramIntent, boolean paramBoolean, int paramInt, String paramString)
  {
    ForwardUtils.a(paramActivity, paramIntent, paramBoolean, paramInt, paramString);
  }
  
  public void fowardToQzoneAlbum(Activity paramActivity, String paramString1, String paramString2, int paramInt, Parcelable paramParcelable, boolean paramBoolean, String paramString3)
  {
    AIOGalleryUtils.a(paramActivity, paramString1, paramString2, paramInt, paramParcelable, paramBoolean, paramString3);
  }
  
  public String getExtraGroupCode()
  {
    return "extra.GROUP_CODE";
  }
  
  public String getExtraGroupUin()
  {
    return "extra.GROUP_UIN";
  }
  
  public String getExtraMutilMsg()
  {
    return "extra.IS_FROM_MULTI_MSG";
  }
  
  public Intent getForwardPicToFriendIntent(File paramFile, boolean paramBoolean, Parcelable paramParcelable, Bundle paramBundle, Activity paramActivity)
  {
    if ((paramParcelable instanceof AIOPictureData))
    {
      paramParcelable = (AIOPictureData)paramParcelable;
      if (paramFile != null) {}
      try
      {
        paramBundle.putString("forward_filepath", paramFile.getAbsolutePath());
        paramBundle.putInt("forward_type", 1);
        paramBundle.putInt("forward_source_uin_type", paramActivity.getIntent().getIntExtra("forward_source_uin_type", -1));
        if (paramBoolean) {
          paramBundle.putInt("PhotoConst.SEND_SIZE_SPEC", 2);
        }
        paramBundle.putParcelable("FORWARD_MSG_FOR_PIC", paramParcelable);
        paramBundle.putBoolean("key_help_forward_pic", true);
        paramBundle.putBoolean("key_allow_multiple_forward_from_limit", false);
        if (!TextUtils.isEmpty(paramParcelable.H))
        {
          paramBundle.putBoolean("forward_send_template_pic", true);
          paramBundle.putString("widgetinfo", paramParcelable.H);
          paramBundle.putString("key_camera_material_name", paramParcelable.I);
        }
        paramFile = new Intent();
        paramFile.putExtras(paramBundle);
        return paramFile;
      }
      catch (NullPointerException paramFile)
      {
        paramParcelable = BrowserLogHelper.getInstance().getGalleryLog();
        paramBundle = new StringBuilder();
        paramBundle.append("showFriendPickerForForward ,NullPointerException: ");
        paramBundle.append(paramFile.getMessage());
        paramParcelable.d("BrowserDependImpl", 4, paramBundle.toString());
      }
      BrowserLogHelper.getInstance().getGalleryLog().d("BrowserDependImpl", 4, "showFriendPickerForForward ,cache path is null");
      return null;
    }
    return null;
  }
  
  public Intent getForwardToFriendIntent(Activity paramActivity, Intent paramIntent, boolean paramBoolean)
  {
    return ForwardUtils.a(paramActivity, paramIntent, paramBoolean);
  }
  
  public Intent getFriendPickerForForwardIntent(File paramFile, boolean paramBoolean, Parcelable paramParcelable, Bundle paramBundle, Activity paramActivity)
  {
    if ((paramParcelable instanceof AIOPictureData))
    {
      paramParcelable = (AIOPictureData)paramParcelable;
      if (paramFile != null) {}
      try
      {
        paramBundle.putString("GALLERY.FORWORD_LOCAL_PATH", paramFile.getAbsolutePath());
        paramBundle.putInt("forward_type", 1);
        paramBundle.putInt("forward_source_uin_type", paramActivity.getIntent().getIntExtra("forward_source_uin_type", -1));
        if (paramBoolean) {
          paramBundle.putInt("PhotoConst.SEND_SIZE_SPEC", 2);
        }
        paramBundle.putParcelable("FORWARD_MSG_FOR_PIC", DataUtils.a(paramParcelable));
        if (paramParcelable.v == 4) {
          paramBundle.putBoolean("HOT_PIC_HAS_EXTRA", true);
        }
        paramFile = new Intent();
        paramFile.putExtras(paramBundle);
        return paramFile;
      }
      catch (NullPointerException paramFile)
      {
        paramParcelable = BrowserLogHelper.getInstance().getGalleryLog();
        paramBundle = new StringBuilder();
        paramBundle.append("showFriendPickerForForward ,NullPointerException: ");
        paramBundle.append(paramFile);
        paramParcelable.d("BrowserDependImpl", 4, paramBundle.toString());
      }
      BrowserLogHelper.getInstance().getGalleryLog().d("BrowserDependImpl", 4, "showFriendPickerForForward ,cache path is null");
      return null;
    }
    return null;
  }
  
  public int getSharePanelType()
  {
    return 100500;
  }
  
  public String getShowDataLine()
  {
    return "k_dataline";
  }
  
  public void gotoChatHistoryActivity(Context paramContext, String paramString, int paramInt, Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof AIOBrowserBaseData)) {
      GalleryJumpUtils.a(paramContext, paramString, paramInt, (AIOBrowserBaseData)paramParcelable);
    }
  }
  
  public boolean isFileSizeEnable(File paramFile)
  {
    return (PicShareToWX.b() != null) && (PicShareToWX.b().a(paramFile));
  }
  
  public boolean isPicShareToWXEnable()
  {
    return (PicShareToWX.b() != null) && (PicShareToWX.b().e());
  }
  
  public boolean isShortVideoType(int paramInt)
  {
    return paramInt == 1;
  }
  
  public boolean isSoftInputPanel(int paramInt)
  {
    return paramInt == 1;
  }
  
  public void jumpToTargetAIOPosition(Activity paramActivity, int paramInt1, String paramString1, String paramString2, long paramLong1, long paramLong2, int paramInt2, boolean paramBoolean)
  {
    GalleryJumpUtils.a(paramActivity, paramInt1, paramString1, paramString2, paramLong1, paramLong2, paramInt2, paramBoolean);
  }
  
  public void onQRDecodeSucceed(Context paramContext, String paramString1, int paramInt1, boolean paramBoolean, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, String paramString6, String paramString7, Intent paramIntent)
  {
    if (paramInt2 == 1)
    {
      GalleryJumpUtils.a(paramContext, paramString1, paramInt1, paramBoolean, paramString2, paramString3, paramString4, paramString5, 1, paramString6, paramString7, paramIntent);
      return;
    }
    if (paramInt2 == 2) {
      GalleryJumpUtils.a(paramContext, paramString1, paramInt1, paramBoolean, paramString2, paramString3, paramString4, paramString5, 2, paramString6, paramString7, paramIntent);
    }
  }
  
  public void openMiniAioForDanmaku(Activity paramActivity, int paramInt, String paramString, boolean paramBoolean, long paramLong1, long paramLong2)
  {
    MiniChatActivity.a(paramActivity, paramInt, paramString, paramBoolean, 26, paramLong1, paramLong2);
  }
  
  public void removeMsgRevokerListener(MsgRevokeListener paramMsgRevokeListener)
  {
    AIOGalleryMsgRevokeMgr.a().b(paramMsgRevokeListener);
  }
  
  public void reportCommercialDrainage(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, int paramInt3, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    VasWebviewUtil.a(paramString2, paramString3, paramString4, paramInt1, paramInt2, paramInt3, paramString5, paramString6, paramString7, paramString8, paramString9, paramString10, paramString11, paramInt4, paramInt5, paramInt6, paramInt7);
  }
  
  public boolean saveImageNeedBlock()
  {
    return ZhuoXusManager.a().b();
  }
  
  public void savePic(Activity paramActivity, File paramFile, String paramString)
  {
    AIOGalleryUtils.a(paramActivity, paramFile, paramString);
  }
  
  public boolean saveVideoToAlbum(Context paramContext, String paramString1, String paramString2)
  {
    return FileUtils.a(paramContext, paramString1, paramString2);
  }
  
  public boolean scanQrCodeNeedBlock()
  {
    return ZhuoXusManager.a().c();
  }
  
  public void sharePicToWXFromPeak(String paramString, Context paramContext)
  {
    PicShareToWX.a(paramString, paramContext, 1);
  }
  
  public void showFriendPickerForForward(File paramFile, boolean paramBoolean, Parcelable paramParcelable, Bundle paramBundle, Activity paramActivity, int paramInt)
  {
    paramFile = getFriendPickerForForwardIntent(paramFile, paramBoolean, paramParcelable, paramBundle, paramActivity);
    if (paramFile != null) {
      ForwardBaseOption.a(paramActivity, paramFile, paramInt);
    }
  }
  
  public void startChatAndSendMsg(Activity paramActivity, Bundle paramBundle)
  {
    GalleryJumpUtils.a(paramActivity, paramBundle);
  }
  
  public void startEditPicActivity(Activity paramActivity, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, String paramString, int paramInt3)
  {
    paramString = ((IAELaunchEditPic)QRoute.api(IAELaunchEditPic.class)).startEditPic(paramActivity, paramString, true, true, true, true, true, 2, paramInt1, 7);
    paramString.putExtra("uintype", paramInt3);
    paramString.putExtra("open_chatfragment", true);
    paramString.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1041);
    paramString.putExtra("key_enable_edit_title_bar", true);
    if (paramBoolean1) {
      paramString.putExtra("key_help_forward_pic", paramBoolean1);
    }
    if (paramBoolean2) {
      paramString.putExtra("key_allow_multiple_forward_from_limit", false);
    }
    if (paramInt2 != 0)
    {
      paramActivity.startActivityForResult(paramString, paramInt2);
      return;
    }
    paramActivity.startActivity(paramString);
  }
  
  public boolean supportCapture()
  {
    return CaptureUtil.a();
  }
  
  public void updateMsgStatus(int paramInt1, long paramLong, MessageRecord paramMessageRecord, int paramInt2, IBrowserProvider paramIBrowserProvider)
  {
    int i;
    if ((paramMessageRecord instanceof MessageForShortVideo))
    {
      paramMessageRecord = (MessageForShortVideo)paramMessageRecord;
      i = paramInt2;
    }
    else
    {
      paramMessageRecord = null;
      i = -1;
    }
    if (paramMessageRecord != null)
    {
      if (paramInt1 == -1) {
        return;
      }
      if ((paramLong > 0L) && (paramMessageRecord.videoFileSize > 0)) {
        paramInt2 = (int)(100L * paramLong / paramMessageRecord.videoFileSize);
      } else {
        paramInt2 = 0;
      }
      if (paramMessageRecord.videoFileProgress < 0) {
        paramMessageRecord.videoFileProgress = 0;
      }
      if (isNeedUpdateMsg(paramMessageRecord, paramInt1, paramInt2, paramMessageRecord.videoFileProgress)) {
        return;
      }
      int j;
      if ((i != 6) && (i != 17) && (i != 9) && (i != 67))
      {
        j = paramInt2;
        if (i != 20) {}
      }
      else
      {
        if ((paramInt1 == 2002) && (paramLong > 0L)) {
          paramMessageRecord.transferedSize = ((int)paramLong);
        }
        j = paramInt2;
        if (paramInt1 == 2003)
        {
          paramMessageRecord.transferedSize = 0;
          j = 100;
        }
      }
      if ((paramMessageRecord.videoFileStatus == 2004) || (paramMessageRecord.videoFileStatus == 1004))
      {
        if (paramInt1 == 1002) {
          return;
        }
        if (paramInt1 == 2002) {
          return;
        }
      }
      paramMessageRecord.videoFileStatus = paramInt1;
      paramMessageRecord.fileType = i;
      if (j > 0) {
        paramMessageRecord.videoFileProgress = j;
      }
      String str = ShortVideoUtils.findVideoPathIfExists(paramMessageRecord);
      if ((paramInt1 == 2003) && (!StringUtil.isEmpty(str))) {
        paramMessageRecord.lastModified = new File(str).lastModified();
      }
      if ((paramIBrowserProvider instanceof IAIOBrowserProvider)) {
        ((IAIOBrowserProvider)paramIBrowserProvider).a(paramMessageRecord);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.api.impl.BrowserDependImpl
 * JD-Core Version:    0.7.0.1
 */