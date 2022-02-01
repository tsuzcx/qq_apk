package com.tencent.mobileqq.core;

import android.content.Context;
import com.tencent.mobileqq.emoticonview.IEmoticonInfoSender;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanelApp;
import com.tencent.mobileqq.emoticonview.IEmoticonPanelLinearLayoutHelper;
import com.tencent.mobileqq.emoticonview.adapter.IEmotionAdapterHelper;
import com.tencent.mobileqq.emoticonview.api.IApolloDependListener;
import com.tencent.mobileqq.emoticonview.api.IEmoticonInfoService;
import com.tencent.mobileqq.emoticonview.api.IPanelDependListener;
import com.tencent.mobileqq.qroute.QRoute;

public class SystemEmotionPanelManager
{
  private SystemEmotionPanelManager.IEmoticonPanelInject jdField_a_of_type_ComTencentMobileqqCoreSystemEmotionPanelManager$IEmoticonPanelInject;
  private IApolloDependListener jdField_a_of_type_ComTencentMobileqqEmoticonviewApiIApolloDependListener;
  private IPanelDependListener jdField_a_of_type_ComTencentMobileqqEmoticonviewApiIPanelDependListener;
  
  public static SystemEmotionPanelManager a()
  {
    return SystemEmotionPanelManager.SingletonPatternHolder.a();
  }
  
  public <T extends IEmoticonInfoSender> T a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqCoreSystemEmotionPanelManager$IEmoticonPanelInject == null) {
      return ((IEmoticonInfoService)QRoute.api(IEmoticonInfoService.class)).createEmotionInfoSender(paramInt);
    }
    return this.jdField_a_of_type_ComTencentMobileqqCoreSystemEmotionPanelManager$IEmoticonPanelInject.createEmotionInfoSender(paramInt);
  }
  
  public IEmoticonPanelLinearLayoutHelper a(Context paramContext, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqCoreSystemEmotionPanelManager$IEmoticonPanelInject == null) {
      return ((IEmoticonInfoService)QRoute.api(IEmoticonInfoService.class)).createEmoticonPanelLayoutHelper(paramContext, paramBoolean);
    }
    return this.jdField_a_of_type_ComTencentMobileqqCoreSystemEmotionPanelManager$IEmoticonPanelInject.createEmoticonPanelLayoutHelper(paramBoolean);
  }
  
  public <T extends IEmotionAdapterHelper> T a(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqCoreSystemEmotionPanelManager$IEmoticonPanelInject == null) {
      return ((IEmoticonInfoService)QRoute.api(IEmoticonInfoService.class)).createEmotionAdapterHelper(paramIEmoticonMainPanelApp, paramInt);
    }
    return this.jdField_a_of_type_ComTencentMobileqqCoreSystemEmotionPanelManager$IEmoticonPanelInject.createEmotionAdapterHelper(paramInt);
  }
  
  public IApolloDependListener a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqEmoticonviewApiIApolloDependListener;
  }
  
  public IPanelDependListener a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqEmoticonviewApiIPanelDependListener;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqCoreSystemEmotionPanelManager$IEmoticonPanelInject = null;
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewApiIPanelDependListener = null;
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewApiIApolloDependListener = null;
  }
  
  public void a(SystemEmotionPanelManager.IEmoticonPanelInject paramIEmoticonPanelInject)
  {
    this.jdField_a_of_type_ComTencentMobileqqCoreSystemEmotionPanelManager$IEmoticonPanelInject = paramIEmoticonPanelInject;
  }
  
  public void a(IApolloDependListener paramIApolloDependListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewApiIApolloDependListener = paramIApolloDependListener;
  }
  
  public void a(IPanelDependListener paramIPanelDependListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewApiIPanelDependListener = paramIPanelDependListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.core.SystemEmotionPanelManager
 * JD-Core Version:    0.7.0.1
 */