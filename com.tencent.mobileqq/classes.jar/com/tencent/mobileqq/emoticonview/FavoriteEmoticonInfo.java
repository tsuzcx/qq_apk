package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.photo.AIOGallerySceneWithBusiness;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FunnyPicHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.VipComicFavorEmoStructMsgInfo;
import com.tencent.mobileqq.nearby.HotChatUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.comic.VipComicReportUtils;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class FavoriteEmoticonInfo
  extends EmoticonInfo
{
  static long jdField_a_of_type_Long;
  private ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable();
  public String c;
  public String d;
  public String e;
  public String f;
  
  public FavoriteEmoticonInfo()
  {
    this.b = "show_fav_menu";
  }
  
  public static String a(Map paramMap, String paramString)
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
  
  private void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("image_url", this.d);
    localBundle.putInt("forward_type", -3);
    localBundle.putString("pkg_name", "com.tencent.mobileqq");
    localBundle.putInt("req_type", 5);
    localBundle.putString("brief_key", "[图片]");
    localBundle.putString("app_name", "QQ动漫");
    localBundle.putString("struct_share_key_content_action_DATA", this.f);
    StructMsgForImageShare.sendAndUploadImageShare(paramQQAppInterface, (StructMsgForImageShare)StructMsgFactory.a(localBundle), paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.b, 0);
    paramSessionInfo = AIOGallerySceneWithBusiness.a(this.f);
    if ((paramSessionInfo != null) && (paramSessionInfo.length >= 8)) {
      VipComicReportUtils.a(paramQQAppInterface, "100007", "2", "40051", paramSessionInfo[0], new String[] { paramSessionInfo[2], paramSessionInfo[4], AIOGallerySceneWithBusiness.a(this.f) });
    }
  }
  
  /* Error */
  public Drawable a(Context paramContext, float paramFloat)
  {
    // Byte code:
    //   0: new 18	android/graphics/drawable/ColorDrawable
    //   3: dup
    //   4: invokespecial 19	android/graphics/drawable/ColorDrawable:<init>	()V
    //   7: astore 4
    //   9: aload 4
    //   11: astore_1
    //   12: aload 4
    //   14: astore_3
    //   15: invokestatic 142	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   18: invokevirtual 146	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   21: astore 5
    //   23: aload 4
    //   25: astore_1
    //   26: aload 4
    //   28: astore_3
    //   29: aload 5
    //   31: ldc 147
    //   33: invokevirtual 153	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   36: astore 4
    //   38: aload 4
    //   40: astore_1
    //   41: aload 4
    //   43: astore_3
    //   44: aload 5
    //   46: ldc 154
    //   48: invokevirtual 153	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   51: astore 5
    //   53: aload 5
    //   55: astore_3
    //   56: aload 4
    //   58: astore_1
    //   59: aload_3
    //   60: astore 4
    //   62: new 156	java/net/URL
    //   65: dup
    //   66: ldc 158
    //   68: ldc 160
    //   70: aload_0
    //   71: getfield 63	com/tencent/mobileqq/emoticonview/FavoriteEmoticonInfo:d	Ljava/lang/String;
    //   74: invokespecial 163	java/net/URL:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   77: astore 5
    //   79: new 165	com/tencent/mobileqq/activity/photo/LocalMediaInfo
    //   82: dup
    //   83: invokespecial 166	com/tencent/mobileqq/activity/photo/LocalMediaInfo:<init>	()V
    //   86: astore_3
    //   87: aload_3
    //   88: aload_0
    //   89: getfield 63	com/tencent/mobileqq/emoticonview/FavoriteEmoticonInfo:d	Ljava/lang/String;
    //   92: putfield 169	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   95: aload_3
    //   96: bipush 100
    //   98: putfield 172	com/tencent/mobileqq/activity/photo/LocalMediaInfo:thumbWidth	I
    //   101: aload_3
    //   102: bipush 100
    //   104: putfield 175	com/tencent/mobileqq/activity/photo/LocalMediaInfo:thumbHeight	I
    //   107: invokestatic 181	com/tencent/image/URLDrawable$URLDrawableOptions:obtain	()Lcom/tencent/image/URLDrawable$URLDrawableOptions;
    //   110: astore 6
    //   112: aload 6
    //   114: aload_1
    //   115: putfield 185	com/tencent/image/URLDrawable$URLDrawableOptions:mLoadingDrawable	Landroid/graphics/drawable/Drawable;
    //   118: aload 6
    //   120: aload 4
    //   122: putfield 188	com/tencent/image/URLDrawable$URLDrawableOptions:mFailedDrawable	Landroid/graphics/drawable/Drawable;
    //   125: aload 6
    //   127: aload_0
    //   128: putfield 192	com/tencent/image/URLDrawable$URLDrawableOptions:mExtraInfo	Ljava/lang/Object;
    //   131: aload_0
    //   132: getfield 63	com/tencent/mobileqq/emoticonview/FavoriteEmoticonInfo:d	Ljava/lang/String;
    //   135: invokestatic 34	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   138: ifne +66 -> 204
    //   141: aload 5
    //   143: aload 6
    //   145: invokestatic 197	com/tencent/image/URLDrawable:getDrawable	(Ljava/net/URL;Lcom/tencent/image/URLDrawable$URLDrawableOptions;)Lcom/tencent/image/URLDrawable;
    //   148: astore_1
    //   149: aload_1
    //   150: aload_3
    //   151: invokevirtual 201	com/tencent/image/URLDrawable:setTag	(Ljava/lang/Object;)V
    //   154: aload_1
    //   155: areturn
    //   156: astore_3
    //   157: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   160: ifeq +13 -> 173
    //   163: ldc 209
    //   165: iconst_2
    //   166: aload_3
    //   167: invokevirtual 212	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   170: invokestatic 215	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   173: aconst_null
    //   174: astore 4
    //   176: goto -114 -> 62
    //   179: astore_1
    //   180: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   183: ifeq +13 -> 196
    //   186: ldc 209
    //   188: iconst_2
    //   189: aload_1
    //   190: invokevirtual 216	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   193: invokestatic 215	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   196: aconst_null
    //   197: astore 4
    //   199: aload_3
    //   200: astore_1
    //   201: goto -139 -> 62
    //   204: ldc 209
    //   206: iconst_1
    //   207: new 218	java/lang/StringBuilder
    //   210: dup
    //   211: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   214: ldc 221
    //   216: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: aload_0
    //   220: invokevirtual 228	com/tencent/mobileqq/emoticonview/FavoriteEmoticonInfo:toString	()Ljava/lang/String;
    //   223: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   229: invokestatic 215	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   232: aconst_null
    //   233: areturn
    //   234: astore_1
    //   235: aload_1
    //   236: invokevirtual 232	java/net/MalformedURLException:printStackTrace	()V
    //   239: ldc 209
    //   241: iconst_1
    //   242: ldc 234
    //   244: aload_1
    //   245: invokestatic 237	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   248: goto -16 -> 232
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	251	0	this	FavoriteEmoticonInfo
    //   0	251	1	paramContext	Context
    //   0	251	2	paramFloat	float
    //   14	137	3	localObject1	Object
    //   156	44	3	localException	java.lang.Exception
    //   7	191	4	localObject2	Object
    //   21	121	5	localObject3	Object
    //   110	34	6	localURLDrawableOptions	URLDrawable.URLDrawableOptions
    // Exception table:
    //   from	to	target	type
    //   15	23	156	java/lang/Exception
    //   29	38	156	java/lang/Exception
    //   44	53	156	java/lang/Exception
    //   15	23	179	java/lang/OutOfMemoryError
    //   29	38	179	java/lang/OutOfMemoryError
    //   44	53	179	java/lang/OutOfMemoryError
    //   62	154	234	java/net/MalformedURLException
    //   204	232	234	java/net/MalformedURLException
  }
  
  public Drawable a(Context paramContext, float paramFloat, int paramInt1, int paramInt2)
  {
    try
    {
      URL localURL = new URL("protocol_vas_extension_image", "FAVOROTE_PANEL_DYNAMIC", this.d);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestHeight = paramInt1;
      localURLDrawableOptions.mRequestWidth = paramInt2;
      localURLDrawableOptions.mFailedDrawable = paramContext.getResources().getDrawable(2130841377);
      localURLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
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
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, EditText paramEditText, SessionInfo paramSessionInfo)
  {
    long l = System.currentTimeMillis();
    if (l - jdField_a_of_type_Long < 1000L)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FavoriteEmoticonInfo", 2, "send to offen,please try it later");
      }
      return;
    }
    jdField_a_of_type_Long = l;
    if (AIOGallerySceneWithBusiness.a(this.f))
    {
      a(paramQQAppInterface, paramSessionInfo);
      return;
    }
    if (((paramContext instanceof BaseActivity)) && (HotChatUtil.a(paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      paramContext = (BaseActivity)paramContext;
      QQToast.a(paramQQAppInterface.getApp(), "热聊暂不支持发送自定义表情", 0).b(paramContext.getTitleBarHeight());
      return;
    }
    paramEditText = this.d;
    if (!TextUtils.isEmpty(this.c)) {}
    for (boolean bool = true;; bool = false)
    {
      ChatActivityFacade.a(paramQQAppInterface, paramContext, paramSessionInfo, paramEditText, true, bool, this.c, null);
      if ((TextUtils.isEmpty(this.d)) || (!this.d.contains("qto_"))) {
        break;
      }
      ReportController.b(((BaseActivity)paramContext).app, "CliOper", "", "", "0X8005C74", "0X8005C74", 0, 0, String.valueOf(FunnyPicHelper.a(this.c)), "", FunnyPicHelper.a(this.d), "");
      return;
    }
    ReportController.b(((BaseActivity)paramContext).app, "CliOper", "", "", "ep_mall", "0X800579F", 0, 0, "", "", "1", "");
  }
  
  public Drawable b(Context paramContext, float paramFloat)
  {
    try
    {
      URL localURL = new URL("protocol_vas_extension_image", "FAVOROTE_PANEL_DYNAMIC", this.d);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestHeight = ((int)(100.0F * paramFloat));
      localURLDrawableOptions.mRequestWidth = ((int)(100.0F * paramFloat));
      localURLDrawableOptions.mFailedDrawable = paramContext.getResources().getDrawable(2130841377);
      localURLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
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
  
  public String toString()
  {
    return String.format("FavoriteEmoticonInfo, path %s, url %s", new Object[] { this.d, this.e });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.FavoriteEmoticonInfo
 * JD-Core Version:    0.7.0.1
 */