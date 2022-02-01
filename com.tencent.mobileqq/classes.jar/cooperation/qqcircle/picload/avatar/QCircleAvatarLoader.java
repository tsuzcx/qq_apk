package cooperation.qqcircle.picload.avatar;

import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.chat.QCircleHandler;
import cooperation.qqcircle.picload.Option;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.picload.QCircleOkHttpDW;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;

public class QCircleAvatarLoader
{
  private static final String TAG = "QCircleAvatar";
  private static final long TIME_STAMP = 86400000L;
  private static QCircleAvatarLoader sInstance;
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
      if ((localImageView.getTag(2131374032) instanceof String))
      {
        if (((String)localImageView.getTag(2131374032)).equals(paramAvatarOption)) {
          return true;
        }
        localImageView.setTag(2131374032, paramAvatarOption);
        return false;
      }
      localImageView.setTag(2131374032, paramAvatarOption);
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
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if (localObject == null) {
      QLog.e("QCircleAvatar", 1, "getmEm app null");
    }
    if (!(localObject instanceof QQAppInterface))
    {
      QLog.e("QCircleAvatar", 1, "getmEm not  QQAppInterface");
      return null;
    }
    if (((AppRuntime)localObject).getAccount() == null)
    {
      QLog.e("QCircleAvatar", 1, "getmEm getAccount null");
      return null;
    }
    try
    {
      this.mEm = ((QQAppInterface)localObject).getEntityManagerFactory().createEntityManager();
      localObject = this.mEm;
      return localObject;
    }
    catch (Exception localException)
    {
      QLog.e("QCircleAvatar", 1, "getmEm " + localException);
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
        paramAvatarOption.getTargetView().setImageDrawable(BaseApplicationImpl.context.getResources().getDrawable(2130840348));
      }
      paramAvatarOption.mStartTime = Long.valueOf(System.currentTimeMillis());
      paramAvatarOption.setSeq(QCircleFeedPicLoader.sAtomicInteger.getAndIncrement()).setPicType(3);
      QLog.d("QCircleAvatar", 1, "seq = " + paramAvatarOption.getSeq() + "  load seq start:" + paramAvatarOption.getUin() + " is preload:" + paramAvatarOption.isFromPreload());
      if (!paramAvatarOption.isFromPreload()) {
        break;
      }
    } while (!this.mCheckTask.containsKey(paramAvatarOption.getUin()));
    QLog.d("QCircleAvatar", 1, "seq = " + paramAvatarOption.getSeq() + "  load return, has check already");
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
    QCircleHandler localQCircleHandler = (QCircleHandler)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getBusinessHandler(BusinessHandlerFactory.QCIRCLE_HANDLER);
    if (localQCircleHandler != null) {
      localQCircleHandler.clearAvatarListener();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.picload.avatar.QCircleAvatarLoader
 * JD-Core Version:    0.7.0.1
 */