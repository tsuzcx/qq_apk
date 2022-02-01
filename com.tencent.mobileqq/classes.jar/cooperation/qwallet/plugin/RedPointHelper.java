package cooperation.qwallet.plugin;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;
import com.tencent.mobileqq.util.DisplayUtil;

public class RedPointHelper
{
  public static final int MODE_ALIGN_ANCHOR = 0;
  public static final int MODE_ALIGN_ANCHOR_BOTTOM = 2;
  public static final int MODE_ALIGN_ANCHOR_CENTERX = 4;
  public static final int MODE_ALIGN_ANCHOR_CENTERY = 8;
  public static final int MODE_ALIGN_ANCHOR_RIGHT = 1;
  protected Context mContext;
  private PopupWindow popupWindow;
  
  public RedPointHelper(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public RedPointHelper createPopView(Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    this.popupWindow = new PopupWindow(this.mContext);
    this.popupWindow.setWidth(paramInt1);
    this.popupWindow.setHeight(paramInt2);
    this.popupWindow.setBackgroundDrawable(new ColorDrawable(Color.argb(0, 0, 0, 0)));
    this.popupWindow.setOutsideTouchable(false);
    this.popupWindow.setTouchable(false);
    this.popupWindow.setFocusable(false);
    ImageView localImageView = new ImageView(this.mContext);
    localImageView.setImageDrawable(paramDrawable);
    this.popupWindow.setContentView(localImageView);
    return this;
  }
  
  public void hidePoint()
  {
    PopupWindow localPopupWindow = this.popupWindow;
    if (localPopupWindow == null) {
      return;
    }
    localPopupWindow.dismiss();
  }
  
  public void showRedPoint(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.popupWindow != null)
    {
      int[] arrayOfInt = new int[2];
      paramView.getLocationOnScreen(arrayOfInt);
      int n = this.popupWindow.getWidth();
      int m = this.popupWindow.getHeight();
      int j = arrayOfInt[0];
      int k = arrayOfInt[1];
      int i = j;
      if ((paramInt1 & 0x1) != 0) {
        i = j + paramView.getWidth() - n;
      }
      j = k;
      if ((paramInt1 & 0x2) != 0) {
        j = k + paramView.getHeight() - m;
      }
      k = i;
      if ((paramInt1 & 0x4) != 0) {
        k = i + paramView.getWidth() / 2 - n / 2;
      }
      i = j;
      if ((paramInt1 & 0x8) != 0) {
        i = j + paramView.getHeight() / 2 - m / 2;
      }
      paramInt1 = DisplayUtil.a(this.mContext, paramInt2);
      paramInt2 = DisplayUtil.a(this.mContext, paramInt3);
      this.popupWindow.showAtLocation(paramView, 0, k + paramInt1, i + paramInt2);
      return;
    }
    throw new RuntimeException("createSinglePopView should called first!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qwallet.plugin.RedPointHelper
 * JD-Core Version:    0.7.0.1
 */