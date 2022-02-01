package com.tencent.mobileqq.shortvideo.mediadevice;

import android.hardware.Camera;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.aelight.camera.api.ICameraCompatible;
import com.tencent.aelight.camera.constants.CameraCompatibleConstants;
import com.tencent.maxvideo.common.AVIOStruct;
import com.tencent.maxvideo.common.ControlFlagEnum;
import com.tencent.maxvideo.mediadevice.AVCodec;
import com.tencent.mobileqq.editor.composite.CodecParam;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.hwcodec.SVHwEncoder;
import com.tencent.mobileqq.shortvideo.hwcodec.SVHwEncoder.HwFrame;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class PreviewContext
{
  public static final boolean SG_SUPPORT_CALLBACK = true;
  private static final String TAG = "PreviewContext";
  public static final boolean USE_USER_BUFFER = true;
  private static final int sCheckSizeLimt = 32;
  int fps = 0;
  int frameCount = 0;
  AVCodec mAVCodec = null;
  public boolean mActivtiyDestory = false;
  int mBlockIndex = 0;
  public CameraProxy mCamera;
  private boolean mCheckedDataValid = false;
  private boolean mDisablePrivilage = false;
  public AtomicReference<SVHwEncoder> mEncodeRef = new AtomicReference(null);
  ArrayList<Integer> mFrameCountArray = new ArrayList();
  private int mFrameIndex = 0;
  private volatile boolean mFrameProcessEnd = false;
  List<AVIOStruct> mFrameSrcList = new ArrayList();
  private boolean mInitHwEncode = false;
  int mLastFrameIndex = 0;
  public Handler mMsghandler = null;
  public boolean mPTVRealBeauty = false;
  private AVIOStruct mPTVRealBeautyCache = new AVIOStruct();
  private int mRecordToCache = 0;
  private long[] mTimeStamp = new long[1];
  public AtomicInteger mVideoFrameProcess = new AtomicInteger(0);
  public AtomicInteger mVideoFrameWrite = new AtomicInteger(0);
  int mWriteFrameCount = 0;
  private Object mlock = new Object();
  Object mlockFrame = new Object();
  public boolean notifyFirstFrame = false;
  long updateTime = 0L;
  
  public PreviewContext(CameraProxy paramCameraProxy, int paramInt1, int paramInt2)
  {
    this.mCamera = paramCameraProxy;
    paramCameraProxy.jdField_b_of_type_Int = paramInt1;
    paramCameraProxy.c = paramInt2;
    this.mInitHwEncode = initHwCallBackSecurity();
    this.mFrameProcessEnd = false;
    this.mVideoFrameWrite.getAndSet(0);
    this.mVideoFrameProcess.getAndSet(0);
    this.mCheckedDataValid = false;
    this.mDisablePrivilage = false;
  }
  
  public static boolean checkIsDisablePrivilage(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte == null) {
      return true;
    }
    if (paramArrayOfByte.length < paramInt) {
      return true;
    }
    int j = 0;
    int i = 0;
    while (j < paramInt)
    {
      i += (paramArrayOfByte[j] & 0xFF);
      j += 1;
    }
    paramInt = paramArrayOfByte.length - paramInt;
    while (paramInt < paramArrayOfByte.length)
    {
      i += (paramArrayOfByte[paramInt] & 0xFF);
      paramInt += 1;
    }
    return i == 0;
  }
  
  private boolean checkPreviewDataLength(AVIOStruct paramAVIOStruct, byte[] paramArrayOfByte)
  {
    int i = paramAVIOStruct.vHeight;
    int j = paramAVIOStruct.vWidth;
    int k = paramAVIOStruct.vFormat;
    if (QLog.isColorLevel())
    {
      paramAVIOStruct = new StringBuilder();
      paramAVIOStruct.append("[@] checkPreviewDataLength,height = ");
      paramAVIOStruct.append(i);
      paramAVIOStruct.append(",width = ");
      paramAVIOStruct.append(j);
      paramAVIOStruct.append(",imgFmt = ");
      paramAVIOStruct.append(k);
      paramAVIOStruct.append(",data.length = ");
      paramAVIOStruct.append(paramArrayOfByte.length);
      paramAVIOStruct.append(" Build.MODEL=");
      paramAVIOStruct.append(Build.MODEL);
      paramAVIOStruct.append(" Build.CPU_ABI=");
      paramAVIOStruct.append(Build.CPU_ABI);
      QLog.d("PreviewContext", 2, paramAVIOStruct.toString());
    }
    boolean bool = true;
    if ((k != 4) && (k != 20))
    {
      if (k != 842094169)
      {
        if (k == 16) {
          break label264;
        }
        if (k != 17)
        {
          if (!QLog.isColorLevel()) {
            break label326;
          }
          paramAVIOStruct = new StringBuilder();
          paramAVIOStruct.append("[@] checkPreviewDataLength error 3,imgFmt  = ");
          paramAVIOStruct.append(k);
          QLog.d("PreviewContext", 2, paramAVIOStruct.toString());
          return true;
        }
      }
      if (j * i * 3 / 2 == paramArrayOfByte.length) {
        break label323;
      }
      if (!QLog.isColorLevel()) {
        break label326;
      }
      paramAVIOStruct = new StringBuilder();
      paramAVIOStruct.append("[@] checkPreviewDataLength error 2 [Build.MODEL=");
      paramAVIOStruct.append(Build.MODEL);
      paramAVIOStruct.append("]");
      QLog.d("PreviewContext", 2, paramAVIOStruct.toString());
      return true;
    }
    label264:
    if (j * i * 2 != paramArrayOfByte.length)
    {
      if (QLog.isColorLevel())
      {
        paramAVIOStruct = new StringBuilder();
        paramAVIOStruct.append("[@] checkPreviewDataLength error 1 [Build.MODEL=");
        paramAVIOStruct.append(Build.MODEL);
        paramAVIOStruct.append("]");
        QLog.d("PreviewContext", 2, paramAVIOStruct.toString());
        return true;
      }
    }
    else {
      label323:
      bool = false;
    }
    label326:
    return bool;
  }
  
  private native int getProcessedFrameData(byte[] paramArrayOfByte, long[] paramArrayOfLong, int paramInt);
  
  private native boolean initHwCallBack();
  
  private boolean initHwCallBackSecurity()
  {
    try
    {
      boolean bool = initHwCallBack();
      return bool;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      localUnsatisfiedLinkError.printStackTrace();
    }
    return false;
  }
  
  public void addUserBufferRecycle(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {
      CameraControl.a().a(true, paramArrayOfByte);
    }
  }
  
  public void encodeOneFrameNotify()
  {
    Object localObject = (SVHwEncoder)this.mEncodeRef.get();
    SVHwEncoder.HwFrame localHwFrame;
    int j;
    if (localObject != null)
    {
      localHwFrame = ((SVHwEncoder)localObject).a();
      if (localHwFrame == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PreviewContext", 2, "[@] encodeOneFrameNotify frame is null");
        }
        return;
      }
      j = ((SVHwEncoder)localObject).jdField_a_of_type_Int;
    }
    try
    {
      i = getProcessedFrameData(localHwFrame.jdField_a_of_type_ArrayOfByte, this.mTimeStamp, j);
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      int i;
      label65:
      StringBuilder localStringBuilder;
      break label65;
    }
    i = -1001;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[@] HandleVideo: error=");
      localStringBuilder.append(i);
      localStringBuilder.append(" colorspace=");
      localStringBuilder.append(j);
      QLog.d("PreviewContext", 2, localStringBuilder.toString());
    }
    if (i == 0)
    {
      localHwFrame.jdField_a_of_type_Int = 0;
      localHwFrame.jdField_b_of_type_Int = localHwFrame.jdField_a_of_type_ArrayOfByte.length;
      localHwFrame.jdField_a_of_type_Long = this.mTimeStamp[0];
      localHwFrame.jdField_a_of_type_Boolean = false;
      localHwFrame.jdField_b_of_type_Boolean = true;
      ((SVHwEncoder)localObject).a(localHwFrame, true);
      return;
    }
    this.mEncodeRef.getAndSet(null);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[@] HandleVideo: error=");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(" set encode to null...");
      QLog.d("PreviewContext", 2, ((StringBuilder)localObject).toString());
      return;
      if (QLog.isColorLevel()) {
        QLog.d("PreviewContext", 2, "[@] HandleVideo: [encodeOneFrameNotify] encode=null");
      }
    }
  }
  
  public int getFrameIndex()
  {
    return this.mFrameIndex;
  }
  
  public void getPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    if (QLog.isColorLevel())
    {
      paramCamera = new StringBuilder();
      paramCamera.append("[@] onPreviewFrame start Build.MODEL=");
      paramCamera.append(Build.MODEL);
      paramCamera.append(", Build.CPU_ABI=");
      paramCamera.append(Build.CPU_ABI);
      paramCamera.append(", notifyFirstFrame=");
      paramCamera.append(this.notifyFirstFrame);
      QLog.i("PreviewContext", 2, paramCamera.toString());
    }
    if (this.updateTime == 0L)
    {
      this.updateTime = SystemClock.uptimeMillis();
      this.frameCount = 0;
    }
    else
    {
      this.frameCount += 1;
    }
    int i;
    if (this.frameCount == 100)
    {
      paramCamera = new StringBuilder();
      paramCamera.append("fps = ");
      i = (int)(this.frameCount * 1000 / (SystemClock.uptimeMillis() - this.updateTime));
      this.fps = i;
      paramCamera.append(i);
      QLog.d("PreviewContext", 2, paramCamera.toString());
      this.updateTime = 0L;
      this.frameCount = 0;
    }
    if (!this.mCheckedDataValid)
    {
      if (((ICameraCompatible)QRoute.api(ICameraCompatible.class)).isFoundProductFeature(CameraCompatibleConstants.p)) {
        this.mDisablePrivilage = checkIsDisablePrivilage(paramArrayOfByte, 32);
      } else {
        this.mDisablePrivilage = false;
      }
      this.mCheckedDataValid = true;
      if (this.mDisablePrivilage) {
        this.mCamera.a.a(12, new Object[] { "camera disabled zero data." });
      }
    }
    else if (this.mDisablePrivilage)
    {
      return;
    }
    if (paramArrayOfByte == null)
    {
      CameraControl.a().a(true);
      return;
    }
    this.mRecordToCache = 0;
    if (!this.mPTVRealBeauty) {
      sendFirstFrameMsg();
    }
    Object localObject = null;
    paramCamera = (Camera)localObject;
    if (!this.mFrameSrcList.isEmpty()) {}
    try
    {
      paramCamera = (AVIOStruct)this.mFrameSrcList.get(this.mFrameSrcList.size() - 1);
      if (paramCamera != null) {
        if (Lock.jdField_a_of_type_Boolean)
        {
          if (paramCamera.pControlFlag == ControlFlagEnum.NONE.getValue())
          {
            localObject = CameraControl.a().a();
            i = CameraControl.a().a();
            paramCamera.vWidth = ((CameraControl.CustomSize)localObject).jdField_a_of_type_Int;
            paramCamera.vHeight = ((CameraControl.CustomSize)localObject).jdField_b_of_type_Int;
            paramCamera.vFormat = i;
            paramCamera.vOrientation = CameraControl.a().b();
            paramCamera.vFPS = CodecParam.VIDEO_FPS;
            paramCamera.pControlFlag = ControlFlagEnum.OPEN_FILE_AND_WRITE_FRAME_DATA.getValue();
            paramCamera.vBitrate = CodecParam.mDstVideoEncBitrate;
            paramCamera.pCodec = CodecParam.mCodecId;
          }
          else if (paramCamera.pControlFlag == ControlFlagEnum.OPEN_FILE_AND_WRITE_FRAME_DATA.getValue())
          {
            paramCamera.pControlFlag = ControlFlagEnum.WRITE_FRAME_DATA.getValue();
          }
        }
        else if (paramCamera.pControlFlag == ControlFlagEnum.WRITE_FRAME_DATA.getValue()) {
          paramCamera.pControlFlag = ControlFlagEnum.WRITE_FRAME_DATA_AND_CLOSE_FILE.getValue();
        } else if (paramCamera.pControlFlag == ControlFlagEnum.WRITE_FRAME_DATA_AND_CLOSE_FILE.getValue()) {
          paramCamera.pControlFlag = ControlFlagEnum.NONE.getValue();
        }
      }
      if ((paramCamera != null) && (paramCamera.isWriteFrame()))
      {
        boolean bool = checkPreviewDataLength(paramCamera, paramArrayOfByte);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("[@] onPreviewFrame PreviewDataLength error : ");
          ((StringBuilder)localObject).append(bool);
          ((StringBuilder)localObject).append(" Build.MODEL=");
          ((StringBuilder)localObject).append(Build.MODEL);
          ((StringBuilder)localObject).append(" Build.CPU_ABI=");
          ((StringBuilder)localObject).append(Build.CPU_ABI);
          QLog.d("PreviewContext", 2, ((StringBuilder)localObject).toString());
        }
        if (bool)
        {
          this.mCamera.a.a(8, new Object[] { "unacceptable camera preview data" });
          return;
        }
        i = this.mFrameIndex;
        this.mFrameIndex = (i + 1);
        paramCamera.pFrameIndex = i;
        paramCamera.vFrameTime = SystemClock.elapsedRealtime();
        this.mWriteFrameCount += 1;
        this.mRecordToCache = 1;
        if (!this.mPTVRealBeauty)
        {
          this.mVideoFrameWrite.incrementAndGet();
          this.mAVCodec.copyQQBuf(paramArrayOfByte, paramCamera);
          QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread", false).post(new PreviewContext.HandleVideo(this));
        }
      }
      if (this.mPTVRealBeauty)
      {
        localObject = Message.obtain(this.mMsghandler);
        ((Message)localObject).what = -16716526;
        i = this.mRecordToCache;
        ((Message)localObject).arg1 = i;
        ((Message)localObject).arg2 = 1;
        ((Message)localObject).obj = paramArrayOfByte;
        if (i == 1)
        {
          PreviewContext.VFrameData localVFrameData = new PreviewContext.VFrameData();
          localVFrameData.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
          localVFrameData.jdField_a_of_type_ComTencentMaxvideoCommonAVIOStruct = ((AVIOStruct)paramCamera.clone());
          ((Message)localObject).obj = localVFrameData;
        }
        else
        {
          if (QLog.isColorLevel())
          {
            paramCamera = new StringBuilder();
            paramCamera.append("[@] mPTVRealBeauty: [Build.MODEL=");
            paramCamera.append(Build.MODEL);
            paramCamera.append("]  mMsghandler=");
            paramCamera.append(this.mMsghandler);
            QLog.d("PreviewContext", 2, paramCamera.toString());
          }
          paramCamera = CameraControl.a().a();
          if (paramCamera == null) {
            return;
          }
          i = CameraControl.a().a();
          this.mPTVRealBeautyCache.vWidth = paramCamera.jdField_a_of_type_Int;
          this.mPTVRealBeautyCache.vHeight = paramCamera.jdField_b_of_type_Int;
          paramCamera = this.mPTVRealBeautyCache;
          paramCamera.vFormat = i;
          if (checkPreviewDataLength(paramCamera, paramArrayOfByte))
          {
            this.mCamera.a.a(8, new Object[] { "unacceptable camera preview data" });
            return;
          }
        }
        paramArrayOfByte = this.mMsghandler;
        if (paramArrayOfByte != null) {
          paramArrayOfByte.sendMessage((Message)localObject);
        }
      }
      else
      {
        CameraControl.a().a(true, paramArrayOfByte);
      }
      if (QLog.isColorLevel())
      {
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("[@] onPreviewFrame end,mFrameIndex  = ");
        paramArrayOfByte.append(this.mFrameIndex);
        QLog.d("PreviewContext", 2, paramArrayOfByte.toString());
      }
      return;
    }
    catch (ArrayIndexOutOfBoundsException paramCamera)
    {
      for (;;)
      {
        paramCamera = (Camera)localObject;
      }
    }
  }
  
  public int getRemainedRecordFrames(int paramInt)
  {
    int i = this.mFrameCountArray.size();
    int j = 0;
    if (paramInt >= i) {
      return 0;
    }
    i = this.mFrameIndex;
    while (j < paramInt)
    {
      ArrayList localArrayList = this.mFrameCountArray;
      int k = localArrayList.size();
      j += 1;
      i -= ((Integer)localArrayList.get(k - j)).intValue();
    }
    return i;
  }
  
  public int getSegmentCount()
  {
    List localList = this.mFrameSrcList;
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
  
  public void lockFrameSync()
  {
    if (!this.mFrameProcessEnd) {
      synchronized (this.mlock)
      {
        boolean bool = this.mFrameProcessEnd;
        if (bool) {}
      }
    }
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("PreviewContext", 2, "lockFrameSync start wait");
      }
      this.mlock.wait(2000L);
      if (QLog.isColorLevel()) {
        QLog.d("PreviewContext", 2, "lockFrameSync wait finish");
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      label63:
      break label63;
    }
    return;
    localObject2 = finally;
    throw localObject2;
  }
  
  public void removeLatestVideo()
  {
    Object localObject = this.mFrameSrcList;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = this.mFrameSrcList;
      ((List)localObject).remove(((List)localObject).size() - 1);
    }
    if (this.mFrameCountArray.size() > 0)
    {
      int i = this.mFrameIndex;
      localObject = this.mFrameCountArray;
      this.mFrameIndex = (i - ((Integer)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1)).intValue());
      if (this.mFrameIndex <= 0) {
        this.mFrameIndex = 0;
      }
      localObject = this.mFrameCountArray;
      ((ArrayList)localObject).remove(((ArrayList)localObject).size() - 1);
      if (this.mFrameCountArray.size() == 0)
      {
        this.mFrameIndex = 0;
        localObject = this.mFrameSrcList;
        if (localObject != null) {
          ((List)localObject).clear();
        }
      }
    }
  }
  
  public void reset()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PreviewContext", 2, "[@] reset");
    }
    List localList = this.mFrameSrcList;
    if (localList != null) {
      localList.clear();
    }
    this.mFrameCountArray.clear();
    this.mBlockIndex = 0;
    this.mLastFrameIndex = 0;
    this.mWriteFrameCount = 0;
    this.mFrameIndex = 0;
  }
  
  public void sendFirstFrameMsg()
  {
    if (this.notifyFirstFrame)
    {
      CameraProxy localCameraProxy = this.mCamera;
      if (localCameraProxy != null)
      {
        localCameraProxy.a.a(10, new Object[] { "getted" });
        this.notifyFirstFrame = false;
      }
    }
  }
  
  public void setFrameIndex(int paramInt)
  {
    this.mFrameIndex = paramInt;
  }
  
  public void startCapture()
  {
    if (!Lock.jdField_a_of_type_Boolean) {
      return;
    }
    if (this.mFrameSrcList == null) {
      this.mFrameSrcList = new ArrayList();
    }
    AVIOStruct localAVIOStruct = new AVIOStruct();
    int i = this.mBlockIndex;
    this.mBlockIndex = (i + 1);
    localAVIOStruct.pBlockIndex = i;
    this.mFrameSrcList.add(localAVIOStruct);
    this.mLastFrameIndex = this.mFrameIndex;
  }
  
  public void stopCapture()
  {
    this.mFrameCountArray.add(Integer.valueOf(this.mFrameIndex - this.mLastFrameIndex));
  }
  
  public void unlockFrameSync()
  {
    synchronized (this.mlock)
    {
      this.mFrameProcessEnd = true;
      this.mlock.notifyAll();
      if (QLog.isColorLevel()) {
        QLog.d("PreviewContext", 2, "unlockFrameSync notifyAll");
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext
 * JD-Core Version:    0.7.0.1
 */