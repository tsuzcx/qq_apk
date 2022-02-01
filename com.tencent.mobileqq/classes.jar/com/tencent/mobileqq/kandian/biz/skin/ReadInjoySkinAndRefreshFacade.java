package com.tencent.mobileqq.kandian.biz.skin;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.biz.skin.entity.BaseResData;
import com.tencent.mobileqq.kandian.biz.skin.entity.SkinData;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x5bd.oidb_0x5bd.GuideInfo;
import tencent.im.oidb.cmd0x5bd.oidb_0x5bd.RefreshInfo;
import tencent.im.oidb.cmd0x5bd.oidb_0x5bd.SkinInfo;

public class ReadInjoySkinAndRefreshFacade
{
  private int jdField_a_of_type_Int;
  protected AppInterface a;
  private ReadInJoySkinHandler.ReadInJoySkinObserver jdField_a_of_type_ComTencentMobileqqKandianBizSkinReadInJoySkinHandler$ReadInJoySkinObserver = new ReadInjoySkinAndRefreshFacade.2(this);
  ReadInjoySkinAndRefreshFacade.SkinAndRefreshCallback jdField_a_of_type_ComTencentMobileqqKandianBizSkinReadInjoySkinAndRefreshFacade$SkinAndRefreshCallback;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
  public ReadInjoySkinAndRefreshFacade(AppInterface paramAppInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  @Nullable
  private RefreshData a(int paramInt1, oidb_0x5bd.RefreshInfo paramRefreshInfo, int paramInt2)
  {
    ReadInJoyRefreshManager localReadInJoyRefreshManager = (ReadInJoyRefreshManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(QQManagerFactory.READ_INJOY_REFRESH_MANAGER);
    if (paramRefreshInfo.has()) {
      paramRefreshInfo = new RefreshData(paramRefreshInfo);
    } else {
      paramRefreshInfo = null;
    }
    RefreshData localRefreshData = localReadInJoyRefreshManager.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), paramInt2);
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
        SharedPreUtils.f(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), null, paramInt2);
        FileUtils.deleteFilesInDirectory(RefreshRes.a());
        localReadInJoyRefreshManager.a(0, "", -1L, paramInt2);
      }
    }
    else if (((localRefreshData == null) || (!paramRefreshInfo.id.equals(localRefreshData.id)) || (paramRefreshInfo.seq > localRefreshData.seq)) && (paramInt1 <= paramRefreshInfo.endTime))
    {
      FileUtils.deleteFilesInDirectory(RefreshRes.a());
      localReadInJoyRefreshManager.a(paramRefreshInfo, this.jdField_a_of_type_Int);
    }
    if (paramRefreshInfo != null)
    {
      paramRefreshInfo.setShowInSource(true, this.jdField_a_of_type_Int);
      if (localRefreshData != null) {
        paramRefreshInfo.isShown = localRefreshData.isShown;
      }
      SharedPreUtils.f(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), paramRefreshInfo.toJson().toString(), paramInt2);
    }
    return localRefreshData;
  }
  
  private void a(int paramInt1, RefreshData paramRefreshData, oidb_0x5bd.SkinInfo paramSkinInfo, oidb_0x5bd.GuideInfo paramGuideInfo, int paramInt2)
  {
    if (paramSkinInfo.has()) {
      paramSkinInfo = new SkinData(paramSkinInfo);
    } else {
      paramSkinInfo = null;
    }
    paramGuideInfo = new GuideData(paramGuideInfo, paramInt2);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("guideData = ");
      ((StringBuilder)localObject).append(paramGuideInfo);
      QLog.d("Q.readinjoy.4tab", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (ReadInJoySkinManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER);
    if ((!this.jdField_a_of_type_Boolean) && (paramInt1 >= paramGuideInfo.beginTime) && (paramInt1 <= paramGuideInfo.endTime))
    {
      a(QQManagerFactory.READ_INJOY_SKIN_MANAGER, "", paramGuideInfo);
    }
    else if ((paramInt1 <= paramGuideInfo.endTime) && (NetworkUtil.isWifiConnected(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication())))
    {
      ((ReadInJoySkinManager)localObject).a(paramGuideInfo);
      ((ReadInJoySkinManager)localObject).a(paramGuideInfo.skinData);
    }
    paramGuideInfo = ((ReadInJoySkinManager)localObject).a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication());
    if ((paramSkinInfo == null) && (((ReadInJoySkinManager)localObject).a() == 1))
    {
      this.jdField_a_of_type_JavaLangString = ((ReadInJoySkinManager)localObject).a();
      SharedPreUtils.o(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), null);
      if ((paramRefreshData != null) && (paramInt1 <= paramRefreshData.endTime))
      {
        paramRefreshData.isShown = true;
        SharedPreUtils.f(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), paramRefreshData.toJson().toString(), paramInt2);
      }
    }
    else if ((paramSkinInfo != null) && (paramGuideInfo != null) && (paramGuideInfo.id.equals(paramSkinInfo.id)) && (paramGuideInfo.seq != paramSkinInfo.seq))
    {
      SharedPreUtils.o(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), paramSkinInfo.toJson().toString());
      if (paramSkinInfo.id.equals(((ReadInJoySkinManager)localObject).a()))
      {
        this.jdField_a_of_type_JavaLangString = paramSkinInfo.id;
        return;
      }
      FileUtils.deleteDirectory(CommonSkinRes.a(paramSkinInfo.id));
    }
  }
  
  private void a(int paramInt, String paramString, BaseResData paramBaseResData)
  {
    ReadInjoySkinAndRefreshFacade.SkinAndRefreshCallback localSkinAndRefreshCallback = this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinReadInjoySkinAndRefreshFacade$SkinAndRefreshCallback;
    if (localSkinAndRefreshCallback != null) {
      localSkinAndRefreshCallback.a(paramInt, paramString, paramBaseResData);
    }
  }
  
  private void a(int paramInt1, oidb_0x5bd.GuideInfo paramGuideInfo, int paramInt2)
  {
    ReadInJoyOperationManager localReadInJoyOperationManager = (ReadInJoyOperationManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(QQManagerFactory.READ_IN_JOY_OPERATION_MANAGER);
    if (paramGuideInfo.has()) {
      paramGuideInfo = new GuideData(paramGuideInfo, paramInt2);
    } else {
      paramGuideInfo = null;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("guideData = ");
      ((StringBuilder)localObject1).append(paramGuideInfo);
      QLog.d("ReadInjoySkinAndRefreshFacadeManager", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getEntityManagerFactory().createEntityManager();
    if (paramGuideInfo != null)
    {
      paramGuideInfo.business = "operation_guide";
      Object localObject2 = paramGuideInfo.id;
      int i = 0;
      localObject2 = (GuideData)((EntityManager)localObject1).find(GuideData.class, new String[] { localObject2, paramGuideInfo.uin, paramGuideInfo.business });
      if ((localObject2 == null) || (((GuideData)localObject2).showTime == 0)) {
        ((EntityManager)localObject1).persistOrReplace(paramGuideInfo);
      }
      paramGuideInfo = localReadInJoyOperationManager.a("operation_guide", paramGuideInfo.id);
      if (paramGuideInfo != null)
      {
        paramGuideInfo = paramGuideInfo.iterator();
        while (paramGuideInfo.hasNext())
        {
          localObject1 = (GuideData)paramGuideInfo.next();
          if ((i == 0) && (((GuideData)localObject1).source == paramInt2) && (paramInt1 >= ((GuideData)localObject1).beginTime) && (paramInt1 <= ((GuideData)localObject1).endTime))
          {
            a(QQManagerFactory.READ_IN_JOY_OPERATION_MANAGER, "operation_guide", (BaseResData)localObject1);
            this.jdField_a_of_type_Boolean = true;
          }
          else if ((paramInt1 <= ((GuideData)localObject1).endTime) && (NetworkUtil.isWifiConnected(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication())))
          {
            localReadInJoyOperationManager.c("operation_guide", (BaseResData)localObject1);
          }
          i += 1;
        }
      }
    }
    else
    {
      localReadInJoyOperationManager.a(paramInt2);
    }
  }
  
  public void a()
  {
    ThreadManager.post(new ReadInjoySkinAndRefreshFacade.1(this), 5, null, true);
  }
  
  public void a(ReadInjoySkinAndRefreshFacade.SkinAndRefreshCallback paramSkinAndRefreshCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinReadInjoySkinAndRefreshFacade$SkinAndRefreshCallback = paramSkinAndRefreshCallback;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinReadInjoySkinAndRefreshFacade$SkinAndRefreshCallback = null;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinReadInJoySkinHandler$ReadInJoySkinObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.skin.ReadInjoySkinAndRefreshFacade
 * JD-Core Version:    0.7.0.1
 */