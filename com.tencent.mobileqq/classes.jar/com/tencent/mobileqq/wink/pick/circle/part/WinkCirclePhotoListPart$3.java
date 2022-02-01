package com.tencent.mobileqq.wink.pick.circle.part;

import android.text.Layout;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.wink.pick.circle.WinkCirclePhotoListLogic.PhotoListGuideData;
import com.tencent.mobileqq.wink.view.RoundCornerImageView;

class WinkCirclePhotoListPart$3
  implements Observer<WinkCirclePhotoListLogic.PhotoListGuideData>
{
  WinkCirclePhotoListPart$3(WinkCirclePhotoListPart paramWinkCirclePhotoListPart, View paramView) {}
  
  public void a(WinkCirclePhotoListLogic.PhotoListGuideData paramPhotoListGuideData)
  {
    Object localObject = this.a;
    if ((localObject != null) && (paramPhotoListGuideData != null))
    {
      WinkCirclePhotoListPart.a(this.b, (RelativeLayout)((View)localObject).findViewById(2131439011));
      WinkCirclePhotoListPart.f(this.b).setVisibility(0);
      localObject = (RoundCornerImageView)this.a.findViewById(2131439010);
      ((RoundCornerImageView)localObject).setImageDrawable(paramPhotoListGuideData.c);
      ((RoundCornerImageView)localObject).setCorner(ViewUtils.dpToPx(WinkCirclePhotoListPart.b));
      localObject = (TextView)this.a.findViewById(2131442813);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(((TextView)localObject).getText());
      localStringBuilder.append(paramPhotoListGuideData.b);
      localStringBuilder.append("\"");
      localStringBuilder.append(paramPhotoListGuideData.a);
      localStringBuilder.append("\"");
      ((TextView)localObject).setText(localStringBuilder.toString());
      if (((TextView)localObject).getLineCount() > 1)
      {
        int i = ((TextView)localObject).getLayout().getLineEnd(0);
        paramPhotoListGuideData = new StringBuilder();
        paramPhotoListGuideData.append(((TextView)localObject).getText().subSequence(0, i));
        paramPhotoListGuideData.append("...\"");
        ((TextView)localObject).setText(paramPhotoListGuideData.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.pick.circle.part.WinkCirclePhotoListPart.3
 * JD-Core Version:    0.7.0.1
 */