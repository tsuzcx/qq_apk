package com.tencent.mobileqq.remind;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.remind.widget.IosTimepicker;
import com.tencent.mobileqq.remind.widget.IosTimepicker.FormatDataListener;
import com.tencent.mobileqq.remind.widget.IosTimepicker.OnTimePickerSelectListener;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.widget.DispatchActionMoveScrollView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

public class RemindHelper
{
  private static IosTimepicker.FormatDataListener a;
  public static String a = "1";
  public static boolean a = true;
  public static String b = "0";
  private static String c = "remind";
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqRemindWidgetIosTimepicker$FormatDataListener = new RemindHelper.1();
  }
  
  public static int a(Context paramContext, String paramString1, long paramLong1, long paramLong2, String paramString2, String paramString3, int[] paramArrayOfInt)
  {
    return -9;
  }
  
  public static Long a(String paramString)
  {
    long l2 = new Date().getTime() / 1000L;
    long l1;
    try
    {
      l1 = Long.valueOf(paramString).longValue();
    }
    catch (NumberFormatException paramString)
    {
      l1 = l2;
      if (QLog.isColorLevel())
      {
        String str = c;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getLong error: ");
        localStringBuilder.append(paramString.getMessage());
        QLog.d(str, 2, localStringBuilder.toString());
        paramString.printStackTrace();
        l1 = l2;
      }
    }
    return Long.valueOf(l1);
  }
  
  public static String a(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = new JSONObject(paramString1).optString(paramString2);
      return paramString1;
    }
    catch (JSONException paramString1)
    {
      if (QLog.isColorLevel())
      {
        paramString2 = c;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getString from json error:");
        localStringBuilder.append(paramString1.getMessage());
        QLog.d(paramString2, 2, localStringBuilder.toString());
      }
    }
    return "";
  }
  
  public static void a(Context paramContext, long paramLong, IosTimepicker.OnTimePickerSelectListener paramOnTimePickerSelectListener, JsBridgeListener paramJsBridgeListener)
  {
    Object localObject = LayoutInflater.from(paramContext);
    if (jdField_a_of_type_Boolean)
    {
      jdField_a_of_type_Boolean = false;
      ActionSheet localActionSheet = ActionSheet.createMenuSheet(paramContext);
      ((DispatchActionMoveScrollView)localActionSheet.findViewById(2131361999)).jdField_a_of_type_Boolean = true;
      localObject = (IosTimepicker)((LayoutInflater)localObject).inflate(2131563056, null);
      ((IosTimepicker)localObject).setMaxDays(25568);
      DayAdapter localDayAdapter = new DayAdapter(paramContext, 25);
      NumberAdapter localNumberAdapter1 = new NumberAdapter(paramContext, TimeHelper.a, 25);
      NumberAdapter localNumberAdapter2 = new NumberAdapter(paramContext, TimeHelper.b, 25);
      int i = (int)TimeHelper.a(paramLong);
      int j = TimeHelper.a(paramLong);
      int k = TimeHelper.b(paramLong);
      IosTimepicker.FormatDataListener localFormatDataListener = jdField_a_of_type_ComTencentMobileqqRemindWidgetIosTimepicker$FormatDataListener;
      ((IosTimepicker)localObject).a(paramContext, localActionSheet, paramOnTimePickerSelectListener, null, new BaseAdapter[] { localDayAdapter, localNumberAdapter1, localNumberAdapter2 }, new int[] { i, j, k }, localFormatDataListener);
      if (Build.VERSION.SDK_INT >= 11) {
        localActionSheet.getWindow().setFlags(16777216, 16777216);
      }
      localActionSheet.setActionContentView((View)localObject, null);
      localActionSheet.setOnDismissListener(new RemindHelper.2((IosTimepicker)localObject, paramJsBridgeListener));
      try
      {
        localActionSheet.show();
        return;
      }
      catch (Throwable paramContext)
      {
        if (QLog.isColorLevel()) {
          QLog.d(c, 2, paramContext.getMessage());
        }
      }
    }
  }
  
  public static boolean a(String paramString)
  {
    return paramString.equalsIgnoreCase(jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.remind.RemindHelper
 * JD-Core Version:    0.7.0.1
 */