package io.flutter.plugin.platform;

import android.app.Activity;
import android.app.ActivityManager.TaskDescription;
import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipboardManager;
import android.content.ContentResolver;
import android.os.Build.VERSION;
import android.view.View;
import android.view.Window;
import androidx.annotation.VisibleForTesting;
import io.flutter.Log;
import io.flutter.embedding.engine.systemchannels.PlatformChannel;
import io.flutter.embedding.engine.systemchannels.PlatformChannel.AppSwitcherDescription;
import io.flutter.embedding.engine.systemchannels.PlatformChannel.ClipboardContentFormat;
import io.flutter.embedding.engine.systemchannels.PlatformChannel.HapticFeedbackType;
import io.flutter.embedding.engine.systemchannels.PlatformChannel.PlatformMessageHandler;
import io.flutter.embedding.engine.systemchannels.PlatformChannel.SoundType;
import io.flutter.embedding.engine.systemchannels.PlatformChannel.SystemChromeStyle;
import io.flutter.embedding.engine.systemchannels.PlatformChannel.SystemUiOverlay;
import java.io.FileNotFoundException;
import java.util.List;

public class PlatformPlugin
{
  public static final int DEFAULT_SYSTEM_UI = 1280;
  private static final String TAG = "PlatformPlugin";
  private final Activity activity;
  private PlatformChannel.SystemChromeStyle currentTheme;
  private int mEnabledOverlays;
  @VisibleForTesting
  final PlatformChannel.PlatformMessageHandler mPlatformMessageHandler = new PlatformPlugin.1(this);
  private final PlatformChannel platformChannel;
  
  public PlatformPlugin(Activity paramActivity, PlatformChannel paramPlatformChannel)
  {
    this.activity = paramActivity;
    this.platformChannel = paramPlatformChannel;
    this.platformChannel.setPlatformMessageHandler(this.mPlatformMessageHandler);
    this.mEnabledOverlays = 1280;
  }
  
  private CharSequence getClipboardData(PlatformChannel.ClipboardContentFormat paramClipboardContentFormat)
  {
    Object localObject = (ClipboardManager)this.activity.getSystemService("clipboard");
    if (!((ClipboardManager)localObject).hasPrimaryClip()) {
      return null;
    }
    try
    {
      localObject = ((ClipboardManager)localObject).getPrimaryClip();
      if (localObject == null) {
        return null;
      }
      if ((paramClipboardContentFormat == null) || (paramClipboardContentFormat == PlatformChannel.ClipboardContentFormat.PLAIN_TEXT))
      {
        paramClipboardContentFormat = ((ClipData)localObject).getItemAt(0);
        if (paramClipboardContentFormat.getUri() != null) {
          this.activity.getContentResolver().openTypedAssetFileDescriptor(paramClipboardContentFormat.getUri(), "text/*", null);
        }
        paramClipboardContentFormat = paramClipboardContentFormat.coerceToText(this.activity);
        return paramClipboardContentFormat;
      }
      return null;
    }
    catch (FileNotFoundException paramClipboardContentFormat)
    {
      return null;
    }
    catch (SecurityException paramClipboardContentFormat)
    {
      Log.w("PlatformPlugin", "Attempted to get clipboard data that requires additional permission(s).\nSee the exception details for which permission(s) are required, and consider adding them to your Android Manifest as described in:\nhttps://developer.android.com/guide/topics/permissions/overview", paramClipboardContentFormat);
    }
    return null;
  }
  
  private void playSystemSound(PlatformChannel.SoundType paramSoundType)
  {
    if (paramSoundType == PlatformChannel.SoundType.CLICK) {
      this.activity.getWindow().getDecorView().playSoundEffect(0);
    }
  }
  
  private void popSystemNavigator()
  {
    this.activity.finish();
  }
  
  private void restoreSystemChromeSystemUIOverlays()
  {
    updateSystemUiOverlays();
  }
  
  private void setClipboardData(String paramString)
  {
    ((ClipboardManager)this.activity.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text label?", paramString));
  }
  
  private void setSystemChromeApplicationSwitcherDescription(PlatformChannel.AppSwitcherDescription paramAppSwitcherDescription)
  {
    if (Build.VERSION.SDK_INT < 21) {}
    do
    {
      return;
      if ((Build.VERSION.SDK_INT < 28) && (Build.VERSION.SDK_INT > 21)) {
        this.activity.setTaskDescription(new ActivityManager.TaskDescription(paramAppSwitcherDescription.label, null, paramAppSwitcherDescription.color));
      }
    } while (Build.VERSION.SDK_INT < 28);
    paramAppSwitcherDescription = new ActivityManager.TaskDescription(paramAppSwitcherDescription.label, 0, paramAppSwitcherDescription.color);
    this.activity.setTaskDescription(paramAppSwitcherDescription);
  }
  
  private void setSystemChromeEnabledSystemUIOverlays(List<PlatformChannel.SystemUiOverlay> paramList)
  {
    int i;
    int j;
    if ((paramList.size() == 0) && (Build.VERSION.SDK_INT >= 19))
    {
      i = 5894;
      j = 0;
      label23:
      if (j >= paramList.size()) {
        break label110;
      }
      PlatformChannel.SystemUiOverlay localSystemUiOverlay = (PlatformChannel.SystemUiOverlay)paramList.get(j);
      switch (PlatformPlugin.2.$SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$SystemUiOverlay[localSystemUiOverlay.ordinal()])
      {
      }
    }
    for (;;)
    {
      j += 1;
      break label23;
      i = 1798;
      break;
      i = i & 0xFFFFFDFF & 0xFFFFFFFD;
      continue;
      i &= 0xFFFFFFFB;
    }
    label110:
    this.mEnabledOverlays = i;
    updateSystemUiOverlays();
  }
  
  private void setSystemChromePreferredOrientations(int paramInt)
  {
    this.activity.setRequestedOrientation(paramInt);
  }
  
  private void setSystemChromeSystemUIOverlayStyle(PlatformChannel.SystemChromeStyle paramSystemChromeStyle)
  {
    Object localObject = this.activity.getWindow();
    View localView = ((Window)localObject).getDecorView();
    int k = localView.getSystemUiVisibility();
    int i = k;
    int j;
    if (Build.VERSION.SDK_INT >= 26)
    {
      j = k;
      if (paramSystemChromeStyle.systemNavigationBarIconBrightness == null) {}
    }
    switch (PlatformPlugin.2.$SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$Brightness[paramSystemChromeStyle.systemNavigationBarIconBrightness.ordinal()])
    {
    default: 
      j = k;
      i = j;
      if (paramSystemChromeStyle.systemNavigationBarColor != null)
      {
        ((Window)localObject).setNavigationBarColor(paramSystemChromeStyle.systemNavigationBarColor.intValue());
        i = j;
      }
      k = i;
      if (Build.VERSION.SDK_INT >= 23)
      {
        j = i;
        if (paramSystemChromeStyle.statusBarIconBrightness != null) {
          switch (PlatformPlugin.2.$SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$Brightness[paramSystemChromeStyle.statusBarIconBrightness.ordinal()])
          {
          default: 
            j = i;
          }
        }
      }
      break;
    }
    for (;;)
    {
      k = j;
      if (paramSystemChromeStyle.statusBarColor != null)
      {
        ((Window)localObject).setStatusBarColor(paramSystemChromeStyle.statusBarColor.intValue());
        k = j;
      }
      localObject = paramSystemChromeStyle.systemNavigationBarDividerColor;
      localView.setSystemUiVisibility(k);
      this.currentTheme = paramSystemChromeStyle;
      return;
      j = k & 0xFFFFFFEF;
      break;
      j = k | 0x10;
      break;
      j = i & 0xFFFFDFFF;
      continue;
      j = i | 0x2000;
    }
  }
  
  public void destroy()
  {
    this.platformChannel.setPlatformMessageHandler(null);
  }
  
  public void updateSystemUiOverlays()
  {
    this.activity.getWindow().getDecorView().setSystemUiVisibility(this.mEnabledOverlays);
    if (this.currentTheme != null) {
      setSystemChromeSystemUIOverlayStyle(this.currentTheme);
    }
  }
  
  @VisibleForTesting
  void vibrateHapticFeedback(PlatformChannel.HapticFeedbackType paramHapticFeedbackType)
  {
    View localView = this.activity.getWindow().getDecorView();
    switch (PlatformPlugin.2.$SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$HapticFeedbackType[paramHapticFeedbackType.ordinal()])
    {
    default: 
    case 5: 
    case 4: 
      do
      {
        do
        {
          return;
        } while (Build.VERSION.SDK_INT < 21);
        localView.performHapticFeedback(4);
        return;
      } while (Build.VERSION.SDK_INT < 23);
      localView.performHapticFeedback(6);
      return;
    case 3: 
      localView.performHapticFeedback(3);
      return;
    case 2: 
      localView.performHapticFeedback(1);
      return;
    }
    localView.performHapticFeedback(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     io.flutter.plugin.platform.PlatformPlugin
 * JD-Core Version:    0.7.0.1
 */