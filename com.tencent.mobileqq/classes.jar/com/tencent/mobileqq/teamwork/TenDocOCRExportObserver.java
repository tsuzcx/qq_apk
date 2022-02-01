package com.tencent.mobileqq.teamwork;

import android.app.Activity;
import com.tencent.mobileqq.app.BusinessObserver;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import org.json.JSONObject;

public class TenDocOCRExportObserver
  implements BusinessObserver
{
  public WeakReference<Activity> b;
  
  public TenDocOCRExportObserver(Activity paramActivity)
  {
    this.b = new WeakReference(paramActivity);
  }
  
  public void a() {}
  
  public void a(int paramInt) {}
  
  public void a(String paramString1, String paramString2) {}
  
  public void a(boolean paramBoolean, String paramString) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4) {
            return;
          }
          if (paramObject == null) {
            return;
          }
          paramObject = (Object[])paramObject;
          if (paramObject.length != 1) {
            return;
          }
          a(((Integer)paramObject[0]).intValue());
          return;
        }
        if (paramObject == null) {
          return;
        }
        paramObject = (Object[])paramObject;
        if (paramObject.length != 1) {
          return;
        }
        try
        {
          paramObject = (JSONObject)paramObject[0];
          String str = paramObject.optString("url");
          paramInt = paramObject.optInt("ret");
          paramObject = URLDecoder.decode(str, "UTF-8");
          if ((paramInt == 0) && (paramObject.length() > 0))
          {
            a(paramBoolean, paramObject);
            return;
          }
          paramObject = new StringBuilder();
          paramObject.append(paramInt);
          paramObject.append("");
          a(paramObject.toString(), "");
          return;
        }
        catch (Exception paramObject)
        {
          paramObject.printStackTrace();
          a(paramObject.toString(), "");
          return;
        }
      }
      a();
    }
    else if (paramObject != null)
    {
      paramObject = (Object[])paramObject;
      if (paramObject.length == 2) {
        a((String)paramObject[0], (String)paramObject[1]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TenDocOCRExportObserver
 * JD-Core Version:    0.7.0.1
 */