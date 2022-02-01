package com.tencent.mobileqq.kandian.biz.video;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.util.PAVideoStructMsgUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.repo.common.RIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoyUserInfoModule;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/video/VideoStructMsgHelper;", "", "()V", "ARK_APP_VER", "", "ARK_BASE_VIEW", "ARK_PACKAGE_NAME", "IS_JUMP_NATIVE", "", "TAG", "URL_TO_KD_FEEDS", "convertVideoShareStructMsgJsonToBundle", "Landroid/os/Bundle;", "jsonObject", "Lorg/json/JSONObject;", "getAvatarJumpUrlByBaseArticleInfo", "videoInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "getAvatarUrlByVideo", "getMediaJsonByVideo", "Lorg/json/JSONArray;", "getShareUrl", "getShareUrlByBaseArticleInfo", "getVideoMeta", "fromPts", "", "getVideoShareStructMsgForArk", "getVideoShareStructMsgForArkToJson", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class VideoStructMsgHelper
{
  public static final VideoStructMsgHelper a = new VideoStructMsgHelper();
  
  private final String a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    String str = (String)null;
    if (!TextUtils.isEmpty((CharSequence)paramAbsBaseArticleInfo.thirdIcon)) {
      return paramAbsBaseArticleInfo.thirdIcon;
    }
    if (!TextUtils.isEmpty((CharSequence)paramAbsBaseArticleInfo.mSubscribeID))
    {
      paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.mSubscribeID;
      Intrinsics.checkExpressionValueIsNotNull(paramAbsBaseArticleInfo, "videoInfo.mSubscribeID");
      str = ReadInJoyUserInfoModule.a(ReadInJoyUserInfoModule.a(Long.parseLong(paramAbsBaseArticleInfo), null));
    }
    return str;
  }
  
  private final String a(AbsBaseArticleInfo paramAbsBaseArticleInfo, boolean paramBoolean)
  {
    JSONObject localJSONObject1 = new JSONObject();
    for (;;)
    {
      try
      {
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject1.put("data", localJSONObject2);
        localJSONObject2.put("id", "none");
        localJSONObject2.put("rowkey", paramAbsBaseArticleInfo.rawkey);
        localJSONObject2.put("uin", RIJQQAppInterfaceUtil.a());
        localJSONObject2.put("puin", paramAbsBaseArticleInfo.mSubscribeID);
        if (paramBoolean)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("@{uin:");
          ((StringBuilder)localObject).append(paramAbsBaseArticleInfo.mSubscribeID);
          ((StringBuilder)localObject).append(",nick:");
          ((StringBuilder)localObject).append(paramAbsBaseArticleInfo.thirdName);
          ((StringBuilder)localObject).append('}');
          localJSONObject2.put("nick", ((StringBuilder)localObject).toString());
          if (RIJItemViewTypeUtils.B(paramAbsBaseArticleInfo))
          {
            localJSONObject2.put("contentJumpUrl", paramAbsBaseArticleInfo.mOriginalUrl);
          }
          else
          {
            localObject = paramAbsBaseArticleInfo.getShareUrl();
            if (localObject == null) {
              break label403;
            }
            localJSONObject2.put("contentJumpUrl", localObject);
          }
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("@{uin:");
          ((StringBuilder)localObject).append(paramAbsBaseArticleInfo.mSubscribeID);
          ((StringBuilder)localObject).append(",nick:");
          ((StringBuilder)localObject).append(paramAbsBaseArticleInfo.mSubscribeName);
          ((StringBuilder)localObject).append('}');
          localJSONObject2.put("nick", ((StringBuilder)localObject).toString());
          localJSONObject2.put("contentJumpUrl", c(paramAbsBaseArticleInfo));
        }
        localJSONObject2.put("avatar", a(paramAbsBaseArticleInfo));
        localJSONObject2.put("avatarJumpUrl", b(paramAbsBaseArticleInfo));
        localJSONObject2.put("iconJumpUrl", "mqqapi://readinjoy/open?src_type=internal&target=1&version=1");
        localJSONObject2.put("media", a(paramAbsBaseArticleInfo));
        localJSONObject2.put("title", paramAbsBaseArticleInfo.mTitle);
        localJSONObject2.put("type", 2);
        localJSONObject2.put("isAIO", 1);
        localJSONObject2.put("appName", "kandian");
      }
      catch (JSONException paramAbsBaseArticleInfo)
      {
        QLog.e("VideoStructMsgHelper", 1, "getVideoMeta error", (Throwable)paramAbsBaseArticleInfo);
      }
      if (QLog.isColorLevel())
      {
        paramAbsBaseArticleInfo = new StringBuilder();
        paramAbsBaseArticleInfo.append("getVideoMeta JSON:");
        paramAbsBaseArticleInfo.append(localJSONObject1);
        QLog.d("VideoStructMsgHelper", 2, paramAbsBaseArticleInfo.toString());
      }
      return localJSONObject1.toString();
      label403:
      Object localObject = "";
    }
  }
  
  private final JSONArray a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    JSONArray localJSONArray = new JSONArray();
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("isVideo", true);
      localJSONObject.put("videoDuration", paramAbsBaseArticleInfo.getVideoDuration());
      localJSONObject.put("width", paramAbsBaseArticleInfo.getVideoWidth());
      localJSONObject.put("height", paramAbsBaseArticleInfo.getVideoHeight());
      localJSONObject.put("url", FeedsChannelDataHelper.a(paramAbsBaseArticleInfo.getVideoCoverURL()));
      localJSONArray.put(localJSONObject);
      return localJSONArray;
    }
    catch (JSONException paramAbsBaseArticleInfo)
    {
      QLog.e("VideoStructMsgHelper", 1, "getMediaJsonByVideo error", (Throwable)paramAbsBaseArticleInfo);
    }
    return localJSONArray;
  }
  
  private final String b(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    String str1 = paramAbsBaseArticleInfo.mSubscribeID;
    String str2 = PAVideoStructMsgUtil.a(str1, true);
    if ((paramAbsBaseArticleInfo.busiType > 1) && ((TextUtils.isEmpty((CharSequence)str1)) || (Intrinsics.areEqual(str1, "16888")))) {
      return paramAbsBaseArticleInfo.thirdAction;
    }
    return str2;
  }
  
  private final String c(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return d(paramAbsBaseArticleInfo);
  }
  
  private final String d(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Object localObject;
    if (paramAbsBaseArticleInfo.aioShareUrl != null)
    {
      localObject = paramAbsBaseArticleInfo.aioShareUrl;
      Intrinsics.checkExpressionValueIsNotNull(localObject, "videoInfo.aioShareUrl");
      if (StringsKt.contains$default((CharSequence)localObject, (CharSequence)"kandianshare.html5.qq.com", false, 2, null)) {
        return paramAbsBaseArticleInfo.aioShareUrl;
      }
    }
    if (paramAbsBaseArticleInfo.mArticleContentUrl != null)
    {
      localObject = paramAbsBaseArticleInfo.mArticleContentUrl;
      Intrinsics.checkExpressionValueIsNotNull(localObject, "videoInfo.mArticleContentUrl");
      if (!StringsKt.contains$default((CharSequence)localObject, (CharSequence)"&sourcefrom=0", false, 2, null))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramAbsBaseArticleInfo.mArticleContentUrl);
        ((StringBuilder)localObject).append("&sourcefrom=0");
        paramAbsBaseArticleInfo.mArticleContentUrl = ((StringBuilder)localObject).toString();
      }
    }
    return paramAbsBaseArticleInfo.mArticleContentUrl;
  }
  
  @NotNull
  public final Bundle a(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Bundle localBundle = new Bundle();
    if (paramAbsBaseArticleInfo != null)
    {
      localBundle.putInt("forward_type", 27);
      localBundle.putString("forward_ark_app_name", "com.tencent.biz.pubaccount.readinjoy");
      localBundle.putString("forward_ark_app_view", "baseView");
      localBundle.putString("forward_ark_app_ver", Aladdin.getConfig(415).getString("ark_app_ver", "1.0.0.66"));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[视频]");
      localStringBuilder.append(paramAbsBaseArticleInfo.mTitle);
      localBundle.putString("forward_ark_app_prompt", localStringBuilder.toString());
      localBundle.putString("forward_ark_app_meta", a.a(paramAbsBaseArticleInfo, false));
    }
    if (QLog.isColorLevel())
    {
      paramAbsBaseArticleInfo = new StringBuilder();
      paramAbsBaseArticleInfo.append("FORWARD_ARK_APP_VER: ");
      paramAbsBaseArticleInfo.append(localBundle.getString("forward_ark_app_ver"));
      QLog.d("VideoStructMsgHelper", 2, paramAbsBaseArticleInfo.toString());
    }
    return localBundle;
  }
  
  @NotNull
  public final Bundle a(@Nullable JSONObject paramJSONObject)
  {
    Bundle localBundle = new Bundle();
    if (paramJSONObject != null)
    {
      localBundle.putInt("forward_type", paramJSONObject.optInt("forward_type"));
      localBundle.putString("forward_ark_app_name", paramJSONObject.optString("forward_ark_app_name"));
      localBundle.putString("forward_ark_app_view", paramJSONObject.optString("forward_ark_app_view"));
      localBundle.putString("forward_ark_app_ver", paramJSONObject.optString("forward_ark_app_ver"));
      localBundle.putString("forward_ark_app_prompt", paramJSONObject.optString("forward_ark_app_prompt"));
      localBundle.putString("forward_ark_app_meta", paramJSONObject.optString("forward_ark_app_meta"));
    }
    if (QLog.isColorLevel())
    {
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("FORWARD_ARK_APP_VER: ");
      paramJSONObject.append(localBundle.getString("forward_ark_app_ver", ""));
      QLog.d("VideoStructMsgHelper", 2, paramJSONObject.toString());
    }
    return localBundle;
  }
  
  @NotNull
  public final JSONObject a(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramAbsBaseArticleInfo != null)
    {
      localJSONObject.put("forward_type", 27);
      localJSONObject.put("forward_ark_app_name", "com.tencent.biz.pubaccount.readinjoy");
      localJSONObject.put("forward_ark_app_view", "baseView");
      localJSONObject.put("forward_ark_app_ver", Aladdin.getConfig(415).getString("ark_app_ver", "1.0.0.66"));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[视频]");
      localStringBuilder.append(paramAbsBaseArticleInfo.mTitle);
      localJSONObject.put("forward_ark_app_prompt", localStringBuilder.toString());
      localJSONObject.put("forward_ark_app_meta", a.a(paramAbsBaseArticleInfo, true));
    }
    if (QLog.isColorLevel())
    {
      paramAbsBaseArticleInfo = new StringBuilder();
      paramAbsBaseArticleInfo.append("FORWARD_ARK_APP_VER: ");
      paramAbsBaseArticleInfo.append(localJSONObject.optString("forward_ark_app_ver"));
      QLog.d("VideoStructMsgHelper", 2, paramAbsBaseArticleInfo.toString());
    }
    return localJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.VideoStructMsgHelper
 * JD-Core Version:    0.7.0.1
 */