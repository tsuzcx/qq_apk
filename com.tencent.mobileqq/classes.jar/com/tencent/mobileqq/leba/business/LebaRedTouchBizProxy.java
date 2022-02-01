package com.tencent.mobileqq.leba.business;

import android.content.Context;
import com.tencent.mobileqq.leba.business.redtouch.LebaSpecificRedTouchBiz;
import com.tencent.mobileqq.leba.entity.LebaExposureInfo;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;

public class LebaRedTouchBizProxy
{
  @ConfigInject(configPath="Business/qqleba-impl/src/main/resources/Inject_LebaBusiness.yml", version=1)
  public static ArrayList<Class<? extends ILebaRedTouchBiz>> a;
  public List<ILebaRedTouchBiz> a;
  
  static
  {
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    jdField_a_of_type_JavaUtilArrayList.add(LebaSpecificRedTouchBiz.class);
  }
  
  public LebaRedTouchBizProxy()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      Object localObject = jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        Class localClass = (Class)((Iterator)localObject).next();
        try
        {
          this.jdField_a_of_type_JavaUtilList.add(localClass.newInstance());
        }
        catch (Exception localException)
        {
          QLog.e("LebaBizRedTouchProxy", 1, localException, new Object[0]);
        }
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("initBizList size = ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaUtilList.size());
      QLog.i("LebaBizRedTouchProxy", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(AppRuntime paramAppRuntime, String paramString, BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((ILebaRedTouchBiz)localIterator.next()).a(paramAppRuntime, paramString, paramAppInfo);
    }
  }
  
  public boolean a(AppRuntime paramAppRuntime, Context paramContext, long paramLong, RedTouch paramRedTouch, String paramString, Map<Long, LebaExposureInfo> paramMap, int paramInt, boolean paramBoolean)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      if (((ILebaRedTouchBiz)localIterator.next()).a(paramAppRuntime, paramContext, paramLong, paramRedTouch, paramString, paramMap, paramInt, paramBoolean)) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.leba.business.LebaRedTouchBizProxy
 * JD-Core Version:    0.7.0.1
 */