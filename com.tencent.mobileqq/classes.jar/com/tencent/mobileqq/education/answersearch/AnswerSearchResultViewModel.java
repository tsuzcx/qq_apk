package com.tencent.mobileqq.education.answersearch;

import android.os.Handler;
import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.education.request.api.IStudyRequestHandler;
import com.tencent.mobileqq.education.request.callback.IStudyCmdCallback;
import com.tencent.mobileqq.education.request.callback.IStudyUploadCallback;
import com.tencent.mobileqq.education.request.pb.SearchAnswer.RspErr;
import com.tencent.mobileqq.education.request.pb.SearchAnswer.SearchAnswerReq;
import com.tencent.mobileqq.education.request.pb.SearchAnswer.SearchAnswerRsp;
import com.tencent.mobileqq.education.request.respone.IStudyResponse;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/education/answersearch/AnswerSearchResultViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "answerSearchData", "", "answerSearchErrorCode", "", "answerSearchErrorMsg", "answerSearchNotify", "Landroidx/lifecycle/MutableLiveData;", "", "getAnswerSearchNotify", "()Landroidx/lifecycle/MutableLiveData;", "answerSearchUrl", "bitmapFilePath", "checkNetworkAccess", "getAnswerSearchPicUrl", "getAnswerSearchResultData", "getPackageData", "handleAnswerPictureUploadRsp", "isSuc", "errorCode", "errorMsg", "url", "handleSearchAnswerRequest", "", "response", "Lcom/tencent/mobileqq/education/request/respone/IStudyResponse;", "notifyAnswerSearchFinish", "errCode", "errMsg", "searchData", "requestSearchResult", "callback", "Lcom/tencent/mobileqq/education/request/callback/IStudyCmdCallback;", "resetAnswerData", "searchAnswer", "setBitmapData", "filePath", "uploadSearchPicture", "Lcom/tencent/mobileqq/education/request/callback/IStudyUploadCallback;", "Companion", "qq_education_impl_release"}, k=1, mv={1, 1, 16})
public final class AnswerSearchResultViewModel
  extends ViewModel
{
  public static final AnswerSearchResultViewModel.Companion a = new AnswerSearchResultViewModel.Companion(null);
  @NotNull
  private final MutableLiveData<Boolean> b = new MutableLiveData(Boolean.valueOf(false));
  private String c;
  private String d = "";
  private String e = "";
  private int f;
  private String g = "";
  
  private final String a(boolean paramBoolean, int paramInt, String paramString1, String paramString2)
  {
    return paramString2;
  }
  
  private final void a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("notifyAnswerSearchFinish: error[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("] ");
    QLog.i("ProblemSearchResultViewModel", 1, localStringBuilder.toString());
    ThreadManager.getUIHandlerV2().post((Runnable)new AnswerSearchResultViewModel.notifyAnswerSearchFinish.1(this, paramInt, paramString1, paramString2, paramString3));
  }
  
  private final void a(IStudyResponse paramIStudyResponse)
  {
    Object localObject1;
    if (paramIStudyResponse.b() != 1000)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("handleSearchAnswerRequest: sso error. ");
      ((StringBuilder)localObject1).append(paramIStudyResponse.d());
      QLog.i("ProblemSearchResultViewModel", 1, ((StringBuilder)localObject1).toString());
      a(this, -3, "sso error.", null, null, 12, null);
      return;
    }
    Object localObject2 = new SearchAnswer.SearchAnswerRsp();
    ((SearchAnswer.SearchAnswerRsp)localObject2).mergeFrom(paramIStudyResponse.a());
    if (((SearchAnswer.SearchAnswerRsp)localObject2).ret.has())
    {
      paramIStudyResponse = ((SearchAnswer.SearchAnswerRsp)localObject2).ret.errCode;
      localObject1 = ((SearchAnswer.SearchAnswerRsp)localObject2).ret.errMsg;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("handleSearchAnswerRequest: business error. errCode[");
      ((StringBuilder)localObject2).append(paramIStudyResponse);
      ((StringBuilder)localObject2).append("] errMsg[");
      ((StringBuilder)localObject2).append(localObject1);
      ((StringBuilder)localObject2).append(']');
      QLog.i("ProblemSearchResultViewModel", 1, ((StringBuilder)localObject2).toString());
      a(this, -4, "business error.", null, null, 12, null);
      return;
    }
    if ((!((SearchAnswer.SearchAnswerRsp)localObject2).questionUrl.has()) && (!((SearchAnswer.SearchAnswerRsp)localObject2).questionUrl.has()))
    {
      localObject1 = "";
      paramIStudyResponse = (IStudyResponse)localObject1;
    }
    else
    {
      localObject1 = ((SearchAnswer.SearchAnswerRsp)localObject2).questionUrl.get();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "searchRsp.questionUrl.get()");
      paramIStudyResponse = ((SearchAnswer.SearchAnswerRsp)localObject2).answerData.get();
      Intrinsics.checkExpressionValueIsNotNull(paramIStudyResponse, "searchRsp.answerData.get()");
      QLog.i("ProblemSearchResultViewModel", 1, "handleSearchAnswerRequest: success.");
    }
    a(this, 0, null, (String)localObject1, paramIStudyResponse, 3, null);
  }
  
  @NotNull
  public final MutableLiveData<Boolean> a()
  {
    return this.b;
  }
  
  public final void a(@NotNull IStudyUploadCallback paramIStudyUploadCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramIStudyUploadCallback, "callback");
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
    IStudyRequestHandler localIStudyRequestHandler = (IStudyRequestHandler)QRoute.api(IStudyRequestHandler.class);
    Intrinsics.checkExpressionValueIsNotNull(localAppRuntime, "runtime");
    String str = this.c;
    if (str == null) {
      Intrinsics.throwUninitializedPropertyAccessException("bitmapFilePath");
    }
    localIStudyRequestHandler.uploadFileRequest(localAppRuntime, str, paramIStudyUploadCallback);
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "filePath");
    this.c = paramString;
  }
  
  public final void a(@NotNull String paramString, @NotNull IStudyCmdCallback paramIStudyCmdCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "url");
    Intrinsics.checkParameterIsNotNull(paramIStudyCmdCallback, "callback");
    SearchAnswer.SearchAnswerReq localSearchAnswerReq = new SearchAnswer.SearchAnswerReq();
    localSearchAnswerReq.picUrl.set(paramString);
    paramString = MobileQQ.sMobileQQ.peekAppRuntime();
    IStudyRequestHandler localIStudyRequestHandler = (IStudyRequestHandler)QRoute.api(IStudyRequestHandler.class);
    Intrinsics.checkExpressionValueIsNotNull(paramString, "runtime");
    localIStudyRequestHandler.sendSSORequest(paramString, "trpc.ssr.ssr_tipaipai_svr.SsrTipaipaiSvr.SearchAnswer", localSearchAnswerReq.toByteArray(), 5000, paramIStudyCmdCallback);
  }
  
  public final void b()
  {
    e();
    if (!d())
    {
      a(this, -1, "network error.", null, null, 12, null);
      return;
    }
    ThreadManager.getSubThreadHandler().post((Runnable)new AnswerSearchResultViewModel.searchAnswer.1(this));
  }
  
  @NotNull
  public final String c()
  {
    JSONObject localJSONObject = new JSONObject();
    int i = this.f;
    String str = this.g;
    if (!TextUtils.isEmpty((CharSequence)this.e)) {
      localJSONObject.putOpt("data", this.e);
    } else {
      str = "answer search data is null.";
    }
    if (!TextUtils.isEmpty((CharSequence)this.d)) {
      localJSONObject.put("picurl", this.d);
    } else {
      str = "picture url is null.";
    }
    localJSONObject.put("code", i);
    localJSONObject.put("msg", str);
    str = localJSONObject.toString();
    Intrinsics.checkExpressionValueIsNotNull(str, "packageJsonObject.toString()");
    return str;
  }
  
  public final boolean d()
  {
    return NetworkUtil.isNetworkAvailable(null);
  }
  
  public final void e()
  {
    this.f = 0;
    this.g = "";
    this.e = "";
    this.d = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.education.answersearch.AnswerSearchResultViewModel
 * JD-Core Version:    0.7.0.1
 */