package com.tencent.mobileqq.vas;

import java.util.ArrayList;
import java.util.List;

public class VasQuickUpdateManager$SyncVCRRsp
  extends VasQuickUpdateManager.QuickUpdateRsp
{
  public int continueFlag;
  public int environment;
  public int polltime;
  public VasQuickUpdateManager.SCPreloadOrReport preload = new VasQuickUpdateManager.SCPreloadOrReport();
  public VasQuickUpdateManager.SCPreloadOrReport report = new VasQuickUpdateManager.SCPreloadOrReport();
  public long seq;
  public int syncSwitch;
  public List<VasQuickUpdateManager.VCR> vcrList = new ArrayList();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.VasQuickUpdateManager.SyncVCRRsp
 * JD-Core Version:    0.7.0.1
 */