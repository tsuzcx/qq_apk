package cooperation.qqcircle.picload.avatar;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.tencent.biz.qcircleshadow.handler.QCircleHandler;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.mobileqq.qcircle.api.interfaces.QCirclePicStateListener;
import com.tencent.mobileqq.qcircle.tempapi.avatar.QCircleAvatarInfo;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.picload.RFWOkHttpDW;
import cooperation.qqcircle.utils.QCircleHostStubUtil;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.MobileQQ;

public class QCircleAvatarLoader
{
  private static final String TAG = "QCircleAvatar";
  private static final long TIME_STAMP = 86400000L;
  private static volatile QCircleAvatarLoader sInstance;
  private ConcurrentHashMap<String, QCircleAvatarLoader.QCircleAvatarCheckTask> mCheckTask = new ConcurrentHashMap();
  private EntityManager mEm;
  private ThreadPoolExecutor mLoadExecutor;
  private ThreadPoolExecutor mPreloadExecutor;
  private ConcurrentHashMap<String, String> mRequestIngMap = new ConcurrentHashMap();
  private ConcurrentHashMap<String, QCircleAvatarInfo> mResultInfoMap = new ConcurrentHashMap();
  private ConcurrentHashMap<String, ConcurrentHashMap<Integer, AvatarOption>> mTogetherOptions = new ConcurrentHashMap();
  
  private QCircleAvatarLoader()
  {
    int i = Runtime.getRuntime().availableProcessors();
    int j = i * 2 + 1;
    this.mPreloadExecutor = QCircleFeedPicLoader.createPool(i, j);
    this.mLoadExecutor = QCircleFeedPicLoader.createPool(i, j);
    initEm();
  }
  
  private boolean checkDoubleLoad(AvatarOption paramAvatarOption)
  {
    ImageView localImageView = paramAvatarOption.getTargetView();
    paramAvatarOption = paramAvatarOption.getUin();
    if (localImageView != null)
    {
      if ((localImageView.getTag(2131441575) instanceof String))
      {
        if (((String)localImageView.getTag(2131441575)).equals(paramAvatarOption)) {
          return true;
        }
        localImageView.setTag(2131441575, paramAvatarOption);
        return false;
      }
      localImageView.setTag(2131441575, paramAvatarOption);
    }
    return false;
  }
  
  private void checkDownLoad(AvatarOption paramAvatarOption)
  {
    QCircleAvatarLoader.QCircleAvatarCheckTask localQCircleAvatarCheckTask = new QCircleAvatarLoader.QCircleAvatarCheckTask(this, paramAvatarOption, this.mEm);
    this.mCheckTask.put(paramAvatarOption.getUin(), localQCircleAvatarCheckTask);
    if (paramAvatarOption.isFromPreload())
    {
      this.mPreloadExecutor.execute(localQCircleAvatarCheckTask);
      return;
    }
    this.mLoadExecutor.execute(localQCircleAvatarCheckTask);
  }
  
  public static QCircleAvatarLoader g()
  {
    if (sInstance == null) {
      try
      {
        if (sInstance == null) {
          sInstance = new QCircleAvatarLoader();
        }
      }
      finally {}
    }
    return sInstance;
  }
  
  private EntityManager initEm()
  {
    try
    {
      this.mEm = QCircleHostStubUtil.getEntityManager();
      EntityManager localEntityManager = this.mEm;
      return localEntityManager;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getmEm ");
      localStringBuilder.append(localException);
      QLog.e("QCircleAvatar", 1, localStringBuilder.toString());
    }
    return null;
  }
  
  public void loadAvatar(AvatarOption paramAvatarOption)
  {
    if (paramAvatarOption == null) {
      return;
    }
    if (!TextUtils.isEmpty(paramAvatarOption.getUrl()))
    {
      QCircleFeedPicLoader.g().loadImage(paramAvatarOption, new QCirclePicStateListener());
      return;
    }
    if (checkDoubleLoad(paramAvatarOption)) {
      return;
    }
    if (paramAvatarOption.getTargetView() != null) {
      paramAvatarOption.getTargetView().setImageDrawable(MobileQQ.sMobileQQ.getApplicationContext().getResources().getDrawable(2130841060));
    }
    paramAvatarOption.mStartTime = Long.valueOf(System.currentTimeMillis());
    paramAvatarOption.setSeq(QCircleFeedPicLoader.sAtomicInteger.getAndIncrement()).setPicType(3);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("seq = ");
    localStringBuilder.append(paramAvatarOption.getSeq());
    localStringBuilder.append("  load seq start:");
    localStringBuilder.append(paramAvatarOption.getUin());
    localStringBuilder.append(" is preload:");
    localStringBuilder.append(paramAvatarOption.isFromPreload());
    QLog.d("QCircleAvatar", 1, localStringBuilder.toString());
    if (paramAvatarOption.isFromPreload())
    {
      if (this.mCheckTask.containsKey(paramAvatarOption.getUin()))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("seq = ");
        localStringBuilder.append(paramAvatarOption.getSeq());
        localStringBuilder.append("  load return, has check already");
        QLog.d("QCircleAvatar", 1, localStringBuilder.toString());
      }
    }
    else {
      checkDownLoad(paramAvatarOption);
    }
  }
  
  public void release()
  {
    RFWOkHttpDW.release();
    this.mRequestIngMap.clear();
    this.mResultInfoMap.clear();
    this.mCheckTask.clear();
    this.mTogetherOptions.clear();
    this.mPreloadExecutor.getQueue().clear();
    this.mLoadExecutor.getQueue().clear();
    if (QCircleHandler.d() != null) {
      QCircleHandler.d().a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqcircle.picload.avatar.QCircleAvatarLoader
 * JD-Core Version:    0.7.0.1
 */