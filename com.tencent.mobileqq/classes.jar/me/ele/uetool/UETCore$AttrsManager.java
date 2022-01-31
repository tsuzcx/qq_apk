package me.ele.uetool;

import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import me.ele.uetool.base.IAttrs;

class UETCore$AttrsManager
{
  public static IAttrs createAttrs(View paramView)
  {
    if ((paramView instanceof TextView)) {
      return new UETCore.UETTextView();
    }
    if ((paramView instanceof ImageView)) {
      return new UETCore.UETImageView();
    }
    if ((paramView instanceof WebView)) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     me.ele.uetool.UETCore.AttrsManager
 * JD-Core Version:    0.7.0.1
 */