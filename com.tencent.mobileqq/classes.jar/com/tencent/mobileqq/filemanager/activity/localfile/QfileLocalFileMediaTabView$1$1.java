package com.tencent.mobileqq.filemanager.activity.localfile;

import com.tencent.mobileqq.app.HardCodeUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

class QfileLocalFileMediaTabView$1$1
  implements Runnable
{
  QfileLocalFileMediaTabView$1$1(QfileLocalFileMediaTabView.1 param1, ArrayList paramArrayList, HashMap paramHashMap1, HashMap paramHashMap2, LinkedHashMap paramLinkedHashMap) {}
  
  public void run()
  {
    this.e.this$0.v.clear();
    this.e.this$0.v.addAll(this.a);
    this.e.this$0.l.clear();
    if ((this.e.this$0.n) && ((QfileLocalFileMediaTabView.c(this.e.this$0) & 0x2) > 0)) {
      this.e.this$0.l.put("Camera", new ArrayList());
    }
    Object localObject = this.b.keySet().iterator();
    String str;
    while (((Iterator)localObject).hasNext())
    {
      str = (String)((Iterator)localObject).next();
      if (!this.e.this$0.l.containsKey(HardCodeUtil.a(2131896092))) {
        this.e.this$0.l.put(HardCodeUtil.a(2131896092), new ArrayList());
      }
      ((List)this.e.this$0.l.get(HardCodeUtil.a(2131896092))).addAll((Collection)this.b.get(str));
    }
    localObject = this.c.keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      str = (String)((Iterator)localObject).next();
      if (!this.e.this$0.l.containsKey(HardCodeUtil.a(2131896089))) {
        this.e.this$0.l.put(HardCodeUtil.a(2131896089), new ArrayList());
      }
      ((List)this.e.this$0.l.get(HardCodeUtil.a(2131896089))).addAll((Collection)this.c.get(str));
    }
    localObject = HardCodeUtil.a(2131896092);
    if ((this.d.containsKey(localObject)) && (this.e.this$0.l.containsKey(localObject))) {
      ((List)this.d.get(localObject)).addAll((Collection)this.e.this$0.l.get(localObject));
    }
    this.e.this$0.l.putAll(this.d);
    this.e.this$0.i();
    this.e.this$0.setSelect(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileMediaTabView.1.1
 * JD-Core Version:    0.7.0.1
 */