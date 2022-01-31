package com.tencent.mobileqq.theme.diy;

import askq;
import aymj;
import aymv;
import org.json.JSONObject;

class ThemeDiyModule$1
  implements askq<aymj>
{
  ThemeDiyModule$1(ThemeDiyModule paramThemeDiyModule, JSONObject paramJSONObject, String paramString) {}
  
  public void postQuery(aymj paramaymj)
  {
    if ((paramaymj != null) && (paramaymj.b())) {
      if (ThemeDiyModule.access$000(this.this$0) != null) {
        ThemeDiyModule.access$000(this.this$0).diyThemeSetup(this.val$styleObj, this.val$callbackId);
      }
    }
    while (ThemeDiyModule.access$000(this.this$0) == null) {
      return;
    }
    ThemeDiyModule.access$000(this.this$0).startDownload(this.val$styleObj, this.val$callbackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.theme.diy.ThemeDiyModule.1
 * JD-Core Version:    0.7.0.1
 */