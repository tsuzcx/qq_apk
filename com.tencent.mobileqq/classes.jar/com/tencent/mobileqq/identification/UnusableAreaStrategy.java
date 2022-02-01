package com.tencent.mobileqq.identification;

import android.view.View;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;
import mqq.os.MqqHandler;

public class UnusableAreaStrategy
  implements IFaceAreaStrategy
{
  private String a;
  
  public UnusableAreaStrategy(String paramString)
  {
    this.a = paramString;
  }
  
  public void a(IFaceAreaStrategy.IFaceEntrance paramIFaceEntrance)
  {
    ReportController.a(null, "dc00898", "", "", "0X800B0EA", "0X800B0EA", 0, 0, "", "", "", "");
    ThreadManager.getUIHandler().post(new UnusableAreaStrategy.1(this));
  }
  
  public void a(View... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      paramVarArgs[i].setVisibility(8);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.identification.UnusableAreaStrategy
 * JD-Core Version:    0.7.0.1
 */