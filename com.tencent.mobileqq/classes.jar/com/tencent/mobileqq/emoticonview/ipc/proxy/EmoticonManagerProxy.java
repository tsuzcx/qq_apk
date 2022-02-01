package com.tencent.mobileqq.emoticonview.ipc.proxy;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Pair;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.EmoticonTab;
import com.tencent.mobileqq.data.PromotionEmoticonPkg;
import com.tencent.mobileqq.data.VipIPSiteInfo;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.model.QueryCallback;
import com.tencent.mobileqq.model.QueryTask;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class EmoticonManagerProxy
  extends AbsManagerProxy<EmoticonManager>
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
  private static final String TAG = "EmoticonManagerProxy";
  public static final String VIPIPSITEINFO = "vipipsiteinfo";
  protected EntityManager em;
  
  public EmoticonManagerProxy(QQAppInterface paramQQAppInterface, EntityManager paramEntityManager)
  {
    super(paramQQAppInterface, QQManagerFactory.EMOTICON_MANAGER);
    this.em = paramEntityManager;
  }
  
  public static EIPCResult checkMatch(AppRuntime paramAppRuntime, String paramString, Bundle paramBundle, int paramInt)
  {
    if ("emoticonmanager_ipsiteinfofrombytes".equals(paramString)) {
      return onGetIPSiteInfoFromBytes((QQAppInterface)paramAppRuntime, paramString, paramBundle, paramInt);
    }
    if ("emoticonmanager_pushrecommendexposeinfotosp".equals(paramString)) {
      return onPushRecommendExposeInfoToSP((QQAppInterface)paramAppRuntime, paramString, paramBundle, paramInt);
    }
    if ("emoticonmanager_getproemoticonpkgs".equals(paramString)) {
      return onGetProEmoticonPkgs((QQAppInterface)paramAppRuntime, paramString, paramBundle, paramInt);
    }
    if ("emoticonmanager_isshowrecommendtabredpoint".equals(paramString)) {
      return onIsShowRecommendTabRedPoint((QQAppInterface)paramAppRuntime, paramString, paramBundle, paramInt);
    }
    if ("emoticonmanager_saveemoticonpackage".equals(paramString)) {
      return onSaveEmoticonPackage((QQAppInterface)paramAppRuntime, paramString, paramBundle, paramInt);
    }
    if ("emoticonmanager_getmagicemoticoninfolist".equals(paramString)) {
      return onGetMagicEmoticonInfoList((QQAppInterface)paramAppRuntime, paramString, paramBundle, paramInt);
    }
    if ("emoticonmanager_recordrecommendepexpose".equals(paramString)) {
      return onRecordRecommendEpExpose((QQAppInterface)paramAppRuntime, paramString, paramBundle, paramInt);
    }
    if ("emoticonmanager_setrecommendepredflag".equals(paramString)) {
      return onSetRecommendEpRedFlag((QQAppInterface)paramAppRuntime, paramString, paramBundle, paramInt);
    }
    if ("emoticonmanager_syncfindemoticonpackage".equals(paramString)) {
      return onSyncFindEmoticonPackage((QQAppInterface)paramAppRuntime, paramString, paramBundle, paramInt);
    }
    return null;
  }
  
  public static EIPCResult onGetIPSiteInfoFromBytes(QQAppInterface paramQQAppInterface, String paramString, Bundle paramBundle, int paramInt)
  {
    paramQQAppInterface = ((EmoticonManager)paramQQAppInterface.getManager(QQManagerFactory.EMOTICON_MANAGER)).a(paramBundle.getByteArray("ipSiteInfoBytes"));
    paramString = new Bundle();
    paramString.putParcelable("vipipsiteinfo", paramQQAppInterface);
    return EIPCResult.createSuccessResult(paramString);
  }
  
  public static EIPCResult onGetMagicEmoticonInfoList(QQAppInterface paramQQAppInterface, String paramString, Bundle paramBundle, int paramInt)
  {
    paramQQAppInterface = ((EmoticonManager)paramQQAppInterface.getManager(QQManagerFactory.EMOTICON_MANAGER)).b(paramBundle.getInt("param_businessidaio"));
    paramString = new Bundle();
    paramString.putParcelableArrayList("param_Package", new ArrayList(paramQQAppInterface));
    return EIPCResult.createSuccessResult(paramString);
  }
  
  public static EIPCResult onGetProEmoticonPkgs(QQAppInterface paramQQAppInterface, String paramString, Bundle paramBundle, int paramInt)
  {
    paramString = ((EmoticonManager)paramQQAppInterface.getManager(QQManagerFactory.EMOTICON_MANAGER)).a(paramBundle.getBoolean("param_isfromcache"), paramBundle.getInt("param_businesstype"), paramBundle.getBoolean("param_kandianbiu"));
    paramQQAppInterface = paramString;
    if (paramString == null) {
      paramQQAppInterface = new ArrayList();
    }
    paramString = new Bundle();
    paramString.putParcelableArrayList("param_Package", new ArrayList(paramQQAppInterface));
    return EIPCResult.createSuccessResult(paramString);
  }
  
  public static EIPCResult onIsShowRecommendTabRedPoint(QQAppInterface paramQQAppInterface, String paramString, Bundle paramBundle, int paramInt)
  {
    paramQQAppInterface = (EmoticonManager)paramQQAppInterface.getManager(QQManagerFactory.EMOTICON_MANAGER);
    paramString = new Bundle();
    paramString.putBoolean("redpoint_result", paramQQAppInterface.a(paramBundle.getInt("param_businesstype")));
    return EIPCResult.createSuccessResult(paramString);
  }
  
  public static EIPCResult onPushRecommendExposeInfoToSP(QQAppInterface paramQQAppInterface, String paramString, Bundle paramBundle, int paramInt)
  {
    ((EmoticonManager)paramQQAppInterface.getManager(QQManagerFactory.EMOTICON_MANAGER)).f();
    return EIPCResult.createSuccessResult(null);
  }
  
  public static EIPCResult onRecordRecommendEpExpose(QQAppInterface paramQQAppInterface, String paramString, Bundle paramBundle, int paramInt)
  {
    ((EmoticonManager)paramQQAppInterface.getManager(QQManagerFactory.EMOTICON_MANAGER)).a((PromotionEmoticonPkg)paramBundle.getParcelable("param_Package"));
    return EIPCResult.createSuccessResult(null);
  }
  
  public static EIPCResult onSaveEmoticonPackage(QQAppInterface paramQQAppInterface, String paramString, Bundle paramBundle, int paramInt)
  {
    ((EmoticonManager)paramQQAppInterface.getManager(QQManagerFactory.EMOTICON_MANAGER)).a((EmoticonPackage)paramBundle.getSerializable("param_Package"));
    return EIPCResult.createSuccessResult(null);
  }
  
  public static EIPCResult onSetRecommendEpRedFlag(QQAppInterface paramQQAppInterface, String paramString, Bundle paramBundle, int paramInt)
  {
    ((EmoticonManager)paramQQAppInterface.getManager(QQManagerFactory.EMOTICON_MANAGER)).i(paramBundle.getString("param_id"), paramBundle.getInt("param_businesstype"));
    return EIPCResult.createSuccessResult(null);
  }
  
  public static EIPCResult onSyncFindEmoticonPackage(QQAppInterface paramQQAppInterface, String paramString, Bundle paramBundle, int paramInt)
  {
    paramQQAppInterface = ((EmoticonManager)paramQQAppInterface.getManager(QQManagerFactory.EMOTICON_MANAGER)).a(paramBundle.getString("param_epid"), paramBundle.getInt("param_businesstype"));
    paramString = new Bundle();
    paramString.putSerializable("param_Package", paramQQAppInterface);
    return EIPCResult.createSuccessResult(paramString);
  }
  
  public void asyncFindEmoticonPackage(String paramString, int paramInt, QueryCallback<EmoticonPackage> paramQueryCallback)
  {
    if (this.manager != null)
    {
      ((EmoticonManager)this.manager).a(paramString, paramInt, paramQueryCallback);
      return;
    }
    realAsyncFindEmoticonPackage(paramString, paramInt, paramQueryCallback);
  }
  
  public VipIPSiteInfo getIPSiteInfoFromBytes(byte[] paramArrayOfByte)
  {
    if (this.manager != null) {
      return ((EmoticonManager)this.manager).a(paramArrayOfByte);
    }
    return getIPSiteInfoFromBytesOtherProcess(paramArrayOfByte);
  }
  
  public VipIPSiteInfo getIPSiteInfoFromBytesOtherProcess(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      Parcel localParcel = Parcel.obtain();
      localParcel.unmarshall(paramArrayOfByte, 0, paramArrayOfByte.length);
      localParcel.setDataPosition(0);
      paramArrayOfByte = (VipIPSiteInfo)VipIPSiteInfo.CREATOR.createFromParcel(localParcel);
      localParcel.recycle();
      return paramArrayOfByte;
    }
    QLog.e("EmoticonManagerProxy", 1, "getIPSiteInfoFromBytes, error data = " + paramArrayOfByte);
    return null;
  }
  
  public List<EmoticonInfo> getMagicEmoticonInfoList(int paramInt)
  {
    if (this.manager != null) {
      return ((EmoticonManager)this.manager).b(paramInt);
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("param_businessidaio", paramInt);
    localObject = QIPCClientHelper.getInstance().getClient().callServer("module_emoticon_mainpanel", "emoticonmanager_getmagicemoticoninfolist", (Bundle)localObject);
    if ((localObject != null) && (((EIPCResult)localObject).isSuccess())) {
      return ((EIPCResult)localObject).data.getParcelableArrayList("param_Package");
    }
    QLog.e("EmoticonManagerProxy", 4, "getMagicEmoticonInfoList fail.");
    return new ArrayList();
  }
  
  public List<PromotionEmoticonPkg> getProEmoticonPkgs(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    if (this.manager != null) {
      return ((EmoticonManager)this.manager).a(paramBoolean1, paramInt, paramBoolean2);
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
    QLog.e("EmoticonManagerProxy", 4, "getProEmoticonPkgs fail.");
    return null;
  }
  
  public boolean isShowRecommendTabRedPoint(int paramInt)
  {
    if (this.manager != null) {
      return ((EmoticonManager)this.manager).a(paramInt);
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("param_businesstype", paramInt);
    localObject = QIPCClientHelper.getInstance().getClient().callServer("module_emoticon_mainpanel", "emoticonmanager_isshowrecommendtabredpoint", (Bundle)localObject);
    if ((localObject != null) && (((EIPCResult)localObject).isSuccess())) {
      return ((EIPCResult)localObject).data.getBoolean("redpoint_result");
    }
    QLog.e("EmoticonManagerProxy", 4, "isShowRecommendTabRedPoint fail.");
    return false;
  }
  
  public void pushRecommendExposeInfoToSP()
  {
    if (this.manager != null) {
      ((EmoticonManager)this.manager).f();
    }
    do
    {
      return;
      EIPCResult localEIPCResult = QIPCClientHelper.getInstance().getClient().callServer("module_emoticon_mainpanel", "emoticonmanager_pushrecommendexposeinfotosp", null);
      if ((localEIPCResult == null) || (!localEIPCResult.isSuccess())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("EmoticonManagerProxy", 4, "pushRecommendExposeInfoToSP suc.");
    return;
    QLog.e("EmoticonManagerProxy", 4, "pushRecommendExposeInfoToSP fail.");
  }
  
  public void realAsyncFindEmoticonPackage(String paramString, int paramInt, QueryCallback<EmoticonPackage> paramQueryCallback)
  {
    if (this.em == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonManagerProxy", 4, "em is null.");
      }
      return;
    }
    new QueryTask(new EmoticonManagerProxy.1(this, paramString, paramInt), paramQueryCallback).a(new Pair(paramString, Integer.valueOf(paramInt)));
  }
  
  public List<Emoticon> realSyncGetSubEmoticonsByPackageId(String paramString, boolean paramBoolean)
  {
    if (this.em == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonManagerProxy", 4, "em is null.");
      }
      paramString = null;
    }
    ArrayList localArrayList;
    do
    {
      do
      {
        return paramString;
        localArrayList = (ArrayList)this.em.query(Emoticon.class, false, "epId=?", new String[] { paramString }, null, null, null, null);
        paramString = localArrayList;
      } while (localArrayList == null);
      paramString = localArrayList;
    } while (!paramBoolean);
    return (List)localArrayList.clone();
  }
  
  public List<EmoticonPackage> realSyncGetTabEmoticonPackages(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if (this.em == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonManagerProxy", 4, "em is null.");
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
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonManagerProxy", 2, "syncGetTabEmoticonPackages begins, kanDianTabCache.size:" + ((List)localObject2).size() + " tabCache.size:" + ((List)localObject1).size() + " businessType = " + paramInt);
    }
    switch (paramInt)
    {
    default: 
      localObject1 = ((List)localObject1).iterator();
    }
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      if (localObject2 != null)
      {
        localObject2 = syncFindEmoticonPackageById((String)localObject2, paramInt);
        if (localObject2 != null)
        {
          localArrayList.add(localObject2);
          continue;
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
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonManagerProxy", 2, "syncGetTabEmoticonPackages ends, list.size:" + localArrayList.size());
    }
    return localArrayList;
  }
  
  public void recordRecommendEpExpose(PromotionEmoticonPkg paramPromotionEmoticonPkg)
  {
    if (this.manager != null) {
      ((EmoticonManager)this.manager).a(paramPromotionEmoticonPkg);
    }
    do
    {
      return;
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("param_Package", paramPromotionEmoticonPkg);
      paramPromotionEmoticonPkg = QIPCClientHelper.getInstance().getClient().callServer("module_emoticon_mainpanel", "emoticonmanager_recordrecommendepexpose", localBundle);
      if ((paramPromotionEmoticonPkg == null) || (!paramPromotionEmoticonPkg.isSuccess())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("EmoticonManagerProxy", 4, "recordRecommendEpExpose suc.");
    return;
    QLog.e("EmoticonManagerProxy", 4, "recordRecommendEpExpose fail.");
  }
  
  public void saveEmoticonPackage(EmoticonPackage paramEmoticonPackage)
  {
    if (this.manager != null) {
      ((EmoticonManager)this.manager).a(paramEmoticonPackage);
    }
    do
    {
      return;
      Bundle localBundle = new Bundle();
      localBundle.putSerializable("param_Package", paramEmoticonPackage);
      paramEmoticonPackage = QIPCClientHelper.getInstance().getClient().callServer("module_emoticon_mainpanel", "emoticonmanager_saveemoticonpackage", localBundle);
      if ((paramEmoticonPackage == null) || (!paramEmoticonPackage.isSuccess())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("EmoticonManagerProxy", 4, "saveEmoticonPackage suc.");
    return;
    QLog.e("EmoticonManagerProxy", 4, "saveEmoticonPackage fail.");
  }
  
  public void setRecommendEpRedFlag(String paramString, int paramInt)
  {
    if (this.manager != null) {
      ((EmoticonManager)this.manager).i(paramString, paramInt);
    }
    do
    {
      return;
      Bundle localBundle = new Bundle();
      localBundle.putString("param_id", paramString);
      localBundle.putInt("param_businesstype", paramInt);
      paramString = QIPCClientHelper.getInstance().getClient().callServer("module_emoticon_mainpanel", "emoticonmanager_setrecommendepredflag", localBundle);
      if ((paramString == null) || (!paramString.isSuccess())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("EmoticonManagerProxy", 4, "setRecommendEpRedFlag suc.");
    return;
    QLog.e("EmoticonManagerProxy", 4, "setRecommendEpRedFlag fail.");
  }
  
  public EmoticonPackage syncFindEmoticonPackageById(String paramString)
  {
    if (this.manager != null) {
      return ((EmoticonManager)this.manager).a(paramString);
    }
    return syncFindEmoticonPackageById(paramString, 0);
  }
  
  public EmoticonPackage syncFindEmoticonPackageById(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonManagerProxy", 2, "syncFindEmoticonPackageById epId = " + paramString + ", type = " + paramInt);
    }
    if (this.em == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonManagerProxy", 4, "em is null.");
      }
      paramString = null;
    }
    EmoticonPackage localEmoticonPackage;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return paramString;
              localEmoticonPackage = (EmoticonPackage)this.em.find(EmoticonPackage.class, paramString);
              paramString = localEmoticonPackage;
            } while (localEmoticonPackage == null);
            paramString = localEmoticonPackage;
          } while (paramInt == -1);
          if (paramInt != 0) {
            break;
          }
          paramString = localEmoticonPackage;
        } while (localEmoticonPackage.aio);
        return null;
        paramString = localEmoticonPackage;
      } while (paramInt != 1);
      paramString = localEmoticonPackage;
    } while (localEmoticonPackage.kandian);
    return null;
  }
  
  public List<Emoticon> syncGetSubEmoticonsByPackageId(String paramString, boolean paramBoolean)
  {
    if (this.manager != null) {
      return ((EmoticonManager)this.manager).a(paramString, paramBoolean);
    }
    return realSyncGetSubEmoticonsByPackageId(paramString, paramBoolean);
  }
  
  public List<EmoticonPackage> syncGetTabEmoticonPackages(int paramInt)
  {
    if (this.manager != null) {
      return ((EmoticonManager)this.manager).a(paramInt);
    }
    return realSyncGetTabEmoticonPackages(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.ipc.proxy.EmoticonManagerProxy
 * JD-Core Version:    0.7.0.1
 */