package com.tencent.mobileqq.troop.avatar.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory.Options;
import android.graphics.Point;
import android.graphics.Rect;
import com.tencent.mobileqq.data.troop.TroopClipPic;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.troop.avatar.AvatarInfo;
import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.Set;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupHeadPortrait;
import tencent.im.oidb.cmd0x8b8.oidb_0x8b8.RspBody;

@QAPI(process={"all"})
public abstract interface ITroopPhotoUtilsApi
  extends QRouteApi
{
  public static final int DEFAULT_HD_AVATAR_SIZE = 640;
  public static final String KEY_CLIP_INFO = "key_clip_info";
  public static final String KEY_DEL_PICS = "key_del_pics";
  public static final int MAX_SAMPLE_SIZE = 1024;
  public static final int REQUEST_CODE_AVATAR_EDIT = 260;
  public static final int REQUEST_CODE_AVATAR_VIEW = 261;
  public static final int REQUEST_CODE_COVER_EDIT = 258;
  public static final int REQUEST_CODE_COVER_VIEW = 259;
  public static final int REQUEST_CODE_PORTRAIT_SHOTPHOTO = 257;
  public static final int SUB_VER = 101;
  
  public abstract void cacheFileFromLocal(int paramInt, String paramString1, String paramString2);
  
  public abstract int calculateInSampleSize(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2);
  
  public abstract int copySdcardFile(String paramString1, String paramString2);
  
  public abstract boolean deleteFoder(File paramFile);
  
  public abstract String getAllPicFromDb(List<TroopClipPic> paramList, TroopInfo paramTroopInfo);
  
  public abstract int getBusiByType(int paramInt);
  
  public abstract void getClipRect(Rect paramRect, String paramString);
  
  public abstract Point getClipRectSize(Activity paramActivity, int paramInt);
  
  public abstract String getClipStr(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract String getCoverFromDb(List<AvatarInfo> paramList, TroopInfo paramTroopInfo);
  
  public abstract String getErrText(Context paramContext, int paramInt);
  
  public abstract int getInSampleSize(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract int getPicsFrom88d(oidb_0x88d.GroupHeadPortrait paramGroupHeadPortrait, List<TroopClipPic> paramList);
  
  public abstract int getPicsFrom8b8(oidb_0x8b8.RspBody paramRspBody, List<TroopClipPic> paramList);
  
  public abstract int getScaledCoverHeight(int paramInt);
  
  public abstract int getShapeOfBusi(int paramInt);
  
  public abstract int getSubcmdByType(int paramInt);
  
  public abstract URL getURL4TroopPhoto(String paramString);
  
  public abstract String getUploadPhotoTempPath();
  
  public abstract int saveBitmapToFile(String paramString1, String paramString2);
  
  public abstract Set<String> setVerifyingAvatarPicId(oidb_0x88d.GroupHeadPortrait paramGroupHeadPortrait);
  
  public abstract void startPhotoEdit(Activity paramActivity, Intent paramIntent, String paramString, int paramInt);
  
  public abstract void startPhotoEdit(Activity paramActivity, String paramString, int paramInt);
  
  public abstract void startPhotoList(Activity paramActivity, int paramInt);
  
  public abstract void startPhotoListEdit(Activity paramActivity, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.avatar.api.ITroopPhotoUtilsApi
 * JD-Core Version:    0.7.0.1
 */