package com.tencent.open.appcircle.module;

import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.appcircle.common.jce.ConfigItem;
import com.tencent.open.appcircle.common.jce.ContentConfig;
import com.tencent.open.appcircle.common.jce.GetConfigRequest;
import com.tencent.open.appcircle.common.jce.GetConfigResponse;
import com.tencent.open.appcircle.protocol.BaseRequest;
import com.tencent.open.business.viareport.ReportDbHelper;
import com.tencent.tmassistant.common.ProtocolPackage;
import com.tencent.tmassistant.common.jce.Response;
import com.tencent.tmassistantbase.util.GlobalUtil;
import java.util.ArrayList;
import java.util.Iterator;

public class GetAppCircleConfigEngine
  extends BaseRequest
{
  private static GetAppCircleConfigEngine a;
  
  public GetAppCircleConfigEngine()
  {
    GlobalUtil.getInstance().setContext(CommonDataAdapter.a().a());
  }
  
  public static GetAppCircleConfigEngine a()
  {
    try
    {
      if (a == null) {
        a = new GetAppCircleConfigEngine();
      }
      GetAppCircleConfigEngine localGetAppCircleConfigEngine = a;
      return localGetAppCircleConfigEngine;
    }
    finally {}
  }
  
  public void a()
  {
    GetConfigRequest localGetConfigRequest = new GetConfigRequest();
    localGetConfigRequest.typeList = new ArrayList();
    localGetConfigRequest.typeList.add(Integer.valueOf(3));
    a(localGetConfigRequest);
  }
  
  protected void onFinished(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt)
  {
    paramArrayOfByte1 = ProtocolPackage.unpackPackage(paramArrayOfByte2);
    if ((paramArrayOfByte1 != null) && (paramArrayOfByte1.body != null))
    {
      paramArrayOfByte1 = ProtocolPackage.unpageageJceResponse(paramArrayOfByte1.body, GetConfigResponse.class);
      if ((paramArrayOfByte1 != null) && (paramInt == 0) && ((paramArrayOfByte1 instanceof GetConfigResponse)))
      {
        paramArrayOfByte1 = (GetConfigResponse)paramArrayOfByte1;
        if ((paramArrayOfByte1 != null) && (paramArrayOfByte1.ret == 0) && (paramArrayOfByte1.settingList != null) && (paramArrayOfByte1.settingList.size() > 0))
        {
          paramArrayOfByte1 = paramArrayOfByte1.settingList;
          if (paramArrayOfByte1 != null)
          {
            paramArrayOfByte1 = paramArrayOfByte1.iterator();
            while (paramArrayOfByte1.hasNext())
            {
              paramArrayOfByte2 = (ConfigItem)paramArrayOfByte1.next();
              if (paramArrayOfByte2 != null) {
                switch (paramArrayOfByte2.type)
                {
                default: 
                  break;
                case 3: 
                  if ((paramArrayOfByte2.configuration != null) && ((ContentConfig)ProtocolPackage.bytes2JceObj(paramArrayOfByte2.configuration, ContentConfig.class) != null)) {
                    ReportDbHelper.a().a(paramArrayOfByte2.configuration);
                  }
                  break;
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.open.appcircle.module.GetAppCircleConfigEngine
 * JD-Core Version:    0.7.0.1
 */