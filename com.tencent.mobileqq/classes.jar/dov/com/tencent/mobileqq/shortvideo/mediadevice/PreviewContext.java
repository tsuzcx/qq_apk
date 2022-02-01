package dov.com.tencent.mobileqq.shortvideo.mediadevice;

import android.hardware.Camera;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import bcif;
import bcig;
import bcij;
import bcio;
import bciu;
import bcjb;
import bmks;
import bpwl;
import bpwt;
import bqgx;
import bqhn;
import bqhu;
import bqhv;
import com.tencent.maxvideo.common.AVIOStruct;
import com.tencent.maxvideo.common.ControlFlagEnum;
import com.tencent.maxvideo.mediadevice.AVCodec;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import dov.com.tencent.mobileqq.shortvideo.hwcodec.SVHwEncoder;
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
  public bcio mCamera;
  private boolean mCheckedDataValid;
  private boolean mDisablePrivilage;
  public AtomicReference<SVHwEncoder> mEncodeRef = new AtomicReference(null);
  ArrayList<Integer> mFrameCountArray = new ArrayList();
  private int mFrameIndex;
  private volatile boolean mFrameProcessEnd;
  List<AVIOStruct> mFrameSrcList = new ArrayList();
  private boolean mInitHwEncode;
  int mLastFrameIndex = 0;
  public Handler mMsghandler;
  public boolean mPTVRealBeauty;
  private AVIOStruct mPTVRealBeautyCache = new AVIOStruct();
  private int mRecordToCache;
  private long[] mTimeStamp = new long[1];
  public AtomicInteger mVideoFrameProcess = new AtomicInteger(0);
  public AtomicInteger mVideoFrameWrite = new AtomicInteger(0);
  int mWriteFrameCount = 0;
  private Object mlock = new Object();
  Object mlockFrame = new Object();
  public boolean notifyFirstFrame;
  long updateTime = 0L;
  
  public PreviewContext(bcio parambcio, int paramInt1, int paramInt2)
  {
    this.mCamera = parambcio;
    parambcio.jdField_b_of_type_Int = paramInt1;
    parambcio.c = paramInt2;
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
    switch (k)
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.d("PreviewContext", 2, "[@] checkPreviewDataLength error 3,imgFmt  = " + k);
      }
      break;
    }
    do
    {
      do
      {
        return true;
        if (i * j * 2 == paramArrayOfByte.length) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("PreviewContext", 2, "[@] checkPreviewDataLength error 1 [Build.MODEL=" + Build.MODEL + "]");
      return true;
      if (i * j * 3 / 2 == paramArrayOfByte.length) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("PreviewContext", 2, "[@] checkPreviewDataLength error 2 [Build.MODEL=" + Build.MODEL + "]");
    return true;
    return false;
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
      bcig.a().a(true, paramArrayOfByte);
    }
  }
  
  public void encodeOneFrameNotify()
  {
    SVHwEncoder localSVHwEncoder = (SVHwEncoder)this.mEncodeRef.get();
    if (localSVHwEncoder != null)
    {
      localbqhn = localSVHwEncoder.a();
      if (localbqhn == null) {
        if (QLog.isColorLevel()) {
          QLog.d("PreviewContext", 2, "[@] encodeOneFrameNotify frame is null");
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      int i;
      do
      {
        bqhn localbqhn;
        return;
        int j = localSVHwEncoder.jdField_a_of_type_Int;
        try
        {
          i = getProcessedFrameData(localbqhn.jdField_a_of_type_ArrayOfByte, this.mTimeStamp, j);
          if (QLog.isColorLevel()) {
            QLog.d("PreviewContext", 2, "[@] HandleVideo: error=" + i + " colorspace=" + j);
          }
          if (i == 0)
          {
            localbqhn.jdField_a_of_type_Int = 0;
            localbqhn.jdField_b_of_type_Int = localbqhn.jdField_a_of_type_ArrayOfByte.length;
            localbqhn.jdField_a_of_type_Long = this.mTimeStamp[0];
            localbqhn.jdField_a_of_type_Boolean = false;
            localbqhn.jdField_b_of_type_Boolean = true;
            localSVHwEncoder.a(localbqhn, true);
            return;
          }
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
        {
          for (;;)
          {
            i = -1001;
          }
          this.mEncodeRef.getAndSet(null);
        }
      } while (!QLog.isColorLevel());
      QLog.d("PreviewContext", 2, "[@] HandleVideo: error=" + i + " set encode to null...");
      return;
    }
    QLog.d("PreviewContext", 2, "[@] HandleVideo: [encodeOneFrameNotify] encode=null");
  }
  
  public int getFrameIndex()
  {
    return this.mFrameIndex;
  }
  
  public void getPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    if (QLog.isColorLevel())
    {
      paramCamera = new StringBuilder("onPreviewFrame");
      paramCamera.append("Model=").append(Build.MODEL).append("|");
      paramCamera.append("CPU_ABI=").append(Build.CPU_ABI).append("|");
      paramCamera.append("nff=").append(this.notifyFirstFrame).append("|");
    }
    for (;;)
    {
      Object localObject1;
      int i;
      if (this.updateTime == 0L)
      {
        this.updateTime = SystemClock.uptimeMillis();
        this.frameCount = 0;
        bpwt.b();
        if (this.frameCount == 100)
        {
          localObject1 = new StringBuilder().append("fps = ");
          i = (int)(this.frameCount * 1000 / (SystemClock.uptimeMillis() - this.updateTime));
          this.fps = i;
          QLog.d("PreviewContext", 2, i);
          this.updateTime = 0L;
          this.frameCount = 0;
        }
        if (this.mCheckedDataValid) {
          break label258;
        }
        if (!bcif.a(bcif.p)) {
          break label250;
        }
        this.mDisablePrivilage = checkIsDisablePrivilage(paramArrayOfByte, 32);
        label202:
        this.mCheckedDataValid = true;
        if (!this.mDisablePrivilage) {
          break label265;
        }
        this.mCamera.a.a(12, new Object[] { "camera disabled zero data." });
      }
      label258:
      label265:
      label1076:
      for (;;)
      {
        return;
        this.frameCount += 1;
        break;
        label250:
        this.mDisablePrivilage = false;
        break label202;
        if (!this.mDisablePrivilage)
        {
          if (paramArrayOfByte == null)
          {
            bcig.a().a(true);
            return;
          }
          this.mRecordToCache = 0;
          if (!this.mPTVRealBeauty) {
            sendFirstFrameMsg();
          }
          localObject1 = null;
          if (!this.mFrameSrcList.isEmpty()) {
            localObject1 = (AVIOStruct)this.mFrameSrcList.get(this.mFrameSrcList.size() - 1);
          }
          Object localObject2;
          if (localObject1 != null)
          {
            if (!bqhu.jdField_a_of_type_Boolean) {
              break label645;
            }
            if (((AVIOStruct)localObject1).pControlFlag != ControlFlagEnum.NONE.getValue()) {
              break label617;
            }
            localObject2 = bcig.a().a();
            if (localObject2 == null)
            {
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d("PreviewContext", 2, "[@] preview size null");
              return;
            }
            i = bcig.a().a();
            ((AVIOStruct)localObject1).vWidth = ((bcij)localObject2).jdField_a_of_type_Int;
            ((AVIOStruct)localObject1).vHeight = ((bcij)localObject2).jdField_b_of_type_Int;
            ((AVIOStruct)localObject1).vFormat = i;
            ((AVIOStruct)localObject1).vOrientation = bcig.a().b();
            ((AVIOStruct)localObject1).vFPS = bcjb.g;
            ((AVIOStruct)localObject1).pControlFlag = ControlFlagEnum.OPEN_FILE_AND_WRITE_FRAME_DATA.getValue();
            ((AVIOStruct)localObject1).vBitrate = bcjb.f;
            ((AVIOStruct)localObject1).pCodec = bcjb.jdField_b_of_type_Int;
          }
          for (;;)
          {
            if ((localObject1 != null) && (((AVIOStruct)localObject1).isWriteFrame()))
            {
              boolean bool = checkPreviewDataLength((AVIOStruct)localObject1, paramArrayOfByte);
              if ((QLog.isColorLevel()) && (bool)) {
                QLog.d("PreviewContext", 2, "[@] onPreviewFrame PreviewDataLength error : " + bool + " Build.MODEL=" + Build.MODEL + " Build.CPU_ABI=" + Build.CPU_ABI);
              }
              if (bool)
              {
                this.mCamera.a.a(8, new Object[] { "unacceptable camera preview data" });
                if (1 != bpwl.jdField_a_of_type_Int) {
                  break;
                }
                bmks.a(bqgx.jdField_a_of_type_Long + "", "qzone_video_record", "8", null);
                return;
                label617:
                if (((AVIOStruct)localObject1).pControlFlag != ControlFlagEnum.OPEN_FILE_AND_WRITE_FRAME_DATA.getValue()) {
                  continue;
                }
                ((AVIOStruct)localObject1).pControlFlag = ControlFlagEnum.WRITE_FRAME_DATA.getValue();
                continue;
                if (((AVIOStruct)localObject1).pControlFlag == ControlFlagEnum.WRITE_FRAME_DATA.getValue())
                {
                  ((AVIOStruct)localObject1).pControlFlag = ControlFlagEnum.WRITE_FRAME_DATA_AND_CLOSE_FILE.getValue();
                  continue;
                }
                if (((AVIOStruct)localObject1).pControlFlag != ControlFlagEnum.WRITE_FRAME_DATA_AND_CLOSE_FILE.getValue()) {
                  continue;
                }
                ((AVIOStruct)localObject1).pControlFlag = ControlFlagEnum.NONE.getValue();
                continue;
              }
              i = this.mFrameIndex;
              this.mFrameIndex = (i + 1);
              ((AVIOStruct)localObject1).pFrameIndex = i;
              ((AVIOStruct)localObject1).vFrameTime = SystemClock.elapsedRealtime();
              this.mWriteFrameCount += 1;
              this.mRecordToCache = 1;
              if (!this.mPTVRealBeauty)
              {
                this.mVideoFrameWrite.incrementAndGet();
                this.mAVCodec.copyQQBuf(paramArrayOfByte, (AVIOStruct)localObject1);
                QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread", false).post(new PreviewContext.HandleVideo(this));
              }
            }
          }
          if (this.mPTVRealBeauty)
          {
            localObject2 = Message.obtain(this.mMsghandler);
            ((Message)localObject2).what = -16716526;
            ((Message)localObject2).arg1 = this.mRecordToCache;
            ((Message)localObject2).arg2 = 1;
            ((Message)localObject2).obj = paramArrayOfByte;
            if (this.mRecordToCache == 1)
            {
              bqhv localbqhv = new bqhv();
              localbqhv.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
              localbqhv.jdField_a_of_type_ComTencentMaxvideoCommonAVIOStruct = ((AVIOStruct)((AVIOStruct)localObject1).clone());
              ((Message)localObject2).obj = localbqhv;
              label874:
              if (this.mMsghandler != null) {
                this.mMsghandler.sendMessage((Message)localObject2);
              }
            }
          }
          for (;;)
          {
            if ((!QLog.isColorLevel()) || (paramCamera == null)) {
              break label1076;
            }
            paramCamera.append("mFrameIndex").append(this.mFrameIndex).append("|");
            QLog.d("PreviewContext", 2, paramCamera.toString());
            return;
            if ((QLog.isColorLevel()) && (paramCamera != null)) {
              paramCamera.append("mMsghandler").append(this.mMsghandler).append("|");
            }
            localObject1 = bcig.a().a();
            if (localObject1 == null)
            {
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("PreviewContext", 2, "[@] preview size null2");
              return;
            }
            i = bcig.a().a();
            this.mPTVRealBeautyCache.vWidth = ((bcij)localObject1).jdField_a_of_type_Int;
            this.mPTVRealBeautyCache.vHeight = ((bcij)localObject1).jdField_b_of_type_Int;
            this.mPTVRealBeautyCache.vFormat = i;
            if (!checkPreviewDataLength(this.mPTVRealBeautyCache, paramArrayOfByte)) {
              break label874;
            }
            this.mCamera.a.a(8, new Object[] { "unacceptable camera preview data" });
            return;
            bcig.a().a(true, paramArrayOfByte);
          }
        }
      }
      label645:
      paramCamera = null;
    }
  }
  
  public int getRemainedRecordFrames(int paramInt)
  {
    if (paramInt >= this.mFrameCountArray.size()) {
      return 0;
    }
    int j = this.mFrameIndex;
    int i = 0;
    while (i < paramInt)
    {
      j -= ((Integer)this.mFrameCountArray.get(this.mFrameCountArray.size() - (i + 1))).intValue();
      i += 1;
    }
    return j;
  }
  
  public int getSegmentCount()
  {
    if (this.mFrameSrcList != null) {
      return this.mFrameSrcList.size();
    }
    return 0;
  }
  
  public void lockFrameSync()
  {
    if (!this.mFrameProcessEnd)
    {
      synchronized (this.mlock)
      {
        boolean bool = this.mFrameProcessEnd;
        if (bool) {}
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
  }
  
  public void removeLatestVideo()
  {
    if ((this.mFrameSrcList != null) && (this.mFrameSrcList.size() > 0)) {
      this.mFrameSrcList.remove(this.mFrameSrcList.size() - 1);
    }
    if (this.mFrameCountArray.size() > 0)
    {
      this.mFrameIndex -= ((Integer)this.mFrameCountArray.get(this.mFrameCountArray.size() - 1)).intValue();
      if (this.mFrameIndex <= 0) {
        this.mFrameIndex = 0;
      }
      this.mFrameCountArray.remove(this.mFrameCountArray.size() - 1);
      if (this.mFrameCountArray.size() == 0)
      {
        this.mFrameIndex = 0;
        if (this.mFrameSrcList != null) {
          this.mFrameSrcList.clear();
        }
      }
    }
  }
  
  public void reset()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PreviewContext", 2, "[@] reset");
    }
    if (this.mFrameSrcList != null) {
      this.mFrameSrcList.clear();
    }
    this.mFrameCountArray.clear();
    this.mBlockIndex = 0;
    this.mLastFrameIndex = 0;
    this.mWriteFrameCount = 0;
    this.mFrameIndex = 0;
  }
  
  public void sendFirstFrameMsg()
  {
    if ((this.notifyFirstFrame) && (this.mCamera != null))
    {
      this.mCamera.a.a(10, new Object[] { "getted" });
      this.notifyFirstFrame = false;
    }
  }
  
  public void setFrameIndex(int paramInt)
  {
    this.mFrameIndex = paramInt;
  }
  
  public void startCapture()
  {
    if (!bqhu.jdField_a_of_type_Boolean) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext
 * JD-Core Version:    0.7.0.1
 */