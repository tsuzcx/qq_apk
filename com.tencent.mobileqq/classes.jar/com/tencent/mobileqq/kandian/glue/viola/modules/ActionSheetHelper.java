package com.tencent.mobileqq.kandian.glue.viola.modules;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.WatchDismissActions;
import java.lang.ref.WeakReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ActionSheetHelper
  implements ActionSheet.WatchDismissActions
{
  public static String a = "BridgeModule.ActionSheetHelper";
  public boolean b = false;
  private ActionSheet c;
  private int d = 0;
  private WeakReference<BridgeModule> e = null;
  
  public ActionSheetHelper(BridgeModule paramBridgeModule)
  {
    this.e = new WeakReference(paramBridgeModule);
  }
  
  private void a(JSONObject paramJSONObject, String paramString)
  {
    Object localObject1;
    if (paramJSONObject != null)
    {
      localObject1 = this.e;
      if (localObject1 == null) {
        return;
      }
      localObject1 = ((BridgeModule)((WeakReference)localObject1).get()).getViolaInstance().getActivity();
      if (localObject1 == null) {
        return;
      }
    }
    for (;;)
    {
      int n;
      try
      {
        localObject1 = ActionSheet.create((Context)localObject1);
        Object localObject2 = paramJSONObject.optString("title");
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          ((ActionSheet)localObject1).setMainTitle((CharSequence)localObject2);
        }
        localObject2 = paramJSONObject.optJSONArray("items");
        int m = paramJSONObject.optInt("selected", -1);
        int k = 0;
        this.b = false;
        String str = paramJSONObject.optString("close");
        if (TextUtils.isEmpty(str)) {
          break label388;
        }
        this.b = true;
        ((ActionSheet)localObject1).addButton(str, 3);
        i = 1;
        j = i;
        if (localObject2 != null)
        {
          j = i;
          if (((JSONArray)localObject2).length() > 0)
          {
            n = ((JSONArray)localObject2).length();
            j = k;
            if (m >= 0)
            {
              j = k;
              if (m < n)
              {
                j = 0;
                if (j >= n) {
                  break label399;
                }
                str = ((JSONArray)localObject2).getString(j);
                if (j != m) {
                  break label393;
                }
                bool = true;
                ((ActionSheet)localObject1).addRadioButton(str, bool);
                j += 1;
                continue;
              }
            }
            if (j >= n) {
              break label399;
            }
            ((ActionSheet)localObject1).addButton(((JSONArray)localObject2).getString(j));
            j += 1;
            continue;
          }
        }
        paramJSONObject = paramJSONObject.optString("cancel");
        if (!TextUtils.isEmpty(paramJSONObject)) {
          ((ActionSheet)localObject1).addCancelButton(paramJSONObject);
        }
        ((ActionSheet)localObject1).setOnButtonClickListener(new ActionSheetHelper.2(this, paramString));
        ((ActionSheet)localObject1).setOnDismissListener(new ActionSheetHelper.3(this, paramString));
        ((ActionSheet)localObject1).setOnCancelListener(new ActionSheetHelper.4(this, paramString));
        ((ActionSheet)localObject1).registerWatchDisMissActionListener(this);
        this.c = ((ActionSheet)localObject1);
        this.d = j;
        this.c.show();
        return;
      }
      catch (JSONException paramJSONObject)
      {
        if (QLog.isColorLevel())
        {
          paramString = a;
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("showActionSheet error:");
          ((StringBuilder)localObject1).append(paramJSONObject.getMessage());
          QLog.d(paramString, 2, ((StringBuilder)localObject1).toString());
        }
      }
      return;
      label388:
      int i = 0;
      continue;
      label393:
      boolean bool = false;
      continue;
      label399:
      int j = i + n;
    }
  }
  
  public void a(JSONObject paramJSONObject, String paramString, Activity paramActivity)
  {
    if (this.e == null) {
      return;
    }
    if (Looper.myLooper() == null) {
      Looper.prepare();
    }
    new Handler(paramActivity.getMainLooper()).post(new ActionSheetHelper.1(this, paramJSONObject, paramString));
  }
  
  public void onDismissOperations() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.modules.ActionSheetHelper
 * JD-Core Version:    0.7.0.1
 */