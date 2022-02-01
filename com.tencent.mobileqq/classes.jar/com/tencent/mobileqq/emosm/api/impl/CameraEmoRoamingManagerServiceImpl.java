package com.tencent.mobileqq.emosm.api.impl;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.richmedia.Size;
import com.tencent.mobileqq.app.CameraEmoRoamingHandler;
import com.tencent.mobileqq.app.CameraEmoRoamingObserver;
import com.tencent.mobileqq.app.CustomEmoRoamingBaseHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.core.util.EmotionSharedPreUtils;
import com.tencent.mobileqq.data.CameraEmotionData;
import com.tencent.mobileqq.emosm.CustomEmotionRoamingDBManagerBase;
import com.tencent.mobileqq.emosm.CustomEmotionRoamingManagerBase;
import com.tencent.mobileqq.emosm.api.ICameraEmoRoamingManagerService;
import com.tencent.mobileqq.emosm.api.ICameraEmoRoamingManagerService.ICameraEmoAddCallBack;
import com.tencent.mobileqq.emosm.api.ICameraEmotionRoamingDBManagerService;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.CommFileExtReq;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.transfile.BDHCommonUploadProcessor;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.util.SharePreferenceUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppRuntime;

public class CameraEmoRoamingManagerServiceImpl
  extends CustomEmotionRoamingManagerBase<CameraEmotionData>
  implements ICameraEmoRoamingManagerService
{
  public static final String TAG = "CameraEmoRoamingManager";
  private CameraEmoRoamingObserver emoRoamingObserver = new CameraEmoRoamingManagerServiceImpl.1(this);
  private volatile boolean hasReadVersion = false;
  volatile String isNeedShowGuide = null;
  private volatile String listVersion = "";
  HashMap<CameraEmotionData, ICameraEmoRoamingManagerService.ICameraEmoAddCallBack> mAddCallBackMap = new HashMap();
  
  public void asyncIncreaseEmotionClickNum(CameraEmotionData paramCameraEmotionData)
  {
    paramCameraEmotionData.increaseClickNum();
    getDBManager().updateCustomEmotion(paramCameraEmotionData);
  }
  
  protected CustomEmotionRoamingDBManagerBase<CameraEmotionData> getDBManager()
  {
    return (CameraEmotionRoamingDBManagerServiceImpl)this.mApp.getRuntimeService(ICameraEmotionRoamingDBManagerService.class);
  }
  
  public long getFileLength(String paramString)
  {
    try
    {
      paramString = new File(paramString);
      if (paramString.exists())
      {
        long l = paramString.length();
        return l;
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return 0L;
  }
  
  public Size getImageSize(String paramString)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    int j = 0;
    int i;
    try
    {
      BitmapFactory.decodeFile(paramString, localOptions);
      i = localOptions.outHeight;
      try
      {
        int k = localOptions.outWidth;
        j = k;
      }
      catch (Exception paramString) {}
      QLog.e("CameraEmoRoamingManager", 1, "getImageSize has exception", paramString);
    }
    catch (Exception paramString)
    {
      i = 0;
    }
    return new Size(j, i);
  }
  
  public boolean getIsNeedShowGuide()
  {
    if ((this.isNeedShowGuide == null) && (this.mApp != null))
    {
      Context localContext = this.mApp.getApp().getApplicationContext();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.mApp.getCurrentUin());
      localStringBuilder.append("camera_emo_guide_tag");
      this.isNeedShowGuide = SharePreferenceUtils.a(localContext, localStringBuilder.toString());
      if (this.isNeedShowGuide == null) {
        this.isNeedShowGuide = "";
      }
    }
    return ((StringUtil.isEmpty(this.isNeedShowGuide)) || (((Boolean)EmotionSharedPreUtils.b("camera_emo_guide_again_tag", Boolean.valueOf(true))).booleanValue())) && (isShowCameraEmoInApp());
  }
  
  public String getListVersion()
  {
    if (!this.hasReadVersion)
    {
      Context localContext = this.mApp.getApp().getApplicationContext();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.mApp.getCurrentUin());
      localStringBuilder.append("camera_emo_list_version");
      this.listVersion = SharePreferenceUtils.a(localContext, localStringBuilder.toString());
      this.hasReadVersion = true;
    }
    return this.listVersion;
  }
  
  protected CustomEmoRoamingBaseHandler<CameraEmotionData> getRoamingHandler()
  {
    return (CameraEmoRoamingHandler)this.mApp.getBusinessHandler(CameraEmoRoamingHandler.a);
  }
  
  public int getUploadProcessorID()
  {
    return 70;
  }
  
  public boolean isShowCameraEmoInApp()
  {
    return Build.VERSION.SDK_INT >= 21;
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    super.onCreate(paramAppRuntime);
    this.mApp.addObserver(this.emoRoamingObserver);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if ((this.emoRoamingObserver != null) && (this.mApp != null)) {
      this.mApp.removeObserver(this.emoRoamingObserver);
    }
    Iterator localIterator = this.mAddCallBackMap.entrySet().iterator();
    while (localIterator.hasNext()) {
      onUploadCameraEmoCallBack(15, (CameraEmotionData)((Map.Entry)localIterator.next()).getKey());
    }
    this.mAddCallBackMap.clear();
    this.mApp = null;
  }
  
  public void onUploadCameraEmoCallBack(int paramInt, CameraEmotionData paramCameraEmotionData)
  {
    ICameraEmoRoamingManagerService.ICameraEmoAddCallBack localICameraEmoAddCallBack = (ICameraEmoRoamingManagerService.ICameraEmoAddCallBack)this.mAddCallBackMap.get(paramCameraEmotionData);
    if (localICameraEmoAddCallBack != null)
    {
      localICameraEmoAddCallBack.a(paramInt, paramCameraEmotionData);
      this.mAddCallBackMap.remove(paramCameraEmotionData);
    }
  }
  
  public void realUploadCustomEmoticon(CameraEmotionData paramCameraEmotionData)
  {
    if (this.mApp == null)
    {
      QLog.d("CameraEmoRoamingManager", 1, "realUploadCustomEmoticon start, app is null");
      onUploadCameraEmoCallBack(100, paramCameraEmotionData);
      return;
    }
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      QLog.d("CameraEmoRoamingManager", 1, "realUploadCustomEmoticon start, net not support");
      onUploadCameraEmoCallBack(12, paramCameraEmotionData);
      return;
    }
    QLog.d("CameraEmoRoamingManager", 1, "realUploadCustomEmoticon start");
    TransferRequest localTransferRequest = new TransferRequest();
    localTransferRequest.mFileType = 24;
    localTransferRequest.mCommandId = 70;
    localTransferRequest.mRichTag = "camera_emo_upload";
    localTransferRequest.mSelfUin = this.uin;
    localTransferRequest.mPeerUin = this.uin;
    localTransferRequest.mIsUp = true;
    localTransferRequest.mUniseq = paramCameraEmotionData.emoId;
    localTransferRequest.mLocalPath = paramCameraEmotionData.emoPath;
    Bdh_extinfo.CommFileExtReq localCommFileExtReq = new Bdh_extinfo.CommFileExtReq();
    localCommFileExtReq.uint32_action_type.set(0);
    localCommFileExtReq.bytes_uuid.set(ByteStringMicro.copyFrom(paramCameraEmotionData.resid.getBytes()));
    localTransferRequest.mExtentionInfo = localCommFileExtReq.toByteArray();
    paramCameraEmotionData = new CameraEmoRoamingManagerServiceImpl.3(this, ThreadManagerV2.getSubThreadLooper(), paramCameraEmotionData);
    paramCameraEmotionData.addFilter(new Class[] { BDHCommonUploadProcessor.class });
    ((ITransFileController)this.mApp.getRuntimeService(ITransFileController.class)).addHandle(paramCameraEmotionData);
    ((ITransFileController)this.mApp.getRuntimeService(ITransFileController.class)).transferAsync(localTransferRequest);
  }
  
  public void setIsNeedShowGuide(boolean paramBoolean)
  {
    if (paramBoolean) {
      localObject = "";
    } else {
      localObject = "has_value";
    }
    this.isNeedShowGuide = ((String)localObject);
    Object localObject = this.mApp.getApp().getApplicationContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.mApp.getCurrentUin());
    localStringBuilder.append("camera_emo_guide_tag");
    SharePreferenceUtils.a((Context)localObject, localStringBuilder.toString(), this.isNeedShowGuide);
    EmotionSharedPreUtils.a("camera_emo_guide_again_tag", Boolean.valueOf(paramBoolean));
  }
  
  public void syncIncreaseEmoticonExposeNum(CameraEmotionData paramCameraEmotionData)
  {
    paramCameraEmotionData.increaseExposeNum();
    getDBManager().updateCustomEmotion(paramCameraEmotionData);
  }
  
  public void syncLocalDel()
  {
    if (this.mApp == null) {
      return;
    }
    CameraEmoRoamingHandler localCameraEmoRoamingHandler = (CameraEmoRoamingHandler)this.mApp.getBusinessHandler(CameraEmoRoamingHandler.a);
    if (localCameraEmoRoamingHandler == null) {
      return;
    }
    ThreadManager.post(new CameraEmoRoamingManagerServiceImpl.2(this, (ICameraEmotionRoamingDBManagerService)this.mApp.getRuntimeService(ICameraEmotionRoamingDBManagerService.class), localCameraEmoRoamingHandler), 5, null, true);
  }
  
  public void updateListVersion(String paramString)
  {
    if (paramString == null) {
      return;
    }
    Context localContext = this.mApp.getApp().getApplicationContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.mApp.getCurrentUin());
    localStringBuilder.append("camera_emo_list_version");
    SharePreferenceUtils.a(localContext, localStringBuilder.toString(), paramString);
    this.listVersion = paramString;
  }
  
  public void uploadCameraEmo(CameraEmotionData paramCameraEmotionData, ICameraEmoRoamingManagerService.ICameraEmoAddCallBack paramICameraEmoAddCallBack)
  {
    if (StringUtil.isEmpty(paramCameraEmotionData.emoPath))
    {
      QLog.d("CameraEmoRoamingManager", 1, "uploadCameraEmo error, path is null");
      paramICameraEmoAddCallBack.a(10, paramCameraEmotionData);
      return;
    }
    if (this.mApp == null)
    {
      QLog.d("CameraEmoRoamingManager", 1, "uploadCameraEmo, app is null");
      paramICameraEmoAddCallBack.a(100, paramCameraEmotionData);
      return;
    }
    long l = getFileLength(paramCameraEmotionData.emoPath);
    Size localSize = getImageSize(paramCameraEmotionData.emoPath);
    if ((!StringUtil.isEmpty(paramCameraEmotionData.md5)) && (l != 0L) && (localSize.b() != 0) && (localSize.a() != 0))
    {
      QLog.d("CameraEmoRoamingManager", 1, "uploadCameraEmo start");
      this.mAddCallBackMap.put(paramCameraEmotionData, paramICameraEmoAddCallBack);
      ((CameraEmoRoamingHandler)this.mApp.getBusinessHandler(CameraEmoRoamingHandler.a)).a(paramCameraEmotionData, localSize.a(), localSize.b(), l);
      return;
    }
    QLog.d("CameraEmoRoamingManager", 1, new Object[] { "uploadCameraEmo params error, md5:", paramCameraEmotionData.md5, " size:", Long.valueOf(l), " width:", Integer.valueOf(localSize.a()), " height:", Integer.valueOf(localSize.b()) });
    paramICameraEmoAddCallBack.a(14, paramCameraEmotionData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.api.impl.CameraEmoRoamingManagerServiceImpl
 * JD-Core Version:    0.7.0.1
 */