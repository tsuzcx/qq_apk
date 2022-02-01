package com.tencent.mobileqq.service;

import com.qq.jce.wup.UniPacket;
import com.qq.taf.RequestPacket;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceUtil;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Set;

public class PttUniPacket
  extends UniPacket
{
  public static String TAG = PttUniPacket.class.getSimpleName();
  JceOutputStream josAttribute;
  JceOutputStream josData;
  JceOutputStream josPackage;
  
  public PttUniPacket(boolean paramBoolean)
  {
    super(paramBoolean);
  }
  
  public byte[] encode()
  {
    if (this._package.iVersion == 2)
    {
      if ((this._package.sServantName == null) || (this._package.sServantName.equals(""))) {
        throw new IllegalArgumentException("servantName can not is null");
      }
      if ((this._package.sFuncName == null) || (this._package.sFuncName.equals(""))) {
        throw new IllegalArgumentException("funcName can not is null");
      }
    }
    else
    {
      if (this._package.sServantName == null) {
        this._package.sServantName = "";
      }
      if (this._package.sFuncName == null) {
        this._package.sFuncName = "";
      }
    }
    if (this.josData == null)
    {
      this.josData = new JceOutputStream(0);
      this.josData.setServerEncoding(this.encodeName);
      if ((this._package.iVersion != 2) && (this._package.iVersion != 1)) {
        break label304;
      }
      this.josData.write(this._data, 0);
      label184:
      this._package.sBuffer = JceUtil.getJceBufArray(this.josData.getByteBuffer());
      if (this.josPackage != null) {
        break label319;
      }
      this.josPackage = new JceOutputStream(0);
    }
    for (;;)
    {
      this.josPackage.setServerEncoding(this.encodeName);
      writeTo(this.josPackage);
      int i = this.josPackage.getByteBuffer().position();
      Object localObject = ByteBuffer.allocate(i + 4);
      ((ByteBuffer)localObject).putInt(i + 4);
      localObject = ((ByteBuffer)localObject).array();
      System.arraycopy(this.josPackage.getByteBuffer().array(), 0, localObject, 4, i);
      return localObject;
      this.josData.getByteBuffer().clear();
      break;
      label304:
      this.josData.write(this._newData, 0);
      break label184;
      label319:
      this.josPackage.getByteBuffer().clear();
    }
  }
  
  public <T> void put(String paramString, T paramT)
  {
    if (this._newData != null)
    {
      if (paramString == null) {
        throw new IllegalArgumentException("put key can not is null");
      }
      if (paramT == null) {
        throw new IllegalArgumentException("put value can not is null");
      }
      if ((paramT instanceof Set)) {
        throw new IllegalArgumentException("can not support Set");
      }
      if (this.josAttribute == null) {
        this.josAttribute = new JceOutputStream();
      }
      for (;;)
      {
        this.josAttribute.setServerEncoding(this.encodeName);
        this.josAttribute.write(paramT, 0);
        paramT = JceUtil.getJceBufArray(this.josAttribute.getByteBuffer());
        this._newData.put(paramString, paramT);
        return;
        this.josAttribute.getByteBuffer().clear();
      }
    }
    super.put(paramString, paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.service.PttUniPacket
 * JD-Core Version:    0.7.0.1
 */