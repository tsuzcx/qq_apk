package com.tencent.mobileqq.magicface.service;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.statistics.ReportController;
import mqq.app.AppRuntime;

class MagicfaceActionManager$1
  implements MagicfaceActionManager.MagicfaceSensorOperation
{
  MagicfaceActionManager$1(MagicfaceActionManager paramMagicfaceActionManager) {}
  
  public void a()
  {
    AppRuntime localAppRuntime;
    if (this.a.a == 1)
    {
      localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {
        ReportController.b((QQAppInterface)localAppRuntime, "CliOper", "", "", "MbJieshou", "MbWanchengXiaochu", 0, 0, this.a.b.epId, "", "", "");
      }
    }
    else
    {
      localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface)))
      {
        this.a.r = System.currentTimeMillis();
        ReportController.b((QQAppInterface)localAppRuntime, "CliOper", "", "", "MbFasong", "MbZhudongChaozuo", 0, 0, this.a.b.epId, "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.service.MagicfaceActionManager.1
 * JD-Core Version:    0.7.0.1
 */