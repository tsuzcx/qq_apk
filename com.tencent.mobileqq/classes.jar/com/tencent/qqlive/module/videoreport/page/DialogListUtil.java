package com.tencent.qqlive.module.videoreport.page;

import android.app.Activity;
import android.app.Dialog;
import android.content.ContextWrapper;
import android.support.annotation.NonNull;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;

public class DialogListUtil
{
  private static WeakHashMap<Activity, List<WeakReference<Dialog>>> mActivityDialogMap = new WeakHashMap();
  
  public static Activity getDialogActivity(Dialog paramDialog)
  {
    for (paramDialog = paramDialog.getContext();; paramDialog = ((ContextWrapper)paramDialog).getBaseContext())
    {
      if ((paramDialog instanceof Activity)) {
        return (Activity)paramDialog;
      }
      if (!(paramDialog instanceof ContextWrapper)) {
        return null;
      }
    }
  }
  
  public static List<WeakReference<Dialog>> getDialogList(Activity paramActivity)
  {
    return (List)mActivityDialogMap.get(paramActivity);
  }
  
  public static void onDialogResume(@NonNull Dialog paramDialog)
  {
    Activity localActivity = getDialogActivity(paramDialog);
    if (localActivity != null)
    {
      List localList = getDialogList(localActivity);
      Object localObject = localList;
      if (localList == null)
      {
        localObject = new ArrayList();
        mActivityDialogMap.put(localActivity, localObject);
      }
      saveDialog(paramDialog, (List)localObject);
    }
  }
  
  public static void onDialogStop(Dialog paramDialog)
  {
    Object localObject = getDialogActivity(paramDialog);
    if (localObject != null)
    {
      localObject = getDialogList((Activity)localObject);
      if (localObject != null) {
        removeDialog(paramDialog, (List)localObject);
      }
    }
  }
  
  private static void removeDialog(@NonNull Dialog paramDialog, @NonNull List<WeakReference<Dialog>> paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      paramList = (WeakReference)localIterator.next();
      if (paramList == null) {
        paramList = null;
      } else {
        paramList = (Dialog)paramList.get();
      }
      if ((paramList == null) || (paramList == paramDialog)) {
        localIterator.remove();
      }
    }
  }
  
  private static void saveDialog(Dialog paramDialog, List<WeakReference<Dialog>> paramList)
  {
    removeDialog(paramDialog, paramList);
    paramList.add(new WeakReference(paramDialog));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.page.DialogListUtil
 * JD-Core Version:    0.7.0.1
 */