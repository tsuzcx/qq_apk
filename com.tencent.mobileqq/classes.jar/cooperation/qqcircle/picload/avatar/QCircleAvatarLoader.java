package cooperation.qqcircle.picload.avatar;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import com.tencent.biz.qcircleshadow.handler.QCircleHandler;
import com.tencent.biz.richframework.delegate.impl.RFLog;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.mobileqq.qcircle.api.impl.QCircleServiceImpl;
import com.tencent.mobileqq.qcircle.tempapi.avatar.QCircleAvatarInfo;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.picload.QCircleOkHttpDW;
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
      if ((localImageView.getTag(2131373899) instanceof String))
      {
        if (((String)localImageView.getTag(2131373899)).equals(paramAvatarOption)) {
          return true;
        }
        localImageView.setTag(2131373899, paramAvatarOption);
        return false;
      }
      localImageView.setTag(2131373899, paramAvatarOption);
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
      this.mEm = QCircleServiceImpl.getEntityManager();
      EntityManager localEntityManager = this.mEm;
      return localEntityManager;
    }
    catch (Exception localException)
    {
      int i = RFLog.USR;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getmEm ");
      localStringBuilder.append(localException);
      RFLog.e("QCircleAvatar", i, localStringBuilder.toString());
    }
    return null;
  }
  
  public void loadAvatar(AvatarOption paramAvatarOption)
  {
    if (paramAvatarOption != null)
    {
      if (checkDoubleLoad(paramAvatarOption)) {
        return;
      }
      if (paramAvatarOption.getTargetView() != null) {
        paramAvatarOption.getTargetView().setImageDrawable(MobileQQ.sMobileQQ.getApplicationContext().getResources().getDrawable(2130840321));
      }
      paramAvatarOption.mStartTime = Long.valueOf(System.currentTimeMillis());
      paramAvatarOption.setSeq(QCircleFeedPicLoader.sAtomicInteger.getAndIncrement()).setPicType(3);
      int i = RFLog.USR;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("seq = ");
      localStringBuilder.append(paramAvatarOption.getSeq());
      localStringBuilder.append("  load seq start:");
      localStringBuilder.append(paramAvatarOption.getUin());
      localStringBuilder.append(" is preload:");
      localStringBuilder.append(paramAvatarOption.isFromPreload());
      RFLog.d("QCircleAvatar", i, localStringBuilder.toString());
      if (paramAvatarOption.isFromPreload())
      {
        if (this.mCheckTask.containsKey(paramAvatarOption.getUin()))
        {
          i = RFLog.USR;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("seq = ");
          localStringBuilder.append(paramAvatarOption.getSeq());
          localStringBuilder.append("  load return, has check already");
          RFLog.d("QCircleAvatar", i, localStringBuilder.toString());
        }
      }
      else {
        checkDownLoad(paramAvatarOption);
      }
    }
  }
  
  public void release()
  {
    QCircleOkHttpDW.release();
    this.mRequestIngMap.clear();
    this.mResultInfoMap.clear();
    this.mCheckTask.clear();
    this.mTogetherOptions.clear();
    this.mPreloadExecutor.getQueue().clear();
    this.mLoadExecutor.getQueue().clear();
    if (QCircleHandler.a() != null) {
      QCircleHandler.a().a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.qqcircle.picload.avatar.QCircleAvatarLoader
 * JD-Core Version:    0.7.0.1
 */