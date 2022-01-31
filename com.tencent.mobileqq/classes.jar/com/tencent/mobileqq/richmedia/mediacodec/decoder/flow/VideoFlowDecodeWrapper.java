package com.tencent.mobileqq.richmedia.mediacodec.decoder.flow;

import ahod;
import ahop;
import ahoq;
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
  private HWDecodeListener jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWDecodeListener = new ahop(this);
  private VideoFlowDecodeWrapper.FlowListener jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowVideoFlowDecodeWrapper$FlowListener;
  private VideoFlowDecoder jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowVideoFlowDecoder = new VideoFlowDecoder();
  private Comparator jdField_a_of_type_JavaUtilComparator = new ahoq(this);
  private final List jdField_a_of_type_JavaUtilList = new ArrayList();
  
  private void e()
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      if (localIterator.hasNext()) {
        ((ahod)localIterator.next()).b();
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
  
  public int a(List paramList)
  {
    if (paramList.size() > 0) {
      SLog.c("FlowEdit_VideoFlowDecodeWrapper", "onFrameReached : size " + paramList.size() + ", range [" + ((ahod)paramList.get(0)).a() + " - " + ((ahod)paramList.get(paramList.size() - 1)).a() + "], cycle " + ((ahod)paramList.get(0)).b() + ", current size " + this.jdField_a_of_type_JavaUtilList.size());
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
  public ahod a()
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (this.jdField_a_of_type_JavaUtilList.size() > 0)
      {
        ahod localahod = (ahod)this.jdField_a_of_type_JavaUtilList.remove(0);
        return localahod;
      }
      return null;
    }
  }
  
  public void a()
  {
    SLog.a("FlowEdit_VideoFlowDecodeWrapper", new Throwable(), "stopDecode", new Object[0]);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowVideoFlowDecoder.a();
    SLog.c("FlowEdit_VideoFlowDecodeWrapper", "clear frame list because of stopDecode");
    e();
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
  public ahod b()
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (this.jdField_a_of_type_JavaUtilList.size() > 0)
      {
        ahod localahod = (ahod)this.jdField_a_of_type_JavaUtilList.get(0);
        return localahod;
      }
      return null;
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowVideoFlowDecoder.b();
  }
  
  @Nullable
  public ahod c()
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (this.jdField_a_of_type_JavaUtilList.size() >= 2)
      {
        ahod localahod = (ahod)this.jdField_a_of_type_JavaUtilList.get(1);
        return localahod;
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
    e();
  }
  
  public void f()
  {
    SLog.c("FlowEdit_VideoFlowDecodeWrapper", "clear frame list because of direction change");
    e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.decoder.flow.VideoFlowDecodeWrapper
 * JD-Core Version:    0.7.0.1
 */