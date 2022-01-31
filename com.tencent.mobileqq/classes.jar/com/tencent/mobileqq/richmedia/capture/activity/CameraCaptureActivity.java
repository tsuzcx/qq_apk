package com.tencent.mobileqq.richmedia.capture.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import com.tencent.common.cache.MemoryClearManagerNew;
import com.tencent.mobileqq.activity.aio.photo.PeakFragmentActivity;
import com.tencent.mobileqq.nearby.now.send.SmallVideoCameraCaptureFragment;
import com.tencent.mobileqq.richmedia.capture.fragment.EffectsCameraCaptureFragment;
import com.tencent.mobileqq.richmedia.capture.fragment.QzoneEffectsCameraCaptureFragment;
import com.tencent.mobileqq.tribe.fragment.TribeEffectsCameraCaptureFragment;
import com.tencent.mobileqq.widget.QQToast;

public class CameraCaptureActivity
  extends PeakFragmentActivity
{
  private Fragment a;
  
  public static Intent a(Context paramContext, String paramString, Bundle paramBundle)
  {
    paramContext = new Intent(paramContext, CameraCaptureActivity.class);
    paramContext.putExtras(paramBundle);
    paramContext.putExtra("ARG_FRAGMENT_CLASS", paramString);
    return paramContext;
  }
  
  public static void a(Activity paramActivity, String paramString, Bundle paramBundle, int paramInt)
  {
    paramBundle.putLong("ACTIVITY_START_TIME", System.currentTimeMillis());
    paramActivity.startActivityForResult(a(paramActivity, paramString, paramBundle), paramInt);
  }
  
  public static void a(Context paramContext, String paramString, Bundle paramBundle)
  {
    paramBundle.putLong("ACTIVITY_START_TIME", System.currentTimeMillis());
    paramContext.startActivity(a(paramContext, paramString, paramBundle));
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if ((this.a != null) && ((this.a instanceof QzoneEffectsCameraCaptureFragment))) {
      this.a.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    if ((this.a != null) && ((this.a instanceof SmallVideoCameraCaptureFragment))) {
      this.a.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    if ((this.a != null) && ((this.a instanceof TribeEffectsCameraCaptureFragment))) {
      this.a.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  /* Error */
  protected boolean doOnCreate(Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +14 -> 15
    //   4: aload_1
    //   5: aload_0
    //   6: invokevirtual 86	java/lang/Object:getClass	()Ljava/lang/Class;
    //   9: invokevirtual 92	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   12: invokevirtual 96	android/os/Bundle:setClassLoader	(Ljava/lang/ClassLoader;)V
    //   15: aload_0
    //   16: invokespecial 100	com/tencent/mobileqq/activity/aio/photo/PeakFragmentActivity:getWindow	()Landroid/view/Window;
    //   19: sipush 128
    //   22: invokevirtual 106	android/view/Window:addFlags	(I)V
    //   25: aload_0
    //   26: invokespecial 100	com/tencent/mobileqq/activity/aio/photo/PeakFragmentActivity:getWindow	()Landroid/view/Window;
    //   29: sipush 256
    //   32: invokevirtual 106	android/view/Window:addFlags	(I)V
    //   35: aload_0
    //   36: invokespecial 100	com/tencent/mobileqq/activity/aio/photo/PeakFragmentActivity:getWindow	()Landroid/view/Window;
    //   39: sipush 512
    //   42: invokevirtual 106	android/view/Window:addFlags	(I)V
    //   45: aload_0
    //   46: iconst_1
    //   47: putfield 110	com/tencent/mobileqq/richmedia/capture/activity/CameraCaptureActivity:mNeedStatusTrans	Z
    //   50: aload_0
    //   51: iconst_0
    //   52: putfield 113	com/tencent/mobileqq/richmedia/capture/activity/CameraCaptureActivity:mActNeedImmersive	Z
    //   55: aload_0
    //   56: aload_1
    //   57: invokespecial 115	com/tencent/mobileqq/activity/aio/photo/PeakFragmentActivity:doOnCreate	(Landroid/os/Bundle;)Z
    //   60: pop
    //   61: aload_0
    //   62: ldc 116
    //   64: invokespecial 119	com/tencent/mobileqq/activity/aio/photo/PeakFragmentActivity:setContentView	(I)V
    //   67: aload_0
    //   68: invokevirtual 123	com/tencent/mobileqq/richmedia/capture/activity/CameraCaptureActivity:isInMultiWindow	()Z
    //   71: ifeq +20 -> 91
    //   74: aload_0
    //   75: ldc 125
    //   77: iconst_0
    //   78: invokestatic 130	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;Ljava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   81: invokevirtual 133	com/tencent/mobileqq/widget/QQToast:a	()Landroid/widget/Toast;
    //   84: pop
    //   85: aload_0
    //   86: invokevirtual 136	com/tencent/mobileqq/richmedia/capture/activity/CameraCaptureActivity:finish	()V
    //   89: iconst_1
    //   90: ireturn
    //   91: aload_0
    //   92: invokevirtual 140	com/tencent/mobileqq/richmedia/capture/activity/CameraCaptureActivity:getIntent	()Landroid/content/Intent;
    //   95: invokevirtual 144	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   98: astore_2
    //   99: aload_2
    //   100: ldc 23
    //   102: invokevirtual 148	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   105: astore_1
    //   106: aload_1
    //   107: invokestatic 154	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   110: ifeq +17 -> 127
    //   113: ldc 156
    //   115: iconst_2
    //   116: ldc 158
    //   118: invokestatic 164	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   121: aload_0
    //   122: invokevirtual 136	com/tencent/mobileqq/richmedia/capture/activity/CameraCaptureActivity:finish	()V
    //   125: iconst_1
    //   126: ireturn
    //   127: aload_1
    //   128: invokestatic 168	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   131: astore_3
    //   132: aload_0
    //   133: aload_3
    //   134: invokevirtual 172	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   137: checkcast 67	android/support/v4/app/Fragment
    //   140: putfield 63	com/tencent/mobileqq/richmedia/capture/activity/CameraCaptureActivity:a	Landroid/support/v4/app/Fragment;
    //   143: aload_0
    //   144: getfield 63	com/tencent/mobileqq/richmedia/capture/activity/CameraCaptureActivity:a	Landroid/support/v4/app/Fragment;
    //   147: aload_2
    //   148: invokevirtual 176	android/support/v4/app/Fragment:setArguments	(Landroid/os/Bundle;)V
    //   151: aload_0
    //   152: invokespecial 180	com/tencent/mobileqq/activity/aio/photo/PeakFragmentActivity:getSupportFragmentManager	()Landroid/support/v4/app/FragmentManager;
    //   155: invokevirtual 186	android/support/v4/app/FragmentManager:beginTransaction	()Landroid/support/v4/app/FragmentTransaction;
    //   158: astore_1
    //   159: aload_1
    //   160: ldc 187
    //   162: aload_0
    //   163: getfield 63	com/tencent/mobileqq/richmedia/capture/activity/CameraCaptureActivity:a	Landroid/support/v4/app/Fragment;
    //   166: invokevirtual 193	android/support/v4/app/FragmentTransaction:replace	(ILandroid/support/v4/app/Fragment;)Landroid/support/v4/app/FragmentTransaction;
    //   169: pop
    //   170: aload_1
    //   171: invokevirtual 197	android/support/v4/app/FragmentTransaction:commit	()I
    //   174: pop
    //   175: invokestatic 200	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   178: ifeq +11 -> 189
    //   181: ldc 156
    //   183: iconst_2
    //   184: ldc 202
    //   186: invokestatic 205	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   189: invokestatic 210	com/tencent/common/cache/MemoryClearManagerNew:a	()Lcom/tencent/common/cache/MemoryClearManagerNew;
    //   192: iconst_1
    //   193: putfield 214	com/tencent/common/cache/MemoryClearManagerNew:i	I
    //   196: invokestatic 210	com/tencent/common/cache/MemoryClearManagerNew:a	()Lcom/tencent/common/cache/MemoryClearManagerNew;
    //   199: iconst_1
    //   200: putfield 217	com/tencent/common/cache/MemoryClearManagerNew:k	I
    //   203: invokestatic 223	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   206: invokestatic 228	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   209: aconst_null
    //   210: ldc 230
    //   212: iconst_1
    //   213: lconst_0
    //   214: lconst_0
    //   215: aconst_null
    //   216: ldc 232
    //   218: invokevirtual 235	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   221: iconst_1
    //   222: ireturn
    //   223: astore_2
    //   224: aload_2
    //   225: invokevirtual 238	java/lang/ClassNotFoundException:printStackTrace	()V
    //   228: ldc 156
    //   230: iconst_2
    //   231: new 240	java/lang/StringBuilder
    //   234: dup
    //   235: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   238: ldc 243
    //   240: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: aload_1
    //   244: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   250: invokestatic 164	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   253: aload_0
    //   254: invokevirtual 136	com/tencent/mobileqq/richmedia/capture/activity/CameraCaptureActivity:finish	()V
    //   257: iconst_1
    //   258: ireturn
    //   259: astore_2
    //   260: aload_2
    //   261: invokevirtual 252	java/lang/Exception:printStackTrace	()V
    //   264: ldc 156
    //   266: iconst_2
    //   267: new 240	java/lang/StringBuilder
    //   270: dup
    //   271: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   274: ldc 254
    //   276: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: aload_1
    //   280: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   286: invokestatic 164	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   289: aload_0
    //   290: invokevirtual 136	com/tencent/mobileqq/richmedia/capture/activity/CameraCaptureActivity:finish	()V
    //   293: iconst_1
    //   294: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	295	0	this	CameraCaptureActivity
    //   0	295	1	paramBundle	Bundle
    //   98	50	2	localBundle	Bundle
    //   223	2	2	localClassNotFoundException	java.lang.ClassNotFoundException
    //   259	2	2	localException	java.lang.Exception
    //   131	3	3	localClass	java.lang.Class
    // Exception table:
    //   from	to	target	type
    //   127	132	223	java/lang/ClassNotFoundException
    //   132	143	259	java/lang/Exception
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    MemoryClearManagerNew.a().k = 0;
  }
  
  protected boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramInt == 4)
    {
      bool1 = bool2;
      if (this.a != null)
      {
        bool1 = bool2;
        if ((this.a instanceof EffectsCameraCaptureFragment)) {
          bool1 = ((EffectsCameraCaptureFragment)this.a).e();
        }
      }
    }
    if (!bool1) {
      return super.doOnKeyDown(paramInt, paramKeyEvent);
    }
    return true;
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    if ((this.a != null) && ((this.a instanceof QzoneEffectsCameraCaptureFragment))) {
      ((QzoneEffectsCameraCaptureFragment)this.a).a(paramIntent);
    }
  }
  
  public void onMultiWindowModeChanged(boolean paramBoolean)
  {
    super.onMultiWindowModeChanged(paramBoolean);
    if (isInMultiWindow())
    {
      QQToast.a(this, "该功能无法在分屏模式下使用。", 0).a();
      finish();
    }
  }
  
  protected void onSaveInstanceState(Bundle paramBundle) {}
  
  public void onSaveInstanceState(Bundle paramBundle, PersistableBundle paramPersistableBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.activity.CameraCaptureActivity
 * JD-Core Version:    0.7.0.1
 */