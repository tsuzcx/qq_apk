package com.tencent.mobileqq.wxmini.impl.ui;

import com.tencent.mobileqq.widget.QQToast;
import org.json.JSONObject;

class PreloadingFragment$7$3
  implements Runnable
{
  PreloadingFragment$7$3(PreloadingFragment.7 param7, JSONObject paramJSONObject) {}
  
  public void run()
  {
    QQToast.makeText(this.b.a, "加载失败", 0).show();
    PreloadingFragment.d(this.b.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.wxmini.impl.ui.PreloadingFragment.7.3
 * JD-Core Version:    0.7.0.1
 */