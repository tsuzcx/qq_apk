package com.tencent.mobileqq.troop.homework.arithmetic.stream;

import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.homework.arithmetic.pb.MathHWNetWorkPB.ErrorInfo;
import com.tencent.mobileqq.troop.homework.arithmetic.pb.MathHWNetWorkPB.ReqCheckHomework;
import com.tencent.mobileqq.troop.homework.arithmetic.pb.MathHWNetWorkPB.YoutuPicInfo;

public class SendArithHomeResultSegment$Request
  extends NetworkRequest
{
  SendArithHomeResultSegment.ReqInfo jdField_a_of_type_ComTencentMobileqqTroopHomeworkArithmeticStreamSendArithHomeResultSegment$ReqInfo;
  String jdField_a_of_type_JavaLangString;
  
  public SendArithHomeResultSegment$Request(SendArithHomeResultSegment.ReqInfo paramReqInfo, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkArithmeticStreamSendArithHomeResultSegment$ReqInfo = paramReqInfo;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public BaseResponse a(byte[] paramArrayOfByte)
  {
    MathHWNetWorkPB.ErrorInfo localErrorInfo = new MathHWNetWorkPB.ErrorInfo();
    try
    {
      localErrorInfo.mergeFrom(paramArrayOfByte);
      paramArrayOfByte = new BaseResponse(localErrorInfo.error_code.get(), localErrorInfo.error_desc.get().toStringUtf8());
      return paramArrayOfByte;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      SLog.b("QQ.Troop.homework.SendArithHomeResultSegment", "decodeResponse", paramArrayOfByte);
    }
    return new BaseResponse(-99, "decodeResponse error:" + paramArrayOfByte);
  }
  
  public String a()
  {
    return "HwSvc.check_homework";
  }
  
  protected byte[] a()
  {
    MathHWNetWorkPB.ReqCheckHomework localReqCheckHomework = new MathHWNetWorkPB.ReqCheckHomework();
    MathHWNetWorkPB.YoutuPicInfo localYoutuPicInfo = new MathHWNetWorkPB.YoutuPicInfo();
    localYoutuPicInfo.old_url.set(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkArithmeticStreamSendArithHomeResultSegment$ReqInfo.jdField_a_of_type_JavaLangString);
    localYoutuPicInfo.new_url.set(this.jdField_a_of_type_JavaLangString);
    localYoutuPicInfo.new_data.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkArithmeticStreamSendArithHomeResultSegment$ReqInfo.jdField_b_of_type_JavaLangString));
    localReqCheckHomework.group_id.set(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkArithmeticStreamSendArithHomeResultSegment$ReqInfo.jdField_a_of_type_Long);
    localReqCheckHomework.hw_id.set(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkArithmeticStreamSendArithHomeResultSegment$ReqInfo.jdField_b_of_type_Long);
    localReqCheckHomework.uin.set(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkArithmeticStreamSendArithHomeResultSegment$ReqInfo.c);
    localReqCheckHomework.pics.add(localYoutuPicInfo);
    return localReqCheckHomework.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.arithmetic.stream.SendArithHomeResultSegment.Request
 * JD-Core Version:    0.7.0.1
 */