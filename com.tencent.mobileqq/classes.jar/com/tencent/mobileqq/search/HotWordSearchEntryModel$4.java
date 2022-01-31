package com.tencent.mobileqq.search;

import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import avic;
import avii;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel.GIFInfo;

public class HotWordSearchEntryModel$4
  implements Runnable
{
  public HotWordSearchEntryModel$4(avic paramavic, HotWordSearchEntryDataModel.GIFInfo paramGIFInfo, avii paramavii) {}
  
  public void run()
  {
    if ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$GIFInfo.hotSearchGifID)) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$GIFInfo.hotSearchGifUrl)) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$GIFInfo.hotSearchGifUrlNight))) {
      return;
    }
    int i = this.this$0.jdField_a_of_type_AndroidViewView.getHeight();
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.this$0.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
    localLayoutParams.height = i;
    this.this$0.jdField_a_of_type_ComTencentImageURLImageView.setLayoutParams(localLayoutParams);
    avic.a(this.this$0.jdField_a_of_type_AndroidContentContext, this.this$0.jdField_a_of_type_ComTencentImageURLImageView, this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$GIFInfo.hotSearchGifUrl, this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$GIFInfo.hotSearchGifUrlNight, this.jdField_a_of_type_Avii);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.HotWordSearchEntryModel.4
 * JD-Core Version:    0.7.0.1
 */