package com.tencent.mobileqq.kandian.biz.share;

import com.tencent.mobileqq.kandian.base.view.api.IFontSizePanel;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.widget.RangeButtonView.OnChangeListener;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "lastPosition", "", "newPosition", "onChange"}, k=3, mv={1, 1, 16})
final class ReadInJoyShareHelperV2$rangeBtnListener$1
  implements RangeButtonView.OnChangeListener
{
  ReadInJoyShareHelperV2$rangeBtnListener$1(ReadInJoyShareHelperV2 paramReadInJoyShareHelperV2) {}
  
  public final void onChange(int paramInt1, int paramInt2)
  {
    ReadInJoyShareHelperV2.a(this.a, paramInt2);
    Object localObject = ReadInJoyShareHelperV2.a(this.a);
    float f;
    if (localObject != null) {
      f = ((IFontSizePanel)localObject).a(ReadInJoyShareHelperV2.a(this.a));
    } else {
      f = 1.0F;
    }
    localObject = (IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("readinjoy_font_size_index_sp");
    localStringBuilder.append(((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAccount());
    ((IReadInJoyHelper)localObject).updateReadInJoySpValue(localStringBuilder.toString(), Integer.valueOf(ReadInJoyShareHelperV2.a(this.a)));
    localObject = ReadInJoyShareHelperV2.a(this.a);
    if (localObject != null) {
      ((ReadInJoyShareHelperV2.OnFontSizeChangeListener)localObject).a(ReadInJoyShareHelperV2.a(this.a), f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.share.ReadInJoyShareHelperV2.rangeBtnListener.1
 * JD-Core Version:    0.7.0.1
 */