package com.tencent.mobileqq.troop.homework.xmediaeditor.ui.recite;

import android.view.View;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.HWReciteInfo;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.EditorViewHolderManager.EditViewHolderBase;

class HWReciteItem$HWReciteViewHolder
  extends EditorViewHolderManager.EditViewHolderBase
{
  int jdField_a_of_type_Int;
  View jdField_a_of_type_AndroidViewView;
  GotoReciteSubViewHolder jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiReciteGotoReciteSubViewHolder;
  ReciteResultSubViewHolder jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiReciteReciteResultSubViewHolder;
  ReciteTextSubViewHolder jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiReciteReciteTextSubViewHolder;
  
  public HWReciteItem$HWReciteViewHolder(View paramView)
  {
    super(paramView);
    View localView1 = paramView.findViewById(2131370177);
    View localView2 = paramView.findViewById(2131370124);
    View localView3 = paramView.findViewById(2131370176);
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiReciteReciteTextSubViewHolder = new ReciteTextSubViewHolder(localView1);
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiReciteGotoReciteSubViewHolder = new GotoReciteSubViewHolder(localView2);
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiReciteReciteResultSubViewHolder = new ReciteResultSubViewHolder(localView3);
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  void a(View paramView, HWReciteItem paramHWReciteItem)
  {
    switch (((HWReciteInfo)this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelEditItemInfoBase).jdField_a_of_type_Int)
    {
    default: 
      return;
    case 2: 
      if (this.jdField_a_of_type_Int == 2)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiReciteGotoReciteSubViewHolder.a(paramView, paramHWReciteItem, this);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiReciteReciteTextSubViewHolder.a(paramView, paramHWReciteItem, this);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiReciteReciteResultSubViewHolder.a(paramView, paramHWReciteItem, this);
  }
  
  void a(HWReciteItem paramHWReciteItem, HWReciteInfo paramHWReciteInfo, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    switch (paramHWReciteInfo.jdField_a_of_type_Int)
    {
    default: 
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiReciteReciteTextSubViewHolder.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiReciteGotoReciteSubViewHolder.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiReciteReciteResultSubViewHolder.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return;
    case 2: 
      if (paramInt == 2)
      {
        paramHWReciteInfo.g = 0;
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiReciteReciteTextSubViewHolder.jdField_a_of_type_AndroidViewView.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiReciteGotoReciteSubViewHolder.a(paramHWReciteItem, this, paramHWReciteInfo, paramInt);
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiReciteReciteResultSubViewHolder.jdField_a_of_type_AndroidViewView.setVisibility(8);
        return;
      }
      paramHWReciteInfo.g = 3;
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiReciteReciteTextSubViewHolder.a(paramHWReciteItem, this, paramHWReciteInfo, paramInt);
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiReciteGotoReciteSubViewHolder.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiReciteReciteResultSubViewHolder.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiReciteReciteTextSubViewHolder.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiReciteGotoReciteSubViewHolder.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiReciteReciteResultSubViewHolder.a(paramHWReciteItem, this, paramHWReciteInfo, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.ui.recite.HWReciteItem.HWReciteViewHolder
 * JD-Core Version:    0.7.0.1
 */