package com.tencent.richframework.data.idata;

import java.util.List;

public abstract interface ILoadDataByReq<Q, E, P>
{
  public abstract String getAttachInfoFromRsp(P paramP);
  
  public abstract boolean getIsFinishFromRsp(P paramP);
  
  public abstract List<E> getListDataFromRsp(P paramP);
  
  public abstract Q getRequest(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.richframework.data.idata.ILoadDataByReq
 * JD-Core Version:    0.7.0.1
 */