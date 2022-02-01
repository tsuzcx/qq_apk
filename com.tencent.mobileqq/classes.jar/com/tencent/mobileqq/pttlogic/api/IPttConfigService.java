package com.tencent.mobileqq.pttlogic.api;

import com.tencent.mobileqq.dpc.DPCObserver;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(process={"all"})
public abstract interface IPttConfigService
  extends DPCObserver, IRuntimeService
{
  public static final String TAG_PRE_DOWNLOAD_CFG = "ptt_pre_download";
  public static final String TAG_PTT_OPTIMIZE_CFG = "ptt_optimize_cfg_v2";
  public static final String TAG_STREAM_SLICE_CFG = "ptt_stream_slice_cfg";
  
  public abstract void onGetPreDownloadCfg(String paramString);
  
  public abstract void onGetPttOptimizeCfg(String paramString);
  
  public abstract void onGetStreamSliceCfg(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pttlogic.api.IPttConfigService
 * JD-Core Version:    0.7.0.1
 */