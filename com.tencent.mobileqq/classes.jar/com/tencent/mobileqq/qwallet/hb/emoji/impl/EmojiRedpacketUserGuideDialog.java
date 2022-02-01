package com.tencent.mobileqq.qwallet.hb.emoji.impl;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;

public class EmojiRedpacketUserGuideDialog
  extends Dialog
{
  public static String a = "https://i.gtimg.cn/channel/imglib/201904/upload_13e561ae68d934abd06b8b6830d99754.png";
  private static final String b = "EmojiRedpacketUserGuideDialog";
  
  public EmojiRedpacketUserGuideDialog(Context paramContext)
  {
    this(paramContext, 0);
  }
  
  public EmojiRedpacketUserGuideDialog(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    try
    {
      super.setContentView(new EmojiRedpacketUserGuideDialog.UserGuidView(this, getContext()));
      paramBundle = getWindow();
      if (paramBundle != null)
      {
        paramBundle.setLayout(-1, -1);
        paramBundle.setBackgroundDrawable(new ColorDrawable(0));
        if (ImmersiveUtils.isSupporImmersive() == 1) {
          paramBundle.addFlags(67108864);
        }
      }
      super.setCancelable(true);
      return;
    }
    catch (OutOfMemoryError|Exception paramBundle) {}
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      try
      {
        super.cancel();
      }
      catch (Exception paramKeyEvent)
      {
        if (QLog.isDevelopLevel()) {
          paramKeyEvent.printStackTrace();
        }
      }
      return false;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.emoji.impl.EmojiRedpacketUserGuideDialog
 * JD-Core Version:    0.7.0.1
 */