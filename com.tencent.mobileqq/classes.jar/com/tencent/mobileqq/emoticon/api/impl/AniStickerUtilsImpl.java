package com.tencent.mobileqq.emoticon.api.impl;

import android.content.Context;
import android.widget.PopupWindow;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.richmedia.Size;
import com.tencent.mobileqq.core.util.EmotionSharedPreUtils;
import com.tencent.mobileqq.emoticon.IAniStickerAIOOperation;
import com.tencent.mobileqq.emoticon.SysEmoAniStickerAIOOperation;
import com.tencent.mobileqq.emoticon.api.IAniStickerUtils;
import com.tencent.mobileqq.emoticonview.AniStickerPreGuideView;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.NotNull;

public class AniStickerUtilsImpl
  implements IAniStickerUtils
{
  private static final String KEY_SHOW_ANI_STICKER_PRE_GUIDE = "key_show_anisticker_pre_guide";
  
  public boolean checkIsNeedShowAniStickerPreGuide()
  {
    int i = getAniStickerPreGuideShowNumInner().intValue();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkIsNeedShowAniStickerPreGuide, showNum = ");
      localStringBuilder.append(i);
      QLog.d("timweiliu_emolog", 2, localStringBuilder.toString());
    }
    return i < 3;
  }
  
  public IAniStickerAIOOperation createAniStickerAIOOperation(int paramInt, Context paramContext, BaseQQAppInterface paramBaseQQAppInterface, BaseSessionInfo paramBaseSessionInfo)
  {
    if (paramInt == 1) {
      return new SysEmoAniStickerAIOOperation(paramContext, paramBaseQQAppInterface, paramBaseSessionInfo);
    }
    return null;
  }
  
  public PopupWindow createAniStickerPreGuideView(Context paramContext)
  {
    paramContext = createAniStickerPreGuideViewInner(paramContext);
    paramContext.initUI();
    return paramContext;
  }
  
  @NotNull
  protected AniStickerPreGuideView createAniStickerPreGuideViewInner(Context paramContext)
  {
    return new AniStickerPreGuideView(paramContext);
  }
  
  protected Integer getAniStickerPreGuideShowNumInner()
  {
    return (Integer)EmotionSharedPreUtils.b("key_show_anisticker_pre_guide", Integer.valueOf(0));
  }
  
  public Size getAniStickerPreGuideViewSize()
  {
    return new Size(ViewUtils.dpToPx(200.0F), ViewUtils.dpToPx(42.0F));
  }
  
  public void notifyAniStickerPreGuideShow()
  {
    int i = getAniStickerPreGuideShowNumInner().intValue() + 1;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("notifyAniStickerPreGuideShow, showNum = ");
      localStringBuilder.append(i);
      QLog.d("timweiliu_emolog", 2, localStringBuilder.toString());
    }
    EmotionSharedPreUtils.a("key_show_anisticker_pre_guide", Integer.valueOf(i));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.api.impl.AniStickerUtilsImpl
 * JD-Core Version:    0.7.0.1
 */