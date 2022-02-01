package com.tencent.mobileqq.teamwork;

import android.app.Activity;
import com.tencent.mobileqq.app.BusinessObserver;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import org.json.JSONObject;

public class TenDocOCRExportObserver
  implements BusinessObserver
{
  public WeakReference<Activity> a;
  
  public TenDocOCRExportObserver(Activity paramActivity)
  {
    this.a = new WeakReference(paramActivity);
  }
  
  public void a() {}
  
  public void a(int paramInt) {}
  
  public void a(String paramString1, String paramString2) {}
  
  public void a(boolean paramBoolean, String paramString) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
              } while (paramObject == null);
              paramObject = (Object[])paramObject;
            } while (paramObject.length != 2);
            a((String)paramObject[0], (String)paramObject[1]);
            return;
            a();
            return;
          } while (paramObject == null);
          paramObject = (Object[])paramObject;
        } while (paramObject.length != 1);
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
        }
        catch (Exception paramObject)
        {
          paramObject.printStackTrace();
          a(paramObject.toString(), "");
          return;
        }
        a(paramInt + "", "");
        return;
      } while (paramObject == null);
      paramObject = (Object[])paramObject;
    } while (paramObject.length != 1);
    a(((Integer)paramObject[0]).intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TenDocOCRExportObserver
 * JD-Core Version:    0.7.0.1
 */