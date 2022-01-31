package com.tencent.mobileqq.structmsg;

import java.io.Externalizable;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class AbsShareMsg$ShareData
  implements Externalizable
{
  public static final byte APP_INFO_STATUS_INIT = 0;
  public static final byte APP_INFO_STATUS_READY = 1;
  public static final byte IMAGE_URL_STATUS_INIT = 0;
  public static final byte IMAGE_URL_STATUS_LOCAL = 2;
  public static final byte IMAGE_URL_STATUS_OK = 1;
  public static final byte IMAGE_URL_STATUS_REMOTE = 4;
  public static final byte IMAGE_URL_STATUS_REMOTE_CHANGED = 3;
  public static final byte SHORT_URL_STATUS_CHANGED = 1;
  public static final byte SHORT_URL_STATUS_INIT = 0;
  public byte appInfoStatus = 0;
  public byte imageUrlStatus = 0;
  public String pkgName;
  public byte shortUrlStatus = 0;
  public String sourceIconBig;
  public int status;
  public byte version = 1;
  
  public boolean isFinish()
  {
    return this.status == 1003;
  }
  
  public void readExternal(ObjectInput paramObjectInput)
  {
    this.version = paramObjectInput.readByte();
    this.appInfoStatus = paramObjectInput.readByte();
    this.imageUrlStatus = paramObjectInput.readByte();
    this.shortUrlStatus = paramObjectInput.readByte();
    this.status = paramObjectInput.readInt();
    this.pkgName = paramObjectInput.readUTF();
    this.sourceIconBig = paramObjectInput.readUTF();
  }
  
  public void writeExternal(ObjectOutput paramObjectOutput)
  {
    paramObjectOutput.writeByte(this.version);
    paramObjectOutput.writeByte(this.appInfoStatus);
    paramObjectOutput.writeByte(this.imageUrlStatus);
    paramObjectOutput.writeByte(this.shortUrlStatus);
    paramObjectOutput.writeInt(this.status);
    if (this.pkgName == null)
    {
      str = "";
      paramObjectOutput.writeUTF(str);
      if (this.sourceIconBig != null) {
        break label93;
      }
    }
    label93:
    for (String str = "";; str = this.sourceIconBig)
    {
      paramObjectOutput.writeUTF(str);
      return;
      str = this.pkgName;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.AbsShareMsg.ShareData
 * JD-Core Version:    0.7.0.1
 */