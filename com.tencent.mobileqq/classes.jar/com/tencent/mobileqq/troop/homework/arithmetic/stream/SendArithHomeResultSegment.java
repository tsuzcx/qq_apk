package com.tencent.mobileqq.troop.homework.arithmetic.stream;

import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;

public class SendArithHomeResultSegment
  extends JobSegment<String, SendArithHomeResultSegment.RspInfo>
{
  private SendArithHomeResultSegment.ReqInfo jdField_a_of_type_ComTencentMobileqqTroopHomeworkArithmeticStreamSendArithHomeResultSegment$ReqInfo;
  private String jdField_a_of_type_JavaLangString;
  
  public SendArithHomeResultSegment(SendArithHomeResultSegment.ReqInfo paramReqInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkArithmeticStreamSendArithHomeResultSegment$ReqInfo = paramReqInfo;
  }
  
  protected void a(JobContext paramJobContext, String paramString)
  {
    SLog.d("QQ.Troop.homework.SendArithHomeResultSegment", "runSegment " + paramString);
    this.jdField_a_of_type_JavaLangString = paramString;
    CmdTaskManger.a().a(new SendArithHomeResultSegment.Request(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkArithmeticStreamSendArithHomeResultSegment$ReqInfo, this.jdField_a_of_type_JavaLangString), new SendArithHomeResultSegment.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.arithmetic.stream.SendArithHomeResultSegment
 * JD-Core Version:    0.7.0.1
 */