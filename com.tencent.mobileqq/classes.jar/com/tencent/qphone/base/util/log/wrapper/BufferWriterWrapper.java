package com.tencent.qphone.base.util.log.wrapper;

import com.tencent.qphone.base.util.log.ILogWriter;
import com.tencent.qphone.base.util.log.QBufferedWriter;
import com.tencent.qphone.base.util.log.QLogWriter;

public class BufferWriterWrapper
  extends QBufferedWriter
  implements ILogWriter
{
  public BufferWriterWrapper(QLogWriter paramQLogWriter, int paramInt)
  {
    super(paramQLogWriter, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qphone.base.util.log.wrapper.BufferWriterWrapper
 * JD-Core Version:    0.7.0.1
 */