package com.tencent.mobileqq.emoticonview.ipc.proxy;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Pair;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.EmoticonTab;
import com.tencent.mobileqq.data.PromotionEmoticonPkg;
import com.tencent.mobileqq.data.VipIPSiteInfo;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.QueryCallback;
import com.tencent.mobileqq.emoticonview.QueryTask;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class EmoticonManagerServiceProxy
  extends AbsEmoRuntimeServiceProxy<IEmoticonManagerService>
{
  public static final String ACTION_EMOTICONMANAGER_GETMAGICEMOTICONINFOLIST = "emoticonmanager_getmagicemoticoninfolist";
  public static final String ACTION_EMOTICONMANAGER_GETPROEMOTICONPKGS = "emoticonmanager_getproemoticonpkgs";
  public static final String ACTION_EMOTICONMANAGER_IPSITEINFOFROMBYTES = "emoticonmanager_ipsiteinfofrombytes";
  public static final String ACTION_EMOTICONMANAGER_ISSHOWRECOMMENDTABREDPOINT = "emoticonmanager_isshowrecommendtabredpoint";
  public static final String ACTION_EMOTICONMANAGER_PUSHRECOMMENDEXPOSEINFOTOSP = "emoticonmanager_pushrecommendexposeinfotosp";
  public static final String ACTION_EMOTICONMANAGER_RECORDRECOMMENDEPEXPOSE = "emoticonmanager_recordrecommendepexpose";
  public static final String ACTION_EMOTICONMANAGER_SAVEEMOTICONPACKAGE = "emoticonmanager_saveemoticonpackage";
  public static final String ACTION_EMOTICONMANAGER_SETRECOMMENDEPREDFLAG = "emoticonmanager_setrecommendepredflag";
  public static final String ACTION_EMOTICONMANAGER_SYNCFINDEMOTICONPACKAGE = "emoticonmanager_syncfindemoticonpackage";
  public static final String IPSITEINFOBYTES = "ipSiteInfoBytes";
  public static final String PARAM_BUSINESSIDAIO = "param_businessidaio";
  public static final String PARAM_BUSINESSTYPE = "param_businesstype";
  public static final String PARAM_CLONE = "param_clone";
  public static final String PARAM_EPID = "param_epid";
  public static final String PARAM_ID = "param_id";
  public static final String PARAM_ISFROMCACHE = "param_isfromcache";
  public static final String PARAM_KANDIANBIU = "param_kandianbiu";
  public static final String PARAM_PACKAGE = "param_Package";
  public static final String REDPOINT_RESULT = "redpoint_result";
  private static final String TAG = "EmoticonManagerServiceProxy";
  public static final String VIPIPSITEINFO = "vipipsiteinfo";
  protected EntityManager em;
  
  public EmoticonManagerServiceProxy(BaseQQAppInterface paramBaseQQAppInterface, EntityManager paramEntityManager)
  {
    super(paramBaseQQAppInterface, IEmoticonManagerService.class);
    this.em = paramEntityManager;
  }
  
  public static EIPCResult checkMatch(AppRuntime paramAppRuntime, String paramString, Bundle paramBundle, int paramInt)
  {
    if ("emoticonmanager_ipsiteinfofrombytes".equals(paramString)) {
      return onGetIPSiteInfoFromBytes((BaseQQAppInterface)paramAppRuntime, paramString, paramBundle, paramInt);
    }
    if ("emoticonmanager_pushrecommendexposeinfotosp".equals(paramString)) {
      return onPushRecommendExposeInfoToSP((BaseQQAppInterface)paramAppRuntime, paramString, paramBundle, paramInt);
    }
    if ("emoticonmanager_getproemoticonpkgs".equals(paramString)) {
      return onGetProEmoticonPkgs((BaseQQAppInterface)paramAppRuntime, paramString, paramBundle, paramInt);
    }
    if ("emoticonmanager_isshowrecommendtabredpoint".equals(paramString)) {
      return onIsShowRecommendTabRedPoint((BaseQQAppInterface)paramAppRuntime, paramString, paramBundle, paramInt);
    }
    if ("emoticonmanager_saveemoticonpackage".equals(paramString)) {
      return onSaveEmoticonPackage((BaseQQAppInterface)paramAppRuntime, paramString, paramBundle, paramInt);
    }
    if ("emoticonmanager_getmagicemoticoninfolist".equals(paramString)) {
      return onGetMagicEmoticonInfoList((BaseQQAppInterface)paramAppRuntime, paramString, paramBundle, paramInt);
    }
    if ("emoticonmanager_recordrecommendepexpose".equals(paramString)) {
      return onRecordRecommendEpExpose((BaseQQAppInterface)paramAppRuntime, paramString, paramBundle, paramInt);
    }
    if ("emoticonmanager_setrecommendepredflag".equals(paramString)) {
      return onSetRecommendEpRedFlag((BaseQQAppInterface)paramAppRuntime, paramString, paramBundle, paramInt);
    }
    if ("emoticonmanager_syncfindemoticonpackage".equals(paramString)) {
      return onSyncFindEmoticonPackage((BaseQQAppInterface)paramAppRuntime, paramString, paramBundle, paramInt);
    }
    return null;
  }
  
  public static EIPCResult onGetIPSiteInfoFromBytes(BaseQQAppInterface paramBaseQQAppInterface, String paramString, Bundle paramBundle, int paramInt)
  {
    paramBaseQQAppInterface = ((IEmoticonManagerService)paramBaseQQAppInterface.getRuntimeService(IEmoticonManagerService.class)).getIPSiteInfoFromBytes(paramBundle.getByteArray("ipSiteInfoBytes"));
    paramString = new Bundle();
    paramString.putParcelable("vipipsiteinfo", paramBaseQQAppInterface);
    return EIPCResult.createSuccessResult(paramString);
  }
  
  public static EIPCResult onGetMagicEmoticonInfoList(BaseQQAppInterface paramBaseQQAppInterface, String paramString, Bundle paramBundle, int paramInt)
  {
    paramBaseQQAppInterface = ((IEmoticonManagerService)paramBaseQQAppInterface.getRuntimeService(IEmoticonManagerService.class)).getMagicEmoticonInfoList(paramBundle.getInt("param_businessidaio"));
    paramString = new Bundle();
    paramString.putParcelableArrayList("param_Package", new ArrayList(paramBaseQQAppInterface));
    return EIPCResult.createSuccessResult(paramString);
  }
  
  public static EIPCResult onGetProEmoticonPkgs(BaseQQAppInterface paramBaseQQAppInterface, String paramString, Bundle paramBundle, int paramInt)
  {
    paramString = ((IEmoticonManagerService)paramBaseQQAppInterface.getRuntimeService(IEmoticonManagerService.class)).getProEmoticonPkgs(paramBundle.getBoolean("param_isfromcache"), paramBundle.getInt("param_businesstype"), paramBundle.getBoolean("param_kandianbiu"));
    paramBaseQQAppInterface = paramString;
    if (paramString == null) {
      paramBaseQQAppInterface = new ArrayList();
    }
    paramString = new Bundle();
    paramString.putParcelableArrayList("param_Package", new ArrayList(paramBaseQQAppInterface));
    return EIPCResult.createSuccessResult(paramString);
  }
  
  public static EIPCResult onIsShowRecommendTabRedPoint(BaseQQAppInterface paramBaseQQAppInterface, String paramString, Bundle paramBundle, int paramInt)
  {
    paramBaseQQAppInterface = (IEmoticonManagerService)paramBaseQQAppInterface.getRuntimeService(IEmoticonManagerService.class);
    paramString = new Bundle();
    paramString.putBoolean("redpoint_result", paramBaseQQAppInterface.isShowRecommendTabRedPoint(paramBundle.getInt("param_businesstype")));
    return EIPCResult.createSuccessResult(paramString);
  }
  
  public static EIPCResult onPushRecommendExposeInfoToSP(BaseQQAppInterface paramBaseQQAppInterface, String paramString, Bundle paramBundle, int paramInt)
  {
    ((IEmoticonManagerService)paramBaseQQAppInterface.getRuntimeService(IEmoticonManagerService.class)).pushRecommendExposeInfoToSP();
    return EIPCResult.createSuccessResult(null);
  }
  
  public static EIPCResult onRecordRecommendEpExpose(BaseQQAppInterface paramBaseQQAppInterface, String paramString, Bundle paramBundle, int paramInt)
  {
    ((IEmoticonManagerService)paramBaseQQAppInterface.getRuntimeService(IEmoticonManagerService.class)).recordRecommendEpExpose((PromotionEmoticonPkg)paramBundle.getParcelable("param_Package"));
    return EIPCResult.createSuccessResult(null);
  }
  
  public static EIPCResult onSaveEmoticonPackage(BaseQQAppInterface paramBaseQQAppInterface, String paramString, Bundle paramBundle, int paramInt)
  {
    ((IEmoticonManagerService)paramBaseQQAppInterface.getRuntimeService(IEmoticonManagerService.class)).saveEmoticonPackage((EmoticonPackage)paramBundle.getSerializable("param_Package"));
    return EIPCResult.createSuccessResult(null);
  }
  
  public static EIPCResult onSetRecommendEpRedFlag(BaseQQAppInterface paramBaseQQAppInterface, String paramString, Bundle paramBundle, int paramInt)
  {
    ((IEmoticonManagerService)paramBaseQQAppInterface.getRuntimeService(IEmoticonManagerService.class)).setRecommendEpRedFlag(paramBundle.getString("param_id"), paramBundle.getInt("param_businesstype"));
    return EIPCResult.createSuccessResult(null);
  }
  
  public static EIPCResult onSyncFindEmoticonPackage(BaseQQAppInterface paramBaseQQAppInterface, String paramString, Bundle paramBundle, int paramInt)
  {
    paramBaseQQAppInterface = ((IEmoticonManagerService)paramBaseQQAppInterface.getRuntimeService(IEmoticonManagerService.class)).syncFindEmoticonPackageById(paramBundle.getString("param_epid"), paramBundle.getInt("param_businesstype"));
    paramString = new Bundle();
    paramString.putSerializable("param_Package", paramBaseQQAppInterface);
    return EIPCResult.createSuccessResult(paramString);
  }
  
  public void asyncFindEmoticonPackage(String paramString, int paramInt, QueryCallback<EmoticonPackage> paramQueryCallback)
  {
    if (this.manager != null)
    {
      ((IEmoticonManagerService)this.manager).asyncFindEmoticonPackage(paramString, paramInt, paramQueryCallback);
      return;
    }
    realAsyncFindEmoticonPackage(paramString, paramInt, paramQueryCallback);
  }
  
  public VipIPSiteInfo getIPSiteInfoFromBytes(byte[] paramArrayOfByte)
  {
    if (this.manager != null) {
      return ((IEmoticonManagerService)this.manager).getIPSiteInfoFromBytes(paramArrayOfByte);
    }
    return getIPSiteInfoFromBytesOtherProcess(paramArrayOfByte);
  }
  
  public VipIPSiteInfo getIPSiteInfoFromBytesOtherProcess(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      localObject = Parcel.obtain();
      ((Parcel)localObject).unmarshall(paramArrayOfByte, 0, paramArrayOfByte.length);
      ((Parcel)localObject).setDataPosition(0);
      paramArrayOfByte = (VipIPSiteInfo)VipIPSiteInfo.CREATOR.createFromParcel((Parcel)localObject);
      ((Parcel)localObject).recycle();
      return paramArrayOfByte;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getIPSiteInfoFromBytes, error data = ");
    ((StringBuilder)localObject).append(paramArrayOfByte);
    QLog.e("EmoticonManagerServiceProxy", 1, ((StringBuilder)localObject).toString());
    return null;
  }
  
  public List<EmoticonInfo> getMagicEmoticonInfoList(int paramInt)
  {
    if (this.manager != null) {
      return ((IEmoticonManagerService)this.manager).getMagicEmoticonInfoList(paramInt);
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("param_businessidaio", paramInt);
    localObject = QIPCClientHelper.getInstance().getClient().callServer("module_emoticon_mainpanel", "emoticonmanager_getmagicemoticoninfolist", (Bundle)localObject);
    if ((localObject != null) && (((EIPCResult)localObject).isSuccess())) {
      return ((EIPCResult)localObject).data.getParcelableArrayList("param_Package");
    }
    QLog.e("EmoticonManagerServiceProxy", 4, "getMagicEmoticonInfoList fail.");
    return new ArrayList();
  }
  
  public List<PromotionEmoticonPkg> getProEmoticonPkgs(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    if (this.manager != null) {
      return ((IEmoticonManagerService)this.manager).getProEmoticonPkgs(paramBoolean1, paramInt, paramBoolean2);
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putBoolean("param_isfromcache", paramBoolean1);
    ((Bundle)localObject).putInt("param_businesstype", paramInt);
    ((Bundle)localObject).putBoolean("param_kandianbiu", paramBoolean2);
    localObject = QIPCClientHelper.getInstance().getClient().callServer("module_emoticon_mainpanel", "emoticonmanager_getproemoticonpkgs", (Bundle)localObject);
    if ((localObject != null) && (((EIPCResult)localObject).isSuccess()))
    {
      ((EIPCResult)localObject).data.setClassLoader(EmoticonPackage.class.getClassLoader());
      return ((EIPCResult)localObject).data.getParcelableArrayList("param_Package");
    }
    QLog.e("EmoticonManagerServiceProxy", 4, "getProEmoticonPkgs fail.");
    return null;
  }
  
  public boolean isShowRecommendTabRedPoint(int paramInt)
  {
    if (this.manager != null) {
      return ((IEmoticonManagerService)this.manager).isShowRecommendTabRedPoint(paramInt);
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("param_businesstype", paramInt);
    localObject = QIPCClientHelper.getInstance().getClient().callServer("module_emoticon_mainpanel", "emoticonmanager_isshowrecommendtabredpoint", (Bundle)localObject);
    if ((localObject != null) && (((EIPCResult)localObject).isSuccess())) {
      return ((EIPCResult)localObject).data.getBoolean("redpoint_result");
    }
    QLog.e("EmoticonManagerServiceProxy", 4, "isShowRecommendTabRedPoint fail.");
    return false;
  }
  
  public void pushRecommendExposeInfoToSP()
  {
    if (this.manager != null)
    {
      ((IEmoticonManagerService)this.manager).pushRecommendExposeInfoToSP();
      return;
    }
    EIPCResult localEIPCResult = QIPCClientHelper.getInstance().getClient().callServer("module_emoticon_mainpanel", "emoticonmanager_pushrecommendexposeinfotosp", null);
    if ((localEIPCResult != null) && (localEIPCResult.isSuccess()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonManagerServiceProxy", 4, "pushRecommendExposeInfoToSP suc.");
      }
    }
    else {
      QLog.e("EmoticonManagerServiceProxy", 4, "pushRecommendExposeInfoToSP fail.");
    }
  }
  
  public void realAsyncFindEmoticonPackage(String paramString, int paramInt, QueryCallback<EmoticonPackage> paramQueryCallback)
  {
    if (this.em == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonManagerServiceProxy", 4, "em is null.");
      }
      return;
    }
    new QueryTask(new EmoticonManagerServiceProxy.1(this, paramString, paramInt), paramQueryCallback).execute(new Pair(paramString, Integer.valueOf(paramInt)));
  }
  
  public List<Emoticon> realSyncGetSubEmoticonsByPackageId(String paramString, boolean paramBoolean)
  {
    Object localObject = this.em;
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonManagerServiceProxy", 4, "em is null.");
      }
      return null;
    }
    localObject = (ArrayList)((EntityManager)localObject).query(Emoticon.class, false, "epId=?", new String[] { paramString }, null, null, null, null);
    paramString = (String)localObject;
    if (localObject != null)
    {
      paramString = (String)localObject;
      if (paramBoolean) {
        paramString = (List)((ArrayList)localObject).clone();
      }
    }
    return paramString;
  }
  
  public List<EmoticonPackage> realSyncGetTabEmoticonPackages(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if (this.em == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonManagerServiceProxy", 4, "em is null.");
      }
      return null;
    }
    if ((paramInt != 1) && (paramInt != 0)) {
      return localArrayList;
    }
    Object localObject3 = (ArrayList)this.em.query(EmoticonTab.class, false, null, null, null, null, null, null);
    Object localObject1 = new ArrayList();
    Object localObject2 = new ArrayList();
    if ((localObject3 != null) && (!((ArrayList)localObject3).isEmpty()))
    {
      localObject3 = ((ArrayList)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        EmoticonTab localEmoticonTab = (EmoticonTab)((Iterator)localObject3).next();
        if (localEmoticonTab != null)
        {
          if (localEmoticonTab.aioHave) {
            ((List)localObject1).add(localEmoticonTab.epId);
          }
          if (localEmoticonTab.kandianHave) {
            ((List)localObject2).add(localEmoticonTab.epId);
          }
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("syncGetTabEmoticonPackages begins, kanDianTabCache.size:");
      ((StringBuilder)localObject3).append(((List)localObject2).size());
      ((StringBuilder)localObject3).append(" tabCache.size:");
      ((StringBuilder)localObject3).append(((List)localObject1).size());
      ((StringBuilder)localObject3).append(" businessType = ");
      ((StringBuilder)localObject3).append(paramInt);
      QLog.d("EmoticonManagerServiceProxy", 2, ((StringBuilder)localObject3).toString());
    }
    if (paramInt != 1)
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        if (localObject2 != null)
        {
          localObject2 = syncFindEmoticonPackageById((String)localObject2, paramInt);
          if (localObject2 != null) {
            localArrayList.add(localObject2);
          }
        }
      }
    }
    localObject1 = ((List)localObject2).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      if (localObject2 != null)
      {
        localObject2 = syncFindEmoticonPackageById((String)localObject2, paramInt);
        if (localObject2 != null) {
          localArrayList.add(localObject2);
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("syncGetTabEmoticonPackages ends, list.size:");
      ((StringBuilder)localObject1).append(localArrayList.size());
      QLog.d("EmoticonManagerServiceProxy", 2, ((StringBuilder)localObject1).toString());
    }
    return localArrayList;
  }
  
  public void recordRecommendEpExpose(PromotionEmoticonPkg paramPromotionEmoticonPkg)
  {
    if (this.manager != null)
    {
      ((IEmoticonManagerService)this.manager).recordRecommendEpExpose(paramPromotionEmoticonPkg);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("param_Package", paramPromotionEmoticonPkg);
    paramPromotionEmoticonPkg = QIPCClientHelper.getInstance().getClient().callServer("module_emoticon_mainpanel", "emoticonmanager_recordrecommendepexpose", localBundle);
    if ((paramPromotionEmoticonPkg != null) && (paramPromotionEmoticonPkg.isSuccess()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonManagerServiceProxy", 4, "recordRecommendEpExpose suc.");
      }
    }
    else {
      QLog.e("EmoticonManagerServiceProxy", 4, "recordRecommendEpExpose fail.");
    }
  }
  
  public void saveEmoticonPackage(EmoticonPackage paramEmoticonPackage)
  {
    if (this.manager != null)
    {
      ((IEmoticonManagerService)this.manager).saveEmoticonPackage(paramEmoticonPackage);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("param_Package", paramEmoticonPackage);
    paramEmoticonPackage = QIPCClientHelper.getInstance().getClient().callServer("module_emoticon_mainpanel", "emoticonmanager_saveemoticonpackage", localBundle);
    if ((paramEmoticonPackage != null) && (paramEmoticonPackage.isSuccess()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonManagerServiceProxy", 4, "saveEmoticonPackage suc.");
      }
    }
    else {
      QLog.e("EmoticonManagerServiceProxy", 4, "saveEmoticonPackage fail.");
    }
  }
  
  public void setRecommendEpRedFlag(String paramString, int paramInt)
  {
    if (this.manager != null)
    {
      ((IEmoticonManagerService)this.manager).setRecommendEpRedFlag(paramString, paramInt);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("param_id", paramString);
    localBundle.putInt("param_businesstype", paramInt);
    paramString = QIPCClientHelper.getInstance().getClient().callServer("module_emoticon_mainpanel", "emoticonmanager_setrecommendepredflag", localBundle);
    if ((paramString != null) && (paramString.isSuccess()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonManagerServiceProxy", 4, "setRecommendEpRedFlag suc.");
      }
    }
    else {
      QLog.e("EmoticonManagerServiceProxy", 4, "setRecommendEpRedFlag fail.");
    }
  }
  
  public EmoticonPackage syncFindEmoticonPackageById(String paramString)
  {
    if (this.manager != null) {
      return ((IEmoticonManagerService)this.manager).syncFindEmoticonPackageById(paramString);
    }
    return syncFindEmoticonPackageById(paramString, 0);
  }
  
  public EmoticonPackage syncFindEmoticonPackageById(String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("syncFindEmoticonPackageById epId = ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", type = ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("EmoticonManagerServiceProxy", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.em;
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonManagerServiceProxy", 4, "em is null.");
      }
      return null;
    }
    localObject = (EmoticonPackage)((EntityManager)localObject).find(EmoticonPackage.class, paramString);
    paramString = (String)localObject;
    if (localObject != null)
    {
      if (paramInt == -1) {
        return localObject;
      }
      if (paramInt == 0)
      {
        if (((EmoticonPackage)localObject).aio) {
          return localObject;
        }
        return null;
      }
      paramString = (String)localObject;
      if (paramInt == 1)
      {
        if (((EmoticonPackage)localObject).kandian) {
          return localObject;
        }
        paramString = null;
      }
    }
    return paramString;
  }
  
  public List<Emoticon> syncGetSubEmoticonsByPackageId(String paramString, boolean paramBoolean)
  {
    if (this.manager != null) {
      return ((IEmoticonManagerService)this.manager).syncGetSubEmoticonsByPackageId(paramString, paramBoolean);
    }
    return realSyncGetSubEmoticonsByPackageId(paramString, paramBoolean);
  }
  
  public List<EmoticonPackage> syncGetTabEmoticonPackages(int paramInt)
  {
    if (this.manager != null) {
      return ((IEmoticonManagerService)this.manager).syncGetTabEmoticonPackages(paramInt);
    }
    return realSyncGetTabEmoticonPackages(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.ipc.proxy.EmoticonManagerServiceProxy
 * JD-Core Version:    0.7.0.1
 */