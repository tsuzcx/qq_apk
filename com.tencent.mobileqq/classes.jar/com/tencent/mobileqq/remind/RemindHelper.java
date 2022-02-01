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
  public static String a = "1";
  public static String b = "0";
  public static boolean c = true;
  private static String d = "remind";
  private static IosTimepicker.FormatDataListener e = new RemindHelper.1();
  
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
        String str = d;
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
        paramString2 = d;
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
    if (c)
    {
      c = false;
      ActionSheet localActionSheet = ActionSheet.createMenuSheet(paramContext);
      ((DispatchActionMoveScrollView)localActionSheet.findViewById(2131427560)).a = true;
      localObject = (IosTimepicker)((LayoutInflater)localObject).inflate(2131629672, null);
      ((IosTimepicker)localObject).setMaxDays(25568);
      DayAdapter localDayAdapter = new DayAdapter(paramContext, 25);
      NumberAdapter localNumberAdapter1 = new NumberAdapter(paramContext, TimeHelper.b, 25);
      NumberAdapter localNumberAdapter2 = new NumberAdapter(paramContext, TimeHelper.c, 25);
      int i = (int)TimeHelper.c(paramLong);
      int j = TimeHelper.a(paramLong);
      int k = TimeHelper.b(paramLong);
      IosTimepicker.FormatDataListener localFormatDataListener = e;
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
          QLog.d(d, 2, paramContext.getMessage());
        }
      }
    }
  }
  
  public static boolean b(String paramString)
  {
    return paramString.equalsIgnoreCase(a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.remind.RemindHelper
 * JD-Core Version:    0.7.0.1
 */