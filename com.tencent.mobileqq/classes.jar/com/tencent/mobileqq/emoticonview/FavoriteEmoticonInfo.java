package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.widget.EditText;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.core.SystemEmotionPanelManager;
import com.tencent.mobileqq.emoticonview.api.IEmoticonInfoService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import mqq.app.AppRuntime;

public class FavoriteEmoticonInfo
  extends CustomEmoticonInfoBase
  implements Parcelable, ICustomEmotionInfo
{
  public static final Parcelable.Creator<FavoriteEmoticonInfo> CREATOR = new FavoriteEmoticonInfo.1();
  public static final String TAG = "FavoriteEmoticonInfo";
  public String actionData;
  private ColorDrawable mEmptyDrawable = new ColorDrawable();
  
  public FavoriteEmoticonInfo()
  {
    this.longClickAction = "show_fav_menu";
  }
  
  protected FavoriteEmoticonInfo(Parcel paramParcel)
  {
    super(paramParcel);
    this.actionData = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Drawable getBigDrawable(Context paramContext, float paramFloat)
  {
    try
    {
      URL localURL = new URL(((IEmoticonInfoService)QRoute.api(IEmoticonInfoService.class)).getVasExtensionDownloaderProtocol(), "FAVOROTE_PANEL_DYNAMIC", this.path);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestHeight = ((int)(100.0F * paramFloat));
      localURLDrawableOptions.mRequestWidth = ((int)(100.0F * paramFloat));
      localURLDrawableOptions.mFailedDrawable = paramContext.getResources().getDrawable(2130846574);
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
      URL localURL = new URL(((IEmoticonInfoService)QRoute.api(IEmoticonInfoService.class)).getVasExtensionDownloaderProtocol(), "FAVOROTE_PANEL_DYNAMIC", this.path);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestHeight = paramInt1;
      localURLDrawableOptions.mRequestWidth = paramInt2;
      localURLDrawableOptions.mFailedDrawable = paramContext.getResources().getDrawable(2130846574);
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
    //   0: new 31	android/graphics/drawable/ColorDrawable
    //   3: dup
    //   4: invokespecial 32	android/graphics/drawable/ColorDrawable:<init>	()V
    //   7: astore 5
    //   9: aload 5
    //   11: astore_3
    //   12: aload 5
    //   14: astore 4
    //   16: aload_1
    //   17: invokevirtual 97	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   20: astore 6
    //   22: aload 5
    //   24: astore_3
    //   25: aload 5
    //   27: astore 4
    //   29: aload 6
    //   31: ldc 166
    //   33: invokevirtual 104	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   36: astore_1
    //   37: aload_1
    //   38: astore_3
    //   39: aload_1
    //   40: astore 4
    //   42: aload 6
    //   44: ldc 98
    //   46: invokevirtual 104	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   49: astore 5
    //   51: aload 5
    //   53: astore 4
    //   55: aload_1
    //   56: astore_3
    //   57: aload 4
    //   59: astore_1
    //   60: new 58	java/net/URL
    //   63: dup
    //   64: ldc 60
    //   66: invokestatic 66	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   69: checkcast 60	com/tencent/mobileqq/emoticonview/api/IEmoticonInfoService
    //   72: invokeinterface 69 1 0
    //   77: ldc 168
    //   79: aload_0
    //   80: getfield 74	com/tencent/mobileqq/emoticonview/FavoriteEmoticonInfo:path	Ljava/lang/String;
    //   83: invokespecial 77	java/net/URL:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   86: astore 5
    //   88: new 170	com/tencent/mobileqq/activity/photo/LocalMediaInfo
    //   91: dup
    //   92: invokespecial 171	com/tencent/mobileqq/activity/photo/LocalMediaInfo:<init>	()V
    //   95: astore 4
    //   97: aload 4
    //   99: aload_0
    //   100: getfield 74	com/tencent/mobileqq/emoticonview/FavoriteEmoticonInfo:path	Ljava/lang/String;
    //   103: putfield 172	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   106: aload 4
    //   108: bipush 100
    //   110: putfield 175	com/tencent/mobileqq/activity/photo/LocalMediaInfo:thumbWidth	I
    //   113: aload 4
    //   115: bipush 100
    //   117: putfield 178	com/tencent/mobileqq/activity/photo/LocalMediaInfo:thumbHeight	I
    //   120: invokestatic 83	com/tencent/image/URLDrawable$URLDrawableOptions:obtain	()Lcom/tencent/image/URLDrawable$URLDrawableOptions;
    //   123: astore 6
    //   125: aload 6
    //   127: aload_3
    //   128: putfield 111	com/tencent/image/URLDrawable$URLDrawableOptions:mLoadingDrawable	Landroid/graphics/drawable/Drawable;
    //   131: aload 6
    //   133: aload_1
    //   134: putfield 108	com/tencent/image/URLDrawable$URLDrawableOptions:mFailedDrawable	Landroid/graphics/drawable/Drawable;
    //   137: aload 6
    //   139: aload_0
    //   140: putfield 182	com/tencent/image/URLDrawable$URLDrawableOptions:mExtraInfo	Ljava/lang/Object;
    //   143: aload_0
    //   144: getfield 74	com/tencent/mobileqq/emoticonview/FavoriteEmoticonInfo:path	Ljava/lang/String;
    //   147: invokestatic 188	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   150: ifne +66 -> 216
    //   153: aload 5
    //   155: aload 6
    //   157: invokestatic 120	com/tencent/image/URLDrawable:getDrawable	(Ljava/net/URL;Lcom/tencent/image/URLDrawable$URLDrawableOptions;)Lcom/tencent/image/URLDrawable;
    //   160: astore_1
    //   161: aload_1
    //   162: aload 4
    //   164: invokevirtual 192	com/tencent/image/URLDrawable:setTag	(Ljava/lang/Object;)V
    //   167: aload_1
    //   168: areturn
    //   169: astore_1
    //   170: invokestatic 126	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   173: ifeq +13 -> 186
    //   176: ldc 15
    //   178: iconst_2
    //   179: aload_1
    //   180: invokevirtual 195	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   183: invokestatic 198	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   186: aconst_null
    //   187: astore_1
    //   188: goto -128 -> 60
    //   191: astore_1
    //   192: invokestatic 126	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   195: ifeq +13 -> 208
    //   198: ldc 15
    //   200: iconst_2
    //   201: aload_1
    //   202: invokevirtual 199	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   205: invokestatic 198	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   208: aload 4
    //   210: astore_3
    //   211: aconst_null
    //   212: astore_1
    //   213: goto -153 -> 60
    //   216: ldc 15
    //   218: iconst_1
    //   219: new 128	java/lang/StringBuilder
    //   222: dup
    //   223: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   226: ldc 201
    //   228: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: aload_0
    //   232: invokevirtual 202	com/tencent/mobileqq/emoticonview/FavoriteEmoticonInfo:toString	()Ljava/lang/String;
    //   235: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   241: invokestatic 198	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   244: aconst_null
    //   245: areturn
    //   246: astore_1
    //   247: aload_1
    //   248: invokevirtual 160	java/net/MalformedURLException:printStackTrace	()V
    //   251: ldc 15
    //   253: iconst_1
    //   254: ldc 204
    //   256: aload_1
    //   257: invokestatic 207	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   260: goto -16 -> 244
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	263	0	this	FavoriteEmoticonInfo
    //   0	263	1	paramContext	Context
    //   0	263	2	paramFloat	float
    //   11	200	3	localObject1	Object
    //   14	195	4	localObject2	Object
    //   7	147	5	localObject3	Object
    //   20	136	6	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   16	22	169	java/lang/Exception
    //   29	37	169	java/lang/Exception
    //   42	51	169	java/lang/Exception
    //   16	22	191	java/lang/OutOfMemoryError
    //   29	37	191	java/lang/OutOfMemoryError
    //   42	51	191	java/lang/OutOfMemoryError
    //   60	167	246	java/net/MalformedURLException
    //   216	244	246	java/net/MalformedURLException
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
    //   0: new 31	android/graphics/drawable/ColorDrawable
    //   3: dup
    //   4: invokespecial 32	android/graphics/drawable/ColorDrawable:<init>	()V
    //   7: astore 7
    //   9: aload 7
    //   11: astore 5
    //   13: aload 7
    //   15: astore 6
    //   17: aload_1
    //   18: invokevirtual 97	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   21: astore 8
    //   23: aload 7
    //   25: astore 5
    //   27: aload 7
    //   29: astore 6
    //   31: aload 8
    //   33: ldc 166
    //   35: invokevirtual 104	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   38: astore_1
    //   39: aload_1
    //   40: astore 5
    //   42: aload_1
    //   43: astore 6
    //   45: aload 8
    //   47: ldc 98
    //   49: invokevirtual 104	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   52: astore 7
    //   54: aload 7
    //   56: astore 6
    //   58: aload_1
    //   59: astore 5
    //   61: aload 6
    //   63: astore_1
    //   64: new 58	java/net/URL
    //   67: dup
    //   68: ldc 60
    //   70: invokestatic 66	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   73: checkcast 60	com/tencent/mobileqq/emoticonview/api/IEmoticonInfoService
    //   76: invokeinterface 69 1 0
    //   81: ldc 220
    //   83: aload_0
    //   84: getfield 74	com/tencent/mobileqq/emoticonview/FavoriteEmoticonInfo:path	Ljava/lang/String;
    //   87: invokespecial 77	java/net/URL:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   90: astore 7
    //   92: new 170	com/tencent/mobileqq/activity/photo/LocalMediaInfo
    //   95: dup
    //   96: invokespecial 171	com/tencent/mobileqq/activity/photo/LocalMediaInfo:<init>	()V
    //   99: astore 6
    //   101: aload 6
    //   103: aload_0
    //   104: getfield 74	com/tencent/mobileqq/emoticonview/FavoriteEmoticonInfo:path	Ljava/lang/String;
    //   107: putfield 172	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   110: aload 6
    //   112: iload_3
    //   113: putfield 175	com/tencent/mobileqq/activity/photo/LocalMediaInfo:thumbWidth	I
    //   116: aload 6
    //   118: iload 4
    //   120: putfield 178	com/tencent/mobileqq/activity/photo/LocalMediaInfo:thumbHeight	I
    //   123: invokestatic 83	com/tencent/image/URLDrawable$URLDrawableOptions:obtain	()Lcom/tencent/image/URLDrawable$URLDrawableOptions;
    //   126: astore 8
    //   128: aload 8
    //   130: aload 5
    //   132: putfield 111	com/tencent/image/URLDrawable$URLDrawableOptions:mLoadingDrawable	Landroid/graphics/drawable/Drawable;
    //   135: aload 8
    //   137: aload_1
    //   138: putfield 108	com/tencent/image/URLDrawable$URLDrawableOptions:mFailedDrawable	Landroid/graphics/drawable/Drawable;
    //   141: aload 8
    //   143: aload_0
    //   144: putfield 182	com/tencent/image/URLDrawable$URLDrawableOptions:mExtraInfo	Ljava/lang/Object;
    //   147: aload_0
    //   148: getfield 74	com/tencent/mobileqq/emoticonview/FavoriteEmoticonInfo:path	Ljava/lang/String;
    //   151: invokestatic 188	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   154: ifne +67 -> 221
    //   157: aload 7
    //   159: aload 8
    //   161: invokestatic 120	com/tencent/image/URLDrawable:getDrawable	(Ljava/net/URL;Lcom/tencent/image/URLDrawable$URLDrawableOptions;)Lcom/tencent/image/URLDrawable;
    //   164: astore_1
    //   165: aload_1
    //   166: aload 6
    //   168: invokevirtual 192	com/tencent/image/URLDrawable:setTag	(Ljava/lang/Object;)V
    //   171: aload_1
    //   172: areturn
    //   173: astore_1
    //   174: invokestatic 126	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   177: ifeq +13 -> 190
    //   180: ldc 15
    //   182: iconst_2
    //   183: aload_1
    //   184: invokevirtual 195	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   187: invokestatic 198	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   190: aconst_null
    //   191: astore_1
    //   192: goto -128 -> 64
    //   195: astore_1
    //   196: invokestatic 126	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   199: ifeq +13 -> 212
    //   202: ldc 15
    //   204: iconst_2
    //   205: aload_1
    //   206: invokevirtual 199	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   209: invokestatic 198	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   212: aload 6
    //   214: astore 5
    //   216: aconst_null
    //   217: astore_1
    //   218: goto -154 -> 64
    //   221: ldc 15
    //   223: iconst_1
    //   224: new 128	java/lang/StringBuilder
    //   227: dup
    //   228: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   231: ldc 222
    //   233: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: aload_0
    //   237: invokevirtual 202	com/tencent/mobileqq/emoticonview/FavoriteEmoticonInfo:toString	()Ljava/lang/String;
    //   240: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   246: invokestatic 198	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   249: aconst_null
    //   250: areturn
    //   251: astore_1
    //   252: aload_1
    //   253: invokevirtual 160	java/net/MalformedURLException:printStackTrace	()V
    //   256: ldc 15
    //   258: iconst_1
    //   259: ldc 224
    //   261: aload_1
    //   262: invokestatic 207	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   265: goto -16 -> 249
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	268	0	this	FavoriteEmoticonInfo
    //   0	268	1	paramContext	Context
    //   0	268	2	paramFloat	float
    //   0	268	3	paramInt1	int
    //   0	268	4	paramInt2	int
    //   11	204	5	localObject1	Object
    //   15	198	6	localObject2	Object
    //   7	151	7	localObject3	Object
    //   21	139	8	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   17	23	173	java/lang/Exception
    //   31	39	173	java/lang/Exception
    //   45	54	173	java/lang/Exception
    //   17	23	195	java/lang/OutOfMemoryError
    //   31	39	195	java/lang/OutOfMemoryError
    //   45	54	195	java/lang/OutOfMemoryError
    //   64	171	251	java/net/MalformedURLException
    //   221	249	251	java/net/MalformedURLException
  }
  
  public boolean isChecked()
  {
    return this.isChecked;
  }
  
  public void send(AppRuntime paramAppRuntime, Context paramContext, EditText paramEditText, Parcelable paramParcelable)
  {
    IEmoticonInfoSender localIEmoticonInfoSender = SystemEmotionPanelManager.a().a(4);
    if (localIEmoticonInfoSender == null)
    {
      QLog.e("FavoriteEmoticonInfo", 1, "emotionInfoSender is null.");
      return;
    }
    localIEmoticonInfoSender.send(this, paramAppRuntime, paramContext, paramEditText, paramParcelable);
  }
  
  public void setIsChecked(boolean paramBoolean)
  {
    this.isChecked = paramBoolean;
  }
  
  public String toString()
  {
    return String.format("FavoriteEmoticonInfo, path %s, url %s", new Object[] { this.path, this.url });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.actionData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.FavoriteEmoticonInfo
 * JD-Core Version:    0.7.0.1
 */