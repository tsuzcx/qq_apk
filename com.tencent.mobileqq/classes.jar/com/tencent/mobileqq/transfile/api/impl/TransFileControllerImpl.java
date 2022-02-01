package com.tencent.mobileqq.transfile.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.transfile.BDHCommonUploadProcessor;
import com.tencent.mobileqq.transfile.BaseTransFileController;
import com.tencent.mobileqq.transfile.BaseTransFileController.ProcHandler;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.BuddyTransfileProcessor;
import com.tencent.mobileqq.transfile.C2CPicDownloadProcessor;
import com.tencent.mobileqq.transfile.C2CPicUploadProcessor;
import com.tencent.mobileqq.transfile.C2CPttDownloadProcessor;
import com.tencent.mobileqq.transfile.C2CPttUploadProcessor;
import com.tencent.mobileqq.transfile.C2CQzonePicUploadProcessor;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.ForwardSdkShareProcessor;
import com.tencent.mobileqq.transfile.GroupPicDownloadProcessor;
import com.tencent.mobileqq.transfile.GroupPicUploadProcessor;
import com.tencent.mobileqq.transfile.GroupPttDownloadProcessor;
import com.tencent.mobileqq.transfile.GroupPttUploadProcessor;
import com.tencent.mobileqq.transfile.GroupQzonePicUploadProcessor;
import com.tencent.mobileqq.transfile.HttpCommunicator;
import com.tencent.mobileqq.transfile.JSPttDownloadProcessor;
import com.tencent.mobileqq.transfile.JSPttUploadProcessor;
import com.tencent.mobileqq.transfile.MultiMsgDownloadProcessor;
import com.tencent.mobileqq.transfile.MultiMsgUpProcessor;
import com.tencent.mobileqq.transfile.NearbyPeoplePhotoUploadProcessor;
import com.tencent.mobileqq.transfile.PAAudioPttDownloadProcessor;
import com.tencent.mobileqq.transfile.PttSliceUploadProcessor;
import com.tencent.mobileqq.transfile.ScribblePicDownloadProcessor;
import com.tencent.mobileqq.transfile.ScribblePicUploadProcessor;
import com.tencent.mobileqq.transfile.ShareToWXUploadProcessor;
import com.tencent.mobileqq.transfile.ShortVideoDownloadProcessor;
import com.tencent.mobileqq.transfile.ShortVideoForwardProcessor;
import com.tencent.mobileqq.transfile.ShortVideoUploadProcessor;
import com.tencent.mobileqq.transfile.StoryUploadProcessor;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.TroopEffectsPicUploadProcessor;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.transfile.api.TransFileControllerBusHelper;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
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
  
  public void fillTransRequestMessage(BaseTransProcessor paramBaseTransProcessor)
  {
    try
    {
      TransferRequest localTransferRequest = paramBaseTransProcessor.getTransferRequest();
      if ((localTransferRequest != null) && (localTransferRequest.mUniseq != 0L) && (localTransferRequest.mRec == null) && ((paramBaseTransProcessor.app instanceof QQAppInterface))) {
        localTransferRequest.mRec = ((QQAppInterface)paramBaseTransProcessor.app).getMessageFacade().b(localTransferRequest.mPeerUin, localTransferRequest.mUinType, localTransferRequest.mUniseq);
      }
      return;
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
    if (paramTransferRequest.mFileType == 2) {
      return new C2CPttDownloadProcessor(this, paramTransferRequest);
    }
    if (paramTransferRequest.mFileType == 32) {
      return new JSPttDownloadProcessor(this, paramTransferRequest);
    }
    if (paramTransferRequest.mFileType == 33) {
      return new PAAudioPttDownloadProcessor(this, paramTransferRequest);
    }
    if ((paramTransferRequest.mFileType == 6) || (paramTransferRequest.mFileType == 7) || (paramTransferRequest.mFileType == 17) || (paramTransferRequest.mFileType == 18) || (paramTransferRequest.mFileType == 9) || (paramTransferRequest.mFileType == 16)) {
      return new ShortVideoDownloadProcessor(this, paramTransferRequest);
    }
    if ((paramTransferRequest.mFileType == 1) || (paramTransferRequest.mFileType == 65537) || (paramTransferRequest.mFileType == 131075)) {
      return new C2CPicDownloadProcessor(this, paramTransferRequest);
    }
    if (paramTransferRequest.mFileType == 131079) {
      return new StructLongMessageDownloadProcessor(this, paramTransferRequest);
    }
    return null;
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
    if (paramTransferRequest.mFileType == 2) {
      return new C2CPttUploadProcessor(this, paramTransferRequest);
    }
    if (paramTransferRequest.mFileType == 32) {
      return new JSPttUploadProcessor(this, paramTransferRequest);
    }
    if ((paramTransferRequest.mFileType == 6) || (paramTransferRequest.mFileType == 17) || (paramTransferRequest.mFileType == 9)) {
      return new ShortVideoUploadProcessor(this, paramTransferRequest);
    }
    if (nearByFileType.contains(Integer.valueOf(paramTransferRequest.mFileType))) {
      return new NearbyPeoplePhotoUploadProcessor(this, paramTransferRequest);
    }
    if (paramTransferRequest.mFileType == 20) {
      return new ShortVideoForwardProcessor(this, paramTransferRequest);
    }
    if (paramTransferRequest.mFileType == 24) {
      return new BDHCommonUploadProcessor(this, paramTransferRequest);
    }
    if ((paramTransferRequest.mFileType == 196609) || (paramTransferRequest.mFileType == 196610) || (paramTransferRequest.mFileType == 327681)) {
      return new StoryUploadProcessor(this, paramTransferRequest);
    }
    if (paramTransferRequest.mBusiType == 1045) {
      return new C2CQzonePicUploadProcessor(this, paramTransferRequest);
    }
    return new C2CPicUploadProcessor(this, paramTransferRequest);
  }
  
  public BaseTransProcessor getHotChatProcessor(TransferRequest paramTransferRequest)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PttShow", 2, "getProcessor UIN_TYPE_HOTCHAT_TOPIC  isUp = " + paramTransferRequest.mIsUp);
    }
    if (paramTransferRequest.mIsUp) {
      return new GroupPicUploadProcessor(this, paramTransferRequest);
    }
    if (paramTransferRequest.mFileType == 2) {
      return new GroupPttDownloadProcessor(this, paramTransferRequest);
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
        return new ScribblePicUploadProcessor(this, paramTransferRequest);
      }
      return new ScribblePicDownloadProcessor(this, paramTransferRequest);
    }
    if (paramTransferRequest.mFileType == 327696) {
      return new PttSliceUploadProcessor(this, paramTransferRequest);
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
    if ((paramTransferRequest.mUinType == 1) || (paramTransferRequest.mUinType == 3000)) {
      return getTroopProcessor(paramTransferRequest);
    }
    return getC2CProcessor(paramTransferRequest);
  }
  
  public BaseTransProcessor getTroopProcessor(TransferRequest paramTransferRequest)
  {
    if (paramTransferRequest.mIsUp)
    {
      if ((paramTransferRequest.mFileType == 6) || (paramTransferRequest.mFileType == 17) || (paramTransferRequest.mFileType == 9)) {
        return new ShortVideoUploadProcessor(this, paramTransferRequest);
      }
      if (paramTransferRequest.mFileType == 20) {
        return new ShortVideoForwardProcessor(this, paramTransferRequest);
      }
      if (paramTransferRequest.mFileType == 55) {
        return new TroopEffectsPicUploadProcessor(this, paramTransferRequest);
      }
      if (paramTransferRequest.mBusiType == 1045) {
        return new GroupQzonePicUploadProcessor(this, paramTransferRequest);
      }
      if (paramTransferRequest.mFileType == 2) {
        return new GroupPttUploadProcessor(this, paramTransferRequest);
      }
      return new GroupPicUploadProcessor(this, paramTransferRequest);
    }
    if (paramTransferRequest.mFileType == 2) {
      return new GroupPttDownloadProcessor(this, paramTransferRequest);
    }
    if ((paramTransferRequest.mFileType == 1) || (paramTransferRequest.mFileType == 65537) || (paramTransferRequest.mFileType == 131075)) {
      return new GroupPicDownloadProcessor(this, paramTransferRequest);
    }
    if ((paramTransferRequest.mFileType == 6) || (paramTransferRequest.mFileType == 7) || (paramTransferRequest.mFileType == 17) || (paramTransferRequest.mFileType == 18) || (paramTransferRequest.mFileType == 9) || (paramTransferRequest.mFileType == 16)) {
      return new ShortVideoDownloadProcessor(this, paramTransferRequest);
    }
    return null;
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.richmedia.TransFileController", 2, "construct transfilecontroller:" + this);
    }
    this.app = ((AppInterface)paramAppRuntime);
    this.mHandler = new BaseTransFileController.ProcHandler(this, ThreadManager.getSubThreadLooper());
    ThreadManager.executeOnSubThread(new TransFileControllerImpl.1(this));
    this.busHelper = new TransFileControllerBusHelper(this.app);
  }
  
  public void onDestroy()
  {
    long l;
    if (this.mWorking.get()) {
      l = System.currentTimeMillis();
    }
    synchronized (this.mWorking)
    {
      this.mWorking.set(false);
      Object localObject1 = (IHttpEngineService)this.app.getRuntimeService(IHttpEngineService.class, "all");
      if (localObject1 != null)
      {
        localObject1 = ((IHttpEngineService)localObject1).getCommunicator();
        if (localObject1 != null) {
          ((HttpCommunicator)localObject1).close();
        }
      }
      stopCurrentWork();
      this.app = null;
      if (QLog.isColorLevel()) {
        QLog.d("Q.richmedia.TransFileController", 2, "destroy transfilecontroller:" + this + " elapsed:" + (System.currentTimeMillis() - l));
      }
      return;
    }
  }
  
  public void removeProcessorByPeerUin(String paramString, int paramInt)
  {
    Iterator localIterator = getKeySetClone(this.processorMap).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      IHttpCommunicatorListener localIHttpCommunicatorListener = (IHttpCommunicatorListener)this.processorMap.get(str);
      switch (paramInt)
      {
      case 1: 
      case 2: 
      default: 
        break;
      case 0: 
        if (((localIHttpCommunicatorListener instanceof BuddyTransfileProcessor)) && (paramString.equals(((BuddyTransfileProcessor)localIHttpCommunicatorListener).file.mUin)))
        {
          ((BaseTransProcessor)localIHttpCommunicatorListener).stop();
          this.processorMap.remove(str);
        }
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.api.impl.TransFileControllerImpl
 * JD-Core Version:    0.7.0.1
 */