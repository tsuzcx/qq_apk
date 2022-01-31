package com.tencent.tav.core;

import com.tencent.tav.asset.Asset;
import com.tencent.tav.coremedia.CMTimeRange;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class AssetReader
  implements AssetReaderOutput.StatusListener
{
  private Asset asset;
  private IContextCreate contextCreate;
  private String errMsg = "";
  private HashMap<AssetReaderOutput, AssetReader.AVAssetReaderStatus> outputStatusHashMap = new HashMap();
  private List<AssetReaderOutput> outputs = new ArrayList();
  private AssetReader.AVAssetReaderStatus status = AssetReader.AVAssetReaderStatus.AssetReaderStatusUnknown;
  private CMTimeRange timeRange;
  
  public AssetReader(Asset paramAsset)
  {
    this.asset = paramAsset;
  }
  
  private void updateAssetStatus()
  {
    Iterator localIterator = this.outputs.iterator();
    int i = 1;
    AssetReaderOutput localAssetReaderOutput;
    int j;
    if (localIterator.hasNext())
    {
      localAssetReaderOutput = (AssetReaderOutput)localIterator.next();
      if (this.outputStatusHashMap.get(localAssetReaderOutput) == AssetReader.AVAssetReaderStatus.AssetReaderStatusCompleted) {}
      for (j = 1;; j = 0)
      {
        i = j & i;
        break;
      }
    }
    if (i != 0) {
      this.status = AssetReader.AVAssetReaderStatus.AssetReaderStatusCompleted;
    }
    do
    {
      return;
      while (!localIterator.hasNext())
      {
        localIterator = this.outputs.iterator();
        i = 1;
        if (localIterator.hasNext())
        {
          localAssetReaderOutput = (AssetReaderOutput)localIterator.next();
          if ((this.outputStatusHashMap.get(localAssetReaderOutput) == AssetReader.AVAssetReaderStatus.AssetReaderStatusReading) || (this.outputStatusHashMap.get(localAssetReaderOutput) == AssetReader.AVAssetReaderStatus.AssetReaderStatusCompleted)) {}
          for (j = 1;; j = 0)
          {
            i = j & i;
            break;
          }
        }
        if (i != 0)
        {
          this.status = AssetReader.AVAssetReaderStatus.AssetReaderStatusReading;
          return;
        }
        localIterator = this.outputs.iterator();
        while (localIterator.hasNext())
        {
          localAssetReaderOutput = (AssetReaderOutput)localIterator.next();
          if (this.outputStatusHashMap.get(localAssetReaderOutput) == AssetReader.AVAssetReaderStatus.AssetReaderStatusFailed)
          {
            this.status = AssetReader.AVAssetReaderStatus.AssetReaderStatusFailed;
            return;
          }
        }
        localIterator = this.outputs.iterator();
      }
      localAssetReaderOutput = (AssetReaderOutput)localIterator.next();
    } while (this.outputStatusHashMap.get(localAssetReaderOutput) != AssetReader.AVAssetReaderStatus.AssetReaderStatusCancelled);
    this.status = AssetReader.AVAssetReaderStatus.AssetReaderStatusCancelled;
  }
  
  public void addOutput(AssetReaderOutput paramAssetReaderOutput)
  {
    if (canAddOutput(paramAssetReaderOutput)) {
      this.outputs.add(paramAssetReaderOutput);
    }
  }
  
  public boolean canAddOutput(AssetReaderOutput paramAssetReaderOutput)
  {
    return (paramAssetReaderOutput != null) && (!this.outputs.contains(paramAssetReaderOutput));
  }
  
  public void cancelReading()
  {
    Iterator localIterator = this.outputs.iterator();
    while (localIterator.hasNext())
    {
      AssetReaderOutput localAssetReaderOutput = (AssetReaderOutput)localIterator.next();
      this.outputStatusHashMap.put(localAssetReaderOutput, AssetReader.AVAssetReaderStatus.AssetReaderStatusCancelled);
      localAssetReaderOutput.release();
    }
    updateAssetStatus();
  }
  
  public Asset getAsset()
  {
    return this.asset;
  }
  
  public String getErrMsg()
  {
    return this.errMsg;
  }
  
  public List<AssetReaderOutput> getOutputs()
  {
    return this.outputs;
  }
  
  public AssetReader.AVAssetReaderStatus getStatus()
  {
    return this.status;
  }
  
  public CMTimeRange getTimeRange()
  {
    return this.timeRange;
  }
  
  public void setTimeRange(CMTimeRange paramCMTimeRange)
  {
    this.timeRange = paramCMTimeRange;
  }
  
  public boolean startReading(IContextCreate paramIContextCreate)
  {
    this.contextCreate = paramIContextCreate;
    Iterator localIterator = this.outputs.iterator();
    if (localIterator.hasNext())
    {
      AssetReaderOutput localAssetReaderOutput = (AssetReaderOutput)localIterator.next();
      this.outputStatusHashMap.put(localAssetReaderOutput, AssetReader.AVAssetReaderStatus.AssetReaderStatusReading);
      if (localAssetReaderOutput.mediaType == 1) {
        localAssetReaderOutput.start(paramIContextCreate, this);
      }
      for (;;)
      {
        localAssetReaderOutput.addStatusListener(this);
        break;
        localAssetReaderOutput.start(null, this);
      }
    }
    updateAssetStatus();
    return this.outputs.size() > 0;
  }
  
  public void statusChanged(AssetReaderOutput paramAssetReaderOutput, AssetReader.AVAssetReaderStatus paramAVAssetReaderStatus)
  {
    this.outputStatusHashMap.put(paramAssetReaderOutput, paramAVAssetReaderStatus);
    updateAssetStatus();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.tav.core.AssetReader
 * JD-Core Version:    0.7.0.1
 */