package com.tencent.raft.generate;

import com.tencent.raft.component.TxchPage;
import com.tencent.raft.raftframework.service.api.IServiceEntry;
import com.tencent.richmediabrowser.core.BrowserDirector;
import com.tencent.richmediabrowser.core.IBrowserBuilder;
import com.tencent.richmediabrowser.core.MainBrowserBuilder;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import java.util.HashMap;
import java.util.Map;

public class RaftServiceEntryMap
{
  public static final Map<String, String> sConstantMap;
  public static final Map<String, IServiceEntry> sDeclareMap;
  public static final Map<Class, IServiceEntry> sServicesMap = new HashMap();
  
  static
  {
    sDeclareMap = new HashMap();
    sConstantMap = new HashMap();
    sServicesMap.put(IBrowserBuilder.class, new com.tencent.richmediabrowser.core.MainBrowserBuilder());
    sServicesMap.put(TxchPage.class, new com.tencent.raft.component.TxchPage());
    sServicesMap.put(RichMediaBrowserInfo.class, new com.tencent.richmediabrowser.model.RichMediaBrowserInfo());
    sServicesMap.put(BrowserDirector.class, new com.tencent.richmediabrowser.core.BrowserDirector());
    sServicesMap.put(MainBrowserBuilder.class, new com.tencent.richmediabrowser.core.MainBrowserBuilder());
    sConstantMap.put("Tuxiaochao-Android/product_id", "60668");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.raft.generate.RaftServiceEntryMap
 * JD-Core Version:    0.7.0.1
 */