package com.tencent.mobileqq.winkpublish.viewmodel;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants._AEEditorConstants;
import com.tencent.biz.qcircleshadow.lib.QCircleHostLauncher;
import com.tencent.biz.qcircleshadow.lib.QCircleHostQzoneHelper;
import com.tencent.mobileqq.qcircle.api.constant.QCircleConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkpublish.account.LoginData;
import com.tencent.mobileqq.winkpublish.api.IPublishLauncher;
import com.tencent.mobileqq.winkpublish.api.IUploadLocalConfig;
import com.tencent.mobileqq.winkpublish.common.AUploadCommonSetting;
import com.tencent.mobileqq.winkpublish.common.UploadConstants;
import com.tencent.mobileqq.winkpublish.model.DynamicArrayList;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCirclePublishQualityReporter;
import cooperation.qqcircle.report.QCircleReportHelper;
import feedcloud.FeedCloudCommon.Entry;
import java.util.Arrays;

public class PublishJumpModel
{
  private static final String c;
  public String a = QCircleHostConstants._AEEditorConstants.AE_PHOTO_PICKER_TAB_ALBUM();
  String b;
  private boolean d;
  private int e;
  private boolean f = false;
  private boolean g = false;
  private long h;
  private long i;
  private String j;
  private String k;
  private String l = "";
  private DynamicArrayList<String> m = new DynamicArrayList();
  private boolean n;
  private boolean o;
  private Intent p;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(UploadConstants.a);
    localStringBuilder.append("QcirclePublishJumpUtil");
    c = localStringBuilder.toString();
  }
  
  private void a(Context paramContext)
  {
    if ((this.f) && (this.g))
    {
      AUploadCommonSetting.a().uploadQualityReport(QCirclePublishQualityReporter.E_PICKER_ENTER, Arrays.asList(new FeedCloudCommon.Entry[] { QCircleReportHelper.newEntry("traceid", this.l), QCircleReportHelper.newEntry("ext2", "longvideomode"), QCircleReportHelper.newEntry("ret_code", "0") }));
      b(paramContext);
      return;
    }
    c(paramContext);
  }
  
  private void a(Intent paramIntent)
  {
    this.h = LoginData.a().b();
    boolean bool;
    if ((paramIntent != null) && (paramIntent.getBooleanExtra("key_isfrom_photobubble", false))) {
      bool = true;
    } else {
      bool = false;
    }
    this.d = bool;
    this.e = paramIntent.getIntExtra("key_qcircle_entrance_type", 0);
    this.f = paramIntent.getBooleanExtra("bundle_key_allow_long_video", false);
    this.g = paramIntent.getBooleanExtra("bundle_key_select_qq_photo", false);
    this.i = QCircleHostQzoneHelper.getInt4Uin("sp_key_max_limit_video_length", PublishViewModel.w, LoginData.a().b());
    this.j = paramIntent.getStringExtra("key_scheme");
    this.k = paramIntent.getStringExtra("key_polymerization_scheme");
    this.l = paramIntent.getStringExtra(QCircleConstants.w);
    this.o = paramIntent.getBooleanExtra("key_is_capsule_button", false);
  }
  
  private void b(Context paramContext)
  {
    Intent localIntent1 = new Intent();
    if (this.i == 0L) {
      this.i = PublishViewModel.w;
    }
    localIntent1.putExtra("PhotoConst.PHOTOLIST_KEY_VIDEO_DURATION", this.i * 1000L);
    localIntent1.putExtra("PhotoConst.PHOTOLIST_KEY_VIDEO_SIZE", 1610612736L);
    Intent localIntent2 = this.p;
    if (localIntent2 != null) {
      localIntent1.putExtra("key_is_take_photo", localIntent2.getBooleanExtra("key_is_take_photo", false));
    }
    QCircleHostLauncher.launchQQPhotoSelect(paramContext, localIntent1);
  }
  
  private void c(Context paramContext)
  {
    Object localObject1 = new Bundle();
    Object localObject2 = this.p;
    if ((localObject2 != null) && (((Intent)localObject2).getExtras() != null))
    {
      ((Bundle)localObject1).putAll(this.p.getExtras());
      ((Bundle)localObject1).remove("key_bundle_common_init_bean");
      if (this.n)
      {
        ((Bundle)localObject1).remove("PhotoConst.PHOTO_PATHS");
        ((Bundle)localObject1).remove("ALBUM_ID");
      }
      ((Bundle)localObject1).remove("PhotoConst.PHOTO_PATHS");
      ((Bundle)localObject1).putString("key_wink_video_mission_id", this.b);
    }
    ((Bundle)localObject1).putInt("key_qcircle_entrance_type", this.e);
    QLog.d(c, 1, new Object[] { "takePhoto... mQcircleScheme:", this.j });
    if (!TextUtils.isEmpty(this.j))
    {
      ((Bundle)localObject1).putString("key_scheme", this.j);
      ((Bundle)localObject1).putString("qq_camera_from_qcircle_scheme", this.j);
    }
    if (!TextUtils.isEmpty(this.k)) {
      ((Bundle)localObject1).putString("key_polymerization_scheme", this.k);
    }
    ((Bundle)localObject1).putLong("PhotoConst.timestamp", System.currentTimeMillis());
    ((Bundle)localObject1).putLong("PhotoConst.timestamp_last_activity", System.currentTimeMillis());
    int i1 = this.m.size();
    ((Bundle)localObject1).putInt("BUNDLE_KEY_CIRCLE_HAS_PICKED_NUM", i1);
    boolean bool;
    if ((i1 != 0) && (!this.n)) {
      bool = false;
    } else {
      bool = true;
    }
    ((Bundle)localObject1).putBoolean("BUNDLE_KEY_CIRCLE_CAN_PICK_VIDEO", bool);
    ((Bundle)localObject1).putBoolean("key_qcircle_publish_back_edit", this.n);
    if (this.n)
    {
      ((Bundle)localObject1).putString(QCircleHostConstants._AEEditorConstants.KEY_AE_PHOTO_PICKER_TAB(), this.a);
      if (this.p.getIntExtra("PUBLISH_ENTRANCE", -1) == 3) {
        ((Bundle)localObject1).putInt("EDITOR_ENTRANCE", 3);
      } else {
        ((Bundle)localObject1).putInt("EDITOR_ENTRANCE", 2);
      }
    }
    ((Bundle)localObject1).putStringArrayList("key_qcircle_publish_out_imagepath", this.m);
    if (QCircleHostQzoneHelper.getInt4Uin("_flash_show_publish_", 0, this.h) == 1) {
      bool = true;
    } else {
      bool = false;
    }
    ((Bundle)localObject1).putBoolean("key_qcircle_pulish_has_draft", bool);
    if (i1 > 0)
    {
      ((Bundle)localObject1).putBoolean("BUNDLE_KEY_CIRCLE_CAN_MIX_PICK_PHOTO_AND_VIDEO", false);
      ((Bundle)localObject1).putBoolean("BUNDLE_KEY_CIRCLE_CAN_SWITCH_SECTION_MODE", false);
    }
    else
    {
      ((Bundle)localObject1).putBoolean("BUNDLE_KEY_CIRCLE_CAN_MIX_PICK_PHOTO_AND_VIDEO", false);
      ((Bundle)localObject1).putBoolean("BUNDLE_KEY_CIRCLE_CAN_SWITCH_SECTION_MODE", true);
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("[Performance2]");
    ((StringBuilder)localObject2).append(c);
    localObject2 = ((StringBuilder)localObject2).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[takePhoto...] + END, time cost:");
    localStringBuilder.append(System.currentTimeMillis());
    QLog.d((String)localObject2, 1, localStringBuilder.toString());
    ((Bundle)localObject1).putString("qcircle_client_traceid", this.l);
    ((Bundle)localObject1).putBoolean("key_is_capsule_button", this.o);
    ((Bundle)localObject1).putBoolean("BUNDLE_KEY_FS_CAN_ONLY_EDIT_VIDEO", true);
    long l1 = System.currentTimeMillis();
    i1 = this.e;
    if (i1 == 1)
    {
      localObject2 = new Intent();
      ((Intent)localObject2).putExtras((Bundle)localObject1);
      ((IPublishLauncher)QRoute.api(IPublishLauncher.class)).jumpForAECircle(paramContext, (Intent)localObject2);
    }
    else if (i1 == 2)
    {
      ((IPublishLauncher)QRoute.api(IPublishLauncher.class)).launchAECameraFromCircle(paramContext, (Bundle)localObject1);
    }
    else if ((i1 == 3) || (i1 == 0))
    {
      ((IPublishLauncher)QRoute.api(IPublishLauncher.class)).launchAEMutiCameraFromFS(paramContext, (Bundle)localObject1);
    }
    paramContext = c;
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("takePhoto... cost:");
    ((StringBuilder)localObject1).append(System.currentTimeMillis() - l1);
    QLog.d(paramContext, 1, ((StringBuilder)localObject1).toString());
  }
  
  public void a(Context paramContext, Intent paramIntent, DynamicArrayList<String> paramDynamicArrayList, boolean paramBoolean, String paramString1, String paramString2)
  {
    a(paramIntent);
    if (paramDynamicArrayList != null) {
      this.m = paramDynamicArrayList;
    }
    this.n = paramBoolean;
    this.a = paramString1;
    this.p = paramIntent;
    this.b = paramString2;
    a(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.viewmodel.PublishJumpModel
 * JD-Core Version:    0.7.0.1
 */