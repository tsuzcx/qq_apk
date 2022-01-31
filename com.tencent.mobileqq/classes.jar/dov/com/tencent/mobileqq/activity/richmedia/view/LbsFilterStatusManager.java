package dov.com.tencent.mobileqq.activity.richmedia.view;

import android.os.Handler;
import android.util.SparseArray;
import ansc;
import ansd;
import anse;
import ansg;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.activity.richmedia.LBSDetetor;
import dov.com.tencent.mobileqq.activity.richmedia.LBSDetetor.LBSTemplateListener;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import java.util.ArrayList;

public class LbsFilterStatusManager
  implements LBSDetetor.LBSTemplateListener
{
  private static LbsFilterStatusManager jdField_a_of_type_DovComTencentMobileqqActivityRichmediaViewLbsFilterStatusManager;
  private int jdField_a_of_type_Int = 2;
  private long jdField_a_of_type_Long;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private SparseArray jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(1);
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private INetInfoHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new anse(this);
  private LbsFilterStatusManager.LbsUpdateFilter jdField_a_of_type_DovComTencentMobileqqActivityRichmediaViewLbsFilterStatusManager$LbsUpdateFilter;
  private PtvTemplateManager.PtvTemplateInfo jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo;
  private boolean jdField_a_of_type_Boolean = true;
  private boolean b;
  
  private LbsFilterStatusManager(AppInterface paramAppInterface)
  {
    if (paramAppInterface == null) {
      throw new RuntimeException("new LbsFilterStatusManager app==null");
    }
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_a_of_type_AndroidUtilSparseArray.put(1, ansg.a());
    this.jdField_a_of_type_Long = Thread.currentThread().getId();
    AppNetConnInfo.registerConnectionChangeReceiver(VideoEnvironment.a(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
  }
  
  public static LbsFilterStatusManager a(AppInterface paramAppInterface)
  {
    try
    {
      if (jdField_a_of_type_DovComTencentMobileqqActivityRichmediaViewLbsFilterStatusManager == null)
      {
        jdField_a_of_type_DovComTencentMobileqqActivityRichmediaViewLbsFilterStatusManager = new LbsFilterStatusManager(paramAppInterface);
        LBSDetetor.a(paramAppInterface).a(jdField_a_of_type_DovComTencentMobileqqActivityRichmediaViewLbsFilterStatusManager);
      }
      paramAppInterface = jdField_a_of_type_DovComTencentMobileqqActivityRichmediaViewLbsFilterStatusManager;
      return paramAppInterface;
    }
    finally {}
  }
  
  private String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "LBS_FILTER_UNINIT_KIND";
    case 1: 
      return "LBS_FILTER_LOADING_KIND";
    case 2: 
      return "LBS_FILTER_NOMAL_KIND";
    }
    return "LBS_FILTER_SPECIAL_KIND";
  }
  
  public static void a()
  {
    try
    {
      if (jdField_a_of_type_DovComTencentMobileqqActivityRichmediaViewLbsFilterStatusManager != null)
      {
        jdField_a_of_type_DovComTencentMobileqqActivityRichmediaViewLbsFilterStatusManager.c();
        jdField_a_of_type_DovComTencentMobileqqActivityRichmediaViewLbsFilterStatusManager = null;
      }
      LBSDetetor.a();
      return;
    }
    finally {}
  }
  
  private void a(int paramInt)
  {
    String str = this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.getLbsActivityType(paramInt);
    a("sendLoadingFilterMsg", String.format("[%s]acitvityName=%s", new Object[] { this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.name, str }), null);
    if ((this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.usable) && (a(this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.activityType)) && (this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.activityType == paramInt))
    {
      boolean bool = b(paramInt);
      a("sendLoadingFilterMsg", String.format("needRefresh=%s", new Object[] { "" + bool }), null);
      if ((this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaViewLbsFilterStatusManager$LbsUpdateFilter != null) && (bool))
      {
        a("sendLoadingFilterMsg", "refreshed filterName=" + this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.name, null);
        this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaViewLbsFilterStatusManager$LbsUpdateFilter.a(this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.name);
      }
    }
  }
  
  public static void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (QLog.isColorLevel())
    {
      if (paramThrowable != null) {
        QLog.i("LbsFilterStatusManager", 2, paramString1 + "_" + paramString2, paramThrowable);
      }
    }
    else {
      return;
    }
    QLog.i("LbsFilterStatusManager", 2, paramString1 + "_" + paramString2);
  }
  
  private boolean a(int paramInt)
  {
    return this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt) != null;
  }
  
  private void b()
  {
    ansg localansg = (ansg)this.jdField_a_of_type_AndroidUtilSparseArray.get(this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.activityType);
    a("startLocationUsingActivity", String.format("activityType=%s", new Object[] { this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.getLbsActivityType(this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.activityType) }), null);
    if ((localansg == null) || (!this.jdField_a_of_type_Boolean)) {}
    do
    {
      return;
      a("startLocationUsingActivity", String.format("mRequestStatus=%s", new Object[] { localansg.a() }), null);
    } while (localansg.jdField_a_of_type_Int != 3);
    a("startLocationUsingActivity", String.format("mRequestBeginTime=%s", new Object[] { "" + localansg.jdField_a_of_type_Long }), null);
    if (localansg.jdField_a_of_type_Long > 0L)
    {
      long l = System.currentTimeMillis() - localansg.jdField_a_of_type_Long;
      a("startLocationUsingActivity", String.format("diffTime=%s", new Object[] { "" + l }), null);
      if (l >= 30000L) {}
    }
    for (boolean bool = false;; bool = true)
    {
      a("startLocationUsingActivity", String.format("timeOK=%s", new Object[] { "" + bool }), null);
      if (!bool) {
        break;
      }
      localansg.c();
      localansg.b();
      localansg.jdField_a_of_type_Int = 1;
      localansg.jdField_a_of_type_Long = System.currentTimeMillis();
      LBSDetetor.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface).a(this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.activityType);
      return;
    }
  }
  
  private void b(int paramInt, boolean paramBoolean)
  {
    ansg localansg = (ansg)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localansg != null)
    {
      a("processLocationPermission", String.format("[%s]acitvityName=%s", new Object[] { "" + paramBoolean, this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.getLbsActivityType(paramInt) }), null);
      if (localansg.jdField_a_of_type_Int == 3) {
        break label98;
      }
      localansg.jdField_a_of_type_Boolean = paramBoolean;
      if (paramBoolean) {
        localansg.jdField_a_of_type_Int = 2;
      }
    }
    else
    {
      return;
    }
    localansg.jdField_a_of_type_Int = 3;
    a(paramInt);
    return;
    label98:
    a("processLocationPermission", String.format("[Error]Status=%s", new Object[] { localansg.a() }), null);
    localansg.jdField_a_of_type_Boolean = paramBoolean;
    localansg.jdField_a_of_type_JavaUtilArrayList.clear();
    localansg.jdField_a_of_type_Ansg.jdField_a_of_type_JavaUtilArrayList.clear();
    a(paramInt);
  }
  
  private void b(int paramInt, boolean paramBoolean, ArrayList paramArrayList)
  {
    ansg localansg = (ansg)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localansg != null)
    {
      a("processLocationForTemplate", String.format("[%s]acitvityName=%s", new Object[] { "" + paramBoolean, this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.getLbsActivityType(paramInt) }), null);
      if (localansg.jdField_a_of_type_Int != 3)
      {
        if (paramBoolean)
        {
          localansg.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
          a("processLocationForTemplate", String.format("templateIds= %s", new Object[] { paramArrayList.toString() }), null);
        }
        localansg.jdField_a_of_type_Int = 3;
        a(paramInt);
      }
    }
    else
    {
      return;
    }
    a("processLocationForTemplate", String.format("[Error]templateIds= %s,Status=%s", new Object[] { paramArrayList.toString(), localansg.a() }), null);
  }
  
  private boolean b(int paramInt)
  {
    ansg localansg = (ansg)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if ((localansg.jdField_a_of_type_Boolean) && (localansg.a(this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id))) {}
    for (paramInt = 3;; paramInt = 2)
    {
      a("filterNeedRefresh", String.format("newKindName=%s,currentKindName=%s", new Object[] { a(paramInt), a(this.jdField_a_of_type_Int) }), null);
      if (paramInt == this.jdField_a_of_type_Int) {
        break;
      }
      return true;
    }
    return false;
  }
  
  private void c()
  {
    this.b = false;
    AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo != null)
    {
      a("processMobile2WifiNet", String.format("activityType=%s", new Object[] { this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.getLbsActivityType(this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.activityType) }), null);
      if (!this.b) {
        b();
      }
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    long l = Thread.currentThread().getId();
    if (this.jdField_a_of_type_Long == l)
    {
      b(paramInt, paramBoolean);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new ansc(this, paramInt, paramBoolean));
  }
  
  public void a(int paramInt, boolean paramBoolean, ArrayList paramArrayList)
  {
    long l = Thread.currentThread().getId();
    if (this.jdField_a_of_type_Long == l)
    {
      b(paramInt, paramBoolean, paramArrayList);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new ansd(this, paramInt, paramBoolean, paramArrayList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.view.LbsFilterStatusManager
 * JD-Core Version:    0.7.0.1
 */