package com.tencent.mobileqq.highway.config;

import com.tencent.mobileqq.highway.utils.EndPoint;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

class IpContainer$PersistentConfig
{
  public ConcurrentHashMap<String, ArrayList<EndPoint>> mIpList;
  public ConcurrentHashMap<String, ArrayList<EndPoint>> mIpv6List;
  public ArrayList<HwNetSegConf> mSegConf;
  public ArrayList<HwNetSegConf> mShortVideoSegConf;
  
  private IpContainer$PersistentConfig(IpContainer paramIpContainer) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.highway.config.IpContainer.PersistentConfig
 * JD-Core Version:    0.7.0.1
 */