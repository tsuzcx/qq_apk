package com.tencent.mobileqq.hotpic;

import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.ShortVideoDownResp;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc.RichProtoCallback;
import java.util.List;

class HotVideoData$1
  implements RichProtoProc.RichProtoCallback
{
  HotVideoData$1(HotVideoData paramHotVideoData, HotVideoData.HotVideoGetUrlResult paramHotVideoGetUrlResult, HotVideoData.HotVideoGetUrlCallBack paramHotVideoGetUrlCallBack) {}
  
  public void onBusiProtoResp(RichProto.RichProtoReq paramRichProtoReq, RichProto.RichProtoResp paramRichProtoResp)
  {
    if (paramRichProtoResp != null)
    {
      if (paramRichProtoResp.resps.size() > 0)
      {
        paramRichProtoReq = (RichProto.RichProtoResp.ShortVideoDownResp)paramRichProtoResp.resps.get(0);
        this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoData$HotVideoGetUrlResult.a(paramRichProtoReq);
      }
      else
      {
        paramRichProtoReq = this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoData$HotVideoGetUrlResult;
        paramRichProtoReq.jdField_a_of_type_Boolean = false;
        paramRichProtoReq.jdField_a_of_type_JavaLangString = "Unknown error！";
      }
    }
    else
    {
      paramRichProtoReq = this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoData$HotVideoGetUrlResult;
      paramRichProtoReq.jdField_a_of_type_Boolean = false;
      paramRichProtoReq.jdField_a_of_type_JavaLangString = "Unknown error！";
    }
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoData$HotVideoGetUrlCallBack.a(this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoData$HotVideoGetUrlResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotVideoData.1
 * JD-Core Version:    0.7.0.1
 */