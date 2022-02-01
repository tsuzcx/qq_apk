package com.tencent.mobileqq.writetogether.api.impl;

import com.tencent.mobileqq.writetogether.api.IWriteTogetherConfig;
import com.tencent.mobileqq.writetogetherconfig.WriteTogetherConfBean;
import mqq.app.AppRuntime;

public class WriteTogetherConfigImpl
  implements IWriteTogetherConfig
{
  public boolean isAllowShowEntrance(AppRuntime paramAppRuntime, String paramString)
  {
    return WriteTogetherConfBean.a(paramAppRuntime, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.api.impl.WriteTogetherConfigImpl
 * JD-Core Version:    0.7.0.1
 */