package com.tencent.mobileqq.richmediabrowser.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListForTroopFragment;
import com.tencent.mobileqq.activity.history.ChatHistoryActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.api.IScanUtilApi;
import com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData;
import com.tencent.mobileqq.transfile.BaseDownloadProcessor;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import java.util.ArrayList;

public class GalleryJumpUtils
{
  public static void a(Activity paramActivity, int paramInt1, String paramString1, String paramString2, long paramLong1, long paramLong2, int paramInt2, boolean paramBoolean)
  {
    if (paramActivity == null) {
      return;
    }
    long l;
    if ((paramInt2 != 1) && (paramInt2 != 3000)) {
      l = paramLong1;
    } else {
      l = paramLong2;
    }
    Object localObject3 = paramActivity.getIntent().getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
    Object localObject1 = BrowserLogHelper.getInstance().getGalleryLog();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("jumpToTargetAIOPosition, className = ");
    ((StringBuilder)localObject2).append((String)localObject3);
    ((StringBuilder)localObject2).append(", time = ");
    ((StringBuilder)localObject2).append(paramLong1);
    ((StringBuilder)localObject2).append(" , shmsgseq = ");
    ((StringBuilder)localObject2).append(paramLong2);
    ((StringBuilder)localObject2).append(", isEmotion = ");
    ((StringBuilder)localObject2).append(paramBoolean);
    ((IBrowserLog)localObject1).d("GalleryJumpUtils", 4, ((StringBuilder)localObject2).toString());
    localObject1 = new Bundle();
    ((Bundle)localObject1).putBoolean("need_jump_to_msg", true);
    ((Bundle)localObject1).putLong("searched_timeorseq", l);
    ((Bundle)localObject1).putLong("searched_time", paramLong1);
    ((Bundle)localObject1).putLong("target_shmsgseq", paramLong2);
    ((Bundle)localObject1).putBoolean("searched_update_session", true);
    ((Bundle)localObject1).putBoolean("jump_from_shmsgseq", true);
    localObject2 = new Intent();
    if (!TextUtils.isEmpty((CharSequence)localObject3)) {
      ((Intent)localObject2).setClassName(paramActivity, (String)localObject3);
    } else {
      ((Intent)localObject2).setClass(paramActivity, SplashActivity.class);
    }
    int i = paramActivity.getIntent().getIntExtra("extra.EXTRA_ENTRANCE", -1);
    boolean bool1;
    if ((i != 2) && (i != 3)) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    boolean bool3 = paramActivity.getIntent().getBooleanExtra("from_chat_history", false);
    boolean bool2;
    if (paramBoolean) {
      bool2 = bool3;
    } else {
      bool2 = bool1;
    }
    localObject3 = BrowserLogHelper.getInstance().getGalleryLog();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("jumpToTargetAIOPosition, isFromHistory = ");
    localStringBuilder.append(bool2);
    localStringBuilder.append(", isEmotion = ");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(", sourceEntrance = ");
    localStringBuilder.append(i);
    localStringBuilder.append(", fromHistory_picAndVideo = ");
    localStringBuilder.append(bool1);
    localStringBuilder.append(", fromHistory_emotion = ");
    localStringBuilder.append(bool3);
    ((IBrowserLog)localObject3).d("GalleryJumpUtils", 4, localStringBuilder.toString());
    if (bool2)
    {
      paramInt1 = paramActivity.getIntent().getIntExtra("FromChatHistoryTab", 0);
      localObject3 = BrowserLogHelper.getInstance().getGalleryLog();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("jumpToTargetAIOPosition, fromType = ");
      localStringBuilder.append(paramInt1);
      ((IBrowserLog)localObject3).d("GalleryJumpUtils", 4, localStringBuilder.toString());
      if ((paramInt1 != 2) && (paramInt1 != 4))
      {
        ((Intent)localObject2).putExtras((Bundle)localObject1);
        paramActivity.setResult(-1, (Intent)localObject2);
        paramActivity.finish();
        return;
      }
      if (paramInt2 == 1)
      {
        ChatHistoryBubbleListForTroopFragment.a(paramActivity, paramString2, paramLong2, -1, 0);
        return;
      }
      ChatHistoryActivity.a(paramActivity, paramString1, paramInt2, "", paramLong1, paramLong2, 0);
      return;
    }
    localObject2 = AIOUtils.a((Intent)localObject2, null);
    ((Intent)localObject2).putExtras((Bundle)localObject1);
    ((Intent)localObject2).putExtra("uin", paramString1);
    ((Intent)localObject2).putExtra("uintype", paramInt1);
    ((Intent)localObject2).putExtra("troop_uin", paramString2);
    ((Intent)localObject2).addFlags(603979776);
    ((Intent)localObject2).putExtra("entrance", 1);
    paramActivity.startActivity((Intent)localObject2);
  }
  
  public static void a(Activity paramActivity, Bundle paramBundle)
  {
    Intent localIntent = AIOUtils.a(new Intent(paramActivity, SplashActivity.class), null);
    paramBundle = new Bundle(paramBundle);
    BrowserLogHelper.getInstance().getGalleryLog().d("GalleryJumpUtils", 4, "AIOGallerysence startChatAndSendMsg IS_WAIT_DEST_RESULT=true");
    paramBundle.putBoolean("PhotoConst.HANDLE_DEST_RESULT", true);
    paramBundle.putBoolean("PhotoConst.IS_FORWARD", true);
    paramBundle.putInt("PhotoConst.SEND_BUSINESS_TYPE", 1031);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", SplashActivity.class.getName());
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", SendPhotoActivity.class.getName());
    localIntent.putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("extra_image_sender_tag", "sessionInfo.aioAlbum");
    paramBundle.putBoolean("PicContants.NEED_COMPRESS", false);
    localIntent.putExtras(paramBundle);
    String str = paramBundle.getString("GALLERY.FORWORD_LOCAL_PATH");
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(str);
    PhotoUtils.sendPhoto(paramActivity, localIntent, localArrayList, paramBundle.getInt("PhotoConst.SEND_SIZE_SPEC", 0), true);
  }
  
  public static void a(Context paramContext, String paramString, int paramInt, AIOBrowserBaseData paramAIOBrowserBaseData)
  {
    Intent localIntent = new Intent(paramContext, ChatHistoryActivity.class);
    localIntent.addFlags(536870912);
    localIntent.putExtra("tab_tab_type", 0);
    localIntent.putExtra("uin", paramString);
    localIntent.putExtra("SissionUin", paramString);
    localIntent.putExtra("uintype", paramInt);
    localIntent.putExtra("extra.IS_FROM_CHAT_AIO_GALLERY", true);
    localIntent.putExtra("extra.EXTRA_CURRENT_IMAGE", DataUtils.a(paramAIOBrowserBaseData));
    localIntent.putExtra("leftViewText", paramContext.getString(2131690874));
    paramContext.startActivity(localIntent);
  }
  
  public static void a(Context paramContext, String paramString1, int paramInt1, boolean paramBoolean, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, String paramString6, String paramString7, Intent paramIntent)
  {
    if (paramIntent == null) {
      paramIntent = new Intent();
    }
    paramIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", paramString1);
    paramIntent.putExtra("detectType", paramInt2);
    paramIntent.putExtra("fromPicQRDecode", true);
    paramInt2 = 0;
    Object localObject = null;
    if ((paramInt1 != 1) && (paramInt1 != 3000)) {
      if (paramBoolean) {
        paramInt1 = 3;
      } else {
        paramInt1 = 1;
      }
    }
    label700:
    label711:
    for (;;)
    {
      try
      {
        if (!TextUtils.equals(paramString2, paramString6)) {
          continue;
        }
        paramString6 = paramString7;
        if (!TextUtils.isEmpty(paramString4))
        {
          int i = BaseDownloadProcessor.getPicDownloadPort();
          if (paramInt2 == 0) {
            break label700;
          }
          paramString7 = "gchat.qpic.cn";
          paramString1 = localObject;
          if (TextUtils.isEmpty(paramString7)) {
            break label711;
          }
          if (i != 80)
          {
            paramString1 = new StringBuilder();
            paramString1.append(paramString7);
            paramString1.append(":");
            paramString1.append(i);
            paramString1.append(paramString4);
            paramString1 = paramString1.toString();
            break label711;
          }
          paramString1 = new StringBuilder();
          paramString1.append(paramString7);
          paramString1.append(paramString4);
          paramString1 = paramString1.toString();
          break label711;
        }
        paramBoolean = TextUtils.isEmpty(paramString5);
        paramString1 = localObject;
        if (paramBoolean) {
          break label711;
        }
        if (paramInt1 != 1)
        {
          if (paramInt1 != 2)
          {
            paramString1 = localObject;
            break label711;
          }
          paramString1 = "gchat.qpic.cn/gchatpic_new";
          if (!TextUtils.isEmpty(paramString2))
          {
            paramString1 = new StringBuilder();
            paramString1.append("gchat.qpic.cn/gchatpic_new");
            paramString1.append("/");
            paramString1.append(paramString2);
            paramString1 = paramString1.toString();
          }
          paramBoolean = paramString5.startsWith("/");
          if (paramBoolean)
          {
            paramString4 = new StringBuilder();
            paramString4.append(paramString1);
            paramString4.append("0-0-");
            paramString4.append(paramString5.replace(".jpg", ""));
            paramString4.append("/0");
            paramString1 = paramString4.toString();
          }
          else
          {
            paramString4 = new StringBuilder();
            paramString4.append(paramString1);
            paramString4.append("/0-0-");
            paramString4.append(paramString5.replace(".jpg", ""));
            paramString4.append("/0");
            paramString1 = paramString4.toString();
          }
        }
        else
        {
          paramString1 = "c2cpicdw.qpic.cn/offpic_new";
          if (!TextUtils.isEmpty(paramString2))
          {
            paramString1 = new StringBuilder();
            paramString1.append("c2cpicdw.qpic.cn/offpic_new");
            paramString1.append("/");
            paramString1.append(paramString2);
            paramString1 = paramString1.toString();
          }
          if (paramString5.startsWith("/"))
          {
            paramString4 = new StringBuilder();
            paramString4.append(paramString1);
            paramString4.append(paramString5);
            paramString4.append("/0");
            paramString1 = paramString4.toString();
          }
          else
          {
            paramString4 = new StringBuilder();
            paramString4.append(paramString1);
            paramString4.append("/");
            paramString4.append(paramString5);
            paramString4.append("/0");
            paramString1 = paramString4.toString();
          }
        }
      }
      catch (Throwable paramString3)
      {
        continue;
      }
      paramIntent.putExtra("report_params", ((IScanUtilApi)QRoute.api(IScanUtilApi.class)).buildQRScanReportParams(paramString3, paramString1, paramString5, paramString2, paramString6, paramInt1));
      continue;
      paramString1 = BrowserLogHelper.getInstance().getGalleryLog();
      paramString2 = new StringBuilder();
      paramString2.append("onQRDecodeSucceed error:");
      paramString2.append(paramString3.getMessage());
      paramString1.d("GalleryJumpUtils", 4, paramString2.toString());
      RouteUtils.a(paramContext, paramIntent, "/qrscan/scanner");
      return;
      continue;
      if (paramBoolean)
      {
        paramString6 = null;
        paramInt1 = 4;
      }
      else
      {
        paramString6 = null;
        paramInt2 = 1;
        paramInt1 = 2;
        continue;
        paramString7 = "c2cpicdw.qpic.cn";
        continue;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.utils.GalleryJumpUtils
 * JD-Core Version:    0.7.0.1
 */