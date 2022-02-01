package com.tencent.mobileqq.qqguildsdk.wrapper;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.gprosdk.GProCategoryChannelIdList;
import com.tencent.gprosdk.GProEnterChannleInfoResult;
import com.tencent.gprosdk.GProNotice;
import com.tencent.gprosdk.GProNoticeAction;
import com.tencent.gprosdk.GProNoticeCover;
import com.tencent.gprosdk.GProNoticeText;
import com.tencent.gprosdk.GProResult;
import com.tencent.gprosdk.GProSecurityResult;
import com.tencent.gprosdk.GProSessionConfig;
import com.tencent.gprosdk.IGProFetchAudioChannelUserListCallback;
import com.tencent.gprosdk.IGProLoadAllMemberListCallback;
import com.tencent.gprosdk.IGProSdkListener;
import com.tencent.gprosdk.IGProSdkWrapper;
import com.tencent.gprosdk.IGProSdkWrapper.CppProxy;
import com.tencent.gprosdk.IGProSearchGuildCallback;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qqguildsdk.callback.IAppAuthorizationCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IBindAppRoleCallback;
import com.tencent.mobileqq.qqguildsdk.callback.ICheckSelfRealNameVerifiedCallback;
import com.tencent.mobileqq.qqguildsdk.callback.ICheckUserBannedSpeakInChannelCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IDealNoticeCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IEnterAudioChannelCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IFetchEnterChannelPermissionCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IFetchGuildInfoByAppIdentityCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IFetchInviteInfoCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IFetchIsLiveChannelOpenCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IFetchIsVoiceChannelOpenCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IFetchLiveChannelAnchorListCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IFetchLiveChannelBannedUserListCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IFetchLiveRoomInfoCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IFetchLiveSecurityTipsCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IFetchNoticeRedPointCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IFetchRemainAtAllCountSink;
import com.tencent.mobileqq.qqguildsdk.callback.IFetchShareInfoCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IFetchVisibleMemberListByTinyIdCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IGetAddGuildOptionCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IGetAppAuthorizationInfoCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IGetAppRoleListCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IGetClientInfoListCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IGetGProUserListPaginationCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IGetMoreNoticeListCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IGetUserListCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IInitGetNoticeListCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IKickChannelMemberCallback;
import com.tencent.mobileqq.qqguildsdk.callback.ILoadUserProfileInfoCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IQueryTinyIdByLiveUIDCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IResultCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IResultWithSecurityCallback;
import com.tencent.mobileqq.qqguildsdk.callback.ISearchVisibleMemberListCallback;
import com.tencent.mobileqq.qqguildsdk.callback.ISetChannelAdminMsgNotifyTypeCallback;
import com.tencent.mobileqq.qqguildsdk.callback.ISetChannelMsgNotifyTypeCallback;
import com.tencent.mobileqq.qqguildsdk.callback.ISetChannelNameCallback;
import com.tencent.mobileqq.qqguildsdk.callback.ISetChannelTalkPermissionCallback;
import com.tencent.mobileqq.qqguildsdk.callback.ISetGuildClientIdCallback;
import com.tencent.mobileqq.qqguildsdk.callback.ISetGuildInfoCallback;
import com.tencent.mobileqq.qqguildsdk.callback.ISetGuildTopCallback;
import com.tencent.mobileqq.qqguildsdk.callback.ISwitchPresenceArchiveCallback;
import com.tencent.mobileqq.qqguildsdk.data.AddGuildOption;
import com.tencent.mobileqq.qqguildsdk.data.AppChnnPreFetchInfo;
import com.tencent.mobileqq.qqguildsdk.data.CategoryChannelSortInfo;
import com.tencent.mobileqq.qqguildsdk.data.ChannelCreateInfo;
import com.tencent.mobileqq.qqguildsdk.data.FocusChannelReqInfo;
import com.tencent.mobileqq.qqguildsdk.data.GuildIdentityInfo;
import com.tencent.mobileqq.qqguildsdk.data.GuildMsgNode;
import com.tencent.mobileqq.qqguildsdk.data.GuildNotice;
import com.tencent.mobileqq.qqguildsdk.data.GuildNotice.GuildNoticeAction;
import com.tencent.mobileqq.qqguildsdk.data.GuildNotice.GuildNoticeCover;
import com.tencent.mobileqq.qqguildsdk.data.GuildNotice.GuildNoticeText;
import com.tencent.mobileqq.qqguildsdk.data.GuildSourceId;
import com.tencent.mobileqq.qqguildsdk.data.GuildSourceInfo;
import com.tencent.mobileqq.qqguildsdk.data.IEnterChannleInfoResult;
import com.tencent.mobileqq.qqguildsdk.data.IGProClientIdentityInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProResultInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.MsgRouttingHead;
import com.tencent.mobileqq.qqguildsdk.util.GProConvert;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;
import com.tencent.mobileqq.qqguildsdk.wrapper.callback.IFetchAppChnnPreInfoListCallback;
import com.tencent.mobileqq.qqguildsdk.wrapper.callback.IFetchAppInfoListCallback;
import com.tencent.mobileqq.qqguildsdk.wrapper.callback.IFetchChannelListWithGuildInitForGuestCallback;
import com.tencent.mobileqq.qqguildsdk.wrapper.callback.IFetchChannelMemberListCallback;
import com.tencent.mobileqq.qqguildsdk.wrapper.callback.IFetchGuestGuildForImplCallback;
import com.tencent.mobileqq.qqguildsdk.wrapper.callback.IFetchGuildInfoForImplCallback;
import com.tencent.mobileqq.qqguildsdk.wrapper.callback.IFetchVisibleMemberListCallback;
import com.tencent.mobileqq.qqguildsdk.wrapper.callback.IGetChannelCategoryWithListCallback;
import com.tencent.mobileqq.qqguildsdk.wrapper.callback.IGetChannelInfoCallback;
import com.tencent.mobileqq.qqguildsdk.wrapper.callback.IGetGProUserCallback;
import com.tencent.mobileqq.qqguildsdk.wrapper.callback.ILoadGuildAndChnListCallback;
import com.tencent.mobileqq.qqguildsdk.wrapper.callback.ILoadSimpleProfilesCallback;
import com.tencent.mobileqq.qqguildsdk.wrapper.callback.ISearchMemberFromServerCallback;
import com.tencent.mobileqq.utils.SoLoadUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;

public abstract class GProSdkWrapperImpl
  extends GPSNotifyCenter
  implements IGProSdkWrapperListener
{
  public static int a;
  private IGProSdkWrapper b;
  private Handler c;
  private String d;
  
  static
  {
    try
    {
      SoLoadUtil.a(BaseApplication.getContext(), "gpro", 0, false);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      localUnsatisfiedLinkError.printStackTrace();
    }
  }
  
  public GProSdkWrapperImpl(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime != null)
    {
      this.c = new Handler(Looper.getMainLooper());
      this.b = a(paramAppRuntime);
    }
  }
  
  private static IGProSdkWrapper a(IGProSdkListener paramIGProSdkListener)
  {
    return IGProSdkWrapper.CppProxy.createGProSdkWrapper(paramIGProSdkListener);
  }
  
  private IGProSdkWrapper a(AppRuntime paramAppRuntime)
  {
    return a(new GProSdkWrapperImpl.GProSdkListenerImpl(this, paramAppRuntime));
  }
  
  private IEnterChannleInfoResult a(GProEnterChannleInfoResult paramGProEnterChannleInfoResult)
  {
    return new GProSdkWrapperImpl.34(this, paramGProEnterChannleInfoResult);
  }
  
  private IGProResultInfo a(GProResult paramGProResult)
  {
    return new GProSdkWrapperImpl.40(this, paramGProResult);
  }
  
  private String a(GProCategoryChannelIdList paramGProCategoryChannelIdList, ArrayList<GProCategoryChannelIdList> paramArrayList)
  {
    if ((paramGProCategoryChannelIdList != null) && (paramGProCategoryChannelIdList.getChannelList() != null))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("uncategorizedChannels size:");
      ((StringBuilder)localObject).append(paramGProCategoryChannelIdList.getChannelList().size());
      ((StringBuilder)localObject).append(": ");
      ((StringBuilder)localObject).append(paramGProCategoryChannelIdList);
      ((StringBuilder)localObject).append("\n  categoryList size: ");
      ((StringBuilder)localObject).append(paramArrayList.size());
      paramGProCategoryChannelIdList = ((StringBuilder)localObject).toString();
      localObject = paramGProCategoryChannelIdList;
      if (paramArrayList != null)
      {
        localObject = paramGProCategoryChannelIdList;
        if (paramArrayList.size() > 0)
        {
          paramArrayList = paramArrayList.iterator();
          for (;;)
          {
            localObject = paramGProCategoryChannelIdList;
            if (!paramArrayList.hasNext()) {
              break;
            }
            localObject = (GProCategoryChannelIdList)paramArrayList.next();
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(paramGProCategoryChannelIdList);
            localStringBuilder.append("\n ");
            localStringBuilder.append(((GProCategoryChannelIdList)localObject).getName());
            localStringBuilder.append("(");
            localStringBuilder.append(((GProCategoryChannelIdList)localObject).getCategoryId());
            localStringBuilder.append("): ");
            localStringBuilder.append(((GProCategoryChannelIdList)localObject).getChannelList());
            paramGProCategoryChannelIdList = localStringBuilder.toString();
          }
        }
      }
      return localObject;
    }
    return "";
  }
  
  private String a(GProSecurityResult paramGProSecurityResult)
  {
    if ((paramGProSecurityResult != null) && (paramGProSecurityResult.getIsValidSecResult()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(", secResult :  actionCode");
      localStringBuilder.append(paramGProSecurityResult.getActionCode());
      localStringBuilder.append(", strPrompt : ");
      localStringBuilder.append(paramGProSecurityResult.getStrPrompt());
      localStringBuilder.append(", strPrompt : ");
      localStringBuilder.append(paramGProSecurityResult.getStrDetail());
      return localStringBuilder.toString();
    }
    return "";
  }
  
  @NotNull
  private String a(GProSecurityResult paramGProSecurityResult, GProCategoryChannelIdList paramGProCategoryChannelIdList, ArrayList<GProCategoryChannelIdList> paramArrayList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a(paramGProSecurityResult));
    localStringBuilder.append("\n");
    localStringBuilder.append(a(paramGProCategoryChannelIdList, paramArrayList));
    return localStringBuilder.toString();
  }
  
  public static String a(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    return IGProSdkWrapper.CppProxy.getFullAvatarUrl(paramString, paramInt1, paramLong, paramInt2);
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    return IGProSdkWrapper.CppProxy.lz4DecompressBuf(paramArrayOfByte);
  }
  
  private IGProSecurityResult b(GProSecurityResult paramGProSecurityResult)
  {
    if (paramGProSecurityResult.getIsValidSecResult()) {
      return new GProSdkWrapperImpl.9(this, paramGProSecurityResult);
    }
    return null;
  }
  
  private List<GuildNotice> c(ArrayList<GProNotice> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      GProNotice localGProNotice = (GProNotice)paramArrayList.next();
      GuildNotice localGuildNotice = new GuildNotice();
      localGuildNotice.a = localGProNotice.getNoticeId();
      localGuildNotice.b = localGProNotice.getTemplateId();
      localGuildNotice.c = localGProNotice.getCreateTs();
      localGuildNotice.d = localGProNotice.getExpireTs();
      localGuildNotice.e = localGProNotice.getHandleTs();
      Object localObject1;
      try
      {
        localGuildNotice.f = String.valueOf(localGProNotice.getGuildId());
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("getGuildNoticeList: ");
          ((StringBuilder)localObject1).append(localException.getMessage());
          QLog.d("GProSdkWrapperImpl", 2, ((StringBuilder)localObject1).toString());
        }
      }
      localGuildNotice.g = new GuildNotice.GuildNoticeCover();
      if (localGProNotice.getCover() != null)
      {
        localGuildNotice.g.b = localGProNotice.getCover().getLinkId();
        localGuildNotice.g.a = localGProNotice.getCover().getType();
        localGuildNotice.g.c = localGProNotice.getCover().getUrl();
      }
      localGuildNotice.h = new ArrayList();
      Iterator localIterator;
      Object localObject2;
      if (localGProNotice.getTitle() != null)
      {
        localIterator = localGProNotice.getTitle().iterator();
        while (localIterator.hasNext())
        {
          localObject1 = (GProNoticeText)localIterator.next();
          localObject2 = new GuildNotice.GuildNoticeText();
          ((GuildNotice.GuildNoticeText)localObject2).b = ((GProNoticeText)localObject1).getLinkId();
          ((GuildNotice.GuildNoticeText)localObject2).c = ((GProNoticeText)localObject1).getContent();
          ((GuildNotice.GuildNoticeText)localObject2).a = ((GProNoticeText)localObject1).getType();
          localGuildNotice.h.add(localObject2);
        }
      }
      localGuildNotice.i = new ArrayList();
      if (localGProNotice.getSubTitle() != null)
      {
        localIterator = localGProNotice.getSubTitle().iterator();
        while (localIterator.hasNext())
        {
          localObject1 = (GProNoticeText)localIterator.next();
          localObject2 = new GuildNotice.GuildNoticeText();
          ((GuildNotice.GuildNoticeText)localObject2).b = ((GProNoticeText)localObject1).getLinkId();
          ((GuildNotice.GuildNoticeText)localObject2).c = ((GProNoticeText)localObject1).getContent();
          ((GuildNotice.GuildNoticeText)localObject2).a = ((GProNoticeText)localObject1).getType();
          localGuildNotice.i.add(localObject2);
        }
      }
      localGuildNotice.j = new ArrayList();
      if (localGProNotice.getComment() != null)
      {
        localIterator = localGProNotice.getComment().iterator();
        while (localIterator.hasNext())
        {
          localObject1 = (GProNoticeText)localIterator.next();
          localObject2 = new GuildNotice.GuildNoticeText();
          ((GuildNotice.GuildNoticeText)localObject2).b = ((GProNoticeText)localObject1).getLinkId();
          ((GuildNotice.GuildNoticeText)localObject2).c = ((GProNoticeText)localObject1).getContent();
          ((GuildNotice.GuildNoticeText)localObject2).a = ((GProNoticeText)localObject1).getType();
          localGuildNotice.j.add(localObject2);
        }
      }
      localGuildNotice.k = new ArrayList();
      if (localGProNotice.getActionList() != null)
      {
        localIterator = localGProNotice.getActionList().iterator();
        while (localIterator.hasNext())
        {
          localObject1 = (GProNoticeAction)localIterator.next();
          localObject2 = new GuildNotice.GuildNoticeAction();
          ((GuildNotice.GuildNoticeAction)localObject2).c = ((GProNoticeAction)localObject1).getActionId();
          ((GuildNotice.GuildNoticeAction)localObject2).b = ((GProNoticeAction)localObject1).getTitle();
          ((GuildNotice.GuildNoticeAction)localObject2).a = ((GProNoticeAction)localObject1).getStyle();
          localGuildNotice.k.add(localObject2);
        }
      }
      localGuildNotice.l = localGProNotice.getJoinSign();
      localArrayList.add(localGuildNotice);
    }
    return localArrayList;
  }
  
  private List<IGProResultInfo> c(List<GProResult> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(a((GProResult)paramList.next()));
    }
    return localArrayList;
  }
  
  public void a(int paramInt1, int paramInt2, MsgRouttingHead paramMsgRouttingHead, byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("msgType : ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", subType :");
    localStringBuilder.append(paramInt2);
    GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper interface", "onServerPushMsg", " push msg to server", localStringBuilder.toString());
    this.b.onServerPushMsg(paramInt1, paramInt2, GProConvert.a(paramMsgRouttingHead), paramArrayOfByte);
  }
  
  public void a(int paramInt, IGetClientInfoListCallback paramIGetClientInfoListCallback)
  {
    int i = a;
    a = i + 1;
    i = GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper interface", "getClientInfoList", "", "", i);
    this.b.getClientInfoList(paramInt, new GProSdkWrapperImpl.84(this, i, paramIGetClientInfoListCallback));
  }
  
  public void a(int paramInt, IGetMoreNoticeListCallback paramIGetMoreNoticeListCallback)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("listOffset ：");
    ((StringBuilder)localObject).append(paramInt);
    localObject = ((StringBuilder)localObject).toString();
    int i = a;
    a = i + 1;
    i = GProLog.b("GProSdkWrapperImpl", true, "sdkWrapper interface", "getMoreNoticeList", "ui", (String)localObject, i);
    this.b.getMoreNoticeList(paramInt, new GProSdkWrapperImpl.60(this, i, paramIGetMoreNoticeListCallback));
  }
  
  public void a(int paramInt, IResultCallback paramIResultCallback)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("redPointType ：");
    ((StringBuilder)localObject).append(paramInt);
    localObject = ((StringBuilder)localObject).toString();
    int i = a;
    a = i + 1;
    i = GProLog.b("GProSdkWrapperImpl", true, "sdkWrapper interface", "clearNoticeRedPoint", "ui", (String)localObject, i);
    this.b.clearNoticeRedPoint(paramInt, new GProSdkWrapperImpl.63(this, i, paramIResultCallback));
  }
  
  public void a(ICheckSelfRealNameVerifiedCallback paramICheckSelfRealNameVerifiedCallback)
  {
    int i = a;
    a = i + 1;
    i = GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper interface", "checkSelfRealNameVerified", i);
    this.b.checkSelfRealNameVerified(new GProSdkWrapperImpl.72(this, i, paramICheckSelfRealNameVerifiedCallback));
  }
  
  public void a(IFetchLiveSecurityTipsCallback paramIFetchLiveSecurityTipsCallback)
  {
    int i = a;
    a = i + 1;
    i = GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchLiveSecurityTips", i);
    this.b.fetchLiveSecurityTips(new GProSdkWrapperImpl.74(this, i, paramIFetchLiveSecurityTipsCallback));
  }
  
  public void a(IFetchNoticeRedPointCallback paramIFetchNoticeRedPointCallback)
  {
    int i = a;
    a = i + 1;
    i = GProLog.b("GProSdkWrapperImpl", true, "sdkWrapper interface", "fetchNoticeRedPoint", "ui", "", i);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(1));
    this.b.fetchNoticeRedPoint(localArrayList, new GProSdkWrapperImpl.62(this, i, paramIFetchNoticeRedPointCallback));
  }
  
  public void a(GuildIdentityInfo paramGuildIdentityInfo, String paramString1, String paramString2, IFetchGuildInfoByAppIdentityCallback paramIFetchGuildInfoByAppIdentityCallback)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("identity：");
    localStringBuilder.append(paramGuildIdentityInfo.toString());
    localStringBuilder.append(", guildOpenId: ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("， rawUrl ： ");
    localStringBuilder.append(paramString2);
    GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchGuildInfoByAppIdentity", "", localStringBuilder.toString());
    this.b.fetchGuildInfoByAppIdentity(GProConvert.a(paramGuildIdentityInfo), paramString1, paramString2, new GProSdkWrapperImpl.44(this, paramIFetchGuildInfoByAppIdentityCallback));
  }
  
  public void a(IFetchAppInfoListCallback paramIFetchAppInfoListCallback)
  {
    int i = a;
    a = i + 1;
    i = GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchAppInfoList", "", "", i);
    this.b.fetchAppInfoList(new GProSdkWrapperImpl.78(this, i, paramIFetchAppInfoListCallback));
  }
  
  protected void a(ILoadSimpleProfilesCallback paramILoadSimpleProfilesCallback)
  {
    int i = a;
    a = i + 1;
    i = GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper interface", "loadSimpleProfiles", "sdk-init", null, i);
    this.b.loadSimpleProfiles(200, new GProSdkWrapperImpl.31(this, i, paramILoadSimpleProfilesCallback));
  }
  
  protected void a(String paramString, int paramInt)
  {
    GProLog.b("sdkWrapper interface", false, "startGProSdk", "open sdk service");
    IGProSdkWrapper localIGProSdkWrapper = this.b;
    if (localIGProSdkWrapper != null)
    {
      long l = GProConvert.a(paramString);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(AppConstants.SDCARD_FILE_SAVE_PATH);
      localStringBuilder.append(paramString);
      localStringBuilder.append("_crpty.db");
      localIGProSdkWrapper.start(l, new GProSessionConfig(localStringBuilder.toString(), "1.1", 0L));
    }
  }
  
  public void a(String paramString, int paramInt, IGetAppAuthorizationInfoCallback paramIGetAppAuthorizationInfoCallback)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("clientId: ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(", type: ");
    ((StringBuilder)localObject).append(paramInt);
    localObject = ((StringBuilder)localObject).toString();
    int i = a;
    a = i + 1;
    i = GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper interface", "getAppAuthorizationInfo", "", (String)localObject, i);
    this.b.getAppAuthorizationInfo(GProConvert.b(paramString), paramInt, new GProSdkWrapperImpl.80(this, paramInt, i, paramIGetAppAuthorizationInfoCallback));
  }
  
  public void a(String paramString, long paramLong, IGProLoadAllMemberListCallback paramIGProLoadAllMemberListCallback)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("guildId ：");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("， count ： ");
    ((StringBuilder)localObject).append(paramLong);
    localObject = ((StringBuilder)localObject).toString();
    int i = a;
    a = i + 1;
    GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper interface", "loadAllMemberList", "", (String)localObject, i);
    this.b.loadAllMemberList(GProConvert.a(paramString), paramLong, paramIGProLoadAllMemberListCallback);
  }
  
  public void a(String paramString1, long paramLong, String paramString2, IGetChannelCategoryWithListCallback paramIGetChannelCategoryWithListCallback)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("guildId ：");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append("， categoryId ： ");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append("， dstName：");
    ((StringBuilder)localObject).append(paramString2);
    localObject = ((StringBuilder)localObject).toString();
    int i = a;
    a = i + 1;
    i = GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper interface", "changeChannelCategoryNameWithId", "", (String)localObject, i);
    this.b.changeChannelCategoryNameWithId(GProConvert.a(paramString1), paramLong, paramString2, new GProSdkWrapperImpl.48(this, i, paramIGetChannelCategoryWithListCallback));
  }
  
  public void a(String paramString, long paramLong, boolean paramBoolean, IGetUserListCallback paramIGetUserListCallback)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("guildId ：");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(", count : ");
    ((StringBuilder)localObject).append(paramLong);
    localObject = ((StringBuilder)localObject).toString();
    int i = a;
    a = i + 1;
    GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper interface", "getUserList", "ui", (String)localObject, i);
    new GProUserListApiAdapter(this.b).a(paramString, paramLong, paramBoolean, paramIGetUserListCallback);
  }
  
  public void a(String paramString, long paramLong, boolean paramBoolean, IGetChannelCategoryWithListCallback paramIGetChannelCategoryWithListCallback)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("guildId ：");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("， categoryId ： ");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append(", isRemoveChannel: ");
    ((StringBuilder)localObject).append(paramBoolean);
    localObject = ((StringBuilder)localObject).toString();
    int i = a;
    a = i + 1;
    i = GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper interface", "removeChannelCategoryWithId", "", (String)localObject, i);
    this.b.removeChannelCategoryWithId(GProConvert.a(paramString), paramLong, paramBoolean, new GProSdkWrapperImpl.47(this, i, paramIGetChannelCategoryWithListCallback));
  }
  
  public void a(String paramString, IGProSearchGuildCallback paramIGProSearchGuildCallback)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key ：");
    localStringBuilder.append(paramString);
    GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper interface", "searchGuildByShowNumber", "", localStringBuilder.toString());
    this.b.searchGuildByShowNumber(paramString, 2, 2, "2", paramIGProSearchGuildCallback);
  }
  
  public void a(String paramString, IAppAuthorizationCallback paramIAppAuthorizationCallback)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("clientId: ");
    ((StringBuilder)localObject).append(paramString);
    localObject = ((StringBuilder)localObject).toString();
    int i = a;
    a = i + 1;
    i = GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper interface", "appAuthorization", "", (String)localObject, i);
    this.b.appAuthorization(GProConvert.b(paramString), new GProSdkWrapperImpl.81(this, i, paramIAppAuthorizationCallback));
  }
  
  public void a(String paramString, IFetchInviteInfoCallback paramIFetchInviteInfoCallback)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("inviteCode ： ");
    ((StringBuilder)localObject).append(paramString);
    localObject = ((StringBuilder)localObject).toString();
    int i = a;
    a = i + 1;
    i = GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchGuildInfoByInviteCode", "ui", (String)localObject, i);
    this.b.fetchInviteInfo(paramString, new GProSdkWrapperImpl.30(this, i, paramIFetchInviteInfoCallback));
  }
  
  public void a(String paramString, IFetchIsLiveChannelOpenCallback paramIFetchIsLiveChannelOpenCallback)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("guildId ：");
    ((StringBuilder)localObject).append(paramString);
    localObject = ((StringBuilder)localObject).toString();
    int i = a;
    a = i + 1;
    i = GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchIsLiveChannelOpen", "", (String)localObject, i);
    this.b.fetchIsLiveChannelOpen(GProConvert.a(paramString), new GProSdkWrapperImpl.73(this, i, paramIFetchIsLiveChannelOpenCallback));
  }
  
  public void a(String paramString, IFetchIsVoiceChannelOpenCallback paramIFetchIsVoiceChannelOpenCallback)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("guildId ：");
    ((StringBuilder)localObject).append(paramString);
    localObject = ((StringBuilder)localObject).toString();
    int i = a;
    a = i + 1;
    i = GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchIsVoiceChannelOpen", "", (String)localObject, i);
    this.b.fetchIsVoiceChannelOpen(GProConvert.a(paramString), new GProSdkWrapperImpl.38(this, i, paramIFetchIsVoiceChannelOpenCallback));
  }
  
  public void a(String paramString, IFetchRemainAtAllCountSink paramIFetchRemainAtAllCountSink)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("guildId ：");
    ((StringBuilder)localObject).append(paramString);
    localObject = ((StringBuilder)localObject).toString();
    int i = a;
    a = i + 1;
    i = GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchRemainAtAllCount", "ui", (String)localObject, i);
    this.b.fetchRemainAtAllCount(GProConvert.a(paramString), new GProSdkWrapperImpl.1(this, i, paramIFetchRemainAtAllCountSink, paramString));
  }
  
  public void a(String paramString, IGetAddGuildOptionCallback paramIGetAddGuildOptionCallback)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("guildId ：");
    ((StringBuilder)localObject).append(paramString);
    localObject = ((StringBuilder)localObject).toString();
    int i = a;
    a = i + 1;
    i = GProLog.b("GProSdkWrapperImpl", true, "sdkWrapper interface", "getAddGuildOption", "ui", (String)localObject, i);
    this.b.fetchAddGuildOption(GProConvert.a(paramString), new GProSdkWrapperImpl.56(this, paramString, i, paramIGetAddGuildOptionCallback));
  }
  
  public void a(String paramString, IGetAppRoleListCallback paramIGetAppRoleListCallback)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("clientId: ");
    ((StringBuilder)localObject).append(paramString);
    localObject = ((StringBuilder)localObject).toString();
    int i = a;
    a = i + 1;
    i = GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper interface", "getAppRoleList", "", (String)localObject, i);
    this.b.getAppRoleList(GProConvert.b(paramString), new GProSdkWrapperImpl.82(this, i, paramIGetAppRoleListCallback));
  }
  
  protected void a(String paramString, IResultCallback paramIResultCallback)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(" guildId ： ");
    ((StringBuilder)localObject).append(paramString);
    localObject = ((StringBuilder)localObject).toString();
    int i = a;
    a = i + 1;
    i = GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper interface", "destroyGuild", " ui", (String)localObject, i);
    this.b.destroyGuild(GProConvert.a(paramString), new GProSdkWrapperImpl.12(this, i, paramIResultCallback));
  }
  
  protected void a(String paramString, IResultWithSecurityCallback paramIResultWithSecurityCallback)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("guildId ：");
    ((StringBuilder)localObject).append(paramString);
    localObject = ((StringBuilder)localObject).toString();
    int i = a;
    a = i + 1;
    i = GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper interface", "removeGuild", "ui", (String)localObject, i);
    this.b.removeGuild(GProConvert.a(paramString), new GProSdkWrapperImpl.10(this, paramString, i, paramIResultWithSecurityCallback));
  }
  
  public void a(String paramString, AddGuildOption paramAddGuildOption, IResultWithSecurityCallback paramIResultWithSecurityCallback)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("guildId ：");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" option:");
    ((StringBuilder)localObject).append(paramAddGuildOption.a);
    ((StringBuilder)localObject).append(" question:");
    ((StringBuilder)localObject).append(paramAddGuildOption.b);
    ((StringBuilder)localObject).append(" answer:");
    ((StringBuilder)localObject).append(paramAddGuildOption.c);
    localObject = ((StringBuilder)localObject).toString();
    int i = a;
    a = i + 1;
    i = GProLog.b("GProSdkWrapperImpl", true, "sdkWrapper interface", "setAddGuildOption", "ui", (String)localObject, i);
    this.b.setAddGuildOption(GProConvert.a(paramString), paramAddGuildOption.a, paramAddGuildOption.b, paramAddGuildOption.c, new GProSdkWrapperImpl.57(this, i, paramIResultWithSecurityCallback));
  }
  
  public void a(String paramString, CategoryChannelSortInfo paramCategoryChannelSortInfo, ArrayList<CategoryChannelSortInfo> paramArrayList, IGetChannelCategoryWithListCallback paramIGetChannelCategoryWithListCallback)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("guildId ：");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("， unCategory ： ");
    ((StringBuilder)localObject).append(paramCategoryChannelSortInfo.b());
    localObject = ((StringBuilder)localObject).toString();
    int i = a;
    a = i + 1;
    i = GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper interface", "setChannelCategoryInfoWithId", "", (String)localObject, i);
    this.b.setChannelCategoryInfoWithId(GProConvert.a(paramString), GProConvert.a(paramCategoryChannelSortInfo), GProConvert.g(paramArrayList), new GProSdkWrapperImpl.50(this, i, paramIGetChannelCategoryWithListCallback));
  }
  
  protected void a(String paramString, ChannelCreateInfo paramChannelCreateInfo, long paramLong, IGetChannelInfoCallback paramIGetChannelInfoCallback)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("guildId ：");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(", info : ");
    ((StringBuilder)localObject).append(paramChannelCreateInfo.b());
    ((StringBuilder)localObject).append(", categoryId:");
    ((StringBuilder)localObject).append(paramLong);
    localObject = ((StringBuilder)localObject).toString();
    int i = a;
    a = i + 1;
    i = GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper interface", "createChannelWithId", "ui", (String)localObject, i);
    this.b.createChannelWithId(GProConvert.a(paramString), GProConvert.a(paramChannelCreateInfo), paramLong, new GProSdkWrapperImpl.5(this, paramString, i, paramIGetChannelInfoCallback));
  }
  
  protected void a(String paramString1, GuildSourceId paramGuildSourceId, String paramString2, IResultWithSecurityCallback paramIResultWithSecurityCallback)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("guildId ：");
    ((StringBuilder)localObject).append(paramString1);
    localObject = ((StringBuilder)localObject).toString();
    int i = a;
    a = i + 1;
    i = GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper interface", "addGuild", "ui", (String)localObject, i);
    this.b.addGuild(GProConvert.a(paramString1), GProConvert.a(paramGuildSourceId), paramString2, new GProSdkWrapperImpl.6(this, paramString1, i, paramIResultWithSecurityCallback));
  }
  
  protected void a(String paramString1, GuildSourceId paramGuildSourceId, String paramString2, GuildSourceInfo paramGuildSourceInfo, IResultWithSecurityCallback paramIResultWithSecurityCallback)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("guildId ：");
    ((StringBuilder)localObject).append(paramString1);
    localObject = ((StringBuilder)localObject).toString();
    int i = a;
    a = i + 1;
    i = GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper interface", "addGuildWithSource", "ui", (String)localObject, i);
    this.b.addGuildWithSource(GProConvert.a(paramString1), GProConvert.a(paramGuildSourceId), paramString2, GProConvert.a(paramGuildSourceInfo), new GProSdkWrapperImpl.7(this, paramString1, i, paramIResultWithSecurityCallback));
  }
  
  public void a(String paramString1, GuildSourceId paramGuildSourceId, String paramString2, String paramString3, String paramString4, IResultWithSecurityCallback paramIResultWithSecurityCallback)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("guildId ：");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(" comment:");
    ((StringBuilder)localObject).append(paramString3);
    ((StringBuilder)localObject).append(" answer:");
    if (paramString4 != null) {
      i = paramString4.length();
    } else {
      i = 0;
    }
    ((StringBuilder)localObject).append(i);
    localObject = ((StringBuilder)localObject).toString();
    int i = a;
    a = i + 1;
    i = GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper interface", "addGuildWithOption", "ui", (String)localObject, i);
    this.b.addGuildWithOption(GProConvert.a(paramString1), GProConvert.a(paramGuildSourceId), paramString2, paramString3, paramString4, new GProSdkWrapperImpl.8(this, paramString1, i, paramIResultWithSecurityCallback));
  }
  
  public void a(String paramString, IFetchChannelListWithGuildInitForGuestCallback paramIFetchChannelListWithGuildInitForGuestCallback)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("guildId ：");
    ((StringBuilder)localObject).append(paramString);
    localObject = ((StringBuilder)localObject).toString();
    int i = a;
    a = i + 1;
    i = GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchChannelListForGuest", "", (String)localObject, i);
    this.b.fetchChannelListForGuest(GProConvert.c(paramString), new GProSdkWrapperImpl.51(this, i, paramIFetchChannelListWithGuildInitForGuestCallback));
  }
  
  public void a(String paramString, IFetchGuestGuildForImplCallback paramIFetchGuestGuildForImplCallback)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("guildId ：");
    ((StringBuilder)localObject).append(paramString);
    localObject = ((StringBuilder)localObject).toString();
    int i = a;
    a = i + 1;
    i = GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchGuestGuild", "", (String)localObject, i);
    this.b.fetchGuestGuild(GProConvert.a(paramString), new GProSdkWrapperImpl.53(this, i, paramIFetchGuestGuildForImplCallback));
  }
  
  public void a(String paramString, IFetchGuildInfoForImplCallback paramIFetchGuildInfoForImplCallback)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("guildId ：");
    ((StringBuilder)localObject).append(paramString);
    localObject = ((StringBuilder)localObject).toString();
    int i = a;
    a = i + 1;
    i = GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchGuildInfoForGuest", "", (String)localObject, i);
    this.b.fetchGuildInfoForGuest(GProConvert.a(paramString), new GProSdkWrapperImpl.52(this, i, paramIFetchGuildInfoForImplCallback));
  }
  
  public void a(String paramString, Object paramObject, boolean paramBoolean, @NonNull IGetGProUserListPaginationCallback paramIGetGProUserListPaginationCallback)
  {
    GProUserListPaginationRequest.a(this.b).a(paramBoolean).a(100L).a(paramString, paramObject, paramIGetGProUserListPaginationCallback);
  }
  
  public void a(String paramString1, String paramString2, int paramInt, long paramLong, ISearchMemberFromServerCallback paramISearchMemberFromServerCallback)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("guildId: ");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(", keyWord: ");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append(", count:");
    ((StringBuilder)localObject).append(paramLong);
    localObject = ((StringBuilder)localObject).toString();
    int i = a;
    a = i + 1;
    i = GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper interface", "searchMemberFromServer", "", (String)localObject, i);
    this.b.searchMemberFromServer(GProConvert.a(paramString1), paramString2, paramInt, paramLong, new GProSdkWrapperImpl.89(this, i, paramISearchMemberFromServerCallback));
  }
  
  public void a(String paramString1, String paramString2, int paramInt, IBindAppRoleCallback paramIBindAppRoleCallback)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("clientId: ");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(", roleId: ");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append(", type: ");
    ((StringBuilder)localObject).append(paramInt);
    localObject = ((StringBuilder)localObject).toString();
    int i = a;
    a = i + 1;
    i = GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper interface", "bindAppRole", "", (String)localObject, i);
    this.b.bindAppRole(GProConvert.b(paramString1), paramString2, paramInt, new GProSdkWrapperImpl.83(this, paramString2, paramInt, i, paramIBindAppRoleCallback));
  }
  
  public void a(String paramString1, String paramString2, int paramInt, IResultWithSecurityCallback paramIResultWithSecurityCallback)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(" channelUin ： ");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append("， bannedSpeak ： ");
    ((StringBuilder)localObject).append(paramInt);
    localObject = ((StringBuilder)localObject).toString();
    int i = a;
    a = i + 1;
    i = GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper interface", "setChannelBannedSpeak", "ui", (String)localObject, i);
    this.b.setChannelBannedSpeak(GProConvert.a(paramString1), GProConvert.a(paramString2), paramInt, new GProSdkWrapperImpl.16(this, i, paramIResultWithSecurityCallback));
  }
  
  protected void a(String paramString1, String paramString2, int paramInt, ISetChannelAdminMsgNotifyTypeCallback paramISetChannelAdminMsgNotifyTypeCallback)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("channelUin ： ");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append("， type ： ");
    ((StringBuilder)localObject).append(paramInt);
    localObject = ((StringBuilder)localObject).toString();
    int i = a;
    a = i + 1;
    i = GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper interface", "setChannelMsgNotifyType", "ui-for manage", (String)localObject, i);
    this.b.setChannelMsgNotifyType(GProConvert.a(paramString1), GProConvert.a(paramString2), paramInt, new GProSdkWrapperImpl.18(this, i, paramISetChannelAdminMsgNotifyTypeCallback));
  }
  
  protected void a(String paramString1, String paramString2, int paramInt, ISetChannelMsgNotifyTypeCallback paramISetChannelMsgNotifyTypeCallback)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(" channelUin ： ");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append("， type ： ");
    ((StringBuilder)localObject).append(paramInt);
    localObject = ((StringBuilder)localObject).toString();
    int i = a;
    a = i + 1;
    i = GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper interface", "setMyMsgNotifyType", "ui-self", (String)localObject, i);
    this.b.customChannelMsgNotifyType(GProConvert.a(paramString1), GProConvert.a(paramString2), paramInt, new GProSdkWrapperImpl.20(this, i, paramISetChannelMsgNotifyTypeCallback));
  }
  
  protected void a(String paramString1, String paramString2, int paramInt, ISetChannelTalkPermissionCallback paramISetChannelTalkPermissionCallback)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(" channelUin ： ");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append("， permission ： ");
    ((StringBuilder)localObject).append(paramInt);
    localObject = ((StringBuilder)localObject).toString();
    int i = a;
    a = i + 1;
    i = GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper interface", "setChannelTalkPermission", "ui", (String)localObject, i);
    this.b.setChannelSpeakerPerm(GProConvert.a(paramString1), GProConvert.a(paramString2), paramInt, new GProSdkWrapperImpl.15(this, i, paramISetChannelTalkPermissionCallback));
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2, IResultCallback paramIResultCallback)
  {
    int i = a;
    a = i + 1;
    i = GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper interface", "reportShareInfo", "", i);
    this.b.reportShareInfo(GProConvert.a(paramString1), GProConvert.a(paramString2), paramInt1, paramString3, paramInt2, new GProSdkWrapperImpl.77(this, i, paramIResultCallback));
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2, ISearchVisibleMemberListCallback paramISearchVisibleMemberListCallback)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("channelId: ");
    ((StringBuilder)localObject).append(paramString2);
    localObject = ((StringBuilder)localObject).toString();
    int i = a;
    a = i + 1;
    i = GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper interface", "searchVisibleMemberList", "call", (String)localObject, i);
    long l1 = GProConvert.a(paramString1);
    long l2 = GProConvert.a(paramString2);
    paramString1 = new GProSdkWrapperImpl.25(this, i, paramISearchVisibleMemberListCallback);
    this.b.searchChannelMemberFromServer(l1, l2, paramString3, paramInt1, paramInt2, paramString1);
  }
  
  protected void a(String paramString1, String paramString2, int paramInt, @Nullable List<String> paramList, IResultWithSecurityCallback paramIResultWithSecurityCallback)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("channelUin: ");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append(", type: ");
    ((StringBuilder)localObject).append(paramInt);
    localObject = ((StringBuilder)localObject).toString();
    int i = a;
    a = i + 1;
    i = GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper interface", "setChannelVisible", "call", (String)localObject, i);
    long l1 = GProConvert.a(paramString1);
    long l2 = GProConvert.a(paramString2);
    paramString1 = GProConvert.a(paramList);
    this.b.setChannelVisible(l1, l2, paramInt, paramString1, new GProSdkWrapperImpl.21(this, i, paramIResultWithSecurityCallback));
  }
  
  public void a(String paramString1, String paramString2, long paramLong, int paramInt, IFetchChannelMemberListCallback paramIFetchChannelMemberListCallback)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("channelId: ");
    ((StringBuilder)localObject).append(paramString2);
    localObject = ((StringBuilder)localObject).toString();
    int i = a;
    a = i + 1;
    i = GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchChannelMemberList", "call", (String)localObject, i);
    long l1 = GProConvert.a(paramString1);
    long l2 = GProConvert.a(paramString2);
    this.b.fetchChannelMemberList(l1, l2, paramLong, paramInt, new GProSdkWrapperImpl.24(this, i, paramIFetchChannelMemberListCallback));
  }
  
  public void a(String paramString1, String paramString2, long paramLong, int paramInt, IFetchVisibleMemberListCallback paramIFetchVisibleMemberListCallback)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("channelId: ");
    ((StringBuilder)localObject).append(paramString2);
    localObject = ((StringBuilder)localObject).toString();
    int i = a;
    a = i + 1;
    i = GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchVisibleMemberList", "call", (String)localObject, i);
    long l1 = GProConvert.a(paramString1);
    long l2 = GProConvert.a(paramString2);
    this.b.fetchVisibleMemberList(l1, l2, paramLong, paramInt, new GProSdkWrapperImpl.23(this, i, paramIFetchVisibleMemberListCallback));
  }
  
  public void a(String paramString1, String paramString2, long paramLong, IGetChannelCategoryWithListCallback paramIGetChannelCategoryWithListCallback)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("guildId ：");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append("，channelId ：");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append("， categoryId ： ");
    ((StringBuilder)localObject).append(paramLong);
    localObject = ((StringBuilder)localObject).toString();
    int i = a;
    a = i + 1;
    i = GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper interface", "setChannelCategoryWithId", " ", (String)localObject, i);
    this.b.setChannelCategoryWithId(GProConvert.a(paramString1), GProConvert.a(paramString2), paramLong, new GProSdkWrapperImpl.45(this, i, paramIGetChannelCategoryWithListCallback));
  }
  
  public void a(String paramString1, String paramString2, IGProFetchAudioChannelUserListCallback paramIGProFetchAudioChannelUserListCallback)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("guildId ：");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(", audioChannelId ： ");
    ((StringBuilder)localObject).append(paramString2);
    localObject = ((StringBuilder)localObject).toString();
    int i = a;
    a = i + 1;
    i = GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchOneAudioChannelUserList", "", (String)localObject, i);
    this.b.fetchAudioChannelUserList(GProConvert.a(paramString1), GProConvert.a(paramString2), new GProSdkWrapperImpl.37(this, paramString1, i, paramIGProFetchAudioChannelUserListCallback));
  }
  
  public void a(String paramString1, String paramString2, IDealNoticeCallback paramIDealNoticeCallback)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("noticeId ：");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(" actionId ：");
    ((StringBuilder)localObject).append(paramString2);
    localObject = ((StringBuilder)localObject).toString();
    int i = a;
    a = i + 1;
    i = GProLog.b("GProSdkWrapperImpl", true, "sdkWrapper interface", "dealNotice", "ui", (String)localObject, i);
    this.b.dealNotice(paramString1, paramString2, new GProSdkWrapperImpl.61(this, i, paramIDealNoticeCallback));
  }
  
  public void a(String paramString1, String paramString2, IFetchEnterChannelPermissionCallback paramIFetchEnterChannelPermissionCallback)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("guildId ：");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(", channelId:");
    ((StringBuilder)localObject).append(paramString2);
    localObject = ((StringBuilder)localObject).toString();
    int i = a;
    a = i + 1;
    i = GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchEnterChannelPermission", "", (String)localObject, i);
    this.b.fetchEnterChannelPermission(GProConvert.a(paramString1), GProConvert.a(paramString2), new GProSdkWrapperImpl.66(this, i, paramIFetchEnterChannelPermissionCallback));
  }
  
  public void a(String paramString1, String paramString2, IFetchLiveChannelAnchorListCallback paramIFetchLiveChannelAnchorListCallback)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("guildId ：");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(", channelId:");
    ((StringBuilder)localObject).append(paramString2);
    localObject = ((StringBuilder)localObject).toString();
    int i = a;
    a = i + 1;
    i = GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchLiveChannelAnchorList", "", (String)localObject, i);
    this.b.fetchLiveChannelAnchorList(GProConvert.a(paramString1), GProConvert.a(paramString2), new GProSdkWrapperImpl.65(this, i, paramIFetchLiveChannelAnchorListCallback));
  }
  
  public void a(String paramString1, String paramString2, IFetchShareInfoCallback paramIFetchShareInfoCallback)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(" guildId ： ");
    ((StringBuilder)localObject).append(paramString1);
    localObject = ((StringBuilder)localObject).toString();
    int i = a;
    a = i + 1;
    i = GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchGuildInviteUrl", "ui", (String)localObject, i);
    this.b.fetchShareInfo(GProConvert.a(paramString1), GProConvert.a(paramString2), new GProSdkWrapperImpl.29(this, i, paramIFetchShareInfoCallback));
  }
  
  public void a(String paramString1, String paramString2, ILoadUserProfileInfoCallback paramILoadUserProfileInfoCallback)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("guildId ： ");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append("， tinyId ： ");
    ((StringBuilder)localObject).append(paramString2);
    localObject = ((StringBuilder)localObject).toString();
    int i = a;
    a = i + 1;
    i = GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper interface", "loadGProUserProfileInfo", "ui", (String)localObject, i);
    this.b.LoadGuildUserProfileInfo(GProConvert.a(paramString1), GProConvert.a(paramString2), new GProSdkWrapperImpl.19(this, i, paramILoadUserProfileInfoCallback));
  }
  
  protected void a(String paramString1, String paramString2, IResultWithSecurityCallback paramIResultWithSecurityCallback)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(" channelUin ： ");
    ((StringBuilder)localObject).append(paramString2);
    localObject = ((StringBuilder)localObject).toString();
    int i = a;
    a = i + 1;
    i = GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper interface", "removeChannel", "ui", (String)localObject, i);
    this.b.removeChannel(GProConvert.a(paramString1), GProConvert.a(paramString2), new GProSdkWrapperImpl.13(this, i, paramIResultWithSecurityCallback));
  }
  
  public void a(String paramString1, String paramString2, ISetGuildClientIdCallback paramISetGuildClientIdCallback)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("guildId:");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(", clientId:");
    ((StringBuilder)localObject).append(paramString2);
    localObject = ((StringBuilder)localObject).toString();
    int i = a;
    a = i + 1;
    i = GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper interface", "setGuildClientId", "", (String)localObject, i);
    this.b.setGuildClientId(GProConvert.a(paramString1), GProConvert.b(paramString2), new GProSdkWrapperImpl.87(this, i, paramISetGuildClientIdCallback));
  }
  
  protected void a(String paramString1, String paramString2, ISetGuildInfoCallback paramISetGuildInfoCallback)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("guildId ： ");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append("， name ： ");
    ((StringBuilder)localObject).append(paramString2);
    localObject = ((StringBuilder)localObject).toString();
    int i = a;
    a = i + 1;
    i = GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper interface", "setGuildName", " ui", (String)localObject, i);
    this.b.setGuildName(GProConvert.a(paramString1), paramString2, new GProSdkWrapperImpl.27(this, i, paramISetGuildInfoCallback));
  }
  
  public void a(String paramString1, String paramString2, IGProClientIdentityInfo paramIGProClientIdentityInfo, long paramLong)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("guildId: ");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(", tinyId: ");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append(", clientIdentity: ");
    ((StringBuilder)localObject).append(paramIGProClientIdentityInfo);
    ((StringBuilder)localObject).append(", time: ");
    ((StringBuilder)localObject).append(paramLong);
    localObject = ((StringBuilder)localObject).toString();
    int i = a;
    a = i + 1;
    GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper interface", "setMemberClientIdentityForMsg", "", (String)localObject, i);
    this.b.setMemberClientIdentityForMsg(GProConvert.a(paramString1), GProConvert.a(paramString2), GProConvert.a(paramIGProClientIdentityInfo), paramLong);
  }
  
  public void a(String paramString1, String paramString2, IGetChannelCategoryWithListCallback paramIGetChannelCategoryWithListCallback)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("guildId ：");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append("， categoryName ： ");
    ((StringBuilder)localObject).append(paramString2);
    localObject = ((StringBuilder)localObject).toString();
    int i = a;
    a = i + 1;
    i = GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper interface", "createChannelCategoryWithId", "", (String)localObject, i);
    this.b.createChannelCategoryWithId(GProConvert.a(paramString1), paramString2, new GProSdkWrapperImpl.46(this, i, paramIGetChannelCategoryWithListCallback));
  }
  
  public void a(String paramString1, String paramString2, String paramString3, ICheckUserBannedSpeakInChannelCallback paramICheckUserBannedSpeakInChannelCallback)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("guildId ：");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(" channelId:");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append(" tinyId:");
    ((StringBuilder)localObject).append(paramString3);
    localObject = ((StringBuilder)localObject).toString();
    int i = a;
    a = i + 1;
    i = GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper interface", "checkUserBannedSpeakInChannel", "", (String)localObject, i);
    this.b.checkUserBannedSpeakInChannel(GProConvert.a(paramString1), GProConvert.a(paramString2), GProConvert.a(paramString3), new GProSdkWrapperImpl.75(this, i, paramICheckUserBannedSpeakInChannelCallback));
  }
  
  public void a(String paramString1, String paramString2, String paramString3, IEnterAudioChannelCallback paramIEnterAudioChannelCallback)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("guildId ：");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append("， channelId ： ");
    ((StringBuilder)localObject).append(paramString2);
    localObject = ((StringBuilder)localObject).toString();
    int i = a;
    a = i + 1;
    i = GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper interface", "addAudioChannel", "", (String)localObject, i);
    this.b.enterAudioChannel(GProConvert.a(paramString1), GProConvert.a(paramString2), GProConvert.b(paramString3), new GProSdkWrapperImpl.33(this, paramString1, paramString2, i, paramIEnterAudioChannelCallback));
  }
  
  public void a(String paramString1, String paramString2, String paramString3, IFetchLiveChannelBannedUserListCallback paramIFetchLiveChannelBannedUserListCallback)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("guildId ：");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(" channelId:");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append(" roomId:");
    ((StringBuilder)localObject).append(paramString3);
    localObject = ((StringBuilder)localObject).toString();
    int i = a;
    a = i + 1;
    i = GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchLiveChannelBannedUserList", "", (String)localObject, i);
    this.b.fetchLiveChannelBannedUserList(GProConvert.a(paramString1), GProConvert.a(paramString2), GProConvert.a(paramString3), new GProSdkWrapperImpl.71(this, i, paramIFetchLiveChannelBannedUserListCallback));
  }
  
  public void a(String paramString1, String paramString2, String paramString3, IResultCallback paramIResultCallback)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("guildId ：");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(", channelId:");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append(", roomId:");
    ((StringBuilder)localObject).append(paramString3);
    localObject = ((StringBuilder)localObject).toString();
    int i = a;
    a = i + 1;
    i = GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper interface", "requestBeginBroadcast", "", (String)localObject, i);
    this.b.requestBeginBroadcast(GProConvert.a(paramString1), GProConvert.a(paramString2), GProConvert.a(paramString3), new GProSdkWrapperImpl.67(this, i, paramIResultCallback));
  }
  
  public void a(String paramString1, String paramString2, String paramString3, ISetChannelNameCallback paramISetChannelNameCallback)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(" channelUin ： ");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append("， name ： ");
    ((StringBuilder)localObject).append(paramString3);
    localObject = ((StringBuilder)localObject).toString();
    int i = a;
    a = i + 1;
    i = GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper interface", "setChannelName", "ui", (String)localObject, i);
    this.b.setChannelName(GProConvert.a(paramString1), GProConvert.a(paramString2), paramString3, new GProSdkWrapperImpl.17(this, i, paramISetChannelNameCallback));
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, IResultCallback paramIResultCallback)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("guildId ：");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(", channelId:");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append(", roomId:");
    ((StringBuilder)localObject).append(paramString3);
    ((StringBuilder)localObject).append(", bannedUser:");
    ((StringBuilder)localObject).append(paramString4);
    ((StringBuilder)localObject).append(", operateType:");
    ((StringBuilder)localObject).append(paramInt);
    localObject = ((StringBuilder)localObject).toString();
    int i = a;
    a = i + 1;
    i = GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper interface", "setLiveChannelBannedUser", "", (String)localObject, i);
    this.b.setLiveChannelBannedUser(GProConvert.a(paramString1), GProConvert.a(paramString2), GProConvert.a(paramString3), GProConvert.a(paramString4), paramInt, new GProSdkWrapperImpl.70(this, i, paramIResultCallback));
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("guildId ：");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(", tinyId:");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append(", name: ");
    ((StringBuilder)localObject).append(paramString3);
    localObject = ((StringBuilder)localObject).toString();
    int i = a;
    a = i + 1;
    GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper interface", "setMemberNameForMsg", "", (String)localObject, i);
    this.b.setMemberNameForMsg(GProConvert.a(paramString1), GProConvert.a(paramString2), paramString3, paramString4, paramLong);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, IResultCallback paramIResultCallback)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("guildId ：");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append("， tinyId ： ");
    ((StringBuilder)localObject).append(paramString3);
    ((StringBuilder)localObject).append("， bMute ： ");
    ((StringBuilder)localObject).append(paramBoolean);
    localObject = ((StringBuilder)localObject).toString();
    int i = a;
    a = i + 1;
    i = GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper interface", "setUserMuteSeatInGuild", "", (String)localObject, i);
    this.b.setUserMuteSeatInGuild(GProConvert.a(paramString1), GProConvert.a(paramString2), GProConvert.a(paramString3), paramBoolean, new GProSdkWrapperImpl.43(this, i, paramIResultCallback));
  }
  
  public void a(String paramString1, String paramString2, ArrayList<String> paramArrayList, IKickChannelMemberCallback paramIKickChannelMemberCallback)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("guildId ：");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append("， channelId ： ");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append("tinyIdLst:");
    ((StringBuilder)localObject).append(paramArrayList);
    localObject = ((StringBuilder)localObject).toString();
    int i = a;
    a = i + 1;
    i = GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper interface", "exitAudioChannel", "", (String)localObject, i);
    this.b.kickAudioChannelUsers(GProConvert.a(paramString1), GProConvert.a(paramString2), GProConvert.a(paramArrayList), new GProSdkWrapperImpl.39(this, i, paramIKickChannelMemberCallback));
  }
  
  public void a(String paramString1, String paramString2, List<String> paramList, IFetchVisibleMemberListByTinyIdCallback paramIFetchVisibleMemberListByTinyIdCallback)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("channelId: ");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append(", tinyIdList: ");
    ((StringBuilder)localObject).append(paramList.size());
    localObject = ((StringBuilder)localObject).toString();
    int i = a;
    a = i + 1;
    i = GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchVisibleMemberListByTinyId", "call", (String)localObject, i);
    long l1 = GProConvert.a(paramString1);
    long l2 = GProConvert.a(paramString2);
    paramString1 = GProConvert.a(paramList);
    this.b.fetchVisibleMemberListByTinyId(l1, l2, paramString1, new GProSdkWrapperImpl.26(this, i, paramIFetchVisibleMemberListByTinyIdCallback));
  }
  
  public void a(String paramString1, String paramString2, List<String> paramList1, List<String> paramList2, IResultCallback paramIResultCallback)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("guildId ：");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(", channelId:");
    ((StringBuilder)localObject).append(paramString2);
    localObject = ((StringBuilder)localObject).toString();
    int i = a;
    a = i + 1;
    i = GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper interface", "setLiveChannelAnchorList", "", (String)localObject, i);
    this.b.setLiveChannelAnchorList(GProConvert.a(paramString1), GProConvert.a(paramString2), GProConvert.a(paramList1), GProConvert.a(paramList2), new GProSdkWrapperImpl.64(this, i, paramIResultCallback));
  }
  
  protected void a(String paramString1, String paramString2, @Nullable List<String> paramList1, @Nullable List<String> paramList2, IResultWithSecurityCallback paramIResultWithSecurityCallback)
  {
    long l1 = GProConvert.a(paramString1);
    long l2 = GProConvert.a(paramString2);
    paramString1 = GProConvert.a(paramList1);
    paramList1 = GProConvert.a(paramList2);
    paramList2 = new StringBuilder();
    paramList2.append("channelUin: ");
    paramList2.append(paramString2);
    paramList2.append(", add: ");
    paramList2.append(paramString1.size());
    paramList2.append(", remove: ");
    paramList2.append(paramList1.size());
    paramString2 = paramList2.toString();
    int i = a;
    a = i + 1;
    i = GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper interface", "setChannelVisibleMembers", "call", paramString2, i);
    this.b.setChannelVisibleMembers(l1, l2, paramString1, paramList1, new GProSdkWrapperImpl.22(this, i, paramIResultWithSecurityCallback));
  }
  
  protected void a(String paramString1, String paramString2, boolean paramBoolean, IResultWithSecurityCallback paramIResultWithSecurityCallback)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("guildId ： ");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append("， userTinyId ： ");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append("，isAdmin ： ");
    ((StringBuilder)localObject).append(paramBoolean);
    localObject = ((StringBuilder)localObject).toString();
    int i = a;
    a = i + 1;
    i = GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper interface", "setGuildAdmin", "ui", (String)localObject, i);
    this.b.setGuildAdmin(GProConvert.a(paramString1), GProConvert.a(paramString2), paramBoolean, new GProSdkWrapperImpl.28(this, i, paramIResultWithSecurityCallback));
  }
  
  public void a(String paramString, ArrayList<Long> paramArrayList, IGetChannelCategoryWithListCallback paramIGetChannelCategoryWithListCallback)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("guildId ：");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("， categoryList ： ");
    ((StringBuilder)localObject).append(paramArrayList);
    localObject = ((StringBuilder)localObject).toString();
    int i = a;
    a = i + 1;
    i = GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper interface", "setChannelCategoryOrderWithId", "", (String)localObject, i);
    this.b.setChannelCategoryOrderWithId(GProConvert.a(paramString), paramArrayList, new GProSdkWrapperImpl.49(this, i, paramIGetChannelCategoryWithListCallback));
  }
  
  public void a(String paramString, List<String> paramList, IFetchLiveRoomInfoCallback paramIFetchLiveRoomInfoCallback)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("guildId ：");
    ((StringBuilder)localObject).append(paramString);
    localObject = ((StringBuilder)localObject).toString();
    int i = a;
    a = i + 1;
    i = GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchLiveRoomInfoByChannelIds", "", (String)localObject, i);
    this.b.fetchLiveRoomInfoByChannelIds(GProConvert.a(paramString), GProConvert.a(paramList), new GProSdkWrapperImpl.69(this, i, paramIFetchLiveRoomInfoCallback));
  }
  
  public void a(String paramString, List<String> paramList, IGetGProUserCallback paramIGetGProUserCallback)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("guildId ：");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("， tinydList ： ");
    ((StringBuilder)localObject).append(paramList);
    localObject = ((StringBuilder)localObject).toString();
    int i = a;
    a = i + 1;
    i = GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper interface", "loadUserInfo", "ui-for fetchUserInfo", (String)localObject, i);
    this.b.loadUserInfo(GProConvert.a(paramString), GProConvert.a(paramList), new GProSdkWrapperImpl.3(this, i, paramIGetGProUserCallback));
  }
  
  public void a(String paramString, List<String> paramList, boolean paramBoolean, IGProFetchAudioChannelUserListCallback paramIGProFetchAudioChannelUserListCallback)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("guildId ：");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(", audioChannelIds ： ");
    ((StringBuilder)localObject).append(paramList);
    ((StringBuilder)localObject).append(", bForce ： ");
    ((StringBuilder)localObject).append(paramBoolean);
    localObject = ((StringBuilder)localObject).toString();
    int i = a;
    a = i + 1;
    i = GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper interface", "tryRrefreshAllAudioChannelSimpleInfo", "", (String)localObject, i);
    this.b.batchFetchAudioChannelSimpleUserList(GProConvert.a(paramString), GProConvert.a(paramList), paramBoolean, new GProSdkWrapperImpl.36(this, paramString, i, paramIGProFetchAudioChannelUserListCallback));
  }
  
  public void a(String paramString, List<String> paramList, boolean paramBoolean, IResultWithSecurityCallback paramIResultWithSecurityCallback)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(" guildId ： ");
    ((StringBuilder)localObject).append(paramString);
    localObject = ((StringBuilder)localObject).toString();
    int i = a;
    a = i + 1;
    i = GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper interface", "ui-kick other", "", (String)localObject, i);
    this.b.kickGuildUser(GProConvert.a(paramString), GProConvert.a(paramList), paramBoolean, new GProSdkWrapperImpl.11(this, i, paramIResultWithSecurityCallback));
  }
  
  public void a(String paramString, boolean paramBoolean, IResultCallback paramIResultCallback)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("tinyId ：");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("， bVoiceless ： ");
    ((StringBuilder)localObject).append(paramBoolean);
    localObject = ((StringBuilder)localObject).toString();
    int i = a;
    a = i + 1;
    i = GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper interface", "setUserVoicelessToMe", "", (String)localObject, i);
    this.b.setUserVoicelessToMe(GProConvert.a(paramString), paramBoolean, new GProSdkWrapperImpl.42(this, i, paramIResultCallback));
  }
  
  public void a(String paramString, boolean paramBoolean, ISetGuildTopCallback paramISetGuildTopCallback)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(" guildId ： ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("， isTop ： ");
    ((StringBuilder)localObject).append(paramBoolean);
    localObject = ((StringBuilder)localObject).toString();
    int i = a;
    a = i + 1;
    i = GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper interface", "setGuildTop", "ui", (String)localObject, i);
    this.b.setGuildTop(GProConvert.a(paramString), paramBoolean, new GProSdkWrapperImpl.14(this, i, paramISetGuildTopCallback));
  }
  
  public void a(String paramString, boolean paramBoolean, ISwitchPresenceArchiveCallback paramISwitchPresenceArchiveCallback)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("clientId: ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(", showPresence: ");
    ((StringBuilder)localObject).append(paramBoolean);
    localObject = ((StringBuilder)localObject).toString();
    int i = a;
    a = i + 1;
    i = GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper interface", "setShowPresence", "", (String)localObject, i);
    this.b.setShowPresence(GProConvert.b(paramString), paramBoolean, new GProSdkWrapperImpl.85(this, i, paramISwitchPresenceArchiveCallback));
  }
  
  public void a(ArrayList<String> paramArrayList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("tinyIds ：");
    localStringBuilder.append(paramArrayList);
    GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper interface", "getGuildUsersNick", "", localStringBuilder.toString());
    this.b.getGuildUsersNick(GProConvert.a(paramArrayList));
  }
  
  protected void a(List<GuildMsgNode> paramList, int paramInt, ILoadGuildAndChnListCallback paramILoadGuildAndChnListCallback)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("udcflag ：");
    ((StringBuilder)localObject).append(paramInt);
    localObject = ((StringBuilder)localObject).toString();
    int i = a;
    a = i + 1;
    paramList = new GProSdkWrapperImpl.32(this, GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper interface", "initGuildAndChannelListWithId", "sdk-init", (String)localObject, i), paramILoadGuildAndChnListCallback, paramList);
    if (paramInt == 1)
    {
      this.b.initGuildAndChannelListWithId(paramList);
      return;
    }
    this.b.loadGuildAndChannelListWithId(paramList);
  }
  
  public void a(List<String> paramList, IFetchLiveRoomInfoCallback paramIFetchLiveRoomInfoCallback)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("roomIdList size ：");
    ((StringBuilder)localObject).append(paramList.size());
    localObject = ((StringBuilder)localObject).toString();
    int i = a;
    a = i + 1;
    i = GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchLiveRoomInfoByRoomIds", "", (String)localObject, i);
    this.b.fetchLiveRoomInfoByRoomIds(GProConvert.a(paramList), new GProSdkWrapperImpl.68(this, i, paramIFetchLiveRoomInfoCallback));
  }
  
  public void a(List<String> paramList, IQueryTinyIdByLiveUIDCallback paramIQueryTinyIdByLiveUIDCallback)
  {
    int i = a;
    a = i + 1;
    i = GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper interface", "queryTinyIdByLiveUID", "", i);
    this.b.queryTinyIdByLiveUID(GProConvert.a(paramList), new GProSdkWrapperImpl.76(this, i, paramIQueryTinyIdByLiveUIDCallback));
  }
  
  public void a(List<FocusChannelReqInfo> paramList, IResultCallback paramIResultCallback)
  {
    Object localObject;
    if (paramList != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reqInfos size :");
      ((StringBuilder)localObject).append(paramList.size());
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = "";
    }
    int i = a;
    a = i + 1;
    i = GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper interface", "setFocusChannel", "", (String)localObject, i);
    this.b.setFocusChannel(GProConvert.j(paramList), new GProSdkWrapperImpl.88(this, i, paramIResultCallback));
  }
  
  public void a(List<AppChnnPreFetchInfo> paramList, boolean paramBoolean, IFetchAppChnnPreInfoListCallback paramIFetchAppChnnPreInfoListCallback)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("list size:");
    ((StringBuilder)localObject).append(paramList.size());
    localObject = ((StringBuilder)localObject).toString();
    int i = a;
    a = i + 1;
    i = GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchAppChnnPreInfoList", "", (String)localObject, i);
    this.b.fetchAppChnnPreInfoList(GProConvert.k(paramList), paramBoolean, new GProSdkWrapperImpl.79(this, i, paramIFetchAppChnnPreInfoListCallback));
  }
  
  protected void a(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" isForce ： ");
    localStringBuilder.append(paramBoolean);
    GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper interface", "refreshGuildList", "", localStringBuilder.toString());
    this.b.refreshGuildList(paramBoolean);
    if (paramBoolean) {
      this.b.setOnLogin();
    }
  }
  
  public void a(boolean paramBoolean, IInitGetNoticeListCallback paramIInitGetNoticeListCallback)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("forceRefresh ：");
    ((StringBuilder)localObject).append(paramBoolean);
    localObject = ((StringBuilder)localObject).toString();
    int i = a;
    a = i + 1;
    i = GProLog.b("GProSdkWrapperImpl", true, "sdkWrapper interface", "initGetNoticeList", "ui", (String)localObject, i);
    this.b.initGetNoticeList(paramBoolean, new GProSdkWrapperImpl.59(this, i, paramIInitGetNoticeListCallback));
  }
  
  public void b(String paramString, IResultWithSecurityCallback paramIResultWithSecurityCallback)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("guildId ：");
    ((StringBuilder)localObject).append(paramString);
    localObject = ((StringBuilder)localObject).toString();
    int i = a;
    a = i + 1;
    i = GProLog.b("GProSdkWrapperImpl", true, "sdkWrapper interface", "queryApplyAddGuildStatus", "ui", (String)localObject, i);
    this.b.queryApplyAddGuildStatus(GProConvert.a(paramString), new GProSdkWrapperImpl.58(this, i, paramIResultWithSecurityCallback));
  }
  
  public void b(String paramString1, String paramString2, int paramInt, IResultWithSecurityCallback paramIResultWithSecurityCallback)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("guildId ：");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append("， channelId ： ");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append("limit:");
    ((StringBuilder)localObject).append(paramInt);
    localObject = ((StringBuilder)localObject).toString();
    int i = a;
    a = i + 1;
    i = GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper interface", "exitAudioChannel", "", (String)localObject, i);
    this.b.setAudioChannelUserLimit(GProConvert.a(paramString1), GProConvert.a(paramString2), paramInt, new GProSdkWrapperImpl.41(this, i, paramIResultWithSecurityCallback));
  }
  
  public void b(String paramString1, String paramString2, IResultWithSecurityCallback paramIResultWithSecurityCallback)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("guildId ：");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append("， channelId ： ");
    ((StringBuilder)localObject).append(paramString2);
    localObject = ((StringBuilder)localObject).toString();
    int i = a;
    a = i + 1;
    i = GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper interface", "exitAudioChannel", "", (String)localObject, i);
    this.b.exitAudioChannel(GProConvert.a(paramString1), GProConvert.a(paramString2), new GProSdkWrapperImpl.35(this, paramString1, paramString2, i, paramIResultWithSecurityCallback));
  }
  
  protected void b(String paramString, List<String> paramList, IGetGProUserCallback paramIGetGProUserCallback)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("guildId ：");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("， tinydList ： ");
    ((StringBuilder)localObject).append(paramList);
    localObject = ((StringBuilder)localObject).toString();
    int i = a;
    a = i + 1;
    i = GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchUserInfo", "ui-after loadUserInfo", (String)localObject, i);
    this.b.fetchUserInfo(GProConvert.a(paramString), GProConvert.a(paramList), new GProSdkWrapperImpl.4(this, i, paramIGetGProUserCallback));
  }
  
  public void b(String paramString, boolean paramBoolean, ISwitchPresenceArchiveCallback paramISwitchPresenceArchiveCallback)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("clientId: ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(", showArchive: ");
    ((StringBuilder)localObject).append(paramBoolean);
    localObject = ((StringBuilder)localObject).toString();
    int i = a;
    a = i + 1;
    i = GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper interface", "setShowArchive", "", (String)localObject, i);
    this.b.setShowArchive(GProConvert.b(paramString), paramBoolean, new GProSdkWrapperImpl.86(this, i, paramISwitchPresenceArchiveCallback));
  }
  
  public void b(ArrayList<String> paramArrayList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("tinyIds ：");
    localStringBuilder.append(paramArrayList);
    GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper interface", "getGuildUserAvatarUrl", "", localStringBuilder.toString());
    this.b.getGuildUserAvatarUrl(GProConvert.a(paramArrayList));
  }
  
  public void c(String paramString1, String paramString2, IResultWithSecurityCallback paramIResultWithSecurityCallback)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("guildId ：");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(", memberName:");
    ((StringBuilder)localObject).append(paramString2);
    localObject = ((StringBuilder)localObject).toString();
    int i = a;
    a = i + 1;
    i = GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper interface", "setGuildMemberName", "", (String)localObject, i);
    this.b.setGuildMemberName(GProConvert.a(paramString1), paramString2, new GProSdkWrapperImpl.55(this, i, paramIResultWithSecurityCallback));
  }
  
  public void c(String paramString1, String paramString2, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" channelId ：");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(" isForce ： ");
    localStringBuilder.append(paramBoolean);
    GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper interface", "refreshChannelInfo", "", localStringBuilder.toString());
    this.b.refreshChannelInfo(GProConvert.a(paramString1), GProConvert.a(paramString2), paramBoolean);
  }
  
  public void d(String paramString1, String paramString2, IResultWithSecurityCallback paramIResultWithSecurityCallback)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("guildId ：");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(", profile:");
    ((StringBuilder)localObject).append(paramString2);
    localObject = ((StringBuilder)localObject).toString();
    int i = a;
    a = i + 1;
    i = GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchGuestGuild", "", (String)localObject, i);
    this.b.setGuildProfile(GProConvert.a(paramString1), paramString2, new GProSdkWrapperImpl.54(this, i, paramIResultWithSecurityCallback));
  }
  
  public void d(String paramString1, String paramString2, List<String> paramList)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("guildId:");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(", clientId:");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append(", tinyIds:");
    ((StringBuilder)localObject).append(paramList);
    localObject = ((StringBuilder)localObject).toString();
    int i = a;
    a = i + 1;
    GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper interface", "getGuildMemberClientIdentityByWrapper", "", (String)localObject, i);
    this.b.getGuildMemberClientIdentity(GProConvert.a(paramString1), GProConvert.b(paramString2), GProConvert.a(paramList));
  }
  
  public void d(String paramString, List<String> paramList)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("guildId ：");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(", tinyIds:");
    ((StringBuilder)localObject).append(paramList);
    localObject = ((StringBuilder)localObject).toString();
    int i = a;
    a = i + 1;
    GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper interface", "getGuildMemberNameByWrapper", "", (String)localObject, i);
    this.b.getGuildMemberName(GProConvert.a(paramString), GProConvert.a(paramList));
  }
  
  public void f(String paramString, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("guildId ：");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" isForce ： ");
    localStringBuilder.append(paramBoolean);
    GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper interface", "refreshGuildInfo", "", localStringBuilder.toString());
    this.b.refreshGuildInfo(GProConvert.a(paramString), paramBoolean);
  }
  
  public void i(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("guildId ：");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("， tinyId ： ");
    localStringBuilder.append(paramString2);
    GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper interface", "refreshGuildUserProfileInfo", "", localStringBuilder.toString());
    this.b.refreshGuildUserProfileInfo(GProConvert.a(paramString1), GProConvert.a(paramString2));
  }
  
  public String m()
  {
    return this.d;
  }
  
  public void n()
  {
    GProLog.b("sdkWrapper interface", false, "stopSdkWrapper", "close sdk service");
    IGProSdkWrapper localIGProSdkWrapper = this.b;
    if (localIGProSdkWrapper != null) {
      localIGProSdkWrapper.close();
    }
  }
  
  public void s(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("tinyId : ");
    localStringBuilder.append(paramString);
    GProLog.a("GProSdkWrapperImpl", false, "sdkWrapper interface", "setSelfTinyId", "set", localStringBuilder.toString());
    this.b.setSelfTinyId(GProConvert.a(paramString));
    this.d = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl
 * JD-Core Version:    0.7.0.1
 */