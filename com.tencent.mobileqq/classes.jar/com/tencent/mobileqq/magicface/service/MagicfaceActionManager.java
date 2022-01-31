package com.tencent.mobileqq.magicface.service;

import adqt;
import adqu;
import adqv;
import adqw;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.hardware.SensorManager;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ShakeListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
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
  static final float[] jdField_a_of_type_ArrayOfFloat = { 1.4F, 1.5F, 1.6F, 1.7F, 1.8F, 1.9F, 2.0F, 2.1F, 2.2F, 2.3F };
  static final int[] jdField_a_of_type_ArrayOfInt = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 };
  public int a;
  public long a;
  public ShakeListener a;
  public Emoticon a;
  public Action a;
  public ActionGlobalData a;
  public MagicfaceActionDecoder a;
  public MagicfaceResLoader a;
  public RecordVolume a;
  MagicfaceActionManager.MagicfaceActionListener jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager$MagicfaceActionListener;
  MagicfaceActionManager.MagicfaceCloseListener jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager$MagicfaceCloseListener;
  public MagicfaceActionManager.MagicfaceSensorOperation a;
  MagicfaceActionManager.MagicfaceTextUpdateListener jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager$MagicfaceTextUpdateListener;
  public MagicfacePlayManager a;
  SoundPoolUtil jdField_a_of_type_ComTencentMobileqqMagicfaceServiceSoundPoolUtil;
  MagicfaceViewController jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController;
  String jdField_a_of_type_JavaLangString;
  public List a;
  volatile boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = 0;
  long jdField_b_of_type_Long;
  public volatile boolean b;
  int c;
  public volatile boolean c;
  
  public MagicfaceActionManager(MagicfaceViewController paramMagicfaceViewController)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData = null;
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager$MagicfaceSensorOperation = new adqt(this);
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqAppShakeListener = new adqv(this);
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelRecordVolume = new RecordVolume(new adqw(this));
    if (QLog.isColorLevel()) {
      QLog.d("MagicfaceActionManager", 2, "func MagicfaceActionManager begins");
    }
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController = paramMagicfaceViewController;
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionMagicfaceActionDecoder = new MagicfaceActionDecoder();
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceSoundPoolUtil = new SoundPoolUtil();
    if (QLog.isColorLevel()) {
      QLog.d("MagicfaceActionManager", 2, "func MagicfaceActionManager ends");
    }
  }
  
  public static int a(Emoticon paramEmoticon, int paramInt)
  {
    MagicfaceResLoader localMagicfaceResLoader = new MagicfaceResLoader(EmoticonUtils.n.replace("[epId]", paramEmoticon.epId));
    paramEmoticon = null;
    if (paramInt == 0) {
      paramEmoticon = localMagicfaceResLoader.a("send.xml");
    }
    for (;;)
    {
      return new MagicfaceActionDecoder().a(paramEmoticon);
      if (paramInt == 1) {
        paramEmoticon = localMagicfaceResLoader.a("receive.xml");
      }
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
      paramEmoticon = new MagicfaceResLoader(EmoticonUtils.n.replace("[epId]", paramEmoticon.epId));
      if (paramInt1 != 0) {
        break label161;
      }
      paramEmoticon = paramEmoticon.a("send.xml");
    }
    for (;;)
    {
      if (paramEmoticon == null)
      {
        return null;
        if (paramInt2 == 2)
        {
          if (paramInt3 == 1) {}
          for (paramEmoticon = EmoticonUtils.m.replace("[epId]", paramEmoticon.epId + "_V");; paramEmoticon = EmoticonUtils.m.replace("[epId]", paramEmoticon.epId + "_HD"))
          {
            paramEmoticon = new MagicfaceResLoader(paramEmoticon, 2);
            break;
          }
        }
        if (paramInt2 == 3)
        {
          paramEmoticon = new MagicfaceResLoader(EmoticonUtils.n.replace("[epId]", paramEmoticon.epId), 3);
          break;
        }
        return null;
        label161:
        if (paramInt1 != 1) {
          break label188;
        }
        paramEmoticon = paramEmoticon.a("receive.xml");
        continue;
      }
      return new MagicfaceActionDecoder().a(paramEmoticon);
      label188:
      paramEmoticon = null;
    }
  }
  
  public int a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData != null) && (this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionMagicfacebackText != null)) {
      return this.jdField_b_of_type_Int;
    }
    return 0;
  }
  
  public List a(boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    for (;;)
    {
      Action localAction;
      if (localIterator.hasNext())
      {
        localAction = (Action)localIterator.next();
        if (localAction == null) {
          continue;
        }
        if (paramBoolean)
        {
          if (!"default".equals(localAction.jdField_a_of_type_JavaLangString)) {
            continue;
          }
          localArrayList.add(localAction);
        }
      }
      else
      {
        return localArrayList;
      }
      if (!"default".equals(localAction.jdField_a_of_type_JavaLangString)) {
        localArrayList.add(localAction);
      }
    }
  }
  
  public void a()
  {
    this.jdField_b_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionAction != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionAction.c();
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionAction.d();
    }
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    if ((this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData != null) && (this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager$MagicfaceTextUpdateListener != null) && (this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.e != null))
    {
      this.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.jdField_b_of_type_Int;
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager$MagicfaceTextUpdateListener.c(this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionMagicfacebackText.a(this.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.jdField_a_of_type_Float));
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MagicfaceActionManager", 2, "func initActionData begins.");
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfacePlayManager.a();
    if (paramInt == 1) {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceResLoader = new MagicfaceResLoader(EmoticonUtils.n.replace("[epId]", this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfacePlayManager.a(this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceResLoader);
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfacePlayManager.a(this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceSoundPoolUtil);
      if (QLog.isColorLevel()) {
        QLog.d("MagicfaceActionManager", 2, "func initActionData ends.");
      }
      return;
      if (paramInt == 2) {
        this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceResLoader = new MagicfaceResLoader(EmoticonUtils.m.replace("[epId]", this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId), 2);
      } else if (paramInt == 3) {
        this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceResLoader = new MagicfaceResLoader(EmoticonUtils.n.replace("[epId]", this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId), 3);
      }
    }
  }
  
  public void a(Emoticon paramEmoticon, int paramInt, String paramString)
  {
    a(paramEmoticon, paramInt, paramString, 1);
  }
  
  public void a(Emoticon paramEmoticon, int paramInt1, String paramString, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MagicfaceActionManager", 2, "func doAction begins. isStart:" + this.jdField_a_of_type_Boolean + ",isRelease:" + this.jdField_c_of_type_Boolean);
    }
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqDataEmoticon = paramEmoticon;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_JavaLangString = paramString;
    ThreadManager.post(new adqu(this, paramInt2, paramInt1), 8, null, true);
  }
  
  public void a(ActionGlobalData paramActionGlobalData)
  {
    if (paramActionGlobalData == null) {
      QLog.e("MagicfaceActionManager", 1, "onStartMagicface error : actionGlobalData = null");
    }
    for (;;)
    {
      return;
      c(paramActionGlobalData);
      if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager$MagicfaceActionListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager$MagicfaceActionListener.a(paramActionGlobalData);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager$MagicfaceTextUpdateListener != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager$MagicfaceTextUpdateListener.a(paramActionGlobalData.jdField_d_of_type_JavaLangString);
        if (this.jdField_a_of_type_Int == 1)
        {
          if (paramActionGlobalData.f == null) {
            break label130;
          }
          this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager$MagicfaceTextUpdateListener.b(paramActionGlobalData.f.replace("%param%", "" + paramActionGlobalData.jdField_b_of_type_Int));
        }
      }
      while (paramActionGlobalData.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionMagicfacebackText != null)
      {
        paramActionGlobalData.a(this);
        paramActionGlobalData.a();
        return;
        label130:
        this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager$MagicfaceTextUpdateListener.b("");
      }
    }
  }
  
  public void a(MagicfaceActionManager.MagicfaceActionListener paramMagicfaceActionListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager$MagicfaceActionListener = paramMagicfaceActionListener;
  }
  
  public void a(MagicfaceActionManager.MagicfaceCloseListener paramMagicfaceCloseListener)
  {
    if (paramMagicfaceCloseListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager$MagicfaceCloseListener = paramMagicfaceCloseListener;
    }
    this.jdField_b_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionAction != null) {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionAction.d();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData != null) {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.a(null);
    }
  }
  
  public void a(MagicfaceActionManager.MagicfaceTextUpdateListener paramMagicfaceTextUpdateListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager$MagicfaceTextUpdateListener = paramMagicfaceTextUpdateListener;
  }
  
  public void a(MagicfacePlayManager paramMagicfacePlayManager)
  {
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfacePlayManager = paramMagicfacePlayManager;
  }
  
  public void a(boolean paramBoolean)
  {
    BaseApplicationImpl.getApplication().getRuntime().getPreferences().edit().putBoolean("sendSound", paramBoolean).commit();
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionAction != null) {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionAction.b(paramInt, this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager$MagicfaceSensorOperation);
    }
    return false;
  }
  
  public int[] a(String paramString)
  {
    int j = 0;
    if (QLog.isColorLevel()) {
      QLog.d("MagicfaceActionManager", 2, "func splitVersion begins, version:" + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {
      paramString = null;
    }
    int[] arrayOfInt;
    do
    {
      return paramString;
      arrayOfInt = new int[3];
      int i = 0;
      while (i < 3)
      {
        arrayOfInt[i] = 0;
        i += 1;
      }
      paramString = paramString.split("\\.");
      if ((paramString != null) && (paramString.length > 1))
      {
        i = j;
        try
        {
          while (i < arrayOfInt.length)
          {
            arrayOfInt[i] = Integer.valueOf(paramString[i]).intValue();
            if (QLog.isColorLevel()) {
              QLog.d("MagicfaceActionManager", 2, "func splitVersion, intVers[" + i + "],=" + arrayOfInt[i]);
            }
            i += 1;
          }
          paramString = arrayOfInt;
        }
        catch (Throwable paramString)
        {
          paramString.printStackTrace();
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("MagicfaceActionManager", 2, "func splitVersion ends");
    return arrayOfInt;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionAction == null) {}
    do
    {
      do
      {
        ActionProcess localActionProcess;
        do
        {
          return;
          localActionProcess = this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionAction.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess;
        } while ((localActionProcess == null) || (!"gravity".equalsIgnoreCase(localActionProcess.jdField_b_of_type_JavaLangString)));
        if (!"record".equalsIgnoreCase(localActionProcess.jdField_a_of_type_JavaLangString)) {
          break;
        }
      } while (this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager$MagicfaceTextUpdateListener == null);
      this.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.jdField_b_of_type_Int;
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager$MagicfaceTextUpdateListener.c(this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.e);
      return;
    } while (this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager$MagicfaceTextUpdateListener == null);
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager$MagicfaceTextUpdateListener.c(this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionMagicfacebackText.a(1, this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.jdField_a_of_type_Float));
  }
  
  public void b(ActionGlobalData paramActionGlobalData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MagicfaceActionManager", 2, "func onEndMagicface, 【magic end】");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager$MagicfaceCloseListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager$MagicfaceCloseListener.a();
    }
    this.jdField_a_of_type_Boolean = false;
    if (paramActionGlobalData != null) {
      d(paramActionGlobalData);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager$MagicfaceActionListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager$MagicfaceActionListener.b(paramActionGlobalData);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    BaseApplicationImpl.getApplication().getRuntime().getPreferences().edit().putBoolean("receiveSound", paramBoolean).commit();
  }
  
  public boolean b()
  {
    return BaseApplicationImpl.getApplication().getRuntime().getPreferences().getBoolean("sendSound", false);
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController != null) && (this.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionAction != null) && (this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionAction.jdField_d_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController.e();
    }
  }
  
  public void c(ActionGlobalData paramActionGlobalData)
  {
    if ("mic".equalsIgnoreCase(paramActionGlobalData.c)) {
      ThreadManager.executeOnNetWorkThread(this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelRecordVolume);
    }
    do
    {
      return;
      if ("gravity".equalsIgnoreCase(paramActionGlobalData.c))
      {
        paramActionGlobalData = (SensorManager)BaseApplicationImpl.getContext().getSystemService("sensor");
        paramActionGlobalData.registerListener(this.jdField_a_of_type_ComTencentMobileqqAppShakeListener, paramActionGlobalData.getDefaultSensor(1), 0);
        return;
      }
    } while (!"touch".equalsIgnoreCase(paramActionGlobalData.c));
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData != null) {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.jdField_d_of_type_Boolean = true;
    }
  }
  
  public boolean c()
  {
    return BaseApplicationImpl.getApplication().getRuntime().getPreferences().getBoolean("receiveSound", false);
  }
  
  public void d()
  {
    boolean bool2 = true;
    if ((this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData == null) || ("non-ver".equals(this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.jdField_b_of_type_JavaLangString)))
    {
      this.jdField_a_of_type_JavaUtilList = a(false);
      return;
    }
    int[] arrayOfInt1 = a("7.6.0");
    int[] arrayOfInt2 = a(this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.jdField_b_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.d("MagicfaceActionManager", 2, "func filterAction, qqver:" + arrayOfInt1 + ",magicVer:" + arrayOfInt2);
    }
    int i;
    boolean bool1;
    if ((arrayOfInt1 != null) && (arrayOfInt2 != null) && (arrayOfInt1.length == arrayOfInt2.length))
    {
      i = 0;
      if (i < arrayOfInt2.length) {
        if (arrayOfInt1[i] > arrayOfInt2[i]) {
          bool1 = true;
        }
      }
    }
    for (;;)
    {
      label142:
      if (QLog.isColorLevel()) {
        QLog.d("MagicfaceActionManager", 2, "func filterAction, isQQSupport:" + bool1);
      }
      if (!bool1) {}
      for (bool1 = bool2;; bool1 = false)
      {
        this.jdField_a_of_type_JavaUtilList = a(bool1);
        return;
        if (arrayOfInt1[i] < arrayOfInt2[i])
        {
          bool1 = false;
          break label142;
        }
        i += 1;
        break;
      }
      bool1 = true;
    }
  }
  
  public void d(ActionGlobalData paramActionGlobalData)
  {
    if ("mic".equalsIgnoreCase(paramActionGlobalData.c)) {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelRecordVolume.a();
    }
    while (!"gravity".equalsIgnoreCase(paramActionGlobalData.c)) {
      return;
    }
    ((SensorManager)BaseApplicationImpl.getContext().getSystemService("sensor")).unregisterListener(this.jdField_a_of_type_ComTencentMobileqqAppShakeListener);
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MagicfaceActionManager", 2, "func parseReceiveValue, magicValue:" + this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.magicValue);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.magicValue != null)
    {
      String[] arrayOfString = this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.magicValue.split("&");
      if ((arrayOfString.length >= 0) && (arrayOfString[0].contains("value")))
      {
        arrayOfString = arrayOfString[0].split("=");
        if ((arrayOfString != null) && (arrayOfString.length == 2)) {
          this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.jdField_b_of_type_Int = Integer.parseInt(arrayOfString[1]);
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("MagicfaceActionManager", 2, "func parseReceiveValue, value:" + this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.jdField_b_of_type_Int);
    }
  }
  
  public void f()
  {
    a(null);
  }
  
  public void g()
  {
    f();
    a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
  }
  
  public void h()
  {
    this.jdField_c_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData != null) {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.a(null);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfacePlayManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfacePlayManager.a(null);
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfacePlayManager.c();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceSoundPoolUtil != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceSoundPoolUtil.a();
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceSoundPoolUtil = null;
    }
    if ((this.jdField_a_of_type_Int == 0) && (this.jdField_b_of_type_Long - this.jdField_a_of_type_Long > 0L))
    {
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {
        ReportController.b((QQAppInterface)localAppRuntime, "CliOper", "", "", "MbFasong", "MbZhizuoShichang", 0, 0, String.valueOf(this.jdField_b_of_type_Long - this.jdField_a_of_type_Long), "", "", "");
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.service.MagicfaceActionManager
 * JD-Core Version:    0.7.0.1
 */