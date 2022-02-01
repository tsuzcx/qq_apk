package com.tencent.tkd.topicsdk.mvp;

import com.tencent.tkd.topicsdk.common.KeyBoardChangeListener.KeyboardListener;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tkd/topicsdk/mvp/BaseListView$2$1", "Lcom/tencent/tkd/topicsdk/common/KeyBoardChangeListener$KeyboardListener;", "onKeyboardChange", "", "isShow", "", "keyboardHeight", "", "topicsdk-common_release"}, k=1, mv={1, 1, 16})
public final class BaseListView$$special$$inlined$apply$lambda$1
  implements KeyBoardChangeListener.KeyboardListener
{
  BaseListView$$special$$inlined$apply$lambda$1(BaseListView paramBaseListView) {}
  
  public void a(boolean paramBoolean, int paramInt)
  {
    BaseListView.a(this.a, paramBoolean);
    if (!paramBoolean) {
      this.a.requestFocus();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.mvp.BaseListView..special..inlined.apply.lambda.1
 * JD-Core Version:    0.7.0.1
 */