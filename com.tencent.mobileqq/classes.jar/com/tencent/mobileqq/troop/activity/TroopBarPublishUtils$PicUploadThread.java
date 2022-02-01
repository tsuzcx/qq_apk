package com.tencent.mobileqq.troop.activity;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import azlo;
import bgip;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.jsp.MediaApiPlugin;
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
import zdr;

public class TroopBarPublishUtils$PicUploadThread
  implements Runnable
{
  private long a;
  protected Handler a;
  protected String a;
  protected final ArrayList<String> a;
  protected WeakReference<BaseActivity> a;
  protected boolean a;
  protected String b;
  
  public TroopBarPublishUtils$PicUploadThread(BaseActivity paramBaseActivity, Handler paramHandler, ArrayList<String> paramArrayList, String paramString)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(paramArrayList);
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramBaseActivity);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.b = "2";
  }
  
  private void a(int paramInt1, Object paramObject, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      return;
    }
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(paramInt1);
    if (paramObject != null) {
      localMessage.obj = paramObject;
    }
    localMessage.arg1 = paramInt2;
    localMessage.arg2 = paramInt3;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public void run()
  {
    this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
    if (this.jdField_a_of_type_MqqUtilWeakReference == null) {}
    for (BaseActivity localBaseActivity = null; this.jdField_a_of_type_JavaUtilArrayList.size() == 0; localBaseActivity = (BaseActivity)this.jdField_a_of_type_MqqUtilWeakReference.get())
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopBarPublishUtils", 2, "PicUploadThread path list is null!");
      }
      a(1001, null, -2, 0);
      return;
    }
    if ((localBaseActivity == null) || (localBaseActivity.app == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopBarPublishUtils", 2, "PicUploadThread activity is null!");
      }
      a(1001, this.jdField_a_of_type_JavaUtilArrayList.get(0), -1, 0);
      return;
    }
    String str1 = localBaseActivity.app.getCurrentAccountUin();
    String str2 = ((TicketManager)localBaseActivity.app.getManager(2)).getSkey(str1);
    if (TextUtils.isEmpty(str2))
    {
      a(1001, this.jdField_a_of_type_JavaUtilArrayList.get(0), 1000, 0);
      return;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    String str3;
    int i;
    Object localObject1;
    label291:
    Object localObject2;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        str3 = (String)localIterator.next();
        if ((!azlo.a(str3)) && (TroopBarPublishUtils.a()) && (TroopBarPublishUtils.jdField_a_of_type_Boolean)) {}
        for (i = 1;; i = 0)
        {
          localObject1 = (TroopBarPublishActivity.Pic_list)bgip.a.get(str3);
          if (localObject1 != null)
          {
            if (((TroopBarPublishActivity.Pic_list)localObject1).canReuse) {
              break;
            }
            bgip.a.remove(str3);
          }
          if ((!localBaseActivity.isFinishing()) && (!this.jdField_a_of_type_Boolean)) {
            break label291;
          }
          a(1001, str3, 1003, 0);
          return;
        }
        localObject1 = MediaApiPlugin.a(str3, 0);
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          a(1001, str3, 1001, 0);
          if (QLog.isColorLevel()) {
            QLog.d("TroopBarPublishUtils", 2, "scalePublishImage failed: path = " + str3);
          }
        }
        else
        {
          if (i == 0) {
            break label670;
          }
          localObject2 = new BitmapFactory.Options();
          ((BitmapFactory.Options)localObject2).inScaled = false;
          localObject2 = TroopBarPublishUtils.a(localBaseActivity, BitmapFactory.decodeFile((String)localObject1, (BitmapFactory.Options)localObject2));
          if (localObject2 != null)
          {
            localObject1 = ((String)localObject1).substring(0, ((String)localObject1).lastIndexOf(".")) + "_tribe_water_" + ((String)localObject1).substring(((String)localObject1).lastIndexOf("."));
            zdr.a((Bitmap)localObject2, Bitmap.CompressFormat.PNG, 100, (String)localObject1);
          }
        }
      }
    }
    label670:
    for (;;)
    {
      label445:
      localObject2 = new HashMap();
      ((HashMap)localObject2).put("type", this.b);
      if (QLog.isColorLevel()) {
        QLog.d("TroopBarPublishUtils", 2, "PicUploadThread type: " + this.b + " ,mUrl: " + this.jdField_a_of_type_JavaLangString);
      }
      localObject2 = bgip.a(this.jdField_a_of_type_JavaLangString, localBaseActivity, (String)localObject1, str1, str2, (Map)localObject2);
      if (i != 0) {
        new File((String)localObject1).delete();
      }
      if (localObject2 != null)
      {
        localObject1 = new TroopBarPublishActivity.Pic_list((JSONObject)localObject2);
        if (i == 0) {}
        for (boolean bool = true;; bool = false)
        {
          ((TroopBarPublishActivity.Pic_list)localObject1).canReuse = bool;
          bgip.a.put(str3, localObject1);
          break;
          i = 0;
          break label445;
        }
      }
      a(1001, str3, 1002, 0);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("TroopBarPublishUtils", 2, "singleUploadImage failed: path = " + str3);
      break;
      a(1003, this.jdField_a_of_type_JavaUtilArrayList.get(0), 0, (int)(SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopBarPublishUtils.PicUploadThread
 * JD-Core Version:    0.7.0.1
 */