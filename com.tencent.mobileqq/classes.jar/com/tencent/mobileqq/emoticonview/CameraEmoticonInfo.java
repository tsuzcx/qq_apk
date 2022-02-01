package com.tencent.mobileqq.emoticonview;

import acvv;
import amtj;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import awhn;
import bcef;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;

public class CameraEmoticonInfo
  extends CustomEmoticonInfoBase
  implements ICustomEmotionInfo
{
  static final long ONE_SEC = 1000L;
  public static final String TAG = "CameraEmoticonInfo";
  static long lastTime;
  public String contextKey;
  private ColorDrawable mEmptyDrawable = new ColorDrawable();
  public String templateId;
  public String thumbPath;
  
  public Drawable getBigDrawable(Context paramContext, float paramFloat)
  {
    try
    {
      URL localURL = new URL("protocol_vas_extension_image", "BUSINESS_CAMERA_EMO_PANEL_DYNAMIC", this.path);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestHeight = ((int)(100.0F * paramFloat));
      localURLDrawableOptions.mRequestWidth = ((int)(100.0F * paramFloat));
      localURLDrawableOptions.mFailedDrawable = paramContext.getResources().getDrawable(2130843781);
      localURLDrawableOptions.mLoadingDrawable = this.mEmptyDrawable;
      localURLDrawableOptions.mPlayGifImage = true;
      paramContext = URLDrawable.getDrawable(localURL, localURLDrawableOptions);
      if (QLog.isColorLevel()) {
        QLog.d("CameraEmoticonInfo", 2, "d: width = " + paramContext.getIntrinsicWidth() + ";height = " + paramContext.getIntrinsicHeight() + ";options:width = " + localURLDrawableOptions.mRequestWidth + ";options:height = " + localURLDrawableOptions.mRequestHeight);
      }
      return paramContext;
    }
    catch (MalformedURLException paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public Drawable getBigDrawable(Context paramContext, int paramInt1, int paramInt2)
  {
    try
    {
      URL localURL = new URL("protocol_vas_extension_image", "BUSINESS_CAMERA_EMO_PANEL_DYNAMIC", this.path);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestHeight = paramInt1;
      localURLDrawableOptions.mRequestWidth = paramInt2;
      localURLDrawableOptions.mFailedDrawable = paramContext.getResources().getDrawable(2130843781);
      localURLDrawableOptions.mLoadingDrawable = this.mEmptyDrawable;
      localURLDrawableOptions.mPlayGifImage = true;
      paramContext = URLDrawable.getDrawable(localURL, localURLDrawableOptions);
      if (QLog.isColorLevel()) {
        QLog.d("CameraEmoticonInfo", 2, "d: width = " + paramContext.getIntrinsicWidth() + ";height = " + paramContext.getIntrinsicHeight() + ";options:width = " + localURLDrawableOptions.mRequestWidth + ";options:height = " + localURLDrawableOptions.mRequestHeight);
      }
      return paramContext;
    }
    catch (MalformedURLException paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  /* Error */
  public Drawable getDrawable(Context paramContext, float paramFloat)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 43	com/tencent/mobileqq/emoticonview/CameraEmoticonInfo:path	Ljava/lang/String;
    //   4: astore_1
    //   5: aload_0
    //   6: getfield 139	com/tencent/mobileqq/emoticonview/CameraEmoticonInfo:roamingType	Ljava/lang/String;
    //   9: ldc 141
    //   11: invokevirtual 147	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   14: ifne +18 -> 32
    //   17: aload_1
    //   18: astore 4
    //   20: aload_0
    //   21: getfield 139	com/tencent/mobileqq/emoticonview/CameraEmoticonInfo:roamingType	Ljava/lang/String;
    //   24: ldc 149
    //   26: invokevirtual 147	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   29: ifeq +33 -> 62
    //   32: aload_1
    //   33: invokestatic 155	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   36: ifne +20 -> 56
    //   39: aload_1
    //   40: astore 4
    //   42: new 157	java/io/File
    //   45: dup
    //   46: aload_1
    //   47: invokespecial 160	java/io/File:<init>	(Ljava/lang/String;)V
    //   50: invokevirtual 163	java/io/File:exists	()Z
    //   53: ifne +9 -> 62
    //   56: aload_0
    //   57: getfield 165	com/tencent/mobileqq/emoticonview/CameraEmoticonInfo:thumbPath	Ljava/lang/String;
    //   60: astore 4
    //   62: invokestatic 171	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   65: invokevirtual 172	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   68: astore_3
    //   69: aload_3
    //   70: ldc 173
    //   72: invokevirtual 73	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   75: astore_1
    //   76: aload_3
    //   77: ldc 67
    //   79: invokevirtual 73	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   82: astore 5
    //   84: aload_1
    //   85: astore_3
    //   86: aload 5
    //   88: astore_1
    //   89: new 36	java/net/URL
    //   92: dup
    //   93: ldc 38
    //   95: ldc 175
    //   97: aload 4
    //   99: invokespecial 46	java/net/URL:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   102: astore 6
    //   104: new 177	com/tencent/mobileqq/activity/photo/LocalMediaInfo
    //   107: dup
    //   108: invokespecial 178	com/tencent/mobileqq/activity/photo/LocalMediaInfo:<init>	()V
    //   111: astore 5
    //   113: aload 5
    //   115: aload 4
    //   117: putfield 179	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   120: aload 5
    //   122: bipush 100
    //   124: putfield 182	com/tencent/mobileqq/activity/photo/LocalMediaInfo:thumbWidth	I
    //   127: aload 5
    //   129: bipush 100
    //   131: putfield 185	com/tencent/mobileqq/activity/photo/LocalMediaInfo:thumbHeight	I
    //   134: invokestatic 52	com/tencent/image/URLDrawable$URLDrawableOptions:obtain	()Lcom/tencent/image/URLDrawable$URLDrawableOptions;
    //   137: astore 7
    //   139: aload 7
    //   141: aload_3
    //   142: putfield 80	com/tencent/image/URLDrawable$URLDrawableOptions:mLoadingDrawable	Landroid/graphics/drawable/Drawable;
    //   145: aload 7
    //   147: aload_1
    //   148: putfield 77	com/tencent/image/URLDrawable$URLDrawableOptions:mFailedDrawable	Landroid/graphics/drawable/Drawable;
    //   151: aload 7
    //   153: aload_0
    //   154: putfield 189	com/tencent/image/URLDrawable$URLDrawableOptions:mExtraInfo	Ljava/lang/Object;
    //   157: aload 4
    //   159: invokestatic 155	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   162: ifne +71 -> 233
    //   165: aload 6
    //   167: aload 7
    //   169: invokestatic 89	com/tencent/image/URLDrawable:getDrawable	(Ljava/net/URL;Lcom/tencent/image/URLDrawable$URLDrawableOptions;)Lcom/tencent/image/URLDrawable;
    //   172: astore_1
    //   173: aload_1
    //   174: aload 5
    //   176: invokevirtual 193	com/tencent/image/URLDrawable:setTag	(Ljava/lang/Object;)V
    //   179: aload_1
    //   180: areturn
    //   181: astore 5
    //   183: aconst_null
    //   184: astore_3
    //   185: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   188: ifeq +14 -> 202
    //   191: ldc 14
    //   193: iconst_2
    //   194: aload 5
    //   196: invokevirtual 196	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   199: invokestatic 199	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   202: aconst_null
    //   203: astore_1
    //   204: goto -115 -> 89
    //   207: astore 5
    //   209: aconst_null
    //   210: astore_3
    //   211: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   214: ifeq +14 -> 228
    //   217: ldc 14
    //   219: iconst_2
    //   220: aload 5
    //   222: invokevirtual 200	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   225: invokestatic 199	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   228: aconst_null
    //   229: astore_1
    //   230: goto -141 -> 89
    //   233: ldc 14
    //   235: iconst_1
    //   236: new 97	java/lang/StringBuilder
    //   239: dup
    //   240: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   243: ldc 202
    //   245: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: aload_0
    //   249: invokevirtual 203	com/tencent/mobileqq/emoticonview/CameraEmoticonInfo:toString	()Ljava/lang/String;
    //   252: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   258: invokestatic 199	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   261: aconst_null
    //   262: areturn
    //   263: astore_1
    //   264: aload_1
    //   265: invokevirtual 131	java/net/MalformedURLException:printStackTrace	()V
    //   268: ldc 14
    //   270: iconst_1
    //   271: ldc 205
    //   273: aload_1
    //   274: invokestatic 208	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   277: goto -16 -> 261
    //   280: astore 5
    //   282: aload_1
    //   283: astore_3
    //   284: goto -73 -> 211
    //   287: astore 5
    //   289: aload_1
    //   290: astore_3
    //   291: goto -106 -> 185
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	294	0	this	CameraEmoticonInfo
    //   0	294	1	paramContext	Context
    //   0	294	2	paramFloat	float
    //   68	223	3	localObject1	Object
    //   18	140	4	localObject2	Object
    //   82	93	5	localObject3	Object
    //   181	14	5	localException1	java.lang.Exception
    //   207	14	5	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   280	1	5	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   287	1	5	localException2	java.lang.Exception
    //   102	64	6	localURL	URL
    //   137	31	7	localURLDrawableOptions	URLDrawable.URLDrawableOptions
    // Exception table:
    //   from	to	target	type
    //   62	76	181	java/lang/Exception
    //   62	76	207	java/lang/OutOfMemoryError
    //   89	179	263	java/net/MalformedURLException
    //   233	261	263	java/net/MalformedURLException
    //   76	84	280	java/lang/OutOfMemoryError
    //   76	84	287	java/lang/Exception
  }
  
  public int getEmoId()
  {
    return this.emoId;
  }
  
  public int getEmoType()
  {
    return 2;
  }
  
  public String getPath()
  {
    return this.path;
  }
  
  public String getRoamingType()
  {
    return this.roamingType;
  }
  
  public Drawable getZoomDrawable(Context paramContext, float paramFloat, int paramInt1, int paramInt2)
  {
    return getDrawable(paramContext, paramFloat);
  }
  
  public boolean isChecked()
  {
    return this.isChecked;
  }
  
  public void send(QQAppInterface paramQQAppInterface, Context paramContext, EditText paramEditText, SessionInfo paramSessionInfo)
  {
    long l = System.currentTimeMillis();
    if (l - lastTime < 1000L) {
      if (QLog.isColorLevel()) {
        QLog.e("CameraEmoticonInfo", 2, "send to offen,please try it later");
      }
    }
    do
    {
      do
      {
        return;
      } while ((paramQQAppInterface == null) || (paramContext == null) || (paramSessionInfo == null));
      lastTime = l;
      if (((paramContext instanceof BaseActivity)) && (awhn.a(paramSessionInfo.curType, paramSessionInfo.curFriendUin)))
      {
        paramContext = (BaseActivity)paramContext;
        QQToast.a(paramQQAppInterface.getApp(), amtj.a(2131700455), 0).b(paramContext.getTitleBarHeight());
        return;
      }
      paramEditText = null;
      if (!TextUtils.isEmpty(this.templateId))
      {
        paramEditText = new Bundle();
        paramEditText.putString("widgetinfo", this.templateId);
      }
      acvv.a(paramQQAppInterface, paramContext, paramSessionInfo, this.path, true, this.contextKey, paramEditText);
    } while (TextUtils.isEmpty(this.eId));
    bcef.b(paramQQAppInterface, "dc00898", "", "", "0X800A371", "0X800A371", 0, 0, "", "", this.eId, "");
  }
  
  public void setIsChecked(boolean paramBoolean)
  {
    this.isChecked = paramBoolean;
  }
  
  public String toString()
  {
    return String.format("CameraEmoticonInfo, path %s, url %s, contextKey %s", new Object[] { this.path, this.url, this.contextKey });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.CameraEmoticonInfo
 * JD-Core Version:    0.7.0.1
 */