package com.tencent.mobileqq.emoticonview;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.item.PokeItemHelper;
import com.tencent.mobileqq.activity.aio.stickerbubble.PEPanelHelper;
import com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleAnimationHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.popanim.PopOutAnimConfig;
import com.tencent.mobileqq.vas.VasApngIPCModule;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;

public class AIOPopOutEmoticonConfig
  extends PopOutAnimConfig
{
  private static final String TAG = "AIOPopOutEmoticonConfig";
  private WeakReference<BaseChatPie> weakChatPie;
  private WeakReference<ViewGroup> weakRootView;
  
  public AIOPopOutEmoticonConfig(BaseChatPie paramBaseChatPie, ViewGroup paramViewGroup)
  {
    if (paramBaseChatPie != null)
    {
      this.weakChatPie = new WeakReference(paramBaseChatPie);
      return;
    }
    if (paramViewGroup != null) {
      this.weakRootView = new WeakReference(paramViewGroup);
    }
  }
  
  private View getAFRootView()
  {
    WeakReference localWeakReference = this.weakChatPie;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      return ((BaseChatPie)this.weakChatPie.get()).d;
    }
    localWeakReference = this.weakRootView;
    if (localWeakReference != null) {
      return (View)localWeakReference.get();
    }
    return null;
  }
  
  public void init()
  {
    Object localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if ((localObject instanceof QQAppInterface)) {
      localObject = (QQAppInterface)localObject;
    } else {
      localObject = null;
    }
    this.itemCountShowAppear = StickerBubbleAnimationHelper.a((QQAppInterface)localObject);
    this.itemCountRecShowAppear = StickerBubbleAnimationHelper.a((QQAppInterface)localObject);
    this.supportFeedBack = PokeItemHelper.b(null);
    this.maxSendCount = PokeItemHelper.b((QQAppInterface)localObject, 10);
    this.apngSoLoaded = VasApngIPCModule.a().isLoaded();
    if (!this.apngSoLoaded) {
      ThreadManager.excute(new AIOPopOutEmoticonConfig.1(this), 64, null, false);
    }
    if (PEPanelHelper.a == null) {
      PEPanelHelper.b();
    }
    this.typeface = PEPanelHelper.a;
  }
  
  public void sendPopEmoMsg(SystemAndEmojiEmoticonInfo paramSystemAndEmojiEmoticonInfo, int paramInt)
  {
    Object localObject = this.weakChatPie;
    if ((localObject != null) && (((WeakReference)localObject).get() != null))
    {
      localObject = (BaseChatPie)this.weakChatPie.get();
      ChatActivityFacade.a(((BaseChatPie)localObject).a(), ((BaseChatPie)localObject).a(), paramInt, paramSystemAndEmojiEmoticonInfo);
    }
  }
  
  public void startShakeAnimation()
  {
    View localView = getAFRootView();
    if (localView != null) {
      StickerBubbleAnimationHelper.b(this, localView);
    }
  }
  
  public void stopShakeAnimation()
  {
    View localView = getAFRootView();
    if (localView != null) {
      StickerBubbleAnimationHelper.a(this, localView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.AIOPopOutEmoticonConfig
 * JD-Core Version:    0.7.0.1
 */