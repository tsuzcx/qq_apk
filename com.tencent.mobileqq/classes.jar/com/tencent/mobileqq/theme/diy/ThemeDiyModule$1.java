package com.tencent.mobileqq.theme.diy;

import axfu;
import beio;
import beja;
import org.json.JSONObject;

class ThemeDiyModule$1
  implements axfu<beio>
{
  ThemeDiyModule$1(ThemeDiyModule paramThemeDiyModule, JSONObject paramJSONObject, String paramString) {}
  
  public void postQuery(beio parambeio)
  {
    if ((parambeio != null) && (parambeio.b())) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.theme.diy.ThemeDiyModule.1
 * JD-Core Version:    0.7.0.1
 */