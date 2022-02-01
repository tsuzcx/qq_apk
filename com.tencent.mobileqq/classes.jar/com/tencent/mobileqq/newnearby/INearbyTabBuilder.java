package com.tencent.mobileqq.newnearby;

import android.app.Activity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.widget.TabLayoutCompat;
import java.util.ArrayList;
import java.util.List;

@QAPI(process={"all"})
public abstract interface INearbyTabBuilder
  extends QRouteApi
{
  public abstract void buildTabByConfig(ArrayList<Integer> paramArrayList, ArrayList<String> paramArrayList1, Activity paramActivity, TabLayoutCompat paramTabLayoutCompat);
  
  public abstract int getTabIdByTabType(int paramInt);
  
  public abstract int getTabTypeByTabId(int paramInt);
  
  public abstract List<Object> getTabs();
  
  public abstract boolean hasMatchTab();
  
  public abstract void reqTabConfig(QBaseActivity paramQBaseActivity, TabLayoutCompat paramTabLayoutCompat);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.newnearby.INearbyTabBuilder
 * JD-Core Version:    0.7.0.1
 */