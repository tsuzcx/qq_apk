package com.tencent.mobileqq.kandian.glue.utils;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.biz.pubaccount.util.api.IPublicAccountHttpDownloader;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.ReadInJoyDisplayUtils;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.pts.lite.PTSLiteDataParser;
import com.tencent.mobileqq.kandian.repo.common.RIJConvertString2URL;
import com.tencent.mobileqq.kandian.repo.common.RIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.common.constant.ReadInJoyConstants;
import com.tencent.mobileqq.kandian.repo.db.struct.BaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.dislike.DislikeInfo;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.PGCFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.PGCPicInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopicRecommendFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopicRecommendFeedsInfo.TopicRecommendInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UGCFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UGCPicInfo;
import com.tencent.mobileqq.kandian.repo.video.entity.UGCVideoInfo;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import tencent.im.oidb.gallery.galleryFeeds.GalleryFeedsInfo;

public class RIJPreParseData
{
  public static Pair<Integer, Integer> a(Pair<Integer, Integer>[] paramArrayOfPair, int paramInt1, int paramInt2)
  {
    int j = paramArrayOfPair.length;
    double d1 = paramInt2;
    Double.isNaN(d1);
    double d2 = paramInt1;
    Double.isNaN(d2);
    double d3 = d1 * 1.0D / d2;
    d2 = 1.7976931348623157E+308D;
    Object localObject2 = null;
    int i = 0;
    while (i < j)
    {
      d1 = ((Integer)paramArrayOfPair[i].second).intValue();
      Double.isNaN(d1);
      double d4 = ((Integer)paramArrayOfPair[i].first).intValue();
      Double.isNaN(d4);
      d4 = d1 * 1.0D / d4 - d3;
      double d5 = Math.abs(d4);
      Object localObject1;
      if (d5 < d2)
      {
        d1 = Math.abs(d4);
        localObject1 = paramArrayOfPair[i];
      }
      else
      {
        d1 = d2;
        localObject1 = localObject2;
        if (d5 == d2)
        {
          d1 = d2;
          localObject1 = localObject2;
          if (localObject2 != null)
          {
            d1 = d2;
            localObject1 = localObject2;
            if (Math.abs(((Integer)localObject2.second).intValue() - paramInt2) + Math.abs(((Integer)localObject2.first).intValue() - paramInt1) > Math.abs(((Integer)paramArrayOfPair[i].second).intValue() - paramInt2) + Math.abs(((Integer)paramArrayOfPair[i].first).intValue() - paramInt1))
            {
              d1 = Math.abs(d4);
              localObject1 = paramArrayOfPair[i];
            }
          }
        }
      }
      i += 1;
      d2 = d1;
      localObject2 = localObject1;
    }
    return localObject2;
  }
  
  public static String a(AbsBaseArticleInfo paramAbsBaseArticleInfo, String paramString)
  {
    if (paramAbsBaseArticleInfo == null) {
      return "";
    }
    Object localObject1;
    try
    {
      JSONObject localJSONObject = new JSONObject(paramAbsBaseArticleInfo.proteusItemsData);
      localObject2 = localJSONObject.optString("style_ID", "");
      localObject1 = localObject2;
      try
      {
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          break label112;
        }
        localObject1 = localJSONObject.optString("pts_page_name", "");
      }
      catch (JSONException localJSONException1)
      {
        localObject1 = localObject2;
      }
      localObject2 = new StringBuilder();
    }
    catch (JSONException localJSONException2)
    {
      localObject1 = "";
    }
    ((StringBuilder)localObject2).append("[getNewStyleName] e = ");
    ((StringBuilder)localObject2).append(localJSONException2);
    ((StringBuilder)localObject2).append(", articleInfo title = ");
    ((StringBuilder)localObject2).append(paramAbsBaseArticleInfo.mTitle);
    QLog.e("RIJPreParseData", 1, ((StringBuilder)localObject2).toString());
    label112:
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("[getNewStyleName] newStyleName = ");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(", articleInfo title = ");
    ((StringBuilder)localObject2).append(paramAbsBaseArticleInfo.mTitle);
    ((StringBuilder)localObject2).append(", rowKey = ");
    ((StringBuilder)localObject2).append(paramAbsBaseArticleInfo.innerUniqueID);
    QLog.i("RIJPreParseData", 1, ((StringBuilder)localObject2).toString());
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      return paramString;
    }
    return localObject1;
  }
  
  @Deprecated
  public static String a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!ReadInJoyHelper.b(RIJQQAppInterfaceUtil.a()))
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("smart crop switch is false ! url : ");
        ((StringBuilder)localObject1).append(paramString);
        QLog.d("RIJPreParseData", 2, ((StringBuilder)localObject1).toString());
      }
      return paramString;
    }
    Object localObject1 = a(ReadInJoyConstants.a(paramString, 0), paramInt2, paramInt1);
    if (localObject1 == null) {
      return paramString;
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("the picture size : w : ");
      ((StringBuilder)localObject2).append(paramInt2);
      ((StringBuilder)localObject2).append(" h : ");
      ((StringBuilder)localObject2).append(paramInt1);
      ((StringBuilder)localObject2).append(", select scale : ");
      ((StringBuilder)localObject2).append(((Pair)localObject1).first);
      ((StringBuilder)localObject2).append(":");
      ((StringBuilder)localObject2).append(((Pair)localObject1).second);
      ((StringBuilder)localObject2).append(" from : ");
      ((StringBuilder)localObject2).append(paramInt3);
      QLog.d("RIJPreParseData", 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject2 = paramString.split("/");
    localObject2 = localObject2[(localObject2.length - 1)];
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("_open/");
    ((StringBuilder)localObject3).append((String)localObject2);
    localObject3 = ((StringBuilder)localObject3).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("_open_");
    localStringBuilder.append(((Pair)localObject1).first);
    localStringBuilder.append("_");
    localStringBuilder.append(((Pair)localObject1).second);
    localStringBuilder.append("/");
    localStringBuilder.append((String)localObject2);
    return paramString.replace((CharSequence)localObject3, localStringBuilder.toString());
  }
  
  public static String a(String paramString, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    paramString = a(paramString);
    if ((paramString != null) && (paramString.length() > 0))
    {
      Object localObject2 = paramString.optJSONObject(0);
      if (localObject2 != null)
      {
        String str1 = ((JSONObject)localObject2).optString("vid");
        int k = ((JSONObject)localObject2).optInt("duration");
        String str2 = ((JSONObject)localObject2).optString("thirdIcon");
        String str3 = ((JSONObject)localObject2).optString("thirdName");
        String str4 = ((JSONObject)localObject2).optString("thirdAction");
        String str5 = ((JSONObject)localObject2).optString("innerUniqueID");
        paramString = "0";
        String str6 = ((JSONObject)localObject2).optString("width", "0");
        String str7 = ((JSONObject)localObject2).optString("height", "0");
        int j = ((JSONObject)localObject2).optInt("busiType");
        int i = j;
        if (j == 0) {
          i = 1;
        }
        Object localObject1 = "";
        String str8 = ((JSONObject)localObject2).optString("third_uin", "");
        String str9 = ((JSONObject)localObject2).optString("third_uin_name", "");
        boolean bool = RIJItemViewTypeUtils.x(paramAbsBaseArticleInfo);
        paramAbsBaseArticleInfo = "file_size";
        if (!bool) {
          paramString = String.valueOf(((JSONObject)localObject2).optLong("file_size"));
        }
        long l;
        try
        {
          localObject2 = ((JSONObject)localObject2).optJSONArray("video_info");
          if (localObject2 != null)
          {
            j = 0;
            try
            {
              while (j < ((JSONArray)localObject2).length())
              {
                JSONObject localJSONObject = ((JSONArray)localObject2).optJSONObject(j);
                if (localJSONObject != null)
                {
                  int m = localJSONObject.optInt("network_type");
                  l = localJSONObject.optLong(paramAbsBaseArticleInfo);
                  if (m == 2)
                  {
                    paramAbsBaseArticleInfo = String.valueOf(l);
                    try
                    {
                      localObject2 = localJSONObject.optString("url", "");
                      localObject1 = localObject2;
                      l = localJSONObject.optLong("url_expire_time");
                      paramString = paramAbsBaseArticleInfo;
                      localObject1 = localObject2;
                    }
                    catch (Exception localException)
                    {
                      paramString = paramAbsBaseArticleInfo;
                      break label302;
                    }
                  }
                }
                j += 1;
              }
              l = 0L;
            }
            catch (Exception paramAbsBaseArticleInfo) {}
          }
        }
        catch (Exception paramAbsBaseArticleInfo)
        {
          AbsBaseArticleInfo localAbsBaseArticleInfo = paramAbsBaseArticleInfo;
          label302:
          localAbsBaseArticleInfo.printStackTrace();
          l = 0L;
        }
        paramAbsBaseArticleInfo = new StringBuilder();
        paramAbsBaseArticleInfo.append(str1);
        paramAbsBaseArticleInfo.append(";");
        paramAbsBaseArticleInfo.append(k);
        paramAbsBaseArticleInfo.append(";");
        paramAbsBaseArticleInfo.append(str2);
        paramAbsBaseArticleInfo.append(";");
        paramAbsBaseArticleInfo.append(str3);
        paramAbsBaseArticleInfo.append(";");
        paramAbsBaseArticleInfo.append(str4);
        paramAbsBaseArticleInfo.append(";");
        paramAbsBaseArticleInfo.append(str5);
        paramAbsBaseArticleInfo.append(";");
        paramAbsBaseArticleInfo.append(i);
        paramAbsBaseArticleInfo.append(";");
        paramAbsBaseArticleInfo.append(str6);
        paramAbsBaseArticleInfo.append(";");
        paramAbsBaseArticleInfo.append(str7);
        paramAbsBaseArticleInfo.append(";");
        paramAbsBaseArticleInfo.append(str8);
        paramAbsBaseArticleInfo.append(";");
        paramAbsBaseArticleInfo.append(str9);
        paramAbsBaseArticleInfo.append(";");
        paramAbsBaseArticleInfo.append(paramString);
        paramAbsBaseArticleInfo.append(";");
        paramAbsBaseArticleInfo.append((String)localObject1);
        paramAbsBaseArticleInfo.append(";");
        paramAbsBaseArticleInfo.append(l);
        return paramAbsBaseArticleInfo.toString();
      }
    }
    return null;
  }
  
  public static URL a(AbsBaseArticleInfo paramAbsBaseArticleInfo, String paramString)
  {
    paramAbsBaseArticleInfo = a(paramString);
    if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.length() > 0))
    {
      paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.optJSONObject(0);
      if (paramAbsBaseArticleInfo != null) {
        try
        {
          paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.optString("picture");
          paramAbsBaseArticleInfo = ((IPublicAccountHttpDownloader)QRoute.api(IPublicAccountHttpDownloader.class)).makeURL(paramAbsBaseArticleInfo, 3);
          return paramAbsBaseArticleInfo;
        }
        catch (Exception paramAbsBaseArticleInfo)
        {
          QLog.e("RIJPreParseData", 1, new Object[] { "getReadinjoyVideoConvelFromJson", QLog.getStackTraceString(paramAbsBaseArticleInfo) });
        }
      }
    }
    return null;
  }
  
  public static URL a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject = paramString;
    if (a(paramString))
    {
      if (paramBoolean1) {
        localObject = ReadInJoyDisplayUtils.e();
      } else {
        localObject = ReadInJoyDisplayUtils.a();
      }
      localObject = a(paramString, ((Integer)((Pair)localObject).second).intValue(), ((Integer)((Pair)localObject).first).intValue(), 3);
    }
    return RIJConvertString2URL.a((String)localObject);
  }
  
  private static JSONArray a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = (JSONObject)new JSONTokener(paramString).nextValue();
      if (paramString != null)
      {
        if (TextUtils.isEmpty(paramString.toString())) {
          return null;
        }
        paramString = paramString.optJSONArray("videos");
        if (paramString != null)
        {
          int i = paramString.length();
          if (i >= 1) {
            return paramString;
          }
        }
      }
      return null;
    }
    catch (Exception paramString)
    {
      QLog.e("RIJPreParseData", 1, new Object[] { "getVideoJsonArray", QLog.getStackTraceString(paramString) });
    }
    return null;
  }
  
  private static JSONObject a(String paramString)
  {
    paramString = a(paramString);
    if ((paramString != null) && (paramString.length() > 0)) {
      return paramString.optJSONObject(0);
    }
    return null;
  }
  
  public static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.a != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.a.size() > 0))
    {
      paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.a.iterator();
      while (paramAbsBaseArticleInfo.hasNext())
      {
        UGCPicInfo localUGCPicInfo = (UGCPicInfo)paramAbsBaseArticleInfo.next();
        if (localUGCPicInfo != null)
        {
          localUGCPicInfo.b = RIJConvertString2URL.a(localUGCPicInfo.b);
          localUGCPicInfo.c = RIJConvertString2URL.a(localUGCPicInfo.c);
        }
      }
    }
  }
  
  public static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, String paramString)
  {
    paramString = a(paramString);
    if (paramString == null) {
      return;
    }
    paramAbsBaseArticleInfo.setFirstFrameUrl(RIJConvertString2URL.a(paramString.optString("first_frame")));
  }
  
  private static void a(String paramString, JSONObject paramJSONObject, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ("mini_program_name".equals(paramString)) {
      paramAbsBaseArticleInfo.miniProgramName = paramJSONObject.optString("mini_program_name");
    }
    if ("movie_name".equals(paramString)) {
      paramAbsBaseArticleInfo.miniAppMovieName = paramJSONObject.optString("movie_name");
    }
    if ("exRowkey".equals(paramString)) {
      paramAbsBaseArticleInfo.miniRowKey = paramJSONObject.optString("exRowkey");
    }
  }
  
  @Deprecated
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    paramString = paramString.split("/");
    if (paramString.length < 2) {
      return false;
    }
    paramString = paramString[(paramString.length - 2)].split("_");
    if (paramString.length < 1) {
      return false;
    }
    return "open".equals(paramString[(paramString.length - 1)]);
  }
  
  public static URL[] a(String paramString, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    for (;;)
    {
      try
      {
        paramString = (JSONObject)new JSONTokener(paramString).nextValue();
        if (paramString != null)
        {
          if (paramString.length() <= 0) {
            return null;
          }
          JSONArray localJSONArray = paramString.optJSONArray("pictures");
          if ((localJSONArray != null) && (localJSONArray.length() > 0))
          {
            URL[] arrayOfURL = new URL[localJSONArray.length()];
            Object localObject = ReadInJoyDisplayUtils.a();
            paramString = (String)localObject;
            if (!RIJFeedsType.T(paramAbsBaseArticleInfo)) {
              break label253;
            }
            i = paramAbsBaseArticleInfo.mGalleryFeedsInfo.enum_article_style.get();
            if (i == 2)
            {
              paramString = ReadInJoyDisplayUtils.b();
              break label253;
            }
            if (i == 3)
            {
              paramString = ReadInJoyDisplayUtils.d();
              break label253;
            }
            paramString = (String)localObject;
            if (i != 1) {
              break label253;
            }
            paramString = ReadInJoyDisplayUtils.c();
            break label253;
            if (i < localJSONArray.length())
            {
              localObject = localJSONArray.optJSONObject(i).optString("picture");
              if (!TextUtils.isEmpty((CharSequence)localObject))
              {
                paramAbsBaseArticleInfo = (AbsBaseArticleInfo)localObject;
                if (a((String)localObject)) {
                  paramAbsBaseArticleInfo = a((String)localObject, ((Integer)paramString.second).intValue(), ((Integer)paramString.first).intValue(), 1);
                }
                arrayOfURL[i] = ((IPublicAccountHttpDownloader)QRoute.api(IPublicAccountHttpDownloader.class)).makeURL(paramAbsBaseArticleInfo, 3);
              }
              i += 1;
              continue;
            }
            return arrayOfURL;
          }
        }
        return null;
      }
      catch (Exception paramString)
      {
        QLog.e("RIJPreParseData", 1, new Object[] { "getReadinjoyFeedsPicturesFromJson", QLog.getStackTraceString(paramString) });
        return null;
      }
      label253:
      int i = 0;
    }
  }
  
  public static URL b(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject = paramString;
    if (a(paramString))
    {
      localObject = ReadInJoyDisplayUtils.c();
      localObject = a(paramString, ((Integer)((Pair)localObject).second).intValue(), ((Integer)((Pair)localObject).first).intValue(), 3);
    }
    return RIJConvertString2URL.a((String)localObject);
  }
  
  public static void b(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    for (;;)
    {
      try
      {
        if ((paramAbsBaseArticleInfo.mDislikeInfos == null) || (paramAbsBaseArticleInfo.mDislikeInfos.size() <= 0)) {
          paramAbsBaseArticleInfo.mDislikeInfos = DislikeInfo.a(paramAbsBaseArticleInfo.mDiskLikeInfoString);
        }
        paramAbsBaseArticleInfo.mPictures = a(paramAbsBaseArticleInfo.mJsonPictureList, paramAbsBaseArticleInfo);
        Object localObject;
        if ((RIJItemViewTypeUtils.s(paramAbsBaseArticleInfo)) && (!RIJItemViewTypeUtils.z(paramAbsBaseArticleInfo)))
        {
          paramAbsBaseArticleInfo.mSinglePicture = a(((TopicRecommendFeedsInfo.TopicRecommendInfo)paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityTopicRecommendFeedsInfo.a.get(0)).d, true, true);
        }
        else if (((paramAbsBaseArticleInfo instanceof BaseArticleInfo)) && ((RIJItemViewTypeUtils.a(paramAbsBaseArticleInfo)) || (RIJItemViewTypeUtils.e(paramAbsBaseArticleInfo))))
        {
          paramAbsBaseArticleInfo.mSinglePicture = a(paramAbsBaseArticleInfo.mFirstPagePicUrl, RIJItemViewTypeUtils.f(paramAbsBaseArticleInfo), true);
          a(paramAbsBaseArticleInfo);
          d(paramAbsBaseArticleInfo);
        }
        else if ((RIJFeedsType.T(paramAbsBaseArticleInfo)) && (paramAbsBaseArticleInfo.mGalleryFeedsInfo.enum_article_style.get() == 1))
        {
          paramAbsBaseArticleInfo.mSinglePicture = b(paramAbsBaseArticleInfo.mFirstPagePicUrl, RIJItemViewTypeUtils.f(paramAbsBaseArticleInfo), true);
        }
        else
        {
          localObject = paramAbsBaseArticleInfo.mFirstPagePicUrl;
          boolean bool2 = paramAbsBaseArticleInfo.mShowBigPicture;
          if (paramAbsBaseArticleInfo.mVideoType != 0) {
            break label671;
          }
          bool1 = true;
          paramAbsBaseArticleInfo.mSinglePicture = a((String)localObject, bool2, bool1);
        }
        if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.mFirstPagePicUrl)) {
          paramAbsBaseArticleInfo.mFirstPagePicUrl = RIJConvertString2URL.a(paramAbsBaseArticleInfo.mFirstPagePicUrl);
        }
        if (paramAbsBaseArticleInfo.mVideoCoverUrl != null) {
          paramAbsBaseArticleInfo.mVideoCoverUrl = ((IPublicAccountHttpDownloader)QRoute.api(IPublicAccountHttpDownloader.class)).makeURL(paramAbsBaseArticleInfo.mVideoCoverUrl.toString(), 3);
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("preParseArticleJsonParam mJsonVideoList = ");
          ((StringBuilder)localObject).append(paramAbsBaseArticleInfo.mJsonVideoList);
          QLog.d("RIJPreParseData", 2, ((StringBuilder)localObject).toString());
        }
        if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.mJsonVideoList))
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("preParseArticleJsonParam article.mArticleID:");
            ((StringBuilder)localObject).append(paramAbsBaseArticleInfo.mArticleID);
            ((StringBuilder)localObject).append(" article.mTitle:");
            ((StringBuilder)localObject).append(paramAbsBaseArticleInfo.mTitle);
            ((StringBuilder)localObject).append(" article.mSummary:");
            ((StringBuilder)localObject).append(paramAbsBaseArticleInfo.mSummary);
            ((StringBuilder)localObject).append("mJsonVideoList:");
            ((StringBuilder)localObject).append(paramAbsBaseArticleInfo.mJsonVideoList);
            QLog.d("RIJPreParseData", 2, ((StringBuilder)localObject).toString());
          }
          paramAbsBaseArticleInfo.mVideoCoverUrl = a(paramAbsBaseArticleInfo, paramAbsBaseArticleInfo.mJsonVideoList);
          localObject = a(paramAbsBaseArticleInfo.mJsonVideoList, paramAbsBaseArticleInfo);
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            localObject = ((String)localObject).split(";");
            paramAbsBaseArticleInfo.mVideoVid = localObject[0];
            paramAbsBaseArticleInfo.mVideoDuration = Integer.valueOf(localObject[1]).intValue();
            paramAbsBaseArticleInfo.thirdIcon = localObject[2];
            paramAbsBaseArticleInfo.thirdName = localObject[3];
            paramAbsBaseArticleInfo.thirdAction = localObject[4];
            if ((paramAbsBaseArticleInfo.mFeedType != 3) && (TextUtils.isEmpty(paramAbsBaseArticleInfo.innerUniqueID))) {
              paramAbsBaseArticleInfo.innerUniqueID = localObject[5];
            }
            paramAbsBaseArticleInfo.busiType = Integer.valueOf(localObject[6]).intValue();
            paramAbsBaseArticleInfo.mVideoJsonWidth = Integer.valueOf(localObject[7]).intValue();
            paramAbsBaseArticleInfo.mVideoJsonHeight = Integer.valueOf(localObject[8]).intValue();
            paramAbsBaseArticleInfo.thirdUin = localObject[9];
            paramAbsBaseArticleInfo.thirdUinName = localObject[10];
            paramAbsBaseArticleInfo.mXGFileSize = Long.valueOf(localObject[11]).longValue();
            paramAbsBaseArticleInfo.mThirdVideoURL = localObject[12];
            paramAbsBaseArticleInfo.mThirdVideoURLExpireTime = Long.valueOf(localObject[13]).longValue();
          }
          a(paramAbsBaseArticleInfo, paramAbsBaseArticleInfo.mJsonVideoList);
          return;
        }
        if (((paramAbsBaseArticleInfo instanceof BaseArticleInfo)) && (!RIJItemViewTypeUtils.x(paramAbsBaseArticleInfo)))
        {
          paramAbsBaseArticleInfo.busiType = ((UGCVideoInfo)paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.b.get(0)).f;
          return;
        }
      }
      catch (Exception paramAbsBaseArticleInfo)
      {
        QLog.e("RIJPreParseData", 1, new Object[] { "preParseArticleJsonParam", QLog.getStackTraceString(paramAbsBaseArticleInfo) });
      }
      return;
      label671:
      boolean bool1 = false;
    }
  }
  
  public static void c(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo == null) {
      return;
    }
    PTSLiteDataParser.a(paramAbsBaseArticleInfo);
    try
    {
      JSONObject localJSONObject = new JSONObject(paramAbsBaseArticleInfo.proteusItemsData);
      QLog.d("RIJPreParseData", 2, new Object[] { "mArticleInfo.proteusItemsData = ", paramAbsBaseArticleInfo.proteusItemsData });
      Iterator localIterator = localJSONObject.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if ("id_super_topic".equals(str))
        {
          paramAbsBaseArticleInfo.isSuperTopic = true;
          return;
        }
        a(str, localJSONObject, paramAbsBaseArticleInfo);
      }
      return;
    }
    catch (JSONException paramAbsBaseArticleInfo)
    {
      QLog.d("RIJPreParseData", 2, new Object[] { "preParseProteusItemData", QLog.getStackTraceString(paramAbsBaseArticleInfo) });
    }
  }
  
  private static void d(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPGCFeedsInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPGCFeedsInfo.a != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPGCFeedsInfo.a.size() > 0))
    {
      paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPGCFeedsInfo.a.iterator();
      while (paramAbsBaseArticleInfo.hasNext())
      {
        PGCPicInfo localPGCPicInfo = (PGCPicInfo)paramAbsBaseArticleInfo.next();
        if (localPGCPicInfo != null)
        {
          localPGCPicInfo.b = RIJConvertString2URL.a(localPGCPicInfo.b);
          localPGCPicInfo.c = RIJConvertString2URL.a(localPGCPicInfo.c);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.utils.RIJPreParseData
 * JD-Core Version:    0.7.0.1
 */