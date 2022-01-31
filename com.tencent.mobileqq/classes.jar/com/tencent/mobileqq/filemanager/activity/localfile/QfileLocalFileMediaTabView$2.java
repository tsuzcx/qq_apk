package com.tencent.mobileqq.filemanager.activity.localfile;

import armo;
import arna;
import arqz;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

class QfileLocalFileMediaTabView$2
  implements Runnable
{
  QfileLocalFileMediaTabView$2(QfileLocalFileMediaTabView paramQfileLocalFileMediaTabView) {}
  
  public void run()
  {
    HashMap localHashMap1 = new HashMap();
    if (this.this$0.f) {
      localObject1 = armo.a().a();
    }
    while ((QfileLocalFileMediaTabView.a(this.this$0) & 0x1) > 0)
    {
      localObject2 = this.this$0.d.iterator();
      for (;;)
      {
        if (((Iterator)localObject2).hasNext())
        {
          arna.a(true, ((arqz)((Iterator)localObject2).next()).a(), ".mp3|.wav|.m4a|.wave|.midi|.wma|.ogg|.ape|.acc|.aac|.aiff|.mid|.xmf|.rtttl|.flac|.amr|.mp2|.m3u|.m4b|.m4p.mpga|", ".mpg", localHashMap1, null);
          continue;
          localObject1 = null;
          break;
        }
      }
      if (localObject1 != null) {
        arna.a(true, (String)localObject1, ".mp3|.wav|.m4a|.wave|.midi|.wma|.ogg|.ape|.acc|.aac|.aiff|.mid|.xmf|.rtttl|.flac|.amr|.mp2|.m3u|.m4b|.m4p.mpga|", ".mpg", localHashMap1, null);
      }
      arna.a(localHashMap1);
    }
    Object localObject2 = new ArrayList();
    ((ArrayList)localObject2).addAll(this.this$0.a);
    HashMap localHashMap2 = new HashMap();
    if ((QfileLocalFileMediaTabView.a(this.this$0) & 0x2) > 0)
    {
      localObject3 = this.this$0.d.iterator();
      while (((Iterator)localObject3).hasNext()) {
        arna.a(true, ((arqz)((Iterator)localObject3).next()).a(), ".swf|.mov|.mp4|.3gp|.avi|.rmvb|.wmf|.mpg|.rm|.asf|.mpeg|.mkv|.wmv|.flv|.f4v|.webm|.mod|.mpe|.fla|.m4r|.m4u|.m4v|.vob|", "", localHashMap2, null);
      }
      if (localObject1 != null) {
        arna.a(true, (String)localObject1, ".swf|.mov|.mp4|.3gp|.avi|.rmvb|.wmf|.mpg|.rm|.asf|.mpeg|.mkv|.wmv|.flv|.f4v|.webm|.mod|.mpe|.fla|.m4r|.m4u|.m4v|.vob|", "", localHashMap2, null);
      }
      arna.a(localHashMap2);
    }
    Object localObject1 = localHashMap2.keySet().iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((ArrayList)localObject2).addAll((Collection)localHashMap2.get((String)((Iterator)localObject1).next()));
    }
    localObject1 = localHashMap1.keySet().iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((ArrayList)localObject2).addAll((Collection)localHashMap1.get((String)((Iterator)localObject1).next()));
    }
    Object localObject3 = new LinkedHashMap();
    Iterator localIterator = ((ArrayList)localObject2).iterator();
    FileInfo localFileInfo;
    while (localIterator.hasNext())
    {
      localFileInfo = (FileInfo)localIterator.next();
      if (localFileInfo == null)
      {
        localIterator.remove();
      }
      else
      {
        localObject1 = localFileInfo.a();
        if ((localObject1 != null) && (((String)localObject1).length() != 0))
        {
          if (("camera".equalsIgnoreCase((String)localObject1) != true) && ("Video".equalsIgnoreCase((String)localObject1) != true)) {
            break label485;
          }
          localObject1 = "Camera";
        }
      }
    }
    label485:
    for (;;)
    {
      if (!((LinkedHashMap)localObject3).containsKey(localObject1)) {
        ((LinkedHashMap)localObject3).put(localObject1, new ArrayList());
      }
      if (((List)((LinkedHashMap)localObject3).get(localObject1)).contains(localFileInfo)) {
        break;
      }
      ((List)((LinkedHashMap)localObject3).get(localObject1)).add(localFileInfo);
      break;
      QfileLocalFileMediaTabView.a(this.this$0, new QfileLocalFileMediaTabView.2.1(this, (ArrayList)localObject2, localHashMap2, localHashMap1, (LinkedHashMap)localObject3));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileMediaTabView.2
 * JD-Core Version:    0.7.0.1
 */