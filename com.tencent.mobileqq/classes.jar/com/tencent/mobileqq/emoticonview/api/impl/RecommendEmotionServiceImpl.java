package com.tencent.mobileqq.emoticonview.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.PromotionEmoticonPkg;
import com.tencent.mobileqq.emoticon.IFindEmotionPackageListener;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanelApp;
import com.tencent.mobileqq.emoticonview.api.IRecommendEmotionService;
import com.tencent.mobileqq.emoticonview.ipc.proxy.EmoticonManagerProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.VasQuickUpdateManagerProxy;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.vas.updatesystem.callback.CallBacker;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.List;

public class RecommendEmotionServiceImpl
  implements IRecommendEmotionService<PromotionEmoticonPkg>
{
  public void asyncFindEmoticonPackage(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, int paramInt1, int paramInt2, String paramString, int paramInt3, IFindEmotionPackageListener paramIFindEmotionPackageListener)
  {
    ((EmoticonManagerProxy)paramIEmoticonMainPanelApp.getManager(QQManagerFactory.EMOTICON_MANAGER)).asyncFindEmoticonPackage(paramString, paramInt3, new RecommendEmotionServiceImpl.1(this, paramIEmoticonMainPanelApp, paramInt1, paramString, paramInt2, paramIFindEmotionPackageListener));
  }
  
  public URLDrawable getApngDrawable(Drawable paramDrawable, String paramString, int paramInt)
  {
    try
    {
      paramString = new URL("vasapngdownloader", paramString, "local_recommendEffect");
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mUseApngImage = true;
      localURLDrawableOptions.mRequestHeight = paramInt;
      localURLDrawableOptions.mRequestWidth = paramInt;
      localURLDrawableOptions.mLoadingDrawable = paramDrawable;
      localURLDrawableOptions.mFailedDrawable = paramDrawable;
      paramDrawable = new Bundle();
      paramDrawable.putInt("key_loop", 1);
      paramDrawable.putBoolean("key_once_clear", true);
      paramDrawable.putLong("bundle_key_bid", 1003L);
      paramDrawable.putString("bundle_key_scid", "emotionRecommendEffect");
      localURLDrawableOptions.mExtraInfo = paramDrawable;
      paramDrawable = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
      return paramDrawable;
    }
    catch (Exception paramDrawable)
    {
      QLog.d("RecommendEmotionServiceImpl", 2, "getApngDrawable exception = " + paramDrawable.getMessage());
    }
    return null;
  }
  
  public String getEmotionScid()
  {
    return "emotionRecommendEffect";
  }
  
  public long getPicBid()
  {
    return 1003L;
  }
  
  public List<PromotionEmoticonPkg> getProEmoticonPkgs(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    return ((EmoticonManagerProxy)paramIEmoticonMainPanelApp.getManager(QQManagerFactory.EMOTICON_MANAGER)).getProEmoticonPkgs(paramBoolean1, paramInt, paramBoolean2);
  }
  
  public boolean isAIOBusiness(int paramInt)
  {
    return paramInt == 0;
  }
  
  public boolean isColorNick(int paramInt)
  {
    return paramInt == 2;
  }
  
  public boolean isKanDianBusiness(int paramInt)
  {
    return paramInt == 1;
  }
  
  public void openEmoticonDetailPage(Context paramContext, IEmoticonMainPanelApp paramIEmoticonMainPanelApp, PromotionEmoticonPkg paramPromotionEmoticonPkg, int paramInt)
  {
    boolean bool = true;
    Intent localIntent1 = null;
    if (paramPromotionEmoticonPkg.type == 4)
    {
      localIntent1 = new Intent();
      localIntent1.putExtra("EXTRA_KEY_IS_SMALL_EMOTICON", true);
    }
    Intent localIntent2;
    if (paramInt == 1)
    {
      localIntent2 = localIntent1;
      if (localIntent1 == null) {
        localIntent2 = new Intent();
      }
      localIntent2.putExtra("EXTRA_KEY_IS_KANDIAN_EMOTICON", true);
    }
    for (;;)
    {
      if ((paramContext instanceof Activity))
      {
        if (paramPromotionEmoticonPkg.type == 4) {}
        for (;;)
        {
          EmojiHomeUiPlugin.openEmojiDetailPage(paramContext, paramIEmoticonMainPanelApp, paramIEmoticonMainPanelApp.getAccount(), 8, paramPromotionEmoticonPkg.id, false, localIntent2, bool);
          return;
          bool = false;
        }
      }
      QLog.e("RecommendEmotionServiceImpl", 1, "openEmoticonDetailPage error : context not activity");
      return;
      localIntent2 = localIntent1;
    }
  }
  
  public void recordRecommendEpExpose(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, PromotionEmoticonPkg paramPromotionEmoticonPkg)
  {
    ((EmoticonManagerProxy)paramIEmoticonMainPanelApp.getManager(QQManagerFactory.EMOTICON_MANAGER)).recordRecommendEpExpose(paramPromotionEmoticonPkg);
  }
  
  public void removeCallBacker(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, CallBacker paramCallBacker)
  {
    if (paramIEmoticonMainPanelApp != null) {
      ((VasQuickUpdateManagerProxy)paramIEmoticonMainPanelApp.getManager(QQManagerFactory.VAS_QUICKUPDATE_MANAGER)).removeCallBacker(paramCallBacker);
    }
  }
  
  public void sendRecommendSSORequest(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, int paramInt)
  {
    EmoticonManager.a(paramIEmoticonMainPanelApp, paramInt);
  }
  
  public void setRecommendEpRedFlag(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, String paramString, int paramInt)
  {
    ((EmoticonManagerProxy)paramIEmoticonMainPanelApp.getManager(QQManagerFactory.EMOTICON_MANAGER)).setRecommendEpRedFlag(paramString, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.api.impl.RecommendEmotionServiceImpl
 * JD-Core Version:    0.7.0.1
 */