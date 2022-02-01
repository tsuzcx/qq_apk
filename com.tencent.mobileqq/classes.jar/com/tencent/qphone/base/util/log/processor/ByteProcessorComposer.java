package com.tencent.qphone.base.util.log.processor;

import java.util.ArrayList;
import java.util.Iterator;

public class ByteProcessorComposer
  implements IByteProcessor
{
  ArrayList<IByteProcessor> list = new ArrayList();
  
  public void addProcessor(IByteProcessor paramIByteProcessor)
  {
    this.list.add(paramIByteProcessor);
  }
  
  public ProcessByteData handleData(ProcessByteData paramProcessByteData)
  {
    Iterator localIterator = this.list.iterator();
    while (localIterator.hasNext()) {
      paramProcessByteData = ((IByteProcessor)localIterator.next()).handleData(paramProcessByteData);
    }
    return paramProcessByteData;
  }
  
  public void reset()
  {
    Iterator localIterator = this.list.iterator();
    while (localIterator.hasNext()) {
      ((IByteProcessor)localIterator.next()).reset();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qphone.base.util.log.processor.ByteProcessorComposer
 * JD-Core Version:    0.7.0.1
 */