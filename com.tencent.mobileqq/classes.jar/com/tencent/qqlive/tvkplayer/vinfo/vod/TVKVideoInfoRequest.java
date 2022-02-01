package com.tencent.qqlive.tvkplayer.vinfo.vod;

import com.tencent.qqlive.tvkplayer.vinfo.apiinner.ITVKCGIVInfoResponse;
import com.tencent.qqlive.tvkplayer.vinfo.apiinner.ITVKCGIVkeyResponse;
import com.tencent.qqlive.tvkplayer.vinfo.apiinner.ITVKVideoInfoRequest;
import com.tencent.qqlive.tvkplayer.vinfo.apiinner.ITVKVideoInfoResponse;

public class TVKVideoInfoRequest
  implements ITVKVideoInfoRequest
{
  private static volatile int REQUEST_ID_BASE = 2000000;
  private ITVKCGIVInfoResponse mCGIVInfoResponse = new TVKVideoInfoRequest.1(this);
  private TVKVideoInfoParams mParams;
  private int mRequestId;
  private ITVKVideoInfoResponse mResponse;
  private ITVKCGIVkeyResponse mVKeyResponse = new TVKVideoInfoRequest.2(this);
  private TVKCGIVideoInfo mVideoInfo;
  private TVKCGIVideoInfoBuilder mVideoInfoBuilder;
  private TVKCGIVInfoRequest mVinfoRequest;
  private TVKCGIVkeyRequest mVkeyRequest;
  
  private void startRequestVKey()
  {
    int i = this.mVideoInfoBuilder.getClipCount();
    int j = this.mVideoInfoBuilder.getVkeyCount();
    if (j + 10 >= i)
    {
      if (this.mVkeyRequest != null)
      {
        this.mVkeyRequest.cancelRequest();
        this.mVkeyRequest = null;
      }
      if (!this.mParams.getUpc().isEmpty()) {
        break label260;
      }
    }
    label260:
    for (TVKCGIVKeyRequestParams localTVKCGIVKeyRequestParams = new TVKCGIVKeyRequestParams.VKeyRequestParasBuilder(this.mParams.getVid()).format(String.valueOf(this.mVideoInfoBuilder.getFormatId())).vt(String.valueOf(this.mVideoInfoBuilder.getVt())).loginCookie(this.mParams.getLoginCookie()).sdtFrom(this.mParams.getSdtFrom()).startClipNo(j + 1).endClipNo(i).requestType(0).requestID(String.valueOf(this.mRequestId)).vkeyType(0).lnk(this.mVideoInfoBuilder.getLinkvid()).ckeyExtraParamsMap(this.mParams.getCkeyExtraParamsMap()).platForm(this.mParams.getPlatForm()).appVer(this.mParams.getAppVer()).networkType(this.mParams.getNetworkType()).loginQQ(this.mParams.getLoginQQ()).encryptVer(this.mParams.getEncryptVer()).guid(this.mParams.getGuid()).build();; localTVKCGIVKeyRequestParams = new TVKCGIVKeyRequestParams.VKeyRequestParasBuilder(this.mParams.getVid()).format(String.valueOf(this.mVideoInfoBuilder.getFormatId())).vt(String.valueOf(this.mVideoInfoBuilder.getVt())).loginCookie(this.mParams.getLoginCookie()).sdtFrom(this.mParams.getSdtFrom()).startClipNo(j + 1).endClipNo(i).requestType(0).requestID(String.valueOf(this.mRequestId)).vkeyType(0).lnk(this.mVideoInfoBuilder.getLinkvid()).ckeyExtraParamsMap(this.mParams.getCkeyExtraParamsMap()).platForm(this.mParams.getPlatForm()).appVer(this.mParams.getAppVer()).networkType(this.mParams.getNetworkType()).loginQQ(this.mParams.getLoginQQ()).encryptVer(this.mParams.getEncryptVer()).guid(this.mParams.getGuid()).upc(this.mParams.getUpc()).upcPaths(this.mVideoInfoBuilder.getPath()).upcSPIPs(this.mVideoInfoBuilder.getSpip()).upcSPPORTs(this.mVideoInfoBuilder.getSpport()).build())
    {
      this.mVkeyRequest = new TVKCGIVkeyRequest(localTVKCGIVKeyRequestParams, this.mVKeyResponse);
      this.mVkeyRequest.executeRequest();
      return;
      i = j + 10;
      break;
    }
  }
  
  public void cancelRequest()
  {
    if (this.mVinfoRequest != null) {
      this.mVinfoRequest.cancelRequest();
    }
    if (this.mVkeyRequest != null) {
      this.mVkeyRequest.cancelRequest();
    }
  }
  
  public int startRequest(TVKVideoInfoParams paramTVKVideoInfoParams, ITVKVideoInfoResponse paramITVKVideoInfoResponse)
  {
    int i = REQUEST_ID_BASE;
    REQUEST_ID_BASE = i + 1;
    this.mRequestId = i;
    this.mParams = paramTVKVideoInfoParams;
    this.mResponse = paramITVKVideoInfoResponse;
    this.mVideoInfoBuilder = new TVKCGIVideoInfoBuilder();
    this.mVideoInfoBuilder.setVideoInfoParams(paramTVKVideoInfoParams);
    this.mVinfoRequest = new TVKCGIVInfoRequest(new TVKCGIVInfoRequestParams.TVKCGIVInfoRequestParasBuilder(this.mParams.getVid()).uin(this.mParams.getUin()).dlType(this.mParams.getDlType()).ipstack(this.mParams.getipstack()).isCharge(this.mParams.isCharge()).drm(this.mParams.getDrm()).ckeyExtraParamsMap(this.mParams.getCkeyExtraParamsMap()).extraParamsMap(this.mParams.getExtraParamsMap()).format(this.mParams.getFormat()).loginCookie(this.mParams.getLoginCookie()).platForm(this.mParams.getPlatForm()).sdtFrom(this.mParams.getSdtFrom()).requestType(this.mParams.getRequestType()).playerCapacity(this.mParams.getPlayerCapacity()).requestID(String.valueOf(this.mRequestId)).upc(this.mParams.getUpc()).appVer(this.mParams.getAppVer()).encryptVer(this.mParams.getEncryptVer()).networkType(this.mParams.getNetworkType()).wxOpenId(this.mParams.getWxOpenId()).guid(this.mParams.getGuid()).build(), this.mCGIVInfoResponse);
    this.mVinfoRequest.executeRequest();
    return this.mRequestId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.vod.TVKVideoInfoRequest
 * JD-Core Version:    0.7.0.1
 */