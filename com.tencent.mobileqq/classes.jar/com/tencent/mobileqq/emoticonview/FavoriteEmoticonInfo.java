package com.tencent.mobileqq.emoticonview;

import admh;
import ahsj;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import anvn;
import anvx;
import axnp;
import bdla;
import bdof;
import blrb;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.VipComicFavorEmoStructMsgInfo;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class FavoriteEmoticonInfo
  extends CustomEmoticonInfoBase
  implements ICustomEmotionInfo
{
  static final long ONE_SEC = 1000L;
  public static final String TAG = "FavoriteEmoticonInfo";
  static long lastTime;
  public String actionData;
  private ColorDrawable mEmptyDrawable = new ColorDrawable();
  
  public FavoriteEmoticonInfo()
  {
    this.longClickAction = "show_fav_menu";
  }
  
  public static String getActionData(Map<String, VipComicFavorEmoStructMsgInfo> paramMap, String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramMap == null) || (paramMap.size() == 0)) {
      return null;
    }
    paramMap = (VipComicFavorEmoStructMsgInfo)paramMap.get(paramString.toUpperCase());
    if (paramMap != null) {
      return paramMap.actionData;
    }
    return null;
  }
  
  private void sendStructMsgForImage(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("image_url", this.path);
    localBundle.putInt("forward_type", -3);
    localBundle.putString("pkg_name", "com.tencent.mobileqq");
    localBundle.putInt("req_type", 5);
    localBundle.putString("brief_key", anvx.a(2131703858));
    localBundle.putString("app_name", "QQ动漫");
    localBundle.putString("struct_share_key_content_action_DATA", this.actionData);
    StructMsgForImageShare.sendAndUploadImageShare(paramQQAppInterface, (StructMsgForImageShare)bdof.a(localBundle), paramSessionInfo.curFriendUin, paramSessionInfo.curType, paramSessionInfo.troopUin, 0);
    paramSessionInfo = ahsj.a(this.actionData);
    if ((paramSessionInfo != null) && (paramSessionInfo.length >= 8)) {
      blrb.a(paramQQAppInterface, "100007", "2", "40051", paramSessionInfo[0], new String[] { paramSessionInfo[2], paramSessionInfo[4], ahsj.a(this.actionData) });
    }
  }
  
  public Drawable getBigDrawable(Context paramContext, float paramFloat)
  {
    try
    {
      URL localURL = new URL("protocol_vas_extension_image", "FAVOROTE_PANEL_DYNAMIC", this.path);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestHeight = ((int)(100.0F * paramFloat));
      localURLDrawableOptions.mRequestWidth = ((int)(100.0F * paramFloat));
      localURLDrawableOptions.mFailedDrawable = paramContext.getResources().getDrawable(2130843819);
      localURLDrawableOptions.mLoadingDrawable = this.mEmptyDrawable;
      localURLDrawableOptions.mPlayGifImage = true;
      paramContext = URLDrawable.getDrawable(localURL, localURLDrawableOptions);
      if (QLog.isColorLevel()) {
        QLog.d("FavoriteEmoticonInfo", 2, "d: width = " + paramContext.getIntrinsicWidth() + ";height = " + paramContext.getIntrinsicHeight() + ";options:width = " + localURLDrawableOptions.mRequestWidth + ";options:height = " + localURLDrawableOptions.mRequestHeight);
      }
      return paramContext;
    }
    catch (MalformedURLException paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public Drawable getBigDrawable(Context paramContext, float paramFloat, int paramInt1, int paramInt2)
  {
    try
    {
      URL localURL = new URL("protocol_vas_extension_image", "FAVOROTE_PANEL_DYNAMIC", this.path);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestHeight = paramInt1;
      localURLDrawableOptions.mRequestWidth = paramInt2;
      localURLDrawableOptions.mFailedDrawable = paramContext.getResources().getDrawable(2130843819);
      localURLDrawableOptions.mLoadingDrawable = this.mEmptyDrawable;
      localURLDrawableOptions.mPlayGifImage = true;
      paramContext = URLDrawable.getDrawable(localURL, localURLDrawableOptions);
      if (QLog.isColorLevel()) {
        QLog.d("FavoriteEmoticonInfo", 2, "d: width = " + paramContext.getIntrinsicWidth() + ";height = " + paramContext.getIntrinsicHeight() + ";options:width = " + localURLDrawableOptions.mRequestWidth + ";options:height = " + localURLDrawableOptions.mRequestHeight);
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
    //   0: new 24	android/graphics/drawable/ColorDrawable
    //   3: dup
    //   4: invokespecial 25	android/graphics/drawable/ColorDrawable:<init>	()V
    //   7: astore 4
    //   9: aload 4
    //   11: astore_1
    //   12: aload 4
    //   14: astore_3
    //   15: invokestatic 253	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   18: invokevirtual 254	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   21: astore 5
    //   23: aload 4
    //   25: astore_1
    //   26: aload 4
    //   28: astore_3
    //   29: aload 5
    //   31: ldc 255
    //   33: invokevirtual 186	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   36: astore 4
    //   38: aload 4
    //   40: astore_1
    //   41: aload 4
    //   43: astore_3
    //   44: aload 5
    //   46: ldc 180
    //   48: invokevirtual 186	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   51: astore 5
    //   53: aload 5
    //   55: astore_3
    //   56: aload 4
    //   58: astore_1
    //   59: aload_3
    //   60: astore 4
    //   62: new 153	java/net/URL
    //   65: dup
    //   66: ldc 155
    //   68: ldc_w 257
    //   71: aload_0
    //   72: getfield 73	com/tencent/mobileqq/emoticonview/FavoriteEmoticonInfo:path	Ljava/lang/String;
    //   75: invokespecial 160	java/net/URL:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   78: astore 5
    //   80: new 259	com/tencent/mobileqq/activity/photo/LocalMediaInfo
    //   83: dup
    //   84: invokespecial 260	com/tencent/mobileqq/activity/photo/LocalMediaInfo:<init>	()V
    //   87: astore_3
    //   88: aload_3
    //   89: aload_0
    //   90: getfield 73	com/tencent/mobileqq/emoticonview/FavoriteEmoticonInfo:path	Ljava/lang/String;
    //   93: putfield 261	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   96: aload_3
    //   97: bipush 100
    //   99: putfield 264	com/tencent/mobileqq/activity/photo/LocalMediaInfo:thumbWidth	I
    //   102: aload_3
    //   103: bipush 100
    //   105: putfield 267	com/tencent/mobileqq/activity/photo/LocalMediaInfo:thumbHeight	I
    //   108: invokestatic 166	com/tencent/image/URLDrawable$URLDrawableOptions:obtain	()Lcom/tencent/image/URLDrawable$URLDrawableOptions;
    //   111: astore 6
    //   113: aload 6
    //   115: aload_1
    //   116: putfield 193	com/tencent/image/URLDrawable$URLDrawableOptions:mLoadingDrawable	Landroid/graphics/drawable/Drawable;
    //   119: aload 6
    //   121: aload 4
    //   123: putfield 190	com/tencent/image/URLDrawable$URLDrawableOptions:mFailedDrawable	Landroid/graphics/drawable/Drawable;
    //   126: aload 6
    //   128: aload_0
    //   129: putfield 271	com/tencent/image/URLDrawable$URLDrawableOptions:mExtraInfo	Ljava/lang/Object;
    //   132: aload_0
    //   133: getfield 73	com/tencent/mobileqq/emoticonview/FavoriteEmoticonInfo:path	Ljava/lang/String;
    //   136: invokestatic 41	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   139: ifne +66 -> 205
    //   142: aload 5
    //   144: aload 6
    //   146: invokestatic 202	com/tencent/image/URLDrawable:getDrawable	(Ljava/net/URL;Lcom/tencent/image/URLDrawable$URLDrawableOptions;)Lcom/tencent/image/URLDrawable;
    //   149: astore_1
    //   150: aload_1
    //   151: aload_3
    //   152: invokevirtual 275	com/tencent/image/URLDrawable:setTag	(Ljava/lang/Object;)V
    //   155: aload_1
    //   156: areturn
    //   157: astore_3
    //   158: invokestatic 208	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   161: ifeq +13 -> 174
    //   164: ldc 14
    //   166: iconst_2
    //   167: aload_3
    //   168: invokevirtual 278	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   171: invokestatic 281	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   174: aconst_null
    //   175: astore 4
    //   177: goto -115 -> 62
    //   180: astore_1
    //   181: invokestatic 208	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   184: ifeq +13 -> 197
    //   187: ldc 14
    //   189: iconst_2
    //   190: aload_1
    //   191: invokevirtual 282	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   194: invokestatic 281	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   197: aconst_null
    //   198: astore 4
    //   200: aload_3
    //   201: astore_1
    //   202: goto -140 -> 62
    //   205: ldc 14
    //   207: iconst_1
    //   208: new 210	java/lang/StringBuilder
    //   211: dup
    //   212: invokespecial 211	java/lang/StringBuilder:<init>	()V
    //   215: ldc_w 284
    //   218: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: aload_0
    //   222: invokevirtual 285	com/tencent/mobileqq/emoticonview/FavoriteEmoticonInfo:toString	()Ljava/lang/String;
    //   225: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: invokevirtual 235	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   231: invokestatic 281	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   234: aconst_null
    //   235: areturn
    //   236: astore_1
    //   237: aload_1
    //   238: invokevirtual 242	java/net/MalformedURLException:printStackTrace	()V
    //   241: ldc 14
    //   243: iconst_1
    //   244: ldc_w 287
    //   247: aload_1
    //   248: invokestatic 290	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   251: goto -17 -> 234
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	254	0	this	FavoriteEmoticonInfo
    //   0	254	1	paramContext	Context
    //   0	254	2	paramFloat	float
    //   14	138	3	localObject1	Object
    //   157	44	3	localException	java.lang.Exception
    //   7	192	4	localObject2	Object
    //   21	122	5	localObject3	Object
    //   111	34	6	localURLDrawableOptions	URLDrawable.URLDrawableOptions
    // Exception table:
    //   from	to	target	type
    //   15	23	157	java/lang/Exception
    //   29	38	157	java/lang/Exception
    //   44	53	157	java/lang/Exception
    //   15	23	180	java/lang/OutOfMemoryError
    //   29	38	180	java/lang/OutOfMemoryError
    //   44	53	180	java/lang/OutOfMemoryError
    //   62	155	236	java/net/MalformedURLException
    //   205	234	236	java/net/MalformedURLException
  }
  
  public int getEmoId()
  {
    return this.emoId;
  }
  
  public int getEmoType()
  {
    return 0;
  }
  
  public String getPath()
  {
    return this.path;
  }
  
  public String getRoamingType()
  {
    return this.roamingType;
  }
  
  /* Error */
  public Drawable getZoomDrawable(Context paramContext, float paramFloat, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: new 24	android/graphics/drawable/ColorDrawable
    //   3: dup
    //   4: invokespecial 25	android/graphics/drawable/ColorDrawable:<init>	()V
    //   7: astore 6
    //   9: aload 6
    //   11: astore_1
    //   12: aload 6
    //   14: astore 5
    //   16: invokestatic 253	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   19: invokevirtual 254	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   22: astore 7
    //   24: aload 6
    //   26: astore_1
    //   27: aload 6
    //   29: astore 5
    //   31: aload 7
    //   33: ldc 255
    //   35: invokevirtual 186	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   38: astore 6
    //   40: aload 6
    //   42: astore_1
    //   43: aload 6
    //   45: astore 5
    //   47: aload 7
    //   49: ldc 180
    //   51: invokevirtual 186	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   54: astore 7
    //   56: aload 7
    //   58: astore 5
    //   60: aload 6
    //   62: astore_1
    //   63: aload 5
    //   65: astore 6
    //   67: new 153	java/net/URL
    //   70: dup
    //   71: ldc 155
    //   73: ldc_w 303
    //   76: aload_0
    //   77: getfield 73	com/tencent/mobileqq/emoticonview/FavoriteEmoticonInfo:path	Ljava/lang/String;
    //   80: invokespecial 160	java/net/URL:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   83: astore 7
    //   85: new 259	com/tencent/mobileqq/activity/photo/LocalMediaInfo
    //   88: dup
    //   89: invokespecial 260	com/tencent/mobileqq/activity/photo/LocalMediaInfo:<init>	()V
    //   92: astore 5
    //   94: aload 5
    //   96: aload_0
    //   97: getfield 73	com/tencent/mobileqq/emoticonview/FavoriteEmoticonInfo:path	Ljava/lang/String;
    //   100: putfield 261	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   103: aload 5
    //   105: iload_3
    //   106: putfield 264	com/tencent/mobileqq/activity/photo/LocalMediaInfo:thumbWidth	I
    //   109: aload 5
    //   111: iload 4
    //   113: putfield 267	com/tencent/mobileqq/activity/photo/LocalMediaInfo:thumbHeight	I
    //   116: invokestatic 166	com/tencent/image/URLDrawable$URLDrawableOptions:obtain	()Lcom/tencent/image/URLDrawable$URLDrawableOptions;
    //   119: astore 8
    //   121: aload 8
    //   123: aload_1
    //   124: putfield 193	com/tencent/image/URLDrawable$URLDrawableOptions:mLoadingDrawable	Landroid/graphics/drawable/Drawable;
    //   127: aload 8
    //   129: aload 6
    //   131: putfield 190	com/tencent/image/URLDrawable$URLDrawableOptions:mFailedDrawable	Landroid/graphics/drawable/Drawable;
    //   134: aload 8
    //   136: aload_0
    //   137: putfield 271	com/tencent/image/URLDrawable$URLDrawableOptions:mExtraInfo	Ljava/lang/Object;
    //   140: aload_0
    //   141: getfield 73	com/tencent/mobileqq/emoticonview/FavoriteEmoticonInfo:path	Ljava/lang/String;
    //   144: invokestatic 41	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   147: ifne +70 -> 217
    //   150: aload 7
    //   152: aload 8
    //   154: invokestatic 202	com/tencent/image/URLDrawable:getDrawable	(Ljava/net/URL;Lcom/tencent/image/URLDrawable$URLDrawableOptions;)Lcom/tencent/image/URLDrawable;
    //   157: astore_1
    //   158: aload_1
    //   159: aload 5
    //   161: invokevirtual 275	com/tencent/image/URLDrawable:setTag	(Ljava/lang/Object;)V
    //   164: aload_1
    //   165: areturn
    //   166: astore 5
    //   168: invokestatic 208	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   171: ifeq +14 -> 185
    //   174: ldc 14
    //   176: iconst_2
    //   177: aload 5
    //   179: invokevirtual 278	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   182: invokestatic 281	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   185: aconst_null
    //   186: astore 6
    //   188: goto -121 -> 67
    //   191: astore_1
    //   192: invokestatic 208	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   195: ifeq +13 -> 208
    //   198: ldc 14
    //   200: iconst_2
    //   201: aload_1
    //   202: invokevirtual 282	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   205: invokestatic 281	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   208: aconst_null
    //   209: astore 6
    //   211: aload 5
    //   213: astore_1
    //   214: goto -147 -> 67
    //   217: ldc 14
    //   219: iconst_1
    //   220: new 210	java/lang/StringBuilder
    //   223: dup
    //   224: invokespecial 211	java/lang/StringBuilder:<init>	()V
    //   227: ldc_w 305
    //   230: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: aload_0
    //   234: invokevirtual 285	com/tencent/mobileqq/emoticonview/FavoriteEmoticonInfo:toString	()Ljava/lang/String;
    //   237: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: invokevirtual 235	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   243: invokestatic 281	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   246: aconst_null
    //   247: areturn
    //   248: astore_1
    //   249: aload_1
    //   250: invokevirtual 242	java/net/MalformedURLException:printStackTrace	()V
    //   253: ldc 14
    //   255: iconst_1
    //   256: ldc_w 307
    //   259: aload_1
    //   260: invokestatic 290	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   263: goto -17 -> 246
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	266	0	this	FavoriteEmoticonInfo
    //   0	266	1	paramContext	Context
    //   0	266	2	paramFloat	float
    //   0	266	3	paramInt1	int
    //   0	266	4	paramInt2	int
    //   14	146	5	localObject1	Object
    //   166	46	5	localException	java.lang.Exception
    //   7	203	6	localObject2	Object
    //   22	129	7	localObject3	Object
    //   119	34	8	localURLDrawableOptions	URLDrawable.URLDrawableOptions
    // Exception table:
    //   from	to	target	type
    //   16	24	166	java/lang/Exception
    //   31	40	166	java/lang/Exception
    //   47	56	166	java/lang/Exception
    //   16	24	191	java/lang/OutOfMemoryError
    //   31	40	191	java/lang/OutOfMemoryError
    //   47	56	191	java/lang/OutOfMemoryError
    //   67	164	248	java/net/MalformedURLException
    //   217	246	248	java/net/MalformedURLException
  }
  
  public boolean isChecked()
  {
    return this.isChecked;
  }
  
  public void send(QQAppInterface paramQQAppInterface, Context paramContext, EditText paramEditText, SessionInfo paramSessionInfo)
  {
    if (paramQQAppInterface == null) {
      QLog.e("FavoriteEmoticonInfo", 2, "app is null.");
    }
    long l;
    do
    {
      return;
      l = System.currentTimeMillis();
      if (l - lastTime >= 1000L) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("FavoriteEmoticonInfo", 2, "send to offen,please try it later");
    return;
    lastTime = l;
    if (ahsj.a(this.actionData))
    {
      sendStructMsgForImage(paramQQAppInterface, paramSessionInfo);
      return;
    }
    if (((paramContext instanceof BaseActivity)) && (axnp.a(paramSessionInfo.curType, paramSessionInfo.curFriendUin)))
    {
      paramContext = (BaseActivity)paramContext;
      QQToast.a(paramQQAppInterface.getApp(), anvx.a(2131703860), 0).b(paramContext.getTitleBarHeight());
      return;
    }
    paramEditText = this.path;
    if (!TextUtils.isEmpty(this.eId)) {}
    for (boolean bool = true;; bool = false)
    {
      admh.a(paramQQAppInterface, paramContext, paramSessionInfo, paramEditText, true, bool, this.eId, null);
      if ((TextUtils.isEmpty(this.path)) || (!this.path.contains("qto_"))) {
        break;
      }
      bdla.b(((BaseActivity)paramContext).app, "CliOper", "", "", "0X8005C74", "0X8005C74", 0, 0, String.valueOf(anvn.a(this.eId)), "", anvn.a(this.path), "");
      return;
    }
    bdla.b(((BaseActivity)paramContext).app, "CliOper", "", "", "ep_mall", "0X800579F", 0, 0, "", "", "1", "");
  }
  
  public void setIsChecked(boolean paramBoolean)
  {
    this.isChecked = paramBoolean;
  }
  
  public String toString()
  {
    return String.format("FavoriteEmoticonInfo, path %s, url %s", new Object[] { this.path, this.url });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.FavoriteEmoticonInfo
 * JD-Core Version:    0.7.0.1
 */