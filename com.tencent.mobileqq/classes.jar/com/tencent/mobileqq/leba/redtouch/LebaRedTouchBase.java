package com.tencent.mobileqq.leba.redtouch;

import android.content.Context;
import com.tencent.mobileqq.leba.LebaConstant;
import com.tencent.mobileqq.leba.business.LebaRedTouchBizProxy;
import com.tencent.mobileqq.leba.config.LebaConfigApi;
import com.tencent.mobileqq.leba.core.LebaShowListManager;
import com.tencent.mobileqq.leba.entity.LebaExposureInfo;
import com.tencent.mobileqq.leba.entity.UpdateRedTouchParam;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.api.IRedTouchServer;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import mqq.app.AppRuntime;

public abstract class LebaRedTouchBase
{
  protected LebaRedTouchBizProxy a;
  protected HashSet<Long> a;
  protected Map<Long, LebaExposureInfo> a;
  protected boolean a;
  
  public LebaRedTouchBase()
  {
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_ComTencentMobileqqLebaBusinessLebaRedTouchBizProxy = new LebaRedTouchBizProxy();
    this.jdField_a_of_type_Boolean = true;
    a();
    b();
  }
  
  private void a(long paramLong, RedTouch paramRedTouch)
  {
    int i = LebaConstant.a(paramRedTouch);
    if (i != 0) {
      this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(paramLong), new LebaExposureInfo(i, LebaConstant.b(paramRedTouch)));
    }
  }
  
  private void a(AppRuntime paramAppRuntime, long paramLong, BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if ((!this.jdField_a_of_type_JavaUtilHashSet.contains(Long.valueOf(paramLong))) && (paramAppInfo != null) && (paramAppInfo.iNewFlag.get() != 0))
    {
      this.jdField_a_of_type_JavaUtilHashSet.add(Long.valueOf(paramLong));
      ((IRedTouchManager)paramAppRuntime.getRuntimeService(IRedTouchManager.class, "")).reportLevelOneRedInfo((int)paramLong, 30);
    }
  }
  
  public abstract BusinessInfoCheckUpdate.AppInfo a(AppRuntime paramAppRuntime, String paramString);
  
  public Map<Long, LebaExposureInfo> a()
  {
    return this.jdField_a_of_type_JavaUtilMap;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqLebaBusinessLebaRedTouchBizProxy.a();
  }
  
  public void a(UpdateRedTouchParam paramUpdateRedTouchParam)
  {
    AppRuntime localAppRuntime = paramUpdateRedTouchParam.jdField_a_of_type_MqqAppAppRuntime;
    Context localContext = paramUpdateRedTouchParam.jdField_a_of_type_AndroidContentContext;
    RedTouch localRedTouch = paramUpdateRedTouchParam.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch;
    long l = paramUpdateRedTouchParam.jdField_a_of_type_Long;
    String str = paramUpdateRedTouchParam.jdField_a_of_type_JavaLangString;
    int i = paramUpdateRedTouchParam.jdField_a_of_type_Int;
    boolean bool = paramUpdateRedTouchParam.jdField_a_of_type_Boolean;
    paramUpdateRedTouchParam = a(localAppRuntime, String.valueOf(l));
    a(localAppRuntime, l, paramUpdateRedTouchParam);
    if (this.jdField_a_of_type_Boolean) {
      bool = this.jdField_a_of_type_ComTencentMobileqqLebaBusinessLebaRedTouchBizProxy.a(localAppRuntime, localContext, l, localRedTouch, str, this.jdField_a_of_type_JavaUtilMap, i, bool);
    } else {
      bool = false;
    }
    QLog.d("Q.lebatab.LebaRedTouchBase", 1, new Object[] { "updateRedTouch,resID=", Long.valueOf(l), ",resPkgName=", str, ",isHandledRedTouch=", Boolean.valueOf(bool), ",leba_red_touch_spcific_enable->mSpecificEnable=", Boolean.valueOf(this.jdField_a_of_type_Boolean) });
    if (!bool)
    {
      a(localRedTouch, paramUpdateRedTouchParam);
      a(l, localRedTouch);
      this.jdField_a_of_type_ComTencentMobileqqLebaBusinessLebaRedTouchBizProxy.a(localAppRuntime, str, paramUpdateRedTouchParam);
    }
  }
  
  public abstract void a(RedTouch paramRedTouch, BusinessInfoCheckUpdate.AppInfo paramAppInfo);
  
  public void a(AppRuntime paramAppRuntime)
  {
    if (!this.jdField_a_of_type_JavaUtilHashSet.isEmpty()) {
      try
      {
        LebaShowListManager.jdField_a_of_type_Int |= 0x2;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onPause update");
        localStringBuilder.append(LebaShowListManager.jdField_a_of_type_Int);
        QLog.i("Q.lebatab.LebaRedTouchBase", 1, localStringBuilder.toString());
        ((IRedTouchServer)paramAppRuntime.getRuntimeService(IRedTouchServer.class, "")).notifyUI(4, true, null);
      }
      catch (Exception paramAppRuntime)
      {
        QLog.i("Q.lebatab.LebaRedTouchBase", 1, "onPause", paramAppRuntime);
      }
    }
    this.jdField_a_of_type_JavaUtilHashSet.clear();
    this.jdField_a_of_type_JavaUtilMap.clear();
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = new LebaConfigApi().c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.leba.redtouch.LebaRedTouchBase
 * JD-Core Version:    0.7.0.1
 */