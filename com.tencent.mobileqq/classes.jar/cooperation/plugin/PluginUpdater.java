package cooperation.plugin;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import axrl;
import bgkk;
import bgli;
import bglz;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper.PluginInfoParser;
import com.tencent.mobileqq.startup.step.UpdatePluginVersion;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.manager.ServerConfigManager;
import mqq.observer.ServerConfigObserver;
import protocol.KQQConfig.GPS;
import protocol.KQQConfig.GetResourceReqInfoV2;
import protocol.KQQConfig.GetResourceRespInfoV2;
import protocol.KQQConfig.GetResourceRespV2;
import protocol.KQQConfig.ReqUserInfo;

public class PluginUpdater
  extends ServerConfigObserver
  implements Handler.Callback, Runnable
{
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private bglz jdField_a_of_type_Bglz;
  private Map<String, PluginInfo> jdField_a_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_a_of_type_Boolean;
  
  public PluginUpdater(Context paramContext, Handler paramHandler)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(paramHandler.getLooper(), this);
    paramContext = a(paramContext);
    boolean bool = bgli.a(paramContext);
    paramHandler = bgli.a(paramContext);
    if (paramHandler != null)
    {
      int n = paramHandler.length;
      int i = 0;
      if (i < n)
      {
        File localFile = paramHandler[i];
        Object localObject;
        int j;
        if (localFile.isFile())
        {
          if (!bool) {
            break label181;
          }
          int m = 0;
          localObject = UpdatePluginVersion.a;
          int i1 = localObject.length;
          j = 0;
          label102:
          int k = m;
          if (j < i1)
          {
            String str = localObject[j];
            if (!localFile.getName().equals(str + ".cfg")) {
              break label172;
            }
            localFile.delete();
            k = 1;
          }
          if (k == 0) {
            break label181;
          }
        }
        for (;;)
        {
          i += 1;
          break;
          label172:
          j += 1;
          break label102;
          label181:
          localObject = bgli.a(localFile);
          if (localObject != null) {
            this.jdField_a_of_type_JavaUtilMap.put(((PluginInfo)localObject).mID, localObject);
          } else {
            localFile.delete();
          }
        }
      }
    }
    if (bool) {
      bgli.a(paramContext);
    }
    QLog.d("plugin_tag", 1, "init plugin updater :" + this.jdField_a_of_type_JavaUtilMap.size());
  }
  
  static File a(Context paramContext)
  {
    return paramContext.getDir("plugin_info", 0);
  }
  
  private void a(GetResourceRespV2 paramGetResourceRespV2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "doOnGetPluginConfig");
    }
    Object localObject3;
    Object localObject1;
    Object localObject2;
    HashMap localHashMap;
    Object localObject4;
    Object localObject5;
    Object localObject6;
    if (paramGetResourceRespV2 != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "onGetPluginConfig GetResourceRespV2: " + paramGetResourceRespV2 + "[add: " + paramGetResourceRespV2.vecAddedResInfo.size() + ", remove: " + paramGetResourceRespV2.vecDeletedResInfo.size() + ", update: " + paramGetResourceRespV2.vecUpdatedResInfo.size() + "]");
      }
      localObject3 = new PluginBaseInfoHelper.PluginInfoParser();
      ((PluginBaseInfoHelper.PluginInfoParser)localObject3).setResultClass(PluginInfo.class);
      localObject1 = new ArrayList();
      localObject2 = new HashMap();
      localHashMap = new HashMap();
      localObject4 = paramGetResourceRespV2.vecDeletedResInfo.iterator();
      while (((Iterator)localObject4).hasNext()) {
        ((List)localObject1).add(((GetResourceRespInfoV2)((Iterator)localObject4).next()).strPkgName);
      }
      localObject4 = paramGetResourceRespV2.vecAddedResInfo.iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = (GetResourceRespInfoV2)((Iterator)localObject4).next();
        localObject6 = (PluginInfo)PluginBaseInfoHelper.parseConfig(((GetResourceRespInfoV2)localObject5).strResConf, (PluginBaseInfoHelper.PluginInfoParser)localObject3);
        if (localObject6 != null)
        {
          ((PluginInfo)localObject6).mType = ((GetResourceRespInfoV2)localObject5).sResSubType;
          ((PluginInfo)localObject6).mPackageName = ((GetResourceRespInfoV2)localObject5).strPkgName;
          ((PluginInfo)localObject6).mCurVersion = ((GetResourceRespInfoV2)localObject5).uiNewVer;
          ((PluginInfo)localObject6).mState = 0;
          ((HashMap)localObject2).put(((PluginInfo)localObject6).mID, localObject6);
        }
      }
      localObject4 = paramGetResourceRespV2.vecUpdatedResInfo.iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = (GetResourceRespInfoV2)((Iterator)localObject4).next();
        localObject6 = (PluginInfo)PluginBaseInfoHelper.parseConfig(((GetResourceRespInfoV2)localObject5).strResConf, (PluginBaseInfoHelper.PluginInfoParser)localObject3);
        if (localObject6 != null)
        {
          ((PluginInfo)localObject6).mType = ((GetResourceRespInfoV2)localObject5).sResSubType;
          ((PluginInfo)localObject6).mPackageName = ((GetResourceRespInfoV2)localObject5).strPkgName;
          ((PluginInfo)localObject6).mCurVersion = ((GetResourceRespInfoV2)localObject5).uiNewVer;
          ((PluginInfo)localObject6).mState = 0;
          localHashMap.put(((PluginInfo)localObject6).mID, localObject6);
        }
      }
    }
    label1108:
    label1113:
    label1116:
    label1119:
    label1124:
    label1127:
    label1132:
    label1134:
    label1137:
    for (;;)
    {
      try
      {
        localObject3 = this.jdField_a_of_type_JavaUtilMap;
        localObject4 = ((List)localObject1).iterator();
        i = 0;
        if (((Iterator)localObject4).hasNext())
        {
          localObject5 = (String)((Iterator)localObject4).next();
          localObject6 = ((Map)localObject3).values().iterator();
          if (!((Iterator)localObject6).hasNext()) {
            break label1119;
          }
          localObject1 = (PluginInfo)((Iterator)localObject6).next();
          if (!((PluginInfo)localObject1).mPackageName.equals(localObject5)) {
            continue;
          }
          if (localObject1 == null) {
            break label1116;
          }
          if (((HashMap)localObject2).containsKey(((PluginInfo)localObject1).mID))
          {
            localObject5 = (PluginInfo)((HashMap)localObject2).get(((PluginInfo)localObject1).mID);
            ((HashMap)localObject2).remove(((PluginInfo)localObject1).mID);
            localHashMap.put(((PluginInfo)localObject1).mID, localObject5);
            break label1124;
          }
          if ((this.jdField_a_of_type_Bglz == null) || (!this.jdField_a_of_type_Bglz.a((PluginInfo)localObject1))) {
            break label1116;
          }
          ((Map)localObject3).remove(((PluginInfo)localObject1).mID);
          if (!QLog.isColorLevel()) {
            break label1127;
          }
          QLog.d("plugin_tag", 2, "remove PluginInfo: " + localObject1);
          break label1127;
        }
        localObject1 = ((HashMap)localObject2).keySet().iterator();
        if (((Iterator)localObject1).hasNext())
        {
          localObject4 = (PluginInfo)((HashMap)localObject2).get((String)((Iterator)localObject1).next());
          localObject5 = (PluginInfo)((Map)localObject3).get(((PluginInfo)localObject4).mID);
          if ((localObject5 != null) && (((PluginInfo)localObject5).mMD5 != null) && (((PluginInfo)localObject5).mMD5.equals(((PluginInfo)localObject4).mMD5)) && ((((PluginInfo)localObject5).mURL == null) || (((PluginInfo)localObject4).mForceUrl <= 0) || (((PluginInfo)localObject5).mURL.equals(((PluginInfo)localObject4).mURL)))) {
            break label1113;
          }
          ((Map)localObject3).put(((PluginInfo)localObject4).mID, localObject4);
          if (!QLog.isColorLevel()) {
            break label1132;
          }
          QLog.d("plugin_tag", 2, "add PluginInfo: " + localObject4);
          break label1132;
        }
        localObject1 = localHashMap.keySet().iterator();
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (PluginInfo)localHashMap.get((String)((Iterator)localObject1).next());
          localObject4 = (PluginInfo)((Map)localObject3).get(((PluginInfo)localObject2).mID);
          if ((localObject4 == null) || (((PluginInfo)localObject4).mMD5 == null) || (!((PluginInfo)localObject4).mMD5.equals(((PluginInfo)localObject2).mMD5)) || ((((PluginInfo)localObject4).mURL != null) && (((PluginInfo)localObject2).mForceUrl > 0) && (!((PluginInfo)localObject4).mURL.equals(((PluginInfo)localObject2).mURL))))
          {
            ((Map)localObject3).put(((PluginInfo)localObject2).mID, localObject2);
            if (!QLog.isColorLevel()) {
              break label1108;
            }
            QLog.d("plugin_tag", 2, "update PluginInfo: " + localObject2);
            i = 1;
            break label1137;
          }
          if ((((PluginInfo)localObject4).mMD5.equals(((PluginInfo)localObject2).mMD5)) && (((PluginInfo)localObject4).mURL != null) && (((PluginInfo)localObject2).mForceUrl <= 0) && (!((PluginInfo)localObject4).mURL.equals(((PluginInfo)localObject2).mURL)))
          {
            ((PluginInfo)localObject4).mPackageName = ((PluginInfo)localObject2).mPackageName;
            ((PluginInfo)localObject4).mCurVersion = ((PluginInfo)localObject2).mCurVersion;
            ((PluginInfo)localObject4).mURL = ((PluginInfo)localObject2).mURL;
            i = 1;
            break label1137;
          }
        }
        else
        {
          if (this.jdField_a_of_type_Bglz != null) {
            this.jdField_a_of_type_Bglz.a(true);
          }
          if (this.jdField_a_of_type_JavaUtilMap.isEmpty())
          {
            localObject1 = new HashMap();
            axrl.a((Map)localObject1, AppSetting.a());
            axrl.a(this.jdField_a_of_type_AndroidContentContext).a(String.valueOf(paramGetResourceRespV2.uin), "pluginUpdateEmpty", false, 0L, 0L, (HashMap)localObject1, "");
          }
          if (i != 0) {
            a();
          }
          return;
        }
      }
      finally {}
      break label1137;
      int i = 1;
      break label1137;
      break label1134;
      break label1124;
      localObject1 = null;
      continue;
      for (;;)
      {
        break;
        i = 1;
      }
      i = 1;
    }
  }
  
  public PluginInfo a(String paramString)
  {
    PluginInfo localPluginInfo2 = (PluginInfo)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    PluginInfo localPluginInfo1 = localPluginInfo2;
    if (localPluginInfo2 == null) {
      localPluginInfo1 = bgkk.a(this.jdField_a_of_type_AndroidContentContext).a(paramString);
    }
    return localPluginInfo1;
  }
  
  public void a()
  {
    File localFile = a(this.jdField_a_of_type_AndroidContentContext);
    Object localObject = bgli.a(localFile);
    if (localObject != null)
    {
      int i = 0;
      while (i < localObject.length)
      {
        localObject[i].delete();
        i += 1;
      }
    }
    localObject = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (((Iterator)localObject).hasNext()) {
      bgli.a((PluginInfo)((Iterator)localObject).next(), localFile);
    }
  }
  
  public void a(bglz parambglz)
  {
    this.jdField_a_of_type_Bglz = parambglz;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "handle getPluginList");
    }
    this.jdField_a_of_type_Boolean = true;
    ReqUserInfo localReqUserInfo = new ReqUserInfo();
    localReqUserInfo.cType = 1;
    localReqUserInfo.stGps = new GPS();
    localReqUserInfo.strAuthName = "B1_QQ_Neighbor_android";
    localReqUserInfo.strAuthPassword = "NzVK_qGE";
    localReqUserInfo.vCells = new ArrayList();
    localReqUserInfo.vMacs = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext())
    {
      PluginInfo localPluginInfo = (PluginInfo)localIterator.next();
      GetResourceReqInfoV2 localGetResourceReqInfoV2 = new GetResourceReqInfoV2();
      localGetResourceReqInfoV2.cState = 0;
      localGetResourceReqInfoV2.sLanType = 1;
      localGetResourceReqInfoV2.sResSubType = ((short)localPluginInfo.mType);
      localGetResourceReqInfoV2.strPkgName = localPluginInfo.mPackageName;
      localGetResourceReqInfoV2.uiCurVer = localPluginInfo.mCurVersion;
      localArrayList.add(localGetResourceReqInfoV2);
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "getPluginList Add: " + localPluginInfo.mID);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "getPluginList: 128");
    }
    ((ServerConfigManager)paramQQAppInterface.getManager(4)).getPluginConfig(128, localReqUserInfo, localArrayList, this, AppSetting.a());
  }
  
  public void a(boolean paramBoolean, int paramInt, GetResourceRespV2 paramGetResourceRespV2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "onGetPluginConfig: " + paramBoolean);
    }
    if (paramInt != 128) {
      if (this.jdField_a_of_type_Bglz != null) {
        this.jdField_a_of_type_Bglz.a(false);
      }
    }
    do
    {
      return;
      if ((paramBoolean) && (paramGetResourceRespV2 != null)) {
        break;
      }
    } while (this.jdField_a_of_type_Bglz == null);
    this.jdField_a_of_type_Bglz.a(false);
    return;
    a(paramGetResourceRespV2);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public boolean a(PluginInfo paramPluginInfo)
  {
    Object localObject2 = null;
    if (paramPluginInfo == null) {
      return false;
    }
    PluginInfo localPluginInfo = a(paramPluginInfo.mID);
    Object localObject1;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("pre: ");
      if (paramPluginInfo != null)
      {
        localObject1 = paramPluginInfo.mMD5;
        QLog.d("plugin_tag", 2, (String)localObject1);
        localStringBuilder = new StringBuilder().append("new: ");
        localObject1 = localObject2;
        if (localPluginInfo != null) {
          localObject1 = localPluginInfo.mMD5;
        }
        QLog.d("plugin_tag", 2, (String)localObject1);
      }
    }
    else
    {
      if ((localPluginInfo == null) || (paramPluginInfo == null) || (!localPluginInfo.mMD5.equals(paramPluginInfo.mMD5))) {
        break label141;
      }
    }
    label141:
    for (boolean bool = true;; bool = false)
    {
      return bool;
      localObject1 = null;
      break;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    }
    int i = paramMessage.arg1;
    if (paramMessage.arg2 == 1) {}
    for (boolean bool = true;; bool = false)
    {
      a(bool, i, (GetResourceRespV2)paramMessage.obj);
      return false;
    }
  }
  
  public void onGetPluginConfig(boolean paramBoolean, int paramInt, GetResourceRespV2 paramGetResourceRespV2)
  {
    Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      Message.obtain(localHandler, 2, paramInt, i, paramGetResourceRespV2).sendToTarget();
      return;
    }
  }
  
  public void run()
  {
    GetResourceRespV2 localGetResourceRespV2 = new GetResourceRespV2();
    localGetResourceRespV2.result = 0;
    localGetResourceRespV2.vecAddedResInfo = new ArrayList();
    localGetResourceRespV2.vecDeletedResInfo = new ArrayList();
    localGetResourceRespV2.vecUpdatedResInfo = new ArrayList();
    a(localGetResourceRespV2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.plugin.PluginUpdater
 * JD-Core Version:    0.7.0.1
 */