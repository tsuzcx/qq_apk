package com.tencent.mobileqq.cmshow.engine.resource;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.game.utils.ApolloGameBasicEventUtil.NotifyDressReady;
import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.apollo.model.ApolloBaseInfo;
import com.tencent.mobileqq.apollo.model.ApolloPreDownloadData;
import com.tencent.mobileqq.apollo.utils.IResDownloadListener;
import com.tencent.mobileqq.app.QQAppInterface;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/cmshow/engine/resource/IApolloResManager;", "", "apolloResDownloader", "Lcom/tencent/mobileqq/cmshow/engine/resource/IApolloResDownloader;", "getApolloResDownloader", "()Lcom/tencent/mobileqq/cmshow/engine/resource/IApolloResDownloader;", "resDownloadListener", "Lcom/tencent/mobileqq/cmshow/engine/resource/IApolloResDownloader$OnApolloDownLoadListener;", "getResDownloadListener", "()Lcom/tencent/mobileqq/cmshow/engine/resource/IApolloResDownloader$OnApolloDownLoadListener;", "addDownLoadListener", "", "listener", "Lcom/tencent/mobileqq/apollo/utils/IResDownloadListener;", "check3DFaceRes", "", "faceData", "", "checkApolloPanelJsonCfg", "forceDownload", "from", "task", "", "checkBasicActionExist", "app", "Lcom/tencent/mobileqq/app/QQAppInterface;", "checkCompat2DActionRsc", "checkDressRes", "id", "checkDressRsc", "uin", "roleId", "dressId", "", "dressReadyLis", "Lcom/tencent/mobileqq/apollo/game/utils/ApolloGameBasicEventUtil$NotifyDressReady;", "checkPanelActionRes", "packageId", "isFavTab", "checkResForGuidePanel", "checkRoleDress", "targetModel", "checkRoleRes", "checkThreeDressRsc", "threeRoleId", "threeDressId", "checkThreeFaceRsc", "faceDataDownloadListener", "Lcom/tencent/mobileqq/cmshow/engine/resource/IApolloResDownloader$OnFaceDataDownloadListener;", "checkUpdateActionRes", "serverId", "serverVersion", "", "localArray", "Lorg/json/JSONArray;", "checkUserDress", "Lcom/tencent/common/app/AppInterface;", "downloadActionIfNotExist", "action", "Lcom/tencent/mobileqq/apollo/model/ApolloActionData;", "tasks", "downloadIfActionNotExist", "rscType", "actionId", "actionType", "aioType", "subType", "extendJson", "msgId", "downloadIfDressNotExist", "openId", "deafaultRole", "cmd", "downloadJson", "jsonType", "downloadResAndPanel", "needDownload", "", "key", "getApolloDrawerPath", "getApolloDrawerUrl", "getApolloDressInfo", "qqAppInterface", "Lmqq/app/AppRuntime;", "dressList", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/cmshow/engine/resource/IApolloResManager$ApolloDressInfoListener;", "getApolloFileDir", "dirType", "getApolloResLocalTimestamp", "resType", "getApolloResPath", "opTypeZipPath", "getApolloRoleInfo", "appRuntime", "Lcom/tencent/mobileqq/cmshow/engine/resource/IApolloResManager$ApolloRoleInfoListener;", "getApolloUserDressInfo", "requestUin", "Lcom/tencent/mobileqq/cmshow/engine/resource/IApolloResManager$ApolloUserDressInfoListener;", "getAudioFilePath", "getDressPath", "getFaceJsonFilePath", "dir", "getFaceJsonFilePathByUrl", "url", "getPanelPicPath", "getRealResDir", "resTypeAction", "getRealResUrl", "resId", "getResAbsolutePath", "name", "type", "getResFile", "Ljava/io/File;", "handlePushUpdateBaseRes", "appId", "newVersion", "handlePushUpdateDressRes", "handlePushUpdatePanelJsonCfg", "handlePushUpdateRoleRes", "handleResDownloaded", "hasSound", "isActionDone", "isActionPanelFrameResDone", "personNum", "isActionResDone", "isCMSPanelPicExists", "isRandomSubActionDone", "isPeer", "subActionId", "isDivisionPlatform", "isResExist", "isResourceDone", "isRscValid", "loadListener", "isSpecialActionResDone", "resTypeDrawer", "isWhiteFaceActionRscDone", "isGroup", "notifyJsonDone", "onCreate", "onDestroy", "parseActionPanelJSon", "readRoleBubbleTips", "removeAllListener", "removeDownLoadListener", "saveApolloResLocalTimestamp", "ts", "updateAndDownloadPreRes", "preDownloadDataMapNew", "", "Lcom/tencent/mobileqq/apollo/model/ApolloPreDownloadData;", "updateUserDress", "apolloBaseInfos", "Lcom/tencent/mobileqq/apollo/model/ApolloBaseInfo;", "ApolloDressInfoListener", "ApolloRoleInfoListener", "ApolloUserDressInfoListener", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public abstract interface IApolloResManager
{
  @NotNull
  public abstract IApolloResDownloader a();
  
  @Nullable
  public abstract String a(int paramInt1, int paramInt2);
  
  @Nullable
  public abstract String a(@Nullable ApolloActionData paramApolloActionData, int paramInt);
  
  @Nullable
  public abstract String a(@Nullable String paramString1, @Nullable String paramString2);
  
  public abstract void a(int paramInt1, int paramInt2, @Nullable String paramString);
  
  public abstract void a(int paramInt, long paramLong, @Nullable JSONArray paramJSONArray);
  
  public abstract void a(int paramInt, boolean paramBoolean);
  
  public abstract void a(@Nullable AppInterface paramAppInterface, @Nullable String paramString1, @Nullable String paramString2);
  
  public abstract void a(@Nullable IResDownloadListener paramIResDownloadListener);
  
  public abstract void a(@Nullable QQAppInterface paramQQAppInterface, @Nullable String paramString, @Nullable IApolloResDownloader.OnFaceDataDownloadListener paramOnFaceDataDownloadListener);
  
  public abstract void a(@NotNull QQAppInterface paramQQAppInterface, @Nullable String paramString1, @Nullable String paramString2, int paramInt, @Nullable String paramString3, @Nullable ApolloGameBasicEventUtil.NotifyDressReady paramNotifyDressReady);
  
  public abstract void a(@Nullable String paramString, @NotNull IApolloResManager.ApolloUserDressInfoListener paramApolloUserDressInfoListener);
  
  public abstract void a(@Nullable List<ApolloBaseInfo> paramList);
  
  public abstract void a(@Nullable List<ApolloActionData> paramList, @Nullable String paramString);
  
  public abstract void a(@Nullable Map<String, ApolloPreDownloadData> paramMap);
  
  public abstract void a(@Nullable AppRuntime paramAppRuntime);
  
  public abstract void a(@Nullable AppRuntime paramAppRuntime, int paramInt1, int paramInt2);
  
  public abstract void a(@Nullable AppRuntime paramAppRuntime, int paramInt, @Nullable IApolloResManager.ApolloRoleInfoListener paramApolloRoleInfoListener);
  
  public abstract void a(@NotNull AppRuntime paramAppRuntime, @Nullable ArrayList<Integer> paramArrayList, @NotNull IApolloResManager.ApolloDressInfoListener paramApolloDressInfoListener);
  
  public abstract void a(boolean paramBoolean, @Nullable String paramString, int paramInt);
  
  public abstract boolean a(int paramInt);
  
  public abstract boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, @Nullable String paramString, long paramLong);
  
  public abstract boolean a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean);
  
  public abstract boolean a(int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2);
  
  public abstract boolean a(@Nullable ApolloActionData paramApolloActionData);
  
  public abstract boolean a(@Nullable ApolloActionData paramApolloActionData, int paramInt, @Nullable IResDownloadListener paramIResDownloadListener);
  
  public abstract boolean a(@NotNull QQAppInterface paramQQAppInterface);
  
  public abstract boolean a(@Nullable String paramString);
  
  public abstract boolean a(@NotNull String paramString, int paramInt, @Nullable QQAppInterface paramQQAppInterface, @Nullable IApolloResDownloader.OnApolloDownLoadListener paramOnApolloDownLoadListener);
  
  public abstract boolean a(@Nullable String paramString, int paramInt, @NotNull int[] paramArrayOfInt, @Nullable AppRuntime paramAppRuntime);
  
  public abstract boolean a(@Nullable String paramString, int paramInt, @NotNull int[] paramArrayOfInt, @Nullable AppRuntime paramAppRuntime, @Nullable IApolloResDownloader.OnApolloDownLoadListener paramOnApolloDownLoadListener);
  
  @Nullable
  public abstract File b(@Nullable ApolloActionData paramApolloActionData, int paramInt);
  
  @Nullable
  public abstract String b(@Nullable ApolloActionData paramApolloActionData);
  
  @Nullable
  public abstract String b(@Nullable String paramString);
  
  public abstract void b();
  
  public abstract void b(int paramInt1, int paramInt2, @Nullable String paramString);
  
  public abstract void b(@Nullable IResDownloadListener paramIResDownloadListener);
  
  public abstract void b(@Nullable QQAppInterface paramQQAppInterface, @Nullable String paramString, int paramInt, @Nullable int[] paramArrayOfInt, @Nullable ApolloGameBasicEventUtil.NotifyDressReady paramNotifyDressReady);
  
  public abstract boolean b(int paramInt);
  
  public abstract boolean b(int paramInt1, int paramInt2);
  
  @Nullable
  public abstract String c(int paramInt);
  
  @Nullable
  public abstract String c(@Nullable String paramString);
  
  public abstract void c(int paramInt1, int paramInt2, @Nullable String paramString);
  
  public abstract void c(@Nullable QQAppInterface paramQQAppInterface, @Nullable String paramString, int paramInt, @Nullable int[] paramArrayOfInt, @Nullable ApolloGameBasicEventUtil.NotifyDressReady paramNotifyDressReady);
  
  public abstract boolean c();
  
  public abstract boolean c(int paramInt1, int paramInt2);
  
  public abstract boolean c(@NotNull ApolloActionData paramApolloActionData);
  
  public abstract boolean c(@NotNull ApolloActionData paramApolloActionData, int paramInt);
  
  @Nullable
  public abstract String d(int paramInt);
  
  @Nullable
  public abstract String d(int paramInt1, int paramInt2);
  
  public abstract void d();
  
  public abstract void d(int paramInt1, int paramInt2, @Nullable String paramString);
  
  @Nullable
  public abstract String e(int paramInt);
  
  public abstract void e();
  
  public abstract boolean e(int paramInt1, int paramInt2);
  
  @Nullable
  public abstract String f(int paramInt);
  
  public abstract void f();
  
  public abstract boolean f(int paramInt1, int paramInt2);
  
  public abstract long g(int paramInt1, int paramInt2);
  
  @Nullable
  public abstract IApolloResDownloader.OnApolloDownLoadListener g();
  
  public abstract boolean g(int paramInt);
  
  @Nullable
  public abstract String h(int paramInt);
  
  @Nullable
  public abstract String i(int paramInt);
  
  public abstract void j(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.engine.resource.IApolloResManager
 * JD-Core Version:    0.7.0.1
 */