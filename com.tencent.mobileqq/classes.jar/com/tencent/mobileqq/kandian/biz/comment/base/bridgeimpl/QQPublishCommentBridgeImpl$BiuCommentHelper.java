package com.tencent.mobileqq.kandian.biz.comment.base.bridgeimpl;

import android.text.Editable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.biu.AtFriendsSpan;
import com.tencent.mobileqq.kandian.biz.biu.BiuNicknameSpan;
import com.tencent.mobileqq.kandian.biz.comment.base.model.CommentArgumentModel;
import com.tencent.mobileqq.kandian.biz.ugc.Utils;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.handler.BiuCommentInfo;
import com.tencent.mobileqq.kandian.repo.handler.BiuInfo;
import com.tencent.mobileqq.service.message.EmotionCodecUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

class QQPublishCommentBridgeImpl$BiuCommentHelper
{
  private QQPublishCommentBridgeImpl$BiuCommentHelper(QQPublishCommentBridgeImpl paramQQPublishCommentBridgeImpl) {}
  
  private void a(String paramString1, String paramString2, @NotNull Editable paramEditable, @NotNull ArrayList<QQPublishCommentBridgeImpl.BiuCommentHelper.UserBiuInfo> paramArrayList, @NotNull BiuNicknameSpan[] paramArrayOfBiuNicknameSpan)
  {
    Object localObject = new ArrayList();
    ((ArrayList)localObject).addAll(Arrays.asList(paramArrayOfBiuNicknameSpan));
    Collections.sort((List)localObject, new QQPublishCommentBridgeImpl.BiuCommentHelper.BiuSpanComparator(this, paramEditable));
    Iterator localIterator = ((ArrayList)localObject).iterator();
    long l = 0L;
    int j = 0;
    int i = 0;
    String str;
    for (;;)
    {
      boolean bool = localIterator.hasNext();
      localObject = null;
      paramArrayOfBiuNicknameSpan = null;
      if (!bool) {
        break;
      }
      BiuNicknameSpan localBiuNicknameSpan = (BiuNicknameSpan)localIterator.next();
      int k = paramEditable.getSpanStart(localBiuNicknameSpan);
      try
      {
        localObject = paramEditable.subSequence(j, k).toString();
        paramArrayOfBiuNicknameSpan = (BiuNicknameSpan[])localObject;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      if (paramArrayOfBiuNicknameSpan != null)
      {
        str = Utils.a(paramArrayOfBiuNicknameSpan, paramString1).replaceAll("\n|\r\n", "");
        paramArrayOfBiuNicknameSpan = str;
        if (j == 0) {
          paramArrayOfBiuNicknameSpan = str.substring(str.indexOf(str.trim()));
        }
        paramArrayList.add(new QQPublishCommentBridgeImpl.BiuCommentHelper.UserBiuInfo(this, paramString2, l, EmotionCodecUtils.a(Utils.b(paramArrayOfBiuNicknameSpan, paramString1)), i));
      }
      if ((localBiuNicknameSpan instanceof AtFriendsSpan)) {
        i = 1;
      } else {
        i = 0;
      }
      j = paramEditable.getSpanEnd(localBiuNicknameSpan);
      paramString2 = localBiuNicknameSpan.jdField_a_of_type_JavaLangString;
      l = localBiuNicknameSpan.jdField_a_of_type_Long;
    }
    try
    {
      paramEditable = paramEditable.subSequence(j, paramEditable.length()).toString();
    }
    catch (Exception paramEditable)
    {
      paramEditable.printStackTrace();
      paramEditable = str;
    }
    if (paramEditable != null)
    {
      paramEditable = Utils.a(paramEditable, paramString1).replaceAll("\n|\r\n", "");
      paramArrayList.add(new QQPublishCommentBridgeImpl.BiuCommentHelper.UserBiuInfo(this, paramString2, l, EmotionCodecUtils.a(Utils.b(paramEditable.substring(0, paramEditable.indexOf(paramEditable.trim()) + paramEditable.trim().length()), paramString1)), i));
    }
  }
  
  private void a(@NotNull ArrayList<QQPublishCommentBridgeImpl.BiuCommentHelper.UserBiuInfo> paramArrayList)
  {
    if ((QQPublishCommentBridgeImpl.a(this.a).a != null) && (QQPublishCommentBridgeImpl.a(this.a).a.mSocialFeedInfo != null) && (QQPublishCommentBridgeImpl.a(this.a).a.mSocialFeedInfo.a != null) && (QQPublishCommentBridgeImpl.a(this.a).a.mSocialFeedInfo.a.jdField_a_of_type_JavaUtilList != null))
    {
      List localList = QQPublishCommentBridgeImpl.a(this.a).a.mSocialFeedInfo.a.jdField_a_of_type_JavaUtilList;
      int j = localList.size();
      int i = 0;
      while (i < j)
      {
        BiuCommentInfo localBiuCommentInfo = (BiuCommentInfo)localList.get(i);
        if (localBiuCommentInfo != null) {
          paramArrayList.add(new QQPublishCommentBridgeImpl.BiuCommentHelper.UserBiuInfo(this, String.valueOf(localBiuCommentInfo.mUin), localBiuCommentInfo.mFeedId.longValue(), localBiuCommentInfo.mBiuComment, localBiuCommentInfo.mOpType));
        }
        i += 1;
      }
    }
  }
  
  private boolean a(String paramString, @NotNull Editable paramEditable, @NotNull ArrayList<QQPublishCommentBridgeImpl.BiuCommentHelper.UserBiuInfo> paramArrayList)
  {
    boolean bool1;
    if ((!TextUtils.isEmpty(QQPublishCommentBridgeImpl.a(this.a).jdField_e_of_type_JavaLangString)) && (!TextUtils.isEmpty(QQPublishCommentBridgeImpl.a(this.a).jdField_f_of_type_JavaLangString)) && (QQPublishCommentBridgeImpl.a(this.a).a != null)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2;
    if ((RIJFeedsType.e(QQPublishCommentBridgeImpl.a(this.a).a)) && (QQPublishCommentBridgeImpl.a(this.a).d == 1)) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    String str1 = UUID.randomUUID().toString();
    String str2 = Utils.a(paramEditable.toString(), str1).trim();
    boolean bool3;
    if (TextUtils.isEmpty(str2))
    {
      paramArrayList.add(new QQPublishCommentBridgeImpl.BiuCommentHelper.UserBiuInfo(this, paramString, 0L, ""));
      bool3 = true;
    }
    else
    {
      bool3 = a(paramArrayList, paramString, paramEditable, str2, str1, bool1, bool2);
    }
    if (bool1)
    {
      paramString = QQPublishCommentBridgeImpl.a(this.a);
      paramEditable = new StringBuilder();
      paramEditable.append(": ");
      paramEditable.append(QQPublishCommentBridgeImpl.a(this.a).jdField_e_of_type_JavaLangString);
      paramString.jdField_e_of_type_JavaLangString = paramEditable.toString();
      paramArrayList.add(new QQPublishCommentBridgeImpl.BiuCommentHelper.UserBiuInfo(this, QQPublishCommentBridgeImpl.a(this.a).jdField_f_of_type_JavaLangString, QQPublishCommentBridgeImpl.a(this.a).a.mFeedId, QQPublishCommentBridgeImpl.a(this.a).jdField_e_of_type_JavaLangString, 0));
    }
    if (bool2) {
      a(paramArrayList);
    }
    return bool3;
  }
  
  private boolean a(@NotNull ArrayList<QQPublishCommentBridgeImpl.BiuCommentHelper.UserBiuInfo> paramArrayList, String paramString1, @NotNull Editable paramEditable, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2)
  {
    BiuNicknameSpan[] arrayOfBiuNicknameSpan = (BiuNicknameSpan[])paramEditable.getSpans(0, paramEditable.length(), BiuNicknameSpan.class);
    if ((arrayOfBiuNicknameSpan != null) && (arrayOfBiuNicknameSpan.length > 0))
    {
      a(paramString3, paramString1, paramEditable, paramArrayList, arrayOfBiuNicknameSpan);
      return false;
    }
    paramString2 = EmotionCodecUtils.a(Utils.b(paramString2.replaceAll("\n|\r\n", ""), paramString3));
    if (!paramBoolean1)
    {
      paramEditable = paramString2;
      if (!paramBoolean2) {}
    }
    else
    {
      paramEditable = new StringBuilder();
      paramEditable.append(paramString2);
      paramEditable.append("//");
      paramEditable = paramEditable.toString();
    }
    paramString2 = new StringBuilder();
    paramString2.append("：");
    paramString2.append(paramEditable);
    paramArrayList.add(new QQPublishCommentBridgeImpl.BiuCommentHelper.UserBiuInfo(this, paramString1, 0L, paramString2.toString()));
    return true;
  }
  
  JSONObject a(Editable paramEditable)
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      if ((QQPublishCommentBridgeImpl.a(this.a).a != null) && (QQPublishCommentBridgeImpl.a(this.a).a.mSocialFeedInfo != null) && (QQPublishCommentBridgeImpl.a(this.a).a.mSocialFeedInfo.a != null))
      {
        localJSONObject1.put("mOriFeedType", QQPublishCommentBridgeImpl.a(this.a).a.mSocialFeedInfo.a.b);
        localJSONObject1.put("mOriFeedId", QQPublishCommentBridgeImpl.a(this.a).a.mSocialFeedInfo.a.jdField_a_of_type_JavaLangLong);
      }
      localJSONObject1.put("biuSrc", QQPublishCommentBridgeImpl.a(this.a).jdField_e_of_type_Int);
      localJSONObject1.put("feedtype", QQPublishCommentBridgeImpl.a(this.a).jdField_f_of_type_Int);
      ArrayList localArrayList = new ArrayList();
      a(localArrayList, paramEditable);
      paramEditable = new JSONArray();
      int i = 0;
      while (i < localArrayList.size())
      {
        QQPublishCommentBridgeImpl.BiuCommentHelper.UserBiuInfo localUserBiuInfo = (QQPublishCommentBridgeImpl.BiuCommentHelper.UserBiuInfo)localArrayList.get(i);
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("biu_info_comment", localUserBiuInfo.b);
        localJSONObject2.put("biu_feedid", new Long(localUserBiuInfo.jdField_a_of_type_Long));
        localJSONObject2.put("biu_optype", localUserBiuInfo.jdField_a_of_type_Int);
        localJSONObject2.put("biu_uin", localUserBiuInfo.jdField_a_of_type_JavaLangString);
        localJSONObject2.put("biu_nickname", localUserBiuInfo.jdField_a_of_type_JavaLangCharSequence);
        paramEditable.put(localJSONObject2);
        i += 1;
      }
      localJSONObject1.put("biuinfo", paramEditable);
      return localJSONObject1;
    }
    catch (Exception paramEditable)
    {
      paramEditable.printStackTrace();
    }
    return null;
  }
  
  protected boolean a(ArrayList<QQPublishCommentBridgeImpl.BiuCommentHelper.UserBiuInfo> paramArrayList, Editable paramEditable)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface)) {
      localObject = ((QQAppInterface)localObject).getCurrentAccountUin();
    } else {
      localObject = "0";
    }
    if ((paramEditable != null) && (!TextUtils.isEmpty(paramEditable.toString()))) {
      return a((String)localObject, paramEditable, paramArrayList);
    }
    paramArrayList.add(new QQPublishCommentBridgeImpl.BiuCommentHelper.UserBiuInfo(this, (String)localObject, 0L, ""));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.base.bridgeimpl.QQPublishCommentBridgeImpl.BiuCommentHelper
 * JD-Core Version:    0.7.0.1
 */