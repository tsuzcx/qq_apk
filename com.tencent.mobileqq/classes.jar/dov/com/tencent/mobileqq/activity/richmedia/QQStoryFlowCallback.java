package dov.com.tencent.mobileqq.activity.richmedia;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import aopf;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.StoryIntentUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import com.tencent.mobileqq.shortvideo.util.MediaCodecDPC;
import com.tencent.mobileqq.widget.QQToast;
import dov.com.qq.im.QIMCameraCaptureActivity;
import dov.com.qq.im.cropvideo.CropVideoActivity;
import dov.com.tencent.biz.qqstory.takevideo.EditLocalPhotoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditLocalVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoActivity;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.LocalVideoSelectActivity;
import dov.com.tencent.biz.qqstory.takevideo.publish.PublishFileManager;
import java.io.File;

public class QQStoryFlowCallback
  implements FlowComponentInterface
{
  public static float a;
  public static int a;
  public static Bitmap a;
  public static float b;
  public static int b;
  public static int c;
  public static int d;
  public static int e;
  public static int f;
  public static int g;
  
  static
  {
    jdField_a_of_type_Int = 419430400;
    jdField_b_of_type_Int = 240;
    c = 60000;
    d = 12002200;
    e = 20971520;
    f = 240;
    jdField_a_of_type_Float = d / 10000 / 1000.0F;
    jdField_b_of_type_Float = d % 10000 / 1000.0F;
  }
  
  public static String a(Activity paramActivity, int paramInt)
  {
    if (paramActivity.getIntent().hasExtra("extra_upload_temp_directory")) {
      return paramActivity.getIntent().getStringExtra("extra_upload_temp_directory");
    }
    String str = PublishFileManager.a(paramInt);
    paramActivity.getIntent().putExtra("extra_upload_temp_directory", str);
    return str;
  }
  
  public static String a(@NonNull LocalMediaInfo paramLocalMediaInfo)
  {
    return paramLocalMediaInfo.fileSize + "|" + paramLocalMediaInfo.mediaWidth + "|" + paramLocalMediaInfo.mediaHeight + "|" + paramLocalMediaInfo.mDuration + "," + paramLocalMediaInfo.mMimeType + "," + paramLocalMediaInfo.rotation;
  }
  
  public static void a(Activity paramActivity, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, int paramInt2, int paramInt3)
  {
    Intent localIntent = new Intent(paramActivity, PhotoListActivity.class);
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", paramInt1);
    localIntent.putExtra("from_qqstory", true);
    localIntent.putExtra("ALBUM_NAME", "最近照片");
    localIntent.putExtra("ALBUM_ID", "$RecentAlbumId");
    localIntent.putExtra("video_refer", paramString1);
    localIntent.putExtra("PhotoConst.IS_PREVIEW_VIDEO", false);
    localIntent.putExtra("PhotoConst.IS_SINGLE_DERECTBACK_MODE", true);
    localIntent.putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
    localIntent.putExtra("PhotoConst.ENABLE_MULTI_FRAGMENT_VIDEO", paramBoolean);
    localIntent.putExtra("entrance_type", paramInt2);
    localIntent.putExtra("story_default_label", paramActivity.getIntent().getStringExtra("story_default_label"));
    localIntent.putExtra("troop_uin", paramActivity.getIntent().getLongExtra("troop_uin", 0L));
    if (paramString2 != null)
    {
      localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", paramString2);
      localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    }
    if (paramString3 != null)
    {
      localIntent.putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", paramString3);
      localIntent.putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    }
    if (paramString4 != null) {
      localIntent.putExtra("launch_take_video_view_extra_value_key", paramString4);
    }
    if (paramInt3 >= 0)
    {
      paramActivity.startActivityForResult(localIntent, paramInt3);
      return;
    }
    paramActivity.startActivity(localIntent);
  }
  
  public static void a(Activity paramActivity, int paramInt1, String paramString, boolean paramBoolean, int paramInt2, int paramInt3)
  {
    a(paramActivity, paramInt1, paramString, QIMCameraCaptureActivity.class.getName(), LocalVideoSelectActivity.class.getName(), null, paramBoolean, paramInt2, paramInt3);
  }
  
  public static void a(Activity paramActivity, String paramString1, LocalMediaInfo paramLocalMediaInfo, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString2, String paramString3, boolean paramBoolean, int paramInt6)
  {
    for (;;)
    {
      try
      {
        Bundle localBundle = new Bundle();
        int i = 1;
        if (paramInt4 == 10002) {
          break label626;
        }
        int j = 2;
        if (paramInt4 == 10004)
        {
          localBundle.putInt("qq_sub_business_id", 101);
          i = 2;
          localBundle.putString("extra_upload_temp_directory", a(paramActivity, i));
          localBundle.putInt("entrance_type", paramInt3);
          localBundle.putString("story_default_label", paramActivity.getIntent().getStringExtra("story_default_label"));
          long l = paramActivity.getIntent().getLongExtra("troop_uin", 0L);
          if (paramLocalMediaInfo.mMimeType.contains("video"))
          {
            paramString1 = new EditLocalVideoSource(paramString1, paramLocalMediaInfo, paramInt1, paramInt2);
            j = paramInt2 - paramInt1;
            paramInt1 = 1;
            if (j / 10000.0F > 1.0F)
            {
              paramInt2 = j / 10000;
              paramInt1 = paramInt2;
              if (j % 10000 >= 1000) {
                paramInt1 = paramInt2 + 1;
              }
            }
            localBundle.putInt("expect_fragment_count", paramInt1);
            if (paramInt1 > 1) {
              break label576;
            }
            break label576;
            paramInt1 = paramInt2 | 0x20000000 | 0x8000000;
            if (TextUtils.isEmpty(paramString2)) {
              continue;
            }
            paramInt1 |= 0x1000000;
            paramInt2 = paramInt1;
            if (MediaCodecDPC.l()) {
              paramInt2 = paramInt1 & 0xFFFFFFDF & 0xFFFFFFFD & 0xFFFFFEFF & 0xFFFFFFEF & 0xFFFFFFFE;
            }
            paramString1 = new EditVideoParams(i, paramInt2, paramString1, localBundle);
            if (l != 0L) {
              paramString1.a.putLong("troop_uin", l);
            }
            paramString1.a.putBoolean("enable_hw_encode", false);
            paramString1.a.putBoolean("ignorePersonalPublish", paramBoolean);
            paramString1.a.putInt("shareGroupType", paramInt5);
            paramString1.a.putString("shareGroupId", paramString2);
            paramString1.a.putString("shareGroupName", paramString3);
            paramLocalMediaInfo = paramString1.a;
            if (paramInt6 != 7) {
              continue;
            }
            paramBoolean = true;
            paramLocalMediaInfo.putBoolean("extra_is_slide_show_video", paramBoolean);
            SLog.b("Q.qqstory.publish.QQStoryFlowCallback", "EditVideoParams params:" + paramString1.toString());
            paramLocalMediaInfo = new Intent(paramActivity, EditVideoActivity.class);
            StoryIntentUtils.a(paramLocalMediaInfo, paramActivity.getIntent().getExtras());
            paramLocalMediaInfo.putExtra(EditVideoParams.class.getName(), paramString1);
            paramLocalMediaInfo.putExtra("op_department", "grp_qq");
            paramLocalMediaInfo.putExtra("op_type", "video_edit");
            paramLocalMediaInfo.putExtra("stop_record_time", System.currentTimeMillis());
            paramLocalMediaInfo.putExtra("short_video_entrance_type", 6);
            paramLocalMediaInfo.putExtra("edit_video_way", paramInt6);
            SegmentKeeper.b(0L);
            paramActivity.startActivityForResult(paramLocalMediaInfo, 10002);
          }
        }
        else
        {
          i = j;
          if (paramInt4 != 10009) {
            break label626;
          }
          localBundle.putInt("qq_sub_business_id", 102);
          i = j;
          break label626;
        }
        paramString1 = new EditLocalPhotoSource(paramString1, paramLocalMediaInfo);
        break label576;
        boolean bool = TextUtils.isEmpty(paramString2);
        if (!bool)
        {
          break label584;
          paramInt1 |= 0x20000;
          continue;
          paramBoolean = false;
          continue;
          if (paramInt4 == 10002) {
            break label629;
          }
        }
      }
      catch (Exception paramActivity)
      {
        SLog.e("Q.qqstory.publish.QQStoryFlowCallback", "startEditVideoActivity exception:" + paramActivity);
        return;
      }
      label576:
      label584:
      paramInt2 = 268443967;
      if (paramInt5 == 1) {
        paramInt2 = 0x1000213F & 0xFFEFFFFF;
      }
      if (paramInt4 != 10004)
      {
        paramInt1 = paramInt2;
        if (paramInt4 == 10002)
        {
          continue;
          label626:
          continue;
          label629:
          if (paramInt3 != 16) {}
        }
      }
    }
  }
  
  public static boolean a()
  {
    StoryConfigManager localStoryConfigManager = (StoryConfigManager)SuperManager.a(10);
    if (localStoryConfigManager == null)
    {
      SLog.e("Q.qqstory.publish.QQStoryFlowCallback", "StoryConfigManager(CONFIG_MANAGER) is null!");
      return false;
    }
    int i = localStoryConfigManager.b();
    if (i == g) {
      return false;
    }
    jdField_a_of_type_Int = ((Integer)localStoryConfigManager.b("localUploadVideoSizeLimit", Integer.valueOf(jdField_a_of_type_Int))).intValue();
    jdField_b_of_type_Int = ((Integer)localStoryConfigManager.b("localUploadVideoMinResolutionLimit", Integer.valueOf(jdField_b_of_type_Int))).intValue();
    c = ((Integer)localStoryConfigManager.b("localUploadVideoDurationLimit", Integer.valueOf(c))).intValue();
    d = ((Integer)localStoryConfigManager.b("localUploadVideoRatioLimit", Integer.valueOf(d))).intValue();
    e = ((Integer)localStoryConfigManager.b("localUploadImageSizeLimit", Integer.valueOf(e))).intValue();
    f = ((Integer)localStoryConfigManager.b("localUploadImageMinResolutionLimit", Integer.valueOf(f))).intValue();
    jdField_a_of_type_Float = d / 10000 / 1000.0F;
    jdField_b_of_type_Float = d % 10000 / 1000.0F;
    SLog.d("Q.qqstory.publish.QQStoryFlowCallback", "Update Limit Config %d|%d|%d|%d|%d|%d", new Object[] { Integer.valueOf(jdField_a_of_type_Int), Integer.valueOf(jdField_b_of_type_Int), Integer.valueOf(c), Integer.valueOf(d), Integer.valueOf(e), Integer.valueOf(f) });
    SLog.d("Q.qqstory.publish.QQStoryFlowCallback", "Update Limit Config from %d to %d", new Object[] { Integer.valueOf(g), Integer.valueOf(i) });
    g = localStoryConfigManager.b();
    return true;
  }
  
  public static boolean a(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    long l = paramIntent.getLongExtra("file_send_duration", 0L);
    LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)paramIntent.getParcelableExtra("media_info");
    int j = paramIntent.getIntExtra("entrance_type", 99);
    int k = paramIntent.getIntExtra("edit_video_type", 10002);
    if (localLocalMediaInfo == null) {
      throw new IllegalArgumentException("选取视频信息 MEDIA_INFO, 不存在!");
    }
    String str1 = localLocalMediaInfo.path;
    int m;
    String str2;
    String str3;
    boolean bool;
    if (localLocalMediaInfo.mMimeType.contains("video"))
    {
      if ((l >= 3500L) || (k == 10009)) {
        break label341;
      }
      m = paramIntent.getIntExtra("shareGroupType", 0);
      str2 = paramIntent.getStringExtra("shareGroupId");
      str3 = paramIntent.getStringExtra("shareGroupName");
      bool = paramIntent.getBooleanExtra("ignorePersonalPublish", false);
      if (localLocalMediaInfo.mDuration > 3000L) {
        break label334;
      }
    }
    label334:
    for (int i = 0;; i = 3000)
    {
      a(paramActivity, str1, localLocalMediaInfo, 0, i, j, k, m, str2, str3, bool, paramInt);
      return true;
      if (k == 10009) {}
      for (;;)
      {
        return true;
        if (k != 10002)
        {
          if (k == 10004) {}
          for (bool = true;; bool = false)
          {
            paramIntent = EditPicActivity.a(paramActivity, str1, true, true, true, true, true, false, true, true, bool, bool, bool, 2, j, 5);
            paramIntent.putExtra("media_info", localLocalMediaInfo);
            paramIntent.putExtra("edit_video_way", paramInt);
            if (k == 10004) {
              paramIntent.putExtra("sub_business_id", 101);
            }
            paramActivity.startActivityForResult(paramIntent, 10002);
            break;
          }
        }
        paramIntent = EditPicActivity.a(paramActivity, str1, true, true, true, true, true, false, true, true, true, true, TextUtils.isEmpty(paramIntent.getStringExtra("shareGroupId")), 1, j, 0);
        paramIntent.putExtra("media_info", localLocalMediaInfo);
        paramActivity.startActivityForResult(paramIntent, 10002);
      }
    }
    label341:
    if ((l < 3500L) && (k == 10009))
    {
      CropVideoActivity.a(paramActivity, 0L, l, str1);
      paramActivity.finish();
      return true;
    }
    return false;
  }
  
  public static boolean a(@NonNull Activity paramActivity, @NonNull LocalMediaInfo paramLocalMediaInfo)
  {
    int k = 9999;
    a();
    float f2 = paramLocalMediaInfo.mediaHeight * 1.0F / paramLocalMediaInfo.mediaWidth;
    QQToast localQQToast;
    int j;
    int i;
    if (paramLocalMediaInfo.mMimeType.contains("video")) {
      if (paramLocalMediaInfo.fileSize > jdField_a_of_type_Int)
      {
        localQQToast = QQToast.a(paramActivity, 1, "你选择的视频过大", 0);
        SLog.c("Q.qqstory.publish.QQStoryFlowCallback", "checkQQStoryMediaValid media not valid! " + paramLocalMediaInfo.toString());
        k = 1;
        j = 1;
        i = 1;
      }
    }
    for (;;)
    {
      StoryReportor.b("upload_local_video", "choose_media_info", 0, j, new String[] { a(paramLocalMediaInfo) });
      String str;
      if (i != 0)
      {
        str = String.valueOf(1);
        label130:
        StoryReportor.a("video_shoot", "chose_video", 0, 0, new String[] { str, String.valueOf(k) });
        if ((i != 0) && (paramLocalMediaInfo.mDuration >= 10500L)) {
          StoryReportor.a("video_shoot", "local_over", 0, 0, new String[0]);
        }
        if (paramLocalMediaInfo.addedDate == 0L)
        {
          paramLocalMediaInfo.addedDate = (new File(paramLocalMediaInfo.path).lastModified() / 1000L);
          if (paramLocalMediaInfo.addedDate == 0L) {
            break label717;
          }
        }
      }
      label717:
      for (i = 0;; i = 1)
      {
        StoryReportor.b("upload_local_video", "media_info_missing", 0, i, new String[] { a(paramLocalMediaInfo) });
        if (localQQToast != null) {
          paramActivity.runOnUiThread(new aopf(localQQToast));
        }
        if (j != 0) {
          break label723;
        }
        return true;
        if (Math.min(paramLocalMediaInfo.mediaHeight, paramLocalMediaInfo.mediaWidth) < jdField_b_of_type_Int)
        {
          localQQToast = QQToast.a(paramActivity, 1, "你选择的视频分辨率过低", 0);
          SLog.c("Q.qqstory.publish.QQStoryFlowCallback", "checkQQStoryMediaValid media not valid! " + paramLocalMediaInfo.toString());
          k = 3;
          j = 2;
          i = 1;
          break;
        }
        float f1 = f2;
        if (f2 < 1.0F) {
          f1 = 1.0F / f2;
        }
        if ((f1 < 1.2F) || (f1 > 2.2F))
        {
          localQQToast = QQToast.a(paramActivity, 1, "你选择的视频比例不符合要求", 0);
          SLog.c("Q.qqstory.publish.QQStoryFlowCallback", "checkQQStoryMediaValid media not valid! " + paramLocalMediaInfo.toString());
          k = 4;
          j = 3;
          i = 1;
          break;
        }
        if (paramLocalMediaInfo.mDuration > c)
        {
          localQQToast = QQToast.a(paramActivity, 1, "请上传不超过1分钟的视频", 0);
          SLog.c("Q.qqstory.publish.QQStoryFlowCallback", "checkQQStoryMediaValid media not valid! " + paramLocalMediaInfo.toString());
          j = 4;
          k = 5;
          i = 1;
          break;
        }
        localQQToast = null;
        j = 0;
        i = 1;
        break;
        if (paramLocalMediaInfo.fileSize > e)
        {
          localQQToast = QQToast.a(paramActivity, 1, "你选择的图片过大", 0);
          SLog.c("Q.qqstory.publish.QQStoryFlowCallback", "checkQQStoryMediaValid media not valid! " + paramLocalMediaInfo.toString());
          k = 1;
          j = 1;
          i = 0;
          break;
        }
        if (Math.min(paramLocalMediaInfo.mediaHeight, paramLocalMediaInfo.mediaWidth) < f)
        {
          localQQToast = QQToast.a(paramActivity, 1, "你选择的图片分辨率过低", 0);
          SLog.c("Q.qqstory.publish.QQStoryFlowCallback", "checkQQStoryMediaValid media not valid! " + paramLocalMediaInfo.toString());
          k = 3;
          j = 2;
          i = 0;
          break;
        }
        if ((f2 >= 0.45D) && (f2 <= 2.2D)) {
          break label725;
        }
        localQQToast = QQToast.a(paramActivity, 1, "你选择的图片比例不符合要求", 0);
        SLog.c("Q.qqstory.publish.QQStoryFlowCallback", "checkQQStoryMediaValid media not valid! " + paramLocalMediaInfo.toString());
        k = 4;
        j = 3;
        i = 0;
        break;
        str = String.valueOf(0);
        break label130;
      }
      label723:
      return false;
      label725:
      localQQToast = null;
      j = 0;
      i = 0;
    }
  }
  
  public String a()
  {
    return "qqstory";
  }
  
  public void a(Activity paramActivity)
  {
    SLog.b("Q.qqstory.publish.QQStoryFlowCallback", "localVideoClick()");
    if (paramActivity == null)
    {
      SLog.e("Q.qqstory.publish.QQStoryFlowCallback", "localVideoClick() context == null");
      return;
    }
    int i = 99;
    try
    {
      if ((paramActivity instanceof QIMCameraCaptureActivity))
      {
        QIMCameraCaptureActivity localQIMCameraCaptureActivity = (QIMCameraCaptureActivity)paramActivity;
        localQIMCameraCaptureActivity.a("612", "2", "0", true);
        i = localQIMCameraCaptureActivity.a();
      }
      StoryReportor.a("video_shoot", "clk_local", 0, 0, new String[0]);
      a(paramActivity, 0, a(), false, i, 10006);
      return;
    }
    catch (Exception paramActivity)
    {
      SLog.b("Q.qqstory.publish.QQStoryFlowCallback", "QQStoryFlowCallback ", paramActivity);
    }
  }
  
  public void a(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent)
  {
    paramActivity = paramActivity.getIntent();
    if (paramInt2 != -1) {}
    for (boolean bool = true;; bool = false)
    {
      paramActivity.putExtra("edit_video_extra_flag_need_remove_temp_dir", bool);
      if (jdField_a_of_type_AndroidGraphicsBitmap != null)
      {
        jdField_a_of_type_AndroidGraphicsBitmap = null;
        SLog.c("Q.qqstory.publish.QQStoryFlowCallback", "mVideoThumbnailCache clear()");
      }
      return;
    }
  }
  
  public void a(Activity paramActivity, Intent paramIntent) {}
  
  public void a(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.QQStoryFlowCallback
 * JD-Core Version:    0.7.0.1
 */