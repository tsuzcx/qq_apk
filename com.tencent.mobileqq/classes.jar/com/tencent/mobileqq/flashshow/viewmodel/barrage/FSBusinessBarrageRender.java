package com.tencent.mobileqq.flashshow.viewmodel.barrage;

import android.content.Context;
import com.tencent.mobileqq.flashshow.viewmodel.barrage.holder.FSBaseBarrageHolder;
import com.tencent.mobileqq.flashshow.viewmodel.barrage.holder.FSHotBarrageHolder;
import com.tencent.mobileqq.flashshow.viewmodel.barrage.holder.FSNormalBarrageHolder;
import com.tencent.mobileqq.flashshow.viewmodel.barrage.holder.FSReplayBarrageHolder;
import com.tencent.mobileqq.flashshow.viewmodel.barrage.holder.bean.BarrageHolderParam;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rfw.barrage.data.RFWBaseBarrage;
import com.tencent.rfw.barrage.data.RFWViewBarrage;
import com.tencent.rfw.barrage.render.RFWViewBarrageRender;
import com.tencent.rfw.barrage.render.RFWViewBarrageRender.ViewHolder;
import java.lang.ref.WeakReference;

public class FSBusinessBarrageRender
  extends RFWViewBarrageRender
{
  private WeakReference<Context> a = null;
  
  public FSBusinessBarrageRender(Context paramContext)
  {
    this.a = new WeakReference(paramContext);
  }
  
  private Context b()
  {
    WeakReference localWeakReference = this.a;
    if (localWeakReference == null) {
      return null;
    }
    return (Context)localWeakReference.get();
  }
  
  public int a(Object paramObject)
  {
    return FSBarrageViewTypeUtils.a(paramObject);
  }
  
  public RFWViewBarrageRender.ViewHolder a(int paramInt)
  {
    Context localContext = b();
    if (localContext == null)
    {
      QLog.d("DM-FSBusinessBarrageRender", 1, "[onCreateViewHolder] context should not be null.");
      return null;
    }
    if (paramInt == 1) {
      return new FSNormalBarrageHolder(localContext);
    }
    if (paramInt == 2) {
      return new FSHotBarrageHolder(localContext);
    }
    if (paramInt == 3) {
      return new FSReplayBarrageHolder(localContext);
    }
    return null;
  }
  
  public void a(int paramInt, RFWViewBarrageRender.ViewHolder paramViewHolder, RFWViewBarrage paramRFWViewBarrage)
  {
    if (!(paramViewHolder instanceof FSBaseBarrageHolder))
    {
      QLog.d("DM-FSBusinessBarrageRender", 1, "[onBindViewHolder] current view holder not is FSBaseBarrageHolder type.");
      return;
    }
    if (paramRFWViewBarrage == null)
    {
      QLog.d("DM-FSBusinessBarrageRender", 1, "[onBindViewHolder] danmaku should not be null.");
      return;
    }
    paramRFWViewBarrage = (BarrageHolderParam)paramRFWViewBarrage.r();
    if (paramRFWViewBarrage == null)
    {
      QLog.d("DM-FSBusinessBarrageRender", 1, "[onBindViewHolder] param should not be null.");
      return;
    }
    ((FSBaseBarrageHolder)paramViewHolder).a(paramRFWViewBarrage);
  }
  
  public boolean a(RFWBaseBarrage paramRFWBaseBarrage)
  {
    return paramRFWBaseBarrage instanceof RFWBaseBarrage;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.viewmodel.barrage.FSBusinessBarrageRender
 * JD-Core Version:    0.7.0.1
 */