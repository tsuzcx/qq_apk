package com.tencent.mobileqq.richmedia.mediacodec.decoder.flow;

import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.support.annotation.Nullable;
import android.util.AndroidRuntimeException;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.richmedia.mediacodec.decoder.DecodeConfig;
import com.tencent.mobileqq.richmedia.mediacodec.decoder.HWDecodeListener;
import com.tencent.mobileqq.richmedia.mediacodec.decoder.IVideoDecoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class VideoFlowDecodeWrapper
  implements IVideoDecoder, FlowDecodeListener
{
  private HWDecodeListener jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWDecodeListener = new VideoFlowDecodeWrapper.1(this);
  private VideoFlowDecodeWrapper.FlowListener jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowVideoFlowDecodeWrapper$FlowListener;
  private VideoFlowDecoder jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowVideoFlowDecoder = new VideoFlowDecoder();
  private Comparator<DecodedFrame> jdField_a_of_type_JavaUtilComparator = new VideoFlowDecodeWrapper.2(this);
  private final List<DecodedFrame> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  private void f()
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      if (localIterator.hasNext()) {
        ((DecodedFrame)localIterator.next()).b();
      }
    }
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public int a()
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      int i = this.jdField_a_of_type_JavaUtilList.size();
      return i;
    }
  }
  
  public int a(List<DecodedFrame> paramList)
  {
    if (paramList.size() > 0) {
      SLog.c("FlowEdit_VideoFlowDecodeWrapper", "onFrameReached : size " + paramList.size() + ", range [" + ((DecodedFrame)paramList.get(0)).a() + " - " + ((DecodedFrame)paramList.get(paramList.size() - 1)).a() + "], cycle " + ((DecodedFrame)paramList.get(0)).b() + ", current size " + this.jdField_a_of_type_JavaUtilList.size());
    }
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      for (;;)
      {
        this.jdField_a_of_type_JavaUtilList.addAll(paramList);
        Collections.sort(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_JavaUtilComparator);
        int j = this.jdField_a_of_type_JavaUtilList.size();
        if (j <= 5) {
          break;
        }
        i = 1;
        if ((i != 0) && (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowVideoFlowDecodeWrapper$FlowListener != null)) {
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowVideoFlowDecodeWrapper$FlowListener.a();
        }
        return j;
        SLog.d("FlowEdit_VideoFlowDecodeWrapper", "onFrameReached : size 0");
      }
      int i = 0;
    }
  }
  
  @Nullable
  public DecodedFrame a()
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (this.jdField_a_of_type_JavaUtilList.size() > 0)
      {
        DecodedFrame localDecodedFrame = (DecodedFrame)this.jdField_a_of_type_JavaUtilList.remove(0);
        return localDecodedFrame;
      }
      return null;
    }
  }
  
  public void a()
  {
    SLog.a("FlowEdit_VideoFlowDecodeWrapper", new Throwable(), "stopDecode", new Object[0]);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowVideoFlowDecoder.a();
    SLog.c("FlowEdit_VideoFlowDecodeWrapper", "clear frame list because of stopDecode");
    f();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowVideoFlowDecoder.a(paramInt);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowVideoFlowDecoder.a(paramLong1, paramLong2);
  }
  
  public void a(DecodeConfig paramDecodeConfig, int paramInt, SurfaceTexture.OnFrameAvailableListener paramOnFrameAvailableListener, HWDecodeListener paramHWDecodeListener)
  {
    throw new AndroidRuntimeException("please use startDecode(FlowDecodeConfig, FlowListener) instead");
  }
  
  public void a(FlowDecodeConfig paramFlowDecodeConfig, VideoFlowDecodeWrapper.FlowListener paramFlowListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowVideoFlowDecodeWrapper$FlowListener = paramFlowListener;
    SLog.a("FlowEdit_VideoFlowDecodeWrapper", new Throwable(), "startDecode : decodeConfig = %s", new Object[] { paramFlowDecodeConfig });
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowVideoFlowDecoder.a(paramFlowDecodeConfig, this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWDecodeListener, this);
  }
  
  @Nullable
  public DecodedFrame b()
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (this.jdField_a_of_type_JavaUtilList.size() > 0)
      {
        DecodedFrame localDecodedFrame = (DecodedFrame)this.jdField_a_of_type_JavaUtilList.get(0);
        return localDecodedFrame;
      }
      return null;
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowVideoFlowDecoder.b();
  }
  
  @Nullable
  public DecodedFrame c()
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (this.jdField_a_of_type_JavaUtilList.size() >= 2)
      {
        DecodedFrame localDecodedFrame = (DecodedFrame)this.jdField_a_of_type_JavaUtilList.get(1);
        return localDecodedFrame;
      }
      return null;
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowVideoFlowDecoder.c();
  }
  
  public void d()
  {
    SLog.c("FlowEdit_VideoFlowDecodeWrapper", "clear frame list because of play range change");
    f();
  }
  
  public void e()
  {
    SLog.c("FlowEdit_VideoFlowDecodeWrapper", "clear frame list because of direction change");
    f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.decoder.flow.VideoFlowDecodeWrapper
 * JD-Core Version:    0.7.0.1
 */