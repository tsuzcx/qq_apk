package com.tencent.mobileqq.magicface.service;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.hardware.SensorManager;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ShakeListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emoticonview.EmotionPanelConstans;
import com.tencent.mobileqq.magicface.magicfaceaction.Action;
import com.tencent.mobileqq.magicface.magicfaceaction.ActionGlobalData;
import com.tencent.mobileqq.magicface.magicfaceaction.ActionGlobalData.ActionCountdownOver;
import com.tencent.mobileqq.magicface.magicfaceaction.ActionProcess;
import com.tencent.mobileqq.magicface.magicfaceaction.MagicfaceActionDecoder;
import com.tencent.mobileqq.magicface.magicfaceaction.MagicfacebackText;
import com.tencent.mobileqq.magicface.model.MagicfaceResLoader;
import com.tencent.mobileqq.magicface.model.RecordVolume;
import com.tencent.mobileqq.magicface.view.MagicfaceContainerView.MagicfaceGestureListener;
import com.tencent.mobileqq.magicface.view.MagicfaceViewController;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class MagicfaceActionManager
  implements ActionGlobalData.ActionCountdownOver, MagicfaceContainerView.MagicfaceGestureListener
{
  static final float[] v = { 1.4F, 1.5F, 1.6F, 1.7F, 1.8F, 1.9F, 2.0F, 2.1F, 2.2F, 2.3F };
  static final int[] w = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 };
  public int a = 0;
  Emoticon b;
  String c;
  MagicfaceActionDecoder d;
  MagicfacePlayManager e;
  List<Action> f;
  MagicfaceResLoader g;
  Action h;
  volatile boolean i = false;
  volatile boolean j = false;
  volatile boolean k = false;
  MagicfaceActionManager.MagicfaceActionListener l;
  MagicfaceActionManager.MagicfaceTextUpdateListener m;
  MagicfaceActionManager.MagicfaceCloseListener n;
  SoundPoolUtil o;
  ActionGlobalData p = null;
  int q = 0;
  long r;
  long s;
  MagicfaceViewController t;
  MagicfaceActionManager.MagicfaceSensorOperation u = new MagicfaceActionManager.1(this);
  int x = 0;
  public ShakeListener y = new MagicfaceActionManager.3(this);
  public RecordVolume z = new RecordVolume(new MagicfaceActionManager.4(this));
  
  public MagicfaceActionManager(MagicfaceViewController paramMagicfaceViewController)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MagicfaceActionManager", 2, "func MagicfaceActionManager begins");
    }
    this.t = paramMagicfaceViewController;
    this.d = new MagicfaceActionDecoder();
    this.o = new SoundPoolUtil();
    if (QLog.isColorLevel()) {
      QLog.d("MagicfaceActionManager", 2, "func MagicfaceActionManager ends");
    }
  }
  
  public static ActionGlobalData a(Emoticon paramEmoticon, int paramInt)
  {
    return a(paramEmoticon, paramInt, 1);
  }
  
  public static ActionGlobalData a(Emoticon paramEmoticon, int paramInt1, int paramInt2)
  {
    return a(paramEmoticon, paramInt1, paramInt2, 0);
  }
  
  public static ActionGlobalData a(Emoticon paramEmoticon, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 == 1)
    {
      paramEmoticon = new MagicfaceResLoader(EmotionPanelConstans.emoticonPackageFolderPath.replace("[epId]", paramEmoticon.epId));
    }
    else if (paramInt2 == 2)
    {
      String str;
      StringBuilder localStringBuilder;
      if (paramInt3 == 1)
      {
        str = EmotionPanelConstans.giftBigAnimationPath;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramEmoticon.epId);
        localStringBuilder.append("_V");
        paramEmoticon = str.replace("[epId]", localStringBuilder.toString());
      }
      else
      {
        str = EmotionPanelConstans.giftBigAnimationPath;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramEmoticon.epId);
        localStringBuilder.append("_HD");
        paramEmoticon = str.replace("[epId]", localStringBuilder.toString());
      }
      paramEmoticon = new MagicfaceResLoader(paramEmoticon, 2);
    }
    else
    {
      if (paramInt2 != 3) {
        break label219;
      }
      paramEmoticon = new MagicfaceResLoader(EmotionPanelConstans.emoticonPackageFolderPath.replace("[epId]", paramEmoticon.epId), 3);
    }
    if (paramInt1 == 0) {
      paramEmoticon = paramEmoticon.a("send.xml");
    } else if (paramInt1 == 1) {
      paramEmoticon = paramEmoticon.a("receive.xml");
    } else {
      paramEmoticon = null;
    }
    if (paramEmoticon == null) {
      return null;
    }
    return new MagicfaceActionDecoder().b(paramEmoticon);
    label219:
    return null;
  }
  
  public static int b(Emoticon paramEmoticon, int paramInt)
  {
    paramEmoticon = new MagicfaceResLoader(EmotionPanelConstans.emoticonPackageFolderPath.replace("[epId]", paramEmoticon.epId));
    if (paramInt == 0) {
      paramEmoticon = paramEmoticon.a("send.xml");
    } else if (paramInt == 1) {
      paramEmoticon = paramEmoticon.a("receive.xml");
    } else {
      paramEmoticon = null;
    }
    return new MagicfaceActionDecoder().c(paramEmoticon);
  }
  
  public List<Action> a(boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.f.iterator();
    while (localIterator.hasNext())
    {
      Action localAction = (Action)localIterator.next();
      if (localAction != null) {
        if (paramBoolean)
        {
          if ("default".equals(localAction.b))
          {
            localArrayList.add(localAction);
            return localArrayList;
          }
        }
        else if (!"default".equals(localAction.b)) {
          localArrayList.add(localAction);
        }
      }
    }
    return localArrayList;
  }
  
  public void a()
  {
    this.j = true;
    Object localObject = this.h;
    if (localObject != null)
    {
      ((Action)localObject).d();
      this.h.e();
    }
    this.s = System.currentTimeMillis();
    localObject = this.p;
    if ((localObject != null) && (this.m != null) && (((ActionGlobalData)localObject).k != null))
    {
      this.q = this.p.i;
      this.m.c(this.p.m.a(this.q, this.p.p));
    }
  }
  
  public void a(Emoticon paramEmoticon, int paramInt, String paramString)
  {
    a(paramEmoticon, paramInt, paramString, 1);
  }
  
  public void a(Emoticon paramEmoticon, int paramInt1, String paramString, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("func doAction begins. isStart:");
      localStringBuilder.append(this.i);
      localStringBuilder.append(",isRelease:");
      localStringBuilder.append(this.k);
      QLog.d("MagicfaceActionManager", 2, localStringBuilder.toString());
    }
    if (this.i) {
      return;
    }
    this.b = paramEmoticon;
    this.a = paramInt1;
    this.c = paramString;
    ThreadManager.post(new MagicfaceActionManager.2(this, paramInt2, paramInt1), 8, null, true);
  }
  
  public void a(ActionGlobalData paramActionGlobalData)
  {
    if (paramActionGlobalData == null)
    {
      QLog.e("MagicfaceActionManager", 1, "onStartMagicface error : actionGlobalData = null");
      return;
    }
    c(paramActionGlobalData);
    Object localObject = this.l;
    if (localObject != null) {
      ((MagicfaceActionManager.MagicfaceActionListener)localObject).a(paramActionGlobalData);
    }
    localObject = this.m;
    if (localObject != null)
    {
      ((MagicfaceActionManager.MagicfaceTextUpdateListener)localObject).a(paramActionGlobalData.j);
      if (this.a == 1) {
        if (paramActionGlobalData.l != null)
        {
          localObject = this.m;
          String str = paramActionGlobalData.l;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("");
          localStringBuilder.append(paramActionGlobalData.i);
          ((MagicfaceActionManager.MagicfaceTextUpdateListener)localObject).b(str.replace("%param%", localStringBuilder.toString()));
        }
        else
        {
          this.m.b("");
        }
      }
    }
    if (paramActionGlobalData.m != null)
    {
      paramActionGlobalData.a(this);
      paramActionGlobalData.a();
    }
  }
  
  public void a(MagicfaceActionManager.MagicfaceActionListener paramMagicfaceActionListener)
  {
    this.l = paramMagicfaceActionListener;
  }
  
  public void a(MagicfaceActionManager.MagicfaceCloseListener paramMagicfaceCloseListener)
  {
    if (paramMagicfaceCloseListener != null) {
      this.n = paramMagicfaceCloseListener;
    }
    this.j = true;
    paramMagicfaceCloseListener = this.h;
    if (paramMagicfaceCloseListener != null) {
      paramMagicfaceCloseListener.e();
    }
    paramMagicfaceCloseListener = this.p;
    if (paramMagicfaceCloseListener != null) {
      paramMagicfaceCloseListener.a(null);
    }
  }
  
  public void a(MagicfaceActionManager.MagicfaceTextUpdateListener paramMagicfaceTextUpdateListener)
  {
    this.m = paramMagicfaceTextUpdateListener;
  }
  
  public void a(MagicfacePlayManager paramMagicfacePlayManager)
  {
    this.e = paramMagicfacePlayManager;
  }
  
  public boolean a(int paramInt)
  {
    Action localAction = this.h;
    if (localAction != null) {
      localAction.b(paramInt, this.u);
    }
    return false;
  }
  
  public int[] a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("func splitVersion begins, version:");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("MagicfaceActionManager", 2, ((StringBuilder)localObject).toString());
    }
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject = new int[3];
    int i2 = 0;
    int i1 = 0;
    while (i1 < 3)
    {
      localObject[i1] = 0;
      i1 += 1;
    }
    paramString = paramString.split("\\.");
    if ((paramString != null) && (paramString.length > 1))
    {
      i1 = i2;
      try
      {
        while (i1 < localObject.length)
        {
          localObject[i1] = Integer.valueOf(paramString[i1]).intValue();
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("func splitVersion, intVers[");
            localStringBuilder.append(i1);
            localStringBuilder.append("],=");
            localStringBuilder.append(localObject[i1]);
            QLog.d("MagicfaceActionManager", 2, localStringBuilder.toString());
          }
          i1 += 1;
        }
        if (!QLog.isColorLevel()) {
          break label205;
        }
      }
      catch (Throwable paramString)
      {
        paramString.printStackTrace();
      }
    }
    QLog.d("MagicfaceActionManager", 2, "func splitVersion ends");
    label205:
    return localObject;
  }
  
  public void b()
  {
    Object localObject = this.h;
    if (localObject == null) {
      return;
    }
    localObject = ((Action)localObject).i;
    if ((localObject != null) && ("gravity".equalsIgnoreCase(((ActionProcess)localObject).b))) {
      if ("record".equalsIgnoreCase(((ActionProcess)localObject).a))
      {
        if (this.m != null)
        {
          this.q = this.p.i;
          this.m.c(this.p.k);
        }
      }
      else
      {
        localObject = this.m;
        if (localObject != null) {
          ((MagicfaceActionManager.MagicfaceTextUpdateListener)localObject).c(this.p.m.a(1, this.p.p));
        }
      }
    }
  }
  
  void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MagicfaceActionManager", 2, "func initActionData begins.");
    }
    this.i = true;
    this.j = false;
    this.e.a();
    if (paramInt == 1) {
      this.g = new MagicfaceResLoader(EmotionPanelConstans.emoticonPackageFolderPath.replace("[epId]", this.b.epId));
    } else if (paramInt == 2) {
      this.g = new MagicfaceResLoader(EmotionPanelConstans.giftBigAnimationPath.replace("[epId]", this.b.epId), 2);
    } else if (paramInt == 3) {
      this.g = new MagicfaceResLoader(EmotionPanelConstans.emoticonPackageFolderPath.replace("[epId]", this.b.epId), 3);
    }
    this.e.a(this.g);
    this.e.a(this.o);
    if (QLog.isColorLevel()) {
      QLog.d("MagicfaceActionManager", 2, "func initActionData ends.");
    }
  }
  
  public void b(ActionGlobalData paramActionGlobalData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MagicfaceActionManager", 2, "func onEndMagicface, 【magic end】");
    }
    Object localObject = this.n;
    if (localObject != null) {
      ((MagicfaceActionManager.MagicfaceCloseListener)localObject).a();
    }
    this.i = false;
    if (paramActionGlobalData != null) {
      d(paramActionGlobalData);
    }
    localObject = this.l;
    if (localObject != null) {
      ((MagicfaceActionManager.MagicfaceActionListener)localObject).b(paramActionGlobalData);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    BaseApplicationImpl.getApplication().getRuntime().getPreferences().edit().putBoolean("sendSound", paramBoolean).commit();
  }
  
  void c()
  {
    if ((this.t != null) && (this.a == 0))
    {
      Action localAction = this.h;
      if ((localAction != null) && (localAction.n)) {
        this.t.f();
      }
    }
  }
  
  public void c(ActionGlobalData paramActionGlobalData)
  {
    if ("mic".equalsIgnoreCase(paramActionGlobalData.h))
    {
      ThreadManager.executeOnNetWorkThread(this.z);
      return;
    }
    if ("gravity".equalsIgnoreCase(paramActionGlobalData.h))
    {
      paramActionGlobalData = (SensorManager)BaseApplicationImpl.getContext().getSystemService("sensor");
      paramActionGlobalData.registerListener(this.y, paramActionGlobalData.getDefaultSensor(1), 0);
      return;
    }
    "touch".equalsIgnoreCase(paramActionGlobalData.h);
  }
  
  public void c(boolean paramBoolean)
  {
    BaseApplicationImpl.getApplication().getRuntime().getPreferences().edit().putBoolean("receiveSound", paramBoolean).commit();
  }
  
  public void d()
  {
    Object localObject = this.p;
    boolean bool = false;
    if ((localObject != null) && (!"non-ver".equals(((ActionGlobalData)localObject).f)))
    {
      localObject = a("8.8.17");
      int[] arrayOfInt = a(this.p.f);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("func filterAction, qqver:");
        localStringBuilder.append(localObject);
        localStringBuilder.append(",magicVer:");
        localStringBuilder.append(arrayOfInt);
        QLog.d("MagicfaceActionManager", 2, localStringBuilder.toString());
      }
      if ((localObject != null) && (arrayOfInt != null) && (localObject.length == arrayOfInt.length))
      {
        int i1 = 0;
        while ((i1 < arrayOfInt.length) && (localObject[i1] <= arrayOfInt[i1]))
        {
          if (localObject[i1] < arrayOfInt[i1]) {
            break label168;
          }
          i1 += 1;
        }
      }
      bool = true;
      label168:
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("func filterAction, isQQSupport:");
        ((StringBuilder)localObject).append(bool);
        QLog.d("MagicfaceActionManager", 2, ((StringBuilder)localObject).toString());
      }
      this.f = a(bool ^ true);
      return;
    }
    this.f = a(false);
  }
  
  public void d(ActionGlobalData paramActionGlobalData)
  {
    if ("mic".equalsIgnoreCase(paramActionGlobalData.h))
    {
      this.z.a();
      return;
    }
    if ("gravity".equalsIgnoreCase(paramActionGlobalData.h)) {
      ((SensorManager)BaseApplicationImpl.getContext().getSystemService("sensor")).unregisterListener(this.y);
    }
  }
  
  public void d(boolean paramBoolean)
  {
    ActionGlobalData localActionGlobalData = this.p;
    if (localActionGlobalData != null) {
      localActionGlobalData.n = true;
    }
  }
  
  public void e()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("func parseReceiveValue, magicValue:");
      ((StringBuilder)localObject).append(this.b.magicValue);
      QLog.d("MagicfaceActionManager", 2, ((StringBuilder)localObject).toString());
    }
    if (this.b.magicValue != null)
    {
      localObject = this.b.magicValue.split("&");
      if ((localObject.length >= 0) && (localObject[0].contains("value")))
      {
        localObject = localObject[0].split("=");
        if ((localObject != null) && (localObject.length == 2)) {
          this.p.i = Integer.parseInt(localObject[1]);
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("func parseReceiveValue, value:");
      ((StringBuilder)localObject).append(this.p.i);
      QLog.d("MagicfaceActionManager", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void f()
  {
    a(null);
  }
  
  public void g()
  {
    f();
    a(this.b, this.a, this.c);
  }
  
  public boolean h()
  {
    return this.i;
  }
  
  public void i()
  {
    this.k = true;
    Object localObject = this.p;
    if (localObject != null) {
      ((ActionGlobalData)localObject).a(null);
    }
    localObject = this.e;
    if (localObject != null)
    {
      ((MagicfacePlayManager)localObject).a(null);
      this.e.c();
    }
    localObject = this.o;
    if (localObject != null)
    {
      ((SoundPoolUtil)localObject).a();
      this.o = null;
    }
    if ((this.a == 0) && (this.s - this.r > 0L))
    {
      localObject = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject != null) && ((localObject instanceof QQAppInterface))) {
        ReportController.b((QQAppInterface)localObject, "CliOper", "", "", "MbFasong", "MbZhizuoShichang", 0, 0, String.valueOf(this.s - this.r), "", "", "");
      }
    }
    this.t = null;
  }
  
  public int j()
  {
    ActionGlobalData localActionGlobalData = this.p;
    if ((localActionGlobalData != null) && (localActionGlobalData.m != null)) {
      return this.q;
    }
    return 0;
  }
  
  public boolean k()
  {
    return BaseApplicationImpl.getApplication().getRuntime().getPreferences().getBoolean("sendSound", false);
  }
  
  public boolean l()
  {
    return BaseApplicationImpl.getApplication().getRuntime().getPreferences().getBoolean("receiveSound", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.service.MagicfaceActionManager
 * JD-Core Version:    0.7.0.1
 */