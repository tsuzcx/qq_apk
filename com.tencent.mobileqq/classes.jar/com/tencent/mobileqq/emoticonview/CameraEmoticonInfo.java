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

public class CameraEmoticonInfo
  extends CustomEmoticonInfoBase
  implements Parcelable, ICustomEmotionInfo
{
  public static final Parcelable.Creator<CameraEmoticonInfo> CREATOR = new CameraEmoticonInfo.1();
  public static final String TAG = "CameraEmoticonInfo";
  public String contextKey;
  private ColorDrawable mEmptyDrawable = new ColorDrawable();
  public String templateId;
  public String thumbPath;
  
  public CameraEmoticonInfo() {}
  
  protected CameraEmoticonInfo(Parcel paramParcel)
  {
    super(paramParcel);
    this.contextKey = paramParcel.readString();
    this.thumbPath = paramParcel.readString();
    this.templateId = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Drawable getBigDrawable(Context paramContext, float paramFloat)
  {
    try
    {
      URL localURL = new URL(((IEmoticonInfoService)QRoute.api(IEmoticonInfoService.class)).getVasExtensionDownloaderProtocol(), "BUSINESS_CAMERA_EMO_PANEL_DYNAMIC", this.path);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestHeight = ((int)(100.0F * paramFloat));
      localURLDrawableOptions.mRequestWidth = ((int)(100.0F * paramFloat));
      localURLDrawableOptions.mFailedDrawable = paramContext.getResources().getDrawable(2130846574);
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
      URL localURL = new URL(((IEmoticonInfoService)QRoute.api(IEmoticonInfoService.class)).getVasExtensionDownloaderProtocol(), "BUSINESS_CAMERA_EMO_PANEL_DYNAMIC", this.path);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestHeight = paramInt1;
      localURLDrawableOptions.mRequestWidth = paramInt2;
      localURLDrawableOptions.mFailedDrawable = paramContext.getResources().getDrawable(2130846574);
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
    //   1: getfield 75	com/tencent/mobileqq/emoticonview/CameraEmoticonInfo:path	Ljava/lang/String;
    //   4: astore 4
    //   6: aload_0
    //   7: getfield 169	com/tencent/mobileqq/emoticonview/CameraEmoticonInfo:roamingType	Ljava/lang/String;
    //   10: ldc 171
    //   12: invokevirtual 177	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   15: ifne +15 -> 30
    //   18: aload_0
    //   19: getfield 169	com/tencent/mobileqq/emoticonview/CameraEmoticonInfo:roamingType	Ljava/lang/String;
    //   22: ldc 179
    //   24: invokevirtual 177	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   27: ifeq +267 -> 294
    //   30: aload 4
    //   32: invokestatic 185	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   35: ifne +18 -> 53
    //   38: new 187	java/io/File
    //   41: dup
    //   42: aload 4
    //   44: invokespecial 190	java/io/File:<init>	(Ljava/lang/String;)V
    //   47: invokevirtual 193	java/io/File:exists	()Z
    //   50: ifne +244 -> 294
    //   53: aload_0
    //   54: getfield 49	com/tencent/mobileqq/emoticonview/CameraEmoticonInfo:thumbPath	Ljava/lang/String;
    //   57: astore 4
    //   59: aload_1
    //   60: invokevirtual 98	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   63: astore_3
    //   64: aload_3
    //   65: ldc 194
    //   67: invokevirtual 105	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   70: astore_1
    //   71: aload_3
    //   72: ldc 99
    //   74: invokevirtual 105	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   77: astore 5
    //   79: aload_1
    //   80: astore_3
    //   81: aload 5
    //   83: astore_1
    //   84: new 59	java/net/URL
    //   87: dup
    //   88: ldc 61
    //   90: invokestatic 67	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   93: checkcast 61	com/tencent/mobileqq/emoticonview/api/IEmoticonInfoService
    //   96: invokeinterface 70 1 0
    //   101: ldc 196
    //   103: aload 4
    //   105: invokespecial 78	java/net/URL:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   108: astore 6
    //   110: new 198	com/tencent/mobileqq/activity/photo/LocalMediaInfo
    //   113: dup
    //   114: invokespecial 199	com/tencent/mobileqq/activity/photo/LocalMediaInfo:<init>	()V
    //   117: astore 5
    //   119: aload 5
    //   121: aload 4
    //   123: putfield 200	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   126: aload 5
    //   128: bipush 100
    //   130: putfield 203	com/tencent/mobileqq/activity/photo/LocalMediaInfo:thumbWidth	I
    //   133: aload 5
    //   135: bipush 100
    //   137: putfield 206	com/tencent/mobileqq/activity/photo/LocalMediaInfo:thumbHeight	I
    //   140: invokestatic 84	com/tencent/image/URLDrawable$URLDrawableOptions:obtain	()Lcom/tencent/image/URLDrawable$URLDrawableOptions;
    //   143: astore 7
    //   145: aload 7
    //   147: aload_3
    //   148: putfield 112	com/tencent/image/URLDrawable$URLDrawableOptions:mLoadingDrawable	Landroid/graphics/drawable/Drawable;
    //   151: aload 7
    //   153: aload_1
    //   154: putfield 109	com/tencent/image/URLDrawable$URLDrawableOptions:mFailedDrawable	Landroid/graphics/drawable/Drawable;
    //   157: aload 7
    //   159: aload_0
    //   160: putfield 210	com/tencent/image/URLDrawable$URLDrawableOptions:mExtraInfo	Ljava/lang/Object;
    //   163: aload 4
    //   165: invokestatic 185	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   168: ifne +71 -> 239
    //   171: aload 6
    //   173: aload 7
    //   175: invokestatic 121	com/tencent/image/URLDrawable:getDrawable	(Ljava/net/URL;Lcom/tencent/image/URLDrawable$URLDrawableOptions;)Lcom/tencent/image/URLDrawable;
    //   178: astore_1
    //   179: aload_1
    //   180: aload 5
    //   182: invokevirtual 214	com/tencent/image/URLDrawable:setTag	(Ljava/lang/Object;)V
    //   185: aload_1
    //   186: areturn
    //   187: astore_3
    //   188: aconst_null
    //   189: astore_1
    //   190: invokestatic 127	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   193: ifeq +13 -> 206
    //   196: ldc 15
    //   198: iconst_2
    //   199: aload_3
    //   200: invokevirtual 217	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   203: invokestatic 220	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   206: aload_1
    //   207: astore_3
    //   208: aconst_null
    //   209: astore_1
    //   210: goto -126 -> 84
    //   213: astore_3
    //   214: aconst_null
    //   215: astore_1
    //   216: invokestatic 127	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   219: ifeq +13 -> 232
    //   222: ldc 15
    //   224: iconst_2
    //   225: aload_3
    //   226: invokevirtual 221	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   229: invokestatic 220	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   232: aload_1
    //   233: astore_3
    //   234: aconst_null
    //   235: astore_1
    //   236: goto -152 -> 84
    //   239: ldc 15
    //   241: iconst_1
    //   242: new 129	java/lang/StringBuilder
    //   245: dup
    //   246: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   249: ldc 223
    //   251: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: aload_0
    //   255: invokevirtual 224	com/tencent/mobileqq/emoticonview/CameraEmoticonInfo:toString	()Ljava/lang/String;
    //   258: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   264: invokestatic 220	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   267: aconst_null
    //   268: areturn
    //   269: astore_1
    //   270: aload_1
    //   271: invokevirtual 161	java/net/MalformedURLException:printStackTrace	()V
    //   274: ldc 15
    //   276: iconst_1
    //   277: ldc 226
    //   279: aload_1
    //   280: invokestatic 229	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   283: goto -16 -> 267
    //   286: astore_3
    //   287: goto -71 -> 216
    //   290: astore_3
    //   291: goto -101 -> 190
    //   294: goto -235 -> 59
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	297	0	this	CameraEmoticonInfo
    //   0	297	1	paramContext	Context
    //   0	297	2	paramFloat	float
    //   63	85	3	localObject1	Object
    //   187	13	3	localException1	java.lang.Exception
    //   207	1	3	localContext1	Context
    //   213	13	3	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   233	1	3	localContext2	Context
    //   286	1	3	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   290	1	3	localException2	java.lang.Exception
    //   4	160	4	str	String
    //   77	104	5	localObject2	Object
    //   108	64	6	localURL	URL
    //   143	31	7	localURLDrawableOptions	URLDrawable.URLDrawableOptions
    // Exception table:
    //   from	to	target	type
    //   59	71	187	java/lang/Exception
    //   59	71	213	java/lang/OutOfMemoryError
    //   84	185	269	java/net/MalformedURLException
    //   239	267	269	java/net/MalformedURLException
    //   71	79	286	java/lang/OutOfMemoryError
    //   71	79	290	java/lang/Exception
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
  
  public void send(AppRuntime paramAppRuntime, Context paramContext, EditText paramEditText, Parcelable paramParcelable)
  {
    IEmoticonInfoSender localIEmoticonInfoSender = SystemEmotionPanelManager.a().a(11);
    if (localIEmoticonInfoSender == null)
    {
      QLog.e("CameraEmoticonInfo", 1, "emotionInfoSender is null.");
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
    return String.format("CameraEmoticonInfo, path %s, url %s, contextKey %s", new Object[] { this.path, this.url, this.contextKey });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.contextKey);
    paramParcel.writeString(this.thumbPath);
    paramParcel.writeString(this.templateId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.CameraEmoticonInfo
 * JD-Core Version:    0.7.0.1
 */