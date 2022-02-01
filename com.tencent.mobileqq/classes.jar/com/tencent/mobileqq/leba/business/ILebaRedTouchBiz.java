package com.tencent.mobileqq.leba.business;

import android.content.Context;
import com.tencent.mobileqq.leba.LebaConstant;
import com.tencent.mobileqq.leba.entity.LebaExposureInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import java.util.Map;
import mqq.app.AppRuntime;

public abstract class ILebaRedTouchBiz
{
  protected Map<Long, LebaExposureInfo> a;
  
  protected int a(RedTouch paramRedTouch)
  {
    if (paramRedTouch != null)
    {
      if (!paramRedTouch.c()) {
        return 0;
      }
      paramRedTouch = paramRedTouch.getRedType();
      if (paramRedTouch == null) {
        return 0;
      }
      if (paramRedTouch.red_type.get() == 0) {
        return 1;
      }
      if (paramRedTouch.red_type.get() == 5) {
        return 2;
      }
      if (paramRedTouch.red_type.get() == 11) {}
      return 3;
    }
    return 0;
  }
  
  protected void a(long paramLong, RedTouch paramRedTouch)
  {
    if (this.a == null) {
      return;
    }
    int j = LebaConstant.a(paramRedTouch);
    int i = j;
    if (j == 0) {
      i = a(paramRedTouch);
    }
    if (i != 0) {
      this.a.put(Long.valueOf(paramLong), new LebaExposureInfo(i, LebaConstant.b(paramRedTouch)));
    }
  }
  
  public abstract void a(AppRuntime paramAppRuntime, String paramString, BusinessInfoCheckUpdate.AppInfo paramAppInfo);
  
  public abstract boolean a(AppRuntime paramAppRuntime, Context paramContext, long paramLong, RedTouch paramRedTouch, String paramString, Map<Long, LebaExposureInfo> paramMap, int paramInt, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.business.ILebaRedTouchBiz
 * JD-Core Version:    0.7.0.1
 */