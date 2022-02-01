package com.tencent.mobileqq.data;

import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;

public class FunnyFaceMessage
  implements Externalizable
{
  public static final int FACE_ID_BOMB = 2;
  public static final int FACE_ID_TURNTABLE = 1;
  private static int VERSION = 1;
  public FunnyFaceMessage.Bomb bomb;
  public int faceId = 0;
  public boolean playAnimation = true;
  public FunnyFaceMessage.Turntable turntable;
  
  public FunnyFaceMessage() {}
  
  public FunnyFaceMessage(FunnyFaceMessage paramFunnyFaceMessage)
  {
    this.playAnimation = paramFunnyFaceMessage.playAnimation;
    this.faceId = paramFunnyFaceMessage.faceId;
    this.turntable = paramFunnyFaceMessage.turntable;
    this.bomb = paramFunnyFaceMessage.bomb;
  }
  
  public byte[] getBytes()
  {
    Object localObject = new ByteArrayOutputStream();
    try
    {
      ObjectOutputStream localObjectOutputStream = new ObjectOutputStream((OutputStream)localObject);
      writeExternal(localObjectOutputStream);
      localObjectOutputStream.close();
      localObject = ((ByteArrayOutputStream)localObject).toByteArray();
      return localObject;
    }
    catch (IOException localIOException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FunnyFaceMessage", 2, localIOException.getMessage(), localIOException);
      }
    }
    return null;
  }
  
  public boolean msgEquals(Object paramObject)
  {
    boolean bool2 = false;
    if (paramObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FunnyFaceMessage", 2, "msgEquals, obj == null");
      }
      return false;
    }
    if (paramObject == this)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FunnyFaceMessage", 2, "msgEquals, obj == this");
      }
      return true;
    }
    if (!(paramObject instanceof FunnyFaceMessage))
    {
      if (QLog.isColorLevel()) {
        QLog.d("FunnyFaceMessage", 2, "msgEquals, obj not FunnyFaceMessage");
      }
      return false;
    }
    paramObject = (FunnyFaceMessage)paramObject;
    int i = this.faceId;
    if (i != paramObject.faceId)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("msgEquals, this.faceId == ");
        localStringBuilder.append(this.faceId);
        localStringBuilder.append(", rhs.faceId == ");
        localStringBuilder.append(paramObject.faceId);
        QLog.d("FunnyFaceMessage", 2, localStringBuilder.toString());
      }
      return false;
    }
    if (i != 1)
    {
      if (i != 2) {
        return false;
      }
      bool1 = bool2;
    }
    try
    {
      if (this.bomb.isBurst != paramObject.bomb.isBurst) {
        break label262;
      }
    }
    catch (Exception paramObject)
    {
      boolean bool3;
      bool1 = bool2;
      if (!QLog.isColorLevel()) {
        break label262;
      }
      QLog.d("FunnyFaceMessage", 2, paramObject.toString());
      bool1 = bool2;
    }
    boolean bool1 = bool2;
    if (this.turntable.hitUin.equals(paramObject.turntable.hitUin))
    {
      bool3 = this.turntable.uinList.equals(paramObject.turntable.uinList);
      bool1 = bool2;
      if (bool3) {
        break label301;
      }
    }
    for (;;)
    {
      label262:
      if (QLog.isColorLevel())
      {
        paramObject = new StringBuilder();
        paramObject.append("msgEquals, ret == ");
        paramObject.append(bool1);
        QLog.d("FunnyFaceMessage", 2, paramObject.toString());
      }
      return bool1;
      label301:
      bool1 = true;
    }
  }
  
  public void readExternal(ObjectInput paramObjectInput)
  {
    if (paramObjectInput.readInt() == 1)
    {
      this.faceId = paramObjectInput.readInt();
      this.playAnimation = paramObjectInput.readBoolean();
      int i = this.faceId;
      if (i == 1)
      {
        this.turntable = new FunnyFaceMessage.Turntable();
        this.turntable.readExternal(paramObjectInput);
        return;
      }
      if (i == 2)
      {
        this.bomb = new FunnyFaceMessage.Bomb();
        this.bomb.readExternal(paramObjectInput);
      }
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("faceId:");
    localStringBuilder.append(this.faceId);
    int i = this.faceId;
    if (i == 1)
    {
      localStringBuilder.append(",hituin:");
      localStringBuilder.append(this.turntable.hitUin);
      localStringBuilder.append(",uinList[");
      Iterator localIterator = this.turntable.uinList.iterator();
      while (localIterator.hasNext())
      {
        localStringBuilder.append((String)localIterator.next());
        localStringBuilder.append(",");
      }
      localStringBuilder.append("]");
      localStringBuilder.append(",nickNane:");
      localStringBuilder.append(this.turntable.hitNickName);
    }
    else if (i == 2)
    {
      localStringBuilder.append(",isBurst:");
      localStringBuilder.append(this.bomb.isBurst);
    }
    return localStringBuilder.toString();
  }
  
  public void writeExternal(ObjectOutput paramObjectOutput)
  {
    paramObjectOutput.writeInt(VERSION);
    paramObjectOutput.writeInt(this.faceId);
    paramObjectOutput.writeBoolean(this.playAnimation);
    int i = this.faceId;
    if (i == 1)
    {
      this.turntable.writeExternal(paramObjectOutput);
      return;
    }
    if (i == 2) {
      this.bomb.writeExternal(paramObjectOutput);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.FunnyFaceMessage
 * JD-Core Version:    0.7.0.1
 */