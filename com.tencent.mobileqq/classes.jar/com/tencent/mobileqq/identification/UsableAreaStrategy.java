package com.tencent.mobileqq.identification;

import android.view.View;

public class UsableAreaStrategy
  implements IFaceAreaStrategy
{
  public void a(IFaceAreaStrategy.IFaceEntrance paramIFaceEntrance)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.identification.UsableAreaStrategy
 * JD-Core Version:    0.7.0.1
 */