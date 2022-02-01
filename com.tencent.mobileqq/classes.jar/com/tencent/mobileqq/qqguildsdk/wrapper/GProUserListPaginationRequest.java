package com.tencent.mobileqq.qqguildsdk.wrapper;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.gprosdk.GProUser;
import com.tencent.gprosdk.IGProSdkWrapper;
import com.tencent.mobileqq.qqguildsdk.callback.IGetGProUserListPaginationCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IGetGProUserListPaginationCallback.Result;
import com.tencent.mobileqq.qqguildsdk.data.GProUserInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.qqguildsdk.util.GProConvert;
import com.tencent.mobileqq.qqguildsdk.util.GProUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class GProUserListPaginationRequest
{
  private static final ConcurrentHashMap<String, ArrayList<GProUser>> a = new ConcurrentHashMap();
  private static final Handler b = new Handler(Looper.getMainLooper());
  private final IGProSdkWrapper c;
  private boolean d = false;
  private long e = 0L;
  
  private GProUserListPaginationRequest(IGProSdkWrapper paramIGProSdkWrapper)
  {
    this.c = paramIGProSdkWrapper;
  }
  
  public static GProUserListPaginationRequest a(IGProSdkWrapper paramIGProSdkWrapper)
  {
    return new GProUserListPaginationRequest(paramIGProSdkWrapper);
  }
  
  private void a(int paramInt, String paramString, IGetGProUserListPaginationCallback paramIGetGProUserListPaginationCallback)
  {
    paramString = IGetGProUserListPaginationCallback.Result.a(paramInt, paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("dispatchErrorCallback() ");
    localStringBuilder.append(paramString);
    QLog.e("GProUserListPaginationRequest", 1, localStringBuilder.toString());
    b.post(new GProUserListPaginationRequest.3(this, paramIGetGProUserListPaginationCallback, paramString));
  }
  
  private void a(GProUserListPaginationRequest.PaginationCookie paramPaginationCookie, IGetGProUserListPaginationCallback paramIGetGProUserListPaginationCallback, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("dispatchCallback() hasMore: ");
    localStringBuilder.append(paramBoolean);
    QLog.e("GProUserListPaginationRequest", 1, localStringBuilder.toString());
    b.post(new GProUserListPaginationRequest.4(this, paramPaginationCookie, paramBoolean, paramIGetGProUserListPaginationCallback));
  }
  
  private void a(@NonNull String paramString1, int paramInt, String paramString2, boolean paramBoolean, byte[] paramArrayOfByte, ArrayList<GProUser> paramArrayList1, ArrayList<GProUser> paramArrayList2, ArrayList<GProUser> paramArrayList3, @NonNull IGetGProUserListPaginationCallback paramIGetGProUserListPaginationCallback)
  {
    if (paramInt != 0)
    {
      a(paramInt, paramString2, paramIGetGProUserListPaginationCallback);
      return;
    }
    paramString2 = new ArrayList();
    paramString2.addAll(paramArrayList1);
    paramString2.addAll(paramArrayList2);
    paramString2.addAll(paramArrayList3);
    paramString1 = GProUserListPaginationRequest.PaginationCookie.a(paramString1, paramArrayOfByte);
    a.put(GProUserListPaginationRequest.PaginationCookie.b(paramString1), paramString2);
    a(paramString1, paramIGetGProUserListPaginationCallback, paramBoolean);
  }
  
  private static ArrayList<IGProUserInfo> b(List<GProUser> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(new GProUserInfo((GProUser)paramList.next()));
    }
    return localArrayList;
  }
  
  public GProUserListPaginationRequest a(long paramLong)
  {
    this.e = paramLong;
    return this;
  }
  
  public GProUserListPaginationRequest a(boolean paramBoolean)
  {
    this.d = paramBoolean;
    return this;
  }
  
  public void a(@NonNull String paramString, @Nullable Object paramObject, @NonNull IGetGProUserListPaginationCallback paramIGetGProUserListPaginationCallback)
  {
    if (GProUtil.a(paramString))
    {
      a(-90, "guildId 参数异常!", paramIGetGProUserListPaginationCallback);
      return;
    }
    if ((paramObject != null) && (!(paramObject instanceof GProUserListPaginationRequest.PaginationCookie)))
    {
      a(-90, "Cookie 参数异常!", paramIGetGProUserListPaginationCallback);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("GProUserListPaginationRequest", 2, new Object[] { "getUserList() call: mSdkWrapper.getUserList() with", paramString, " ", Long.valueOf(this.e), " ", Boolean.valueOf(this.d) });
    }
    if (paramObject == null)
    {
      this.c.getUserList(GProConvert.a(paramString), this.e, this.d, new GProUserListPaginationRequest.1(this, paramString, paramIGetGProUserListPaginationCallback));
      return;
    }
    paramObject = (GProUserListPaginationRequest.PaginationCookie)paramObject;
    this.c.loadNextPageMemberList(GProConvert.a(paramString), this.e, this.d, GProUserListPaginationRequest.PaginationCookie.a(paramObject), new GProUserListPaginationRequest.2(this, paramString, paramIGetGProUserListPaginationCallback));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProUserListPaginationRequest
 * JD-Core Version:    0.7.0.1
 */