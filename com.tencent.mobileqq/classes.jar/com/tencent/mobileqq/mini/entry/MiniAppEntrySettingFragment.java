package com.tencent.mobileqq.mini.entry;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ListView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MiniAppEntrySettingFragment
  extends IphoneTitleBarFragment
{
  private static final String TAG = "MiniAppEntrySettingFragment";
  private BaseActivity activity;
  private BounceScrollView mSettingLayout;
  private ListView mSettingListView;
  private MiniAppEntrySettingFragment.SettingListViewAdapter mSettingListViewAdapter;
  private ArrayList<MiniAppSettingSwitchInfoEntity> switchInfoList = new ArrayList();
  
  private void initData()
  {
    Object localObject = this.activity;
    if (localObject != null)
    {
      localObject = ((BaseActivity)localObject).getAppInterface().getEntityManagerFactory().createEntityManager().query(MiniAppSettingSwitchInfoEntity.class, MiniAppSettingSwitchInfoEntity.class.getSimpleName(), false, null, null, null, null, null, null);
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          MiniAppSettingSwitchInfoEntity localMiniAppSettingSwitchInfoEntity = (MiniAppSettingSwitchInfoEntity)((Iterator)localObject).next();
          if ((localMiniAppSettingSwitchInfoEntity != null) && (!TextUtils.isEmpty(localMiniAppSettingSwitchInfoEntity.key))) {
            this.switchInfoList.add(localMiniAppSettingSwitchInfoEntity);
          }
        }
      }
    }
    MiniAppCmdUtil.getInstance().getSwitchList(null, new MiniAppEntrySettingFragment.2(this));
  }
  
  private void initUI(View paramView)
  {
    this.mSettingLayout = ((BounceScrollView)paramView.findViewById(2131371099));
    if (MiniAppUtils.isNightMode()) {
      this.mSettingLayout.setBackgroundColor(-16777216);
    }
    this.mSettingListView = ((ListView)paramView.findViewById(2131371368));
    this.mSettingListViewAdapter = new MiniAppEntrySettingFragment.SettingListViewAdapter(this, paramView.getContext());
    this.mSettingListView.setAdapter(this.mSettingListViewAdapter);
    paramView = this.activity;
    if (paramView != null) {
      paramView.runOnUiThread(new MiniAppEntrySettingFragment.1(this));
    }
  }
  
  /* Error */
  private void saveLocalSwitchDataList(List<MiniAppSettingSwitchInfoEntity> paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 41	com/tencent/mobileqq/mini/entry/MiniAppEntrySettingFragment:activity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   4: astore_2
    //   5: aload_2
    //   6: ifnull +152 -> 158
    //   9: aload_2
    //   10: getfield 198	com/tencent/mobileqq/app/BaseActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   13: astore_2
    //   14: aload_1
    //   15: ifnull +112 -> 127
    //   18: aload_1
    //   19: invokeinterface 102 1 0
    //   24: ifeq +103 -> 127
    //   27: aload_2
    //   28: ifnonnull +6 -> 34
    //   31: goto +96 -> 127
    //   34: aload_2
    //   35: invokevirtual 76	com/tencent/common/app/AppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   38: invokevirtual 82	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   41: astore_3
    //   42: aload_3
    //   43: ifnull +115 -> 158
    //   46: aload_3
    //   47: invokevirtual 202	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   50: astore_2
    //   51: aload_2
    //   52: invokevirtual 207	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   55: aload_1
    //   56: invokeinterface 106 1 0
    //   61: astore_1
    //   62: aload_1
    //   63: invokeinterface 112 1 0
    //   68: ifeq +21 -> 89
    //   71: aload_0
    //   72: aload_3
    //   73: aload_1
    //   74: invokeinterface 116 1 0
    //   79: checkcast 84	com/tencent/mobileqq/mini/entry/MiniAppSettingSwitchInfoEntity
    //   82: invokespecial 57	com/tencent/mobileqq/mini/entry/MiniAppEntrySettingFragment:updateSwitchData	(Lcom/tencent/mobileqq/persistence/EntityManager;Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   85: pop
    //   86: goto -24 -> 62
    //   89: aload_2
    //   90: invokevirtual 210	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   93: goto +23 -> 116
    //   96: astore_1
    //   97: goto +24 -> 121
    //   100: astore_1
    //   101: invokestatic 215	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   104: ifeq +12 -> 116
    //   107: ldc 8
    //   109: iconst_2
    //   110: ldc 217
    //   112: aload_1
    //   113: invokestatic 221	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   116: aload_2
    //   117: invokevirtual 224	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   120: return
    //   121: aload_2
    //   122: invokevirtual 224	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   125: aload_1
    //   126: athrow
    //   127: new 226	java/lang/StringBuilder
    //   130: dup
    //   131: invokespecial 227	java/lang/StringBuilder:<init>	()V
    //   134: astore_1
    //   135: aload_1
    //   136: ldc 229
    //   138: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: pop
    //   142: aload_1
    //   143: aload_2
    //   144: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   147: pop
    //   148: ldc 8
    //   150: iconst_2
    //   151: aload_1
    //   152: invokevirtual 239	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   155: invokestatic 243	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   158: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	159	0	this	MiniAppEntrySettingFragment
    //   0	159	1	paramList	List<MiniAppSettingSwitchInfoEntity>
    //   4	140	2	localObject	Object
    //   41	32	3	localEntityManager	EntityManager
    // Exception table:
    //   from	to	target	type
    //   55	62	96	finally
    //   62	86	96	finally
    //   89	93	96	finally
    //   101	116	96	finally
    //   55	62	100	java/lang/Exception
    //   62	86	100	java/lang/Exception
    //   89	93	100	java/lang/Exception
  }
  
  private void updateDataToDB(MiniAppSettingSwitchInfoEntity paramMiniAppSettingSwitchInfoEntity)
  {
    if (paramMiniAppSettingSwitchInfoEntity != null)
    {
      if (TextUtils.isEmpty(paramMiniAppSettingSwitchInfoEntity.key)) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateDataToDB entity.key:");
      localStringBuilder.append(paramMiniAppSettingSwitchInfoEntity.key);
      QLog.e("MiniAppEntrySettingFragment", 2, localStringBuilder.toString());
      ThreadManager.excute(new MiniAppEntrySettingFragment.4(this, paramMiniAppSettingSwitchInfoEntity), 32, null, true);
    }
  }
  
  private void updateLocalSwitchDataList(List<MiniAppSettingSwitchInfoEntity> paramList)
  {
    ThreadManager.excute(new MiniAppEntrySettingFragment.3(this, paramList), 32, null, true);
  }
  
  private boolean updateSwitchData(EntityManager paramEntityManager, Entity paramEntity)
  {
    boolean bool2 = paramEntityManager.isOpen();
    boolean bool1 = false;
    if (bool2)
    {
      if (paramEntity.getStatus() == 1000)
      {
        paramEntityManager.persistOrReplace(paramEntity);
        if (paramEntity.getStatus() == 1001) {
          bool1 = true;
        }
      }
      else if ((paramEntity.getStatus() == 1001) || (paramEntity.getStatus() == 1002))
      {
        bool1 = paramEntityManager.update(paramEntity);
      }
      paramEntityManager.close();
      return bool1;
    }
    if (QLog.isColorLevel())
    {
      paramEntityManager = new StringBuilder();
      paramEntityManager.append("updateEntity em closed e=");
      paramEntityManager.append(paramEntity.getTableName());
      QLog.d("MiniAppEntrySettingFragment", 2, paramEntityManager.toString());
    }
    return false;
  }
  
  protected int getContentLayoutId()
  {
    return 2131562372;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
  }
  
  public void onDetach()
  {
    super.onDetach();
    this.activity = null;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.activity = getBaseActivity();
    setTitle(HardCodeUtil.a(2131706839));
    initData();
    initUI(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppEntrySettingFragment
 * JD-Core Version:    0.7.0.1
 */