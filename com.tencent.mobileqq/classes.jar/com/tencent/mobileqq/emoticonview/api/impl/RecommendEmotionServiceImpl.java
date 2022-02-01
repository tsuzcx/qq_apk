package com.tencent.mobileqq.emoticonview.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.aio.core.BaseAIOContext;
import com.tencent.mobileqq.activity.aio.helper.SpecWordEmotionThinkHelper;
import com.tencent.mobileqq.activity.aio.helper.StickerRecHelper;
import com.tencent.mobileqq.data.PromotionEmoticonPkg;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanelApp;
import com.tencent.mobileqq.emoticonview.api.IRecommendEmotionService;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.qphone.base.util.QLog;

public class RecommendEmotionServiceImpl
  implements IRecommendEmotionService<PromotionEmoticonPkg>
{
  public void clearSpecWordType(BaseAIOContext paramBaseAIOContext)
  {
    ((SpecWordEmotionThinkHelper)paramBaseAIOContext.a(41)).b();
  }
  
  public String getSpecKeyWord(BaseAIOContext paramBaseAIOContext)
  {
    return ((SpecWordEmotionThinkHelper)paramBaseAIOContext.a(41)).d();
  }
  
  public void onEmotionKeywordDimiss(BaseAIOContext paramBaseAIOContext)
  {
    paramBaseAIOContext = (StickerRecHelper)paramBaseAIOContext.a(14);
    if (paramBaseAIOContext != null) {
      paramBaseAIOContext.d();
    }
  }
  
  public void openEmoticonDetailPage(Context paramContext, IEmoticonMainPanelApp paramIEmoticonMainPanelApp, PromotionEmoticonPkg paramPromotionEmoticonPkg, int paramInt)
  {
    Intent localIntent1;
    if (paramPromotionEmoticonPkg.type == 4)
    {
      localIntent1 = new Intent();
      localIntent1.putExtra("EXTRA_KEY_IS_SMALL_EMOTICON", true);
    }
    else
    {
      localIntent1 = null;
    }
    Intent localIntent2 = localIntent1;
    if (paramInt == 1)
    {
      localIntent2 = localIntent1;
      if (localIntent1 == null) {
        localIntent2 = new Intent();
      }
      localIntent2.putExtra("EXTRA_KEY_IS_KANDIAN_EMOTICON", true);
    }
    if ((paramContext instanceof Activity))
    {
      boolean bool;
      if (paramPromotionEmoticonPkg.type == 4) {
        bool = true;
      } else {
        bool = false;
      }
      EmojiHomeUiPlugin.openEmojiDetailPage(paramContext, paramIEmoticonMainPanelApp, paramIEmoticonMainPanelApp.getAccount(), 8, paramPromotionEmoticonPkg.id, false, localIntent2, bool);
      return;
    }
    QLog.e("RecommendEmotionServiceImpl", 1, "openEmoticonDetailPage error : context not activity");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.api.impl.RecommendEmotionServiceImpl
 * JD-Core Version:    0.7.0.1
 */