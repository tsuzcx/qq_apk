package com.tencent.mobileqq.vas.tianshu;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.NotNull;

public class TianshuWebManagerImpl
  implements ITianshuWebManager
{
  public static String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getLastClickTraceInfoJson:");
    localStringBuilder.append("");
    QLog.i("TianshuWebManagerImpl", 1, localStringBuilder.toString());
    return BaseApplication.getContext().getSharedPreferences("tianshu_manager", 0).getString("tianshu_manager", "{}");
  }
  
  @NotNull
  public String getTraceInfoOfLastClick()
  {
    return a();
  }
  
  public void setTraceInfoOfLastClick(@NotNull String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setTraceInfoOfLastClick:");
    ((StringBuilder)localObject).append(paramString);
    QLog.i("TianshuWebManagerImpl", 1, ((StringBuilder)localObject).toString());
    localObject = BaseApplication.getContext().getSharedPreferences("tianshu_manager", 0).edit();
    ((SharedPreferences.Editor)localObject).putString("tianshu_manager", paramString);
    ((SharedPreferences.Editor)localObject).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.tianshu.TianshuWebManagerImpl
 * JD-Core Version:    0.7.0.1
 */