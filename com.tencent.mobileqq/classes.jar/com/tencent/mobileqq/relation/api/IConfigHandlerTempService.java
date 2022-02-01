package com.tencent.mobileqq.relation.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.api.IRuntimeService;
import protocol.KQQConfig.GetResourceReqInfo;

@Service(process={""})
public abstract interface IConfigHandlerTempService
  extends IRuntimeService
{
  public abstract void doConfigHandlerUpdateConfigs(AppRuntime paramAppRuntime, ArrayList<GetResourceReqInfo> paramArrayList, GetResourceReqInfo... paramVarArgs);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.relation.api.IConfigHandlerTempService
 * JD-Core Version:    0.7.0.1
 */