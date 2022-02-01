package com.tencent.ttpic.trigger;

import android.text.TextUtils;
import com.tencent.ttpic.openapi.PTDetectInfo;
import com.tencent.ttpic.openapi.model.StickerItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class VoiceToTextTriggerCtrlItem
  extends TriggerCtrlItem
{
  private Map<String, TriggerCtrlItem> triggerCtrlItemMap = new HashMap();
  private Map<String, String> triggerWordsMap = new HashMap();
  
  public void addItem(StickerItem paramStickerItem)
  {
    if (paramStickerItem != null)
    {
      TriggerCtrlItem localTriggerCtrlItem = new TriggerCtrlItem(paramStickerItem);
      this.triggerCtrlItemMap.put(paramStickerItem.id, localTriggerCtrlItem);
      this.triggerWordsMap.put(paramStickerItem.id, paramStickerItem.triggerWords);
    }
  }
  
  public List<String> getRenderVoiceTextIds()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.triggerCtrlItemMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((TriggerCtrlItem)localEntry.getValue()).isTriggered()) {
        localArrayList.add(localEntry.getKey());
      }
    }
    return localArrayList;
  }
  
  public boolean isTriggered()
  {
    Iterator localIterator = this.triggerCtrlItemMap.entrySet().iterator();
    while (localIterator.hasNext()) {
      if (((TriggerCtrlItem)((Map.Entry)localIterator.next()).getValue()).isTriggered()) {
        return true;
      }
    }
    return false;
  }
  
  public void setTriggerWords(String paramString)
  {
    Iterator localIterator = this.triggerCtrlItemMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      String str2 = (String)this.triggerWordsMap.get(localEntry.getKey());
      String str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = paramString;
      }
      ((TriggerCtrlItem)localEntry.getValue()).setTriggerWords(str1);
    }
  }
  
  public void updateTriggerStatus(PTDetectInfo paramPTDetectInfo)
  {
    Iterator localIterator = this.triggerCtrlItemMap.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((TriggerCtrlItem)((Map.Entry)localIterator.next()).getValue()).updateTriggerStatus(paramPTDetectInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.trigger.VoiceToTextTriggerCtrlItem
 * JD-Core Version:    0.7.0.1
 */