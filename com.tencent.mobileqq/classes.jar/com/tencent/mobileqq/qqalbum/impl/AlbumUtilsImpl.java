package com.tencent.mobileqq.qqalbum.impl;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.component.media.image.ImageManager;
import com.tencent.mobileqq.activity.photo.PhotoSendParams;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qqalbum.IAlbumUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashMap<Ljava.lang.String;Lcom.tencent.mobileqq.activity.photo.PhotoSendParams;>;

public class AlbumUtilsImpl
  implements IAlbumUtils
{
  public static final String TAG = "QQAlbum";
  
  public String formatTimeToString(long paramLong)
  {
    return QAlbumUtil.formatTimeToString(paramLong);
  }
  
  public void sendPhoto(Activity paramActivity, Intent paramIntent, ArrayList<String> paramArrayList, HashMap<String, PhotoSendParams> paramHashMap, int paramInt, boolean paramBoolean)
  {
    paramIntent.setExtrasClassLoader(PhotoSendParams.class.getClassLoader());
    Object localObject1 = new HashMap();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramArrayList.size())
    {
      Object localObject2 = (PhotoSendParams)paramHashMap.get(paramArrayList.get(i));
      if (localObject2 != null)
      {
        ((HashMap)localObject1).put(((PhotoSendParams)localObject2).thumbPath, localObject2);
        if (QLog.isColorLevel()) {
          QLog.d("aioSendPhotos", 2, new Object[] { "[Qzone] thumbPath:", ((PhotoSendParams)localObject2).thumbPath, " photoSendParams:", ((PhotoSendParams)localObject2).toString() });
        }
      }
      else if (!ImageManager.isNetworkUrl((String)paramArrayList.get(i)))
      {
        localArrayList.add(paramArrayList.get(i));
        if (QLog.isColorLevel()) {
          QLog.d("aioSendPhotos", 2, new Object[] { "[QQ] local path:", paramArrayList.get(i) });
        }
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[Error] path:");
        ((StringBuilder)localObject2).append((String)paramArrayList.get(i));
        QLog.w("aioSendPhotos", 2, ((StringBuilder)localObject2).toString());
      }
      i += 1;
    }
    paramIntent.putExtra("PhotoConst.photo_send_pic_type", (Serializable)localObject1);
    paramIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
    paramIntent.putExtra("PhotoConst.SEND_SIZE_SPEC", paramInt);
    localObject1 = paramIntent.getStringExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME");
    paramArrayList = paramIntent.getStringExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME");
    if (!TextUtils.isEmpty(paramArrayList))
    {
      paramHashMap = (HashMap<String, PhotoSendParams>)localObject1;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
    }
    else
    {
      paramHashMap = paramIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME");
      paramArrayList = paramIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQAlbum", 2, String.format("sendPhoto packageName=%s className=%s", new Object[] { paramHashMap, paramArrayList }));
    }
    if ((!TextUtils.isEmpty(paramHashMap)) && (!TextUtils.isEmpty(paramArrayList)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQAlbum", 2, String.format("sendPhoto extras=%s", new Object[] { paramIntent.getExtras() }));
      }
      paramIntent.setClassName(paramHashMap, paramArrayList);
      paramIntent.addFlags(603979776);
      boolean bool1 = paramIntent.getBooleanExtra("PhotoConst.IS_CALL_IN_PLUGIN", false);
      if (QLog.isColorLevel())
      {
        paramHashMap = new StringBuilder();
        paramHashMap.append("sendPhoto isCallFromPlugin=");
        paramHashMap.append(bool1);
        paramHashMap.append("className=");
        paramHashMap.append(paramArrayList);
        QLog.d("forward", 2, paramHashMap.toString());
      }
      boolean bool2 = paramIntent.getBooleanExtra("PhotoConst.is_troop_send_mixed_msg", false);
      if (QLog.isColorLevel())
      {
        paramArrayList = new StringBuilder();
        paramArrayList.append("sendPhoto isTroopSendMixedMsg = ");
        paramArrayList.append(bool2);
        QLog.d("zivonchen", 2, paramArrayList.toString());
      }
      if (!bool1)
      {
        paramIntent.putExtra("PhotoConst.QZONE_ALBUM_FROM_AIO", true);
        paramActivity.startActivityForResult(paramIntent, 2);
      }
      if (!paramBoolean)
      {
        paramActivity.finish();
        QAlbumUtil.anim(paramActivity, false, false);
      }
      return;
    }
    paramArrayList = paramIntent.getStringExtra("PhotoConst.DEST_BROADCAST_ACTION_NAME");
    if (QLog.isColorLevel()) {
      QLog.d("QQAlbum", 2, String.format("sendPhoto action=%s", new Object[] { paramArrayList }));
    }
    if (TextUtils.isEmpty(paramArrayList))
    {
      QQToast.a(paramActivity, HardCodeUtil.a(2131718785), 0).a();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQAlbum", 2, String.format("sendPhoto extras=%s", new Object[] { paramIntent.getExtras() }));
    }
    paramIntent.setComponent(null);
    paramIntent.setAction(paramArrayList);
    paramIntent.setFlags(paramIntent.getFlags() & 0xDFFFFFFF & 0xFBFFFFFF);
    try
    {
      paramActivity.sendBroadcast(paramIntent);
      paramActivity.finish();
      return;
    }
    catch (Exception paramActivity)
    {
      QLog.d("QQAlbum", 1, "sendPhoto fail!", paramActivity);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqalbum.impl.AlbumUtilsImpl
 * JD-Core Version:    0.7.0.1
 */