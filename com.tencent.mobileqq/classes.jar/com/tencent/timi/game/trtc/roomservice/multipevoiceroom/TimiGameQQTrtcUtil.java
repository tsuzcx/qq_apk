package com.tencent.timi.game.trtc.roomservice.multipevoiceroom;

import android.text.TextUtils;
import com.tencent.avbiz.AVBizModuleFactory;
import com.tencent.avbiz.IModule;
import com.tencent.mobileqq.soload.api.SoLoadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.tim.api.ITimiGameTimApi;

public class TimiGameQQTrtcUtil
{
  public static boolean a = false;
  public static boolean b = false;
  public static String c;
  
  public static void a()
  {
    AVBizModuleFactory.getModuleByName("游戏组队").abandonAVFocus();
    AVBizModuleFactory.removeModuleByName("游戏组队");
    a = false;
  }
  
  public static void a(TimiGameQQTrtcUtil.ITrtcCheckResult paramITrtcCheckResult)
  {
    String str = AVBizModuleFactory.getModuleByName("游戏组队").requestAVFocus();
    if (!"true".equals(str))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("获取音频业务权限失败,占用业务 res[");
      localStringBuilder.append(str);
      localStringBuilder.append("]");
      QLog.e("TimiGameQQTrtcCheckUtil", 2, localStringBuilder.toString());
      a = false;
      paramITrtcCheckResult.a(-2, str);
      return;
    }
    QLog.i("TimiGameQQTrtcCheckUtil", 2, "获取音频业务权限[Success]");
    a = true;
    d(paramITrtcCheckResult);
  }
  
  public static boolean b()
  {
    return (a) && (b) && (!TextUtils.isEmpty(c));
  }
  
  private static void c(TimiGameQQTrtcUtil.ITrtcCheckResult paramITrtcCheckResult)
  {
    if (b)
    {
      paramITrtcCheckResult.a();
      return;
    }
    SoLoadManager.getInstance().load("trtc_entry", new TimiGameQQTrtcUtil.1(paramITrtcCheckResult));
  }
  
  private static void d(TimiGameQQTrtcUtil.ITrtcCheckResult paramITrtcCheckResult)
  {
    ((ITimiGameTimApi)ServiceCenter.a(ITimiGameTimApi.class)).a(new TimiGameQQTrtcUtil.2(paramITrtcCheckResult));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.trtc.roomservice.multipevoiceroom.TimiGameQQTrtcUtil
 * JD-Core Version:    0.7.0.1
 */