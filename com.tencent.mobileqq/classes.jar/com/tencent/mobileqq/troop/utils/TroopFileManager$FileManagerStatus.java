package com.tencent.mobileqq.troop.utils;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TroopFileManager$FileManagerStatus
{
  public int a;
  public long a;
  public ByteStringMicro a;
  public List<TroopFileInfo> a;
  public Map<String, TroopFileInfo> a;
  public boolean a;
  public int b;
  public boolean b;
  public int c;
  public int d;
  
  public TroopFileManager$FileManagerStatus(TroopFileManager paramTroopFileManager, long paramLong)
  {
    int i = 0;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_Int = 0;
    this.d = 0;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = ByteStringMicro.copyFromUtf8("");
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    if (paramLong == 0L) {
      this.c = 0;
    } else {
      i = 3;
    }
    this.c = i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileManager.FileManagerStatus
 * JD-Core Version:    0.7.0.1
 */