package com.tencent.mobileqq.leba.model;

import com.tencent.mobileqq.config.struct.LebaViewItem;
import com.tencent.mobileqq.data.ResourcePluginInfo;

public class LebaGridItemInfo
{
  public byte a;
  public int a;
  public long a;
  public PluginInfo a;
  public String a;
  public int b = -2;
  public int c = -1;
  
  public LebaViewItem a()
  {
    boolean bool = false;
    LebaViewItem localLebaViewItem = new LebaViewItem();
    localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo = new ResourcePluginInfo();
    localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId = this.jdField_a_of_type_ComTencentMobileqqLebaModelPluginInfo.pluginId;
    localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strPkgName = this.jdField_a_of_type_ComTencentMobileqqLebaModelPluginInfo.pkgName;
    localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strResName = this.jdField_a_of_type_ComTencentMobileqqLebaModelPluginInfo.resName;
    localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strResURL = this.jdField_a_of_type_ComTencentMobileqqLebaModelPluginInfo.resBigUrl;
    localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strNewPluginDesc = this.jdField_a_of_type_ComTencentMobileqqLebaModelPluginInfo.resDesc;
    localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strNewPluginURL = this.jdField_a_of_type_ComTencentMobileqqLebaModelPluginInfo.strDescIconUrl;
    ResourcePluginInfo localResourcePluginInfo = localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo;
    if (this.jdField_a_of_type_ComTencentMobileqqLebaModelPluginInfo.uiJumpType == 0) {}
    for (short s = 0;; s = 2)
    {
      localResourcePluginInfo.sResSubType = s;
      localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strGotoUrl = this.jdField_a_of_type_ComTencentMobileqqLebaModelPluginInfo.jumpInfo;
      if (this.jdField_a_of_type_ComTencentMobileqqLebaModelPluginInfo.uiCanChangeStatus != 0) {
        bool = true;
      }
      localLebaViewItem.jdField_a_of_type_Boolean = bool;
      localLebaViewItem.b = this.jdField_a_of_type_JavaLangString;
      localLebaViewItem.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      localLebaViewItem.jdField_a_of_type_Byte = this.jdField_a_of_type_Byte;
      localLebaViewItem.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
      return localLebaViewItem;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.leba.model.LebaGridItemInfo
 * JD-Core Version:    0.7.0.1
 */