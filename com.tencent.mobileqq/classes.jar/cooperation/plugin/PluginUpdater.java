package cooperation.plugin;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.biz.ProtoServlet;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper.PluginInfoParser;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.app.NewIntent;
import protocol.KQQConfig.GPS;
import protocol.KQQConfig.ReqUserInfo;
import tencent.im.plugin.ResourceConfig.GetResourceReqInfoV2;
import tencent.im.plugin.ResourceConfig.GetResourceReqV2;
import tencent.im.plugin.ResourceConfig.GetResourceRespInfoV2;
import tencent.im.plugin.ResourceConfig.GetResourceRespV2;

public class PluginUpdater
  implements Handler.Callback, Runnable
{
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private PluginUpdater.OnPluginInfoUpdateListener jdField_a_of_type_CooperationPluginPluginUpdater$OnPluginInfoUpdateListener;
  private Map<String, PluginInfo> jdField_a_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_a_of_type_Boolean;
  private final Map<String, PluginInfo> b = new HashMap();
  
  public PluginUpdater(Context paramContext, Handler paramHandler)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(paramHandler.getLooper(), this);
    paramContext = b(paramContext);
    boolean bool = PluginInfoUtil.a(paramContext);
    paramHandler = PluginInfoUtil.a(paramContext);
    if (paramHandler != null)
    {
      int j = paramHandler.length;
      int i = 0;
      while (i < j)
      {
        File localFile = paramHandler[i];
        if (localFile.isFile()) {
          if (bool)
          {
            localFile.delete();
          }
          else
          {
            PluginInfo localPluginInfo = PluginInfoUtil.a(localFile);
            if (localPluginInfo != null) {
              this.jdField_a_of_type_JavaUtilMap.put(localPluginInfo.mID, localPluginInfo);
            } else {
              localFile.delete();
            }
          }
        }
        i += 1;
      }
    }
    if (bool) {
      PluginInfoUtil.a(paramContext);
    }
    paramContext = new StringBuilder();
    paramContext.append("init plugin updater :");
    paramContext.append(this.jdField_a_of_type_JavaUtilMap.size());
    QLog.d("plugin_tag", 1, paramContext.toString());
  }
  
  static File a(Context paramContext)
  {
    return paramContext.getDir("debug_plugin_info", 0);
  }
  
  private void a(ResourceConfig.GetResourceRespV2 paramGetResourceRespV2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "doOnGetPluginConfig");
    }
    Object localObject1;
    Object localObject2;
    Object localObject3;
    HashMap localHashMap;
    Object localObject4;
    int i;
    Object localObject5;
    Object localObject6;
    if (paramGetResourceRespV2 != null)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("onGetPluginConfig GetResourceRespV2: ");
        ((StringBuilder)localObject1).append(paramGetResourceRespV2);
        ((StringBuilder)localObject1).append("[add: ");
        ((StringBuilder)localObject1).append(paramGetResourceRespV2.addedResInfo.size());
        ((StringBuilder)localObject1).append(", remove: ");
        ((StringBuilder)localObject1).append(paramGetResourceRespV2.deletedResInfo.size());
        ((StringBuilder)localObject1).append(", update: ");
        ((StringBuilder)localObject1).append(paramGetResourceRespV2.updatedResInfo.size());
        ((StringBuilder)localObject1).append("]");
        QLog.d("plugin_tag", 2, ((StringBuilder)localObject1).toString());
      }
      localObject2 = new PluginBaseInfoHelper.PluginInfoParser();
      ((PluginBaseInfoHelper.PluginInfoParser)localObject2).setResultClass(PluginInfo.class);
      localObject1 = new ArrayList();
      localObject3 = new HashMap();
      localHashMap = new HashMap();
      localObject4 = paramGetResourceRespV2.deletedResInfo.get().iterator();
      while (((Iterator)localObject4).hasNext()) {
        ((List)localObject1).add(((ResourceConfig.GetResourceRespInfoV2)((Iterator)localObject4).next()).pkgName.get());
      }
      localObject4 = paramGetResourceRespV2.addedResInfo.get().iterator();
      for (;;)
      {
        boolean bool = ((Iterator)localObject4).hasNext();
        i = 0;
        if (!bool) {
          break;
        }
        localObject5 = (ResourceConfig.GetResourceRespInfoV2)((Iterator)localObject4).next();
        localObject6 = (PluginInfo)PluginBaseInfoHelper.parseConfig(((ResourceConfig.GetResourceRespInfoV2)localObject5).resConf.get(), (PluginBaseInfoHelper.PluginInfoParser)localObject2);
        if (localObject6 != null)
        {
          ((PluginInfo)localObject6).mType = ((ResourceConfig.GetResourceRespInfoV2)localObject5).resSubType.get();
          ((PluginInfo)localObject6).mPackageName = ((ResourceConfig.GetResourceRespInfoV2)localObject5).pkgName.get();
          ((PluginInfo)localObject6).mCurVersion = ((ResourceConfig.GetResourceRespInfoV2)localObject5).newVer.get();
          ((PluginInfo)localObject6).mState = 0;
          ((HashMap)localObject3).put(((PluginInfo)localObject6).mID, localObject6);
        }
      }
      localObject4 = paramGetResourceRespV2.updatedResInfo.get().iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = (ResourceConfig.GetResourceRespInfoV2)((Iterator)localObject4).next();
        localObject6 = (PluginInfo)PluginBaseInfoHelper.parseConfig(((ResourceConfig.GetResourceRespInfoV2)localObject5).resConf.get(), (PluginBaseInfoHelper.PluginInfoParser)localObject2);
        if (localObject6 != null)
        {
          ((PluginInfo)localObject6).mType = ((ResourceConfig.GetResourceRespInfoV2)localObject5).resSubType.get();
          ((PluginInfo)localObject6).mPackageName = ((ResourceConfig.GetResourceRespInfoV2)localObject5).pkgName.get();
          ((PluginInfo)localObject6).mCurVersion = ((ResourceConfig.GetResourceRespInfoV2)localObject5).newVer.get();
          ((PluginInfo)localObject6).mState = 0;
          localHashMap.put(((PluginInfo)localObject6).mID, localObject6);
        }
      }
    }
    for (;;)
    {
      try
      {
        localObject4 = this.jdField_a_of_type_JavaUtilMap;
        localObject5 = ((List)localObject1).iterator();
        if (((Iterator)localObject5).hasNext())
        {
          localObject6 = (String)((Iterator)localObject5).next();
          localObject2 = null;
          Iterator localIterator = ((Map)localObject4).values().iterator();
          localObject1 = localObject2;
          if (localIterator.hasNext())
          {
            localObject1 = (PluginInfo)localIterator.next();
            if (!((PluginInfo)localObject1).mPackageName.equals(localObject6)) {
              continue;
            }
          }
          if (localObject1 == null) {
            continue;
          }
          if (((HashMap)localObject3).containsKey(((PluginInfo)localObject1).mID))
          {
            localObject2 = (PluginInfo)((HashMap)localObject3).get(((PluginInfo)localObject1).mID);
            ((HashMap)localObject3).remove(((PluginInfo)localObject1).mID);
            localHashMap.put(((PluginInfo)localObject1).mID, localObject2);
            continue;
          }
          if ((this.jdField_a_of_type_CooperationPluginPluginUpdater$OnPluginInfoUpdateListener == null) || (!this.jdField_a_of_type_CooperationPluginPluginUpdater$OnPluginInfoUpdateListener.a((PluginInfo)localObject1))) {
            continue;
          }
          ((Map)localObject4).remove(((PluginInfo)localObject1).mID);
          if (!QLog.isColorLevel()) {
            break label1271;
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("remove PluginInfo: ");
          ((StringBuilder)localObject2).append(localObject1);
          QLog.d("plugin_tag", 2, ((StringBuilder)localObject2).toString());
          break label1271;
        }
        localObject1 = ((HashMap)localObject3).keySet().iterator();
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (PluginInfo)((HashMap)localObject3).get((String)((Iterator)localObject1).next());
          localObject5 = (PluginInfo)((Map)localObject4).get(((PluginInfo)localObject2).mID);
          if ((localObject5 != null) && (((PluginInfo)localObject5).mMD5 != null) && (((PluginInfo)localObject5).mMD5.equals(((PluginInfo)localObject2).mMD5)) && ((((PluginInfo)localObject5).mURL == null) || (((PluginInfo)localObject2).mForceUrl <= 0) || (((PluginInfo)localObject5).mURL.equals(((PluginInfo)localObject2).mURL)))) {
            continue;
          }
          ((Map)localObject4).put(((PluginInfo)localObject2).mID, localObject2);
          if (!QLog.isColorLevel()) {
            break label1276;
          }
          localObject5 = new StringBuilder();
          ((StringBuilder)localObject5).append("add PluginInfo: ");
          ((StringBuilder)localObject5).append(localObject2);
          QLog.d("plugin_tag", 2, ((StringBuilder)localObject5).toString());
          break label1276;
        }
        localObject1 = localHashMap.keySet().iterator();
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (PluginInfo)localHashMap.get((String)((Iterator)localObject1).next());
          localObject3 = (PluginInfo)((Map)localObject4).get(((PluginInfo)localObject2).mID);
          if ((localObject3 != null) && (((PluginInfo)localObject3).mMD5 != null) && (((PluginInfo)localObject3).mMD5.equals(((PluginInfo)localObject2).mMD5)) && ((((PluginInfo)localObject3).mURL == null) || (((PluginInfo)localObject2).mForceUrl <= 0) || (((PluginInfo)localObject3).mURL.equals(((PluginInfo)localObject2).mURL))))
          {
            if ((((PluginInfo)localObject3).mMD5.equals(((PluginInfo)localObject2).mMD5)) && (((PluginInfo)localObject3).mURL != null) && (((PluginInfo)localObject2).mForceUrl <= 0) && (!((PluginInfo)localObject3).mURL.equals(((PluginInfo)localObject2).mURL)))
            {
              ((PluginInfo)localObject3).mPackageName = ((PluginInfo)localObject2).mPackageName;
              ((PluginInfo)localObject3).mCurVersion = ((PluginInfo)localObject2).mCurVersion;
              ((PluginInfo)localObject3).mURL = ((PluginInfo)localObject2).mURL;
              break label1281;
            }
            if (((PluginInfo)localObject3).mCurVersion == ((PluginInfo)localObject2).mCurVersion) {
              continue;
            }
            ((PluginInfo)localObject3).mCurVersion = ((PluginInfo)localObject2).mCurVersion;
            break label1281;
          }
          ((Map)localObject4).put(((PluginInfo)localObject2).mID, localObject2);
          if (!QLog.isColorLevel()) {
            break label1281;
          }
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("update PluginInfo: ");
          ((StringBuilder)localObject3).append(localObject2);
          QLog.d("plugin_tag", 2, ((StringBuilder)localObject3).toString());
          break label1281;
        }
        localObject1 = this.jdField_a_of_type_CooperationPluginPluginUpdater$OnPluginInfoUpdateListener;
        if (localObject1 != null) {
          ((PluginUpdater.OnPluginInfoUpdateListener)localObject1).a(true);
        }
        if (this.jdField_a_of_type_JavaUtilMap.isEmpty())
        {
          localObject1 = new HashMap();
          StatisticCollector.fillFailCode((Map)localObject1, AppSetting.a());
          StatisticCollector.getInstance(this.jdField_a_of_type_AndroidContentContext).collectPerformance(String.valueOf(paramGetResourceRespV2.uin), "pluginUpdateEmpty", false, 0L, 0L, (HashMap)localObject1, "");
        }
        if (i != 0)
        {
          a();
          return;
        }
      }
      finally {}
      return;
      label1271:
      i = 1;
      continue;
      label1276:
      i = 1;
      continue;
      label1281:
      i = 1;
    }
  }
  
  public static void a(boolean paramBoolean, Context paramContext)
  {
    paramContext = new File(a(paramContext), "enableDebug");
    if (paramBoolean)
    {
      if (paramContext.exists()) {
        return;
      }
      try
      {
        paramContext.createNewFile();
        return;
      }
      catch (IOException paramContext)
      {
        QLog.e("plugin_tag", 4, "debug tag create failed! ", paramContext);
        return;
      }
    }
    if (paramContext.exists()) {
      paramContext.delete();
    }
  }
  
  public static boolean a(Context paramContext)
  {
    return new File(a(paramContext), "enableDebug").exists();
  }
  
  static File b(Context paramContext)
  {
    return paramContext.getDir("plugin_info", 0);
  }
  
  PluginInfo a(String paramString)
  {
    return (PluginInfo)this.b.get(paramString);
  }
  
  public void a()
  {
    File localFile = b(this.jdField_a_of_type_AndroidContentContext);
    Object localObject = PluginInfoUtil.a(localFile);
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
      PluginInfoUtil.a((PluginInfo)((Iterator)localObject).next(), localFile);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "handle getPluginList");
    }
    this.jdField_a_of_type_Boolean = true;
    Object localObject1 = new ReqUserInfo();
    ((ReqUserInfo)localObject1).cType = 1;
    ((ReqUserInfo)localObject1).stGps = new GPS();
    ((ReqUserInfo)localObject1).strAuthName = "B1_QQ_Neighbor_android";
    ((ReqUserInfo)localObject1).strAuthPassword = "NzVK_qGE";
    ((ReqUserInfo)localObject1).vCells = new ArrayList();
    ((ReqUserInfo)localObject1).vMacs = new ArrayList();
    localObject1 = new ArrayList();
    Object localObject2 = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      PluginInfo localPluginInfo = (PluginInfo)((Iterator)localObject2).next();
      Object localObject3 = new ResourceConfig.GetResourceReqInfoV2();
      ((ResourceConfig.GetResourceReqInfoV2)localObject3).state.set(0);
      ((ResourceConfig.GetResourceReqInfoV2)localObject3).lanType.set(1);
      ((ResourceConfig.GetResourceReqInfoV2)localObject3).resSubType.set(localPluginInfo.mType);
      ((ResourceConfig.GetResourceReqInfoV2)localObject3).pkgName.set(localPluginInfo.mPackageName);
      ((ResourceConfig.GetResourceReqInfoV2)localObject3).curVer.set(localPluginInfo.mCurVersion);
      ((ArrayList)localObject1).add(localObject3);
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("getPluginList Add: ");
        ((StringBuilder)localObject3).append(localPluginInfo.mID);
        QLog.d("plugin_tag", 2, ((StringBuilder)localObject3).toString());
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "getPluginList: 128");
    }
    localObject2 = new ResourceConfig.GetResourceReqV2();
    ((ResourceConfig.GetResourceReqV2)localObject2).appid.set(AppSetting.a());
    ((ResourceConfig.GetResourceReqV2)localObject2).pluginType.set(128);
    ((ResourceConfig.GetResourceReqV2)localObject2).reqVer.set(1);
    ((ResourceConfig.GetResourceReqV2)localObject2).resReqInfo.set((List)localObject1);
    ((ResourceConfig.GetResourceReqV2)localObject2).revision.set("01328a87");
    localObject1 = new NewIntent(BaseApplicationImpl.getApplication(), ProtoServlet.class);
    ((NewIntent)localObject1).putExtra("cmd", "ResourceConfig.ClientReqV2");
    ((NewIntent)localObject1).putExtra("data", ((ResourceConfig.GetResourceReqV2)localObject2).toByteArray());
    ((NewIntent)localObject1).setObserver(new PluginUpdater.1(this));
    paramQQAppInterface.startServlet((NewIntent)localObject1);
  }
  
  void a(PluginInfo paramPluginInfo)
  {
    if (paramPluginInfo != null) {
      PluginInfoUtil.a(paramPluginInfo, a(this.jdField_a_of_type_AndroidContentContext));
    }
  }
  
  public void a(PluginUpdater.OnPluginInfoUpdateListener paramOnPluginInfoUpdateListener)
  {
    this.jdField_a_of_type_CooperationPluginPluginUpdater$OnPluginInfoUpdateListener = paramOnPluginInfoUpdateListener;
  }
  
  public void a(boolean paramBoolean, int paramInt, ResourceConfig.GetResourceRespV2 paramGetResourceRespV2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGetPluginConfig: ");
      localStringBuilder.append(paramBoolean);
      QLog.d("plugin_tag", 2, localStringBuilder.toString());
    }
    if (paramInt != 128)
    {
      paramGetResourceRespV2 = this.jdField_a_of_type_CooperationPluginPluginUpdater$OnPluginInfoUpdateListener;
      if (paramGetResourceRespV2 != null) {
        paramGetResourceRespV2.a(false);
      }
      return;
    }
    if ((paramBoolean) && (paramGetResourceRespV2 != null))
    {
      a(paramGetResourceRespV2);
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    paramGetResourceRespV2 = this.jdField_a_of_type_CooperationPluginPluginUpdater$OnPluginInfoUpdateListener;
    if (paramGetResourceRespV2 != null) {
      paramGetResourceRespV2.a(false);
    }
  }
  
  public boolean a(PluginInfo paramPluginInfo)
  {
    boolean bool2 = false;
    if (paramPluginInfo == null) {
      return false;
    }
    PluginInfo localPluginInfo = b(paramPluginInfo.mID);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("pre: ");
      Object localObject2 = null;
      if (paramPluginInfo != null) {
        localObject1 = paramPluginInfo.mMD5;
      } else {
        localObject1 = null;
      }
      localStringBuilder.append((String)localObject1);
      QLog.d("plugin_tag", 2, localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("new: ");
      Object localObject1 = localObject2;
      if (localPluginInfo != null) {
        localObject1 = localPluginInfo.mMD5;
      }
      localStringBuilder.append((String)localObject1);
      QLog.d("plugin_tag", 2, localStringBuilder.toString());
    }
    boolean bool1 = bool2;
    if (localPluginInfo != null)
    {
      bool1 = bool2;
      if (paramPluginInfo != null)
      {
        bool1 = bool2;
        if (localPluginInfo.mMD5.equals(paramPluginInfo.mMD5)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public PluginInfo b(String paramString)
  {
    PluginInfo localPluginInfo1 = (PluginInfo)this.b.get(paramString);
    if ((!a(this.jdField_a_of_type_AndroidContentContext)) || (localPluginInfo1 == null)) {
      localPluginInfo1 = (PluginInfo)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    }
    PluginInfo localPluginInfo2 = localPluginInfo1;
    if (localPluginInfo1 == null) {
      localPluginInfo2 = BuiltinPluginManager.a(this.jdField_a_of_type_AndroidContentContext).a(paramString);
    }
    return localPluginInfo2;
  }
  
  public void b(boolean paramBoolean, int paramInt, ResourceConfig.GetResourceRespV2 paramGetResourceRespV2)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 2) {
      return false;
    }
    int i = paramMessage.arg1;
    int j = paramMessage.arg2;
    boolean bool = true;
    if (j != 1) {
      bool = false;
    }
    a(bool, i, (ResourceConfig.GetResourceRespV2)paramMessage.obj);
    return false;
  }
  
  public void run()
  {
    ResourceConfig.GetResourceRespV2 localGetResourceRespV2 = new ResourceConfig.GetResourceRespV2();
    localGetResourceRespV2.result.set(0);
    a(localGetResourceRespV2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.plugin.PluginUpdater
 * JD-Core Version:    0.7.0.1
 */