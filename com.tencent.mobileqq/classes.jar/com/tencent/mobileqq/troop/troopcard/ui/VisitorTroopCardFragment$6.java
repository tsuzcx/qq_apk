package com.tencent.mobileqq.troop.troopcard.ui;

import android.text.Layout;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.emoticon.QQEmojiUtil;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.widget.ExpandableTextView;
import com.tencent.mobileqq.util.Utils;

class VisitorTroopCardFragment$6
  implements Runnable
{
  VisitorTroopCardFragment$6(VisitorTroopCardFragment paramVisitorTroopCardFragment) {}
  
  public void run()
  {
    if (this.this$0.F.getContentTextView().getLineCount() > 0)
    {
      int i = this.this$0.F.getContentTextView().getLayout().getLineEnd(0);
      Object localObject = this.this$0.W.mRichFingerMemo.substring(0, i);
      if ((QQEmojiUtil.containsEmoji((String)localObject)) || (QQSysFaceUtil.containsExpression((String)localObject)))
      {
        localObject = (RelativeLayout.LayoutParams)this.this$0.G.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).topMargin += Utils.a(1.5F, this.this$0.getResources());
        this.this$0.G.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.ui.VisitorTroopCardFragment.6
 * JD-Core Version:    0.7.0.1
 */