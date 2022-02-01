package com.tencent.mobileqq.data;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FunnyFaceMessage$Turntable
  implements Externalizable
{
  public String hitNickName;
  public String hitUin;
  public List<String> uinList = new ArrayList();
  
  public FunnyFaceMessage$Turntable() {}
  
  public FunnyFaceMessage$Turntable(ObjectInput paramObjectInput)
  {
    try
    {
      readExternal(paramObjectInput);
      return;
    }
    catch (ClassNotFoundException paramObjectInput)
    {
      paramObjectInput.printStackTrace();
      return;
    }
    catch (IOException paramObjectInput)
    {
      paramObjectInput.printStackTrace();
    }
  }
  
  public void readExternal(ObjectInput paramObjectInput)
  {
    int j = paramObjectInput.readInt();
    int i = 0;
    while (i < j)
    {
      this.uinList.add(paramObjectInput.readUTF());
      i += 1;
    }
    this.hitUin = paramObjectInput.readUTF();
    this.hitNickName = paramObjectInput.readUTF();
  }
  
  public void writeExternal(ObjectOutput paramObjectOutput)
  {
    paramObjectOutput.writeInt(this.uinList.size());
    Iterator localIterator = this.uinList.iterator();
    while (localIterator.hasNext()) {
      paramObjectOutput.writeUTF((String)localIterator.next());
    }
    paramObjectOutput.writeUTF(this.hitUin);
    paramObjectOutput.writeUTF(this.hitNickName);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.FunnyFaceMessage.Turntable
 * JD-Core Version:    0.7.0.1
 */