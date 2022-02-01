package cooperation.qqcircle.picload.avatar;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import com.tencent.biz.richframework.delegate.impl.RFLog;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.mobileqq.qcircle.api.impl.QCircleServiceImpl;
import com.tencent.mobileqq.qcircle.tempapi.api.IQQBaseService;
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
    this.mPreloadExecutor = QCircleFeedPicLoader.createPool(i, i * 2 + 1);
    this.mLoadExecutor = QCircleFeedPicLoader.createPool(i, i * 2 + 1);
    initEm();
  }
  
  private boolean checkDoubleLoad(AvatarOption paramAvatarOption)
  {
    ImageView localImageView = paramAvatarOption.getTargetView();
    paramAvatarOption = paramAvatarOption.getUin();
    if (localImageView != null)
    {
      if ((localImageView.getTag(2131374346) instanceof String))
      {
        if (((String)localImageView.getTag(2131374346)).equals(paramAvatarOption)) {
          return true;
        }
        localImageView.setTag(2131374346, paramAvatarOption);
        return false;
      }
      localImageView.setTag(2131374346, paramAvatarOption);
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
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new QCircleAvatarLoader();
      }
      return sInstance;
    }
    finally {}
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
      RFLog.e("QCircleAvatar", RFLog.USR, "getmEm " + localException);
    }
    return null;
  }
  
  public void loadAvatar(AvatarOption paramAvatarOption)
  {
    if ((paramAvatarOption == null) || (checkDoubleLoad(paramAvatarOption))) {}
    do
    {
      return;
      if (paramAvatarOption.getTargetView() != null) {
        paramAvatarOption.getTargetView().setImageDrawable(MobileQQ.sMobileQQ.getApplicationContext().getResources().getDrawable(2130840452));
      }
      paramAvatarOption.mStartTime = Long.valueOf(System.currentTimeMillis());
      paramAvatarOption.setSeq(QCircleFeedPicLoader.sAtomicInteger.getAndIncrement()).setPicType(3);
      RFLog.d("QCircleAvatar", RFLog.USR, "seq = " + paramAvatarOption.getSeq() + "  load seq start:" + paramAvatarOption.getUin() + " is preload:" + paramAvatarOption.isFromPreload());
      if (!paramAvatarOption.isFromPreload()) {
        break;
      }
    } while (!this.mCheckTask.containsKey(paramAvatarOption.getUin()));
    RFLog.d("QCircleAvatar", RFLog.USR, "seq = " + paramAvatarOption.getSeq() + "  load return, has check already");
    return;
    checkDownLoad(paramAvatarOption);
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
    QCircleServiceImpl.getQQService().clearAvatarListener();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqcircle.picload.avatar.QCircleAvatarLoader
 * JD-Core Version:    0.7.0.1
 */