package com.tencent.mobileqq.intervideo.huayang.impl;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.intervideo.huayang.HuayangOpenHelper;
import com.tencent.mobileqq.intervideo.huayang.IHuayangOpenHelper;

public class HuayangOpenHelperImpl
  implements IHuayangOpenHelper
{
  public void doKillProcess(Context paramContext, String paramString)
  {
    HuayangOpenHelper.a(paramContext, paramString);
  }
  
  public void killProcess(Context paramContext, String paramString)
  {
    HuayangOpenHelper.b(paramContext, paramString);
  }
  
  public void open(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    HuayangOpenHelper.a((QQAppInterface)paramAppInterface, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.huayang.impl.HuayangOpenHelperImpl
 * JD-Core Version:    0.7.0.1
 */