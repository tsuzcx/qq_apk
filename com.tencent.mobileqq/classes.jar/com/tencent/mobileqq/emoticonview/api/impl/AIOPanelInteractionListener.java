package com.tencent.mobileqq.emoticonview.api.impl;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.tencent.mobileqq.AIODepend.IPanelInteractionListener;
import com.tencent.mobileqq.AIODepend.IPanelInteractionListener.InterceptListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.core.BaseAIOContext;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.BaseTroopChatPie;
import com.tencent.mobileqq.activity.aio.core.DiscussChatPie;
import com.tencent.mobileqq.activity.aio.core.FriendChatPie;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout.InterceptListener;
import com.tencent.mobileqq.emosm.IAIOEmoticonUIHelper;
import com.tencent.mobileqq.emoticonview.AIOPopOutEmoticonConfig;
import com.tencent.mobileqq.popanim.PopOutAnimConfig;

public class AIOPanelInteractionListener
  implements IPanelInteractionListener, PanelIconLinearLayout.InterceptListener
{
  private BaseChatPie baseChatPie;
  private IPanelInteractionListener.InterceptListener interceptListener;
  private AIOPopOutEmoticonConfig popOutConfig;
  
  public AIOPanelInteractionListener(BaseChatPie paramBaseChatPie)
  {
    this.baseChatPie = paramBaseChatPie;
  }
  
  public void addView(View paramView)
  {
    BaseChatPie localBaseChatPie = this.baseChatPie;
    if (localBaseChatPie != null) {
      localBaseChatPie.c(paramView);
    }
  }
  
  public BaseAIOContext getAIOContext()
  {
    BaseChatPie localBaseChatPie = this.baseChatPie;
    if (localBaseChatPie != null) {
      return localBaseChatPie.bv();
    }
    return null;
  }
  
  public IAIOEmoticonUIHelper getAIOEmoticonUIHelper()
  {
    BaseChatPie localBaseChatPie = this.baseChatPie;
    if (localBaseChatPie != null) {
      return (IAIOEmoticonUIHelper)localBaseChatPie.q(105);
    }
    return null;
  }
  
  public EditText getAIOInput()
  {
    BaseChatPie localBaseChatPie = this.baseChatPie;
    if (localBaseChatPie != null) {
      return localBaseChatPie.Y;
    }
    return null;
  }
  
  public ViewGroup getAIORootView()
  {
    BaseChatPie localBaseChatPie = this.baseChatPie;
    if (localBaseChatPie != null) {
      return localBaseChatPie.aZ;
    }
    return null;
  }
  
  public Object getBaseChatPie()
  {
    return this.baseChatPie;
  }
  
  public String getCurFriendUin()
  {
    BaseChatPie localBaseChatPie = this.baseChatPie;
    if ((localBaseChatPie != null) && (localBaseChatPie.aE() != null)) {
      return this.baseChatPie.aE().b;
    }
    return null;
  }
  
  public int getCurType()
  {
    BaseChatPie localBaseChatPie = this.baseChatPie;
    if ((localBaseChatPie != null) && (localBaseChatPie.aE() != null)) {
      return this.baseChatPie.aE().a;
    }
    return -1;
  }
  
  public int getPanelChatPieType()
  {
    BaseChatPie localBaseChatPie = this.baseChatPie;
    if ((localBaseChatPie instanceof FriendChatPie)) {
      return 1;
    }
    if ((localBaseChatPie instanceof BaseTroopChatPie)) {
      return 2;
    }
    if ((localBaseChatPie instanceof DiscussChatPie)) {
      return 3;
    }
    return 0;
  }
  
  public ViewGroup getPanelicons()
  {
    BaseChatPie localBaseChatPie = this.baseChatPie;
    if (localBaseChatPie != null) {
      return localBaseChatPie.W;
    }
    return null;
  }
  
  public PopOutAnimConfig getPopOutAnimConfig()
  {
    if (this.popOutConfig == null)
    {
      this.popOutConfig = new AIOPopOutEmoticonConfig(this.baseChatPie, null);
      this.popOutConfig.init();
    }
    return this.popOutConfig;
  }
  
  public int getRootViewHeight()
  {
    BaseChatPie localBaseChatPie = this.baseChatPie;
    if (localBaseChatPie != null) {
      return localBaseChatPie.bw();
    }
    return 0;
  }
  
  public boolean handleTouchEvent(MotionEvent paramMotionEvent)
  {
    IPanelInteractionListener.InterceptListener localInterceptListener = this.interceptListener;
    if (localInterceptListener != null) {
      return localInterceptListener.handleTouchEvent(paramMotionEvent);
    }
    return false;
  }
  
  public boolean interceptTouchEvent(MotionEvent paramMotionEvent)
  {
    IPanelInteractionListener.InterceptListener localInterceptListener = this.interceptListener;
    if (localInterceptListener != null) {
      return localInterceptListener.interceptTouchEvent(paramMotionEvent);
    }
    return false;
  }
  
  public void onTouchEvent(MotionEvent paramMotionEvent)
  {
    BaseChatPie localBaseChatPie = this.baseChatPie;
    if (localBaseChatPie != null) {
      localBaseChatPie.d(paramMotionEvent);
    }
  }
  
  public void removeEmoticonGuideBubble()
  {
    BaseChatPie localBaseChatPie = this.baseChatPie;
    if (localBaseChatPie != null) {
      localBaseChatPie.I();
    }
  }
  
  public void removeView(View paramView)
  {
    BaseChatPie localBaseChatPie = this.baseChatPie;
    if (localBaseChatPie != null) {
      localBaseChatPie.d(paramView);
    }
  }
  
  public void setPaneliconsInterceptListener(IPanelInteractionListener.InterceptListener paramInterceptListener)
  {
    Object localObject = this.baseChatPie;
    if ((localObject != null) && (((BaseChatPie)localObject).W != null))
    {
      this.interceptListener = paramInterceptListener;
      localObject = this.baseChatPie.W;
      if (paramInterceptListener != null) {
        paramInterceptListener = this;
      } else {
        paramInterceptListener = null;
      }
      ((PanelIconLinearLayout)localObject).setInterceptListener(paramInterceptListener);
    }
  }
  
  public void setPaneliconsShowRed(int paramInt, boolean paramBoolean)
  {
    BaseChatPie localBaseChatPie = this.baseChatPie;
    if ((localBaseChatPie != null) && (localBaseChatPie.W != null)) {
      this.baseChatPie.W.setShowRed(paramInt, paramBoolean);
    }
  }
  
  public void stickerEditMode(boolean paramBoolean)
  {
    BaseChatPie localBaseChatPie = this.baseChatPie;
    if (localBaseChatPie != null) {
      localBaseChatPie.l(paramBoolean);
    }
  }
  
  public void stopAnimationConatiner()
  {
    Object localObject = this.baseChatPie;
    if (localObject != null)
    {
      localObject = ((BaseChatPie)localObject).bi();
      if (localObject != null) {
        ((AIOAnimationConatiner)localObject).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.api.impl.AIOPanelInteractionListener
 * JD-Core Version:    0.7.0.1
 */