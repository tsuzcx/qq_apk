package com.tencent.mtt.hippy.views.text;

import android.content.Context;
import android.text.Layout;
import android.text.Spannable;
import android.view.View;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.dom.node.StyleNode;
import com.tencent.mtt.hippy.dom.node.TextExtra;
import com.tencent.mtt.hippy.dom.node.TextNode;
import com.tencent.mtt.hippy.dom.node.e;
import com.tencent.mtt.hippy.uimanager.HippyViewController;

@HippyController(name="Text")
public class HippyTextViewController
  extends HippyViewController<HippyTextView>
{
  public static final String CLASS_NAME = "Text";
  
  public StyleNode createNode(boolean paramBoolean)
  {
    return new TextNode(paramBoolean);
  }
  
  public View createViewImpl(Context paramContext)
  {
    return new HippyTextView(paramContext);
  }
  
  public boolean handleGestureBySelf()
  {
    return true;
  }
  
  public void updateExtra(View paramView, Object paramObject)
  {
    paramObject = (TextExtra)paramObject;
    Layout localLayout;
    if ((paramObject != null) && ((paramObject.mExtra instanceof Layout)) && ((paramView instanceof HippyTextView)))
    {
      paramView = (HippyTextView)paramView;
      localLayout = (Layout)paramObject.mExtra;
      Object localObject = localLayout.getText();
      if ((localObject instanceof Spannable))
      {
        localObject = (Spannable)localObject;
        localObject = (e[])((Spannable)localObject).getSpans(0, ((Spannable)localObject).length(), e.class);
        if ((localObject == null) || (localObject.length <= 0)) {
          break label148;
        }
        paramView.setNativeGestureEnable(true);
      }
    }
    for (;;)
    {
      paramView.setPadding((int)Math.floor(paramObject.mLeftPadding), (int)Math.floor(paramObject.mTopPadding), (int)Math.floor(paramObject.mRightPadding), (int)Math.floor(paramObject.mBottomPadding));
      paramView.setLayout(localLayout);
      paramView.postInvalidate();
      return;
      label148:
      paramView.setNativeGestureEnable(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.text.HippyTextViewController
 * JD-Core Version:    0.7.0.1
 */