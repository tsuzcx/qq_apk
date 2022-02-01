package com.tencent.mobileqq.startup.step;

import com.tencent.mobileqq.ark.api.INativeLibLoader;
import com.tencent.mobileqq.qroute.QRoute;

public class UpdateArkSo
  extends Step
{
  protected boolean doStep()
  {
    ((INativeLibLoader)QRoute.api(INativeLibLoader.class)).extractPNGLibrary();
    ((INativeLibLoader)QRoute.api(INativeLibLoader.class)).extractArkLibrary();
    ((INativeLibLoader)QRoute.api(INativeLibLoader.class)).extractWordSegmentLibrary();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.UpdateArkSo
 * JD-Core Version:    0.7.0.1
 */