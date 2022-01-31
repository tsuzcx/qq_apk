package dov.com.tencent.biz.qqstory.takevideo;

import aekt;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import bmha;
import bmhb;
import bngs;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import dov.com.qq.im.capture.text.DynamicTextConfigManager;
import wta;

public class EditVideoDTextFace$1
  implements Runnable
{
  public EditVideoDTextFace$1(bmha parambmha, DynamicTextConfigManager paramDynamicTextConfigManager) {}
  
  public void run()
  {
    if (this.this$0.d()) {
      return;
    }
    bmha.a(this.this$0, LayoutInflater.from(this.this$0.a()).inflate(2131561415, null));
    RelativeLayout localRelativeLayout = (RelativeLayout)this.this$0.a(2131363820);
    EditText localEditText = (EditText)bmha.a(this.this$0).findViewById(2131365553);
    View localView = bmha.a(this.this$0).findViewById(2131369470);
    localEditText.setText(" " + bmha.a(this.this$0));
    localEditText.setSelection(0);
    localEditText.setOnTouchListener(new bmhb(this));
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(12);
    Resources localResources = BaseApplicationImpl.getContext().getResources();
    int j = aekt.a(200.0F, localResources);
    int i;
    if (bngs.b())
    {
      int k = this.a.a - aekt.a(48.0F, localResources);
      i = k;
      if (k <= 0)
      {
        i = k;
        if (k > 300) {
          i = aekt.a(66.0F, localResources);
        }
      }
      i += j;
    }
    for (;;)
    {
      localLayoutParams.bottomMargin = i;
      localLayoutParams.leftMargin = aekt.a(12.0F, localResources);
      i = localResources.getDisplayMetrics().widthPixels;
      localView.getLayoutParams().width = (i - localLayoutParams.leftMargin * 2);
      localRelativeLayout.addView(bmha.a(this.this$0), localLayoutParams);
      localEditText.setFocusable(true);
      localEditText.setFocusableInTouchMode(true);
      localEditText.requestFocus();
      localEditText.setSelection(0);
      bmha.a(this.this$0, localEditText);
      wta.a("video_edit_text", "exp_textWording", 0, 0, new String[] { this.this$0.a, "", "", "" });
      return;
      i = j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoDTextFace.1
 * JD-Core Version:    0.7.0.1
 */