package com.tencent.mobileqq.vas;

import java.util.ArrayList;
import java.util.List;

public class VasQuickUpdateManager$SyncVCRRsp
  extends VasQuickUpdateManager.QuickUpdateRsp
{
  public int continue_flag;
  public int polltime;
  public VasQuickUpdateManager.SCPreloadOrReport preload = new VasQuickUpdateManager.SCPreloadOrReport();
  public VasQuickUpdateManager.SCPreloadOrReport report = new VasQuickUpdateManager.SCPreloadOrReport();
  public long seq;
  public int sync_switch;
  public List<VasQuickUpdateManager.VCR> vcr_list = new ArrayList();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.vas.VasQuickUpdateManager.SyncVCRRsp
 * JD-Core Version:    0.7.0.1
 */