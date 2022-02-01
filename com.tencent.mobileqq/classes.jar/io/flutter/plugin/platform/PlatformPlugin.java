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
import com.tencent.mobileqq.qmethodmonitor.monitor.ClipboardMonitor;
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
    ClipboardMonitor.hasPrimaryClip((ClipboardManager)localObject);
    if (!((ClipboardManager)localObject).hasPrimaryClip()) {
      return null;
    }
    try
    {
      ClipboardMonitor.getPrimaryClip((ClipboardManager)localObject);
      localObject = ((ClipboardManager)localObject).getPrimaryClip();
      if (localObject == null) {
        return null;
      }
      if (paramClipboardContentFormat != null) {
        if (paramClipboardContentFormat != PlatformChannel.ClipboardContentFormat.PLAIN_TEXT) {
          break label113;
        }
      }
      paramClipboardContentFormat = ((ClipData)localObject).getItemAt(0);
      if (paramClipboardContentFormat.getUri() != null) {
        this.activity.getContentResolver().openTypedAssetFileDescriptor(paramClipboardContentFormat.getUri(), "text/*", null);
      }
      paramClipboardContentFormat = paramClipboardContentFormat.coerceToText(this.activity);
      return paramClipboardContentFormat;
    }
    catch (SecurityException paramClipboardContentFormat)
    {
      Log.w("PlatformPlugin", "Attempted to get clipboard data that requires additional permission(s).\nSee the exception details for which permission(s) are required, and consider adding them to your Android Manifest as described in:\nhttps://developer.android.com/guide/topics/permissions/overview", paramClipboardContentFormat);
      return null;
    }
    catch (FileNotFoundException paramClipboardContentFormat)
    {
      return null;
    }
    label113:
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
    ClipboardManager localClipboardManager = (ClipboardManager)this.activity.getSystemService("clipboard");
    paramString = ClipData.newPlainText("text label?", paramString);
    ClipboardMonitor.setPrimaryClip(localClipboardManager, paramString);
    localClipboardManager.setPrimaryClip(paramString);
  }
  
  private void setSystemChromeApplicationSwitcherDescription(PlatformChannel.AppSwitcherDescription paramAppSwitcherDescription)
  {
    if (Build.VERSION.SDK_INT < 21) {
      return;
    }
    if ((Build.VERSION.SDK_INT < 28) && (Build.VERSION.SDK_INT > 21)) {
      this.activity.setTaskDescription(new ActivityManager.TaskDescription(paramAppSwitcherDescription.label, null, paramAppSwitcherDescription.color));
    }
    if (Build.VERSION.SDK_INT >= 28)
    {
      paramAppSwitcherDescription = new ActivityManager.TaskDescription(paramAppSwitcherDescription.label, 0, paramAppSwitcherDescription.color);
      this.activity.setTaskDescription(paramAppSwitcherDescription);
    }
  }
  
  private void setSystemChromeEnabledSystemUIOverlays(List<PlatformChannel.SystemUiOverlay> paramList)
  {
    int i;
    if ((paramList.size() == 0) && (Build.VERSION.SDK_INT >= 19)) {
      i = 5894;
    } else {
      i = 1798;
    }
    int j = 0;
    while (j < paramList.size())
    {
      PlatformChannel.SystemUiOverlay localSystemUiOverlay = (PlatformChannel.SystemUiOverlay)paramList.get(j);
      int k = PlatformPlugin.2.$SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$SystemUiOverlay[localSystemUiOverlay.ordinal()];
      if (k != 1)
      {
        if (k == 2) {
          i = i & 0xFFFFFDFF & 0xFFFFFFFD;
        }
      }
      else {
        i &= 0xFFFFFFFB;
      }
      j += 1;
    }
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
      if (paramSystemChromeStyle.systemNavigationBarIconBrightness != null)
      {
        i = PlatformPlugin.2.$SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$Brightness[paramSystemChromeStyle.systemNavigationBarIconBrightness.ordinal()];
        if (i != 1)
        {
          if (i != 2) {
            j = k;
          } else {
            j = k & 0xFFFFFFEF;
          }
        }
        else {
          j = k | 0x10;
        }
      }
      i = j;
      if (paramSystemChromeStyle.systemNavigationBarColor != null)
      {
        ((Window)localObject).setNavigationBarColor(paramSystemChromeStyle.systemNavigationBarColor.intValue());
        i = j;
      }
    }
    k = i;
    if (Build.VERSION.SDK_INT >= 23)
    {
      j = i;
      if (paramSystemChromeStyle.statusBarIconBrightness != null)
      {
        j = PlatformPlugin.2.$SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$Brightness[paramSystemChromeStyle.statusBarIconBrightness.ordinal()];
        if (j != 1)
        {
          if (j != 2) {
            j = i;
          } else {
            j = i & 0xFFFFDFFF;
          }
        }
        else {
          j = i | 0x2000;
        }
      }
      k = j;
      if (paramSystemChromeStyle.statusBarColor != null)
      {
        ((Window)localObject).setStatusBarColor(paramSystemChromeStyle.statusBarColor.intValue());
        k = j;
      }
    }
    localObject = paramSystemChromeStyle.systemNavigationBarDividerColor;
    localView.setSystemUiVisibility(k);
    this.currentTheme = paramSystemChromeStyle;
  }
  
  public void destroy()
  {
    this.platformChannel.setPlatformMessageHandler(null);
  }
  
  public void updateSystemUiOverlays()
  {
    this.activity.getWindow().getDecorView().setSystemUiVisibility(this.mEnabledOverlays);
    PlatformChannel.SystemChromeStyle localSystemChromeStyle = this.currentTheme;
    if (localSystemChromeStyle != null) {
      setSystemChromeSystemUIOverlayStyle(localSystemChromeStyle);
    }
  }
  
  @VisibleForTesting
  void vibrateHapticFeedback(PlatformChannel.HapticFeedbackType paramHapticFeedbackType)
  {
    View localView = this.activity.getWindow().getDecorView();
    int j = PlatformPlugin.2.$SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$HapticFeedbackType[paramHapticFeedbackType.ordinal()];
    int i = 1;
    if (j != 1)
    {
      if (j != 2)
      {
        i = 3;
        if (j != 3)
        {
          i = 4;
          if (j != 4)
          {
            if (j != 5) {
              return;
            }
            if (Build.VERSION.SDK_INT < 21) {
              return;
            }
          }
          else
          {
            if (Build.VERSION.SDK_INT < 23) {
              return;
            }
            i = 6;
            break label88;
          }
        }
      }
      localView.performHapticFeedback(i);
    }
    else
    {
      i = 0;
    }
    label88:
    localView.performHapticFeedback(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     io.flutter.plugin.platform.PlatformPlugin
 * JD-Core Version:    0.7.0.1
 */