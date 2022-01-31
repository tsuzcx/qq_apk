package com.tencent.mobileqq.mini.activity;

import ajya;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ListView;
import auko;
import aukp;
import aukq;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.mini.entry.MiniAppSettingSwitchInfoEntity;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MiniAppEntrySettingFragment
  extends IphoneTitleBarFragment
{
  private static final String TAG = "MiniAppEntrySettingFragment";
  private FragmentActivity activity;
  private BounceScrollView mSettingLayout;
  private ListView mSettingListView;
  private MiniAppEntrySettingFragment.SettingListViewAdapter mSettingListViewAdapter;
  private ArrayList<MiniAppSettingSwitchInfoEntity> switchInfoList = new ArrayList();
  
  private void initData()
  {
    if (this.activity != null)
    {
      Object localObject = this.activity.getAppInterface().getEntityManagerFactory().createEntityManager().a(MiniAppSettingSwitchInfoEntity.class, MiniAppSettingSwitchInfoEntity.class.getSimpleName(), false, null, null, null, null, null, null);
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
    this.mSettingLayout = ((BounceScrollView)paramView.findViewById(2131370181));
    if (MiniAppUtils.isNightMode()) {
      this.mSettingLayout.setBackgroundColor(-16777216);
    }
    this.mSettingListView = ((ListView)paramView.findViewById(2131370306));
    this.mSettingListViewAdapter = new MiniAppEntrySettingFragment.SettingListViewAdapter(this, paramView.getContext());
    this.mSettingListView.setAdapter(this.mSettingListViewAdapter);
    if (this.activity != null) {
      this.activity.runOnUiThread(new MiniAppEntrySettingFragment.1(this));
    }
  }
  
  /* Error */
  private void saveLocalSwitchDataList(List<MiniAppSettingSwitchInfoEntity> paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 41	com/tencent/mobileqq/mini/activity/MiniAppEntrySettingFragment:activity	Landroid/support/v4/app/FragmentActivity;
    //   4: ifnull +53 -> 57
    //   7: aload_0
    //   8: getfield 41	com/tencent/mobileqq/mini/activity/MiniAppEntrySettingFragment:activity	Landroid/support/v4/app/FragmentActivity;
    //   11: getfield 198	android/support/v4/app/FragmentActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   14: astore_2
    //   15: aload_1
    //   16: ifnull +16 -> 32
    //   19: aload_1
    //   20: invokeinterface 102 1 0
    //   25: ifeq +7 -> 32
    //   28: aload_2
    //   29: ifnonnull +29 -> 58
    //   32: ldc 8
    //   34: iconst_2
    //   35: new 200	java/lang/StringBuilder
    //   38: dup
    //   39: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   42: ldc 203
    //   44: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: aload_2
    //   48: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   51: invokevirtual 213	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: invokestatic 219	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   57: return
    //   58: aload_2
    //   59: invokevirtual 76	com/tencent/common/app/AppInterface:getEntityManagerFactory	()Laukq;
    //   62: invokevirtual 82	aukq:createEntityManager	()Laukp;
    //   65: astore_3
    //   66: aload_3
    //   67: ifnull -10 -> 57
    //   70: aload_3
    //   71: invokevirtual 222	aukp:a	()Laukr;
    //   74: astore_2
    //   75: aload_2
    //   76: invokevirtual 226	aukr:a	()V
    //   79: aload_1
    //   80: invokeinterface 106 1 0
    //   85: astore_1
    //   86: aload_1
    //   87: invokeinterface 112 1 0
    //   92: ifeq +42 -> 134
    //   95: aload_0
    //   96: aload_3
    //   97: aload_1
    //   98: invokeinterface 116 1 0
    //   103: checkcast 84	com/tencent/mobileqq/mini/entry/MiniAppSettingSwitchInfoEntity
    //   106: invokespecial 57	com/tencent/mobileqq/mini/activity/MiniAppEntrySettingFragment:updateSwitchData	(Laukp;Lauko;)Z
    //   109: pop
    //   110: goto -24 -> 86
    //   113: astore_1
    //   114: invokestatic 229	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   117: ifeq +12 -> 129
    //   120: ldc 8
    //   122: iconst_2
    //   123: ldc 231
    //   125: aload_1
    //   126: invokestatic 235	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   129: aload_2
    //   130: invokevirtual 238	aukr:b	()V
    //   133: return
    //   134: aload_2
    //   135: invokevirtual 241	aukr:c	()V
    //   138: aload_2
    //   139: invokevirtual 238	aukr:b	()V
    //   142: return
    //   143: astore_1
    //   144: aload_2
    //   145: invokevirtual 238	aukr:b	()V
    //   148: aload_1
    //   149: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	150	0	this	MiniAppEntrySettingFragment
    //   0	150	1	paramList	List<MiniAppSettingSwitchInfoEntity>
    //   14	131	2	localObject	Object
    //   65	32	3	localaukp	aukp
    // Exception table:
    //   from	to	target	type
    //   79	86	113	java/lang/Exception
    //   86	110	113	java/lang/Exception
    //   134	138	113	java/lang/Exception
    //   79	86	143	finally
    //   86	110	143	finally
    //   114	129	143	finally
    //   134	138	143	finally
  }
  
  private void updateDataToDB(MiniAppSettingSwitchInfoEntity paramMiniAppSettingSwitchInfoEntity)
  {
    if ((paramMiniAppSettingSwitchInfoEntity == null) || (TextUtils.isEmpty(paramMiniAppSettingSwitchInfoEntity.key))) {
      return;
    }
    QLog.e("MiniAppEntrySettingFragment", 2, "updateDataToDB entity.key:" + paramMiniAppSettingSwitchInfoEntity.key);
    ThreadManager.excute(new MiniAppEntrySettingFragment.4(this, paramMiniAppSettingSwitchInfoEntity), 32, null, true);
  }
  
  private void updateLocalSwitchDataList(List<MiniAppSettingSwitchInfoEntity> paramList)
  {
    ThreadManager.excute(new MiniAppEntrySettingFragment.3(this, paramList), 32, null, true);
  }
  
  private boolean updateSwitchData(aukp paramaukp, auko paramauko)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramaukp.a()) {
      if (paramauko.getStatus() == 1000)
      {
        paramaukp.b(paramauko);
        if (paramauko.getStatus() == 1001) {
          bool1 = true;
        }
        paramaukp.a();
      }
    }
    do
    {
      return bool1;
      if ((paramauko.getStatus() != 1001) && (paramauko.getStatus() != 1002)) {
        break;
      }
      bool1 = paramaukp.a(paramauko);
      break;
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d("MiniAppEntrySettingFragment", 2, "updateEntity em closed e=" + paramauko.getTableName());
    return false;
  }
  
  public int getContentLayoutId()
  {
    return 2131561968;
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
    this.activity = getActivity();
    setTitle(ajya.a(2131706814));
    initData();
    initUI(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.activity.MiniAppEntrySettingFragment
 * JD-Core Version:    0.7.0.1
 */