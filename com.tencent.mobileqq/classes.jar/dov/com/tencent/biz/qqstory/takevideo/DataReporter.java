package dov.com.tencent.biz.qqstory.takevideo;

import android.support.annotation.Nullable;

public class DataReporter
{
  private static final DataReporter jdField_a_of_type_DovComTencentBizQqstoryTakevideoDataReporter = new DataReporter();
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  
  public static DataReporter a()
  {
    return jdField_a_of_type_DovComTencentBizQqstoryTakevideoDataReporter;
  }
  
  @Nullable
  public DataReporter.Destination a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return DataReporter.Destination.C2C;
    case 0: 
    case 2: 
    case 1000: 
    case 1001: 
    case 1002: 
    case 1003: 
    case 1004: 
    case 1005: 
    case 1006: 
    case 1008: 
    case 1009: 
    case 1010: 
    case 1011: 
    case 1020: 
    case 1021: 
    case 1022: 
    case 1024: 
    case 1025: 
    case 7400: 
    case 10002: 
    case 10008: 
    case 10009: 
    case 10010: 
      return DataReporter.Destination.C2C;
    case 1: 
      return DataReporter.Destination.GROUP;
    }
    return DataReporter.Destination.DISCUSS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.DataReporter
 * JD-Core Version:    0.7.0.1
 */