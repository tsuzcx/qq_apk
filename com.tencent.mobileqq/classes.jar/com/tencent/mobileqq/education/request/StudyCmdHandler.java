package com.tencent.mobileqq.education.request;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.education.request.callback.IStudyCmdCallback;
import com.tencent.mobileqq.education.request.respone.IStudyResponse;
import com.tencent.mobileqq.education.request.respone.StudySSOResponse;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.utils.PkgTools;
import com.tencent.mobileqq.utils.WupUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/education/request/StudyCmdHandler;", "Lcom/tencent/mobileqq/education/request/IStudyCmdHandler;", "appInterface", "Lmqq/app/AppRuntime;", "(Lmqq/app/AppRuntime;)V", "requestHashMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mobileqq/education/request/StudyCmdHandler$RequestObject;", "requestSeqFactory", "Ljava/util/concurrent/atomic/AtomicInteger;", "decodeResponse", "Lcom/tencent/mobileqq/education/request/respone/IStudyResponse;", "requestObject", "fromServiceMsg", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "onReceive", "", "toServiceMsg", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", "realSendRequest", "request", "Lcom/tencent/mobileqq/education/request/StudyReqInfo;", "callback", "Lcom/tencent/mobileqq/education/request/callback/IStudyCmdCallback;", "sendRequest", "sendSSORequest", "cmdString", "", "buffer", "", "timeOutSecond", "Companion", "RequestObject", "qq_education_impl_release"}, k=1, mv={1, 1, 16})
public final class StudyCmdHandler
  implements IStudyCmdHandler
{
  public static final StudyCmdHandler.Companion a = new StudyCmdHandler.Companion(null);
  private final AtomicInteger b;
  private final ConcurrentHashMap<Integer, StudyCmdHandler.RequestObject> c;
  private final AppRuntime d;
  
  public StudyCmdHandler(@NotNull AppRuntime paramAppRuntime)
  {
    this.d = paramAppRuntime;
    this.b = new AtomicInteger();
    this.c = new ConcurrentHashMap();
  }
  
  private final IStudyResponse a(StudyCmdHandler.RequestObject paramRequestObject, FromServiceMsg paramFromServiceMsg)
  {
    int i = paramFromServiceMsg.getResultCode();
    paramRequestObject = paramFromServiceMsg.getBusinessFailMsg();
    Intrinsics.checkExpressionValueIsNotNull(paramRequestObject, "fromServiceMsg.businessFailMsg");
    paramRequestObject = new StudySSOResponse(i, paramRequestObject);
    if (paramFromServiceMsg.isSuccess()) {
      paramRequestObject.a(WupUtil.b(paramFromServiceMsg.getWupBuffer()));
    }
    return (IStudyResponse)paramRequestObject;
  }
  
  private final void b(StudyReqInfo paramStudyReqInfo, IStudyCmdCallback paramIStudyCmdCallback)
  {
    int i = this.b.incrementAndGet();
    ((Map)this.c).put(Integer.valueOf(i), new StudyCmdHandler.RequestObject(paramStudyReqInfo, paramIStudyCmdCallback));
    paramIStudyCmdCallback = new ToServiceMsg("mobileqq.service", this.d.getAccount(), paramStudyReqInfo.d());
    paramIStudyCmdCallback.setTimeout(paramStudyReqInfo.b());
    paramIStudyCmdCallback.extraData.putLong("study_key_request_time", System.currentTimeMillis());
    paramIStudyCmdCallback.extraData.putInt("study_key_request_seq", i);
    if (!paramStudyReqInfo.c())
    {
      long l = paramStudyReqInfo.a().length;
      int j = (int)l;
      localObject = new byte[j + 4];
      PkgTools.DWord2Byte((byte[])localObject, 0, l + 4);
      PkgTools.copyData((byte[])localObject, 4, paramStudyReqInfo.a(), j);
      paramIStudyCmdCallback.putWupBuffer((byte[])localObject);
    }
    else
    {
      paramIStudyCmdCallback.putWupBuffer(paramStudyReqInfo.a());
    }
    Object localObject = new NewIntent((Context)this.d.getApplication(), StudyCmdServlet.class);
    ((NewIntent)localObject).putExtra(ToServiceMsg.class.getSimpleName(), (Parcelable)paramIStudyCmdCallback);
    this.d.startServlet((NewIntent)localObject);
    paramIStudyCmdCallback = StringCompanionObject.INSTANCE;
    paramIStudyCmdCallback = new Object[2];
    paramIStudyCmdCallback[0] = paramStudyReqInfo.d();
    paramIStudyCmdCallback[1] = Integer.valueOf(i);
    paramStudyReqInfo = String.format("realSendRequest: send request cmd: %s, request seq: %s", Arrays.copyOf(paramIStudyCmdCallback, paramIStudyCmdCallback.length));
    Intrinsics.checkExpressionValueIsNotNull(paramStudyReqInfo, "java.lang.String.format(format, *args)");
    QLog.d("StudyCmdHandler", 2, paramStudyReqInfo);
  }
  
  public final void a(@NotNull StudyReqInfo paramStudyReqInfo, @Nullable IStudyCmdCallback paramIStudyCmdCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramStudyReqInfo, "request");
    if (!AppNetConnInfo.isNetSupport())
    {
      if (paramIStudyCmdCallback != null) {
        paramIStudyCmdCallback.a(paramStudyReqInfo, (IStudyResponse)new StudySSOResponse(-1, "no network"));
      }
      return;
    }
    ThreadManager.getSubThreadHandler().post((Runnable)new StudyCmdHandler.sendRequest.1(this, paramStudyReqInfo, paramIStudyCmdCallback));
  }
  
  public final void a(@Nullable ToServiceMsg paramToServiceMsg, @Nullable FromServiceMsg paramFromServiceMsg)
  {
    if ((paramToServiceMsg != null) && (paramFromServiceMsg != null))
    {
      int i = paramToServiceMsg.extraData.getInt("study_key_request_seq");
      StudyCmdHandler.RequestObject localRequestObject = (StudyCmdHandler.RequestObject)this.c.get(Integer.valueOf(i));
      if (localRequestObject == null)
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("onReceive: can't find request cmd:");
        paramFromServiceMsg.append(paramToServiceMsg.getServiceCmd());
        paramFromServiceMsg.append(" request seq:");
        paramFromServiceMsg.append(i);
        QLog.w("StudyCmdHandler", 1, paramFromServiceMsg.toString());
        return;
      }
      paramToServiceMsg = a(localRequestObject, paramFromServiceMsg);
      paramFromServiceMsg = localRequestObject.b();
      if (paramFromServiceMsg != null) {
        paramFromServiceMsg.a(localRequestObject.a(), paramToServiceMsg);
      }
      return;
    }
    QLog.e("StudyCmdHandler", 1, "request == null || response == null");
  }
  
  public final void a(@Nullable String paramString, @Nullable byte[] paramArrayOfByte, int paramInt, @Nullable IStudyCmdCallback paramIStudyCmdCallback)
  {
    paramString = new StudyReqInfo.Builder().a(false).a(paramString).a(paramArrayOfByte).a(paramInt).a();
    Intrinsics.checkExpressionValueIsNotNull(paramString, "StudyReqInfo.Builder()\n …\n                .build()");
    a(paramString, paramIStudyCmdCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.education.request.StudyCmdHandler
 * JD-Core Version:    0.7.0.1
 */