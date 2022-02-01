package com.tencent.mobileqq.qqalbum.impl;

import android.content.Intent;
import com.tencent.mobileqq.activity.photo.album.OtherCommonData;
import com.tencent.mobileqq.activity.photo.album.albumlist.AbstractAlbumListFragment;
import com.tencent.mobileqq.activity.photo.album.albumlist.AlbumListCustomization;
import com.tencent.mobileqq.activity.photo.album.photolist.AbstractPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomization;
import com.tencent.mobileqq.activity.photo.album.preview.AbstractPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.preview.PhotoPreviewCustomization;
import com.tencent.mobileqq.qqalbum.IPhotoLogicFactory;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Constructor;

public class PhotoLogicFactoryImpl
  implements IPhotoLogicFactory
{
  public static final String TAG = "PhotoLogicFactory";
  
  public AlbumListCustomization<? extends OtherCommonData> createAlbumListLogic(AbstractAlbumListFragment paramAbstractAlbumListFragment, Intent paramIntent)
  {
    if (paramIntent != null) {
      paramIntent = paramIntent.getStringExtra("KEY_ALBUM_LIST_CLASS_NAME");
    } else {
      paramIntent = null;
    }
    Object localObject;
    if (paramIntent != null)
    {
      localObject = paramIntent;
      if (!paramIntent.equals("")) {}
    }
    else
    {
      localObject = "com.tencent.mobileqq.activity.photo.album.AlbumListCustomizationDefault";
    }
    if (QLog.isColorLevel())
    {
      paramIntent = new StringBuilder();
      paramIntent.append("createAlbumListCustomization:");
      paramIntent.append((String)localObject);
      QLog.d("PhotoLogicFactory", 2, paramIntent.toString());
    }
    try
    {
      paramIntent = Class.forName((String)localObject).getDeclaredConstructor(new Class[] { AbstractAlbumListFragment.class });
      paramIntent.setAccessible(true);
      paramAbstractAlbumListFragment = (AlbumListCustomization)paramIntent.newInstance(new Object[] { paramAbstractAlbumListFragment });
      return paramAbstractAlbumListFragment;
    }
    catch (Exception paramAbstractAlbumListFragment)
    {
      QLog.e("PhotoLogicFactory", 1, paramAbstractAlbumListFragment, new Object[0]);
    }
    return null;
  }
  
  public PhotoListCustomization<? extends OtherCommonData> createPhotoListLogic(AbstractPhotoListActivity paramAbstractPhotoListActivity, Intent paramIntent)
  {
    if (paramIntent != null) {
      paramIntent = paramIntent.getStringExtra("KEY_PHOTO_LIST_CLASS_NAME");
    } else {
      paramIntent = null;
    }
    Object localObject;
    if (paramIntent != null)
    {
      localObject = paramIntent;
      if (!paramIntent.equals("")) {}
    }
    else
    {
      localObject = "com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault";
    }
    if (QLog.isColorLevel())
    {
      paramIntent = new StringBuilder();
      paramIntent.append("createPhotoListCustomization:");
      paramIntent.append((String)localObject);
      QLog.d("PhotoLogicFactory", 2, paramIntent.toString());
    }
    try
    {
      paramIntent = Class.forName((String)localObject).getDeclaredConstructor(new Class[] { AbstractPhotoListActivity.class });
      paramIntent.setAccessible(true);
      paramAbstractPhotoListActivity = (PhotoListCustomization)paramIntent.newInstance(new Object[] { paramAbstractPhotoListActivity });
      return paramAbstractPhotoListActivity;
    }
    catch (Exception paramAbstractPhotoListActivity)
    {
      QLog.e("PhotoLogicFactory", 1, paramAbstractPhotoListActivity, new Object[0]);
    }
    return null;
  }
  
  public PhotoPreviewCustomization<? extends OtherCommonData> createPhotoPreviewLogic(AbstractPhotoPreviewActivity paramAbstractPhotoPreviewActivity, Intent paramIntent)
  {
    if (paramIntent != null) {
      paramIntent = paramIntent.getStringExtra("KEY_PHOTO_PREVIEW_CLASS_NAME");
    } else {
      paramIntent = null;
    }
    Object localObject;
    if (paramIntent != null)
    {
      localObject = paramIntent;
      if (!paramIntent.equals("")) {}
    }
    else
    {
      localObject = "com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault";
    }
    if (QLog.isColorLevel())
    {
      paramIntent = new StringBuilder();
      paramIntent.append("createPhotoPreviewCustomization:");
      paramIntent.append((String)localObject);
      QLog.d("PhotoLogicFactory", 2, paramIntent.toString());
    }
    try
    {
      paramIntent = Class.forName((String)localObject).getDeclaredConstructor(new Class[] { AbstractPhotoPreviewActivity.class });
      paramIntent.setAccessible(true);
      paramAbstractPhotoPreviewActivity = (PhotoPreviewCustomization)paramIntent.newInstance(new Object[] { paramAbstractPhotoPreviewActivity });
      return paramAbstractPhotoPreviewActivity;
    }
    catch (Exception paramAbstractPhotoPreviewActivity)
    {
      QLog.e("PhotoLogicFactory", 1, paramAbstractPhotoPreviewActivity, new Object[0]);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqalbum.impl.PhotoLogicFactoryImpl
 * JD-Core Version:    0.7.0.1
 */