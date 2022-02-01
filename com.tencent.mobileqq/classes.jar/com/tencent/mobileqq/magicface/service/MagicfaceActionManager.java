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
  static final float[] jdField_a_of_type_ArrayOfFloat = { 1.4F, 1.5F, 1.6F, 1.7F, 1.8F, 1.9F, 2.0F, 2.1F, 2.2F, 2.3F };
  static final int[] jdField_a_of_type_ArrayOfInt = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 };
  public int a;
  long jdField_a_of_type_Long;
  public ShakeListener a;
  Emoticon jdField_a_of_type_ComTencentMobileqqDataEmoticon;
  Action jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionAction;
  ActionGlobalData jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData = null;
  MagicfaceActionDecoder jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionMagicfaceActionDecoder;
  MagicfaceResLoader jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceResLoader;
  public RecordVolume a;
  MagicfaceActionManager.MagicfaceActionListener jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager$MagicfaceActionListener;
  MagicfaceActionManager.MagicfaceCloseListener jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager$MagicfaceCloseListener;
  MagicfaceActionManager.MagicfaceSensorOperation jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager$MagicfaceSensorOperation = new MagicfaceActionManager.1(this);
  MagicfaceActionManager.MagicfaceTextUpdateListener jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager$MagicfaceTextUpdateListener;
  MagicfacePlayManager jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfacePlayManager;
  SoundPoolUtil jdField_a_of_type_ComTencentMobileqqMagicfaceServiceSoundPoolUtil;
  MagicfaceViewController jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController;
  String jdField_a_of_type_JavaLangString;
  List<Action> jdField_a_of_type_JavaUtilList;
  volatile boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = 0;
  long jdField_b_of_type_Long;
  volatile boolean jdField_b_of_type_Boolean = false;
  int jdField_c_of_type_Int = 0;
  volatile boolean jdField_c_of_type_Boolean = false;
  
  public MagicfaceActionManager(MagicfaceViewController paramMagicfaceViewController)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqAppShakeListener = new MagicfaceActionManager.3(this);
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelRecordVolume = new RecordVolume(new MagicfaceActionManager.4(this));
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
    paramEmoticon = new MagicfaceResLoader(EmotionPanelConstans.emoticonPackageFolderPath.replace("[epId]", paramEmoticon.epId));
    if (paramInt == 0) {
      paramEmoticon = paramEmoticon.a("send.xml");
    } else if (paramInt == 1) {
      paramEmoticon = paramEmoticon.a("receive.xml");
    } else {
      paramEmoticon = null;
    }
    return new MagicfaceActionDecoder().a(paramEmoticon);
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
    return new MagicfaceActionDecoder().a(paramEmoticon);
    label219:
    return null;
  }
  
  public int a()
  {
    ActionGlobalData localActionGlobalData = this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData;
    if ((localActionGlobalData != null) && (localActionGlobalData.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionMagicfacebackText != null)) {
      return this.jdField_b_of_type_Int;
    }
    return 0;
  }
  
  public List<Action> a(boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      Action localAction = (Action)localIterator.next();
      if (localAction != null) {
        if (paramBoolean)
        {
          if ("default".equals(localAction.jdField_a_of_type_JavaLangString))
          {
            localArrayList.add(localAction);
            return localArrayList;
          }
        }
        else if (!"default".equals(localAction.jdField_a_of_type_JavaLangString)) {
          localArrayList.add(localAction);
        }
      }
    }
    return localArrayList;
  }
  
  public void a()
  {
    this.jdField_b_of_type_Boolean = true;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionAction;
    if (localObject != null)
    {
      ((Action)localObject).c();
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionAction.d();
    }
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    localObject = this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData;
    if ((localObject != null) && (this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager$MagicfaceTextUpdateListener != null) && (((ActionGlobalData)localObject).e != null))
    {
      this.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.jdField_b_of_type_Int;
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager$MagicfaceTextUpdateListener.c(this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionMagicfacebackText.a(this.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.jdField_a_of_type_Float));
    }
  }
  
  void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MagicfaceActionManager", 2, "func initActionData begins.");
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfacePlayManager.a();
    if (paramInt == 1) {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceResLoader = new MagicfaceResLoader(EmotionPanelConstans.emoticonPackageFolderPath.replace("[epId]", this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId));
    } else if (paramInt == 2) {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceResLoader = new MagicfaceResLoader(EmotionPanelConstans.giftBigAnimationPath.replace("[epId]", this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId), 2);
    } else if (paramInt == 3) {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceResLoader = new MagicfaceResLoader(EmotionPanelConstans.emoticonPackageFolderPath.replace("[epId]", this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId), 3);
    }
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfacePlayManager.a(this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceResLoader);
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfacePlayManager.a(this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceSoundPoolUtil);
    if (QLog.isColorLevel()) {
      QLog.d("MagicfaceActionManager", 2, "func initActionData ends.");
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
      localStringBuilder.append(this.jdField_a_of_type_Boolean);
      localStringBuilder.append(",isRelease:");
      localStringBuilder.append(this.jdField_c_of_type_Boolean);
      QLog.d("MagicfaceActionManager", 2, localStringBuilder.toString());
    }
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqDataEmoticon = paramEmoticon;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_JavaLangString = paramString;
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager$MagicfaceActionListener;
    if (localObject != null) {
      ((MagicfaceActionManager.MagicfaceActionListener)localObject).a(paramActionGlobalData);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager$MagicfaceTextUpdateListener;
    if (localObject != null)
    {
      ((MagicfaceActionManager.MagicfaceTextUpdateListener)localObject).a(paramActionGlobalData.jdField_d_of_type_JavaLangString);
      if (this.jdField_a_of_type_Int == 1) {
        if (paramActionGlobalData.f != null)
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager$MagicfaceTextUpdateListener;
          String str = paramActionGlobalData.f;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("");
          localStringBuilder.append(paramActionGlobalData.jdField_b_of_type_Int);
          ((MagicfaceActionManager.MagicfaceTextUpdateListener)localObject).b(str.replace("%param%", localStringBuilder.toString()));
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager$MagicfaceTextUpdateListener.b("");
        }
      }
    }
    if (paramActionGlobalData.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionMagicfacebackText != null)
    {
      paramActionGlobalData.a(this);
      paramActionGlobalData.a();
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
    paramMagicfaceCloseListener = this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionAction;
    if (paramMagicfaceCloseListener != null) {
      paramMagicfaceCloseListener.d();
    }
    paramMagicfaceCloseListener = this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData;
    if (paramMagicfaceCloseListener != null) {
      paramMagicfaceCloseListener.a(null);
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
    Action localAction = this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionAction;
    if (localAction != null) {
      localAction.b(paramInt, this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager$MagicfaceSensorOperation);
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
    int j = 0;
    int i = 0;
    while (i < 3)
    {
      localObject[i] = 0;
      i += 1;
    }
    paramString = paramString.split("\\.");
    if ((paramString != null) && (paramString.length > 1))
    {
      i = j;
      try
      {
        while (i < localObject.length)
        {
          localObject[i] = Integer.valueOf(paramString[i]).intValue();
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("func splitVersion, intVers[");
            localStringBuilder.append(i);
            localStringBuilder.append("],=");
            localStringBuilder.append(localObject[i]);
            QLog.d("MagicfaceActionManager", 2, localStringBuilder.toString());
          }
          i += 1;
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionAction;
    if (localObject == null) {
      return;
    }
    localObject = ((Action)localObject).jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess;
    if ((localObject != null) && ("gravity".equalsIgnoreCase(((ActionProcess)localObject).jdField_b_of_type_JavaLangString))) {
      if ("record".equalsIgnoreCase(((ActionProcess)localObject).jdField_a_of_type_JavaLangString))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager$MagicfaceTextUpdateListener != null)
        {
          this.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.jdField_b_of_type_Int;
          this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager$MagicfaceTextUpdateListener.c(this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.e);
        }
      }
      else
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager$MagicfaceTextUpdateListener;
        if (localObject != null) {
          ((MagicfaceActionManager.MagicfaceTextUpdateListener)localObject).c(this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionMagicfacebackText.a(1, this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.jdField_a_of_type_Float));
        }
      }
    }
  }
  
  public void b(ActionGlobalData paramActionGlobalData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MagicfaceActionManager", 2, "func onEndMagicface, 【magic end】");
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager$MagicfaceCloseListener;
    if (localObject != null) {
      ((MagicfaceActionManager.MagicfaceCloseListener)localObject).a();
    }
    this.jdField_a_of_type_Boolean = false;
    if (paramActionGlobalData != null) {
      d(paramActionGlobalData);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager$MagicfaceActionListener;
    if (localObject != null) {
      ((MagicfaceActionManager.MagicfaceActionListener)localObject).b(paramActionGlobalData);
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
  
  void c()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController != null) && (this.jdField_a_of_type_Int == 0))
    {
      Action localAction = this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionAction;
      if ((localAction != null) && (localAction.jdField_d_of_type_Boolean)) {
        this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController.e();
      }
    }
  }
  
  public void c(ActionGlobalData paramActionGlobalData)
  {
    if ("mic".equalsIgnoreCase(paramActionGlobalData.c))
    {
      ThreadManager.executeOnNetWorkThread(this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelRecordVolume);
      return;
    }
    if ("gravity".equalsIgnoreCase(paramActionGlobalData.c))
    {
      paramActionGlobalData = (SensorManager)BaseApplicationImpl.getContext().getSystemService("sensor");
      paramActionGlobalData.registerListener(this.jdField_a_of_type_ComTencentMobileqqAppShakeListener, paramActionGlobalData.getDefaultSensor(1), 0);
      return;
    }
    "touch".equalsIgnoreCase(paramActionGlobalData.c);
  }
  
  public void c(boolean paramBoolean)
  {
    ActionGlobalData localActionGlobalData = this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData;
    if (localActionGlobalData != null) {
      localActionGlobalData.jdField_d_of_type_Boolean = true;
    }
  }
  
  public boolean c()
  {
    return BaseApplicationImpl.getApplication().getRuntime().getPreferences().getBoolean("receiveSound", false);
  }
  
  public void d()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData;
    boolean bool = false;
    if ((localObject != null) && (!"non-ver".equals(((ActionGlobalData)localObject).jdField_b_of_type_JavaLangString)))
    {
      localObject = a("8.7.0");
      int[] arrayOfInt = a(this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.jdField_b_of_type_JavaLangString);
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
        int i = 0;
        while ((i < arrayOfInt.length) && (localObject[i] <= arrayOfInt[i]))
        {
          if (localObject[i] < arrayOfInt[i]) {
            break label168;
          }
          i += 1;
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
      this.jdField_a_of_type_JavaUtilList = a(bool ^ true);
      return;
    }
    this.jdField_a_of_type_JavaUtilList = a(false);
  }
  
  public void d(ActionGlobalData paramActionGlobalData)
  {
    if ("mic".equalsIgnoreCase(paramActionGlobalData.c))
    {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelRecordVolume.a();
      return;
    }
    if ("gravity".equalsIgnoreCase(paramActionGlobalData.c)) {
      ((SensorManager)BaseApplicationImpl.getContext().getSystemService("sensor")).unregisterListener(this.jdField_a_of_type_ComTencentMobileqqAppShakeListener);
    }
  }
  
  public void e()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("func parseReceiveValue, magicValue:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.magicValue);
      QLog.d("MagicfaceActionManager", 2, ((StringBuilder)localObject).toString());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.magicValue != null)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.magicValue.split("&");
      if ((localObject.length >= 0) && (localObject[0].contains("value")))
      {
        localObject = localObject[0].split("=");
        if ((localObject != null) && (localObject.length == 2)) {
          this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.jdField_b_of_type_Int = Integer.parseInt(localObject[1]);
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("func parseReceiveValue, value:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.jdField_b_of_type_Int);
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
    a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
  }
  
  public void h()
  {
    this.jdField_c_of_type_Boolean = true;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData;
    if (localObject != null) {
      ((ActionGlobalData)localObject).a(null);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfacePlayManager;
    if (localObject != null)
    {
      ((MagicfacePlayManager)localObject).a(null);
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfacePlayManager.c();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceSoundPoolUtil;
    if (localObject != null)
    {
      ((SoundPoolUtil)localObject).a();
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceSoundPoolUtil = null;
    }
    if ((this.jdField_a_of_type_Int == 0) && (this.jdField_b_of_type_Long - this.jdField_a_of_type_Long > 0L))
    {
      localObject = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject != null) && ((localObject instanceof QQAppInterface))) {
        ReportController.b((QQAppInterface)localObject, "CliOper", "", "", "MbFasong", "MbZhizuoShichang", 0, 0, String.valueOf(this.jdField_b_of_type_Long - this.jdField_a_of_type_Long), "", "", "");
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.service.MagicfaceActionManager
 * JD-Core Version:    0.7.0.1
 */