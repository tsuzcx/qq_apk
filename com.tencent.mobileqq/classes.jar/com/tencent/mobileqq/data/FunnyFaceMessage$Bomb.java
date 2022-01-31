package com.tencent.mobileqq.data;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class FunnyFaceMessage$Bomb
  implements Externalizable
{
  public boolean isBurst;
  
  public FunnyFaceMessage$Bomb() {}
  
  public FunnyFaceMessage$Bomb(ObjectInput paramObjectInput)
  {
    try
    {
      readExternal(paramObjectInput);
      return;
    }
    catch (IOException paramObjectInput)
    {
      paramObjectInput.printStackTrace();
      return;
    }
    catch (ClassNotFoundException paramObjectInput)
    {
      paramObjectInput.printStackTrace();
    }
  }
  
  public void readExternal(ObjectInput paramObjectInput)
  {
    this.isBurst = paramObjectInput.readBoolean();
  }
  
  public void writeExternal(ObjectOutput paramObjectOutput)
  {
    paramObjectOutput.writeBoolean(this.isBurst);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.FunnyFaceMessage.Bomb
 * JD-Core Version:    0.7.0.1
 */