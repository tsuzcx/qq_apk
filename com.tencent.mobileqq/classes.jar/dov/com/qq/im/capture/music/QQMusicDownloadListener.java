package dov.com.qq.im.capture.music;

import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.view.QIMCommonLoadingProgress;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;

public class QQMusicDownloadListener
  extends MusicDownloadListener
{
  private MusicDownloadListener jdField_a_of_type_DovComQqImCaptureMusicMusicDownloadListener;
  private ConcurrentHashMap<String, MusicItemInfo> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private ConcurrentHashMap<String, DownloadTask> b;
  
  public QQMusicDownloadListener(ConcurrentHashMap<String, MusicItemInfo> paramConcurrentHashMap, ConcurrentHashMap<String, DownloadTask> paramConcurrentHashMap1, MusicDownloadListener paramMusicDownloadListener)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = paramConcurrentHashMap;
    this.b = paramConcurrentHashMap1;
    this.jdField_a_of_type_DovComQqImCaptureMusicMusicDownloadListener = paramMusicDownloadListener;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_DovComQqImCaptureMusicMusicDownloadListener.a(paramInt);
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQMusicDownloadListener", 2, "onCancel key=" + paramString);
    }
    MusicItemInfo localMusicItemInfo = (MusicItemInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (localMusicItemInfo != null) {
      localMusicItemInfo.mProgress = -1;
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
    this.b.remove(paramString);
    this.jdField_a_of_type_DovComQqImCaptureMusicMusicDownloadListener.a(paramString);
    QIMCommonLoadingProgress.a(localMusicItemInfo).c();
  }
  
  public void a(String paramString, int paramInt)
  {
    MusicItemInfo localMusicItemInfo = (MusicItemInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    int i = paramInt;
    if (localMusicItemInfo != null)
    {
      i = paramInt;
      if (paramInt == 100)
      {
        i = paramInt;
        if (this.b.contains(localMusicItemInfo.getLocalPath())) {
          i = 99;
        }
      }
      localMusicItemInfo.mProgress = i;
    }
    this.jdField_a_of_type_DovComQqImCaptureMusicMusicDownloadListener.a(paramString, i);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    MusicItemInfo localMusicItemInfo = (MusicItemInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (localMusicItemInfo != null)
    {
      if (paramBoolean) {
        break label60;
      }
      QIMCommonLoadingProgress.a(localMusicItemInfo).c();
      localMusicItemInfo.mProgress = -1;
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
      this.b.remove(paramString);
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComQqImCaptureMusicMusicDownloadListener.a(paramString, paramBoolean);
      return;
      label60:
      localMusicItemInfo.mProgress = 1;
    }
  }
  
  public void a(String paramString, boolean paramBoolean, int paramInt)
  {
    MusicItemInfo localMusicItemInfo = (MusicItemInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("QQMusicDownloadListener", 2, new Object[] { "onFinish, info:", localMusicItemInfo });
    }
    boolean bool = paramBoolean;
    if (localMusicItemInfo != null)
    {
      if (!paramBoolean) {
        break label214;
      }
      localMusicItemInfo.mProgress = 100;
      QIMCommonLoadingProgress.a(localMusicItemInfo).b();
      bool = paramBoolean;
      if (localMusicItemInfo.isMyMusicInfo())
      {
        bool = paramBoolean;
        if (localMusicItemInfo.fileSize > 0L)
        {
          File localFile = new File(paramString);
          if (localFile.length() != localMusicItemInfo.fileSize)
          {
            localMusicItemInfo.mProgress = -1;
            QIMCommonLoadingProgress.a(localMusicItemInfo).c();
            paramBoolean = false;
          }
          bool = paramBoolean;
          if (QLog.isColorLevel()) {
            QLog.d("QQMusicDownloadListener", 2, "file.length =" + localFile.length() + " info.fileSize=" + localMusicItemInfo.fileSize);
          }
        }
      }
    }
    for (bool = paramBoolean;; bool = paramBoolean)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
      this.b.remove(paramString);
      this.jdField_a_of_type_DovComQqImCaptureMusicMusicDownloadListener.a(paramString, bool, paramInt);
      return;
      label214:
      localMusicItemInfo.mProgress = -1;
      QIMCommonLoadingProgress.a(localMusicItemInfo).c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.music.QQMusicDownloadListener
 * JD-Core Version:    0.7.0.1
 */