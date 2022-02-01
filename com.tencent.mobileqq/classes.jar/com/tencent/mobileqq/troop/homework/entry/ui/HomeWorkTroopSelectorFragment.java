package com.tencent.mobileqq.troop.homework.entry.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopHWApi;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import mqq.os.MqqHandler;

public class HomeWorkTroopSelectorFragment
  extends QIphoneTitleBarFragment
  implements Runnable
{
  private ListView a;
  private AppInterface b;
  private boolean c;
  private String d = "";
  private List<String> e = null;
  private TroopInfo f = null;
  private HomeWorkTroopSelectorFragment.HwTroopAdapter g = null;
  
  public static void a(Activity paramActivity, String paramString, ArrayList<String> paramArrayList)
  {
    Intent localIntent = new Intent();
    if (!TextUtils.isEmpty(paramString)) {
      localIntent.putExtra("HomeWorkTroopSelectorFragment:my_troop_uin", paramString);
    }
    if (paramArrayList != null) {
      localIntent.putExtra("HomeWorkTroopSelectorFragment:select_troop_uin", paramArrayList);
    }
    QPublicFragmentActivity.startForResult(paramActivity, localIntent, HomeWorkTroopSelectorFragment.class, 263);
  }
  
  private void a(List<TroopInfo> paramList)
  {
    if (this.a != null)
    {
      this.g = new HomeWorkTroopSelectorFragment.HwTroopAdapter(getActivity(), paramList, this.f, this.e);
      this.a.setAdapter(this.g);
    }
  }
  
  protected int a()
  {
    return 2131626715;
  }
  
  protected void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    this.a = ((ListView)this.t.findViewById(2131435103));
    this.a.setDivider(null);
    this.a.setDividerHeight(0);
    if (getActivity() == null) {
      paramLayoutInflater = null;
    } else {
      paramLayoutInflater = (AppInterface)getQBaseActivity().getAppRuntime();
    }
    this.b = paramLayoutInflater;
    if (this.b == null)
    {
      getActivity().finish();
      return;
    }
    this.c = true;
    c(2131895228, new HomeWorkTroopSelectorFragment.1(this));
    a(HardCodeUtil.a(2131903489));
    paramLayoutInflater = getArguments();
    if (paramLayoutInflater != null)
    {
      this.d = paramLayoutInflater.getString("HomeWorkTroopSelectorFragment:my_troop_uin");
      if (this.d == null) {
        this.d = "";
      }
      this.e = paramLayoutInflater.getStringArrayList("HomeWorkTroopSelectorFragment:select_troop_uin");
      if (this.e == null) {
        this.e = new ArrayList();
      }
    }
    ThreadManager.postImmediately(this, null, true);
  }
  
  public boolean onBackEvent()
  {
    this.c = false;
    return super.onBackEvent();
  }
  
  public void run()
  {
    if (this.b == null) {
      return;
    }
    Object localObject1 = ((ITroopHWApi)QRoute.api(ITroopHWApi.class)).getTroopListUin(this.b, -2);
    if (localObject1 != null)
    {
      localObject1 = (String[])((HashMap)localObject1).get(Integer.valueOf(-2));
      if (this.d == null) {
        this.d = "";
      }
      ITroopInfoService localITroopInfoService = (ITroopInfoService)this.b.getRuntimeService(ITroopInfoService.class, "");
      if (!TextUtils.isEmpty(this.d)) {
        this.f = localITroopInfoService.findTroopInfo(this.d);
      }
      if (localObject1 != null)
      {
        LinkedList localLinkedList = new LinkedList();
        int j = localObject1.length;
        int i = 0;
        while (i < j)
        {
          Object localObject2 = localObject1[i];
          if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!this.d.equals(localObject2)))
          {
            localObject2 = localITroopInfoService.findTroopInfo((String)localObject2);
            if ((localObject2 != null) && (((((TroopInfo)localObject2).dwAdditionalFlag & 1L) == 1L) || ((((TroopInfo)localObject2).dwCmdUinUinFlag & 1L) == 1L))) {
              localLinkedList.add(localObject2);
            }
          }
          i += 1;
        }
        ThreadManager.getUIHandler().post(new HomeWorkTroopSelectorFragment.2(this, localLinkedList));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.entry.ui.HomeWorkTroopSelectorFragment
 * JD-Core Version:    0.7.0.1
 */