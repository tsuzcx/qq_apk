package com.tencent.mobileqq.onlinestatus.olympic.helper;

import com.tencent.biz.ProtoUtils;
import mqq.app.AppRuntime;
import trpc.qq_status_rank.status_rank_mgr.StatusRankMgr.StatusRankRequest;

public class OlympicProtocolHelper
{
  public static void a(AppRuntime paramAppRuntime, StatusRankMgr.StatusRankRequest paramStatusRankRequest, OlympicProtocolHelper.IGetStatusRankCallback paramIGetStatusRankCallback)
  {
    ProtoUtils.a(paramAppRuntime, new OlympicProtocolHelper.1(paramIGetStatusRankCallback), paramStatusRankRequest.toByteArray(), "trpc.qq_status_rank.status_rank_mgr.StatusRank.GetRank");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.olympic.helper.OlympicProtocolHelper
 * JD-Core Version:    0.7.0.1
 */