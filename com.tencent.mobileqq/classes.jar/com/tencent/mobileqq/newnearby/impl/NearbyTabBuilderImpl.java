package com.tencent.mobileqq.newnearby.impl;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.ProtoUtils;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.activity.NearbyActivityHelper;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.dating.BaseMsgBoxActivity;
import com.tencent.mobileqq.nearby.now.IResourceUtil;
import com.tencent.mobileqq.newnearby.INearbyResDownloader;
import com.tencent.mobileqq.newnearby.INearbyTabBuilder;
import com.tencent.mobileqq.newnearby.model.TabInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.TabLayoutCompat;
import com.tencent.mobileqq.widget.TabLayoutCompat.Tab;
import com.tencent.trpcprotocol.nearby.trpc_nearby_control.nearby_control.nearbyControl.GetTabConfigReq;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NearbyTabBuilderImpl
  implements INearbyTabBuilder
{
  private static final String TAG = "NearbyTabBuilderImpl";
  private List<TabInfo> mTabs = new ArrayList();
  
  private void doInitTab(Activity paramActivity, TabLayoutCompat paramTabLayoutCompat)
  {
    int j = this.mTabs.size();
    if (j == 0) {
      return;
    }
    int i = 0;
    while (i < j)
    {
      TabInfo localTabInfo = (TabInfo)this.mTabs.get(i);
      if (((localTabInfo.c == 0) && ((paramActivity instanceof NearbyActivity))) || ((localTabInfo.c == 4) && ((paramActivity instanceof BaseMsgBoxActivity)))) {
        paramTabLayoutCompat.d(paramTabLayoutCompat.a().a(Integer.valueOf(localTabInfo.d)).a(createTabItem(paramActivity, localTabInfo.b, localTabInfo.e, true)));
      } else {
        paramTabLayoutCompat.d(paramTabLayoutCompat.a().a(Integer.valueOf(localTabInfo.d)).a(createTabItem(paramActivity, localTabInfo.b, localTabInfo.f, false)));
      }
      i += 1;
    }
    if ((paramActivity instanceof NearbyActivity))
    {
      ((NearbyActivity)paramActivity).setMsgTabRedTouch(NearbyActivityHelper.a(paramActivity, paramTabLayoutCompat, TabInfo.a));
      return;
    }
    if ((paramActivity instanceof BaseMsgBoxActivity)) {
      ((BaseMsgBoxActivity)paramActivity).setMsgTabRedTouch(NearbyActivityHelper.a(paramActivity, paramTabLayoutCompat, TabInfo.a));
    }
  }
  
  private void initTab(Activity paramActivity, TabLayoutCompat paramTabLayoutCompat)
  {
    paramActivity.runOnUiThread(new NearbyTabBuilderImpl.2(this, paramActivity, paramTabLayoutCompat));
  }
  
  public void buildTabByConfig(ArrayList<Integer> paramArrayList, ArrayList<String> paramArrayList1, Activity paramActivity, TabLayoutCompat paramTabLayoutCompat)
  {
    this.mTabs.clear();
    int j = paramArrayList.size();
    int i = 0;
    while (i < j)
    {
      TabInfo localTabInfo = new TabInfo();
      localTabInfo.b = ((String)paramArrayList1.get(i));
      localTabInfo.c = ((Integer)paramArrayList.get(i)).intValue();
      localTabInfo.d = i;
      if (localTabInfo.c == 4) {
        TabInfo.a = localTabInfo.d;
      }
      localTabInfo.e = ((INearbyResDownloader)QRoute.api(INearbyResDownloader.class)).downloadImg(localTabInfo.c, true);
      localTabInfo.f = ((INearbyResDownloader)QRoute.api(INearbyResDownloader.class)).downloadImg(localTabInfo.c, false);
      this.mTabs.add(localTabInfo);
      i += 1;
    }
    initTab(paramActivity, paramTabLayoutCompat);
  }
  
  public View createTabItem(Activity paramActivity, String paramString, Drawable paramDrawable, boolean paramBoolean)
  {
    IResourceUtil localIResourceUtil = (IResourceUtil)QRoute.api(IResourceUtil.class);
    Object localObject = (TabLayoutCompat)paramActivity.findViewById(2131446755);
    localObject = LayoutInflater.from(paramActivity).inflate(localIResourceUtil.getNearbyTabItem(), (ViewGroup)localObject, false);
    TextView localTextView = (TextView)((View)localObject).findViewById(localIResourceUtil.getNearbyTabNameId());
    localTextView.setText(paramString);
    localTextView.setTextColor(paramActivity.getResources().getColor(localIResourceUtil.getNearbyTabColor(paramBoolean)));
    ((ImageView)((View)localObject).findViewById(localIResourceUtil.getNearbyTabIconId())).setImageDrawable(paramDrawable);
    return localObject;
  }
  
  public int getTabIdByTabType(int paramInt)
  {
    Object localObject = this.mTabs;
    if (localObject != null)
    {
      if (((List)localObject).size() == 0) {
        return 0;
      }
      localObject = this.mTabs.iterator();
      while (((Iterator)localObject).hasNext())
      {
        TabInfo localTabInfo = (TabInfo)((Iterator)localObject).next();
        if (localTabInfo.c == paramInt) {
          return localTabInfo.d;
        }
      }
    }
    return 0;
  }
  
  public int getTabTypeByTabId(int paramInt)
  {
    Object localObject = this.mTabs;
    if (localObject != null)
    {
      if (((List)localObject).size() == 0) {
        return 0;
      }
      localObject = this.mTabs.iterator();
      while (((Iterator)localObject).hasNext())
      {
        TabInfo localTabInfo = (TabInfo)((Iterator)localObject).next();
        if (localTabInfo.d == paramInt) {
          return localTabInfo.c;
        }
      }
    }
    return 0;
  }
  
  public List<Object> getTabs()
  {
    return this.mTabs;
  }
  
  public boolean hasMatchTab()
  {
    Iterator localIterator = this.mTabs.iterator();
    while (localIterator.hasNext()) {
      if (((TabInfo)localIterator.next()).c == 2) {
        return true;
      }
    }
    return false;
  }
  
  public void reqTabConfig(QBaseActivity paramQBaseActivity, TabLayoutCompat paramTabLayoutCompat)
  {
    nearbyControl.GetTabConfigReq localGetTabConfigReq = new nearbyControl.GetTabConfigReq();
    ProtoUtils.a(paramQBaseActivity.getAppRuntime(), new NearbyTabBuilderImpl.1(this, paramQBaseActivity, paramTabLayoutCompat), localGetTabConfigReq.toByteArray(), "trpc.nearby.trpc_nearby_control.nearby_control.GetTabConfig");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.newnearby.impl.NearbyTabBuilderImpl
 * JD-Core Version:    0.7.0.1
 */