package com.tencent.upload.network.route;

import com.tencent.upload.utils.Const.FileType;
import java.util.ArrayList;
import java.util.List;

class DebugRouteStrategy$1
  extends ServerRouteTable
{
  DebugRouteStrategy$1(DebugRouteStrategy paramDebugRouteStrategy, int paramInt, IRouteIPProvider paramIRouteIPProvider, String paramString1, String paramString2, Const.FileType paramFileType)
  {
    super(paramInt, paramIRouteIPProvider, paramString1, paramString2, paramFileType);
  }
  
  List<UploadRoute> getUploadRoutes()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(DebugRouteStrategy.access$000(this.this$0));
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.upload.network.route.DebugRouteStrategy.1
 * JD-Core Version:    0.7.0.1
 */