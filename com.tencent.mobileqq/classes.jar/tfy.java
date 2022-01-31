import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqBatchGetVideoFullInfoList;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils.2;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils.3;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils.4;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils.5;
import com.tencent.biz.qqstory.playvideo.entrance.ShareFromMemoryPlayInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams.DecodeHandler;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatcher.Dispatchable;
import java.io.File;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class tfy
{
  private static SparseArray<tgg> a;
  public static final String a;
  public static final int[] a;
  public static final String b;
  
  static
  {
    jdField_a_of_type_JavaLangString = skt.a("StorySvc.report_comment");
    b = skt.a(2131633887);
    jdField_a_of_type_ArrayOfInt = new int[] { 90 };
    jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  }
  
  public static int a(int paramInt)
  {
    if ((paramInt == 76) || (paramInt == 77)) {
      return 221;
    }
    return 220;
  }
  
  public static int a(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0)
    {
      switch (paramInt1)
      {
      default: 
        return 0;
      case 10: 
        return 74;
      case 11: 
        return 76;
      case 23: 
      case 210: 
      case 220: 
        return 75;
      }
      return 77;
    }
    return paramInt2;
  }
  
  public static int a(StoryVideoItem paramStoryVideoItem, int paramInt, String paramString)
  {
    Object localObject2 = vnr.a(a(), paramStoryVideoItem.mVid, paramStoryVideoItem.mVideoWidth, paramStoryVideoItem.mVideoHeight, paramInt);
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      QLog.i("Q.qqstory.player.PlayModeUtils", 1, "get download water mark failed, logoMarkPath is null!");
    }
    Object localObject3 = vnr.b(paramStoryVideoItem);
    Object localObject1 = vnr.a(paramStoryVideoItem);
    String str = vnr.a(paramStoryVideoItem.getInteractLayout(), paramStoryVideoItem.mVideoWidth, paramStoryVideoItem.mVideoHeight);
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
    while ((!TextUtils.isEmpty((CharSequence)localObject3)) && (!TextUtils.isEmpty((CharSequence)localObject1)))
    {
      str = sfm.u;
      str = str + paramStoryVideoItem.mVid + System.currentTimeMillis() + "_max.png";
      if (!vnr.a((String)localObject3, (String)localObject1, str))
      {
        QLog.e("Q.qqstory.player.PlayModeUtils", 2, "combineTwoImg maxMask videoVote failed");
        return -997;
        localObject1 = str;
      }
      else
      {
        localObject1 = str;
      }
    }
    while ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject2)))
    {
      localObject3 = localObject2;
      if (vnr.a((String)localObject1, (String)localObject2, (String)localObject2)) {
        break label236;
      }
      QLog.e("Q.qqstory.player.PlayModeUtils", 2, "watermarkVideoByMediaCodec() combineTwoImg failed");
      return -997;
      if (!TextUtils.isEmpty((CharSequence)localObject3)) {
        localObject1 = localObject3;
      }
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
    label236:
    long l;
    for (;;)
    {
      localObject3 = localObject1;
      localObject1 = new PublishVideoEntry();
      ((PublishVideoEntry)localObject1).doodlePath = ((String)localObject3);
      ((PublishVideoEntry)localObject1).isPicture = false;
      ((PublishVideoEntry)localObject1).mLocalRawVideoDir = paramStoryVideoItem.mLocalVideoPath;
      ((PublishVideoEntry)localObject1).businessId = 1;
      l = SystemClock.elapsedRealtime();
      localObject1 = new auxq(2000000, (PublishVideoEntry)localObject1);
      ((auxq)localObject1).b(0);
      localObject2 = new auxo();
      localObject3 = sfm.k + paramStoryVideoItem.mVid + ".mp4";
      paramInt = ((auxo)localObject2).a(paramStoryVideoItem.mLocalVideoPath, (String)localObject3, (auxq)localObject1);
      if (paramInt == 0) {
        break label481;
      }
      if (paramInt == -1) {
        break;
      }
      urk.b("Q.qqstory.player.PlayModeUtils", new Throwable("MergeVideoError"), "watermarkVideoByMediaCodec() error after mergeVideo() return, errorCode=%d", new Object[] { Integer.valueOf(paramInt) });
      return paramInt;
      localObject1 = localObject2;
    }
    vlm.c(paramStoryVideoItem.mLocalVideoPath, paramString);
    label481:
    for (paramInt = 0;; paramInt = vol.a((String)localObject3, paramStoryVideoItem.mLocalVideoPath, paramString, 0))
    {
      if (paramInt == 0) {
        vlm.a(BaseApplication.getContext(), new File(paramString));
      }
      paramStoryVideoItem = new File((String)localObject3);
      if (paramStoryVideoItem.exists()) {
        paramStoryVideoItem.delete();
      }
      QLog.i("Q.qqstory.player.PlayModeUtils", 1, "hardware watermar cost:" + (SystemClock.elapsedRealtime() - l) / 1000.0D);
      return paramInt;
    }
  }
  
  public static Context a()
  {
    return BaseApplicationImpl.getApplication().getApplicationContext();
  }
  
  public static QQAppInterface a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return (QQAppInterface)localAppRuntime;
    }
    throw new InvalidParameterException("can't get AppInterface");
  }
  
  public static String a(QQUserUIItem paramQQUserUIItem)
  {
    if ((paramQQUserUIItem == null) || (!paramQQUserUIItem.isAvailable())) {
      return b;
    }
    if ((paramQQUserUIItem.isVip) && (!paramQQUserUIItem.isFriend())) {
      return paramQQUserUIItem.nickName;
    }
    return paramQQUserUIItem.getDisplayName();
  }
  
  public static String a(String paramString)
  {
    paramString = ((sqs)sqg.a(2)).b(paramString);
    if (paramString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.qqstory.player.PlayModeUtils", 2, "getNickName, userItem is null");
      }
      return b;
    }
    return a(paramString);
  }
  
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return paramString1;
    }
    if (paramString1.contains("?")) {
      return paramString1 + "&" + paramString2 + "=" + paramString3;
    }
    return paramString1 + "?" + paramString2 + "=" + paramString3;
  }
  
  public static final String a(String paramString, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder().append(ShortVideoUtils.d());
    if (paramBoolean) {}
    for (String str = ".png";; str = ".mp4") {
      return vnr.a(paramString, str);
    }
  }
  
  @NonNull
  public static tgg a(int paramInt)
  {
    tgg localtgg2 = (tgg)jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    tgg localtgg1 = localtgg2;
    if (localtgg2 == null)
    {
      localtgg1 = new tgg();
      jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localtgg1);
    }
    return localtgg1;
  }
  
  public static void a(Context paramContext, CommentEntry paramCommentEntry)
  {
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing())) {}
    do
    {
      do
      {
        return;
        if (badq.d(BaseApplicationImpl.getContext())) {
          break;
        }
        bbmy.a(BaseApplicationImpl.getContext(), 1, ajjy.a(2131642425), 0).a();
        urp.b("story_net", jdField_a_of_type_JavaLangString, 0, 99980, new String[] { "", "0", urp.a(BaseApplication.getContext()) });
      } while (!QLog.isColorLevel());
      QLog.w("Q.qqstory.player.PlayModeUtils", 2, "reportVideoCommemt - isNetSupport is false----");
      return;
      paramContext = (begr)behe.b(paramContext, null);
      paramContext.a(ajjy.a(2131642417), 5);
      paramContext.a(ajjy.a(2131642436), 5);
      paramContext.a(ajjy.a(2131642433), 5);
      paramContext.a(ajjy.a(2131642421), 5);
      paramContext.c(2131625035);
      paramContext.a(new tge(paramCommentEntry, paramContext));
    } while (paramContext.isShowing());
    paramContext.show();
  }
  
  public static void a(Context paramContext, QQUserUIItem paramQQUserUIItem, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    if (!badq.d(BaseApplicationImpl.getContext())) {
      bbmy.a(BaseApplicationImpl.getContext(), 1, ajjy.a(2131642434), 0).a();
    }
    do
    {
      return;
      paramContext = (begr)behe.b(paramContext, null);
      paramContext.a(ajjy.a(2131642432), 5);
      paramContext.a(ajjy.a(2131642426), 5);
      paramContext.a(ajjy.a(2131642439), 5);
      paramContext.a(ajjy.a(2131642416), 5);
      paramContext.c(2131625035);
      paramContext.a(new tgd(paramQQUserUIItem, paramContext));
      paramContext.setOnDismissListener(paramOnDismissListener);
    } while (paramContext.isShowing());
    paramContext.show();
  }
  
  public static void a(Context paramContext, StoryVideoItem paramStoryVideoItem, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    if (!badq.d(BaseApplicationImpl.getContext())) {
      bbmy.a(BaseApplicationImpl.getContext(), 1, ajjy.a(2131642419), 0).a();
    }
    do
    {
      return;
      paramContext = (begr)behe.b(paramContext, null);
      paramContext.a(ajjy.a(2131642415), 5);
      paramContext.a(ajjy.a(2131642418), 5);
      paramContext.a(ajjy.a(2131642437), 5);
      paramContext.a(ajjy.a(2131642438), 5);
      paramContext.c(2131625035);
      paramContext.a(new tgf(paramStoryVideoItem, paramContext));
      paramContext.setOnDismissListener(paramOnDismissListener);
    } while (paramContext.isShowing());
    paramContext.show();
  }
  
  public static void a(Resources paramResources, TextView paramTextView, String paramString, float paramFloat1, float paramFloat2)
  {
    boolean bool = false;
    if ((paramResources == null) || (paramTextView == null) || (!mpl.a(paramString))) {
      if (QLog.isColorLevel())
      {
        paramResources = new StringBuilder().append("setAuthIcon fail：textView is null ? ");
        if (paramTextView == null) {
          bool = true;
        }
        QLog.w("Q.qqstory.player.PlayModeUtils", 2, bool + ", url = " + paramString);
      }
    }
    do
    {
      return;
      try
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        int i = aciy.a(paramFloat1, paramResources);
        Drawable localDrawable = axwd.a;
        localURLDrawableOptions.mFailedDrawable = localDrawable;
        localURLDrawableOptions.mLoadingDrawable = localDrawable;
        localURLDrawableOptions.mRequestHeight = i;
        localURLDrawableOptions.mRequestWidth = i;
        localURLDrawableOptions.mMemoryCacheKeySuffix = "StoryPlayModeAuthIcon";
        paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
        if (paramString.getStatus() == 2) {
          paramString.restartDownload();
        }
        paramString.setBounds(0, 0, i, i);
        paramTextView.setCompoundDrawablePadding(aciy.a(paramFloat2, paramResources));
        paramTextView.setCompoundDrawables(null, null, paramString, null);
        return;
      }
      catch (Exception paramResources) {}
    } while (!QLog.isColorLevel());
    QLog.d("Q.qqstory.player.PlayModeUtils", 2, QLog.getStackTraceString(paramResources));
  }
  
  public static void a(Resources paramResources, QQUserUIItem paramQQUserUIItem, ImageView paramImageView, float paramFloat1, TextView paramTextView, float paramFloat2, float paramFloat3, boolean paramBoolean, String paramString)
  {
    Drawable localDrawable = bacm.b();
    if (paramQQUserUIItem == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.qqstory.player.PlayModeUtils", 2, "setNickNameAndAuthIcon, userItem == null");
      }
      paramImageView.setImageDrawable(localDrawable);
      paramTextView.setText(b);
      return;
    }
    Object localObject;
    int i;
    if (sky.a())
    {
      localObject = paramQQUserUIItem.getUserIconUrl();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.player.PlayModeUtils", 2, "fillFriendsData userIconUrl = " + (String)localObject);
        }
        a(paramResources, paramTextView, (String)localObject, paramFloat2, paramFloat3);
        i = aciy.a(paramFloat1, paramResources);
        if ((!paramQQUserUIItem.isVipButNoFriend()) && (!paramQQUserUIItem.isNotDovUser())) {
          break label255;
        }
        if (!paramBoolean) {
          break label243;
        }
        paramTextView.setText(((sqo)sqg.a(23)).a(paramQQUserUIItem, paramString, false, true));
      }
    }
    for (;;)
    {
      a(paramImageView, paramQQUserUIItem.headUrl, true, i);
      return;
      if (!paramQQUserUIItem.isVipButNoFriend()) {
        break;
      }
      localObject = paramResources.getDrawable(2130845745);
      i = aciy.a(paramFloat2, paramResources);
      int j = aciy.a(paramFloat3, paramResources);
      if (localObject == null) {
        break;
      }
      ((Drawable)localObject).setBounds(0, 0, i, i);
      paramTextView.setCompoundDrawablePadding(j);
      paramTextView.setCompoundDrawables(null, null, (Drawable)localObject, null);
      break;
      paramTextView.setCompoundDrawables(null, null, null, null);
      break;
      label243:
      paramTextView.setText(a(paramQQUserUIItem));
    }
    label255:
    paramTextView.setCompoundDrawables(null, null, null, null);
    if (!TextUtils.isEmpty(paramQQUserUIItem.qq))
    {
      paramResources = azwp.a(a(), 1, paramQQUserUIItem.qq, 3, localDrawable, localDrawable);
      if (paramResources == null)
      {
        paramResources = localDrawable;
        paramImageView.setImageDrawable(paramResources);
      }
    }
    for (;;)
    {
      if (!paramBoolean) {
        break label366;
      }
      paramTextView.setText(((sqo)sqg.a(23)).a(paramQQUserUIItem, paramString, false, true));
      return;
      break;
      if (mpl.a(paramQQUserUIItem.headUrl)) {
        a(paramImageView, paramQQUserUIItem.headUrl, true, i);
      } else {
        paramImageView.setImageDrawable(localDrawable);
      }
    }
    label366:
    paramTextView.setText(a(paramQQUserUIItem));
  }
  
  public static final void a(ImageView paramImageView, QQUserUIItem paramQQUserUIItem)
  {
    if ((paramQQUserUIItem == null) || (paramImageView == null))
    {
      if (QLog.isDevelopLevel()) {
        QLog.w("Q.qqstory.player.PlayModeUtils", 2, "[zivon]PlayModeUtils.setQIMIconImage erroe: item = " + paramQQUserUIItem + ", iconView = " + paramImageView);
      }
      return;
    }
    paramQQUserUIItem = sky.a(paramQQUserUIItem);
    if (!TextUtils.isEmpty(paramQQUserUIItem))
    {
      paramImageView.setVisibility(0);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mFailedDrawable = axwd.a;
      localURLDrawableOptions.mLoadingDrawable = axwd.a;
      localURLDrawableOptions.mUseAutoScaleParams = false;
      paramImageView.setImageDrawable(URLDrawable.getDrawable(paramQQUserUIItem, localURLDrawableOptions));
      return;
    }
    paramImageView.setVisibility(8);
  }
  
  public static final void a(ImageView paramImageView, String paramString)
  {
    Drawable localDrawable = bacm.a();
    paramImageView.setImageDrawable(azwp.a(a(), 1, paramString, 3, localDrawable, localDrawable));
  }
  
  protected static void a(ImageView paramImageView, String paramString1, int paramInt1, int paramInt2, boolean paramBoolean, Drawable paramDrawable, DownloadParams.DecodeHandler paramDecodeHandler, Object paramObject, String paramString2)
  {
    a(paramImageView, paramString1, paramInt1, paramInt2, paramBoolean, paramDrawable, paramDecodeHandler, paramObject, paramString2, null);
  }
  
  protected static void a(ImageView paramImageView, String paramString1, int paramInt1, int paramInt2, boolean paramBoolean, Drawable paramDrawable, DownloadParams.DecodeHandler paramDecodeHandler, Object paramObject, String paramString2, tgk paramtgk)
  {
    for (;;)
    {
      try
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mLoadingDrawable = paramDrawable;
        localURLDrawableOptions.mFailedDrawable = paramDrawable;
        localURLDrawableOptions.mPlayGifImage = false;
        localURLDrawableOptions.mGifRoundCorner = 0.0F;
        if (paramInt1 > 0) {
          localURLDrawableOptions.mRequestWidth = paramInt1;
        }
        if (paramInt2 > 0) {
          localURLDrawableOptions.mRequestHeight = paramInt2;
        }
        localURLDrawableOptions.mMemoryCacheKeySuffix = paramString2;
        if (paramBoolean)
        {
          paramString1 = URLDrawable.getDrawable(new File(paramString1), localURLDrawableOptions);
          paramString1.setDecodeHandler(paramDecodeHandler);
          paramString1.setTag(paramObject);
          paramImageView.setImageDrawable(paramString1);
          if (paramString1 == null) {
            return;
          }
          if (paramString1.getStatus() != 1) {
            break;
          }
          if (paramtgk == null) {
            return;
          }
          paramtgk.a();
          return;
        }
        if (mpl.a(paramString1))
        {
          paramString1 = URLDrawable.getDrawable(a(paramString1, "dummypara", "666"), localURLDrawableOptions);
          paramString1.setDecodeHandler(paramDecodeHandler);
          paramString1.setTag(paramObject);
          paramString1.startDownload();
          paramImageView.setImageDrawable(paramString1);
          continue;
        }
        paramImageView.setImageDrawable(null);
      }
      catch (IllegalArgumentException paramString1)
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.qqstory.player.PlayModeUtils", 2, "setImageView2 fail: " + QLog.getStackTraceString(paramString1));
        }
        paramImageView.setImageDrawable(null);
        return;
      }
      paramString1 = null;
    }
    paramString1.setURLDrawableListener(new tfz(System.currentTimeMillis(), paramtgk));
  }
  
  protected static void a(ImageView paramImageView, String paramString1, int paramInt1, int paramInt2, boolean paramBoolean, DownloadParams.DecodeHandler paramDecodeHandler, Object paramObject, String paramString2)
  {
    a(paramImageView, paramString1, paramInt1, paramInt2, paramBoolean, paramDecodeHandler, paramObject, paramString2, null);
  }
  
  protected static void a(ImageView paramImageView, String paramString1, int paramInt1, int paramInt2, boolean paramBoolean, DownloadParams.DecodeHandler paramDecodeHandler, Object paramObject, String paramString2, tgk paramtgk)
  {
    a(paramImageView, paramString1, paramInt1, paramInt2, paramBoolean, new ColorDrawable(0), paramDecodeHandler, paramObject, paramString2, paramtgk);
  }
  
  public static void a(ImageView paramImageView, String paramString1, String paramString2, boolean paramBoolean)
  {
    b(paramImageView, paramString1, paramString2, paramBoolean, null);
  }
  
  public static void a(ImageView paramImageView, String paramString1, String paramString2, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    DownloadParams.DecodeHandler localDecodeHandler;
    if (paramBoolean)
    {
      localDecodeHandler = azue.a;
      if (!paramBoolean) {
        break label47;
      }
    }
    label47:
    for (String str = "StoryPlayModeRound";; str = null)
    {
      if (!apdh.a(paramString1)) {
        break label53;
      }
      a(paramImageView, paramString1, paramInt1, paramInt2, true, localDecodeHandler, null, str);
      return;
      localDecodeHandler = null;
      break;
    }
    label53:
    a(paramImageView, paramString2, paramInt1, paramInt2, false, localDecodeHandler, null, str);
  }
  
  public static void a(ImageView paramImageView, String paramString1, String paramString2, boolean paramBoolean, tgk paramtgk)
  {
    String str = null;
    boolean bool = apdh.a(paramString1);
    DownloadParams.DecodeHandler localDecodeHandler;
    int[] arrayOfInt;
    if (paramBoolean)
    {
      localDecodeHandler = azue.r;
      if (!paramBoolean) {
        break label73;
      }
      arrayOfInt = jdField_a_of_type_ArrayOfInt;
      label27:
      if (paramBoolean) {
        str = "rotate90";
      }
      if (!bool) {
        break label79;
      }
    }
    for (;;)
    {
      a(paramImageView, paramString1, awmc.jdField_a_of_type_Int / 2, awmc.b / 2, bool, localDecodeHandler, arrayOfInt, str, paramtgk);
      return;
      localDecodeHandler = null;
      break;
      label73:
      arrayOfInt = null;
      break label27;
      label79:
      paramString1 = paramString2;
    }
  }
  
  public static void a(ImageView paramImageView, String paramString, boolean paramBoolean, int paramInt)
  {
    a(paramImageView, null, paramString, paramBoolean, paramInt, paramInt);
  }
  
  public static void a(TextView paramTextView)
  {
    paramTextView.setCompoundDrawables(null, null, null, null);
  }
  
  public static void a(StoryVideoItem paramStoryVideoItem, int paramInt, String paramString)
  {
    ThreadManager.post(new PlayModeUtils.2(paramStoryVideoItem, paramInt, paramString), 5, null, false);
  }
  
  public static void a(ShareFromMemoryPlayInfo paramShareFromMemoryPlayInfo, tgj paramtgj)
  {
    szj localszj = new szj();
    localszj.jdField_c_of_type_JavaLangString = paramShareFromMemoryPlayInfo.uid;
    localszj.d = "";
    localszj.jdField_c_of_type_Int = 20;
    localszj.jdField_e_of_type_Int = paramShareFromMemoryPlayInfo.shareTimeZone;
    localszj.jdField_e_of_type_JavaLangString = paramShareFromMemoryPlayInfo.feedId;
    localszj.f = paramShareFromMemoryPlayInfo.identify;
    localszj.g = paramShareFromMemoryPlayInfo.videoListOrder;
    slv.a().a(localszj, new tgc(paramtgj));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, tgl paramtgl)
  {
    qqstory_service.ReqBatchGetVideoFullInfoList localReqBatchGetVideoFullInfoList = new qqstory_service.ReqBatchGetVideoFullInfoList();
    localReqBatchGetVideoFullInfoList.vid_list.add(ByteStringMicro.copyFromUtf8(paramString));
    localReqBatchGetVideoFullInfoList.source.set(1);
    long l = System.currentTimeMillis();
    paramString = new Bundle();
    paramString.putLong("key_for_start_time", l);
    mmj.a(paramQQAppInterface, paramtgl, localReqBatchGetVideoFullInfoList.toByteArray(), tan.jdField_a_of_type_JavaLangString, paramString);
  }
  
  protected static final void a(vni paramvni, String paramString1, StoryVideoItem paramStoryVideoItem, String paramString2, int paramInt, String paramString3)
  {
    try
    {
      tgi localtgi = new tgi(paramString2, paramStoryVideoItem, paramString3);
      paramvni.a(paramString2);
      paramvni.a(vnr.a(a(), paramStoryVideoItem.mVid, paramStoryVideoItem.mVideoWidth, paramStoryVideoItem.mVideoHeight, paramInt), paramString1, paramString2, paramStoryVideoItem.mVideoWidth, paramStoryVideoItem.mVideoHeight, localtgi);
      return;
    }
    catch (Exception paramvni)
    {
      paramString1 = new tgh(paramString3, 3, paramStoryVideoItem);
      sgi.a().dispatch(paramString1);
      QLog.e("Q.qqstory.player.PlayModeUtils", 2, paramvni.getMessage());
    }
  }
  
  public static boolean a(StoryVideoItem paramStoryVideoItem)
  {
    return (paramStoryVideoItem.isMine()) || (StoryVideoItem.isFakeVid(paramStoryVideoItem.mVid));
  }
  
  public static boolean a(StoryVideoItem paramStoryVideoItem, Context paramContext)
  {
    if (vms.b()) {
      return false;
    }
    urk.a("Q.qqstory.player.PlayModeUtils", "onClickRetryUploadBtn=%s", paramStoryVideoItem);
    urp.a("mystory", "clk_retry", 0, 0, new String[0]);
    if (sjc.a(paramStoryVideoItem.mUpLoadFailedError))
    {
      urk.d("Q.qqstory.player.PlayModeUtils", "video file not exist, vid:%s", new Object[] { paramStoryVideoItem.mVid });
      String str = paramStoryVideoItem.mVid;
      paramContext = babr.a(paramContext, 230);
      paramContext.setTitle(ajjy.a(2131642424));
      if (sjc.b(paramStoryVideoItem.mUpLoadFailedError)) {
        paramContext.setMessage(ajjy.a(2131642431));
      }
      for (;;)
      {
        paramContext.setPositiveButton(ajjy.a(2131642430), new tgb(paramStoryVideoItem, str));
        paramContext.setCancelable(false);
        paramContext.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        paramContext.show();
        return false;
        paramContext.setMessage(ajjy.a(2131642427));
      }
    }
    return sis.a(paramStoryVideoItem, paramContext);
  }
  
  public static final String b(QQUserUIItem paramQQUserUIItem)
  {
    return sky.b(paramQQUserUIItem);
  }
  
  public static String b(String paramString)
  {
    paramString = ((sqs)sqg.a(2)).b(paramString);
    if (paramString != null) {
      return paramString.headUrl;
    }
    return null;
  }
  
  protected static void b(ImageView paramImageView, String paramString1, int paramInt1, int paramInt2, boolean paramBoolean, DownloadParams.DecodeHandler paramDecodeHandler, Object paramObject, String paramString2)
  {
    a(paramImageView, paramString1, paramInt1, paramInt2, paramBoolean, bacm.b(), paramDecodeHandler, paramObject, paramString2);
  }
  
  public static void b(ImageView paramImageView, String paramString1, String paramString2, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    DownloadParams.DecodeHandler localDecodeHandler;
    if (paramBoolean)
    {
      localDecodeHandler = azue.a;
      if (!paramBoolean) {
        break label47;
      }
    }
    label47:
    for (String str = "StoryPlayModeRound";; str = null)
    {
      if (!apdh.a(paramString1)) {
        break label53;
      }
      b(paramImageView, paramString1, paramInt1, paramInt2, true, localDecodeHandler, null, str);
      return;
      localDecodeHandler = null;
      break;
    }
    label53:
    b(paramImageView, paramString2, paramInt1, paramInt2, false, localDecodeHandler, null, str);
  }
  
  public static void b(ImageView paramImageView, String paramString1, String paramString2, boolean paramBoolean, tgk paramtgk)
  {
    String str = null;
    boolean bool = apdh.a(paramString1);
    DownloadParams.DecodeHandler localDecodeHandler;
    int[] arrayOfInt;
    if (paramBoolean)
    {
      localDecodeHandler = azue.r;
      if (!paramBoolean) {
        break label69;
      }
      arrayOfInt = jdField_a_of_type_ArrayOfInt;
      label27:
      if (paramBoolean) {
        str = "rotate90";
      }
      if (!bool) {
        break label75;
      }
    }
    for (;;)
    {
      a(paramImageView, paramString1, awmc.jdField_a_of_type_Int, awmc.b, bool, localDecodeHandler, arrayOfInt, str, paramtgk);
      return;
      localDecodeHandler = null;
      break;
      label69:
      arrayOfInt = null;
      break label27;
      label75:
      paramString1 = paramString2;
    }
  }
  
  public static void b(ImageView paramImageView, String paramString, boolean paramBoolean, int paramInt)
  {
    b(paramImageView, null, paramString, paramBoolean, paramInt, paramInt);
  }
  
  public static void b(StoryVideoItem paramStoryVideoItem, int paramInt, String paramString)
  {
    if (TextUtils.isEmpty(paramStoryVideoItem.mLocalVideoPath))
    {
      paramStoryVideoItem = new tgh(paramString, 3, paramStoryVideoItem);
      sgi.a().dispatch(paramStoryVideoItem);
    }
    for (;;)
    {
      return;
      if (paramStoryVideoItem.mIsPicture == 1)
      {
        c(paramStoryVideoItem, paramInt, paramString);
        return;
      }
      long l1 = SystemClock.uptimeMillis();
      String str2 = a(paramStoryVideoItem.mVid, false);
      try
      {
        i = a(paramStoryVideoItem, paramInt, str2);
        if (i == 0)
        {
          paramString = new tgh(paramString, 2, paramStoryVideoItem);
          paramString.b = str2;
          sgi.a().dispatch(paramString);
          long l2 = paramStoryVideoItem.mVideoDuration;
          urp.a("play_video", "down_watermark_time", 1, 0, new String[] { String.valueOf(SystemClock.uptimeMillis() - l1), String.valueOf(l2) });
          urp.a("play_video", "down_watermark", 1, 0, new String[0]);
          urp.a("play_video", "down_suc", 1, 0, new String[] { "", "", "", paramStoryVideoItem.mVid });
          return;
        }
      }
      catch (IllegalStateException localIllegalStateException)
      {
        int i;
        for (;;)
        {
          QLog.e("Q.qqstory.player.PlayModeUtils", 1, "watermarkVideoByMediaCodec throw a exception, fallback to ffmpeg method...", new IllegalStateException("CatchedException, caused by: ", localIllegalStateException));
          i = -1;
        }
        QLog.e("Q.qqstory.player.PlayModeUtils", 1, "HardWare Encoder Watermark failed. ErroCode:" + i);
        Object localObject1 = sfm.k + paramStoryVideoItem.mVid + ".mp4";
        vni localvni = vni.a(a());
        if (localvni.a())
        {
          if (!localvni.a(str2))
          {
            paramStoryVideoItem = new tgh(paramString, 1, paramStoryVideoItem);
            sgi.a().dispatch(paramStoryVideoItem);
          }
        }
        else
        {
          if (vlm.c(str2))
          {
            paramStoryVideoItem = new tgh(paramString, 2, paramStoryVideoItem);
            paramStoryVideoItem.b = str2;
            sgi.a().dispatch(paramStoryVideoItem);
            return;
          }
          if (vlm.c((String)localObject1))
          {
            a(localvni, (String)localObject1, paramStoryVideoItem, str2, paramInt, paramString);
            return;
          }
          if ((paramStoryVideoItem.getVideoMaskType() == 0) && (!paramStoryVideoItem.isPollVideo()) && (!paramStoryVideoItem.isInteractVideo()))
          {
            a(localvni, paramStoryVideoItem.mLocalVideoPath, paramStoryVideoItem, str2, paramInt, paramString);
            return;
          }
          Object localObject3 = vnr.a(a(), paramStoryVideoItem.mVid, paramStoryVideoItem.mVideoWidth, paramStoryVideoItem.mVideoHeight, paramInt);
          if (TextUtils.isEmpty((CharSequence)localObject3)) {
            QLog.i("Q.qqstory.player.PlayModeUtils", 1, "get download water mark failed, logoMarkPath is null!");
          }
          Object localObject2 = vnr.b(paramStoryVideoItem);
          localObject1 = vnr.a(paramStoryVideoItem);
          String str1 = vnr.a(paramStoryVideoItem.getInteractLayout(), paramStoryVideoItem.mVideoWidth, paramStoryVideoItem.mVideoHeight);
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
          while ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty((CharSequence)localObject1)))
          {
            str1 = sfm.u;
            str1 = str1 + paramStoryVideoItem.mVid + System.currentTimeMillis() + "_max.png";
            if (!vnr.a((String)localObject2, (String)localObject1, str1))
            {
              paramStoryVideoItem = new tgh(paramString, 3, paramStoryVideoItem);
              sgi.a().dispatch(paramStoryVideoItem);
              QLog.e("Q.qqstory.player.PlayModeUtils", 2, "combineTwoImg maxMask videoVote failed");
              return;
              localObject1 = str1;
            }
            else
            {
              localObject1 = str1;
            }
          }
          while ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject3))) {
            if (!vnr.a((String)localObject1, (String)localObject3, (String)localObject3))
            {
              paramStoryVideoItem = new tgh(paramString, 3, paramStoryVideoItem);
              sgi.a().dispatch(paramStoryVideoItem);
              QLog.e("Q.qqstory.player.PlayModeUtils", 2, "combineTwoImg failed");
              return;
              if (!TextUtils.isEmpty((CharSequence)localObject2)) {
                localObject1 = localObject2;
              }
            }
            else
            {
              localObject2 = localObject3;
            }
          }
          for (;;)
          {
            try
            {
              localObject1 = new tgi(str2, paramStoryVideoItem, paramString);
              localvni.a(str2);
              paramInt = vnb.b(paramStoryVideoItem.mLocalVideoPath);
              if ((paramInt != 0) && (paramInt != -1)) {
                break;
              }
              localvni.a((String)localObject2, paramStoryVideoItem.mLocalVideoPath, str2, paramStoryVideoItem.mVideoWidth, paramStoryVideoItem.mVideoHeight, (vnq)localObject1);
              return;
            }
            catch (Exception localException)
            {
              paramStoryVideoItem = new tgh(paramString, 3, paramStoryVideoItem);
              sgi.a().dispatch(paramStoryVideoItem);
              QLog.e("Q.qqstory.player.PlayModeUtils", 2, localException.getMessage());
              return;
            }
            localObject2 = localException;
            if (TextUtils.isEmpty(localException)) {
              localObject2 = localObject3;
            }
          }
          localObject3 = new ArrayList();
          str1 = sfm.k + "hflip" + paramStoryVideoItem.mVid + ".mp4";
          if (!vlm.c(str1))
          {
            localObject4 = new vno();
            ((vno)localObject4).jdField_a_of_type_Int = 10;
            ((vno)localObject4).jdField_a_of_type_JavaUtilArrayList = new PlayModeUtils.3(paramStoryVideoItem, str1);
            ((vno)localObject4).jdField_a_of_type_Vnq = new voa(localException);
            ((ArrayList)localObject3).add(localObject4);
            localObject4 = new tgh(paramString, 0, paramStoryVideoItem);
            sgi.a().dispatch((Dispatcher.Dispatchable)localObject4);
          }
          Object localObject4 = new vno();
          ((vno)localObject4).jdField_a_of_type_Int = 1;
          ((vno)localObject4).jdField_a_of_type_JavaUtilArrayList = new PlayModeUtils.4((String)localObject2, str1, str2, paramStoryVideoItem);
          ((vno)localObject4).jdField_a_of_type_Vnq = localException;
          ((ArrayList)localObject3).add(localObject4);
          localvni.a((ArrayList)localObject3);
        }
      }
    }
  }
  
  public static boolean b(StoryVideoItem paramStoryVideoItem)
  {
    return paramStoryVideoItem.id == -1000L;
  }
  
  @TargetApi(10)
  public static void c(StoryVideoItem paramStoryVideoItem, int paramInt, String paramString)
  {
    tgh localtgh = new tgh(paramString, 0, paramStoryVideoItem);
    sgi.a().dispatch(localtgh);
    ThreadManager.post(new PlayModeUtils.5(paramStoryVideoItem, paramString, paramInt), 5, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tfy
 * JD-Core Version:    0.7.0.1
 */