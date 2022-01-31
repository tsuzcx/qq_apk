package com.tencent.mobileqq.highway.netprobe;

import java.util.ArrayList;
import java.util.Collections;

public class ProbeChain
  extends ProbeItem
{
  public static final String PROBE_NAME = "ProbeChain";
  public ArrayList<ProbeItem> chain = new ArrayList();
  
  public ProbeChain() {}
  
  public ProbeChain(int paramInt)
  {
    this.priority = paramInt;
  }
  
  public ProbeChain(ProbeItem[] paramArrayOfProbeItem)
  {
    addProbeItems(paramArrayOfProbeItem);
  }
  
  public static ProbeChain getDefaultProbeChain()
  {
    ProbeChain localProbeChain = new ProbeChain();
    localProbeChain.addProbeItem(new LoginWifiProbe());
    localProbeChain.addProbeItem(new MtuProbe());
    localProbeChain.addProbeItem(new DefaultProbe());
    return localProbeChain;
  }
  
  public ProbeChain addProbeItem(ProbeItem paramProbeItem)
  {
    if (paramProbeItem != null) {
      this.chain.add(paramProbeItem);
    }
    return this;
  }
  
  public ProbeChain addProbeItems(ProbeItem[] paramArrayOfProbeItem)
  {
    if ((paramArrayOfProbeItem != null) && (paramArrayOfProbeItem.length > 0))
    {
      int i = 0;
      int j = paramArrayOfProbeItem.length;
      while (i < j)
      {
        this.chain.add(paramArrayOfProbeItem[i]);
        i += 1;
      }
    }
    return this;
  }
  
  public void doProbe()
  {
    if (this.chain.isEmpty())
    {
      this.mResult.success = false;
      this.mResult.errDesc = "at lease one probe item need!";
      return;
    }
    if (this.chain.size() > 1) {
      initProbeSequence();
    }
    ProbeItem localProbeItem = (ProbeItem)this.chain.get(0);
    if (localProbeItem != null) {
      localProbeItem.probe(this.mRequest, this.cb);
    }
    onSubItemsFinish();
  }
  
  public String getProbeName()
  {
    return "ProbeChain";
  }
  
  public ProbeItem.ProbeResult getProbeResult(ProbeRequest paramProbeRequest, ProbeCallback paramProbeCallback)
  {
    return new ProbeChain.ProbeChainResult(getProbeName(), paramProbeCallback);
  }
  
  public void initProbeSequence()
  {
    Collections.sort(this.chain);
    int j = this.chain.size();
    int i = 1;
    while (i < j)
    {
      ((ProbeItem)this.chain.get(i - 1)).setSuccessor((ProbeItem)this.chain.get(i));
      i += 1;
    }
  }
  
  public void onSubItemsFinish()
  {
    ProbeChain.ProbeChainResult localProbeChainResult = (ProbeChain.ProbeChainResult)this.mResult;
    this.mResult.success = true;
    int j = this.chain.size();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        ProbeItem localProbeItem = (ProbeItem)this.chain.get(i);
        localProbeChainResult.subResults.add(localProbeItem.mResult);
        if (!localProbeItem.mResult.success)
        {
          this.mResult.success = false;
          this.mResult.errDesc = (localProbeItem.getProbeName() + ":" + localProbeItem.mResult.errDesc);
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.netprobe.ProbeChain
 * JD-Core Version:    0.7.0.1
 */