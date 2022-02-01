package com.tencent.mobileqq.filemanager.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class QQFMSettings$StorageInfo
{
  boolean a;
  String b;
  String c;
  String d;
  long e;
  
  private QQFMSettings$StorageInfo(QQFMSettings paramQQFMSettings) {}
  
  public void a() {}
  
  public void a(Context paramContext)
  {
    paramContext.getSharedPreferences("FMSETTING_59", 3).edit().putString("DefaultRootPath", this.c).commit();
    paramContext = this.f;
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.c);
    ((StringBuilder)localObject1).append(this.d);
    paramContext = QQFMSettings.a(paramContext, ((StringBuilder)localObject1).toString());
    localObject1 = this.f;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.c);
    ((StringBuilder)localObject2).append(this.d);
    localObject1 = QQFMSettings.b((QQFMSettings)localObject1, ((StringBuilder)localObject2).toString());
    localObject2 = this.f;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.c);
    localStringBuilder.append(this.d);
    localObject2 = QQFMSettings.c((QQFMSettings)localObject2, localStringBuilder.toString());
    QQFMSettings.d(this.f, paramContext);
    QQFMSettings.d(this.f, (String)localObject2);
    QQFMSettings.d(this.f, (String)localObject1);
    paramContext = this.f.b.keySet().iterator();
    while (paramContext.hasNext())
    {
      localObject1 = (String)paramContext.next();
      localObject1 = (StorageInfo)this.f.b.get(localObject1);
      if ((((StorageInfo)localObject1).a) && (localObject1 != this))
      {
        paramContext = new StringBuilder();
        paramContext.append("getDefaultStorage[");
        paramContext.append(((StorageInfo)localObject1).c);
        paramContext.append("]");
        QQFMSettings.a(2, paramContext.toString());
        ((StorageInfo)localObject1).a = false;
      }
    }
    this.a = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.settings.QQFMSettings.StorageInfo
 * JD-Core Version:    0.7.0.1
 */