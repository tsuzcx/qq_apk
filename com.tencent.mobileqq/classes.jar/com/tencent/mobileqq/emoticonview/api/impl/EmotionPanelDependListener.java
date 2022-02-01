package com.tencent.mobileqq.emoticonview.api.impl;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.EmotionPanelConstans;
import com.tencent.mobileqq.emoticonview.EmotionUtils;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.emoticonview.api.IPanelDependListener;
import com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayer;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.immersive.ImmersiveUtils;

public class EmotionPanelDependListener
  implements IPanelDependListener
{
  private EmoticonInfo mPointInfo;
  private FrameLayout mPopupEmo;
  private ImageView mPopupEmoImage;
  private FrameLayout mWindowContent;
  private AudioPlayer player;
  private boolean showing = false;
  
  public void hidePopupWindow(Context paramContext, EmoticonCallback paramEmoticonCallback)
  {
    if ((this.mPopupEmo != null) && (this.showing))
    {
      ((WindowManager)paramContext.getSystemService("window")).removeViewImmediate(this.mWindowContent);
      paramContext = this.player;
      if (paramContext != null) {
        paramContext.c();
      }
      if (paramEmoticonCallback != null) {
        paramEmoticonCallback.onHidePopup(this.mPointInfo);
      }
      this.showing = false;
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
    if ((i != 1) && (i != 2) && (i != 7) && (i != 10))
    {
      i = (int)(110.0F * f);
      this.mPopupEmo.setBackgroundResource(2130850886);
      this.mPopupEmo.setPadding(k, k, k, k);
      paramView.bottomMargin = 0;
      j = (int)(100.0F * f);
      paramView.width = j;
      paramView.height = j;
      ReportController.b(null, "CliOper", "", "", "ep_mall", "ep_preview", 0, 0, "", "", "", "");
      j = i;
    }
    else
    {
      i = (int)(64.0F * f);
      j = (int)(71.0F * f);
      this.mPopupEmo.setBackgroundResource(2130850887);
      this.mPopupEmo.setPadding(k, k, k, k);
      k = (int)(28.0F * f);
      paramView.width = k;
      paramView.height = k;
      paramView.bottomMargin = ((int)(6.0F * f));
      paramView.gravity = 17;
    }
    paramView = (FrameLayout.LayoutParams)this.mPopupEmo.getLayoutParams();
    paramView.gravity = 51;
    paramView.leftMargin = (paramRect.left - (i - paramRect.width()) / 2);
    paramView.topMargin = (paramRect.top - j - (int)(f * 15.0F));
    paramView.width = i;
    paramView.height = j;
    if (this.showing)
    {
      this.mPopupEmo.requestLayout();
    }
    else
    {
      paramView = (WindowManager)paramContext.getSystemService("window");
      if (ImmersiveUtils.isSupporImmersive() == 1) {
        i = 67108888;
      } else {
        i = 24;
      }
      paramRect = new WindowManager.LayoutParams(-1, -1, 2, i, -3);
      paramView.addView(this.mWindowContent, paramRect);
      this.showing = true;
    }
    paramView = this.mPointInfo;
    this.mPointInfo = paramEmoticonInfo;
    if ((paramView != null) && (paramView.type == 6) && ((paramView instanceof PicEmoticonInfo)))
    {
      paramRect = this.player;
      if (paramRect != null) {
        paramRect.c();
      }
    }
    if ((paramEmoticonInfo.type == 6) && ((paramEmoticonInfo instanceof PicEmoticonInfo)) && ((localDrawable instanceof URLDrawable)))
    {
      paramRect = (PicEmoticonInfo)paramEmoticonInfo;
      if (paramRect.isSound())
      {
        String str = EmotionPanelConstans.emoticonSoundPath.replace("[epId]", paramRect.emoticon.epId).replace("[eId]", paramRect.emoticon.eId);
        if (this.player == null) {
          this.player = new AudioPlayer(paramContext, null);
        }
        this.player.a(17);
        this.player.a(str);
        EmotionUtils.startSoundDrawablePlay((URLDrawable)localDrawable);
      }
      if (2 == paramRect.emoticon.jobType) {
        ReportController.b(null, "CliOper", "", "", "MbYulan", "MbChangan", 0, 0, paramRect.emoticon.epId, "", "", "");
      }
    }
    if (paramEmoticonCallback != null) {
      paramEmoticonCallback.onShowPopup(paramView, paramEmoticonInfo, localDrawable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.api.impl.EmotionPanelDependListener
 * JD-Core Version:    0.7.0.1
 */