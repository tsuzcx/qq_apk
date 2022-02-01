package com.tencent.mobileqq.kandian.biz.feedspopup;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
import android.widget.FrameLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.automator.BasePopupStep;
import com.tencent.mobileqq.kandian.base.automator.RIJPopupAutomator;
import com.tencent.mobileqq.kandian.biz.skin.CommonSkinRes;
import com.tencent.mobileqq.kandian.biz.skin.GuideData;
import com.tencent.mobileqq.kandian.biz.skin.ReadInJoyBaseResManager;
import com.tencent.mobileqq.kandian.biz.skin.ReadInJoyOperationManager;
import com.tencent.mobileqq.kandian.biz.skin.ReadInJoyRefreshManager;
import com.tencent.mobileqq.kandian.biz.skin.ReadInJoySkinGuideView;
import com.tencent.mobileqq.kandian.biz.skin.ReadInJoySkinHandler.ReadInJoySkinObserver;
import com.tencent.mobileqq.kandian.biz.skin.ReadInJoySkinManager;
import com.tencent.mobileqq.kandian.biz.skin.RefreshData;
import com.tencent.mobileqq.kandian.biz.skin.RefreshRes;
import com.tencent.mobileqq.kandian.biz.skin.entity.BaseResData;
import com.tencent.mobileqq.kandian.biz.skin.entity.SkinData;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x5bd.oidb_0x5bd.GuideInfo;
import tencent.im.oidb.cmd0x5bd.oidb_0x5bd.RefreshInfo;
import tencent.im.oidb.cmd0x5bd.oidb_0x5bd.SkinInfo;

public class RIJSkinOperationPopupStep
  extends BasePopupStep
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  @Nullable
  private ReadInJoySkinGuideView jdField_a_of_type_ComTencentMobileqqKandianBizSkinReadInJoySkinGuideView;
  private ReadInJoySkinHandler.ReadInJoySkinObserver jdField_a_of_type_ComTencentMobileqqKandianBizSkinReadInJoySkinHandler$ReadInJoySkinObserver = new RIJSkinOperationPopupStep.5(this);
  private ReadInJoyObserver jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver = new RIJSkinOperationPopupStep.7(this);
  @Nullable
  private String jdField_a_of_type_JavaLangString = null;
  private boolean jdField_a_of_type_Boolean = false;
  
  public RIJSkinOperationPopupStep(@NotNull RIJPopupAutomator paramRIJPopupAutomator, Activity paramActivity)
  {
    super(paramRIJPopupAutomator, "RIJSkinOperationPopupStep");
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  @UiThread
  private void a(GuideData paramGuideData, String paramString, int paramInt)
  {
    if (!a()) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinReadInJoySkinGuideView == null)
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      FrameLayout localFrameLayout = (FrameLayout)this.jdField_a_of_type_AndroidAppActivity.findViewById(2131365172);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinReadInJoySkinGuideView = new ReadInJoySkinGuideView(0, this.jdField_a_of_type_AndroidAppActivity, localQQAppInterface, paramGuideData.id, paramString, paramInt, new RIJSkinOperationPopupStep.3(this, localFrameLayout, paramInt, localQQAppInterface), new RIJSkinOperationPopupStep.4(this, localQQAppInterface, localFrameLayout, paramGuideData));
      if (a() == 0) {
        localFrameLayout.addView(this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinReadInJoySkinGuideView, -1, -1);
      }
    }
  }
  
  private void a(oidb_0x5bd.GuideInfo paramGuideInfo1, int paramInt, oidb_0x5bd.RefreshInfo paramRefreshInfo, oidb_0x5bd.SkinInfo paramSkinInfo, oidb_0x5bd.GuideInfo paramGuideInfo2)
  {
    boolean bool1 = a(paramGuideInfo1, paramInt);
    a(paramRefreshInfo, paramInt);
    boolean bool2 = a(paramInt, paramSkinInfo, paramGuideInfo2);
    ThreadManager.getUIHandler().post(new RIJSkinOperationPopupStep.6(this, bool1 | bool2));
  }
  
  private void a(oidb_0x5bd.RefreshInfo paramRefreshInfo, int paramInt)
  {
    int i = (int)(System.currentTimeMillis() / 1000L);
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    ReadInJoyRefreshManager localReadInJoyRefreshManager = (ReadInJoyRefreshManager)localQQAppInterface.getManager(QQManagerFactory.READ_INJOY_REFRESH_MANAGER);
    if (paramRefreshInfo.has()) {
      paramRefreshInfo = new RefreshData(paramRefreshInfo);
    } else {
      paramRefreshInfo = null;
    }
    RefreshData localRefreshData = localReadInJoyRefreshManager.a(this.jdField_a_of_type_AndroidAppActivity, paramInt);
    if (QLog.isColorLevel())
    {
      QLog.d("Q.readinjoy.4tab", 2, "onReqGuideInfo 5bd回包 ");
      StringBuilder localStringBuilder;
      if (paramRefreshInfo == null)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("newRefreshData = ");
        localStringBuilder.append(paramRefreshInfo);
        QLog.d("Q.readinjoy.4tab", 2, localStringBuilder.toString());
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("newRefreshData = ");
        localStringBuilder.append(paramRefreshInfo.toString());
        QLog.d("Q.readinjoy.4tab", 2, localStringBuilder.toString());
      }
      if (localRefreshData == null)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("oldRefreshData = ");
        localStringBuilder.append(localRefreshData);
        QLog.d("Q.readinjoy.4tab", 2, localStringBuilder.toString());
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("oldRefreshData = ");
        localStringBuilder.append(localRefreshData.toString());
        QLog.d("Q.readinjoy.4tab", 2, localStringBuilder.toString());
      }
    }
    if (paramRefreshInfo == null)
    {
      if (localRefreshData != null)
      {
        SharedPreUtils.f(this.jdField_a_of_type_AndroidAppActivity, localQQAppInterface.getCurrentAccountUin(), null, paramInt);
        FileUtils.deleteFilesInDirectory(RefreshRes.a());
        localReadInJoyRefreshManager.a(0, "", -1L, paramInt);
      }
    }
    else if (((localRefreshData == null) || (!paramRefreshInfo.id.equals(localRefreshData.id)) || (paramRefreshInfo.seq > localRefreshData.seq)) && (i <= paramRefreshInfo.endTime))
    {
      localReadInJoyRefreshManager.a(0, "", -1L, paramInt);
      FileUtils.deleteFilesInDirectory(RefreshRes.a());
      localReadInJoyRefreshManager.a(paramRefreshInfo, paramInt);
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.4tab", 2, "setRefreshType none and downloadRefreshRes");
      }
    }
    if (paramRefreshInfo != null)
    {
      paramRefreshInfo.showInFeeds = true;
      if (localRefreshData != null) {
        paramRefreshInfo.isShown = localRefreshData.isShown;
      }
      SharedPreUtils.f(this.jdField_a_of_type_AndroidAppActivity, localQQAppInterface.getCurrentAccountUin(), paramRefreshInfo.toJson().toString(), paramInt);
    }
  }
  
  private boolean a(int paramInt, String paramString, BaseResData paramBaseResData)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    ReadInJoyBaseResManager localReadInJoyBaseResManager = (ReadInJoyBaseResManager)localQQAppInterface.getManager(paramInt);
    if (localReadInJoyBaseResManager.a(paramString, paramBaseResData))
    {
      String str = localReadInJoyBaseResManager.a(paramString, paramBaseResData.id);
      if (localReadInJoyBaseResManager.b(paramString, paramBaseResData))
      {
        if (QQManagerFactory.READ_INJOY_SKIN_MANAGER == paramInt)
        {
          if (SharedPreUtils.d(this.jdField_a_of_type_AndroidAppActivity, paramBaseResData.id) != paramBaseResData.seq)
          {
            FileUtils.deleteDirectory(str);
            localReadInJoyBaseResManager.c(paramString, paramBaseResData);
            return false;
          }
          SharedPreUtils.p(this.jdField_a_of_type_AndroidAppActivity, localQQAppInterface.getCurrentAccountUin(), paramBaseResData.id);
          SharedPreUtils.r(this.jdField_a_of_type_AndroidAppActivity, localQQAppInterface.getCurrentAccountUin());
        }
        localReadInJoyBaseResManager.b(paramString, paramBaseResData);
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("checkAndSkinGuide：real: ");
          paramString.append(paramBaseResData.id);
          QLog.d("Q.readinjoy.4tab", 2, paramString.toString());
        }
        if ((paramBaseResData instanceof GuideData))
        {
          paramString = (GuideData)paramBaseResData;
          ThreadManager.getUIHandler().post(new RIJSkinOperationPopupStep.2(this, paramString, str, paramInt));
          return true;
        }
      }
      else
      {
        localReadInJoyBaseResManager.c(paramString, paramBaseResData);
      }
    }
    return false;
  }
  
  private boolean a(int paramInt, oidb_0x5bd.SkinInfo paramSkinInfo, oidb_0x5bd.GuideInfo paramGuideInfo)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    RefreshData localRefreshData = ((ReadInJoyRefreshManager)localQQAppInterface.getManager(QQManagerFactory.READ_INJOY_REFRESH_MANAGER)).a(this.jdField_a_of_type_AndroidAppActivity, paramInt);
    int i = (int)(System.currentTimeMillis() / 1000L);
    if (paramSkinInfo.has()) {
      paramSkinInfo = new SkinData(paramSkinInfo);
    } else {
      paramSkinInfo = null;
    }
    paramGuideInfo = new GuideData(paramGuideInfo, paramInt);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("guideData = ");
      ((StringBuilder)localObject).append(paramGuideInfo);
      QLog.d("Q.readinjoy.4tab", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (ReadInJoySkinManager)localQQAppInterface.getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER);
    if ((!this.jdField_a_of_type_Boolean) && (i >= paramGuideInfo.beginTime) && (i <= paramGuideInfo.endTime))
    {
      if (a(QQManagerFactory.READ_INJOY_SKIN_MANAGER, "", paramGuideInfo))
      {
        bool = true;
        break label211;
      }
    }
    else if ((i <= paramGuideInfo.endTime) && (NetworkUtil.isWifiConnected(this.jdField_a_of_type_AndroidAppActivity)))
    {
      ((ReadInJoySkinManager)localObject).a(paramGuideInfo);
      ((ReadInJoySkinManager)localObject).a(paramGuideInfo.skinData);
    }
    boolean bool = false;
    label211:
    paramGuideInfo = ((ReadInJoySkinManager)localObject).a(this.jdField_a_of_type_AndroidAppActivity);
    if ((paramSkinInfo == null) && (((ReadInJoySkinManager)localObject).a() == 1))
    {
      this.jdField_a_of_type_JavaLangString = ((ReadInJoySkinManager)localObject).a();
      SharedPreUtils.o(this.jdField_a_of_type_AndroidAppActivity, localQQAppInterface.getCurrentAccountUin(), null);
      if ((localRefreshData != null) && (i <= localRefreshData.endTime))
      {
        localRefreshData.isShown = true;
        SharedPreUtils.f(this.jdField_a_of_type_AndroidAppActivity, localQQAppInterface.getCurrentAccountUin(), localRefreshData.toJson().toString(), paramInt);
        return bool;
      }
    }
    else if ((paramSkinInfo != null) && (paramGuideInfo != null) && (paramGuideInfo.id.equals(paramSkinInfo.id)) && (paramGuideInfo.seq != paramSkinInfo.seq))
    {
      SharedPreUtils.o(this.jdField_a_of_type_AndroidAppActivity, localQQAppInterface.getCurrentAccountUin(), paramSkinInfo.toJson().toString());
      if (paramSkinInfo.id.equals(((ReadInJoySkinManager)localObject).a()))
      {
        this.jdField_a_of_type_JavaLangString = paramSkinInfo.id;
        return bool;
      }
      FileUtils.deleteDirectory(CommonSkinRes.a(paramSkinInfo.id));
    }
    return bool;
  }
  
  private boolean a(oidb_0x5bd.GuideInfo paramGuideInfo, int paramInt)
  {
    Object localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    int j = (int)(System.currentTimeMillis() / 1000L);
    ReadInJoyOperationManager localReadInJoyOperationManager = (ReadInJoyOperationManager)((QQAppInterface)localObject1).getManager(QQManagerFactory.READ_IN_JOY_OPERATION_MANAGER);
    if (paramGuideInfo.has()) {
      paramGuideInfo = new GuideData(paramGuideInfo, paramInt);
    } else {
      paramGuideInfo = null;
    }
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("guideData = ");
      ((StringBuilder)localObject2).append(paramGuideInfo);
      QLog.d("RIJSkinOperationPopupStep", 2, ((StringBuilder)localObject2).toString());
    }
    localObject1 = ((QQAppInterface)localObject1).getEntityManagerFactory().createEntityManager();
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramGuideInfo != null)
    {
      paramGuideInfo.business = "operation_guide";
      localObject2 = (GuideData)((EntityManager)localObject1).find(GuideData.class, new String[] { paramGuideInfo.id, paramGuideInfo.uin, paramGuideInfo.business });
      if ((localObject2 == null) || (((GuideData)localObject2).showTime == 0)) {
        ((EntityManager)localObject1).persistOrReplace(paramGuideInfo);
      }
      paramGuideInfo = localReadInJoyOperationManager.a("operation_guide", paramGuideInfo.id);
      if (paramGuideInfo != null)
      {
        paramGuideInfo = paramGuideInfo.iterator();
        int i = 0;
        for (;;)
        {
          bool2 = bool1;
          if (!paramGuideInfo.hasNext()) {
            break;
          }
          localObject1 = (GuideData)paramGuideInfo.next();
          if ((i == 0) && (((GuideData)localObject1).source == paramInt) && (j >= ((GuideData)localObject1).beginTime) && (j <= ((GuideData)localObject1).endTime))
          {
            if (a(QQManagerFactory.READ_IN_JOY_OPERATION_MANAGER, "operation_guide", (BaseResData)localObject1)) {
              bool1 = true;
            }
            this.jdField_a_of_type_Boolean = true;
            bool2 = bool1;
          }
          else
          {
            bool2 = bool1;
            if (j <= ((GuideData)localObject1).endTime)
            {
              bool2 = bool1;
              if (NetworkUtil.isWifiConnected(this.jdField_a_of_type_AndroidAppActivity))
              {
                localReadInJoyOperationManager.c("operation_guide", (BaseResData)localObject1);
                bool2 = bool1;
              }
            }
          }
          i += 1;
          bool1 = bool2;
        }
      }
    }
    else
    {
      localReadInJoyOperationManager.a(paramInt);
    }
    return bool2;
  }
  
  private void i()
  {
    ThreadManager.excute(new RIJSkinOperationPopupStep.1(this), 16, null, true);
  }
  
  private void j()
  {
    ReadInJoySkinGuideView localReadInJoySkinGuideView = this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinReadInJoySkinGuideView;
    if (localReadInJoySkinGuideView != null)
    {
      localReadInJoySkinGuideView.a();
      ((FrameLayout)this.jdField_a_of_type_AndroidAppActivity.findViewById(2131365172)).removeView(this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinReadInJoySkinGuideView);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinReadInJoySkinGuideView = null;
    }
  }
  
  public int a()
  {
    return 0;
  }
  
  public void a()
  {
    super.a();
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    localQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinReadInJoySkinHandler$ReadInJoySkinObserver);
    localQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
  }
  
  public void b()
  {
    super.b();
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    localQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinReadInJoySkinHandler$ReadInJoySkinObserver);
    localQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
  }
  
  public void d()
  {
    super.d();
    String str = this.jdField_a_of_type_JavaLangString;
    if (str != null)
    {
      FileUtils.deleteDirectory(CommonSkinRes.a(str));
      this.jdField_a_of_type_JavaLangString = null;
    }
  }
  
  protected void g() {}
  
  protected void h()
  {
    i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feedspopup.RIJSkinOperationPopupStep
 * JD-Core Version:    0.7.0.1
 */