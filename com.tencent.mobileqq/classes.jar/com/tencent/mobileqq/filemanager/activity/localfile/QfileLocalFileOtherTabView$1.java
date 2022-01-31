package com.tencent.mobileqq.filemanager.activity.localfile;

import alud;
import arqx;
import arrj;
import arvi;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

class QfileLocalFileOtherTabView$1
  implements Runnable
{
  QfileLocalFileOtherTabView$1(QfileLocalFileOtherTabView paramQfileLocalFileOtherTabView) {}
  
  public void run()
  {
    Object localObject2 = new HashMap();
    if (this.this$0.a.e() != 8) {}
    for (boolean bool = true;; bool = false)
    {
      localObject1 = this.this$0.d.iterator();
      while (((Iterator)localObject1).hasNext()) {
        arrj.a(bool, ((arvi)((Iterator)localObject1).next()).a(), "", ".doc|.docx|.wps|.pages|.ppt|.pptx.|.dps|.keynote|.xls|.xlsx|.et|.numbers|.pdf|.swf|.mov|.mp4|.3gp|.avi|.rmvb|.wmf|.mpg|.rm|.asf|.mpeg|.mkv|.wmv|.flv|.f4v|.webm|.mod|.mpe|.fla|.m4r|.m4u|.m4v|.vob|.mp3|.wav|.m4a|.wave|.midi|.wma|.ogg|.ape|.acc|.aac|.aiff|.mid|.xmf|.rtttl|.flac|.amr|.mp2|.m3u|.m4b|.m4p.mpga|.apk|.jpg|.bmp|.jpeg|.gif|.png|.ico|", (HashMap)localObject2, null);
      }
    }
    if (this.this$0.f) {}
    for (Object localObject1 = arqx.a().a();; localObject1 = null)
    {
      if (localObject1 != null) {
        arrj.a(bool, (String)localObject1, "", ".doc|.docx|.wps|.pages|.ppt|.pptx.|.dps|.keynote|.xls|.xlsx|.et|.numbers|.pdf|.swf|.mov|.mp4|.3gp|.avi|.rmvb|.wmf|.mpg|.rm|.asf|.mpeg|.mkv|.wmv|.flv|.f4v|.webm|.mod|.mpe|.fla|.m4r|.m4u|.m4v|.vob|.mp3|.wav|.m4a|.wave|.midi|.wma|.ogg|.ape|.acc|.aac|.aiff|.mid|.xmf|.rtttl|.flac|.amr|.mp2|.m3u|.m4b|.m4p.mpga|.apk|.jpg|.bmp|.jpeg|.gif|.png|.ico|", (HashMap)localObject2, null);
      }
      arrj.a((Map)localObject2);
      localObject1 = new LinkedHashMap();
      ((LinkedHashMap)localObject1).put(alud.a(2131710076), new ArrayList());
      ((LinkedHashMap)localObject1).put(alud.a(2131710081), new ArrayList());
      ((LinkedHashMap)localObject1).put(alud.a(2131710068), new ArrayList());
      Iterator localIterator = ((HashMap)localObject2).keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        ((List)((LinkedHashMap)localObject1).get(this.this$0.a(str))).addAll((Collection)((HashMap)localObject2).get(str));
      }
    }
    localObject2 = ((LinkedHashMap)localObject1).keySet().iterator();
    while (((Iterator)localObject2).hasNext()) {
      if (((List)((LinkedHashMap)localObject1).get((String)((Iterator)localObject2).next())).size() == 0) {
        ((Iterator)localObject2).remove();
      }
    }
    QfileLocalFileOtherTabView.a(this.this$0, new QfileLocalFileOtherTabView.1.1(this, (LinkedHashMap)localObject1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileOtherTabView.1
 * JD-Core Version:    0.7.0.1
 */