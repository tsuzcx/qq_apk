package com.tencent.mobileqq.startup.step;

class MigrateSubscribeDB$SubscribeRecentData
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  String jdField_a_of_type_JavaLangString;
  long jdField_b_of_type_Long;
  String jdField_b_of_type_JavaLangString;
  long jdField_c_of_type_Long;
  String jdField_c_of_type_JavaLangString;
  String d;
  String e;
  String f;
  
  private MigrateSubscribeDB$SubscribeRecentData(MigrateSubscribeDB paramMigrateSubscribeDB) {}
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mSubscribeID: ");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(" | mSubscribeName: ");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(" | mLastMsg: ");
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append(" | mLastMsgTime: ");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(" | mLastMsgID: ");
    localStringBuilder.append(this.jdField_b_of_type_Long);
    localStringBuilder.append(" | mLastReorderTime: ");
    localStringBuilder.append(this.jdField_c_of_type_Long);
    localStringBuilder.append(" | mDraft: ");
    localStringBuilder.append(this.d);
    localStringBuilder.append(" | mDraftTime: ");
    localStringBuilder.append(this.e);
    localStringBuilder.append(" | mSubscribeHeadUrl: ");
    localStringBuilder.append(this.f);
    localStringBuilder.append(" | mUnreadCount: ");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.MigrateSubscribeDB.SubscribeRecentData
 * JD-Core Version:    0.7.0.1
 */