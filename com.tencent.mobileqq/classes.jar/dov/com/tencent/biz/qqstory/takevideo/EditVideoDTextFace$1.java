package dov.com.tencent.biz.qqstory.takevideo;

import aepi;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import bmlm;
import bmln;
import bnle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import dov.com.qq.im.capture.text.DynamicTextConfigManager;
import wxj;

public class EditVideoDTextFace$1
  implements Runnable
{
  public EditVideoDTextFace$1(bmlm parambmlm, DynamicTextConfigManager paramDynamicTextConfigManager) {}
  
  public void run()
  {
    if (this.this$0.d()) {
      return;
    }
    bmlm.a(this.this$0, LayoutInflater.from(this.this$0.a()).inflate(2131561433, null));
    RelativeLayout localRelativeLayout = (RelativeLayout)this.this$0.a(2131363822);
    EditText localEditText = (EditText)bmlm.a(this.this$0).findViewById(2131365555);
    View localView = bmlm.a(this.this$0).findViewById(2131369488);
    localEditText.setText(" " + bmlm.a(this.this$0));
    localEditText.setSelection(0);
    localEditText.setOnTouchListener(new bmln(this));
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(12);
    Resources localResources = BaseApplicationImpl.getContext().getResources();
    int j = aepi.a(200.0F, localResources);
    int i;
    if (bnle.b())
    {
      int k = this.a.a - aepi.a(48.0F, localResources);
      i = k;
      if (k <= 0)
      {
        i = k;
        if (k > 300) {
          i = aepi.a(66.0F, localResources);
        }
      }
      i += j;
    }
    for (;;)
    {
      localLayoutParams.bottomMargin = i;
      localLayoutParams.leftMargin = aepi.a(12.0F, localResources);
      i = localResources.getDisplayMetrics().widthPixels;
      localView.getLayoutParams().width = (i - localLayoutParams.leftMargin * 2);
      localRelativeLayout.addView(bmlm.a(this.this$0), localLayoutParams);
      localEditText.setFocusable(true);
      localEditText.setFocusableInTouchMode(true);
      localEditText.requestFocus();
      localEditText.setSelection(0);
      bmlm.a(this.this$0, localEditText);
      wxj.a("video_edit_text", "exp_textWording", 0, 0, new String[] { this.this$0.a, "", "", "" });
      return;
      i = j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoDTextFace.1
 * JD-Core Version:    0.7.0.1
 */