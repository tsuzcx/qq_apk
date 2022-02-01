package com.tencent.mobileqq.kandian.biz.comment.base.model;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.comment.data.ReadInJoyCommentDataManager;
import com.tencent.mobileqq.kandian.biz.comment.entity.SimpleCommentData;
import com.tencent.mobileqq.kandian.biz.comment.entity.SubCommentCreateData;
import com.tencent.mobileqq.kandian.biz.comment.entity.SubCommentData;
import com.tencent.mobileqq.kandian.biz.comment.helper.DraftDataUtil;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.service.message.EmotionCodecUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tkd.comment.publisher.qq.model.TkdQQArgument;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

public class CommentArgumentModel
{
  public boolean a;
  public int b;
  public TkdQQArgument c;
  public IPublishScene d;
  public String e;
  public int f;
  private final Intent g;
  private int h = 140;
  private boolean i;
  private boolean j;
  
  public CommentArgumentModel(Intent paramIntent)
  {
    this.g = paramIntent;
    int k = paramIntent.getIntExtra("comment_editor_scene", 0);
    if (k != 0)
    {
      if (k != 1)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("no action for scene ");
        localStringBuilder.append(k);
        ReadInJoyHelper.a("CommentArgumentModel", new IllegalStateException(localStringBuilder.toString()));
      }
      else
      {
        this.d = new PublishMessageBoardScene();
      }
    }
    else {
      this.d = new PublishCommentScene();
    }
    this.d.a(this, paramIntent);
    e();
    a();
  }
  
  private static String a(AbsBaseArticleInfo paramAbsBaseArticleInfo, SimpleCommentData paramSimpleCommentData)
  {
    if (paramAbsBaseArticleInfo != null) {
      return paramAbsBaseArticleInfo.innerUniqueID;
    }
    if (paramSimpleCommentData != null) {
      return paramSimpleCommentData.d();
    }
    return "";
  }
  
  private static String a(AbsBaseArticleInfo paramAbsBaseArticleInfo, String paramString)
  {
    paramAbsBaseArticleInfo = ReadInJoyCommentDataManager.a(paramAbsBaseArticleInfo);
    if (paramAbsBaseArticleInfo != null)
    {
      paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.g(paramString);
      if ((paramAbsBaseArticleInfo instanceof SubCommentData)) {
        return ((SubCommentData)paramAbsBaseArticleInfo).parentCommentId;
      }
    }
    return "";
  }
  
  public static String a(AbsBaseArticleInfo paramAbsBaseArticleInfo, String paramString, SimpleCommentData paramSimpleCommentData)
  {
    String str = a(paramAbsBaseArticleInfo, paramSimpleCommentData);
    if ((paramSimpleCommentData instanceof SubCommentCreateData))
    {
      paramAbsBaseArticleInfo = (SubCommentCreateData)paramSimpleCommentData;
      paramString = paramAbsBaseArticleInfo.a();
      paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.m();
    }
    else if (!TextUtils.isEmpty(paramString))
    {
      paramSimpleCommentData = a(paramAbsBaseArticleInfo, paramString);
      if (TextUtils.isEmpty(paramSimpleCommentData))
      {
        paramAbsBaseArticleInfo = "";
      }
      else
      {
        paramAbsBaseArticleInfo = paramString;
        paramString = paramSimpleCommentData;
      }
    }
    else
    {
      paramAbsBaseArticleInfo = "";
      paramString = paramAbsBaseArticleInfo;
    }
    try
    {
      paramSimpleCommentData = new JSONObject();
      a(paramSimpleCommentData, "innerUniqueID", str);
      a(paramSimpleCommentData, "firstCommentId", paramString);
      a(paramSimpleCommentData, "secondCommentId", paramAbsBaseArticleInfo);
      if (paramSimpleCommentData.length() > 0)
      {
        paramAbsBaseArticleInfo = paramSimpleCommentData.toString();
        return paramAbsBaseArticleInfo;
      }
    }
    catch (JSONException paramAbsBaseArticleInfo)
    {
      QLog.w("CommentArgumentModel", 4, paramAbsBaseArticleInfo.getMessage(), paramAbsBaseArticleInfo);
    }
    return "";
  }
  
  private void a()
  {
    this.c = new TkdQQArgument();
    this.c.defaultTxt = c();
    this.c.placeHolder = d();
    Object localObject = this.c;
    ((TkdQQArgument)localObject).maxCharCount = this.h;
    ((TkdQQArgument)localObject).showGif = false;
    ((TkdQQArgument)localObject).showLink = this.i;
    ((TkdQQArgument)localObject).firstAction = this.f;
    ((TkdQQArgument)localObject).forceHideAt = this.g.getBooleanExtra("forceHideAt", false);
    this.c.forceHideTopic = this.g.getBooleanExtra("forceHideTopic", false);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("#initQQArgument: qqArgument=");
    ((StringBuilder)localObject).append(this.c);
    QLog.d("CommentArgumentModel", 1, ((StringBuilder)localObject).toString());
  }
  
  private void a(Bundle paramBundle)
  {
    this.j = paramBundle.getBoolean("arg_comment_gif_switch", true);
    if (ReadInJoyHelper.F(f()) == 1) {
      this.j = false;
    }
  }
  
  private static void a(JSONObject paramJSONObject, String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString2)) {
      paramJSONObject.put(paramString1, paramString2);
    }
  }
  
  private int b()
  {
    int k = this.g.getIntExtra("firstAction", 0);
    if (k != 1)
    {
      if (k != 2) {
        return 0;
      }
      return 2;
    }
    return 1;
  }
  
  private void b(@NotNull Bundle paramBundle)
  {
    int k = paramBundle.getInt("maxLength", -1);
    if (k > 0)
    {
      this.h = ReadInJoyHelper.b(k);
    }
    else
    {
      this.h = ReadInJoyHelper.j();
      if (QLog.isColorLevel())
      {
        paramBundle = new StringBuilder();
        paramBundle.append("initData | comment_mMaxCharCount : ");
        paramBundle.append(this.h);
        QLog.d("CommentArgumentModel", 2, paramBundle.toString());
      }
    }
    if (this.h > 5000) {
      this.h = 5000;
    }
    if (this.h < 100) {
      this.h = 100;
    }
  }
  
  private CharSequence c()
  {
    Object localObject2 = this.g.getStringExtra("comment_recreate_draft");
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = DraftDataUtil.b(this.d.c());
    }
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject1 = this.g.getStringExtra("defaultTxt");
      localObject2 = localObject1;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = EmotionCodecUtils.c(((CharSequence)localObject1).toString());
      }
    }
    return localObject2;
  }
  
  private String d()
  {
    Object localObject = this.e;
    String str = this.d.a();
    if (!TextUtils.isEmpty(str)) {
      localObject = str;
    }
    return localObject;
  }
  
  private void e()
  {
    Bundle localBundle = this.g.getExtras();
    if (localBundle == null) {
      return;
    }
    this.e = localBundle.getString("placeholder", "");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("#initData: placeHolder=");
    localStringBuilder.append(this.e);
    QLog.d("CommentArgumentModel", 2, localStringBuilder.toString());
    b(localBundle);
    a(localBundle);
    g();
    this.f = b();
  }
  
  @Nullable
  private static QQAppInterface f()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  private void g()
  {
    boolean bool3 = ReadInJoyHelper.k();
    boolean bool2 = false;
    if ((bool3) && (this.d.b())) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.a = bool1;
    this.b = ReadInJoyHelper.n();
    boolean bool1 = bool2;
    if (this.a)
    {
      bool1 = bool2;
      if (this.b > 0) {
        bool1 = true;
      }
    }
    this.i = bool1;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("linkSwitch = ");
    localStringBuilder.append(bool3);
    localStringBuilder.append(", insertLinkLimit = ");
    localStringBuilder.append(this.b);
    QLog.d("CommentArgumentModel", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.base.model.CommentArgumentModel
 * JD-Core Version:    0.7.0.1
 */