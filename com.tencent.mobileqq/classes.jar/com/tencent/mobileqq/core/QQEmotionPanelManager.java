package com.tencent.mobileqq.core;

import android.app.Application;
import com.tencent.mobileqq.AIODepend.IPanelInteractionListener;
import com.tencent.mobileqq.emoticon.IEmoticonPackageDownloadListener;
import com.tencent.mobileqq.emoticonview.IEmoticonPanelController;

public class QQEmotionPanelManager
{
  private Application jdField_a_of_type_AndroidAppApplication;
  private IPanelInteractionListener jdField_a_of_type_ComTencentMobileqqAIODependIPanelInteractionListener;
  private EmotionPanelParamsBuilder jdField_a_of_type_ComTencentMobileqqCoreEmotionPanelParamsBuilder;
  private IEmoticonPackageDownloadListener jdField_a_of_type_ComTencentMobileqqEmoticonIEmoticonPackageDownloadListener;
  private IEmoticonPanelController jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonPanelController;
  
  public static QQEmotionPanelManager a()
  {
    return QQEmotionPanelManager.SingletonPatternHolder.a();
  }
  
  public IPanelInteractionListener a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAIODependIPanelInteractionListener;
  }
  
  public EmotionPanelParamsBuilder a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqCoreEmotionPanelParamsBuilder == null) {
      this.jdField_a_of_type_ComTencentMobileqqCoreEmotionPanelParamsBuilder = new EmotionPanelParamsBuilder();
    }
    return this.jdField_a_of_type_ComTencentMobileqqCoreEmotionPanelParamsBuilder;
  }
  
  public IEmoticonPackageDownloadListener a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqEmoticonIEmoticonPackageDownloadListener;
  }
  
  public IEmoticonPanelController a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonPanelController;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAIODependIPanelInteractionListener = null;
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonPanelController = null;
    this.jdField_a_of_type_ComTencentMobileqqEmoticonIEmoticonPackageDownloadListener = null;
  }
  
  public void a(Application paramApplication)
  {
    this.jdField_a_of_type_AndroidAppApplication = paramApplication;
  }
  
  public void a(IPanelInteractionListener paramIPanelInteractionListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqAIODependIPanelInteractionListener = paramIPanelInteractionListener;
  }
  
  public void a(EmotionPanelParamsBuilder paramEmotionPanelParamsBuilder)
  {
    this.jdField_a_of_type_ComTencentMobileqqCoreEmotionPanelParamsBuilder = paramEmotionPanelParamsBuilder;
  }
  
  public void a(IEmoticonPackageDownloadListener paramIEmoticonPackageDownloadListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqEmoticonIEmoticonPackageDownloadListener = paramIEmoticonPackageDownloadListener;
  }
  
  public void a(IEmoticonPanelController paramIEmoticonPanelController)
  {
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonPanelController = paramIEmoticonPanelController;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.core.QQEmotionPanelManager
 * JD-Core Version:    0.7.0.1
 */