package com.tencent.mobileqq.emoticon;

import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import apoa;
import apod;
import bdcs;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public abstract class QQSysAndEmojiResInfo
{
  private static JSONObject a;
  protected Drawable a;
  protected apod a;
  protected ArrayList<Integer> a;
  protected HashMap<Integer, QQSysAndEmojiResInfo.QQEmoConfigItem> a;
  protected HashMap<Integer, Integer> b;
  
  public QQSysAndEmojiResInfo()
  {
    a();
  }
  
  public static void a(String paramString)
  {
    Object localObject = null;
    jdField_a_of_type_OrgJsonJSONObject = null;
    try
    {
      long l = System.currentTimeMillis();
      paramString = new File(paramString + "face_config.json");
      if (paramString.exists()) {}
      for (paramString = bdcs.a(paramString); (paramString != null) && (paramString.length() > 0); paramString = localObject)
      {
        jdField_a_of_type_OrgJsonJSONObject = new JSONObject(paramString);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("QQSysAndEmojiBaseInfo", 2, new Object[] { "getFaceConfigJson len:", Integer.valueOf(jdField_a_of_type_OrgJsonJSONObject.length()), " ,cost:", Long.valueOf(System.currentTimeMillis() - l) });
        return;
        QLog.d("QQSysAndEmojiBaseInfo", 1, "getFaceConfigJson not exist!");
        ThreadManager.getSubThreadHandler().post(new QQSysAndEmojiResInfo.1());
      }
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public abstract int a();
  
  public abstract int a(int paramInt);
  
  public abstract Drawable a(int paramInt);
  
  protected Drawable a(URL paramURL, Drawable paramDrawable, boolean paramBoolean, String paramString)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    if (paramDrawable == null) {
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {}
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = BaseApplicationImpl.getContext().getResources().getDrawable(2130837914);
        localURLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        localURLDrawableOptions.mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        localURLDrawableOptions.mPlayGifImage = paramBoolean;
        paramURL = a(paramURL, localURLDrawableOptions);
        if ((paramURL != null) && (!TextUtils.isEmpty(paramString))) {
          paramURL.addHeader("emoId", paramString);
        }
        return paramURL;
      }
      catch (Exception paramDrawable)
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable();
        QLog.e("QQSysAndEmojiBaseInfo", 1, "getDrawable exception e: = " + paramDrawable.getMessage());
        continue;
      }
      localURLDrawableOptions.mLoadingDrawable = paramDrawable;
      localURLDrawableOptions.mFailedDrawable = paramDrawable;
    }
  }
  
  protected URLDrawable a(URL paramURL, URLDrawable.URLDrawableOptions paramURLDrawableOptions)
  {
    return URLDrawable.getDrawable(paramURL, paramURLDrawableOptions);
  }
  
  public abstract String a(int paramInt);
  
  public ArrayList<Integer> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public JSONObject a()
  {
    if (jdField_a_of_type_OrgJsonJSONObject == null) {
      a(apoa.b());
    }
    return jdField_a_of_type_OrgJsonJSONObject;
  }
  
  public abstract void a();
  
  public abstract void a(int paramInt1, int paramInt2);
  
  protected void a(Drawable paramDrawable, int paramInt)
  {
    if ((paramDrawable instanceof URLDrawable))
    {
      paramDrawable = (URLDrawable)paramDrawable;
      if ((paramDrawable.getStatus() == 1) || (paramDrawable.getStatus() == 0)) {
        break label70;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQSysAndEmojiBaseInfo", 2, new Object[] { "reloadDrawable restartDownload:", Integer.valueOf(paramInt) });
      }
      paramDrawable.addHeader("emoId", Integer.toString(paramInt));
      paramDrawable.restartDownload();
    }
    label70:
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("QQSysAndEmojiBaseInfo", 2, new Object[] { "reloadDrawable do nothing:", Integer.valueOf(paramInt) });
  }
  
  public boolean a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap == null) {
      return false;
    }
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt))) {
      return a((QQSysAndEmojiResInfo.QQEmoConfigItem)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt)));
    }
    return true;
  }
  
  public boolean a(QQSysAndEmojiResInfo.QQEmoConfigItem paramQQEmoConfigItem)
  {
    return "1".equals(paramQQEmoConfigItem.QHide);
  }
  
  public int b()
  {
    int i = 0;
    if (this.jdField_a_of_type_JavaUtilHashMap != null) {
      i = this.jdField_a_of_type_JavaUtilHashMap.size();
    }
    return i;
  }
  
  public int b(int paramInt)
  {
    if ((this.b != null) && (this.b.containsKey(Integer.valueOf(paramInt)))) {
      return ((Integer)this.b.get(Integer.valueOf(paramInt))).intValue();
    }
    return -1;
  }
  
  public abstract void b();
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_Apod == null) {
      b();
    }
    this.jdField_a_of_type_Apod.a(paramInt);
  }
  
  public abstract void c();
  
  public void d()
  {
    if (this.jdField_a_of_type_Apod != null) {
      this.jdField_a_of_type_Apod.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo
 * JD-Core Version:    0.7.0.1
 */