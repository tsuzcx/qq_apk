package com.tencent.mobileqq.troop.robot;

import ajmf;
import ajmg;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.WindowManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.surfaceviewaction.gl.RobotSpriteVideoView;
import com.tencent.mobileqq.util.PuzzleAvatarUtil;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;

public class RobotResourcesManager
{
  private static RobotResourcesManager jdField_a_of_type_ComTencentMobileqqTroopRobotRobotResourcesManager = new RobotResourcesManager();
  private WindowManager jdField_a_of_type_AndroidViewWindowManager;
  public BaseChatPie a;
  public RobotSpriteVideoView a;
  DownloadListener jdField_a_of_type_ComTencentMobileqqVipDownloadListener = new ajmf(this);
  public String a;
  public HashMap a;
  public HashMap b = new HashMap();
  
  public RobotResourcesManager()
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public static RobotResourcesManager a()
  {
    return jdField_a_of_type_ComTencentMobileqqTroopRobotRobotResourcesManager;
  }
  
  public static void a(String paramString, int[] paramArrayOfInt)
  {
    try
    {
      Object localObject = new MediaMetadataRetriever();
      ((MediaMetadataRetriever)localObject).setDataSource(paramString);
      paramString = ((MediaMetadataRetriever)localObject).extractMetadata(18);
      localObject = ((MediaMetadataRetriever)localObject).extractMetadata(19);
      paramArrayOfInt[0] = (Integer.parseInt(paramString) / 2);
      paramArrayOfInt[1] = Integer.parseInt((String)localObject);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void b(String paramString)
  {
    if ((!this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString)) || (((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)).intValue() == 4))
    {
      Object localObject = new File(b(paramString));
      Bundle localBundle = new Bundle();
      localBundle.putString("resId", paramString);
      localObject = new DownloadTask(a(paramString), (File)localObject);
      ((DownloadTask)localObject).b = 2;
      a().a((DownloadTask)localObject, this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener, localBundle);
      if (QLog.isColorLevel()) {
        QLog.d("Q.robot.RobotResourcesManager", 2, "start Download PackageId:" + paramString);
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, Integer.valueOf(2));
    }
  }
  
  public Bitmap a(int paramInt, Bitmap[] paramArrayOfBitmap)
  {
    Object localObject = null;
    try
    {
      paramArrayOfBitmap = PuzzleAvatarUtil.a(paramInt, paramArrayOfBitmap, BitmapFactory.decodeResource(BaseApplicationImpl.getApplication().getResources(), 2130842367), 1.0F);
      return paramArrayOfBitmap;
    }
    catch (Throwable localThrowable)
    {
      do
      {
        paramArrayOfBitmap = localObject;
      } while (!QLog.isColorLevel());
      QLog.i("Q.robot.RobotResourcesManager", 2, localThrowable.toString());
    }
    return null;
  }
  
  public DownloaderInterface a()
  {
    return ((DownloaderFactory)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(46)).a(1);
  }
  
  public String a(String paramString)
  {
    return "http://pub.idqqimg.com/pc/misc/robot/" + paramString + ".zip";
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = null;
    if (this.jdField_a_of_type_AndroidViewWindowManager != null) {}
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlRobotSpriteVideoView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlRobotSpriteVideoView.n();
        this.jdField_a_of_type_AndroidViewWindowManager.removeView(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlRobotSpriteVideoView);
      }
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlRobotSpriteVideoView = null;
      this.jdField_a_of_type_JavaLangString = null;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void a(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
  }
  
  public void a(String paramString)
  {
    int i = 0;
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    label26:
    Object localObject;
    if (paramString.contains("|"))
    {
      paramString = paramString.split("\\|");
      if (paramString.length <= 4) {
        break label122;
      }
      localObject = new String[4];
      localObject[0] = paramString[0];
      localObject[1] = paramString[1];
      localObject[2] = paramString[2];
      localObject[3] = paramString[3];
      paramString = (String)localObject;
    }
    label122:
    for (;;)
    {
      localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      int j = paramString.length;
      while (i < j)
      {
        ((QQAppInterface)localObject).a(paramString[i], true);
        i += 1;
      }
      break;
      localObject = new String[1];
      localObject[0] = paramString;
      paramString = (String)localObject;
      break label26;
    }
  }
  
  public void a(String paramString, RobotResourcesManager.LoadResourceCallback paramLoadResourceCallback)
  {
    String str = b(paramString);
    if ((this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString)) && (((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)).intValue() == 3)) {
      if (paramLoadResourceCallback != null) {
        paramLoadResourceCallback.a(0);
      }
    }
    do
    {
      return;
      if ((!new File(str).exists()) || (!a(paramString))) {
        break;
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, Integer.valueOf(3));
    } while (paramLoadResourceCallback == null);
    paramLoadResourceCallback.a(0);
    return;
    if (paramLoadResourceCallback != null) {
      this.b.put(paramString, paramLoadResourceCallback);
    }
    b(paramString);
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    new Handler(Looper.getMainLooper()).post(new ajmg(this, paramString2, paramString3, paramString1));
  }
  
  public boolean a()
  {
    return !TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString);
  }
  
  public boolean a(String paramString)
  {
    boolean bool3 = true;
    Object localObject1 = new File(c(paramString));
    if (!((File)localObject1).exists()) {}
    do
    {
      return false;
      localObject1 = ((File)localObject1).list();
    } while (localObject1 == null);
    int j = localObject1.length;
    int i = 0;
    boolean bool1 = false;
    boolean bool2 = false;
    while (i < j)
    {
      Object localObject2 = localObject1[i];
      if ("video.mp4".equals(localObject2)) {
        bool2 = true;
      }
      if ("header.png".equals(localObject2)) {
        bool1 = true;
      }
      i += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.robot.RobotResourcesManager", 2, "checkDir resId = " + paramString + "hasVideo = " + bool2 + " hasHeader = " + bool1);
    }
    if ((bool2) && (bool1)) {}
    for (bool1 = bool3;; bool1 = false) {
      return bool1;
    }
  }
  
  public String b(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(AppConstants.cd).append(paramString).append(".zip");
    return localStringBuffer.toString();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidViewWindowManager != null) {}
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlRobotSpriteVideoView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlRobotSpriteVideoView.n();
        this.jdField_a_of_type_AndroidViewWindowManager.removeView(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlRobotSpriteVideoView);
      }
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlRobotSpriteVideoView = null;
      this.jdField_a_of_type_JavaLangString = null;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.notifyDataSetChanged();
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public boolean b(String paramString)
  {
    if ((!this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString)) || (this.jdField_a_of_type_JavaUtilHashMap.get(paramString) == null)) {
      return false;
    }
    return ((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)).intValue() == 3;
  }
  
  public String c(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(AppConstants.cd).append(paramString).append(File.separator);
    paramString = new File(localStringBuffer.toString());
    if (!paramString.exists()) {
      paramString.mkdirs();
    }
    return localStringBuffer.toString();
  }
  
  public boolean c(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {
      return false;
    }
    return paramString.equals(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.troop.robot.RobotResourcesManager
 * JD-Core Version:    0.7.0.1
 */