package com.tencent.mobileqq.teamwork.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface ITeamWorkDocEditBrowserProxy
  extends QRouteApi
{
  public static final String KEY_FROM_AIO = "doc_from_aio";
  public static final String KEY_FROM_AIO_NICKNAME = "doc_from_aio_nickname";
  public static final String KEY_FROM_AIO_PEERTYPE = "doc_from_aio_peertype";
  public static final String KEY_FROM_AIO_UIN = "doc_from_aio_uin";
  public static final String KEY_FROM_FORWARD_DIALOG = "doc_from_forward_dialog";
  public static final String KEY_GROUP_TEAM_WORK_DOC_DOMAIN_ID = "key_group_team_work_doc_domain_id";
  public static final String KEY_GROUP_TEAM_WORK_DOC_GROUP_UIN = "key_group_team_work_doc_group_uin";
  public static final String KEY_GROUP_TEAM_WORK_DOC_PAD_ID = "key_group_team_work_doc_pad_id";
  public static final String KEY_IS_NEW_PAD_FLAG = "key_is_new_pad_flag";
  public static final String KEY_TEAM_WORK_EDIT_TYPE = "key_team_work_edit_type";
  public static final String KEY_TEAM_WORK_PAD_LIST_TYPE = "key_team_work_pad_list_type";
  public static final String KEY_TEAM_WORK_SOURCE_URL = "key_team_work_rul";
  public static final String KEY_TEAM_WORK_TITLE = "key_team_work_title";
  public static final String KEY_TEMP_PREVIEW_FROM_QQ = "temp_preview_from_qq";
  public static final String KEY_TEMP_SHOW_LOADING = "temp_preview_show_loading";
  public static final int REQUEST_CODE_OPEN_TEAM_WORK_EDIT_BROWSER = 14001;
  public static final int REQUEST_CODE_OPEN_TEAM_WORK_MINI_PROGRAM = 14002;
  public static final int TYPE_EDIT_DOC = 1;
  public static final int TYPE_EDIT_SHEET = 2;
  
  public abstract Intent getClassIntent(Context paramContext);
  
  public abstract Intent getOpenTeamWorkIntent(Intent paramIntent, String paramString, Context paramContext);
  
  public abstract boolean isInstanceClass(Activity paramActivity);
  
  public abstract boolean openDocsMiniApp(Context paramContext, String paramString1, String paramString2);
  
  public abstract void openTeamWorkDocEditBrowserActivity(Context paramContext, Bundle paramBundle, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.api.ITeamWorkDocEditBrowserProxy
 * JD-Core Version:    0.7.0.1
 */