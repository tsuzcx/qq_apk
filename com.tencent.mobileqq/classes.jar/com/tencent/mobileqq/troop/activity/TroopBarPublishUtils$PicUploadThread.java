package com.tencent.mobileqq.troop.activity;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.qqstory.utils.BitmapUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.jsp.MediaApiPlugin;
import com.tencent.mobileqq.troop.utils.TroopBarUtils;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import mqq.manager.TicketManager;
import mqq.util.WeakReference;
import org.json.JSONObject;

public class TroopBarPublishUtils$PicUploadThread
  implements Runnable
{
  protected final ArrayList<String> a;
  protected Handler b;
  protected WeakReference<BaseActivity> c;
  protected String d;
  protected String e;
  protected boolean f;
  private long g;
  
  private void a(int paramInt1, Object paramObject, int paramInt2, int paramInt3)
  {
    Object localObject = this.b;
    if (localObject == null) {
      return;
    }
    localObject = ((Handler)localObject).obtainMessage(paramInt1);
    if (paramObject != null) {
      ((Message)localObject).obj = paramObject;
    }
    ((Message)localObject).arg1 = paramInt2;
    ((Message)localObject).arg2 = paramInt3;
    this.b.sendMessage((Message)localObject);
  }
  
  public void run()
  {
    this.g = SystemClock.elapsedRealtime();
    Object localObject1 = this.c;
    BaseActivity localBaseActivity;
    if (localObject1 == null) {
      localBaseActivity = null;
    } else {
      localBaseActivity = (BaseActivity)((WeakReference)localObject1).get();
    }
    if (this.a.size() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopBarPublishUtils", 2, "PicUploadThread path list is null!");
      }
      a(1001, null, -2, 0);
      return;
    }
    if ((localBaseActivity != null) && (localBaseActivity.app != null))
    {
      String str1 = localBaseActivity.app.getCurrentAccountUin();
      String str2 = ((TicketManager)localBaseActivity.app.getManager(2)).getSkey(str1);
      if (TextUtils.isEmpty(str2))
      {
        a(1001, this.a.get(0), 1000, 0);
        return;
      }
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        String str3 = (String)localIterator.next();
        int i;
        if ((!BaseImageUtil.c(str3)) && (TroopBarPublishUtils.a()) && (TroopBarPublishUtils.b)) {
          i = 1;
        } else {
          i = 0;
        }
        localObject1 = (TroopBarPublishUtils.Pic_list)TroopBarUtils.f.get(str3);
        if (localObject1 != null)
        {
          if (!((TroopBarPublishUtils.Pic_list)localObject1).canReuse) {
            TroopBarUtils.f.remove(str3);
          }
        }
        else if ((!localBaseActivity.isFinishing()) && (!this.f))
        {
          Object localObject2 = MediaApiPlugin.b(str3, 0);
          if (TextUtils.isEmpty((CharSequence)localObject2))
          {
            a(1001, str3, 1001, 0);
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("scalePublishImage failed: path = ");
              ((StringBuilder)localObject1).append(str3);
              QLog.d("TroopBarPublishUtils", 2, ((StringBuilder)localObject1).toString());
            }
          }
          else
          {
            localObject1 = localObject2;
            Object localObject3;
            if (i != 0)
            {
              localObject1 = new BitmapFactory.Options();
              ((BitmapFactory.Options)localObject1).inScaled = false;
              localObject3 = TroopBarPublishUtils.a(localBaseActivity, BitmapFactory.decodeFile((String)localObject2, (BitmapFactory.Options)localObject1));
              if (localObject3 != null)
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append(((String)localObject2).substring(0, ((String)localObject2).lastIndexOf(".")));
                ((StringBuilder)localObject1).append("_tribe_water_");
                ((StringBuilder)localObject1).append(((String)localObject2).substring(((String)localObject2).lastIndexOf(".")));
                localObject1 = ((StringBuilder)localObject1).toString();
                BitmapUtils.a((Bitmap)localObject3, Bitmap.CompressFormat.PNG, 100, (String)localObject1);
              }
              else
              {
                localObject1 = localObject2;
                i = 0;
              }
            }
            localObject2 = new HashMap();
            ((HashMap)localObject2).put("type", this.e);
            if (QLog.isColorLevel())
            {
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("PicUploadThread type: ");
              ((StringBuilder)localObject3).append(this.e);
              ((StringBuilder)localObject3).append(" ,mUrl: ");
              ((StringBuilder)localObject3).append(this.d);
              QLog.d("TroopBarPublishUtils", 2, ((StringBuilder)localObject3).toString());
            }
            localObject2 = TroopBarUtils.a(this.d, localBaseActivity, (String)localObject1, str1, str2, (Map)localObject2);
            if (i != 0) {
              new File((String)localObject1).delete();
            }
            if (localObject2 != null)
            {
              localObject1 = new TroopBarPublishUtils.Pic_list((JSONObject)localObject2);
              ((TroopBarPublishUtils.Pic_list)localObject1).canReuse = (i ^ 0x1);
              TroopBarUtils.f.put(str3, localObject1);
            }
            else
            {
              a(1001, str3, 1002, 0);
              if (QLog.isColorLevel())
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append("singleUploadImage failed: path = ");
                ((StringBuilder)localObject1).append(str3);
                QLog.d("TroopBarPublishUtils", 2, ((StringBuilder)localObject1).toString());
              }
            }
          }
        }
        else
        {
          a(1001, str3, 1003, 0);
          return;
        }
      }
      a(1003, this.a.get(0), 0, (int)(SystemClock.elapsedRealtime() - this.g));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopBarPublishUtils", 2, "PicUploadThread activity is null!");
    }
    a(1001, this.a.get(0), -1, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopBarPublishUtils.PicUploadThread
 * JD-Core Version:    0.7.0.1
 */