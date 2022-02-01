package com.tencent.mobileqq.identification;

import android.view.View;

public class UsableStrategy
  implements IFaceStrategy
{
  public void a(IFaceStrategy.IFaceEntrance paramIFaceEntrance)
  {
    paramIFaceEntrance.a();
  }
  
  public void a(View... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      paramVarArgs[i].setVisibility(0);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.identification.UsableStrategy
 * JD-Core Version:    0.7.0.1
 */