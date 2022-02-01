package dov.com.tencent.biz.qqstory.takevideo;

import agej;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import bqen;
import bqeo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import dov.com.qq.im.capture.text.DynamicTextConfigManager;
import dov.com.tencent.mobileqq.richmedia.capture.util.LiuHaiUtils;
import yup;

public class EditVideoDTextFace$1
  implements Runnable
{
  public EditVideoDTextFace$1(bqen parambqen, DynamicTextConfigManager paramDynamicTextConfigManager) {}
  
  public void run()
  {
    if (this.this$0.d()) {
      return;
    }
    bqen.a(this.this$0, LayoutInflater.from(this.this$0.a()).inflate(2131561710, null));
    RelativeLayout localRelativeLayout = (RelativeLayout)this.this$0.a(2131364054);
    EditText localEditText = (EditText)bqen.a(this.this$0).findViewById(2131365832);
    View localView = bqen.a(this.this$0).findViewById(2131369980);
    localEditText.setText(" " + bqen.a(this.this$0));
    localEditText.setSelection(0);
    localEditText.setOnTouchListener(new bqeo(this));
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(12);
    Resources localResources = BaseApplicationImpl.getContext().getResources();
    int j = agej.a(200.0F, localResources);
    int i;
    if (LiuHaiUtils.b())
    {
      int k = this.a.a - agej.a(48.0F, localResources);
      i = k;
      if (k <= 0)
      {
        i = k;
        if (k > 300) {
          i = agej.a(66.0F, localResources);
        }
      }
      i += j;
    }
    for (;;)
    {
      localLayoutParams.bottomMargin = i;
      localLayoutParams.leftMargin = agej.a(12.0F, localResources);
      i = localResources.getDisplayMetrics().widthPixels;
      localView.getLayoutParams().width = (i - localLayoutParams.leftMargin * 2);
      localRelativeLayout.addView(bqen.a(this.this$0), localLayoutParams);
      localEditText.setFocusable(true);
      localEditText.setFocusableInTouchMode(true);
      localEditText.requestFocus();
      localEditText.setSelection(0);
      bqen.a(this.this$0, localEditText);
      yup.a("video_edit_text", "exp_textWording", 0, 0, new String[] { this.this$0.a, "", "", "" });
      return;
      i = j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoDTextFace.1
 * JD-Core Version:    0.7.0.1
 */