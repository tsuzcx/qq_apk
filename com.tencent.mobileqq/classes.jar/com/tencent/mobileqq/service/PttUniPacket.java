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
  public static String TAG = "PttUniPacket";
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
      if ((this._package.sServantName != null) && (!this._package.sServantName.equals("")))
      {
        if ((this._package.sFuncName == null) || (this._package.sFuncName.equals(""))) {
          throw new IllegalArgumentException("funcName can not is null");
        }
      }
      else {
        throw new IllegalArgumentException("servantName can not is null");
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
    Object localObject = this.josData;
    if (localObject == null) {
      this.josData = new JceOutputStream(0);
    } else {
      ((JceOutputStream)localObject).getByteBuffer().clear();
    }
    this.josData.setServerEncoding(this.encodeName);
    if ((this._package.iVersion != 2) && (this._package.iVersion != 1)) {
      this.josData.write(this._newData, 0);
    } else {
      this.josData.write(this._data, 0);
    }
    this._package.sBuffer = JceUtil.getJceBufArray(this.josData.getByteBuffer());
    localObject = this.josPackage;
    if (localObject == null) {
      this.josPackage = new JceOutputStream(0);
    } else {
      ((JceOutputStream)localObject).getByteBuffer().clear();
    }
    this.josPackage.setServerEncoding(this.encodeName);
    writeTo(this.josPackage);
    int i = this.josPackage.getByteBuffer().position();
    int j = i + 4;
    localObject = ByteBuffer.allocate(j);
    ((ByteBuffer)localObject).putInt(j);
    localObject = ((ByteBuffer)localObject).array();
    System.arraycopy(this.josPackage.getByteBuffer().array(), 0, localObject, 4, i);
    return localObject;
  }
  
  public <T> void put(String paramString, T paramT)
  {
    if (this._newData != null)
    {
      if (paramString != null)
      {
        if (paramT != null)
        {
          if (!(paramT instanceof Set))
          {
            JceOutputStream localJceOutputStream = this.josAttribute;
            if (localJceOutputStream == null) {
              this.josAttribute = new JceOutputStream();
            } else {
              localJceOutputStream.getByteBuffer().clear();
            }
            this.josAttribute.setServerEncoding(this.encodeName);
            this.josAttribute.write(paramT, 0);
            paramT = JceUtil.getJceBufArray(this.josAttribute.getByteBuffer());
            this._newData.put(paramString, paramT);
            return;
          }
          throw new IllegalArgumentException("can not support Set");
        }
        throw new IllegalArgumentException("put value can not is null");
      }
      throw new IllegalArgumentException("put key can not is null");
    }
    super.put(paramString, paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.service.PttUniPacket
 * JD-Core Version:    0.7.0.1
 */