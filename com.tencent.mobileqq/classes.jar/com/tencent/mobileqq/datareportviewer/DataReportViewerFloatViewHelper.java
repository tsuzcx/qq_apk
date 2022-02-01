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
  private static DataReportViewerFloatViewHelper jdField_a_of_type_ComTencentMobileqqDatareportviewerDataReportViewerFloatViewHelper;
  public static boolean a = true;
  private int jdField_a_of_type_Int;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new DataReportViewerFloatViewHelper.3(this);
  private WindowManager jdField_a_of_type_AndroidViewWindowManager;
  private DataReportViewer jdField_a_of_type_ComTencentMobileqqDatareportviewerDataReportViewer;
  private ArrayList<BaseReportDataConfig> jdField_a_of_type_JavaUtilArrayList = null;
  private HashMap<String, ReportDataConfig> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private boolean b = false;
  private boolean c;
  private boolean d;
  
  public static DataReportViewerFloatViewHelper a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqDatareportviewerDataReportViewerFloatViewHelper == null) {
        try
        {
          jdField_a_of_type_ComTencentMobileqqDatareportviewerDataReportViewerFloatViewHelper = new DataReportViewerFloatViewHelper();
        }
        finally {}
      }
      return jdField_a_of_type_ComTencentMobileqqDatareportviewerDataReportViewerFloatViewHelper;
    }
    finally {}
  }
  
  public ArrayList<BaseReportDataConfig> a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null)
    {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(10);
      Object localObject1 = BaseApplication.getContext().getFileStreamPath("DataReportConfigs");
      if ((localObject1 != null) && (((File)localObject1).exists()))
      {
        localObject1 = FileUtils.readFileContent((File)localObject1);
        try
        {
          localObject1 = new JSONArray((String)localObject1);
          int i = 0;
          while (i < ((JSONArray)localObject1).length())
          {
            Object localObject2 = ((JSONArray)localObject1).optJSONObject(i);
            if (TextUtils.isEmpty(((JSONObject)localObject2).optString("group")))
            {
              localObject2 = ReportDataConfig.a((JSONObject)localObject2);
              this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
              this.jdField_a_of_type_JavaUtilHashMap.put(((ReportDataConfig)localObject2).b, localObject2);
            }
            else
            {
              localObject2 = ReportDataConfigGroup.a((JSONObject)localObject2);
              this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
              localObject2 = ((ReportDataConfigGroup)localObject2).jdField_a_of_type_JavaUtilArrayList.iterator();
              while (((Iterator)localObject2).hasNext())
              {
                ReportDataConfig localReportDataConfig = (ReportDataConfig)((Iterator)localObject2).next();
                this.jdField_a_of_type_JavaUtilHashMap.put(localReportDataConfig.b, localReportDataConfig);
              }
            }
            i += 1;
          }
          return this.jdField_a_of_type_JavaUtilArrayList;
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
        }
      }
    }
  }
  
  public void a()
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    if (this.jdField_a_of_type_ComTencentMobileqqDatareportviewerDataReportViewer == null)
    {
      this.jdField_a_of_type_AndroidViewWindowManager = ((WindowManager)localBaseApplication.getSystemService("window"));
      this.jdField_a_of_type_ComTencentMobileqqDatareportviewerDataReportViewer = new DataReportViewerFloatViewHelper.2(this, localBaseApplication, localBaseApplication);
      this.jdField_a_of_type_ComTencentMobileqqDatareportviewerDataReportViewer.setOnTouchListener(this);
    }
    if (!this.b) {}
    try
    {
      this.jdField_a_of_type_AndroidViewWindowManager.removeViewImmediate(this.jdField_a_of_type_ComTencentMobileqqDatareportviewerDataReportViewer);
      label66:
      int i;
      if (Build.VERSION.SDK_INT >= 26) {
        i = 2038;
      } else {
        i = 2003;
      }
      WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams(-1, -2, i, 776, -2);
      localLayoutParams.gravity = 51;
      localLayoutParams.x = 0;
      localLayoutParams.y = DisplayUtil.a(localBaseApplication, 72.0F);
      try
      {
        this.jdField_a_of_type_AndroidViewWindowManager.addView(this.jdField_a_of_type_ComTencentMobileqqDatareportviewerDataReportViewer, localLayoutParams);
      }
      catch (Exception localException2)
      {
        label140:
        break label140;
      }
      QQToast.a(localBaseApplication, 1, HardCodeUtil.a(2131702936), 0).a();
      this.b = true;
      return;
    }
    catch (Exception localException1)
    {
      break label66;
    }
  }
  
  public void a(Context paramContext, boolean paramBoolean)
  {
    this.d = paramBoolean;
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putBoolean("DataReportViewerFloatViewHelper", paramBoolean);
    paramContext.apply();
  }
  
  public void a(BaseReportDataConfig paramBaseReportDataConfig)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(paramBaseReportDataConfig);
    e();
    if ((paramBaseReportDataConfig instanceof ReportDataConfig))
    {
      HashMap localHashMap = this.jdField_a_of_type_JavaUtilHashMap;
      paramBaseReportDataConfig = (ReportDataConfig)paramBaseReportDataConfig;
      localHashMap.put(paramBaseReportDataConfig.b, paramBaseReportDataConfig);
    }
  }
  
  public void a(ArrayList<BaseReportDataConfig> paramArrayList)
  {
    HashMap localHashMap = new HashMap();
    Object localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (BaseReportDataConfig)((Iterator)localObject1).next();
      localHashMap.put(((BaseReportDataConfig)localObject2).jdField_a_of_type_JavaLangString, Boolean.valueOf(((BaseReportDataConfig)localObject2).jdField_a_of_type_Boolean));
    }
    int k = 0;
    int j;
    for (int i = 0;; i = j + 1)
    {
      j = k;
      if (i >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
        break;
      }
      localObject1 = (BaseReportDataConfig)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      j = i;
      if (!((BaseReportDataConfig)localObject1).a())
      {
        this.jdField_a_of_type_JavaUtilArrayList.remove(i);
        i -= 1;
        if ((localObject1 instanceof ReportDataConfig))
        {
          this.jdField_a_of_type_JavaUtilHashMap.remove(((ReportDataConfig)localObject1).b);
          j = i;
        }
        else
        {
          j = i;
          if ((localObject1 instanceof ReportDataConfigGroup))
          {
            localObject1 = ((ReportDataConfigGroup)localObject1).jdField_a_of_type_JavaUtilArrayList.iterator();
            for (;;)
            {
              j = i;
              if (!((Iterator)localObject1).hasNext()) {
                break;
              }
              localObject2 = (ReportDataConfig)((Iterator)localObject1).next();
              this.jdField_a_of_type_JavaUtilHashMap.remove(((ReportDataConfig)localObject2).b);
            }
          }
        }
      }
    }
    while (j < paramArrayList.size())
    {
      localObject2 = (BaseReportDataConfig)paramArrayList.get(j);
      if (localHashMap.containsKey(((BaseReportDataConfig)localObject2).jdField_a_of_type_JavaLangString)) {
        ((BaseReportDataConfig)localObject2).jdField_a_of_type_Boolean = ((Boolean)localHashMap.get(((BaseReportDataConfig)localObject2).jdField_a_of_type_JavaLangString)).booleanValue();
      } else {
        ((BaseReportDataConfig)localObject2).jdField_a_of_type_Boolean = true;
      }
      if ((localObject2 instanceof ReportDataConfig))
      {
        localObject1 = this.jdField_a_of_type_JavaUtilHashMap;
        localObject2 = (ReportDataConfig)localObject2;
        ((HashMap)localObject1).put(((ReportDataConfig)localObject2).b, localObject2);
      }
      else if ((localObject2 instanceof ReportDataConfigGroup))
      {
        localObject1 = ((ReportDataConfigGroup)localObject2).jdField_a_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (ReportDataConfig)((Iterator)localObject1).next();
          this.jdField_a_of_type_JavaUtilHashMap.put(((ReportDataConfig)localObject2).b, localObject2);
        }
      }
      j += 1;
    }
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
    e();
  }
  
  public boolean a()
  {
    return this.d;
  }
  
  public void b()
  {
    if (this.b) {}
    try
    {
      this.jdField_a_of_type_AndroidViewWindowManager.removeViewImmediate(this.jdField_a_of_type_ComTencentMobileqqDatareportviewerDataReportViewer);
      label20:
      this.b = false;
      return;
    }
    catch (Exception localException)
    {
      break label20;
    }
  }
  
  public void b(BaseReportDataConfig paramBaseReportDataConfig)
  {
    this.jdField_a_of_type_JavaUtilArrayList.remove(paramBaseReportDataConfig);
    e();
    if ((paramBaseReportDataConfig instanceof ReportDataConfig))
    {
      this.jdField_a_of_type_JavaUtilHashMap.remove(((ReportDataConfig)paramBaseReportDataConfig).b);
      return;
    }
    if ((paramBaseReportDataConfig instanceof ReportDataConfigGroup))
    {
      paramBaseReportDataConfig = ((ReportDataConfigGroup)paramBaseReportDataConfig).jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramBaseReportDataConfig.hasNext())
      {
        ReportDataConfig localReportDataConfig = (ReportDataConfig)paramBaseReportDataConfig.next();
        this.jdField_a_of_type_JavaUtilHashMap.remove(localReportDataConfig.b);
      }
    }
  }
  
  public void c()
  {
    this.d = true;
    IntentFilter localIntentFilter = new IntentFilter("action.data.report.viewer");
    BaseApplicationImpl.getContext().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    a(BaseApplicationImpl.getApplication(), true);
  }
  
  public void d()
  {
    this.d = false;
    BaseApplicationImpl.getContext().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    b();
    a(BaseApplicationImpl.getApplication(), false);
  }
  
  public void e()
  {
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      localJSONArray.put(((BaseReportDataConfig)localIterator.next()).a());
    }
    FileUtils.writeFile(BaseApplication.getContext().getFileStreamPath("DataReportConfigs").getAbsolutePath(), localJSONArray.toString());
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    paramView = this.jdField_a_of_type_ComTencentMobileqqDatareportviewerDataReportViewer.getContext();
    int i = paramMotionEvent.getAction();
    int j = (int)paramMotionEvent.getRawY();
    if (i == 0)
    {
      this.jdField_a_of_type_Int = ((int)paramMotionEvent.getY());
      return false;
    }
    if (i == 2)
    {
      if ((this.c) || (Math.abs(paramMotionEvent.getY() - this.jdField_a_of_type_Int) > DisplayUtil.a(paramView, 10.0F)))
      {
        this.c = true;
        paramMotionEvent = (WindowManager.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqDatareportviewerDataReportViewer.getLayoutParams();
        paramMotionEvent.y = (j - this.jdField_a_of_type_Int - DisplayUtil.a(paramView, 0.0F));
        i = this.jdField_a_of_type_AndroidViewWindowManager.getDefaultDisplay().getHeight();
        if (paramMotionEvent.y < 0) {
          paramMotionEvent.y = 0;
        } else if (paramMotionEvent.y > i - this.jdField_a_of_type_ComTencentMobileqqDatareportviewerDataReportViewer.getHeight()) {
          paramMotionEvent.y = (i - this.jdField_a_of_type_ComTencentMobileqqDatareportviewerDataReportViewer.getHeight());
        }
        this.jdField_a_of_type_AndroidViewWindowManager.updateViewLayout(this.jdField_a_of_type_ComTencentMobileqqDatareportviewerDataReportViewer, paramMotionEvent);
      }
      return true;
    }
    if ((i != 1) && (i == 3)) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.datareportviewer.DataReportViewerFloatViewHelper
 * JD-Core Version:    0.7.0.1
 */