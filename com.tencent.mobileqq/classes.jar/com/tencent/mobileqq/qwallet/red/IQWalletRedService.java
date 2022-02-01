package com.tencent.mobileqq.qwallet.red;

import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.List;
import mqq.app.api.IRuntimeService;

@Service(needUin=false, process={""})
public abstract interface IQWalletRedService
  extends IRuntimeService
{
  public static final String ID_RED_PACKET_KSONG = "3001";
  public static final String ID_RED_PACKET_PANEL = "2001";
  public static final String ID_RED_PACKET_SPECIFY = "3002";
  public static final String ID_RED_PACKET_WALLET_FEEDS = "4001";
  
  public abstract void doClick(String paramString);
  
  public abstract void doShowReport(String paramString);
  
  public abstract void doShowReport(List<String> paramList);
  
  public abstract String getNotShowListStr();
  
  public abstract IQWalletRedService.ShowInfo getShowInfo(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.red.IQWalletRedService
 * JD-Core Version:    0.7.0.1
 */