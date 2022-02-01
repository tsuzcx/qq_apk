package com.tencent.mobileqq.filemanager.activity.localfile;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.util.FileCategoryUtil;
import com.tencent.mobileqq.filemanager.widget.QfileTabBarView.ScanParams;
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
    Object localObject1 = new HashMap();
    boolean bool;
    if (this.this$0.a.e() != 8) {
      bool = true;
    } else {
      bool = false;
    }
    Object localObject2 = this.this$0.d.iterator();
    while (((Iterator)localObject2).hasNext()) {
      FileCategoryUtil.a(bool, ((QfileTabBarView.ScanParams)((Iterator)localObject2).next()).a(), "", ".doc|.docx|.wps|.pages|.ppt|.pptx.|.dps|.keynote|.xls|.xlsx|.et|.numbers|.pdf|.swf|.mov|.mp4|.3gp|.avi|.rmvb|.wmf|.mpg|.rm|.asf|.mpeg|.mkv|.wmv|.flv|.f4v|.webm|.mod|.mpe|.fla|.m4r|.m4u|.m4v|.vob|.mp3|.wav|.m4a|.wave|.midi|.wma|.ogg|.ape|.acc|.aac|.aiff|.mid|.xmf|.rtttl|.flac|.amr|.mp2|.m3u|.m4b|.m4p.mpga|.apk|.jpg|.bmp|.jpeg|.gif|.png|.ico|", (HashMap)localObject1, null);
    }
    FileCategoryUtil.a((Map)localObject1);
    localObject2 = new LinkedHashMap();
    ((LinkedHashMap)localObject2).put(HardCodeUtil.a(2131698237), new ArrayList());
    ((LinkedHashMap)localObject2).put(HardCodeUtil.a(2131698166), new ArrayList());
    ((LinkedHashMap)localObject2).put(HardCodeUtil.a(2131698163), new ArrayList());
    Iterator localIterator = ((HashMap)localObject1).keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      ((List)((LinkedHashMap)localObject2).get(this.this$0.a(str))).addAll((Collection)((HashMap)localObject1).get(str));
    }
    localObject1 = ((LinkedHashMap)localObject2).keySet().iterator();
    while (((Iterator)localObject1).hasNext()) {
      if (((List)((LinkedHashMap)localObject2).get((String)((Iterator)localObject1).next())).size() == 0) {
        ((Iterator)localObject1).remove();
      }
    }
    QfileLocalFileOtherTabView.a(this.this$0, new QfileLocalFileOtherTabView.1.1(this, (LinkedHashMap)localObject2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileOtherTabView.1
 * JD-Core Version:    0.7.0.1
 */