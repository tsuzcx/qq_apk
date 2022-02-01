package com.tencent.mobileqq.kandian.biz.share;

import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.base.view.api.IFontSizePanel;
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
    Object localObject = ReadInJoyShareHelperV2.c(this.a);
    float f;
    if (localObject != null) {
      f = ((IFontSizePanel)localObject).a(ReadInJoyShareHelperV2.b(this.a));
    } else {
      f = 1.0F;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("readinjoy_font_size_index_sp");
    ((StringBuilder)localObject).append(RIJQQAppInterfaceUtil.d());
    RIJSPUtils.a(((StringBuilder)localObject).toString(), Integer.valueOf(ReadInJoyShareHelperV2.b(this.a)));
    localObject = ReadInJoyShareHelperV2.d(this.a);
    if (localObject != null) {
      ((ReadInJoyShareHelperV2.OnFontSizeChangeListener)localObject).a(ReadInJoyShareHelperV2.b(this.a), f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.share.ReadInJoyShareHelperV2.rangeBtnListener.1
 * JD-Core Version:    0.7.0.1
 */