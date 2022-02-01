package com.tencent.mobileqq.qqlive.filter;

import android.hardware.SensorEvent;
import androidx.annotation.IntRange;
import com.tencent.aekit.api.standard.filter.AEFilterManager;
import com.tencent.aekit.api.standard.filter.AEFilterManager.MaterialInnerEffectListener;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.mobileqq.qqlive.callback.anchor.QQLiveCameraFilterLoaderListener;
import com.tencent.mobileqq.qqlive.data.anchor.camera.QQLiveCameraFilterInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.config.BeautyRealConfig.TYPE;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.light.listener.LightAssetListener;

public class QQLiveAEFilterProcess
{
  protected int a;
  protected int b;
  protected float[] c;
  public HashMap<BeautyRealConfig.TYPE, Integer> d;
  private AEFilterManager e;
  private LightAssetListener f;
  private boolean g;
  private AEFilterManager.MaterialInnerEffectListener h;
  
  private void d()
  {
    e();
  }
  
  private void e()
  {
    if (this.e != null) {
      h();
    }
  }
  
  private void f()
  {
    AEFilterManager localAEFilterManager = this.e;
    if (localAEFilterManager != null)
    {
      localAEFilterManager.destroy();
      this.e = null;
    }
  }
  
  private void g()
  {
    Object localObject = ((IAEResUtil)QRoute.api(IAEResUtil.class)).getLightBundleMap();
    if (localObject != null)
    {
      localObject = ((Map)localObject).keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        AEResInfo localAEResInfo = (AEResInfo)((Iterator)localObject).next();
        if ((((IAEResUtil)QRoute.api(IAEResUtil.class)).isAEResExist(localAEResInfo)) && (this.e != null))
        {
          String str = ((IAEResUtil)QRoute.api(IAEResUtil.class)).getLightBundleDir(localAEResInfo);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("[injectBundlePathsToLight] agentType:");
          localStringBuilder.append(localAEResInfo.agentType);
          localStringBuilder.append(" | dir:");
          localStringBuilder.append(str);
          QLog.d("QQLiveAEFilterProcess", 2, localStringBuilder.toString());
          this.e.setLightBundle(str, localAEResInfo.agentType);
        }
      }
    }
  }
  
  private void h()
  {
    this.e.initInGL(this.a, this.b);
    this.e.supportMultiThreads(true);
    this.e.defineFiltersAndOrder(new int[] { 300, 100 });
    this.e.setFilterInSmooth(true);
    this.e.setSyncMode(true);
    this.e.setStickerInnerLutFilterListener(this.h);
    this.e.setLightNodeLightAssetListener(new QQLiveAEFilterProcess.1(this));
    g();
  }
  
  public int a(int paramInt)
  {
    if (!c()) {
      return paramInt;
    }
    this.e.setPicNeedFlipBeforeRender(true);
    this.e.notifyDetectFaceAttr();
    AEFilterManager localAEFilterManager = this.e;
    int i = paramInt;
    if (localAEFilterManager != null)
    {
      localAEFilterManager.setRotationMatrix(this.c);
      i = this.e.drawFrame(paramInt, true, System.currentTimeMillis());
    }
    return i;
  }
  
  public void a()
  {
    if (!this.g)
    {
      d();
      this.g = true;
    }
  }
  
  public void a(float paramFloat)
  {
    AEFilterManager localAEFilterManager = this.e;
    if (localAEFilterManager != null) {
      localAEFilterManager.setPhoneRoll(paramFloat);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((this.b != paramInt2) && (this.a != paramInt1))
    {
      this.b = paramInt2;
      this.a = paramInt1;
      AEFilterManager localAEFilterManager = this.e;
      if (localAEFilterManager != null) {
        localAEFilterManager.updateWidthHeight(paramInt1, paramInt2);
      }
    }
  }
  
  public void a(SensorEvent paramSensorEvent)
  {
    AEFilterManager localAEFilterManager = this.e;
    if (localAEFilterManager != null) {
      localAEFilterManager.setSensorEventToLight(paramSensorEvent);
    }
  }
  
  public void a(QQLiveCameraFilterInfo paramQQLiveCameraFilterInfo, QQLiveCameraFilterLoaderListener paramQQLiveCameraFilterLoaderListener)
  {
    QQLiveAEResManager.a().a(paramQQLiveCameraFilterInfo, new QQLiveAEFilterProcess.2(this, paramQQLiveCameraFilterLoaderListener));
  }
  
  public void a(String paramString, @IntRange(from=0L, to=100L) int paramInt, boolean paramBoolean)
  {
    paramString = BeautyRealConfig.TYPE.valueOf(paramString);
    if (paramBoolean)
    {
      this.e.setBeautyOrTransformLevel(paramString, paramInt);
      this.d.put(paramString, Integer.valueOf(paramInt));
      return;
    }
    this.e.setBeautyOrTransformLevel(paramString, 0);
    this.d.remove(paramString);
  }
  
  public void b()
  {
    if (this.g)
    {
      f();
      this.g = false;
    }
  }
  
  public boolean c()
  {
    return this.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.filter.QQLiveAEFilterProcess
 * JD-Core Version:    0.7.0.1
 */