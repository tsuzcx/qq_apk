package com.tencent.qqmini.miniapp.core.page.widget;

import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.qqmini.miniapp.core.page.NativeViewContainer;
import com.tencent.qqmini.miniapp.core.page.PageWebviewContainer;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;

class WebInputHandler$MyOnGlobalLayoutListener
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private final WebEditText webEditText;
  
  public WebInputHandler$MyOnGlobalLayoutListener(WebInputHandler paramWebInputHandler, WebEditText paramWebEditText)
  {
    this.webEditText = paramWebEditText;
  }
  
  public void onGlobalLayout()
  {
    if ((this.webEditText.isFocused()) && (WebInputHandler.access$000(this.this$0)))
    {
      arrayOfInt = new int[2];
      this.webEditText.getLocationOnScreen(arrayOfInt);
      i = arrayOfInt[1];
      i = DisplayUtil.getRealHeight(this.webEditText.getContext()) - (i + this.webEditText.getHeight()) - this.webEditText.getMarginBottom();
      if ((WebInputHandler.access$100(this.this$0) > i) && (this.webEditText.isAdjustPosition()) && (WebInputHandler.access$000(this.this$0)) && (WebInputHandler.access$200(this.this$0) != null) && (WebInputHandler.access$200(this.this$0).getPageWebviewContainer() != null)) {
        WebInputHandler.access$400(this.this$0, new float[] { 0.0F, -(WebInputHandler.access$100(this.this$0) - i) });
      }
    }
    while ((WebInputHandler.access$000(this.this$0)) || (WebInputHandler.access$200(this.this$0) == null) || (WebInputHandler.access$200(this.this$0).getPageWebviewContainer() == null))
    {
      int[] arrayOfInt;
      int i;
      return;
    }
    WebInputHandler.access$400(this.this$0, new float[] { WebInputHandler.access$200(this.this$0).getPageWebviewContainer().getTranslationY(), 0.0F });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.widget.WebInputHandler.MyOnGlobalLayoutListener
 * JD-Core Version:    0.7.0.1
 */