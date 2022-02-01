package com.tencent.mobileqq.emoticonview.api.impl;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.Adapter;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.core.QQEmotionPanelManager;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.EmoticonPanelController;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.emoticonview.EmotionPanelInfo;
import com.tencent.mobileqq.emoticonview.EmotionPanelViewPagerAdapter;
import com.tencent.mobileqq.emoticonview.EmotionUtils;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.emoticonview.SmallEmotionDownloadedAdapter;
import com.tencent.mobileqq.emoticonview.api.IPanelDependListener;
import com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayer;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.XPanelContainer;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.List;

public class EmotionPanelDependListener
  implements IPanelDependListener
{
  private EmoticonInfo mPointInfo;
  private FrameLayout mPopupEmo;
  private ImageView mPopupEmoImage;
  private FrameLayout mWindowContent;
  private AudioPlayer player;
  private boolean showing = false;
  
  public ImageButton getDeleteButtonFromCache(int paramInt)
  {
    if ((QQEmotionPanelManager.a().a() instanceof EmoticonPanelController))
    {
      Object localObject = (EmoticonPanelController)QQEmotionPanelManager.a().a();
      if (localObject != null)
      {
        localObject = ((EmoticonPanelController)localObject).getPageAdapter();
        if (localObject != null) {
          return ((EmotionPanelViewPagerAdapter)localObject).getDeleteButtonFromCache(paramInt);
        }
      }
    }
    return null;
  }
  
  public int getLastSelectedSecondTabIndex()
  {
    return EmoticonPanelController.sLastSelectedSecondTabIndex;
  }
  
  public List<EmotionPanelInfo> getPanelDataList()
  {
    if ((QQEmotionPanelManager.a().a() instanceof EmoticonPanelController)) {
      return ((EmoticonPanelController)QQEmotionPanelManager.a().a()).getPanelDataList();
    }
    return null;
  }
  
  public int getmAddedHeight()
  {
    return XPanelContainer.d;
  }
  
  public void hidePopupWindow(Context paramContext, EmoticonCallback paramEmoticonCallback)
  {
    if ((this.mPopupEmo != null) && (this.showing))
    {
      ((WindowManager)paramContext.getSystemService("window")).removeViewImmediate(this.mWindowContent);
      if (this.player != null) {
        this.player.d();
      }
      if (paramEmoticonCallback != null) {
        paramEmoticonCallback.onHidePopup(this.mPointInfo);
      }
      this.showing = false;
    }
  }
  
  public boolean isSmallEmotionDownloadedAdapter(Adapter paramAdapter)
  {
    return paramAdapter instanceof SmallEmotionDownloadedAdapter;
  }
  
  public void removePopupGuide()
  {
    if ((QQEmotionPanelManager.a().a() instanceof EmoticonPanelController)) {
      ((EmoticonPanelController)QQEmotionPanelManager.a().a()).removePopupGuide();
    }
  }
  
  public void showPopupEmo(View paramView, EmoticonInfo paramEmoticonInfo, Rect paramRect, Context paramContext, EmoticonCallback paramEmoticonCallback)
  {
    Drawable localDrawable = paramEmoticonInfo.getBigDrawable(paramContext, paramContext.getResources().getDisplayMetrics().density);
    if (localDrawable == null) {
      return;
    }
    paramView.getGlobalVisibleRect(paramRect);
    int i = paramEmoticonInfo.type;
    if (this.mWindowContent == null)
    {
      this.mWindowContent = new FrameLayout(paramContext);
      this.mPopupEmo = new FrameLayout(paramContext);
      this.mPopupEmoImage = new ImageView(paramContext);
      this.mPopupEmoImage.setAdjustViewBounds(false);
      this.mPopupEmoImage.setScaleType(ImageView.ScaleType.FIT_CENTER);
      this.mWindowContent.addView(this.mPopupEmo);
      this.mPopupEmo.addView(this.mPopupEmoImage);
    }
    this.mPopupEmoImage.setImageDrawable(localDrawable);
    float f = paramContext.getResources().getDisplayMetrics().density;
    int k = (int)(5.0F * f);
    paramView = (FrameLayout.LayoutParams)this.mPopupEmoImage.getLayoutParams();
    int j;
    if ((i == 1) || (i == 2) || (i == 7) || (i == 10))
    {
      j = (int)(64.0F * f);
      i = (int)(71.0F * f);
      this.mPopupEmo.setBackgroundResource(2130850947);
      this.mPopupEmo.setPadding(k, k, k, k);
      paramView.width = ((int)(28.0F * f));
      paramView.height = ((int)(28.0F * f));
      paramView.bottomMargin = ((int)(6.0F * f));
      paramView.gravity = 17;
      label266:
      paramView = (FrameLayout.LayoutParams)this.mPopupEmo.getLayoutParams();
      paramView.gravity = 51;
      paramView.leftMargin = (paramRect.left - (j - paramRect.width()) / 2);
      paramView.topMargin = (paramRect.top - i - (int)(15.0F * f));
      paramView.width = j;
      paramView.height = i;
      if (!this.showing) {
        break label673;
      }
      this.mPopupEmo.requestLayout();
    }
    for (;;)
    {
      paramView = this.mPointInfo;
      this.mPointInfo = paramEmoticonInfo;
      if ((paramView != null) && (paramView.type == 6) && ((paramView instanceof PicEmoticonInfo)) && (this.player != null)) {
        this.player.d();
      }
      if ((paramEmoticonInfo.type == 6) && ((paramEmoticonInfo instanceof PicEmoticonInfo)) && ((localDrawable instanceof URLDrawable)))
      {
        paramRect = (PicEmoticonInfo)paramEmoticonInfo;
        if (paramRect.isSound())
        {
          String str = EmoticonUtils.emoticonSoundPath.replace("[epId]", paramRect.emoticon.epId).replace("[eId]", paramRect.emoticon.eId);
          if (this.player == null) {
            this.player = new AudioPlayer(paramContext, null);
          }
          this.player.b(17);
          this.player.a(str);
          EmotionUtils.startSoundDrawablePlay((URLDrawable)localDrawable);
        }
        if (2 == paramRect.emoticon.jobType) {
          ReportController.b(null, "CliOper", "", "", "MbYulan", "MbChangan", 0, 0, paramRect.emoticon.epId, "", "", "");
        }
      }
      if (paramEmoticonCallback == null) {
        break;
      }
      paramEmoticonCallback.onShowPopup(paramView, paramEmoticonInfo, localDrawable);
      return;
      j = (int)(110.0F * f);
      i = (int)(110.0F * f);
      this.mPopupEmo.setBackgroundResource(2130850946);
      this.mPopupEmo.setPadding(k, k, k, k);
      paramView.bottomMargin = 0;
      paramView.width = ((int)(100.0F * f));
      paramView.height = ((int)(100.0F * f));
      ReportController.b(null, "CliOper", "", "", "ep_mall", "ep_preview", 0, 0, "", "", "", "");
      break label266;
      label673:
      paramView = (WindowManager)paramContext.getSystemService("window");
      i = 24;
      if (ImmersiveUtils.isSupporImmersive() == 1) {
        i = 67108888;
      }
      paramRect = new WindowManager.LayoutParams(-1, -1, 2, i, -3);
      paramView.addView(this.mWindowContent, paramRect);
      this.showing = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.api.impl.EmotionPanelDependListener
 * JD-Core Version:    0.7.0.1
 */