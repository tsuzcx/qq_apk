package com.tencent.tavcut.operator;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/operator/IClipSourceOperator$InvalidStatus;", "", "(Ljava/lang/String;I)V", "ADD_INVALID_INDEX", "REMOVE_INVALID_INDEX", "REPLACE_INVALID_INDEX", "SPLIT_INVALID_INDEX", "ADJUST_SPEED_INVALID_INDEX", "REORDER_INVALID_INDEX", "COPY_INVALID_INDEX", "ADJUST_TIMERANGE_INVALID_INDEX", "DELETE_LIMIT", "SPLIT_LIMIT", "lib_tavcut_release"}, k=1, mv={1, 1, 16})
public enum IClipSourceOperator$InvalidStatus
{
  static
  {
    InvalidStatus localInvalidStatus1 = new InvalidStatus("ADD_INVALID_INDEX", 0);
    ADD_INVALID_INDEX = localInvalidStatus1;
    InvalidStatus localInvalidStatus2 = new InvalidStatus("REMOVE_INVALID_INDEX", 1);
    REMOVE_INVALID_INDEX = localInvalidStatus2;
    InvalidStatus localInvalidStatus3 = new InvalidStatus("REPLACE_INVALID_INDEX", 2);
    REPLACE_INVALID_INDEX = localInvalidStatus3;
    InvalidStatus localInvalidStatus4 = new InvalidStatus("SPLIT_INVALID_INDEX", 3);
    SPLIT_INVALID_INDEX = localInvalidStatus4;
    InvalidStatus localInvalidStatus5 = new InvalidStatus("ADJUST_SPEED_INVALID_INDEX", 4);
    ADJUST_SPEED_INVALID_INDEX = localInvalidStatus5;
    InvalidStatus localInvalidStatus6 = new InvalidStatus("REORDER_INVALID_INDEX", 5);
    REORDER_INVALID_INDEX = localInvalidStatus6;
    InvalidStatus localInvalidStatus7 = new InvalidStatus("COPY_INVALID_INDEX", 6);
    COPY_INVALID_INDEX = localInvalidStatus7;
    InvalidStatus localInvalidStatus8 = new InvalidStatus("ADJUST_TIMERANGE_INVALID_INDEX", 7);
    ADJUST_TIMERANGE_INVALID_INDEX = localInvalidStatus8;
    InvalidStatus localInvalidStatus9 = new InvalidStatus("DELETE_LIMIT", 8);
    DELETE_LIMIT = localInvalidStatus9;
    InvalidStatus localInvalidStatus10 = new InvalidStatus("SPLIT_LIMIT", 9);
    SPLIT_LIMIT = localInvalidStatus10;
    $VALUES = new InvalidStatus[] { localInvalidStatus1, localInvalidStatus2, localInvalidStatus3, localInvalidStatus4, localInvalidStatus5, localInvalidStatus6, localInvalidStatus7, localInvalidStatus8, localInvalidStatus9, localInvalidStatus10 };
  }
  
  private IClipSourceOperator$InvalidStatus() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.operator.IClipSourceOperator.InvalidStatus
 * JD-Core Version:    0.7.0.1
 */