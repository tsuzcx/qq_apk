package com.tencent.mobileqq.guild.util;

import android.content.Intent;
import android.graphics.Point;
import android.support.v7.widget.GridLayoutManager;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault;
import com.tencent.mobileqq.activity.photo.album.PhotoListData;
import com.tencent.mobileqq.activity.photo.album.QQAlbumUtils;
import com.tencent.mobileqq.activity.photo.album.photolist.AbstractPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.photolist.PhotoListSceneBase;
import com.tencent.mobileqq.qqalbum.IPhotoTempUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.avatar.api.ITroopPhotoUtilsApi;

public class QQGuildPhotoListCustomizationCrop
  extends PhotoListCustomizationDefault
{
  public static final String a = "com.tencent.mobileqq.guild.util.QQGuildPhotoListCustomizationCrop";
  
  public QQGuildPhotoListCustomizationCrop(AbstractPhotoListActivity paramAbstractPhotoListActivity)
  {
    super(paramAbstractPhotoListActivity);
  }
  
  public void a(LocalMediaInfo paramLocalMediaInfo, int paramInt)
  {
    String str = paramLocalMediaInfo.path;
    Point localPoint = GuildCoverUtils.b(this.c, 102);
    Intent localIntent = this.c.getIntent();
    localIntent = ((IPhotoTempUtils)QRoute.api(IPhotoTempUtils.class)).toCropActivity(this.c, localIntent);
    localIntent.putExtra("ALBUM_NAME", this.e.albumName);
    localIntent.putExtra("ALBUM_ID", this.e.albumId);
    localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", true);
    localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.e.selectedPhotoList);
    localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", str);
    localIntent.putExtra("media_info", paramLocalMediaInfo);
    if (localIntent.getBooleanExtra("PhotoConst.MULTI_PREVIEW_IN_SINGLE_MODE", false))
    {
      localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.e.mediaPathsList);
      localIntent.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", paramLocalMediaInfo.position);
    }
    paramInt = localIntent.getIntExtra("Business_Origin", 0);
    if (102 == paramInt)
    {
      localIntent.putExtra("PhotoConst.EDIT_MASK_SHAPE_TYPE", ((ITroopPhotoUtilsApi)QRoute.api(ITroopPhotoUtilsApi.class)).getShapeOfBusi(paramInt));
      QQAlbumUtils.a(localIntent, this.e.albumId, str, this.b.N);
      localIntent.putExtra("PHOTOLIST_START_POSITION", this.h.m.findFirstVisibleItemPosition());
      localIntent.putExtra("FROM_WHERE", "FROM_PHOTO_LIST");
      localIntent.putExtra("PhotoConst.SOURCE_FROM", "FROM_SELECT_PHOTO");
      localIntent.addFlags(603979776);
      localIntent.putExtra("PhotoConst.IS_WITH_PENDANT", false);
      localIntent.putExtra("PhotoConst.TARGET_WIDTH", localPoint.x);
      localIntent.putExtra("PhotoConst.TARGET_HEIGHT", localPoint.y);
    }
    this.c.startActivity(localIntent);
    this.c.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.util.QQGuildPhotoListCustomizationCrop
 * JD-Core Version:    0.7.0.1
 */