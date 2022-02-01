package com.tencent.mobileqq.fts.api;

import com.tencent.mobileqq.fts.query.QueryArgs;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.List;
import mqq.app.api.IRuntimeService;

@Service(process={""})
public abstract interface IFTSQuery
  extends IRuntimeService
{
  public abstract <T> List<T> query(QueryArgs paramQueryArgs);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fts.api.IFTSQuery
 * JD-Core Version:    0.7.0.1
 */