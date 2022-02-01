package com.tencent.mobileqq.datareportviewer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DataReportViewerFloatViewHelper
  implements View.OnTouchListener
{
  public static boolean a = true;
  private static DataReportViewerFloatViewHelper b;
  private boolean c = false;
  private WindowManager d;
  private DataReportViewer e;
  private ArrayList<BaseReportDataConfig> f = null;
  private HashMap<String, ReportDataConfig> g = new HashMap();
  private int h;
  private boolean i;
  private boolean j;
  private BroadcastReceiver k = new DataReportViewerFloatViewHelper.3(this);
  
  public static DataReportViewerFloatViewHelper a()
  {
    try
    {
      if (b == null) {
        try
        {
          b = new DataReportViewerFloatViewHelper();
        }
        finally {}
      }
      return b;
    }
    finally {}
  }
  
  public void a(Context paramContext, boolean paramBoolean)
  {
    this.j = paramBoolean;
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putBoolean("DataReportViewerFloatViewHelper", paramBoolean);
    paramContext.apply();
  }
  
  public void a(BaseReportDataConfig paramBaseReportDataConfig)
  {
    this.f.add(paramBaseReportDataConfig);
    h();
    if ((paramBaseReportDataConfig instanceof ReportDataConfig))
    {
      HashMap localHashMap = this.g;
      paramBaseReportDataConfig = (ReportDataConfig)paramBaseReportDataConfig;
      localHashMap.put(paramBaseReportDataConfig.c, paramBaseReportDataConfig);
    }
  }
  
  public void a(ArrayList<BaseReportDataConfig> paramArrayList)
  {
    HashMap localHashMap = new HashMap();
    Object localObject1 = this.f.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (BaseReportDataConfig)((Iterator)localObject1).next();
      localHashMap.put(((BaseReportDataConfig)localObject2).a, Boolean.valueOf(((BaseReportDataConfig)localObject2).b));
    }
    int i1 = 0;
    int n;
    for (int m = 0;; m = n + 1)
    {
      n = i1;
      if (m >= this.f.size()) {
        break;
      }
      localObject1 = (BaseReportDataConfig)this.f.get(m);
      n = m;
      if (!((BaseReportDataConfig)localObject1).b())
      {
        this.f.remove(m);
        m -= 1;
        if ((localObject1 instanceof ReportDataConfig))
        {
          this.g.remove(((ReportDataConfig)localObject1).c);
          n = m;
        }
        else
        {
          n = m;
          if ((localObject1 instanceof ReportDataConfigGroup))
          {
            localObject1 = ((ReportDataConfigGroup)localObject1).c.iterator();
            for (;;)
            {
              n = m;
              if (!((Iterator)localObject1).hasNext()) {
                break;
              }
              localObject2 = (ReportDataConfig)((Iterator)localObject1).next();
              this.g.remove(((ReportDataConfig)localObject2).c);
            }
          }
        }
      }
    }
    while (n < paramArrayList.size())
    {
      localObject2 = (BaseReportDataConfig)paramArrayList.get(n);
      if (localHashMap.containsKey(((BaseReportDataConfig)localObject2).a)) {
        ((BaseReportDataConfig)localObject2).b = ((Boolean)localHashMap.get(((BaseReportDataConfig)localObject2).a)).booleanValue();
      } else {
        ((BaseReportDataConfig)localObject2).b = true;
      }
      if ((localObject2 instanceof ReportDataConfig))
      {
        localObject1 = this.g;
        localObject2 = (ReportDataConfig)localObject2;
        ((HashMap)localObject1).put(((ReportDataConfig)localObject2).c, localObject2);
      }
      else if ((localObject2 instanceof ReportDataConfigGroup))
      {
        localObject1 = ((ReportDataConfigGroup)localObject2).c.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (ReportDataConfig)((Iterator)localObject1).next();
          this.g.put(((ReportDataConfig)localObject2).c, localObject2);
        }
      }
      n += 1;
    }
    this.f.addAll(paramArrayList);
    h();
  }
  
  public void b()
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    if (this.e == null)
    {
      this.d = ((WindowManager)localBaseApplication.getSystemService("window"));
      this.e = new DataReportViewerFloatViewHelper.2(this, localBaseApplication, localBaseApplication);
      this.e.setOnTouchListener(this);
    }
    if (!this.c) {}
    try
    {
      this.d.removeViewImmediate(this.e);
      label66:
      int m;
      if (Build.VERSION.SDK_INT >= 26) {
        m = 2038;
      } else {
        m = 2003;
      }
      WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams(-1, -2, m, 776, -2);
      localLayoutParams.gravity = 51;
      localLayoutParams.x = 0;
      localLayoutParams.y = DisplayUtil.a(localBaseApplication, 72.0F);
      try
      {
        this.d.addView(this.e, localLayoutParams);
      }
      catch (Exception localException2)
      {
        label140:
        break label140;
      }
      QQToast.makeText(localBaseApplication, 1, HardCodeUtil.a(2131900913), 0).show();
      this.c = true;
      return;
    }
    catch (Exception localException1)
    {
      break label66;
    }
  }
  
  public void b(BaseReportDataConfig paramBaseReportDataConfig)
  {
    this.f.remove(paramBaseReportDataConfig);
    h();
    if ((paramBaseReportDataConfig instanceof ReportDataConfig))
    {
      this.g.remove(((ReportDataConfig)paramBaseReportDataConfig).c);
      return;
    }
    if ((paramBaseReportDataConfig instanceof ReportDataConfigGroup))
    {
      paramBaseReportDataConfig = ((ReportDataConfigGroup)paramBaseReportDataConfig).c.iterator();
      while (paramBaseReportDataConfig.hasNext())
      {
        ReportDataConfig localReportDataConfig = (ReportDataConfig)paramBaseReportDataConfig.next();
        this.g.remove(localReportDataConfig.c);
      }
    }
  }
  
  public void c()
  {
    if (this.c) {}
    try
    {
      this.d.removeViewImmediate(this.e);
      label20:
      this.c = false;
      return;
    }
    catch (Exception localException)
    {
      break label20;
    }
  }
  
  public void d()
  {
    this.j = true;
    IntentFilter localIntentFilter = new IntentFilter("action.data.report.viewer");
    BaseApplicationImpl.getContext().registerReceiver(this.k, localIntentFilter);
    a(BaseApplicationImpl.getApplication(), true);
  }
  
  public void e()
  {
    this.j = false;
    BaseApplicationImpl.getContext().unregisterReceiver(this.k);
    c();
    a(BaseApplicationImpl.getApplication(), false);
  }
  
  public boolean f()
  {
    return this.j;
  }
  
  public ArrayList<BaseReportDataConfig> g()
  {
    if (this.f == null)
    {
      this.f = new ArrayList(10);
      Object localObject1 = BaseApplication.getContext().getFileStreamPath("DataReportConfigs");
      if ((localObject1 != null) && (((File)localObject1).exists()))
      {
        localObject1 = FileUtils.readFileContent((File)localObject1);
        try
        {
          localObject1 = new JSONArray((String)localObject1);
          int m = 0;
          while (m < ((JSONArray)localObject1).length())
          {
            Object localObject2 = ((JSONArray)localObject1).optJSONObject(m);
            if (TextUtils.isEmpty(((JSONObject)localObject2).optString("group")))
            {
              localObject2 = ReportDataConfig.a((JSONObject)localObject2);
              this.f.add(localObject2);
              this.g.put(((ReportDataConfig)localObject2).c, localObject2);
            }
            else
            {
              localObject2 = ReportDataConfigGroup.a((JSONObject)localObject2);
              this.f.add(localObject2);
              localObject2 = ((ReportDataConfigGroup)localObject2).c.iterator();
              while (((Iterator)localObject2).hasNext())
              {
                ReportDataConfig localReportDataConfig = (ReportDataConfig)((Iterator)localObject2).next();
                this.g.put(localReportDataConfig.c, localReportDataConfig);
              }
            }
            m += 1;
          }
          return this.f;
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
        }
      }
    }
  }
  
  public void h()
  {
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = this.f.iterator();
    while (localIterator.hasNext()) {
      localJSONArray.put(((BaseReportDataConfig)localIterator.next()).a());
    }
    FileUtils.writeFile(BaseApplication.getContext().getFileStreamPath("DataReportConfigs").getAbsolutePath(), localJSONArray.toString());
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    paramView = this.e.getContext();
    int m = paramMotionEvent.getAction();
    int n = (int)paramMotionEvent.getRawY();
    if (m == 0)
    {
      this.h = ((int)paramMotionEvent.getY());
      return false;
    }
    if (m == 2)
    {
      if ((this.i) || (Math.abs(paramMotionEvent.getY() - this.h) > DisplayUtil.a(paramView, 10.0F)))
      {
        this.i = true;
        paramMotionEvent = (WindowManager.LayoutParams)this.e.getLayoutParams();
        paramMotionEvent.y = (n - this.h - DisplayUtil.a(paramView, 0.0F));
        m = this.d.getDefaultDisplay().getHeight();
        if (paramMotionEvent.y < 0) {
          paramMotionEvent.y = 0;
        } else if (paramMotionEvent.y > m - this.e.getHeight()) {
          paramMotionEvent.y = (m - this.e.getHeight());
        }
        this.d.updateViewLayout(this.e, paramMotionEvent);
      }
      return true;
    }
    if ((m != 1) && (m == 3)) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.datareportviewer.DataReportViewerFloatViewHelper
 * JD-Core Version:    0.7.0.1
 */