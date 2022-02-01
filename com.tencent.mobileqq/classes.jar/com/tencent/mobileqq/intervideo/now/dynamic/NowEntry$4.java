package com.tencent.mobileqq.intervideo.now.dynamic;

import com.tencent.intervideo.nowproxy.customized_interface.ActionCallback;
import com.tencent.mobileqq.intervideo.yiqikan.OnOpenCloseRoomCallback;

class NowEntry$4
  implements ActionCallback
{
  NowEntry$4(NowEntry paramNowEntry) {}
  
  public void onResult(String paramString)
  {
    try
    {
      i = Integer.parseInt(paramString);
    }
    catch (Exception paramString)
    {
      int i;
      label8:
      break label8;
    }
    i = -1;
    if (NowEntry.a(this.a) != null) {
      NowEntry.a(this.a).a(i, "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.dynamic.NowEntry.4
 * JD-Core Version:    0.7.0.1
 */