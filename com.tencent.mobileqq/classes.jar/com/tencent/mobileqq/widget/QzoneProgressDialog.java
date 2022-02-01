package com.tencent.mobileqq.widget;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import cooperation.qzone.widget.ExtendButton;

public class QzoneProgressDialog
  extends ReportDialog
{
  private TextView a;
  
  public QzoneProgressDialog(Context paramContext, Intent paramIntent)
  {
    super(paramContext, 2131756192);
    String str2 = paramIntent.getStringExtra("qzone_plugin_activity_name");
    Object localObject3 = LayoutInflater.from(paramContext).inflate(2131562474, null);
    Object localObject1 = getWindow();
    ((Window)localObject1).setWindowAnimations(2131756187);
    ((Window)localObject1).setContentView((View)localObject3);
    Object localObject2 = ((Window)localObject1).getAttributes();
    ((WindowManager.LayoutParams)localObject2).width = -1;
    ((WindowManager.LayoutParams)localObject2).height = -1;
    ((WindowManager.LayoutParams)localObject2).gravity = 48;
    ((WindowManager.LayoutParams)localObject2).y = ((WindowManager.LayoutParams)localObject2).y;
    ((Window)localObject1).setAttributes((WindowManager.LayoutParams)localObject2);
    setCanceledOnTouchOutside(false);
    this.a = ((TextView)((View)localObject3).findViewById(2131371534));
    localObject1 = paramIntent.getStringExtra("leftViewText");
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = paramContext.getString(2131690706);
    }
    Object localObject4;
    if ("com.qzone.album.business.albumlist.activity.QZonePersonalAlbumActivity".equals(str2))
    {
      localObject3 = ((ViewStub)((View)localObject3).findViewById(2131378210)).inflate();
      localObject4 = paramIntent.getStringExtra("key_left_tab_title");
      localObject1 = localObject4;
      if (TextUtils.isEmpty((CharSequence)localObject4)) {
        localObject1 = paramContext.getString(2131717063);
      }
      localObject4 = paramIntent.getStringExtra("key_rihgt_tab_title");
      paramIntent = (Intent)localObject4;
      if (TextUtils.isEmpty((CharSequence)localObject4)) {
        paramIntent = paramContext.getString(2131717144);
      }
      paramContext = (ExtendButton)((View)localObject3).findViewById(2131363870);
      localObject4 = (ExtendButton)((View)localObject3).findViewById(2131363871);
      paramContext.setText((CharSequence)localObject1);
      ((ExtendButton)localObject4).setText(paramIntent);
      ((ExtendButton)localObject4).setSelected(false);
      paramContext.setSelected(true);
      paramContext = (Context)localObject3;
    }
    else
    {
      localObject4 = ((ViewStub)((View)localObject3).findViewById(2131365000)).inflate();
      TextView localTextView = (TextView)((ViewStub)((View)localObject4).findViewById(2131369249)).inflate();
      boolean bool = "com.qzone.homepage.ui.activity.QZoneUserHomeActivity".equals(str2);
      String str1 = "";
      long l;
      if (bool)
      {
        l = paramIntent.getLongExtra("qqid", 0L);
        paramContext = paramIntent.getStringExtra("qzone_uin");
        localObject3 = localObject2;
        localObject1 = str1;
        if (!String.valueOf(Long.valueOf(l)).equals(paramContext)) {}
      }
      else
      {
        for (paramContext = HardCodeUtil.a(2131712152);; paramContext = paramContext.getString(2131717581))
        {
          localObject3 = localObject2;
          localObject1 = paramContext;
          break label866;
          if ("com.qzone.feed.ui.activity.QZoneFriendFeedActivity".equals(str2))
          {
            localObject1 = paramContext.getString(2131717290);
            localObject3 = paramContext.getString(2131717214);
            break label866;
          }
          if ("com.qzone.cover.ui.activity.QzoneCoverPhotoWallActivity".equals(str2))
          {
            localObject1 = paramContext.getString(2131717188);
            localObject3 = localObject2;
            break label866;
          }
          if ("com.qzone.cover.ui.activity.QZoneCoverStoreActivity".equals(str2))
          {
            localObject1 = paramContext.getString(2131717189);
            localObject3 = localObject2;
            break label866;
          }
          if ("com.qzone.detail.ui.activity.QzoneDetailActivity".equals(str2))
          {
            localObject3 = localObject2;
            localObject1 = str1;
            if (!paramIntent.getBooleanExtra("qzone.sourceFrom", false)) {
              break label866;
            }
            localObject3 = paramContext.getString(2131699274);
            localObject1 = str1;
            break label866;
          }
          if (!"com.qzone.publish.ui.activity.QZoneUploadPhotoRealActivity".equals(str2)) {
            break label634;
          }
          localObject1 = paramContext.getString(2131717666);
          int i = paramIntent.getIntExtra("QZoneUploadPhotoActivity.key_state_type_src", -1);
          localObject3 = paramIntent.getAction();
          paramIntent = (Intent)localObject1;
          if (TextUtils.isEmpty((CharSequence)localObject3)) {
            break;
          }
          if (((String)localObject3).equals("com.tencent.intent.QZONE_RESHIP_FROM_QUN_AIO_TO_QUN")) {
            i = 5;
          } else if (((String)localObject3).equals("com.tencent.intent.QZONE_QUOTE_FROM_AIO")) {
            i = 11;
          }
          if (i != 11) {
            switch (i)
            {
            default: 
              paramIntent = (Intent)localObject1;
              break label624;
            }
          }
        }
        for (;;)
        {
          label624:
          localObject3 = localObject2;
          localObject1 = paramIntent;
          break label866;
          label634:
          if ("com.qzone.business.lbsv2.ui.QZoneMoodSelectLocation".equals(str2))
          {
            localObject1 = paramContext.getString(2131717606);
            localObject3 = localObject2;
            break label866;
          }
          if ("com.qzone.setting.QZoneSettingManager".equals(str2))
          {
            localObject1 = paramContext.getString(2131717615);
            localObject3 = localObject2;
            break label866;
          }
          if (!"com.qzone.album.business.photolist.activity.QZonePersonalPhotoListActivity".equals(str2)) {
            break label786;
          }
          l = paramIntent.getLongExtra("key_album_face_uin", 0L);
          paramContext = paramIntent.getStringExtra("key_alubm_name");
          paramIntent = paramIntent.getStringExtra("key_album_face_nickname");
          if ((Long.valueOf(l).longValue() != 0L) && (!TextUtils.isEmpty(paramIntent)))
          {
            paramContext = new StringBuilder();
            paramContext.append(paramIntent);
            paramContext.append(HardCodeUtil.a(2131712151));
            paramContext = paramContext.toString();
            break;
          }
          localObject3 = localObject2;
          localObject1 = str1;
          if (paramContext == null) {
            break label866;
          }
          paramIntent = paramContext;
        }
        label786:
        if ("com.qzone.publish.ui.activity.QZonePublishMoodRealActivity".equals(str2))
        {
          localObject1 = paramIntent.getStringExtra("key_title");
          localObject3 = localObject2;
        }
        else if ("com.qzone.publish.ui.activity.QZonePublishQueueAcitvity".equals(str2))
        {
          localObject1 = paramContext.getString(2131717533);
          localObject3 = localObject2;
        }
        else
        {
          localObject3 = localObject2;
          localObject1 = str1;
          if ("com.qzone.permissionsetting.ui.activities.QZoneSinglePermissionSettingActivity".equals(str2))
          {
            localObject1 = paramContext.getString(2131717422);
            localObject3 = localObject2;
          }
        }
      }
      label866:
      localTextView.setText((CharSequence)localObject1);
      paramContext = (Context)localObject4;
      localObject2 = localObject3;
    }
    ((TextView)paramContext.findViewById(2131369202)).setText((CharSequence)localObject2);
    ((ProgressBar)((ViewStub)paramContext.findViewById(2131369263)).inflate()).setVisibility(0);
  }
  
  public void a(String paramString)
  {
    this.a.setText(paramString);
  }
  
  public void dismiss()
  {
    try
    {
      super.dismiss();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void setOnDismissListener(@Nullable DialogInterface.OnDismissListener paramOnDismissListener)
  {
    if (paramOnDismissListener == null) {
      super.setOnDismissListener(paramOnDismissListener);
    }
    super.setOnDismissListener(new QzoneProgressDialog.CustomDismissListener(paramOnDismissListener));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.QzoneProgressDialog
 * JD-Core Version:    0.7.0.1
 */