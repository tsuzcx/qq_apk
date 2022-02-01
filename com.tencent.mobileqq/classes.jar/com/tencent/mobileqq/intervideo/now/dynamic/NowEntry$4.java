package com.tencent.mobileqq.intervideo.now.dynamic;

import com.tencent.intervideo.nowproxy.customized_interface.ActionCallback;

class NowEntry$4
  implements ActionCallback
{
  NowEntry$4(NowEntry paramNowEntry) {}
  
  public void onResult(String paramString)
  {
    try
    {
      i = Integer.parseInt(paramString);
      if (NowEntry.a(this.a) != null) {
        NowEntry.a(this.a).a(i, "");
      }
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        int i = -1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.dynamic.NowEntry.4
 * JD-Core Version:    0.7.0.1
 */