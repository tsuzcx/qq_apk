package com.tencent.mobileqq.transfile.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pic.api.IPicFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.api.IShortVideoFactory;
import com.tencent.mobileqq.transfile.BDHCommonUploadProcessor;
import com.tencent.mobileqq.transfile.BaseTransFileController;
import com.tencent.mobileqq.transfile.BaseTransFileController.ProcHandler;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.ForwardSdkShareProcessor;
import com.tencent.mobileqq.transfile.HttpCommunicator;
import com.tencent.mobileqq.transfile.IScribblePicDownloadProcessor;
import com.tencent.mobileqq.transfile.IScribblePicUploadProcessor;
import com.tencent.mobileqq.transfile.MultiMsgDownloadProcessor;
import com.tencent.mobileqq.transfile.MultiMsgUpProcessor;
import com.tencent.mobileqq.transfile.NearbyPeoplePhotoUploadProcessor;
import com.tencent.mobileqq.transfile.ShareToWXUploadProcessor;
import com.tencent.mobileqq.transfile.ShortVideoDownloadProcessor;
import com.tencent.mobileqq.transfile.StoryUploadProcessor;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.transfile.api.IPttTransProcessorHelper;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.transfile.api.TransFileControllerBusHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;

public class TransFileControllerImpl
  extends BaseTransFileController
  implements ITransFileController
{
  public static final boolean CLIENT_PERMIT_PRE_CONN = false;
  public static final String KEY_USE_PRE_CONN = "key_pre_conn";
  public static final String TAG = "Q.richmedia.TransFileController";
  public static final String VALUE_USE_PRE_CONN = "use";
  public static HashSet<Integer> nearByFileType = new HashSet();
  TransFileControllerBusHelper busHelper;
  
  static
  {
    nearByFileType.add(Integer.valueOf(8));
    nearByFileType.add(Integer.valueOf(64));
    nearByFileType.add(Integer.valueOf(22));
    nearByFileType.add(Integer.valueOf(21));
    nearByFileType.add(Integer.valueOf(34));
    nearByFileType.add(Integer.valueOf(35));
    nearByFileType.add(Integer.valueOf(36));
    nearByFileType.add(Integer.valueOf(37));
    nearByFileType.add(Integer.valueOf(38));
    nearByFileType.add(Integer.valueOf(48));
    nearByFileType.add(Integer.valueOf(23));
    nearByFileType.add(Integer.valueOf(39));
    nearByFileType.add(Integer.valueOf(40));
    nearByFileType.add(Integer.valueOf(41));
    nearByFileType.add(Integer.valueOf(50));
    nearByFileType.add(Integer.valueOf(51));
    nearByFileType.add(Integer.valueOf(56));
  }
  
  public TransFileControllerImpl() {}
  
  public TransFileControllerImpl(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  protected void fillTransRequestMessage(BaseTransProcessor paramBaseTransProcessor)
  {
    try
    {
      TransferRequest localTransferRequest = paramBaseTransProcessor.getTransferRequest();
      if ((localTransferRequest != null) && (localTransferRequest.mUniseq != 0L) && (localTransferRequest.mRec == null) && ((paramBaseTransProcessor.app instanceof QQAppInterface)))
      {
        localTransferRequest.mRec = ((QQAppInterface)paramBaseTransProcessor.app).getMessageFacade().b(localTransferRequest.mPeerUin, localTransferRequest.mUinType, localTransferRequest.mUniseq);
        return;
      }
    }
    catch (Exception paramBaseTransProcessor)
    {
      QLog.e("Q.richmedia.TransFileController", 1, paramBaseTransProcessor, new Object[0]);
    }
  }
  
  public TransFileControllerBusHelper getBusHelper()
  {
    return this.busHelper;
  }
  
  public BaseTransProcessor getC2CDownProcessor(TransferRequest paramTransferRequest)
  {
    if ((paramTransferRequest.mFileType != 2) && (paramTransferRequest.mFileType != 32) && (paramTransferRequest.mFileType != 33) && (paramTransferRequest.mFileType != 327696))
    {
      if ((paramTransferRequest.mFileType != 6) && (paramTransferRequest.mFileType != 7) && (paramTransferRequest.mFileType != 17) && (paramTransferRequest.mFileType != 18) && (paramTransferRequest.mFileType != 9) && (paramTransferRequest.mFileType != 16))
      {
        if ((paramTransferRequest.mFileType != 1) && (paramTransferRequest.mFileType != 65537) && (paramTransferRequest.mFileType != 131075))
        {
          if (paramTransferRequest.mFileType == 131079) {
            return new StructLongMessageDownloadProcessor(this, paramTransferRequest);
          }
          return null;
        }
        return ((IPicFactory)QRoute.api(IPicFactory.class)).getProcessor(this, paramTransferRequest);
      }
      return new ShortVideoDownloadProcessor(this, paramTransferRequest);
    }
    return ((IPttTransProcessorHelper)QRoute.api(IPttTransProcessorHelper.class)).createPttTransProcessor(this, paramTransferRequest);
  }
  
  public BaseTransProcessor getC2CProcessor(TransferRequest paramTransferRequest)
  {
    if (paramTransferRequest.mIsUp) {
      return getC2CUpProcessor(paramTransferRequest);
    }
    return getC2CDownProcessor(paramTransferRequest);
  }
  
  public BaseTransProcessor getC2CUpProcessor(TransferRequest paramTransferRequest)
  {
    if ((paramTransferRequest.mFileType != 2) && (paramTransferRequest.mFileType != 32) && (paramTransferRequest.mFileType != 327696))
    {
      if ((paramTransferRequest.mFileType != 6) && (paramTransferRequest.mFileType != 17) && (paramTransferRequest.mFileType != 9))
      {
        if (nearByFileType.contains(Integer.valueOf(paramTransferRequest.mFileType))) {
          return new NearbyPeoplePhotoUploadProcessor(this, paramTransferRequest);
        }
        if (paramTransferRequest.mFileType == 20) {
          return ((IShortVideoFactory)QRoute.api(IShortVideoFactory.class)).getProcessor(this, paramTransferRequest);
        }
        if (paramTransferRequest.mFileType == 24) {
          return new BDHCommonUploadProcessor(this, paramTransferRequest);
        }
        if ((paramTransferRequest.mFileType != 196609) && (paramTransferRequest.mFileType != 196610) && (paramTransferRequest.mFileType != 327681))
        {
          if (paramTransferRequest.mBusiType == 1045) {
            return ((IPicFactory)QRoute.api(IPicFactory.class)).getProcessor(this, paramTransferRequest);
          }
          return ((IPicFactory)QRoute.api(IPicFactory.class)).getProcessor(this, paramTransferRequest);
        }
        return new StoryUploadProcessor(this, paramTransferRequest);
      }
      return ((IShortVideoFactory)QRoute.api(IShortVideoFactory.class)).getProcessor(this, paramTransferRequest);
    }
    return ((IPttTransProcessorHelper)QRoute.api(IPttTransProcessorHelper.class)).createPttTransProcessor(this, paramTransferRequest);
  }
  
  public BaseTransProcessor getHotChatProcessor(TransferRequest paramTransferRequest)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getProcessor UIN_TYPE_HOTCHAT_TOPIC  isUp = ");
      localStringBuilder.append(paramTransferRequest.mIsUp);
      QLog.i("PttShow", 2, localStringBuilder.toString());
    }
    if (paramTransferRequest.mFileType == 2) {
      return ((IPttTransProcessorHelper)QRoute.api(IPttTransProcessorHelper.class)).createPttTransProcessor(this, paramTransferRequest);
    }
    return null;
  }
  
  public BaseTransProcessor getProcessor(TransferRequest paramTransferRequest)
  {
    if (paramTransferRequest == null) {
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.richmedia.TransFileController", 2, paramTransferRequest.toString());
    }
    if (paramTransferRequest.mFileType == 131078)
    {
      if (paramTransferRequest.mIsUp) {
        return new MultiMsgUpProcessor(this, paramTransferRequest);
      }
      return new MultiMsgDownloadProcessor(this, paramTransferRequest);
    }
    if (paramTransferRequest.mFileType == 262153)
    {
      if (paramTransferRequest.mIsUp) {
        return ((IScribblePicUploadProcessor)QRoute.api(IScribblePicUploadProcessor.class)).createProcessor(this, paramTransferRequest);
      }
      return ((IScribblePicDownloadProcessor)QRoute.api(IScribblePicDownloadProcessor.class)).createProcessor(this, paramTransferRequest);
    }
    if (paramTransferRequest.mFileType == 66) {
      return new ShareToWXUploadProcessor(this, paramTransferRequest);
    }
    if ((paramTransferRequest.mFileType == 52) && (paramTransferRequest.mIsUp)) {
      return new ForwardSdkShareProcessor(this, paramTransferRequest);
    }
    if (paramTransferRequest.mUinType == 1026) {
      return getHotChatProcessor(paramTransferRequest);
    }
    if ((paramTransferRequest.mUinType != 1) && (paramTransferRequest.mUinType != 3000)) {
      return getC2CProcessor(paramTransferRequest);
    }
    return getTroopProcessor(paramTransferRequest);
  }
  
  public BaseTransProcessor getTroopProcessor(TransferRequest paramTransferRequest)
  {
    if (paramTransferRequest.mIsUp)
    {
      if ((paramTransferRequest.mFileType != 6) && (paramTransferRequest.mFileType != 17) && (paramTransferRequest.mFileType != 9))
      {
        if (paramTransferRequest.mFileType == 20) {
          return ((IShortVideoFactory)QRoute.api(IShortVideoFactory.class)).getProcessor(this, paramTransferRequest);
        }
        if (paramTransferRequest.mFileType == 55) {
          return ((IPicFactory)QRoute.api(IPicFactory.class)).getProcessor(this, paramTransferRequest);
        }
        if (paramTransferRequest.mBusiType == 1045) {
          return ((IPicFactory)QRoute.api(IPicFactory.class)).getProcessor(this, paramTransferRequest);
        }
        if (paramTransferRequest.mFileType == 2) {
          return ((IPttTransProcessorHelper)QRoute.api(IPttTransProcessorHelper.class)).createPttTransProcessor(this, paramTransferRequest);
        }
        return ((IPicFactory)QRoute.api(IPicFactory.class)).getProcessor(this, paramTransferRequest);
      }
      return ((IShortVideoFactory)QRoute.api(IShortVideoFactory.class)).getProcessor(this, paramTransferRequest);
    }
    if ((paramTransferRequest.mFileType != 2) && (paramTransferRequest.mFileType != 327696))
    {
      if ((paramTransferRequest.mFileType != 1) && (paramTransferRequest.mFileType != 65537) && (paramTransferRequest.mFileType != 131075))
      {
        if ((paramTransferRequest.mFileType != 6) && (paramTransferRequest.mFileType != 7) && (paramTransferRequest.mFileType != 17) && (paramTransferRequest.mFileType != 18) && (paramTransferRequest.mFileType != 9) && (paramTransferRequest.mFileType != 16)) {
          return null;
        }
        return new ShortVideoDownloadProcessor(this, paramTransferRequest);
      }
      return ((IPicFactory)QRoute.api(IPicFactory.class)).getProcessor(this, paramTransferRequest);
    }
    return ((IPttTransProcessorHelper)QRoute.api(IPttTransProcessorHelper.class)).createPttTransProcessor(this, paramTransferRequest);
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("construct transfilecontroller:");
      localStringBuilder.append(this);
      QLog.d("Q.richmedia.TransFileController", 2, localStringBuilder.toString());
    }
    this.app = ((AppInterface)paramAppRuntime);
    this.mHandler = new BaseTransFileController.ProcHandler(this, ThreadManager.getSubThreadLooper());
    ThreadManager.executeOnSubThread(new TransFileControllerImpl.1(this));
    this.busHelper = new TransFileControllerBusHelper(this.app);
  }
  
  public void onDestroy()
  {
    if (this.mWorking.get())
    {
      long l = System.currentTimeMillis();
      synchronized (this.mWorking)
      {
        this.mWorking.set(false);
        Object localObject2 = (IHttpEngineService)this.app.getRuntimeService(IHttpEngineService.class, "all");
        if (localObject2 != null)
        {
          localObject2 = ((IHttpEngineService)localObject2).getCommunicator();
          if (localObject2 != null) {
            ((HttpCommunicator)localObject2).close();
          }
        }
        stopCurrentWork();
        if (QLog.isColorLevel())
        {
          ??? = new StringBuilder();
          ((StringBuilder)???).append("destroy transfilecontroller:");
          ((StringBuilder)???).append(this);
          ((StringBuilder)???).append(" elapsed:");
          ((StringBuilder)???).append(System.currentTimeMillis() - l);
          QLog.d("Q.richmedia.TransFileController", 2, ((StringBuilder)???).toString());
          return;
        }
      }
    }
  }
  
  /* Error */
  public void removeProcessorByPeerUin(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_0
    //   2: getfield 322	com/tencent/mobileqq/transfile/api/impl/TransFileControllerImpl:processorMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   5: invokevirtual 326	com/tencent/mobileqq/transfile/api/impl/TransFileControllerImpl:getKeySetClone	(Ljava/util/concurrent/ConcurrentHashMap;)Ljava/util/Set;
    //   8: invokeinterface 332 1 0
    //   13: astore_3
    //   14: aload_3
    //   15: invokeinterface 337 1 0
    //   20: ifeq +87 -> 107
    //   23: aload_3
    //   24: invokeinterface 341 1 0
    //   29: checkcast 343	java/lang/String
    //   32: astore 4
    //   34: aload_0
    //   35: getfield 322	com/tencent/mobileqq/transfile/api/impl/TransFileControllerImpl:processorMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   38: aload 4
    //   40: invokevirtual 348	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   43: checkcast 350	com/tencent/mobileqq/utils/httputils/IHttpCommunicatorListener
    //   46: astore 5
    //   48: iload_2
    //   49: ifeq +11 -> 60
    //   52: iload_2
    //   53: iconst_1
    //   54: if_icmpeq -40 -> 14
    //   57: goto -43 -> 14
    //   60: aload 5
    //   62: instanceof 352
    //   65: ifeq -51 -> 14
    //   68: aload_1
    //   69: aload 5
    //   71: checkcast 352	com/tencent/mobileqq/transfile/BuddyTransfileProcessor
    //   74: getfield 356	com/tencent/mobileqq/transfile/BuddyTransfileProcessor:file	Lcom/tencent/mobileqq/transfile/FileMsg;
    //   77: getfield 361	com/tencent/mobileqq/transfile/FileMsg:mUin	Ljava/lang/String;
    //   80: invokevirtual 364	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   83: ifeq -69 -> 14
    //   86: aload 5
    //   88: checkcast 55	com/tencent/mobileqq/transfile/BaseTransProcessor
    //   91: invokevirtual 367	com/tencent/mobileqq/transfile/BaseTransProcessor:stop	()V
    //   94: aload_0
    //   95: getfield 322	com/tencent/mobileqq/transfile/api/impl/TransFileControllerImpl:processorMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   98: aload 4
    //   100: invokevirtual 370	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   103: pop
    //   104: goto -90 -> 14
    //   107: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	108	0	this	TransFileControllerImpl
    //   0	108	1	paramString	String
    //   0	108	2	paramInt	int
    //   13	11	3	localIterator	java.util.Iterator
    //   32	67	4	str	String
    //   46	41	5	localIHttpCommunicatorListener	com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.api.impl.TransFileControllerImpl
 * JD-Core Version:    0.7.0.1
 */