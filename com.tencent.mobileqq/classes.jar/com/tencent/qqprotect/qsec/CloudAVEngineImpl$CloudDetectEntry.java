package com.tencent.qqprotect.qsec;

final class CloudAVEngineImpl$CloudDetectEntry
{
  int jdField_a_of_type_Int;
  ICloudAVEngine.DetectBundle jdField_a_of_type_ComTencentQqprotectQsecICloudAVEngine$DetectBundle;
  ICloudAVEngine.IAVEngineEventListener jdField_a_of_type_ComTencentQqprotectQsecICloudAVEngine$IAVEngineEventListener;
  String jdField_a_of_type_JavaLangString = "";
  boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int;
  boolean jdField_b_of_type_Boolean;
  int c;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[EntryId:");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(",UseCache:");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(",rightnow:");
    localStringBuilder.append(this.jdField_b_of_type_Boolean);
    localStringBuilder.append(",Retry:");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(",localKey:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(",content:");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentQqprotectQsecICloudAVEngine$DetectBundle.toString());
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqprotect.qsec.CloudAVEngineImpl.CloudDetectEntry
 * JD-Core Version:    0.7.0.1
 */