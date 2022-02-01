package com.tencent.mobileqq.troop.troopCard;

import android.text.Layout;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.troop.widget.ExpandableTextView;
import com.tencent.mobileqq.troopinfo.TroopInfoData;

class VisitorTroopCardFragment$6
  implements Runnable
{
  VisitorTroopCardFragment$6(VisitorTroopCardFragment paramVisitorTroopCardFragment) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqTroopWidgetExpandableTextView.a().getLineCount() > 0)
    {
      int i = this.this$0.jdField_a_of_type_ComTencentMobileqqTroopWidgetExpandableTextView.a().getLayout().getLineEnd(0);
      Object localObject = this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo.substring(0, i);
      if ((QQText.containsEmoji((String)localObject)) || (QQText.containsExpression((String)localObject)))
      {
        localObject = (RelativeLayout.LayoutParams)this.this$0.e.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).topMargin += AIOUtils.dp2px(1.5F, this.this$0.getResources());
        this.this$0.e.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopCard.VisitorTroopCardFragment.6
 * JD-Core Version:    0.7.0.1
 */