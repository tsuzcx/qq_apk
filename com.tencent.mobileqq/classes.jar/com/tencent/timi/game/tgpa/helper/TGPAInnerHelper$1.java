package com.tencent.timi.game.tgpa.helper;

import com.tencent.timi.game.tgpa.TGPAUtil.TGPAGameDataCallback;
import com.tencent.timi.game.utils.Logger;
import java.util.Iterator;
import java.util.List;

class TGPAInnerHelper$1
  implements TGPAUtil.TGPAGameDataCallback
{
  TGPAInnerHelper$1(TGPAInnerHelper paramTGPAInnerHelper) {}
  
  public void a(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("tgpaService###callback#onGameSceneChanged - ");
    ((StringBuilder)localObject).append(paramInt);
    Logger.a("CyminiTGPAHelper", ((StringBuilder)localObject).toString());
    if ((TGPAInnerHelper.a(this.a) != null) && (TGPAInnerHelper.a(this.a).size() > 0))
    {
      localObject = TGPAInnerHelper.a(this.a).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((TGPAUtil.TGPAGameDataCallback)((Iterator)localObject).next()).a(paramInt);
      }
    }
  }
  
  public void a(int paramInt, float paramFloat)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("tgpaService###callback#onResourceUpdateProgress - ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" - ");
    ((StringBuilder)localObject).append(paramFloat);
    Logger.a("CyminiTGPAHelper", ((StringBuilder)localObject).toString());
    if ((TGPAInnerHelper.a(this.a) != null) && (TGPAInnerHelper.a(this.a).size() > 0))
    {
      localObject = TGPAInnerHelper.a(this.a).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((TGPAUtil.TGPAGameDataCallback)((Iterator)localObject).next()).a(paramInt, paramFloat);
      }
    }
  }
  
  public void a(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("tgpaService###callback#onReceiveGameVersion - ");
    ((StringBuilder)localObject).append(paramString);
    Logger.a("CyminiTGPAHelper", ((StringBuilder)localObject).toString());
    if ((TGPAInnerHelper.a(this.a) != null) && (TGPAInnerHelper.a(this.a).size() > 0))
    {
      localObject = TGPAInnerHelper.a(this.a).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((TGPAUtil.TGPAGameDataCallback)((Iterator)localObject).next()).a(paramString);
      }
    }
  }
  
  public void a(String paramString, Object paramObject)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("tgpaService###callback#onReceiveCustomData - ");
    ((StringBuilder)localObject).append(paramObject);
    Logger.a("CyminiTGPAHelper", ((StringBuilder)localObject).toString());
    if ((TGPAInnerHelper.a(this.a) != null) && (TGPAInnerHelper.a(this.a).size() > 0))
    {
      localObject = TGPAInnerHelper.a(this.a).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((TGPAUtil.TGPAGameDataCallback)((Iterator)localObject).next()).a(paramString, paramObject);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("tgpaService###callback#onGameVoiceSwitch - ");
    ((StringBuilder)localObject).append(paramBoolean);
    Logger.a("CyminiTGPAHelper", ((StringBuilder)localObject).toString());
    if ((TGPAInnerHelper.a(this.a) != null) && (TGPAInnerHelper.a(this.a).size() > 0))
    {
      localObject = TGPAInnerHelper.a(this.a).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((TGPAUtil.TGPAGameDataCallback)((Iterator)localObject).next()).a(paramBoolean);
      }
    }
  }
  
  public void b(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("tgpaService###callback#onReceiveResourceVersion - ");
    ((StringBuilder)localObject).append(paramString);
    Logger.a("CyminiTGPAHelper", ((StringBuilder)localObject).toString());
    if ((TGPAInnerHelper.a(this.a) != null) && (TGPAInnerHelper.a(this.a).size() > 0))
    {
      localObject = TGPAInnerHelper.a(this.a).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((TGPAUtil.TGPAGameDataCallback)((Iterator)localObject).next()).b(paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.tgpa.helper.TGPAInnerHelper.1
 * JD-Core Version:    0.7.0.1
 */